package com.bofan.publichealth.valueobject;

import java.io.Serializable;
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
 * 慢性病随访--症状表
 * 
 */
@Entity
@Table(name="PERSON_VISIT_CHRONIC_SYM", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "VISIT_CHRONIC_SYM_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_VISIT_CHRONIC_SYM_ID", allocationSize = 1)
public class PersonVisitChronicSym implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VISIT_CHRONIC_SYM_ID")
	@Column(name="VISIT_CHRONIC_SYM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long visitChronicSymId;

	@Column(name="CHRONIC_TYPE")
	private String chronicType;

	@Column(name="HOSPITAL_ID", precision = 18, scale = 0)
	private Long hospitalId;

	@Column(name="PERSON_CHRONIC_ID", precision = 18, scale = 0)
	private Long personChronicId;

	@Column(name="PERSON_DETAIL_ID", precision = 18, scale = 0)
	private Long personDetailId;

	@Column(name="SYMPTOM_ID", precision = 18, scale = 0)
	private Long symptomId;

	@Column(name="VALID_FLAG")
	private String validFlag;

	@Column(name="VISIT_DOCTOR_ID", precision = 18, scale = 0)
	private Long visitDoctorId;

	@Column(name="VISIT_TIME")
	private Date visitTime;

	@Column(name="CHRONIC_VISIT_ID", precision = 18, scale = 0)
    private Long chronicVisitId;

	public PersonVisitChronicSym() {
	}

	/**
     * @return the visitChronicSymId
     */
    public Long getVisitChronicSymId() {
        return visitChronicSymId;
    }

    /**
     * @param visitChronicSymId the visitChronicSymId to set
     */
    public void setVisitChronicSymId(Long visitChronicSymId) {
        this.visitChronicSymId = visitChronicSymId;
    }

    public String getChronicType() {
		return this.chronicType;
	}

	public void setChronicType(String chronicType) {
		this.chronicType = chronicType;
	}

	public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Long getPersonChronicId() {
		return this.personChronicId;
	}

	public void setPersonChronicId(Long personChronicId) {
		this.personChronicId = personChronicId;
	}

	public Long getPersonDetailId() {
		return this.personDetailId;
	}

	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	public Long getSymptomId() {
		return this.symptomId;
	}

	public void setSymptomId(Long symptomId) {
		this.symptomId = symptomId;
	}

	public String getValidFlag() {
		return this.validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

	public Long getVisitDoctorId() {
		return this.visitDoctorId;
	}

	public void setVisitDoctorId(Long visitDoctorId) {
		this.visitDoctorId = visitDoctorId;
	}

	public Date getVisitTime() {
		return this.visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

    /**
     * @return the chronicVisitId
     */
    public Long getChronicVisitId() {
        return chronicVisitId;
    }

    /**
     * @param chronicVisitId the chronicVisitId to set
     */
    public void setChronicVisitId(Long chronicVisitId) {
        this.chronicVisitId = chronicVisitId;
    }

}