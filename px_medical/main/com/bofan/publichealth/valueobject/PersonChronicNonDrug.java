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
 * 慢性病非药物治疗
 * 
 */
@Entity
@Table(name="PERSON_CHRONIC_NON_DRUG", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "CHRONIC_NON_DRUG_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_CHRONIC_NON_DRUG_ID", allocationSize = 1)
public class PersonChronicNonDrug implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHRONIC_NON_DRUG_ID")
	@Column(name="CHRONIC_NON_DRUG_ID", unique=true, nullable=false, precision=18)
	private Long chronicNonDrugId;
	
	@Column(name="PERSON_CHRONIC_ID", nullable=false, precision=18)
    private Long personChronicId;
	
	@Column(name="PERSON_DETAIL_ID", nullable=false, precision=18)
    private Long personDetailId;

	@Column(name="CHRONIC_TYPE", length = 1)
	private String chronicType;
	
	@Column(name="NON_DRUG_TYPE", length = 1)
    private String nonDrugType;

	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="CREATOR_ID", nullable=false, precision=18)
	private Long creatorId;

	@Column(name="HOSPITAL_ID", nullable=false, precision=18)
	private Long hospitalId;

	@Column(name="VALID_FLAG")
	private String validFlag;

	public PersonChronicNonDrug() {
	}

	/**
     * @return the chronicNonDrugId
     */
    public Long getChronicNonDrugId() {
        return chronicNonDrugId;
    }

    /**
     * @param chronicNonDrugId the chronicNonDrugId to set
     */
    public void setChronicNonDrugId(Long chronicNonDrugId) {
        this.chronicNonDrugId = chronicNonDrugId;
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

	public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getNonDrugType() {
		return this.nonDrugType;
	}

	public void setNonDrugType(String nonDrugType) {
		this.nonDrugType = nonDrugType;
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
}