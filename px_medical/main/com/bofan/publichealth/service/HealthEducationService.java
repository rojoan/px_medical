package com.bofan.publichealth.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.publichealth.command.HealthEducationEditInfo;
import com.bofan.publichealth.command.HealthEducationQueryInfo;
import com.bofan.publichealth.valueobject.HealthEduBulletin;
import com.bofan.publichealth.valueobject.HealthEduReadyDatum;
import com.bofan.publichealth.valueobject.HealthEducation;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 健康教育业务类
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class HealthEducationService extends AbstractAnnoCommonService {

    @Autowired
    private HealthEduAreaService healthEduAreaService;
    @Autowired
    private HealthEduCrowdService healthEduCrowdService;
    @Autowired
    private HealthEduArchiveService healthEduArchiveService;
    @Autowired
    private HealthEduDatumTypeService healthEduDatumTypeService;
    
    /**
     * 健康教育活动分页列表
     * @param queryInfo
     * @return
     */
    public Page selectHealthEducationList(HealthEducationQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new HealthEducationQueryInfo();
        }
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 保存健康教育活动
     * @param info
     */
    public void saveHealthEducation(HealthEducationEditInfo info) {
        // 保存主表信息 
        HealthEducation education = null;
        if(null != info.getHealthEducationId()) {
            // 修改
            education = super.selectAObject(HealthEducation.class, info.getHealthEducationId());
        } else {
            // 新增
            education = new HealthEducation();
            education.setCreateTime(new Date());
            education.setCreatorId(info.getCurrentUser().getUserInfoId());
            education.setValidFlag(Contstants.YES_FLAG);
            
            SysOrg unit = super.selectAObject(SysOrg.class, info.getCurrentUser().getSysOrg().getUnitOrgId());
            education.setHospitalId(unit.getOrgId());
            education.setHospitalNo(unit.getOrgNo());
            education.setHospitalName(unit.getName());
        }
        NullBeanUtils.copyProperties(education, info);
        super.saveAndRefresh(education);
        info.setHealthEducationId(education.getHealthEducationId());
        
        // 保存健康教育宣传栏
        if (null != info.getHealthEduBulletin()) {
            HealthEduBulletin healthEduBulletin = super.selectAObject(HealthEduBulletin.class, info.getHealthEducationId());
            if (null == healthEduBulletin) {
                healthEduBulletin = new HealthEduBulletin();
            }
            info.getHealthEduBulletin().setHealthEducationId(info.getHealthEducationId());
            NullBeanUtils.copyProperties(healthEduBulletin, info.getHealthEduBulletin());
            super.save(healthEduBulletin);
        }
        
        // 保存健康教育--准备活动资料
        if (null != info.getHealthEduReadyDatum()) {
            HealthEduReadyDatum healthEduReadyDatum = super.selectAObject(HealthEduReadyDatum.class, info.getHealthEducationId());
            if (null == healthEduReadyDatum) {
                healthEduReadyDatum = new HealthEduReadyDatum();
            }
            info.getHealthEduReadyDatum().setHealthEducationId(info.getHealthEducationId());
            NullBeanUtils.copyProperties(healthEduReadyDatum, info.getHealthEduReadyDatum());
            super.save(healthEduReadyDatum);
        }
        
        // 保存资料发放位置
        this.healthEduAreaService.saveHealthEduArea(info.getGivePositions(), info.getHealthEducationId(), Contstants.EDU_AREA_PUT);
        // 保存资料播放位置
        this.healthEduAreaService.saveHealthEduArea(info.getPlayPositions(), info.getHealthEducationId(), Contstants.EDU_AREA_PALY);
        // 健康教育--发放接受教育对象
        this.healthEduCrowdService.saveHealthEduCrowd(info.getReceiveObjects(), info.getHealthEducationId());
        // 保存健康教育活动存档类型
        this.healthEduArchiveService.saveHealthEduArchive(info.getArchiveTypes(), info.getHealthEducationId());
        // 保存健康教育--资料种类
        this.healthEduDatumTypeService.saveHealthEduDatumType(info.getDatumTypes(), info.getHealthEducationId());
    }
    
    /**
     * 删除健康教育活动
     * @param ids
     * @return
     */
    public void deleteHealthEducation(Long[] ids) {
        HealthEducation education = null;
        for (Long id : ids) {
            if (null == id) {
                continue ;
            }
            
            education = super.selectAObject(HealthEducation.class, id);
            if (null != education) {
                education.setValidFlag(Contstants.NO_FLAG);
                super.save(education);
            }
        } 
    }
    

}
