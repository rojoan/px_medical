package com.bofan.publichealth.valueobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.utils.SchemaConsts;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 慢性病患者--类型实体
 * 
 */
@Entity
@Table(name="PERSON_CHRONIC_TYPE", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "CHRONIC_TYPE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_CHRONIC_TYPE_ID", allocationSize = 1)
public class PersonChronicType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHRONIC_TYPE_ID")
    @Column(name="CHRONIC_TYPE_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long chronicTypeId;
	
	/** 慢性病ID */
	@Column(name="PERSON_CHRONIC_ID", nullable = false, precision = 18, scale = 0)
	private Long personChronicId;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PERSON_CHRONIC_ID", insertable = false, updatable = false)
    private PersonChronic personChronic;
	
	@Column(name="PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
    private Long personDetailId;

	/** 慢性病类型 */
	@Column(name="CHRONIC_TYPE", length = 1)
	private String chronicType;

	/** 慢性病诊断--等级/类型 */
	@Column(name="CHRONIC_LEVEL", length = 3)
	private String chronicLevel;

	/** 发病日期 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
	@Column(name="ATTACK_DATE")
	private Date attackDate;
	
	/** 确诊日期 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
	@Column(name="CONFIRM_DATE")
    private Date confirmDate;

	/** 慢性病--专项档案号 */
	@Column(name="SPECIAL_ARCHIVE", length = 40)
	private String specialArchive;

	/** 确诊医院 */
	@Column(name="DIAGNOSIS_HOSPITAL", length = 40)
	private String diagnosisHospital;

	/** 确诊医院类型  */
	@Column(name="DIAGNOSIS_HOSPITAL_TYPE", length = 1)
	private String diagnosisHospitalType;
	
	/** 有效无效  */
    @Column(name="VALID_FLAG", length = 1)
    private String validFlag;

    /** 就诊日期 */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name="INHOSPITAL_DATE")
    private Date inhospitalDate;
	
	public PersonChronicType() {
	}

    /**
     * @return the chronicTypeId
     */
    public Long getChronicTypeId() {
        return chronicTypeId;
    }

    /**
     * @param chronicTypeId the chronicTypeId to set
     */
    public void setChronicTypeId(Long chronicTypeId) {
        this.chronicTypeId = chronicTypeId;
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
     * @return the personChronic
     */
    public PersonChronic getPersonChronic() {
        return personChronic;
    }

    /**
     * @param personChronic the personChronic to set
     */
    public void setPersonChronic(PersonChronic personChronic) {
        this.personChronic = personChronic;
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
     * @return the attackDate
     */
    public Date getAttackDate() {
        return attackDate;
    }

    /**
     * @param attackDate the attackDate to set
     */
    public void setAttackDate(Date attackDate) {
        this.attackDate = attackDate;
    }

    /**
     * @return the confirmDate
     */
    public Date getConfirmDate() {
        return confirmDate;
    }

    /**
     * @param confirmDate the confirmDate to set
     */
    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    /**
     * @return the specialArchive
     */
    public String getSpecialArchive() {
        return specialArchive;
    }

    /**
     * @param specialArchive the specialArchive to set
     */
    public void setSpecialArchive(String specialArchive) {
        this.specialArchive = specialArchive;
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

    /**
     * @return the inhospitalDate
     */
    public Date getInhospitalDate() {
        return inhospitalDate;
    }

    /**
     * @param inhospitalDate the inhospitalDate to set
     */
    public void setInhospitalDate(Date inhospitalDate) {
        this.inhospitalDate = inhospitalDate;
    }

}