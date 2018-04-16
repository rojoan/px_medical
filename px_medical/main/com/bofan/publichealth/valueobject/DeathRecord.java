package com.bofan.publichealth.valueobject;

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
 * @Description: 死亡登记
 * @author lqw
 */
@Entity
@Table(name = "DEATH_RECORD", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "DEATH_RECORD_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".DEATH_RECORD_ID", allocationSize = 1)
public class DeathRecord {

    /** 死亡登记ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEATH_RECORD_ID")
    @Column(name = "DEATH_RECORD_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long deathRecordId;
	
    /** 行政区域--城镇街道ID 分三级管理  省（直辖市） ：001 市（地区）     ：001001 县（城区）     ：001001001 */
    @Column(name = "REGION_ID", nullable = false, length = 18)
	private String regionId;
	
    /** 儿童基本信息ID（与个人基本信息ID不能同时为空） 对应  child_detail（儿童基本信息表） 主键ID */
    @Column(name = "CHILD_DETAIL_ID", precision = 18, scale = 0)
	private Long childDetailId;
	
    /** 个人基本信息ID 对应  person_detail（个人基本信息表） 主键ID */
    @Column(name = "PERSON_DETAIL_ID", precision = 18, scale = 0)
	private Long personDetailId;
	
    /** 姓名（冗余字段） */
    @Column(name = "VACCINATED_NAME", nullable = false, length = 20)
	private String vaccinatedName;
	
    /** 性别，冗余字段  1：男 2：女 */
    @Column(name = "GENDER", length = 1)
	private String gender;
	
    /** 出生日期，冗余字段 */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "BIRTH_DATE", length = 7)
	private Date birthDate;
	
    /** 是否孕妇-儿童  0=居民 1=孕妇 2=儿童 */
    @Column(name = "DEATH_FLAG", length = 10)
	private String deathFlag;
	
    /** 死亡地点 */
    @Column(name = "DEATH_SITE", length = 200)
	private String deathSite;
	
    /** 死亡日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "DEATH_TIME", length = 10)
	private Date deathTime;
	
    /** 死亡年龄 */
    @Column(name = "DEATH_AGE", precision = 18, scale = 0)
	private Long deathAge;
	
    /** 死亡诊断 */
    @Column(name = "DEATH_CLINIC", length = 50)
	private String deathClinic;
	
    /** 家庭联系电话 */
    @Column(name = "FAMILY_PHONE", length = 20)
	private String familyPhone;
	
    /** 家庭地址 */
    @Column(name = "FAMILY_ADDR", length = 200)
	private String familyAddr;
	
    /** 录入人ID */
    @Column(name = "CREATOR_ID", nullable = false, precision = 22, scale = 0)
	private Long creatorId;
	
    /** 录入人 */
    @Column(name = "CREATOR_NAME", nullable = false, length = 20)
	private String creatorName;
	
    /** 录入时间 */
    @Column(name = "CREATE_TIME", nullable = false)
	private Date createTime;
	
    /** 录入医疗机构ID 对应sys_org表的 主键ID */
    @Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;
	
    /** 录入医院编码（医疗机构代码） 对应sys_org 表中的 org_no */
    @Column(name = "HOSPITAL_NO", nullable = false, length = 40)
	private String hospitalNo;
	
    /** 录入医疗机构名称 */
    @Column(name = "HOSPITAL_NAME", nullable = false, length = 80)
	private String hospitalName;
	
    /** 是否有效 1=有效 0=无效 */
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;
 
	/** default constructor */
	public DeathRecord() {
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
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 要设置的 createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    /**
     * @return validFlag
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag 要设置的 validFlag
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

}