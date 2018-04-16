package com.bofan.publichealth.command;

import java.util.Date;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 个人基本档案编辑
 * @author lqw
 */
public class PersonDetailEditInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

	/** 个人基本档案ID */
	private Long personDetailId;

	/** 家庭基本档案ID */
	private Long familyDetailId;
	
	/** 民族ID */
	private Long nationId;

	/** 行政区域--城镇街道ID */
	private String regionId;

	/** 家庭关系ID */
	private Long familyRelId;

	/** 居委会ID */
	private Long committeeId;
	/** 个人职业ID */
	private Long careerId;

	/** 医疗机构ID 对应sys_org表的 主键ID */
	private Long hospitalId;

	/** 医院编码（医疗机构代码） 对应sys_org 表中的 org_no */
	private String hospitalNo;

	/** 姓名 */
	private String personalName;

	/** 健康档案编号 */
	private String archivePersonalNum;

	/**
	 * 个人类别 1=婴儿期：从出生到12个月末的这一年龄阶段。 2=幼儿期：儿童从1～3周岁末的这个时期称为幼儿期。
	 * 3=学龄前期：儿童从3周岁到6~7周岁这一年龄阶段。 4=学龄期：儿童从6～7周岁到15周岁这一年龄阶段6～14 5=中年
	 * 6=老年：60岁以上为老年
	 */
	private String personalType;

	/** 证件类型 身份证、居住证、签证、护照、户口本、军人证、港澳通行证 */
	private String certificateType;

	/** 证件编号 */
	private String certificateNumber;

	/** 人员性别 1：男 2：女 */
	private String gender;

	/** 出生日期 */
	private Date birthDate;

	/** 工作单位 */
	private String workOrg;

	/** 本人电话 */
	private String myselfPhone;

	/** 父亲姓名 */
	private String fatherName;

	/** 母亲姓名 */
	private String motherName;

	/** 联系人姓名 */
	private String contactName;

	/** 联系人电话 */
	private String contactPhone;

	/**
	 * 常住类型 * 户籍 非户籍 流动
	 */
	private String liveType;

	/** 家庭详细地址 */
	private String familyAddr;

	/** 户籍类型 农业户口和非农业户口 */
	private String censusType;

	/** 户籍地址 */
	private String censusAddr;

	/** 迁入时间 */
	private Date moveInTime;

	/** 迁出时间 */
	private Date moveOutTime;

	/** 迁出原因 */
	private String moveReason;

	/** 血型 A型、B型、AB型、O型 */
	private String bloodType;

	/** Rt阴性 1：是 0：不是 */
	private String rtBloodGroup;

	/** 身高（CM） */
	private Double height;

	/** 体重（KG） */
	private Double weight;

	/** 文化程度 研究生、 大学本科、 大学专科和专科学校、 中等专业学校或中等技术学校、 技工学校、 高中、 初中、 小学、 文盲或半文盲 */
	private String educationDegree;

	/** 医保类型 城镇职工基本医疗保险 城镇居民基本医疗保险 新型农民合作医疗 贫困救助 商业医疗保险 全公费 全自费 其他 */
	private String healthIns;
	
	/** 医保卡号 */
	private String healthCard;

	/** 就诊卡号 */
	private String clinicCard;

	/** 医疗费用支付方式 自费 医保 门诊统筹 公费 农合 */
	private String payWay;

	/** 建档人（填写人）ID */
	private Long creatorId;

	/** 建档人（填写人） */
	private String creatorName;

	 
	/**
	 * @return personDetailId
	 */
	public Long getPersonDetailId() {
		return personDetailId;
	}

	/**
	 * @param personDetailId
	 *            要设置的 personDetailId
	 */
	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
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
	 * @return nationId
	 */
	public Long getNationId() {
		return nationId;
	}

	/**
	 * @param nationId
	 *            要设置的 nationId
	 */
	public void setNationId(Long nationId) {
		this.nationId = nationId;
	}

	/**
	 * @return regionId
	 */
	public String getRegionId() {
		return regionId;
	}

	/**
	 * @param regionId
	 *            要设置的 regionId
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	/**
	 * @return familyRelId
	 */
	public Long getFamilyRelId() {
		return familyRelId;
	}

	/**
	 * @param familyRelId
	 *            要设置的 familyRelId
	 */
	public void setFamilyRelId(Long familyRelId) {
		this.familyRelId = familyRelId;
	}

	/**
	 * @return committeeId
	 */
	public Long getCommitteeId() {
		return committeeId;
	}

	/**
	 * @param committeeId
	 *            要设置的 committeeId
	 */
	public void setCommitteeId(Long committeeId) {
		this.committeeId = committeeId;
	}

	/**
	 * @return careerId
	 */
	public Long getCareerId() {
		return careerId;
	}

	/**
	 * @param careerId
	 *            要设置的 careerId
	 */
	public void setCareerId(Long careerId) {
		this.careerId = careerId;
	}

	/**
	 * @return hospitalId
	 */
	public Long getHospitalId() {
		return hospitalId;
	}

	/**
	 * @param hospitalId
	 *            要设置的 hospitalId
	 */
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * @return hospitalNo
	 */
	public String getHospitalNo() {
		return hospitalNo;
	}

	/**
	 * @param hospitalNo
	 *            要设置的 hospitalNo
	 */
	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	/**
	 * @return personalName
	 */
	public String getPersonalName() {
		return personalName;
	}

	/**
	 * @param personalName
	 *            要设置的 personalName
	 */
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	/**
	 * @return archivePersonalNum
	 */
	public String getArchivePersonalNum() {
		return archivePersonalNum;
	}

	/**
	 * @param archivePersonalNum
	 *            要设置的 archivePersonalNum
	 */
	public void setArchivePersonalNum(String archivePersonalNum) {
		this.archivePersonalNum = archivePersonalNum;
	}

	/**
	 * @return personalType
	 */
	public String getPersonalType() {
		return personalType;
	}

	/**
	 * @param personalType 要设置的 personalType
	 */
	public void setPersonalType(String personalType) {
		this.personalType = personalType;
	}

	/**
	 * @return certificateType
	 */
	public String getCertificateType() {
		return certificateType;
	}

	/**
	 * @param certificateType
	 *            要设置的 certificateType
	 */
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	/**
	 * @return certificateNumber
	 */
	public String getCertificateNumber() {
		return certificateNumber;
	}

	/**
	 * @param certificateNumber
	 *            要设置的 certificateNumber
	 */
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            要设置的 gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            要设置的 birthDate
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return workOrg
	 */
	public String getWorkOrg() {
		return workOrg;
	}

	/**
	 * @param workOrg
	 *            要设置的 workOrg
	 */
	public void setWorkOrg(String workOrg) {
		this.workOrg = workOrg;
	}

	/**
	 * @return myselfPhone
	 */
	public String getMyselfPhone() {
		return myselfPhone;
	}

	/**
	 * @param myselfPhone
	 *            要设置的 myselfPhone
	 */
	public void setMyselfPhone(String myselfPhone) {
		this.myselfPhone = myselfPhone;
	}

	/**
	 * @return fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName
	 *            要设置的 fatherName
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return motherName
	 */
	public String getMotherName() {
		return motherName;
	}

	/**
	 * @param motherName
	 *            要设置的 motherName
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	/**
	 * @return contactName
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * @param contactName
	 *            要设置的 contactName
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * @return contactPhone
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * @param contactPhone
	 *            要设置的 contactPhone
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	/**
	 * @return liveType
	 */
	public String getLiveType() {
		return liveType;
	}

	/**
	 * @param liveType
	 *            要设置的 liveType
	 */
	public void setLiveType(String liveType) {
		this.liveType = liveType;
	}

	/**
	 * @return familyAddr
	 */
	public String getFamilyAddr() {
		return familyAddr;
	}

	/**
	 * @param familyAddr
	 *            要设置的 familyAddr
	 */
	public void setFamilyAddr(String familyAddr) {
		this.familyAddr = familyAddr;
	}

	/**
	 * @return censusType
	 */
	public String getCensusType() {
		return censusType;
	}

	/**
	 * @param censusType
	 *            要设置的 censusType
	 */
	public void setCensusType(String censusType) {
		this.censusType = censusType;
	}

	/**
	 * @return censusAddr
	 */
	public String getCensusAddr() {
		return censusAddr;
	}

	/**
	 * @param censusAddr
	 *            要设置的 censusAddr
	 */
	public void setCensusAddr(String censusAddr) {
		this.censusAddr = censusAddr;
	}

	/**
	 * @return moveInTime
	 */
	public Date getMoveInTime() {
		return moveInTime;
	}

	/**
	 * @param moveInTime
	 *            要设置的 moveInTime
	 */
	public void setMoveInTime(Date moveInTime) {
		this.moveInTime = moveInTime;
	}

	/**
	 * @return moveOutTime
	 */
	public Date getMoveOutTime() {
		return moveOutTime;
	}

	/**
	 * @param moveOutTime
	 *            要设置的 moveOutTime
	 */
	public void setMoveOutTime(Date moveOutTime) {
		this.moveOutTime = moveOutTime;
	}

	/**
	 * @return moveReason
	 */
	public String getMoveReason() {
		return moveReason;
	}

	/**
	 * @param moveReason
	 *            要设置的 moveReason
	 */
	public void setMoveReason(String moveReason) {
		this.moveReason = moveReason;
	}

	/**
	 * @return bloodType
	 */
	public String getBloodType() {
		return bloodType;
	}

	/**
	 * @param bloodType
	 *            要设置的 bloodType
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	/**
	 * @return rtBloodGroup
	 */
	public String getRtBloodGroup() {
		return rtBloodGroup;
	}

	/**
	 * @param rtBloodGroup
	 *            要设置的 rtBloodGroup
	 */
	public void setRtBloodGroup(String rtBloodGroup) {
		this.rtBloodGroup = rtBloodGroup;
	}

	/**
	 * @return height
	 */
	public Double getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            要设置的 height
	 */
	public void setHeight(Double height) {
		this.height = height;
	}

	/**
	 * @return weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            要设置的 weight
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * @return educationDegree
	 */
	public String getEducationDegree() {
		return educationDegree;
	}

	/**
	 * @param educationDegree
	 *            要设置的 educationDegree
	 */
	public void setEducationDegree(String educationDegree) {
		this.educationDegree = educationDegree;
	}

	/**
	 * @return healthIns
	 */
	public String getHealthIns() {
		return healthIns;
	}

	/**
	 * @param healthIns
	 *            要设置的 healthIns
	 */
	public void setHealthIns(String healthIns) {
		this.healthIns = healthIns;
	}

	/**
	 * @return healthCard
	 */
	public String getHealthCard() {
		return healthCard;
	}

	/**
	 * @param healthCard
	 *            要设置的 healthCard
	 */
	public void setHealthCard(String healthCard) {
		this.healthCard = healthCard;
	}

	/**
	 * @return clinicCard
	 */
	public String getClinicCard() {
		return clinicCard;
	}

	/**
	 * @param clinicCard
	 *            要设置的 clinicCard
	 */
	public void setClinicCard(String clinicCard) {
		this.clinicCard = clinicCard;
	}

	/**
	 * @return payWay
	 */
	public String getPayWay() {
		return payWay;
	}

	/**
	 * @param payWay
	 *            要设置的 payWay
	 */
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	/**
	 * @return creatorId
	 */
	public Long getCreatorId() {
		return creatorId;
	}

	/**
	 * @param creatorId
	 *            要设置的 creatorId
	 */
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * @return creatorName
	 */
	public String getCreatorName() {
		return creatorName;
	}

	/**
	 * @param creatorName
	 *            要设置的 creatorName
	 */
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

}