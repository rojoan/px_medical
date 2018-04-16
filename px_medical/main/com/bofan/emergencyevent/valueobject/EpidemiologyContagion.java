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
 * @Description: epidemiology_contagion（流行病--传染病类型对照表） 对应 甲、乙、丙 三类传染病
 * @author lqw
 */
@Entity
@Table(name = "EPIDEMIOLOGY_CONTAGION", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "EPIDEMIOLOGY_CONTAGION_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".EPIDEMIOLOGY_CONTAGION_ID", allocationSize=1)
public class EpidemiologyContagion {

	/** 流行病--传染病类型对照ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EPIDEMIOLOGY_CONTAGION_ID")
	@Column(name = "EPIDEMIOLOGY_CONTAGION_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long epidemiologyContagionId;
	
	/** 传染病类型ID */
	@Column(name = "CONTAGION_ID", nullable = false, precision = 18, scale = 0)
	private Long contagionId;
	
	/** 流行病学记录ID */
	@Column(name = "EPIDEMIOLOGY_ID", nullable = false, precision = 18, scale = 0)
	private Long epidemiologyId;
	
	/** 传染病类型 1：甲类 2：乙类 3：丙类 */
	@Column(name = "CONTAGION_TYPE", nullable = false, length = 1)
	private String contagionType;


	/** default constructor */
	public EpidemiologyContagion() {
	}


	/**
	 * @return epidemiologyContagionId
	 */
	public Long getEpidemiologyContagionId() {
		return epidemiologyContagionId;
	}


	/**
	 * @param epidemiologyContagionId 要设置的 epidemiologyContagionId
	 */
	public void setEpidemiologyContagionId(Long epidemiologyContagionId) {
		this.epidemiologyContagionId = epidemiologyContagionId;
	}


	/**
	 * @return contagionId
	 */
	public Long getContagionId() {
		return contagionId;
	}


	/**
	 * @param contagionId 要设置的 contagionId
	 */
	public void setContagionId(Long contagionId) {
		this.contagionId = contagionId;
	}


	/**
	 * @return epidemiologyId
	 */
	public Long getEpidemiologyId() {
		return epidemiologyId;
	}


	/**
	 * @param epidemiologyId 要设置的 epidemiologyId
	 */
	public void setEpidemiologyId(Long epidemiologyId) {
		this.epidemiologyId = epidemiologyId;
	}


	/**
	 * @return contagionType
	 */
	public String getContagionType() {
		return contagionType;
	}


	/**
	 * @param contagionType 要设置的 contagionType
	 */
	public void setContagionType(String contagionType) {
		this.contagionType = contagionType;
	}
	
}