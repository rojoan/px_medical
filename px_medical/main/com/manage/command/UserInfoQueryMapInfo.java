package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;
import com.bofan.utils.Tools;

@SuppressWarnings("serial")
@QueryInfo(
        select = "new Map(u.userInfoId as userInfoId, u.name as name, u.sex as sex,u.age as age, u.dutyId as dutyId, u.phone as phone)", 
        from = "com.bofan.manage.valueobject.SysUserInfo u", 
        orderBy = "u.sort")
public class UserInfoQueryMapInfo extends BaseCommandInfo {

    @QueryParam(fieldName="u.sex", op=QueryOperator.EQU)
    private String sex;
    
    @QueryParam(fieldName="u.userInfoId", op=QueryOperator.EQU)
    private Long userInfoId;

    @QueryParam(fieldName="u.userInfoId", op=QueryOperator.IN)
    private Long[] userInfoIds;

    @QueryParam(fieldName="u.userId", op=QueryOperator.EQU)
    private Long userId;

    @QueryParam(fieldName="u.userId", op=QueryOperator.IN)
    private Long[] userIds;

    @QueryParam(fieldName="u.sysOrg.unitOrgId", op=QueryOperator.EQU)
    private Long unitOrgId;
    
    @QueryParam(fieldName="u.orgId", op=QueryOperator.EQU)
    private Long orgId;

    @QueryParam(fieldName="u.orgId", op=QueryOperator.IN)
    private Long[] orgIds;

    @QueryParam(fieldName="u.sysUser.delFlag", op=QueryOperator.EQU)
    private String delFlag;

    @QueryParam(fieldName="u.sysUser.delFlag", op=QueryOperator.NOT_EQU)
    private String notDelFlag;

    @QueryParam(fieldName="u.dutyId", op=QueryOperator.EQU)
    private Long dutyId;

    @QueryParam(fieldName="u.sysUser.account", op=QueryOperator.EQU)
    private String account;

    @QueryParam(fieldName="u.name", op=QueryOperator.EQU)
    private String name;

    /**
     * default constructor
     */
    public UserInfoQueryMapInfo() {
    }

    /**
     * minimal constructor
     * @param userInfoIds
     */
    public UserInfoQueryMapInfo(Long[] userInfoIds) {
        this.userInfoIds = userInfoIds;
    }

    /**
     * minimal constructor
     * @param notDelFlag
     * @param account
     */
    public UserInfoQueryMapInfo(String account, String notDelFlag) {
        this.account = account;
        this.notDelFlag = notDelFlag;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getNotDelFlag() {
        return notDelFlag;
    }

    public void setNotDelFlag(String notDelFlag) {
        this.notDelFlag = notDelFlag;
    }

    public Long getDutyId() {
        return dutyId;
    }

    public void setDutyId(Long dutyId) {
        this.dutyId = dutyId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the userInfoId
     */
    public Long getUserInfoId() {
        return userInfoId;
    }

    /**
     * @param userInfoId the userInfoId to set
     */
    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
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
     * @return the userIds
     */
    public Long[] getUserIds() {
        return userIds;
    }

    /**
     * @param userIds the userIds to set
     */
    public void setUserIds(Long[] userIds) {
        this.userIds = userIds;
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

    /**
     * @return the orgIds
     */
    public Long[] getOrgIds() {
        return orgIds;
    }

    /**
     * @param orgIds the orgIds to set
     */
    public void setOrgIds(Long[] orgIds) {
        this.orgIds = orgIds;
    }

    /**
     * userInfoIds为字符串时转换成Long型数组
     * @param userInfoIds the userInfoIds to set
     */
    public void setUserInfoIds(String userInfoIds) {
        this.userInfoIds = Tools.splitStringToLongArray(userInfoIds, ",");
    }

    /**
     * userIds为字符串时转换成Long型数组
     * @param userIds the userIds to set
     */
    public void setUserIds(String userIds) {
        this.userIds = Tools.splitStringToLongArray(userIds, ",");
    }

    /**
     * orgIds为字符串时转换成Long型数组
     * @param orgIds the orgIds to set
     */
    public void setOrgIds(String orgIds) {
        this.orgIds = Tools.splitStringToLongArray(orgIds, ",");
    }
}
