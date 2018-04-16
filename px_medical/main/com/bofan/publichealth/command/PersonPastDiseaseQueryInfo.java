package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 家庭--个人对照表查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.PersonPastDisease ", orderBy = "pastDiseaseId asc")
public class PersonPastDiseaseQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

	/** 个人既往疾病ID   */
	@QueryParam(fieldName = "pastDiseaseId", op = QueryOperator.EQU)
	private Long pastDiseaseId;
	
	/** 个人基本档案ID */
	@QueryParam(fieldName = "personDetailId", op = QueryOperator.EQU)
	private Long personDetailId;

	public PersonPastDiseaseQueryInfo() {
	}

	/**
	 * @return pastDiseaseId
	 */
	public Long getPastDiseaseId() {
		return pastDiseaseId;
	}

	/**
	 * @param pastDiseaseId 要设置的 pastDiseaseId
	 */
	public void setPastDiseaseId(Long pastDiseaseId) {
		this.pastDiseaseId = pastDiseaseId;
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