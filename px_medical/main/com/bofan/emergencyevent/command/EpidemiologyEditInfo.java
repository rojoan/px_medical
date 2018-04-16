package com.bofan.emergencyevent.command;

import java.util.Date;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 流行病学记录编辑
 * @author lqw
 */
public class EpidemiologyEditInfo  extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

	/** 流行病学记录ID */
	private Long epidemiologyId;
	
	/** 患者姓名 */
	private Long patientId;
	
	/** 患者姓名 */
	private String patientName;
	
	/** 患者家长姓名 */
	private String patientParentName;
	
	/** 患者档案编号 */
	private String patientArchive;
	
	/** 身份证号 */
	private String patientIdCard;
	
	/** 性别 1：男 2：女 */
	private String patientSex;
	
	/** 出生日期 */
	private Date birthDate;
	
	/** 工作单位 */
	private String worksOrg;
	
	/** 联系电话 */
	private String patientPhone;
	
	/** 病人属于 1：本县区 2：本市其他县区 3：本省其他地市 4：外省 5：港澳台 6：外籍 */
	private String patientBelong;
	
	/** 现住址 */
	private String patientAddr;
	
	/** 患者职业ID */
	private Long careerId;
	
	/** 病历分类 01=疑似病例 02=临床诊断病例 03=实验室确诊病例 04=病原携带者 05=阳性检测病例 06=急性乙型肝炎 07=慢性乙型肝炎 08=急性丙肝 09=慢性丙肝 10=急性吸血虫病 11=慢性吸血虫病 */
	private String medicalClassify;
	
	/** 发病日期，病原携带者填写初检日期或就诊日期 */
	private Date illTime;
	
	/** 诊断时间 */
	private Date diagnosisTime;
	
	/** 死亡时间 */
	private Date dieTime;
	
	/** 其他法定管理及重点监测传染病 */
	private String keyMonitor;
	
	/** 订正病名 */
	private String modifyIllName;
	
	/** 填报单位ID */
	private Long fillOrgId;
	
	/** 填报单位名称 */
	private String fillOrgName;
	
	/** 填报单位联系电话 */
	private String fillOrgPhone;
	
	/** 填报医生ID */
	private Long fillDoctorId;
	
	/** 填报医生 */
	private String fillDoctorName;
	
	/** 填写日期 */
	private Date fillTime;
	
	/** 备注 */
	private String remark;
 
	/** default constructor */
	public EpidemiologyEditInfo() {
	}

	/**
	 * @return epidemiologyId
	 */
	public Long getEpidemiologyId() {
		return epidemiologyId;
	}

	/**
	 * @param epidemiologyId 要设置的 epidemiologyId
	 */
	public void setEpidemiologyId(Long epidemiologyId) {
		this.epidemiologyId = epidemiologyId;
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
	 * @return patientParentName
	 */
	public String getPatientParentName() {
		return patientParentName;
	}

	/**
	 * @param patientParentName 要设置的 patientParentName
	 */
	public void setPatientParentName(String patientParentName) {
		this.patientParentName = patientParentName;
	}

	/**
	 * @return patientArchive
	 */
	public String getPatientArchive() {
		return patientArchive;
	}

	/**
	 * @param patientArchive 要设置的 patientArchive
	 */
	public void setPatientArchive(String patientArchive) {
		this.patientArchive = patientArchive;
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
	 * @return birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate 要设置的 birthDate
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return worksOrg
	 */
	public String getWorksOrg() {
		return worksOrg;
	}

	/**
	 * @param worksOrg 要设置的 worksOrg
	 */
	public void setWorksOrg(String worksOrg) {
		this.worksOrg = worksOrg;
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
	 * @return patientBelong
	 */
	public String getPatientBelong() {
		return patientBelong;
	}

	/**
	 * @param patientBelong 要设置的 patientBelong
	 */
	public void setPatientBelong(String patientBelong) {
		this.patientBelong = patientBelong;
	}

	/**
	 * @return patientAddr
	 */
	public String getPatientAddr() {
		return patientAddr;
	}

	/**
	 * @param patientAddr 要设置的 patientAddr
	 */
	public void setPatientAddr(String patientAddr) {
		this.patientAddr = patientAddr;
	}

	/**
	 * @return careerId
	 */
	public Long getCareerId() {
		return careerId;
	}

	/**
	 * @param careerId 要设置的 careerId
	 */
	public void setCareerId(Long careerId) {
		this.careerId = careerId;
	}

	/**
	 * @return medicalClassify
	 */
	public String getMedicalClassify() {
		return medicalClassify;
	}

	/**
	 * @param medicalClassify 要设置的 medicalClassify
	 */
	public void setMedicalClassify(String medicalClassify) {
		this.medicalClassify = medicalClassify;
	}

	/**
	 * @return illTime
	 */
	public Date getIllTime() {
		return illTime;
	}

	/**
	 * @param illTime 要设置的 illTime
	 */
	public void setIllTime(Date illTime) {
		this.illTime = illTime;
	}

	/**
	 * @return diagnosisTime
	 */
	public Date getDiagnosisTime() {
		return diagnosisTime;
	}

	/**
	 * @param diagnosisTime 要设置的 diagnosisTime
	 */
	public void setDiagnosisTime(Date diagnosisTime) {
		this.diagnosisTime = diagnosisTime;
	}

	/**
	 * @return dieTime
	 */
	public Date getDieTime() {
		return dieTime;
	}

	/**
	 * @param dieTime 要设置的 dieTime
	 */
	public void setDieTime(Date dieTime) {
		this.dieTime = dieTime;
	}

	/**
	 * @return keyMonitor
	 */
	public String getKeyMonitor() {
		return keyMonitor;
	}

	/**
	 * @param keyMonitor 要设置的 keyMonitor
	 */
	public void setKeyMonitor(String keyMonitor) {
		this.keyMonitor = keyMonitor;
	}

	/**
	 * @return modifyIllName
	 */
	public String getModifyIllName() {
		return modifyIllName;
	}

	/**
	 * @param modifyIllName 要设置的 modifyIllName
	 */
	public void setModifyIllName(String modifyIllName) {
		this.modifyIllName = modifyIllName;
	}

	/**
	 * @return fillOrgId
	 */
	public Long getFillOrgId() {
		return fillOrgId;
	}

	/**
	 * @param fillOrgId 要设置的 fillOrgId
	 */
	public void setFillOrgId(Long fillOrgId) {
		this.fillOrgId = fillOrgId;
	}

	/**
	 * @return fillOrgName
	 */
	public String getFillOrgName() {
		return fillOrgName;
	}

	/**
	 * @param fillOrgName 要设置的 fillOrgName
	 */
	public void setFillOrgName(String fillOrgName) {
		this.fillOrgName = fillOrgName;
	}

	/**
	 * @return fillOrgPhone
	 */
	public String getFillOrgPhone() {
		return fillOrgPhone;
	}

	/**
	 * @param fillOrgPhone 要设置的 fillOrgPhone
	 */
	public void setFillOrgPhone(String fillOrgPhone) {
		this.fillOrgPhone = fillOrgPhone;
	}

	/**
	 * @return fillDoctorId
	 */
	public Long getFillDoctorId() {
		return fillDoctorId;
	}

	/**
	 * @param fillDoctorId 要设置的 fillDoctorId
	 */
	public void setFillDoctorId(Long fillDoctorId) {
		this.fillDoctorId = fillDoctorId;
	}

	/**
	 * @return fillDoctorName
	 */
	public String getFillDoctorName() {
		return fillDoctorName;
	}

	/**
	 * @param fillDoctorName 要设置的 fillDoctorName
	 */
	public void setFillDoctorName(String fillDoctorName) {
		this.fillDoctorName = fillDoctorName;
	}

	/**
	 * @return fillTime
	 */
	public Date getFillTime() {
		return fillTime;
	}

	/**
	 * @param fillTime 要设置的 fillTime
	 */
	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
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
	
}