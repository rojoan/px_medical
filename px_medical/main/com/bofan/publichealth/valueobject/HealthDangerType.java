package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.bofan.utils.SchemaConsts;

/**
 * HealthDangerType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "HEALTH_DANGER_TYPE", schema = SchemaConsts.PUBLIC_HEALTH, uniqueConstraints = @UniqueConstraint(columnNames = "HEALTH_DANGER_TYPE"))
public class HealthDangerType implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -1947552355181775971L;
    // Fields

    @Id
    @Column(name = "HEALTH_DANGER_TYPE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long healthDangerTypeId;
    
    @Column(name = "HEALTH_DANGER_TYPE", unique = true, nullable = false, length = 40)
	private String healthDangerType;
    
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	// Constructors

	/** default constructor */
	public HealthDangerType() {
	}

    /**
     * @return the healthDangerTypeId
     */
    public Long getHealthDangerTypeId() {
        return healthDangerTypeId;
    }

    /**
     * @param healthDangerTypeId the healthDangerTypeId to set
     */
    public void setHealthDangerTypeId(Long healthDangerTypeId) {
        this.healthDangerTypeId = healthDangerTypeId;
    }

    /**
     * @return the healthDangerType
     */
    public String getHealthDangerType() {
        return healthDangerType;
    }

    /**
     * @param healthDangerType the healthDangerType to set
     */
    public void setHealthDangerType(String healthDangerType) {
        this.healthDangerType = healthDangerType;
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