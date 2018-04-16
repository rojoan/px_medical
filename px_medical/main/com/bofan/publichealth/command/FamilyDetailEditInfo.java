package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;


/**
 * @Description: 家庭基本档案编辑
 * @author lqw
 */
public class FamilyDetailEditInfo extends BaseCommandInfo{

	private static final long serialVersionUID = 1L;

	/** 家庭基本档案ID */
	private Long familyDetailId;

	/** 家庭居住条件ID */
	private Long houseConditionId;

	/** 行政区域--城镇街道ID 分三级管理 */
	private String regionId;

	/** 户主姓名 */
	private String familyOwnerName;

	/** 档案编号 */
	private String archiveNumber;

	/** 家庭编号 自动生成18位编号，可以用序列号自动生成 */
	private String familyNumber;

	/** 家庭类型 核心家庭、单亲家庭、主干家庭、联合家庭、其他家庭 */
	private String familyType;

	/** 户籍类型 1：城镇 2：农村 */
	private String censusType;

	/** 户口薄编号 */
	private String householdNumber;

	/** 户属性 1：一般农户 2：烈军属 3：五保户 4：贫困户 5：特困户 */
	private String censusAttribute;

	/** 联系电话 */
	private String contactPhone;

	/** 家庭详细地址 */
	private String familyAddr;

	/** 居住小区 */
	private String livingQuarter;

	/** 成员数量 */
	private Long familyCount;

	/** 现住人数 */
	private Long liveCount;

	/** 未成年人数 */
	private Long childrenCount;

	/** 负担老人数 */
	private Long elderCount;

	/** 备注 */
	private String remark;
	
	/** 建档人ID */
	private Long creatorId;

	/** default constructor */
	public FamilyDetailEditInfo() {
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
	 * @return contactPhone
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * @param contactPhone 要设置的 contactPhone
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	/**
	 * @return familyAddr
	 */
	public String getFamilyAddr() {
		return familyAddr;
	}

	/**
	 * @param familyAddr 要设置的 familyAddr
	 */
	public void setFamilyAddr(String familyAddr) {
		this.familyAddr = familyAddr;
	}

	/**
	 * @return livingQuarter
	 */
	public String getLivingQuarter() {
		return livingQuarter;
	}

	/**
	 * @param livingQuarter 要设置的 livingQuarter
	 */
	public void setLivingQuarter(String livingQuarter) {
		this.livingQuarter = livingQuarter;
	}

	/**
	 * @return familyCount
	 */
	public Long getFamilyCount() {
		return familyCount;
	}

	/**
	 * @param familyCount 要设置的 familyCount
	 */
	public void setFamilyCount(Long familyCount) {
		this.familyCount = familyCount;
	}

	/**
	 * @return liveCount
	 */
	public Long getLiveCount() {
		return liveCount;
	}

	/**
	 * @param liveCount 要设置的 liveCount
	 */
	public void setLiveCount(Long liveCount) {
		this.liveCount = liveCount;
	}

	/**
	 * @return childrenCount
	 */
	public Long getChildrenCount() {
		return childrenCount;
	}

	/**
	 * @param childrenCount 要设置的 childrenCount
	 */
	public void setChildrenCount(Long childrenCount) {
		this.childrenCount = childrenCount;
	}

	/**
	 * @return elderCount
	 */
	public Long getElderCount() {
		return elderCount;
	}

	/**
	 * @param elderCount 要设置的 elderCount
	 */
	public void setElderCount(Long elderCount) {
		this.elderCount = elderCount;
	}

	/**
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark 要设置的 remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return creatorId
	 */
	public Long getCreatorId() {
		return creatorId;
	}

	/**
	 * @param creatorId 要设置的 creatorId
	 */
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

}