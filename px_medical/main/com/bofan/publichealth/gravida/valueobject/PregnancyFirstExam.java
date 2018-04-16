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
 * @Description: 孕产妇初次孕检记录表 
 *  听诊、妇科检查、辅助检查：填写到 gravide_exam_item表、 gravide_aux_item
 * @author lqw
 */
@Entity
@Table(name = "PREGNANCY_FIRST_EXAM", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PREGNANCY_FIRST_EXAM_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PREGNANCY_FIRST_EXAM_ID", allocationSize = 1)
public class PregnancyFirstExam {
	
    /** 初次孕检记录ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREGNANCY_FIRST_EXAM_ID")
    @Column(name = "PREGNANCY_FIRST_EXAM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long pregnancyFirstExamId;
	
    /** 孕产妇登记卡ID，自动增长ID */
    @Column(name = "GRAVIDA_DETAIL_ID", precision = 18, scale = 0)
	private Long gravidaDetailId;
	
    /** 个人基本信息ID */
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
	
    /** 孕妇姓名 */
    @Column(name = "GRAVIDA_NAME", length = 20)
	private String gravidaName;
	
    /** 填表孕周 */
    @Column(name = "CUR_GESTATIONAL_WEEK", precision = 3, scale = 0)
	private Integer curGestationalWeek;
	
    /** 末次月经时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "LAST_MENORRHE_TIME")
	private Date lastMenorrheTime;
	
    /** 预产期 */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "GRAVIDA_YIELD")
	private Date gravidaYield;
	
    /** 是否有妇科手术史  1=有 0=无 */
    @Column(name = "GYN_OPERATION_FLAG", length = 1)
	private String gynOperationFlag;
	
    /** 手术史描述 */
    @Column(name = "GYN_OPERATION_CONTENT", length = 100)
	private String gynOperationContent;
	
    /** 孕产史--孕次 */
    @Column(name = "GRAVIDA_COUNT", precision = 2, scale = 0)
	private Integer gravidaCount;
	
    /** 孕产史--人流史 */
    @Column(name = "ABORTION_COUNT", precision = 2, scale = 0)
	private Integer abortionCount;
	
    /** 产次--阴道分娩 */
    @Column(name = "VAGINAL_DELIVERY", precision = 2, scale = 0)
	private Integer vaginalDelivery;
	
    /** 产次--剖宫产 */
    @Column(name = "CESAREAN_DELIVERY", precision = 2, scale = 0)
	private Integer cesareanDelivery;
	
    /** 孕产史--成活 */
    @Column(name = "LIVE_DELIVERY", precision = 2, scale = 0)
	private Integer liveDelivery;
	
    /** 孕产史--妊高症 */
    @Column(name = "HYP_SYNDROME", length = 40)
	private String hypSyndrome;
	
    /** 孕早期其他描述 */
    @Column(name = "PREGNANCY_CONTENT", length = 40)
	private String pregnancyContent;
	
    /** 身高（cm） */
    @Column(name = "HEIGHT", precision = 4, scale = 1)
	private BigDecimal height;
	
    /** 体重（kg） */
    @Column(name = "WEIGHT", precision = 4, scale = 1)
	private BigDecimal weight;
	
    /** 体质指数（BMI） */
    @Column(name = "BODY_INDEX", precision = 8)
	private BigDecimal bodyIndex;
	
    /** 血压左（mmHg） */
    @Column(name = "LBLOOD_PRESSURE", precision = 3, scale = 0)
	private Integer lbloodPressure;
	
    /** 血压右（mmHg） */
    @Column(name = "RBLOOD_PRESSURE", precision = 3, scale = 0)
	private Integer rbloodPressure;
	
    /** 化验--血常规 */
    @Column(name = "BLOOD_ROUTINE_EXAM", length = 20)
	private String bloodRoutineExam;
	
    /** 化验--MCV */
    @Column(name = "MCV_EXAM", precision = 3, scale = 0)
	private Integer mcvExam;
	
    /** 化验--MCH */
    @Column(name = "MCH_EXAM", precision = 4, scale = 1)
	private BigDecimal mchExam;
	
    /** 化验--血型 */
    @Column(name = "BLOOD_TYPE", length = 10)
	private String bloodType;
	
    /** 化验--血小板 */
    @Column(name = "BLOOD_PLATELET", length = 20)
	private String bloodPlatelet;
	
    /** 化验--肝功能 */
    @Column(name = "LIVER_FUNCTION", length = 10)
	private String liverFunction;
	
    /** 化验--HBsAg */
    @Column(name = "HBSAG", length = 10)
	private String hbsag;
	
    /** 化验--心电图 */
    @Column(name = "ECG_PICTURE", length = 40)
	private String ecgPicture;
	
    /** 化验--尿常规 */
    @Column(name = "URINALYSIS", length = 10)
	private String urinalysis;
	
    /** 化验--白带常规 */
    @Column(name = "LEUCORRHEA", length = 10)
	private String leucorrhea;
	
    /** 化验--HIV */
    @Column(name = "HIV", length = 10)
	private String hiv;
	
    /** 化验--梅毒 */
    @Column(name = "SYPHILIS", length = 10)
	private String syphilis;
	
    /** 化验--丙肝 */
    @Column(name = "HCV", length = 10)
	private String hcv;
	
    /** 超声波诊断 */
    @Column(name = "PACS_DIAGNOSE", length = 100)
	private String pacsDiagnose;
	
    /** 诊断 */
    @Column(name = "DIAGNOSE", length = 100)
	private String diagnose;
	
    /** 丈夫健康状况--不良 */
    @Column(name = "HUSBAND_LIVE_WAY", length = 20)
	private String husbandLiveWay;
	
    /** 丈夫健康状况--遗传病 */
    @Column(name = "HUSBAND_GENETIC_DISEASE", length = 20)
	private String husbandGeneticDisease;
	
    /** 丈夫血型 */
    @Column(name = "HUSBAND_BLOOD_TYPE", length = 10)
	private String husbandBloodType;
	
    /** 是否转诊  1=是 0=否 */
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
	
    /** 检查医疗机构ID 对应sys_org表的 主键ID */
    @Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;
	
    /** 检查医院名称 */
    @Column(name = "HOSPITAL_NAME", nullable = false, length = 200)
	private String hospitalName;
	
    /** 责任医生ID */
    @Column(name = "DUTY_DOCTOR_ID", precision = 18, scale = 0)
	private Long dutyDoctorId;
	
    /** 责任医生 */
    @Column(name = "DUTY_DOCTOR_NAME", length = 20)
	private String dutyDoctorName;
	
    /** 备注 */
    @Column(name = "REMARK", length = 200)
	private String remark;
	
    /** 孕检（登记）日期 */
    @Column(name = "CUR_EXAM_TIME", nullable = false)
	private Date curExamTime;

	/** default constructor */
	public PregnancyFirstExam() {
	}

    /**
     * @return pregnancyFirstExamId
     */
    public Long getPregnancyFirstExamId() {
        return pregnancyFirstExamId;
    }

    /**
     * @param pregnancyFirstExamId 要设置的 pregnancyFirstExamId
     */
    public void setPregnancyFirstExamId(Long pregnancyFirstExamId) {
        this.pregnancyFirstExamId = pregnancyFirstExamId;
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
     * @return curGestationalWeek
     */
    public Integer getCurGestationalWeek() {
        return curGestationalWeek;
    }

    /**
     * @param curGestationalWeek 要设置的 curGestationalWeek
     */
    public void setCurGestationalWeek(Integer curGestationalWeek) {
        this.curGestationalWeek = curGestationalWeek;
    }

    /**
     * @return lastMenorrheTime
     */
    public Date getLastMenorrheTime() {
        return lastMenorrheTime;
    }

    /**
     * @param lastMenorrheTime 要设置的 lastMenorrheTime
     */
    public void setLastMenorrheTime(Date lastMenorrheTime) {
        this.lastMenorrheTime = lastMenorrheTime;
    }

    /**
     * @return gravidaYield
     */
    public Date getGravidaYield() {
        return gravidaYield;
    }

    /**
     * @param gravidaYield 要设置的 gravidaYield
     */
    public void setGravidaYield(Date gravidaYield) {
        this.gravidaYield = gravidaYield;
    }

    /**
     * @return gynOperationFlag
     */
    public String getGynOperationFlag() {
        return gynOperationFlag;
    }

    /**
     * @param gynOperationFlag 要设置的 gynOperationFlag
     */
    public void setGynOperationFlag(String gynOperationFlag) {
        this.gynOperationFlag = gynOperationFlag;
    }

    /**
     * @return gynOperationContent
     */
    public String getGynOperationContent() {
        return gynOperationContent;
    }

    /**
     * @param gynOperationContent 要设置的 gynOperationContent
     */
    public void setGynOperationContent(String gynOperationContent) {
        this.gynOperationContent = gynOperationContent;
    }

    /**
     * @return gravidaCount
     */
    public Integer getGravidaCount() {
        return gravidaCount;
    }

    /**
     * @param gravidaCount 要设置的 gravidaCount
     */
    public void setGravidaCount(Integer gravidaCount) {
        this.gravidaCount = gravidaCount;
    }

    /**
     * @return abortionCount
     */
    public Integer getAbortionCount() {
        return abortionCount;
    }

    /**
     * @param abortionCount 要设置的 abortionCount
     */
    public void setAbortionCount(Integer abortionCount) {
        this.abortionCount = abortionCount;
    }

    /**
     * @return vaginalDelivery
     */
    public Integer getVaginalDelivery() {
        return vaginalDelivery;
    }

    /**
     * @param vaginalDelivery 要设置的 vaginalDelivery
     */
    public void setVaginalDelivery(Integer vaginalDelivery) {
        this.vaginalDelivery = vaginalDelivery;
    }

    /**
     * @return cesareanDelivery
     */
    public Integer getCesareanDelivery() {
        return cesareanDelivery;
    }

    /**
     * @param cesareanDelivery 要设置的 cesareanDelivery
     */
    public void setCesareanDelivery(Integer cesareanDelivery) {
        this.cesareanDelivery = cesareanDelivery;
    }

    /**
     * @return liveDelivery
     */
    public Integer getLiveDelivery() {
        return liveDelivery;
    }

    /**
     * @param liveDelivery 要设置的 liveDelivery
     */
    public void setLiveDelivery(Integer liveDelivery) {
        this.liveDelivery = liveDelivery;
    }

    /**
     * @return hypSyndrome
     */
    public String getHypSyndrome() {
        return hypSyndrome;
    }

    /**
     * @param hypSyndrome 要设置的 hypSyndrome
     */
    public void setHypSyndrome(String hypSyndrome) {
        this.hypSyndrome = hypSyndrome;
    }

    /**
     * @return pregnancyContent
     */
    public String getPregnancyContent() {
        return pregnancyContent;
    }

    /**
     * @param pregnancyContent 要设置的 pregnancyContent
     */
    public void setPregnancyContent(String pregnancyContent) {
        this.pregnancyContent = pregnancyContent;
    }

    /**
     * @return height
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * @param height 要设置的 height
     */
    public void setHeight(BigDecimal height) {
        this.height = height;
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
     * @return bodyIndex
     */
    public BigDecimal getBodyIndex() {
        return bodyIndex;
    }

    /**
     * @param bodyIndex 要设置的 bodyIndex
     */
    public void setBodyIndex(BigDecimal bodyIndex) {
        this.bodyIndex = bodyIndex;
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
     * @return bloodRoutineExam
     */
    public String getBloodRoutineExam() {
        return bloodRoutineExam;
    }

    /**
     * @param bloodRoutineExam 要设置的 bloodRoutineExam
     */
    public void setBloodRoutineExam(String bloodRoutineExam) {
        this.bloodRoutineExam = bloodRoutineExam;
    }

    /**
     * @return mcvExam
     */
    public Integer getMcvExam() {
        return mcvExam;
    }

    /**
     * @param mcvExam 要设置的 mcvExam
     */
    public void setMcvExam(Integer mcvExam) {
        this.mcvExam = mcvExam;
    }

    /**
     * @return mchExam
     */
    public BigDecimal getMchExam() {
        return mchExam;
    }

    /**
     * @param mchExam 要设置的 mchExam
     */
    public void setMchExam(BigDecimal mchExam) {
        this.mchExam = mchExam;
    }

    /**
     * @return bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * @param bloodType 要设置的 bloodType
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * @return bloodPlatelet
     */
    public String getBloodPlatelet() {
        return bloodPlatelet;
    }

    /**
     * @param bloodPlatelet 要设置的 bloodPlatelet
     */
    public void setBloodPlatelet(String bloodPlatelet) {
        this.bloodPlatelet = bloodPlatelet;
    }

    /**
     * @return liverFunction
     */
    public String getLiverFunction() {
        return liverFunction;
    }

    /**
     * @param liverFunction 要设置的 liverFunction
     */
    public void setLiverFunction(String liverFunction) {
        this.liverFunction = liverFunction;
    }

    /**
     * @return hbsag
     */
    public String getHbsag() {
        return hbsag;
    }

    /**
     * @param hbsag 要设置的 hbsag
     */
    public void setHbsag(String hbsag) {
        this.hbsag = hbsag;
    }

    /**
     * @return ecgPicture
     */
    public String getEcgPicture() {
        return ecgPicture;
    }

    /**
     * @param ecgPicture 要设置的 ecgPicture
     */
    public void setEcgPicture(String ecgPicture) {
        this.ecgPicture = ecgPicture;
    }

    /**
     * @return urinalysis
     */
    public String getUrinalysis() {
        return urinalysis;
    }

    /**
     * @param urinalysis 要设置的 urinalysis
     */
    public void setUrinalysis(String urinalysis) {
        this.urinalysis = urinalysis;
    }

    /**
     * @return leucorrhea
     */
    public String getLeucorrhea() {
        return leucorrhea;
    }

    /**
     * @param leucorrhea 要设置的 leucorrhea
     */
    public void setLeucorrhea(String leucorrhea) {
        this.leucorrhea = leucorrhea;
    }

    /**
     * @return hiv
     */
    public String getHiv() {
        return hiv;
    }

    /**
     * @param hiv 要设置的 hiv
     */
    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    /**
     * @return syphilis
     */
    public String getSyphilis() {
        return syphilis;
    }

    /**
     * @param syphilis 要设置的 syphilis
     */
    public void setSyphilis(String syphilis) {
        this.syphilis = syphilis;
    }

    /**
     * @return hcv
     */
    public String getHcv() {
        return hcv;
    }

    /**
     * @param hcv 要设置的 hcv
     */
    public void setHcv(String hcv) {
        this.hcv = hcv;
    }

    /**
     * @return pacsDiagnose
     */
    public String getPacsDiagnose() {
        return pacsDiagnose;
    }

    /**
     * @param pacsDiagnose 要设置的 pacsDiagnose
     */
    public void setPacsDiagnose(String pacsDiagnose) {
        this.pacsDiagnose = pacsDiagnose;
    }

    /**
     * @return diagnose
     */
    public String getDiagnose() {
        return diagnose;
    }

    /**
     * @param diagnose 要设置的 diagnose
     */
    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    /**
     * @return husbandLiveWay
     */
    public String getHusbandLiveWay() {
        return husbandLiveWay;
    }

    /**
     * @param husbandLiveWay 要设置的 husbandLiveWay
     */
    public void setHusbandLiveWay(String husbandLiveWay) {
        this.husbandLiveWay = husbandLiveWay;
    }

    /**
     * @return husbandGeneticDisease
     */
    public String getHusbandGeneticDisease() {
        return husbandGeneticDisease;
    }

    /**
     * @param husbandGeneticDisease 要设置的 husbandGeneticDisease
     */
    public void setHusbandGeneticDisease(String husbandGeneticDisease) {
        this.husbandGeneticDisease = husbandGeneticDisease;
    }

    /**
     * @return husbandBloodType
     */
    public String getHusbandBloodType() {
        return husbandBloodType;
    }

    /**
     * @param husbandBloodType 要设置的 husbandBloodType
     */
    public void setHusbandBloodType(String husbandBloodType) {
        this.husbandBloodType = husbandBloodType;
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