package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;


/**
 * @Description:个人家族疾病史查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.PersonFamilyDisease ", orderBy = "familyMemberFlag asc ")
public class PersonFamilyDiseaseQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

	/** 个人家族疾病ID  */
	@QueryParam(fieldName = "familyDiseaseId", op = QueryOperator.EQU)
	private Long familyDiseaseId;

	/** 个人基本档案ID */
	@QueryParam(fieldName = "personDetailId", op = QueryOperator.EQU)
	private Long personDetailId;

	public PersonFamilyDiseaseQueryInfo() {
	}

	public PersonFamilyDiseaseQueryInfo(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	/**
	 * @return familyDiseaseId
	 */
	public Long getFamilyDiseaseId() {
		return familyDiseaseId;
	}

	/**
	 * @param familyDiseaseId 要设置的 familyDiseaseId
	 */
	public void setFamilyDiseaseId(Long familyDiseaseId) {
		this.familyDiseaseId = familyDiseaseId;
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

