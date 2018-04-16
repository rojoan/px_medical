package com.bofan.publichealth.elder.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.elder.command.HealthAssessTypeQueryInfo;
import com.bofan.publichealth.elder.valueobject.HealthAssessType;
import com.bofan.utils.Contstants;
import com.bofan.utils.Tools;

/**
 * @Description: 老年人健康评估 - 项目评估类型 Service
 * @author lqw
 */
@Service
@Transactional
public class HealthAssessTypeService extends AbstractAnnoCommonService {
    /** 项目评估类型第一级的长度  */
    private int healthAssessTypeFirstLen = 3;
    /**
     * 根据条件查询 老年人健康评估 - 项目评估类型 列表
     * @param queryInfo HealthAssessTypeQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<HealthAssessType> selectHealthAssessTypeList(HealthAssessTypeQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询 老年人健康评估 - 项目评估类型
     * @param queryInfo HealthAssessTypeQueryInfo
     * @return
     */
    public HealthAssessType findHealthAssessType(HealthAssessTypeQueryInfo queryInfo) {
        List<HealthAssessType> list = selectHealthAssessTypeList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
     
    /**
     * 查询第一级类别的 Map
     * Map<第一级类别的ID，第一级类别的名称>
     * @return
     */
    public Map<String,String> selectFirstLevelHealthAssessTypeMap() {
        Map<String,String> healthAssessTypeMap = new HashMap<String,String>();
        HealthAssessTypeQueryInfo queryInfo = new HealthAssessTypeQueryInfo();
        queryInfo.setValidFlag(Contstants.YES_FLAG);
        List<HealthAssessType> list = selectHealthAssessTypeList(queryInfo);
        if (!Tools.isNotEmptyList(list)) {
            return healthAssessTypeMap;
        }
        for (HealthAssessType healthAssessType : list) {
            if (healthAssessType.getHealthAssessTypeId().length() > healthAssessTypeFirstLen) {
                continue;
            }
            healthAssessTypeMap.put(healthAssessType.getHealthAssessTypeId(), healthAssessType.getHealthAssessTypeName());
        }
        
        return healthAssessTypeMap;
    }
    
  
    /**
     * 获取  二级分类的List 的 map集合
     * Map<第一级类别的ID，List<Map<第二级类别的ID，第二级类别的名称>>
     * @return
     */
    public Map<String,List<Map<String,String>>> selectSecondLevelHealthAssessTypeMap() {
        Map<String,List<Map<String,String>>> healthAssessTypeMap = new HashMap<String,List<Map<String,String>>>();
        HealthAssessTypeQueryInfo queryInfo = new HealthAssessTypeQueryInfo();
        queryInfo.setValidFlag(Contstants.YES_FLAG);
        List<HealthAssessType> list = selectHealthAssessTypeList(queryInfo);
        
        if (!Tools.isNotEmptyList(list)) {
            return healthAssessTypeMap;
        }
        for (HealthAssessType healthAssessType : list) {
            if (healthAssessType.getHealthAssessTypeId().length() < healthAssessTypeFirstLen) {
                continue;
            }
            String healthAssessTypeId = healthAssessType.getHealthAssessTypeId();
            String firstHealthAssessTypeId = healthAssessTypeId.substring(healthAssessTypeFirstLen);
            
            List<Map<String,String>> secondHealthAssessTypeList =  healthAssessTypeMap.get(firstHealthAssessTypeId);
            
            if (null == secondHealthAssessTypeList) {
                secondHealthAssessTypeList = new ArrayList<Map<String,String>>();
            }
            Map<String,String> secondHealthAssessTypeMap = new HashMap<String,String>();
            secondHealthAssessTypeMap.put(healthAssessTypeId, healthAssessType.getHealthAssessTypeName());
            secondHealthAssessTypeList.add(secondHealthAssessTypeMap);
            healthAssessTypeMap.put(firstHealthAssessTypeId, secondHealthAssessTypeList);
        }
        
        return healthAssessTypeMap;
    }
    
    
}