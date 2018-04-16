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
 * @Description: 健康教育--发放印刷/播放位置
 * @author xlf
 */
@Entity
@Table(name = "HEALTH_EDU_AREA", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "EDU_AREA_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".HEALTH_EDU_AREA_ID", allocationSize = 1)
public class HealthEduArea implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1655357154245841636L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDU_AREA_ID")
	@Column(name = "EDU_AREA_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long eduAreaId;
    
    @Column(name = "HEALTH_EDUCATION_ID", nullable = false, precision = 18, scale = 0)
    private Long healthEducationId;
    
    /** 1=发放资料位置  2=播放音像位置 */
    @Column(name = "EDU_AREA_FLAG", nullable = false, length = 1)
    private String eduAreaFlag;
    
    /** 放置位置 */
    @Column(name = "PUT_AREA", length = 1)
    private String putArea;

	/** default constructor */
	public HealthEduArea() {
	}

    /**
     * @return the eduAreaId
     */
    public Long getEduAreaId() {
        return eduAreaId;
    }

    /**
     * @param eduAreaId the eduAreaId to set
     */
    public void setEduAreaId(Long eduAreaId) {
        this.eduAreaId = eduAreaId;
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
     * @return the eduAreaFlag
     */
    public String getEduAreaFlag() {
        return eduAreaFlag;
    }

    /**
     * @param eduAreaFlag the eduAreaFlag to set
     */
    public void setEduAreaFlag(String eduAreaFlag) {
        this.eduAreaFlag = eduAreaFlag;
    }

    /**
     * @return the putArea
     */
    public String getPutArea() {
        return putArea;
    }

    /**
     * @param putArea the putArea to set
     */
    public void setPutArea(String putArea) {
        this.putArea = putArea;
    }

}