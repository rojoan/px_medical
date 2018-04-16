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
 * @Description: dicom_match（图像匹配表）实体
 * @author lqw
 * @date 2017-09-26
 * @version V1.0
 */
@Entity
@Table(name = "DICOM_MATCH", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "DICOM_MATCH_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".DICOM_MATCH_ID", allocationSize=1)
public class DicomMatch {

	// Fields
	/**  图形匹配表主键ID  */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DICOM_MATCH_ID")
	@Column(name = "DICOM_MATCH_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long dicomMatchId;
	
	 /**  图形匹配编号标识  */
	@Column(name = "DICOM_MATCH_NUM", precision = 18, scale = 0)
	private Long dicomMatchNum;
	
	/**  检查编号  */
	@Column(name = "STUDY_UID", length = 128)
	private String studyUid;
	
	/**  病人编号  */
	@Column(name = "PATIENT_ID", length = 50)
	private String patientId;
	
	/**  存取编号  */
	@Column(name = "ACCESS_NUMBER", length = 50)
	private String accessNumber;
	
	/**  病人检查号  */
	@Column(name = "PATIENT_EXAM_NUM", length = 50)
	private String patientExamNum;
	
	/**  姓名  */
	@Column(name = "PATIENT_NAME", length = 50)
	private String patientName;
	
	/**  性别  */
	@Column(name = "PATIENT_SEX", length = 50)
	private String patientSex;
	
	/**  年龄  */
	@Column(name = "PATIENT_AGE", length = 12)
	private String patientAge;
	
	/**  设备类型  */
	@Column(name = "DEVICE_TYPE", length = 50)
	private String deviceType;
	
	/**  检查时间  */
	@Column(name = "EXAM_DATE")
	private Date examDate;
	
	/**  序列数量  */
	@Column(name = "SEQUENCE_COUNT", precision = 18, scale = 0)
	private Long sequenceCount;
	
	/**  图像数量  */
	@Column(name = "DICOM_COUNT", precision = 18, scale = 0)
	private Long dicomCount;
	
	/**  数据文件储存路径  */
	@Column(name = "DICOM_SAVE_PATH", length = 50)
	private String dicomSavePath;
	
	/**  DICOM第一层路径仅仅同步PACS  C/S 系统 dicom文件保存的第一层路径，本系统不使用  */
	@Column(name = "DICOM_ONE_PATH", length = 10)
	private String dicomOnePath;
	
	/**  DICOM第二层路径仅仅同步PACS  C/S 系统 dicom文件保存的第二层路径，本系统不使用  */
	@Column(name = "DICOM_TWO_PATH", length = 10)
	private String dicomTwoPath;
	
	/**  医院标识不同的医院分配不同的标识  对应sys_org表中org_no字段*/
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	 /**  ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS  */
	@Column(name = "HT_FS_PACS_MARK", nullable = false, length = 1)
	private String htFsPacsMark;

	// Constructors

	/** default constructor */
	public DicomMatch() {
	}

	// Property accessors
	public Long getDicomMatchNum() {
		return this.dicomMatchNum;
	}

	public void setDicomMatchNum(Long dicomMatchNum) {
		this.dicomMatchNum = dicomMatchNum;
	}
	
	public Long getDicomMatchId() {
		return this.dicomMatchId;
	}

	public void setDicomMatchId(Long dicomMatchId) {
		this.dicomMatchId = dicomMatchId;
	}
	
	public String getStudyUid() {
		return this.studyUid;
	}

	public void setStudyUid(String studyUid) {
		this.studyUid = studyUid;
	}
	
	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public String getAccessNumber() {
		return this.accessNumber;
	}

	public void setAccessNumber(String accessNumber) {
		this.accessNumber = accessNumber;
	}
	
	public String getPatientExamNum() {
		return this.patientExamNum;
	}

	public void setPatientExamNum(String patientExamNum) {
		this.patientExamNum = patientExamNum;
	}
	
	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public String getPatientSex() {
		return this.patientSex;
	}

	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	
	public String getPatientAge() {
		return this.patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	
	public String getDeviceType() {
		return this.deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	
	public Date getExamDate() {
		return this.examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
	public Long getSequenceCount() {
		return this.sequenceCount;
	}

	public void setSequenceCount(Long sequenceCount) {
		this.sequenceCount = sequenceCount;
	}
	
	public Long getDicomCount() {
		return this.dicomCount;
	}

	public void setDicomCount(Long dicomCount) {
		this.dicomCount = dicomCount;
	}

	public String getDicomSavePath() {
		return this.dicomSavePath;
	}

	public void setDicomSavePath(String dicomSavePath) {
		this.dicomSavePath = dicomSavePath;
	}
	
	public String getDicomOnePath() {
		return this.dicomOnePath;
	}

	public void setDicomOnePath(String dicomOnePath) {
		this.dicomOnePath = dicomOnePath;
	}
	
	public String getDicomTwoPath() {
		return this.dicomTwoPath;
	}

	public void setDicomTwoPath(String dicomTwoPath) {
		this.dicomTwoPath = dicomTwoPath;
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