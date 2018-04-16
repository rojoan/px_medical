package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;


/**
 * @Description:个人既往手术、外伤、输血史查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.PersonSurgery ", orderBy = "surgeryName ,traumaName,bloodTransReason")
public class PersonSurgeryQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

	/** 个人既往手术ID  */
	@QueryParam(fieldName = "surgeryId", op = QueryOperator.EQU)
	private Long surgeryId;

	/** 个人基本档案ID */
	@QueryParam(fieldName = "personDetailId", op = QueryOperator.EQU)
	private Long personDetailId;

	public PersonSurgeryQueryInfo() {
	}

	public PersonSurgeryQueryInfo(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	/**
	 * @return surgeryId
	 */
	public Long getSurgeryId() {
		return surgeryId;
	}

	/**
	 * @param surgeryId 要设置的 surgeryId
	 */
	public void setSurgeryId(Long surgeryId) {
		this.surgeryId = surgeryId;
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

