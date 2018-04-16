package com.bofan.publichealth.gravida.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 孕妇保健指导表
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.gravida.valueobject.GravidaHealthGuide ", orderBy = "gravidaHealthGuideId asc")
public class GravidaHealthGuideQueryInfo extends BaseCommandInfo {
	
    private static final long serialVersionUID = 7170385352896177502L;

    /** 初次孕检记录ID，自动增长ID */
    @QueryParam(fieldName = "pregnancyFirstExamId", op = QueryOperator.EQU)
	private Long pregnancyFirstExamId;
	
    /** 孕期检查记录ID，自动增长ID */
	 @QueryParam(fieldName = "pregnancyExamId", op = QueryOperator.EQU)
	private Long pregnancyExamId;
	
	/** default constructor */
	public GravidaHealthGuideQueryInfo() {
	}

	/**
	 * @param pregnancyFirstExamId
	 * @param pregnancyExamId
	 */
    public GravidaHealthGuideQueryInfo(Long pregnancyFirstExamId, Long pregnancyExamId) {
        this.pregnancyFirstExamId = pregnancyFirstExamId;
        this.pregnancyExamId = pregnancyExamId;
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

    /**
     * @return pregnancyExamId
     */
    public Long getPregnancyExamId() {
        return pregnancyExamId;
    }

    /**
     * @param pregnancyExamId 要设置的 pregnancyExamId
     */
    public void setPregnancyExamId(Long pregnancyExamId) {
        this.pregnancyExamId = pregnancyExamId;
    }

     
}