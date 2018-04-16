package com.bofan.publichealth.gravida.command;


/**
 * @Description: 孕妇孕检辅助检查项目情况对照表
 * @author lqw
 */
public class GravidaAuxExamEditInfo {

    /** 孕检辅助项目情况ID，自动增长ID */
	private Long gravidaAuxExamId;
	
    /** 孕检辅助检查项目ID */
	private Long pregnancyExamItemId;
	
    /** 孕产妇登记卡ID，冗余字段 */
	private Long gravidaDetailId;
	
    /** 检测结果 */
	private String examItemContem;
	
    /** 检测单位 */
	private String examItemUnit;
	
	/** default constructor */
	public GravidaAuxExamEditInfo() {
	}

    /**
     * @return gravidaAuxExamId
     */
    public Long getGravidaAuxExamId() {
        return gravidaAuxExamId;
    }

    /**
     * @param gravidaAuxExamId 要设置的 gravidaAuxExamId
     */
    public void setGravidaAuxExamId(Long gravidaAuxExamId) {
        this.gravidaAuxExamId = gravidaAuxExamId;
    }

    /**
     * @return pregnancyExamItemId
     */
    public Long getPregnancyExamItemId() {
        return pregnancyExamItemId;
    }

    /**
     * @param pregnancyExamItemId 要设置的 pregnancyExamItemId
     */
    public void setPregnancyExamItemId(Long pregnancyExamItemId) {
        this.pregnancyExamItemId = pregnancyExamItemId;
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
     * @return examItemContem
     */
    public String getExamItemContem() {
        return examItemContem;
    }

    /**
     * @param examItemContem 要设置的 examItemContem
     */
    public void setExamItemContem(String examItemContem) {
        this.examItemContem = examItemContem;
    }

    /**
     * @return examItemUnit
     */
    public String getExamItemUnit() {
        return examItemUnit;
    }

    /**
     * @param examItemUnit 要设置的 examItemUnit
     */
    public void setExamItemUnit(String examItemUnit) {
        this.examItemUnit = examItemUnit;
    }

}