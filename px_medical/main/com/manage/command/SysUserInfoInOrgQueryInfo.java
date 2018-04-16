/*
 * <p> Title:  SysUserInfoInOrgQueryInfo.java</p>
 * <p>Copyright:   bofan 2017</p>
 * <p>Company: 博繁科技</p>
 */
package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;
import com.bofan.manage.valueobject.SysUser;

/**
 * <p> Calss Name:  SysUserInfoInOrgQueryInfo.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author pch
 * @created  2017年1月21日
 */
@QueryInfo(
        select = "distinct userInfo",
        from="com.bofan.manage.valueobject.SysUserInfo userInfo join fetch userInfo.sysUser sysUser join sysUser.userOrgs org", orderBy="userInfo.sort")
public class SysUserInfoInOrgQueryInfo extends BaseCommandInfo {
    private static final long serialVersionUID = -1345276227831723965L;
    
    @QueryParam(fieldName="userInfo.name", op=QueryOperator.LIKE)
    private String name;
    
    @QueryParam(fieldName="userInfo.userId")
    private Long userId;
    
    @QueryParam(fieldName="org.orgId")
    private Long[] orgIds;
    
    @QueryParam(fieldName="userInfo.userInfoId")
    private Long userInfoId;
    
    @QueryParam(fieldName="sysUser.account", op = QueryOperator.LIKE)
    private String account;
    
    @QueryParam(fieldName="sysUser.delFlag")
    private String[] delFlag = {SysUser.VALID_USER,SysUser.OA_USER, SysUser.CASE_USER};
    
    //用于参数传递
    private Long rootOrgId;
    //用于参数传递
    private boolean includeChildOrg = true;
    
     

    public Long[] getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(Long[] orgIds) {
        this.orgIds = orgIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String[] getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String[] delFlag) {
        this.delFlag = delFlag;
    }

    public Long getRootOrgId() {
        return rootOrgId;
    }

    public void setRootOrgId(Long rootOrgId) {
        this.rootOrgId = rootOrgId;
    }

    public boolean isIncludeChildOrg() {
        return includeChildOrg;
    }

    public void setIncludeChildOrg(boolean includeChildOrg) {
        this.includeChildOrg = includeChildOrg;
    }

    
}
