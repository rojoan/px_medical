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
import com.bofan.publichealth.gravida.command.GravidaHealthGuideEditInfo;
import com.bofan.publichealth.gravida.command.GravidaHealthGuideQueryInfo;
import com.bofan.publichealth.gravida.command.PregnancyExamEditInfo;
import com.bofan.publichealth.gravida.command.PregnancyExamQueryInfo;
import com.bofan.publichealth.gravida.valueobject.GravidaDetail;
import com.bofan.publichealth.gravida.valueobject.GravidaHealthGuide;
import com.bofan.publichealth.gravida.valueobject.PregnancyExam;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * @Description:孕期检查记录 Service
 * @author lqw
 */
@Service
@Transactional
public class PregnancyExamService extends AbstractAnnoCommonService {
    @Autowired
    private GravidaHealthGuideService gravidaHealthGuideService;
    
    /**
     * 根据条件查询孕期检查记录 分页列表
     * @param queryInfo
     * @return
     */
    public Page selectPregnancyExamPage(PregnancyExamQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 根据条件查询孕期检查记录 列表
     * @param queryInfo PregnancyExamQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PregnancyExam> selectPregnancyExamList(PregnancyExamQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询孕期检查记录
     * @param queryInfo PregnancyExamQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public PregnancyExam findPregnancyExam(PregnancyExamQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<PregnancyExam> list = super.executeSql(qo.getQueryString(),qo.getParam());
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 孕期检查记录表
     * @param pregnancyExamRetionData
     */
    @SuppressWarnings("unchecked")
    public void savePregnancyExam(String pregnancyExamRetionData) {
        JSONObject data = JSONObject.parseObject(pregnancyExamRetionData);
        String pregnancyExamEditInfoJson = data.getString("pregnancyExamEditInfo");
        String gravidaHealthGuideEditInfoListJson = data.getString("gravidaHealthGuideEditInfoList");
        
        PregnancyExamEditInfo pregnancyExamEditInfo = JSON.parseObject(pregnancyExamEditInfoJson, PregnancyExamEditInfo.class);
        List<JSONObject> gravidaHealthGuideEditInfoList = JSON.parseObject(gravidaHealthGuideEditInfoListJson, List.class);
        
        PregnancyExam pregnancyExam = null;
        if(null != pregnancyExamEditInfo.getPregnancyExamId()) {
            pregnancyExam = super.selectAObject(PregnancyExam.class, pregnancyExamEditInfo.getPregnancyExamId());
        } else {
            // 新增
            pregnancyExam = new PregnancyExam();
            pregnancyExam.setCurExamTime(new Date()); 
        }
        NullBeanUtils.copyProperties(pregnancyExam, pregnancyExamEditInfo);
        super.save(pregnancyExam);
        
        //关联修改 孕妇登记卡的  是否高危 标识
        updateGravidaDetailHighRisk(pregnancyExamEditInfo.getGravidaDetailId(), pregnancyExam);
        //更新或保存  孕妇保健指导表
        this.saveOrUpdateGravidaHealthGuideList(gravidaHealthGuideEditInfoList,pregnancyExam.getPregnancyExamId());
        
    }
    
    /**
     * 更新或保存  孕妇保健指导表
     * @param gravidaHealthGuideEditInfoList
     * @param pregnancyExamId
     */
    @SuppressWarnings("rawtypes")
    private void saveOrUpdateGravidaHealthGuideList(List<JSONObject> gravidaHealthGuideEditInfoList, Long pregnancyExamId) {
        Iterator<GravidaHealthGuide> gravidaHealthGuideIt = this.gravidaHealthGuideService.selectGravidaHealthGuideList(
                new GravidaHealthGuideQueryInfo(null,pregnancyExamId)).iterator();
         
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
                editInfo.setPregnancyExamId(pregnancyExamId);
                NullBeanUtils.copyProperties(oldGravidaHealthGuide, editInfo);
                super.save(oldGravidaHealthGuide);
                gravidaHealthGuideMap.remove(editInfo.getHealthGuideType());
            } else {
                //不包含则需要新增
                GravidaHealthGuide newGravidaHealthGuide = new GravidaHealthGuide();
                NullBeanUtils.copyProperties(newGravidaHealthGuide, editInfo);
                newGravidaHealthGuide.setPregnancyExamId(pregnancyExamId);
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
     * 关联修改 孕妇登记卡的  是否高危 标识
     * @param pregnancyExamEditInfo
     * @param pregnancyExam
     */
    private void updateGravidaDetailHighRisk(Long gravidaDetailId, PregnancyExam pregnancyExam) {
        if (Contstants.YES_FLAG.equals(pregnancyExam.getHighRiskPregnancy())) {
            GravidaDetail gravidaDetail = super.selectAObject(GravidaDetail.class, gravidaDetailId);
            if (!Contstants.YES_FLAG.equals(gravidaDetail.getHighRiskPregnancy())) {
                gravidaDetail.setHighRiskPregnancy(Contstants.YES_FLAG);
                super.save(gravidaDetail);
            }
        }
    }
    
}