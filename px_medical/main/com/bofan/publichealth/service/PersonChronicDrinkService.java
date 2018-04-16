package com.bofan.publichealth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonChronicDrinkQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronic;
import com.bofan.publichealth.valueobject.PersonChronicDrink;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 慢性病患者--饮酒种类对照业务
 * @author xlf
 * 2017-10-26
 */
@Service
public class PersonChronicDrinkService extends AbstractAnnoCommonService {
    
    
    /**
     * 根据慢性病这ID和个人信息ID获取慢性病患者--饮酒种类对照
     * @param personChronicId
     * @param personDetailId
     * @return
     */
    @Transactional
    public Map<String, PersonChronicDrink> selectPersonChronicDrinkMap(Long personChronicId, Long personDetailId) {
        Map<String, PersonChronicDrink> dataMap = new HashMap<String, PersonChronicDrink>();
        PersonChronicDrinkQueryInfo queryInfo = new PersonChronicDrinkQueryInfo();
        queryInfo.setPersonChronicId(personChronicId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<PersonChronicDrink> dataList = super.executeSql(PersonChronicDrink.class, qo.getQueryString(), qo.getParam());
        if (null == dataList) {
            return dataMap;
        }
        
        for (PersonChronicDrink chronicDrink : dataList) {
            dataMap.put(chronicDrink.getDrinkTypeId() + "", chronicDrink);
        }
        return dataMap;
    }
    
    /**
     * 保存慢性病患者--饮酒种类对照
     * @param chronicDrugArray
     * @param personChronicId
     * @param personDetailId
     * @param personChronic
     */
    public void savePersonChronicDrinkByJson(String chronicDrinkByJson, PersonChronic personChronic) {
        PersonChronicDrink chronicDrink = null;
        Map<String, PersonChronicDrink> chronicDrinkMap = this.selectPersonChronicDrinkMap(personChronic.getPersonChronicId(), personChronic.getPersonDetailId());
        List<PersonChronicDrink> chronicDrinkList = JSONArray.parseArray(chronicDrinkByJson, PersonChronicDrink.class);
        if (null != chronicDrinkList && chronicDrinkList.size() > 0) {
            for (PersonChronicDrink chronicDrinkInfo : chronicDrinkList) {
                if (null == chronicDrinkInfo.getDrinkTypeId()) {
                    continue;
                }
                
                chronicDrink = chronicDrinkMap.get(chronicDrinkInfo.getDrinkTypeId() + "");
                if (null != chronicDrink) {
                    chronicDrinkInfo.setChronicDrinkId(chronicDrink.getChronicDrinkId());
                    chronicDrinkMap.remove(chronicDrinkInfo.getDrinkTypeId() + "", chronicDrink);
                } else {
                    chronicDrink = new PersonChronicDrink();
                }
                chronicDrinkInfo.setValidFlag(Contstants.YES_FLAG);
                chronicDrinkInfo.setPersonDetailId(personChronic.getPersonDetailId());
                chronicDrinkInfo.setPersonChronicId(personChronic.getPersonChronicId());
                chronicDrinkInfo.setCreateTime(personChronic.getCreateTime());
                chronicDrinkInfo.setCreatorId(personChronic.getCreatorId());
                chronicDrinkInfo.setHospitalId(personChronic.getHospitalId());
    
                NullBeanUtils.copyProperties(chronicDrink, chronicDrinkInfo);
                super.save(chronicDrink);
            }
        }
        
        // 删除多余的数据
        for (PersonChronicDrink value : chronicDrinkMap.values()) { 
            super.delete(value);
        } 
    }

    /**
     * 根据主键删除慢性病患者--饮酒种类对照
     * @param chronicDrugId
     */
    public void deletePersonChronicDrink(Long chronicDrugId) {
        PersonChronicDrink personalDrug = super.selectAObject(PersonChronicDrink.class, chronicDrugId);
        if (null != personalDrug) {
            super.delete(personalDrug);
        }
    }
}
