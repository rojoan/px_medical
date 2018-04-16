package com.bofan.publichealth.elder.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.controller.ElderHealthAssessItemEditInfo;
import com.bofan.publichealth.elder.command.ElderHealthAssessEditInfo;
import com.bofan.publichealth.elder.command.ElderHealthAssessItemQueryInfo;
import com.bofan.publichealth.elder.command.ElderHealthAssessQueryInfo;
import com.bofan.publichealth.elder.valueobject.ElderHealthAssess;
import com.bofan.publichealth.elder.valueobject.ElderHealthAssessItem;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * @Description: 老年人健康评估结果 Service
 * @author lqw
 */
@Service
@Transactional
public class ElderHealthAssessService extends AbstractAnnoCommonService {

    @Autowired
    private ElderHealthAssessItemService elderHealthAssessItemService;
    
    
    /**
     * 根据条件查询 老年人健康评估结果 列表
     * @param queryInfo ElderHealthAssessQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<ElderHealthAssess> selectElderHealthAssessList(ElderHealthAssessQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询 老年人健康评估结果
     * @param queryInfo ElderHealthAssessQueryInfo
     * @return
     */
    public ElderHealthAssess findElderHealthAssess(ElderHealthAssessQueryInfo queryInfo) {
        List<ElderHealthAssess> list = selectElderHealthAssessList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 保存 老年人健康评估结果
     * @param postpartumVisitEditInfo
     */
    @SuppressWarnings("unchecked")
    public void saveElderHealthAssess(String elderHealthAssessRetionData) {
        JSONObject data = JSONObject.parseObject(elderHealthAssessRetionData);
        String elderHealthAssessEditInfoJson =  data.getString("elderHealthAssessEditInfo");
        String healthAssessTypeItemEditInfoListJson =  data.getString("healthAssessTypeItemEditInfoList");
        ElderHealthAssessEditInfo elderHealthAssessEditInfo =  JSON.parseObject(elderHealthAssessEditInfoJson, ElderHealthAssessEditInfo.class);
        List<JSONObject> healthAssessTypeItemEditInfoList = JSON.parseObject(healthAssessTypeItemEditInfoListJson, List.class);
        
        
        ElderHealthAssess elderHealthAssess = null;
        if (null != elderHealthAssessEditInfo.getElderHealthAssessId()) {
            elderHealthAssess = super.selectAObject(ElderHealthAssess.class, elderHealthAssessEditInfo.getElderHealthAssessId());
            NullBeanUtils.copyProperties(elderHealthAssess, elderHealthAssessEditInfo);
        } else {
            elderHealthAssess = new ElderHealthAssess();
            NullBeanUtils.copyProperties(elderHealthAssess, elderHealthAssessEditInfo);
        }
        // 保存
        super.save(elderHealthAssess);
        this.saveOrUpdateElderHealthAssessItemItem(healthAssessTypeItemEditInfoList,elderHealthAssess);
    }

    /**
     * 保存或者 新增 老年人健康评估结果明细表
     * @param healthAssessTypeItemEditInfoList
     * @param elderHealthAssess
     */
    @SuppressWarnings("rawtypes")
    private void saveOrUpdateElderHealthAssessItemItem(List<JSONObject> healthAssessTypeItemEditInfoList, ElderHealthAssess elderHealthAssess) {
        Iterator<ElderHealthAssessItem> personExposeDisIt = this.elderHealthAssessItemService.selectElderHealthAssessItemList(
                new ElderHealthAssessItemQueryInfo(elderHealthAssess.getElderHealthAssessId())) .iterator(); 
        if (!Tools.isNotEmptyList(healthAssessTypeItemEditInfoList)) { 
            // 如果页面传参不存在既往史，则删除已有的数据
            while ( personExposeDisIt.hasNext()) {
                ElderHealthAssessItem ElderHealthAssessItemDisease = (ElderHealthAssessItem) personExposeDisIt.next();
                super.delete(ElderHealthAssessItemDisease); 
            }
        } else {
            // 如果页面传参存在关联关系，则更新关联关系 
            Map<Long,ElderHealthAssessItem> elderHealthAssessItemMap = new HashMap<Long,ElderHealthAssessItem>();
            
            while (personExposeDisIt.hasNext()) {  
                ElderHealthAssessItem personExposeDisItem = (ElderHealthAssessItem) personExposeDisIt.next();
                elderHealthAssessItemMap.put(personExposeDisItem.getElderHealthAssessItemId(), personExposeDisItem);
            }
            for (JSONObject exposeDiseaseEditInfoJson : healthAssessTypeItemEditInfoList) {
                ElderHealthAssessItemEditInfo editInfo = JSON.parseObject(exposeDiseaseEditInfoJson.toJSONString(), ElderHealthAssessItemEditInfo.class);
                if (elderHealthAssessItemMap.containsKey(editInfo.getElderHealthAssessItemId())) {
                    elderHealthAssessItemMap.remove(editInfo.getElderHealthAssessItemId());
                } else {
                    //不包含则需要新增
                    ElderHealthAssessItem newElderHealthAssessItem = new ElderHealthAssessItem();
                    NullBeanUtils.copyProperties(newElderHealthAssessItem, editInfo);
                    newElderHealthAssessItem.setAssessTime(elderHealthAssess.getAssessTime());
                    newElderHealthAssessItem.setElderHealthAssessId(elderHealthAssess.getElderHealthAssessId());
                    newElderHealthAssessItem.setHospitalId(elderHealthAssess.getHospitalId());
                    newElderHealthAssessItem.setPersonDetailId(elderHealthAssess.getPersonDetailId());
                    newElderHealthAssessItem.setRegionId(elderHealthAssess.getRegionId());
                    super.save(newElderHealthAssessItem);
                }
            }
            
            //删除页面已删除的既往史
            if (Tools.isNotEmptyMap(elderHealthAssessItemMap)) {
                Iterator it = elderHealthAssessItemMap.entrySet().iterator();
                while (it.hasNext()) {
                    super.delete((ElderHealthAssessItem) ((Map.Entry) it.next()).getValue());
                }
            }
        }
        
    }
    

    /**
     * 根据条件查询 HealthAssessItem 的 key为健康评估项目ID ，value为老年人健康评估明细ID 的map
     * @param queryInfo
     * @return
     */
    public Map<Long,Long> selectHealthAssessItemIdMap(ElderHealthAssessItemQueryInfo queryInfo){
        Map<Long,Long> healthAssessItemIdMap = new HashMap<Long,Long>();
        List<ElderHealthAssessItem>  list =  this.elderHealthAssessItemService.selectElderHealthAssessItemList(queryInfo);
        if (!Tools.isNotEmptyList(list)) {
            return healthAssessItemIdMap;
        }
        
        for (ElderHealthAssessItem elderHealthAssessItem : list) {
            healthAssessItemIdMap.put(elderHealthAssessItem.getHealthAssessItemId(), elderHealthAssessItem.getElderHealthAssessItemId());
        }
        return healthAssessItemIdMap;
    }

    /**
     * 删除 老年人健康评估 相关表
     * @param elderHealthAssessId
     */
    public void delElderHealthAssess(Long elderHealthAssessId) {
        
        // 删除  老年人健康评估结果明细表
        List<ElderHealthAssessItem>  elderHealthAssessItemList =  
                this.elderHealthAssessItemService.selectElderHealthAssessItemList(new ElderHealthAssessItemQueryInfo(elderHealthAssessId));
        if (Tools.isNotEmptyList(elderHealthAssessItemList)) {
            super.deleteAll(elderHealthAssessItemList);
        }
        
        //删除 老年人健康评估结果主表
        ElderHealthAssess elderHealthAssess = super.selectAObject(ElderHealthAssess.class,elderHealthAssessId);
        super.delete(elderHealthAssess);
        
    }
    
 
   
    
}