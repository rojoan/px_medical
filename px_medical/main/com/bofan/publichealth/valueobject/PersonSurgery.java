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
 * @Description: person_surgery（个人既往手术、外伤、输血史）
 * @author lqw
 */
@Entity
@Table(name = "PERSON_SURGERY", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PERSON_SURGERY_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_SURGERY_ID", allocationSize = 1)
public class PersonSurgery {
	
	/** 个人既往手术ID  */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SURGERY_ID")
	@Column(name = "SURGERY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long surgeryId;
	
	/** 个人基本档案ID  */
	@Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
	
	/** 手术名称  */
	@Column(name = "SURGERY_NAME", length = 100)
	private String surgeryName;
	
	/** 手术时间  */
	@Column(name = "SURGERY_TIME")
	private Date surgeryTime;
	
	/** 外伤名称  */
	@Column(name = "TRAUMA_NAME", length = 100)
	private String traumaName;

	/** 外伤时间  */
	@Column(name = "TRAUMA_TIME")
	private Date traumaTime;
	
	/** 输血原因  */
	@Column(name = "BLOOD_TRANS_REASON", length = 400)
	private String bloodTransReason;
	
	/** 输血时间  */
	@Column(name = "BLOOD_TRANS_TIME")
	private Date bloodTransTime;
	
	/** 填写记录人ID  */
	@Column(name = "CREATOR_ID", nullable = false, precision = 18, scale = 0)
	private Long creatorId;
	
	/** 填写记录时间  */
	@Column(name = "CREATE_TIME", nullable = false)
	private Date createTime;

	/** default constructor */
	public PersonSurgery() {
	}

	/**
	 * @return surgeryId
	 */
	public Long getSurgeryId() {
		return surgeryId;
	}

	/**
	 * @param surgeryId
	 *            要设置的 surgeryId
	 */
	public void setSurgeryId(Long surgeryId) {
		this.surgeryId = surgeryId;
	}

	/**
	 * @return personDetailId
	 */
	public Long getPersonDetailId() {
		return personDetailId;
	}

	/**
	 * @param personDetailId
	 *            要设置的 personDetailId
	 */
	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	/**
	 * @return surgeryName
	 */
	public String getSurgeryName() {
		return surgeryName;
	}

	/**
	 * @param surgeryName
	 *            要设置的 surgeryName
	 */
	public void setSurgeryName(String surgeryName) {
		this.surgeryName = surgeryName;
	}

	/**
	 * @return surgeryTime
	 */
	public Date getSurgeryTime() {
		return surgeryTime;
	}

	/**
	 * @param surgeryTime
	 *            要设置的 surgeryTime
	 */
	public void setSurgeryTime(Date surgeryTime) {
		this.surgeryTime = surgeryTime;
	}

	/**
	 * @return traumaName
	 */
	public String getTraumaName() {
		return traumaName;
	}

	/**
	 * @param traumaName
	 *            要设置的 traumaName
	 */
	public void setTraumaName(String traumaName) {
		this.traumaName = traumaName;
	}

	/**
	 * @return traumaTime
	 */
	public Date getTraumaTime() {
		return traumaTime;
	}

	/**
	 * @param traumaTime
	 *            要设置的 traumaTime
	 */
	public void setTraumaTime(Date traumaTime) {
		this.traumaTime = traumaTime;
	}

	/**
	 * @return bloodTransReason
	 */
	public String getBloodTransReason() {
		return bloodTransReason;
	}

	/**
	 * @param bloodTransReason
	 *            要设置的 bloodTransReason
	 */
	public void setBloodTransReason(String bloodTransReason) {
		this.bloodTransReason = bloodTransReason;
	}

	/**
	 * @return bloodTransTime
	 */
	public Date getBloodTransTime() {
		return bloodTransTime;
	}

	/**
	 * @param bloodTransTime
	 *            要设置的 bloodTransTime
	 */
	public void setBloodTransTime(Date bloodTransTime) {
		this.bloodTransTime = bloodTransTime;
	}

	/**
	 * @return creatorId
	 */
	public Long getCreatorId() {
		return creatorId;
	}

	/**
	 * @param creatorId
	 *            要设置的 creatorId
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
	 * @param createTime
	 *            要设置的 createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}