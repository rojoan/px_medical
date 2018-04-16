package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * VisitSicken entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VISIT_SICKEN", schema = SchemaConsts.PUBLIC_HEALTH)
public class VisitSicken implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 540896008970878960L;
    // Fields

    @Id
    @Column(name = "VISIT_SICKEN_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long visitSickenId;
    
    @Column(name = "VISIT_SICKEN_NAME", unique = true, nullable = false, length = 20)
	private String visitSickenName;
    
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	// Constructors

	/** default constructor */
	public VisitSicken() {
	}

    /**
     * @return the visitSickenId
     */
    public Long getVisitSickenId() {
        return visitSickenId;
    }

    /**
     * @param visitSickenId the visitSickenId to set
     */
    public void setVisitSickenId(Long visitSickenId) {
        this.visitSickenId = visitSickenId;
    }

    /**
     * @return the visitSickenName
     */
    public String getVisitSickenName() {
        return visitSickenName;
    }

    /**
     * @param visitSickenName the visitSickenName to set
     */
    public void setVisitSickenName(String visitSickenName) {
        this.visitSickenName = visitSickenName;
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