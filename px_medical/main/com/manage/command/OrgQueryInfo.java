/*
 * FileName:    OrgQueryInfo.java
 * Description:
 * Company:     博繁科技
 * Copyright:   bofan 2017
 * History:     2017-1-19 (PCH) 1.0 Create
 */
package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * The <code>OrgQueryInfo</code>
 *
 * @author  PCH
 * @version 1.0, 2017-1-19
 */
@SuppressWarnings("serial")
public class OrgQueryInfo extends BaseCommandInfo {
    /** 部门单位编号 */
    private Long orgId;
    private Long parentOrgId;

    /** 部门单位编号 */
    private Long userId;
    
    /** nullable persistent field */
    private Long unitOrgId;

    /** 部门单位名称 */
    private String name;

    /** 部门单位代码（like查询） */
    private String code;

    /** 部门单位代码(equ查询) */
    private String codeEqu;

    /** 县局标志 */
    private String orgRank;

    /** 县局标志(作为IN查询使用) */
    private String orgRanks;

    /** persistent field */
    private String delFlag;
    
    private String userDelFlag;
    
    /** 预设人员查询参数 ,逗号分隔*/
    private String userIds;
    private String orgName;
    /** 预设部门查询参数,逗号分隔 */
    private String orgIds;
    private String filterIds;
    
    /**
     * 该参数不为空，则在页面中显示短信输入框
     */
    private String withSms;

    /**
     * default constructor
     */
    public OrgQueryInfo() {
    }

    /**
     * minimal constructor
     * @param userId Long
     */
    public OrgQueryInfo(Long userId) {
    	this.userId = userId;
    }

    /**
     * minimal constructor
     * @param orgRanks (id,id)
     */
    public OrgQueryInfo(String orgRanks) {
        this.orgRanks = orgRanks;
    }

    /**
     * constructor
     * @param orgId
     * @param orgRank
     */
    public OrgQueryInfo(Long unitOrgId, String orgRank) {
        this.unitOrgId = unitOrgId;
        this.orgRank = orgRank;
    }

    /**
     * minimal constructor
     * @param unitOrgId
     * @param code String
     * @param codeEqu String
     */
    public OrgQueryInfo(Long unitOrgId,String code, String codeEqu) {
        this.unitOrgId = unitOrgId;
        this.code = code;
        this.codeEqu = codeEqu;
    }

    /**
     * @return the orgId
     */
    public Long getOrgId() {
        return orgId;
    }
    
    
    /**
     * @param orgId the orgId to set
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the orgRank
     */
    public String getOrgRank() {
        return orgRank;
    }

    /**
     * @param orgRank the orgRank to set
     */
    public void setOrgRank(String orgRank) {
        this.orgRank = orgRank;
    }

    /**
     * @return the orgRanks
     */
    public String getOrgRanks() {
        return orgRanks;
    }

    /**
     * @param orgRanks the orgRanks to set
     */
    public void setOrgRanks(String orgRanks) {
        this.orgRanks = orgRanks;
    }

    /**
     * @return the delFlag
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag the delFlag to set
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * @return the unitOrgId
     */
    public Long getUnitOrgId() {
        return unitOrgId;
    }

    /**
     * @param unitOrgId the unitOrgId to set
     */
    public void setUnitOrgId(Long unitOrgId) {
        this.unitOrgId = unitOrgId;
    } 
    
    /**
     * @return the withSms
     */
    public String getWithSms() {
        return withSms;
    }


    /**
     * @param withSms the withSms to set
     */
    public void setWithSms(String withSms) {
        this.withSms = withSms;
    }


    /**
     * @return the userIds
     */
    public String getUserIds() {
        return userIds;
    }


    /**
     * @param userIds the userIds to set
     */
    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }


    /**
     * @return the orgName
     */
    public String getOrgName() {
        return orgName;
    }


    /**
     * @param orgName the orgName to set
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }


    /**
     * @return the orgIds
     */
    public String getOrgIds() {
        return orgIds;
    }


    /**
     * @param orgIds the orgIds to set
     */
    public void setOrgIds(String orgIds) {
        this.orgIds = orgIds;
    }


    /**
     * @return the filterIds
     */
    public String getFilterIds() {
        return filterIds;
    }


    /**
     * @param filterIds the filterIds to set
     */
    public void setFilterIds(String filterIds) {
        this.filterIds = filterIds;
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
	 * @return the codeEqu
	 */
	public String getCodeEqu() {
		return codeEqu;
	}

	/**
	 * @param codeEqu the codeEqu to set
	 */
	public void setCodeEqu(String codeEqu) {
		this.codeEqu = codeEqu;
	}

	/**
	 * @return the userDelFlag
	 */
	public String getUserDelFlag() {
		return userDelFlag;
	}

	/**
	 * @param userDelFlag the userDelFlag to set
	 */
	public void setUserDelFlag(String userDelFlag) {
		this.userDelFlag = userDelFlag;
	}

	/**
	 * @return the parentOrgId
	 */
	public Long getParentOrgId() {
		return parentOrgId;
	}

	/**
	 * @param parentOrgId the parentOrgId to set
	 */
	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

 
}
