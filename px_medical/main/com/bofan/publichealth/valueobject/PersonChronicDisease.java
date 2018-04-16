package com.bofan.publichealth.valueobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;


/**
 * 慢性病患者相关病史和家族史实体
 * 
 */
@Entity
@Table(name="PERSON_CHRONIC_DISEASE", schema = SchemaConsts.PUBLIC_HEALTH)
public class PersonChronicDisease implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PERSON_CHRONIC_ID")
	private Long personChronicId;

	@Column(name="ANGINA_AGE")
	private Long anginaAge;

	@Column(name="ANGINA_FLAG")
	private String anginaFlag;

	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="CREATOR_ID")
	private Long creatorId;

	@Column(name="DIABETES_AGE")
	private Long diabetesAge;

	@Column(name="DIABETES_FLAG")
	private String diabetesFlag;

	@Column(name="FAMILY_CHD_FLAG")
	private String familyChdFlag;

	@Column(name="FAMILY_DIABETES_FLAG")
	private String familyDiabetesFlag;

	@Column(name="FAMILY_HYP_FLAG")
	private String familyHypFlag;

	@Column(name="FAMILY_STROKE_FLAG")
	private String familyStrokeFlag;

	@Column(name="HOSPITAL_ID")
	private Long hospitalId;

	@Column(name="HYP_AGE")
	private BigDecimal hypAge;

	@Column(name="HYP_FLAG")
	private String hypFlag;

	@Column(name="MCAO_AGE")
	private BigDecimal mcaoAge;

	@Column(name="MCAO_FLAG")
	private String mcaoFlag;

	@Column(name="OTHER_DISEASE")
	private String otherDisease;

	@Column(name="PERSON_DETAIL_ID")
	private Long personDetailId;

	@Column(name="STEMI_AGE")
	private BigDecimal stemiAge;

	@Column(name="STEMI_FLAG")
	private String stemiFlag;

	@Column(name="STROKE_AGE")
	private BigDecimal strokeAge;

	@Column(name="STROKE_FLAG")
	private String strokeFlag;

	@Column(name="VALID_FLAG")
	private String validFlag;

	public PersonChronicDisease() {
	}

	public Long getPersonChronicId() {
		return this.personChronicId;
	}

	public void setPersonChronicId(Long personChronicId) {
		this.personChronicId = personChronicId;
	}

	public Long getAnginaAge() {
		return this.anginaAge;
	}

	public void setAnginaAge(Long anginaAge) {
		this.anginaAge = anginaAge;
	}

	public String getAnginaFlag() {
		return this.anginaFlag;
	}

	public void setAnginaFlag(String anginaFlag) {
		this.anginaFlag = anginaFlag;
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

	public Long getDiabetesAge() {
		return this.diabetesAge;
	}

	public void setDiabetesAge(Long diabetesAge) {
		this.diabetesAge = diabetesAge;
	}

	public String getDiabetesFlag() {
		return this.diabetesFlag;
	}

	public void setDiabetesFlag(String diabetesFlag) {
		this.diabetesFlag = diabetesFlag;
	}

	public String getFamilyChdFlag() {
		return this.familyChdFlag;
	}

	public void setFamilyChdFlag(String familyChdFlag) {
		this.familyChdFlag = familyChdFlag;
	}

	public String getFamilyDiabetesFlag() {
		return this.familyDiabetesFlag;
	}

	public void setFamilyDiabetesFlag(String familyDiabetesFlag) {
		this.familyDiabetesFlag = familyDiabetesFlag;
	}

	public String getFamilyHypFlag() {
		return this.familyHypFlag;
	}

	public void setFamilyHypFlag(String familyHypFlag) {
		this.familyHypFlag = familyHypFlag;
	}

	public String getFamilyStrokeFlag() {
		return this.familyStrokeFlag;
	}

	public void setFamilyStrokeFlag(String familyStrokeFlag) {
		this.familyStrokeFlag = familyStrokeFlag;
	}

	public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public BigDecimal getHypAge() {
		return this.hypAge;
	}

	public void setHypAge(BigDecimal hypAge) {
		this.hypAge = hypAge;
	}

	public String getHypFlag() {
		return this.hypFlag;
	}

	public void setHypFlag(String hypFlag) {
		this.hypFlag = hypFlag;
	}

	public BigDecimal getMcaoAge() {
		return this.mcaoAge;
	}

	public void setMcaoAge(BigDecimal mcaoAge) {
		this.mcaoAge = mcaoAge;
	}

	public String getMcaoFlag() {
		return this.mcaoFlag;
	}

	public void setMcaoFlag(String mcaoFlag) {
		this.mcaoFlag = mcaoFlag;
	}

	public String getOtherDisease() {
		return this.otherDisease;
	}

	public void setOtherDisease(String otherDisease) {
		this.otherDisease = otherDisease;
	}

	public Long getPersonDetailId() {
		return this.personDetailId;
	}

	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	public BigDecimal getStemiAge() {
		return this.stemiAge;
	}

	public void setStemiAge(BigDecimal stemiAge) {
		this.stemiAge = stemiAge;
	}

	public String getStemiFlag() {
		return this.stemiFlag;
	}

	public void setStemiFlag(String stemiFlag) {
		this.stemiFlag = stemiFlag;
	}

	public BigDecimal getStrokeAge() {
		return this.strokeAge;
	}

	public void setStrokeAge(BigDecimal strokeAge) {
		this.strokeAge = strokeAge;
	}

	public String getStrokeFlag() {
		return this.strokeFlag;
	}

	public void setStrokeFlag(String strokeFlag) {
		this.strokeFlag = strokeFlag;
	}

	public String getValidFlag() {
		return this.validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}
}