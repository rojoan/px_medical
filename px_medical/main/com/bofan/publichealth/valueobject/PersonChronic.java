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
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 慢性病患者实体
 * 
 */
@Entity
@Table(name="PERSON_CHRONIC", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PERSON_CHRONIC_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_CHRONIC_ID", allocationSize = 1)
public class PersonChronic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_CHRONIC_ID")
	@Column(name="PERSON_CHRONIC_ID", nullable = false, precision = 18, scale = 0)
	private Long personChronicId;

	@Column(name="CONTACT_ADDR")
	private String contactAddr;

	@Column(name="CREATE_TIME")
	private Date createTime;
	
	@Column(name="GENDER")
    private String gender;

	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name="BIRTH_DATE")
    private Date birthDate;
	
	@Column(name="CREATOR_ID")
	private Long creatorId;

	@Column(name="CREATOR_NAME")
	private String creatorName;

	@Column(name="FAMILY_REL_ID")
	private Long familyRelId;

	@Column(name="HOSPITAL_ID")
	private Long hospitalId;

	@Column(name="HOSPITAL_NAME")
	private String hospitalName;

	@Column(name="HOSPITAL_NO")
	private String hospitalNo;

	@Column(name="HOSPITAL_PHONE")
	private String hospitalPhone;

	@Column(name="ID_CARD")
	private String idCard;

	@Column(name="LINKMAN_PHONE")
	private String linkmanPhone;

	@Column(name="PATIENT_NAME")
	private String patientName;

	@Column(name="PERSON_DETAIL_ID")
	private Long personDetailId;

	@Column(name="RECORD_NUM")
	private String recordNum;

	@Column(name="REGION_ID")
	private String regionId;

	@Column(name="VALID_FLAG")
	private String validFlag;

	@Column(name="ZIP_CODE")
	private String zipCode;
	
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name="DEATH_DATE")
    private Date deathDate;
	
	@Column(name="DEATH_REASON", length = 40)
    private String deathReason;

	public PersonChronic() {
	}

	public Long getPersonChronicId() {
		return this.personChronicId;
	}

	public void setPersonChronicId(Long personChronicId) {
		this.personChronicId = personChronicId;
	}

	public String getContactAddr() {
		return this.contactAddr;
	}

	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return this.creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	
	public Long getFamilyRelId() {
		return this.familyRelId;
	}

	public void setFamilyRelId(Long familyRelId) {
		this.familyRelId = familyRelId;
	}

	public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalNo() {
		return this.hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getHospitalPhone() {
		return this.hospitalPhone;
	}

	public void setHospitalPhone(String hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getLinkmanPhone() {
		return this.linkmanPhone;
	}

	public void setLinkmanPhone(String linkmanPhone) {
		this.linkmanPhone = linkmanPhone;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Long getPersonDetailId() {
		return this.personDetailId;
	}

	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	public String getRecordNum() {
		return this.recordNum;
	}

	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}

	public String getRegionId() {
		return this.regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getValidFlag() {
		return this.validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

    /**
     * @return the deathDate
     */
    public Date getDeathDate() {
        return deathDate;
    }

    /**
     * @param deathDate the deathDate to set
     */
    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    /**
     * @return the deathReason
     */
    public String getDeathReason() {
        return deathReason;
    }

    /**
     * @param deathReason the deathReason to set
     */
    public void setDeathReason(String deathReason) {
        this.deathReason = deathReason;
    }

}