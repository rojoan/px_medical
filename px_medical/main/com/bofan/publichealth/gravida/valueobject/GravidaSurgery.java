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
 * @Description: 产前筛查检查/手术记录表 
 * @author lqw
 */
@Entity
@Table(name = "GRAVIDA_SURGERY", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "GRAVIDA_SURGERY_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".GRAVIDA_SURGERY_ID", allocationSize = 1)
public class GravidaSurgery {
	
    /** 产前手术记录ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRAVIDA_SURGERY_ID")
    @Column(name = "GRAVIDA_SURGERY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long gravidaSurgeryId;
	
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
	
    /** 产前诊断编号 */
    @Column(name = "PREGNANCY_SURGERY_NO", length = 40)
	private String pregnancySurgeryNo;
	
    /** 孕周 */
    @Column(name = "PREGNANCY_WEEK", nullable = false, length = 20)
	private String pregnancyWeek;
	
    /** 手术过程 */
    @Column(name = "CHIEF_ACTION", nullable = false, length = 4000)
	private String chiefAction;
	
    /** 手术后注意事项 */
    @Column(name = "HEART_LUNG_AUSCULTATION", length = 4000)
	private String heartLungAuscultation;
	
    /** 特殊记录 */
    @Column(name = "UTERUS_HEIGTH", length = 2000)
	private String uterusHeigth;
	
    /** 手术主治医生ID */
    @Column(name = "DUTY_DOCTOR_ID", precision = 18, scale = 0)
	private Long dutyDoctorId;
	
    /** 手术主治医生 */
    @Column(name = "DUTY_DOCTOR_NAME", length = 20)
	private String dutyDoctorName;
	
    /** 手术医疗机构ID 对应sys_org表的 主键ID */
    @Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;
	
    /** 手术医院名称 */
    @Column(name = "HOSPITAL_NAME", nullable = false, length = 200)
	private String hospitalName;
	
    /** 手术日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "CUR_SURGERY_TIME", nullable = false)
	private Date curSurgeryTime;
	
    /** 备注 */
    @Column(name = "REMARK", length = 200)
	private String remark;
	 
	/** default constructor */
	public GravidaSurgery() {
	
	}

    /**
     * @return gravidaSurgeryId
     */
    public Long getGravidaSurgeryId() {
        return gravidaSurgeryId;
    }

    /**
     * @param gravidaSurgeryId 要设置的 gravidaSurgeryId
     */
    public void setGravidaSurgeryId(Long gravidaSurgeryId) {
        this.gravidaSurgeryId = gravidaSurgeryId;
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
     * @return pregnancySurgeryNo
     */
    public String getPregnancySurgeryNo() {
        return pregnancySurgeryNo;
    }

    /**
     * @param pregnancySurgeryNo 要设置的 pregnancySurgeryNo
     */
    public void setPregnancySurgeryNo(String pregnancySurgeryNo) {
        this.pregnancySurgeryNo = pregnancySurgeryNo;
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
    public String getUterusHeigth() {
        return uterusHeigth;
    }

    /**
     * @param uterusHeigth 要设置的 uterusHeigth
     */
    public void setUterusHeigth(String uterusHeigth) {
        this.uterusHeigth = uterusHeigth;
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
     * @return curSurgeryTime
     */
    public Date getCurSurgeryTime() {
        return curSurgeryTime;
    }

    /**
     * @param curSurgeryTime 要设置的 curSurgeryTime
     */
    public void setCurSurgeryTime(Date curSurgeryTime) {
        this.curSurgeryTime = curSurgeryTime;
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