package com.bofan.publichealth.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: person_drug_allergy（个人药物过敏史）
 * @author lqw
 */
@Entity
@Table(name = "PERSON_DRUG_ALLERGY", schema = SchemaConsts.PUBLIC_HEALTH )
@SequenceGenerator(name = "PERSON_DRUG_ALLERGY_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_DRUG_ALLERGY_ID", allocationSize = 1)
public class PersonDrugAllergy {
	
	/** 药物过敏ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_DRUG_ALLERGY_ID")
	@Column(name = "PERSON_DRUG_ALLERGY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long personDrugAllergyId;
	
	/** 个人基本档案ID  */
	@Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
	
	/** 药物过敏名称ID  */
	@Column(name = "DRUG_ALLERGY_ID", nullable = false, precision = 18, scale = 0)
	private Long drugAllergyId;
	
	/** 过敏药物  */
	@Column(name = "DRUG_ALLERGY_NAME", nullable = false, length = 40)
	private String drugAllergyName;
	
	/** 其他药物过敏  */
	@Column(name = "DRUG_ALLERGY_OTHER", length = 100)
	private String drugAllergyOther;
	
	/** 填写记录人ID  */
	@Column(name = "CREATOR_ID", nullable = false, precision = 18, scale = 0)
	private Long creatorId;
	
	/** 填写记录时间  */
	@Column(name = "CREATE_TIME", nullable = false)
	private Date createTime;
	
	/** default constructor */
	public PersonDrugAllergy() {
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

	/**
	 * @return creatorId
	 */
	public Long getCreatorId() {
		return creatorId;
	}
	/**
	 * @param creatorId 要设置的 creatorId
	 */
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	/**
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime 要设置的 createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}