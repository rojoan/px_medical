package com.bofan.publichealth.elder.valueobject;

import java.math.BigDecimal;
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
 * @Description: 老年人健康评估结果主表
 * @author lqw
 */
@Entity
@Table(name = "ELDER_HEALTH_ASSESS", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "ELDER_HEALTH_ASSESS_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".ELDER_HEALTH_ASSESS_ID", allocationSize = 1)
public class ElderHealthAssess {

	/** 老年人健康评估ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ELDER_HEALTH_ASSESS_ID")
	@Column(name = "ELDER_HEALTH_ASSESS_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long elderHealthAssessId;

	/** 行政区域--城镇街道ID 分三级管理 省（直辖市） ：001 市（地区） ：001001 县（城区） ：001001001 */
	@Column(name = "REGION_ID", nullable = false, length = 18)
	private String regionId;
	
	/** 个人基本信息ID personal_detail（个人基本信息） 主键ID */
	@Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
	
	/** 身高（cm） */
	@Column(name = "HEIGHT", precision = 4, scale = 1)
	private BigDecimal height;
	
	/** 体重（kg） */
	@Column(name = "WEIGHT", precision = 4, scale = 1)
	private BigDecimal weight;
	
	/** BMI */
	@Column(name = "BMI", precision = 4)
	private BigDecimal bmi;
	
	/** 血压高（mmHg） */
	@Column(name = "MAX_BLOOD_PRESSURE", precision = 3, scale = 0)
	private Short maxBloodPressure;
	
	/** 血压低（mmHg） */
	@Column(name = "MIN_BLOOD_PRESSURE", precision = 3, scale = 0)
	private Short minBloodPressure;
	
	/** 其他评估 */
	@Column(name = "OTHER_ASSESS", length = 40)
	private String otherAssess;
	
	/** 总体评估 */
	@Column(name = "WHOLE_ASSESS", length = 4000)
	private String wholeAssess;
	
	/** 管理计划 */
	@Column(name = "MANAGER_PLAN", length = 4000)
	private String managerPlan;
	
	/** 疾病筛选 */
	@Column(name = "DISEASE_CHOICE", length = 1000)
	private String diseaseChoice;
	
	/** 评估医生ID */
	@Column(name = "ASSESS_DOCTOR_ID", nullable = false, precision = 18, scale = 0)
	private Long assessDoctorId;
	
	/** 评估医生 */
	@Column(name = "ASSESS_DOCTOR_NAME", nullable = false, length = 20)
	private String assessDoctorName;

	/** 评估日期 */
	@Column(name = "ASSESS_TIME")
	private Date assessTime;
	
	/** 医疗机构ID 对应sys_org表的 主键ID */
	@Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;
	
	/** 医院编码（医疗机构代码） 对应sys_org 表中的 org_no */
	@Column(name = "HOSPITAL_NO", nullable = false, length = 40)
	private String hospitalNo;
	
	/** 医疗机构名称 */
	@Column(name = "HOSPITAL_NAME", nullable = false, length = 80)
	private String hospitalName;

	/** default constructor */
	public ElderHealthAssess() {
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