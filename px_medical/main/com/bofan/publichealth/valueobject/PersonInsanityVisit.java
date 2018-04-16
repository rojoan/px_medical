package com.bofan.publichealth.valueobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 重性精神疾病患者随访服务记录表
 * 
 */
@Entity
@Table(name="PERSON_INSANITY_VISIT", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PERSON_INSANITY_VISIT_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_INSANITY_VISIT_ID", allocationSize = 1)
public class PersonInsanityVisit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_INSANITY_VISIT_ID")
	@Column(name="PERSON_INSANITY_VISIT_ID", unique=true, nullable=false, precision=18)
	private Long personInsanityVisitId;

	@Column(name="BODY_DISEASE_FLAG", length=1)
	private String bodyDiseaseFlag;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name="DEATH_DATE")
	private Date deathDate;

	@Column(name="DEATH_REASON_FLAG", length=1)
	private String deathReasonFlag;

	@Column(name="DIET_CONTENT_FLAG", length=1)
	private String dietContentFlag;

	@Column(name="HOSPITAL_ID", nullable=false, precision=18)
	private Long hospitalId;

	@Column(name="HOSPITAL_NAME", nullable=false, length=200)
	private String hospitalName;

	@Column(name="HOSPITAL_NO", nullable=false, length=50)
	private String hospitalNo;

	@Column(name="HOSPITAL_PHONE", length=30)
	private String hospitalPhone;

	@Column(name="HOUSEWORK_FLAG", length=1)
	private String houseworkFlag;

	@Column(name="HUMAN_FLAG", length=1)
	private String humanFlag;

	@Column(name="INHOSPITAL_FLAG", length=1)
	private String inhospitalFlag;

	@Column(name="INSANITY_DANGER_FLAG", nullable=false, length=1)
	private String insanityDangerFlag;

	@Column(name="INSIGHT_FLAG", length=1)
	private String insightFlag;

	@Column(name="LAB_EXAM", length=100)
	private String labExam;

	@Column(name="LEARN_FLAG", length=1)
	private String learnFlag;

	@Column(name="LIVING_CONTENT_FLAG", length=1)
	private String livingContentFlag;

	@Column(name="LOCKING_FLAG", length=1)
	private String lockingFlag;

	@Column(name="LOSS_REASON_FLAG", length=1)
	private String lossReasonFlag;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name="NEXT_VISIT_TIME")
	private Date nextVisitTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name="OUTHOSPITAL_TIME")
	private Date outhospitalTime;

	@Column(name="PERSON_INSANITY_ID", nullable=false, precision=18)
	private Long personInsanityId;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PERSON_INSANITY_ID", insertable = false, updatable = false)
    private PersonInsanity personInsanity;

	@Column(name="SLEEP_FLAG", length=1)
	private String sleepFlag;

	@Column(name="SYM_DESCRIBE", length=200)
	private String symDescribe;

	@Column(name="TRANS_DIAGNOSIS_FLAG", length=1)
	private String transDiagnosisFlag;

	@Column(name="TRANS_DIAGNOSIS_OFFICE_ID", precision=18)
	private Long transDiagnosisOfficeId;

	@Column(name="TRANS_DIAGNOSIS_OFFICE_NAME", length=200)
	private String transDiagnosisOfficeName;

	@Column(name="TRANS_DIAGNOSIS_REASON", length=200)
	private String transDiagnosisReason;

	@Column(name="VALID_FLAG", nullable=false, length=1)
	private String validFlag;

	@Column(name="VISIT_CLASSIFY", length=1)
	private String visitClassify;

	@Column(name="VISIT_DOCTOR_ID", precision=18)
	private Long visitDoctorId;

	@Column(name="VISIT_DOCTOR_NAME", length=20)
	private String visitDoctorName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name="VISIT_TIME", nullable=false)
	private Date visitTime;

	@Column(name="VISIT_WAY", length=1)
	private String visitWay;

	@Column(name="WORK_FLAG", length=1)
	private String workFlag;
	
	@Column(name="EAT_DRUG_BELONG", length=1)
    private String eatDrugBelong;

    @Column(name="DRUG_SIDE_EFFECT", length=1)
    private String drugSideEffect;
    
    @Column(name="DRUG_NAME", length=20)
    private String drugName;

    @Column(name="CURE_EFFECT", length=1)
    private String cureEffect;
    
    @Column(name="RECOVERY_OTHER", length=40)
    private String recoveryOther;
    
    @Column(name="PERSON_DETAIL_ID", nullable=false, precision=18)
    private Long personDetailId;

	public PersonInsanityVisit() {
	    
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
     * @return the personInsanity
     */
    public PersonInsanity getPersonInsanity() {
        return personInsanity;
    }

    /**
     * @param personInsanity the personInsanity to set
     */
    public void setPersonInsanity(PersonInsanity personInsanity) {
        this.personInsanity = personInsanity;
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

}