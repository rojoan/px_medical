package com.bofan.publichealth.gravida.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 孕妇孕早期情况对照表查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.gravida.valueobject.GravidaPregnancy ", orderBy = "gravidaPregnancyId desc")
public class GravidaPregnancyQueryInfo extends BaseCommandInfo {
    
	private static final long serialVersionUID = 1L;

    /** 初次孕检记录ID，自动增长ID */
	@QueryParam(fieldName = "pregnancyFirstExamId", op = QueryOperator.EQU)
    private Long pregnancyFirstExamId;

    public GravidaPregnancyQueryInfo() {
        
    }

    /**
     * @param pregnancyFirstExamId
     */
    public GravidaPregnancyQueryInfo(Long pregnancyFirstExamId) {
        this.pregnancyFirstExamId = pregnancyFirstExamId;
    }

    /**
     * @return pregnancyFirstExamId
     */
    public Long getPregnancyFirstExamId() {
        return pregnancyFirstExamId;
    }

    /**
     * @param pregnancyFirstExamId 要设置的 pregnancyFirstExamId
     */
    public void setPregnancyFirstExamId(Long pregnancyFirstExamId) {
        this.pregnancyFirstExamId = pregnancyFirstExamId;
    }
}