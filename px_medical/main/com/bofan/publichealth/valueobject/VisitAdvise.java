package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * VisitAdvise entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VISIT_ADVISE", schema = SchemaConsts.PUBLIC_HEALTH)
public class VisitAdvise implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -8341007120521305773L;
    // Fields

    @Id
    @Column(name = "VISIT_ADIVSE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long visitAdivseId;
    
    @Column(name = "VISIT_ADVISE_TYPE", nullable = false, length = 1)
	private String visitAdviseType;
    
    @Column(name = "VISIT_ADVISE_NAME", nullable = false, length = 20)
	private String visitAdviseName;
    
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;
	
	// Constructors

	/** default constructor */
	public VisitAdvise() {
	}

    /**
     * @return the visitAdivseId
     */
    public Long getVisitAdivseId() {
        return visitAdivseId;
    }

    /**
     * @param visitAdivseId the visitAdivseId to set
     */
    public void setVisitAdivseId(Long visitAdivseId) {
        this.visitAdivseId = visitAdivseId;
    }

    /**
     * @return the visitAdviseType
     */
    public String getVisitAdviseType() {
        return visitAdviseType;
    }

    /**
     * @param visitAdviseType the visitAdviseType to set
     */
    public void setVisitAdviseType(String visitAdviseType) {
        this.visitAdviseType = visitAdviseType;
    }

    /**
     * @return the visitAdviseName
     */
    public String getVisitAdviseName() {
        return visitAdviseName;
    }

    /**
     * @param visitAdviseName the visitAdviseName to set
     */
    public void setVisitAdviseName(String visitAdviseName) {
        this.visitAdviseName = visitAdviseName;
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