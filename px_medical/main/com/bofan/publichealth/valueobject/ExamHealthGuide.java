package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * ExamHealthGuide entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_HEALTH_GUIDE", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "EXAM_HEALTH_DUIDE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".EXAM_HEALTH_GUIDE_ID", allocationSize = 1)
public class ExamHealthGuide implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -2738079060470556603L;
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAM_HEALTH_DUIDE_ID")
    @Column(name = "EXAM_HEALTH_DUIDE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long examHealthDuideId;
    
    @Column(name = "HEALTH_GUIDE_TYPE_ID", nullable = false, precision = 18, scale = 0)
	private Long healthGuideTypeId;
    
    @Column(name = "EXAM_PERSON_ID", nullable = false, precision = 18, scale = 0)
    private Long examPersonId;
	
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;

	// Constructors

	/** default constructor */
	public ExamHealthGuide() {
	}

    /**
     * @return the examHealthDuideId
     */
    public Long getExamHealthDuideId() {
        return examHealthDuideId;
    }

    /**
     * @param examHealthDuideId the examHealthDuideId to set
     */
    public void setExamHealthDuideId(Long examHealthDuideId) {
        this.examHealthDuideId = examHealthDuideId;
    }

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


}