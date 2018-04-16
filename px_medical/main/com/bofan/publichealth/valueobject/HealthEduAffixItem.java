package com.bofan.publichealth.valueobject;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 健康教育--附件文件
 * @author xlf
 */
@Entity
@Table(name = "HEALTH_EDU_AFFIX_ITEM", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "AFFIX_ITEM_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".HEALTH_EDU_AFFIX_ITEM_ID", allocationSize = 1)
public class HealthEduAffixItem implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1655357154245841636L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AFFIX_ITEM_ID")
	@Column(name = "AFFIX_ITEM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long affixItemId;
    
    /**  */
    @Column(name = "AFFIX_ID", nullable = false, length = 20)
    private String affixId;
    
    /**  */
    @Column(name = "SAVE_NAME", nullable = false, length = 250)
    private String saveName;
    
    /**  */
    @Column(name = "FILE_SIZE", nullable = false, length = 18)
    private Long fileSize;
    
    /**  */
    @Column(name = "TRUE_NAME", nullable = false, length = 250)
    private String trueName;
    
    /**  */
    @Column(name = "SAVE_PATH", nullable = false, length = 250)
    private String savePath;
    
    /**  */
    @Column(name = "IS_IMAGE", length = 1)
    private String isImage;
    
    /**  */
    @Column(name = "PDF_FLAG", length = 1)
    private String pdfFlag;

	/** default constructor */
	public HealthEduAffixItem() {
	}

	/**
	 * 计算文件的大小（单位为KB）
	 * @return
	 */
	public double calculateSize() {
	    if (null == this.fileSize || this.fileSize <= 0) {
	        return 0;
	    }
	    
	    Double value  = (double) this.fileSize;
	    BigDecimal bg = new BigDecimal(value/1024);
	    return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
    /**
     * @return the affixItemId
     */
    public Long getAffixItemId() {
        return affixItemId;
    }

    /**
     * @param affixItemId the affixItemId to set
     */
    public void setAffixItemId(Long affixItemId) {
        this.affixItemId = affixItemId;
    }

    /**
     * @return the affixId
     */
    public String getAffixId() {
        return affixId;
    }

    /**
     * @param affixId the affixId to set
     */
    public void setAffixId(String affixId) {
        this.affixId = affixId;
    }

    /**
     * @return the saveName
     */
    public String getSaveName() {
        return saveName;
    }

    /**
     * @param saveName the saveName to set
     */
    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    /**
     * @return the fileSize
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize the fileSize to set
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return the trueName
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * @param trueName the trueName to set
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    /**
     * @return the savePath
     */
    public String getSavePath() {
        return savePath;
    }

    /**
     * @param savePath the savePath to set
     */
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    /**
     * @return the isImage
     */
    public String getIsImage() {
        return isImage;
    }

    /**
     * @param isImage the isImage to set
     */
    public void setIsImage(String isImage) {
        this.isImage = isImage;
    }

    /**
     * @return the pdfFlag
     */
    public String getPdfFlag() {
        return pdfFlag;
    }

    /**
     * @param pdfFlag the pdfFlag to set
     */
    public void setPdfFlag(String pdfFlag) {
        this.pdfFlag = pdfFlag;
    }

}