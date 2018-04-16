package com.bofan.pacs.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 医生检查报告内容
 * @author lqw
 * @date 2017年10月1日
 * @version V1.0
 */
public class ExamResultEditInfo  extends BaseCommandInfo {
    
    /**
     * 
     */
    private static final long serialVersionUID = -817804215266814182L;
	
    /** 病人检查号 */
    private String patientExamNum;
    
	/** ExamResult 检查所见 */
	private String examFindings;
	
	/** ExamResult 检查提示 */
	private String examHint;
	
	/** ExamResult 检查建议 */
	private String examAdvise;
	
	/** PatientExamt 审核医生 */
	private String auditDoctor;
	
	/** 医院标识不同的医院分配不同的标识 */
	private String hospitalNo;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	private String htFsPacsMark;

	/**
	 * @return patientExamNum
	 */
	public String getPatientExamNum() {
		return patientExamNum;
	}

	/**
	 * @param patientExamNum 要设置的 patientExamNum
	 */
	public void setPatientExamNum(String patientExamNum) {
		this.patientExamNum = patientExamNum;
	}

	/**
	 * @return examFindings
	 */
	public String getExamFindings() {
		return examFindings;
	}

	/**
	 * @param examFindings 要设置的 examFindings
	 */
	public void setExamFindings(String examFindings) {
		this.examFindings = examFindings;
	}

	/**
	 * @return examHint
	 */
	public String getExamHint() {
		return examHint;
	}

	/**
	 * @param examHint 要设置的 examHint
	 */
	public void setExamHint(String examHint) {
		this.examHint = examHint;
	}

	/**
	 * @return examAdvise
	 */
	public String getExamAdvise() {
		return examAdvise;
	}

	/**
	 * @param examAdvise 要设置的 examAdvise
	 */
	public void setExamAdvise(String examAdvise) {
		this.examAdvise = examAdvise;
	}

	/**
	 * @return auditDoctor
	 */
	public String getAuditDoctor() {
		return auditDoctor;
	}

	/**
	 * @param auditDoctor 要设置的 auditDoctor
	 */
	public void setAuditDoctor(String auditDoctor) {
		this.auditDoctor = auditDoctor;
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
	 * @return htFsPacsMark
	 */
	public String getHtFsPacsMark() {
		return htFsPacsMark;
	}

	/**
	 * @param htFsPacsMark 要设置的 htFsPacsMark
	 */
	public void setHtFsPacsMark(String htFsPacsMark) {
		this.htFsPacsMark = htFsPacsMark;
	}

}
