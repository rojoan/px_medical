package com.bofan.emergencyevent.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: contagion（传染病类型表）
 * @author lqw
 * @date 2017-10-16
 */
@Entity
@Table(name = "CONTAGION", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "CONTAGION_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".CONTAGION_ID", allocationSize = 1)
public class Contagion {

	/** 传染病类型ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTAGION_ID")
	@Column(name = "CONTAGION_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long contagionId;
	
	/** 传染病名称 */
	@Column(name = "CONTAGION_NAME", nullable = false, length = 100)
	private String contagionName;
	
	/** 传染病类型 1：甲类 2：乙类 3：丙类 */
	@Column(name = "CONTAGION_TYPE", nullable = false, length = 1)
	private String contagionType;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public Contagion() {
	}

	/**
	 * @return contagionId
	 */
	public Long getContagionId() {
		return contagionId;
	}

	/**
	 * @param contagionId
	 *            要设置的 contagionId
	 */
	public void setContagionId(Long contagionId) {
		this.contagionId = contagionId;
	}

	/**
	 * @return contagionName
	 */
	public String getContagionName() {
		return contagionName;
	}

	/**
	 * @param contagionName
	 *            要设置的 contagionName
	 */
	public void setContagionName(String contagionName) {
		this.contagionName = contagionName;
	}

	/**
	 * @return contagionType
	 */
	public String getContagionType() {
		return contagionType;
	}

	/**
	 * @param contagionType
	 *            要设置的 contagionType
	 */
	public void setContagionType(String contagionType) {
		this.contagionType = contagionType;
	}

	/**
	 * @return validFlag
	 */
	public String getValidFlag() {
		return validFlag;
	}

	/**
	 * @param validFlag
	 *            要设置的 validFlag
	 */
	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

}