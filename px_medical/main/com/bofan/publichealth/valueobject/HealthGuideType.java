package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.bofan.utils.SchemaConsts;

/**
 * HealthGuideType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "HEALTH_GUIDE_TYPE", schema = SchemaConsts.PUBLIC_HEALTH, uniqueConstraints = @UniqueConstraint(columnNames = "HEALTH_GUIDE_TYPE"))
public class HealthGuideType implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 2782380346375758052L;
    // Fields

    @Id
    @Column(name = "HEALTH_GUIDE_TYPE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long healthGuideTypeId;
    
    @Column(name = "HEALTH_GUIDE_TYPE", unique = true, nullable = false, length = 40)
	private String healthGuideType;
    
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;
	
	// Constructors

	/** default constructor */
	public HealthGuideType() {
	}

	// Property accessors
    /**
     * @return the healthGuideTypeId
     */
    public Long getHealthGuideTypeId() {
        return healthGuideTypeId;
    }

    /**
     * @param healthGuideTypeId the healthGuideTypeId to set
     */
    public void setHealthGuideTypeId(Long healthGuideTypeId) {
        this.healthGuideTypeId = healthGuideTypeId;
    }

    /**
     * @return the healthGuideType
     */
    public String getHealthGuideType() {
        return healthGuideType;
    }

    /**
     * @param healthGuideType the healthGuideType to set
     */
    public void setHealthGuideType(String healthGuideType) {
        this.healthGuideType = healthGuideType;
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