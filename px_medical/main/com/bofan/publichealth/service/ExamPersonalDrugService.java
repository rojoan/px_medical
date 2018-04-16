package com.bofan.publichealth.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.ExamPersonalDrugQueryInfo;
import com.bofan.publichealth.valueobject.ExamPersonalDrug;

/**
 * @Description 保存居民体检--个人用药情况业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class ExamPersonalDrugService extends AbstractAnnoCommonService {
    
    
    /**
     * 获取居民体检健康问题--个人用药信息
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<ExamPersonalDrug> selectPersonalDrug(Long examPersonId, Long personDetailId) {
        ExamPersonalDrugQueryInfo queryInfo = new ExamPersonalDrugQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(ExamPersonalDrug.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存居民体检--个人用药情况
     * @param json
     */
    public void savePersonalDrugByJson(String json, Long personDetailId, Long examPersonId, Date examTime) {
        List<ExamPersonalDrug> dataList = JSONArray.parseArray(json, ExamPersonalDrug.class);
        for (ExamPersonalDrug personalDrug : dataList) {
            if (null == personalDrug.getDiseaseDrugId()) {
                continue ;
            }
            personalDrug.setPersonDetailId(personDetailId);
            personalDrug.setExamPersonId(examPersonId);
            personalDrug.setExamTime(examTime);
            super.save(personalDrug);
        }
    }
    
    /**
     * 删除居民体检--个人用药情况(多个)
     * @param json
     */
    public void deletePersonalDrug(Long personDetailId, Long examPersonId) {
        List<ExamPersonalDrug> personalDrugList = this.selectPersonalDrug(examPersonId, personDetailId);
        if (null != personalDrugList) {
            super.deleteAll(personalDrugList);
        }
    }
    
    /**
     * 根据主键删除个人用药情况
     * @param personDrugId
     */
    public void deletePersonalDrug(Long personDrugId) {
        ExamPersonalDrug personalDrug = super.selectAObject(ExamPersonalDrug.class, personDrugId);
        if (null != personalDrug) {
            super.delete(personalDrug);
        }
    }
}
