package com.bofan.emergencyevent.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 突发公卫报告登记查询
 * @author lqw
 */
@QueryInfo(
        from = "com.bofan.emergencyevent.valueobject.EmHealthReport er", 
        orderBy = "er.healthReportId desc")
public class EmHealthReportQueryInfo extends BaseCommandInfo {
    /**
     * 
     */
    private static final long serialVersionUID = -5540536874297793573L;
    
    /** 报告人ID */
    @QueryParam(fieldName = "er.fillManId", op = QueryOperator.EQU)
	private Long fillManId;

    /** 事件名称 */
    @QueryParam(fieldName = "er.eventName", op = QueryOperator.LIKE)
	private String eventName;
    
    /** 信息类别ID */
    @QueryParam(fieldName = "er.eventTypeId", op = QueryOperator.EQU)
    private Long eventTypeId;
	
	/** 事件等级ID */
    @QueryParam(fieldName = "er.eventLevelId", op = QueryOperator.EQU)
	private Long eventLevelId;
    
    /** 事件发生日期开始时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "er.eventOccurTime", op = QueryOperator.GT_EQU)
    private Date eventOccurTimeStart;
    
    /** 事件发生日期结束时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "er.eventOccurTime", op = QueryOperator.LESS_EQU)
    private Date eventOccurTimeEnd;
    
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
	 * @return eventOccurTimeStart
	 */
	public Date getEventOccurTimeStart() {
		return eventOccurTimeStart;
	}

	/**
	 * @param eventOccurTimeStart 要设置的 eventOccurTimeStart
	 */
	public void setEventOccurTimeStart(Date eventOccurTimeStart) {
		this.eventOccurTimeStart = eventOccurTimeStart;
	}

	/**
	 * @return eventOccurTimeEnd
	 */
	public Date getEventOccurTimeEnd() {
		return eventOccurTimeEnd;
	}

	/**
	 * @param eventOccurTimeEnd 要设置的 eventOccurTimeEnd
	 */
	public void setEventOccurTimeEnd(Date eventOccurTimeEnd) {
		this.eventOccurTimeEnd = eventOccurTimeEnd;
	}
	
}
