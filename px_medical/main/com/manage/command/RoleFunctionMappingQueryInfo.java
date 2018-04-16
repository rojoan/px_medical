/*
 * <p> Title:  RoleFunctionMappingQueryInfo.java</p>
 * <p>Copyright:   bofan 2017</p>
 * <p>Company: 博繁科技˾</p>
 */
package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryParam;

/**
 * <p> Calss Name:  RoleFunctionMappingQueryInfo.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author pch
 * @created  2017-10-18
 */
@QueryInfo(from="com.bofan.manage.valueobject.SysRoleFunctionMapping rf join fetch rf.sysRole role join fetch rf.sysFunction")
public class RoleFunctionMappingQueryInfo extends BaseCommandInfo {
	private static final long serialVersionUID = 7170077413214100643L;
	
	@QueryParam(fieldName="role.roleId")
	private Long[] roleIds;

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }
	
}
