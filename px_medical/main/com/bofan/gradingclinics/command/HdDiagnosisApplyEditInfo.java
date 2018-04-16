package com.bofan.gradingclinics.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 双向转诊申请单
 * @author lqw
 * @date 2017-10-1
 * @version V1.0
 */
public class HdDiagnosisApplyEditInfo extends BaseCommandInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	/** 双向转诊id **/
	private Long hdDiagnosisApplyId;
	
	/** 申请医院的id */ 
	private Long orgId;
	
	/** 转诊单号 **/
	private String hdDiagnosisNum;
	
	/** 患者ID 对应云HIS系统 PATIENT（患者设置），患者ID (主键) **/
	private Long patientId;
	
	/** 患者院内档案ID（HIS系统） */
	private String patientNo;
	
	/** 患者姓名 对应云HIS系统 PATIENT（患者设置），患者姓名 **/
	private String patientName;
	
	/** 转诊类型 1：上转 2：下转 **/
	private String hdType;
	
	/** 初步诊断（主诉）（上转） 上转单 必填 **/
	private String firstDiagnosisUp;
	
	/** 其他（上转） **/
	private String otherDiagnosisUp;
	
	/** 初步印象（上转） 上转单 必填 **/
	private String firstImpressUp;
	
	/** 主要现病史（上转） 上转单 必填 **/
	private String mainSickUp;
	
	/** 主要既往史（上转） 上转单 必填 **/
	private String historySickUp;
	
	/** 治疗经过（上转） 上转单 必填 **/
	private String cureUp;
	
	/** 转入医院ID MEDICALINSTITUTION（医疗机构） 主键ID **/
	private Long institutionUpId;
	
	/** 转入医院名称 **/
	private String institutionUpName;
	
	/** 转入科室ID **/
	private Long officeUpId;
	
	/** 转入科室 **/
	private String officeUpName;
	
	/** 转入医生ID **/
	private Long doctorUpId;
	
	/** 转入医生 **/
	private String doctorUpName;
	
	/** 转入医院联系电话 **/
	private String institutionPhoneUp;
	
	/** 转入医生电话 **/
	private String doctorMobileUp;
	
	/** 转出医院ID **/
	private Long institutionDownId;
	
	/** 转出医院 **/
	private String institutionDownName;
	
	/** 转出科室ID **/
	private Long offficeDownId;
	
	/** 转出科室 **/
	private String officeDownName;
	
	/** 转出医生ID **/
	private Long doctorDownId;
	
	/** 转出医生 **/
	private String doctorDownName;
	
	/** 转出医院联系电话 **/
	private String institutionPhoneDow;
	
	/** 转出医生联系电话 **/
	private String doctorMobileDown;
	
	/** 转诊诊断（下转） **/
	private String diagnosisDown;
	
	/** 转诊检查结果（下转） **/
	private String diagnosisResultDown;
	
	/** 转诊治疗经过（下转） **/
	private String diagnosisCureDown;
	
	/** 转诊康复建议（下转） **/
	private String recoverySuggestDown;
	
	/** 手术名称 **/
	private String operationDown;
	
	/** 手术日期 **/
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date operationTimeDown;
	
	/** 转诊目的 1：转诊 2：转捡 3：转院 **/
	private String transAim;
	
	/** 转诊原因 **/
	private String transReason;
	
	/** 有效期开始时间 **/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date validStartTime;
	
	/** 有效期截止时间 **/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date validEndTime;
	
	/** 是否自动审核 1：是 0：否 **/
	private String autoCheckFlag;
	
	/** 审核医生ID **/
	private Long checkDoctorId;
	
	/** 审核医生 **/
	private String checkDoctorName;
	
	/** 审核意见 **/
	private String checkOpinion;
	
	/** 审核日期 **/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkTime;
	
	/** 接诊科室ID **/
	private Long clinicalOfficeId;
	
	/** 接诊科室名称 **/
	private String clinicalOfficeName;
	
	/** 接诊医生ID **/
	private Long clinicalDoctorId;
	
	/** 接诊医生 **/
	private String clinicalDoctorName;
	
	/** 接诊时间 **/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date clinicalTime;
	
	/** 转诊状态 0：暂存 1：已申请待审核 2：已审核待接诊 3：已接诊待患者就诊 4：已到医院就诊 5：取消转诊 **/
	private String transStatus;
	
	/** 病人类型 0住院 1门诊  **/
	private String patientType ;
	
	/** 病人门诊号或住院号  **/
	private String inpatientId  ;

	/** default constructor */
	public HdDiagnosisApplyEditInfo() {
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

}