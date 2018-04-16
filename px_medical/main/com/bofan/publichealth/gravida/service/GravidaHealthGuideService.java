package com.bofan.publichealth.gravida.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.gravida.command.GravidaHealthGuideQueryInfo;
import com.bofan.publichealth.gravida.valueobject.GravidaHealthGuide;
import com.bofan.utils.Tools;

/**
 * @Description:孕妇保健指导 Service
 * @author lqw
 */
@Service
@Transactional
public class GravidaHealthGuideService extends AbstractAnnoCommonService {
    
    /**
     * 根据条件查询孕妇保健指导 列表
     * @param queryInfo GravidaHealthGuideQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<GravidaHealthGuide> selectGravidaHealthGuideList(GravidaHealthGuideQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询孕妇保健指导
     * @param queryInfo GravidaHealthGuideQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public GravidaHealthGuide findGravidaHealthGuide(GravidaHealthGuideQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<GravidaHealthGuide> list = super.executeSql(qo.getQueryString(),qo.getParam());
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
}