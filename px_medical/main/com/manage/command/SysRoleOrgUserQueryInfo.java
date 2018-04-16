package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * <p> Calss Name:  SysRoleOrgUserQueryInfo.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author manjj
 * @created  2018-12-31
 */
@SuppressWarnings("serial")
@QueryInfo(from="com.bofan.manage.valueobject.SysRole role",
    orderBy = "role.roleId desc")
public class SysRoleOrgUserQueryInfo extends BaseCommandInfo {

    @QueryParam(fieldName = "role.roleName", op = QueryOperator.LIKE)
    private String roleName;

    @QueryParam(fieldName = "role.roleId")
    private Long roleId;

    private Long[] orgIds;

    private Long[] userInfoIds;

    private Long unitId;
    /** 仅查询出与role_code相关的角色 */
    @QueryParam(fieldName = "role.roleCode", op = QueryOperator.LIKE)
    private String roleCode;


    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the roleId
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleCode the roleCode to set
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * @return the roleCode
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * @param orgIds the orgIds to set
     */
    public void setOrgIds(Long[] orgIds) {
        this.orgIds = orgIds;
    }

    /**
     * @return the orgIds
     */
    public Long[] getOrgIds() {
        return orgIds;
    }

    /**
     * @return the unitId
     */
    public Long getUnitId() {
        return unitId;
    }

    /**
     * @param unitId the unitId to set
     */
    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    /**
     * @return the userInfoIds
     */
    public Long[] getUserInfoIds() {
        return userInfoIds;
    }

    /**
     * @param userInfoIds the userInfoIds to set
     */
    public void setUserInfoIds(Long[] userInfoIds) {
        this.userInfoIds = userInfoIds;
    }

}