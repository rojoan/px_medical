/*
 * <p> Title:  UsersInfo.java</p>
 * <p>Copyright:   bofan 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.manage.command;

/**
 * <p> Calss Name:  UsersInfo.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author pch
 * @created  2018-7-19
 */
public class UsersInfo {
    private Long[] userInfoId;
    private Long[] orgId;
    
    public Long[] getUserInfoId() {
        return userInfoId;
    }
    public void setUserInfoId(Long[] userInfoId) {
        this.userInfoId = userInfoId;
    }
    public Long[] getOrgId() {
        return orgId;
    }
    public void setOrgId(Long[] orgId) {
        this.orgId = orgId;
    }
    
}
