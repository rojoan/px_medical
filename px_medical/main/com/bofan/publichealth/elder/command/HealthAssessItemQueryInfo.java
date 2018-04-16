package com.bofan.publichealth.elder.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 健康评估项目字典表--老年人查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.elder.valueobject.HealthAssessItem o", orderBy = "o.healthAssessTypeId asc")
public class HealthAssessItemQueryInfo extends BaseCommandInfo {
    
    private static final long serialVersionUID = 5755922405652275495L;
 
    /** 是否有效 1=有效 0=无效 */
    @QueryParam(fieldName = "o.validFlag", op = QueryOperator.EQU)
    private String validFlag;
    
    /** 是否属于健康评估 1=是 0=否 */
    @QueryParam(fieldName = "o.healthFlag", op = QueryOperator.EQU)
    private String healthFlag;
    
    
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

    /**
     * @return healthFlag
     */
    public String getHealthFlag() {
        return healthFlag;
    }

    /**
     * @param healthFlag 要设置的 healthFlag
     */
    public void setHealthFlag(String healthFlag) {
        this.healthFlag = healthFlag;
    }
 
}
