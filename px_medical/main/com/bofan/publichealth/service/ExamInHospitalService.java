package com.bofan.publichealth.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.ExamInHospitalQueryInfo;
import com.bofan.publichealth.valueobject.ExamInHospital;

/**
 * @Description 保存居民体检--住院情况业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class ExamInHospitalService extends AbstractAnnoCommonService {
    
    /**
     * 获取居民体检--住院情况信息
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<ExamInHospital> selectInHospital(Long examPersonId, Long personDetailId) {
        ExamInHospitalQueryInfo queryInfo = new ExamInHospitalQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(ExamInHospital.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存居民体检--住院情况
     * @param json
     */
    public void saveInHospitalByJson(String json, Long personDetailId, Long examPersonId, Date examTime) {
        List<ExamInHospital> dataList = JSONArray.parseArray(json, ExamInHospital.class);
        for (ExamInHospital inHospital : dataList) {
            inHospital.setPersonDetailId(personDetailId);
            inHospital.setExamPersonId(examPersonId);
            inHospital.setExamTime(examTime);
            super.save(inHospital);
        }
    }
    
    /**
     * 保存居民体检--住院情况(多个)
     * @param json
     */
    public void deleteInHospital(Long personDetailId, Long examPersonId) {
        List<ExamInHospital> inHospitalList = this.selectInHospital(examPersonId, personDetailId);
        if (null != inHospitalList) {
            super.deleteAll(inHospitalList);
        }
    }
    
    /**
     * 根据主键删除居民体检--住院情况(单个)
     * @param personDrugId
     */
    public void deleteInHospital(Long inHospitalId) {
        ExamInHospital inHospital = super.selectAObject(ExamInHospital.class, inHospitalId);
        if (null != inHospital) {
            super.delete(inHospital);
        }
    }
}
