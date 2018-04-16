package com.bofan.publichealth.elder.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.elder.command.ElderHealthTcmItemQueryInfo;
import com.bofan.publichealth.elder.valueobject.ElderHealthTcmItem;
import com.bofan.utils.Tools;

/**
 * @Description: 老年人中医药评估明细表 Service
 * @author lqw
 */
@Service
@Transactional
public class ElderHealthTcmItemService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询 老年人中医药评估明细表 列表
     * @param queryInfo ElderHealthTcmItemQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<ElderHealthTcmItem> selectElderHealthTcmItemList(ElderHealthTcmItemQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询 老年人中医药评估明细表
     * @param queryInfo ElderHealthTcmItemQueryInfo
     * @return
     */
    public ElderHealthTcmItem findElderHealthTcmItem(ElderHealthTcmItemQueryInfo queryInfo) {
        List<ElderHealthTcmItem> list = selectElderHealthTcmItemList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
 
    
   
    
}