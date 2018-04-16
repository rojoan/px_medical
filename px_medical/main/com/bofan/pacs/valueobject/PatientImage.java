package com.bofan.pacs.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: PATIENT_IMAGE（病人图象表）实体
 * @author lqw
 * @date 2017-09-26
 * @version V1.0
 */
@Entity
@Table(name = "PATIENT_IMAGE", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "PATIENT_IMAGE_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".PATIENT_IMAGE_ID", allocationSize=1)
public class PatientImage {

	// Fields

	/** 病人图像主键ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT_IMAGE_ID")
	@Column(name = "PATIENT_IMAGE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long patientImageId;
	
	/** 图象标识 */
	@Column(name = "PATIENT_IMAGE_NUM", nullable = false, precision = 18, scale = 0)
	private Long patientImageNum;
	
	/** 病人检查号 */
	@Column(name = "PATIENT_EXAM_NUM", nullable = false, length = 20)
	private String patientExamNum;
	
	/** 图象文件名 */
	@Column(name = "IMAGE_FILE_NAME", nullable = false, length = 128)
	private String imageFileName;
	
	/** 图象类型 */
	@Column(name = "IMAGE_TYPE", length = 8)
	private String imageType;
	
	/** 是否备份 */
	@Column(name = "IS_BACKUP", length = 1)
	private String isBackup;
	
	/** 备份标识 */
	@Column(name = "BACKUP_FLAG", precision = 18, scale = 0)
	private Long backupFlag;
	
	/** 体位标记 */
	@Column(name = "BODY_TAG", length = 6)
	private String bodyTag;
	
	/** 体位标记说明 */
	@Column(name = "BODY_TAG_EXPLAIN", length = 64)
	private String bodyTagExplain;
	
	/** 图象分类 */
	@Column(name = "IMAGE_CLASSIFY", length = 64)
	private String imageClassify;
	
	/** 图象说明 */
	@Column(name = "IMAGE_EXPLAIN" , length = 4000)
	private String imageExplain;
	
	/** 图象是否可用 */
	@Column(name = "IMAGE_IS_AVAILABLE", nullable = false, length = 1)
	private String imageIsAvailable;
	
	/** 是否已打印 */
	@Column(name = "IS_PRINTED", precision = 18, scale = 0)
	private Long isPrinted;
	
	/** 打印顺序 */
	@Column(name = "PRINT_SORT", precision = 18, scale = 0)
	private Long printSort;
	
	/** 图象编号 */
	@Column(name = "IMAGE_NUMBER", length = 128)
	private String imageNumber;
	
	/** 序列编号 */
	@Column(name = "SERIAL_NUMBER", length = 128)
	private String serialNumber;
	
	/** 图象日期 */
	@Column(name = "IMAGE_DATE")
	private Date imageDate;
	
	/** 采集地址 */
	@Column(name = "COLLECTION_ADDRESS", length = 50)
	private String collectionAddress;
	
	/** 图象序列 */
	@Column(name = "IMAGE_SERIAL", precision = 18, scale = 0)
	private Long imageSerial;
	
	/** 图象排序 */
	@Column(name = "IMAGE_SORT", precision = 18, scale = 0)
	private Long imageSort;
	
	/** 图象上传 */
	@Column(name = "IMAGE_UPLOAD", precision = 18, scale = 0)
	private Long imageUpload;
	
	/** 窗宽值 */
	@Column(name = "WINDOW_WIDTH_VALUE", precision = 18, scale = 0)
	private Long windowWidthValue;
	
	/** 窗位值 */
	@Column(name = "WINDOW_PLACE_VALUE", precision = 18, scale = 0)
	private Long windowPlaceValue;
	
	/** 其它值 */
	@Column(name = "OTHER_VALUE", length = 512)
	private String otherValue;
	
	/** 医院标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	
	/** bdb保存路径 */
	@Column(name = "SAVE_PATH", length = 100)
	private String savePath;

	/** bdb数据库关键字 */
	@Column(name = "BDB_KEY", unique = true, length = 18)
	private String bdbKey;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	@Column(name = "HT_FS_PACS_MARK", nullable = false, length = 1)
	private String htFsPacsMark;

	/** 图片base64数据*/
	@Transient
	private String imgBase64Data;
	 

	/** default constructor */
	public PatientImage() {
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

	/**
	 * @return isBackup
	 */
	public String getIsBackup() {
		return isBackup;
	}

	/**
	 * @param isBackup 要设置的 isBackup
	 */
	public void setIsBackup(String isBackup) {
		this.isBackup = isBackup;
	}

	/**
	 * @return backupFlag
	 */
	public Long getBackupFlag() {
		return backupFlag;
	}

	/**
	 * @param backupFlag 要设置的 backupFlag
	 */
	public void setBackupFlag(Long backupFlag) {
		this.backupFlag = backupFlag;
	}

	/**
	 * @return bodyTag
	 */
	public String getBodyTag() {
		return bodyTag;
	}

	/**
	 * @param bodyTag 要设置的 bodyTag
	 */
	public void setBodyTag(String bodyTag) {
		this.bodyTag = bodyTag;
	}

	/**
	 * @return bodyTagExplain
	 */
	public String getBodyTagExplain() {
		return bodyTagExplain;
	}

	/**
	 * @param bodyTagExplain 要设置的 bodyTagExplain
	 */
	public void setBodyTagExplain(String bodyTagExplain) {
		this.bodyTagExplain = bodyTagExplain;
	}

	/**
	 * @return imageClassify
	 */
	public String getImageClassify() {
		return imageClassify;
	}

	/**
	 * @param imageClassify 要设置的 imageClassify
	 */
	public void setImageClassify(String imageClassify) {
		this.imageClassify = imageClassify;
	}

	/**
	 * @return imageExplain
	 */
	public String getImageExplain() {
		return imageExplain;
	}

	/**
	 * @param imageExplain 要设置的 imageExplain
	 */
	public void setImageExplain(String imageExplain) {
		this.imageExplain = imageExplain;
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
	 * @return isPrinted
	 */
	public Long getIsPrinted() {
		return isPrinted;
	}

	/**
	 * @param isPrinted 要设置的 isPrinted
	 */
	public void setIsPrinted(Long isPrinted) {
		this.isPrinted = isPrinted;
	}

	/**
	 * @return printSort
	 */
	public Long getPrintSort() {
		return printSort;
	}

	/**
	 * @param printSort 要设置的 printSort
	 */
	public void setPrintSort(Long printSort) {
		this.printSort = printSort;
	}

	/**
	 * @return imageNumber
	 */
	public String getImageNumber() {
		return imageNumber;
	}

	/**
	 * @param imageNumber 要设置的 imageNumber
	 */
	public void setImageNumber(String imageNumber) {
		this.imageNumber = imageNumber;
	}

	/**
	 * @return serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber 要设置的 serialNumber
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return imageDate
	 */
	public Date getImageDate() {
		return imageDate;
	}

	/**
	 * @param imageDate 要设置的 imageDate
	 */
	public void setImageDate(Date imageDate) {
		this.imageDate = imageDate;
	}

	/**
	 * @return collectionAddress
	 */
	public String getCollectionAddress() {
		return collectionAddress;
	}

	/**
	 * @param collectionAddress 要设置的 collectionAddress
	 */
	public void setCollectionAddress(String collectionAddress) {
		this.collectionAddress = collectionAddress;
	}

	/**
	 * @return imageSerial
	 */
	public Long getImageSerial() {
		return imageSerial;
	}

	/**
	 * @param imageSerial 要设置的 imageSerial
	 */
	public void setImageSerial(Long imageSerial) {
		this.imageSerial = imageSerial;
	}

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
	 * @return imageUpload
	 */
	public Long getImageUpload() {
		return imageUpload;
	}

	/**
	 * @param imageUpload 要设置的 imageUpload
	 */
	public void setImageUpload(Long imageUpload) {
		this.imageUpload = imageUpload;
	}

	/**
	 * @return windowWidthValue
	 */
	public Long getWindowWidthValue() {
		return windowWidthValue;
	}

	/**
	 * @param windowWidthValue 要设置的 windowWidthValue
	 */
	public void setWindowWidthValue(Long windowWidthValue) {
		this.windowWidthValue = windowWidthValue;
	}

	/**
	 * @return windowPlaceValue
	 */
	public Long getWindowPlaceValue() {
		return windowPlaceValue;
	}

	/**
	 * @param windowPlaceValue 要设置的 windowPlaceValue
	 */
	public void setWindowPlaceValue(Long windowPlaceValue) {
		this.windowPlaceValue = windowPlaceValue;
	}

	/**
	 * @return otherValue
	 */
	public String getOtherValue() {
		return otherValue;
	}

	/**
	 * @param otherValue 要设置的 otherValue
	 */
	public void setOtherValue(String otherValue) {
		this.otherValue = otherValue;
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
	 * @return imgBase64Data
	 */
	public String getImgBase64Data() {
		return imgBase64Data;
	}

	/**
	 * @param imgBase64Data 要设置的 imgBase64Data
	 */
	public void setImgBase64Data(String imgBase64Data) {
		this.imgBase64Data = imgBase64Data;
	}

}