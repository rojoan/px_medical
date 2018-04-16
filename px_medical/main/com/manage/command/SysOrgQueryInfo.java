package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

@SuppressWarnings("serial")
@QueryInfo(from="com.bofan.manage.valueobject.SysOrg", orderBy=" to_number(orgRank) asc, sort asc ")
public class SysOrgQueryInfo extends BaseCommandInfo{

    /** 不作为查询条件，仅仅用来传参数 */
    private Long rootId;

    @QueryParam(fieldName="orgId", op = QueryOperator.EQU)
	private Long orgId;
    
    @QueryParam(fieldName="orgId", op = QueryOperator.IN)
    private Long[] orgIds;
    
    @QueryParam(fieldName="unitOrgId", op = QueryOperator.EQU)
    private Long unitOrgId;
    
    @QueryParam(fieldName="unitOrgId", op = QueryOperator.NOT_EQU)
    private Long notUnitOrgId;
    
    @QueryParam(fieldName="name", op = QueryOperator.LIKE)
    private String name;
    
    @QueryParam(fieldName="delFlag", op = QueryOperator.EQU)
    private String delFlag;
    
    @QueryParam(fieldName="code", op = QueryOperator.EQU)
    private String codeEqu;
    
    @QueryParam(fieldName="code", op = QueryOperator.LEFTLIKE)
    private String code;
    
    @QueryParam(fieldName="parentOrgId", op = QueryOperator.EQU)
    private Long parentOrgId;
    
    @QueryParam(fieldName="parentOrgId", op = QueryOperator.IN)
    private Long[] parentOrgIds;
    
    @QueryParam(fieldName="orgRank", op = QueryOperator.EQU)
    private String orgRank;
    
    @QueryParam(fieldName="orgRank", op = QueryOperator.IN)
    private String[] orgRanks;

    /**
     * default constructor
     */
    public SysOrgQueryInfo() {
	}

    /**
     * minimal constructor
     * @param unitOrgId
     * @param orgRank
     */
    public SysOrgQueryInfo(Long unitOrgId) {
        this.unitOrgId = unitOrgId;
    }
    
    /**
     * @return the notUnitOrgId
     */
    public Long getNotUnitOrgId() {
        return notUnitOrgId;
    }

    /**
     * @param notUnitOrgId the notUnitOrgId to set
     */
    public void setNotUnitOrgId(Long notUnitOrgId) {
        this.notUnitOrgId = notUnitOrgId;
    }

    /**
     * minimal constructor
     * @param unitOrgId
     * @param orgRank
     */
    public SysOrgQueryInfo(Long unitOrgId, String orgRank) {
        this.unitOrgId = unitOrgId;
        this.orgRank = orgRank;
    }
    
    /**
     * minimal constructor
     * @param unitOrgId
     * @param orgRanks
     */
    public SysOrgQueryInfo(Long unitOrgId, String[] orgRanks) {
        this.unitOrgId = unitOrgId;
        this.orgRanks = orgRanks;
    }
    
    /**
     * minimal constructor
     * @param unitOrgId
     * @param orgRank
     */
    public SysOrgQueryInfo(Long unitOrgId, String orgRank, String name) {
        this.unitOrgId = unitOrgId;
        this.orgRank = orgRank;
        this.name = name;
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
	 * @return the parentOrgId
	 */
	public Long getParentOrgId() {
		return parentOrgId;
	}

	/**
	 * @param parentOrgId the parentOrgId to set
	 */
	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	/**
	 * @return the parentOrgIds
	 */
	public Long[] getParentOrgIds() {
		return parentOrgIds;
	}

	/**
	 * @param parentOrgIds the parentOrgIds to set
	 */
	public void setParentOrgIds(Long[] parentOrgIds) {
		this.parentOrgIds = parentOrgIds;
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
     * @return the delFlag
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag the delFlag to set
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * @return the codeEqu
     */
    public String getCodeEqu() {
        return codeEqu;
    }

    /**
     * @param codeEqu the codeEqu to set
     */
    public void setCodeEqu(String codeEqu) {
        this.codeEqu = codeEqu;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the orgRanks
     */
    public String[] getOrgRanks() {
        return orgRanks;
    }

    /**
     * @param orgRanks the orgRanks to set
     */
    public void setOrgRanks(String[] orgRanks) {
        this.orgRanks = orgRanks;
    }

    /**
     * @return the orgRank
     */
    public String getOrgRank() {
        return orgRank;
    }

    /**
     * @param orgRank the orgRank to set
     */
    public void setOrgRank(String orgRank) {
        this.orgRank = orgRank;
    }

    /**
     * @return the rootId
     */
    public Long getRootId() {
        return rootId;
    }

    /**
     * @param rootId the rootId to set
     */
    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

}
