package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * 接收来自页面编辑慢性病患者登记参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
public class PersonInsanityEditInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -5451648553090339790L;

    private Long personInsanityId;
    
    private String gender;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date birthDate;

    private String agreeManageFlag;

    private Long careerId;

    private String censusFlag;

    private Long creatorId;

    private String creatorName;

    private String curDiagnosis;

    private String diagnosisHospital;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date diseaseConfirmTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date diseaseTime;

    private String docotorAdvice;

    private String economicFlag;

    private Long familyRelId;

    private String guardianAddr;

    private String guardianName;

    private String guardianPhone;

    private Long hospitalId;

    private String hospitalName;

    private String hospitalNo;

    private String hospitalPhone;

    private Integer inhospitalCount;

    private String linkmanName;

    private String linkmanPhone;

    private String lockingFlag;

    private String nextTherapy;

    private String otherSym;

    private String outpatientFlag;

    private String patientName;

    private Long personDetailId;

    private String regionId;

    private String signPerson;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date signTime;

    private String specialArchiveNum;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date therapyTime;
    
    private String recordFlag;
    
    /** 症状ids */
    private Long[] symptomIds;
    
    /** 重性精神病--危险行为json */
    private String insanityBehaviorJson;

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
     * @return the symptomIds
     */
    public Long[] getSymptomIds() {
        return symptomIds;
    }

    /**
     * @param symptomIds the symptomIds to set
     */
    public void setSymptomIds(Long[] symptomIds) {
        this.symptomIds = symptomIds;
    }

    /**
     * @return the insanityBehaviorJson
     */
    public String getInsanityBehaviorJson() {
        return insanityBehaviorJson;
    }

    /**
     * @param insanityBehaviorJson the insanityBehaviorJson to set
     */
    public void setInsanityBehaviorJson(String insanityBehaviorJson) {
        this.insanityBehaviorJson = insanityBehaviorJson;
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
