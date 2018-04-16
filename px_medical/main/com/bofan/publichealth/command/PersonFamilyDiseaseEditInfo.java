package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 个人家族疾病史 编辑内容
 * @author lqw
 */
public class PersonFamilyDiseaseEditInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

	/** 个人家族疾病ID */
	private Long familyDiseaseId;

	/** 个人基本档案ID */
	private Long personDetailId;

	/** 家族成员标识 1=父亲 2=母亲 3=兄弟姐妹 4=子女 */
	private String familyMemberFlag;

	/** 家族成员 如： 父亲、母亲等 */
	private String familyMember;

	/** 疾病名称 中文描述，用“，”分割 */
	private String diseaseName;

	/** 疾病名称ID 保存disease疾病表 的 疾病ID， 用 , 分割 */
	private Long diseaseId;
	/**
	 * @return familyDiseaseId
	 */
	public Long getFamilyDiseaseId() {
		return familyDiseaseId;
	}

	/**
	 * @param familyDiseaseId  要设置的 familyDiseaseId
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
	 * @param personDetailId  要设置的 personDetailId
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
	 * @param diseaseName   要设置的 diseaseName
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
}