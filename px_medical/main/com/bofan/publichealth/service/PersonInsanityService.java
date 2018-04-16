package com.bofan.publichealth.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonInsanityEditInfo;
import com.bofan.publichealth.command.PersonInsanityQueryInfo;
import com.bofan.publichealth.command.PersonInsanityVisitEditInfo;
import com.bofan.publichealth.command.PersonInsanityVisitGroupQueryInfo;
import com.bofan.publichealth.command.PersonInsanityVisitQueryInfo;
import com.bofan.publichealth.valueobject.PersonInsanity;
import com.bofan.publichealth.valueobject.PersonInsanityVisit;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 重性精神病登记、随访业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class PersonInsanityService extends AbstractAnnoCommonService {

    @Autowired
    private PersonInsanitySymService personInsanitySymService;
    @Autowired
    private PersonInsanityUsedrugService personInsanityUsedrugService;
    @Autowired
    private PersonInsanityRecoveryService personInsanityRecoveryService;
    @Autowired
    private PersonInsanityBehaviorService personInsanityBehaviorService;
    @Autowired
    private PersonInsanityGuidedrugService personInsanityGuidedrugService;
    
    /**
     * 重性精神病患者登记分页列表
     * @param queryInfo
     * @return
     */
    public Page selectPersonInsanityList(PersonInsanityQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new PersonInsanityQueryInfo();
        }
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 重性精神病患者随访分页列表
     * @param queryInfo
     * @return
     */
    public Page selectPersonChronicVisitList(PersonInsanityVisitQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new PersonInsanityVisitQueryInfo();
        }
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 重性精神病患者随访分页列表
     * @param queryInfo
     * @return
     */
    public Page selectPersonChronicVisitGroupList(PersonInsanityVisitGroupQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new PersonInsanityVisitGroupQueryInfo();
        }
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    /**
     * 保存重性精神病患者登记
     * @param info
     */
    public void savePersonInsanity(PersonInsanityEditInfo info) {
        // 保存主表信息 
        PersonInsanity personInsanity = null;
        if(null != info.getPersonInsanityId()) {
            // 修改
            personInsanity = super.selectAObject(PersonInsanity.class, info.getPersonInsanityId());
        } else {
            // 新增
            personInsanity = new PersonInsanity();
            personInsanity.setCreateTime(new Date());
            personInsanity.setValidFlag(Contstants.YES_FLAG);
        }
        NullBeanUtils.copyProperties(personInsanity, info);
        super.saveAndRefresh(personInsanity);
        info.setPersonInsanityId(personInsanity.getPersonInsanityId());

        // 慢性病随访症状
        this.personInsanitySymService.savePersonInsanitySym(info.getSymptomIds(), info.getPersonInsanityId(), null,
                info.getPersonDetailId(), info.getHospitalId(), info.getCareerId(), info.getRecordFlag());

        // 重性精神病--危险行为
        this.personInsanityBehaviorService.savePersonInsanityBehaviorByJson(info.getInsanityBehaviorJson(),
                info.getPersonInsanityId(), null, info.getPersonDetailId(), info.getHospitalId(), info.getCareerId(), info.getRecordFlag());

    }
    
    /**
     * 保存重性精神病患者随访
     * @param info
     */
    public void savePersonInsanityVisit(PersonInsanityVisitEditInfo info) {
        // 保存主表信息 
        PersonInsanityVisit insanityVisit = null;
        if(null != info.getPersonInsanityVisitId()) {
            // 修改
            insanityVisit = super.selectAObject(PersonInsanityVisit.class, info.getPersonInsanityVisitId());
        } else {
            // 新增
            insanityVisit = new PersonInsanityVisit();
            insanityVisit.setValidFlag(Contstants.YES_FLAG);
        }
        NullBeanUtils.copyProperties(insanityVisit, info);
        super.saveAndRefresh(insanityVisit);
        info.setPersonInsanityVisitId(insanityVisit.getPersonInsanityVisitId());

        // 慢性病随访症状
        this.personInsanitySymService.savePersonInsanitySym(info.getSymptomIds(), info.getPersonInsanityId(),
                info.getPersonInsanityVisitId(), info.getPersonDetailId(), info.getHospitalId(),
                info.getVisitDoctorId(), info.getRecordFlag());

        // 慢性病随访药物情况
        this.personInsanityBehaviorService.savePersonInsanityBehaviorByJson(info.getInsanityBehaviorJson(),
                info.getPersonInsanityId(), info.getPersonInsanityVisitId(), info.getPersonDetailId(),
                info.getHospitalId(), info.getVisitDoctorId(), info.getRecordFlag());

        // 重性精神病--康复措施
        this.personInsanityRecoveryService.savePersonInsanityRecovery(info.getRecoveryTypes(), insanityVisit, info.getRecordFlag());
        
        // 重性精神病--用药情况
        this.personInsanityUsedrugService.savePersonInsanityUsedrugByJson(info.getInsanityUsedrugJson(), insanityVisit, info.getRecordFlag());
        
        // 重性精神病--用药指导
        this.personInsanityGuidedrugService.savePersonInsanityGuidedrugByJson(info.getInsanityGuidedrugJson(), insanityVisit, info.getRecordFlag());
    }
    
    /**
     * 删除重性精神病患者登记
     * @param ids
     */
    public void deletePersonInsanity(Long[] ids) {
        PersonInsanity personInsanity = null;
        for (Long id : ids) {
            if (null == id || id.intValue() < 0) {
                continue ;
            }
            
            personInsanity = super.selectAObject(PersonInsanity.class, id);
            if (null != personInsanity) {
                personInsanity.setValidFlag(Contstants.NO_FLAG);
                super.save(personInsanity);
            }
        }
    }
    
    /**
     * 删除重性精神病患者随访
     * @param ids
     */
    public void deletePersonInsanityVisit(Long[] ids) {
        PersonInsanityVisit insanityVisit = null;
        for (Long id : ids) {
            if (null == id || id.intValue() < 0) {
                continue ;
            }
            
            insanityVisit = super.selectAObject(PersonInsanityVisit.class, id);
            if (null != insanityVisit) {
                insanityVisit.setValidFlag(Contstants.NO_FLAG);
                super.save(insanityVisit);
            }
        }
    }

}
