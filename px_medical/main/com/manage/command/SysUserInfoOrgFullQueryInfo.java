/*
 * <p> Title:  SysUserInfoOrgFullQueryInfo.java</p>
 * <p>Copyright:   bofan 2017</p>
 * <p>Company: 博繁科技</p>
 */
package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryParam;

/**
 * <p> Calss Name:  SysUserInfoOrgFullQueryInfo.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author pch
 * @created  2017年1月21日
 */
@QueryInfo(
        select = "distinct userInfo",
        from="com.bofan.manage.valueobject.SysUserInfo userInfo join fetch userInfo.sysUser sysUser join fetch sysUser.userOrgs org", orderBy="userInfo.sort")
public class SysUserInfoOrgFullQueryInfo extends BaseCommandInfo {
    private static final long serialVersionUID = -1345276227831723965L;
    
    @QueryParam(fieldName = "userInfo.userInfoId")
    private Long[] userInfoIds;
    
    @QueryParam(fieldName = "org.orgId")
    private Long orgId;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long[] getUserInfoIds() {
        return userInfoIds;
    }

    public void setUserInfoIds(Long[] userInfoIds) {
        this.userInfoIds = userInfoIds;
    }
}
