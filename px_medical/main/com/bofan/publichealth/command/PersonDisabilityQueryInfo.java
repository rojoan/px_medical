package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description:个人残疾情况查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.PersonDisability ", orderBy = "personDisabilityId asc")
public class PersonDisabilityQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

	/** 个人残疾情况ID */
	@QueryParam(fieldName = "personDisabilityId", op = QueryOperator.EQU)
	private Long personDisabilityId;

	/** 个人基本档案ID */
	@QueryParam(fieldName = "personDetailId", op = QueryOperator.EQU)
	private Long personDetailId;

	public PersonDisabilityQueryInfo() {
	}

	public PersonDisabilityQueryInfo(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	/**
	 * @return personDisabilityId
	 */
	public Long getPersonDisabilityId() {
		return personDisabilityId;
	}

	/**
	 * @param personDisabilityId
	 *            要设置的 personDisabilityId
	 */
	public void setPersonDisabilityId(Long personDisabilityId) {
		this.personDisabilityId = personDisabilityId;
	}

	/**
	 * @return personDetailId
	 */
	public Long getPersonDetailId() {
		return personDetailId;
	}

	/**
	 * @param personDetailId
	 *            要设置的 personDetailId
	 */
	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

}