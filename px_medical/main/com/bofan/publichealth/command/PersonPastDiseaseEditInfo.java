package com.bofan.publichealth.command;

import java.util.Date;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 家庭--个人对照 编辑内容
 * @author lqw
 */
public class PersonPastDiseaseEditInfo  extends BaseCommandInfo{

	private static final long serialVersionUID = 1L;

	/** 个人既往疾病ID   */
	private Long pastDiseaseId;
	
	/** 个人基本档案ID  */
	private Long personDetailId;
	
	/** 疾病名称ID  */
	private Long diseaseId;
	
	/** 疾病名称  */
	private String diseaseName;
	
	/** 得病时间  */
	private Date diseaseTime;
	
	/** 得病部位名称具体描述  */
	private String diseaseContent;
	
	/** 是否为家族遗传病 1=是 0=否  */
	private String familyDiseaseFlag;
	
	/** 填写记录人ID  */
	private Long creatorId;
	
	/** 填写记录人  */
	private String creatorName;

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
	 * @return diseaseTime
	 */
	public Date getDiseaseTime() {
		return diseaseTime;
	}

	/**
	 * @param diseaseTime 要设置的 diseaseTime
	 */
	public void setDiseaseTime(Date diseaseTime) {
		this.diseaseTime = diseaseTime;
	}

	/**
	 * @return diseaseContent
	 */
	public String getDiseaseContent() {
		return diseaseContent;
	}

	/**
	 * @param diseaseContent 要设置的 diseaseContent
	 */
	public void setDiseaseContent(String diseaseContent) {
		this.diseaseContent = diseaseContent;
	}

	/**
	 * @return familyDiseaseFlag
	 */
	public String getFamilyDiseaseFlag() {
		return familyDiseaseFlag;
	}

	/**
	 * @param familyDiseaseFlag 要设置的 familyDiseaseFlag
	 */
	public void setFamilyDiseaseFlag(String familyDiseaseFlag) {
		this.familyDiseaseFlag = familyDiseaseFlag;
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
	 * @return creatorName
	 */
	public String getCreatorName() {
		return creatorName;
	}

	/**
	 * @param creatorName 要设置的 creatorName
	 */
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	 
}