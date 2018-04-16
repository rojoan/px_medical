package com.bofan.publichealth.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.ExamPersonEditInfo;
import com.bofan.publichealth.command.ExamPersonQueryInfo;
import com.bofan.publichealth.valueobject.ExamPerson;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 居民健康体检业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class ExamPersonService extends AbstractAnnoCommonService {
    @Autowired
    private ExamLiveWayService examLiveWayService;
    @Autowired
    private ExamSymptomService examSymptomService;
    @Autowired
    private ExamOrganBodyService examOrganBodyService;
    @Autowired
    private ExamInHospitalService examInHospitalService;
    @Autowired
    private ExamPersonalDrugService examPersonalDrugService;
    @Autowired
    private ExamPersonalNovacService examPersonalNovacService;
    @Autowired
    private ExamHealthProblemService examHealthProblemService;
    
    /**
     * 居民健康体检信息分页列表
     * @param queryInfo
     * @return
     */
    public Page selectExamPersonList(ExamPersonQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new ExamPersonQueryInfo();
        }
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 保存居民健康体检信息
     * @param info
     */
    public void saveExamPerson(ExamPersonEditInfo info) {
        // 保存主表信息 
        ExamPerson examPerson = null;
        if(null != info.getExamPersonId()) {
            examPerson =this.selectAObject(ExamPerson.class, info.getExamPersonId());
        } else {
            examPerson = new ExamPerson();
            examPerson.setValidFlag(Contstants.YES_FLAG);
            examPerson.setCreateTime(new Date());
            examPerson.setCreatorId(info.getCurrentUser().getUserInfoId());
            examPerson.setCreatorName(info.getCurrentUser().getName());
        }
        NullBeanUtils.copyProperties(examPerson, info);
        examPerson.setValidFlag(Contstants.YES_FLAG);
        super.saveAndRefresh(examPerson);
        info.setExamPersonId(examPerson.getExamPersonId());
        
        //保存其他子表信息
        this.examLiveWayService.saveExamLiveWay(info);
        this.examOrganBodyService.saveExamOrganBody(info);
        this.examHealthProblemService.saveExamHealthProblemInfo(info);
        this.examSymptomService.saveExamSymptom(info.getSymptomIds(), info.getPersonDetailId(), info.getExamPersonId());
        this.examInHospitalService.saveInHospitalByJson(info.getTreatJson(), info.getPersonDetailId(), info.getExamPersonId(), info.getExamTime());
        this.examPersonalDrugService.savePersonalDrugByJson(info.getDosageJson(), info.getPersonDetailId(), info.getExamPersonId(), info.getExamTime());
        this.examPersonalNovacService.savePersonalNovacByJson(info.getPreventJson(), info.getPersonDetailId(), info.getExamPersonId(), info.getExamTime()); 
    }
    
    /**
     * 删除居民健康体检
     * @param Long[] ids
     * @return
     */
    public void deleteExamPerson(Long[] ids) {
        ExamPerson examPerson = null;
        for (Long id : ids) {
            if (null == id) {
                continue ;
            }
            
            examPerson = this.selectAObject(ExamPerson.class, id);
            if (null != examPerson) {
                // 更新标志为无效（即删除）
                // 不用从数据删除数据，所以只要标识主表对像（ExamPerson）为无效即可，子表不用做任何处理
                examPerson.setValidFlag(Contstants.NO_FLAG);
                super.save(examPerson);
                /**
                * 
                // 删除其他子表信息
                this.examLiveWayService.deleteExamLiveWay(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
                this.examOrganBodyService.deleteExamOrganBody(examPerson.getExamPersonId());
                this.examHealthProblemService.deleteExamHealthProblemInfo(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
                this.examSymptomService.deleteExamSymptom(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
                this.examInHospitalService.deleteInHospital(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
                this.examPersonalDrugService.deletePersonalDrug(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
                this.examPersonalNovacService.deletePersonNovac(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
                */
            }
        }
    }
    

}
