package com.bofan.reconsult.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;

public class ReConsultingEditInfo  extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -817804215266814182L;
    
    /** 远程会诊申请ID **/
    private Long reConsultingId;
    
    /** 患者检查ID **/
    private Long patientExamId;
    
	/** 对应LIS系统  lis_inspection_sample（检验样本信息表）的主键ID **/
	private Long lisInspectionSampleId;
	
	/** RIS病人检查表 ID主键 **/
    private Long risInspectionId;

    /** 患者主键ID **/
    private Long patientId;
    
    /** 患者名字 **/
    private String patientName;
    
    /** 医疗机构ID **/
    private Long medicalInstitutionId;
    
    /** 医疗机构名称 **/
    private String medicalInstitutionName;
    
    /** 科室ID **/
    private Long officeId;
    
    /** 科室名称 **/
    private String officeName;
    
    /** 医生ID **/
    private Long doctorId;
    
    /** 医生姓名 **/
    private String doctorName;
    
    /** 会诊类型 **/
    private String consultationType;
    
    /** 临床诊断 **/
    private String clinicalDiagnosis;
    
    /** 会诊要求 **/
    private String consultationAsk;
    
    /** 病史描述 **/
    private String diseaseDescribe;
    
    /** 会诊发起人ID **/
    private Long proposerId;
    
    /** 会诊发起人 **/
    private String proposerName;
    
    /** 申请时间 **/
    private Date reApplyTime;
    
    /** 会诊状态 **/
    private String consultingStatus;
    
    /** 会诊时间 **/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date reConsultingTime;
    
    /** 会诊开始时间 **/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date reConsultingStart;
    
    /** 会诊结束时间 **/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date reConsultingEnd;
    
    /** 病人类型 0住院 1门诊  **/
    private String patientType ;
    
    /** 病人门诊号或住院号  **/
    private String inpatientId ;
    
    /** 检查所见 **/
    private String examFinding;
    /** 检查提示 **/
    private String examHint;
    /** 检查建议 **/
    private String examAdvise;
    /** 诊断意见 **/
    private String diagnosticOpinion;

    /**
	 * @return the reConsultingId
	 */
	public Long getReConsultingId() {
		return reConsultingId;
	}

	/**
	 * @param reConsultingId the reConsultingId to set
	 */
	public void setReConsultingId(Long reConsultingId) {
		this.reConsultingId = reConsultingId;
	}

	/**
     * @return the patientExamId
     */
    public Long getPatientExamId() {
        return patientExamId;
    }

    /**
     * @param patientExamId the patientExamId to set
     */
    public void setPatientExamId(Long patientExamId) {
        this.patientExamId = patientExamId;
    }

    /**
     * @return the patientId
     */
    public Long getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the patientName
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * @param patientName the patientName to set
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * @return the medicalInstitutionId
     */
    public Long getMedicalInstitutionId() {
        return medicalInstitutionId;
    }

    /**
     * @param medicalInstitutionId the medicalInstitutionId to set
     */
    public void setMedicalInstitutionId(Long medicalInstitutionId) {
        this.medicalInstitutionId = medicalInstitutionId;
    }

    /**
     * @return the medicalInstitutionName
     */
    public String getMedicalInstitutionName() {
        return medicalInstitutionName;
    }

    /**
     * @param medicalInstitutionName the medicalInstitutionName to set
     */
    public void setMedicalInstitutionName(String medicalInstitutionName) {
        this.medicalInstitutionName = medicalInstitutionName;
    }

    /**
     * @return the officeId
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * @param officeId the officeId to set
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * @return the officeName
     */
    public String getOfficeName() {
        return officeName;
    }

    /**
     * @param officeName the officeName to set
     */
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    /**
     * @return the doctorId
     */
    public Long getDoctorId() {
        return doctorId;
    }

    /**
     * @param doctorId the doctorId to set
     */
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * @return the doctorName
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * @param doctorName the doctorName to set
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * @return the consultationType
     */
    public String getConsultationType() {
        return consultationType;
    }

    /**
     * @param consultationType the consultationType to set
     */
    public void setConsultationType(String consultationType) {
        this.consultationType = consultationType;
    }

    /**
     * @return the clinicalDiagnosis
     */
    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    /**
     * @param clinicalDiagnosis the clinicalDiagnosis to set
     */
    public void setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
    }

    /**
     * @return the consultationAsk
     */
    public String getConsultationAsk() {
        return consultationAsk;
    }

    /**
     * @param consultationAsk the consultationAsk to set
     */
    public void setConsultationAsk(String consultationAsk) {
        this.consultationAsk = consultationAsk;
    }

    /**
     * @return the diseaseDescribe
     */
    public String getDiseaseDescribe() {
        return diseaseDescribe;
    }

    /**
     * @param diseaseDescribe the diseaseDescribe to set
     */
    public void setDiseaseDescribe(String diseaseDescribe) {
        this.diseaseDescribe = diseaseDescribe;
    }

    /**
     * @return the proposerId
     */
    public Long getProposerId() {
        return proposerId;
    }

    /**
     * @param proposerId the proposerId to set
     */
    public void setProposerId(Long proposerId) {
        this.proposerId = proposerId;
    }

    /**
     * @return the proposerName
     */
    public String getProposerName() {
        return proposerName;
    }

    /**
     * @param proposerName the proposerName to set
     */
    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    /**
     * @return the reApplyTime
     */
    public Date getReApplyTime() {
        return reApplyTime;
    }

    /**
     * @param reApplyTime the reApplyTime to set
     */
    public void setReApplyTime(Date reApplyTime) {
        this.reApplyTime = reApplyTime;
    }

    /**
     * @return the consultingStatus
     */
    public String getConsultingStatus() {
        return consultingStatus;
    }

    /**
     * @param consultingStatus the consultingStatus to set
     */
    public void setConsultingStatus(String consultingStatus) {
        this.consultingStatus = consultingStatus;
    }

    /**
     * @return the reConsultingTime
     */
    public Date getReConsultingTime() {
        return reConsultingTime;
    }

    /**
     * @param reConsultingTime the reConsultingTime to set
     */
    public void setReConsultingTime(Date reConsultingTime) {
        this.reConsultingTime = reConsultingTime;
    }

    /**
     * @return the reConsultingStart
     */
    public Date getReConsultingStart() {
        return reConsultingStart;
    }

    /**
     * @param reConsultingStart the reConsultingStart to set
     */
    public void setReConsultingStart(Date reConsultingStart) {
        this.reConsultingStart = reConsultingStart;
    }

    /**
     * @return the reConsultingEnd
     */
    public Date getReConsultingEnd() {
        return reConsultingEnd;
    }

    /**
     * @param reConsultingEnd the reConsultingEnd to set
     */
    public void setReConsultingEnd(Date reConsultingEnd) {
        this.reConsultingEnd = reConsultingEnd;
    }

	/**
	 * @return the lisInspectionSampleId
	 */
	public Long getLisInspectionSampleId() {
		return lisInspectionSampleId;
	}

	/**
	 * @param lisInspectionSampleId the lisInspectionSampleId to set
	 */
	public void setLisInspectionSampleId(Long lisInspectionSampleId) {
		this.lisInspectionSampleId = lisInspectionSampleId;
	}

	/**
	 * @return the risInspectionId
	 */
	public Long getRisInspectionId() {
		return risInspectionId;
	}

	/**
	 * @param risInspectionId the risInspectionId to set
	 */
	public void setRisInspectionId(Long risInspectionId) {
		this.risInspectionId = risInspectionId;
	}

    /**
     * @return the patientType
     */
    public String getPatientType() {
        return patientType;
    }

    /**
     * @param patientType the patientType to set
     */
    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    /**
     * @return the inpatientId
     */
    public String getInpatientId() {
        return inpatientId;
    }

    /**
     * @param inpatientId the inpatientId to set
     */
    public void setInpatientId(String inpatientId) {
        this.inpatientId = inpatientId;
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
