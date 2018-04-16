package com.bofan.publichealth.elder.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 老年人自理能力评估明细表
 * @author lqw
 */
@Entity
@Table(name = "ELDER_SELF_CARE_ITEM", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "ELDER_SELF_CARE_ITEM_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".ELDER_SELF_CARE_ITEM_ID", allocationSize = 1)
public class ElderSelfCareItem {

    /** 老年人自理能力评估明细ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ELDER_SELF_CARE_ITEM_ID")
    @Column(name = "ELDER_SELF_CARE_ITEM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long elderSelfCareItemId;
    
    /** 自理能力评估项目ID，主键ID */
    @Column(name = "ELDER_SELF_CARE_ABILITY_ID", nullable = false, precision = 18, scale = 0)
	private Long elderSelfCareAbilityId;
	
	/** 老年人自理能力评估ID */
	@Column(name = "SELF_CARE_ABILITY_ID", nullable = false, precision = 18, scale = 0)
	private Long selfCareAbilityId;
	
	/** 行政区域--城镇街道ID 分三级管理 省（直辖市） ：001  市（地区）     ：001001 县（城区）     ：001001001 */
	@Column(name = "REGION_ID", nullable = false, length = 18)
	private String regionId;
	
	/** 个人基本信息ID personal_detail（个人基本信息） 主键ID */
	@Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
	
	/** 评估日期 */
	@Column(name = "ASSESS_TIME", nullable = false, length = 7)
	private Date assessTime;
	
	/** 医疗机构ID 对应sys_org表的 主键ID */
	@Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;

	/** default constructor */
	public ElderSelfCareItem() {
	}

    /**
     * @return elderSelfCareItemId
     */
    public Long getElderSelfCareItemId() {
        return elderSelfCareItemId;
    }

    /**
     * @param elderSelfCareItemId 要设置的 elderSelfCareItemId
     */
    public void setElderSelfCareItemId(Long elderSelfCareItemId) {
        this.elderSelfCareItemId = elderSelfCareItemId;
    }

    /**
     * @return elderSelfCareAbilityId
     */
    public Long getElderSelfCareAbilityId() {
        return elderSelfCareAbilityId;
    }

    /**
     * @param elderSelfCareAbilityId 要设置的 elderSelfCareAbilityId
     */
    public void setElderSelfCareAbilityId(Long elderSelfCareAbilityId) {
        this.elderSelfCareAbilityId = elderSelfCareAbilityId;
    }

    /**
     * @return selfCareAbilityId
     */
    public Long getSelfCareAbilityId() {
        return selfCareAbilityId;
    }

    /**
     * @param selfCareAbilityId 要设置的 selfCareAbilityId
     */
    public void setSelfCareAbilityId(Long selfCareAbilityId) {
        this.selfCareAbilityId = selfCareAbilityId;
    }

    /**
     * @return regionId
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId 要设置的 regionId
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * @return personDetailId
     */
    public Long getPersonDetailId() {
        return personDetailId;
    }

    /**
     * @param personDetailId 要设置的 personDetailId
     */
    public void setPersonDetailId(Long personDetailId) {
        this.personDetailId = personDetailId;
    }

    /**
     * @return assessTime
     */
    public Date getAssessTime() {
        return assessTime;
    }

    /**
     * @param assessTime 要设置的 assessTime
     */
    public void setAssessTime(Date assessTime) {
        this.assessTime = assessTime;
    }

    /**
     * @return hospitalId
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId 要设置的 hospitalId
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }
}