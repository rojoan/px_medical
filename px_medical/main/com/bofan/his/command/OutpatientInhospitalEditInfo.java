package com.bofan.his.command;

import java.util.Date;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 门诊/住院登记编辑
 * @author lqw
 */
public class OutpatientInhospitalEditInfo extends BaseCommandInfo {
	private static final long serialVersionUID = 1L;
	
	/** 门诊-住院ID，此表同步HIS表 */
	private Long outpatientInhospitalId;
	
	/** 组织机构（医院单位）ID 对应sys_org表中，医院编码（标识）对应的单位ID **/
	private Long orgId;
	
	/** 组织机构（医院单位）ID 对应sys_org表中，医院编码 **/
	private String hospitalNo;
	
	/** 患者主键ID */
	private Long patientId;
 
	/** 患者姓名 **/
	private String patientName;
	
	/** 性别 , 冗余字段 **/
	private String patientSex;

	/** 证件号码 **/
	private String patientIdCard;
	
	/** 住院号ID 住院表的流水号 */
	private Long inhospitalId;
	
	/** 住院号码 住院号码是病人的住院识别号，性质和门诊的就诊卡号一样。 理论上应该是一个人一个唯一的住院号码。 */
	private String inhospitalNo;
	
	/** 入院日期 */
	private Date diagnosisDate;
	
	/** 门诊挂号明细ID */
	private Long outpatientId;
	
	/** 门诊号码 门诊号码是病人的就诊卡号--一卡通号， 理论上应该是一个人一个就诊卡号 */
	private String patientCardNo;
	
	//病人检查表内容
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
	/** 检查分类： 1=超声 ，2=放射 ，3=内镜 ，4=病理*/
	private String examCategory;
	
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
	
}