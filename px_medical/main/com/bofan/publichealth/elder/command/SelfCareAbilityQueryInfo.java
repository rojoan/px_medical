package com.bofan.publichealth.elder.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 自理能力评估项目字典表--老年人
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.elder.valueobject.SelfCareAbility o", orderBy = "o.selfCareAbilityId desc")
public class SelfCareAbilityQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

    @QueryParam(fieldName = "o.validFlag", op = QueryOperator.EQU)
    private String validFlag;

	public SelfCareAbilityQueryInfo() {
	}

	/**
	 * @param validFlag
	 */
    public SelfCareAbilityQueryInfo(String validFlag) {
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