package com.bofan.publichealth.elder.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.elder.command.ElderSelfCareItemQueryInfo;
import com.bofan.publichealth.elder.valueobject.ElderSelfCareItem;
import com.bofan.utils.Tools;

/**
 * @Description: 老年人自理能力评估明细表 Service
 * @author lqw
 */
@Service
@Transactional
public class ElderSelfCareItemService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询 老年人自理能力评估明细表 列表
     * @param queryInfo ElderSelfCareItemQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<ElderSelfCareItem> selectElderSelfCareItemList(ElderSelfCareItemQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询 老年人自理能力评估明细表
     * @param queryInfo ElderSelfCareItemQueryInfo
     * @return
     */
    public ElderSelfCareItem findElderSelfCareItem(ElderSelfCareItemQueryInfo queryInfo) {
        List<ElderSelfCareItem> list = selectElderSelfCareItemList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
 
    
   
    
}