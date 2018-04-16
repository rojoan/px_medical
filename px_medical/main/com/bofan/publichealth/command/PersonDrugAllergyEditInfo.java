package com.bofan.publichealth.command;

import javax.persistence.Column;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 家庭--个人对照 编辑内容
 * @author lqw
 */
public class PersonDrugAllergyEditInfo  extends BaseCommandInfo{

	private static final long serialVersionUID = 1L;
 
	/** 药物过敏名称ID  */
	@Column(name = "DRUG_ALLERGY_ID", nullable = false, precision = 18, scale = 0)
	private Long drugAllergyId;
	
	/** 个人基本档案ID  */
	private Long personDetailId;
	
	/** 过敏药物  */
	private String drugAllergyName;
	
	/** 其他药物过敏  */
	private String drugAllergyOther;

	/**
	 * @return drugAllergyId
	 */
	public Long getDrugAllergyId() {
		return drugAllergyId;
	}

	/**
	 * @param drugAllergyId 要设置的 drugAllergyId
	 */
	public void setDrugAllergyId(Long drugAllergyId) {
		this.drugAllergyId = drugAllergyId;
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
	 * @return drugAllergyName
	 */
	public String getDrugAllergyName() {
		return drugAllergyName;
	}

	/**
	 * @param drugAllergyName 要设置的 drugAllergyName
	 */
	public void setDrugAllergyName(String drugAllergyName) {
		this.drugAllergyName = drugAllergyName;
	}

	/**
	 * @return drugAllergyOther
	 */
	public String getDrugAllergyOther() {
		return drugAllergyOther;
	}

	/**
	 * @param drugAllergyOther 要设置的 drugAllergyOther
	 */
	public void setDrugAllergyOther(String drugAllergyOther) {
		this.drugAllergyOther = drugAllergyOther;
	}
	 
}