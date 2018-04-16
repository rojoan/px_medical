package com.bofan.publichealth.valueobject;

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
 * ExamPerson entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_PERSON", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "EXAM_PERSON_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".EXAM_PERSON_ID", allocationSize = 1)
public class ExamPerson implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -3172506912499944877L;
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAM_PERSON_ID")
    @Column(name = "EXAM_PERSON_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long examPersonId;
    
    @Column(name = "REGION_ID", nullable = false, length = 18)
    private String regionId;
    
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "EXAM_TIME", nullable = false)
	private Date examTime;
    
    @Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;
    
    @Column(name = "HOSPITAL_NO", nullable = false, length = 40)
	private String hospitalNo;
    
    @Column(name = "HOSPITAL_NAME", length = 80)
	private String hospitalName;
    
    @Column(name = "EXAM_BILL_NO", length = 50)
	private String examBillNo;
    
    @Column(name = "EXAMED_PERSON_NAME", length = 30)
	private String examedPersonName;
    
    @Column(name = "EXAMED_PERSON_GENDER", length = 1)
	private String examedPersonGender;
    
    @Column(name = "CUR_EXAMED_PERSON_AGE", precision = 3, scale = 0)
	private Integer curExamedPersonAge;
    
    @Column(name = "DUTY_DOCTOR_ID", precision = 18, scale = 0)
	private Long dutyDoctorId;
    
    @Column(name = "duty_doctor", precision = 18, scale = 0)
	private String dutyDoctor;
    
    @Column(name = "FREE_FLAG", length = 1)
	private String freeFlag;
    
    @Column(name = "SYMPTOM_OTHER_CONTENT", length = 100)
	private String symptomOtherContent;
    
    @Column(name = "TEMPERATURE", precision = 3, scale = 1)
	private Double temperature;
    
    @Column(name = "PULSE_RATE", precision = 3, scale = 0)
	private Integer pulseRate;
    
    @Column(name = "BREATHING_RATE", precision = 2, scale = 0)
	private Integer breathingRate;
    
    @Column(name = "BLOOD_TYPE", length = 10)
	private String bloodType;
    
    @Column(name = "LMAX_BLOOD_PRESSURE", precision = 3, scale = 0)
	private Integer lmaxBloodPressure;
    
    @Column(name = "LMIN_BLOOD_PRESSURE", precision = 3, scale = 0)
	private Integer lminBloodPressure;
    
    @Column(name = "RMAX_BLOOD_PRESSURE", precision = 3, scale = 0)
	private Integer rmaxBloodPressure;
    
    @Column(name = "RMIN_BLOOD_PRESSURE", precision = 3, scale = 0)
	private Integer rminBloodPressure;
    
    @Column(name = "HEIGHT", precision = 4, scale = 1)
	private Double height;
    
    @Column(name = "WEIGHT", precision = 4, scale = 1)
	private Double weight;
    
    @Column(name = "WAISTLINE", precision = 4, scale = 1)
	private Double waistline;
    
    @Column(name = "BODY_INDEX", precision = 8)
	private Double bodyIndex;
    
    @Column(name = "HIPLINE", precision = 4, scale = 1)
	private Double hipline;
    
    @Column(name = "WAISTLINE_RATIO", precision = 8)
	private Double waistlineRatio;
    
    @Column(name = "CREATOR_ID", nullable = false, precision = 18, scale = 0)
	private Long creatorId;
    
    @Column(name = "CREATOR_NAME", nullable = false, length = 20)
	private String creatorName;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "CREATE_TIME", nullable = false)
	private Date createTime;
    
    @Column(name = "VALID_FLAG", length = 1)
	private String validFlag;

	// Constructors

	/** default constructor */
	public ExamPerson() {
	}

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