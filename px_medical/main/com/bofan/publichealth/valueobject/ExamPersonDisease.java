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
 * ExamPersonDisease entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_PERSON_DISEASE", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PERSON_DISEASE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".EXAM_PERSON_DISEASE_ID", allocationSize = 1)
public class ExamPersonDisease implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 400890466729699440L;
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_DISEASE_ID")
    @Column(name = "PERSON_DISEASE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long personDiseaseId;
    
    @Column(name = "EXAM_PERSON_ID", nullable = false, precision = 18, scale = 0)
    private Long examPersonId;
    
    @Column(name = "DISEASE_ID", nullable = false, precision = 18, scale = 0)
    private Long diseaseId;
    
    
    @Column(name = "DISEASE_TYPE", nullable = false, length = 1)
    private String diseaseType;
    
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
    private Long personDetailId;


	// Constructors

	/** default constructor */
	public ExamPersonDisease() {
	}


    /**
     * @return the personDiseaseId
     */
    public Long getPersonDiseaseId() {
        return personDiseaseId;
    }


    /**
     * @param personDiseaseId the personDiseaseId to set
     */
    public void setPersonDiseaseId(Long personDiseaseId) {
        this.personDiseaseId = personDiseaseId;
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
     * @return the diseaseId
     */
    public Long getDiseaseId() {
        return diseaseId;
    }


    /**
     * @param diseaseId the diseaseId to set
     */
    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }


    /**
     * @return the diseaseType
     */
    public String getDiseaseType() {
        return diseaseType;
    }


    /**
     * @param diseaseType the diseaseType to set
     */
    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
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