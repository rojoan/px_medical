package com.bofan.publichealth.elder.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.elder.command.HealthAssessItemQueryInfo;
import com.bofan.publichealth.elder.valueobject.HealthAssessItem;
import com.bofan.utils.Contstants;
import com.bofan.utils.Tools;

/**
 * @Description: 健康评估项目字典表--老年人 Service
 * @author lqw
 */
@Service
@Transactional
public class HealthAssessItemService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询 健康评估项目字典表--老年人 列表
     * @param queryInfo HealthAssessItemQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<HealthAssessItem> selectHealthAssessItemList(HealthAssessItemQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询 健康评估项目字典表--老年人
     * @param queryInfo HealthAssessItemQueryInfo
     * @return
     */
    public HealthAssessItem findHealthAssessItem(HealthAssessItemQueryInfo queryInfo) {
        List<HealthAssessItem> list = selectHealthAssessItemList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }

    
    /**
     * 
     * Map<项目类型,List<项目细项>>
     * 项目细项 为 非  正常健康评估
     * @return
     */
    public Map<String,List<HealthAssessItem>> selectHealthAssessItemItemHealthNoGroupMap() {
        Map<String,List<HealthAssessItem>> healthAssessTypeMap = new HashMap<String,List<HealthAssessItem>>();
        
        HealthAssessItemQueryInfo queryInfo = new HealthAssessItemQueryInfo();
        queryInfo.setValidFlag(Contstants.YES_FLAG);
        queryInfo.setHealthFlag(Contstants.NO_FLAG);
        List<HealthAssessItem> list = selectHealthAssessItemList(queryInfo);
        
        if (!Tools.isNotEmptyList(list)) {
            return healthAssessTypeMap;
        }
        
        for (HealthAssessItem healthAssessItem : list) {
            
            String healthAssessTypeId = healthAssessItem.getHealthAssessTypeId();
            
            List<HealthAssessItem> typeItemList = healthAssessTypeMap.get(healthAssessTypeId);
            if (Tools.isNotEmptyList(typeItemList)) {
                typeItemList.add(healthAssessItem);
                healthAssessTypeMap.put(healthAssessTypeId, typeItemList);
                continue;
            }
            
            typeItemList = new ArrayList<HealthAssessItem>();
            typeItemList.add(healthAssessItem);
            healthAssessTypeMap.put(healthAssessTypeId, typeItemList);
        }
        System.out.println("healthAssessTypeMap = "+ JSON.toJSON(healthAssessTypeMap));
        return healthAssessTypeMap;
    }
 
    
    /**
     * 
     * Map<项目类型,List<项目细项>>
     * 项目细项 为正常健康评估
     * @return
     */
    public Map<String,List<HealthAssessItem>> selectHealthAssessItemHealthYesGroupMap() {
        Map<String,List<HealthAssessItem>> healthAssessTypeMap = new HashMap<String,List<HealthAssessItem>>();
        
        HealthAssessItemQueryInfo queryInfo = new HealthAssessItemQueryInfo();
        queryInfo.setValidFlag(Contstants.YES_FLAG);
        queryInfo.setHealthFlag(Contstants.YES_FLAG);
        List<HealthAssessItem> list = selectHealthAssessItemList(queryInfo);
        
        if (!Tools.isNotEmptyList(list)) {
            return healthAssessTypeMap;
        }
        
        for (HealthAssessItem healthAssessItem : list) {
            
            String healthAssessTypeId = healthAssessItem.getHealthAssessTypeId();
            
            List<HealthAssessItem> typeItemList = healthAssessTypeMap.get(healthAssessTypeId);
            if (Tools.isNotEmptyList(typeItemList)) {
                typeItemList.add(healthAssessItem);
                healthAssessTypeMap.put(healthAssessTypeId, typeItemList);
                continue;
            }
            
            typeItemList = new ArrayList<HealthAssessItem>();
            typeItemList.add(healthAssessItem);
            healthAssessTypeMap.put(healthAssessTypeId, typeItemList);
        }
        System.out.println("healthAssessTypeMap = "+ JSON.toJSON(healthAssessTypeMap));
        return healthAssessTypeMap;
    }
    
   
    
}