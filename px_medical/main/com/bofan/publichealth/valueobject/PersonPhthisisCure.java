package com.bofan.publichealth.valueobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;


/**
 * 肺结核诊断和治疗情况
 * 
 */
@Entity
@Table(name="PERSON_PHTHISIS_CURE", schema = SchemaConsts.PUBLIC_HEALTH)
public class PersonPhthisisCure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PERSON_CHRONIC_ID", nullable = false, precision = 18, scale = 0)
	private Long personChronicId;
	
	@Column(name="PERSON_DETAIL_ID", precision = 18, scale = 0)
    private Long personDetailId;
	
	@Column(name="PHTHISIS_DIAGNOSE", length = 40)
    private String phthisisDiagnose;
	
	@Column(name="SPUTUM_BACTERIUM_FLAG", length = 1)
    private String sputumBacteriumFlag;
	
	@Column(name="SPUTUM_BACTERIUM", length = 40)
    private String sputumBacterium;
	
	@Column(name="MANAGE_WAY", length = 1)
    private String manageWay;
	
	@Column(name="PATIENT_FLAG", length = 1)
    private String patientFlag;
	
	@Column(name="FIRST_CURE", length = 40)
    private String firstCure;
    
	@Column(name="DRUG_FAST_FLAG", length = 1)
    private String drugFastFlag;
	
    @Column(name="CURE_CASE_FLAG", length = 1)
    private String cureCaseFlag;
    
    @Column(name="CURE_MODIFY_FLAG", length = 1)
    private String cureModifyFlag;
    
    @Column(name="CHEMOTHERAPY", length = 100)
    private String chemotherapy;
    
    @Column(name="DRUG_USAGE", length = 1)
    private String drugUsage;

    @Column(name="SUPERVISOR_FLAG", length = 1)
    private String supervisorFlag;
    
    @Column(name="ALONE_RESIDE", length = 1)
    private String aloneReside;
    
    @Column(name="VENTILATE_FLAG", length = 1)
    private String ventilateFlag;
    
    @Column(name="HOSPITAL_ID", precision = 18, scale = 0)
    private Long hospitalId;

	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="CREATOR_ID", precision = 18, scale = 0)
	private Long creatorId;
	
	@Column(name="VALID_FLAG")
	private String validFlag;

	public PersonPhthisisCure() {
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
     * @return the phthisisDiagnose
     */
    public String getPhthisisDiagnose() {
        return phthisisDiagnose;
    }

    /**
     * @param phthisisDiagnose the phthisisDiagnose to set
     */
    public void setPhthisisDiagnose(String phthisisDiagnose) {
        this.phthisisDiagnose = phthisisDiagnose;
    }

    /**
     * @return the sputumBacteriumFlag
     */
    public String getSputumBacteriumFlag() {
        return sputumBacteriumFlag;
    }

    /**
     * @param sputumBacteriumFlag the sputumBacteriumFlag to set
     */
    public void setSputumBacteriumFlag(String sputumBacteriumFlag) {
        this.sputumBacteriumFlag = sputumBacteriumFlag;
    }

    /**
     * @return the sputumBacterium
     */
    public String getSputumBacterium() {
        return sputumBacterium;
    }

    /**
     * @param sputumBacterium the sputumBacterium to set
     */
    public void setSputumBacterium(String sputumBacterium) {
        this.sputumBacterium = sputumBacterium;
    }

    /**
     * @return the manageWay
     */
    public String getManageWay() {
        return manageWay;
    }

    /**
     * @param manageWay the manageWay to set
     */
    public void setManageWay(String manageWay) {
        this.manageWay = manageWay;
    }

    /**
     * @return the patientFlag
     */
    public String getPatientFlag() {
        return patientFlag;
    }

    /**
     * @param patientFlag the patientFlag to set
     */
    public void setPatientFlag(String patientFlag) {
        this.patientFlag = patientFlag;
    }

    /**
     * @return the firstCure
     */
    public String getFirstCure() {
        return firstCure;
    }

    /**
     * @param firstCure the firstCure to set
     */
    public void setFirstCure(String firstCure) {
        this.firstCure = firstCure;
    }

    /**
     * @return the drugFastFlag
     */
    public String getDrugFastFlag() {
        return drugFastFlag;
    }

    /**
     * @param drugFastFlag the drugFastFlag to set
     */
    public void setDrugFastFlag(String drugFastFlag) {
        this.drugFastFlag = drugFastFlag;
    }

    /**
     * @return the cureCaseFlag
     */
    public String getCureCaseFlag() {
        return cureCaseFlag;
    }

    /**
     * @param cureCaseFlag the cureCaseFlag to set
     */
    public void setCureCaseFlag(String cureCaseFlag) {
        this.cureCaseFlag = cureCaseFlag;
    }

    /**
     * @return the cureModifyFlag
     */
    public String getCureModifyFlag() {
        return cureModifyFlag;
    }

    /**
     * @param cureModifyFlag the cureModifyFlag to set
     */
    public void setCureModifyFlag(String cureModifyFlag) {
        this.cureModifyFlag = cureModifyFlag;
    }

    /**
     * @return the chemotherapy
     */
    public String getChemotherapy() {
        return chemotherapy;
    }

    /**
     * @param chemotherapy the chemotherapy to set
     */
    public void setChemotherapy(String chemotherapy) {
        this.chemotherapy = chemotherapy;
    }

    /**
     * @return the drugUsage
     */
    public String getDrugUsage() {
        return drugUsage;
    }

    /**
     * @param drugUsage the drugUsage to set
     */
    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage;
    }

    /**
     * @return the supervisorFlag
     */
    public String getSupervisorFlag() {
        return supervisorFlag;
    }

    /**
     * @param supervisorFlag the supervisorFlag to set
     */
    public void setSupervisorFlag(String supervisorFlag) {
        this.supervisorFlag = supervisorFlag;
    }

    /**
     * @return the aloneReside
     */
    public String getAloneReside() {
        return aloneReside;
    }

    /**
     * @param aloneReside the aloneReside to set
     */
    public void setAloneReside(String aloneReside) {
        this.aloneReside = aloneReside;
    }

    /**
     * @return the ventilateFlag
     */
    public String getVentilateFlag() {
        return ventilateFlag;
    }

    /**
     * @param ventilateFlag the ventilateFlag to set
     */
    public void setVentilateFlag(String ventilateFlag) {
        this.ventilateFlag = ventilateFlag;
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