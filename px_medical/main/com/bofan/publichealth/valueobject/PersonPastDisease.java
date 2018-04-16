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
 * @Description: 个人既往史
 * @author lqw
 */
@Entity
@Table(name = "PERSON_PAST_DISEASE", schema = SchemaConsts.PUBLIC_HEALTH )
@SequenceGenerator(name = "PERSON_PAST_DISEASE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_PAST_DISEASE_ID", allocationSize = 1)
public class PersonPastDisease {

	/** 个人既往疾病ID   */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_PAST_DISEASE_ID")
	@Column(name = "PAST_DISEASE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long pastDiseaseId;
	
	/** 个人基本档案ID  */
	@Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
	
	/** 疾病名称ID  */
	@Column(name = "DISEASE_ID", nullable = false, precision = 18, scale = 0)
	private Long diseaseId;
	
	/** 疾病名称  */
	@Column(name = "DISEASE_NAME", nullable = false, length = 40)
	private String diseaseName;
	
	/** 得病时间  */
	@Column(name = "DISEASE_TIME", length = 7)
	private Date diseaseTime;
	
	/** 得病部位名称具体描述  */
	@Column(name = "DISEASE_CONTENT", length = 400)
	private String diseaseContent;
	
	/** 是否为家族遗传病 1=是 0=否  */
	@Column(name = "FAMILY_DISEASE_FLAG", length = 1)
	private String familyDiseaseFlag;
	
	/** 填写记录人ID  */
	@Column(name = "CREATOR_ID", nullable = false, precision = 18, scale = 0)
	private Long creatorId;
	
	/** 填写记录时间  */
	@Column(name = "CREATE_TIME", nullable = false)
	private Date createTime;

	/** default constructor */
	public PersonPastDisease() {
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