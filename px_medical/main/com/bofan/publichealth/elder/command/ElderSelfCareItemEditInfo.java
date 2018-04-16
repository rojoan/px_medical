package com.bofan.publichealth.elder.command;


/**
 * @Description: 老年人自理能力评估明细表
 * @author lqw
 */
public class ElderSelfCareItemEditInfo {
    
    
    /** 老年人自理能力评估ID */
	private Long elderSelfCareAbilityId;
	
	/** 自理能力评估项目ID，主键ID */
	private Long selfCareAbilityId;

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

    /**
     * @return selfCareAbilityId
     */
    public Long getSelfCareAbilityId() {
        return selfCareAbilityId;
    }

    /**
     * @param selfCareAbilityId 要设置的 selfCareAbilityId
     */
    public void setSelfCareAbilityId(Long selfCareAbilityId) {
        this.selfCareAbilityId = selfCareAbilityId;
    }
	
	
}