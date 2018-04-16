package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.publichealth.valueobject.PersonChronicDisease;
import com.bofan.publichealth.valueobject.PersonChronicItem;
import com.bofan.publichealth.valueobject.PersonChronicType;
import com.bofan.publichealth.valueobject.PersonDiabetesCure;
import com.bofan.publichealth.valueobject.PersonHypCure;
import com.bofan.publichealth.valueobject.PersonPhthisisCure;
import com.bofan.publichealth.valueobject.PersonTumourCure;

/**
 * 接收来自页面编辑慢性病患者登记参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
public class PersonChronicEditInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -5451648553090339790L;

    private Long personChronicId;

    private String contactAddr;

    private Long familyRelId;

    private String idCard;
    
    private String gender;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    private String linkmanPhone;

    private String patientName;

    private Long personDetailId;

    private String recordNum;

    private String regionId;

    private String zipCode;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date deathDate;
    
    private String deathReason;

    
    /** 慢性病类型 */
    private String chronicType;
    
    /** 慢性病类型 */
    private PersonChronicType personChronicType;
    
    /** 慢性病患者相关病史和家族史 */
    private PersonChronicDisease personChronicDisease;
    
    /** 慢性病患者体格检查/生活行为 */
    private PersonChronicItem personChronicItem;
    
    /** 慢性病患者--饮酒种类 */
    private String chronicDrinkJson; 
    
    /** 高血压患者用药和治疗情况 */
    private PersonHypCure personHypCure;
    
    /** 糖尿病患者干预和治疗情况 */
    private PersonDiabetesCure personDiabetesCure;
    
    /** 慢性病非药物治疗类型 */
    private String[] nonDrugType;
    
    /** 慢性病本次药物治疗（json格式） */
    private String chronicDrugJson;
    
    /** 慢性病危险因素 */
    private String[] dangerType;
    
    /** 诊断依据  */
    private String[] diagnoseBasis;
    
    /** 肿瘤患者治疗和进展情况  */
    private PersonTumourCure personTumourCure;
    
    /** 具体诊断 */
    private String[] chronicDiagnoses;
    
    /** 肺结核诊断和治疗情况 */
    private PersonPhthisisCure personPhthisisCure;

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
     * @return the contactAddr
     */
    public String getContactAddr() {
        return contactAddr;
    }

    /**
     * @param contactAddr the contactAddr to set
     */
    public void setContactAddr(String contactAddr) {
        this.contactAddr = contactAddr;
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
     * @return the idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard the idCard to set
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
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
     * @return the recordNum
     */
    public String getRecordNum() {
        return recordNum;
    }

    /**
     * @param recordNum the recordNum to set
     */
    public void setRecordNum(String recordNum) {
        this.recordNum = recordNum;
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
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the chronicType
     */
    public String getChronicType() {
        return chronicType;
    }

    /**
     * @param chronicType the chronicType to set
     */
    public void setChronicType(String chronicType) {
        this.chronicType = chronicType;
    }

    /**
     * @return the personChronicType
     */
    public PersonChronicType getPersonChronicType() {
        return personChronicType;
    }

    /**
     * @param personChronicType the personChronicType to set
     */
    public void setPersonChronicType(PersonChronicType personChronicType) {
        this.personChronicType = personChronicType;
    }

    /**
     * @return the personChronicDisease
     */
    public PersonChronicDisease getPersonChronicDisease() {
        return personChronicDisease;
    }

    /**
     * @param personChronicDisease the personChronicDisease to set
     */
    public void setPersonChronicDisease(PersonChronicDisease personChronicDisease) {
        this.personChronicDisease = personChronicDisease;
    }

    /**
     * @return the personChronicItem
     */
    public PersonChronicItem getPersonChronicItem() {
        return personChronicItem;
    }

    /**
     * @param personChronicItem the personChronicItem to set
     */
    public void setPersonChronicItem(PersonChronicItem personChronicItem) {
        this.personChronicItem = personChronicItem;
    }

    /**
     * @return the chronicDrinkJson
     */
    public String getChronicDrinkJson() {
        return chronicDrinkJson;
    }

    /**
     * @param chronicDrinkJson the chronicDrinkJson to set
     */
    public void setChronicDrinkJson(String chronicDrinkJson) {
        this.chronicDrinkJson = chronicDrinkJson;
    }

    /**
     * @return the personHypCure
     */
    public PersonHypCure getPersonHypCure() {
        return personHypCure;
    }

    /**
     * @param personHypCure the personHypCure to set
     */
    public void setPersonHypCure(PersonHypCure personHypCure) {
        this.personHypCure = personHypCure;
    }

    /**
     * @return the personDiabetesCure
     */
    public PersonDiabetesCure getPersonDiabetesCure() {
        return personDiabetesCure;
    }

    /**
     * @param personDiabetesCure the personDiabetesCure to set
     */
    public void setPersonDiabetesCure(PersonDiabetesCure personDiabetesCure) {
        this.personDiabetesCure = personDiabetesCure;
    }

    /**
     * @return the nonDrugType
     */
    public String[] getNonDrugType() {
        return nonDrugType;
    }

    /**
     * @param nonDrugType the nonDrugType to set
     */
    public void setNonDrugType(String[] nonDrugType) {
        this.nonDrugType = nonDrugType;
    }

    /**
     * @return the chronicDrugJson
     */
    public String getChronicDrugJson() {
        return chronicDrugJson;
    }

    /**
     * @param chronicDrugJson the chronicDrugJson to set
     */
    public void setChronicDrugJson(String chronicDrugJson) {
        this.chronicDrugJson = chronicDrugJson;
    }

    /**
     * @return the dangerType
     */
    public String[] getDangerType() {
        return dangerType;
    }

    /**
     * @param dangerType the dangerType to set
     */
    public void setDangerType(String[] dangerType) {
        this.dangerType = dangerType;
    }

    /**
     * @return the diagnoseBasis
     */
    public String[] getDiagnoseBasis() {
        return diagnoseBasis;
    }

    /**
     * @param diagnoseBasis the diagnoseBasis to set
     */
    public void setDiagnoseBasis(String[] diagnoseBasis) {
        this.diagnoseBasis = diagnoseBasis;
    }

    /**
     * @return the personTumourCure
     */
    public PersonTumourCure getPersonTumourCure() {
        return personTumourCure;
    }

    /**
     * @param personTumourCure the personTumourCure to set
     */
    public void setPersonTumourCure(PersonTumourCure personTumourCure) {
        this.personTumourCure = personTumourCure;
    }

    /**
     * @return the chronicDiagnoses
     */
    public String[] getChronicDiagnoses() {
        return chronicDiagnoses;
    }

    /**
     * @param chronicDiagnoses the chronicDiagnoses to set
     */
    public void setChronicDiagnoses(String[] chronicDiagnoses) {
        this.chronicDiagnoses = chronicDiagnoses;
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
     * @return the deathReason
     */
    public String getDeathReason() {
        return deathReason;
    }

    /**
     * @param deathReason the deathReason to set
     */
    public void setDeathReason(String deathReason) {
        this.deathReason = deathReason;
    }

    /**
     * @return the personPhthisisCure
     */
    public PersonPhthisisCure getPersonPhthisisCure() {
        return personPhthisisCure;
    }

    /**
     * @param personPhthisisCure the personPhthisisCure to set
     */
    public void setPersonPhthisisCure(PersonPhthisisCure personPhthisisCure) {
        this.personPhthisisCure = personPhthisisCure;
    }

}
