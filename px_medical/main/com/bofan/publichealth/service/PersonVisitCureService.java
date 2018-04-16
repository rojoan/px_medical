package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonVisitCureIdQueryInfo;
import com.bofan.publichealth.command.PersonVisitCureQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronicVisit;
import com.bofan.publichealth.valueobject.PersonVisitCure;
import com.bofan.utils.Contstants;

/**
 * @Description 慢性病随访-治疗情况业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class PersonVisitCureService extends AbstractAnnoCommonService {

    /**
     * 获取慢性病随访-治疗情况ID
     * @param chronicVisitId
     * @param personDetailId
     * @return
     */
    @Transactional
    public List<String> selectPersonVisitCureId(Long chronicVisitId, Long personDetailId, String chronicType) {
        PersonVisitCureIdQueryInfo queryInfo = new PersonVisitCureIdQueryInfo();
        queryInfo.setChronicVisitId(chronicVisitId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(String.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存慢性病随访-治疗情况
     * @param visitSignTypes
     * @param chronicVisit
     * @param chronicType
     */
    public void savePersonVisitCure(String[] visitCureTypes, PersonChronicVisit chronicVisit, String chronicType) {
        List<PersonVisitCure> cureList = this.selectPersonVisitCure(chronicVisit.getPersonChronicId(), chronicVisit.getPersonDetailId(), chronicType);
        if (null == visitCureTypes || visitCureTypes.length <= 0) {
            if (null != cureList && cureList.size() > 0) {
                super.deleteAll(cureList);
            }
            return ;
        }
        
        int index = 0;
        int maxIndex = (null != cureList ? cureList.size() : 0);
        PersonVisitCure visitCure = null;
        for (String type : visitCureTypes) {
            visitCure = ((maxIndex > 0 && maxIndex > index) ? cureList.get(0) : null);
            if (null != visitCure) {
                cureList.remove(0);
            } else {
                visitCure = new PersonVisitCure();
            }
            visitCure.setValidFlag(Contstants.YES_FLAG);
            visitCure.setChronicType(chronicType);
            visitCure.setVisitTime(chronicVisit.getVisitTime());
            visitCure.setVisitDoctorId(chronicVisit.getVisitDoctorId());
            visitCure.setHospitalId(chronicVisit.getHospitalId());
            visitCure.setCureType(type);
            visitCure.setChronicVisitId(chronicVisit.getChronicVisitId());
            visitCure.setPersonDetailId(chronicVisit.getPersonDetailId());
            visitCure.setPersonChronicId(chronicVisit.getPersonChronicId());
            
            index++;
            super.save(visitCure);
        }
        
        if (null != cureList && cureList.size() > 0) {
            for (PersonVisitCure cure : cureList) {
                super.delete(cure);
            }
        }
    }
    
    /**
     * 获取慢性病随访-治疗情况
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    private List<PersonVisitCure> selectPersonVisitCure(Long chronicVisitId, Long personDetailId, String chronicType) {
        PersonVisitCureQueryInfo queryInfo = new PersonVisitCureQueryInfo();
        queryInfo.setChronicVisitId(chronicVisitId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonVisitCure.class, qo.getQueryString(), qo.getParam());
    }
    
}