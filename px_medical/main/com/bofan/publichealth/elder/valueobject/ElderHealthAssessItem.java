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
 * @Description: 老年人健康评估结果明细表
 * @author lqw
 */
@Entity
@Table(name = "ELDER_HEALTH_ASSESS_ITEM", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "ELDER_HEALTH_ASSESS_ITEM_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".ELDER_HEALTH_ASSESS_ITEM_ID", allocationSize = 1)
public class ElderHealthAssessItem {

	/** 老年人健康评估明细ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ELDER_HEALTH_ASSESS_ITEM_ID")
	@Column(name = "ELDER_HEALTH_ASSESS_ITEM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long elderHealthAssessItemId;
	
	/** 健康评估项目ID，（仅保存选中的项目） 选择中那个项目，保存那个相关的项目 */
	@Column(name = "HEALTH_ASSESS_ITEM_ID",nullable = false, precision = 18, scale = 0)
	private Long healthAssessItemId;
	
	/** 老年人健康评估ID */
	@Column(name = "ELDER_HEALTH_ASSESS_ID",  nullable = false, precision = 18, scale = 0)
	private Long elderHealthAssessId;
	
	/** 项目评估类型ID，主键ID 躯干 肌肉皮肤 */
	@Column(name = "HEALTH_ASSESS_TYPE_ID", nullable = false, length = 18)
	private String healthAssessTypeId;
	
	/** 行政区域--城镇街道ID 分三级管理 省（直辖市） ：001 市（地区）     ：001001 县（城区）     ：001001001 */
	@Column(name = "REGION_ID", nullable = false, length = 18)
	private String regionId;
	
	/** 个人基本信息ID personal_detail（个人基本信息） 主键ID */
	@Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
	
	/** 评估日期 */
	@Column(name = "ASSESS_TIME", nullable = false)
	private Date assessTime;
	
	/** 医疗机构ID 对应sys_org表的 主键ID */
	@Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;

	/** default constructor */
	public ElderHealthAssessItem() {
	}

	/**
	 * @return elderHealthAssessItemId
	 */
	public Long getElderHealthAssessItemId() {
		return elderHealthAssessItemId;
	}

	/**
	 * @param elderHealthAssessItemId 要设置的 elderHealthAssessItemId
	 */
	public void setElderHealthAssessItemId(Long elderHealthAssessItemId) {
		this.elderHealthAssessItemId = elderHealthAssessItemId;
	}

	/**
	 * @return healthAssessItemId
	 */
	public Long getHealthAssessItemId() {
		return healthAssessItemId;
	}

	/**
	 * @param healthAssessItemId 要设置的 healthAssessItemId
	 */
	public void setHealthAssessItemId(Long healthAssessItemId) {
		this.healthAssessItemId = healthAssessItemId;
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
	 * @return healthAssessTypeId
	 */
	public String getHealthAssessTypeId() {
		return healthAssessTypeId;
	}

	/**
	 * @param healthAssessTypeId 要设置的 healthAssessTypeId
	 */
	public void setHealthAssessTypeId(String healthAssessTypeId) {
		this.healthAssessTypeId = healthAssessTypeId;
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