package com.bofan.his.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bofan.utils.SchemaConsts;
import com.bofan.utils.Tools;

/**
 * @Description: 患者-附件文件表
 * @author lqw
 */
@Entity
@Table(name = "PATIENT_AFFIX_ITEM", schema = SchemaConsts.REMOTE_CONSULT)
@SequenceGenerator(name = "PATIENT_AFFIX_ITEM_ID", sequenceName = SchemaConsts.REMOTE_CONSULT + ".PATIENT_AFFIX_ITEM_ID", allocationSize = 1)
public class PatientAffixItem {

	// Fields

	/** 附件文件ID，自动增长ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT_AFFIX_ITEM_ID")
	@Column(name = "AFFIX_ITEM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long affixItemId;
	
	/** 附件标识 */
	@Column(name = "AFFIX_ID", nullable = false, length = 20)
	private String affixId;
	
	/** 附件保存名 */
	@Column(name = "SAVE_NAME", nullable = false, length = 250)
	private String saveName;
	
	/** 附件大小 */
	@Column(name = "FILE_SIZE", nullable = false, precision = 18, scale = 0)
	private Long fileSize;
	
	/** 附件原名 */
	@Column(name = "TRUE_NAME", nullable = false, length = 250)
	private String trueName;
	
	/** 附件保存bdb路径 */
	@Column(name = "SAVE_PATH", nullable = false, length = 100)
	private String savePath;
	
	/** bdb数据库关键字 医院（医疗机构）标识+ 图象文件名 */
	@Column(name = "BDB_KEY", nullable = false, length = 18)
	private String bdbKey;
	
	/** 是否为图文 0：  为非图文 1：  为图文 */
	@Column(name = "IS_IMAGE", nullable = false, length = 1)
	private String isImage;
	
	/** 是否有PDF转换文件 1:有PDF转换文件 此字段 提供word文件是否有PDF文件的转换格式的标记 */
	@Column(name = "PDF_FLAG", nullable = false, length = 1)
	private String pdfFlag;

	@Transient
	private String formatSize;
	
	/**
	 * @return affixItemId
	 */
	public Long getAffixItemId() {
		return affixItemId;
	}

	/**
	 * @param affixItemId 要设置的 affixItemId
	 */
	public void setAffixItemId(Long affixItemId) {
		this.affixItemId = affixItemId;
	}

	/**
	 * @return affixId
	 */
	public String getAffixId() {
		return affixId;
	}

	/**
	 * @param affixId 要设置的 affixId
	 */
	public void setAffixId(String affixId) {
		this.affixId = affixId;
	}

	/**
	 * @return saveName
	 */
	public String getSaveName() {
		return saveName;
	}

	/**
	 * @param saveName 要设置的 saveName
	 */
	public void setSaveName(String saveName) {
		this.saveName = saveName;
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

	/**
	 * @return trueName
	 */
	public String getTrueName() {
		return trueName;
	}

	/**
	 * @param trueName 要设置的 trueName
	 */
	public void setTrueName(String trueName) {
		this.trueName = trueName;
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
	 * @return isImage
	 */
	public String getIsImage() {
		return isImage;
	}

	/**
	 * @param isImage 要设置的 isImage
	 */
	public void setIsImage(String isImage) {
		this.isImage = isImage;
	}

	/**
	 * @return pdfFlag
	 */
	public String getPdfFlag() {
		return pdfFlag;
	}

	/**
	 * @param pdfFlag 要设置的 pdfFlag
	 */
	public void setPdfFlag(String pdfFlag) {
		this.pdfFlag = pdfFlag;
	}

	/**
	 * @return formatSize
	 */
	public String getFormatSize() {
		if (null != this.fileSize) {
			formatSize = Tools.formatSize(this.fileSize);
		}
		return formatSize;
	}
	
}