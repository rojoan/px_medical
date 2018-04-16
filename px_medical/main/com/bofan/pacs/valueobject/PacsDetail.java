package com.bofan.pacs.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bofan.utils.SchemaConsts;
import com.bofan.utils.Tools;

/**
 * @Description: 检查dicom数据记录
 * @author lqw
 * @date 2017-09-26
 * @version v1.0
 */
@Entity
@Table(name = "PACS_DETAIL", schema = SchemaConsts.PACS_SCHEMA)
public class PacsDetail {

	/** 实例Uid **/
	@Id
	@Column(name = "INSTANCEUID", unique = true, nullable = false, length = 50)
    private String instanceUid;

	/** 序列号 **/
	@Column(name = "SERIESUID",  nullable = false, length = 50)
	private String seriesUid;
	
	/** 病人id -- 对应 patientExam 主键id **/
	@Column(name = "PATIENTID",  nullable = false, length = 50)
	private String patientId;
	
	/** dicom文件名 **/
	@Column(name = "DICOM_FILE_NAME",  nullable = false, length = 50)
	private String dicomFileName;
	
	/** 文件大小 */
    @Column(name = "FILE_SIZE", nullable = false, precision = 18, scale = 0)
    private Long fileSize;
    
	/** 检查Uid **/
	@Column(name = "STUDYUID",  nullable = false, length = 50)
	private String studyUid;
	
	/** 储存编号 **/
	@Column(name = "ACCESSNUMBER",  nullable = false, length = 50)
	private String accessNumber;
	
	/** 检查日期 **/
	@Column(name = "DATETIME", nullable = false, length = 30)
	private String dateTime;
	
	/** 医院标识不同的医院分配不同的标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	@Column(name = "HT_FS_PACS_MARK", nullable = false, length = 1)
	private String htFsPacsMark;
	
	/** bdb保存路径 */
	@Column(name = "SAVE_PATH", length = 100)
	private String savePath;
 
    @Transient
    private String formatSize;
	
	public PacsDetail() {
	}
 
	public String getInstanceUid() {
		return instanceUid;
	}

	public void setInstanceUid(String instanceUid) {
		this.instanceUid = instanceUid;
	}

	public String getSeriesUid() {
		return seriesUid;
	}

	public void setSeriesUid(String seriesUid) {
		this.seriesUid = seriesUid;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDicomFileName() {
		return dicomFileName;
	}

	public void setDicomFileName(String dicomFileName) {
		this.dicomFileName = dicomFileName;
	}

	/**
     * @return fileSize
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize 要设置的 fileSize
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getStudyUid() {
		return studyUid;
	}

	public void setStudyUid(String studyUid) {
		this.studyUid = studyUid;
	}

	public String getAccessNumber() {
		return accessNumber;
	}

	public void setAccessNumber(String accessNumber) {
		this.accessNumber = accessNumber;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getHospitalNo() {
		return hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getHtFsPacsMark() {
		return htFsPacsMark;
	}

	public void setHtFsPacsMark(String htFsPacsMark) {
		this.htFsPacsMark = htFsPacsMark;
	}

	/**
	 * @return savePath
	 */
	public String getSavePath() {
		return savePath;
	}

	/**
	 * @param savePath 要设置的 savePath
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFormatSize() {
        if (null != this.fileSize) {
            formatSize = Tools.formatSize(this.fileSize);
        }
        return formatSize;
    }

    /**
     * @param formatSize 要设置的 formatSize
     */
    public void setFormatSize(String formatSize) {
        this.formatSize = formatSize;
    }
}
