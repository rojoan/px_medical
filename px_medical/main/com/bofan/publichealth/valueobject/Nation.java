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
 * @Description: 民族字典
 * @author lqw
 */
@Entity
@Table(name = "NATION", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "NATION_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".NATION_ID", allocationSize = 1)
public class Nation {

	/** 民族ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NATION_ID")
	@Column(name = "NATION_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long nationId;

	/** 民族名称 */
	@Column(name = "NATION_NAME", unique = true, nullable = false, length = 100)
	private String nationName;

	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public Nation() {
	}

	/**
	 * @return nationId
	 */
	public Long getNationId() {
		return nationId;
	}

	/**
	 * @param nationId
	 *            要设置的 nationId
	 */
	public void setNationId(Long nationId) {
		this.nationId = nationId;
	}

	/**
	 * @return nationName
	 */
	public String getNationName() {
		return nationName;
	}

	/**
	 * @param nationName
	 *            要设置的 nationName
	 */
	public void setNationName(String nationName) {
		this.nationName = nationName;
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