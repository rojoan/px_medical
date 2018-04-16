package com.bofan.publichealth.gravida.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.gravida.command.GravidaAuxExamEditInfo;
import com.bofan.publichealth.gravida.command.GravidaAuxExamQueryInfo;
import com.bofan.publichealth.gravida.command.GravidaExamItemEditInfo;
import com.bofan.publichealth.gravida.command.GravidaExamItemQueryInfo;
import com.bofan.publichealth.gravida.command.GravidaHealthGuideEditInfo;
import com.bofan.publichealth.gravida.command.GravidaHealthGuideQueryInfo;
import com.bofan.publichealth.gravida.command.GravidaPregnancyEditInfo;
import com.bofan.publichealth.gravida.command.GravidaPregnancyQueryInfo;
import com.bofan.publichealth.gravida.command.PregnancyFirstExamEditInfo;
import com.bofan.publichealth.gravida.command.PregnancyFirstExamQueryInfo;
import com.bofan.publichealth.gravida.valueobject.GravidaAuxExam;
import com.bofan.publichealth.gravida.valueobject.GravidaExamItem;
import com.bofan.publichealth.gravida.valueobject.GravidaHealthGuide;
import com.bofan.publichealth.gravida.valueobject.GravidaPregnancy;
import com.bofan.publichealth.gravida.valueobject.PregnancyFirstExam;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * @Description: 孕妇孕前体检业务
 * @author lqw
 */
@Service
@Transactional
public class PregnancyFirstExamService extends AbstractAnnoCommonService {

    @Autowired
    private GravidaPregnancyService gravidaPregnancyService;
    @Autowired
    private GravidaExamItemService gravidaExamItemService;
    @Autowired
    private GravidaAuxExamService gravidaAuxExamService;
    @Autowired
    private GravidaHealthGuideService gravidaHealthGuideService;
   
    /**
     * 根据条件查询孕妇孕前体检分页记录
     * @param info
     * @return
     */
    public Page selectPregnancyFirstExamPage(PregnancyFirstExamQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
    }

    /**
     * 根据条件查询孕妇孕前体检列表
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PregnancyFirstExam> selectPregnancyFirstExamList(PregnancyFirstExamQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 根据条件查询孕妇孕前体检记录
     * @param queryInfo
     * @return
     */
    public PregnancyFirstExam findPregnancyFirstExam(PregnancyFirstExamQueryInfo queryInfo) {
        List<PregnancyFirstExam> list = selectPregnancyFirstExamList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 保存孕妇孕前体检
     */
    @SuppressWarnings("unchecked")
    public PregnancyFirstExam savePregnancyFirstExam(String pregnancyFirstExamRetionData) {
        // 获取参数
        JSONObject data = JSONObject.parseObject(pregnancyFirstExamRetionData);
        String pregnancyFirstExamEditInfoJson = data.getString("pregnancyFirstExamEditInfo");
        String gravidaPregnancyEditInfoListJson = data.getString("gravidaPregnancyEditInfoList");
        String gravidaExamItemEditInfoListJson = data.getString("gravidaExamItemEditInfoList");
        String gravidaAuxExamEditInfoListJson = data.getString("gravidaAuxExamEditInfoList");
        String gravidaHealthGuideEditInfoListJson = data.getString("gravidaHealthGuideEditInfoList");
        
        PregnancyFirstExamEditInfo pregnancyFirstExamEditInfo = JSON.parseObject(pregnancyFirstExamEditInfoJson, PregnancyFirstExamEditInfo.class);
        List<JSONObject> gravidaPregnancyEditInfoList = JSON.parseObject(gravidaPregnancyEditInfoListJson, List.class);
        List<JSONObject> gravidaExamItemEditInfoList = JSON.parseObject(gravidaExamItemEditInfoListJson, List.class);
        List<JSONObject> gravidaAuxExamEditInfoList = JSON.parseObject(gravidaAuxExamEditInfoListJson, List.class);
        List<JSONObject> gravidaHealthGuideEditInfoList = JSON.parseObject(gravidaHealthGuideEditInfoListJson, List.class);

        // 设置
        PregnancyFirstExam pregnancyFirstExam = null;
        if (null != pregnancyFirstExamEditInfo.getPregnancyFirstExamId()) {
            pregnancyFirstExam = super.selectAObject(PregnancyFirstExam.class, pregnancyFirstExamEditInfo.getPregnancyFirstExamId());
            NullBeanUtils.copyProperties(pregnancyFirstExam, pregnancyFirstExamEditInfo);
        } else {
            pregnancyFirstExam = new PregnancyFirstExam();
            NullBeanUtils.copyProperties(pregnancyFirstExam, pregnancyFirstExamEditInfo);
            pregnancyFirstExam.setCurExamTime(new Date());
        }
        
        // 保存
        super.save(pregnancyFirstExam);
        Long pregnancyFirstExamId = pregnancyFirstExam.getPregnancyFirstExamId();
        //保存或者更新 孕早期情况
        this.saveOrUpdateGravidaPregnancyList(gravidaPregnancyEditInfoList,pregnancyFirstExamId);
        //保存或者更新 孕妇检查项目情况
        this.saveOrUpdateGravidaExamItemList(gravidaExamItemEditInfoList,pregnancyFirstExamId);
        //保存或者更新 孕妇辅助检查项目情况
        this.saveOrUpdateGravidaAuxExamList(gravidaAuxExamEditInfoList,pregnancyFirstExamId);
        //更新或保存  孕妇保健指导表
        this.saveOrUpdateGravidaHealthGuideList(gravidaHealthGuideEditInfoList,pregnancyFirstExamId);
        
        return pregnancyFirstExam;
    } 
    
    /**
     * 更新或保存  孕妇保健指导表
     * @param gravidaHealthGuideEditInfoList
     * @param pregnancyFirstExamId
     */
    @SuppressWarnings("rawtypes")
    private void saveOrUpdateGravidaHealthGuideList(List<JSONObject> gravidaHealthGuideEditInfoList, Long pregnancyFirstExamId) {
        Iterator<GravidaHealthGuide> gravidaHealthGuideIt = this.gravidaHealthGuideService.selectGravidaHealthGuideList(
                new GravidaHealthGuideQueryInfo(pregnancyFirstExamId,null)).iterator();
         
        // 如果页面传参不存在既往史，则删除已有的数据
        if (!Tools.isNotEmptyList(gravidaHealthGuideEditInfoList)) { 
            while ( gravidaHealthGuideIt.hasNext()) {
                GravidaHealthGuide gravidaHealthGuide = (GravidaHealthGuide) gravidaHealthGuideIt.next();
                super.delete(gravidaHealthGuide); 
            }
            return ;
        }  
        
        // 如果页面传参存在关联关系，则更新关联关系 
        Map<String,GravidaHealthGuide> gravidaHealthGuideMap = new HashMap<String,GravidaHealthGuide>();
        
        while (gravidaHealthGuideIt.hasNext()) {  
            GravidaHealthGuide gravidaHealthGuideItem = (GravidaHealthGuide) gravidaHealthGuideIt.next();
            gravidaHealthGuideMap.put(gravidaHealthGuideItem.getHealthGuideType(), gravidaHealthGuideItem);
        }
        
        for (JSONObject gravidaHealthGuideEditInfoJson : gravidaHealthGuideEditInfoList) {
            GravidaHealthGuideEditInfo editInfo = JSON.parseObject(gravidaHealthGuideEditInfoJson.toJSONString(), GravidaHealthGuideEditInfo.class);
            if (gravidaHealthGuideMap.containsKey(editInfo.getHealthGuideType())) {
                GravidaHealthGuide oldGravidaHealthGuide = gravidaHealthGuideMap.get(editInfo.getHealthGuideType());
                editInfo.setPregnancyFirstExamId(pregnancyFirstExamId);
                NullBeanUtils.copyProperties(oldGravidaHealthGuide, editInfo);
                super.save(oldGravidaHealthGuide);
                gravidaHealthGuideMap.remove(editInfo.getHealthGuideType());
            } else {
                //不包含则需要新增
                GravidaHealthGuide newGravidaHealthGuide = new GravidaHealthGuide();
                NullBeanUtils.copyProperties(newGravidaHealthGuide, editInfo);
                newGravidaHealthGuide.setPregnancyFirstExamId(pregnancyFirstExamId);
                newGravidaHealthGuide.setCurCreateTime(new Date());
                super.save(newGravidaHealthGuide);
            }
        }
        
        //删除页面已删除的既往史
        if (Tools.isNotEmptyMap(gravidaHealthGuideMap)) {
            Iterator it = gravidaHealthGuideMap.entrySet().iterator();
            while (it.hasNext()) {
                super.delete((GravidaHealthGuide) ((Map.Entry) it.next()).getValue());
            }
        }
    }

    /**
     * 保存或者更新 孕妇辅助检查项目情况
     * @param gravidaAuxExamEditInfoList
     * @param pregnancyFirstExamId
     */
    @SuppressWarnings("rawtypes")
    private void saveOrUpdateGravidaAuxExamList(List<JSONObject> gravidaAuxExamEditInfoList, Long pregnancyFirstExamId) {
        Iterator<GravidaAuxExam> gravidaAuxExamIt = this.gravidaAuxExamService.selectGravidaAuxExamList(
                new GravidaAuxExamQueryInfo(pregnancyFirstExamId)).iterator();
         
        // 如果页面传参不存在既往史，则删除已有的数据
        if (!Tools.isNotEmptyList(gravidaAuxExamEditInfoList)) { 
            while ( gravidaAuxExamIt.hasNext()) {
                GravidaAuxExam gravidaAuxExam = (GravidaAuxExam) gravidaAuxExamIt.next();
                super.delete(gravidaAuxExam); 
            }
            return ;
        }  
        
        // 如果页面传参存在关联关系，则更新关联关系 
        Map<Long,GravidaAuxExam> gravidaAuxExamMap = new HashMap<Long,GravidaAuxExam>();
        
        while (gravidaAuxExamIt.hasNext()) {  
            GravidaAuxExam gravidaAuxExamItem = (GravidaAuxExam) gravidaAuxExamIt.next();
            gravidaAuxExamMap.put(gravidaAuxExamItem.getGravidaAuxExamId(), gravidaAuxExamItem);
        }
        
        for (JSONObject gravidaAuxExamEditInfoJson : gravidaAuxExamEditInfoList) {
            GravidaAuxExamEditInfo editInfo = JSON.parseObject(gravidaAuxExamEditInfoJson.toJSONString(), GravidaAuxExamEditInfo.class);
            if (gravidaAuxExamMap.containsKey(editInfo.getGravidaAuxExamId())) {
                GravidaAuxExam oldGravidaAuxExam = gravidaAuxExamMap.get(editInfo.getGravidaAuxExamId());
                NullBeanUtils.copyProperties(oldGravidaAuxExam, editInfo);
                super.save(oldGravidaAuxExam);
                gravidaAuxExamMap.remove(editInfo.getGravidaAuxExamId());
            } else {
                //不包含则需要新增
                GravidaAuxExam newGravidaAuxExam = new GravidaAuxExam();
                NullBeanUtils.copyProperties(newGravidaAuxExam, editInfo);
                newGravidaAuxExam.setPregnancyFirstExamId(pregnancyFirstExamId);
                newGravidaAuxExam.setCurCreateTime(new Date());
                super.save(newGravidaAuxExam);
            }
        }
        
        //删除页面已删除的既往史
        if (Tools.isNotEmptyMap(gravidaAuxExamMap)) {
            Iterator it = gravidaAuxExamMap.entrySet().iterator();
            while (it.hasNext()) {
                super.delete((GravidaAuxExam) ((Map.Entry) it.next()).getValue());
            }
        }
    }

    /**
     * 保存或者更新 孕妇检查项目情况
     * @param gravidaExamItemEditInfoList
     * @param pregnancyFirstExamId
     */
    @SuppressWarnings("rawtypes")
    private void saveOrUpdateGravidaExamItemList(List<JSONObject> gravidaExamItemEditInfoList, Long pregnancyFirstExamId) {
        Iterator<GravidaExamItem> gravidaExamItemIt = this.gravidaExamItemService.selectGravidaExamItemList(
                new GravidaExamItemQueryInfo(pregnancyFirstExamId)).iterator();
         
        // 如果页面传参不存在既往史，则删除已有的数据
        if (!Tools.isNotEmptyList(gravidaExamItemEditInfoList)) { 
            while ( gravidaExamItemIt.hasNext()) {
                GravidaExamItem gravidaExamItem = (GravidaExamItem) gravidaExamItemIt.next();
                super.delete(gravidaExamItem); 
            }
            return ;
        }  
        
        // 如果页面传参存在关联关系，则更新关联关系 
        Map<Long,GravidaExamItem> gravidaExamItemMap = new HashMap<Long,GravidaExamItem>();
        
        while (gravidaExamItemIt.hasNext()) {  
            GravidaExamItem gravidaExamItemItem = (GravidaExamItem) gravidaExamItemIt.next();
            gravidaExamItemMap.put(gravidaExamItemItem.getGravidaExamItemId(), gravidaExamItemItem);
        }
        
        for (JSONObject gravidaExamItemEditInfoJson : gravidaExamItemEditInfoList) {
            GravidaExamItemEditInfo editInfo = JSON.parseObject(gravidaExamItemEditInfoJson.toJSONString(), GravidaExamItemEditInfo.class);
            if (gravidaExamItemMap.containsKey(editInfo.getGravidaExamItemId())) {
                GravidaExamItem oldGravidaExamItem = gravidaExamItemMap.get(editInfo.getGravidaExamItemId());
                NullBeanUtils.copyProperties(oldGravidaExamItem, editInfo);
                super.save(oldGravidaExamItem);
                gravidaExamItemMap.remove(editInfo.getGravidaExamItemId());
            } else {
                //不包含则需要新增
                GravidaExamItem newGravidaExamItem = new GravidaExamItem();
                NullBeanUtils.copyProperties(newGravidaExamItem, editInfo);
                newGravidaExamItem.setPregnancyFirstExamId(pregnancyFirstExamId);
                newGravidaExamItem.setCurCreateTime(new Date());
                super.save(newGravidaExamItem);
            }
        }
        
        //删除页面已删除的既往史
        if (Tools.isNotEmptyMap(gravidaExamItemMap)) {
            Iterator it = gravidaExamItemMap.entrySet().iterator();
            while (it.hasNext()) {
                super.delete((GravidaExamItem) ((Map.Entry) it.next()).getValue());
            }
        }
    }

    /**
     * 保存或者更新 孕早期情况
     * @param gravidaPregnancyEditInfoList
     * @param pregnancyFirstExamId
     */
    @SuppressWarnings("rawtypes")
    private void saveOrUpdateGravidaPregnancyList(List<JSONObject> gravidaPregnancyEditInfoList, Long pregnancyFirstExamId) {
        Iterator<GravidaPregnancy> gravidaPregnancyIt = this.gravidaPregnancyService.selectGravidaPregnancyList(
                new GravidaPregnancyQueryInfo(pregnancyFirstExamId)).iterator();
         
        // 如果页面传参不存在既往史，则删除已有的数据
        if (!Tools.isNotEmptyList(gravidaPregnancyEditInfoList)) { 
            while ( gravidaPregnancyIt.hasNext()) {
                GravidaPregnancy gravidaPregnancy = (GravidaPregnancy) gravidaPregnancyIt.next();
                super.delete(gravidaPregnancy); 
            }
            return ;
        }  
        
        // 如果页面传参存在关联关系，则更新关联关系 
        Map<Long,GravidaPregnancy> gravidaPregnancyMap = new HashMap<Long,GravidaPregnancy>();
        
        while (gravidaPregnancyIt.hasNext()) {  
            GravidaPregnancy gravidaPregnancyItem = (GravidaPregnancy) gravidaPregnancyIt.next();
            gravidaPregnancyMap.put(gravidaPregnancyItem.getPregnancyCaseId(), gravidaPregnancyItem);
        }
        
        for (JSONObject gravidaPregnancyEditInfoJson : gravidaPregnancyEditInfoList) {
            GravidaPregnancyEditInfo editInfo = JSON.parseObject(gravidaPregnancyEditInfoJson.toJSONString(), GravidaPregnancyEditInfo.class);
            if (gravidaPregnancyMap.containsKey(editInfo.getPregnancyCaseId())) {
                gravidaPregnancyMap.remove(editInfo.getPregnancyCaseId());
            } else {
                //不包含则需要新增
                GravidaPregnancy newGravidaPregnancy = new GravidaPregnancy();
                NullBeanUtils.copyProperties(newGravidaPregnancy, editInfo);
                newGravidaPregnancy.setPregnancyFirstExamId(pregnancyFirstExamId);
                super.save(newGravidaPregnancy);
            }
        }
        
        //删除页面已删除的既往史
        if (Tools.isNotEmptyMap(gravidaPregnancyMap)) {
            Iterator it = gravidaPregnancyMap.entrySet().iterator();
            while (it.hasNext()) {
                super.delete((GravidaPregnancy) ((Map.Entry) it.next()).getValue());
            }
        }
    }
    
    public void delPregnancyFirstExam(Long pregnancyFirstExamId) {
        //删除 孕产妇初次孕检记录
        PregnancyFirstExam  pregnancyFirstExam = super.selectAObject(PregnancyFirstExam.class, pregnancyFirstExamId);
        super.delete(pregnancyFirstExam); 
        
        //删除 孕妇孕早期情况对照表
        List<GravidaPregnancy>  gravidaPregnancyList = this.gravidaPregnancyService.selectGravidaPregnancyList( new GravidaPregnancyQueryInfo(pregnancyFirstExamId));
        if (Tools.isNotEmptyList(gravidaPregnancyList)) {
            super.deleteAll(gravidaPregnancyList);
        }
        //删除  孕妇孕检项目情况对照表
        List<GravidaExamItem> gravidaExamItemList = this.gravidaExamItemService.selectGravidaExamItemList(
                new GravidaExamItemQueryInfo(pregnancyFirstExamId));
        if (Tools.isNotEmptyList(gravidaExamItemList)) {
            super.deleteAll(gravidaExamItemList);
        }
        //删除  孕妇孕检辅助检查项目情况对照表
        List<GravidaAuxExam> gravidaAuxExamList = this.gravidaAuxExamService.selectGravidaAuxExamList(
                new GravidaAuxExamQueryInfo(pregnancyFirstExamId));
        if (Tools.isNotEmptyList(gravidaAuxExamList)) {
            super.deleteAll(gravidaAuxExamList);
        }
        //删除  孕妇保健指导表
        List<GravidaHealthGuide> gravidaHealthGuideList = this.gravidaHealthGuideService.selectGravidaHealthGuideList(
                new GravidaHealthGuideQueryInfo(pregnancyFirstExamId,null));
        if (Tools.isNotEmptyList(gravidaHealthGuideList)) {
            super.deleteAll(gravidaHealthGuideList);
        }
    }

}
