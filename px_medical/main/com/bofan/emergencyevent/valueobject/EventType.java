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
 * @Description: event_type（事件信息类别）
 * @author lqw
 */
@Entity
@Table(name = "EVENT_TYPE", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "EVENT_TYPE_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".EVENT_TYPE_ID", allocationSize=1)
public class EventType {

	// Fields
	/** 信息类别ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_TYPE_ID")
	@Column(name = "EVENT_TYPE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long eventTypeId;
	
	/** 信息类别名称 传染病，食物中毒，职业中毒，农药中毒事件，环境卫生，其他化学中毒，免疫接种，群体性不明原因疾病，医疗几个内感染，放射性卫生，其他公共卫生 */
	@Column(name = "EVENT_NAME", unique = true, nullable = false, length = 40)
	private String eventName;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;
	 
	/** default constructor */
	public EventType() {
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