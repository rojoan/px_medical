/*
 * FileName:    UserQueryInfo.java
 * Description:
 * Company:     博繁科技
 * Copyright:   bofan 2017
 * History:     2017-12-2 (PCH) 1.0 Create
 */
package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;


/**
 * The <code>UserQueryInfo</code>
 *
 * @author PCH
 * @version 1.0, 2017-12-2
 */
@SuppressWarnings("serial")
@QueryInfo(from="com.bofan.manage.valueobject.SysUser user")
public class SysUserQueryInfo extends BaseCommandInfo {

    @QueryParam(fieldName="user.userId", op=QueryOperator.EQU)
    private Long userId;
    @QueryParam(fieldName="user.account", op=QueryOperator.EQU)
    private String account;
    @QueryParam(fieldName="user.delFlag", op=QueryOperator.EQU)
    private String delFlag;
    @QueryParam(fieldName="user.delFlag", op=QueryOperator.NOT_EQU)
    private String notDelFlag;
    @QueryParam(fieldName="user.password", op=QueryOperator.EQU)
    private String password;    
    @QueryParam(fieldName="user.status", op=QueryOperator.EQU)
    private String status;

    /**
     * constructor default
     */
    public SysUserQueryInfo() {
    }

    /**
     * mini constructor
     * @param orgId
     */
    public SysUserQueryInfo(Long userId) {
        this.userId = userId;
    }

    /**
     * @param account
     */
    public SysUserQueryInfo(String account) {
        this.account = account;
    }

    public SysUserQueryInfo(String account, String delFlag) {
        this.account = account;
        this.setDelFlag(delFlag);
    }
    

    /**
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
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
     * @param delFlag
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * @return
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the notDelFlag
     */
    public String getNotDelFlag() {
        return notDelFlag;
    }

    /**
     * @param notDelFlag the notDelFlag to set
     */
    public void setNotDelFlag(String notDelFlag) {
        this.notDelFlag = notDelFlag;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
