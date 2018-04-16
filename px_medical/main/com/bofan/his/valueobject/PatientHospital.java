package com.bofan.his.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description: patient_hospital（患者医院对应表）
 * @author lqw
 */
@Entity
@Table(name = "PATIENT_HOSPITAL", schema = SchemaConsts.REMOTE_CONSULT)
@SequenceGenerator(name = "PATIENT_HOSPITAL_ID", sequenceName = SchemaConsts.REMOTE_CONSULT + ".PATIENT_HOSPITAL_ID", allocationSize = 1)
public class PatientHospital {

	/** 患者医院对应ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT_HOSPITAL_ID")
	@Column(name = "PATIENT_HOSPITAL_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long patientHospitalId;
	
	/** 患者主键ID HIS系统  病人档案（门诊）表 的主键ID */
	@Column(name = "PATIENT_ID", nullable = false, precision = 18, scale = 0)
	private Long patientId;
	
	/** 患者姓名 **/
	@Column(name = "PATIENT_NAME", length = 20)
	private String patientName;
	
	/** 性别 **/
	@Column(name = "PATIENT_SEX", nullable = false, length = 1)
	private String patientSex;
	
	/** 出生年月 **/
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
	@Column(name = "PATIENT_BIRTH")
	private Date patientBirth;
	
	/** 患者电话 **/
	@Column(name = "PATIENT_PHONE", length = 20)
	private String patientPhone;
 
	/** 家庭地址 **/
	@Column(name = "HOME_ADDR", length = 200)
	private String homeAddr;
	
	/** 患者院内档案ID（HIS系统） */
	@Column(name = "PATIENT_NO", precision = 18, scale = 0)
	private Long patientNo;
	
	/** 就诊卡号--一卡通号（门诊号码） 门诊号码，病人挂号先要建卡（就诊卡号）作为识别 个人信息证号，理论上一个病人对应唯一的门诊号码，
	 *  而病人每次挂号就诊会生成一条序列号作为病人  该次就诊的门诊号（门诊表的主键ID，流水号）。 医院无就诊卡号，可用患者身份证等信息代替，保证唯一即可 */
	@Column(name = "PATIENT_CARD_NO", nullable = false, length = 60)
	private String patientCardNo;
	
	/** 病人住院号码 住院号码是病人的住院唯一识别号，性质和门诊的就诊卡号 （门诊号码）一样，理论上应该是一个人一个唯一的号。 */
	@Column(name = "PATIENT_HOSPITAL_NO", length = 60)
	private String patientHospitalNo;
	
	/** 医院（医疗机构）编码 */
	@Column(name = "HOSPITAL_NO", nullable = false, length = 40)
	private String hospitalNo;
	
	/** 组织机构（医院单位）ID 对应sys_org表中，医院编码（标识）对应的单位ID */
	@Column(name = "ORG_ID", nullable = false, precision = 18, scale = 0)
	private Long orgId;
	
	/** 证件号码 **/
	@Column(name = "PATIENT_ID_CARD", length = 40)
	private String patientIdCard;
	
	/** 医/农保证号 **/
	@Column(name = "INSURANCE_NO", length = 20)
	private String insuranceNo;

	/** 是否有效 1=有效 0=无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** 创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
	@Column(name = "CREATE_TIME", nullable = false)
    private Date createTime;
	
	/** 更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
	@Column(name = "MODIFY_TIME")
	private Date modifyTime;
	
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
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 要设置的 createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime 要设置的 modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
	
}