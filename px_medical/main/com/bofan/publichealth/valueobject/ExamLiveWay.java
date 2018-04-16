package com.bofan.publichealth.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * ExamLiveWay entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_LIVE_WAY", schema = SchemaConsts.PUBLIC_HEALTH)
public class ExamLiveWay implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 905727741015199932L;
    // Fields

    @Id
    @Column(name = "EXAM_PERSON_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long examPersonId;
    
    @Column(name = "EXAM_TIME")
	private Date examTime;
    
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
    
    @Column(name = "EXE_FREQUENCY", length = 1)
	private String exeFrequency;
    
    @Column(name = "EXE_TIME_EVERY", length = 20)
	private String exeTimeEvery;
    
    @Column(name = "EXE_TIME_YEAR", length = 20)
	private String exeTimeYear;
    
    @Column(name = "EXE_TYPE", length = 20)
	private String exeType;
    
    @Column(name = "SMOKE_STATE", length = 1)
	private String smokeState;
    
    @Column(name = "SMOKE_DAY", precision = 18, scale = 0)
	private Long smokeDay;
    
    @Column(name = "SMOKE_START_AGE", precision = 18, scale = 0)
	private Long smokeStartAge;
    
    @Column(name = "GIVE_UP_SMOKE_AGE", precision = 18, scale = 0)
	private Long giveUpSmokeAge;
    
    @Column(name = "DRINK_FREQUENCY", length = 1)
	private String drinkFrequency;
    
    @Column(name = "DRINK_DAY", precision = 18, scale = 0)
	private Long drinkDay;
    
    @Column(name = "DRINK_START_AGE", precision = 18, scale = 0)
	private Long drinkStartAge;
    
    @Column(name = "GIVE_UP_DRINK", length = 1)
	private String giveUpDrink;
    
    @Column(name = "GIVE_UP_DRINK_AGE", precision = 18, scale = 0)
	private Long giveUpDrinkAge;
    
    @Column(name = "OTHER_DRINK_TYPE", length = 40)
	private String otherDrinkType;
    
    @Column(name = "NEAR_YEAR_DRUNK", length = 1)
	private String nearYearDrunk;
    
    @Column(name = "HARM_CAREER_FLAG", length = 1)
	private String harmCareerFlag;
    
    @Column(name = "HARM_CAREER", length = 1)
	private String harmCareer;
    
    @Column(name = "HARM_CAREER_AGE", length = 20)
	private String harmCareerAge;
    
    @Column(name = "DUST_FACTOR", length = 40)
	private String dustFactor;
    
    @Column(name = "DUST_FLAG", length = 1)
	private String dustFlag;
    
    @Column(name = "DUST_DEFEND", length = 100)
	private String dustDefend;
    
    @Column(name = "RAY_FACTOR", length = 40)
	private String rayFactor;
    
    @Column(name = "RAY_FLAG", length = 1)
	private String rayFlag;
    
    @Column(name = "RAY_DEFEND", length = 100)
	private String rayDefend;
    
    @Column(name = "PHYSICS_FACTOR", length = 40)
	private String physicsFactor;
    
    @Column(name = "PHYSICS_FLAG", length = 1)
	private String physicsFlag;
    
    @Column(name = "PHYSICS_DEFEND", length = 100)
	private String physicsDefend;
    
    @Column(name = "CHEM_FACTOR", length = 40)
	private String chemFactor;
    
    @Column(name = "CHEM_FLAG", length = 1)
	private String chemFlag;
    
    @Column(name = "CHEM_DEFEND", length = 100)
	private String chemDefend;
    
    @Column(name = "OTHER_FACTOR", length = 40)
	private String otherFactor;
    
    @Column(name = "OTHER_FLAG", length = 1)
	private String otherFlag;
    
    @Column(name = "OTHER_DEFEND", length = 100)
	private String otherDefend;

	// Constructors

	/** default constructor */
	public ExamLiveWay() {
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
     * @return the exeFrequency
     */
    public String getExeFrequency() {
        return exeFrequency;
    }

    /**
     * @param exeFrequency the exeFrequency to set
     */
    public void setExeFrequency(String exeFrequency) {
        this.exeFrequency = exeFrequency;
    }

    /**
     * @return the exeTimeEvery
     */
    public String getExeTimeEvery() {
        return exeTimeEvery;
    }

    /**
     * @param exeTimeEvery the exeTimeEvery to set
     */
    public void setExeTimeEvery(String exeTimeEvery) {
        this.exeTimeEvery = exeTimeEvery;
    }

    /**
     * @return the exeTimeYear
     */
    public String getExeTimeYear() {
        return exeTimeYear;
    }

    /**
     * @param exeTimeYear the exeTimeYear to set
     */
    public void setExeTimeYear(String exeTimeYear) {
        this.exeTimeYear = exeTimeYear;
    }

    /**
     * @return the exeType
     */
    public String getExeType() {
        return exeType;
    }

    /**
     * @param exeType the exeType to set
     */
    public void setExeType(String exeType) {
        this.exeType = exeType;
    }

    /**
     * @return the smokeState
     */
    public String getSmokeState() {
        return smokeState;
    }

    /**
     * @param smokeState the smokeState to set
     */
    public void setSmokeState(String smokeState) {
        this.smokeState = smokeState;
    }

    /**
     * @return the smokeDay
     */
    public Long getSmokeDay() {
        return smokeDay;
    }

    /**
     * @param smokeDay the smokeDay to set
     */
    public void setSmokeDay(Long smokeDay) {
        this.smokeDay = smokeDay;
    }

    /**
     * @return the smokeStartAge
     */
    public Long getSmokeStartAge() {
        return smokeStartAge;
    }

    /**
     * @param smokeStartAge the smokeStartAge to set
     */
    public void setSmokeStartAge(Long smokeStartAge) {
        this.smokeStartAge = smokeStartAge;
    }

    /**
     * @return the giveUpSmokeAge
     */
    public Long getGiveUpSmokeAge() {
        return giveUpSmokeAge;
    }

    /**
     * @param giveUpSmokeAge the giveUpSmokeAge to set
     */
    public void setGiveUpSmokeAge(Long giveUpSmokeAge) {
        this.giveUpSmokeAge = giveUpSmokeAge;
    }

    /**
     * @return the drinkFrequency
     */
    public String getDrinkFrequency() {
        return drinkFrequency;
    }

    /**
     * @param drinkFrequency the drinkFrequency to set
     */
    public void setDrinkFrequency(String drinkFrequency) {
        this.drinkFrequency = drinkFrequency;
    }

    /**
     * @return the drinkDay
     */
    public Long getDrinkDay() {
        return drinkDay;
    }

    /**
     * @param drinkDay the drinkDay to set
     */
    public void setDrinkDay(Long drinkDay) {
        this.drinkDay = drinkDay;
    }

    /**
     * @return the drinkStartAge
     */
    public Long getDrinkStartAge() {
        return drinkStartAge;
    }

    /**
     * @param drinkStartAge the drinkStartAge to set
     */
    public void setDrinkStartAge(Long drinkStartAge) {
        this.drinkStartAge = drinkStartAge;
    }

    /**
     * @return the giveUpDrink
     */
    public String getGiveUpDrink() {
        return giveUpDrink;
    }

    /**
     * @param giveUpDrink the giveUpDrink to set
     */
    public void setGiveUpDrink(String giveUpDrink) {
        this.giveUpDrink = giveUpDrink;
    }

    /**
     * @return the giveUpDrinkAge
     */
    public Long getGiveUpDrinkAge() {
        return giveUpDrinkAge;
    }

    /**
     * @param giveUpDrinkAge the giveUpDrinkAge to set
     */
    public void setGiveUpDrinkAge(Long giveUpDrinkAge) {
        this.giveUpDrinkAge = giveUpDrinkAge;
    }

    /**
     * @return the otherDrinkType
     */
    public String getOtherDrinkType() {
        return otherDrinkType;
    }

    /**
     * @param otherDrinkType the otherDrinkType to set
     */
    public void setOtherDrinkType(String otherDrinkType) {
        this.otherDrinkType = otherDrinkType;
    }

    /**
     * @return the nearYearDrunk
     */
    public String getNearYearDrunk() {
        return nearYearDrunk;
    }

    /**
     * @param nearYearDrunk the nearYearDrunk to set
     */
    public void setNearYearDrunk(String nearYearDrunk) {
        this.nearYearDrunk = nearYearDrunk;
    }

    /**
     * @return the harmCareerFlag
     */
    public String getHarmCareerFlag() {
        return harmCareerFlag;
    }

    /**
     * @param harmCareerFlag the harmCareerFlag to set
     */
    public void setHarmCareerFlag(String harmCareerFlag) {
        this.harmCareerFlag = harmCareerFlag;
    }

    /**
     * @return the harmCareer
     */
    public String getHarmCareer() {
        return harmCareer;
    }

    /**
     * @param harmCareer the harmCareer to set
     */
    public void setHarmCareer(String harmCareer) {
        this.harmCareer = harmCareer;
    }

    /**
     * @return the harmCareerAge
     */
    public String getHarmCareerAge() {
        return harmCareerAge;
    }

    /**
     * @param harmCareerAge the harmCareerAge to set
     */
    public void setHarmCareerAge(String harmCareerAge) {
        this.harmCareerAge = harmCareerAge;
    }

    /**
     * @return the dustFactor
     */
    public String getDustFactor() {
        return dustFactor;
    }

    /**
     * @param dustFactor the dustFactor to set
     */
    public void setDustFactor(String dustFactor) {
        this.dustFactor = dustFactor;
    }

    /**
     * @return the dustFlag
     */
    public String getDustFlag() {
        return dustFlag;
    }

    /**
     * @param dustFlag the dustFlag to set
     */
    public void setDustFlag(String dustFlag) {
        this.dustFlag = dustFlag;
    }

    /**
     * @return the dustDefend
     */
    public String getDustDefend() {
        return dustDefend;
    }

    /**
     * @param dustDefend the dustDefend to set
     */
    public void setDustDefend(String dustDefend) {
        this.dustDefend = dustDefend;
    }

    /**
     * @return the rayFactor
     */
    public String getRayFactor() {
        return rayFactor;
    }

    /**
     * @param rayFactor the rayFactor to set
     */
    public void setRayFactor(String rayFactor) {
        this.rayFactor = rayFactor;
    }

    /**
     * @return the rayFlag
     */
    public String getRayFlag() {
        return rayFlag;
    }

    /**
     * @param rayFlag the rayFlag to set
     */
    public void setRayFlag(String rayFlag) {
        this.rayFlag = rayFlag;
    }

    /**
     * @return the rayDefend
     */
    public String getRayDefend() {
        return rayDefend;
    }

    /**
     * @param rayDefend the rayDefend to set
     */
    public void setRayDefend(String rayDefend) {
        this.rayDefend = rayDefend;
    }

    /**
     * @return the physicsFactor
     */
    public String getPhysicsFactor() {
        return physicsFactor;
    }

    /**
     * @param physicsFactor the physicsFactor to set
     */
    public void setPhysicsFactor(String physicsFactor) {
        this.physicsFactor = physicsFactor;
    }

    /**
     * @return the physicsFlag
     */
    public String getPhysicsFlag() {
        return physicsFlag;
    }

    /**
     * @param physicsFlag the physicsFlag to set
     */
    public void setPhysicsFlag(String physicsFlag) {
        this.physicsFlag = physicsFlag;
    }

    /**
     * @return the physicsDefend
     */
    public String getPhysicsDefend() {
        return physicsDefend;
    }

    /**
     * @param physicsDefend the physicsDefend to set
     */
    public void setPhysicsDefend(String physicsDefend) {
        this.physicsDefend = physicsDefend;
    }

    /**
     * @return the chemFactor
     */
    public String getChemFactor() {
        return chemFactor;
    }

    /**
     * @param chemFactor the chemFactor to set
     */
    public void setChemFactor(String chemFactor) {
        this.chemFactor = chemFactor;
    }

    /**
     * @return the chemFlag
     */
    public String getChemFlag() {
        return chemFlag;
    }

    /**
     * @param chemFlag the chemFlag to set
     */
    public void setChemFlag(String chemFlag) {
        this.chemFlag = chemFlag;
    }

    /**
     * @return the chemDefend
     */
    public String getChemDefend() {
        return chemDefend;
    }

    /**
     * @param chemDefend the chemDefend to set
     */
    public void setChemDefend(String chemDefend) {
        this.chemDefend = chemDefend;
    }

    /**
     * @return the otherFactor
     */
    public String getOtherFactor() {
        return otherFactor;
    }

    /**
     * @param otherFactor the otherFactor to set
     */
    public void setOtherFactor(String otherFactor) {
        this.otherFactor = otherFactor;
    }

    /**
     * @return the otherFlag
     */
    public String getOtherFlag() {
        return otherFlag;
    }

    /**
     * @param otherFlag the otherFlag to set
     */
    public void setOtherFlag(String otherFlag) {
        this.otherFlag = otherFlag;
    }

    /**
     * @return the otherDefend
     */
    public String getOtherDefend() {
        return otherDefend;
    }

    /**
     * @param otherDefend the otherDefend to set
     */
    public void setOtherDefend(String otherDefend) {
        this.otherDefend = otherDefend;
    }

	// Property accessors
	

}