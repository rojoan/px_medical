package com.bofan.publichealth.elder.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.elder.command.ElderHealthAssessItemQueryInfo;
import com.bofan.publichealth.elder.valueobject.ElderHealthAssessItem;
import com.bofan.utils.Tools;

/**
 * @Description: 老年人健康评估结果明细表 Service
 * @author lqw
 */
@Service
@Transactional
public class ElderHealthAssessItemService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询 老年人健康评估结果明细表 列表
     * @param queryInfo ElderHealthAssessItemQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<ElderHealthAssessItem> selectElderHealthAssessItemList(ElderHealthAssessItemQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询 老年人健康评估结果明细表
     * @param queryInfo ElderHealthAssessItemQueryInfo
     * @return
     */
    public ElderHealthAssessItem findElderHealthAssessItem(ElderHealthAssessItemQueryInfo queryInfo) {
        List<ElderHealthAssessItem> list = selectElderHealthAssessItemList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
 
    
   
    
}