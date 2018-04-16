package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonVisitSignIdQueryInfo;
import com.bofan.publichealth.command.PersonVisitSignQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronicVisit;
import com.bofan.publichealth.valueobject.PersonVisitSign;
import com.bofan.utils.Contstants;

/**
 * @Description 慢性病随访--体征业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class PersonVisitSignService extends AbstractAnnoCommonService {

    /**
     * 获取慢性病随访--体征ID
     * @param personChronicId
     * @param personDetailId
     * @return
     */
    @Transactional
    public List<String> selectPersonVisitSignId(Long personChronicId, Long personDetailId, String chronicType) {
        PersonVisitSignIdQueryInfo queryInfo = new PersonVisitSignIdQueryInfo();
        queryInfo.setPersonChronicId(personChronicId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(String.class, qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存慢性病随访--体征
     * @param visitSignTypes
     * @param personDetailId
     * @param examPersonId
     */
    public void savePersonVisitSign(String[] visitSignTypes, PersonChronicVisit personChronic, String chronicType) {
        List<PersonVisitSign> dangerList = this.selectPersonVisitSign(personChronic.getPersonChronicId(), personChronic.getPersonDetailId(), chronicType);
        if (null == visitSignTypes || visitSignTypes.length <= 0) {
            if (null != dangerList && dangerList.size() > 0) {
                super.deleteAll(dangerList);
            }
            return ;
        }
        
        int index = 0;
        int maxIndex = (null != dangerList ? dangerList.size() : 0);
        PersonVisitSign visitSign = null;
        for (String type : visitSignTypes) {
            visitSign = ((maxIndex > 0 && maxIndex > index) ? dangerList.get(0) : null);
            if (null != visitSign) {
                dangerList.remove(0);
            } else {
                visitSign = new PersonVisitSign();
            }
            visitSign.setValidFlag(Contstants.YES_FLAG);
            visitSign.setChronicType(chronicType);
            visitSign.setVisitTime(personChronic.getVisitTime());
            visitSign.setVisitDoctorId(personChronic.getVisitDoctorId());
            visitSign.setHospitalId(personChronic.getHospitalId());
            visitSign.setSignType(type);
            visitSign.setPersonDetailId(personChronic.getPersonDetailId());
            visitSign.setPersonChronicId(personChronic.getPersonChronicId());
            
            index++;
            super.save(visitSign);
        }
        
        if (null != dangerList && dangerList.size() > 0) {
            for (PersonVisitSign sign : dangerList) {
                super.delete(sign);
            }
        }
    }
    
    /**
     * 获取慢性病随访--体征
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    private List<PersonVisitSign> selectPersonVisitSign(Long personChronicId, Long personDetailId, String chronicType) {
        PersonVisitSignQueryInfo queryInfo = new PersonVisitSignQueryInfo();
        queryInfo.setPersonChronicId(personChronicId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonVisitSign.class, qo.getQueryString(), qo.getParam());
    }
    
}