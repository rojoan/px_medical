package com.bofan.emergencyevent.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 专家库 查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.emergencyevent.valueobject.EmProfessor ")
public class EmProfessorQueryInfo extends BaseCommandInfo {
	
	private static final long serialVersionUID = -5540536874297793573L;
 
	/** 单位ID */
	@QueryParam(fieldName = "orgId", op = QueryOperator.EQU)
	private Long orgId;
	
	/** 队内职务 */
	@QueryParam(fieldName = "duty", op = QueryOperator.LIKE)
	private String duty;
	
	/** 专家姓名 */
	@QueryParam(fieldName = "name", op = QueryOperator.LIKE)
	private String name;
	
	/** 工作单位及职务 */
	@QueryParam(fieldName = "orgInnerDuty", op = QueryOperator.LIKE)
	private String orgInnerDuty;
	
	/** 性别 1：男 2：女 */
	@QueryParam(fieldName = "gender", op = QueryOperator.EQU)
	private String gender;
	
	/** 是否有效 1：有效 0：无效 */
	@QueryParam(fieldName = "validFlag", op = QueryOperator.EQU)
	private String validFlag;
	
	public EmProfessorQueryInfo() {
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
