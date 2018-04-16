package com.bofan.publichealth.gravida.command;

import java.util.Date;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description: 孕产妇登记卡 编辑
 * @author lqw
 */
public class GravidaDetailEditInfo  extends BaseCommandInfo{

	private static final long serialVersionUID = 8659261029132122705L;

	/** 孕产妇登记卡ID */
	private Long gravidaDetailId;
	
	/** 个人基本信息ID */
	private Long personDetailId;
	
	/** 行政区域--城镇街道ID 分三级管理 省（直辖市） ：001  市（地区）     ：001001 县（城区）     ：001001001 */
	private String regionId;
	
	/** 保健卡号 */
	private String gravidaCard;
	
	/** 孕妇姓名 */
	private String gravidaName;
	
	/** 孕妇年龄 */
	private Integer gravidaAge;
	
	/** 是否定义为高危孕妇 1=是 0=否 */
	private String highRiskPregnancy;
	
	/** 高危因素 */
	private String highRiskFactor;
	
	/** 身份证号码 */
	private String gravidaIdCard;
	
	/** 联系电话 */
	private String gravidaPhone;
	
	/** 联系地址 */
	private String gravidaAddr;
	
	/** 孕妇户籍地 */
	private String gravidaCensus;
	
	/** 丈夫姓名 */
	private String husbandName;
	
	/** 丈夫身份证号 */
	private String husbandIdCard;
	
	/** 丈夫年龄 */
	private Integer husbandAge;
	
	/** 丈夫户籍地 */
	private String husbandCensus;
	
	/** 登记（填表）日期 */
	private Date createTime;
	
	/** 登记人ID */
	private Long creatorId;
	
	/** 登记人 */
	private String creatorName;
	
	/** 建册医疗机构ID 对应sys_org表的 主键ID */
	private Long hospitalId;
	
	/** 建册医院名称 */
	private String hospitalName;
	
	/** 建册医院代码 */
	private String hospitalNo;
	
	/** 医院联系电话  */
	private String hospitalPhone;
	
	/** 备注 */
	private String remark;
	
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
	public Integer getHusbandAge() {
		return husbandAge;
	}
	/**
	 * @param husbandAge 要设置的 husbandAge
	 */
	public void setHusbandAge(Integer husbandAge) {
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

}