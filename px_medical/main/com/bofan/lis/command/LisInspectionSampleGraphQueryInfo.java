package com.bofan.lis.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-10-11
 */
@QueryInfo( from = "com.bofan.lis.valueobject.LisInspectionSampleGraph lsg")
public class LisInspectionSampleGraphQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -5429939548229637564L;
    
    /** 检验ID */
    @QueryParam(fieldName = "lsg.inspectionId", op = QueryOperator.EQU)
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
