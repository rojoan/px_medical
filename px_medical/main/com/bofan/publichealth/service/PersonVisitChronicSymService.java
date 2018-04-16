package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonVisitChronicSymIdQueryInfo;
import com.bofan.publichealth.command.PersonVisitChronicSymQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronicVisit;
import com.bofan.publichealth.valueobject.PersonVisitChronicSym;
import com.bofan.utils.Contstants;

/**
 * @Description 慢性病随访--症状务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
@Transactional
public class PersonVisitChronicSymService extends AbstractAnnoCommonService {

    /**
     * 获取慢性病非药物治疗ID
     * @param personChronicId
     * @param personDetailId
     * @return
     */
    public List<Long> selectPersonVisitChronicSymId(Long chronicVisitId, Long personDetailId, String chronicType) {
        PersonVisitChronicSymIdQueryInfo queryInfo = new PersonVisitChronicSymIdQueryInfo();
        queryInfo.setChronicVisitId(chronicVisitId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(Long.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 获取慢性病非药物治疗类型
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<PersonVisitChronicSym> selectPersonVisitChronicSym(Long chronicVisitId, Long personDetailId, String chronicType) {
        PersonVisitChronicSymQueryInfo queryInfo = new PersonVisitChronicSymQueryInfo();
        queryInfo.setChronicVisitId(chronicVisitId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonVisitChronicSym.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存慢性病非药物治疗
     * @param symptomIds
     * @param personDetailId
     * @param examPersonId
     */
    public void savePersonVisitChronicSym(String[] visitChronicSymIds, PersonChronicVisit personChronicVisit) {
        List<PersonVisitChronicSym> chronicSymList = this.selectPersonVisitChronicSym(
                personChronicVisit.getChronicVisitId(), personChronicVisit.getPersonDetailId(),
                personChronicVisit.getChronicType());
        if (null == visitChronicSymIds || visitChronicSymIds.length <= 0) {
            if (null != chronicSymList && chronicSymList.size()> 0) {
                super.deleteAll(chronicSymList);
            }
            return ;
        }
        
        int index = 0;
        PersonVisitChronicSym visitChronicSym = null;
        int maxIndex = (null == chronicSymList ? 0 : chronicSymList.size());
        for (String symptomId : visitChronicSymIds) {
            if (!StringUtils.hasText(symptomId)) {
                continue ;
            }
            
            if (maxIndex > index) {
                visitChronicSym = chronicSymList.get(index);
                chronicSymList.remove(index);
                maxIndex = chronicSymList.size();
            } else {
                visitChronicSym = new PersonVisitChronicSym();
            }
            visitChronicSym.setValidFlag(Contstants.YES_FLAG);
            visitChronicSym.setChronicType(personChronicVisit.getChronicType());
            visitChronicSym.setSymptomId(Long.valueOf(symptomId));
            visitChronicSym.setVisitTime(personChronicVisit.getVisitTime());
            visitChronicSym.setVisitDoctorId(personChronicVisit.getVisitDoctorId());
            visitChronicSym.setHospitalId(personChronicVisit.getHospitalId());
            visitChronicSym.setPersonDetailId(personChronicVisit.getPersonDetailId());
            visitChronicSym.setPersonChronicId(personChronicVisit.getPersonChronicId());
            visitChronicSym.setChronicVisitId(personChronicVisit.getChronicVisitId());
            
            index++;
            super.save(visitChronicSym);
        }
        
        // 删除多余选项
        for (PersonVisitChronicSym chronicSym : chronicSymList) {
            super.delete(chronicSym);
        }
        
    }
}