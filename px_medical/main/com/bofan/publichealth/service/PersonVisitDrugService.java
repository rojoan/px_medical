package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonVisitDrugQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronicVisit;
import com.bofan.publichealth.valueobject.PersonVisitDrug;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 慢性病随访用药情况业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class PersonVisitDrugService extends AbstractAnnoCommonService {
    
    
    /**
     * 根据慢性病这ID和个人信息ID获取慢性病随访药物ID
     * @param personChronicId
     * @param personDetailId
     * @return
     */
    public List<PersonVisitDrug> selectPersonVisitDrug(Long chronicVisitId, Long personDetailId, String chronicType) {
        PersonVisitDrugQueryInfo queryInfo = new PersonVisitDrugQueryInfo();
        queryInfo.setChronicVisitId(chronicVisitId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonVisitDrug.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存慢性病随访药物
     * @param chronicDrugArray
     * @param personChronicId
     * @param personDetailId
     * @param personChronic
     */
    public void savePersonVisitDrugByJson(String personVisitDrugJson, PersonChronicVisit personChronicVisit) {
        List<PersonVisitDrug> visitDrugList = JSONArray.parseArray(personVisitDrugJson, PersonVisitDrug.class);
        if (null != visitDrugList && visitDrugList.size() > 0) {
            for (PersonVisitDrug visitDrug : visitDrugList) {
                if (null == visitDrug.getDiseaseDrugId()) {
                    continue;
                }
                
                visitDrug.setValidFlag(Contstants.YES_FLAG);
                visitDrug.setVisitTime(personChronicVisit.getVisitTime());
                visitDrug.setHospitalId(personChronicVisit.getHospitalId());
                visitDrug.setChronicType(personChronicVisit.getChronicType());
                visitDrug.setVisitDoctorId(personChronicVisit.getVisitDoctorId());
                visitDrug.setPersonDetailId(personChronicVisit.getPersonDetailId());
                visitDrug.setPersonChronicId(personChronicVisit.getPersonChronicId());
                visitDrug.setChronicVisitId(personChronicVisit.getChronicVisitId());
                
                if (null != visitDrug.getVisitDrugId()) {
                    PersonVisitDrug personVisitDrug = super.selectAObject(PersonVisitDrug.class, visitDrug.getVisitDrugId());
                    NullBeanUtils.copyProperties(personVisitDrug, visitDrug);
                    super.save(personVisitDrug);
                } else {
                    super.save(visitDrug);
                }
            }
        }
    }

    /**
     * 根据主键删除慢性病随访药物
     * @param chronicDrugId
     */
    public void deletePersonVisitDrug(Long visitDrugId) {
        PersonVisitDrug visitDrug = super.selectAObject(PersonVisitDrug.class, visitDrugId);
        if (null != visitDrug) {
            super.delete(visitDrug);
        }
    }
}
