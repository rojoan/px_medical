package com.bofan.emergencyevent.valueobject;

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
 * @Description: em_health_check（公卫事件审核表）
 * @author lqw
 */
@Entity
@Table(name = "EM_HEALTH_CHECK", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "EM_HEALTH_CHECK_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".EM_HEALTH_CHECK_ID", allocationSize = 1)
public class EmHealthCheck {

	/** 公卫事件审核ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EM_HEALTH_CHECK_ID")
	@Column(name = "HEALTH_CHECK_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long healthCheckId;
	
	/** 突发公卫报告ID */
	@Column(name = "HEALTH_REPORT_ID", precision = 18, scale = 0)
	private Long healthReportId;
	
	/** 流行病学记录ID */
	@Column(name = "EPIDEMIOLOGY_ID", precision = 18, scale = 0)
	private Long epidemiologyId;
	
	/** 审核单位ID */
	@Column(name = "CHECK_ORG_ID", nullable = false, precision = 18, scale = 0)
	private Long checkOrgId;
	
	/** 审核单位名称 */
	@Column(name = "CHECK_ORG_NAME", nullable = false, length = 100)
	private String checkOrgName;
	
	/** 审核日期 */
	@Column(name = "CHECK_TIME", nullable = false)
	private Date checkTime;
	
	/** 审核意见和建议 */
	@Column(name = "CHECK_OPINION", length = 4000)
	private String checkOpinion;
	
	/** 审核人ID */
	@Column(name = "CHECKER_ID", nullable = false, precision = 18, scale = 0)
	private Long checkerId;
	
	/** 审核人姓名 */
	@Column(name = "CHECKER_NAME", nullable = false, length = 40)
	private String checkerName;


	/** default constructor */
	public EmHealthCheck() {
	}

	/**
	 * @return healthCheckId
	 */
	public Long getHealthCheckId() {
		return healthCheckId;
	}

	/**
	 * @param healthCheckId 要设置的 healthCheckId
	 */
	public void setHealthCheckId(Long healthCheckId) {
		this.healthCheckId = healthCheckId;
	}

	/**
	 * @return healthReportId
	 */
	public Long getHealthReportId() {
		return healthReportId;
	}

	/**
	 * @param healthReportId 要设置的 healthReportId
	 */
	public void setHealthReportId(Long healthReportId) {
		this.healthReportId = healthReportId;
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
	 * @return checkOrgId
	 */
	public Long getCheckOrgId() {
		return checkOrgId;
	}

	/**
	 * @param checkOrgId 要设置的 checkOrgId
	 */
	public void setCheckOrgId(Long checkOrgId) {
		this.checkOrgId = checkOrgId;
	}

	/**
	 * @return checkOrgName
	 */
	public String getCheckOrgName() {
		return checkOrgName;
	}

	/**
	 * @param checkOrgName 要设置的 checkOrgName
	 */
	public void setCheckOrgName(String checkOrgName) {
		this.checkOrgName = checkOrgName;
	}

	/**
	 * @return checkTime
	 */
	public Date getCheckTime() {
		return checkTime;
	}

	/**
	 * @param checkTime 要设置的 checkTime
	 */
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * @return checkOpinion
	 */
	public String getCheckOpinion() {
		return checkOpinion;
	}

	/**
	 * @param checkOpinion 要设置的 checkOpinion
	 */
	public void setCheckOpinion(String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}

	/**
	 * @return checkerId
	 */
	public Long getCheckerId() {
		return checkerId;
	}

	/**
	 * @param checkerId 要设置的 checkerId
	 */
	public void setCheckerId(Long checkerId) {
		this.checkerId = checkerId;
	}

	/**
	 * @return checkerName
	 */
	public String getCheckerName() {
		return checkerName;
	}

	/**
	 * @param checkerName 要设置的 checkerName
	 */
	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}
}