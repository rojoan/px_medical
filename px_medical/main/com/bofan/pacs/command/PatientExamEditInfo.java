package com.bofan.pacs.command;

import java.util.Date;

import com.bofan.basesystem.common.command.BaseCommandInfo;


public class PatientExamEditInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;
	/** 组织机构（医院单位）ID 对应sys_org表中，医院编码（标识）对应的单位ID **/
	private Long orgId;
	
	/** 患者主键ID */
	private Long patientId;
	
	/** 患者姓名 **/
	private String patientName;
	
	/** 病人类别（对应病人来源字段中文的解析） 1=住院 2=门诊 3=住院急诊 4=门诊急诊 5=体检 */
	private Long patientType;
	
	/*** HIS辅助号（ 病人门诊住院唯一号） 根据病人类别对应  
	 * 门诊--对应云HIS系统   REGISTATION（门诊挂号）的主键ID 住院--对应云HIS系统    HOSPITALREGISTER（住院登记）的主键ID*/
	private Long inpatientId;
	
	/** 病人检查主键ID */
	private Long patientExamId;
	
	/** 图片类型 1=dicom 图片 2=img 图片 */
	private String imageType;
	
	/** 检查部位 */
	private String examPart;
	
	/** 主诉 */
	private String mainDesc;
	
	/** 病人检查号 */
	private String patientExamNum;
	
	/** 病人档案号 */
	private String patientArchiveNum;
	
	/** 检查分类  放射 改成 ： 1=超声 ，2=放射 ，3=内镜 ，4=病理*/
	private String examCategory;
	
	/** 影像科室标识 1=超声 ，2=放射 ，3=内镜 ，4=病理*/
	private Long imageDeptNum;
	
	/** 检查时间 */
	private Date examDate;
	
	/** 医院标识不同的医院分配不同的标识 */
	private String hospitalNo;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	private String htFsPacsMark;
	
	
	/**
	 * @return imageDeptNum
	 */
	public Long getImageDeptNum() {
		return imageDeptNum;
	}
	/**
	 * @param imageDeptNum 要设置的 imageDeptNum
	 */
	public void setImageDeptNum(Long imageDeptNum) {
		this.imageDeptNum = imageDeptNum;
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
	 * @return inpatientId
	 */
	public Long getInpatientId() {
		return inpatientId;
	}
	/**
	 * @param inpatientId 要设置的 inpatientId
	 */
	public void setInpatientId(Long inpatientId) {
		this.inpatientId = inpatientId;
	}
	/**
	 * @return patientType
	 */
	public Long getPatientType() {
		return patientType;
	}
	/**
	 * @param patientType 要设置的 patientType
	 */
	public void setPatientType(Long patientType) {
		this.patientType = patientType;
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
	 * @return patientExamId
	 */
	public Long getPatientExamId() {
		return patientExamId;
	}
	/**
	 * @param patientExamId 要设置的 patientExamId
	 */
	public void setPatientExamId(Long patientExamId) {
		this.patientExamId = patientExamId;
	}
	/**
	 * @return imageType
	 */
	public String getImageType() {
		return imageType;
	}
	/**
	 * @param imageType 要设置的 imageType
	 */
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	/**
	 * @return examPart
	 */
	public String getExamPart() {
		return examPart;
	}
	/**
	 * @param examPart 要设置的 examPart
	 */
	public void setExamPart(String examPart) {
		this.examPart = examPart;
	}
	/**
	 * @return mainDesc
	 */
	public String getMainDesc() {
		return mainDesc;
	}
	/**
	 * @param mainDesc 要设置的 mainDesc
	 */
	public void setMainDesc(String mainDesc) {
		this.mainDesc = mainDesc;
	}
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
	 * @return patientArchiveNum
	 */
	public String getPatientArchiveNum() {
		return patientArchiveNum;
	}
	/**
	 * @param patientArchiveNum 要设置的 patientArchiveNum
	 */
	public void setPatientArchiveNum(String patientArchiveNum) {
		this.patientArchiveNum = patientArchiveNum;
	}
	/**
	 * @return examCategory
	 */
	public String getExamCategory() {
		return examCategory;
	}
	/**
	 * @param examCategory 要设置的 examCategory
	 */
	public void setExamCategory(String examCategory) {
		this.examCategory = examCategory;
	}
	/**
	 * @return examDate
	 */
	public Date getExamDate() {
		return examDate;
	}
	/**
	 * @param examDate 要设置的 examDate
	 */
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
}