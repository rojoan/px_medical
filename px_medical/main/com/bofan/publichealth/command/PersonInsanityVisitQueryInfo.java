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
@QueryInfo(
        from = "com.bofan.publichealth.valueobject.PersonInsanityVisit piv", 
        orderBy = "piv.personInsanityVisitId desc", 
        where = "piv.validFlag = " + Contstants.YES_FLAG)
public class PersonInsanityVisitQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 5955756732587793215L;

    @QueryParam(fieldName = "piv.hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
    @QueryParam(fieldName = "piv.personInsanity.gender", op = QueryOperator.EQU)
    private String gender;
    
    @QueryParam(fieldName = "piv.personInsanity.patientName", op = QueryOperator.LIKE)
    private String patientName;
    
    @QueryParam(fieldName = "piv.visitClassify", op = QueryOperator.EQU)
    private String visitClassify;

    @QueryParam(fieldName = "piv.personInsanityId", op = QueryOperator.EQU)
    private Long personInsanityId;
    
    @QueryParam(fieldName = "piv.personInsanityVisitId", op = QueryOperator.EQU)
    private Long personInsanityVisitId;
    
    @QueryParam(fieldName = "piv.personDetailId", op = QueryOperator.EQU)
    private Long personDetailId;

    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "piv.personInsanity.birthDate", op = QueryOperator.GT_EQU)
    private Date beginBirthDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "piv.personInsanity.birthDate", op = QueryOperator.LESS_EQU)
    private Date endBirthDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "piv.visitTime", op = QueryOperator.GT_EQU)
    private Date beginVisitDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "piv.visitTime", op = QueryOperator.LESS_EQU)
    private Date endVisitDate;

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
     * @return the beginVisitDate
     */
    public Date getBeginVisitDate() {
        return beginVisitDate;
    }

    /**
     * @param beginVisitDate the beginVisitDate to set
     */
    public void setBeginVisitDate(Date beginVisitDate) {
        this.beginVisitDate = beginVisitDate;
    }

    /**
     * @return the endVisitDate
     */
    public Date getEndVisitDate() {
        return endVisitDate;
    }

    /**
     * @param endVisitDate the endVisitDate to set
     */
    public void setEndVisitDate(Date endVisitDate) {
        this.endVisitDate = endVisitDate;
    }

}
