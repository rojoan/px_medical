package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 城镇街道
 * @author lqw
 */
@Entity
@Table(name = "REGION", schema = SchemaConsts.PUBLIC_HEALTH)
public class Region {

	/** 行政区域--城镇街道ID 分三级管理 省（直辖市） ：001 市（地区） ：001001 县（城区） ：001001001 */
	@Id
	@Column(name = "REGION_ID", unique = true, nullable = false, length = 18)
	private String regionId;

	/** 行政区域代码 */
	@Column(name = "REGION_CODE", nullable = false, length = 20)
	private String regionCode;

	/** 行政区域名称 */
	@Column(name = "REGION_NAME", nullable = false, length = 80)
	private String regionName;

	/** 邮政编码 */
	@Column(name = "ZIP_CODE", precision = 18, scale = 0)
	private Long zipCode;

	/** 纬度 */
	@Column(name = "LATITUDE", precision = 18, scale = 10)
	private Double latitude;

	/** 经度 */
	@Column(name = "LONGITUDE", precision = 18, scale = 10)
	private Double longitude;

	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public Region() {
	}

	/**
	 * @return regionId
	 */
	public String getRegionId() {
		return regionId;
	}

	/**
	 * @param regionId
	 *            要设置的 regionId
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	/**
	 * @return regionCode
	 */
	public String getRegionCode() {
		return regionCode;
	}

	/**
	 * @param regionCode
	 *            要设置的 regionCode
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	/**
	 * @return regionName
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @param regionName
	 *            要设置的 regionName
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * @return zipCode
	 */
	public Long getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            要设置的 zipCode
	 */
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            要设置的 latitude
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            要设置的 longitude
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return validFlag
	 */
	public String getValidFlag() {
		return validFlag;
	}

	/**
	 * @param validFlag
	 *            要设置的 validFlag
	 */
	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

}