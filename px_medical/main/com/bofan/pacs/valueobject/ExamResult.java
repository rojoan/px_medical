package com.bofan.pacs.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: exam_result（检查结果表）实体
 * @author lqw
 * @date 2017-09-26
 * @version V1.0
 */
@Entity
@Table(name = "EXAM_RESULT", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "EXAM_RESULT_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".EXAM_RESULT_ID", allocationSize=1)
public class ExamResult {

	// Fields
	/** 检查结果主键ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAM_RESULT_ID")
	@Column(name = "EXAM_RESULT_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long examResultId;
	
	/** 病人检查号对应 patient_check （病人检查表）主键ID */
	@Column(name = "PATIENT_EXAM_NUM", nullable = false, length = 20)
	private String patientExamNum;
	
	/** 检查所见 */
	@Column(name = "EXAM_FINDINGS", length = 3000)
	private String examFindings;
	
	/** 检查提示 */
	@Column(name = "EXAM_HINT", length = 3000)
	private String examHint;
	
	/** 手术过程 */
	@Column(name = "SURGICAL_PROCEDURE", length = 1000)
	private String surgicalProcedure;
	
	/** 病理诊断 */
	@Column(name = "PATHOLOGIC_DIAGNOSIS", length = 1000)
	private String pathologicDiagnosis;
	
	/** 检查所见_审核 */
	@Column(name = "EXAM_FINDINGS_AUDIT", length = 3000)
	private String examFindingsAudit;
	
	/** 检查提示_审核 */
	@Column(name = "EXAM_HINT_AUDIT", length = 3000)
	private String examHintAudit;
	
	/** 检查所见_初诊 */
	@Column(name = "EXAM_FINDING_INIT_DIAGNOSIS", length = 3000)
	private String examFindingInitDiagnosis;
	
	/** 检查提示_初诊 */
	@Column(name = "EXAM_HINT_INIT_DIAGNOSIS", length = 3000)
	private String examHintInitDiagnosis;
	
	/** 检查建议 */
	@Column(name = "EXAM_ADVISE", length = 500)
	private String examAdvise;
	
	/** 检查提示_编号 */
	@Column(name = "EXAM_HINT_NUMBER", length = 256)
	private String examHintNumber;
	
	/** 活检部位htPACS使用 */
	@Column(name = "BIOPSY_SITES", length = 50)
	private String biopsySites;
	
	/** 医院标识不同的医院分配不同的标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	@Column(name = "HT_FS_PACS_MARK", nullable = false, length = 1)
	private String htFsPacsMark;

	// Constructors

	/** default constructor */
	public ExamResult() {
	}

	// Property accessors
	
	public Long getExamResultId() {
		return this.examResultId;
	}

	public void setExamResultId(Long examResultId) {
		this.examResultId = examResultId;
	}

	public String getPatientExamNum() {
		return this.patientExamNum;
	}

	public void setPatientExamNum(String patientExamNum) {
		this.patientExamNum = patientExamNum;
	}
	
	public String getExamFindings() {
		return this.examFindings;
	}

	public void setExamFindings(String examFindings) {
		this.examFindings = examFindings;
	}
	
	public String getExamHint() {
		return this.examHint;
	}

	public void setExamHint(String examHint) {
		this.examHint = examHint;
	}
	
	public String getSurgicalProcedure() {
		return this.surgicalProcedure;
	}

	public void setSurgicalProcedure(String surgicalProcedure) {
		this.surgicalProcedure = surgicalProcedure;
	}

	public String getPathologicDiagnosis() {
		return this.pathologicDiagnosis;
	}

	public void setPathologicDiagnosis(String pathologicDiagnosis) {
		this.pathologicDiagnosis = pathologicDiagnosis;
	}
	
	public String getExamFindingsAudit() {
		return this.examFindingsAudit;
	}

	public void setExamFindingsAudit(String examFindingsAudit) {
		this.examFindingsAudit = examFindingsAudit;
	}

	public String getExamHintAudit() {
		return this.examHintAudit;
	}

	public void setExamHintAudit(String examHintAudit) {
		this.examHintAudit = examHintAudit;
	}
	
	public String getExamFindingInitDiagnosis() {
		return this.examFindingInitDiagnosis;
	}

	public void setExamFindingInitDiagnosis(String examFindingInitDiagnosis) {
		this.examFindingInitDiagnosis = examFindingInitDiagnosis;
	}

	public String getExamHintInitDiagnosis() {
		return this.examHintInitDiagnosis;
	}

	public void setExamHintInitDiagnosis(String examHintInitDiagnosis) {
		this.examHintInitDiagnosis = examHintInitDiagnosis;
	}
	
	public String getExamAdvise() {
		return this.examAdvise;
	}

	public void setExamAdvise(String examAdvise) {
		this.examAdvise = examAdvise;
	}
	
	public String getExamHintNumber() {
		return this.examHintNumber;
	}

	public void setExamHintNumber(String examHintNumber) {
		this.examHintNumber = examHintNumber;
	}
	
	public String getBiopsySites() {
		return this.biopsySites;
	}

	public void setBiopsySites(String biopsySites) {
		this.biopsySites = biopsySites;
	}
	
	public String getHospitalNo() {
		return this.hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}
	
	public String getHtFsPacsMark() {
		return this.htFsPacsMark;
	}

	public void setHtFsPacsMark(String htFsPacsMark) {
		this.htFsPacsMark = htFsPacsMark;
	}

}