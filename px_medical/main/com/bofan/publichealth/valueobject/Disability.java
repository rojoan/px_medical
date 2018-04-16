package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: disability（残疾表）
 * @author lqw
 */
@Entity
@Table(name = "DISABILITY", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "DISABILITY_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".DISABILITY_ID", allocationSize = 1)
public class Disability {

	/** 残疾名称ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DISABILITY_ID")
	@Column(name = "DISABILITY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long disabilityId;
	
	/** 残疾名称 */
	@Column(name = "DISABILITY_NAME", unique = true, nullable = false, length = 40)
	private String disabilityName;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public Disability() {
	}

	
	public Long getDisabilityId() {
		return this.disabilityId;
	}

	public void setDisabilityId(Long disabilityId) {
		this.disabilityId = disabilityId;
	}

	
	public String getDisabilityName() {
		return this.disabilityName;
	}

	public void setDisabilityName(String disabilityName) {
		this.disabilityName = disabilityName;
	}

	
	public String getValidFlag() {
		return this.validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

}