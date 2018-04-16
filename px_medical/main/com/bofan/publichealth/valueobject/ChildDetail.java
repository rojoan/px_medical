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
 * ChildDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CHILD_DETAIL", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "CHILD_DETAIL_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".CHILD_DETAIL_ID", allocationSize = 1)
public class ChildDetail implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -8160032453648042786L;
    // Fields

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHILD_DETAIL_ID")
    @Column(name = "CHILD_DETAIL_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long childDetailId;
    
    @Column(name = "FAMILY_DETAIL_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long familyDetailId;
    
    @Column(name = "PATIENT_ID", precision = 18, scale = 0)
	private Long patientId;
    
    @Column(name = "BIRTH_LOC_TYPE", length = 1)
	private String birthLocType;
    
    @Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;
    
    @Column(name = "HOSPITAL_NO", nullable = false, length = 40)
	private String hospitalNo;
    
    @Column(name = "HOSPITAL_NAME", length = 80)
	private String hospitalName;
    
    @Column(name = "NEW_BORN", nullable = false, length = 1)
	private String newBorn;
    
    @Column(name = "BIRTH_ATTENDANT", length = 20)
	private String birthAttendant;
    
    @Column(name = "CHILD_NAME", length = 20)
	private String childName;
    
    @Column(name = "HEALTHBOOK_FLAG", length = 1)
	private String healthbookFlag;
    
    @Column(name = "BIRTH_CERT", length = 20)
	private String birthCert;
    
    @Column(name = "BIRTH_CERT_DATE")
	private Date birthCertDate;
    
    @Column(name = "BIRTH_CERT_PERSON", length = 20)
	private String birthCertPerson;
    
    @Column(name = "GENDER", length = 1)
	private String gender;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @Column(name = "BIRTH_DATE")
	private Date birthDate;
    
    @Column(name = "REGION_ID", length = 18)
	private String regionId;
    
    @Column(name = "FAMILY_ADDR", length = 200)
	private String familyAddr;
    
    @Column(name = "COMMITTEE_ID", nullable = false, precision = 18, scale = 0)
	private Long committeeId;
    
    @Column(name = "COMMITTEE_NAME", nullable = false, length = 200)
	private String committeeName;
    
    @Column(name = "FATHER_NAME", length = 20)
	private String fatherName;
    
    @Column(name = "FATHER_BIRTH")
	private Date fatherBirth;
    
    @Column(name = "FATHER_CAREER", length = 20)
	private String fatherCareer;
    
    @Column(name = "FATHER_NATION", precision = 18, scale = 0)
	private Long fatherNation;
    
    @Column(name = "FATHER_COUNTRY", length = 100)
	private String fatherCountry;
    
    @Column(name = "FATHER_PHONE", length = 40)
	private String fatherPhone;
    
    @Column(name = "FATHER_WORK_ORG", length = 100)
	private String fatherWorkOrg;
    
    @Column(name = "FATHER_ADDR", length = 200)
	private String fatherAddr;
    
    @Column(name = "FATHER_CRET_TYPE", length = 1)
	private String fatherCretType;
    
    @Column(name = "FATHER_CRET", length = 50)
	private String fatherCret;
    
    @Column(name = "MOTHER_NAME", length = 20)
	private String motherName;
    
    @Column(name = "MOTHER_BIRTH")
	private Date motherBirth;
    
    @Column(name = "MOTHER_CAREER", length = 20)
	private String motherCareer;
    
    @Column(name = "MOTHER_NATION", precision = 18, scale = 0)
	private Long motherNation;
    
    @Column(name = "MOTHER_COUNTRY", length = 100)
	private String motherCountry;
    
    @Column(name = "MOTHER_PHONE", length = 40)
	private String motherPhone;
    
    @Column(name = "MOTHER_WORK_ORG", length = 100)
	private String motherWorkOrg;
    
    @Column(name = "MOTHER_ADDR", length = 200)
	private String motherAddr;
    
    @Column(name = "MOTHER_CRET_TYPE", length = 1)
	private String motherCretType;
    
    @Column(name = "MOTHER_CRET", length = 50)
	private String motherCret;
    
    @Column(name = "FETATION_AGE", length = 20)
	private String fetationAge;
    
    @Column(name = "HEALTH_FLAG", length = 1)
	private String healthFlag;
    
    @Column(name = "FETATION_FLAG", length = 1)
	private String fetationFlag;
    
    @Column(name = "FETATION_OTHER", length = 100)
	private String fetationOther;
    
    @Column(name = "BIRTH_WEIGHT", precision = 18)
	private Double birthWeight;
    
    @Column(name = "BIRTH_HEIGHT", precision = 18)
	private Double birthHeight;
    
    @Column(name = "BIRTH_CONDITION", length = 1)
	private String birthCondition;
    
    @Column(name = "BIRTH_STIFLE", length = 1)
    private String birthStifle;
    
    @Column(name = "BIRTH_STIFLE_DESC", length = 100)
    private String birthStifleDesc;
    
    @Column(name = "BIRTH_OTHER", length = 20)
	private String birthOther;
    
    @Column(name = "HEAD_SIZE", precision = 18)
	private Double headSize;
    
    @Column(name = "CHEST_SIZE", precision = 18)
	private Double chestSize;

    @Column(name = "APG_SCORE_ONE", length = 20)
	private String apgScoreOne;
    
    @Column(name = "APG_SCORE_FIVE", length = 20)
	private String apgScoreFive;
    
    @Column(name = "APG_SCORE_OTHER", length = 20)
	private String apgScoreOther;
    
    @Column(name = "BIRTH_DEFECT", length = 1)
	private String birthDefect;
    
    @Column(name = "BIRTH_DEFECT_OTHER", length = 100)
	private String birthDefectOther;
    
    @Column(name = "DISEASE_SCREENING", length = 1)
	private String diseaseScreening;
    
    @Column(name = "DISEASE_SCREENING_OTHER", length = 100)
	private String diseaseScreeningOther;
    
    @Column(name = "BLOOD", length = 20)
	private String blood;
    
    @Column(name = "HEAR_SCREENING", length = 1)
	private String hearScreening;
    
    @Column(name = "WEAK_FLAG", length = 1)
	private String weakFlag;
    
    @Column(name = "FAMILY_DISEASE", length = 100)
	private String familyDisease;
    
    @Column(name = "FAMILY_REL", length = 20)
	private String familyRel;
    
    @Column(name = "DRUG_ALLERGY", length = 50)
	private String drugAllergy;
   
    /** 新生儿--卡介苗 1=已种 0=未种 */
    @Column(name = "BCG_VACCINE", length = 1)
    private String bcgVaccine;
    
    /** 新生儿--乙肝疫苗 */
    @Column(name = "HEPATITIS_B_VACCINE", length = 1)
    private String hepatitisBVaccine;
    
    @Column(name = "CREATOR_ID", nullable = false, precision = 18, scale = 0)
	private Long creatorId;
    
    @Column(name = "CREATOR_NAME", nullable = false, length = 20)
	private String creatorName;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
    @Column(name = "CREATE_TIME", nullable = false, length = 7)
	private Date createTime;
    
    @Column(name = "MOVE_FLAG", nullable = false, length = 1)
	private String moveFlag;
    
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
    private String validFlag;
    

	// Constructors

	/** default constructor */
	public ChildDetail() {
	    
	}
	// Property accessors

    /**
     * @return the childDetailId
     */
    public Long getChildDetailId() {
        return childDetailId;
    }

    /**
     * @param childDetailId the childDetailId to set
     */
    public void setChildDetailId(Long childDetailId) {
        this.childDetailId = childDetailId;
    }

    /**
     * @return the familyDetailId
     */
    public Long getFamilyDetailId() {
        return familyDetailId;
    }

    /**
     * @param familyDetailId the familyDetailId to set
     */
    public void setFamilyDetailId(Long familyDetailId) {
        this.familyDetailId = familyDetailId;
    }

    /**
     * @return the patientId
     */
    public Long getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the birthLocType
     */
    public String getBirthLocType() {
        return birthLocType;
    }

    /**
     * @param birthLocType the birthLocType to set
     */
    public void setBirthLocType(String birthLocType) {
        this.birthLocType = birthLocType;
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
     * @return the newBorn
     */
    public String getNewBorn() {
        return newBorn;
    }

    /**
     * @param newBorn the newBorn to set
     */
    public void setNewBorn(String newBorn) {
        this.newBorn = newBorn;
    }

    /**
     * @return the birthAttendant
     */
    public String getBirthAttendant() {
        return birthAttendant;
    }

    /**
     * @param birthAttendant the birthAttendant to set
     */
    public void setBirthAttendant(String birthAttendant) {
        this.birthAttendant = birthAttendant;
    }

    /**
     * @return the childName
     */
    public String getChildName() {
        return childName;
    }

    /**
     * @param childName the childName to set
     */
    public void setChildName(String childName) {
        this.childName = childName;
    }

    /**
     * @return the healthbookFlag
     */
    public String getHealthbookFlag() {
        return healthbookFlag;
    }

    /**
     * @param healthbookFlag the healthbookFlag to set
     */
    public void setHealthbookFlag(String healthbookFlag) {
        this.healthbookFlag = healthbookFlag;
    }

    /**
     * @return the birthCert
     */
    public String getBirthCert() {
        return birthCert;
    }

    /**
     * @param birthCert the birthCert to set
     */
    public void setBirthCert(String birthCert) {
        this.birthCert = birthCert;
    }

    /**
     * @return the birthCertDate
     */
    public Date getBirthCertDate() {
        return birthCertDate;
    }

    /**
     * @param birthCertDate the birthCertDate to set
     */
    public void setBirthCertDate(Date birthCertDate) {
        this.birthCertDate = birthCertDate;
    }

    /**
     * @return the birthCertPerson
     */
    public String getBirthCertPerson() {
        return birthCertPerson;
    }

    /**
     * @param birthCertPerson the birthCertPerson to set
     */
    public void setBirthCertPerson(String birthCertPerson) {
        this.birthCertPerson = birthCertPerson;
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
     * @return the familyAddr
     */
    public String getFamilyAddr() {
        return familyAddr;
    }

    /**
     * @param familyAddr the familyAddr to set
     */
    public void setFamilyAddr(String familyAddr) {
        this.familyAddr = familyAddr;
    }

    /**
     * @return the committeeId
     */
    public Long getCommitteeId() {
        return committeeId;
    }

    /**
     * @param committeeId the committeeId to set
     */
    public void setCommitteeId(Long committeeId) {
        this.committeeId = committeeId;
    }

    /**
     * @return the committeeName
     */
    public String getCommitteeName() {
        return committeeName;
    }

    /**
     * @param committeeName the committeeName to set
     */
    public void setCommitteeName(String committeeName) {
        this.committeeName = committeeName;
    }

    /**
     * @return the fatherName
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @param fatherName the fatherName to set
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    /**
     * @return the fatherBirth
     */
    public Date getFatherBirth() {
        return fatherBirth;
    }

    /**
     * @param fatherBirth the fatherBirth to set
     */
    public void setFatherBirth(Date fatherBirth) {
        this.fatherBirth = fatherBirth;
    }

    /**
     * @return the fatherCareer
     */
    public String getFatherCareer() {
        return fatherCareer;
    }

    /**
     * @param fatherCareer the fatherCareer to set
     */
    public void setFatherCareer(String fatherCareer) {
        this.fatherCareer = fatherCareer;
    }

    /**
     * @return the fatherNation
     */
    public Long getFatherNation() {
        return fatherNation;
    }

    /**
     * @param fatherNation the fatherNation to set
     */
    public void setFatherNation(Long fatherNation) {
        this.fatherNation = fatherNation;
    }

    /**
     * @return the fatherCountry
     */
    public String getFatherCountry() {
        return fatherCountry;
    }

    /**
     * @param fatherCountry the fatherCountry to set
     */
    public void setFatherCountry(String fatherCountry) {
        this.fatherCountry = fatherCountry;
    }

    /**
     * @return the fatherPhone
     */
    public String getFatherPhone() {
        return fatherPhone;
    }

    /**
     * @param fatherPhone the fatherPhone to set
     */
    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    /**
     * @return the fatherWorkOrg
     */
    public String getFatherWorkOrg() {
        return fatherWorkOrg;
    }

    /**
     * @param fatherWorkOrg the fatherWorkOrg to set
     */
    public void setFatherWorkOrg(String fatherWorkOrg) {
        this.fatherWorkOrg = fatherWorkOrg;
    }

    /**
     * @return the fatherAddr
     */
    public String getFatherAddr() {
        return fatherAddr;
    }

    /**
     * @param fatherAddr the fatherAddr to set
     */
    public void setFatherAddr(String fatherAddr) {
        this.fatherAddr = fatherAddr;
    }

    /**
     * @return the fatherCretType
     */
    public String getFatherCretType() {
        return fatherCretType;
    }

    /**
     * @param fatherCretType the fatherCretType to set
     */
    public void setFatherCretType(String fatherCretType) {
        this.fatherCretType = fatherCretType;
    }

    /**
     * @return the fatherCret
     */
    public String getFatherCret() {
        return fatherCret;
    }

    /**
     * @param fatherCret the fatherCret to set
     */
    public void setFatherCret(String fatherCret) {
        this.fatherCret = fatherCret;
    }

    /**
     * @return the motherName
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * @param motherName the motherName to set
     */
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    /**
     * @return the motherBirth
     */
    public Date getMotherBirth() {
        return motherBirth;
    }

    /**
     * @param motherBirth the motherBirth to set
     */
    public void setMotherBirth(Date motherBirth) {
        this.motherBirth = motherBirth;
    }

    /**
     * @return the motherCareer
     */
    public String getMotherCareer() {
        return motherCareer;
    }

    /**
     * @param motherCareer the motherCareer to set
     */
    public void setMotherCareer(String motherCareer) {
        this.motherCareer = motherCareer;
    }

    /**
     * @return the motherNation
     */
    public Long getMotherNation() {
        return motherNation;
    }

    /**
     * @param motherNation the motherNation to set
     */
    public void setMotherNation(Long motherNation) {
        this.motherNation = motherNation;
    }

    /**
     * @return the motherCountry
     */
    public String getMotherCountry() {
        return motherCountry;
    }

    /**
     * @param motherCountry the motherCountry to set
     */
    public void setMotherCountry(String motherCountry) {
        this.motherCountry = motherCountry;
    }

    /**
     * @return the motherPhone
     */
    public String getMotherPhone() {
        return motherPhone;
    }

    /**
     * @param motherPhone the motherPhone to set
     */
    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone;
    }

    /**
     * @return the motherWorkOrg
     */
    public String getMotherWorkOrg() {
        return motherWorkOrg;
    }

    /**
     * @param motherWorkOrg the motherWorkOrg to set
     */
    public void setMotherWorkOrg(String motherWorkOrg) {
        this.motherWorkOrg = motherWorkOrg;
    }

    /**
     * @return the motherAddr
     */
    public String getMotherAddr() {
        return motherAddr;
    }

    /**
     * @param motherAddr the motherAddr to set
     */
    public void setMotherAddr(String motherAddr) {
        this.motherAddr = motherAddr;
    }

    /**
     * @return the motherCretType
     */
    public String getMotherCretType() {
        return motherCretType;
    }

    /**
     * @param motherCretType the motherCretType to set
     */
    public void setMotherCretType(String motherCretType) {
        this.motherCretType = motherCretType;
    }

    /**
     * @return the motherCret
     */
    public String getMotherCret() {
        return motherCret;
    }

    /**
     * @param motherCret the motherCret to set
     */
    public void setMotherCret(String motherCret) {
        this.motherCret = motherCret;
    }

    /**
     * @return the fetationAge
     */
    public String getFetationAge() {
        return fetationAge;
    }

    /**
     * @param fetationAge the fetationAge to set
     */
    public void setFetationAge(String fetationAge) {
        this.fetationAge = fetationAge;
    }

    /**
     * @return the healthFlag
     */
    public String getHealthFlag() {
        return healthFlag;
    }

    /**
     * @param healthFlag the healthFlag to set
     */
    public void setHealthFlag(String healthFlag) {
        this.healthFlag = healthFlag;
    }

    /**
     * @return the fetationFlag
     */
    public String getFetationFlag() {
        return fetationFlag;
    }

    /**
     * @param fetationFlag the fetationFlag to set
     */
    public void setFetationFlag(String fetationFlag) {
        this.fetationFlag = fetationFlag;
    }

    /**
     * @return the fetationOther
     */
    public String getFetationOther() {
        return fetationOther;
    }

    /**
     * @param fetationOther the fetationOther to set
     */
    public void setFetationOther(String fetationOther) {
        this.fetationOther = fetationOther;
    }

    /**
     * @return the birthWeight
     */
    public Double getBirthWeight() {
        return birthWeight;
    }

    /**
     * @param birthWeight the birthWeight to set
     */
    public void setBirthWeight(Double birthWeight) {
        this.birthWeight = birthWeight;
    }

    /**
     * @return the birthHeight
     */
    public Double getBirthHeight() {
        return birthHeight;
    }

    /**
     * @param birthHeight the birthHeight to set
     */
    public void setBirthHeight(Double birthHeight) {
        this.birthHeight = birthHeight;
    }

    /**
     * @return the birthCondition
     */
    public String getBirthCondition() {
        return birthCondition;
    }

    /**
     * @param birthCondition the birthCondition to set
     */
    public void setBirthCondition(String birthCondition) {
        this.birthCondition = birthCondition;
    }

    /**
     * @return the birthStifle
     */
    public String getBirthStifle() {
        return birthStifle;
    }

    /**
     * @param birthStifle the birthStifle to set
     */
    public void setBirthStifle(String birthStifle) {
        this.birthStifle = birthStifle;
    }

    /**
     * @return the birthStifleDesc
     */
    public String getBirthStifleDesc() {
        return birthStifleDesc;
    }

    /**
     * @param birthStifleDesc the birthStifleDesc to set
     */
    public void setBirthStifleDesc(String birthStifleDesc) {
        this.birthStifleDesc = birthStifleDesc;
    }

    /**
     * @return the birthOther
     */
    public String getBirthOther() {
        return birthOther;
    }

    /**
     * @param birthOther the birthOther to set
     */
    public void setBirthOther(String birthOther) {
        this.birthOther = birthOther;
    }

    /**
     * @return the headSize
     */
    public Double getHeadSize() {
        return headSize;
    }

    /**
     * @param headSize the headSize to set
     */
    public void setHeadSize(Double headSize) {
        this.headSize = headSize;
    }

    /**
     * @return the chestSize
     */
    public Double getChestSize() {
        return chestSize;
    }

    /**
     * @param chestSize the chestSize to set
     */
    public void setChestSize(Double chestSize) {
        this.chestSize = chestSize;
    }

    /**
     * @return the apgScoreOne
     */
    public String getApgScoreOne() {
        return apgScoreOne;
    }

    /**
     * @param apgScoreOne the apgScoreOne to set
     */
    public void setApgScoreOne(String apgScoreOne) {
        this.apgScoreOne = apgScoreOne;
    }

    /**
     * @return the apgScoreFive
     */
    public String getApgScoreFive() {
        return apgScoreFive;
    }

    /**
     * @param apgScoreFive the apgScoreFive to set
     */
    public void setApgScoreFive(String apgScoreFive) {
        this.apgScoreFive = apgScoreFive;
    }

    /**
     * @return the apgScoreOther
     */
    public String getApgScoreOther() {
        return apgScoreOther;
    }

    /**
     * @param apgScoreOther the apgScoreOther to set
     */
    public void setApgScoreOther(String apgScoreOther) {
        this.apgScoreOther = apgScoreOther;
    }

    /**
     * @return the birthDefect
     */
    public String getBirthDefect() {
        return birthDefect;
    }

    /**
     * @param birthDefect the birthDefect to set
     */
    public void setBirthDefect(String birthDefect) {
        this.birthDefect = birthDefect;
    }

    /**
     * @return the birthDefectOther
     */
    public String getBirthDefectOther() {
        return birthDefectOther;
    }

    /**
     * @param birthDefectOther the birthDefectOther to set
     */
    public void setBirthDefectOther(String birthDefectOther) {
        this.birthDefectOther = birthDefectOther;
    }

    /**
     * @return the diseaseScreening
     */
    public String getDiseaseScreening() {
        return diseaseScreening;
    }

    /**
     * @param diseaseScreening the diseaseScreening to set
     */
    public void setDiseaseScreening(String diseaseScreening) {
        this.diseaseScreening = diseaseScreening;
    }

    /**
     * @return the diseaseScreeningOther
     */
    public String getDiseaseScreeningOther() {
        return diseaseScreeningOther;
    }

    /**
     * @param diseaseScreeningOther the diseaseScreeningOther to set
     */
    public void setDiseaseScreeningOther(String diseaseScreeningOther) {
        this.diseaseScreeningOther = diseaseScreeningOther;
    }

    /**
     * @return the blood
     */
    public String getBlood() {
        return blood;
    }

    /**
     * @param blood the blood to set
     */
    public void setBlood(String blood) {
        this.blood = blood;
    }

    /**
     * @return the hearScreening
     */
    public String getHearScreening() {
        return hearScreening;
    }

    /**
     * @param hearScreening the hearScreening to set
     */
    public void setHearScreening(String hearScreening) {
        this.hearScreening = hearScreening;
    }

    /**
     * @return the weakFlag
     */
    public String getWeakFlag() {
        return weakFlag;
    }

    /**
     * @param weakFlag the weakFlag to set
     */
    public void setWeakFlag(String weakFlag) {
        this.weakFlag = weakFlag;
    }

    /**
     * @return the familyDisease
     */
    public String getFamilyDisease() {
        return familyDisease;
    }

    /**
     * @param familyDisease the familyDisease to set
     */
    public void setFamilyDisease(String familyDisease) {
        this.familyDisease = familyDisease;
    }

    /**
     * @return the familyRel
     */
    public String getFamilyRel() {
        return familyRel;
    }

    /**
     * @param familyRel the familyRel to set
     */
    public void setFamilyRel(String familyRel) {
        this.familyRel = familyRel;
    }

    /**
     * @return the drugAllergy
     */
    public String getDrugAllergy() {
        return drugAllergy;
    }

    /**
     * @param drugAllergy the drugAllergy to set
     */
    public void setDrugAllergy(String drugAllergy) {
        this.drugAllergy = drugAllergy;
    }

    /**
     * @return the bcgVaccine
     */
    public String getBcgVaccine() {
        return bcgVaccine;
    }

    /**
     * @param bcgVaccine the bcgVaccine to set
     */
    public void setBcgVaccine(String bcgVaccine) {
        this.bcgVaccine = bcgVaccine;
    }

    /**
     * @return the hepatitisBVaccine
     */
    public String getHepatitisBVaccine() {
        return hepatitisBVaccine;
    }

    /**
     * @param hepatitisBVaccine the hepatitisBVaccine to set
     */
    public void setHepatitisBVaccine(String hepatitisBVaccine) {
        this.hepatitisBVaccine = hepatitisBVaccine;
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
     * @return the moveFlag
     */
    public String getMoveFlag() {
        return moveFlag;
    }

    /**
     * @param moveFlag the moveFlag to set
     */
    public void setMoveFlag(String moveFlag) {
        this.moveFlag = moveFlag;
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