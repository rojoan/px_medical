package com.bofan.publichealth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.ChildVisitDateQueryInfo;
import com.bofan.publichealth.command.ChildVisitEditInfo;
import com.bofan.publichealth.command.ChildVisitQueryInfo;
import com.bofan.publichealth.valueobject.ChildVisit;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 0-6岁儿童基本情况业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class ChildVisitService extends AbstractAnnoCommonService {
    
    @Autowired
    private ChildVisitSickenService childVisitSickenService;
    
    @Autowired
    private ChildVisitAdviseService childVisitAdviseService;

    /**
     * 0-6岁儿童访视分页列表
     * @param queryInfo
     * @return
     */
    public Page selectChildVisitList(ChildVisitQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new ChildVisitQueryInfo();
        }
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 0-6岁儿童访视日期分页列表
     * @param queryInfo
     * @return
     */
    public Page selectChildVisitDateList(ChildVisitDateQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new ChildVisitDateQueryInfo();
        }
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 保存0-6岁儿童访视信息
     * @param info
     */
    public void saveChildVisit(ChildVisitEditInfo info) {
        // 保存主表信息 
        ChildVisit childVisit = null;
        if(null != info.getChildVisitId()) {
            // 修改
            childVisit = super.selectAObject(ChildVisit.class, info.getChildVisitId());
        } else {
            // 新增
            childVisit = new ChildVisit();
            //childDetail.setCreateTime(new Date());
            childVisit.setVisitDoctorId(info.getCurrentUser().getUserInfoId());
            childVisit.setVisitDoctor(info.getCurrentUser().getName());

        }
        NullBeanUtils.copyProperties(childVisit, info);
        super.saveAndRefresh(childVisit);
        info.setChildVisitId(childVisit.getChildVisitId());
        
        // 随访患病情况
        this.childVisitSickenService.saveChildVisitSicken(info.getVisitSickenMap(), info.getChildVisitId(), info.getChildDetailId());
        // 随访指导
        this.childVisitAdviseService.saveChildVisitAdvise(info.getVisitAdivseIds(), info.getChildVisitId(), info.getChildDetailId());

        
    }
    
    /**
     * 删除0-6岁访视信息
     * @param ids
     * @return
     */
    public void deleteChildVisit(Long[] ids) {
        ChildVisit childVisit =  null;
        for (Long id : ids) {
            if (null == id) {
                continue ;
            }
            
            childVisit = super.selectAObject(ChildVisit.class, id);
            if (null != childVisit) {
                childVisit.setValidFlag(Contstants.NO_FLAG);
                super.save(childVisit);
            }
        }
    }
    

}
