package com.bofan.publichealth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.ChildVisitSickenQueryInfo;
import com.bofan.publichealth.valueobject.ChildVisitSicken;
import com.bofan.utils.Tools;

/**
 * @Description 儿童随访患病情况业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
@Transactional
public class ChildVisitSickenService extends AbstractAnnoCommonService {

    /**
     * 获取儿童随访患病内容
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public Map<String, ChildVisitSicken> selectChildVisitSickenMap(Long childVisitId, Long childDetailId) {
        Map<String, ChildVisitSicken> result = new HashMap<String, ChildVisitSicken>();
        ChildVisitSickenQueryInfo queryInfo = new ChildVisitSickenQueryInfo();
        queryInfo.setChildVisitId(childVisitId);
        queryInfo.setChildDetailId(childDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<ChildVisitSicken> dataList = super.executeSql(ChildVisitSicken.class, qo.getQueryString(), qo.getParam());
        
        if (null != dataList) {
            for (ChildVisitSicken visitSicken : dataList) {
                result.put(visitSicken.getVisitSickenId() + "", visitSicken);
            }
        }
        
        return result;
    }
    
    /**
     * 获取儿童随访患病情况列表
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<ChildVisitSicken> selectChildVisitSicken(Long childVisitId, Long childDetailId) {
        ChildVisitSickenQueryInfo queryInfo = new ChildVisitSickenQueryInfo();
        queryInfo.setChildVisitId(childVisitId);
        queryInfo.setChildDetailId(childDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(ChildVisitSicken.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存儿童随访患病情况信息
     * @param symptomIds
     * @param personDetailId
     * @param examPersonId
     */
    public void saveChildVisitSicken(Map<Long, ChildVisitSicken> visitSickenMap, Long childVisitId, Long childDetailId) {
        ChildVisitSicken visitSicken = null;
        for (Map.Entry<Long, ChildVisitSicken> entry : visitSickenMap.entrySet()) {
            if (null == entry.getKey() || entry.getKey().intValue() <= 0) {
                continue ;
            }
            
            
            
            if (null != entry.getValue().getChildVisitSickenId()) {
                visitSicken = super.selectAObject(ChildVisitSicken.class, entry.getValue().getChildVisitSickenId());
                
                // 当描疾病描述内容为空，删除当前疾病内容
                if (!StringUtils.hasText(entry.getValue().getSickenContent())) {
                    super.delete(visitSicken);
                    continue;
                }
            } else {
                // 当描疾病描述内容为空时，跳到下个循环（即不做保存）
                if (!StringUtils.hasText(entry.getValue().getSickenContent())) {
                    continue;
                }
                visitSicken = new ChildVisitSicken();
            }

            visitSicken.setVisitSickenId(entry.getKey());
            visitSicken.setChildVisitId(childVisitId);
            visitSicken.setChildDetailId(childDetailId);
            visitSicken.setSickenContent(entry.getValue().getSickenContent());
            super.save(visitSicken);
        }
    }
    
    /**
     * 删除儿童随访患病情况
     * @param symptomIds
     * @param personDetailId
     * @param examPersonId
     */
    public void deleteChildVisitSicken(Long childVisitId, Long childDetailId) {
        List<ChildVisitSicken> sickenList = this.selectChildVisitSicken(childVisitId, childDetailId);
        if (Tools.isNotEmptyList(sickenList)) {
            super.deleteAll(sickenList);
        }
        
    }
}