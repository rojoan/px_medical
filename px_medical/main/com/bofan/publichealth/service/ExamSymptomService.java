package com.bofan.publichealth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.ExamSymptomIdQueryInfo;
import com.bofan.publichealth.command.ExamSymptomQueryInfo;
import com.bofan.publichealth.valueobject.ExamSymptom;
import com.bofan.utils.Tools;

/**
 * @Description 居民体检--症状对照业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
@Transactional
public class ExamSymptomService extends AbstractAnnoCommonService {

    /**
     * 获取体检--症状对应的症状ID
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<Long> selectExamSymptomId(Long examPersonId, Long personDetailId) {
        ExamSymptomIdQueryInfo queryInfo = new ExamSymptomIdQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(Long.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 获取体检--症状对应的症状ID
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<ExamSymptom> selectExamSymptom(Long examPersonId, Long personDetailId) {
        ExamSymptomQueryInfo queryInfo = new ExamSymptomQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(ExamSymptom.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存居民体检--症状对照信息
     * @param symptomIds
     * @param personDetailId
     * @param examPersonId
     */
    public void saveExamSymptom(Long[] symptomIds, Long personDetailId, Long examPersonId) {
        // 去除之前以保存过的数据
        List<ExamSymptom> symptomList = this.selectExamSymptom(examPersonId, personDetailId);
        if (null == symptomIds || symptomIds.length <= 0) {
            // 当页面传回的症状ids（symptomIds）为空， 表示页面没有勾选，因此要删除之前保存过得 数据据
            super.deleteAll(symptomList);
            return ;
        }
        
        List<Long> symptomIdList = new ArrayList<Long>(java.util.Arrays.asList(symptomIds));
        for (ExamSymptom symptom : symptomList) {
            if (symptomIdList.contains(symptom.getSymptomId())) {
                symptomIdList.remove(symptom.getSymptomId());
            } else {
                super.delete(symptom);
            }
        }
        
        ExamSymptom symptom = null;
        for (Long itemId : symptomIdList) {
            if (null == itemId || itemId.intValue() <= 0) {
                continue ;
            }
            symptom = new ExamSymptom();
            symptom.setSymptomId(itemId);
            symptom.setExamPersonId(examPersonId);
            symptom.setPersonDetailId(personDetailId);
            super.save(symptom);
        }
    }
    
    /**
     * 删除居民体检--症状对照信息
     * @param symptomIds
     * @param personDetailId
     * @param examPersonId
     */
    public void deleteExamSymptom(Long personDetailId, Long examPersonId) {
        List<ExamSymptom> symptomList = this.selectExamSymptom(examPersonId, personDetailId);
        if (Tools.isNotEmptyList(symptomList)) {
            super.deleteAll(symptomList);
        }
        
    }
}