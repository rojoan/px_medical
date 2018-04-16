package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonInsanityGuidedrugQueryInfo;
import com.bofan.publichealth.valueobject.PersonInsanityGuidedrug;
import com.bofan.publichealth.valueobject.PersonInsanityVisit;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 重性精神病--用药指导业务类
 * @author xlf
 * 2017-10-26
 */
@Service
public class PersonInsanityGuidedrugService extends AbstractAnnoCommonService {
    
    
   /**
    * 获取重性精神病--用药指导业
    * @param personInsanityVisitId
    * @param personDetailId
    * @return
    */
    @Transactional
    public List<PersonInsanityGuidedrug> selectPersonInsanityGuidedrug(Long personInsanityVisitId, Long personDetailId) {
        PersonInsanityGuidedrugQueryInfo queryInfo = new PersonInsanityGuidedrugQueryInfo();
        queryInfo.setPersonDetailId(personDetailId);
        //queryInfo.setPersonInsanityId(personInsanityId);
        queryInfo.setPersonInsanityVisitId(personInsanityVisitId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonInsanityGuidedrug.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存重性精神病--用药指导业
     * @param insanityGuidedrugJson
     * @param insanityVisit
     * @param recordFlag
     */
    public void savePersonInsanityGuidedrugByJson(String insanityGuidedrugJson, PersonInsanityVisit insanityVisit, String recordFlag) {
        List<PersonInsanityGuidedrug> guidedrugList = JSONArray.parseArray(insanityGuidedrugJson, PersonInsanityGuidedrug.class);
        if (null != guidedrugList && guidedrugList.size() > 0) {
            for (PersonInsanityGuidedrug guidedrug : guidedrugList) {
                if (null == guidedrug.getDiseaseDrugId()) {
                    continue;
                }
                
                guidedrug.setRecordFlag(recordFlag);
                guidedrug.setHospitalId(insanityVisit.getHospitalId());
                guidedrug.setCreatorId(insanityVisit.getVisitDoctorId());
                guidedrug.setPersonDetailId(insanityVisit.getPersonDetailId());
                guidedrug.setPersonInsanityId(insanityVisit.getPersonInsanityId());
                guidedrug.setPersonInsanityVisitId(insanityVisit.getPersonInsanityVisitId());
                if (null != guidedrug.getPersonInsanityGuidedrugId()) {
                    PersonInsanityGuidedrug curGuidedrug = super.selectAObject(PersonInsanityGuidedrug.class, guidedrug.getPersonInsanityGuidedrugId());
                    NullBeanUtils.copyProperties(curGuidedrug, guidedrug);
                    super.save(curGuidedrug);
                } else {
                    super.save(guidedrug);
                }
            }
        }
    }

    /**
     * 根据主键删除重性精神病--用药指导业
     * @param chronicDrugId
     */
    @Transactional
    public void deletePersonInsanityGuidedrug(Long personInsanityGuidedrugId) {
        PersonInsanityGuidedrug guidedrug = super.selectAObject(PersonInsanityGuidedrug.class, personInsanityGuidedrugId);
        if (null != guidedrug) {
            super.delete(guidedrug);
        }
    }
}
