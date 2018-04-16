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
 * 慢性病随访用药情况表
 * 
 */
@Entity
@Table(name="PERSON_VISIT_DRUG", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "VISIT_DRUG_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_VISIT_DRUG_ID", allocationSize = 1)
public class PersonVisitDrug implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VISIT_DRUG_ID")
	@Column(name="VISIT_DRUG_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long visitDrugId;

	@Column(name="CHRONIC_TYPE")
	private String chronicType;

	@Column(name="DISEASE_DRUG_ID", precision = 18, scale = 0)
	private Long diseaseDrugId;

	@Column(name="DISEASE_DRUG_NAME")
	private String diseaseDrugName;

	@Column(name="DISEASE_DRUG_TYPE")
	private String diseaseDrugType;

	@Column(name="DRUG_FREQ")
	private String drugFreq;

	@Column(name="DRUG_QUANTITY")
	private String drugQuantity;

	@Column(name="DRUG_UNIT")
	private String drugUnit;

	@Column(name="HOSPITAL_ID", precision = 18, scale = 0)
	private Long hospitalId;

	@Column(name="PERSON_CHRONIC_ID", precision = 18, scale = 0)
	private Long personChronicId;

	@Column(name="PERSON_DETAIL_ID", precision = 18, scale = 0)
	private Long personDetailId;

	@Column(name="VALID_FLAG")
	private String validFlag;

	@Column(name="VISIT_DOCTOR_ID", precision = 18, scale = 0)
	private Long visitDoctorId;

	@Column(name="VISIT_TIME")
	private Date visitTime;

	@Column(name="CHRONIC_VISIT_ID", precision = 18, scale = 0)
    private Long chronicVisitId;

	public PersonVisitDrug() {
	}

	public Long getVisitDrugId() {
		return this.visitDrugId;
	}

	public void setVisitDrugId(Long visitDrugId) {
		this.visitDrugId = visitDrugId;
	}

	public String getChronicType() {
		return this.chronicType;
	}

	public void setChronicType(String chronicType) {
		this.chronicType = chronicType;
	}

	public Long getDiseaseDrugId() {
		return this.diseaseDrugId;
	}

	public void setDiseaseDrugId(Long diseaseDrugId) {
		this.diseaseDrugId = diseaseDrugId;
	}

	public String getDiseaseDrugName() {
		return this.diseaseDrugName;
	}

	public void setDiseaseDrugName(String diseaseDrugName) {
		this.diseaseDrugName = diseaseDrugName;
	}

	public String getDiseaseDrugType() {
		return this.diseaseDrugType;
	}

	public void setDiseaseDrugType(String diseaseDrugType) {
		this.diseaseDrugType = diseaseDrugType;
	}

	public String getDrugFreq() {
		return this.drugFreq;
	}

	public void setDrugFreq(String drugFreq) {
		this.drugFreq = drugFreq;
	}

	public String getDrugQuantity() {
		return this.drugQuantity;
	}

	public void setDrugQuantity(String drugQuantity) {
		this.drugQuantity = drugQuantity;
	}

	public String getDrugUnit() {
		return this.drugUnit;
	}

	public void setDrugUnit(String drugUnit) {
		this.drugUnit = drugUnit;
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