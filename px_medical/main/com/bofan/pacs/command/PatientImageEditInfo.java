package com.bofan.pacs.command;



/**
 * @Description: PATIENT_IMAGE病人图象保存
 * @author lqw
 */
public class PatientImageEditInfo {
	/** 病人图像主键ID */
	private Long patientImageId;
	
	/** 图象标识 */
	private Long patientImageNum;
	
	/** 病人检查号 */
	private String patientExamNum;
	
	/** 图象文件名 */
	private String imageFileName;
	
	/** 图象类型 */
	private String imageType;
	
	/** 图象是否可用 */
	private String imageIsAvailable;
	
	/** 图象排序 */
	private Long imageSort;
	
	/** 医院标识不同的医院分配不同的标识 */
	private String hospitalNo;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	private String htFsPacsMark;
	
	/** bdb保存路径 */
	private String savePath;
	
	/** bdb数据库关键字 */
	private String bdbKey;
	
	
	
	/**
	 * @return imageSort
	 */
	public Long getImageSort() {
		return imageSort;
	}

	/**
	 * @param imageSort 要设置的 imageSort
	 */
	public void setImageSort(Long imageSort) {
		this.imageSort = imageSort;
	}

	/**
	 * @return patientImageId
	 */
	public Long getPatientImageId() {
		return patientImageId;
	}

	/**
	 * @param patientImageId 要设置的 patientImageId
	 */
	public void setPatientImageId(Long patientImageId) {
		this.patientImageId = patientImageId;
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

	/**
	 * @return bdbKey
	 */
	public String getBdbKey() {
		return bdbKey;
	}

	/**
	 * @param bdbKey 要设置的 bdbKey
	 */
	public void setBdbKey(String bdbKey) {
		this.bdbKey = bdbKey;
	}

	/**
	 * @return imageIsAvailable
	 */
	public String getImageIsAvailable() {
		return imageIsAvailable;
	}

	/**
	 * @param imageIsAvailable 要设置的 imageIsAvailable
	 */
	public void setImageIsAvailable(String imageIsAvailable) {
		this.imageIsAvailable = imageIsAvailable;
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

	/**
	 * @return patientImageNum
	 */
	public Long getPatientImageNum() {
		return patientImageNum;
	}

	/**
	 * @param patientImageNum 要设置的 patientImageNum
	 */
	public void setPatientImageNum(Long patientImageNum) {
		this.patientImageNum = patientImageNum;
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
	 * @return imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * @param imageFileName 要设置的 imageFileName
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
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
	

}