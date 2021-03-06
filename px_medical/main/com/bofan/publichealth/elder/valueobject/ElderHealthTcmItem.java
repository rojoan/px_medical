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
 * @Description: 老年人中医药评估明细表
 * @author lqw
 */
@Entity
@Table(name = "ELDER_HEALTH_TCM_ITEM", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "ELDER_HEALTH_TCM_ITEM_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".ELDER_HEALTH_TCM_ITEM_ID", allocationSize = 1)
public class ElderHealthTcmItem {

    /** 老年人中医药评估明细ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ELDER_HEALTH_TCM_ITEM_ID")
    @Column(name = "ELDER_HEALTH_TCM_ITEM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long elderHealthTcmItemId;
	
    /** 老年人中医药评估ID */
	@Column(name = "ELDER_HEALTH_TCMEDICINE_ID", nullable = false, precision = 18, scale = 0)
	private Long elderHealthTcmedicineId;
	
	/** 老年人中医药评估ID */
	@Column(name = "HEALTH_TCMEDICINE_ID", nullable = false, precision = 18, scale = 0)
	private Long healthTcmedicineId;
	
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
	
	/** 老年人中医药评估分值 */
	@Column(name = "TCM_SCORE", precision = 2, scale = 0)
	private Integer tcmScore;

	/** default constructor */
	public ElderHealthTcmItem() {
	}

    /**
     * @return elderHealthTcmItemId
     */
    public Long getElderHealthTcmItemId() {
        return elderHealthTcmItemId;
    }

    /**
     * @param elderHealthTcmItemId 要设置的 elderHealthTcmItemId
     */
    public void setElderHealthTcmItemId(Long elderHealthTcmItemId) {
        this.elderHealthTcmItemId = elderHealthTcmItemId;
    }

    /**
     * @return elderHealthTcmedicineId
     */
    public Long getElderHealthTcmedicineId() {
        return elderHealthTcmedicineId;
    }

    /**
     * @param elderHealthTcmedicineId 要设置的 elderHealthTcmedicineId
     */
    public void setElderHealthTcmedicineId(Long elderHealthTcmedicineId) {
        this.elderHealthTcmedicineId = elderHealthTcmedicineId;
    }

    /**
     * @return healthTcmedicineId
     */
    public Long getHealthTcmedicineId() {
        return healthTcmedicineId;
    }

    /**
     * @param healthTcmedicineId 要设置的 healthTcmedicineId
     */
    public void setHealthTcmedicineId(Long healthTcmedicineId) {
        this.healthTcmedicineId = healthTcmedicineId;
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

    /**
     * @return tcmScore
     */
    public Integer getTcmScore() {
        return tcmScore;
    }

    /**
     * @param tcmScore 要设置的 tcmScore
     */
    public void setTcmScore(Integer tcmScore) {
        this.tcmScore = tcmScore;
    }

}