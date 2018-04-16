package com.bofan.publichealth.gravida.command;


/**
 * @Description: 孕妇保健指导表
 * @author lqw
 */
public class GravidaHealthGuideEditInfo {
    
    /** 孕产妇登记卡ID，冗余字段 */
	private Long gravidaDetailId;
	
    /** 初次孕检记录ID，自动增长ID */
	private Long pregnancyFirstExamId;
	
    /** 孕期检查记录ID，自动增长ID */
	private Long pregnancyExamId;
	
    /** 保健类型  01=生活方式  02=避免畸型和疾病对胚胎的不良影响 03=心理  04=产前筛查宣传告知  05=营养  99=其他   */
	private String healthGuideType;
	
    /** 其他描述 */
	private String healthGuideOtherContent;

	/** default constructor */
	public GravidaHealthGuideEditInfo() {
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

    /**
     * @return healthGuideType
     */
    public String getHealthGuideType() {
        return healthGuideType;
    }

    /**
     * @param healthGuideType 要设置的 healthGuideType
     */
    public void setHealthGuideType(String healthGuideType) {
        this.healthGuideType = healthGuideType;
    }

    /**
     * @return healthGuideOtherContent
     */
    public String getHealthGuideOtherContent() {
        return healthGuideOtherContent;
    }

    /**
     * @param healthGuideOtherContent 要设置的 healthGuideOtherContent
     */
    public void setHealthGuideOtherContent(String healthGuideOtherContent) {
        this.healthGuideOtherContent = healthGuideOtherContent;
    }

}