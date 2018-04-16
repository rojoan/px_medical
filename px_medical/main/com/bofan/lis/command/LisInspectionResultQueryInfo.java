package com.bofan.lis.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017年10月8日
 */
@QueryInfo( from = "com.bofan.lis.valueobject.LisInspectionResult lir")
public class LisInspectionResultQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 7491257076018569669L;
    
    /** 检验ID */
    @QueryParam(fieldName = "lir.inspectionId", op = QueryOperator.EQU)
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
