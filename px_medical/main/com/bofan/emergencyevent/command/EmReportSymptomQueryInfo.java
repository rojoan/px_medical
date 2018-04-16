package com.bofan.emergencyevent.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 突发公卫报告表 与事件信息来源 对照表 查询
 * @author lqw
 */
@QueryInfo( from = "com.bofan.emergencyevent.valueobject.EmReportSymptom ")
public class EmReportSymptomQueryInfo extends BaseCommandInfo {
    /**
     * 
     */
    private static final long serialVersionUID = -5540536874297793573L;
    
    /** 突发公卫报告ID */
    @QueryParam(fieldName = "healthReportId", op = QueryOperator.EQU)
    private Long healthReportId;

	public EmReportSymptomQueryInfo() {
	}

	public EmReportSymptomQueryInfo(Long healthReportId) {
		this.healthReportId = healthReportId;
	}

	/**
	 * @return healthReportId
	 */
	public Long getHealthReportId() {
		return healthReportId;
	}

	/**
	 * @param healthReportId 要设置的 healthReportId
	 */
	public void setHealthReportId(Long healthReportId) {
		this.healthReportId = healthReportId;
	}

}
