/*
 * <p> Title:  UserQueryInfo.java</p>
 * <p>Copyright:   bofan 2018</p>
 * <p>Company: 博繁科技</p>
 */
package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * The <code>UserQueryInfo</code>
 *
 * @author  PCH
 * @version 1.0, 2017-12-2
 */
public class MultiUserQueryInfo extends BaseCommandInfo {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**  */
    private Long userId;
    /**  */
    private Long userInfoId;

    private Long orgId;
    private String delFlag;
    /** userNames */
    private String userNames;
    /** userIds */
    private String userIds;
    private String orgIds;
    private Long unitOrgId;

    /**
     * 构造函数
     */
    public MultiUserQueryInfo() {
    }

    /**
     * 构造函数
     * @param orgId
     */
    public MultiUserQueryInfo(Long orgId) {
        this.orgId = orgId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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
     * @return the userInfoId
     */
    public Long getUserInfoId() {
        return userInfoId;
    }

    /**
     * @param userInfoId the userInfoId to set
     */
    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    /**
    * @return the userNames
    */
    public String getUserNames() {
        return userNames;
    }

    /**
    * @param userNames the userNames to set
    */
    public void setUserNames(String userNames) {
        this.userNames = userNames;
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



}
