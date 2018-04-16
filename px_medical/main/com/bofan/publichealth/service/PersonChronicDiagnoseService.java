package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonChronicDiagnoseIdQueryInfo;
import com.bofan.publichealth.command.PersonChronicDiagnoseQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronic;
import com.bofan.publichealth.valueobject.PersonChronicDiagnose;
import com.bofan.utils.Contstants;

/**
 * @Description 慢性病--危险因素业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class PersonChronicDiagnoseService extends AbstractAnnoCommonService {

    /**
     * 获取慢性病--危险因素ID
     * @param personChronicId
     * @param personDetailId
     * @return
     */
    @Transactional
    public List<String> selectPersonChronicDiagnoseId(Long personChronicId, Long personDetailId, String chronicType) {
        PersonChronicDiagnoseIdQueryInfo queryInfo = new PersonChronicDiagnoseIdQueryInfo();
        queryInfo.setPersonChronicId(personChronicId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(String.class, qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存慢性病--危险因素
     * @param symptomIds
     * @param personDetailId
     * @param examPersonId
     */
    public void savePersonChronicDiagnose(String[] nonDrugType, PersonChronic personChronic, String chronicType) {
        List<PersonChronicDiagnose> dangerList = this.selectPersonChronicDiagnose(personChronic.getPersonChronicId(), personChronic.getPersonDetailId(), chronicType);
        if (null == nonDrugType || nonDrugType.length <= 0) {
            if (null != dangerList && dangerList.size() > 0) {
                super.deleteAll(dangerList);
            }
            return ;
        }
        
        int index = 0;
        int maxIndex = (null != dangerList ? dangerList.size() : 0);
        PersonChronicDiagnose chronicDiagnose = null;
        for (String type : nonDrugType) {
            chronicDiagnose = ((maxIndex > 0 && maxIndex > index) ? dangerList.get(0) : null);
            if (null != chronicDiagnose) {
                dangerList.remove(0);
            } else {
                chronicDiagnose = new PersonChronicDiagnose();
            }
            chronicDiagnose.setValidFlag(Contstants.YES_FLAG);
            chronicDiagnose.setChronicType(chronicType);
            chronicDiagnose.setCreateTime(personChronic.getCreateTime());
            chronicDiagnose.setCreatorId(personChronic.getCreatorId());
            chronicDiagnose.setHospitalId(personChronic.getHospitalId());
            chronicDiagnose.setDiagnoseType(type);
            chronicDiagnose.setPersonDetailId(personChronic.getPersonDetailId());
            chronicDiagnose.setPersonChronicId(personChronic.getPersonChronicId());
            
            index++;
            super.save(chronicDiagnose);
        }
        
        if (null != dangerList && dangerList.size() > 0) {
            for (PersonChronicDiagnose diagnose : dangerList) {
                super.delete(diagnose);
            }
        }
    }
    
    /**
     * 获取慢性病--危险因素
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    private List<PersonChronicDiagnose> selectPersonChronicDiagnose(Long personChronicId, Long personDetailId, String chronicType) {
        PersonChronicDiagnoseQueryInfo queryInfo = new PersonChronicDiagnoseQueryInfo();
        queryInfo.setPersonChronicId(personChronicId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonChronicDiagnose.class, qo.getQueryString(), qo.getParam());
    }
    
}