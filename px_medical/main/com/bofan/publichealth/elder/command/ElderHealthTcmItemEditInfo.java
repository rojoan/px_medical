package com.bofan.publichealth.elder.command;

import java.util.Date;

/**
 * @Description: 老年人中医药评估明细表
 * @author lqw
 */
public class ElderHealthTcmItemEditInfo {

    /** 老年人中医药评估明细ID */
	private Long elderHealthTcmItemId;
	
    /** 老年人中医药评估ID */
	private Long elderHealthTcmedicineId;
	
	/** 老年人中医药评估ID */
	private Long healthTcmedicineId;
	
	/** 行政区域--城镇街道ID 分三级管理 省（直辖市） ：001  市（地区）     ：001001 县（城区）     ：001001001 */
	private String regionId;

	/** 个人基本信息ID personal_detail（个人基本信息） 主键ID */
	private Long personDetailId;
	
	/** 评估日期 */
	private Date assessTime;
	
	/** 医疗机构ID 对应sys_org表的 主键ID */
	private Long hospitalId;
	
	/** 老年人中医药评估分值 */
    private Integer tcmScore;

	/** default constructor */
	public ElderHealthTcmItemEditInfo() {
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