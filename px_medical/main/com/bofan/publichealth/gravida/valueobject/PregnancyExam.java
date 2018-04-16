package com.bofan.publichealth.gravida.valueobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description: 孕期检查记录表 
 * 健康指导填写：gravida_health_guide表
 * @author lqw
 */
@Entity
@Table(name = "PREGNANCY_EXAM", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PREGNANCY_EXAM_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PREGNANCY_EXAM_ID", allocationSize = 1)
public class PregnancyExam {
    /** 孕期检查记录ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREGNANCY_EXAM_ID")
    @Column(name = "PREGNANCY_EXAM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long pregnancyExamId;
	
    /** 孕产妇登记卡ID */
    @Column(name = "GRAVIDA_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long gravidaDetailId;
	
    /** 个人基本信息ID */
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
   
    /** 行政区域--城镇街道ID 分三级管理  省（直辖市） ：001 市（地区）     ：001001 县（城区）     ：001001001 */
    @Column(name = "REGION_ID", nullable = false, length = 18)
	private String regionId;
	
    /** 孕妇姓名 */
    @Column(name = "GRAVIDA_NAME", nullable = false, length = 20)
	private String gravidaName;
	
    /** 是否定义为高危孕妇 1=是 0=否 */
    @Column(name = "HIGH_RISK_PREGNANCY", nullable = false, length = 1)
	private String highRiskPregnancy;
	
    /** 高危因素 在孕期检查过程中，出现高危，被定为高危孕妇， 同时更新gravida_detail（孕妇登记表） */
    @Column(name = "HIGH_RISK_FACTOR", length = 2000)
	private String highRiskFactor;
	
    /** 孕周 */
    @Column(name = "PREGNANCY_WEEK", nullable = false, length = 20)
	private String pregnancyWeek;
	
    /** 主诉 */
    @Column(name = "CHIEF_ACTION", nullable = false, length = 4000)
	private String chiefAction;
	
    /** 心肺听诊 */
    @Column(name = "HEART_LUNG_AUSCULTATION", length = 100)
	private String heartLungAuscultation;
	
    /** 宫底高度（cm） */
    @Column(name = "UTERUS_HEIGTH", precision = 4, scale = 1)
	private BigDecimal uterusHeigth;
	
    /** 体重（kg） */
    @Column(name = "WEIGHT", precision = 4, scale = 1)
	private BigDecimal weight;

    /** 腹围（cm） */
    @Column(name = "WAISTLINE", precision = 4, scale = 1)
	private BigDecimal waistline;
	
    /** 胎方位 */
    @Column(name = "FOETUS_POSITION", length = 40)
	private String foetusPosition;
	
    /** 胎心率（次/分秒） */
    @Column(name = "FOETUS_HEART_RATE", precision = 3, scale = 0)
	private Integer foetusHeartRate;
	
    /** 血压左（mmHg） */
    @Column(name = "LBLOOD_PRESSURE", precision = 3, scale = 0)
	private Integer lbloodPressure;
    
    /** 血压右（mmHg） */
    @Column(name = "RBLOOD_PRESSURE", precision = 3, scale = 0)
    private Integer rbloodPressure;
     
	
    /** 血红蛋白（mmHg） */
    @Column(name = "HEMOGLOBIN", length = 100)
	private String hemoglobin;
	
    /** 尿常规--尿蛋白 */
    @Column(name = "UNINE_PROTEIN", length = 100) 
	private String unineProtein;
	
    /** 水肿 */
    @Column(name = "EDEMA", length = 100)
	private String edema;
	
    /** 入盆 */
    @Column(name = "BE_ENGAGED", length = 100)
	private String beEngaged;
	
    /** 其他检查 */
    @Column(name = "OTHER_EXAM", length = 100)
	private String otherExam;
	
    /** 分类是否异常  0=未见异常  1=异常 */
    @Column(name = "CLASSIFIED_ANOMALY", length = 1)
	private String classifiedAnomaly;
	
    /** 分类名称 */
    @Column(name = "CLASSIFIED_ANOMALY_NAME", length = 100)
	private String classifiedAnomalyName;
	
    /** 分类对应--指导 */
    @Column(name = "ANOMALY_GUIDE", length = 400)
	private String anomalyGuide;
	
    /** 其他指导 */
    @Column(name = "OTHER_GUIDE", length = 400)
	private String otherGuide;
	
    /** 是否转诊  1=是  0=否 */
    @Column(name = "TRANS_DIAGNOSIS_FLAG", length = 1)
	private String transDiagnosisFlag;
	
    /** 转诊原因 */
    @Column(name = "TRANS_DIAGNOSIS_REASON", length = 200)
	private String transDiagnosisReason;
	
    /** 转诊机构科室ID */
    @Column(name = "TRANS_DIAGNOSIS_OFFICE_ID", precision = 18, scale = 0)
	private Long transDiagnosisOfficeId;
	
    /** 转诊机构科室 */
    @Column(name = "TRANS_DIAGNOSIS_OFFICE_NAME", length = 200)
	private String transDiagnosisOfficeName;
	
    /** 下次检查日期 */
    @Column(name = "NEXT_EXAM_TIME")
	private Date nextExamTime;
	
    /** 责任医生ID */
    @Column(name = "DUTY_DOCTOR_ID", precision = 18, scale = 0)
	private Long dutyDoctorId;
	
    /** 责任医生 */
    @Column(name = "DUTY_DOCTOR_NAME", length = 20)
	private String dutyDoctorName;
	
    /** 检查医疗机构ID 对应sys_org表的 主键ID */
    @Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;
	
    /** 检查医院名称 */
    @Column(name = "HOSPITAL_NAME", nullable = false, length = 200)
	private String hospitalName;
	
    /** 孕期检查日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "CUR_EXAM_TIME", nullable = false)
	private Date curExamTime;
	
    /** 备注 */
    @Column(name = "REMARK", length = 200)
	private String remark;

	/** default constructor */
	public PregnancyExam() {
	}

    /**
     * @return pregnancyExamId
     */
    public Long getPregnancyExamId() {
        return pregnancyExamId;
    }

    /**
     * @param pregnancyExamId 要设置的 pregnancyExamId
     */
    public void setPregnancyExamId(Long pregnancyExamId) {
        this.pregnancyExamId = pregnancyExamId;
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
     * @return highRiskPregnancy
     */
    public String getHighRiskPregnancy() {
        return highRiskPregnancy;
    }

    /**
     * @param highRiskPregnancy 要设置的 highRiskPregnancy
     */
    public void setHighRiskPregnancy(String highRiskPregnancy) {
        this.highRiskPregnancy = highRiskPregnancy;
    }

    /**
     * @return highRiskFactor
     */
    public String getHighRiskFactor() {
        return highRiskFactor;
    }

    /**
     * @param highRiskFactor 要设置的 highRiskFactor
     */
    public void setHighRiskFactor(String highRiskFactor) {
        this.highRiskFactor = highRiskFactor;
    }

    /**
     * @return pregnancyWeek
     */
    public String getPregnancyWeek() {
        return pregnancyWeek;
    }

    /**
     * @param pregnancyWeek 要设置的 pregnancyWeek
     */
    public void setPregnancyWeek(String pregnancyWeek) {
        this.pregnancyWeek = pregnancyWeek;
    }

    /**
     * @return chiefAction
     */
    public String getChiefAction() {
        return chiefAction;
    }

    /**
     * @param chiefAction 要设置的 chiefAction
     */
    public void setChiefAction(String chiefAction) {
        this.chiefAction = chiefAction;
    }

    /**
     * @return heartLungAuscultation
     */
    public String getHeartLungAuscultation() {
        return heartLungAuscultation;
    }

    /**
     * @param heartLungAuscultation 要设置的 heartLungAuscultation
     */
    public void setHeartLungAuscultation(String heartLungAuscultation) {
        this.heartLungAuscultation = heartLungAuscultation;
    }

    /**
     * @return uterusHeigth
     */
    public BigDecimal getUterusHeigth() {
        return uterusHeigth;
    }

    /**
     * @param uterusHeigth 要设置的 uterusHeigth
     */
    public void setUterusHeigth(BigDecimal uterusHeigth) {
        this.uterusHeigth = uterusHeigth;
    }

    /**
     * @return weight
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * @param weight 要设置的 weight
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * @return waistline
     */
    public BigDecimal getWaistline() {
        return waistline;
    }

    /**
     * @param waistline 要设置的 waistline
     */
    public void setWaistline(BigDecimal waistline) {
        this.waistline = waistline;
    }

    /**
     * @return foetusPosition
     */
    public String getFoetusPosition() {
        return foetusPosition;
    }

    /**
     * @param foetusPosition 要设置的 foetusPosition
     */
    public void setFoetusPosition(String foetusPosition) {
        this.foetusPosition = foetusPosition;
    }

    /**
     * @return foetusHeartRate
     */
    public Integer getFoetusHeartRate() {
        return foetusHeartRate;
    }

    /**
     * @param foetusHeartRate 要设置的 foetusHeartRate
     */
    public void setFoetusHeartRate(Integer foetusHeartRate) {
        this.foetusHeartRate = foetusHeartRate;
    }

    /**
     * @return lbloodPressure
     */
    public Integer getLbloodPressure() {
        return lbloodPressure;
    }

    /**
     * @param lbloodPressure 要设置的 lbloodPressure
     */
    public void setLbloodPressure(Integer lbloodPressure) {
        this.lbloodPressure = lbloodPressure;
    }

    /**
     * @return rbloodPressure
     */
    public Integer getRbloodPressure() {
        return rbloodPressure;
    }

    /**
     * @param rbloodPressure 要设置的 rbloodPressure
     */
    public void setRbloodPressure(Integer rbloodPressure) {
        this.rbloodPressure = rbloodPressure;
    }

    /**
     * @return hemoglobin
     */
    public String getHemoglobin() {
        return hemoglobin;
    }

    /**
     * @param hemoglobin 要设置的 hemoglobin
     */
    public void setHemoglobin(String hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    /**
     * @return unineProtein
     */
    public String getUnineProtein() {
        return unineProtein;
    }

    /**
     * @param unineProtein 要设置的 unineProtein
     */
    public void setUnineProtein(String unineProtein) {
        this.unineProtein = unineProtein;
    }

    /**
     * @return edema
     */
    public String getEdema() {
        return edema;
    }

    /**
     * @param edema 要设置的 edema
     */
    public void setEdema(String edema) {
        this.edema = edema;
    }

    /**
     * @return beEngaged
     */
    public String getBeEngaged() {
        return beEngaged;
    }

    /**
     * @param beEngaged 要设置的 beEngaged
     */
    public void setBeEngaged(String beEngaged) {
        this.beEngaged = beEngaged;
    }

    /**
     * @return otherExam
     */
    public String getOtherExam() {
        return otherExam;
    }

    /**
     * @param otherExam 要设置的 otherExam
     */
    public void setOtherExam(String otherExam) {
        this.otherExam = otherExam;
    }

    /**
     * @return classifiedAnomaly
     */
    public String getClassifiedAnomaly() {
        return classifiedAnomaly;
    }

    /**
     * @param classifiedAnomaly 要设置的 classifiedAnomaly
     */
    public void setClassifiedAnomaly(String classifiedAnomaly) {
        this.classifiedAnomaly = classifiedAnomaly;
    }

    /**
     * @return classifiedAnomalyName
     */
    public String getClassifiedAnomalyName() {
        return classifiedAnomalyName;
    }

    /**
     * @param classifiedAnomalyName 要设置的 classifiedAnomalyName
     */
    public void setClassifiedAnomalyName(String classifiedAnomalyName) {
        this.classifiedAnomalyName = classifiedAnomalyName;
    }

    /**
     * @return anomalyGuide
     */
    public String getAnomalyGuide() {
        return anomalyGuide;
    }

    /**
     * @param anomalyGuide 要设置的 anomalyGuide
     */
    public void setAnomalyGuide(String anomalyGuide) {
        this.anomalyGuide = anomalyGuide;
    }

    /**
     * @return otherGuide
     */
    public String getOtherGuide() {
        return otherGuide;
    }

    /**
     * @param otherGuide 要设置的 otherGuide
     */
    public void setOtherGuide(String otherGuide) {
        this.otherGuide = otherGuide;
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
     * @return nextExamTime
     */
    public Date getNextExamTime() {
        return nextExamTime;
    }

    /**
     * @param nextExamTime 要设置的 nextExamTime
     */
    public void setNextExamTime(Date nextExamTime) {
        this.nextExamTime = nextExamTime;
    }

    /**
     * @return dutyDoctorId
     */
    public Long getDutyDoctorId() {
        return dutyDoctorId;
    }

    /**
     * @param dutyDoctorId 要设置的 dutyDoctorId
     */
    public void setDutyDoctorId(Long dutyDoctorId) {
        this.dutyDoctorId = dutyDoctorId;
    }

    /**
     * @return dutyDoctorName
     */
    public String getDutyDoctorName() {
        return dutyDoctorName;
    }

    /**
     * @param dutyDoctorName 要设置的 dutyDoctorName
     */
    public void setDutyDoctorName(String dutyDoctorName) {
        this.dutyDoctorName = dutyDoctorName;
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
     * @return curExamTime
     */
    public Date getCurExamTime() {
        return curExamTime;
    }

    /**
     * @param curExamTime 要设置的 curExamTime
     */
    public void setCurExamTime(Date curExamTime) {
        this.curExamTime = curExamTime;
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

}