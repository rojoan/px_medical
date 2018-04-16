package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: region_popu（行政区域人口基数表）
 * @author lqw
 */
@Entity
@Table(name = "REGION_POPU", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "REGION_POPU_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".REGION_POPU_ID", allocationSize = 1)
public class RegionPopu {

	/** 行政区域人口基数ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REGION_POPU_ID")
	@Column(name = "REGION_POPU_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long regionPopuId;
	
	/** 行政区域ID 分三级管理 省（直辖市） ：001 市（地区） ：001001 县（城区） ：001001001 */
	/** 行政区域--城镇街道ID 分三级管理 省（直辖市） ：001 市（地区） ：001001 县（城区） ：001001001 */
	@Column(name = "REGION_ID",  nullable = false, length = 18)
	private String regionId;
	
	/** 年份 2017 */
	@Column(name = "YEAR_POPU", nullable = false, length = 4)
	private String yearPopu;
	
	/** 农村人口总数 */
	@Column(name = "RURAL_POPU", precision = 18, scale = 0)
	private Long ruralPopu;
	
	/** 城镇人口总数 */
	@Column(name = "CITY_POPU", precision = 18, scale = 0)
	private Long cityPopu;
	
	/** 辖区人口总数 */
	@Column(name = "AREA_POPU", precision = 18, scale = 0)
	private Long areaPopu;
	
	/** 新生儿活产数（农村） */
	@Column(name = "RURAL_BABY_POPU", precision = 18, scale = 0)
	private Long ruralBabyPopu;
	
	/** 新生儿活产数（城镇） */
	@Column(name = "CITY_BABY_POPU", precision = 18, scale = 0)
	private Long cityBabyPopu;
	
	/** 成人人口总数 */
	@Column(name = "ADULT_POPU", precision = 18, scale = 0)
	private Long adultPopu;
	
	/** 青少年人口总数 */
	@Column(name = "TEENAGER_POPU", precision = 18, scale = 0)
	private Long teenagerPopu;
	
	/** 儿童人口总数 */
	@Column(name = "CHILDREN_POPU", precision = 18, scale = 0)
	private Long childrenPopu;
	
	/** 男性人口总数 */
	@Column(name = "MAN_POPU", precision = 18, scale = 0)
	private Long manPopu;
	
	/** 女性人口总数 */
	@Column(name = "WOMAN_POPU", precision = 18, scale = 0)
	private Long womanPopu;
	
	/** 老年人口总数 */
	@Column(name = "ELDER_POPU", precision = 18, scale = 0)
	private Long elderPopu;
	
	/** 五保户人口总数 */
	@Column(name = "FIVE_HOUSEHOLDS_POPU", precision = 18, scale = 0)
	private Long fiveHouseholdsPopu;
	
	/** 六普人口数 */
	@Column(name = "SIX_HOUSEHOLDS_POPU", precision = 18, scale = 0)
	private Long sixHouseholdsPopu;
	
	/** 常住人口数 */
	@Column(name = "LONG_LIVE_POPU", precision = 18, scale = 0)
	private Long longLivePopu;
	
	/** 暂住人口数 */
	@Column(name = "MOMENT_LIVE_POPU", precision = 18, scale = 0)
	private Long momentLivePopu;
	
	/** 新农合参合户数 */
	@Column(name = "NEW_RURAL_FAMILY", precision = 18, scale = 0)
	private Long newRuralFamily;
	
	/** 新农合参合人数 */
	@Column(name = "NEW_RURAL_POPU", precision = 18, scale = 0)
	private Long newRuralPopu;
	
	/** 贫困户人口数 */
	@Column(name = "POVERTY_FAMILY", precision = 18, scale = 0)
	private Long povertyFamily;
	
	/** 学校 */
	@Column(name = "SCHOOL_COUNT", precision = 18, scale = 0)
	private Long schoolCount;
	
	/** 幼儿园 */
	@Column(name = "NURSERY_SCHOOL_COUNT", precision = 18, scale = 0)
	private Long nurserySchoolCount;
	
	/** 卫生站 */
	@Column(name = "HEALTH_STATION", precision = 18, scale = 0)
	private Long healthStation;
	
	/** 备注 */
	@Column(name = "REMARK", length = 100)
	private String remark;

	/** default constructor */
	public RegionPopu() {
	}

	/**
	 * @return regionPopuId
	 */
	public Long getRegionPopuId() {
		return regionPopuId;
	}

	/**
	 * @param regionPopuId
	 *            要设置的 regionPopuId
	 */
	public void setRegionPopuId(Long regionPopuId) {
		this.regionPopuId = regionPopuId;
	}

	/**
	 * @return yearPopu
	 */
	public String getYearPopu() {
		return yearPopu;
	}

	/**
	 * @param yearPopu
	 *            要设置的 yearPopu
	 */
	public void setYearPopu(String yearPopu) {
		this.yearPopu = yearPopu;
	}

	/**
	 * @return ruralPopu
	 */
	public Long getRuralPopu() {
		return ruralPopu;
	}

	/**
	 * @param ruralPopu
	 *            要设置的 ruralPopu
	 */
	public void setRuralPopu(Long ruralPopu) {
		this.ruralPopu = ruralPopu;
	}

	/**
	 * @return cityPopu
	 */
	public Long getCityPopu() {
		return cityPopu;
	}

	/**
	 * @param cityPopu
	 *            要设置的 cityPopu
	 */
	public void setCityPopu(Long cityPopu) {
		this.cityPopu = cityPopu;
	}

	/**
	 * @return areaPopu
	 */
	public Long getAreaPopu() {
		return areaPopu;
	}

	/**
	 * @param areaPopu
	 *            要设置的 areaPopu
	 */
	public void setAreaPopu(Long areaPopu) {
		this.areaPopu = areaPopu;
	}

	/**
	 * @return ruralBabyPopu
	 */
	public Long getRuralBabyPopu() {
		return ruralBabyPopu;
	}

	/**
	 * @param ruralBabyPopu
	 *            要设置的 ruralBabyPopu
	 */
	public void setRuralBabyPopu(Long ruralBabyPopu) {
		this.ruralBabyPopu = ruralBabyPopu;
	}

	/**
	 * @return cityBabyPopu
	 */
	public Long getCityBabyPopu() {
		return cityBabyPopu;
	}

	/**
	 * @param cityBabyPopu
	 *            要设置的 cityBabyPopu
	 */
	public void setCityBabyPopu(Long cityBabyPopu) {
		this.cityBabyPopu = cityBabyPopu;
	}

	/**
	 * @return adultPopu
	 */
	public Long getAdultPopu() {
		return adultPopu;
	}

	/**
	 * @param adultPopu
	 *            要设置的 adultPopu
	 */
	public void setAdultPopu(Long adultPopu) {
		this.adultPopu = adultPopu;
	}

	/**
	 * @return teenagerPopu
	 */
	public Long getTeenagerPopu() {
		return teenagerPopu;
	}

	/**
	 * @param teenagerPopu
	 *            要设置的 teenagerPopu
	 */
	public void setTeenagerPopu(Long teenagerPopu) {
		this.teenagerPopu = teenagerPopu;
	}

	/**
	 * @return childrenPopu
	 */
	public Long getChildrenPopu() {
		return childrenPopu;
	}

	/**
	 * @param childrenPopu
	 *            要设置的 childrenPopu
	 */
	public void setChildrenPopu(Long childrenPopu) {
		this.childrenPopu = childrenPopu;
	}

	/**
	 * @return manPopu
	 */
	public Long getManPopu() {
		return manPopu;
	}

	/**
	 * @param manPopu
	 *            要设置的 manPopu
	 */
	public void setManPopu(Long manPopu) {
		this.manPopu = manPopu;
	}

	/**
	 * @return womanPopu
	 */
	public Long getWomanPopu() {
		return womanPopu;
	}

	/**
	 * @param womanPopu
	 *            要设置的 womanPopu
	 */
	public void setWomanPopu(Long womanPopu) {
		this.womanPopu = womanPopu;
	}

	/**
	 * @return elderPopu
	 */
	public Long getElderPopu() {
		return elderPopu;
	}

	/**
	 * @param elderPopu
	 *            要设置的 elderPopu
	 */
	public void setElderPopu(Long elderPopu) {
		this.elderPopu = elderPopu;
	}

	/**
	 * @return fiveHouseholdsPopu
	 */
	public Long getFiveHouseholdsPopu() {
		return fiveHouseholdsPopu;
	}

	/**
	 * @param fiveHouseholdsPopu
	 *            要设置的 fiveHouseholdsPopu
	 */
	public void setFiveHouseholdsPopu(Long fiveHouseholdsPopu) {
		this.fiveHouseholdsPopu = fiveHouseholdsPopu;
	}

	/**
	 * @return sixHouseholdsPopu
	 */
	public Long getSixHouseholdsPopu() {
		return sixHouseholdsPopu;
	}

	/**
	 * @param sixHouseholdsPopu
	 *            要设置的 sixHouseholdsPopu
	 */
	public void setSixHouseholdsPopu(Long sixHouseholdsPopu) {
		this.sixHouseholdsPopu = sixHouseholdsPopu;
	}

	/**
	 * @return longLivePopu
	 */
	public Long getLongLivePopu() {
		return longLivePopu;
	}

	/**
	 * @param longLivePopu
	 *            要设置的 longLivePopu
	 */
	public void setLongLivePopu(Long longLivePopu) {
		this.longLivePopu = longLivePopu;
	}

	/**
	 * @return momentLivePopu
	 */
	public Long getMomentLivePopu() {
		return momentLivePopu;
	}

	/**
	 * @param momentLivePopu
	 *            要设置的 momentLivePopu
	 */
	public void setMomentLivePopu(Long momentLivePopu) {
		this.momentLivePopu = momentLivePopu;
	}

	/**
	 * @return newRuralFamily
	 */
	public Long getNewRuralFamily() {
		return newRuralFamily;
	}

	/**
	 * @param newRuralFamily
	 *            要设置的 newRuralFamily
	 */
	public void setNewRuralFamily(Long newRuralFamily) {
		this.newRuralFamily = newRuralFamily;
	}

	/**
	 * @return newRuralPopu
	 */
	public Long getNewRuralPopu() {
		return newRuralPopu;
	}

	/**
	 * @param newRuralPopu
	 *            要设置的 newRuralPopu
	 */
	public void setNewRuralPopu(Long newRuralPopu) {
		this.newRuralPopu = newRuralPopu;
	}

	/**
	 * @return povertyFamily
	 */
	public Long getPovertyFamily() {
		return povertyFamily;
	}

	/**
	 * @param povertyFamily
	 *            要设置的 povertyFamily
	 */
	public void setPovertyFamily(Long povertyFamily) {
		this.povertyFamily = povertyFamily;
	}

	/**
	 * @return schoolCount
	 */
	public Long getSchoolCount() {
		return schoolCount;
	}

	/**
	 * @param schoolCount
	 *            要设置的 schoolCount
	 */
	public void setSchoolCount(Long schoolCount) {
		this.schoolCount = schoolCount;
	}

	/**
	 * @return nurserySchoolCount
	 */
	public Long getNurserySchoolCount() {
		return nurserySchoolCount;
	}

	/**
	 * @param nurserySchoolCount
	 *            要设置的 nurserySchoolCount
	 */
	public void setNurserySchoolCount(Long nurserySchoolCount) {
		this.nurserySchoolCount = nurserySchoolCount;
	}

	/**
	 * @return healthStation
	 */
	public Long getHealthStation() {
		return healthStation;
	}

	/**
	 * @param healthStation
	 *            要设置的 healthStation
	 */
	public void setHealthStation(Long healthStation) {
		this.healthStation = healthStation;
	}

	/**
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            要设置的 remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}