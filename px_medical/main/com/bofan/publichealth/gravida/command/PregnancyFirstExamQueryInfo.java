package com.bofan.publichealth.gravida.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 孕产妇初次孕检记录 查询
 * @author lqw
 */

@QueryInfo(from = "com.bofan.publichealth.gravida.valueobject.PregnancyFirstExam ", orderBy = "pregnancyFirstExamId desc")
public class PregnancyFirstExamQueryInfo extends BaseCommandInfo {
	
    private static final long serialVersionUID = -6758659585395268446L;
	
    /** 孕产妇登记卡ID，自动增长ID */
    @QueryParam(fieldName = "gravidaDetailId", op = QueryOperator.EQU)
	private Long gravidaDetailId;
	
    /** 个人基本信息ID */
    @QueryParam(fieldName = "personDetailId", op = QueryOperator.EQU)
	private Long personDetailId;
	
    /** 孕妇姓名 */
    @QueryParam(fieldName = "gravidaName", op = QueryOperator.EQU)
	private String gravidaName;

    
    public PregnancyFirstExamQueryInfo() {
    }

    /**
     * @param gravidaDetailId
     */
    public PregnancyFirstExamQueryInfo(Long gravidaDetailId) {
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

    /**
     * @return gravidaName
     */
    public String getGravidaName() {
        return gravidaName;
    }

    /**
     * @param gravidaName 要设置的 gravidaName
     */
    public void setGravidaName(String gravidaName) {
        this.gravidaName = gravidaName;
    }
}