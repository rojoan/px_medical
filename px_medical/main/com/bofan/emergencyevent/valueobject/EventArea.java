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
 * @Description: event_area（事件发生场所表）
 * @author lqw
 */
@Entity
@Table(name = "EVENT_AREA", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "EVENT_AREA_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".EVENT_AREA_ID", allocationSize = 1)
public class EventArea {

	/**
	 * 事件发生场所ID 001：学校 001001：托幼机构、 小学、 中学、 大、中专院校、综合类学校、其他 002：医疗卫生机构
	 * 002001：公办医疗机构、疾病预防控制机构、采供血机构、检验检疫机构、其他私立机构 003：医疗机构感染部门
	 * 003001：病房、手术室、门诊、化验室、药房、办公室、治疗室、特殊检查室、其他场所
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_AREA_ID")
	@Column(name = "EVENT_AREA_ID", unique = true, nullable = false, length = 18)
	private String eventAreaId;
	
	/** 事件发生场所 学校、餐饮服务单位、党政机关办公场所、城市住宅小区、其他重要公共场所等 */
	@Column(name = "EVENT_AREA", unique = true, nullable = false, length = 40)
	private String eventArea;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public EventArea() {
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

	/**
	 * @return eventArea
	 */
	public String getEventArea() {
		return eventArea;
	}

	/**
	 * @param eventArea
	 *            要设置的 eventArea
	 */
	public void setEventArea(String eventArea) {
		this.eventArea = eventArea;
	}

	/**
	 * @return validFlag
	 */
	public String getValidFlag() {
		return validFlag;
	}

	/**
	 * @param validFlag
	 *            要设置的 validFlag
	 */
	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

}