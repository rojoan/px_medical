package com.bofan.publichealth.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.publichealth.valueobject.ExamElder;

/**
 * @Description 居民体检--症状对照业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
@Transactional
public class ExamElderService extends AbstractAnnoCommonService {

    /**
     * 获取体检--老年人信息
     * @param examPersonId
     * @return
     */
    public ExamElder selectExamElder(Long examPersonId) {
        return super.selectAObject(ExamElder.class, examPersonId);
    }
}
