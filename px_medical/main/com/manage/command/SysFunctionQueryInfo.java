package com.manage.command;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/** @author Hibernate CodeGenerator */
public class SysFunctionQueryInfo extends BaseCommandInfo {

    /** identifier field */
    private Long functionId;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String code;

    /** nullable persistent field */
    private String functionOperate;

    /** nullable persistent field */
    private Long parentId;

    /** nullable persistent field */
    private BigDecimal sort;

    private String topFlag;
    
    private String other;

    /** persistent field */
    private String[] sysType;

    /** 角色ids */
    private String roleIds;
    /** 用户userId */
    private Long userId;

    /** default constructor */
    public SysFunctionQueryInfo() {
    }

    /** minimal constructor */
    public SysFunctionQueryInfo(Long userId, String roleIds) {
        this.userId = userId;
        this.roleIds = roleIds;
    }

    /** minimal constructor */
    public SysFunctionQueryInfo(String other) {
        this.other = other;
    }

    public Long getFunctionId() {
        return this.functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFunctionOperate() {
        return this.functionOperate;
    }

    public void setFunctionOperate(String functionOperate) {
        this.functionOperate = functionOperate;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public BigDecimal getSort() {
        return this.sort;
    }

    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    public String getOther() {
        return this.other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String[] getSysType() {
        return this.sysType;
    }

    public void setSysType(String... sysType) {
        this.sysType = sysType;
    }

    /**
    * @return the roleIds
    */
    public String getRoleIds() {
        return roleIds;
    }

    /**
    * @param roleIds the roleIds to set
    */
    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    /**
    * @return the userId
    */
    public Long getUserId() {
        return userId;
    }

    /**
    * @param userId the userId to set
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

	/**
	 * @return the topFlag
	 */
	public String getTopFlag() {
		return topFlag;
	}

	/**
	 * @param topFlag the topFlag to set
	 */
	public void setTopFlag(String topFlag) {
		this.topFlag = topFlag;
	}

}
