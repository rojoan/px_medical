package com.bofan.lis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.lis.command.LisInspectionSampleQueryInfo;
import com.bofan.lis.valueobject.LisInspectionSample;
import com.bofan.utils.Tools;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-10-8
 */
@Service
@Transactional
public class LisInspectionSampleServcie extends AbstractAnnoCommonService {
    
    /**
     * 查询检验样本信息列表
     * @param querInfo
     * @return
     */
    public Page selectLisInspectionSampleList(LisInspectionSampleQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 根据 单位Id、门诊|住院号 查询 检验样本信息
     * @param inpatientId
     * @return
     */
    @SuppressWarnings("unchecked")
    public LisInspectionSample selectInspectionSampleByOrgInpatientId(Long orgId,String inpatientId) {
    	LisInspectionSampleQueryInfo queryInfo = new LisInspectionSampleQueryInfo();
    	queryInfo.setInpatientId(inpatientId);
    	queryInfo.setOrgId(orgId);
        IQueryObject qo = super.getQueryObject(queryInfo);
		List<LisInspectionSample> list = super.executeSql(qo.getQueryString(), qo.getParam());
        if (Tools.isNotEmptyList(list)) {
			return list.get(0);
		}
        return null;
    }

}
