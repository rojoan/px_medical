package com.bofan.publichealth.elder.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 老年人自理能力评估主表
 * @author lqw
 */
@Entity
@Table(name = "ELDER_SELF_CARE_ABILITY", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "ELDER_SELF_CARE_ABILITY_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".ELDER_SELF_CARE_ABILITY_ID", allocationSize = 1)
public class ElderSelfCareAbility {

    /** 老年人自理能力评估ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ELDER_SELF_CARE_ABILITY_ID")
    @Column(name = "ELDER_SELF_CARE_ABILITY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long elderSelfCareAbilityId;
	
    /** 行政区域--城镇街道ID 分三级管理 省（直辖市） ：001  市（地区）     ：001001 县（城区）     ：001001001 */
    @Column(name = "REGION_ID", nullable = false, length = 18)
	private String regionId;
	
    /** 个人基本信息ID personal_detail（个人基本信息） 主键ID */
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
	
    /** 评估得分 */
    @Column(name = "SELF_CARE_ASSESS_SCORE", precision = 18, scale = 0)
	private Long selfCareAssessScore;
	
    /** 评估结果
              根据下表中5个方面进行评估，将各方面判断评分汇总后：
        1 =  0 - 3     分者为： 生活自理能力 - 可自理
        2 =  4 - 8     分者为： 生活自理能力 - 轻度依赖
        3 =  9 -  18  分者为： 生活自理能力 - 中度依赖
        4 =  >=19    分者为： 生活自理能力 - 不能自理 */
    @Column(name = "SELF_CARE_ASSESS_RESULT", length = 1)
	private String selfCareAssessResult;
	
    /** 评估医生ID */
    @Column(name = "ASSESS_DOCTOR_ID", nullable = false, precision = 18, scale = 0)
	private Long assessDoctorId;
	
    /** 评估医生 */
    @Column(name = "ASSESS_DOCTOR_NAME", nullable = false, length = 20)
	private String assessDoctorName;
	
    /** 评估日期 */
    @Column(name = "ASSESS_TIME", nullable = false, length = 7)
	private Date assessTime;
	
    /** 医疗机构ID 对应sys_org表的 主键ID */
    @Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;
	
    /** 医院编码（医疗机构代码） 对应sys_org 表中的 org_no  */
    @Column(name = "HOSPITAL_NO", nullable = false, length = 40)
	private String hospitalNo;
	
    /** 医疗机构名称 */
    @Column(name = "HOSPITAL_NAME", nullable = false, length = 80)
	private String hospitalName;

	/** default constructor */
	public ElderSelfCareAbility() {
	}

    /**
     * @return elderSelfCareAbilityId
     */
    public Long getElderSelfCareAbilityId() {
        return elderSelfCareAbilityId;
    }

    /**
     * @param elderSelfCareAbilityId 要设置的 elderSelfCareAbilityId
     */
    public void setElderSelfCareAbilityId(Long elderSelfCareAbilityId) {
        this.elderSelfCareAbilityId = elderSelfCareAbilityId;
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
     * @return selfCareAssessScore
     */
    public Long getSelfCareAssessScore() {
        return selfCareAssessScore;
    }

    /**
     * @param selfCareAssessScore 要设置的 selfCareAssessScore
     */
    public void setSelfCareAssessScore(Long selfCareAssessScore) {
        this.selfCareAssessScore = selfCareAssessScore;
    }

    /**
     * @return selfCareAssessResult
     */
    public String getSelfCareAssessResult() {
        return selfCareAssessResult;
    }

    /**
     * @param selfCareAssessResult 要设置的 selfCareAssessResult
     */
    public void setSelfCareAssessResult(String selfCareAssessResult) {
        this.selfCareAssessResult = selfCareAssessResult;
    }

    /**
     * @return assessDoctorId
     */
    public Long getAssessDoctorId() {
        return assessDoctorId;
    }

    /**
     * @param assessDoctorId 要设置的 assessDoctorId
     */
    public void setAssessDoctorId(Long assessDoctorId) {
        this.assessDoctorId = assessDoctorId;
    }

    /**
     * @return assessDoctorName
     */
    public String getAssessDoctorName() {
        return assessDoctorName;
    }

    /**
     * @param assessDoctorName 要设置的 assessDoctorName
     */
    public void setAssessDoctorName(String assessDoctorName) {
        this.assessDoctorName = assessDoctorName;
    }

    /**
     * @return assessTime
     */
    public Date getAssessTime() {
        return assessTime;
    }

    /**
     * @param assessTime 要设置的 assessTime
     */
    public void setAssessTime(Date assessTime) {
        this.assessTime = assessTime;
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