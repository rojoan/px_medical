/*
 * <p> Title:  AllRoleFunctionMappingInfo.java</p>
 * <p>Copyright:   bofan 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryParam;

/**
 * <p> Calss Name:  SysRoleOrgMappingQueryInfo.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author pch
 * @created  2018-3-18
 */
@QueryInfo(from="com.bofan.manage.valueobject.SysRoleOrgMapping rom join fetch rom.sysOrg")
public class SysRoleOrgMappingQueryInfo extends BaseCommandInfo {
    private static final long serialVersionUID = 7170077413214100643L;

    @QueryParam(fieldName="rom.compId.roleId")
    private Long[] roleIds;

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }
    
}
