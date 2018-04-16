package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 居民健康体症状检信息查询参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.ChildVisitSicken cvs", orderBy = "cvs.childVisitSickenId asc")
public class ChildVisitSickenQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 9065496992044630401L;

    @QueryParam(fieldName = "cvs.childVisitId", op = QueryOperator.EQU)
    private Long childVisitId;

    @QueryParam(fieldName = "cvs.childDetailId", op = QueryOperator.EQU)
    private Long childDetailId;

    /**
     * @return the childVisitId
     */
    public Long getChildVisitId() {
        return childVisitId;
    }

    /**
     * @param childVisitId the childVisitId to set
     */
    public void setChildVisitId(Long childVisitId) {
        this.childVisitId = childVisitId;
    }

    /**
     * @return the childDetailId
     */
    public Long getChildDetailId() {
        return childDetailId;
    }

    /**
     * @param childDetailId the childDetailId to set
     */
    public void setChildDetailId(Long childDetailId) {
        this.childDetailId = childDetailId;
    }

}
