package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryParam;

/**
 * <p> Calss Name:  SysRoleOrgMappingQueryInfo.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author manjj
 * @created  2018-12-31
 */
@QueryInfo(from="com.bofan.manage.valueobject.SysUserRoleMapping mapping join fetch mapping.compId mappingPK")
public class SysRoleUserMappingQueryInfo extends BaseCommandInfo {

    private static final long serialVersionUID = 7351526546128926560L;

    @QueryParam(fieldName = "mappingPK.roleId")
    private Long roleId;

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


}