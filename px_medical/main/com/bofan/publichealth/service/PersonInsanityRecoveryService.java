package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonInsanityRecoveryQueryInfo;
import com.bofan.publichealth.command.PersonInsanityRecoveryTypeQueryInfo;
import com.bofan.publichealth.valueobject.PersonInsanityRecovery;
import com.bofan.publichealth.valueobject.PersonInsanityVisit;

/**
 * @Description 重性精神病--康复措施业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class PersonInsanityRecoveryService extends AbstractAnnoCommonService {

    /**
     * 获取重性精神病--康复措施类型
     * @param personInsanityVisitId
     * @param personDetailId
     * @return
     */
    @Transactional
    public List<String> selectPersonInsanityRecoveryType(Long personInsanityVisitId, Long personDetailId) {
        PersonInsanityRecoveryTypeQueryInfo queryInfo = new PersonInsanityRecoveryTypeQueryInfo();
        queryInfo.setPersonDetailId(personDetailId);
        //queryInfo.setPersonInsanityId(personInsanityId);
        queryInfo.setPersonInsanityVisitId(personInsanityVisitId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(String.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 获取重性精神病--康复措施
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<PersonInsanityRecovery> selectPersonInsanityRecovery(Long personInsanityId, Long personInsanityVisitId, Long personDetailId) {
        PersonInsanityRecoveryQueryInfo queryInfo = new PersonInsanityRecoveryQueryInfo();
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setPersonInsanityId(personInsanityId);
        queryInfo.setPersonInsanityVisitId(personInsanityVisitId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonInsanityRecovery.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存重性精神病--康复措施
     * @param recoveryTypes
     * @param insanityVisit
     * @param recordFlag
     */
    public void savePersonInsanityRecovery(String[] recoveryTypes, PersonInsanityVisit insanityVisit, String recordFlag) {
        
        List<PersonInsanityRecovery> insanitySymList = this.selectPersonInsanityRecovery(
                insanityVisit.getPersonInsanityId(), insanityVisit.getPersonInsanityVisitId(),
                insanityVisit.getPersonDetailId());
        if (null == recoveryTypes || recoveryTypes.length <= 0) {
            if (null != insanitySymList && insanitySymList.size() > 0) {
                super.deleteAll(insanitySymList);
            }
            return;
        }
        
        int index = 0;
        PersonInsanityRecovery insanityRecovery = null;
        int maxIndex = (null == insanitySymList ? 0 : insanitySymList.size());
        for (String type : recoveryTypes) {
            if (!StringUtils.hasText(type)) {
                continue ;
            }
            
            if (maxIndex > index) {
                insanityRecovery = insanitySymList.get(index);
                insanitySymList.remove(index);
                maxIndex = insanitySymList.size();
            } else {
                insanityRecovery = new PersonInsanityRecovery();
            }
            
            insanityRecovery.setRecoveryType(type);
            insanityRecovery.setRecordFlag(recordFlag);
            insanityRecovery.setCreatorId(insanityVisit.getVisitDoctorId());
            insanityRecovery.setHospitalId(insanityVisit.getHospitalId());
            insanityRecovery.setPersonDetailId(insanityVisit.getPersonDetailId());
            insanityRecovery.setPersonInsanityId(insanityVisit.getPersonInsanityId());
            insanityRecovery.setPersonInsanityVisitId(insanityVisit.getPersonInsanityVisitId());

            index++;
            super.save(insanityRecovery);
        }
        
        // 删除多余选项
        for (PersonInsanityRecovery recovery : insanitySymList) {
            super.delete(recovery);
        } 
    }
}