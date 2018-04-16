package com.bofan.pacs.command;

import java.util.Date;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * PatientImageQueryInfo
 * @version    1.0    2017-09-4
 */
@SuppressWarnings("serial")
@QueryInfo(from="com.bofan.pacs.valueobject.PatientImage ",orderBy = "imageSort asc") 
public class PatientImageQueryInfo extends BaseCommandInfo {

	/** 病人图像主键ID */
    @QueryParam(fieldName="patientImageId",op = QueryOperator.EQU)
	private Long patientImageId;
	
	/** 图象标识 */
    @QueryParam(fieldName="patientImageNum",op = QueryOperator.EQU)
	private Long patientImageNum;
	
	/** 病人检查号 */
    @QueryParam(fieldName="patientExamNum",op = QueryOperator.EQU)
	private String patientExamNum;
	
	/** 图象文件名 */
    @QueryParam(fieldName="imageFileName",op = QueryOperator.EQU)
	private String imageFileName;
	
	/** 图象类型 */
    @QueryParam(fieldName="imageType",op = QueryOperator.EQU)
	private String imageType;
	
	/** 图象分类 */
    @QueryParam(fieldName="imageClassify",op = QueryOperator.EQU)
	private String imageClassify;
	
	/** 图象编号 */
    @QueryParam(fieldName="imageNumber",op = QueryOperator.EQU)
	private String imageNumber;
	
	/** 序列编号 */
    @QueryParam(fieldName="serialNumber",op = QueryOperator.EQU)
	private String serialNumber;
	
    /** 图象日期 起始时间 */
    @QueryParam(fieldName="imageDate",op = QueryOperator.GT_EQU)
    private Date imageDateBegin;

    /** 图象日期 结束时间*/
    @QueryParam(fieldName="imageDate",op = QueryOperator.LESS_EQU)
    private Date imageDateEnd;

	/** 采集地址 */
    @QueryParam(fieldName="collectionAddress",op = QueryOperator.EQU)
	private String collectionAddress;
	
	/** 图象序列 */
    @QueryParam(fieldName="imageSerial",op = QueryOperator.EQU)
	private Long imageSerial;
	
	/** 医院标识 */
    @QueryParam(fieldName="hospitalNo",op = QueryOperator.EQU)
	private String hospitalNo;
	
	/** bdb数据库关键字 */
    @QueryParam(fieldName="bdbKey",op = QueryOperator.EQU)
	private String bdbKey;
	
	/** ht-fs数据库标识 */
    @QueryParam(fieldName="htFsPacsMark",op = QueryOperator.EQU)
	private String htFsPacsMark;

	// Constructors

	/** default constructor */
	public PatientImageQueryInfo() {
	}

	/** minimal constructor */
	public PatientImageQueryInfo(Long patientImageId, Long patientImageNum,
			String patientExamNum, String imageFileName,String hospitalNo, String htFsPacsMark) {
		this.patientImageId = patientImageId;
		this.patientImageNum = patientImageNum;
		this.patientExamNum = patientExamNum;
		this.imageFileName = imageFileName;
		this.hospitalNo = hospitalNo;
		this.htFsPacsMark = htFsPacsMark;
	}

	/**
	 * @return the patientImageId
	 */
	public Long getPatientImageId() {
		return patientImageId;
	}

	/**
	 * @param patientImageId the patientImageId to set
	 */
	public void setPatientImageId(Long patientImageId) {
		this.patientImageId = patientImageId;
	}

	/**
	 * @return the patientImageNum
	 */
	public Long getPatientImageNum() {
		return patientImageNum;
	}

	/**
	 * @param patientImageNum the patientImageNum to set
	 */
	public void setPatientImageNum(Long patientImageNum) {
		this.patientImageNum = patientImageNum;
	}

	/**
	 * @return the patientExamNum
	 */
	public String getPatientExamNum() {
		return patientExamNum;
	}

	/**
	 * @param patientExamNum the patientExamNum to set
	 */
	public void setPatientExamNum(String patientExamNum) {
		this.patientExamNum = patientExamNum;
	}

	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * @param imageFileName the imageFileName to set
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	/**
	 * @return the imageType
	 */
	public String getImageType() {
		return imageType;
	}

	/**
	 * @param imageType the imageType to set
	 */
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	/**
	 * @return the imageClassify
	 */
	public String getImageClassify() {
		return imageClassify;
	}

	/**
	 * @param imageClassify the imageClassify to set
	 */
	public void setImageClassify(String imageClassify) {
		this.imageClassify = imageClassify;
	}

	/**
	 * @return the imageNumber
	 */
	public String getImageNumber() {
		return imageNumber;
	}

	/**
	 * @param imageNumber the imageNumber to set
	 */
	public void setImageNumber(String imageNumber) {
		this.imageNumber = imageNumber;
	}

	/**
	 * @return the serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber the serialNumber to set
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the imageDateBegin
	 */
	public Date getImageDateBegin() {
		return imageDateBegin;
	}

	/**
	 * @param imageDateBegin the imageDateBegin to set
	 */
	public void setImageDateBegin(Date imageDateBegin) {
		this.imageDateBegin = imageDateBegin;
	}

	/**
	 * @return the imageDateEnd
	 */
	public Date getImageDateEnd() {
		return imageDateEnd;
	}

	/**
	 * @param imageDateEnd the imageDateEnd to set
	 */
	public void setImageDateEnd(Date imageDateEnd) {
		this.imageDateEnd = imageDateEnd;
	}

	/**
	 * @return the collectionAddress
	 */
	public String getCollectionAddress() {
		return collectionAddress;
	}

	/**
	 * @param collectionAddress the collectionAddress to set
	 */
	public void setCollectionAddress(String collectionAddress) {
		this.collectionAddress = collectionAddress;
	}

	/**
	 * @return the imageSerial
	 */
	public Long getImageSerial() {
		return imageSerial;
	}

	/**
	 * @param imageSerial the imageSerial to set
	 */
	public void setImageSerial(Long imageSerial) {
		this.imageSerial = imageSerial;
	}

	/**
	 * @return the hospitalNo
	 */
	public String getHospitalNo() {
		return hospitalNo;
	}

	/**
	 * @param hospitalNo the hospitalNo to set
	 */
	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	/**
	 * @return the bdbKey
	 */
	public String getBdbKey() {
		return bdbKey;
	}

	/**
	 * @param bdbKey the bdbKey to set
	 */
	public void setBdbKey(String bdbKey) {
		this.bdbKey = bdbKey;
	}

	/**
	 * @return the htFsPacsMark
	 */
	public String getHtFsPacsMark() {
		return htFsPacsMark;
	}

	/**
	 * @param htFsPacsMark the htFsPacsMark to set
	 */
	public void setHtFsPacsMark(String htFsPacsMark) {
		this.htFsPacsMark = htFsPacsMark;
	}

}