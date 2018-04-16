package com.bofan.publichealth.gravida.command;

import java.util.Date;

/**
 * @Description: 产前筛查检查/手术记录表 
 * @author lqw
 */
public class GravidaSurgeryEditInfo {
	
    /** 产前手术记录ID，自动增长ID */
	private Long gravidaSurgeryId;
	
    /** 孕产妇登记卡ID */
	private Long gravidaDetailId;
	
    /** 个人基本信息ID */
	private Long personDetailId;
   
    /** 行政区域--城镇街道ID 分三级管理  省（直辖市） ：001 市（地区）     ：001001 县（城区）     ：001001001 */
	private String regionId;
	
    /** 孕妇姓名 */
	private String gravidaName;
	
    /** 孕妇年龄 */
	private Integer gravidaAge;
	
    /** 产前诊断编号 */
	private String pregnancySurgeryNo;
	
    /** 孕周 */
	private String pregnancyWeek;
	
    /** 手术过程 */
	private String chiefAction;
	
    /** 手术后注意事项 */
	private String heartLungAuscultation;
	
    /** 特殊记录 */
	private String uterusHeigth;
	
    /** 手术主治医生ID */
	private Long dutyDoctorId;
	
    /** 手术主治医生 */
	private String dutyDoctorName;
	
    /** 手术医疗机构ID 对应sys_org表的 主键ID */
	private Long hospitalId;
	
    /** 手术医院名称 */
	private String hospitalName;
	
    /** 手术日期 */
	private Date curSurgeryTime;
	
    /** 备注 */
	private String remark;
	
	/** 手术方式id */
	private Long surgeryWayId;
	 
	/** default constructor */
	public GravidaSurgeryEditInfo() {
	
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

    /**
     * @return surgeryWayId
     */
    public Long getSurgeryWayId() {
        return surgeryWayId;
    }

    /**
     * @param surgeryWayId 要设置的 surgeryWayId
     */
    public void setSurgeryWayId(Long surgeryWayId) {
        this.surgeryWayId = surgeryWayId;
    }

}