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
 * 重性精神病登记表
 * 
 */
@Entity
@Table(name="PERSON_INSANITY", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PERSON_INSANITY_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_INSANITY_ID", allocationSize = 1)
public class PersonInsanity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_INSANITY_ID")
	@Column(name="PERSON_INSANITY_ID", unique=true, nullable=false, precision=18)
	private Long personInsanityId;

	@Column(name="GENDER")
    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name="BIRTH_DATE")
    private Date birthDate;
	
	@Column(name="AGREE_MANAGE_FLAG", length=1)
	private String agreeManageFlag;

	@Column(name="CAREER_ID", nullable=false, precision=18)
	private Long careerId;

	@Column(name="CENSUS_FLAG", nullable=false, length=1)
	private String censusFlag;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="CREATOR_ID", precision=18)
	private Long creatorId;

	@Column(name="CREATOR_NAME", length=20)
	private String creatorName;

	@Column(name="CUR_DIAGNOSIS", length=2000)
	private String curDiagnosis;

	@Column(name="DIAGNOSIS_HOSPITAL", length=200)
	private String diagnosisHospital;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name="DISEASE_CONFIRM_TIME")
	private Date diseaseConfirmTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name="DISEASE_TIME")
	private Date diseaseTime;

	@Column(name="DOCOTOR_ADVICE", length=2000)
	private String docotorAdvice;

	@Column(name="ECONOMIC_FLAG", length=1)
	private String economicFlag;

	@Column(name="FAMILY_REL_ID", nullable=false, precision=18)
	private Long familyRelId;

	@Column(name="GUARDIAN_ADDR", length=200)
	private String guardianAddr;

	@Column(name="GUARDIAN_NAME", length=20)
	private String guardianName;

	@Column(name="GUARDIAN_PHONE", length=40)
	private String guardianPhone;

	@Column(name="HOSPITAL_ID", nullable=false, precision=18)
	private Long hospitalId;

	@Column(name="HOSPITAL_NAME", nullable=false, length=200)
	private String hospitalName;

	@Column(name="HOSPITAL_NO", nullable=false, length=50)
	private String hospitalNo;

	@Column(name="HOSPITAL_PHONE", length=30)
	private String hospitalPhone;

	@Column(name="INHOSPITAL_COUNT", precision=2)
	private Integer inhospitalCount;

	@Column(name="LINKMAN_NAME", nullable=false, length=30)
	private String linkmanName;

	@Column(name="LINKMAN_PHONE", nullable=false, length=30)
	private String linkmanPhone;

	@Column(name="LOCKING_FLAG", length=1)
	private String lockingFlag;

	@Column(name="NEXT_THERAPY", length=40)
	private String nextTherapy;

	@Column(name="OTHER_SYM", length=200)
	private String otherSym;

	@Column(name="OUTPATIENT_FLAG", length=1)
	private String outpatientFlag;

	@Column(name="PATIENT_NAME", nullable=false, length=20)
	private String patientName;

	@Column(name="PERSON_DETAIL_ID", nullable=false, precision=18)
	private Long personDetailId;

	@Column(name="REGION_ID", length=18)
	private String regionId;

	@Column(name="SIGN_PERSON", length=20)
	private String signPerson;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name="SIGN_TIME")
	private Date signTime;

	@Column(name="SPECIAL_ARCHIVE_NUM", length=40)
	private String specialArchiveNum;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name="THERAPY_TIME")
	private Date therapyTime;

	@Column(name="VALID_FLAG", length=1)
	private String validFlag;
	
	public PersonInsanity() {
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

    /**
     * @return the agreeManageFlag
     */
    public String getAgreeManageFlag() {
        return agreeManageFlag;
    }

    /**
     * @param agreeManageFlag the agreeManageFlag to set
     */
    public void setAgreeManageFlag(String agreeManageFlag) {
        this.agreeManageFlag = agreeManageFlag;
    }

    /**
     * @return the careerId
     */
    public Long getCareerId() {
        return careerId;
    }

    /**
     * @param careerId the careerId to set
     */
    public void setCareerId(Long careerId) {
        this.careerId = careerId;
    }

    /**
     * @return the censusFlag
     */
    public String getCensusFlag() {
        return censusFlag;
    }

    /**
     * @param censusFlag the censusFlag to set
     */
    public void setCensusFlag(String censusFlag) {
        this.censusFlag = censusFlag;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
     * @return the creatorName
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * @param creatorName the creatorName to set
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     * @return the curDiagnosis
     */
    public String getCurDiagnosis() {
        return curDiagnosis;
    }

    /**
     * @param curDiagnosis the curDiagnosis to set
     */
    public void setCurDiagnosis(String curDiagnosis) {
        this.curDiagnosis = curDiagnosis;
    }

    /**
     * @return the diagnosisHospital
     */
    public String getDiagnosisHospital() {
        return diagnosisHospital;
    }

    /**
     * @param diagnosisHospital the diagnosisHospital to set
     */
    public void setDiagnosisHospital(String diagnosisHospital) {
        this.diagnosisHospital = diagnosisHospital;
    }

    /**
     * @return the diseaseConfirmTime
     */
    public Date getDiseaseConfirmTime() {
        return diseaseConfirmTime;
    }

    /**
     * @param diseaseConfirmTime the diseaseConfirmTime to set
     */
    public void setDiseaseConfirmTime(Date diseaseConfirmTime) {
        this.diseaseConfirmTime = diseaseConfirmTime;
    }

    /**
     * @return the diseaseTime
     */
    public Date getDiseaseTime() {
        return diseaseTime;
    }

    /**
     * @param diseaseTime the diseaseTime to set
     */
    public void setDiseaseTime(Date diseaseTime) {
        this.diseaseTime = diseaseTime;
    }

    /**
     * @return the docotorAdvice
     */
    public String getDocotorAdvice() {
        return docotorAdvice;
    }

    /**
     * @param docotorAdvice the docotorAdvice to set
     */
    public void setDocotorAdvice(String docotorAdvice) {
        this.docotorAdvice = docotorAdvice;
    }

    /**
     * @return the economicFlag
     */
    public String getEconomicFlag() {
        return economicFlag;
    }

    /**
     * @param economicFlag the economicFlag to set
     */
    public void setEconomicFlag(String economicFlag) {
        this.economicFlag = economicFlag;
    }

    /**
     * @return the familyRelId
     */
    public Long getFamilyRelId() {
        return familyRelId;
    }

    /**
     * @param familyRelId the familyRelId to set
     */
    public void setFamilyRelId(Long familyRelId) {
        this.familyRelId = familyRelId;
    }

    /**
     * @return the guardianAddr
     */
    public String getGuardianAddr() {
        return guardianAddr;
    }

    /**
     * @param guardianAddr the guardianAddr to set
     */
    public void setGuardianAddr(String guardianAddr) {
        this.guardianAddr = guardianAddr;
    }

    /**
     * @return the guardianName
     */
    public String getGuardianName() {
        return guardianName;
    }

    /**
     * @param guardianName the guardianName to set
     */
    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    /**
     * @return the guardianPhone
     */
    public String getGuardianPhone() {
        return guardianPhone;
    }

    /**
     * @param guardianPhone the guardianPhone to set
     */
    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
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
     * @return the hospitalName
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * @param hospitalName the hospitalName to set
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * @return the hospitalNo
     */
    public String getHospitalNo() {
        return hospitalNo;
    }

    /**
     * @param hospitalNo the hospitalNo to set
     */
    public void setHospitalNo(String hospitalNo) {
        this.hospitalNo = hospitalNo;
    }

    /**
     * @return the hospitalPhone
     */
    public String getHospitalPhone() {
        return hospitalPhone;
    }

    /**
     * @param hospitalPhone the hospitalPhone to set
     */
    public void setHospitalPhone(String hospitalPhone) {
        this.hospitalPhone = hospitalPhone;
    }

    /**
     * @return the inhospitalCount
     */
    public Integer getInhospitalCount() {
        return inhospitalCount;
    }

    /**
     * @param inhospitalCount the inhospitalCount to set
     */
    public void setInhospitalCount(Integer inhospitalCount) {
        this.inhospitalCount = inhospitalCount;
    }

    /**
     * @return the linkmanName
     */
    public String getLinkmanName() {
        return linkmanName;
    }

    /**
     * @param linkmanName the linkmanName to set
     */
    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    /**
     * @return the linkmanPhone
     */
    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    /**
     * @param linkmanPhone the linkmanPhone to set
     */
    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    /**
     * @return the lockingFlag
     */
    public String getLockingFlag() {
        return lockingFlag;
    }

    /**
     * @param lockingFlag the lockingFlag to set
     */
    public void setLockingFlag(String lockingFlag) {
        this.lockingFlag = lockingFlag;
    }

    /**
     * @return the nextTherapy
     */
    public String getNextTherapy() {
        return nextTherapy;
    }

    /**
     * @param nextTherapy the nextTherapy to set
     */
    public void setNextTherapy(String nextTherapy) {
        this.nextTherapy = nextTherapy;
    }

    /**
     * @return the otherSym
     */
    public String getOtherSym() {
        return otherSym;
    }

    /**
     * @param otherSym the otherSym to set
     */
    public void setOtherSym(String otherSym) {
        this.otherSym = otherSym;
    }

    /**
     * @return the outpatientFlag
     */
    public String getOutpatientFlag() {
        return outpatientFlag;
    }

    /**
     * @param outpatientFlag the outpatientFlag to set
     */
    public void setOutpatientFlag(String outpatientFlag) {
        this.outpatientFlag = outpatientFlag;
    }

    /**
     * @return the patientName
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * @param patientName the patientName to set
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
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
     * @return the regionId
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId the regionId to set
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * @return the signPerson
     */
    public String getSignPerson() {
        return signPerson;
    }

    /**
     * @param signPerson the signPerson to set
     */
    public void setSignPerson(String signPerson) {
        this.signPerson = signPerson;
    }

    /**
     * @return the signTime
     */
    public Date getSignTime() {
        return signTime;
    }

    /**
     * @param signTime the signTime to set
     */
    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    /**
     * @return the specialArchiveNum
     */
    public String getSpecialArchiveNum() {
        return specialArchiveNum;
    }

    /**
     * @param specialArchiveNum the specialArchiveNum to set
     */
    public void setSpecialArchiveNum(String specialArchiveNum) {
        this.specialArchiveNum = specialArchiveNum;
    }

    /**
     * @return the therapyTime
     */
    public Date getTherapyTime() {
        return therapyTime;
    }

    /**
     * @param therapyTime the therapyTime to set
     */
    public void setTherapyTime(Date therapyTime) {
        this.therapyTime = therapyTime;
    }

    /**
     * @return the validFlag
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag the validFlag to set
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

}