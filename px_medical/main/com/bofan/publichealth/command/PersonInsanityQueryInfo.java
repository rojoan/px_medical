package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;
import com.bofan.utils.Contstants;

/**
 * 慢性病患者--慢性病对照查询条件参数信息
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.PersonInsanity pi", orderBy = "pi.personInsanityId desc", where = "pi.validFlag = " + Contstants.YES_FLAG)
public class PersonInsanityQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 5955756732587793215L;

    @QueryParam(fieldName = "pi.hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
    @QueryParam(fieldName = "pi.gender", op = QueryOperator.EQU)
    private String gender;
    
    @QueryParam(fieldName = "pi.patientName", op = QueryOperator.LIKE)
    private String patientName;
    
    @QueryParam(fieldName = "pi.familyRelId", op = QueryOperator.EQU)
    private Long familyRelId;

    @QueryParam(fieldName = "pi.guardianName", op = QueryOperator.LIKE)
    private String guardianName;
    
    @QueryParam(fieldName = "pi.linkmanName", op = QueryOperator.LIKE)
    private String linkmanName;
    
    @QueryParam(fieldName = "pi.censusFlag", op = QueryOperator.EQU)
    private String censusFlag;

    @QueryParam(fieldName = "pi.personDetailId", op = QueryOperator.EQU)
    private Long personDetailId;

    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "pi.birthDate", op = QueryOperator.GT_EQU)
    private Date beginBirthDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "pi.birthDate", op = QueryOperator.LESS_EQU)
    private Date endBirthDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "pi.diseaseConfirmTime", op = QueryOperator.GT_EQU)
    private Date beginDiseaseConfirmTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "pi.diseaseConfirmTime", op = QueryOperator.LESS_EQU)
    private Date endDiseaseConfirmTime;

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
     * @return the beginBirthDate
     */
    public Date getBeginBirthDate() {
        return beginBirthDate;
    }

    /**
     * @param beginBirthDate the beginBirthDate to set
     */
    public void setBeginBirthDate(Date beginBirthDate) {
        this.beginBirthDate = beginBirthDate;
    }

    /**
     * @return the endBirthDate
     */
    public Date getEndBirthDate() {
        return endBirthDate;
    }

    /**
     * @param endBirthDate the endBirthDate to set
     */
    public void setEndBirthDate(Date endBirthDate) {
        this.endBirthDate = endBirthDate;
    }

    /**
     * @return the beginDiseaseConfirmTime
     */
    public Date getBeginDiseaseConfirmTime() {
        return beginDiseaseConfirmTime;
    }

    /**
     * @param beginDiseaseConfirmTime the beginDiseaseConfirmTime to set
     */
    public void setBeginDiseaseConfirmTime(Date beginDiseaseConfirmTime) {
        this.beginDiseaseConfirmTime = beginDiseaseConfirmTime;
    }

    /**
     * @return the endDiseaseConfirmTime
     */
    public Date getEndDiseaseConfirmTime() {
        return endDiseaseConfirmTime;
    }

    /**
     * @param endDiseaseConfirmTime the endDiseaseConfirmTime to set
     */
    public void setEndDiseaseConfirmTime(Date endDiseaseConfirmTime) {
        this.endDiseaseConfirmTime = endDiseaseConfirmTime;
    }
    
}
