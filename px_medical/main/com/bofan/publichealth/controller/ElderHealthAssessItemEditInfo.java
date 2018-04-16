package com.bofan.publichealth.controller;


/**
 * @Description: 老年人健康评估结果明细表
 * @author lqw
 */
public class ElderHealthAssessItemEditInfo {

	/** 老年人健康评估明细ID */
	private Long elderHealthAssessItemId;
	
	/** 健康评估项目ID，（仅保存选中的项目） 选择中那个项目，保存那个相关的项目 */
	private Long healthAssessItemId; 
	
	/** 项目评估类型ID，主键ID 躯干 肌肉皮肤 */
	private String healthAssessTypeId;

	/** default constructor */
	public ElderHealthAssessItemEditInfo() {
	}

    /**
     * @return elderHealthAssessItemId
     */
    public Long getElderHealthAssessItemId() {
        return elderHealthAssessItemId;
    }

    /**
     * @param elderHealthAssessItemId 要设置的 elderHealthAssessItemId
     */
    public void setElderHealthAssessItemId(Long elderHealthAssessItemId) {
        this.elderHealthAssessItemId = elderHealthAssessItemId;
    }

    /**
     * @return healthAssessItemId
     */
    public Long getHealthAssessItemId() {
        return healthAssessItemId;
    }

    /**
     * @param healthAssessItemId 要设置的 healthAssessItemId
     */
    public void setHealthAssessItemId(Long healthAssessItemId) {
        this.healthAssessItemId = healthAssessItemId;
    }

    /**
     * @return healthAssessTypeId
     */
    public String getHealthAssessTypeId() {
        return healthAssessTypeId;
    }

    /**
     * @param healthAssessTypeId 要设置的 healthAssessTypeId
     */
    public void setHealthAssessTypeId(String healthAssessTypeId) {
        this.healthAssessTypeId = healthAssessTypeId;
    }
}