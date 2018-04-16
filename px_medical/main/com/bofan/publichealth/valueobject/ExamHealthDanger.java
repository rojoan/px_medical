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
 * ExamHealthDanger entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_HEALTH_DANGER", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "EXAM_HEALTH_DANGER_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".EXAM_HEALTH_DANGER_ID", allocationSize = 1)
public class ExamHealthDanger implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 752522167097252669L;
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAM_HEALTH_DANGER_ID")
    @Column(name = "EXAM_HEALTH_DANGER_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long examHealthDangerId;

    @Column(name = "HEALTH_DANGER_TYPE_ID", nullable = false, precision = 18, scale = 0)
    private Long healthDangerTypeId;
    
    @Column(name = "EXAM_PERSON_ID", nullable = false, precision = 18, scale = 0)
    private Long examPersonId;
    
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;

	// Constructors

	/** default constructor */
	public ExamHealthDanger() {
	}

    /**
     * @return the examHealthDangerId
     */
    public Long getExamHealthDangerId() {
        return examHealthDangerId;
    }

    /**
     * @param examHealthDangerId the examHealthDangerId to set
     */
    public void setExamHealthDangerId(Long examHealthDangerId) {
        this.examHealthDangerId = examHealthDangerId;
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