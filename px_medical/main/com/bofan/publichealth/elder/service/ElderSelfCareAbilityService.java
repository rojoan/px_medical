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
import com.bofan.publichealth.elder.command.ElderSelfCareAbilityEditInfo;
import com.bofan.publichealth.elder.command.ElderSelfCareAbilityQueryInfo;
import com.bofan.publichealth.elder.command.ElderSelfCareItemEditInfo;
import com.bofan.publichealth.elder.command.ElderSelfCareItemQueryInfo;
import com.bofan.publichealth.elder.command.SelfCareAbilityQueryInfo;
import com.bofan.publichealth.elder.valueobject.ElderSelfCareAbility;
import com.bofan.publichealth.elder.valueobject.ElderSelfCareItem;
import com.bofan.publichealth.elder.valueobject.SelfCareAbility;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * @Description: 老年人自理能力评估主表 Service
 * @author lqw
 */
@Service
@Transactional
public class ElderSelfCareAbilityService extends AbstractAnnoCommonService {

    @Autowired
    private ElderSelfCareItemService elderSelfCareItemService;
    
    /**
     * 根据条件查询 老年人自理能力评估主表 列表
     * @param queryInfo ElderSelfCareAbilityQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<ElderSelfCareAbility> selectElderSelfCareAbilityList(ElderSelfCareAbilityQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询 老年人自理能力评估主表
     * @param queryInfo ElderSelfCareAbilityQueryInfo
     * @return
     */
    public ElderSelfCareAbility findElderSelfCareAbility(ElderSelfCareAbilityQueryInfo queryInfo) {
        List<ElderSelfCareAbility> list = selectElderSelfCareAbilityList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public void saveElderSelfCareAbility(String elderSelfCareAbilityRetionData) {
        JSONObject data = JSONObject.parseObject(elderSelfCareAbilityRetionData);
        String elderSelfCareAbilityEditInfoJson =  data.getString("elderSelfCareAbilityEditInfo");
        String elderSelfCareItemEditInfoListJson =  data.getString("elderSelfCareItemEditInfoList");
        ElderSelfCareAbilityEditInfo elderSelfCareAbilityEditInfo =  JSON.parseObject(elderSelfCareAbilityEditInfoJson, ElderSelfCareAbilityEditInfo.class);
        List<JSONObject> elderSelfCareItemEditInfoList = JSON.parseObject(elderSelfCareItemEditInfoListJson, List.class);
        
        
        ElderSelfCareAbility elderSelfCareAbility = null;
        if (null != elderSelfCareAbilityEditInfo.getElderSelfCareAbilityId()) {
            elderSelfCareAbility = super.selectAObject(ElderSelfCareAbility.class, elderSelfCareAbilityEditInfo.getElderSelfCareAbilityId());
            NullBeanUtils.copyProperties(elderSelfCareAbility, elderSelfCareAbilityEditInfo);
        } else {
            elderSelfCareAbility = new ElderSelfCareAbility();
            NullBeanUtils.copyProperties(elderSelfCareAbility, elderSelfCareAbilityEditInfo);
        }
        // 保存
        super.save(elderSelfCareAbility);
        this.saveOrUpdateElderSelfCareItem(elderSelfCareItemEditInfoList,elderSelfCareAbility);
        
    }

    /**
     * 新增或者 修改 老年人自理能力评估明细
     * @param elderSelfCareItemEditInfoList
     * @param elderSelfCareAbility
     */
    @SuppressWarnings("rawtypes")
    private void saveOrUpdateElderSelfCareItem(List<JSONObject> elderSelfCareItemEditInfoList, ElderSelfCareAbility elderSelfCareAbility) {
        Iterator<ElderSelfCareItem> personExposeDisIt = this.elderSelfCareItemService.selectElderSelfCareItemList(
                new ElderSelfCareItemQueryInfo(elderSelfCareAbility.getElderSelfCareAbilityId())) .iterator(); 
        if (!Tools.isNotEmptyList(elderSelfCareItemEditInfoList)) { 
            // 如果页面传参不存在既往史，则删除已有的数据
            while ( personExposeDisIt.hasNext()) {
                ElderSelfCareItem ElderSelfCareItemDisease = (ElderSelfCareItem) personExposeDisIt.next();
                super.delete(ElderSelfCareItemDisease); 
            }
        } else {
            // 如果页面传参存在关联关系，则更新关联关系 
            Map<Long,ElderSelfCareItem> elderSelfCareItemMap = new HashMap<Long,ElderSelfCareItem>();
            
            while (personExposeDisIt.hasNext()) {  
                ElderSelfCareItem personExposeDisItem = (ElderSelfCareItem) personExposeDisIt.next();
                elderSelfCareItemMap.put(personExposeDisItem.getElderSelfCareItemId(), personExposeDisItem);
            }
            for (JSONObject exposeDiseaseEditInfoJson : elderSelfCareItemEditInfoList) {
                ElderSelfCareItemEditInfo editInfo = JSON.parseObject(exposeDiseaseEditInfoJson.toJSONString(), ElderSelfCareItemEditInfo.class);
                if (elderSelfCareItemMap.containsKey(editInfo.getSelfCareAbilityId())) {
                    elderSelfCareItemMap.remove(editInfo.getSelfCareAbilityId());
                } else {
                    //不包含则需要新增
                    ElderSelfCareItem newElderSelfCareItem = new ElderSelfCareItem();
                    NullBeanUtils.copyProperties(newElderSelfCareItem, editInfo);
                    newElderSelfCareItem.setAssessTime(elderSelfCareAbility.getAssessTime());
                    newElderSelfCareItem.setElderSelfCareAbilityId(elderSelfCareAbility.getElderSelfCareAbilityId());
                    newElderSelfCareItem.setHospitalId(elderSelfCareAbility.getHospitalId());
                    newElderSelfCareItem.setPersonDetailId(elderSelfCareAbility.getPersonDetailId());
                    newElderSelfCareItem.setRegionId(elderSelfCareAbility.getRegionId());
                    super.save(newElderSelfCareItem);
                }
            }
            
            //删除页面已删除的既往史
            if (Tools.isNotEmptyMap(elderSelfCareItemMap)) {
                Iterator it = elderSelfCareItemMap.entrySet().iterator();
                while (it.hasNext()) {
                    super.delete((ElderSelfCareItem) ((Map.Entry) it.next()).getValue());
                }
            }
        }
        
    }

    /**
     * 查询 自理能力评估项目字典表--老年人
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<SelfCareAbility> selectSelfCareAbilityList(SelfCareAbilityQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
 
    /**
     * 获取 老年人自理能力评估明细表  的map
     * @param elderSelfCareAbilityId
     * @return
     */
    public Map<Long,ElderSelfCareItem> selectElderSelfCareItemMap(Long elderSelfCareAbilityId) {
        Map<Long,ElderSelfCareItem> elderSelfCareItemMap = new HashMap<Long,ElderSelfCareItem>();
        List<ElderSelfCareItem>  elderSelfCareItemList  = elderSelfCareItemService.selectElderSelfCareItemList(new ElderSelfCareItemQueryInfo(elderSelfCareAbilityId));
        if (!Tools.isNotEmptyList(elderSelfCareItemList)) {
            return elderSelfCareItemMap;
        }
        for (ElderSelfCareItem elderSelfCareItem : elderSelfCareItemList) {
            elderSelfCareItemMap.put(elderSelfCareItem.getSelfCareAbilityId(), elderSelfCareItem);
        }
        return elderSelfCareItemMap;
    }

    
    /**
     * 删除 老年人自理能力评估 相关表
     * @param elderSelfCareAbilityId
     */
    public void delElderSelfCareAbility(Long elderSelfCareAbilityId) {
        // 删除 老年人自理能力评估明细表
        List<ElderSelfCareItem>  elderSelfCareItemList  = elderSelfCareItemService.selectElderSelfCareItemList(new ElderSelfCareItemQueryInfo(elderSelfCareAbilityId));
        if (Tools.isNotEmptyList(elderSelfCareItemList)) {
            super.deleteAll(elderSelfCareItemList);
        }
        // 删除  老年人自理能力评估主表
        ElderSelfCareAbility lderSelfCareAbility = super.selectAObject(ElderSelfCareAbility.class,elderSelfCareAbilityId);
        super.delete(lderSelfCareAbility);
    }
    
}