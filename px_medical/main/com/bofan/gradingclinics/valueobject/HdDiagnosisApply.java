package com.bofan.gradingclinics.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.his.valueobject.Patient;
import com.bofan.utils.SchemaConsts;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description: 双向转诊申请单
 * @author lqw
 * @date 2017-10-1
 * @version V1.0
 */
@Entity
@Table(name = "HD_DIAGNOSIS_APPLY", schema = SchemaConsts.REMOTE_CONSULT)
@SequenceGenerator(name = "HD_DIAGNOSIS_APPLY_ID", sequenceName = SchemaConsts.REMOTE_CONSULT + ".HD_DIAGNOSIS_APPLY_ID", allocationSize = 1)
public class HdDiagnosisApply {
    
	// Fields
	/** 双向转诊id **/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HD_DIAGNOSIS_APPLY_ID")
	@Column(name = "HD_DIAGNOSIS_APPLY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long hdDiagnosisApplyId;
	
	/** 申请医院的id */ 
	@Column(name = "ORG_ID", nullable = false, precision = 18, scale = 0)
	private Long orgId;
	
	/** 转诊单号 **/
	@Column(name = "HD_DIAGNOSIS_NUM", nullable = false, length = 20)
	private String hdDiagnosisNum;
	
	/** 患者ID 对应云HIS系统 PATIENT（患者设置），患者ID (主键) **/
	@Column(name = "PATIENT_ID", nullable = false, precision = 18, scale = 0)
	private Long patientId;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PATIENT_ID", insertable = false, updatable = false)
    private Patient patient;	

    /** 患者编码 对应云HIS系统 PATIENT（患者设置），患者编码 **/
	@Column(name = "PATIENT_NO", length = 50)
	private String patientNo;
	
	/** 患者姓名 对应云HIS系统 PATIENT（患者设置），患者姓名 **/
	@Column(name = "PATIENT_NAME", nullable = false, length = 50)
	private String patientName;
	
	/** 转诊类型 1：上转 2：下转 **/
	@Column(name = "HD_TYPE", nullable = false, length = 1)
	private String hdType;
	
	/** 初步诊断（主诉）（上转） 上转单 必填 **/
	@Column(name = "FIRST_DIAGNOSIS_UP", length = 1000)
	private String firstDiagnosisUp;
	
	/** 其他（上转） **/
	@Column(name = "OTHER_DIAGNOSIS_UP", length = 1000)
	private String otherDiagnosisUp;
	
	/** 初步印象（上转） 上转单 必填 **/
	@Column(name = "FIRST_IMPRESS_UP", length = 1000)
	private String firstImpressUp;
	
	/** 主要现病史（上转） 上转单 必填 **/
	@Column(name = "MAIN_SICK_UP", length = 3000)
	private String mainSickUp;
	
	/** 主要既往史（上转） 上转单 必填 **/
	@Column(name = "HISTORY_SICK_UP", length = 3000)
	private String historySickUp;
	
	/** 治疗经过（上转） 上转单 必填 **/
	@Column(name = "CURE_UP", length = 3000)
	private String cureUp;
	
	/** 转入医院ID **/
	@Column(name = "INSTITUTION_UP_ID", nullable = false, precision = 18, scale = 0)
	private Long institutionUpId;

	/** 转入医院名称 **/
	@Column(name = "INSTITUTION_UP_NAME", nullable = false, length = 80)
	private String institutionUpName;
	
	/** 转入科室ID **/
	@Column(name = "OFFICE_UP_ID", precision = 18, scale = 0)
	private Long officeUpId;
	
	/** 转入科室 **/
	@Column(name = "OFFICE_UP_NAME", nullable = false, length = 50)
	private String officeUpName;
	
	/** 转入医生ID **/
	@Column(name = "DOCTOR_UP_ID", precision = 18, scale = 0)
	private Long doctorUpId;
	
	/** 转入医生 **/
	@Column(name = "DOCTOR_UP_NAME", length = 50)
	private String doctorUpName;
	
	/** 转入医院联系电话 **/
	@Column(name = "INSTITUTION_PHONE_UP", length = 40)
	private String institutionPhoneUp;
	
	/** 转入医生电话 **/
	@Column(name = "DOCTOR_MOBILE_UP", length = 40)
	private String doctorMobileUp;
	
	/** 转出医院ID **/
	@Column(name = "INSTITUTION_DOWN_ID", nullable = false, precision = 18, scale = 0)
	private Long institutionDownId;
	
	/** 转出医院 **/
	@Column(name = "INSTITUTION_DOWN_NAME", nullable = false, length = 80)
	private String institutionDownName;
	
	/** 转出科室ID **/
	@Column(name = "OFFFICE_DOWN_ID", precision = 18, scale = 0)
	private Long offficeDownId;
	
	/** 转出科室 **/
	@Column(name = "OFFICE_DOWN_NAME", nullable = false, length = 50)
	private String officeDownName;
	
	/** 转出医生ID **/
	@Column(name = "DOCTOR_DOWN_ID", precision = 18, scale = 0)
	private Long doctorDownId;
	
	/** 转出医生 **/
	@Column(name = "DOCTOR_DOWN_NAME", nullable = false, length = 50)
	private String doctorDownName;
	
	/** 转出医院联系电话 **/
	@Column(name = "INSTITUTION_PHONE_DOW", length = 40)
	private String institutionPhoneDow;
	
	/** 转出医生联系电话 **/
	@Column(name = "DOCTOR_MOBILE_DOWN", nullable = false, length = 40)
	private String doctorMobileDown;
	
	/** 转诊诊断（下转） **/
	@Column(name = "DIAGNOSIS_DOWN", length = 3000)
	private String diagnosisDown;
	
	/** 转诊检查结果（下转） **/
	@Column(name = "DIAGNOSIS_RESULT_DOWN", length = 3000)
	private String diagnosisResultDown;
	
	/** 转诊治疗经过（下转） **/
	@Column(name = "DIAGNOSIS_CURE_DOWN", length = 3000)
	private String diagnosisCureDown;
	
	/** 转诊康复建议（下转） **/
	@Column(name = "RECOVERY_SUGGEST_DOWN", length = 3000)
	private String recoverySuggestDown;
	
	/** 手术名称 **/
	@Column(name = "OPERATION_DOWN", length = 200)
	private String operationDown;
	
	/** 手术日期 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name = "OPERATION_TIME_DOWN")
	private Date operationTimeDown;
	
	/** 申请时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
	@Column(name = "APPLY_TIME", nullable = false)
	private Date applyTime;
	 
	/** 转诊目的 1=诊断 2=检查 3=治疗 4=康复 **/
	@Column(name = "TRANS_AIM", nullable = false, length = 1)
	private String transAim;
	
	/** 转诊原因 **/
	@Column(name = "TRANS_REASON", nullable = false, length = 200)
	private String transReason;
	
	/** 有效期开始时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
	@Column(name = "VALID_START_TIME")
	private Date validStartTime;
	
	/** 有效期截止时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
	@Column(name = "VALID_END_TIME")
	private Date validEndTime;
	
	/** 是否自动审核 1：是 0：否 **/
	@Column(name = "AUTO_CHECK_FLAG", nullable = false, length = 1)
	private String autoCheckFlag;
	
	/** 审核医生ID **/
	@Column(name = "CHECK_DOCTOR_ID", precision = 18, scale = 0)
	private Long checkDoctorId;
	
	/** 审核医生 **/
	@Column(name = "CHECK_DOCTOR_NAME", length = 40)
	private String checkDoctorName;
	
	/** 审核意见 **/
	@Column(name = "CHECK_OPINION", length = 1000)
	private String checkOpinion;
	
	/** 审核日期 **/
	@Column(name = "CHECK_TIME")
	private Date checkTime;
	
	/** 接诊科室ID **/
	@Column(name = "CLINICAL_OFFICE_ID", precision = 18, scale = 0)
	private Long clinicalOfficeId;
	
	/** 接诊科室名称 **/
	@Column(name = "CLINICAL_OFFICE_NAME", length = 40)
	private String clinicalOfficeName;
	
	/** 接诊医生ID **/
	@Column(name = "CLINICAL_DOCTOR_ID", precision = 18, scale = 0)
	private Long clinicalDoctorId;
	
	/** 接诊医生 **/
	@Column(name = "CLINICAL_DOCTOR_NAME", length = 40)
	private String clinicalDoctorName;
	
	/** 接诊时间 **/
	@Column(name = "CLINICAL_TIME")
	private Date clinicalTime;
	
	/** 转诊状态 0：暂存 1：已申请待审核 2：已审核待接诊 3：已接诊待患者就诊 4：已到医院就诊 5：取消转诊 **/
	@Column(name = "TRANS_STATUS", nullable = false, length = 1)
	private String transStatus;
	
	/** 病人类型 1住院 2门诊  **/
	@Column(name = "patient_type ", nullable = false, length = 1)
	private String patientType ;
	
	/** 病人门诊号或住院号  **/
	@Column(name = "inpatient_id", nullable = false, length = 50)
	private String inpatientId  ;

    /** 诊断时间  **/
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "DIAGNOSIS_TIME")
    private Date diagnosisTime;
	
	/** 检查所见  **/
    @Column(name = "EXAM_FINDING", length = 1500)
	private String examFinding;
    
    /** 检查提示  **/
    @Column(name = "EXAM_HINT", length = 1500)
	private String examHint;
    
    /** 检查建议  **/
    @Column(name = "EXAM_ADVISE", length = 250)
    private String examAdvise;
    
    /** 诊断意见  **/
    @Column(name = "DIAGNOSTIC_OPINION", length = 1500)
	private String diagnosticOpinion;
    
	// Constructors

	/** default constructor */
	public HdDiagnosisApply() {
	}

	/**
	 * @return hdDiagnosisApplyId
	 */
	public Long getHdDiagnosisApplyId() {
		return hdDiagnosisApplyId;
	}

	/**
	 * @param hdDiagnosisApplyId 要设置的 hdDiagnosisApplyId
	 */
	public void setHdDiagnosisApplyId(Long hdDiagnosisApplyId) {
		this.hdDiagnosisApplyId = hdDiagnosisApplyId;
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
	 * @return hdDiagnosisNum
	 */
	public String getHdDiagnosisNum() {
		return hdDiagnosisNum;
	}

	/**
	 * @param hdDiagnosisNum 要设置的 hdDiagnosisNum
	 */
	public void setHdDiagnosisNum(String hdDiagnosisNum) {
		this.hdDiagnosisNum = hdDiagnosisNum;
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
	public String getPatientNo() {
		return patientNo;
	}

	/**
	 * @param patientNo 要设置的 patientNo
	 */
	public void setPatientNo(String patientNo) {
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
	 * @return hdType
	 */
	public String getHdType() {
		return hdType;
	}

	/**
	 * @param hdType 要设置的 hdType
	 */
	public void setHdType(String hdType) {
		this.hdType = hdType;
	}

	/**
	 * @return firstDiagnosisUp
	 */
	public String getFirstDiagnosisUp() {
		return firstDiagnosisUp;
	}

	/**
	 * @param firstDiagnosisUp 要设置的 firstDiagnosisUp
	 */
	public void setFirstDiagnosisUp(String firstDiagnosisUp) {
		this.firstDiagnosisUp = firstDiagnosisUp;
	}

	/**
	 * @return otherDiagnosisUp
	 */
	public String getOtherDiagnosisUp() {
		return otherDiagnosisUp;
	}

	/**
	 * @param otherDiagnosisUp 要设置的 otherDiagnosisUp
	 */
	public void setOtherDiagnosisUp(String otherDiagnosisUp) {
		this.otherDiagnosisUp = otherDiagnosisUp;
	}

	/**
	 * @return firstImpressUp
	 */
	public String getFirstImpressUp() {
		return firstImpressUp;
	}

	/**
	 * @param firstImpressUp 要设置的 firstImpressUp
	 */
	public void setFirstImpressUp(String firstImpressUp) {
		this.firstImpressUp = firstImpressUp;
	}

	/**
	 * @return mainSickUp
	 */
	public String getMainSickUp() {
		return mainSickUp;
	}

	/**
	 * @param mainSickUp 要设置的 mainSickUp
	 */
	public void setMainSickUp(String mainSickUp) {
		this.mainSickUp = mainSickUp;
	}

	/**
	 * @return historySickUp
	 */
	public String getHistorySickUp() {
		return historySickUp;
	}

	/**
	 * @param historySickUp 要设置的 historySickUp
	 */
	public void setHistorySickUp(String historySickUp) {
		this.historySickUp = historySickUp;
	}

	/**
	 * @return cureUp
	 */
	public String getCureUp() {
		return cureUp;
	}

	/**
	 * @param cureUp 要设置的 cureUp
	 */
	public void setCureUp(String cureUp) {
		this.cureUp = cureUp;
	}

	/**
	 * @return institutionUpId
	 */
	public Long getInstitutionUpId() {
		return institutionUpId;
	}

	/**
	 * @param institutionUpId 要设置的 institutionUpId
	 */
	public void setInstitutionUpId(Long institutionUpId) {
		this.institutionUpId = institutionUpId;
	}

	/**
	 * @return institutionUpName
	 */
	public String getInstitutionUpName() {
		return institutionUpName;
	}

	/**
	 * @param institutionUpName 要设置的 institutionUpName
	 */
	public void setInstitutionUpName(String institutionUpName) {
		this.institutionUpName = institutionUpName;
	}

	/**
	 * @return officeUpId
	 */
	public Long getOfficeUpId() {
		return officeUpId;
	}

	/**
	 * @param officeUpId 要设置的 officeUpId
	 */
	public void setOfficeUpId(Long officeUpId) {
		this.officeUpId = officeUpId;
	}

	/**
	 * @return officeUpName
	 */
	public String getOfficeUpName() {
		return officeUpName;
	}

	/**
	 * @param officeUpName 要设置的 officeUpName
	 */
	public void setOfficeUpName(String officeUpName) {
		this.officeUpName = officeUpName;
	}

	/**
	 * @return doctorUpId
	 */
	public Long getDoctorUpId() {
		return doctorUpId;
	}

	/**
	 * @param doctorUpId 要设置的 doctorUpId
	 */
	public void setDoctorUpId(Long doctorUpId) {
		this.doctorUpId = doctorUpId;
	}

	/**
	 * @return doctorUpName
	 */
	public String getDoctorUpName() {
		return doctorUpName;
	}

	/**
	 * @param doctorUpName 要设置的 doctorUpName
	 */
	public void setDoctorUpName(String doctorUpName) {
		this.doctorUpName = doctorUpName;
	}

	/**
	 * @return institutionPhoneUp
	 */
	public String getInstitutionPhoneUp() {
		return institutionPhoneUp;
	}

	/**
	 * @param institutionPhoneUp 要设置的 institutionPhoneUp
	 */
	public void setInstitutionPhoneUp(String institutionPhoneUp) {
		this.institutionPhoneUp = institutionPhoneUp;
	}

	/**
	 * @return doctorMobileUp
	 */
	public String getDoctorMobileUp() {
		return doctorMobileUp;
	}

	/**
	 * @param doctorMobileUp 要设置的 doctorMobileUp
	 */
	public void setDoctorMobileUp(String doctorMobileUp) {
		this.doctorMobileUp = doctorMobileUp;
	}

	/**
	 * @return institutionDownId
	 */
	public Long getInstitutionDownId() {
		return institutionDownId;
	}

	/**
	 * @param institutionDownId 要设置的 institutionDownId
	 */
	public void setInstitutionDownId(Long institutionDownId) {
		this.institutionDownId = institutionDownId;
	}

	/**
	 * @return institutionDownName
	 */
	public String getInstitutionDownName() {
		return institutionDownName;
	}

	/**
	 * @param institutionDownName 要设置的 institutionDownName
	 */
	public void setInstitutionDownName(String institutionDownName) {
		this.institutionDownName = institutionDownName;
	}

	/**
	 * @return offficeDownId
	 */
	public Long getOffficeDownId() {
		return offficeDownId;
	}

	/**
	 * @param offficeDownId 要设置的 offficeDownId
	 */
	public void setOffficeDownId(Long offficeDownId) {
		this.offficeDownId = offficeDownId;
	}

	/**
	 * @return officeDownName
	 */
	public String getOfficeDownName() {
		return officeDownName;
	}

	/**
	 * @param officeDownName 要设置的 officeDownName
	 */
	public void setOfficeDownName(String officeDownName) {
		this.officeDownName = officeDownName;
	}

	/**
	 * @return doctorDownId
	 */
	public Long getDoctorDownId() {
		return doctorDownId;
	}

	/**
	 * @param doctorDownId 要设置的 doctorDownId
	 */
	public void setDoctorDownId(Long doctorDownId) {
		this.doctorDownId = doctorDownId;
	}

	/**
	 * @return doctorDownName
	 */
	public String getDoctorDownName() {
		return doctorDownName;
	}

	/**
	 * @param doctorDownName 要设置的 doctorDownName
	 */
	public void setDoctorDownName(String doctorDownName) {
		this.doctorDownName = doctorDownName;
	}

	/**
	 * @return institutionPhoneDow
	 */
	public String getInstitutionPhoneDow() {
		return institutionPhoneDow;
	}

	/**
	 * @param institutionPhoneDow 要设置的 institutionPhoneDow
	 */
	public void setInstitutionPhoneDow(String institutionPhoneDow) {
		this.institutionPhoneDow = institutionPhoneDow;
	}

	/**
	 * @return doctorMobileDown
	 */
	public String getDoctorMobileDown() {
		return doctorMobileDown;
	}

	/**
	 * @param doctorMobileDown 要设置的 doctorMobileDown
	 */
	public void setDoctorMobileDown(String doctorMobileDown) {
		this.doctorMobileDown = doctorMobileDown;
	}

	/**
	 * @return diagnosisDown
	 */
	public String getDiagnosisDown() {
		return diagnosisDown;
	}

	/**
	 * @param diagnosisDown 要设置的 diagnosisDown
	 */
	public void setDiagnosisDown(String diagnosisDown) {
		this.diagnosisDown = diagnosisDown;
	}

	/**
	 * @return diagnosisResultDown
	 */
	public String getDiagnosisResultDown() {
		return diagnosisResultDown;
	}

	/**
	 * @param diagnosisResultDown 要设置的 diagnosisResultDown
	 */
	public void setDiagnosisResultDown(String diagnosisResultDown) {
		this.diagnosisResultDown = diagnosisResultDown;
	}

	/**
	 * @return diagnosisCureDown
	 */
	public String getDiagnosisCureDown() {
		return diagnosisCureDown;
	}

	/**
	 * @param diagnosisCureDown 要设置的 diagnosisCureDown
	 */
	public void setDiagnosisCureDown(String diagnosisCureDown) {
		this.diagnosisCureDown = diagnosisCureDown;
	}

	/**
	 * @return recoverySuggestDown
	 */
	public String getRecoverySuggestDown() {
		return recoverySuggestDown;
	}

	/**
	 * @param recoverySuggestDown 要设置的 recoverySuggestDown
	 */
	public void setRecoverySuggestDown(String recoverySuggestDown) {
		this.recoverySuggestDown = recoverySuggestDown;
	}

	/**
	 * @return operationDown
	 */
	public String getOperationDown() {
		return operationDown;
	}

	/**
	 * @param operationDown 要设置的 operationDown
	 */
	public void setOperationDown(String operationDown) {
		this.operationDown = operationDown;
	}

	/**
	 * @return operationTimeDown
	 */
	public Date getOperationTimeDown() {
		return operationTimeDown;
	}

	/**
	 * @param operationTimeDown 要设置的 operationTimeDown
	 */
	public void setOperationTimeDown(Date operationTimeDown) {
		this.operationTimeDown = operationTimeDown;
	}

	/**
	 * @return applyTime
	 */
	public Date getApplyTime() {
		return applyTime;
	}

	/**
	 * @param applyTime 要设置的 applyTime
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * @return transAim
	 */
	public String getTransAim() {
		return transAim;
	}

	/**
	 * @param transAim 要设置的 transAim
	 */
	public void setTransAim(String transAim) {
		this.transAim = transAim;
	}

	/**
	 * @return transReason
	 */
	public String getTransReason() {
		return transReason;
	}

	/**
	 * @param transReason 要设置的 transReason
	 */
	public void setTransReason(String transReason) {
		this.transReason = transReason;
	}

	/**
	 * @return validStartTime
	 */
	public Date getValidStartTime() {
		return validStartTime;
	}

	/**
	 * @param validStartTime 要设置的 validStartTime
	 */
	public void setValidStartTime(Date validStartTime) {
		this.validStartTime = validStartTime;
	}

	/**
	 * @return validEndTime
	 */
	public Date getValidEndTime() {
		return validEndTime;
	}

	/**
	 * @param validEndTime 要设置的 validEndTime
	 */
	public void setValidEndTime(Date validEndTime) {
		this.validEndTime = validEndTime;
	}

	/**
	 * @return autoCheckFlag
	 */
	public String getAutoCheckFlag() {
		return autoCheckFlag;
	}

	/**
	 * @param autoCheckFlag 要设置的 autoCheckFlag
	 */
	public void setAutoCheckFlag(String autoCheckFlag) {
		this.autoCheckFlag = autoCheckFlag;
	}

	/**
	 * @return checkDoctorId
	 */
	public Long getCheckDoctorId() {
		return checkDoctorId;
	}

	/**
	 * @param checkDoctorId 要设置的 checkDoctorId
	 */
	public void setCheckDoctorId(Long checkDoctorId) {
		this.checkDoctorId = checkDoctorId;
	}

	/**
	 * @return checkDoctorName
	 */
	public String getCheckDoctorName() {
		return checkDoctorName;
	}

	/**
	 * @param checkDoctorName 要设置的 checkDoctorName
	 */
	public void setCheckDoctorName(String checkDoctorName) {
		this.checkDoctorName = checkDoctorName;
	}

	/**
	 * @return checkOpinion
	 */
	public String getCheckOpinion() {
		return checkOpinion;
	}

	/**
	 * @param checkOpinion 要设置的 checkOpinion
	 */
	public void setCheckOpinion(String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}

	/**
	 * @return checkTime
	 */
	public Date getCheckTime() {
		return checkTime;
	}

	/**
	 * @param checkTime 要设置的 checkTime
	 */
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * @return clinicalOfficeId
	 */
	public Long getClinicalOfficeId() {
		return clinicalOfficeId;
	}

	/**
	 * @param clinicalOfficeId 要设置的 clinicalOfficeId
	 */
	public void setClinicalOfficeId(Long clinicalOfficeId) {
		this.clinicalOfficeId = clinicalOfficeId;
	}

	/**
	 * @return clinicalOfficeName
	 */
	public String getClinicalOfficeName() {
		return clinicalOfficeName;
	}

	/**
	 * @param clinicalOfficeName 要设置的 clinicalOfficeName
	 */
	public void setClinicalOfficeName(String clinicalOfficeName) {
		this.clinicalOfficeName = clinicalOfficeName;
	}

	/**
	 * @return clinicalDoctorId
	 */
	public Long getClinicalDoctorId() {
		return clinicalDoctorId;
	}

	/**
	 * @param clinicalDoctorId 要设置的 clinicalDoctorId
	 */
	public void setClinicalDoctorId(Long clinicalDoctorId) {
		this.clinicalDoctorId = clinicalDoctorId;
	}

	/**
	 * @return clinicalDoctorName
	 */
	public String getClinicalDoctorName() {
		return clinicalDoctorName;
	}

	/**
	 * @param clinicalDoctorName 要设置的 clinicalDoctorName
	 */
	public void setClinicalDoctorName(String clinicalDoctorName) {
		this.clinicalDoctorName = clinicalDoctorName;
	}

	/**
	 * @return clinicalTime
	 */
	public Date getClinicalTime() {
		return clinicalTime;
	}

	/**
	 * @param clinicalTime 要设置的 clinicalTime
	 */
	public void setClinicalTime(Date clinicalTime) {
		this.clinicalTime = clinicalTime;
	}

	/**
	 * @return transStatus
	 */
	public String getTransStatus() {
		return transStatus;
	}

	/**
	 * @param transStatus 要设置的 transStatus
	 */
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}

	/**
	 * @return patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient 要设置的 patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return patientType
	 */
	public String getPatientType() {
		return patientType;
	}

	/**
	 * @param patientType 要设置的 patientType
	 */
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	/**
	 * @return inpatientId
	 */
	public String getInpatientId() {
		return inpatientId;
	}

	/**
	 * @param inpatientId 要设置的 inpatientId
	 */
	public void setInpatientId(String inpatientId) {
		this.inpatientId = inpatientId;
	}

    /**
     * @return the diagnosisTime
     */
    public Date getDiagnosisTime() {
        return diagnosisTime;
    }

    /**
     * @param diagnosisTime the diagnosisTime to set
     */
    public void setDiagnosisTime(Date diagnosisTime) {
        this.diagnosisTime = diagnosisTime;
    }

    /**
     * @return the examFinding
     */
    public String getExamFinding() {
        return examFinding;
    }

    /**
     * @param examFinding the examFinding to set
     */
    public void setExamFinding(String examFinding) {
        this.examFinding = examFinding;
    }

    /**
     * @return the examHint
     */
    public String getExamHint() {
        return examHint;
    }

    /**
     * @param examHint the examHint to set
     */
    public void setExamHint(String examHint) {
        this.examHint = examHint;
    }

    /**
     * @return the examAdvise
     */
    public String getExamAdvise() {
        return examAdvise;
    }

    /**
     * @param examAdvise the examAdvise to set
     */
    public void setExamAdvise(String examAdvise) {
        this.examAdvise = examAdvise;
    }

    /**
     * @return the diagnosticOpinion
     */
    public String getDiagnosticOpinion() {
        return diagnosticOpinion;
    }

    /**
     * @param diagnosticOpinion the diagnosticOpinion to set
     */
    public void setDiagnosticOpinion(String diagnosticOpinion) {
        this.diagnosticOpinion = diagnosticOpinion;
    }
	
}