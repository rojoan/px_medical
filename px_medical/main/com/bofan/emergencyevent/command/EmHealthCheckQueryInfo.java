package com.bofan.emergencyevent.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 突发公卫报告表 与 事件发生场所 对照表 查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.emergencyevent.valueobject.EmHealthCheck ")
public class EmHealthCheckQueryInfo extends BaseCommandInfo {
	/**
     * 
     */
	private static final long serialVersionUID = -5540536874297793573L;

	/** 突发公卫报告ID */
	@QueryParam(fieldName = "healthReportId", op = QueryOperator.EQU)
	private Long healthReportId;

	/** 流行病学记录ID */
	@QueryParam(fieldName = "epidemiologyId", op = QueryOperator.EQU)
	private Long epidemiologyId;
	
	public EmHealthCheckQueryInfo() {
	}


	/**
	 * @return healthReportId
	 */
	public Long getHealthReportId() {
		return healthReportId;
	}

	/**
	 * @param healthReportId
	 *            要设置的 healthReportId
	 */
	public void setHealthReportId(Long healthReportId) {
		this.healthReportId = healthReportId;
	}

	/**
	 * @return epidemiologyId
	 */
	public Long getEpidemiologyId() {
		return epidemiologyId;
	}

	/**
	 * @param epidemiologyId 要设置的 epidemiologyId
	 */
	public void setEpidemiologyId(Long epidemiologyId) {
		this.epidemiologyId = epidemiologyId;
	}
	
}
