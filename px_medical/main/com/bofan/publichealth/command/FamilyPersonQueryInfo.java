package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 家庭--个人对照表查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.FamilyPerson ", orderBy = "familyPersonId desc")
public class FamilyPersonQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

	/** 家庭--个人对照ID */
	@QueryParam(fieldName = "familyPersonId", op = QueryOperator.EQU)
	private Long familyPersonId;
	
	/** 家庭基本档案ID */
	@QueryParam(fieldName = "familyDetailId", op = QueryOperator.EQU)
	private Long familyDetailId;

	/** 个人基本档案ID */
	private Long personDetailId;
	
	public FamilyPersonQueryInfo() {
		
	}
	
	public FamilyPersonQueryInfo(Long familyDetailId) {
		this.familyDetailId = familyDetailId;
	}

	/**
	 * @return familyPersonId
	 */
	public Long getFamilyPersonId() {
		return familyPersonId;
	}

	/**
	 * @param familyPersonId 要设置的 familyPersonId
	 */
	public void setFamilyPersonId(Long familyPersonId) {
		this.familyPersonId = familyPersonId;
	}

	/**
	 * @return familyDetailId
	 */
	public Long getFamilyDetailId() {
		return familyDetailId;
	}

	/**
	 * @param familyDetailId 要设置的 familyDetailId
	 */
	public void setFamilyDetailId(Long familyDetailId) {
		this.familyDetailId = familyDetailId;
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