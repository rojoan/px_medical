package com.bofan.publichealth.service;

import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.publichealth.command.ExamChildDayNumCalcInfo;
import com.bofan.publichealth.command.ExamChildEditInfo;
import com.bofan.publichealth.command.ExamChildQueryInfo;
import com.bofan.publichealth.valueobject.ExamChild;
import com.bofan.utils.Contstants;
import com.bofan.utils.DateHelper;
import com.bofan.utils.NullBeanUtils;
import com.mongo.command.HiDataBaseQueryInfo;
import com.mongo.hchart.DataCycleType;
import com.mongo.hchart.HiDataCommon;
import com.mongo.service.BaseMongoService;
/**
 * @Description 儿童体检(检查)业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class ExamChildService extends AbstractAnnoCommonService {
    @Autowired
    private BaseMongoService mongoService;
    /**
     * 儿童体检(检查)分页列表
     * @param queryInfo
     * @return
     */
    public Page selectExamChildList(ExamChildQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new ExamChildQueryInfo();
        }
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 保存儿童体检(检查)信息
     * @param info
     */
    public void saveExamChild(ExamChildEditInfo info) {
        // 保存主表信息 
        ExamChild examChild = null;
        if(null != info.getExamChildId()) {
            // 修改
            examChild = super.selectAObject(ExamChild.class, info.getExamChildId());
        } else {
            // 新增
            examChild = new ExamChild();
            examChild.setDutyDoctor(info.getCurrentUser().getName());
            examChild.setDutyDoctorId(info.getCurrentUser().getUserInfoId());
            
            // 当前用户单位
            SysOrg unitOrg = super.selectAObject(SysOrg.class, info.getCurrentUser().getSysOrg().getUnitOrgId());
            examChild.setHospitalNo(unitOrg.getOrgNo());
            examChild.setHospitalName(unitOrg.getName());
            examChild.setHospitalId(unitOrg.getOrgId());
        }
        NullBeanUtils.copyProperties(examChild, info);
        super.saveAndRefresh(examChild);
        info.setExamChildId(examChild.getExamChildId());
    }
    
    /**
     * 删除儿童体检(检查)
     * @param ids
     * @return
     */
    public void deleteExamChild(Long[] ids) {
        ExamChild examChild = null;
        for (Long id : ids) {
            if (null == id) {
                continue;
            }
            
            examChild = super.selectAObject(ExamChild.class, id);
            if (null != examChild) {
                examChild.setValidFlag(Contstants.NO_FLAG);
                super.save(examChild);
                
            }
        }
    }

    public List<Map<String, Object>> calcExamChildDateCount(ExamChildDayNumCalcInfo calcInfo) {
        IQueryObject qo = super.getQueryObject(calcInfo);

        String dataCycle = DateHelper.formatDateYearMonth(calcInfo.getBeginExamTime());
        // ��ѯMongo�������޾ɼ�¼
        Criteria criatira = new Criteria();
        criatira.andOperator(Criteria.where("dataName").is("ExamChildMonthDateCout"),
                Criteria.where("dataCycle").is(dataCycle));
        HiDataCommon hiData = this.mongoService.selectOne(HiDataCommon.class, query(criatira));
        if (hiData == null) {
            hiData = new HiDataCommon();
            // dataName��������:ֵ������(ExamChild)+����+ά��+��ʵָ��(Cout:��¼��,XXSum:������)
            hiData.setDataName("ExamChildMonthDateCout");
            hiData.setCycleType(DataCycleType.MONTH.getCycleType());
            hiData.setDataCycle(dataCycle);
        }
        // ͳ�ƽ������һ����
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> examChildDayNumList = (List<Map<String, Object>>) super.executeSql(
                qo.getQueryString(), qo.getParam());
        hiData.addSeriesData("��ͯ���ÿ������", examChildDayNumList);

        /*
         * HiDataCommon hiDataCommon = this.mongoService.selectOne(HiDataCommon.class,
         * query(Criteria.where("dataName").is("ExamChildMonthDateCout")));
         */

        this.mongoService.save(hiData);
        return examChildDayNumList;
    }

    public HiDataCommon selectExamChildDateCount(HiDataBaseQueryInfo hiDataQueryInfo) {
        Criteria criatira = new Criteria();
        criatira.andOperator(Criteria.where("dataName").is(hiDataQueryInfo.getDataName()),
                Criteria.where("dataCycle").is(hiDataQueryInfo.getDataCycle()));

        HiDataCommon hiData = this.mongoService.selectOne(HiDataCommon.class, query(criatira));
        return hiData;
    }

}
