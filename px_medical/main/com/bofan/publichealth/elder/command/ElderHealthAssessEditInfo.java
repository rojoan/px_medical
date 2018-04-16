package com.bofan.publichealth.elder.command;

import java.math.BigDecimal;
import java.util.Date;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 老年人健康评估结果主表
 * @author lqw
 */
public class ElderHealthAssessEditInfo extends BaseCommandInfo {

    private static final long serialVersionUID = 4756934410201828280L;
    
	/** 老年人健康评估ID */
	private Long elderHealthAssessId;

	/** 行政区域--城镇街道ID 分三级管理 省（直辖市） ：001 市（地区） ：001001 县（城区） ：001001001 */
	private String regionId;
	
	/** 个人基本信息ID personal_detail（个人基本信息） 主键ID */
	private Long personDetailId;
	
	/** 身高（cm） */
	private BigDecimal height;
	
	/** 体重（kg） */
	private BigDecimal weight;
	
	/** BMI */
	private BigDecimal bmi;
	
	/** 血压高（mmHg） */
	private Short maxBloodPressure;
	
	/** 血压低（mmHg） */
	private Short minBloodPressure;
	
	/** 其他评估 */
	private String otherAssess;
	
	/** 总体评估 */
	private String wholeAssess;
	
	/** 管理计划 */
	private String managerPlan;
	
	/** 疾病筛选 */
	private String diseaseChoice;
	
	/** 评估医生ID */
	private Long assessDoctorId;
	
	/** 评估医生 */
	private String assessDoctorName;

	/** 评估日期 */
	private Date assessTime;
	
	/** 医疗机构ID 对应sys_org表的 主键ID */
	private Long hospitalId;
	
	/** 医院编码（医疗机构代码） 对应sys_org 表中的 org_no */
	private String hospitalNo;
	
	/** 医疗机构名称 */
	private String hospitalName;

	/** default constructor */
	public ElderHealthAssessEditInfo() {
	}

	/**
	 * @return elderHealthAssessId
	 */
	public Long getElderHealthAssessId() {
		return elderHealthAssessId;
	}

	/**
	 * @param elderHealthAssessId 要设置的 elderHealthAssessId
	 */
	public void setElderHealthAssessId(Long elderHealthAssessId) {
		this.elderHealthAssessId = elderHealthAssessId;
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
	 * @return height
	 */
	public BigDecimal getHeight() {
		return height;
	}

	/**
	 * @param height 要设置的 height
	 */
	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	/**
	 * @return weight
	 */
	public BigDecimal getWeight() {
		return weight;
	}

	/**
	 * @param weight 要设置的 weight
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	/**
	 * @return bmi
	 */
	public BigDecimal getBmi() {
		return bmi;
	}

	/**
	 * @param bmi 要设置的 bmi
	 */
	public void setBmi(BigDecimal bmi) {
		this.bmi = bmi;
	}

	/**
	 * @return maxBloodPressure
	 */
	public Short getMaxBloodPressure() {
		return maxBloodPressure;
	}

	/**
	 * @param maxBloodPressure 要设置的 maxBloodPressure
	 */
	public void setMaxBloodPressure(Short maxBloodPressure) {
		this.maxBloodPressure = maxBloodPressure;
	}

	/**
	 * @return minBloodPressure
	 */
	public Short getMinBloodPressure() {
		return minBloodPressure;
	}

	/**
	 * @param minBloodPressure 要设置的 minBloodPressure
	 */
	public void setMinBloodPressure(Short minBloodPressure) {
		this.minBloodPressure = minBloodPressure;
	}

	/**
	 * @return otherAssess
	 */
	public String getOtherAssess() {
		return otherAssess;
	}

	/**
	 * @param otherAssess 要设置的 otherAssess
	 */
	public void setOtherAssess(String otherAssess) {
		this.otherAssess = otherAssess;
	}

	/**
	 * @return wholeAssess
	 */
	public String getWholeAssess() {
		return wholeAssess;
	}

	/**
	 * @param wholeAssess 要设置的 wholeAssess
	 */
	public void setWholeAssess(String wholeAssess) {
		this.wholeAssess = wholeAssess;
	}

	/**
	 * @return managerPlan
	 */
	public String getManagerPlan() {
		return managerPlan;
	}

	/**
	 * @param managerPlan 要设置的 managerPlan
	 */
	public void setManagerPlan(String managerPlan) {
		this.managerPlan = managerPlan;
	}

	/**
	 * @return diseaseChoice
	 */
	public String getDiseaseChoice() {
		return diseaseChoice;
	}

	/**
	 * @param diseaseChoice 要设置的 diseaseChoice
	 */
	public void setDiseaseChoice(String diseaseChoice) {
		this.diseaseChoice = diseaseChoice;
	}

	/**
	 * @return assessDoctorId
	 */
	public Long getAssessDoctorId() {
		return assessDoctorId;
	}

	/**
	 * @param assessDoctorId 要设置的 assessDoctorId
	 */
	public void setAssessDoctorId(Long assessDoctorId) {
		this.assessDoctorId = assessDoctorId;
	}

	/**
	 * @return assessDoctorName
	 */
	public String getAssessDoctorName() {
		return assessDoctorName;
	}

	/**
	 * @param assessDoctorName 要设置的 assessDoctorName
	 */
	public void setAssessDoctorName(String assessDoctorName) {
		this.assessDoctorName = assessDoctorName;
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
	 * @return hospitalNo
	 */
	public String getHospitalNo() {
		return hospitalNo;
	}

	/**
	 * @param hospitalNo 要设置的 hospitalNo
	 */
	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	/**
	 * @return hospitalName
	 */
	public String getHospitalName() {
		return hospitalName;
	}

	/**
	 * @param hospitalName 要设置的 hospitalName
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

}