/*
 * <p> Title:  AllRoleInfo.java</p>
 * <p>Copyright:   bofan 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * <p> Calss Name:  SysRoleQueryInfo.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author pch
 * @created  2018-3-18
 */
@SuppressWarnings("serial")
@QueryInfo(from="com.bofan.manage.valueobject.SysRole", orderBy="sysType")
public class SysRoleQueryInfo extends BaseCommandInfo {
    
    private boolean multi;
    
    @QueryParam(fieldName="roleId")
    private Long roleId;
    
    @QueryParam(fieldName="roleName", op=QueryOperator.LIKE)
    private String roleName;

    @QueryParam(fieldName="roleCode", op=QueryOperator.EQU)
    private String roleCode;

    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    public boolean isMulti() {
        return multi;
    }
    public void setMulti(boolean multi) {
        this.multi = multi;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return the roleCode
     */
    public String getRoleCode() {
        return roleCode;
    }
    /**
     * @param roleCode the roleCode to set
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    /**
     * default constructor
     */
    public SysRoleQueryInfo() {
    }

    public SysRoleQueryInfo(String roleCode) {
        this.roleCode = roleCode;
    }
}
