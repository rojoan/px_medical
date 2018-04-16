package com.bofan.publichealth.gravida.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;


/**
 * @Description: 孕妇孕检辅助检查项目情况对照表
 * @author lqw
 */
@QueryInfo( from = "com.bofan.publichealth.gravida.valueobject.GravidaAuxExam g ",  orderBy = "g.gravidaAuxExamId asc")
public class GravidaAuxExamQueryInfo extends BaseCommandInfo {

    private static final long serialVersionUID = 5325328913404493199L;
    
    /** 初次孕检记录ID，自动增长ID */
    @QueryParam(fieldName = "pregnancyFirstExamId", op = QueryOperator.EQU)
    private Long pregnancyFirstExamId;
	
	/** default constructor */
	public GravidaAuxExamQueryInfo() {
	}

    /**
	 * @param pregnancyFirstExamId
	 */
    public GravidaAuxExamQueryInfo(Long pregnancyFirstExamId) {
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