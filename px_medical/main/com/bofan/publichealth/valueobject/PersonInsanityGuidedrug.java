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
 * 重性精神病--用药指导表
 * 
 */
@Entity
@Table(name="PERSON_INSANITY_GUIDEDRUG", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PERSON_INSANITY_GUIDEDRUG_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_INSANITY_GUIDEDRUG_ID", allocationSize = 1)
public class PersonInsanityGuidedrug implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_INSANITY_GUIDEDRUG_ID")
	@Column(name="PERSON_INSANITY_GUIDEDRUG_ID", unique=true, nullable=false, precision=18)
	private Long personInsanityGuidedrugId;

	@Column(name="CREATOR_ID", nullable=false, precision=18)
	private Long creatorId;

	@Column(name="DISEASE_DRUG_ID", nullable=false, precision=18)
	private Long diseaseDrugId;

	@Column(name="DISEASE_DRUG_NAME", nullable=false, length=40)
	private String diseaseDrugName;

	@Column(name="DISEASE_DRUG_TYPE", nullable=false, length=2)
	private String diseaseDrugType;

	@Column(name="DRUG_FREQ", length=10)
	private String drugFreq;

	@Column(name="DRUG_QUANTITY", length=10)
	private String drugQuantity;

	@Column(name="DRUG_UNIT", length=10)
	private String drugUnit;

	@Column(name="DRUG_USAGE", length=10)
	private String drugUsage;

	@Column(name="HOSPITAL_ID", nullable=false, precision=18)
	private Long hospitalId;

	@Column(name="PERSON_DETAIL_ID", nullable=false, precision=18)
	private Long personDetailId;

	@Column(name="PERSON_INSANITY_ID", nullable=false, precision=18)
	private Long personInsanityId;
	
	@Column(name="PERSON_INSANITY_VISIT_ID", precision=18)
    private Long personInsanityVisitId;
	
	@Column(name="RECORD_FLAG", nullable=false, length=1)
    private String recordFlag;

	public PersonInsanityGuidedrug() {
	}

    /**
     * @return the personInsanityGuidedrugId
     */
    public Long getPersonInsanityGuidedrugId() {
        return personInsanityGuidedrugId;
    }

    /**
     * @param personInsanityGuidedrugId the personInsanityGuidedrugId to set
     */
    public void setPersonInsanityGuidedrugId(Long personInsanityGuidedrugId) {
        this.personInsanityGuidedrugId = personInsanityGuidedrugId;
    }

    /**
     * @return the creatorId
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId the creatorId to set
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
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
     * @return the diseaseDrugType
     */
    public String getDiseaseDrugType() {
        return diseaseDrugType;
    }

    /**
     * @param diseaseDrugType the diseaseDrugType to set
     */
    public void setDiseaseDrugType(String diseaseDrugType) {
        this.diseaseDrugType = diseaseDrugType;
    }

    /**
     * @return the drugFreq
     */
    public String getDrugFreq() {
        return drugFreq;
    }

    /**
     * @param drugFreq the drugFreq to set
     */
    public void setDrugFreq(String drugFreq) {
        this.drugFreq = drugFreq;
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
     * @return the drugUnit
     */
    public String getDrugUnit() {
        return drugUnit;
    }

    /**
     * @param drugUnit the drugUnit to set
     */
    public void setDrugUnit(String drugUnit) {
        this.drugUnit = drugUnit;
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
     * @return the hospitalId
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId the hospitalId to set
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
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
     * @return the personInsanityId
     */
    public Long getPersonInsanityId() {
        return personInsanityId;
    }

    /**
     * @param personInsanityId the personInsanityId to set
     */
    public void setPersonInsanityId(Long personInsanityId) {
        this.personInsanityId = personInsanityId;
    }

    /**
     * @return the personInsanityVisitId
     */
    public Long getPersonInsanityVisitId() {
        return personInsanityVisitId;
    }

    /**
     * @param personInsanityVisitId the personInsanityVisitId to set
     */
    public void setPersonInsanityVisitId(Long personInsanityVisitId) {
        this.personInsanityVisitId = personInsanityVisitId;
    }

    /**
     * @return the recordFlag
     */
    public String getRecordFlag() {
        return recordFlag;
    }

    /**
     * @param recordFlag the recordFlag to set
     */
    public void setRecordFlag(String recordFlag) {
        this.recordFlag = recordFlag;
    }

}