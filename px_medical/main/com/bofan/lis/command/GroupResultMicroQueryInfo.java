package com.bofan.lis.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-10-08
 */
@QueryInfo(
        select = "new Map(lrm.inspectionDate as inspectionDate, lrm.microDataId as microDataId, lrm.microDataIdName as microDataIdName, lrm.microDataIdResult as microDataIdResult, lrm.esbl as esbl)",
        from = "com.bofan.lis.valueobject.LisInspectionResultMicro lrm", 
        groupBy = "lrm.inspectionDate, lrm.microDataId, lrm.microDataIdName, lrm.microDataIdResult, lrm.esbl")
public class GroupResultMicroQueryInfo extends BaseCommandInfo {

    
    /**
     * 
     */
    private static final long serialVersionUID = -5540536874297793573L;
    
    /** 检验ID */
    @QueryParam(fieldName = "lrm.inspectionId", op = QueryOperator.EQU)
    private String inspectionId;

    /**
     * @return the inspectionId
     */
    public String getInspectionId() {
        return inspectionId;
    }

    /**
     * @param inspectionId the inspectionId to set
     */
    public void setInspectionId(String inspectionId) {
        this.inspectionId = inspectionId;
    }

}
