package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 城镇街道查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.Region ", orderBy = "regionId desc")
public class RegionQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

	/** 行政区域--城镇街道ID 分三级管理 省（直辖市） ：001 市（地区） ：001001 县（城区） ：001001001 */
	@QueryParam(fieldName = "regionId", op = QueryOperator.EQU)
	private String regionId;

	public RegionQueryInfo() {
	}

	/**
	 * @return regionId
	 */
	public String getRegionId() {
		return regionId;
	}

	/**
	 * @param regionId  要设置的 regionId
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
}