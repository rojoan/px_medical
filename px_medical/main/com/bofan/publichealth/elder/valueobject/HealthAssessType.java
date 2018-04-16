package com.bofan.publichealth.elder.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 项目评估类型
 * @author lqw
 */
@Entity
@Table(name = "HEALTH_ASSESS_TYPE", schema = SchemaConsts.PUBLIC_HEALTH)
public class HealthAssessType {

	/** 项目评估类型ID，主键ID 目前只分两级，每三个字符为一级 001  躯干 002  肌肉皮肤 */
	@Id
	@Column(name = "HEALTH_ASSESS_TYPE_ID", unique = true, nullable = false, length = 18)
	private String healthAssessTypeId;
	
	/** 项目评估类型 */
	@Column(name = "HEALTH_ASSESS_TYPE_NAME", unique = true, nullable = false, length = 40)
	private String healthAssessTypeName;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;
	 
	/** default constructor */
	public HealthAssessType() {
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
	 * @return healthAssessTypeName
	 */
	public String getHealthAssessTypeName() {
		return healthAssessTypeName;
	}

	/**
	 * @param healthAssessTypeName 要设置的 healthAssessTypeName
	 */
	public void setHealthAssessTypeName(String healthAssessTypeName) {
		this.healthAssessTypeName = healthAssessTypeName;
	}

	/**
	 * @return validFlag
	 */
	public String getValidFlag() {
		return validFlag;
	}

	/**
	 * @param validFlag 要设置的 validFlag
	 */
	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

}