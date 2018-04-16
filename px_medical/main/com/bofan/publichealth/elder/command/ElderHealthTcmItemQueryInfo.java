package com.bofan.publichealth.elder.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 老年人中医药评估明细表
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.elder.valueobject.ElderHealthTcmItem o ", orderBy = "o.elderHealthTcmItemId desc")
public class ElderHealthTcmItemQueryInfo  extends BaseCommandInfo {

    private static final long serialVersionUID = -7776152868811303401L;
 
    /** 老年人中医药评估ID */
    @QueryParam(fieldName = "o.elderHealthTcmedicineId", op = QueryOperator.EQU)
	private Long elderHealthTcmedicineId;

    /** default constructor */
    public ElderHealthTcmItemQueryInfo() {
    }

    /**
     * @param elderHealthTcmedicineId
     */
    public ElderHealthTcmItemQueryInfo(Long elderHealthTcmedicineId) {
        this.elderHealthTcmedicineId = elderHealthTcmedicineId;
    }

    /**
     * @return elderHealthTcmedicineId
     */
    public Long getElderHealthTcmedicineId() {
        return elderHealthTcmedicineId;
    }

    /**
     * @param elderHealthTcmedicineId 要设置的 elderHealthTcmedicineId
     */
    public void setElderHealthTcmedicineId(Long elderHealthTcmedicineId) {
        this.elderHealthTcmedicineId = elderHealthTcmedicineId;
    } 
}