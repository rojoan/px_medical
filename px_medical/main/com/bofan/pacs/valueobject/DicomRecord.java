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
 * @Description: dicom_record（图像信息记录表）实体
 * @author lqw
 * @date 2017年9月25日 下午7:14:36
 * @version V1.0
 */
@Entity
@Table(name = "DICOM_RECORD", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "DICOM_RECORD_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".DICOM_RECORD_ID", allocationSize=1)
public class DicomRecord {

	// Fields

	/** 图像信息记录主键ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DICOM_RECORD_ID")
	@Column(name = "DICOM_RECORD_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long dicomRecordId;

	/** 图像信息记录标识，原PACS系统主键标识 */
	@Column(name = "DICOM_RECORD_NUM", precision = 18, scale = 0)
	private Long dicomRecordNum;
	
	/** 检查号UID */
	@Column(name = "STUDY_UID", length = 128)
	private String studyUid;
	
	/** 患者姓名 */
	@Column(name = "PATIENT_NAME", length = 128)
	private String patientName;
	
	/** 患者ID对应fsPACS|htPACS 的患者ID,不是同步后生成的表主键ID */
	@Column(name = "PATIENT_ID", length = 128)
	private String patientId;
	
	/** 存储编号 */
	@Column(name = "ACCESSION_NUMBER", length = 128)
	private String accessionNumber;
	
	/** DICOM第一层路径仅仅同步PACS C/S 系统 dicom文件保存的第一层路径 */
	@Column(name = "DICOM_ONE_PATH", length = 50)
	private String dicomOnePath;
	
	/** DICOM第二层路径仅仅同步PACS C/S 系统 dicom文件保存的第二层路径 */
	@Column(name = "DICOM_TWO_PATH", length = 50)
	private String dicomTwoPath;
	
	/** 影像类型影像类型，如：DX、CT、MR */
	@Column(name = "MODALITY", length = 10)
	private String modality;
	
	/** 创建时间 */
	@Column(name = "CREATE_DATETIME")
	private Date createDatetime;
	
	/** 医院标识不同的医院分配不同的标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	@Column(name = "HT_FS_PACS_MARK", nullable = false, length = 1)
	private String htFsPacsMark;

	// Constructors

	/** default constructor */
	public DicomRecord() {
	}

	// Property accessors

	public Long getDicomRecordId() {
		return this.dicomRecordId;
	}

	public void setDicomRecordId(Long dicomRecordId) {
		this.dicomRecordId = dicomRecordId;
	}

	public Long getDicomRecordNum() {
		return this.dicomRecordNum;
	}

	public void setDicomRecordNum(Long dicomRecordNum) {
		this.dicomRecordNum = dicomRecordNum;
	}

	public String getStudyUid() {
		return this.studyUid;
	}

	public void setStudyUid(String studyUid) {
		this.studyUid = studyUid;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getAccessionNumber() {
		return this.accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
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

	public String getModality() {
		return this.modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public Date getCreateDatetime() {
		return this.createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
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