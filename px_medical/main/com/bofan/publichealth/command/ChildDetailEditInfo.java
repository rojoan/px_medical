package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * 0-6岁儿童基本情况登记表，接收来自页面编辑参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
public class ChildDetailEditInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -4838997932144501779L;

    private Long childDetailId;
    
    private Long familyDetailId;
    
    private Long patientId;
    
    private String birthLocType;
    
    private Long hospitalId;
    
    private String hospitalNo;
    
    private String hospitalName;
    
    private String newBorn;
    
    private String birthAttendant;
    
    private String childName;
    
    private String healthbookFlag;
    
    private String birthCert;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthCertDate;
    
    private String birthCertPerson;
    
    private String gender;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthDate;
    
    private String regionId;
    
    private String familyAddr;
    
    private Long committeeId;
    
    private String committeeName;
    
    private String fatherName;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fatherBirth;
    
    private String fatherCareer;
    
    private Long fatherNation;
    
    private String fatherCountry;
    
    private String fatherPhone;
    
    private String fatherWorkOrg;
    
    private String fatherAddr;
    
    private String fatherCretType;
    
    private String fatherCret;
    
    private String motherName;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date motherBirth;
    
    private String motherCareer;
    
    private Long motherNation;
    
    private String motherCountry;
    
    private String motherPhone;
    
    private String motherWorkOrg;
    
    private String motherAddr;
    
    private String motherCretType;
    
    private String motherCret;
    
    private String fetationAge;
    
    private String healthFlag;
    
    private String fetationFlag;
    
    private String fetationOther;
    
    private Double birthWeight;
    
    private Double birthHeight;
    
    private String birthCondition;
    
    private String birthStifle;
    
    private String birthStifleDesc;
    
    private String birthOther;
    
    private Double headSize;
    
    private Double chestSize;
    
    private String apgScoreOne;
    
    private String apgScoreFive;
    
    private String apgScoreOther;
    
    private String birthDefect;
    
    private String birthDefectOther;
    
    private String diseaseScreening;
    
    private String diseaseScreeningOther;
    
    private String blood;
    
    private String hearScreening;
    
    private String weakFlag;
    
    private String familyDisease;
    
    private String familyRel;
    
    private String drugAllergy;

    /** 新生儿--卡介苗 1=已种 0=未种 */
    private String bcgVaccine;
    
    /** 新生儿--乙肝疫苗 */
    private String hepatitisBVaccine;
    
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
   
}
