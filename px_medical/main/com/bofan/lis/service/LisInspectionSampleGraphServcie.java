package com.bofan.lis.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.lis.command.LisInspectionSampleGraphQueryInfo;
import com.bofan.lis.valueobject.LisInspectionSampleGraph;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-10-8
 */
@Service
@Transactional
public class LisInspectionSampleGraphServcie extends AbstractAnnoCommonService {
    
    /**
     * 查询检验样本信息列表
     * @param querInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<LisInspectionSampleGraph> selectLisInspectionSampleGraphList(String inspectionId) {
        if (StringUtils.isBlank(inspectionId)) {
            return null;
        }
        LisInspectionSampleGraphQueryInfo queryInfo = new LisInspectionSampleGraphQueryInfo();
        queryInfo.setInspectionId(inspectionId.trim());
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

}
