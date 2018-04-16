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
 * @Description: person_family_disease（个人家族疾病史）
 * @author lqw
 */
@Entity
@Table(name = "PERSON_FAMILY_DISEASE", schema = SchemaConsts.PUBLIC_HEALTH )
@SequenceGenerator(name = "PERSON_FAMILY_DISEASE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_FAMILY_DISEASE_ID", allocationSize = 1)
public class PersonFamilyDisease {
	
	/** 个人家族疾病ID  */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_FAMILY_DISEASE_ID")
	@Column(name = "FAMILY_DISEASE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long familyDiseaseId;
	
	/** 个人基本档案ID  */
	@Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
	
	/** 家族成员标识 1=父亲 2=母亲 3=兄弟姐妹 4=子女  */
	@Column(name = "FAMILY_MEMBER_FLAG", nullable = false, length = 1)
	private String familyMemberFlag;

	/** 家族成员  如： 父亲、母亲等  */
	@Column(name = "FAMILY_MEMBER", nullable = false, length = 20)
	private String familyMember;
	
	/** 疾病名称 中文描述，用“，”分割  */
	@Column(name = "DISEASE_NAME", nullable = false, length = 100)
	private String diseaseName;
	
	/** 疾病名称ID 保存disease疾病表   的 疾病ID， 用 ,  分割  */
	@Column(name = "DISEASE_ID", nullable = false, precision = 18, scale = 0)
	private Long diseaseId;
	
	/** 填写记录人ID  */
	@Column(name = "CREATOR_ID", nullable = false, precision = 18, scale = 0)
	private Long creatorId;
	
	/** 填写记录时间  */
	@Column(name = "CREATE_TIME", nullable = false)
	private Date createTime;

	/** default constructor */
	public PersonFamilyDisease() {
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

	/**
	 * @return familyMemberFlag
	 */
	public String getFamilyMemberFlag() {
		return familyMemberFlag;
	}

	/**
	 * @param familyMemberFlag 要设置的 familyMemberFlag
	 */
	public void setFamilyMemberFlag(String familyMemberFlag) {
		this.familyMemberFlag = familyMemberFlag;
	}

	/**
	 * @return familyMember
	 */
	public String getFamilyMember() {
		return familyMember;
	}

	/**
	 * @param familyMember 要设置的 familyMember
	 */
	public void setFamilyMember(String familyMember) {
		this.familyMember = familyMember;
	}

	/**
	 * @return diseaseName
	 */
	public String getDiseaseName() {
		return diseaseName;
	}

	/**
	 * @param diseaseName 要设置的 diseaseName
	 */
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	
	/**
	 * @return diseaseId
	 */
	public Long getDiseaseId() {
		return diseaseId;
	}

	/**
	 * @param diseaseId 要设置的 diseaseId
	 */
	public void setDiseaseId(Long diseaseId) {
		this.diseaseId = diseaseId;
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