package com.bofan.publichealth.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * ExamHealthProblem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_HEALTH_PROBLEM", schema = SchemaConsts.PUBLIC_HEALTH)
public class ExamHealthProblem implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -4572416887157227374L;
    // Fields

    @Id
    @Column(name = "EXAM_PERSON_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long examPersonId;
    
    @Column(name = "EXAM_TIME")
	private Date examTime;
    
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
    
    @Column(name = "CV_DISEASE_FLAG", length = 1)
	private String cvDiseaseFlag;
    
    @Column(name = "CV_DISEASE_CONTENT", length = 100)
	private String cvDiseaseContent;
	
    @Column(name = "KL_DISEASE_FLAG", length = 1)
	private String klDiseaseFlag;
    
    @Column(name = "KL_DISEASE_CONTENT", length = 100)
	private String klDiseaseContent;
    
    @Column(name = "HEART_FLAG", length = 1)
	private String heartFlag;
    
    @Column(name = "HEART_DISEASE_CONTENT", length = 100)
	private String heartDiseaseContent;
    
    @Column(name = "VASCULAR_FLAG", length = 1)
	private String vascularFlag;
    
    @Column(name = "VASCULAR_DISEASE_CONTENT", length = 100)
	private String vascularDiseaseContent;
    
    @Column(name = "PD_DISEASE_FLAG", length = 1)
	private String pdDiseaseFlag;
    
    @Column(name = "PD_DISEASE_CONTENT", length = 100)
	private String pdDiseaseContent;
    
    @Column(name = "EYE_DISEASE_FLAG", length = 1)
	private String eyeDiseaseFlag;
    
    @Column(name = "EYE_DISEASE_CONTENT", length = 100)
	private String eyeDiseaseContent;
    
    @Column(name = "NERVE_DISEASE_FLAG", length = 1)
	private String nerveDiseaseFlag;
    
    @Column(name = "NERVE_DISEASE_CONTENT", length = 100)
	private String nerveDiseaseContent;
    
    @Column(name = "OTHER_NERVE_FLAG", length = 1)
	private String otherNerveFlag;
    
    @Column(name = "OTHER_NERVE_CONTENT", length = 100)
	private String otherNerveContent;
    
    @Column(name = "HEALTH_ASSESS_FLAG", length = 1)
	private String healthAssessFlag;
    
    @Column(name = "TARGET_WEIGHT", length = 100)
	private String targetWeight;
    
    @Column(name = "VAC_VACCINATE", length = 100)
	private String vacVaccinate;
    
    @Column(name = "RISK_FACTORS", length = 100)
	private String riskFactors;

	// Constructors

	/** default constructor */
	public ExamHealthProblem() {
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
     * @return the cvDiseaseFlag
     */
    public String getCvDiseaseFlag() {
        return cvDiseaseFlag;
    }

    /**
     * @param cvDiseaseFlag the cvDiseaseFlag to set
     */
    public void setCvDiseaseFlag(String cvDiseaseFlag) {
        this.cvDiseaseFlag = cvDiseaseFlag;
    }

    /**
     * @return the cvDiseaseContent
     */
    public String getCvDiseaseContent() {
        return cvDiseaseContent;
    }

    /**
     * @param cvDiseaseContent the cvDiseaseContent to set
     */
    public void setCvDiseaseContent(String cvDiseaseContent) {
        this.cvDiseaseContent = cvDiseaseContent;
    }

    /**
     * @return the klDiseaseFlag
     */
    public String getKlDiseaseFlag() {
        return klDiseaseFlag;
    }

    /**
     * @param klDiseaseFlag the klDiseaseFlag to set
     */
    public void setKlDiseaseFlag(String klDiseaseFlag) {
        this.klDiseaseFlag = klDiseaseFlag;
    }

    /**
     * @return the klDiseaseContent
     */
    public String getKlDiseaseContent() {
        return klDiseaseContent;
    }

    /**
     * @param klDiseaseContent the klDiseaseContent to set
     */
    public void setKlDiseaseContent(String klDiseaseContent) {
        this.klDiseaseContent = klDiseaseContent;
    }

    /**
     * @return the heartFlag
     */
    public String getHeartFlag() {
        return heartFlag;
    }

    /**
     * @param heartFlag the heartFlag to set
     */
    public void setHeartFlag(String heartFlag) {
        this.heartFlag = heartFlag;
    }

    /**
     * @return the heartDiseaseContent
     */
    public String getHeartDiseaseContent() {
        return heartDiseaseContent;
    }

    /**
     * @param heartDiseaseContent the heartDiseaseContent to set
     */
    public void setHeartDiseaseContent(String heartDiseaseContent) {
        this.heartDiseaseContent = heartDiseaseContent;
    }

    /**
     * @return the vascularFlag
     */
    public String getVascularFlag() {
        return vascularFlag;
    }

    /**
     * @param vascularFlag the vascularFlag to set
     */
    public void setVascularFlag(String vascularFlag) {
        this.vascularFlag = vascularFlag;
    }

    /**
     * @return the vascularDiseaseContent
     */
    public String getVascularDiseaseContent() {
        return vascularDiseaseContent;
    }

    /**
     * @param vascularDiseaseContent the vascularDiseaseContent to set
     */
    public void setVascularDiseaseContent(String vascularDiseaseContent) {
        this.vascularDiseaseContent = vascularDiseaseContent;
    }

    /**
     * @return the pdDiseaseFlag
     */
    public String getPdDiseaseFlag() {
        return pdDiseaseFlag;
    }

    /**
     * @param pdDiseaseFlag the pdDiseaseFlag to set
     */
    public void setPdDiseaseFlag(String pdDiseaseFlag) {
        this.pdDiseaseFlag = pdDiseaseFlag;
    }

    /**
     * @return the pdDiseaseContent
     */
    public String getPdDiseaseContent() {
        return pdDiseaseContent;
    }

    /**
     * @param pdDiseaseContent the pdDiseaseContent to set
     */
    public void setPdDiseaseContent(String pdDiseaseContent) {
        this.pdDiseaseContent = pdDiseaseContent;
    }

    /**
     * @return the eyeDiseaseFlag
     */
    public String getEyeDiseaseFlag() {
        return eyeDiseaseFlag;
    }

    /**
     * @param eyeDiseaseFlag the eyeDiseaseFlag to set
     */
    public void setEyeDiseaseFlag(String eyeDiseaseFlag) {
        this.eyeDiseaseFlag = eyeDiseaseFlag;
    }

    /**
     * @return the eyeDiseaseContent
     */
    public String getEyeDiseaseContent() {
        return eyeDiseaseContent;
    }

    /**
     * @param eyeDiseaseContent the eyeDiseaseContent to set
     */
    public void setEyeDiseaseContent(String eyeDiseaseContent) {
        this.eyeDiseaseContent = eyeDiseaseContent;
    }

    /**
     * @return the nerveDiseaseFlag
     */
    public String getNerveDiseaseFlag() {
        return nerveDiseaseFlag;
    }

    /**
     * @param nerveDiseaseFlag the nerveDiseaseFlag to set
     */
    public void setNerveDiseaseFlag(String nerveDiseaseFlag) {
        this.nerveDiseaseFlag = nerveDiseaseFlag;
    }

    /**
     * @return the nerveDiseaseContent
     */
    public String getNerveDiseaseContent() {
        return nerveDiseaseContent;
    }

    /**
     * @param nerveDiseaseContent the nerveDiseaseContent to set
     */
    public void setNerveDiseaseContent(String nerveDiseaseContent) {
        this.nerveDiseaseContent = nerveDiseaseContent;
    }

    /**
     * @return the otherNerveFlag
     */
    public String getOtherNerveFlag() {
        return otherNerveFlag;
    }

    /**
     * @param otherNerveFlag the otherNerveFlag to set
     */
    public void setOtherNerveFlag(String otherNerveFlag) {
        this.otherNerveFlag = otherNerveFlag;
    }

    /**
     * @return the otherNerveContent
     */
    public String getOtherNerveContent() {
        return otherNerveContent;
    }

    /**
     * @param otherNerveContent the otherNerveContent to set
     */
    public void setOtherNerveContent(String otherNerveContent) {
        this.otherNerveContent = otherNerveContent;
    }

    /**
     * @return the healthAssessFlag
     */
    public String getHealthAssessFlag() {
        return healthAssessFlag;
    }

    /**
     * @param healthAssessFlag the healthAssessFlag to set
     */
    public void setHealthAssessFlag(String healthAssessFlag) {
        this.healthAssessFlag = healthAssessFlag;
    }

    /**
     * @return the targetWeight
     */
    public String getTargetWeight() {
        return targetWeight;
    }

    /**
     * @param targetWeight the targetWeight to set
     */
    public void setTargetWeight(String targetWeight) {
        this.targetWeight = targetWeight;
    }

    /**
     * @return the vacVaccinate
     */
    public String getVacVaccinate() {
        return vacVaccinate;
    }

    /**
     * @param vacVaccinate the vacVaccinate to set
     */
    public void setVacVaccinate(String vacVaccinate) {
        this.vacVaccinate = vacVaccinate;
    }

    /**
     * @return the riskFactors
     */
    public String getRiskFactors() {
        return riskFactors;
    }

    /**
     * @param riskFactors the riskFactors to set
     */
    public void setRiskFactors(String riskFactors) {
        this.riskFactors = riskFactors;
    }

	// Property accessors
	
	
}