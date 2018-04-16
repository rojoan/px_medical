package com.bofan.publichealth.gravida.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;


/**
 * @Description: 孕期检查记录表 
 * 健康指导填写：gravida_health_guide表
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.gravida.valueobject.PregnancyExam ", orderBy = "pregnancyExamId desc")
public class PregnancyExamQueryInfo extends BaseCommandInfo {
	
    private static final long serialVersionUID = 6843270253430918951L;

    /** 孕产妇登记卡ID */
	private Long gravidaDetailId;
	
    /** 个人基本信息ID */
	private Long personDetailId;

    public PregnancyExamQueryInfo() {
    }

    /**
     * @param gravidaDetailId
     */
    public PregnancyExamQueryInfo(Long gravidaDetailId) {
        this.gravidaDetailId = gravidaDetailId;
    }

    /**
     * @return gravidaDetailId
     */
    public Long getGravidaDetailId() {
        return gravidaDetailId;
    }

    /**
     * @param gravidaDetailId 要设置的 gravidaDetailId
     */
    public void setGravidaDetailId(Long gravidaDetailId) {
        this.gravidaDetailId = gravidaDetailId;
    }

    /**
     * @return personDetailId
     */
    public Long getPersonDetailId() {
        return personDetailId;
    }

    /**
     * @param personDetailId 要设置的 personDetailId
     */
    public void setPersonDetailId(Long personDetailId) {
        this.personDetailId = personDetailId;
    }
   

}