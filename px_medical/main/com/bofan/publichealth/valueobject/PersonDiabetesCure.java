package com.bofan.publichealth.valueobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;


/**
 * 糖尿病患者干预和治疗情况
 * 
 */
@Entity
@Table(name="PERSON_DIABETES_CURE", schema = SchemaConsts.PUBLIC_HEALTH)
public class PersonDiabetesCure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PERSON_CHRONIC_ID", nullable = false, precision = 18, scale = 0)
	private Long personChronicId;

	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="CREATOR_ID", precision = 18, scale = 0)
	private Long creatorId;

	@Column(name="DIABETES_CURE_FLAG")
	private String diabetesCureFlag;

	@Column(name="DRUG_SIDE_EFFECT_FLAG")
	private String drugSideEffectFlag;

	@Column(name="DRUG_SIDE_EFFECT_REMARK")
	private String drugSideEffectRemark;

	@Column(name="HOSPITAL_ID", precision = 18, scale = 0)
	private Long hospitalId;

	@Column(name="HYPOGLYCEMIC_DRUG")
	private String hypoglycemicDrug;

	private String insulin;

	@Column(name="INSULIN_ANALOG")
	private String insulinAnalog;

	@Column(name="PERSON_DETAIL_ID", precision = 18, scale = 0)
	private Long personDetailId;

	@Column(name="VALID_FLAG")
	private String validFlag;

	public PersonDiabetesCure() {
	}

	public Long getPersonChronicId() {
		return this.personChronicId;
	}

	public void setPersonChronicId(Long personChronicId) {
		this.personChronicId = personChronicId;
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

	public String getDiabetesCureFlag() {
		return this.diabetesCureFlag;
	}

	public void setDiabetesCureFlag(String diabetesCureFlag) {
		this.diabetesCureFlag = diabetesCureFlag;
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

	public String getHypoglycemicDrug() {
		return this.hypoglycemicDrug;
	}

	public void setHypoglycemicDrug(String hypoglycemicDrug) {
		this.hypoglycemicDrug = hypoglycemicDrug;
	}

	public String getInsulin() {
		return this.insulin;
	}

	public void setInsulin(String insulin) {
		this.insulin = insulin;
	}

	public String getInsulinAnalog() {
		return this.insulinAnalog;
	}

	public void setInsulinAnalog(String insulinAnalog) {
		this.insulinAnalog = insulinAnalog;
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