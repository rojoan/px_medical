package com.bofan.publichealth.valueobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;


/**
 * 高血压患者用药和治疗情况
 * 
 */
@Entity
@Table(name="PERSON_HYP_CURE", schema = SchemaConsts.PUBLIC_HEALTH)
public class PersonHypCure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PERSON_CHRONIC_ID")
	private Long personChronicId;

	@Column(name="AB")
	private String ab;

	@Column(name="ACEI")
	private String acei;

	@Column(name="ARB")
	private String arb;

	@Column(name="BB")
	private String bb;

	@Column(name="CADUET")
	private String caduet;

	@Column(name="CCB")
	private String ccb;

	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="CREATOR_ID")
	private Long creatorId;

	private String diuretic;

	@Column(name="DRUG_SIDE_EFFECT_FLAG")
	private String drugSideEffectFlag;

	@Column(name="DRUG_SIDE_EFFECT_REMARK")
	private String drugSideEffectRemark;

	@Column(name="HOSPITAL_ID")
	private Long hospitalId;

	@Column(name="HYP_CURE_FLAG")
	private String hypCureFlag;

	@Column(name="OTHER_CURE")
	private String otherCure;

	@Column(name="PERSON_DETAIL_ID")
	private Long personDetailId;

	@Column(name="VALID_FLAG")
	private String validFlag;

	public PersonHypCure() {
	}

	public Long getPersonChronicId() {
		return this.personChronicId;
	}

	public void setPersonChronicId(Long personChronicId) {
		this.personChronicId = personChronicId;
	}

	public String getAb() {
		return this.ab;
	}

	public void setAb(String ab) {
		this.ab = ab;
	}

	public String getAcei() {
		return this.acei;
	}

	public void setAcei(String acei) {
		this.acei = acei;
	}

	public String getArb() {
		return this.arb;
	}

	public void setArb(String arb) {
		this.arb = arb;
	}

	public String getBb() {
		return this.bb;
	}

	public void setBb(String bb) {
		this.bb = bb;
	}

	public String getCaduet() {
		return this.caduet;
	}

	public void setCaduet(String caduet) {
		this.caduet = caduet;
	}

	public String getCcb() {
		return this.ccb;
	}

	public void setCcb(String ccb) {
		this.ccb = ccb;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public String getDiuretic() {
		return this.diuretic;
	}

	public void setDiuretic(String diuretic) {
		this.diuretic = diuretic;
	}

	public String getDrugSideEffectFlag() {
		return this.drugSideEffectFlag;
	}

	public void setDrugSideEffectFlag(String drugSideEffectFlag) {
		this.drugSideEffectFlag = drugSideEffectFlag;
	}

	public String getDrugSideEffectRemark() {
		return this.drugSideEffectRemark;
	}

	public void setDrugSideEffectRemark(String drugSideEffectRemark) {
		this.drugSideEffectRemark = drugSideEffectRemark;
	}

	public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHypCureFlag() {
		return this.hypCureFlag;
	}

	public void setHypCureFlag(String hypCureFlag) {
		this.hypCureFlag = hypCureFlag;
	}

	public String getOtherCure() {
		return this.otherCure;
	}

	public void setOtherCure(String otherCure) {
		this.otherCure = otherCure;
	}

	public Long getPersonDetailId() {
		return this.personDetailId;
	}

	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	public String getValidFlag() {
		return this.validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

}