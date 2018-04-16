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
 * @Description: person_disability（个人残疾情况）
 * @author lqw
 */
@Entity
@Table(name = "PERSON_DISABILITY", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PERSON_DISABILITY_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_DISABILITY_ID", allocationSize = 1)
public class PersonDisability {

	/** 个人残疾情况ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_DISABILITY_ID")
	@Column(name = "PERSON_DISABILITY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long personDisabilityId;
	
	/** 残疾名称ID */
	@Column(name = "DISABILITY_ID",  nullable = false, precision = 18, scale = 0)
	private Long disabilityId;
	
	/** 个人基本档案ID  */
	@Column(name = "PERSON_DETAIL_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
	
	/** 填写记录人ID  */
	@Column(name = "CREATOR_ID", nullable = false, precision = 18, scale = 0)
	private Long creatorId;
	
	/** 填写记录人  */
	@Column(name = "CREATOR_NAME", nullable = false, length = 20)
	private String creatorName;
	
	/** 填写记录时间  */
	@Column(name = "CREATE_TIME", nullable = false)
	private Date createTime;

	/** default constructor */
	public PersonDisability() {
	}

	/**
	 * @return personDisabilityId
	 */
	public Long getPersonDisabilityId() {
		return personDisabilityId;
	}

	/**
	 * @param personDisabilityId 要设置的 personDisabilityId
	 */
	public void setPersonDisabilityId(Long personDisabilityId) {
		this.personDisabilityId = personDisabilityId;
	}

	/**
	 * @return disabilityId
	 */
	public Long getDisabilityId() {
		return disabilityId;
	}

	/**
	 * @param disabilityId 要设置的 disabilityId
	 */
	public void setDisabilityId(Long disabilityId) {
		this.disabilityId = disabilityId;
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