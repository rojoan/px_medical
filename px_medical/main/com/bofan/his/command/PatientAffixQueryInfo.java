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
@QueryInfo(from = "com.bofan.his.valueobject.PatientAffix", orderBy = "affixId asc")
public class PatientAffixQueryInfo extends BaseCommandInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5982344392013039365L;
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
