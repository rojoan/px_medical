package com.bofan.his.valueobject;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.bofan.utils.SchemaConsts;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description: 患者信息表
 * @author lqw
 */
@Entity
@Table(name = "PATIENT", schema = SchemaConsts.REMOTE_CONSULT)
@SequenceGenerator(name = "PATIENT_ID", sequenceName = SchemaConsts.REMOTE_CONSULT + ".PATIENT_ID", allocationSize = 1)
public class Patient {
	

	/** 患者主键ID HIS系统  病人档案（门诊）表 的主键ID **/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT_ID")
	@Column(name = "PATIENT_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long patientId;
	
	/** 患者姓名 **/
	@Column(name = "PATIENT_NAME", length = 20)
	private String patientName;
	
	/** 出生年月 **/
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "PATIENT_BIRTH")
	private Date patientBirth;
	
	/**  证件类型  身份证、居住证、签证、护照、户口本、军人证、港澳通行证 */
	@Column(name = "CERTIFICATE_TYPE", length = 1)
	private String certificateType;

	/** 证件号码 **/
	@Column(name = "PATIENT_ID_CARD", length = 40)
	private String patientIdCard;
	
	/** 性别 **/
	@Column(name = "PATIENT_SEX", nullable = false, length = 1)
	private String patientSex;
	
	/** 民族 **/
	@Column(name = "PATIENT_NATION", length = 20)
	private String patientNation;
	
	/** 籍贯 */
	@Column(name = "NATIVE_PLACE", length = 20)
	private String nativePlace;
	
	/** 婚否 1=已婚 0=未婚 **/
	@Column(name = "MARRY_FLAG", length = 1)
	private String marryFlag;
	
	/** 现居地址 **/
	@Column(name = "PATIENT_NOW_ADDR", length = 200)
	private String patientNowAddr;
	
	/** 病人电话 **/
	@Column(name = "PATIENT_PHONE", length = 20)
	private String patientPhone;
	
	/** 联系人 **/
	@Column(name = "CONTACT_NAME", length = 20)
	private String contactName;
	
	/** 关系 **/
	@Column(name = "CONTACT_RELATION", length = 20) 
	private String contactRelation;
	
	/** 联系电话 **/
	@Column(name = "CONTACT_PHONE", length = 30)
	private String contactPhone;

	/** 家庭电话 **/
	@Column(name = "HOME_PHONE", length = 20)
	private String homePhone;
	
	/** 家庭地址 **/
	@Column(name = "HOME_ADDR", length = 200)
	private String homeAddr;
	
	/** 邮编(户口) **/
	@Column(name = "POSTAL_CODE", length = 100)
	private String postalCode;
	
	/** 工作单位名称 **/
	@Column(name = "COMPANY_NAME", length = 200)
	private String companyName;

	/** 工作单位电话 **/
	@Column(name = "COMPANY_PHONE", length = 20)
	private String companyPhone;
	
	/** 工作单位地址 **/
	@Column(name = "COMPANY_ADDR", length = 600)
	private String companyAddr;
	
	/** 职业 **/
	@Column(name = "PATIENT_CREER", length = 20)
	private String patientCreer;
	
	/** 参保类型 1=商业医保 2=新农合医保 3=城镇职工医保 4=城镇居民医保 **/
	@Column(name = "INSURED_TYPE", length = 50)
	private String insuredType;
	
	/** 医/农保证号 **/
	@Column(name = "INSURANCE_NO", length = 20)
	private String insuranceNo;
	
	/** 过敏史 **/
	@Column(name = "PATIENT_ALLERGY", length = 20)
	private String patientAllergy;
	
	/** 登记医院（医疗机构）编码  对应sys_org表中org_no字段**/
	@Column(name = "HOSPITAL_NO", nullable = false, length = 40)
	private String hospitalNo;
	
	/** 登记医院（医院单位）ID **/
	@Column(name = "ORG_ID", nullable = false, precision = 18, scale = 0)
	private Long orgId;

	/** 操作人（建档人）ID **/
	@Column(name = "CREATOR_ID", nullable = false, precision = 22, scale = 0)
	private Long creatorId;
	
	/** 登记（建档）日期 **/
	@Column(name = "CREATE_DATE", nullable = false)
	private Date createDate;
	
	/** 备注 **/
	@Column(name = "REMARK", length = 250)
	private String remark;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;
	
	@Transient  
	private int currentAge;  

	/**
	 * 根据身份证号获取年龄
	 * @return
	 */
    public int getAge() {
    	if (StringUtils.isBlank(this.patientIdCard)) {
    		return -1;
		}
        Calendar ca = Calendar.getInstance();
        int nowYear = ca.get(Calendar.YEAR);
        int nowMonth = ca.get(Calendar.MONTH) + 1;
        int len = this.patientIdCard.length();
        if (len == 18) {
            int IDYear = Integer.parseInt(this.patientIdCard.substring(6, 10));
            int IDMonth = Integer.parseInt(this.patientIdCard.substring(10, 12));
            if ((IDMonth - nowMonth) > 0) {
                return nowYear - IDYear - 1;
            } else
                return nowYear - IDYear;
        } else {
            return -1;
        }
    }

	/** default constructor */
	public Patient() {
	    
	}

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
	 * @return patientAllergy
	 */
	public String getPatientAllergy() {
		return patientAllergy;
	}

	/**
	 * @param patientAllergy 要设置的 patientAllergy
	 */
	public void setPatientAllergy(String patientAllergy) {
		this.patientAllergy = patientAllergy;
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
	 * @return createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate 要设置的 createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	/**
	 * @return currentAge
	 */
	public int getCurrentAge() {
		return currentAge;
	}

	/**
	 * @param currentAge 要设置的 currentAge
	 */
	public void setCurrentAge(int currentAge) {
		this.currentAge = currentAge;
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