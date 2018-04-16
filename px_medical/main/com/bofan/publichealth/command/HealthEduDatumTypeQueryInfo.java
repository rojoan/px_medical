package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 健康教育--资料种类信息查询参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.HealthEduDatumType hed", orderBy = "hed.eduDatumTypeId asc")
public class HealthEduDatumTypeQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 9065496992044630401L;

    @QueryParam(fieldName = "hed.healthEducationId", op = QueryOperator.EQU)
    private Long healthEducationId;

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

}
