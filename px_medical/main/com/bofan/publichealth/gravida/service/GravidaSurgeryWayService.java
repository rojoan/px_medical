package com.bofan.publichealth.gravida.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.gravida.command.GravidaSurgeryWayQueryInfo;
import com.bofan.publichealth.gravida.valueobject.GravidaSurgeryWay;
import com.bofan.utils.Tools;

/**
 * @Description:孕妇孕期检查/手术方式 Service
 * @author lqw
 */
@Service
@Transactional
public class GravidaSurgeryWayService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询孕妇孕期检查/手术方式 列表
     * @param queryInfo GravidaSurgeryWayQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<GravidaSurgeryWay> selectGravidaSurgeryWayList(GravidaSurgeryWayQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询孕妇孕期检查/手术方式
     * @param queryInfo GravidaSurgeryWayQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public GravidaSurgeryWay findGravidaSurgeryWay(GravidaSurgeryWayQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<GravidaSurgeryWay> list = super.executeSql(qo.getQueryString(),qo.getParam());
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
    
   
    
}