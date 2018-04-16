package com.bofan.publichealth.valueobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.utils.SchemaConsts;


/**
 * 随访--体征/检查/生活指导/治疗情况表
 * 
 */
@Entity
@Table(name="PERSON_VISIT_ITEM", schema = SchemaConsts.PUBLIC_HEALTH)
public class PersonVisitItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CHRONIC_VISIT_ID", nullable = false, precision = 18, scale = 0)
	private Long chronicVisitId;

	@Column(name="BEHAVIOR_DOCTOR")
	private String behaviorDoctor;

	@Column(name="BODY_INDEX")
	private Double bodyIndex;

	@Column(name="DIASTOLIC_BLOOD_PRESSURE")
	private Integer diastolicBloodPressure;

	@Column(name="DRUG_COMPLIANCE")
	private String drugCompliance;

	@Column(name="DRUG_REACTION")
	private String drugReaction;

	@Column(name="DRUG_REACTION_OTHER")
	private String drugReactionOther;

	@Column(name="EAT_EVERYDAY")
	private Integer eatEveryday;

	@Column(name="FBG_MMOL")
	private Double fbgMmol;

	@Column(name="FOOT_PULSATION")
	private String footPulsation;

	@Column(name="GLYCOSYLATED_HEMOGLOBIN")
	private Integer glycosylatedHemoglobin;

	@Column(name="HEART_RATE")
	private Integer heartRate;

	private Double height;

	@Column(name="HOSPITAL_ID", precision = 18, scale = 0)
	private Long hospitalId;

	@Column(name="INSULIN_TYPE")
	private String insulinType;

	@Column(name="INSULIN_USAGE")
	private String insulinUsage;

	@Column(name="LOW_BLOOD_SUGAR")
	private String lowBloodSugar;

	@Column(name="NEXT_BODY_INDEX")
	private Double nextBodyIndex;

	@Column(name="NEXT_EAT_EVERYDAY")
	private Integer nextEatEveryday;

	@Column(name="NEXT_PHYSICAL_TIME")
	private Integer nextPhysicalTime;

	@Column(name="NEXT_PHYSICAL_WEEK")
	private Integer nextPhysicalWeek;

	@Column(name="NEXT_SMOKE_EVERYDAY")
	private Integer nextSmokeEveryday;

	@Column(name="NEXT_WEIGHT")
	private Double nextWeight;

	@Column(name="NEXT_WINE_EVERYDAY")
	private String nextWineEveryday;

	@Column(name="OTHER_SIGN")
	private String otherSign;

	@Column(name="PERSON_CHRONIC_ID", precision = 18, scale = 0)
	private Long personChronicId;

	@Column(name="PERSON_DETAIL_ID", precision = 18, scale = 0)
	private Long personDetailId;

	@Column(name="PHYSICAL_TIME")
	private Integer physicalTime;

	@Column(name="PHYSICAL_WEEK")
	private Integer physicalWeek;

	@Column(name="PSYCHOLOGICAL_RECOVERY")
	private String psychologicalRecovery;

	@Column(name="SMOKE_EVERYDAY")
	private BigDecimal smokeEveryday;

	@Column(name="SYSTOLIC_BLOOD_PRESSURE")
	private Integer systolicBloodPressure;

	@Column(name="TAKEN_SALT_THICK")
	private String takenSaltThick;

	@Column(name="TAKEN_SALT_THIN")
	private String takenSaltThin;

	@Column(name="VALID_FLAG")
	private String validFlag;

	@Column(name="VISIT_DOCTOR_ID", precision = 18, scale = 0)
	private Long visitDoctorId;

	@Column(name="VISIT_EXAM_OTHER")
	private String visitExamOther;

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="VISIT_EXAM_TIME")
	private Date visitExamTime;

	@Column(name="VISIT_TIME")
	private Date visitTime;

	@Column(name="VISIT_TYPE")
	private String visitType;

	private Double weight;

	@Column(name="WINE_EVERYDAY")
	private String wineEveryday;
	
	@Column(name="OTHER_SYM", length = 100)
	private String otherSym;

	@Column(name="VISIT_EXAM", length = 100)
    private String visitExam;
	
	@Column(name="BREATHE_EXEC", length = 40)
	private String breatheExec;

	@Column(name="CURE_OTHER", length = 40)
    private String cureOther;
	
	@Column(name="RECUR_FLAG", length = 1)
    private String recurFlag;
	
	@Column(name="RECUR_COUNT", length = 2)
    private Integer recurCount;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="RECUR_DATE")
    private Date recurDate;
	
	@Column(name="TANS_PART", length = 40)
    private String tansPart;
	
	@Column(name="KPS")
    private Double kps;
	
	@Column(name="CURRENT_CONDITION", length = 100)
    private String currentCondition;
	
	@Column(name="tc")
    private Double tc;
	
	@Column(name="MUSCLE_FORCE", length = 1)
	private String muscleForce;
	
	@Column(name="COMPLICATION", length = 100)
    private String complication;
	
	@Column(name="CHEMOTHERAPY", length = 100)
    private String chemotherapy;
    
    @Column(name="DRUG_USAGE", length = 1)
    private String drugUsage;

    @Column(name="SUPERVISOR_FLAG", length = 1)
    private String supervisorFlag;

	public PersonVisitItem() {
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

    /**
     * @return the behaviorDoctor
     */
    public String getBehaviorDoctor() {
        return behaviorDoctor;
    }

    /**
     * @param behaviorDoctor the behaviorDoctor to set
     */
    public void setBehaviorDoctor(String behaviorDoctor) {
        this.behaviorDoctor = behaviorDoctor;
    }

    /**
     * @return the bodyIndex
     */
    public Double getBodyIndex() {
        return bodyIndex;
    }

    /**
     * @param bodyIndex the bodyIndex to set
     */
    public void setBodyIndex(Double bodyIndex) {
        this.bodyIndex = bodyIndex;
    }

    /**
     * @return the diastolicBloodPressure
     */
    public Integer getDiastolicBloodPressure() {
        return diastolicBloodPressure;
    }

    /**
     * @param diastolicBloodPressure the diastolicBloodPressure to set
     */
    public void setDiastolicBloodPressure(Integer diastolicBloodPressure) {
        this.diastolicBloodPressure = diastolicBloodPressure;
    }

    /**
     * @return the drugCompliance
     */
    public String getDrugCompliance() {
        return drugCompliance;
    }

    /**
     * @param drugCompliance the drugCompliance to set
     */
    public void setDrugCompliance(String drugCompliance) {
        this.drugCompliance = drugCompliance;
    }

    /**
     * @return the drugReaction
     */
    public String getDrugReaction() {
        return drugReaction;
    }

    /**
     * @param drugReaction the drugReaction to set
     */
    public void setDrugReaction(String drugReaction) {
        this.drugReaction = drugReaction;
    }

    /**
     * @return the drugReactionOther
     */
    public String getDrugReactionOther() {
        return drugReactionOther;
    }

    /**
     * @param drugReactionOther the drugReactionOther to set
     */
    public void setDrugReactionOther(String drugReactionOther) {
        this.drugReactionOther = drugReactionOther;
    }

    /**
     * @return the eatEveryday
     */
    public Integer getEatEveryday() {
        return eatEveryday;
    }

    /**
     * @param eatEveryday the eatEveryday to set
     */
    public void setEatEveryday(Integer eatEveryday) {
        this.eatEveryday = eatEveryday;
    }

    /**
     * @return the fbgMmol
     */
    public Double getFbgMmol() {
        return fbgMmol;
    }

    /**
     * @param fbgMmol the fbgMmol to set
     */
    public void setFbgMmol(Double fbgMmol) {
        this.fbgMmol = fbgMmol;
    }

    /**
     * @return the footPulsation
     */
    public String getFootPulsation() {
        return footPulsation;
    }

    /**
     * @param footPulsation the footPulsation to set
     */
    public void setFootPulsation(String footPulsation) {
        this.footPulsation = footPulsation;
    }

    /**
     * @return the glycosylatedHemoglobin
     */
    public Integer getGlycosylatedHemoglobin() {
        return glycosylatedHemoglobin;
    }

    /**
     * @param glycosylatedHemoglobin the glycosylatedHemoglobin to set
     */
    public void setGlycosylatedHemoglobin(Integer glycosylatedHemoglobin) {
        this.glycosylatedHemoglobin = glycosylatedHemoglobin;
    }

    /**
     * @return the heartRate
     */
    public Integer getHeartRate() {
        return heartRate;
    }

    /**
     * @param heartRate the heartRate to set
     */
    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    /**
     * @return the height
     */
    public Double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Double height) {
        this.height = height;
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
     * @return the insulinType
     */
    public String getInsulinType() {
        return insulinType;
    }

    /**
     * @param insulinType the insulinType to set
     */
    public void setInsulinType(String insulinType) {
        this.insulinType = insulinType;
    }

    /**
     * @return the insulinUsage
     */
    public String getInsulinUsage() {
        return insulinUsage;
    }

    /**
     * @param insulinUsage the insulinUsage to set
     */
    public void setInsulinUsage(String insulinUsage) {
        this.insulinUsage = insulinUsage;
    }

    /**
     * @return the lowBloodSugar
     */
    public String getLowBloodSugar() {
        return lowBloodSugar;
    }

    /**
     * @param lowBloodSugar the lowBloodSugar to set
     */
    public void setLowBloodSugar(String lowBloodSugar) {
        this.lowBloodSugar = lowBloodSugar;
    }

    /**
     * @return the nextBodyIndex
     */
    public Double getNextBodyIndex() {
        return nextBodyIndex;
    }

    /**
     * @param nextBodyIndex the nextBodyIndex to set
     */
    public void setNextBodyIndex(Double nextBodyIndex) {
        this.nextBodyIndex = nextBodyIndex;
    }

    /**
     * @return the nextEatEveryday
     */
    public Integer getNextEatEveryday() {
        return nextEatEveryday;
    }

    /**
     * @param nextEatEveryday the nextEatEveryday to set
     */
    public void setNextEatEveryday(Integer nextEatEveryday) {
        this.nextEatEveryday = nextEatEveryday;
    }

    /**
     * @return the nextPhysicalTime
     */
    public Integer getNextPhysicalTime() {
        return nextPhysicalTime;
    }

    /**
     * @param nextPhysicalTime the nextPhysicalTime to set
     */
    public void setNextPhysicalTime(Integer nextPhysicalTime) {
        this.nextPhysicalTime = nextPhysicalTime;
    }

    /**
     * @return the nextPhysicalWeek
     */
    public Integer getNextPhysicalWeek() {
        return nextPhysicalWeek;
    }

    /**
     * @param nextPhysicalWeek the nextPhysicalWeek to set
     */
    public void setNextPhysicalWeek(Integer nextPhysicalWeek) {
        this.nextPhysicalWeek = nextPhysicalWeek;
    }

    /**
     * @return the nextSmokeEveryday
     */
    public Integer getNextSmokeEveryday() {
        return nextSmokeEveryday;
    }

    /**
     * @param nextSmokeEveryday the nextSmokeEveryday to set
     */
    public void setNextSmokeEveryday(Integer nextSmokeEveryday) {
        this.nextSmokeEveryday = nextSmokeEveryday;
    }

    /**
     * @return the nextWeight
     */
    public Double getNextWeight() {
        return nextWeight;
    }

    /**
     * @param nextWeight the nextWeight to set
     */
    public void setNextWeight(Double nextWeight) {
        this.nextWeight = nextWeight;
    }

    /**
     * @return the nextWineEveryday
     */
    public String getNextWineEveryday() {
        return nextWineEveryday;
    }

    /**
     * @param nextWineEveryday the nextWineEveryday to set
     */
    public void setNextWineEveryday(String nextWineEveryday) {
        this.nextWineEveryday = nextWineEveryday;
    }

    /**
     * @return the otherSign
     */
    public String getOtherSign() {
        return otherSign;
    }

    /**
     * @param otherSign the otherSign to set
     */
    public void setOtherSign(String otherSign) {
        this.otherSign = otherSign;
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
     * @return the physicalTime
     */
    public Integer getPhysicalTime() {
        return physicalTime;
    }

    /**
     * @param physicalTime the physicalTime to set
     */
    public void setPhysicalTime(Integer physicalTime) {
        this.physicalTime = physicalTime;
    }

    /**
     * @return the physicalWeek
     */
    public Integer getPhysicalWeek() {
        return physicalWeek;
    }

    /**
     * @param physicalWeek the physicalWeek to set
     */
    public void setPhysicalWeek(Integer physicalWeek) {
        this.physicalWeek = physicalWeek;
    }

    /**
     * @return the psychologicalRecovery
     */
    public String getPsychologicalRecovery() {
        return psychologicalRecovery;
    }

    /**
     * @param psychologicalRecovery the psychologicalRecovery to set
     */
    public void setPsychologicalRecovery(String psychologicalRecovery) {
        this.psychologicalRecovery = psychologicalRecovery;
    }

    /**
     * @return the smokeEveryday
     */
    public BigDecimal getSmokeEveryday() {
        return smokeEveryday;
    }

    /**
     * @param smokeEveryday the smokeEveryday to set
     */
    public void setSmokeEveryday(BigDecimal smokeEveryday) {
        this.smokeEveryday = smokeEveryday;
    }

    /**
     * @return the systolicBloodPressure
     */
    public Integer getSystolicBloodPressure() {
        return systolicBloodPressure;
    }

    /**
     * @param systolicBloodPressure the systolicBloodPressure to set
     */
    public void setSystolicBloodPressure(Integer systolicBloodPressure) {
        this.systolicBloodPressure = systolicBloodPressure;
    }

    /**
     * @return the takenSaltThick
     */
    public String getTakenSaltThick() {
        return takenSaltThick;
    }

    /**
     * @param takenSaltThick the takenSaltThick to set
     */
    public void setTakenSaltThick(String takenSaltThick) {
        this.takenSaltThick = takenSaltThick;
    }

    /**
     * @return the takenSaltThin
     */
    public String getTakenSaltThin() {
        return takenSaltThin;
    }

    /**
     * @param takenSaltThin the takenSaltThin to set
     */
    public void setTakenSaltThin(String takenSaltThin) {
        this.takenSaltThin = takenSaltThin;
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
     * @return the visitExamOther
     */
    public String getVisitExamOther() {
        return visitExamOther;
    }

    /**
     * @param visitExamOther the visitExamOther to set
     */
    public void setVisitExamOther(String visitExamOther) {
        this.visitExamOther = visitExamOther;
    }

    /**
     * @return the visitExamTime
     */
    public Date getVisitExamTime() {
        return visitExamTime;
    }

    /**
     * @param visitExamTime the visitExamTime to set
     */
    public void setVisitExamTime(Date visitExamTime) {
        this.visitExamTime = visitExamTime;
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
     * @return the visitType
     */
    public String getVisitType() {
        return visitType;
    }

    /**
     * @param visitType the visitType to set
     */
    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    /**
     * @return the weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * @return the wineEveryday
     */
    public String getWineEveryday() {
        return wineEveryday;
    }

    /**
     * @param wineEveryday the wineEveryday to set
     */
    public void setWineEveryday(String wineEveryday) {
        this.wineEveryday = wineEveryday;
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
     * @return the visitExam
     */
    public String getVisitExam() {
        return visitExam;
    }

    /**
     * @param visitExam the visitExam to set
     */
    public void setVisitExam(String visitExam) {
        this.visitExam = visitExam;
    }

    /**
     * @return the breatheExec
     */
    public String getBreatheExec() {
        return breatheExec;
    }

    /**
     * @param breatheExec the breatheExec to set
     */
    public void setBreatheExec(String breatheExec) {
        this.breatheExec = breatheExec;
    }

    /**
     * @return the cureOther
     */
    public String getCureOther() {
        return cureOther;
    }

    /**
     * @param cureOther the cureOther to set
     */
    public void setCureOther(String cureOther) {
        this.cureOther = cureOther;
    }

    /**
     * @return the recurFlag
     */
    public String getRecurFlag() {
        return recurFlag;
    }

    /**
     * @param recurFlag the recurFlag to set
     */
    public void setRecurFlag(String recurFlag) {
        this.recurFlag = recurFlag;
    }

    /**
     * @return the recurCount
     */
    public Integer getRecurCount() {
        return recurCount;
    }

    /**
     * @param recurCount the recurCount to set
     */
    public void setRecurCount(Integer recurCount) {
        this.recurCount = recurCount;
    }

    /**
     * @return the recurDate
     */
    public Date getRecurDate() {
        return recurDate;
    }

    /**
     * @param recurDate the recurDate to set
     */
    public void setRecurDate(Date recurDate) {
        this.recurDate = recurDate;
    }

    /**
     * @return the tansPart
     */
    public String getTansPart() {
        return tansPart;
    }

    /**
     * @param tansPart the tansPart to set
     */
    public void setTansPart(String tansPart) {
        this.tansPart = tansPart;
    }

    /**
     * @return the kps
     */
    public Double getKps() {
        return kps;
    }

    /**
     * @param kps the kps to set
     */
    public void setKps(Double kps) {
        this.kps = kps;
    }

    /**
     * @return the currentCondition
     */
    public String getCurrentCondition() {
        return currentCondition;
    }

    /**
     * @param currentCondition the currentCondition to set
     */
    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }

    /**
     * @return the tc
     */
    public Double getTc() {
        return tc;
    }

    /**
     * @param tc the tc to set
     */
    public void setTc(Double tc) {
        this.tc = tc;
    }

    /**
     * @return the muscleForce
     */
    public String getMuscleForce() {
        return muscleForce;
    }

    /**
     * @param muscleForce the muscleForce to set
     */
    public void setMuscleForce(String muscleForce) {
        this.muscleForce = muscleForce;
    }

    /**
     * @return the complication
     */
    public String getComplication() {
        return complication;
    }

    /**
     * @param complication the complication to set
     */
    public void setComplication(String complication) {
        this.complication = complication;
    }

    /**
     * @return the chemotherapy
     */
    public String getChemotherapy() {
        return chemotherapy;
    }

    /**
     * @param chemotherapy the chemotherapy to set
     */
    public void setChemotherapy(String chemotherapy) {
        this.chemotherapy = chemotherapy;
    }

    /**
     * @return the drugUsage
     */
    public String getDrugUsage() {
        return drugUsage;
    }

    /**
     * @param drugUsage the drugUsage to set
     */
    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage;
    }

    /**
     * @return the supervisorFlag
     */
    public String getSupervisorFlag() {
        return supervisorFlag;
    }

    /**
     * @param supervisorFlag the supervisorFlag to set
     */
    public void setSupervisorFlag(String supervisorFlag) {
        this.supervisorFlag = supervisorFlag;
    }

}