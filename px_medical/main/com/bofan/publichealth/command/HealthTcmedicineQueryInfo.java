package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description:中医药健康字典表--老年人 查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.elder.valueobject.HealthTcmedicine o ", orderBy = "o.healthTcmedicineId")
public class HealthTcmedicineQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

	@QueryParam(fieldName = "o.validFlag", op = QueryOperator.EQU)
    private String validFlag;

	public HealthTcmedicineQueryInfo() {
	}

	/**
	 * @param validFlag
	 */
    public HealthTcmedicineQueryInfo(String validFlag) {
        this.validFlag = validFlag;
    }

    /**
     * @return validFlag
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag 要设置的 validFlag
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

	 
}