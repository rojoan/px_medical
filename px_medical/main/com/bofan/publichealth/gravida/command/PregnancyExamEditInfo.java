package com.bofan.publichealth.gravida.command;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 孕期检查记录表 
 * 健康指导填写：gravida_health_guide表
 * @author lqw
 */
public class PregnancyExamEditInfo {
    /** 孕期检查记录ID，自动增长ID */
	private Long pregnancyExamId;
	
    /** 孕产妇登记卡ID */
	private Long gravidaDetailId;
	
    /** 个人基本信息ID */
	private Long personDetailId;
   
    /** 行政区域--城镇街道ID 分三级管理  省（直辖市） ：001 市（地区）     ：001001 县（城区）     ：001001001 */
	private String regionId;
	
    /** 孕妇姓名 */
	private String gravidaName;
	
    /** 是否定义为高危孕妇 1=是 0=否 */
	private String highRiskPregnancy;
	
    /** 高危因素 在孕期检查过程中，出现高危，被定为高危孕妇， 同时更新gravida_detail（孕妇登记表） */
	private String highRiskFactor;
	
    /** 孕周 */
	private String pregnancyWeek;
	
    /** 主诉 */
	private String chiefAction;
	
    /** 心肺听诊 */
	private String heartLungAuscultation;
	
    /** 宫底高度（cm） */
	private BigDecimal uterusHeigth;
	
    /** 体重（kg） */
	private BigDecimal weight;

    /** 腹围（cm） */
	private BigDecimal waistline;
	
    /** 胎方位 */
	private String foetusPosition;
	
    /** 胎心率（次/分秒） */
	private Integer foetusHeartRate;
	
    /** 血压左（mmHg） */
    private Integer lbloodPressure;
    
    /** 血压右（mmHg） */
    private Integer rbloodPressure;
	
    /** 血红蛋白（mmHg） */
	private String hemoglobin;
	
    /** 尿常规--尿蛋白 */
	private String unineProtein;
	
    /** 水肿 */
	private String edema;
	
    /** 入盆 */
	private String beEngaged;
	
    /** 其他检查 */
	private String otherExam;
	
    /** 分类是否异常  0=未见异常  1=异常 */
	private String classifiedAnomaly;
	
    /** 分类名称 */
	private String classifiedAnomalyName;
	
    /** 分类对应--指导 */
	private String anomalyGuide;
	
    /** 其他指导 */
	private String otherGuide;
	
    /** 是否转诊  1=是  0=否 */
	private String transDiagnosisFlag;
	
    /** 转诊原因 */
	private String transDiagnosisReason;
	
    /** 转诊机构科室ID */
	private Long transDiagnosisOfficeId;
	
    /** 转诊机构科室 */
	private String transDiagnosisOfficeName;
	
    /** 下次检查日期 */
	private Date nextExamTime;
	
    /** 责任医生ID */
	private Long dutyDoctorId;
	
    /** 责任医生 */
	private String dutyDoctorName;
	
    /** 检查医疗机构ID 对应sys_org表的 主键ID */
	private Long hospitalId;
	
    /** 检查医院名称 */
	private String hospitalName;
	
    /** 备注 */
	private String remark;
	
    /** 孕期检查日期 */
    private Date curExamTime;

	/** default constructor */
	public PregnancyExamEditInfo() {
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

}