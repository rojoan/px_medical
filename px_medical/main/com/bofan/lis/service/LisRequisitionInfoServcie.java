package com.bofan.lis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.lis.command.LisRequisitionInfoQueryInfo;
import com.bofan.lis.valueobject.LisRequisitionInfo;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-10-8
 */
@Service
@Transactional
public class LisRequisitionInfoServcie extends AbstractAnnoCommonService {
    
    /**
     * 根据检验ID获取结果列表
     * @param inspectionId
     * @return
     */
    @SuppressWarnings("rawtypes")
    public LisRequisitionInfo selectLisRequisitionInfoByRequisitionId(String requisitionId) {
        if (null != requisitionId) {
            LisRequisitionInfoQueryInfo queryInfo = new LisRequisitionInfoQueryInfo();
            queryInfo.setRequisitionId(requisitionId);
            
            IQueryObject qo = super.getQueryObject(queryInfo);
            List dataList = super.executeSql(qo.getQueryString(), qo.getParam());
            return dataList.isEmpty() ? null : (LisRequisitionInfo) dataList.get(0);
        }
        return null;
    }
    
    /**
     * 查询检验样本信息列表
     * @param querInfo
     * @return
     */
    public Page selectLisRequisitionInfoList(LisRequisitionInfoQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }

}
