package com.bofan.publichealth.command;

import java.util.Date;

/**
 * @Description: 死亡登记 编辑信息
 * @author lqw
 */
public class DeathRecordEditInfo {

    /** 死亡登记ID */
	private Long deathRecordId;
	
    /** 行政区域--城镇街道ID 分三级管理  省（直辖市） ：001 市（地区）     ：001001 县（城区）     ：001001001 */
	private String regionId;
	
    /** 儿童基本信息ID（与个人基本信息ID不能同时为空） 对应  child_detail（儿童基本信息表） 主键ID */
	private Long childDetailId;
	
    /** 个人基本信息ID 对应  person_detail（个人基本信息表） 主键ID */
	private Long personDetailId;
	
    /** 姓名（冗余字段） */
	private String vaccinatedName;
	
    /** 性别，冗余字段  1：男 2：女 */
	private String gender;
	
    /** 出生日期，冗余字段 */
	private Date birthDate;
	
    /** 是否孕妇-儿童  0= 1=孕妇 2=儿童 */
	private String deathFlag;
	
    /** 死亡地点 */
	private String deathSite;
	
    /** 死亡日期 */
	private Date deathTime;
	
    /** 死亡年龄 */
	private Long deathAge;
	
    /** 死亡诊断 */
	private String deathClinic;
	
    /** 家庭联系电话 */
	private String familyPhone;
	
    /** 家庭地址 */
	private String familyAddr;
	
    /** 录入人ID */
	private Long creatorId;
	
    /** 录入人 */
	private String creatorName;
	
    /** 录入医疗机构ID 对应sys_org表的 主键ID */
	private Long hospitalId;
	
    /** 录入医院编码（医疗机构代码） 对应sys_org 表中的 org_no */
	private String hospitalNo;
	
    /** 录入医疗机构名称 */
	private String hospitalName;
 
	/** default constructor */
	public DeathRecordEditInfo() {
	}

    /**
     * @return deathRecordId
     */
    public Long getDeathRecordId() {
        return deathRecordId;
    }

    /**
     * @param deathRecordId 要设置的 deathRecordId
     */
    public void setDeathRecordId(Long deathRecordId) {
        this.deathRecordId = deathRecordId;
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
     * @return childDetailId
     */
    public Long getChildDetailId() {
        return childDetailId;
    }

    /**
     * @param childDetailId 要设置的 childDetailId
     */
    public void setChildDetailId(Long childDetailId) {
        this.childDetailId = childDetailId;
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
     * @return vaccinatedName
     */
    public String getVaccinatedName() {
        return vaccinatedName;
    }

    /**
     * @param vaccinatedName 要设置的 vaccinatedName
     */
    public void setVaccinatedName(String vaccinatedName) {
        this.vaccinatedName = vaccinatedName;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender 要设置的 gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate 要设置的 birthDate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return deathFlag
     */
    public String getDeathFlag() {
        return deathFlag;
    }

    /**
     * @param deathFlag 要设置的 deathFlag
     */
    public void setDeathFlag(String deathFlag) {
        this.deathFlag = deathFlag;
    }

    /**
     * @return deathSite
     */
    public String getDeathSite() {
        return deathSite;
    }

    /**
     * @param deathSite 要设置的 deathSite
     */
    public void setDeathSite(String deathSite) {
        this.deathSite = deathSite;
    }

    /**
     * @return deathTime
     */
    public Date getDeathTime() {
        return deathTime;
    }

    /**
     * @param deathTime 要设置的 deathTime
     */
    public void setDeathTime(Date deathTime) {
        this.deathTime = deathTime;
    }

    /**
     * @return deathAge
     */
    public Long getDeathAge() {
        return deathAge;
    }

    /**
     * @param deathAge 要设置的 deathAge
     */
    public void setDeathAge(Long deathAge) {
        this.deathAge = deathAge;
    }

    /**
     * @return deathClinic
     */
    public String getDeathClinic() {
        return deathClinic;
    }

    /**
     * @param deathClinic 要设置的 deathClinic
     */
    public void setDeathClinic(String deathClinic) {
        this.deathClinic = deathClinic;
    }

    /**
     * @return familyPhone
     */
    public String getFamilyPhone() {
        return familyPhone;
    }

    /**
     * @param familyPhone 要设置的 familyPhone
     */
    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    /**
     * @return familyAddr
     */
    public String getFamilyAddr() {
        return familyAddr;
    }

    /**
     * @param familyAddr 要设置的 familyAddr
     */
    public void setFamilyAddr(String familyAddr) {
        this.familyAddr = familyAddr;
    }

    /**
     * @return creatorId
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId 要设置的 creatorId
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return creatorName
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * @param creatorName 要设置的 creatorName
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
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
     * @return hospitalNo
     */
    public String getHospitalNo() {
        return hospitalNo;
    }

    /**
     * @param hospitalNo 要设置的 hospitalNo
     */
    public void setHospitalNo(String hospitalNo) {
        this.hospitalNo = hospitalNo;
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
}