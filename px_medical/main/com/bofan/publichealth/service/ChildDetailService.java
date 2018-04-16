package com.bofan.publichealth.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.ChildDetailEditInfo;
import com.bofan.publichealth.command.ChildDetailQueryInfo;
import com.bofan.publichealth.valueobject.ChildDetail;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 0-6岁儿童基本情况业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class ChildDetailService extends AbstractAnnoCommonService {

    /**
     * 0-6岁儿童分页列表
     * @param queryInfo
     * @return
     */
    public Page selectChildDetailList(ChildDetailQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new ChildDetailQueryInfo();
        }
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 保存0-6岁儿童信息
     * @param info
     */
    public void saveChildDetail(ChildDetailEditInfo info) {
        // 保存主表信息 
        ChildDetail childDetail = null;
        if(null != info.getChildDetailId()) {
            // 修改
            childDetail = super.selectAObject(ChildDetail.class, info.getChildDetailId());
        } else {
            // 新增
            childDetail = new ChildDetail();
            childDetail.setCreateTime(new Date());
            childDetail.setCreatorId(info.getCurrentUser().getUserInfoId());
            childDetail.setCreatorName(info.getCurrentUser().getName());
            
            // 标识为未移植到个人信息表（儿童年龄超过6岁后，移置个人信息表）
            childDetail.setMoveFlag(Contstants.NO_FLAG);
            childDetail.setValidFlag(Contstants.YES_FLAG);
        }
        NullBeanUtils.copyProperties(childDetail, info);
        super.saveAndRefresh(childDetail);
        info.setChildDetailId(childDetail.getChildDetailId());
        
    }
    
    /**
     * 删除0-6岁儿童信息
     * @param ids
     * @return
     */
    public void deleteChildDetail(Long[] ids) {
        ChildDetail childDetail = null;
        for (Long id : ids) {
            if (null == id) {
                continue ;
            }
            
            childDetail = super.selectAObject(ChildDetail.class, id);
            if (null != childDetail) {
                childDetail.setValidFlag(Contstants.NO_FLAG);
                super.save(childDetail);
            }
        } 
    }
    

}
