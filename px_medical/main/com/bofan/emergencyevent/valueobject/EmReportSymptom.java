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
@Table(name = "EM_REPORT_SYMPTOM", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "EM_REPORT_SYMPTOM_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".EM_REPORT_SYMPTOM_ID", allocationSize = 1)
public class EmReportSymptom {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EM_REPORT_SYMPTOM_ID")
	@Column(name = "REPORT_SYMPTOM_ID", unique = true, nullable = false, length = 18)
	private Long reportSymptomId;

	/** 突发公卫报告ID */
	@Column(name = "HEALTH_REPORT_ID", nullable = false, precision = 18, scale = 0)
	private Long healthReportId;

	/** 主要症状ID */
	@Column(name = "CHEIF_SYMPTOM_ID",  nullable = false, precision = 18, scale = 0)
	private Long cheifSymptomId;

	/** default constructor */
	public EmReportSymptom() {
	}

	/**
	 * @return reportSymptomId
	 */
	public Long getReportSymptomId() {
		return reportSymptomId;
	}

	/**
	 * @param reportSymptomId 要设置的 reportSymptomId
	 */
	public void setReportSymptomId(Long reportSymptomId) {
		this.reportSymptomId = reportSymptomId;
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
	 * @return cheifSymptomId
	 */
	public Long getCheifSymptomId() {
		return cheifSymptomId;
	}

	/**
	 * @param cheifSymptomId 要设置的 cheifSymptomId
	 */
	public void setCheifSymptomId(Long cheifSymptomId) {
		this.cheifSymptomId = cheifSymptomId;
	}
}