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
 * @Description: 突发公卫报告表 与事件信息来源 对照表
 * @author lqw
 */
@Entity
@Table(name = "EM_REPORT_EVENT_SOURCE", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "EM_REPORT_EVENT_SOURCE_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".EM_REPORT_EVENT_SOURCE_ID", allocationSize = 1)
public class EmReportEventSource {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EM_REPORT_EVENT_SOURCE_ID")
	@Column(name = "REPORT_EVENT_SOURCE_ID", unique = true, nullable = false, length = 18)
	private Long reportEventSourceId;

	/** 突发公卫报告ID */
	@Column(name = "HEALTH_REPORT_ID", nullable = false, precision = 18, scale = 0)
	private Long healthReportId;

	/** 事件信息来源ID，自动增长ID */
	@Column(name = "EVENT_SOURCE_ID", nullable = false, precision = 18, scale = 0)
	private Long eventSourceId;

	/** default constructor */
	public EmReportEventSource() {
	}

	/**
	 * @return reportEventSourceId
	 */
	public Long getReportEventSourceId() {
		return reportEventSourceId;
	}

	/**
	 * @param reportEventSourceId 要设置的 reportEventSourceId
	 */
	public void setReportEventSourceId(Long reportEventSourceId) {
		this.reportEventSourceId = reportEventSourceId;
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
	 * @return eventSourceId
	 */
	public Long getEventSourceId() {
		return eventSourceId;
	}

	/**
	 * @param eventSourceId 要设置的 eventSourceId
	 */
	public void setEventSourceId(Long eventSourceId) {
		this.eventSourceId = eventSourceId;
	}
}