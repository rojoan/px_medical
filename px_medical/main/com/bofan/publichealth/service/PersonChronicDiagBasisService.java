package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonChronicDiagBasisIdQueryInfo;
import com.bofan.publichealth.command.PersonChronicDiagBasisQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronic;
import com.bofan.publichealth.valueobject.PersonChronicDiagBasis;
import com.bofan.utils.Contstants;

/**
 * @Description 慢性病--诊断依据业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class PersonChronicDiagBasisService extends AbstractAnnoCommonService {

    /**
     * 获取慢性病--诊断依据ID
     * @param personChronicId
     * @param personDetailId
     * @return
     */
    @Transactional
    public List<String> selectPersonChronicDiagBasisId(Long personChronicId, Long personDetailId, String chronicType) {
        PersonChronicDiagBasisIdQueryInfo queryInfo = new PersonChronicDiagBasisIdQueryInfo();
        queryInfo.setPersonChronicId(personChronicId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(String.class, qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存慢性病--诊断依据
     * @param diagnoseBasis
     * @param personDetailId
     * @param examPersonId
     */
    public void savePersonChronicDiagBasis(String[] diagnoseBasis, PersonChronic personChronic, String chronicType) {
        List<PersonChronicDiagBasis> dangerList = this.selectPersonChronicDiagBasis(personChronic.getPersonChronicId(), personChronic.getPersonDetailId(), chronicType);
        if (null == diagnoseBasis || diagnoseBasis.length <= 0) {
            if (null != dangerList && dangerList.size() > 0) {
                super.deleteAll(dangerList);
            }
            return ;
        }
        
        int index = 0;
        int maxIndex = (null != dangerList ? dangerList.size() : 0);
        PersonChronicDiagBasis diagBasis = null;
        for (String type : diagnoseBasis) {
            diagBasis = ((maxIndex > 0 && maxIndex > index) ? dangerList.get(0) : null);
            if (null != diagBasis) {
                dangerList.remove(0);
            } else {
                diagBasis = new PersonChronicDiagBasis();
            }
            diagBasis.setValidFlag(Contstants.YES_FLAG);
            diagBasis.setChronicType(chronicType);
            diagBasis.setCreateTime(personChronic.getCreateTime());
            diagBasis.setCreatorId(personChronic.getCreatorId());
            diagBasis.setHospitalId(personChronic.getHospitalId());
            diagBasis.setDiagnoseBasis(type);
            diagBasis.setPersonDetailId(personChronic.getPersonDetailId());
            diagBasis.setPersonChronicId(personChronic.getPersonChronicId());
            
            index++;
            super.save(diagBasis);
        }
        
        if (null != dangerList && dangerList.size() > 0) {
            for (PersonChronicDiagBasis basis : dangerList) {
                super.delete(basis);
            }
        }
    }
    
    /**
     * 获取慢性病--诊断依据
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    private List<PersonChronicDiagBasis> selectPersonChronicDiagBasis(Long personChronicId, Long personDetailId, String chronicType) {
        PersonChronicDiagBasisQueryInfo queryInfo = new PersonChronicDiagBasisQueryInfo();
        queryInfo.setPersonChronicId(personChronicId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonChronicDiagBasis.class, qo.getQueryString(), qo.getParam());
    }
    
}