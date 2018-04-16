package com.bofan.pacs.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @ClassName: PatientArchive.java 
 * @Description: PATIENT_ARCHIVE (病人档案表)
 */
@Entity
@Table(name = "PATIENT_ARCHIVE", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "PATIENT_ARCHIVE_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".PATIENT_ARCHIVE_ID", allocationSize=1)
public class PatientArchive {

	// Fields

	/** 病人档案主键ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT_ARCHIVE_ID")
	@Column(name = "PATIENT_ARCHIVE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long patientArchiveId;
	
	/** 病人档案号在fsPACS或者htPACS中的病人档案表唯一标识 */
	@Column(name = "PATIENT_ARCHIVE_NUM", nullable = false, length = 20)
	private String patientArchiveNum;
	
	/** 患者姓名 */
	@Column(name = "PATIENT_NAME", nullable = false, length = 30)
	private String patientName;
	
	/** 病人拼音姓名 */
	@Column(name = "PATIENT_SPELL_NAME", length = 50)
	private String patientSpellName;
	
	/**  病人性别  */
	@Column(name = "PATIENT_SEX", nullable = false, length = 5)
	private String patientSex;
	
	/**  病人出生时间  */
	@Column(name = "PATIENT_BIRTHDAY", nullable = false)
	private Date patientBirthday;
	
	/**  病人联系方法  */
	@Column(name = "PATIENT_CONTACT", length = 256)
	private String patientContact;
	
	 /**  病人社会保险号  */
	@Column(name = "SOCIAL_SECURITY_NUM", length = 25)
	private String socialSecurityNum;
	
	/**  病人建档时间  */
	@Column(name = "ARCHIVE_CREATE_DATE")
	private Date archiveCreateDate;
	
	 /**  病人是否结婚  */
	@Column(name = "IS_MARRIED", length = 2)
	private String isMarried;
	
	/**  病人孕次  */
	@Column(name = "PREGNANCY_TIMES", precision = 18, scale = 0)
	private Long pregnancyTimes;
	
	 /**  病人产次  */
	@Column(name = "CHILDBIRTH_TIMES", precision = 18, scale = 0)
	private Long childbirthTimes;
	
	 /**  病人HIS号  */
	@Column(name = "PATIENT_HIS_NUM", length = 128)
	private String patientHisNum;
	
	/**  民族ID  */
	@Column(name = "NATION", length = 2)
	private String nation;
	
	/**  民族名称  */
	@Column(name = "NATION_NAME", length = 20)
	private String nationName;
	
	/**  病人ID  */
	@Column(name = "PATIENT_ID", length = 50)
	private String patientId;
	
	/**  血型  */
	@Column(name = "BLOOD_TYPE", length = 20)
	private String bloodType;
	
	 /**  所有者ID  */
	@Column(name = "PROPRIETOR", length = 20)
	private String proprietor;
	
	/**  所有者姓名  */
	@Column(name = "PROPRIETOR_NAME", length = 20)
	private String proprietorName;
	
	/**  电话号码  */
	@Column(name = "TELEPHONE", length = 20)
	private String telephone;
	
	/**  医院标识不同的医院分配不同的标识  对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	 /**  来源ip  */
	@Column(name = "SOURCE_IP", length = 20)
	private String sourceIp;
	
	/**  ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS  */
	@Column(name = "HT_FS_PACS_MARK", nullable = false, length = 1)
	private String htFsPacsMark;

	// Constructors

	/** default constructor */
	public PatientArchive() {
	}

	// Property accessors
	
	public String getPatientName() {
		return this.patientName;
	}

	/**
	 * @return the patientArchiveId
	 */
	public Long getPatientArchiveId() {
		return patientArchiveId;
	}

	/**
	 * @param patientArchiveId the patientArchiveId to set
	 */
	public void setPatientArchiveId(Long patientArchiveId) {
		this.patientArchiveId = patientArchiveId;
	}

	/**
	 * @return the patientArchiveNum
	 */
	public String getPatientArchiveNum() {
		return patientArchiveNum;
	}

	/**
	 * @param patientArchiveNum the patientArchiveNum to set
	 */
	public void setPatientArchiveNum(String patientArchiveNum) {
		this.patientArchiveNum = patientArchiveNum;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientSpellName() {
		return this.patientSpellName;
	}

	public void setPatientSpellName(String patientSpellName) {
		this.patientSpellName = patientSpellName;
	}

	public String getPatientSex() {
		return this.patientSex;
	}

	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	
	public Date getPatientBirthday() {
		return this.patientBirthday;
	}

	public void setPatientBirthday(Date patientBirthday) {
		this.patientBirthday = patientBirthday;
	}

	public String getPatientContact() {
		return this.patientContact;
	}

	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}
	
	public String getSocialSecurityNum() {
		return this.socialSecurityNum;
	}

	public void setSocialSecurityNum(String socialSecurityNum) {
		this.socialSecurityNum = socialSecurityNum;
	}

	public Date getArchiveCreateDate() {
		return this.archiveCreateDate;
	}

	public void setArchiveCreateDate(Date archiveCreateDate) {
		this.archiveCreateDate = archiveCreateDate;
	}

	public String getIsMarried() {
		return this.isMarried;
	}

	public void setIsMarried(String isMarried) {
		this.isMarried = isMarried;
	}

	public Long getPregnancyTimes() {
		return this.pregnancyTimes;
	}

	public void setPregnancyTimes(Long pregnancyTimes) {
		this.pregnancyTimes = pregnancyTimes;
	}

	public Long getChildbirthTimes() {
		return this.childbirthTimes;
	}

	public void setChildbirthTimes(Long childbirthTimes) {
		this.childbirthTimes = childbirthTimes;
	}

	public String getPatientHisNum() {
		return this.patientHisNum;
	}

	public void setPatientHisNum(String patientHisNum) {
		this.patientHisNum = patientHisNum;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getNationName() {
		return this.nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getBloodType() {
		return this.bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getProprietor() {
		return this.proprietor;
	}

	public void setProprietor(String proprietor) {
		this.proprietor = proprietor;
	}

	public String getProprietorName() {
		return this.proprietorName;
	}

	public void setProprietorName(String proprietorName) {
		this.proprietorName = proprietorName;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHospitalNo() {
		return this.hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getSourceIp() {
		return this.sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	public String getHtFsPacsMark() {
		return this.htFsPacsMark;
	}

	public void setHtFsPacsMark(String htFsPacsMark) {
		this.htFsPacsMark = htFsPacsMark;
	}

}