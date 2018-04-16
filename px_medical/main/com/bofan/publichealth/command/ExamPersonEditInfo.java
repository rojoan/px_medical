package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.publichealth.valueobject.ExamElder;
import com.bofan.publichealth.valueobject.ExamHealthProblem;
import com.bofan.publichealth.valueobject.ExamLiveWay;
import com.bofan.publichealth.valueobject.ExamOrganBody;

/**
 * @Description 
 * @author xlf
 * 2017-10-26
 */
public class ExamPersonEditInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -7776152868811303401L;
    
    private Long examPersonId;
    
    private Long personDetailId;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date examTime;
    
    private Long hospitalId;
    
    private String hospitalNo;
    
    private String hospitalName;
    
    private String regionId;
    
    private String examBillNo;
    
    private String examedPersonName;
    
    private String examedPersonGender;
    
    private Integer curExamedPersonAge;
    
    private Long dutyDoctorId;
    
    private String dutyDoctor;
    
    private String freeFlag;
    
    private String symptomOtherContent;
    
    private Double temperature;
    
    private Integer pulseRate;
    
    private Integer breathingRate;
    
    private String bloodType;
    
    private Integer lmaxBloodPressure;
    
    private Integer lminBloodPressure;
    
    private Integer rmaxBloodPressure;
    
    private Integer rminBloodPressure;
    
    private Double height;
    
    private Double weight;
    
    private Double waistline;
    
    private Double bodyIndex;
    
    private Double hipline;
    
    private Double waistlineRatio;
    
    private String validFlag;
    
    /** 症状ID */
    private Long[] symptomIds;
    
    /** 饮食习惯 */
    private Long[] dietaryHabitIds;
    
    /** 饮酒种类 */
    private Long[] drinkTypeIds;
    
    /** 脑血管疾病IDS */
    private Long[] cerebrovascularDiseaseIds;
    
    /** 肾脏疾病IDS */
    private Long[] kidneyAndLiveDiseaseIds;
    
    /** 心脏疾病IDS */
    private Long[] heartDiseaseIds;
    
    /** 血管疾病IDS */
    private Long[] bloodDiseaseIds;
    
    /** 眼部疾病IDS */
    private Long[] ocularRegionDiseaseIds;
    
    /** 健康体检异常信息 */
    private String[] healthAbnormalContent;
    
    /** 健康指导类型 */
    private Long[] healthGuideTypeIds;
    
    /** 危险控制因素 */
    private Long[] healthDangerTypeIds;
    
    /** 住院治疗情况 */
    private String treatJson;
    /** 主要用药情况 */
    private String dosageJson;
    /** 非免疫规划预防接种史 */
    private String preventJson;
    
    /** 老年人  */
    private ExamElder examElder;
    
    /** 生活方式  */
    private ExamLiveWay examLiveWay;
    
    /** 查体  */
    private ExamOrganBody examOrganBody;
    
    /** 现存主要健康问题 */
    private ExamHealthProblem healthProblem;

    /**
     * @return the examPersonId
     */
    public Long getExamPersonId() {
        return examPersonId;
    }

    /**
     * @param examPersonId the examPersonId to set
     */
    public void setExamPersonId(Long examPersonId) {
        this.examPersonId = examPersonId;
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
     * @return the examTime
     */
    public Date getExamTime() {
        return examTime;
    }

    /**
     * @param examTime the examTime to set
     */
    public void setExamTime(Date examTime) {
        this.examTime = examTime;
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
     * @return the examBillNo
     */
    public String getExamBillNo() {
        return examBillNo;
    }

    /**
     * @param examBillNo the examBillNo to set
     */
    public void setExamBillNo(String examBillNo) {
        this.examBillNo = examBillNo;
    }

    /**
     * @return the examedPersonName
     */
    public String getExamedPersonName() {
        return examedPersonName;
    }

    /**
     * @param examedPersonName the examedPersonName to set
     */
    public void setExamedPersonName(String examedPersonName) {
        this.examedPersonName = examedPersonName;
    }

    /**
     * @return the examedPersonGender
     */
    public String getExamedPersonGender() {
        return examedPersonGender;
    }

    /**
     * @param examedPersonGender the examedPersonGender to set
     */
    public void setExamedPersonGender(String examedPersonGender) {
        this.examedPersonGender = examedPersonGender;
    }

    /**
     * @return the curExamedPersonAge
     */
    public Integer getCurExamedPersonAge() {
        return curExamedPersonAge;
    }

    /**
     * @param curExamedPersonAge the curExamedPersonAge to set
     */
    public void setCurExamedPersonAge(Integer curExamedPersonAge) {
        this.curExamedPersonAge = curExamedPersonAge;
    }

    /**
     * @return the dutyDoctorId
     */
    public Long getDutyDoctorId() {
        return dutyDoctorId;
    }

    /**
     * @param dutyDoctorId the dutyDoctorId to set
     */
    public void setDutyDoctorId(Long dutyDoctorId) {
        this.dutyDoctorId = dutyDoctorId;
    }

    /**
     * @return the dutyDoctor
     */
    public String getDutyDoctor() {
        return dutyDoctor;
    }

    /**
     * @param dutyDoctor the dutyDoctor to set
     */
    public void setDutyDoctor(String dutyDoctor) {
        this.dutyDoctor = dutyDoctor;
    }

    /**
     * @return the freeFlag
     */
    public String getFreeFlag() {
        return freeFlag;
    }

    /**
     * @param freeFlag the freeFlag to set
     */
    public void setFreeFlag(String freeFlag) {
        this.freeFlag = freeFlag;
    }

    /**
     * @return the symptomOtherContent
     */
    public String getSymptomOtherContent() {
        return symptomOtherContent;
    }

    /**
     * @param symptomOtherContent the symptomOtherContent to set
     */
    public void setSymptomOtherContent(String symptomOtherContent) {
        this.symptomOtherContent = symptomOtherContent;
    }

    /**
     * @return the temperature
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the pulseRate
     */
    public Integer getPulseRate() {
        return pulseRate;
    }

    /**
     * @param pulseRate the pulseRate to set
     */
    public void setPulseRate(Integer pulseRate) {
        this.pulseRate = pulseRate;
    }

    /**
     * @return the breathingRate
     */
    public Integer getBreathingRate() {
        return breathingRate;
    }

    /**
     * @param breathingRate the breathingRate to set
     */
    public void setBreathingRate(Integer breathingRate) {
        this.breathingRate = breathingRate;
    }

    /**
     * @return the bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * @param bloodType the bloodType to set
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * @return the lmaxBloodPressure
     */
    public Integer getLmaxBloodPressure() {
        return lmaxBloodPressure;
    }

    /**
     * @param lmaxBloodPressure the lmaxBloodPressure to set
     */
    public void setLmaxBloodPressure(Integer lmaxBloodPressure) {
        this.lmaxBloodPressure = lmaxBloodPressure;
    }

    /**
     * @return the lminBloodPressure
     */
    public Integer getLminBloodPressure() {
        return lminBloodPressure;
    }

    /**
     * @param lminBloodPressure the lminBloodPressure to set
     */
    public void setLminBloodPressure(Integer lminBloodPressure) {
        this.lminBloodPressure = lminBloodPressure;
    }

    /**
     * @return the rmaxBloodPressure
     */
    public Integer getRmaxBloodPressure() {
        return rmaxBloodPressure;
    }

    /**
     * @param rmaxBloodPressure the rmaxBloodPressure to set
     */
    public void setRmaxBloodPressure(Integer rmaxBloodPressure) {
        this.rmaxBloodPressure = rmaxBloodPressure;
    }

    /**
     * @return the rminBloodPressure
     */
    public Integer getRminBloodPressure() {
        return rminBloodPressure;
    }

    /**
     * @param rminBloodPressure the rminBloodPressure to set
     */
    public void setRminBloodPressure(Integer rminBloodPressure) {
        this.rminBloodPressure = rminBloodPressure;
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
     * @return the waistline
     */
    public Double getWaistline() {
        return waistline;
    }

    /**
     * @param waistline the waistline to set
     */
    public void setWaistline(Double waistline) {
        this.waistline = waistline;
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
     * @return the hipline
     */
    public Double getHipline() {
        return hipline;
    }

    /**
     * @param hipline the hipline to set
     */
    public void setHipline(Double hipline) {
        this.hipline = hipline;
    }

    /**
     * @return the waistlineRatio
     */
    public Double getWaistlineRatio() {
        return waistlineRatio;
    }

    /**
     * @param waistlineRatio the waistlineRatio to set
     */
    public void setWaistlineRatio(Double waistlineRatio) {
        this.waistlineRatio = waistlineRatio;
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
     * @return the drinkTypeIds
     */
    public Long[] getDrinkTypeIds() {
        return drinkTypeIds;
    }

    /**
     * @param drinkTypeIds the drinkTypeIds to set
     */
    public void setDrinkTypeIds(Long[] drinkTypeIds) {
        this.drinkTypeIds = drinkTypeIds;
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
     * @return the dietaryHabitIds
     */
    public Long[] getDietaryHabitIds() {
        return dietaryHabitIds;
    }

    /**
     * @param dietaryHabitIds the dietaryHabitIds to set
     */
    public void setDietaryHabitIds(Long[] dietaryHabitIds) {
        this.dietaryHabitIds = dietaryHabitIds;
    }

    /**
     * @return the cerebrovascularDiseaseIds
     */
    public Long[] getCerebrovascularDiseaseIds() {
        return cerebrovascularDiseaseIds;
    }

    /**
     * @param cerebrovascularDiseaseIds the cerebrovascularDiseaseIds to set
     */
    public void setCerebrovascularDiseaseIds(Long[] cerebrovascularDiseaseIds) {
        this.cerebrovascularDiseaseIds = cerebrovascularDiseaseIds;
    }

    /**
     * @return the kidneyAndLiveDiseaseIds
     */
    public Long[] getKidneyAndLiveDiseaseIds() {
        return kidneyAndLiveDiseaseIds;
    }

    /**
     * @param kidneyAndLiveDiseaseIds the kidneyAndLiveDiseaseIds to set
     */
    public void setKidneyAndLiveDiseaseIds(Long[] kidneyAndLiveDiseaseIds) {
        this.kidneyAndLiveDiseaseIds = kidneyAndLiveDiseaseIds;
    }

    /**
     * @return the heartDiseaseIds
     */
    public Long[] getHeartDiseaseIds() {
        return heartDiseaseIds;
    }

    /**
     * @param heartDiseaseIds the heartDiseaseIds to set
     */
    public void setHeartDiseaseIds(Long[] heartDiseaseIds) {
        this.heartDiseaseIds = heartDiseaseIds;
    }

    /**
     * @return the bloodDiseaseIds
     */
    public Long[] getBloodDiseaseIds() {
        return bloodDiseaseIds;
    }

    /**
     * @param bloodDiseaseIds the bloodDiseaseIds to set
     */
    public void setBloodDiseaseIds(Long[] bloodDiseaseIds) {
        this.bloodDiseaseIds = bloodDiseaseIds;
    }

    /**
     * @return the ocularRegionDiseaseIds
     */
    public Long[] getOcularRegionDiseaseIds() {
        return ocularRegionDiseaseIds;
    }

    /**
     * @param ocularRegionDiseaseIds the ocularRegionDiseaseIds to set
     */
    public void setOcularRegionDiseaseIds(Long[] ocularRegionDiseaseIds) {
        this.ocularRegionDiseaseIds = ocularRegionDiseaseIds;
    }

    /**
     * @return the healthAbnormalContent
     */
    public String[] getHealthAbnormalContent() {
        return healthAbnormalContent;
    }

    /**
     * @param healthAbnormalContent the healthAbnormalContent to set
     */
    public void setHealthAbnormalContent(String[] healthAbnormalContent) {
        this.healthAbnormalContent = healthAbnormalContent;
    }

    /**
     * @return the healthGuideTypeIds
     */
    public Long[] getHealthGuideTypeIds() {
        return healthGuideTypeIds;
    }

    /**
     * @param healthGuideTypeIds the healthGuideTypeIds to set
     */
    public void setHealthGuideTypeIds(Long[] healthGuideTypeIds) {
        this.healthGuideTypeIds = healthGuideTypeIds;
    }

    /**
     * @return the healthDangerTypeIds
     */
    public Long[] getHealthDangerTypeIds() {
        return healthDangerTypeIds;
    }

    /**
     * @param healthDangerTypeIds the healthDangerTypeIds to set
     */
    public void setHealthDangerTypeIds(Long[] healthDangerTypeIds) {
        this.healthDangerTypeIds = healthDangerTypeIds;
    }

    /**
     * @return the treatJson
     */
    public String getTreatJson() {
        return treatJson;
    }

    /**
     * @param treatJson the treatJson to set
     */
    public void setTreatJson(String treatJson) {
        this.treatJson = treatJson;
    }

    /**
     * @return the dosageJson
     */
    public String getDosageJson() {
        return dosageJson;
    }

    /**
     * @param dosageJson the dosageJson to set
     */
    public void setDosageJson(String dosageJson) {
        this.dosageJson = dosageJson;
    }

    /**
     * @return the preventJson
     */
    public String getPreventJson() {
        return preventJson;
    }

    /**
     * @param preventJson the preventJson to set
     */
    public void setPreventJson(String preventJson) {
        this.preventJson = preventJson;
    }

    /**
     * @return the examElder
     */
    public ExamElder getExamElder() {
        return examElder;
    }

    /**
     * @param examElder the examElder to set
     */
    public void setExamElder(ExamElder examElder) {
        this.examElder = examElder;
    }

    /**
     * @return the examLiveWay
     */
    public ExamLiveWay getExamLiveWay() {
        return examLiveWay;
    }

    /**
     * @param examLiveWay the examLiveWay to set
     */
    public void setExamLiveWay(ExamLiveWay examLiveWay) {
        this.examLiveWay = examLiveWay;
    }

    /**
     * @return the examOrganBody
     */
    public ExamOrganBody getExamOrganBody() {
        return examOrganBody;
    }

    /**
     * @param examOrganBody the examOrganBody to set
     */
    public void setExamOrganBody(ExamOrganBody examOrganBody) {
        this.examOrganBody = examOrganBody;
    }

    /**
     * @return the healthProblem
     */
    public ExamHealthProblem getHealthProblem() {
        return healthProblem;
    }

    /**
     * @param healthProblem the healthProblem to set
     */
    public void setHealthProblem(ExamHealthProblem healthProblem) {
        this.healthProblem = healthProblem;
    }

}
