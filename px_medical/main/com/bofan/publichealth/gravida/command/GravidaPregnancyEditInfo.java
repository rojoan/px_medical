package com.bofan.publichealth.gravida.command;

/**
 * @Description: 孕妇孕早期情况对照表编辑
 * @author lqw
 */
public class GravidaPregnancyEditInfo {
	
    /** 孕产妇登记卡ID，冗余字段 */
	private Long gravidaDetailId;
	
    /** 孕早期情况ID */
	private Long pregnancyCaseId;
	
    /** 初次孕检记录ID，自动增长ID */
	private Long pregnancyFirstExamId;
	
    /** 孕早期情况，冗余字段  0=无1=阴道流血2=风疹3=感冒4=发烧5=其他 */
	private String pregnancyCase;

	/** default constructor */
	public GravidaPregnancyEditInfo() {
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
     * @return pregnancyCaseId
     */
    public Long getPregnancyCaseId() {
        return pregnancyCaseId;
    }

    /**
     * @param pregnancyCaseId 要设置的 pregnancyCaseId
     */
    public void setPregnancyCaseId(Long pregnancyCaseId) {
        this.pregnancyCaseId = pregnancyCaseId;
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
     * @return pregnancyCase
     */
    public String getPregnancyCase() {
        return pregnancyCase;
    }

    /**
     * @param pregnancyCase 要设置的 pregnancyCase
     */
    public void setPregnancyCase(String pregnancyCase) {
        this.pregnancyCase = pregnancyCase;
    }
}