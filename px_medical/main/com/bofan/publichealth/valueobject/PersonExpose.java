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
 * @Description: person_expose_disease（个人暴露史）
 * @author lqw
 */
@Entity
@Table(name = "PERSON_EXPOSE", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PERSON_EXPOSE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_EXPOSE_ID", allocationSize = 1)
public class PersonExpose {

	/** 个人暴露史ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_EXPOSE_ID")
	@Column(name = "PERSON_EXPOSE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long personExposeId;
	
	/** 个人基本档案ID */
	@Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
	
	/** 暴露名称ID */
	@Column(name = "EXPOSE_ID",  nullable = false, precision = 18, scale = 0)
	private Long exposeId;
	
	/** 暴露源名称 */
	@Column(name = "EXPOSE_NAME", nullable = false, length = 40)
	private String exposeName;
	
	/** 填写记录人ID */
	@Column(name = "CREATOR_ID", nullable = false, precision = 18, scale = 0)
	private Long creatorId;
	
	/** 填写记录时间 */
	@Column(name = "CREATE_TIME", nullable = false)
	private Date createTime;

	/** default constructor */
	public PersonExpose() {
	}

	/**
	 * @return personExposeId
	 */
	public Long getPersonExposeId() {
		return personExposeId;
	}

	/**
	 * @param personExposeId 要设置的 personExposeId
	 */
	public void setPersonExposeId(Long personExposeId) {
		this.personExposeId = personExposeId;
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
	 * @return exposeId
	 */
	public Long getExposeId() {
		return exposeId;
	}

	/**
	 * @param exposeId 要设置的 exposeId
	 */
	public void setExposeId(Long exposeId) {
		this.exposeId = exposeId;
	}

	/**
	 * @return exposeName
	 */
	public String getExposeName() {
		return exposeName;
	}

	/**
	 * @param exposeName 要设置的 exposeName
	 */
	public void setExposeName(String exposeName) {
		this.exposeName = exposeName;
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