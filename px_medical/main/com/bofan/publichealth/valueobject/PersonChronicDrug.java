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
 * 慢性病本次药物治疗
 * 
 */
@Entity
@Table(name="PERSON_CHRONIC_DRUG", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "CHRONIC_DRUG_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_CHRONIC_DRUG_ID", allocationSize = 1)
public class PersonChronicDrug implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHRONIC_DRUG_ID")
	@Column(name="CHRONIC_DRUG_ID")
	private Long chronicDrugId;

	@Column(name="CHRONIC_TYPE")
	private String chronicType;

	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="CREATOR_ID")
	private Long creatorId;

	@Column(name="DISEASE_DRUG_ID")
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

	@Column(name="HOSPITAL_ID")
	private Long hospitalId;

	@Column(name="PERSON_DETAIL_ID")
	private Long personDetailId;
	
	@Column(name="PERSON_CHRONIC_ID")
    private Long personChronicId;

	@Column(name="VALID_FLAG")
	private String validFlag;

	public PersonChronicDrug() {
	}
	
	/**
     * @return the chronicDrugId
     */
    public Long getChronicDrugId() {
        return chronicDrugId;
    }

    /**
     * @param chronicDrugId the chronicDrugId to set
     */
    public void setChronicDrugId(Long chronicDrugId) {
        this.chronicDrugId = chronicDrugId;
    }

    public String getChronicType() {
		return this.chronicType;
	}

	public void setChronicType(String chronicType) {
		this.chronicType = chronicType;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
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

	public Long getPersonDetailId() {
		return this.personDetailId;
	}

	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	/**
     * @return the personChronicId
     */
    public Long getPersonChronicId() {
        return personChronicId;
    }

    /**
     * @param personChronicId the personChronicId to set
     */
    public void setPersonChronicId(Long personChronicId) {
        this.personChronicId = personChronicId;
    }

    public String getValidFlag() {
		return this.validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}
}