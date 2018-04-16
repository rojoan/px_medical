package com.bofan.publichealth.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.publichealth.command.ExamPersonEditInfo;
import com.bofan.publichealth.valueobject.ExamOrganBody;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 居民健康体检--查体业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class ExamOrganBodyService extends AbstractAnnoCommonService {
    
    /**
     * 获取居民健康体检--查体信息
     * @param examPersonId
     * @return
     */
    public ExamOrganBody selectExamOrganBody(Long examPersonId) {
        return super.selectAObject(ExamOrganBody.class, examPersonId);
    }
    
    /**
     * 保存居民健康体检--查体
     * @param info
     */
    public void saveExamOrganBody(ExamPersonEditInfo info) {
        if (null == info.getExamOrganBody()) {
            return ;
        }
        ExamOrganBody examOrganBody = this.selectExamOrganBody(info.getExamPersonId());
        if (null == examOrganBody) {
            examOrganBody = new ExamOrganBody();
        }
        
        NullBeanUtils.copyProperties(examOrganBody, info.getExamOrganBody());
        examOrganBody.setExamTime(info.getExamTime());
        examOrganBody.setExamPersonId(info.getExamPersonId());
        examOrganBody.setPersonDetailId(info.getPersonDetailId());
        super.save(examOrganBody);
    }
    
    /**
     * 删除居民健康体检--查体
     * @param info
     */
    public void deleteExamOrganBody(Long examPersonId) {
        ExamOrganBody examOrganBody = this.selectExamOrganBody(examPersonId);
        if (null != examOrganBody) {
            super.delete(examOrganBody);
        }
    }
    
    
}
