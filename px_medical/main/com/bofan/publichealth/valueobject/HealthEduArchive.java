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
 * @Description: 健康教育活动存档类型
 * @author xlf
 */
@Entity
@Table(name = "HEALTH_EDU_ARCHIVE", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "EDU_ARCHIVE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".HEALTH_EDU_ARCHIVE_ID", allocationSize = 1)
public class HealthEduArchive implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1655357154245841636L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDU_ARCHIVE_ID")
	@Column(name = "EDU_ARCHIVE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long eduArchiveId;
    
    @Column(name = "HEALTH_EDUCATION_ID", nullable = false, precision = 18, scale = 0)
    private Long healthEducationId;

	@Column(name = "EDU_ARCHIVE_TYPE", nullable = false, length = 2)
	private String eduArchiveType;

	/** default constructor */
	public HealthEduArchive() {
	}

    /**
     * @return the eduArchiveId
     */
    public Long getEduArchiveId() {
        return eduArchiveId;
    }

    /**
     * @param eduArchiveId the eduArchiveId to set
     */
    public void setEduArchiveId(Long eduArchiveId) {
        this.eduArchiveId = eduArchiveId;
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
     * @return the eduArchiveType
     */
    public String getEduArchiveType() {
        return eduArchiveType;
    }

    /**
     * @param eduArchiveType the eduArchiveType to set
     */
    public void setEduArchiveType(String eduArchiveType) {
        this.eduArchiveType = eduArchiveType;
    }

}