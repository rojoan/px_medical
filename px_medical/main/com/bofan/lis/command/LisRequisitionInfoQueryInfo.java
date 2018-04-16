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
@QueryInfo( from = "com.bofan.lis.valueobject.LisRequisitionInfo lri")
public class LisRequisitionInfoQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 2008304277518601185L;
    
    /** 检验ID */
    @QueryParam(fieldName = "lri.requisitionId", op = QueryOperator.EQU)
    private String requisitionId;

    /**
     * @return the requisitionId
     */
    public String getRequisitionId() {
        return requisitionId;
    }

    /**
     * @param requisitionId the requisitionId to set
     */
    public void setRequisitionId(String requisitionId) {
        this.requisitionId = requisitionId;
    }


}
