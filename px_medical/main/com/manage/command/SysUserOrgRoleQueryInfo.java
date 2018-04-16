package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryParam;

/**
 * 根据用户账号查询部门与角色的映射集
 * @author linx
 * @date 2017-6-30
 */
@QueryInfo(from = "com.bofan.manage.valueobject.SysRoleOrgMapping roleOrgMapping ")
public class SysUserOrgRoleQueryInfo extends BaseCommandInfo {

    private static final long serialVersionUID = 1L;

    @QueryParam(fieldName="roleOrgMapping.compId.roleId")
    private Long[] roleIds;

    @QueryParam(stmt="roleOrgMapping.compId.orgId in (" +
    		"select userOrgMapping.compId.orgId from com.bofan.manage.valueobject.SysUserOrgMapping userOrgMapping " +
    		"where userOrgMapping.compId.userId = ?)")
    private Long userId;

    /**
     * default constructor
     */
    public SysUserOrgRoleQueryInfo() {

    }

    /**
     * mini constructor
     * @param userId
     */
    public SysUserOrgRoleQueryInfo(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the roleIds
     */
    public Long[] getRoleIds() {
        return roleIds;
    }

    /**
     * @param roleIds the roleIds to set
     */
    public void setRoleIds(Long[] roleIds) {
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


}
