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
public class PersonInsanityVisitEditInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -5451648553090339790L;
    
    private Long personInsanityVisitId;

    private String bodyDiseaseFlag;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date deathDate;

    private String deathReasonFlag;

    private String dietContentFlag;

    private Long hospitalId;

    private String hospitalName;

    private String hospitalNo;

    private String hospitalPhone;

    private String houseworkFlag;

    private String humanFlag;

    private String inhospitalFlag;

    private String insanityDangerFlag;

    private String insightFlag;

    private String labExam;

    private String learnFlag;

    private String livingContentFlag;

    private String lockingFlag;

    private String lossReasonFlag;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date nextVisitTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date outhospitalTime;

    private Long personInsanityId;

    private String sleepFlag;

    private String symDescribe;

    private String transDiagnosisFlag;

    private Long transDiagnosisOfficeId;

    private String transDiagnosisOfficeName;

    private String transDiagnosisReason;

    private String visitClassify;

    private Long visitDoctorId;

    private String visitDoctorName;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date visitTime;

    private String visitWay;

    private String workFlag;
    
    private String eatDrugBelong;

    private String drugSideEffect;
    
    private String drugName;

    private String cureEffect;
    
    private String recoveryOther;
    
    private Long personDetailId;
    
    private String recordFlag;
    
    /** 症状ids */
    private Long[] symptomIds;
    
    /** 重性精神病--危险行为json */
    private String insanityBehaviorJson;
    
    /** 重性精神病--康复措施类型 */
    private String[] recoveryTypes;
    
    /** 重性精神病--用药情况json */
    private String insanityUsedrugJson;
    
    /** 重性精神病--用药指导json */
    private String insanityGuidedrugJson;

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
     * @return the bodyDiseaseFlag
     */
    public String getBodyDiseaseFlag() {
        return bodyDiseaseFlag;
    }

    /**
     * @param bodyDiseaseFlag the bodyDiseaseFlag to set
     */
    public void setBodyDiseaseFlag(String bodyDiseaseFlag) {
        this.bodyDiseaseFlag = bodyDiseaseFlag;
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
     * @return the deathReasonFlag
     */
    public String getDeathReasonFlag() {
        return deathReasonFlag;
    }

    /**
     * @param deathReasonFlag the deathReasonFlag to set
     */
    public void setDeathReasonFlag(String deathReasonFlag) {
        this.deathReasonFlag = deathReasonFlag;
    }

    /**
     * @return the dietContentFlag
     */
    public String getDietContentFlag() {
        return dietContentFlag;
    }

    /**
     * @param dietContentFlag the dietContentFlag to set
     */
    public void setDietContentFlag(String dietContentFlag) {
        this.dietContentFlag = dietContentFlag;
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
     * @return the houseworkFlag
     */
    public String getHouseworkFlag() {
        return houseworkFlag;
    }

    /**
     * @param houseworkFlag the houseworkFlag to set
     */
    public void setHouseworkFlag(String houseworkFlag) {
        this.houseworkFlag = houseworkFlag;
    }

    /**
     * @return the humanFlag
     */
    public String getHumanFlag() {
        return humanFlag;
    }

    /**
     * @param humanFlag the humanFlag to set
     */
    public void setHumanFlag(String humanFlag) {
        this.humanFlag = humanFlag;
    }

    /**
     * @return the inhospitalFlag
     */
    public String getInhospitalFlag() {
        return inhospitalFlag;
    }

    /**
     * @param inhospitalFlag the inhospitalFlag to set
     */
    public void setInhospitalFlag(String inhospitalFlag) {
        this.inhospitalFlag = inhospitalFlag;
    }

    /**
     * @return the insanityDangerFlag
     */
    public String getInsanityDangerFlag() {
        return insanityDangerFlag;
    }

    /**
     * @param insanityDangerFlag the insanityDangerFlag to set
     */
    public void setInsanityDangerFlag(String insanityDangerFlag) {
        this.insanityDangerFlag = insanityDangerFlag;
    }

    /**
     * @return the insightFlag
     */
    public String getInsightFlag() {
        return insightFlag;
    }

    /**
     * @param insightFlag the insightFlag to set
     */
    public void setInsightFlag(String insightFlag) {
        this.insightFlag = insightFlag;
    }

    /**
     * @return the labExam
     */
    public String getLabExam() {
        return labExam;
    }

    /**
     * @param labExam the labExam to set
     */
    public void setLabExam(String labExam) {
        this.labExam = labExam;
    }

    /**
     * @return the learnFlag
     */
    public String getLearnFlag() {
        return learnFlag;
    }

    /**
     * @param learnFlag the learnFlag to set
     */
    public void setLearnFlag(String learnFlag) {
        this.learnFlag = learnFlag;
    }

    /**
     * @return the livingContentFlag
     */
    public String getLivingContentFlag() {
        return livingContentFlag;
    }

    /**
     * @param livingContentFlag the livingContentFlag to set
     */
    public void setLivingContentFlag(String livingContentFlag) {
        this.livingContentFlag = livingContentFlag;
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
     * @return the lossReasonFlag
     */
    public String getLossReasonFlag() {
        return lossReasonFlag;
    }

    /**
     * @param lossReasonFlag the lossReasonFlag to set
     */
    public void setLossReasonFlag(String lossReasonFlag) {
        this.lossReasonFlag = lossReasonFlag;
    }

    /**
     * @return the nextVisitTime
     */
    public Date getNextVisitTime() {
        return nextVisitTime;
    }

    /**
     * @param nextVisitTime the nextVisitTime to set
     */
    public void setNextVisitTime(Date nextVisitTime) {
        this.nextVisitTime = nextVisitTime;
    }

    /**
     * @return the outhospitalTime
     */
    public Date getOuthospitalTime() {
        return outhospitalTime;
    }

    /**
     * @param outhospitalTime the outhospitalTime to set
     */
    public void setOuthospitalTime(Date outhospitalTime) {
        this.outhospitalTime = outhospitalTime;
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
     * @return the sleepFlag
     */
    public String getSleepFlag() {
        return sleepFlag;
    }

    /**
     * @param sleepFlag the sleepFlag to set
     */
    public void setSleepFlag(String sleepFlag) {
        this.sleepFlag = sleepFlag;
    }

    /**
     * @return the symDescribe
     */
    public String getSymDescribe() {
        return symDescribe;
    }

    /**
     * @param symDescribe the symDescribe to set
     */
    public void setSymDescribe(String symDescribe) {
        this.symDescribe = symDescribe;
    }

    /**
     * @return the transDiagnosisFlag
     */
    public String getTransDiagnosisFlag() {
        return transDiagnosisFlag;
    }

    /**
     * @param transDiagnosisFlag the transDiagnosisFlag to set
     */
    public void setTransDiagnosisFlag(String transDiagnosisFlag) {
        this.transDiagnosisFlag = transDiagnosisFlag;
    }

    /**
     * @return the transDiagnosisOfficeId
     */
    public Long getTransDiagnosisOfficeId() {
        return transDiagnosisOfficeId;
    }

    /**
     * @param transDiagnosisOfficeId the transDiagnosisOfficeId to set
     */
    public void setTransDiagnosisOfficeId(Long transDiagnosisOfficeId) {
        this.transDiagnosisOfficeId = transDiagnosisOfficeId;
    }

    /**
     * @return the transDiagnosisOfficeName
     */
    public String getTransDiagnosisOfficeName() {
        return transDiagnosisOfficeName;
    }

    /**
     * @param transDiagnosisOfficeName the transDiagnosisOfficeName to set
     */
    public void setTransDiagnosisOfficeName(String transDiagnosisOfficeName) {
        this.transDiagnosisOfficeName = transDiagnosisOfficeName;
    }

    /**
     * @return the transDiagnosisReason
     */
    public String getTransDiagnosisReason() {
        return transDiagnosisReason;
    }

    /**
     * @param transDiagnosisReason the transDiagnosisReason to set
     */
    public void setTransDiagnosisReason(String transDiagnosisReason) {
        this.transDiagnosisReason = transDiagnosisReason;
    }

    /**
     * @return the visitClassify
     */
    public String getVisitClassify() {
        return visitClassify;
    }

    /**
     * @param visitClassify the visitClassify to set
     */
    public void setVisitClassify(String visitClassify) {
        this.visitClassify = visitClassify;
    }

    /**
     * @return the visitDoctorId
     */
    public Long getVisitDoctorId() {
        return visitDoctorId;
    }

    /**
     * @param visitDoctorId the visitDoctorId to set
     */
    public void setVisitDoctorId(Long visitDoctorId) {
        this.visitDoctorId = visitDoctorId;
    }

    /**
     * @return the visitDoctorName
     */
    public String getVisitDoctorName() {
        return visitDoctorName;
    }

    /**
     * @param visitDoctorName the visitDoctorName to set
     */
    public void setVisitDoctorName(String visitDoctorName) {
        this.visitDoctorName = visitDoctorName;
    }

    /**
     * @return the visitTime
     */
    public Date getVisitTime() {
        return visitTime;
    }

    /**
     * @param visitTime the visitTime to set
     */
    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    /**
     * @return the visitWay
     */
    public String getVisitWay() {
        return visitWay;
    }

    /**
     * @param visitWay the visitWay to set
     */
    public void setVisitWay(String visitWay) {
        this.visitWay = visitWay;
    }

    /**
     * @return the workFlag
     */
    public String getWorkFlag() {
        return workFlag;
    }

    /**
     * @param workFlag the workFlag to set
     */
    public void setWorkFlag(String workFlag) {
        this.workFlag = workFlag;
    }

    /**
     * @return the eatDrugBelong
     */
    public String getEatDrugBelong() {
        return eatDrugBelong;
    }

    /**
     * @param eatDrugBelong the eatDrugBelong to set
     */
    public void setEatDrugBelong(String eatDrugBelong) {
        this.eatDrugBelong = eatDrugBelong;
    }

    /**
     * @return the drugSideEffect
     */
    public String getDrugSideEffect() {
        return drugSideEffect;
    }

    /**
     * @param drugSideEffect the drugSideEffect to set
     */
    public void setDrugSideEffect(String drugSideEffect) {
        this.drugSideEffect = drugSideEffect;
    }

    /**
     * @return the drugName
     */
    public String getDrugName() {
        return drugName;
    }

    /**
     * @param drugName the drugName to set
     */
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    /**
     * @return the cureEffect
     */
    public String getCureEffect() {
        return cureEffect;
    }

    /**
     * @param cureEffect the cureEffect to set
     */
    public void setCureEffect(String cureEffect) {
        this.cureEffect = cureEffect;
    }

    /**
     * @return the recoveryOther
     */
    public String getRecoveryOther() {
        return recoveryOther;
    }

    /**
     * @param recoveryOther the recoveryOther to set
     */
    public void setRecoveryOther(String recoveryOther) {
        this.recoveryOther = recoveryOther;
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
     * @return the recoveryTypes
     */
    public String[] getRecoveryTypes() {
        return recoveryTypes;
    }

    /**
     * @param recoveryTypes the recoveryTypes to set
     */
    public void setRecoveryTypes(String[] recoveryTypes) {
        this.recoveryTypes = recoveryTypes;
    }

    /**
     * @return the insanityUsedrugJson
     */
    public String getInsanityUsedrugJson() {
        return insanityUsedrugJson;
    }

    /**
     * @param insanityUsedrugJson the insanityUsedrugJson to set
     */
    public void setInsanityUsedrugJson(String insanityUsedrugJson) {
        this.insanityUsedrugJson = insanityUsedrugJson;
    }

    /**
     * @return the insanityGuidedrugJson
     */
    public String getInsanityGuidedrugJson() {
        return insanityGuidedrugJson;
    }

    /**
     * @param insanityGuidedrugJson the insanityGuidedrugJson to set
     */
    public void setInsanityGuidedrugJson(String insanityGuidedrugJson) {
        this.insanityGuidedrugJson = insanityGuidedrugJson;
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
