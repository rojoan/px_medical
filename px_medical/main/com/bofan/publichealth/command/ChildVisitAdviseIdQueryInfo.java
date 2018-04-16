package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 儿童随访指导情况查询参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(select = "cva.visitAdivseId", from = "com.bofan.publichealth.valueobject.ChildVisitAdvise cva", orderBy = "cva.childVisitAdviseId asc")
public class ChildVisitAdviseIdQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 9065496992044630401L;

    @QueryParam(fieldName = "cva.childVisitId", op = QueryOperator.EQU)
    private Long childVisitId;

    @QueryParam(fieldName = "cva.childDetailId", op = QueryOperator.EQU)
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
