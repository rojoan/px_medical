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
@QueryInfo(from = "com.bofan.publichealth.valueobject.PersonChronicType pct", orderBy = "pct.chronicTypeId desc", where = "pct.validFlag = " + Contstants.YES_FLAG)
public class PersonChronicTypeQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 5955756732587793215L;

    @QueryParam(fieldName = "pct.personChronic.hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
    @QueryParam(fieldName = "pct.personChronic.gender", op = QueryOperator.EQU)
    private String gender;
    
    @QueryParam(fieldName = "pct.personChronic.patientName", op = QueryOperator.LIKE)
    private String patientName;
    
    @QueryParam(fieldName = "pct.personChronic.idCard", op = QueryOperator.EQU)
    private String idCard;
    
    @QueryParam(fieldName = "pct.diagnosisHospital", op = QueryOperator.LIKE)
    private String diagnosisHospital;
    
    @QueryParam(fieldName = "pct.diagnosisHospitalType", op = QueryOperator.EQU)
    private String diagnosisHospitalType;
    
    @QueryParam(fieldName = "pct.chronicLevel", op = QueryOperator.EQU)
    private String chronicLevel;

    @QueryParam(fieldName = "pct.personDetailId", op = QueryOperator.EQU)
    private Long personDetailId;

    @QueryParam(fieldName = "pct.personChronicId", op = QueryOperator.EQU)
    private Long personChronicId;
    
    @QueryParam(fieldName = "pct.chronicType", op = QueryOperator.EQU)
    private String chronicType;

    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "pct.confirmDate", op = QueryOperator.GT_EQU)
    private Date beginConfirmDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "pct.confirmDate", op = QueryOperator.LESS_EQU)
    private Date endConfirmDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "pct.attackDate", op = QueryOperator.GT_EQU)
    private Date beginAttackDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "pct.attackDate", op = QueryOperator.LESS_EQU)
    private Date endAttackDate;
    
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
     * @return the diagnosisHospital
     */
    public String getDiagnosisHospital() {
        return diagnosisHospital;
    }

    /**
     * @param diagnosisHospital the diagnosisHospital to set
     */
    public void setDiagnosisHospital(String diagnosisHospital) {
        this.diagnosisHospital = diagnosisHospital;
    }

    /**
     * @return the diagnosisHospitalType
     */
    public String getDiagnosisHospitalType() {
        return diagnosisHospitalType;
    }

    /**
     * @param diagnosisHospitalType the diagnosisHospitalType to set
     */
    public void setDiagnosisHospitalType(String diagnosisHospitalType) {
        this.diagnosisHospitalType = diagnosisHospitalType;
    }

    /**
     * @return the chronicLevel
     */
    public String getChronicLevel() {
        return chronicLevel;
    }

    /**
     * @param chronicLevel the chronicLevel to set
     */
    public void setChronicLevel(String chronicLevel) {
        this.chronicLevel = chronicLevel;
    }

    /**
     * @return the beginConfirmDate
     */
    public Date getBeginConfirmDate() {
        return beginConfirmDate;
    }

    /**
     * @param beginConfirmDate the beginConfirmDate to set
     */
    public void setBeginConfirmDate(Date beginConfirmDate) {
        this.beginConfirmDate = beginConfirmDate;
    }

    /**
     * @return the endConfirmDate
     */
    public Date getEndConfirmDate() {
        return endConfirmDate;
    }

    /**
     * @param endConfirmDate the endConfirmDate to set
     */
    public void setEndConfirmDate(Date endConfirmDate) {
        this.endConfirmDate = endConfirmDate;
    }

    /**
     * @return the beginAttackDate
     */
    public Date getBeginAttackDate() {
        return beginAttackDate;
    }

    /**
     * @param beginAttackDate the beginAttackDate to set
     */
    public void setBeginAttackDate(Date beginAttackDate) {
        this.beginAttackDate = beginAttackDate;
    }

    /**
     * @return the endAttackDate
     */
    public Date getEndAttackDate() {
        return endAttackDate;
    }

    /**
     * @param endAttackDate the endAttackDate to set
     */
    public void setEndAttackDate(Date endAttackDate) {
        this.endAttackDate = endAttackDate;
    }

}
