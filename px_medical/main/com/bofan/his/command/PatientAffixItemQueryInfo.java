package com.bofan.his.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 查询患者附件
 * @Description: 
 * @author lqw
 */
@SuppressWarnings("serial")
@QueryInfo(from = "com.bofan.his.valueobject.PatientAffixItem ", orderBy = "affixItemId asc")
public class PatientAffixItemQueryInfo extends BaseCommandInfo {

	/** 附件标识 */
	@QueryParam(fieldName = "affixId", op = QueryOperator.EQU)
	private String affixId;

	/**
	 * @return affixId
	 */
	public String getAffixId() {
		return affixId;
	}

	/**
	 * @param affixId 要设置的 affixId
	 */
	public void setAffixId(String affixId) {
		this.affixId = affixId;
	}
	
	
}
