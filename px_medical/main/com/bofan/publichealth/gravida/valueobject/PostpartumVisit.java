package com.bofan.publichealth.gravida.valueobject;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Transient;

import com.bofan.utils.SchemaConsts;
import com.bofan.utils.Tools;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description: 产后访视--42天检查）包括42天后健康检查
 * @author lqw
 */
@Entity
@Table(name = "POSTPARTUM_VISIT", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "POSTPARTUM_VISIT_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".POSTPARTUM_VISIT_ID", allocationSize = 1)
public class PostpartumVisit {
	
    /** 产后访视ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTPARTUM_VISIT_ID")
    @Column(name = "POSTPARTUM_VISIT_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long postpartumVisitId;
	
    /** 孕产妇登记卡ID */
    @Column(name = "GRAVIDA_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long gravidaDetailId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GRAVIDA_DETAIL_ID", insertable = false, updatable = false)
    private GravidaDetail gravidaDetail;
	
    /** 个人基本信息ID */
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
  
    /** 行政区域--城镇街道ID 分三级管理  省（直辖市） ：001 市（地区）     ：001001 县（城区）     ：001001001 */
    @Column(name = "REGION_ID", length = 18)
	private String regionId;
	
    /** 孕妇姓名 */
    @Column(name = "GRAVIDA_NAME", nullable = false, length = 20)
	private String gravidaName;
	
    /** 是否产后42天检查  1=是  0=否 */
    @Column(name = "FORTY_TWO_EXAM_FLAG", nullable = false, length = 1)
	private String fortyTwoExamFlag;
	
    /** 体温 */
    @Column(name = "ANIMAL_HEAT", precision = 4, scale = 1)
	private Double animalHeat;
	
    /** 一般健康情况  包括精神、睡眠、饮食、大小便等； 测量产妇体温、血压； 乳房有无红肿、硬结，乳头有无裂伤，乳汁量的多少； 子宫底高度是否正常； 会阴或腹部伤口恢复情况，有无红肿及分泌物； 恶露的颜色、量是否正常，有无异常臭味。 发现异常情况动员产妇及时就诊。 */
    @Column(name = "COMMON_HEALTH", nullable = false, length = 400)
	private String commonHealth;
	
    /** 情绪低落、容易掉泪、精神懒散等现象（有/无）  1=有 0=无 */
    @Column(name = "MENTALITY_FLAG", nullable = false, length = 1)
	private String mentalityFlag;
	
    /** 一般心理状况 */
    @Column(name = "MENTALITY_STATE", nullable = false, length = 400)
	private String mentalityState;
	
    /** 血压高（mmHg） */
    @Column(name = "MAX_BLOOD_PRESSURE", precision = 3, scale = 0)
	private Integer maxBloodPressure;
	
    /** 血压低（mmHg） */
    @Column(name = "MIN_BLOOD_PRESSURE", precision = 3, scale = 0) 
	private Integer minBloodPressure;
	
    /** 乳房情况（是否异常） 0=未见异常 1=异常 */
    @Column(name = "BREAST_CASE_FLAG", length = 1)
	private String breastCaseFlag;
	
    /** 乳房异常详情 */
    @Column(name = "BREAST_CASE", length = 100)
	private String breastCase;
	
    /** 恶露（是否异常） 0=未见异常 1=异常 */
    @Column(name = "LOCHIA_FLAG", length = 1)
	private String lochiaFlag;
	
    /** 恶露异常详情 */
    @Column(name = "LOCHIA_CONTENT", length = 100)
	private String lochiaContent;
	
    /** 子宫情况（是否异常） 0=未见异常  1=异常 */
    @Column(name = "WOMB_FLAG", length = 1)
	private String wombFlag;

    /** 子宫异常详情 */
    @Column(name = "WOMB_CONTENT", length = 100)
	private String wombContent;
	
    /** 伤口情况（是否异常） 0=未见异常  1=异常 */
    @Column(name = "WOUND_FLAG", length = 1)
	private String woundFlag;
	
    /** 伤口异常详情 */
    @Column(name = "WOUND_CONTENT", length = 100)
	private String woundContent;
	
    /** 其他 */
    @Column(name = "OTHER_CNTENT", length = 100)
	private String otherCntent;
	
    /** 分类情况（是否异常） 0=未见异常 1=异常 */
    @Column(name = "CLASSIFY_FLAG", length = 1)
	private String classifyFlag;
	
    /** 分类异常详情 */
    @Column(name = "CLASSIFY_CONTENT", length = 100)
	private String classifyContent;
	
    /** 母乳喂养情况 */
    @Column(name = "BREAST_FEEDING", nullable = false, length = 200)
	private String breastFeeding;
   
    /** 指导  1=个人卫生 2=心理 3=营养   4=母乳喂养 5=新生儿护理与喂养 6=其他  */
    @Column(name = "HEALTH_GUIDE", nullable = false, length = 200)
	private String healthGuide;
	
    /** 其他指导 */
    @Column(name = "OTHER_HEALTH_GUIDE", length = 200)
	private String otherHealthGuide;

    /** 是否转诊  1=是 0=否 */
    @Column(name = "TRANS_DIAGNOSIS_FLAG", length = 1)
	private String transDiagnosisFlag;
	
    /** 转诊原因 */
    @Column(name = "TRANS_DIAGNOSIS_REASON", length = 200)
	private String transDiagnosisReason;
	
    /** 转诊有描述 */
    @Column(name = "TRANS_DIAGNOSIS_DESCRIBE", length = 200)
	private String transDiagnosisDescribe;
	
    /** 转诊机构科室ID */
    @Column(name = "TRANS_DIAGNOSIS_OFFICE_ID", precision = 18, scale = 0)
	private Long transDiagnosisOfficeId;
	
    /** 转诊机构科室 */
    @Column(name = "TRANS_DIAGNOSIS_OFFICE_NAME", length = 200)
	private String transDiagnosisOfficeName;
	
    /** 随访医生 */
    @Column(name = "VISIT_DOCTOR_NAME", length = 20)
	private String visitDoctorName;

    /** 随访医生ID */
    @Column(name = "VISIT_DOCTOR_ID", precision = 18, scale = 0)
	private Long visitDoctorId;
	
    /** 随访医疗机构ID 对应sys_org表的 主键ID */
    @Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;
	
    /** 随访医院名称 */
    @Column(name = "HOSPITAL_NAME", nullable = false, length = 200)
	private String hospitalName;
	
    /** 随访日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "VISIT_TIME", nullable = false)
	private Date visitTime;
	
    /** 下次随访日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "NEXT_VISIT_TIME", nullable = false)
	private Date nextVisitTime;
	
    /** 备注 */
    @Column(name = "REMARK", length = 200)
	private String remark;

    @Transient
    private List<String> healthGuideList ;
    
	/** default constructor */
	public PostpartumVisit() {
	}

    /**
     * @return postpartumVisitId
     */
    public Long getPostpartumVisitId() {
        return postpartumVisitId;
    }

    /**
     * @param postpartumVisitId 要设置的 postpartumVisitId
     */
    public void setPostpartumVisitId(Long postpartumVisitId) {
        this.postpartumVisitId = postpartumVisitId;
    }

    /**
     * @return gravidaDetailId
     */
    public Long getGravidaDetailId() {
        return gravidaDetailId;
    }

    /**
     * @param gravidaDetailId 要设置的 gravidaDetailId
     */
    public void setGravidaDetailId(Long gravidaDetailId) {
        this.gravidaDetailId = gravidaDetailId;
    }

    /**
     * @return gravidaDetail
     */
    public GravidaDetail getGravidaDetail() {
        return gravidaDetail;
    }

    /**
     * @param gravidaDetail 要设置的 gravidaDetail
     */
    public void setGravidaDetail(GravidaDetail gravidaDetail) {
        this.gravidaDetail = gravidaDetail;
    }

    /**
     * @return personDetailId
     */
    public Long getPersonDetailId() {
        return personDetailId;
    }

    /**
     * @param personDetailId 要设置的 personDetailId
     */
    public void setPersonDetailId(Long personDetailId) {
        this.personDetailId = personDetailId;
    }

    /**
     * @return regionId
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId 要设置的 regionId
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * @return gravidaName
     */
    public String getGravidaName() {
        return gravidaName;
    }

    /**
     * @param gravidaName 要设置的 gravidaName
     */
    public void setGravidaName(String gravidaName) {
        this.gravidaName = gravidaName;
    }

    /**
     * @return fortyTwoExamFlag
     */
    public String getFortyTwoExamFlag() {
        return fortyTwoExamFlag;
    }

    /**
     * @param fortyTwoExamFlag 要设置的 fortyTwoExamFlag
     */
    public void setFortyTwoExamFlag(String fortyTwoExamFlag) {
        this.fortyTwoExamFlag = fortyTwoExamFlag;
    }

    /**
     * @return animalHeat
     */
    public Double getAnimalHeat() {
        return animalHeat;
    }

    /**
     * @param animalHeat 要设置的 animalHeat
     */
    public void setAnimalHeat(Double animalHeat) {
        this.animalHeat = animalHeat;
    }

    /**
     * @return commonHealth
     */
    public String getCommonHealth() {
        return commonHealth;
    }

    /**
     * @param commonHealth 要设置的 commonHealth
     */
    public void setCommonHealth(String commonHealth) {
        this.commonHealth = commonHealth;
    }

    /**
     * @return mentalityFlag
     */
    public String getMentalityFlag() {
        return mentalityFlag;
    }

    /**
     * @param mentalityFlag 要设置的 mentalityFlag
     */
    public void setMentalityFlag(String mentalityFlag) {
        this.mentalityFlag = mentalityFlag;
    }

    /**
     * @return mentalityState
     */
    public String getMentalityState() {
        return mentalityState;
    }

    /**
     * @param mentalityState 要设置的 mentalityState
     */
    public void setMentalityState(String mentalityState) {
        this.mentalityState = mentalityState;
    }

    /**
     * @return maxBloodPressure
     */
    public Integer getMaxBloodPressure() {
        return maxBloodPressure;
    }

    /**
     * @param maxBloodPressure 要设置的 maxBloodPressure
     */
    public void setMaxBloodPressure(Integer maxBloodPressure) {
        this.maxBloodPressure = maxBloodPressure;
    }

    /**
     * @return minBloodPressure
     */
    public Integer getMinBloodPressure() {
        return minBloodPressure;
    }

    /**
     * @param minBloodPressure 要设置的 minBloodPressure
     */
    public void setMinBloodPressure(Integer minBloodPressure) {
        this.minBloodPressure = minBloodPressure;
    }

    /**
     * @return breastCaseFlag
     */
    public String getBreastCaseFlag() {
        return breastCaseFlag;
    }

    /**
     * @param breastCaseFlag 要设置的 breastCaseFlag
     */
    public void setBreastCaseFlag(String breastCaseFlag) {
        this.breastCaseFlag = breastCaseFlag;
    }

    /**
     * @return breastCase
     */
    public String getBreastCase() {
        return breastCase;
    }

    /**
     * @param breastCase 要设置的 breastCase
     */
    public void setBreastCase(String breastCase) {
        this.breastCase = breastCase;
    }

    /**
     * @return lochiaFlag
     */
    public String getLochiaFlag() {
        return lochiaFlag;
    }

    /**
     * @param lochiaFlag 要设置的 lochiaFlag
     */
    public void setLochiaFlag(String lochiaFlag) {
        this.lochiaFlag = lochiaFlag;
    }

    /**
     * @return lochiaContent
     */
    public String getLochiaContent() {
        return lochiaContent;
    }

    /**
     * @param lochiaContent 要设置的 lochiaContent
     */
    public void setLochiaContent(String lochiaContent) {
        this.lochiaContent = lochiaContent;
    }

    /**
     * @return wombFlag
     */
    public String getWombFlag() {
        return wombFlag;
    }

    /**
     * @param wombFlag 要设置的 wombFlag
     */
    public void setWombFlag(String wombFlag) {
        this.wombFlag = wombFlag;
    }

    /**
     * @return wombContent
     */
    public String getWombContent() {
        return wombContent;
    }

    /**
     * @param wombContent 要设置的 wombContent
     */
    public void setWombContent(String wombContent) {
        this.wombContent = wombContent;
    }

    /**
     * @return woundFlag
     */
    public String getWoundFlag() {
        return woundFlag;
    }

    /**
     * @param woundFlag 要设置的 woundFlag
     */
    public void setWoundFlag(String woundFlag) {
        this.woundFlag = woundFlag;
    }

    /**
     * @return woundContent
     */
    public String getWoundContent() {
        return woundContent;
    }

    /**
     * @param woundContent 要设置的 woundContent
     */
    public void setWoundContent(String woundContent) {
        this.woundContent = woundContent;
    }

    /**
     * @return otherCntent
     */
    public String getOtherCntent() {
        return otherCntent;
    }

    /**
     * @param otherCntent 要设置的 otherCntent
     */
    public void setOtherCntent(String otherCntent) {
        this.otherCntent = otherCntent;
    }

    /**
     * @return classifyFlag
     */
    public String getClassifyFlag() {
        return classifyFlag;
    }

    /**
     * @param classifyFlag 要设置的 classifyFlag
     */
    public void setClassifyFlag(String classifyFlag) {
        this.classifyFlag = classifyFlag;
    }

    /**
     * @return classifyContent
     */
    public String getClassifyContent() {
        return classifyContent;
    }

    /**
     * @param classifyContent 要设置的 classifyContent
     */
    public void setClassifyContent(String classifyContent) {
        this.classifyContent = classifyContent;
    }

    /**
     * @return breastFeeding
     */
    public String getBreastFeeding() {
        return breastFeeding;
    }

    /**
     * @param breastFeeding 要设置的 breastFeeding
     */
    public void setBreastFeeding(String breastFeeding) {
        this.breastFeeding = breastFeeding;
    }

    /**
     * @return healthGuide
     */
    public String getHealthGuide() {
        return healthGuide;
    }

    /**
     * @param healthGuide 要设置的 healthGuide
     */
    public void setHealthGuide(String healthGuide) {
        this.healthGuide = healthGuide;
    }

    /**
     * @return otherHealthGuide
     */
    public String getOtherHealthGuide() {
        return otherHealthGuide;
    }

    /**
     * @param otherHealthGuide 要设置的 otherHealthGuide
     */
    public void setOtherHealthGuide(String otherHealthGuide) {
        this.otherHealthGuide = otherHealthGuide;
    }

    /**
     * @return transDiagnosisFlag
     */
    public String getTransDiagnosisFlag() {
        return transDiagnosisFlag;
    }

    /**
     * @param transDiagnosisFlag 要设置的 transDiagnosisFlag
     */
    public void setTransDiagnosisFlag(String transDiagnosisFlag) {
        this.transDiagnosisFlag = transDiagnosisFlag;
    }

    /**
     * @return transDiagnosisReason
     */
    public String getTransDiagnosisReason() {
        return transDiagnosisReason;
    }

    /**
     * @param transDiagnosisReason 要设置的 transDiagnosisReason
     */
    public void setTransDiagnosisReason(String transDiagnosisReason) {
        this.transDiagnosisReason = transDiagnosisReason;
    }

    /**
     * @return transDiagnosisDescribe
     */
    public String getTransDiagnosisDescribe() {
        return transDiagnosisDescribe;
    }

    /**
     * @param transDiagnosisDescribe 要设置的 transDiagnosisDescribe
     */
    public void setTransDiagnosisDescribe(String transDiagnosisDescribe) {
        this.transDiagnosisDescribe = transDiagnosisDescribe;
    }

    /**
     * @return transDiagnosisOfficeId
     */
    public Long getTransDiagnosisOfficeId() {
        return transDiagnosisOfficeId;
    }

    /**
     * @param transDiagnosisOfficeId 要设置的 transDiagnosisOfficeId
     */
    public void setTransDiagnosisOfficeId(Long transDiagnosisOfficeId) {
        this.transDiagnosisOfficeId = transDiagnosisOfficeId;
    }

    /**
     * @return transDiagnosisOfficeName
     */
    public String getTransDiagnosisOfficeName() {
        return transDiagnosisOfficeName;
    }

    /**
     * @param transDiagnosisOfficeName 要设置的 transDiagnosisOfficeName
     */
    public void setTransDiagnosisOfficeName(String transDiagnosisOfficeName) {
        this.transDiagnosisOfficeName = transDiagnosisOfficeName;
    }

    /**
     * @return visitDoctorName
     */
    public String getVisitDoctorName() {
        return visitDoctorName;
    }

    /**
     * @param visitDoctorName 要设置的 visitDoctorName
     */
    public void setVisitDoctorName(String visitDoctorName) {
        this.visitDoctorName = visitDoctorName;
    }

    /**
     * @return visitDoctorId
     */
    public Long getVisitDoctorId() {
        return visitDoctorId;
    }

    /**
     * @param visitDoctorId 要设置的 visitDoctorId
     */
    public void setVisitDoctorId(Long visitDoctorId) {
        this.visitDoctorId = visitDoctorId;
    }

    /**
     * @return hospitalId
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId 要设置的 hospitalId
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * @return hospitalName
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * @param hospitalName 要设置的 hospitalName
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * @return visitTime
     */
    public Date getVisitTime() {
        return visitTime;
    }

    /**
     * @param visitTime 要设置的 visitTime
     */
    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    /**
     * @return nextVisitTime
     */
    public Date getNextVisitTime() {
        return nextVisitTime;
    }

    /**
     * @param nextVisitTime 要设置的 nextVisitTime
     */
    public void setNextVisitTime(Date nextVisitTime) {
        this.nextVisitTime = nextVisitTime;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark 要设置的 remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return healthGuideList
     */
    public List<String> getHealthGuideList() {
        if (Tools.isNotEmptyString(this.healthGuide)) {
            healthGuideList = Arrays.asList(this.healthGuide.split(","));  
        }
        return healthGuideList;
    }

}