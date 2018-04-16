package com.bofan.publichealth.elder.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 项目评估类型 查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.elder.valueobject.HealthAssessType o", orderBy = "o.healthAssessTypeId asc")
public class HealthAssessTypeQueryInfo extends BaseCommandInfo {
   
    private static final long serialVersionUID = 5755922405652275495L;
    
    /** 是否有效 1=有效 0=无效 */
    @QueryParam(fieldName = "o.validFlag", op = QueryOperator.EQU)
    private String validFlag;

    public HealthAssessTypeQueryInfo() {
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
