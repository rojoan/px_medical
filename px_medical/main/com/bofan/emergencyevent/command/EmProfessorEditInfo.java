package com.bofan.emergencyevent.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description:专家信息编辑内容
 * @author lqw
 */
public class EmProfessorEditInfo extends BaseCommandInfo{

	private static final long serialVersionUID = 1L;

	/** 专家库ID */
	private Long professorId;
	
	/** 单位ID */
	private Long orgId;
	
	/** 单位名称 */
	private String orgName;  
	
	/** 队内职务 */
	private String duty;
	
	/** 专家姓名 */
	private String name;
	
	/** 工作单位及职务 */
	private String orgInnerDuty;
	
	/** 性别 1：男 2：女 */
	private String gender;
	
	/** 出生年月  */
	private String birthDate;
	
	/** 职称  */
	private String profession;
	
	/** 学历  */
	private String diploma;

	/** 从事专业  */
	private String subject;
	
	/** 办公电话  */
	private String officeTel;
	
	/** 手机 */
	private String mobile;
	
	/** 排序号  */
	private Integer sort;
	
	/** 是否有效 1：有效 0：无效 */
	private String validFlag;

	/** default constructor */
	public EmProfessorEditInfo() {
	}

	/**
	 * @return professorId
	 */
	public Long getProfessorId() {
		return professorId;
	}

	/**
	 * @param professorId 要设置的 professorId
	 */
	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

	/**
	 * @return orgId
	 */
	public Long getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId 要设置的 orgId
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName 要设置的 orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * @return duty
	 */
	public String getDuty() {
		return duty;
	}

	/**
	 * @param duty 要设置的 duty
	 */
	public void setDuty(String duty) {
		this.duty = duty;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return orgInnerDuty
	 */
	public String getOrgInnerDuty() {
		return orgInnerDuty;
	}

	/**
	 * @param orgInnerDuty 要设置的 orgInnerDuty
	 */
	public void setOrgInnerDuty(String orgInnerDuty) {
		this.orgInnerDuty = orgInnerDuty;
	}

	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender 要设置的 gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate 要设置的 birthDate
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * @param profession 要设置的 profession
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 * @return diploma
	 */
	public String getDiploma() {
		return diploma;
	}

	/**
	 * @param diploma 要设置的 diploma
	 */
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

	/**
	 * @return subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject 要设置的 subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return officeTel
	 */
	public String getOfficeTel() {
		return officeTel;
	}

	/**
	 * @param officeTel 要设置的 officeTel
	 */
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	/**
	 * @return mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile 要设置的 mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * @param sort 要设置的 sort
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * @return validFlag
	 */
	public String getValidFlag() {
		return validFlag;
	}

	/**
	 * @param validFlag 要设置的 validFlag
	 */
	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

}