package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 家庭--个人关系 编辑内容
 * @author lqw
 */
public class FamilyPersonEditInfo  extends BaseCommandInfo{

	private static final long serialVersionUID = 1L;

	/** 个人基本档案ID */
	private Long personDetailId;

	/** 家庭基本档案ID */
	private Long familyDetailId;

	/** 家庭关系ID */
	private Long familyRelId;
	
	/** default constructor */
	public FamilyPersonEditInfo() {
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
	 * @return familyRelId
	 */
	public Long getFamilyRelId() {
		return familyRelId;
	}

	/**
	 * @param familyRelId 要设置的 familyRelId
	 */
	public void setFamilyRelId(Long familyRelId) {
		this.familyRelId = familyRelId;
	}
}