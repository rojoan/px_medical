package com.bofan.publichealth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.ChildVisitAdviseIdQueryInfo;
import com.bofan.publichealth.command.ChildVisitAdviseQueryInfo;
import com.bofan.publichealth.valueobject.ChildVisitAdvise;
import com.bofan.utils.Tools;

/**
 * @Description 儿童随访指导情况业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
@Transactional
public class ChildVisitAdviseService extends AbstractAnnoCommonService {

    /**
     * 获取儿童随访指导情况ID
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<Long> selectChildVisitAdviseId(Long childVisitId, Long childDetailId) {
        ChildVisitAdviseIdQueryInfo queryInfo = new ChildVisitAdviseIdQueryInfo();
        queryInfo.setChildVisitId(childVisitId);
        queryInfo.setChildDetailId(childDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(Long.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 获取体检--儿童随访指导情况
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<ChildVisitAdvise> selectChildVisitAdvise(Long childVisitId, Long childDetailId) {
        ChildVisitAdviseQueryInfo queryInfo = new ChildVisitAdviseQueryInfo();
        queryInfo.setChildVisitId(childVisitId);
        queryInfo.setChildDetailId(childDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(ChildVisitAdvise.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存儿童随访指导情况
     * @param symptomIds
     * @param personDetailId
     * @param examPersonId
     */
    public void saveChildVisitAdvise(Long[] visitAdivseIds, Long childVisitId, Long childDetailId) {
        // 去除之前以保存过的数据
        List<ChildVisitAdvise> adivseList = this.selectChildVisitAdvise(childVisitId, childDetailId);
        if (null == visitAdivseIds || visitAdivseIds.length <= 0) {
            // 当页面传回的症状ids（symptomIds）为空， 表示页面没有勾选，因此要删除之前保存过得 数据据
            super.deleteAll(adivseList);
            return ;
        }
        
        List<Long> symptomIdList = new ArrayList<Long>(java.util.Arrays.asList(visitAdivseIds));
        for (ChildVisitAdvise adivse : adivseList) {
            if (symptomIdList.contains(adivse.getChildVisitAdviseId())) {
                symptomIdList.remove(adivse.getChildVisitAdviseId());
            } else {
                super.delete(adivse);
            }
        }
        
        ChildVisitAdvise visitAdvise = null;
        for (Long itemId : symptomIdList) {
            if (null == itemId || itemId.intValue() <= 0) {
                continue ;
            }
            visitAdvise = new ChildVisitAdvise();
            visitAdvise.setVisitAdivseId(itemId);
            visitAdvise.setChildVisitId(childVisitId);
            visitAdvise.setChildDetailId(childDetailId);
            super.save(visitAdvise);
        }
    }
    
    /**
     * 删除儿童随访指导情况
     * @param symptomIds
     * @param personDetailId
     * @param examPersonId
     */
    public void deleteChildVisitAdvise(Long childVisitId, Long childDetailId) {
        List<ChildVisitAdvise> symptomList = this.selectChildVisitAdvise(childVisitId, childDetailId);
        if (Tools.isNotEmptyList(symptomList)) {
            super.deleteAll(symptomList);
        }
        
    }
}