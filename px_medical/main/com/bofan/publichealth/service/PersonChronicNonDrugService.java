package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonChronicNonDrugIdQueryInfo;
import com.bofan.publichealth.command.PersonChronicNonDrugQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronic;
import com.bofan.publichealth.valueobject.PersonChronicNonDrug;
import com.bofan.utils.Contstants;

/**
 * @Description 慢性病非药物治疗业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class PersonChronicNonDrugService extends AbstractAnnoCommonService {

    /**
     * 获取慢性病非药物治疗ID
     * @param personChronicId
     * @param personDetailId
     * @return
     */
    @Transactional
    public List<Long> selectPersonChronicNonDrugId(Long personChronicId, Long personDetailId, String chronicType) {
        PersonChronicNonDrugIdQueryInfo queryInfo = new PersonChronicNonDrugIdQueryInfo();
        queryInfo.setPersonChronicId(personChronicId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(Long.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存慢性病非药物治疗
     * @param symptomIds
     * @param personDetailId
     * @param examPersonId
     */
    public void savePersonChronicNonDrug(String[] nonDrugType, PersonChronic personChronic, String chronicType) {
        List<PersonChronicNonDrug> nonDrugList = this.selectPersonChronicNonDrug(personChronic.getPersonChronicId(), personChronic.getPersonDetailId(), chronicType);
        if (null == nonDrugType || nonDrugType.length <= 0) {
            if (null != nonDrugList && nonDrugList.size() > 0) {
                super.deleteAll(nonDrugList);
            }
            return ;
        }
        
        int index = 0;
        int maxIndex = (null != nonDrugList ? nonDrugList.size() : 0);
        PersonChronicNonDrug chronicNonDrug = null;
        for (String type : nonDrugType) {
            chronicNonDrug = ((maxIndex > 0 && maxIndex > index) ? nonDrugList.get(0) : null);
            if (null != chronicNonDrug) {
                nonDrugList.remove(0);
            } else {
                chronicNonDrug = new PersonChronicNonDrug();
            }
            chronicNonDrug.setValidFlag(Contstants.YES_FLAG);
            chronicNonDrug.setChronicType(chronicType);
            chronicNonDrug.setCreateTime(personChronic.getCreateTime());
            chronicNonDrug.setCreatorId(personChronic.getCreatorId());
            chronicNonDrug.setHospitalId(personChronic.getHospitalId());
            chronicNonDrug.setNonDrugType(type);
            chronicNonDrug.setPersonDetailId(personChronic.getPersonDetailId());
            chronicNonDrug.setPersonChronicId(personChronic.getPersonChronicId());
            
            index++;
            super.save(chronicNonDrug);
        }
        
        if (null != nonDrugList && nonDrugList.size() > 0) {
            for (PersonChronicNonDrug nonDrug: nonDrugList) {
                super.delete(nonDrug);
            }
        }
    }
    
    /**
     * 获取慢性病非药物治疗类型
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    private List<PersonChronicNonDrug> selectPersonChronicNonDrug(Long personChronicId, Long personDetailId, String chronicType) {
        PersonChronicNonDrugQueryInfo queryInfo = new PersonChronicNonDrugQueryInfo();
        queryInfo.setPersonChronicId(personChronicId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonChronicNonDrug.class, qo.getQueryString(), qo.getParam());
    }

}