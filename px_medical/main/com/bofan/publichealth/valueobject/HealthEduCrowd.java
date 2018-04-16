package com.bofan.publichealth.valueobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 健康教育--资料发放/接受教育对象
 * @author xlf
 */
@Entity
@Table(name = "HEALTH_EDU_CROWD", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "EDU_CROWD_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".HEALTH_EDU_CROWD_ID", allocationSize = 1)
public class HealthEduCrowd implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1655357154245841636L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDU_CROWD_ID")
	@Column(name = "EDU_CROWD_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long eduCrowdId;
    
    @Column(name = "HEALTH_EDUCATION_ID", nullable = false, precision = 18, scale = 0)
    private Long healthEducationId;

	@Column(name = "CROWD_TYPE", nullable = false, length = 1)
	private String crowdType;

	/** default constructor */
	public HealthEduCrowd() {
	}

    /**
     * @return the eduCrowdId
     */
    public Long getEduCrowdId() {
        return eduCrowdId;
    }

    /**
     * @param eduCrowdId the eduCrowdId to set
     */
    public void setEduCrowdId(Long eduCrowdId) {
        this.eduCrowdId = eduCrowdId;
    }

    /**
     * @return the healthEducationId
     */
    public Long getHealthEducationId() {
        return healthEducationId;
    }

    /**
     * @param healthEducationId the healthEducationId to set
     */
    public void setHealthEducationId(Long healthEducationId) {
        this.healthEducationId = healthEducationId;
    }

    /**
     * @return the crowdType
     */
    public String getCrowdType() {
        return crowdType;
    }

    /**
     * @param crowdType the crowdType to set
     */
    public void setCrowdType(String crowdType) {
        this.crowdType = crowdType;
    }

}