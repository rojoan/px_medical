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
 * ExamPersonalDrug entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_PERSONAL_DRUG", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PERSON_DRUG_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".EXAM_PERSON_DRUG_ID", allocationSize = 1)
public class ExamPersonalDrug implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 3422566157905141178L;
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_DRUG_ID")
    @Column(name = "PERSON_DRUG_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long personDrugId;
	
	@Column(name = "EXAM_PERSON_ID", nullable = false, precision = 18, scale = 0)
    private Long examPersonId;
    
    @Column(name = "DISEASE_DRUP_ID", nullable = false, precision = 18, scale = 0)
    private Long diseaseDrugId;
    
    @Column(name = "DISEASE_DRUG_NAME", length = 20)
    private String diseaseDrugName;
    
    @Column(name = "DRUG_USAGE", length = 10)
    private String drugUsage;
    
    @Column(name = "DRUG_QUANTITY", length = 10)
    private String drugQuantity;

    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
    
    @Column(name = "EXAM_TIME", nullable = false)
	private Date examTime;
    
    @Column(name = "EAT_DRUG_TIME", length = 20)
	private String eatDrugTime;
    
    @Column(name = "EAT_DRUG_BELONG", length = 80)
	private String eatDrugBelong;

	// Constructors

	/** default constructor */
	public ExamPersonalDrug() {
	}

    /**
     * @return the personDrugId
     */
    public Long getPersonDrugId() {
        return personDrugId;
    }

    /**
     * @param personDrugId the personDrugId to set
     */
    public void setPersonDrugId(Long personDrugId) {
        this.personDrugId = personDrugId;
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
     * @return the diseaseDrugId
     */
    public Long getDiseaseDrugId() {
        return diseaseDrugId;
    }

    /**
     * @param diseaseDrugId the diseaseDrugId to set
     */
    public void setDiseaseDrugId(Long diseaseDrugId) {
        this.diseaseDrugId = diseaseDrugId;
    }

    /**
     * @return the diseaseDrugName
     */
    public String getDiseaseDrugName() {
        return diseaseDrugName;
    }

    /**
     * @param diseaseDrugName the diseaseDrugName to set
     */
    public void setDiseaseDrugName(String diseaseDrugName) {
        this.diseaseDrugName = diseaseDrugName;
    }

    /**
     * @return the drugUsage
     */
    public String getDrugUsage() {
        return drugUsage;
    }

    /**
     * @param drugUsage the drugUsage to set
     */
    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage;
    }

    /**
     * @return the drugQuantity
     */
    public String getDrugQuantity() {
        return drugQuantity;
    }

    /**
     * @param drugQuantity the drugQuantity to set
     */
    public void setDrugQuantity(String drugQuantity) {
        this.drugQuantity = drugQuantity;
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
     * @return the eatDrugTime
     */
    public String getEatDrugTime() {
        return eatDrugTime;
    }

    /**
     * @param eatDrugTime the eatDrugTime to set
     */
    public void setEatDrugTime(String eatDrugTime) {
        this.eatDrugTime = eatDrugTime;
    }

    /**
     * @return the eatDrugBelong
     */
    public String getEatDrugBelong() {
        return eatDrugBelong;
    }

    /**
     * @param eatDrugBelong the eatDrugBelong to set
     */
    public void setEatDrugBelong(String eatDrugBelong) {
        this.eatDrugBelong = eatDrugBelong;
    }


}