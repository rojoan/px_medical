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
 * @Description: career（个人职业）
 * @author lqw
 */
@Entity
@Table(name = "CAREER", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "CAREER_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".CAREER_ID", allocationSize = 1)
public class Career {

	/** 个人职业ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAREER_ID")
	@Column(name = "CAREER_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long careerId;
	
	/** 职业名称 */
	@Column(name = "CAREER_NAME", unique = true, nullable = false, length = 50)
	private String careerName;
	
	/** 备注 */
	@Column(name = "REMARK", length = 50)
	private String remark;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public Career() {
	}

	/**
	 * @return careerId
	 */
	public Long getCareerId() {
		return careerId;
	}

	/**
	 * @param careerId
	 *            要设置的 careerId
	 */
	public void setCareerId(Long careerId) {
		this.careerId = careerId;
	}

	/**
	 * @return careerName
	 */
	public String getCareerName() {
		return careerName;
	}

	/**
	 * @param careerName
	 *            要设置的 careerName
	 */
	public void setCareerName(String careerName) {
		this.careerName = careerName;
	}

	/**
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            要设置的 remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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