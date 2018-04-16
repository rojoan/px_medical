package com.bofan.publichealth.elder.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 老年人健康评估结果明细 查询条件参数信息
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.elder.valueobject.ElderHealthAssessItem o ", orderBy = "o.elderHealthAssessItemId desc")
public class ElderHealthAssessItemQueryInfo extends BaseCommandInfo {

    private static final long serialVersionUID = -7776152868811303401L;
 
    /** 老年人健康评估ID */
    @QueryParam(fieldName = "o.elderHealthAssessId", op = QueryOperator.EQU)
    private Long elderHealthAssessId;

    /** default constructor */
    public ElderHealthAssessItemQueryInfo() {
    }

    /**
     * @param elderHealthAssessId
     */
    public ElderHealthAssessItemQueryInfo(Long elderHealthAssessId) {
        this.elderHealthAssessId = elderHealthAssessId;
    }

    /**
     * @return elderHealthAssessId
     */
    public Long getElderHealthAssessId() {
        return elderHealthAssessId;
    }

    /**
     * @param elderHealthAssessId 要设置的 elderHealthAssessId
     */
    public void setElderHealthAssessId(Long elderHealthAssessId) {
        this.elderHealthAssessId = elderHealthAssessId;
    }
}
