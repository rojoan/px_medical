package com.bofan.publichealth.valueobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;


/**
 * 肿瘤患者治疗和进展情况  
 * 
 */
@Entity
@Table(name="PERSON_TUMOUR_CURE", schema = SchemaConsts.PUBLIC_HEALTH)
public class PersonTumourCure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PERSON_CHRONIC_ID", unique=true, nullable=false, precision=18)
	private Long personChronicId;
	
	@Column(name="PERSON_DETAIL_ID", nullable=false, precision=18)
    private Long personDetailId;

	@Column(name="OTHER_CURE", length = 40)
	private String otherCure;
	
	@Column(name="CURE_HOSPITAL", length = 80)
    private String cureHospital;
	
	@Column(name="SURGERY_HOSPITAL", length = 80)
    private String surgeryHospital;

	@Column(name="CHEMOTHERAPY_HOSPITAL", length = 80)
    private String chemotherapyHospital;
	
	@Column(name="RADIOTHERAPY_HOSPITAL", length = 80)
    private String radiotherapyHospital;
	
	@Column(name="FIRST_SURGERY_HOSPITAL", length = 80)
    private String firstSurgeryHospital;
	
	@Column(name="HOSPITAL_NO", length = 20)
    private String hospitalNo;
	
	@Column(name="PATHOLOGY_NO", length = 20)
    private String pathologyNo;

	@Column(name="SURGERY_DATE")
	private Date surgeryDate;
	
	@Column(name="SURGERY_TYPE", length = 1)
    private String surgeryType;
	
	@Column(name="RECUR_FLAG", length = 1)
    private String recurFlag;
	
	@Column(name="RECUR_COUNT", length = 2)
    private Integer recurCount;
	
	@Column(name="FIRST_RECUR_DATE")
    private Date firstRecurDate;
    
    @Column(name="SECOND_RECUR_DATE")
    private Date secondRecurDate;
    
    @Column(name="TUMOUR_TRANS_FLAG", length = 1)
    private String tumourTransFlag;
    
    @Column(name="TUMOUR_TRANS_PART", length = 100)
    private String tumourTransPart;
    
    @Column(name="FAMILY_TUMOUR", length = 1)
    private String familyTumour;
	
    @Column(name="FAMILY_REL", length = 20)
    private String familyRel;
    
    @Column(name="TUMOUR_TYPE", length = 40)
    private String tumourType;
    
    @Column(name="BACKOUT_DATE")
    private Date backoutDate;
    
    @Column(name="BACKOUT_REASON", length = 1)
    private String backoutReason;
    
    @Column(name="DEATH_DATE")
    private Date deathDate;
    
    @Column(name="DEATH_REASON", length = 1)
    private String deathReason;
    
    @Column(name="DEATH_OTHER_ADDR", length = 40)
    private String deathOtherAddr;
    
    @Column(name="LIFETIME_YEAR", length = 2)
    private Integer lifetimeYear;
    
    @Column(name="LIFETIME_MONTH", length = 2)
    private Integer lifetimeMonth;
    
    @Column(name="HOSPITAL_ID", nullable=false, precision=18)
    private Long hospitalId;
    
    @Column(name="CREATE_TIME")
    private Date createTime;

	@Column(name="CREATOR_ID", nullable=false, precision=18)
	private Long creatorId;

	@Column(name="VALID_FLAG", length = 1)
	private String validFlag;
	
	/** icd编码  */
    @Column(name="ICD_CODE", length = 40)
    private String icdCode;
    
    /** icd  */
    @Column(name="ICD", length = 40)
    private String icd;
    
    /** 始发部位  */
    @Column(name="ORIG_PART", length = 40)
    private String origPart;

	public PersonTumourCure() {
	    
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
     * @return the otherCure
     */
    public String getOtherCure() {
        return otherCure;
    }

    /**
     * @param otherCure the otherCure to set
     */
    public void setOtherCure(String otherCure) {
        this.otherCure = otherCure;
    }

    /**
     * @return the cureHospital
     */
    public String getCureHospital() {
        return cureHospital;
    }

    /**
     * @param cureHospital the cureHospital to set
     */
    public void setCureHospital(String cureHospital) {
        this.cureHospital = cureHospital;
    }

    /**
     * @return the surgeryHospital
     */
    public String getSurgeryHospital() {
        return surgeryHospital;
    }

    /**
     * @param surgeryHospital the surgeryHospital to set
     */
    public void setSurgeryHospital(String surgeryHospital) {
        this.surgeryHospital = surgeryHospital;
    }

    /**
     * @return the chemotherapyHospital
     */
    public String getChemotherapyHospital() {
        return chemotherapyHospital;
    }

    /**
     * @param chemotherapyHospital the chemotherapyHospital to set
     */
    public void setChemotherapyHospital(String chemotherapyHospital) {
        this.chemotherapyHospital = chemotherapyHospital;
    }

    /**
     * @return the radiotherapyHospital
     */
    public String getRadiotherapyHospital() {
        return radiotherapyHospital;
    }

    /**
     * @param radiotherapyHospital the radiotherapyHospital to set
     */
    public void setRadiotherapyHospital(String radiotherapyHospital) {
        this.radiotherapyHospital = radiotherapyHospital;
    }

    /**
     * @return the firstSurgeryHospital
     */
    public String getFirstSurgeryHospital() {
        return firstSurgeryHospital;
    }

    /**
     * @param firstSurgeryHospital the firstSurgeryHospital to set
     */
    public void setFirstSurgeryHospital(String firstSurgeryHospital) {
        this.firstSurgeryHospital = firstSurgeryHospital;
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
     * @return the pathologyNo
     */
    public String getPathologyNo() {
        return pathologyNo;
    }

    /**
     * @param pathologyNo the pathologyNo to set
     */
    public void setPathologyNo(String pathologyNo) {
        this.pathologyNo = pathologyNo;
    }

    /**
     * @return the surgeryDate
     */
    public Date getSurgeryDate() {
        return surgeryDate;
    }

    /**
     * @param surgeryDate the surgeryDate to set
     */
    public void setSurgeryDate(Date surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    /**
     * @return the surgeryType
     */
    public String getSurgeryType() {
        return surgeryType;
    }

    /**
     * @param surgeryType the surgeryType to set
     */
    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    /**
     * @return the recurFlag
     */
    public String getRecurFlag() {
        return recurFlag;
    }

    /**
     * @param recurFlag the recurFlag to set
     */
    public void setRecurFlag(String recurFlag) {
        this.recurFlag = recurFlag;
    }

    /**
     * @return the recurCount
     */
    public Integer getRecurCount() {
        return recurCount;
    }

    /**
     * @param recurCount the recurCount to set
     */
    public void setRecurCount(Integer recurCount) {
        this.recurCount = recurCount;
    }

    /**
     * @return the firstRecurDate
     */
    public Date getFirstRecurDate() {
        return firstRecurDate;
    }

    /**
     * @param firstRecurDate the firstRecurDate to set
     */
    public void setFirstRecurDate(Date firstRecurDate) {
        this.firstRecurDate = firstRecurDate;
    }

    /**
     * @return the secondRecurDate
     */
    public Date getSecondRecurDate() {
        return secondRecurDate;
    }

    /**
     * @param secondRecurDate the secondRecurDate to set
     */
    public void setSecondRecurDate(Date secondRecurDate) {
        this.secondRecurDate = secondRecurDate;
    }

    /**
     * @return the tumourTransFlag
     */
    public String getTumourTransFlag() {
        return tumourTransFlag;
    }

    /**
     * @param tumourTransFlag the tumourTransFlag to set
     */
    public void setTumourTransFlag(String tumourTransFlag) {
        this.tumourTransFlag = tumourTransFlag;
    }

    /**
     * @return the tumourTransPart
     */
    public String getTumourTransPart() {
        return tumourTransPart;
    }

    /**
     * @param tumourTransPart the tumourTransPart to set
     */
    public void setTumourTransPart(String tumourTransPart) {
        this.tumourTransPart = tumourTransPart;
    }

    /**
     * @return the familyTumour
     */
    public String getFamilyTumour() {
        return familyTumour;
    }

    /**
     * @param familyTumour the familyTumour to set
     */
    public void setFamilyTumour(String familyTumour) {
        this.familyTumour = familyTumour;
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
     * @return the tumourType
     */
    public String getTumourType() {
        return tumourType;
    }

    /**
     * @param tumourType the tumourType to set
     */
    public void setTumourType(String tumourType) {
        this.tumourType = tumourType;
    }

    /**
     * @return the backoutDate
     */
    public Date getBackoutDate() {
        return backoutDate;
    }

    /**
     * @param backoutDate the backoutDate to set
     */
    public void setBackoutDate(Date backoutDate) {
        this.backoutDate = backoutDate;
    }

    /**
     * @return the backoutReason
     */
    public String getBackoutReason() {
        return backoutReason;
    }

    /**
     * @param backoutReason the backoutReason to set
     */
    public void setBackoutReason(String backoutReason) {
        this.backoutReason = backoutReason;
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
     * @return the deathOtherAddr
     */
    public String getDeathOtherAddr() {
        return deathOtherAddr;
    }

    /**
     * @param deathOtherAddr the deathOtherAddr to set
     */
    public void setDeathOtherAddr(String deathOtherAddr) {
        this.deathOtherAddr = deathOtherAddr;
    }

    /**
     * @return the lifetimeYear
     */
    public Integer getLifetimeYear() {
        return lifetimeYear;
    }

    /**
     * @param lifetimeYear the lifetimeYear to set
     */
    public void setLifetimeYear(Integer lifetimeYear) {
        this.lifetimeYear = lifetimeYear;
    }

    /**
     * @return the lifetimeMonth
     */
    public Integer getLifetimeMonth() {
        return lifetimeMonth;
    }

    /**
     * @param lifetimeMonth the lifetimeMonth to set
     */
    public void setLifetimeMonth(Integer lifetimeMonth) {
        this.lifetimeMonth = lifetimeMonth;
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

    /**
     * @return the icdCode
     */
    public String getIcdCode() {
        return icdCode;
    }

    /**
     * @param icdCode the icdCode to set
     */
    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    /**
     * @return the icd
     */
    public String getIcd() {
        return icd;
    }

    /**
     * @param icd the icd to set
     */
    public void setIcd(String icd) {
        this.icd = icd;
    }

    /**
     * @return the origPart
     */
    public String getOrigPart() {
        return origPart;
    }

    /**
     * @param origPart the origPart to set
     */
    public void setOrigPart(String origPart) {
        this.origPart = origPart;
    }

}