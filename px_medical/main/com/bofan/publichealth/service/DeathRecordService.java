package com.bofan.publichealth.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.DeathRecordEditInfo;
import com.bofan.publichealth.command.DeathRecordQueryInfo;
import com.bofan.publichealth.valueobject.DeathRecord;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description: 死亡登记 业务
 * @author lqw
 */
@Service
@Transactional
public class DeathRecordService extends AbstractAnnoCommonService {

    /**
     * 死亡登记信息分页列表
     * @param queryInfo
     * @return
     */
    public Page selectDeathRecordList(DeathRecordQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new DeathRecordQueryInfo();
        }
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 保存死亡登记信息
     * @param info
     */
    public void saveDeathRecord(DeathRecordEditInfo info) {
        // 保存主表信息 
        DeathRecord deathRecord = null;
        if(null != info.getDeathRecordId()) {
            // 修改
            deathRecord = super.selectAObject(DeathRecord.class, info.getDeathRecordId());
        } else {
            // 新增
            deathRecord = new DeathRecord();
            deathRecord.setCreateTime(new Date());
            deathRecord.setValidFlag(Contstants.YES_FLAG);
        }
        NullBeanUtils.copyProperties(deathRecord, info);
        super.saveAndRefresh(deathRecord);
    }
    
    /**
     * 删除死亡登信息
     * @param examPersonId
     * @return
     */
    public void deleteDeathRecord(Long examPersonId) {
        DeathRecord DeathRecord = super.selectAObject(DeathRecord.class,examPersonId);
        if (null != DeathRecord) {
            DeathRecord.setValidFlag(Contstants.NO_FLAG);
            super.save(DeathRecord);
        }
    }
    

}
