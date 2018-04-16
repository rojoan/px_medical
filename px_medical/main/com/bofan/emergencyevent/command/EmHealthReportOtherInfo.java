package com.bofan.emergencyevent.command;


/** 突发公卫报告登记 相关 编辑内容
 * @author lqw
 */
public class EmHealthReportOtherInfo  extends EmHealthReportEditInfo {
	
	private static final long serialVersionUID = 2648836528443559326L;
	
	/** 主要症状ID */
	private Long[] cheifSymptomId;
	
	/** 事件发生场所ID  */
	private String[] eventAreaId; 
	
	/** 事件信息来源ID */
	private Long[] eventSourceId;

	public EmHealthReportOtherInfo() {
	}

	/**
	 * @return cheifSymptomId
	 */
	public Long[] getCheifSymptomId() {
		return cheifSymptomId;
	}

	/**
	 * @param cheifSymptomId 要设置的 cheifSymptomId
	 */
	public void setCheifSymptomId(Long[] cheifSymptomId) {
		this.cheifSymptomId = cheifSymptomId;
	}

	/**
	 * @return eventAreaId
	 */
	public String[] getEventAreaId() {
		return eventAreaId;
	}

	/**
	 * @param eventAreaId 要设置的 eventAreaId
	 */
	public void setEventAreaId(String[] eventAreaId) {
		this.eventAreaId = eventAreaId;
	}

	/**
	 * @return eventSourceId
	 */
	public Long[] getEventSourceId() {
		return eventSourceId;
	}

	/**
	 * @param eventSourceId 要设置的 eventSourceId
	 */
	public void setEventSourceId(Long[] eventSourceId) {
		this.eventSourceId = eventSourceId;
	}
	 
}