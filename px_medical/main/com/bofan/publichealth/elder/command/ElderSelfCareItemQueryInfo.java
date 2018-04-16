package com.bofan.publichealth.elder.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 老年人自理能力评估明细表
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.elder.valueobject.ElderSelfCareItem o ", orderBy = "o.elderSelfCareItemId desc")
public class ElderSelfCareItemQueryInfo  extends BaseCommandInfo {

    private static final long serialVersionUID = -7776152868811303401L;
    
    /** 自理能力评估项目ID，主键ID */
    @QueryParam(fieldName = "o.elderSelfCareAbilityId", op = QueryOperator.EQU)
	private Long elderSelfCareAbilityId;

	/** default constructor */
    public ElderSelfCareItemQueryInfo() {
    }

    /**
     * @param elderSelfCareAbilityId
     */
    public ElderSelfCareItemQueryInfo(Long elderSelfCareAbilityId) {
        this.elderSelfCareAbilityId = elderSelfCareAbilityId;
    }

    /**
     * @return elderSelfCareAbilityId
     */
    public Long getElderSelfCareAbilityId() {
        return elderSelfCareAbilityId;
    }

    /**
     * @param elderSelfCareAbilityId 要设置的 elderSelfCareAbilityId
     */
    public void setElderSelfCareAbilityId(Long elderSelfCareAbilityId) {
        this.elderSelfCareAbilityId = elderSelfCareAbilityId;
    }
	 
}