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
        select = "piv.personInsanityVisitId, piv.personInsanityId, to_char(piv.visitTime,'yyyy-MM-dd')",
        from = "com.bofan.publichealth.valueobject.PersonInsanityVisit piv", 
        orderBy = "piv.personInsanityVisitId desc", 
        where = "piv.validFlag = " + Contstants.YES_FLAG, 
        groupBy = "piv.personInsanityVisitId, piv.personInsanityId, piv.visitTime")
public class PersonInsanityVisitGroupQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 5955756732587793215L;

    @QueryParam(fieldName = "piv.hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
    @QueryParam(fieldName = "piv.personChronic.gender", op = QueryOperator.EQU)
    private String gender;
    
    @QueryParam(fieldName = "piv.personChronic.patientName", op = QueryOperator.LIKE)
    private String patientName;
    
    @QueryParam(fieldName = "piv.personChronic.idCard", op = QueryOperator.EQU)
    private String idCard;

    @QueryParam(fieldName = "piv.visitDoctorName", op = QueryOperator.LIKE)
    private String visitDoctorName;
    
    @QueryParam(fieldName = "piv.visitWay", op = QueryOperator.EQU)
    private String visitWay;
    
    @QueryParam(fieldName = "piv.transDiagnosisFlag", op = QueryOperator.EQU)
    private String transDiagnosisFlag;

    @QueryParam(fieldName = "piv.personDetailId", op = QueryOperator.EQU)
    private Long personDetailId;

    @QueryParam(fieldName = "piv.personChronicId", op = QueryOperator.EQU)
    private Long personChronicId;
    
    @QueryParam(fieldName = "piv.chronicType", op = QueryOperator.EQU)
    private String chronicType;

    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "piv.personChronic.birthDate", op = QueryOperator.GT_EQU)
    private Date beginBirthDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "piv.personChronic.birthDate", op = QueryOperator.LESS_EQU)
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
