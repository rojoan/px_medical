package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * Disease entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DISEASE", schema = SchemaConsts.PUBLIC_HEALTH)
public class Disease implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -9100513439425641437L;
    // Fields

    @Id
    @Column(name = "DISEASE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long diseaseId;
    
    @Column(name = "DISEASE_TYPE", nullable = false, length = 1)
	private String diseaseType;
    
    @Column(name = "DISEASE_NAME", unique = true, nullable = false, length = 40)
	private String diseaseName;
    
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	// Constructors

	/** default constructor */
	public Disease() {
	}

    /**
     * @return the diseaseId
     */
    public Long getDiseaseId() {
        return diseaseId;
    }

    /**
     * @param diseaseId the diseaseId to set
     */
    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * @return the diseaseType
     */
    public String getDiseaseType() {
        return diseaseType;
    }

    /**
     * @param diseaseType the diseaseType to set
     */
    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    /**
     * @return the diseaseName
     */
    public String getDiseaseName() {
        return diseaseName;
    }

    /**
     * @param diseaseName the diseaseName to set
     */
    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
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

	// Property accessors
	
}