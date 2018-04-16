package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.publichealth.valueobject.PersonVisitItem;

/**
 * 接收来自页面编辑慢性病患者登记参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
public class PersonChronicVisitEditInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -5451648553090339790L;

    private Long chronicVisitId;

    private Long hospitalId;

    private String hospitalName;

    private String hospitalNo;

    private String hospitalPhone;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date nextVisitTime;

    private Long personChronicId;

    private Long personDetailId;

    private String transDiagnosisDescribe;

    private String transDiagnosisFlag;

    private Long transDiagnosisOfficeId;

    private String transDiagnosisOfficeName;

    private String transDiagnosisReason;

    private Long visitDoctorId;

    private String visitDoctorName;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date visitTime;

    private String visitWay;
    
    private String therapyStopReason;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date therapyStopDate;
    
    /** 患病类型 */
    private String chronicType;
    
    /** 慢性病随访--症状表id */
    private String[] visitChronicSymIds;
    
    /** 慢性病随访用药情况 */
    private String personVisitDrugJson;
    
    /** 随访--体征/检查/生活指导/治疗情况 */
    private PersonVisitItem personVisitItem; 
    
    /** 随访体征类型 */
    private String[] visitSignTypes;
    
    /** 治疗情况 */
    private String[] visitCureTypes;
    
    /** 报导内容 */
    private String[] visitContentTypes;

    /**
     * @return the chronicVisitId
     */
    public Long getChronicVisitId() {
        return chronicVisitId;
    }

    /**
     * @param chronicVisitId the chronicVisitId to set
     */
    public void setChronicVisitId(Long chronicVisitId) {
        this.chronicVisitId = chronicVisitId;
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
     * @return the hospitalPhone
     */
    public String getHospitalPhone() {
        return hospitalPhone;
    }

    /**
     * @param hospitalPhone the hospitalPhone to set
     */
    public void setHospitalPhone(String hospitalPhone) {
        this.hospitalPhone = hospitalPhone;
    }

    /**
     * @return the nextVisitTime
     */
    public Date getNextVisitTime() {
        return nextVisitTime;
    }

    /**
     * @param nextVisitTime the nextVisitTime to set
     */
    public void setNextVisitTime(Date nextVisitTime) {
        this.nextVisitTime = nextVisitTime;
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
     * @return the transDiagnosisDescribe
     */
    public String getTransDiagnosisDescribe() {
        return transDiagnosisDescribe;
    }

    /**
     * @param transDiagnosisDescribe the transDiagnosisDescribe to set
     */
    public void setTransDiagnosisDescribe(String transDiagnosisDescribe) {
        this.transDiagnosisDescribe = transDiagnosisDescribe;
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
     * @return the transDiagnosisOfficeId
     */
    public Long getTransDiagnosisOfficeId() {
        return transDiagnosisOfficeId;
    }

    /**
     * @param transDiagnosisOfficeId the transDiagnosisOfficeId to set
     */
    public void setTransDiagnosisOfficeId(Long transDiagnosisOfficeId) {
        this.transDiagnosisOfficeId = transDiagnosisOfficeId;
    }

    /**
     * @return the transDiagnosisOfficeName
     */
    public String getTransDiagnosisOfficeName() {
        return transDiagnosisOfficeName;
    }

    /**
     * @param transDiagnosisOfficeName the transDiagnosisOfficeName to set
     */
    public void setTransDiagnosisOfficeName(String transDiagnosisOfficeName) {
        this.transDiagnosisOfficeName = transDiagnosisOfficeName;
    }

    /**
     * @return the transDiagnosisReason
     */
    public String getTransDiagnosisReason() {
        return transDiagnosisReason;
    }

    /**
     * @param transDiagnosisReason the transDiagnosisReason to set
     */
    public void setTransDiagnosisReason(String transDiagnosisReason) {
        this.transDiagnosisReason = transDiagnosisReason;
    }

    /**
     * @return the visitDoctorId
     */
    public Long getVisitDoctorId() {
        return visitDoctorId;
    }

    /**
     * @param visitDoctorId the visitDoctorId to set
     */
    public void setVisitDoctorId(Long visitDoctorId) {
        this.visitDoctorId = visitDoctorId;
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
     * @return the visitTime
     */
    public Date getVisitTime() {
        return visitTime;
    }

    /**
     * @param visitTime the visitTime to set
     */
    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
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
     * @return the visitChronicSymIds
     */
    public String[] getVisitChronicSymIds() {
        return visitChronicSymIds;
    }

    /**
     * @param visitChronicSymIds the visitChronicSymIds to set
     */
    public void setVisitChronicSymIds(String[] visitChronicSymIds) {
        this.visitChronicSymIds = visitChronicSymIds;
    }

    /**
     * @return the personVisitDrugJson
     */
    public String getPersonVisitDrugJson() {
        return personVisitDrugJson;
    }

    /**
     * @param personVisitDrugJson the personVisitDrugJson to set
     */
    public void setPersonVisitDrugJson(String personVisitDrugJson) {
        this.personVisitDrugJson = personVisitDrugJson;
    }

    /**
     * @return the personVisitItem
     */
    public PersonVisitItem getPersonVisitItem() {
        return personVisitItem;
    }

    /**
     * @param personVisitItem the personVisitItem to set
     */
    public void setPersonVisitItem(PersonVisitItem personVisitItem) {
        this.personVisitItem = personVisitItem;
    }

    /**
     * @return the visitSignTypes
     */
    public String[] getVisitSignTypes() {
        return visitSignTypes;
    }

    /**
     * @param visitSignTypes the visitSignTypes to set
     */
    public void setVisitSignTypes(String[] visitSignTypes) {
        this.visitSignTypes = visitSignTypes;
    }

    /**
     * @return the visitCureTypes
     */
    public String[] getVisitCureTypes() {
        return visitCureTypes;
    }

    /**
     * @param visitCureTypes the visitCureTypes to set
     */
    public void setVisitCureTypes(String[] visitCureTypes) {
        this.visitCureTypes = visitCureTypes;
    }

    /**
     * @return the visitContentTypes
     */
    public String[] getVisitContentTypes() {
        return visitContentTypes;
    }

    /**
     * @param visitContentTypes the visitContentTypes to set
     */
    public void setVisitContentTypes(String[] visitContentTypes) {
        this.visitContentTypes = visitContentTypes;
    }

    /**
     * @return the therapyStopReason
     */
    public String getTherapyStopReason() {
        return therapyStopReason;
    }

    /**
     * @param therapyStopReason the therapyStopReason to set
     */
    public void setTherapyStopReason(String therapyStopReason) {
        this.therapyStopReason = therapyStopReason;
    }

    /**
     * @return the therapyStopDate
     */
    public Date getTherapyStopDate() {
        return therapyStopDate;
    }

    /**
     * @param therapyStopDate the therapyStopDate to set
     */
    public void setTherapyStopDate(Date therapyStopDate) {
        this.therapyStopDate = therapyStopDate;
    }
    
}
