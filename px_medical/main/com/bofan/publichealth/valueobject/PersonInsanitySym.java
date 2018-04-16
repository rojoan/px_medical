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
 * 重性精神病--症状表
 * 
 */
@Entity
@Table(name="PERSON_INSANITY_SYM", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PERSON_INSANITY_SYM_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_INSANITY_SYM_ID", allocationSize = 1)
public class PersonInsanitySym implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_INSANITY_SYM_ID")
	@Column(name="PERSON_INSANITY_SYM_ID", unique=true, nullable=false, precision=18)
	private Long personInsanitySymId;
	
	@Column(name="PERSON_INSANITY_ID", nullable=false, precision=18)
    private Long personInsanityId;
	
	@Column(name="PERSON_INSANITY_VISIT_ID", precision=18)
    private Long personInsanityVisitId;
	
	@Column(name="CREATOR_ID", nullable=false, precision=18)
	private Long creatorId;

	@Column(name="HOSPITAL_ID", nullable=false, precision=18)
	private Long hospitalId;

	@Column(name="PERSON_DETAIL_ID", nullable=false, precision=18)
	private Long personDetailId;

	@Column(name="SYMPTOM_ID", nullable=false, precision=18)
	private Long symptomId;
	
	@Column(name="RECORD_FLAG", nullable=false, length=1)
    private String recordFlag;

	public PersonInsanitySym() {
	}

    /**
     * @return the personInsanitySymId
     */
    public Long getPersonInsanitySymId() {
        return personInsanitySymId;
    }

    /**
     * @param personInsanitySymId the personInsanitySymId to set
     */
    public void setPersonInsanitySymId(Long personInsanitySymId) {
        this.personInsanitySymId = personInsanitySymId;
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