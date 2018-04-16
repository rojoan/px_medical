package com.bofan.reconsult.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description
 * @author xlf
 * @version 1.0
 * 2017-10-02
 */
@SuppressWarnings("serial")
@QueryInfo(from = "com.bofan.reconsult.valueobject.EmrKbDetail ekd")
public class EmrKbDetailQueryInfo extends BaseCommandInfo {
    
    /** 类型ID */
    @QueryParam(fieldName = "ekd.emrKbTypeId", op = QueryOperator.EQU)
    private Long emrKbTypeId;

    /**
     * @return the emrKbTypeId
     */
    public Long getEmrKbTypeId() {
        return emrKbTypeId;
    }

    /**
     * @param emrKbTypeId the emrKbTypeId to set
     */
    public void setEmrKbTypeId(Long emrKbTypeId) {
        this.emrKbTypeId = emrKbTypeId;
    }
    
}
