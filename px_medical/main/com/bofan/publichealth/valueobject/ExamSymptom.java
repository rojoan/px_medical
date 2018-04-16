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
 * ExamSymptom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_SYMPTOM", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "EXAM_SYMPTOM_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".EXAM_SYMPTOM_ID", allocationSize = 1)
public class ExamSymptom implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 3543019681303084451L;
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAM_SYMPTOM_ID")
    @Column(name = "EXAM_SYMPTOM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long examSymptomId;
    
    @Column(name = "EXAM_PERSON_ID", precision = 18, scale = 0)
    private Long examPersonId;
    
    @Column(name = "SYMPTOM_ID", unique = true, precision = 18, scale = 0)
    private Long symptomId;
    
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;

	// Constructors

	/** default constructor */
	public ExamSymptom() {
	}

    /**
     * @return the examSymptomId
     */
    public Long getExamSymptomId() {
        return examSymptomId;
    }

    /**
     * @param examSymptomId the examSymptomId to set
     */
    public void setExamSymptomId(Long examSymptomId) {
        this.examSymptomId = examSymptomId;
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
     * @return the symptomId
     */
    public Long getSymptomId() {
        return symptomId;
    }

    /**
     * @param symptomId the symptomId to set
     */
    public void setSymptomId(Long symptomId) {
        this.symptomId = symptomId;
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

	// Property accessors
	

}