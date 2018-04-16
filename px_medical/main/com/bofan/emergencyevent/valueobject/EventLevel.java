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
 * @Description: event_level（事件等级）
 * @author lqw
 */
@Entity
@Table(name = "EVENT_LEVEL", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "EVENT_LEVEL_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".EVENT_LEVEL_ID", allocationSize=1)
public class EventLevel {

	/** 事件等级ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_LEVEL_ID")
	@Column(name = "EVENT_LEVEL_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long eventLevelId;
	
	/** 事件等级 特别重大、重大、较大、一般、未分级、非突发事件 */
	@Column(name = "LEVEL_NAME", unique = true, nullable = false, length = 40)
	private String levelName;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public EventLevel() {
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
	 * @return levelName
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * @param levelName 要设置的 levelName
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
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