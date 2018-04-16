package com.bofan.publichealth.gravida.valueobject;

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
 * 孕妇分娩记录表 分娩记录中新生儿登记，数据填写在child_detal表中
 * @author lqw
 */
@Entity
@Table(name = "GRAVIDA_PARTURITION", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "GRAVIDA_PARTURITION_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".GRAVIDA_PARTURITION_ID", allocationSize = 1)
public class GravidaParturition {

    /** 孕后分娩记录ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRAVIDA_PARTURITION_ID")
    @Column(name = "GRAVIDA_PARTURITION_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long gravidaParturitionId;

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
	
	/** 孕妇年龄 */
	@Column(name = "GRAVIDA_AGE", precision = 2, scale = 0)
	private Integer gravidaAge;
	
	/** 本次分娩次 */
	@Column(name = "PARTURITION_NUM", precision = 2, scale = 0)
	private Integer parturitionNum;
	
	/** 孕周 */
	@Column(name = "PREGNANCY_WEEK", nullable = false, length = 20)
	private String pregnancyWeek;
	
	/** 胎位  1=正常2=颜面3=高置4=臀位5=枕前6=枕后 */
	@Column(name = "FETUS_POSITION", length = 1)
	private String fetusPosition;
	
	/** 分娩日期 */
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "PARTURITION_TIME")
	private Date parturitionTime;
	
	/** 胎数 */
	@Column(name = "FETUS_NUM", nullable = false, precision = 1, scale = 0)
	private Integer fetusNum;
	
	/** 分娩方式 1=自然2=臀位产3=臀牵引4=吸引产5=钳产6=破腹产7=其他 */
	@Column(name = "PARTURITION_WAY", length = 1)
	private String parturitionWay;
	
	/** 外缝针线 */
	@Column(name = "SURGICAL_SUTURE", length = 40)
	private String surgicalSuture;
	
	/** 血流量（ml） */
	@Column(name = "BLOOD_FLOW_VOLUME", nullable = false, precision = 3, scale = 0)
	private Integer bloodFlowVolume;
	
	/** 会阴裂伤情况 1=无裂伤2=切开3=3度4=2度5=1度6=其他 */
	@Column(name = "PERINEAL_LACERATION", length = 1)
	private String perinealLaceration;
	
	/** 分娩地点分类 1=医院2=妇幼保健院3=家庭4=其他 */
	@Column(name = "PARTURITION_ADDR_TYPE", length = 1)
	private String parturitionAddrType;
	
	/** 分娩地点 */
	@Column(name = "PARTURITION_ADDR", length = 200)
	private String parturitionAddr;
	
	/** 有无生育证0=无1=有 */
	@Column(name = "BIRTH_CERTIFICATE_FLAG", length = 1)
	private String birthCertificateFlag;
	
	/** 生育证编号 */
	@Column(name = "BIRTH_CERTIFICATE_NUM", length = 40)
	private String birthCertificateNum;
	
	/** 出院时间 */
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "OUTHOSPITAL_TIME")
	private Date outhospitalTime;
	
	/** 产妇身体1=良好2=一般3=较差 */
	@Column(name = "PUERPERA_BODY_FLAG", length = 1)
	private String puerperaBodyFlag;
	
	/** 产休地 */
	@Column(name = "PUERPERA_ADDR", length = 200)
	private String puerperaAddr;

	/** 接生医生ID */
	@Column(name = "DELIVER_DOCTOR_ID", precision = 18, scale = 0)
	private Long deliverDoctorId;
	
	/** 接生医生 */
	@Column(name = "DELIVER_DOCTOR_NAME", length = 20)
	private String deliverDoctorName;
	
	/** 接产医疗机构ID 对应sys_org表的 主键ID */
	@Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;
	
	/** 接产医院名称 */
	@Column(name = "HOSPITAL_NAME", nullable = false, length = 200)
	private String hospitalName;
	
	/** 登记日期 */
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "CUR_CREATE_TIME", nullable = false)
	private Date curCreateTime;
	
	/** 备注 */
	@Column(name = "REMARK", length = 200)
	private String remark;

	/** default constructor */
	public GravidaParturition() {
	}

    /**
     * @return gravidaParturitionId
     */
    public Long getGravidaParturitionId() {
        return gravidaParturitionId;
    }

    /**
     * @param gravidaParturitionId 要设置的 gravidaParturitionId
     */
    public void setGravidaParturitionId(Long gravidaParturitionId) {
        this.gravidaParturitionId = gravidaParturitionId;
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
     * @return gravidaAge
     */
    public Integer getGravidaAge() {
        return gravidaAge;
    }

    /**
     * @param gravidaAge 要设置的 gravidaAge
     */
    public void setGravidaAge(Integer gravidaAge) {
        this.gravidaAge = gravidaAge;
    }

    /**
     * @return parturitionNum
     */
    public Integer getParturitionNum() {
        return parturitionNum;
    }

    /**
     * @param parturitionNum 要设置的 parturitionNum
     */
    public void setParturitionNum(Integer parturitionNum) {
        this.parturitionNum = parturitionNum;
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
     * @return fetusPosition
     */
    public String getFetusPosition() {
        return fetusPosition;
    }

    /**
     * @param fetusPosition 要设置的 fetusPosition
     */
    public void setFetusPosition(String fetusPosition) {
        this.fetusPosition = fetusPosition;
    }

    /**
     * @return parturitionTime
     */
    public Date getParturitionTime() {
        return parturitionTime;
    }

    /**
     * @param parturitionTime 要设置的 parturitionTime
     */
    public void setParturitionTime(Date parturitionTime) {
        this.parturitionTime = parturitionTime;
    }

    /**
     * @return fetusNum
     */
    public Integer getFetusNum() {
        return fetusNum;
    }

    /**
     * @param fetusNum 要设置的 fetusNum
     */
    public void setFetusNum(Integer fetusNum) {
        this.fetusNum = fetusNum;
    }

    /**
     * @return parturitionWay
     */
    public String getParturitionWay() {
        return parturitionWay;
    }

    /**
     * @param parturitionWay 要设置的 parturitionWay
     */
    public void setParturitionWay(String parturitionWay) {
        this.parturitionWay = parturitionWay;
    }

    /**
     * @return surgicalSuture
     */
    public String getSurgicalSuture() {
        return surgicalSuture;
    }

    /**
     * @param surgicalSuture 要设置的 surgicalSuture
     */
    public void setSurgicalSuture(String surgicalSuture) {
        this.surgicalSuture = surgicalSuture;
    }

    /**
     * @return bloodFlowVolume
     */
    public Integer getBloodFlowVolume() {
        return bloodFlowVolume;
    }

    /**
     * @param bloodFlowVolume 要设置的 bloodFlowVolume
     */
    public void setBloodFlowVolume(Integer bloodFlowVolume) {
        this.bloodFlowVolume = bloodFlowVolume;
    }

    /**
     * @return perinealLaceration
     */
    public String getPerinealLaceration() {
        return perinealLaceration;
    }

    /**
     * @param perinealLaceration 要设置的 perinealLaceration
     */
    public void setPerinealLaceration(String perinealLaceration) {
        this.perinealLaceration = perinealLaceration;
    }

    /**
     * @return parturitionAddrType
     */
    public String getParturitionAddrType() {
        return parturitionAddrType;
    }

    /**
     * @param parturitionAddrType 要设置的 parturitionAddrType
     */
    public void setParturitionAddrType(String parturitionAddrType) {
        this.parturitionAddrType = parturitionAddrType;
    }

    /**
     * @return parturitionAddr
     */
    public String getParturitionAddr() {
        return parturitionAddr;
    }

    /**
     * @param parturitionAddr 要设置的 parturitionAddr
     */
    public void setParturitionAddr(String parturitionAddr) {
        this.parturitionAddr = parturitionAddr;
    }

    /**
     * @return birthCertificateFlag
     */
    public String getBirthCertificateFlag() {
        return birthCertificateFlag;
    }

    /**
     * @param birthCertificateFlag 要设置的 birthCertificateFlag
     */
    public void setBirthCertificateFlag(String birthCertificateFlag) {
        this.birthCertificateFlag = birthCertificateFlag;
    }

    /**
     * @return birthCertificateNum
     */
    public String getBirthCertificateNum() {
        return birthCertificateNum;
    }

    /**
     * @param birthCertificateNum 要设置的 birthCertificateNum
     */
    public void setBirthCertificateNum(String birthCertificateNum) {
        this.birthCertificateNum = birthCertificateNum;
    }

    /**
     * @return outhospitalTime
     */
    public Date getOuthospitalTime() {
        return outhospitalTime;
    }

    /**
     * @param outhospitalTime 要设置的 outhospitalTime
     */
    public void setOuthospitalTime(Date outhospitalTime) {
        this.outhospitalTime = outhospitalTime;
    }

    /**
     * @return puerperaBodyFlag
     */
    public String getPuerperaBodyFlag() {
        return puerperaBodyFlag;
    }

    /**
     * @param puerperaBodyFlag 要设置的 puerperaBodyFlag
     */
    public void setPuerperaBodyFlag(String puerperaBodyFlag) {
        this.puerperaBodyFlag = puerperaBodyFlag;
    }

    /**
     * @return puerperaAddr
     */
    public String getPuerperaAddr() {
        return puerperaAddr;
    }

    /**
     * @param puerperaAddr 要设置的 puerperaAddr
     */
    public void setPuerperaAddr(String puerperaAddr) {
        this.puerperaAddr = puerperaAddr;
    }

    /**
     * @return deliverDoctorId
     */
    public Long getDeliverDoctorId() {
        return deliverDoctorId;
    }

    /**
     * @param deliverDoctorId 要设置的 deliverDoctorId
     */
    public void setDeliverDoctorId(Long deliverDoctorId) {
        this.deliverDoctorId = deliverDoctorId;
    }

    /**
     * @return deliverDoctorName
     */
    public String getDeliverDoctorName() {
        return deliverDoctorName;
    }

    /**
     * @param deliverDoctorName 要设置的 deliverDoctorName
     */
    public void setDeliverDoctorName(String deliverDoctorName) {
        this.deliverDoctorName = deliverDoctorName;
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
     * @return curCreateTime
     */
    public Date getCurCreateTime() {
        return curCreateTime;
    }

    /**
     * @param curCreateTime 要设置的 curCreateTime
     */
    public void setCurCreateTime(Date curCreateTime) {
        this.curCreateTime = curCreateTime;
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