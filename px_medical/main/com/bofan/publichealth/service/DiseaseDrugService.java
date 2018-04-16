package com.bofan.publichealth.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.DiseaseDrugQueryInfo;

/**
 * @Description 居民健康体检业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class DiseaseDrugService extends AbstractAnnoCommonService {

    /**
     * 居民健康体检信息分页列表
     * @param queryInfo
     * @return
     */
    public Page selectDiseaseDrugList(DiseaseDrugQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new DiseaseDrugQueryInfo();
        }
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
}
