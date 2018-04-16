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
 * 慢性病随访-治疗情况
 * 
 */
@Entity
@Table(name="PERSON_VISIT_CURE", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "VISIT_CURE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_VISIT_CURE_ID", allocationSize = 1)
public class PersonVisitCure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VISIT_CURE_ID")
	@Column(name="VISIT_CURE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long visitCureId;

	@Column(name="CHRONIC_TYPE")
	private String chronicType;

	@Column(name="HOSPITAL_ID", precision = 18, scale = 0)
	private Long hospitalId;

	@Column(name="CHRONIC_VISIT_ID", precision = 18, scale = 0)
    private Long chronicVisitId;
	
	@Column(name="PERSON_CHRONIC_ID", precision = 18, scale = 0)
	private Long personChronicId;

	@Column(name="PERSON_DETAIL_ID", precision = 18, scale = 0)
	private Long personDetailId;

	@Column(name="CURE_TYPE", precision = 18, scale = 0)
	private String cureType;

	@Column(name="VALID_FLAG", length = 1)
	private String validFlag;

	@Column(name="VISIT_DOCTOR_ID", precision = 18, scale = 0)
	private Long visitDoctorId;

	@Column(name="VISIT_TIME")
	private Date visitTime;

	public PersonVisitCure() {
	}

    /**
     * @return the visitCureId
     */
    public Long getVisitCureId() {
        return visitCureId;
    }

    /**
     * @param visitCureId the visitCureId to set
     */
    public void setVisitCureId(Long visitCureId) {
        this.visitCureId = visitCureId;
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

	/**
     * @return the cureType
     */
    public String getCureType() {
        return cureType;
    }

    /**
     * @param cureType the cureType to set
     */
    public void setCureType(String cureType) {
        this.cureType = cureType;
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