package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonChronicDangerIdQueryInfo;
import com.bofan.publichealth.command.PersonChronicDangerQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronic;
import com.bofan.publichealth.valueobject.PersonChronicDanger;
import com.bofan.utils.Contstants;

/**
 * @Description 慢性病--危险因素业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class PersonChronicDangerService extends AbstractAnnoCommonService {

    /**
     * 获取慢性病--危险因素ID
     * @param personChronicId
     * @param personDetailId
     * @return
     */
    @Transactional
    public List<Long> selectPersonChronicDangerId(Long personChronicId, Long personDetailId, String chronicType) {
        PersonChronicDangerIdQueryInfo queryInfo = new PersonChronicDangerIdQueryInfo();
        queryInfo.setPersonChronicId(personChronicId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(Long.class, qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存慢性病--危险因素
     * @param symptomIds
     * @param personDetailId
     * @param examPersonId
     */
    public void savePersonChronicDanger(String[] nonDrugType, PersonChronic personChronic, String chronicType) {
        List<PersonChronicDanger> dangerList = this.selectPersonChronicDanger(personChronic.getPersonChronicId(), personChronic.getPersonDetailId(), chronicType);
        if (null == nonDrugType || nonDrugType.length <= 0) {
            if (null != dangerList && dangerList.size() > 0) {
                super.deleteAll(dangerList);
            }
            return ;
        }
        
        int index = 0;
        int maxIndex = (null != dangerList ? dangerList.size() : 0);
        PersonChronicDanger chronicDanger = null;
        for (String type : nonDrugType) {
            chronicDanger = ((maxIndex > 0 && maxIndex > index) ? dangerList.get(0) : null);
            if (null != chronicDanger) {
                dangerList.remove(0);
            } else {
                chronicDanger = new PersonChronicDanger();
            }
            chronicDanger.setValidFlag(Contstants.YES_FLAG);
            chronicDanger.setChronicType(chronicType);
            chronicDanger.setCreateTime(personChronic.getCreateTime());
            chronicDanger.setCreatorId(personChronic.getCreatorId());
            chronicDanger.setHospitalId(personChronic.getHospitalId());
            chronicDanger.setDangerType(type);
            chronicDanger.setPersonDetailId(personChronic.getPersonDetailId());
            chronicDanger.setPersonChronicId(personChronic.getPersonChronicId());
            
            index++;
            super.save(chronicDanger);
        }
        
        if (null != dangerList && dangerList.size() > 0) {
            for (PersonChronicDanger danger : dangerList) {
                super.delete(danger);
            }
        }
    }
    
    /**
     * 获取慢性病--危险因素
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    private List<PersonChronicDanger> selectPersonChronicDanger(Long personChronicId, Long personDetailId, String chronicType) {
        PersonChronicDangerQueryInfo queryInfo = new PersonChronicDangerQueryInfo();
        queryInfo.setPersonChronicId(personChronicId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonChronicDanger.class, qo.getQueryString(), qo.getParam());
    }
    
}