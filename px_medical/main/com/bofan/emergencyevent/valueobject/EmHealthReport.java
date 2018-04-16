package com.bofan.emergencyevent.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: em_health_report（突发公卫报告表）
 * @author lqw
 */
@Entity
@Table(name = "EM_HEALTH_REPORT", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "EM_HEALTH_REPORT_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".EM_HEALTH_REPORT_ID", allocationSize=1)
public class EmHealthReport {

	/** 突发公卫报告ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EM_HEALTH_REPORT_ID")
	@Column(name = "HEALTH_REPORT_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long healthReportId;
	
	/** 信息类别ID */
	@Column(name = "EVENT_TYPE_ID", precision = 18, scale = 0)
	private Long eventTypeId;
	
	/** 信息类别对象 **/
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EVENT_TYPE_ID", insertable = false, updatable = false)
    private EventType eventType;
	
	/** 事件等级ID */
	@Column(name = "EVENT_LEVEL_ID", precision = 18, scale = 0)
	private Long eventLevelId;
	
	/** 事件等级对象 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EVENT_LEVEL_ID", insertable = false, updatable = false)
	private EventLevel eventLevel;
	
	/** 填报单位ID */
	@Column(name = "FILL_ORG_ID", precision = 18, scale = 0)
	private Long fillOrgId;
	
	/** 填报单位名称 */
	@Column(name = "FILL_ORG_NAME", nullable = false, length = 200)
	private String fillOrgName;
	
	/** 填报日期 */
	@Column(name = "FILL_TIME")
	private Date fillTime;
	
	/** 报告人ID */
	@Column(name = "FILL_MAN_ID", precision = 18, scale = 0)
	private Long fillManId;	
	
	/** 填报人 */
	@Column(name = "FILL_MAN_NAME", nullable = false, length = 40)
	private String fillManName;
	
	/** 联系电话 */
	@Column(name = "LINKMAN_PHONE", length = 40)
	private String linkmanPhone;
	
	/** 事件名称 */
	@Column(name = "EVENT_NAME", length = 200)
	private String eventName;
	
	/** 初步诊断 */
	@Column(name = "FIRST_DIAGNOSIS", length = 4000)
	private String firstDiagnosis;
	
	/** 初步诊断日期 */
	@Column(name = "FIRST_DIAGNOSIS_TIME")
	private Date firstDiagnosisTime;
	
	/** 订正诊断 */
	@Column(name = "MODIFY_DIAGNOSIS", length = 4000)
	private String modifyDiagnosis;
	
	/** 订正诊断日期 */
	@Column(name = "MODIFY_DIAGNOSIS_TIME")
	private Date modifyDiagnosisTime;
	
	/** 确定分级日期 */
	@Column(name = "LEVEL_TIME")
	private Date levelTime;
	
	/** 订正分级日期 */
	@Column(name = "MODIFY_LEVEL_TIME")
	private Date modifyLevelTime;
	
	/** 报告地区（行政区域--城镇街道ID） 对应公卫系统 region（行政区域--城镇街道表） */
	@Column(name = "REPORT_REGION_ID", length = 18)
	private String reportRegionId;
	
	/** 发生地区（行政区域--城镇街道ID） 对应公卫系统 region（行政区域--城镇街道表） */
	@Column(name = "OCCUR_REGION_ID", length = 18)
	private String occurRegionId;
	
	/** 详细地点 */
	@Column(name = "REPORT_ADDR", length = 400)
	private String reportAddr;
	
	/** 事件信息来源详细 */
	@Column(name = "EVENT_SOURCE", length = 600)
	private String eventSource;
	
	/** 事件波及地域范围 */
	@Column(name = "EVENT_AREA", length = 600)
	private String eventArea;
	
	/** 新报告病历数 */
	@Column(name = "FILL_ILL_COUNT", precision = 18, scale = 0)
	private Long fillIllCount;
	
	/** 排除病例数 */
	@Column(name = "EXCLUDE_ILL_COUNT", precision = 18, scale = 0)
	private Long excludeIllCount;
	
	/** 累计报告病历数 */
	@Column(name = "ADD_ILL_COUNT", precision = 18, scale = 0)
	private Long addIllCount;
	
	/** 累计报告死亡数 */
	@Column(name = "ADD_DIE_COUNT", precision = 18, scale = 0)
	private Long addDieCount;
	
	/** 事件发生日期 */
	@Column(name = "EVENT_OCCUR_TIME")
	private Date eventOccurTime;
	
	/** 接到报告日期 */
	@Column(name = "EVENT_REPORT_TIME")
	private Date eventReportTime;
	
	/** 首例病人发病日期 */
	@Column(name = "FIRST_ATTACK_TIME")
	private Date firstAttackTime;
	
	/** 末例病人发病日期 */
	@Column(name = "END_ATTACK_TIME")
	private Date endAttackTime;
	
	/** 主要体征 */
	@Column(name = "MAIN_SIGN", length = 600)
	private String mainSign;
	
	/** 主要措施与效果 */
	@Column(name = "MAIN_MEASURE", length = 600)
	private String mainMeasure;

	/** default constructor */
	public EmHealthReport() {
	
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
	 * @return eventTypeId
	 */
	public Long getEventTypeId() {
		return eventTypeId;
	}

	/**
	 * @param eventTypeId 要设置的 eventTypeId
	 */
	public void setEventTypeId(Long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	/**
	 * @return eventType
	 */
	public EventType getEventType() {
		return eventType;
	}

	/**
	 * @param eventType 要设置的 eventType
	 */
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return eventLevelId
	 */
	public Long getEventLevelId() {
		return eventLevelId;
	}

	/**
	 * @param eventLevelId 要设置的 eventLevelId
	 */
	public void setEventLevelId(Long eventLevelId) {
		this.eventLevelId = eventLevelId;
	}

	/**
	 * @return eventLevel
	 */
	public EventLevel getEventLevel() {
		return eventLevel;
	}

	/**
	 * @param eventLevel 要设置的 eventLevel
	 */
	public void setEventLevel(EventLevel eventLevel) {
		this.eventLevel = eventLevel;
	}

	/**
	 * @return fillOrgId
	 */
	public Long getFillOrgId() {
		return fillOrgId;
	}

	/**
	 * @param fillOrgId 要设置的 fillOrgId
	 */
	public void setFillOrgId(Long fillOrgId) {
		this.fillOrgId = fillOrgId;
	}

	/**
	 * @return fillTime
	 */
	public Date getFillTime() {
		return fillTime;
	}

	/**
	 * @param fillTime 要设置的 fillTime
	 */
	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}

	/**
	 * @return fillManId
	 */
	public Long getFillManId() {
		return fillManId;
	}

	/**
	 * @param fillManId 要设置的 fillManId
	 */
	public void setFillManId(Long fillManId) {
		this.fillManId = fillManId;
	}



	/**
	 * @return linkmanPhone
	 */
	public String getLinkmanPhone() {
		return linkmanPhone;
	}

	/**
	 * @param linkmanPhone 要设置的 linkmanPhone
	 */
	public void setLinkmanPhone(String linkmanPhone) {
		this.linkmanPhone = linkmanPhone;
	}

	/**
	 * @return eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName 要设置的 eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return firstDiagnosis
	 */
	public String getFirstDiagnosis() {
		return firstDiagnosis;
	}

	/**
	 * @param firstDiagnosis 要设置的 firstDiagnosis
	 */
	public void setFirstDiagnosis(String firstDiagnosis) {
		this.firstDiagnosis = firstDiagnosis;
	}

	/**
	 * @return firstDiagnosisTime
	 */
	public Date getFirstDiagnosisTime() {
		return firstDiagnosisTime;
	}

	/**
	 * @param firstDiagnosisTime 要设置的 firstDiagnosisTime
	 */
	public void setFirstDiagnosisTime(Date firstDiagnosisTime) {
		this.firstDiagnosisTime = firstDiagnosisTime;
	}

	/**
	 * @return modifyDiagnosis
	 */
	public String getModifyDiagnosis() {
		return modifyDiagnosis;
	}

	/**
	 * @param modifyDiagnosis 要设置的 modifyDiagnosis
	 */
	public void setModifyDiagnosis(String modifyDiagnosis) {
		this.modifyDiagnosis = modifyDiagnosis;
	}

	/**
	 * @return modifyDiagnosisTime
	 */
	public Date getModifyDiagnosisTime() {
		return modifyDiagnosisTime;
	}

	/**
	 * @param modifyDiagnosisTime 要设置的 modifyDiagnosisTime
	 */
	public void setModifyDiagnosisTime(Date modifyDiagnosisTime) {
		this.modifyDiagnosisTime = modifyDiagnosisTime;
	}

	/**
	 * @return levelTime
	 */
	public Date getLevelTime() {
		return levelTime;
	}

	/**
	 * @param levelTime 要设置的 levelTime
	 */
	public void setLevelTime(Date levelTime) {
		this.levelTime = levelTime;
	}

	/**
	 * @return modifyLevelTime
	 */
	public Date getModifyLevelTime() {
		return modifyLevelTime;
	}

	/**
	 * @param modifyLevelTime 要设置的 modifyLevelTime
	 */
	public void setModifyLevelTime(Date modifyLevelTime) {
		this.modifyLevelTime = modifyLevelTime;
	}

	/**
	 * @return reportRegionId
	 */
	public String getReportRegionId() {
		return reportRegionId;
	}

	/**
	 * @param reportRegionId 要设置的 reportRegionId
	 */
	public void setReportRegionId(String reportRegionId) {
		this.reportRegionId = reportRegionId;
	}

	/**
	 * @return occurRegionId
	 */
	public String getOccurRegionId() {
		return occurRegionId;
	}

	/**
	 * @param occurRegionId 要设置的 occurRegionId
	 */
	public void setOccurRegionId(String occurRegionId) {
		this.occurRegionId = occurRegionId;
	}

	/**
	 * @return reportAddr
	 */
	public String getReportAddr() {
		return reportAddr;
	}

	/**
	 * @param reportAddr 要设置的 reportAddr
	 */
	public void setReportAddr(String reportAddr) {
		this.reportAddr = reportAddr;
	}

	/**
	 * @return eventSource
	 */
	public String getEventSource() {
		return eventSource;
	}

	/**
	 * @param eventSource 要设置的 eventSource
	 */
	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}

	/**
	 * @return eventArea
	 */
	public String getEventArea() {
		return eventArea;
	}

	/**
	 * @param eventArea 要设置的 eventArea
	 */
	public void setEventArea(String eventArea) {
		this.eventArea = eventArea;
	}

	/**
	 * @return fillIllCount
	 */
	public Long getFillIllCount() {
		return fillIllCount;
	}

	/**
	 * @param fillIllCount 要设置的 fillIllCount
	 */
	public void setFillIllCount(Long fillIllCount) {
		this.fillIllCount = fillIllCount;
	}

	/**
	 * @return excludeIllCount
	 */
	public Long getExcludeIllCount() {
		return excludeIllCount;
	}

	/**
	 * @param excludeIllCount 要设置的 excludeIllCount
	 */
	public void setExcludeIllCount(Long excludeIllCount) {
		this.excludeIllCount = excludeIllCount;
	}

	/**
	 * @return addIllCount
	 */
	public Long getAddIllCount() {
		return addIllCount;
	}

	/**
	 * @param addIllCount 要设置的 addIllCount
	 */
	public void setAddIllCount(Long addIllCount) {
		this.addIllCount = addIllCount;
	}

	/**
	 * @return addDieCount
	 */
	public Long getAddDieCount() {
		return addDieCount;
	}

	/**
	 * @param addDieCount 要设置的 addDieCount
	 */
	public void setAddDieCount(Long addDieCount) {
		this.addDieCount = addDieCount;
	}

	/**
	 * @return eventOccurTime
	 */
	public Date getEventOccurTime() {
		return eventOccurTime;
	}

	/**
	 * @param eventOccurTime 要设置的 eventOccurTime
	 */
	public void setEventOccurTime(Date eventOccurTime) {
		this.eventOccurTime = eventOccurTime;
	}

	/**
	 * @return eventReportTime
	 */
	public Date getEventReportTime() {
		return eventReportTime;
	}

	/**
	 * @param eventReportTime 要设置的 eventReportTime
	 */
	public void setEventReportTime(Date eventReportTime) {
		this.eventReportTime = eventReportTime;
	}

	/**
	 * @return firstAttackTime
	 */
	public Date getFirstAttackTime() {
		return firstAttackTime;
	}

	/**
	 * @param firstAttackTime 要设置的 firstAttackTime
	 */
	public void setFirstAttackTime(Date firstAttackTime) {
		this.firstAttackTime = firstAttackTime;
	}

	/**
	 * @return endAttackTime
	 */
	public Date getEndAttackTime() {
		return endAttackTime;
	}

	/**
	 * @param endAttackTime 要设置的 endAttackTime
	 */
	public void setEndAttackTime(Date endAttackTime) {
		this.endAttackTime = endAttackTime;
	}

	/**
	 * @return mainSign
	 */
	public String getMainSign() {
		return mainSign;
	}

	/**
	 * @param mainSign 要设置的 mainSign
	 */
	public void setMainSign(String mainSign) {
		this.mainSign = mainSign;
	}

	/**
	 * @return mainMeasure
	 */
	public String getMainMeasure() {
		return mainMeasure;
	}

	/**
	 * @param mainMeasure 要设置的 mainMeasure
	 */
	public void setMainMeasure(String mainMeasure) {
		this.mainMeasure = mainMeasure;
	}

	/**
	 * @return fillOrgName
	 */
	public String getFillOrgName() {
		return fillOrgName;
	}	

	/**
	 * @param fillOrgName 要设置的 fillOrgName
	 */
	public void setFillOrgName(String fillOrgName) {
		this.fillOrgName = fillOrgName;
	}

	/**
	 * @return fillManName
	 */
	public String getFillManName() {
		return fillManName;
	}

	/**
	 * @param fillManName 要设置的 fillManName
	 */
	public void setFillManName(String fillManName) {
		this.fillManName = fillManName;
	} 
	
}