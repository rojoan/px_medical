package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;


/**
 * @Description:个人暴露史查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.PersonExpose", orderBy = "personExposeId asc")
public class PersonExposeQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

	/** 个人暴露史ID */
	@QueryParam(fieldName = "personExposeId", op = QueryOperator.EQU)
	private Long personExposeId;
	
	/** 个人基本档案ID */
	@QueryParam(fieldName = "personDetailId", op = QueryOperator.EQU)
	private Long personDetailId;

	public PersonExposeQueryInfo() {
	
	}

	public PersonExposeQueryInfo(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	/**
	 * @return personExposeId
	 */
	public Long getPersonExposeId() {
		return personExposeId;
	}

	/**
	 * @param personExposeId 要设置的 personExposeId
	 */
	public void setPersonExposeId(Long personExposeId) {
		this.personExposeId = personExposeId;
	}

	/**
	 * @return personDetailId
	 */
	public Long getPersonDetailId() {
		return personDetailId;
	}

	/**
	 * @param personDetailId 要设置的 personDetailId
	 */
	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}
}

