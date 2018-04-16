package com.bofan.publichealth.gravida.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.gravida.command.GravidaExamItemQueryInfo;
import com.bofan.publichealth.gravida.valueobject.GravidaExamItem;
import com.bofan.utils.Tools;

/**
 * @Description: 孕妇检查项目 Service
 * @author lqw
 */
@Service
@Transactional
public class GravidaExamItemService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询孕妇孕检项目情况对照表 列表
     * @param queryInfo GravidaExamItemQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<GravidaExamItem> selectGravidaExamItemList(GravidaExamItemQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询孕妇孕检项目情况对照表
     * @param queryInfo GravidaExamItemQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public GravidaExamItem findGravidaExamItem(GravidaExamItemQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<GravidaExamItem> list = super.executeSql(qo.getQueryString(),qo.getParam());
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 根据条件查询 出孕妇孕检项目情况对照 key=孕检项目类型  的map
     * @param queryInfo
     * @return
     */
    public Map<String,GravidaExamItem> selectGravidaExamItemMap(GravidaExamItemQueryInfo queryInfo){
        Map<String,GravidaExamItem> gravidaExamItemMap = new HashMap<String,GravidaExamItem>();
        List<GravidaExamItem> list  = this.selectGravidaExamItemList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            for (GravidaExamItem gravidaExamItem : list) {
                gravidaExamItemMap.put(gravidaExamItem.getExamItemType(), gravidaExamItem);
            }
        }
        return gravidaExamItemMap;
    }
    
}