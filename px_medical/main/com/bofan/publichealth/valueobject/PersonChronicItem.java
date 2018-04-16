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
 * 慢性病患者体格检查/生活行为实体
 * 
 */
@Entity
@Table(name="PERSON_CHRONIC_ITEM", schema = SchemaConsts.PUBLIC_HEALTH)
public class PersonChronicItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PERSON_CHRONIC_ID")
	private Long personChronicId;

	@Column(name="CREA")
	private BigDecimal crea;

	@Column(name="CREA_MG")
	private BigDecimal creaMg;

	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="CREATOR_ID")
	private Long creatorId;

	private String ecg;

	/** 心电图描述 */
	@Column(name="ECG_DESC")
	private String ecgDesc;

	@Column(name="FBG_MG")
	private BigDecimal fbgMg;

	@Column(name="FBG_MMOL")
	private BigDecimal fbgMmol;

	@Column(name="FRUITS_EVERYDAY")
	private BigDecimal fruitsEveryday;

	@Column(name="HDL_CHOLESTEROL")
	private BigDecimal hdlCholesterol;

	@Column(name="HDL_CHOLESTEROL_MG")
	private BigDecimal hdlCholesterolMg;

	@Column(name="HEART_PACS")
	private String heartPacs;

	/** 心脏超声描述 */
	@Column(name="HEART_PACS_DESC")
	private String heartPacsDesc;

	@Column(name="HEART_RATE")
	private BigDecimal heartRate;

	private BigDecimal height;

	@Column(name="HOSPITAL_ID")
	private Long hospitalId;

	@Column(name="MAX_BLOOD_PRESSURE")
	private BigDecimal maxBloodPressure;

	@Column(name="MIN_BLOOD_PRESSURE")
	private BigDecimal minBloodPressure;

	@Column(name="PERSON_DETAIL_ID")
	private Long personDetailId;

	@Column(name="PHYSICAL_TIME")
	private BigDecimal physicalTime;

	@Column(name="PHYSICAL_WEEK")
	private BigDecimal physicalWeek;

	@Column(name="RETINO_PATHY")
	private String retinoPathy;

	@Column(name="SMOKE_EVERYDAY")
	private BigDecimal smokeEveryday;

	private String taste;

	private BigDecimal tc;

	@Column(name="TC_MG")
	private BigDecimal tcMg;

	private BigDecimal tg;

	@Column(name="TG_MG")
	private BigDecimal tgMg;

	@Column(name="UNINE_PROTEIN")
	private String unineProtein;

	@Column(name="VALID_FLAG")
	private String validFlag;

	@Column(name="VEGETABLES_EVERYDAY")
	private BigDecimal vegetablesEveryday;

	private BigDecimal waistline;

	private BigDecimal weight;

	@Column(name="WINE_EVERYDAY")
	private String wineEveryday;

	public PersonChronicItem() {
	    
	}

	public Long getPersonChronicId() {
		return this.personChronicId;
	}

	public void setPersonChronicId(Long personChronicId) {
		this.personChronicId = personChronicId;
	}

	public BigDecimal getCrea() {
		return this.crea;
	}

	public void setCrea(BigDecimal crea) {
		this.crea = crea;
	}

	public BigDecimal getCreaMg() {
		return this.creaMg;
	}

	public void setCreaMg(BigDecimal creaMg) {
		this.creaMg = creaMg;
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

	public String getEcg() {
		return this.ecg;
	}

	public void setEcg(String ecg) {
		this.ecg = ecg;
	}

	public String getEcgDesc() {
		return this.ecgDesc;
	}

	public void setEcgDesc(String ecgDesc) {
		this.ecgDesc = ecgDesc;
	}

	public BigDecimal getFbgMg() {
		return this.fbgMg;
	}

	public void setFbgMg(BigDecimal fbgMg) {
		this.fbgMg = fbgMg;
	}

	public BigDecimal getFbgMmol() {
		return this.fbgMmol;
	}

	public void setFbgMmol(BigDecimal fbgMmol) {
		this.fbgMmol = fbgMmol;
	}

	public BigDecimal getFruitsEveryday() {
		return this.fruitsEveryday;
	}

	public void setFruitsEveryday(BigDecimal fruitsEveryday) {
		this.fruitsEveryday = fruitsEveryday;
	}

	public BigDecimal getHdlCholesterol() {
		return this.hdlCholesterol;
	}

	public void setHdlCholesterol(BigDecimal hdlCholesterol) {
		this.hdlCholesterol = hdlCholesterol;
	}

	public BigDecimal getHdlCholesterolMg() {
		return this.hdlCholesterolMg;
	}

	public void setHdlCholesterolMg(BigDecimal hdlCholesterolMg) {
		this.hdlCholesterolMg = hdlCholesterolMg;
	}

	public String getHeartPacs() {
		return this.heartPacs;
	}

	public void setHeartPacs(String heartPacs) {
		this.heartPacs = heartPacs;
	}

	public String getHeartPacsDesc() {
		return this.heartPacsDesc;
	}

	public void setHeartPacsDesc(String heartPacsDesc) {
		this.heartPacsDesc = heartPacsDesc;
	}

	public BigDecimal getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(BigDecimal heartRate) {
		this.heartRate = heartRate;
	}

	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public BigDecimal getMaxBloodPressure() {
		return this.maxBloodPressure;
	}

	public void setMaxBloodPressure(BigDecimal maxBloodPressure) {
		this.maxBloodPressure = maxBloodPressure;
	}

	public BigDecimal getMinBloodPressure() {
		return this.minBloodPressure;
	}

	public void setMinBloodPressure(BigDecimal minBloodPressure) {
		this.minBloodPressure = minBloodPressure;
	}

	public Long getPersonDetailId() {
		return this.personDetailId;
	}

	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	public BigDecimal getPhysicalTime() {
		return this.physicalTime;
	}

	public void setPhysicalTime(BigDecimal physicalTime) {
		this.physicalTime = physicalTime;
	}

	public BigDecimal getPhysicalWeek() {
		return this.physicalWeek;
	}

	public void setPhysicalWeek(BigDecimal physicalWeek) {
		this.physicalWeek = physicalWeek;
	}

	public String getRetinoPathy() {
		return this.retinoPathy;
	}

	public void setRetinoPathy(String retinoPathy) {
		this.retinoPathy = retinoPathy;
	}

	public BigDecimal getSmokeEveryday() {
		return this.smokeEveryday;
	}

	public void setSmokeEveryday(BigDecimal smokeEveryday) {
		this.smokeEveryday = smokeEveryday;
	}

	public String getTaste() {
		return this.taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public BigDecimal getTc() {
		return this.tc;
	}

	public void setTc(BigDecimal tc) {
		this.tc = tc;
	}

	public BigDecimal getTcMg() {
		return this.tcMg;
	}

	public void setTcMg(BigDecimal tcMg) {
		this.tcMg = tcMg;
	}

	public BigDecimal getTg() {
		return this.tg;
	}

	public void setTg(BigDecimal tg) {
		this.tg = tg;
	}

	public BigDecimal getTgMg() {
		return this.tgMg;
	}

	public void setTgMg(BigDecimal tgMg) {
		this.tgMg = tgMg;
	}

	public String getUnineProtein() {
		return this.unineProtein;
	}

	public void setUnineProtein(String unineProtein) {
		this.unineProtein = unineProtein;
	}

	public String getValidFlag() {
		return this.validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

	public BigDecimal getVegetablesEveryday() {
		return this.vegetablesEveryday;
	}

	public void setVegetablesEveryday(BigDecimal vegetablesEveryday) {
		this.vegetablesEveryday = vegetablesEveryday;
	}

	public BigDecimal getWaistline() {
		return this.waistline;
	}

	public void setWaistline(BigDecimal waistline) {
		this.waistline = waistline;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getWineEveryday() {
		return this.wineEveryday;
	}

	public void setWineEveryday(String wineEveryday) {
		this.wineEveryday = wineEveryday;
	}

}