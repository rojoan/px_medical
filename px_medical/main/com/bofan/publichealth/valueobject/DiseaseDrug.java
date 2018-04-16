package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * DiseaseDrug entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DISEASE_DRUG", schema = SchemaConsts.PUBLIC_HEALTH)
public class DiseaseDrug implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1686539583510777246L;
    // Fields

    @Id
    @Column(name = "DISEASE_DRUG_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long diseaseDrugId;
    
    @Column(name = "DISEASE_DRUG_NAME", nullable = false, length = 40)
	private String diseaseDrugName;
    
    @Column(name = "DISEASE_DRUG_TYPE", nullable = false, length = 2)
	private String diseaseDrugType;
    
    @Column(name = "DRUG_USAGE", length = 10)
	private String drugUsage;
    
    @Column(name = "DRUG_QUANTITY", length = 10)
	private String drugQuantity;
    
    @Column(name = "DRUG_UNIT", length = 10)
	private String drugUnit;
    
    @Column(name = "DRUG_FREQ", length = 10)
	private String drugFreq;
    
    @Column(name = "REMARK", length = 20)
	private String remark;
    
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public DiseaseDrug() {
	}

    /**
     * @return the diseaseDrugId
     */
    public Long getDiseaseDrugId() {
        return diseaseDrugId;
    }

    /**
     * @param diseaseDrugId the diseaseDrugId to set
     */
    public void setDiseaseDrugId(Long diseaseDrugId) {
        this.diseaseDrugId = diseaseDrugId;
    }

    /**
     * @return the diseaseDrugName
     */
    public String getDiseaseDrugName() {
        return diseaseDrugName;
    }

    /**
     * @param diseaseDrugName the diseaseDrugName to set
     */
    public void setDiseaseDrugName(String diseaseDrugName) {
        this.diseaseDrugName = diseaseDrugName;
    }

    /**
     * @return the diseaseDrugType
     */
    public String getDiseaseDrugType() {
        return diseaseDrugType;
    }

    /**
     * @param diseaseDrugType the diseaseDrugType to set
     */
    public void setDiseaseDrugType(String diseaseDrugType) {
        this.diseaseDrugType = diseaseDrugType;
    }

    /**
     * @return the drugUsage
     */
    public String getDrugUsage() {
        return drugUsage;
    }

    /**
     * @param drugUsage the drugUsage to set
     */
    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage;
    }

    /**
     * @return the drugQuantity
     */
    public String getDrugQuantity() {
        return drugQuantity;
    }

    /**
     * @param drugQuantity the drugQuantity to set
     */
    public void setDrugQuantity(String drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    /**
     * @return the drugUnit
     */
    public String getDrugUnit() {
        return drugUnit;
    }

    /**
     * @param drugUnit the drugUnit to set
     */
    public void setDrugUnit(String drugUnit) {
        this.drugUnit = drugUnit;
    }

    /**
     * @return the drugFreq
     */
    public String getDrugFreq() {
        return drugFreq;
    }

    /**
     * @param drugFreq the drugFreq to set
     */
    public void setDrugFreq(String drugFreq) {
        this.drugFreq = drugFreq;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the validFlag
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag the validFlag to set
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }
	
}