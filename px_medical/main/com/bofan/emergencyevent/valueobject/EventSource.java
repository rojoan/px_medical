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
 * @Description: event_source（事件信息来源）
 * @author lqw
 */
@Entity
@Table(name = "EVENT_SOURCE", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "EVENT_SOURCE_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".EVENT_SOURCE_ID", allocationSize=1)
public class EventSource {

	/** 事件信息来源ID，自动增长ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_SOURCE_ID")
	@Column(name = "EVENT_SOURCE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long eventSourceId;
	
	/** 事件信息来源 */
	@Column(name = "INFO_SOURCE", unique = true, nullable = false, length = 40)
	private String infoSource;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;
	 
	/** default constructor */
	public EventSource() {
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

	/**
	 * @return infoSource
	 */
	public String getInfoSource() {
		return infoSource;
	}

	/**
	 * @param infoSource 要设置的 infoSource
	 */
	public void setInfoSource(String infoSource) {
		this.infoSource = infoSource;
	}

	/**
	 * @return validFlag
	 */
	public String getValidFlag() {
		return validFlag;
	}

	/**
	 * @param validFlag 要设置的 validFlag
	 */
	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

}