/*
 * <p> Title:  SysUserRoleMappingQueryInfo.java</p>
 * <p>Copyright:   bofan 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryParam;

/**
 * <p> Calss Name:  AllUserRoleMappingInfo.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author pch
 * @created  2018-3-18
 */
@QueryInfo(from="com.bofan.manage.valueobject.SysUserRoleMapping")
public class SysUserRoleMappingQueryInfo extends BaseCommandInfo {
    private static final long serialVersionUID = 5085745995788310309L;
    
        @QueryParam(fieldName = "sysRole.roleId")
        private Long[] roleIds;

        @QueryParam(stmt="compId.userId in (" +
                "select userOrgMapping.compId.userId from com.bofan.manage.valueobject.SysUserOrgMapping userOrgMapping " +
                "where userOrgMapping.compId.orgId in (" +
                "select orgId from com.bofan.manage.valueobject.SysOrg sysOrg " +
                "where sysOrg.unitOrgId = ?))")
        private Long unitOrgId;

        public Long[] getRoleIds() {
            return roleIds;
        }

        public void setRoleIds(Long[] roleIds) {
            this.roleIds = roleIds;
        }

        /**
         * @return the unitOrgId
         */
        public Long getUnitOrgId() {
            return unitOrgId;
        }

        /**
         * @param unitOrgId the unitOrgId to set
         */
        public void setUnitOrgId(Long unitOrgId) {
            this.unitOrgId = unitOrgId;
        }

}
