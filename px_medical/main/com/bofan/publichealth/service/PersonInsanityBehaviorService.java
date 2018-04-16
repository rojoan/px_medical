package com.bofan.publichealth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonInsanityBehaviorQueryInfo;
import com.bofan.publichealth.valueobject.PersonInsanityBehavior;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 重性精神病--危险行为业务
 * @author xlf
 * 2017-10-26
 */
@Service
public class PersonInsanityBehaviorService extends AbstractAnnoCommonService {
    
    /**
     * 获取重性精神病--危险行为
     * @param personInsanityId
     * @param personInsanityVisitId
     * @param recordFlag
     * @return
     */
    @Transactional
    public Map<String, PersonInsanityBehavior> selectPersonInsanityBehavior(Long personInsanityId, Long personInsanityVisitId, String recordFlag) {
        Map<String, PersonInsanityBehavior> result = new HashMap<String, PersonInsanityBehavior>();
        PersonInsanityBehaviorQueryInfo queryInfo = new PersonInsanityBehaviorQueryInfo();
        queryInfo.setRecordFlag(recordFlag);
        queryInfo.setPersonInsanityId(personInsanityId);
        queryInfo.setPersonInsanityVisitId(personInsanityVisitId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<PersonInsanityBehavior> dataList = super.executeSql(PersonInsanityBehavior.class, qo.getQueryString(), qo.getParam());
        if (null != dataList) {
            for (PersonInsanityBehavior behavior : dataList) {
                result.put(behavior.getInsanityType(), behavior);
            }
        }
        return result;
    }
    
    /**
     * 保存重性精神病--危险行为
     * @param insanityBehaviorJson
     * @param personInsanityId
     * @param personInsanityVisitId
     * @param personDetailId
     * @param hospitalId
     * @param creatorId
     * @param recordFlag
     */
    public void savePersonInsanityBehaviorByJson(String insanityBehaviorJson, Long personInsanityId, Long personInsanityVisitId,
            Long personDetailId, Long hospitalId, Long creatorId, String recordFlag) {
        
        List<PersonInsanityBehavior> behaviorList = JSONArray.parseArray(insanityBehaviorJson, PersonInsanityBehavior.class);
        Map<String, PersonInsanityBehavior> behaviorMap = this.selectPersonInsanityBehavior(personInsanityId, personInsanityVisitId, recordFlag);
        if (null != behaviorList && behaviorList.size() > 0) {
            PersonInsanityBehavior behavior = null;
            for (PersonInsanityBehavior behaviorInfo : behaviorList) {
                if (!StringUtils.hasText(behaviorInfo.getInsanityType())) {
                    continue;
                }

                behavior = behaviorMap.get(behaviorInfo.getInsanityType());
                if (null != behavior) {
                    behavior.setInsanityTypeCount(behaviorInfo.getInsanityTypeCount());
                    behaviorMap.remove(behaviorInfo.getInsanityType(), behavior);
                } else {
                    behavior = new PersonInsanityBehavior();
                    behaviorInfo.setRecordFlag(recordFlag);
                    behaviorInfo.setCreatorId(creatorId);
                    behaviorInfo.setHospitalId(hospitalId);
                    behaviorInfo.setPersonDetailId(personDetailId);
                    behaviorInfo.setPersonInsanityId(personInsanityId);
                    behaviorInfo.setPersonInsanityVisitId(personInsanityVisitId);
                    NullBeanUtils.copyProperties(behavior, behaviorInfo);
                }
                super.save(behavior);
            }
        }
        
        // 删除多余的数据
        for (PersonInsanityBehavior value : behaviorMap.values()) { 
            super.delete(value);
        } 
    }

    /**
     * 根据主键删除重性精神病--危险行为
     * @param chronicDrugId
     */
    @Transactional
    public void deletePersonVisitDrug(Long personInsanityBehaviorId) {
        PersonInsanityBehavior behavior = super.selectAObject(PersonInsanityBehavior.class, personInsanityBehaviorId);
        if (null != behavior) {
            super.delete(behavior);
        }
    }
}
