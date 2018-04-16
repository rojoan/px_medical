package com.bofan.pacs.command;



/**
 * @Description: 检查dicom数据记录编辑
 * @author lqw
 */
public class PacsDetailEditInfo {

	/** 实例Uid **/
    private String instanceUid;

	/** 序列号 **/
	private String seriesUid;
	
	/** 病人id -- 对应 patientExam 主键id **/
	private String patientId;
	
	/** dicom文件名 **/
	private String dicomFileName;
	
	/** 文件大小 */
    private Long fileSize;
	
	/** 检查Uid **/
	private String studyUid;
	
	/** 储存编号 **/
	private String accessNumber;
	
	/** 检查日期 **/
	private String dateTime;
	
	/** 医院标识不同的医院分配不同的标识 对应sys_org表中org_no字段 */
	private String hospitalNo;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	private String htFsPacsMark;
	
	/** bdb保存路径 */
	private String savePath;
 
	
	public PacsDetailEditInfo() {
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
	
}
