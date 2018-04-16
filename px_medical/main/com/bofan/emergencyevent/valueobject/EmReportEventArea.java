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
 * @Description: 突发公卫报告表 与 事件发生场所 对照表
 * @author lqw
 */
@Entity
@Table(name = "EM_REPORT_EVENT_AREA", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "EM_REPORT_EVENT_AREA_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".EM_REPORT_EVENT_AREA_ID", allocationSize = 1)
public class EmReportEventArea {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EM_REPORT_EVENT_AREA_ID")
	@Column(name = "REPROT_EVENT_AREA_ID", unique = true, nullable = false, length = 18)
	private Long reprotEventAreaId;

	/** 突发公卫报告ID */
	@Column(name = "HEALTH_REPORT_ID", nullable = false, precision = 18, scale = 0)
	private Long healthReportId;

	/** 事件发生场所ID */
	@Column(name = "EVENT_AREA_ID", nullable = false, length = 18)
	private String eventAreaId;

	/** default constructor */
	public EmReportEventArea() {
	}

	/**
	 * @return reprotEventAreaId
	 */
	public Long getReprotEventAreaId() {
		return reprotEventAreaId;
	}

	/**
	 * @param reprotEventAreaId
	 *            要设置的 reprotEventAreaId
	 */
	public void setReprotEventAreaId(Long reprotEventAreaId) {
		this.reprotEventAreaId = reprotEventAreaId;
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
	 * @return eventAreaId
	 */
	public String getEventAreaId() {
		return eventAreaId;
	}

	/**
	 * @param eventAreaId
	 *            要设置的 eventAreaId
	 */
	public void setEventAreaId(String eventAreaId) {
		this.eventAreaId = eventAreaId;
	}
}