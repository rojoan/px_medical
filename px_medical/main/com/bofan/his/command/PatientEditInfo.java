package com.bofan.his.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 患者信息编辑
 * @author lqw
 */
public class PatientEditInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;
	
	/** 患者主键ID HIS系统  病人档案（门诊）表 的主键ID **/
	private Long patientId;
	
	/** 患者医院对应ID */
	private Long patientHospitalId;
	
	/** 就诊卡号--一卡通号（门诊号码） 门诊号码，病人挂号先要建卡（就诊卡号）作为识别
                个人信息证号，理论上一个病人对应唯一的门诊号码， 而病人每次挂号就诊会生成一条序列号作为病人 该次就诊的门诊号（门诊表的主键ID，流水号）。 **/
	private String patientCardNo;

	/** 病人住院号码 住院号码是病人的住院唯一识别号，性质和门诊的就诊卡号 （门诊号码）一样，理论上应该是一个人一个唯一的号。 **/
	private String patientHospitalNo;

	/** 患者院内档案ID（HIS系统） */
	private Long patientNo;
	
	/** 患者姓名 **/
	private String patientName;
	
	/** 出生年月 **/
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date patientBirth;
	
	/**  证件类型  身份证、居住证、签证、护照、户口本、军人证、港澳通行证 */
	private String certificateType;

	/** 证件号码 **/
	private String patientIdCard;
	
	/** 性别 **/
	private String patientSex;
	
	/** 民族 **/
	private String patientNation;
	
	/** 籍贯 */
	private String nativePlace;
	
	/** 婚否 1=已婚 0=未婚 **/
	private String marryFlag;
	
	/** 现居地址 **/
	private String patientNowAddr;
	
	/** 电话 **/
	private String patientPhone;
	
	/** 联系人 **/
	private String contactName;
	
	/** 关系 **/
	private String contactRelation;
	
	/** 联系电话 **/
	private String contactPhone;

	/** 家庭电话 **/
	private String homePhone;
	
	/** 家庭地址 **/
	private String homeAddr;
	
	/** 邮编(户口) **/
	private String postalCode;
	
	/** 工作单位名称 **/
	private String companyName;
	
	/** 工作单位电话 **/
	private String companyPhone;
	
	/** 工作单位地址 **/
	private String companyAddr;
	
	/** 职业 **/
	private String patientCreer;
	
	/** 参保类型 1=商业医保 2=新农合医保 3=城镇职工医保 4=城镇居民医保 **/
	private String insuredType;
	
	/** 医/农保证号 **/
	private String insuranceNo;
	
	/** 医院（医疗机构）编码 **/
	private String hospitalNo;
	
	/** 组织机构（医院单位）ID 对应sys_org表中，医院编码（标识）对应的单位ID **/
	private Long orgId;

	/** 操作人（建档人）ID **/
	private Long creatorId;
	
	/** 备注 **/
	private String remark;

	/**
	 * @return patientId
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId 要设置的 patientId
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return patientHospitalId
	 */
	public Long getPatientHospitalId() {
		return patientHospitalId;
	}

	/**
	 * @param patientHospitalId 要设置的 patientHospitalId
	 */
	public void setPatientHospitalId(Long patientHospitalId) {
		this.patientHospitalId = patientHospitalId;
	}

	/**
	 * @return patientCardNo
	 */
	public String getPatientCardNo() {
		return patientCardNo;
	}

	/**
	 * @param patientCardNo 要设置的 patientCardNo
	 */
	public void setPatientCardNo(String patientCardNo) {
		this.patientCardNo = patientCardNo;
	}

	/**
	 * @return patientHospitalNo
	 */
	public String getPatientHospitalNo() {
		return patientHospitalNo;
	}

	/**
	 * @param patientHospitalNo 要设置的 patientHospitalNo
	 */
	public void setPatientHospitalNo(String patientHospitalNo) {
		this.patientHospitalNo = patientHospitalNo;
	}

	/**
	 * @return patientNo
	 */
	public Long getPatientNo() {
		return patientNo;
	}

	/**
	 * @param patientNo 要设置的 patientNo
	 */
	public void setPatientNo(Long patientNo) {
		this.patientNo = patientNo;
	}

	/**
	 * @return patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName 要设置的 patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * @return patientBirth
	 */
	public Date getPatientBirth() {
		return patientBirth;
	}

	/**
	 * @param patientBirth 要设置的 patientBirth
	 */
	public void setPatientBirth(Date patientBirth) {
		this.patientBirth = patientBirth;
	}

	/**
	 * @return certificateType
	 */
	public String getCertificateType() {
		return certificateType;
	}

	/**
	 * @param certificateType 要设置的 certificateType
	 */
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	/**
	 * @return patientIdCard
	 */
	public String getPatientIdCard() {
		return patientIdCard;
	}

	/**
	 * @param patientIdCard 要设置的 patientIdCard
	 */
	public void setPatientIdCard(String patientIdCard) {
		this.patientIdCard = patientIdCard;
	}

	/**
	 * @return patientSex
	 */
	public String getPatientSex() {
		return patientSex;
	}

	/**
	 * @param patientSex 要设置的 patientSex
	 */
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}

	/**
	 * @return patientNation
	 */
	public String getPatientNation() {
		return patientNation;
	}

	/**
	 * @param patientNation 要设置的 patientNation
	 */
	public void setPatientNation(String patientNation) {
		this.patientNation = patientNation;
	}

	/**
	 * @return nativePlace
	 */
	public String getNativePlace() {
		return nativePlace;
	}

	/**
	 * @param nativePlace 要设置的 nativePlace
	 */
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	/**
	 * @return marryFlag
	 */
	public String getMarryFlag() {
		return marryFlag;
	}

	/**
	 * @param marryFlag 要设置的 marryFlag
	 */
	public void setMarryFlag(String marryFlag) {
		this.marryFlag = marryFlag;
	}

	/**
	 * @return patientNowAddr
	 */
	public String getPatientNowAddr() {
		return patientNowAddr;
	}

	/**
	 * @param patientNowAddr 要设置的 patientNowAddr
	 */
	public void setPatientNowAddr(String patientNowAddr) {
		this.patientNowAddr = patientNowAddr;
	}

	/**
	 * @return patientPhone
	 */
	public String getPatientPhone() {
		return patientPhone;
	}

	/**
	 * @param patientPhone 要设置的 patientPhone
	 */
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	/**
	 * @return contactName
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * @param contactName 要设置的 contactName
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * @return contactRelation
	 */
	public String getContactRelation() {
		return contactRelation;
	}

	/**
	 * @param contactRelation 要设置的 contactRelation
	 */
	public void setContactRelation(String contactRelation) {
		this.contactRelation = contactRelation;
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
	 * @return homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @param homePhone 要设置的 homePhone
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @return homeAddr
	 */
	public String getHomeAddr() {
		return homeAddr;
	}

	/**
	 * @param homeAddr 要设置的 homeAddr
	 */
	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}

	/**
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode 要设置的 postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return companyPhone
	 */
	public String getCompanyPhone() {
		return companyPhone;
	}

	/**
	 * @param companyPhone 要设置的 companyPhone
	 */
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	/**
	 * @return companyAddr
	 */
	public String getCompanyAddr() {
		return companyAddr;
	}

	/**
	 * @param companyAddr 要设置的 companyAddr
	 */
	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}

	/**
	 * @return patientCreer
	 */
	public String getPatientCreer() {
		return patientCreer;
	}

	/**
	 * @param patientCreer 要设置的 patientCreer
	 */
	public void setPatientCreer(String patientCreer) {
		this.patientCreer = patientCreer;
	}

	/**
	 * @return insuredType
	 */
	public String getInsuredType() {
		return insuredType;
	}

	/**
	 * @param insuredType 要设置的 insuredType
	 */
	public void setInsuredType(String insuredType) {
		this.insuredType = insuredType;
	}

	/**
	 * @return insuranceNo
	 */
	public String getInsuranceNo() {
		return insuranceNo;
	}

	/**
	 * @param insuranceNo 要设置的 insuranceNo
	 */
	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	/**
	 * @return hospitalNo
	 */
	public String getHospitalNo() {
		return hospitalNo;
	}

	/**
	 * @param hospitalNo 要设置的 hospitalNo
	 */
	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	/**
	 * @return orgId
	 */
	public Long getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId 要设置的 orgId
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
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
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	 
}