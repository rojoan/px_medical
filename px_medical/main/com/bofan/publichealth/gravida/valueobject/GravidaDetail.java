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
 * @Description: 孕产妇登记卡
 * @author lqw
 */
@Entity
@Table(name = "GRAVIDA_DETAIL", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "GRAVIDA_DETAIL_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".GRAVIDA_DETAIL_ID", allocationSize = 1)
public class GravidaDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRAVIDA_DETAIL_ID")
	@Column(name = "GRAVIDA_DETAIL_ID", unique = true, nullable = false, precision = 18, scale = 0)
	/** 孕产妇登记卡ID */
	private Long gravidaDetailId;
	
	/** 个人基本信息ID */
	@Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
	
	/** 行政区域--城镇街道ID 分三级管理 省（直辖市） ：001  市（地区）     ：001001 县（城区）     ：001001001 */
	@Column(name = "REGION_ID", length = 18)
	private String regionId;
	
	/** 保健卡号 */
	@Column(name = "GRAVIDA_CARD", length = 40)
	private String gravidaCard;
	
	/** 孕妇姓名 */
	@Column(name = "GRAVIDA_NAME", nullable = false, length = 20)
	private String gravidaName;
	
	/** 孕妇年龄 */
	@Column(name = "GRAVIDA_AGE", precision = 2, scale = 0)
	private Integer gravidaAge;
	
	/** 是否定义为高危孕妇 1=是 0=否 */
	@Column(name = "HIGH_RISK_PREGNANCY", length = 1)
	private String highRiskPregnancy;
	
	/** 高危因素 */
	@Column(name = "HIGH_RISK_FACTOR", length = 2000)
	private String highRiskFactor;
	
	/** 身份证号码 */
	@Column(name = "GRAVIDA_ID_CARD", nullable = false, length = 40)
	private String gravidaIdCard;
	
	/** 联系电话 */
	@Column(name = "GRAVIDA_PHONE", nullable = false, length = 30)
	private String gravidaPhone;
	
	/** 联系地址 */
	@Column(name = "GRAVIDA_ADDR", length = 200)
	private String gravidaAddr;
	
	/** 孕妇户籍地 */
	@Column(name = "GRAVIDA_CENSUS", length = 100)
	private String gravidaCensus;
	
	/** 丈夫姓名 */
	@Column(name = "HUSBAND_NAME", length = 20)
	private String husbandName;
	
	/** 丈夫身份证号 */
	@Column(name = "HUSBAND_ID_CARD", length = 40)
	private String husbandIdCard;
	
	/** 丈夫年龄 */
	@Column(name = "HUSBAND_AGE", precision = 2, scale = 0)
	private Long husbandAge;
	
	/** 丈夫户籍地 */
	@Column(name = "HUSBAND_CENSUS", length = 100)
	private String husbandCensus;
	
	/** 登记（填表）日期 */
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
	@Column(name = "CREATE_TIME")
	private Date createTime;
	
	/** 登记人ID */
	@Column(name = "CREATOR_ID", precision = 18, scale = 0)
	private Long creatorId;
	
	/** 登记人 */
	@Column(name = "CREATOR_NAME", length = 20)
	private String creatorName;
	
	/** 建册医疗机构ID 对应sys_org表的 主键ID */
	@Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;
	
	/** 建册医院名称 */
	@Column(name = "HOSPITAL_NAME", nullable = false, length = 200)
	private String hospitalName;
	
	/** 建册医院代码 */
	@Column(name = "HOSPITAL_NO", nullable = false, length = 50)
	private String hospitalNo;
	
	/** 医院联系电话  */
	@Column(name = "HOSPITAL_PHONE", length = 30)
	private String hospitalPhone;
	
	/** 备注 */
	@Column(name = "REMARK", length = 200)
	private String remark;
	
	/** 是否有效 1=有效 0=无效 */
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
    private String validFlag;

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
	 * @return gravidaCard
	 */
	public String getGravidaCard() {
		return gravidaCard;
	}

	/**
	 * @param gravidaCard 要设置的 gravidaCard
	 */
	public void setGravidaCard(String gravidaCard) {
		this.gravidaCard = gravidaCard;
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
	 * @return gravidaIdCard
	 */
	public String getGravidaIdCard() {
		return gravidaIdCard;
	}

	/**
	 * @param gravidaIdCard 要设置的 gravidaIdCard
	 */
	public void setGravidaIdCard(String gravidaIdCard) {
		this.gravidaIdCard = gravidaIdCard;
	}

	/**
	 * @return gravidaPhone
	 */
	public String getGravidaPhone() {
		return gravidaPhone;
	}

	/**
	 * @param gravidaPhone 要设置的 gravidaPhone
	 */
	public void setGravidaPhone(String gravidaPhone) {
		this.gravidaPhone = gravidaPhone;
	}

	/**
	 * @return gravidaAddr
	 */
	public String getGravidaAddr() {
		return gravidaAddr;
	}

	/**
	 * @param gravidaAddr 要设置的 gravidaAddr
	 */
	public void setGravidaAddr(String gravidaAddr) {
		this.gravidaAddr = gravidaAddr;
	}

	/**
	 * @return gravidaCensus
	 */
	public String getGravidaCensus() {
		return gravidaCensus;
	}

	/**
	 * @param gravidaCensus 要设置的 gravidaCensus
	 */
	public void setGravidaCensus(String gravidaCensus) {
		this.gravidaCensus = gravidaCensus;
	}

	/**
	 * @return husbandName
	 */
	public String getHusbandName() {
		return husbandName;
	}

	/**
	 * @param husbandName 要设置的 husbandName
	 */
	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}

	/**
	 * @return husbandIdCard
	 */
	public String getHusbandIdCard() {
		return husbandIdCard;
	}

	/**
	 * @param husbandIdCard 要设置的 husbandIdCard
	 */
	public void setHusbandIdCard(String husbandIdCard) {
		this.husbandIdCard = husbandIdCard;
	}

	/**
	 * @return husbandAge
	 */
	public Long getHusbandAge() {
		return husbandAge;
	}

	/**
	 * @param husbandAge 要设置的 husbandAge
	 */
	public void setHusbandAge(Long husbandAge) {
		this.husbandAge = husbandAge;
	}

	/**
	 * @return husbandCensus
	 */
	public String getHusbandCensus() {
		return husbandCensus;
	}

	/**
	 * @param husbandCensus 要设置的 husbandCensus
	 */
	public void setHusbandCensus(String husbandCensus) {
		this.husbandCensus = husbandCensus;
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
	 * @return hospitalPhone
	 */
	public String getHospitalPhone() {
		return hospitalPhone;
	}

	/**
	 * @param hospitalPhone 要设置的 hospitalPhone
	 */
	public void setHospitalPhone(String hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
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