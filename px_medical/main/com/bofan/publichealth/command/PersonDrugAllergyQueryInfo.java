package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;


/**
 * @Description:个人药物过敏史查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.PersonDrugAllergy ", orderBy = "personDrugAllergyId asc")
public class PersonDrugAllergyQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

	/** 药物过敏ID */
	@QueryParam(fieldName = "personDrugAllergyId", op = QueryOperator.EQU)
	private Long personDrugAllergyId;

	/** 个人基本档案ID */
	@QueryParam(fieldName = "personDetailId", op = QueryOperator.EQU)
	private Long personDetailId;

	public PersonDrugAllergyQueryInfo() {
	}

	public PersonDrugAllergyQueryInfo(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	/**
	 * @return personDrugAllergyId
	 */
	public Long getPersonDrugAllergyId() {
		return personDrugAllergyId;
	}

	/**
	 * @param personDrugAllergyId 要设置的 personDrugAllergyId
	 */
	public void setPersonDrugAllergyId(Long personDrugAllergyId) {
		this.personDrugAllergyId = personDrugAllergyId;
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

