package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonInsanityUsedrugQueryInfo;
import com.bofan.publichealth.valueobject.PersonInsanityUsedrug;
import com.bofan.publichealth.valueobject.PersonInsanityVisit;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 重性精神病--用药情况
 * @author xlf
 * 2017-10-26
 */
@Service
public class PersonInsanityUsedrugService extends AbstractAnnoCommonService {
    
    
    /**
     * 获取重性精神病--用药情况
     * @param personInsanityVisitId
     * @param personDetailId
     * @return
     */
    @Transactional
    public List<PersonInsanityUsedrug> selectPersonInsanityUsedrug(Long personInsanityVisitId, Long personDetailId) {
        PersonInsanityUsedrugQueryInfo queryInfo = new PersonInsanityUsedrugQueryInfo();
        queryInfo.setPersonDetailId(personDetailId);
        //queryInfo.setPersonInsanityId(personInsanityId);
        queryInfo.setPersonInsanityVisitId(personInsanityVisitId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonInsanityUsedrug.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存重性精神病--用药情况
     * @param insanityUsedrug
     * @param insanityVisit
     * @param recordFlag
     */
    public void savePersonInsanityUsedrugByJson(String insanityUsedrug, PersonInsanityVisit insanityVisit, String recordFlag) {
        List<PersonInsanityUsedrug> usedrugList = JSONArray.parseArray(insanityUsedrug, PersonInsanityUsedrug.class);
        if (null != usedrugList && usedrugList.size() > 0) {
            for (PersonInsanityUsedrug useDrug : usedrugList) {
                if (null == useDrug.getDiseaseDrugId()) {
                    continue;
                }
                
                useDrug.setRecordFlag(recordFlag);
                useDrug.setHospitalId(insanityVisit.getHospitalId());
                useDrug.setCreatorId(insanityVisit.getVisitDoctorId());
                useDrug.setPersonDetailId(insanityVisit.getPersonDetailId());
                useDrug.setPersonInsanityId(insanityVisit.getPersonInsanityId());
                useDrug.setPersonInsanityVisitId(insanityVisit.getPersonInsanityVisitId());
                if (null != useDrug.getPersonInsanityUsedrugId()) {
                    PersonInsanityUsedrug curUsedrug = super.selectAObject(PersonInsanityUsedrug.class, useDrug.getPersonInsanityUsedrugId());
                    NullBeanUtils.copyProperties(curUsedrug, useDrug);
                    super.save(curUsedrug);
                } else {
                    super.save(useDrug);
                }
            }
        }
    }

    /**
     * 根据主键删除重性精神病--用药情况
     * @param chronicDrugId
     */
    @Transactional
    public void deletePersonInsanityUsedrug(Long personInsanityUsedrugId) {
        PersonInsanityUsedrug usedrug = super.selectAObject(PersonInsanityUsedrug.class, personInsanityUsedrugId);
        if (null != usedrug) {
            super.delete(usedrug);
        }
    }
}
