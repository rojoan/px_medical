package com.bofan.publichealth.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * ExamHealthAssess entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_HEALTH_ASSESS", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "HEALTH_ASSESS_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".EXAM_HEALTH_ASSESS_ID", allocationSize = 1)
public class ExamHealthAssess implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -7892858898917420293L;
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HEALTH_ASSESS_ID")
    @Column(name = "HEALTH_ASSESS_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long healthAssessId;
    
    @Column(name = "EXAM_TIME")
	private Date examTime;
    
    @Column(name = "EXAM_PERSON_ID", nullable = false, precision = 18, scale = 0)
	private Long examPersonId;
    
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
    
    @Column(name = "HEALTH_ABNORMAL_CONTENT", nullable = false, length = 200)
	private String healthAbnormalContent;

	// Constructors

	/** default constructor */
	public ExamHealthAssess() {
	}

    /**
     * @return the healthAssessId
     */
    public Long getHealthAssessId() {
        return healthAssessId;
    }

    /**
     * @param healthAssessId the healthAssessId to set
     */
    public void setHealthAssessId(Long healthAssessId) {
        this.healthAssessId = healthAssessId;
    }

    /**
     * @return the examTime
     */
    public Date getExamTime() {
        return examTime;
    }

    /**
     * @param examTime the examTime to set
     */
    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    /**
     * @return the examPersonId
     */
    public Long getExamPersonId() {
        return examPersonId;
    }

    /**
     * @param examPersonId the examPersonId to set
     */
    public void setExamPersonId(Long examPersonId) {
        this.examPersonId = examPersonId;
    }

    /**
     * @return the personDetailId
     */
    public Long getPersonDetailId() {
        return personDetailId;
    }

    /**
     * @param personDetailId the personDetailId to set
     */
    public void setPersonDetailId(Long personDetailId) {
        this.personDetailId = personDetailId;
    }

    /**
     * @return the healthAbnormalContent
     */
    public String getHealthAbnormalContent() {
        return healthAbnormalContent;
    }

    /**
     * @param healthAbnormalContent the healthAbnormalContent to set
     */
    public void setHealthAbnormalContent(String healthAbnormalContent) {
        this.healthAbnormalContent = healthAbnormalContent;
    }



}