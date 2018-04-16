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

import org.apache.commons.lang.StringUtils;

import com.bofan.utils.SchemaConsts;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description: 门诊-住院表
 * @author lqw
 */
@Entity
@Table(name = "OUTPATIENT_INHOSPITAL", schema = SchemaConsts.REMOTE_CONSULT)
@SequenceGenerator(name = "OUTPATIENT_INHOSPITAL_ID", sequenceName = SchemaConsts.REMOTE_CONSULT + ".OUTPATIENT_INHOSPITAL_ID", allocationSize = 1)
public class OutpatientInhospital {
	
	/** 门诊-住院ID，此表同步HIS表 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OUTPATIENT_INHOSPITAL_ID")
	@Column(name = "OUTPATIENT_INHOSPITAL_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long outpatientInhospitalId;
	
	/** 组织机构（医院单位）ID 对应sys_org表中，医院编码（标识）对应的单位ID **/
	@Column(name = "ORG_ID", nullable = false, precision = 18, scale = 0)
	private Long orgId;
	
	/** 组织机构（医院单位）ID 对应sys_org表中，医院编码 **/
	@Column(name = "HOSPITAL_NO", nullable = false, length = 40)
	private String hospitalNo;
	
	/** 患者主键ID */
	@Column(name = "PATIENT_ID", nullable = false, precision = 18, scale = 0)
	private Long patientId;
	
	/** 患者院内档案ID（HIS系统） */
	@Column(name = "PATIENT_NO", precision = 18, scale = 0)
	private Long patientNo;
	
	/** 患者姓名 **/
	@Column(name = "PATIENT_NAME", length = 20)
	private String patientName;

	/** 性别 , 冗余字段 **/
	@Column(name = "PATIENT_SEX", nullable = false, length = 1)
	private String patientSex;
	
	/** 证件号码 **/
	@Column(name = "PATIENT_ID_CARD", length = 40)
	private String patientIdCard;
	
	/** 住院号ID 住院表的流水号 */
	@Column(name = "INHOSPITAL_ID", precision = 18, scale = 0)
	private Long inhospitalId;
	
	/** 住院号码 住院号码是病人的住院识别号，性质和门诊的就诊卡号一样。 理论上应该是一个人一个唯一的住院号码。 */
	@Column(name = "INHOSPITAL_NO", length = 30)
	private String inhospitalNo;
	
	/** 门诊流水号ID */
	@Column(name = "OUTPATIENT_ID", precision = 18, scale = 0)
	private Long outpatientId;
	
	/** 就诊卡号--一卡通号（门诊号码） 门诊号码，病人挂号先要建卡（就诊卡号）作为识别
	    个人信息证号，理论上一个病人对应唯一的门诊号码， 而病人每次挂号就诊会生成一条序列号作为病人 该次就诊的门诊号（门诊表的主键ID，流水号）。 **/
	@Column(name = "PATIENT_CARD_NO", length = 50)
	private String patientCardNo;
	
	/** 病人就诊时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
	@Column(name = "DIAGNOSIS_DATE")
	private Date diagnosisDate;
	
	/** 转诊-远程诊断标志 0= 1=已申请转诊 2=已申请远程诊断 */
	@Column(name = "DIAGNOSIS_FLAG", length = 1)
	private String diagnosisFlag;

	/** 附件标识 **/
	@Column(name = "AFFIX_ID", length = 20)
	private String affixId;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;
	
	// 不与数据映射
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
	public OutpatientInhospital() {
	}

	/**
	 * @return outpatientInhospitalId
	 */
	public Long getOutpatientInhospitalId() {
		return outpatientInhospitalId;
	}

	/**
	 * @param outpatientInhospitalId 要设置的 outpatientInhospitalId
	 */
	public void setOutpatientInhospitalId(Long outpatientInhospitalId) {
		this.outpatientInhospitalId = outpatientInhospitalId;
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
	 * @return patientIdCard
	 */
	public String getPatientIdCard() {
	    if (this.getAge() > 0) {
            this.currentAge = this.getAge();
        }
		return patientIdCard;
	}

	/**
	 * @param patientIdCard 要设置的 patientIdCard
	 */
	public void setPatientIdCard(String patientIdCard) {
		this.patientIdCard = patientIdCard;
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
	 * @return inhospitalId
	 */
	public Long getInhospitalId() {
		return inhospitalId;
	}

	/**
	 * @param inhospitalId 要设置的 inhospitalId
	 */
	public void setInhospitalId(Long inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	/**
	 * @return inhospitalNo
	 */
	public String getInhospitalNo() {
		return inhospitalNo;
	}

	/**
	 * @param inhospitalNo 要设置的 inhospitalNo
	 */
	public void setInhospitalNo(String inhospitalNo) {
		this.inhospitalNo = inhospitalNo;
	}

	/**
	 * @return outpatientId
	 */
	public Long getOutpatientId() {
		return outpatientId;
	}

	/**
	 * @param outpatientId 要设置的 outpatientId
	 */
	public void setOutpatientId(Long outpatientId) {
		this.outpatientId = outpatientId;
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
	 * @return diagnosisDate
	 */
	public Date getDiagnosisDate() {
		return diagnosisDate;
	}

	/**
	 * @param diagnosisDate 要设置的 diagnosisDate
	 */
	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	/**
     * @return the diagnosisFlag
     */
    public String getDiagnosisFlag() {
        return diagnosisFlag;
    }

    /**
     * @param diagnosisFlag the diagnosisFlag to set
     */
    public void setDiagnosisFlag(String diagnosisFlag) {
        this.diagnosisFlag = diagnosisFlag;
    }

	/**
	 * @return the affixId
	 */
	public String getAffixId() {
		return affixId;
	}

	/**
	 * @param affixId the affixId to set
	 */
	public void setAffixId(String affixId) {
		this.affixId = affixId;
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
     * @return the currentAge
     */
    public int getCurrentAge() {
        return currentAge;
    }

    /**
     * @param currentAge the currentAge to set
     */
    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

}