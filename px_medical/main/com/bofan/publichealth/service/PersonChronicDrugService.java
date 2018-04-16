package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonChronicDrugQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronic;
import com.bofan.publichealth.valueobject.PersonChronicDrug;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 慢性病本次药物治疗业务
 * @author xlf
 * 2017-10-26
 */
@Service
public class PersonChronicDrugService extends AbstractAnnoCommonService {
    
    
    /**
     * 根据慢性病这ID和个人信息ID获取慢性病本次药物治疗
     * @param personChronicId
     * @param personDetailId
     * @return
     */
    @Transactional
    public List<PersonChronicDrug> selectPersonChronicDrug(Long personChronicId, Long personDetailId) {
        PersonChronicDrugQueryInfo queryInfo = new PersonChronicDrugQueryInfo();
        queryInfo.setPersonChronicId(personChronicId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonChronicDrug.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存慢性病本次药物治疗
     * @param chronicDrugArray
     * @param personChronicId
     * @param personDetailId
     * @param personChronic
     */
    public void savePersonalDrugByJson(String chronicDrugJson, PersonChronic personChronic, String chronicType) {
        List<PersonChronicDrug> chronicDrugList = JSONArray.parseArray(chronicDrugJson, PersonChronicDrug.class);
        if (null != chronicDrugList && chronicDrugList.size() > 0) {
            for (PersonChronicDrug chronicDrug : chronicDrugList) {
                if (null == chronicDrug.getDiseaseDrugId()) {
                    continue;
                }
                
                chronicDrug.setValidFlag(Contstants.YES_FLAG);
                chronicDrug.setChronicType(chronicType);
                chronicDrug.setPersonDetailId(personChronic.getPersonDetailId());
                chronicDrug.setPersonChronicId(personChronic.getPersonChronicId());
                chronicDrug.setCreateTime(personChronic.getCreateTime());
                chronicDrug.setCreatorId(personChronic.getCreatorId());
                chronicDrug.setHospitalId(personChronic.getHospitalId());
                
                if (null != chronicDrug.getChronicDrugId()) {
                    PersonChronicDrug personChronicDrug = super.selectAObject(PersonChronicDrug.class, chronicDrug.getChronicDrugId());
                    NullBeanUtils.copyProperties(personChronicDrug, chronicDrug);
                    super.save(personChronicDrug);
                } else {
                    super.save(chronicDrug);
                }
            }
        }
    }

    /**
     * 删除慢性病本次药物治疗(多个)
     * @param personChronicId
     * @param personDetailId
     */
    @Transactional
    public void deletePersonChronicDrug(Long personChronicId, Long personDetailId) {
        List<PersonChronicDrug> chronicDrugList = this.selectPersonChronicDrug(personChronicId, personDetailId);
        if (null != chronicDrugList) {
            super.deleteAll(chronicDrugList);
        }
    }
    
    /**
     * 根据主键删除慢性病本次药物治疗
     * @param chronicDrugId
     */
    @Transactional
    public void deletePersonChronicDrug(Long chronicDrugId) {
        PersonChronicDrug personalDrug = super.selectAObject(PersonChronicDrug.class, chronicDrugId);
        if (null != personalDrug) {
            super.delete(personalDrug);
        }
    }
}
