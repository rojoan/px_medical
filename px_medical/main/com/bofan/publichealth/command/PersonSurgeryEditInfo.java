package com.bofan.publichealth.command;

import java.util.Date;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 个人既往手术、外伤、输血史 编辑内容
 * @author lqw
 */
public class PersonSurgeryEditInfo  extends BaseCommandInfo{

	private static final long serialVersionUID = 1L;

	/** 个人既往手术ID  */
	private Long surgeryId;
	
	/** 个人基本档案ID  */
	private Long personDetailId;
	
	/** 手术名称  */
	private String surgeryName;
	
	/** 手术时间  */
	private Date surgeryTime;
	
	/** 外伤名称  */
	private String traumaName;

	/** 外伤时间  */
	private Date traumaTime;
	
	/** 输血原因  */
	private String bloodTransReason;
	
	/** 输血时间  */
	private Date bloodTransTime;

	/**
	 * @return surgeryId
	 */
	public Long getSurgeryId() {
		return surgeryId;
	}

	/**
	 * @param surgeryId 要设置的 surgeryId
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
	 * @param personDetailId 要设置的 personDetailId
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
	 * @param surgeryName 要设置的 surgeryName
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
	 * @param surgeryTime 要设置的 surgeryTime
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
	 * @param traumaName 要设置的 traumaName
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
	 * @param traumaTime 要设置的 traumaTime
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
	 * @param bloodTransReason 要设置的 bloodTransReason
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
	 * @param bloodTransTime 要设置的 bloodTransTime
	 */
	public void setBloodTransTime(Date bloodTransTime) {
		this.bloodTransTime = bloodTransTime;
	}
}