package com.bofan.emergencyevent.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 公卫事件审核
 * @author lqw
 */
public class EmHealthCheckEditInfo extends BaseCommandInfo{

	private static final long serialVersionUID = -3914948653917814194L;

	/** 公卫事件审核ID */
	private Long healthCheckId;
	
	/** 突发公卫报告ID */
	private Long healthReportId;
	
	/** 流行病学记录ID */
	private Long epidemiologyId;
	
	/** 审核单位ID */
	private Long checkOrgId;
	
	/** 审核单位名称 */
	private String checkOrgName;
	
	/** 审核日期 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date checkTime;
	
	/** 审核意见和建议 */
	private String checkOpinion;
	
	/** 审核人ID */
	private Long checkerId;
	
	/** 审核人姓名 */
	private String checkerName;


	/** default constructor */
	public EmHealthCheckEditInfo() {
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