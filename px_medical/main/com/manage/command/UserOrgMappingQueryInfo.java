package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

@SuppressWarnings("serial")
@QueryInfo(from="com.bofan.manage.valueobject.SysUserOrgMapping", orderBy=" compId.orgId asc ")
public class UserOrgMappingQueryInfo extends BaseCommandInfo {
    
    @QueryParam(fieldName="compId.userId")
    private Long[] userIds;

    @QueryParam(fieldName="compId.userId", op = QueryOperator.EQU)
    private Long userId;

    @QueryParam(fieldName="compId.orgId", op = QueryOperator.EQU)
    private Long orgId;
    
    /**
     * default constructor
     */
    public UserOrgMappingQueryInfo() {
    }

    /**
     * minimal constructor
     * @param userId
     */
    public UserOrgMappingQueryInfo(Long userId) {
        this.userId = userId;
    }
    
    /**
     * full constructor
     * @param userId
     * @param orgId
     */
    public UserOrgMappingQueryInfo(Long userId, Long orgId) {
        this.userId = userId;
        this.orgId = orgId;
    }
    
    public Long[] getUserIds() {
        return userIds;
    }

    public void setUserIds(Long[] userIds) {
        this.userIds = userIds;
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

    /**
     * @return the orgId
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * @param orgId the orgId to set
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
    
}
