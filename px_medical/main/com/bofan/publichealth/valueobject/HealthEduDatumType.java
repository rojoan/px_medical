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
 * @Description: 健康教育--资料种类
 * @author xlf
 */
@Entity
@Table(name = "HEALTH_EDU_DATUM_TYPE", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "EDU_DATUM_TYPE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".HEALTH_EDU_DATUM_TYPE_ID", allocationSize = 1)
public class HealthEduDatumType implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1655357154245841636L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDU_DATUM_TYPE_ID")
	@Column(name = "EDU_DATUM_TYPE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long eduDatumTypeId;
    
    @Column(name = "HEALTH_EDUCATION_ID", nullable = false, precision = 18, scale = 0)
    private Long healthEducationId;

	@Column(name = "DATUM_TYPE", nullable = false, length = 1)
	private String datumType;

	/** default constructor */
	public HealthEduDatumType() {
	}

    /**
     * @return the eduDatumTypeId
     */
    public Long getEduDatumTypeId() {
        return eduDatumTypeId;
    }

    /**
     * @param eduDatumTypeId the eduDatumTypeId to set
     */
    public void setEduDatumTypeId(Long eduDatumTypeId) {
        this.eduDatumTypeId = eduDatumTypeId;
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
     * @return the datumType
     */
    public String getDatumType() {
        return datumType;
    }

    /**
     * @param datumType the datumType to set
     */
    public void setDatumType(String datumType) {
        this.datumType = datumType;
    }

}