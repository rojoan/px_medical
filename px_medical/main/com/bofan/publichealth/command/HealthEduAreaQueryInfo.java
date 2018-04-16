package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 健康教育--发放印刷/播放位置信息查询参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.HealthEduArea hha", orderBy = "hha.eduAreaId asc")
public class HealthEduAreaQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 9065496992044630401L;

    @QueryParam(fieldName = "hha.healthEducationId", op = QueryOperator.EQU)
    private Long healthEducationId;
    
    @QueryParam(fieldName = "hha.eduAreaFlag", op = QueryOperator.EQU)
    private String eduAreaFlag;

    /**
     * @return the healthEducationId
     */
    public Long getHealthEducationId() {
        return healthEducationId;
    }

    /**
     * @param healthEducationId the healthEducationId to set
     */
    public void setHealthEducationId(Long healthEducationId) {
        this.healthEducationId = healthEducationId;
    }

    /**
     * @return the eduAreaFlag
     */
    public String getEduAreaFlag() {
        return eduAreaFlag;
    }

    /**
     * @param eduAreaFlag the eduAreaFlag to set
     */
    public void setEduAreaFlag(String eduAreaFlag) {
        this.eduAreaFlag = eduAreaFlag;
    }

}
