package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;


/**
 * @Description: 家庭基本档案查询
 * @author lqw
 */
@QueryInfo(
        from = "com.bofan.publichealth.valueobject.FamilyDetail fd ", 
        orderBy = "fd.familyDetailId desc")
public class FamilyDetailQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

    /** 医院标识 */
    @QueryParam(fieldName = "fd.hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
	/** 家庭基本档案ID */
	@QueryParam(fieldName = "fd.familyDetailId", op = QueryOperator.EQU)
	private java.lang.Long familyDetailId;

	/** 家庭居住条件ID */
	@QueryParam(fieldName = "fd.houseConditionId", op = QueryOperator.EQU)
	private Long houseConditionId;

	/** 行政区域--城镇街道ID 分三级管理 */
	@QueryParam(fieldName = "fd.regionId", op = QueryOperator.EQU)
	private java.lang.String regionId;

	/** 户主姓名 */
	@QueryParam(fieldName = "fd.familyOwnerName", op = QueryOperator.LIKE)
	private String familyOwnerName;

	/** 档案编号 */
	@QueryParam(fieldName = "fd.archiveNumber", op = QueryOperator.LIKE)
	private String archiveNumber;

	/** 家庭编号 自动生成18位编号，可以用序列号自动生成 */
	@QueryParam(fieldName = "fd.familyNumber", op = QueryOperator.LIKE)
	private String familyNumber;

	/** 家庭类型 核心家庭、单亲家庭、主干家庭、联合家庭、其他家庭 */
	@QueryParam(fieldName = "fd.familyType", op = QueryOperator.EQU)
	private String familyType;

	/** 户籍类型 1：城镇 2：农村 */
	@QueryParam(fieldName = "fd.censusType", op = QueryOperator.EQU)
	private String censusType;
	
	/** 户属性 1：一般农户 2：烈军属 3：五保户 4：贫困户 5：特困户 */
	@QueryParam(fieldName = "fd.censusAttribute", op = QueryOperator.EQU)
	private String censusAttribute;

	/** 户口薄编号 */
	@QueryParam(fieldName = "fd.householdNumber", op = QueryOperator.LIKE)
	private String householdNumber;
	
    @QueryParam(fieldName = "fd.validFlag", op = QueryOperator.EQU)
    private String validFlag;

	public FamilyDetailQueryInfo() {
	}

	/**
     * @return hospitalId
     */
    public Long getHospitalId() {
        return hospitalId;
    }


    /**
     * @param hospitalId 要设置的 hospitalId
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }


    /**
	 * @return familyDetailId
	 */
	public Long getFamilyDetailId() {
		return familyDetailId;
	}

	/**
	 * @param familyDetailId 要设置的 familyDetailId
	 */
	public void setFamilyDetailId(Long familyDetailId) {
		this.familyDetailId = familyDetailId;
	}

	/**
	 * @return houseConditionId
	 */
	public Long getHouseConditionId() {
		return houseConditionId;
	}

	/**
	 * @param houseConditionId 要设置的 houseConditionId
	 */
	public void setHouseConditionId(Long houseConditionId) {
		this.houseConditionId = houseConditionId;
	}

	/**
	 * @return regionId
	 */
	public String getRegionId() {
		return regionId;
	}

	/**
	 * @param regionId 要设置的 regionId
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	/**
	 * @return familyOwnerName
	 */
	public String getFamilyOwnerName() {
		return familyOwnerName;
	}

	/**
	 * @param familyOwnerName 要设置的 familyOwnerName
	 */
	public void setFamilyOwnerName(String familyOwnerName) {
		this.familyOwnerName = familyOwnerName;
	}

	/**
	 * @return archiveNumber
	 */
	public String getArchiveNumber() {
		return archiveNumber;
	}

	/**
	 * @param archiveNumber 要设置的 archiveNumber
	 */
	public void setArchiveNumber(String archiveNumber) {
		this.archiveNumber = archiveNumber;
	}

	/**
	 * @return familyNumber
	 */
	public String getFamilyNumber() {
		return familyNumber;
	}

	/**
	 * @param familyNumber 要设置的 familyNumber
	 */
	public void setFamilyNumber(String familyNumber) {
		this.familyNumber = familyNumber;
	}

	/**
	 * @return familyType
	 */
	public String getFamilyType() {
		return familyType;
	}

	/**
	 * @param familyType 要设置的 familyType
	 */
	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}

	/**
	 * @return censusType
	 */
	public String getCensusType() {
		return censusType;
	}

	/**
	 * @param censusType 要设置的 censusType
	 */
	public void setCensusType(String censusType) {
		this.censusType = censusType;
	}

	/**
	 * @return censusAttribute
	 */
	public String getCensusAttribute() {
		return censusAttribute;
	}

	/**
	 * @param censusAttribute 要设置的 censusAttribute
	 */
	public void setCensusAttribute(String censusAttribute) {
		this.censusAttribute = censusAttribute;
	}

	/**
	 * @return householdNumber
	 */
	public String getHouseholdNumber() {
		return householdNumber;
	}

	/**
	 * @param householdNumber 要设置的 householdNumber
	 */
	public void setHouseholdNumber(String householdNumber) {
		this.householdNumber = householdNumber;
	}

    /**
     * @return validFlag
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag 要设置的 validFlag
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }
	
}