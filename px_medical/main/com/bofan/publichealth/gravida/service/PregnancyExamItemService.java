package com.bofan.publichealth.gravida.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.gravida.command.PregnancyExamItemQueryInfo;
import com.bofan.publichealth.gravida.valueobject.PregnancyExamItem;
import com.bofan.utils.Tools;

/**
 * @Description:孕妇辅助检查项目表 Service
 * @author lqw
 */
@Service
@Transactional
public class PregnancyExamItemService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询孕妇辅助检查项目表 列表
     * @param queryInfo PregnancyExamItemQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PregnancyExamItem> selectPregnancyExamItemList(PregnancyExamItemQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询孕妇辅助检查项目表
     * @param queryInfo PregnancyExamItemQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public PregnancyExamItem findPregnancyExamItem(PregnancyExamItemQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<PregnancyExamItem> list = super.executeSql(qo.getQueryString(),qo.getParam());
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 查询所有 孕妇辅助检查项目 的 map集合
     * @return
     */
    public Map<String,List<PregnancyExamItem>> selectExamItemTypeMap(){
        Map<String,List<PregnancyExamItem>> pegnancyExamItemTypeMap = new HashMap<String,List<PregnancyExamItem>>();
        List<PregnancyExamItem> list  = this.selectPregnancyExamItemList(new PregnancyExamItemQueryInfo());
        if (Tools.isNotEmptyList(list)) {
            for (PregnancyExamItem pregnancyExamItem : list) {
                String examItemType = pregnancyExamItem.getExamItemType();
                List<PregnancyExamItem> pregnancyExamItemList = pegnancyExamItemTypeMap.get(examItemType);
                if (Tools.isNotEmptyList(pregnancyExamItemList)) {
                    pregnancyExamItemList.add(pregnancyExamItem);
                    pegnancyExamItemTypeMap.put(examItemType, pregnancyExamItemList);
                    continue;
                }
                pregnancyExamItemList = new ArrayList<PregnancyExamItem>();
                pregnancyExamItemList.add(pregnancyExamItem);
                pegnancyExamItemTypeMap.put(examItemType, pregnancyExamItemList);
            }
        }
        return pegnancyExamItemTypeMap;
    }
    
}