package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonInsanitySymIdQueryInfo;
import com.bofan.publichealth.command.PersonInsanitySymQueryInfo;
import com.bofan.publichealth.valueobject.PersonInsanitySym;

/**
 * @Description 重性精神病--症状业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class PersonInsanitySymService extends AbstractAnnoCommonService {

    /**
     * 获取重性精神病--症状ID
     * @param personInsanityId
     * @param personInsanityVisitId
     * @param recordFlag
     * @return
     */
    @Transactional
    public List<Long> selectPersonInsanitySymId(Long personInsanityId, Long personInsanityVisitId, String recordFlag) {
        PersonInsanitySymIdQueryInfo queryInfo = new PersonInsanitySymIdQueryInfo();
        queryInfo.setRecordFlag(recordFlag);
        queryInfo.setPersonInsanityId(personInsanityId);
        queryInfo.setPersonInsanityVisitId(personInsanityVisitId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(Long.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 获取重性精神病--症状
     * @param personInsanityId
     * @param personInsanityVisitId
     * @param recordFlag
     * @return
     */
    public List<PersonInsanitySym> selectPersonInsanitySym(Long personInsanityId, Long personInsanityVisitId, String recordFlag) {
        PersonInsanitySymQueryInfo queryInfo = new PersonInsanitySymQueryInfo();
        queryInfo.setRecordFlag(recordFlag);
        queryInfo.setPersonInsanityId(personInsanityId);
        queryInfo.setPersonInsanityVisitId(personInsanityVisitId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonInsanitySym.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存重性精神病--症状
     * @param visitChronicSymIds
     * @param personInsanityId
     * @param personInsanityVisitId
     * @param personDetailId
     * @param hospitalId
     * @param creatorId
     * @param recordFlag
     */
    public void savePersonInsanitySym(Long[] visitChronicSymIds, Long personInsanityId, Long personInsanityVisitId,
            Long personDetailId, Long hospitalId, Long creatorId, String recordFlag) {
        
        List<PersonInsanitySym> insanitySymList = this.selectPersonInsanitySym(personInsanityId, personInsanityVisitId, recordFlag);
        if (null == visitChronicSymIds || visitChronicSymIds.length <= 0) {
            if (null != insanitySymList && insanitySymList.size() > 0) {
                super.deleteAll(insanitySymList);
            }
            return;
        }
        
        int index = 0;
        PersonInsanitySym insanitySym = null;
        int maxIndex = (null == insanitySymList ? 0 : insanitySymList.size());
        for (Long symptomId : visitChronicSymIds) {
            if (null == symptomId) {
                continue ;
            }
            
            if (maxIndex > index) {
                insanitySym = insanitySymList.get(index);
                insanitySymList.remove(index);
                maxIndex = insanitySymList.size();
            } else {
                insanitySym = new PersonInsanitySym();
            }
            
            insanitySym.setRecordFlag(recordFlag);
            insanitySym.setCreatorId(creatorId);
            insanitySym.setSymptomId(symptomId);
            insanitySym.setHospitalId(hospitalId);
            insanitySym.setPersonDetailId(personDetailId);
            insanitySym.setPersonInsanityId(personInsanityId);
            insanitySym.setPersonInsanityVisitId(personInsanityVisitId);

            index++;
            super.save(insanitySym);
        }
        
        // 删除多余选项
        for (PersonInsanitySym sym : insanitySymList) {
            super.delete(sym);
        } 
    }
}