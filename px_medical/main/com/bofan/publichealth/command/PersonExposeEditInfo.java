package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 个人暴露史 编辑内容
 * @author lqw
 */
public class PersonExposeEditInfo  extends BaseCommandInfo{

	private static final long serialVersionUID = 1L;

	/** 个人基本档案ID */
	private Long personDetailId;
	
	/** 暴露名称ID */
	private Long exposeId;
	
	/** 暴露源 */
	private String exposeName;

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
}