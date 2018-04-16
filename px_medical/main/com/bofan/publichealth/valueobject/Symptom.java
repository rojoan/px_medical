package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * Symptom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYMPTOM", schema = SchemaConsts.PUBLIC_HEALTH)
public class Symptom implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 3543797773241809586L;
    // Fields

    @Id
    @Column(name = "SYMPTOM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long symptomId;
    
    @Column(name = "SYMPTOM_CODE", unique = true, nullable = false, length = 20)
	private String symptomCode;
    
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	// Constructors

	/** default constructor */
	public Symptom() {
	}
	// Property accessors

    /**
     * @return the symptomId
     */
    public Long getSymptomId() {
        return symptomId;
    }

    /**
     * @param symptomId the symptomId to set
     */
    public void setSymptomId(Long symptomId) {
        this.symptomId = symptomId;
    }

    /**
     * @return the symptomCode
     */
    public String getSymptomCode() {
        return symptomCode;
    }

    /**
     * @param symptomCode the symptomCode to set
     */
    public void setSymptomCode(String symptomCode) {
        this.symptomCode = symptomCode;
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