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
@QueryInfo(from = "com.bofan.reconsult.valueobject.EmrKbType ek", orderBy = "ek.emrKbTypeCode asc")
public class EmrKbTypeQueryInfo extends BaseCommandInfo {
    
    @QueryParam(fieldName = "ek.emrKbTypeCode", op = QueryOperator.LEFTLIKE)
    private String likeCode;
    
    @QueryParam(fieldName = "ek.emrKbTypeCode", op = QueryOperator.NOT_EQU)
    private String notCode;

    /**
     * @return the likeCode
     */
    public String getLikeCode() {
        return likeCode;
    }

    /**
     * @param likeCode the likeCode to set
     */
    public void setLikeCode(String likeCode) {
        this.likeCode = likeCode;
    }

    /**
     * @return the notCode
     */
    public String getNotCode() {
        return notCode;
    }

    /**
     * @param notCode the notCode to set
     */
    public void setNotCode(String notCode) {
        this.notCode = notCode;
    }
    
}
