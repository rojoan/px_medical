package com.bofan.publichealth.gravida.command;

/**
 * @Description: 孕妇孕检项目情况对照表
 * @author lqw
 */
public class GravidaExamItemEditInfo {

    /** 孕妇孕检项目情况ID，自动增长ID */
    private Long gravidaExamItemId;

    /** 初次孕检记录ID，自动增长ID */
    private Long pregnancyFirstExamId;

    /** 孕产妇登记卡ID，冗余字段 */
    private Long gravidaDetailId;

    /**
     * 孕检项目类型 11=听诊--心脏 12=听诊--肺部 21=妇科检查--外阴 22=妇科检查--阴道 23=妇科检查--宫颈
     * 24=妇科检查--子宫 25=妇科检查--附件
     */
    private String examItemType;

    /** 孕检项目是否正常 0=未见异常 1=异常 */
    private String examFlag;

    /** 孕检项目描述 */
    private String examContent;

    /** default constructor */
    public GravidaExamItemEditInfo() {
    }

    /**
     * @return gravidaExamItemId
     */
    public Long getGravidaExamItemId() {
        return gravidaExamItemId;
    }

    /**
     * @param gravidaExamItemId 要设置的 gravidaExamItemId
     */
    public void setGravidaExamItemId(Long gravidaExamItemId) {
        this.gravidaExamItemId = gravidaExamItemId;
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
     * @return examItemType
     */
    public String getExamItemType() {
        return examItemType;
    }

    /**
     * @param examItemType 要设置的 examItemType
     */
    public void setExamItemType(String examItemType) {
        this.examItemType = examItemType;
    }

    /**
     * @return examFlag
     */
    public String getExamFlag() {
        return examFlag;
    }

    /**
     * @param examFlag 要设置的 examFlag
     */
    public void setExamFlag(String examFlag) {
        this.examFlag = examFlag;
    }

    /**
     * @return examContent
     */
    public String getExamContent() {
        return examContent;
    }

    /**
     * @param examContent 要设置的 examContent
     */
    public void setExamContent(String examContent) {
        this.examContent = examContent;
    }

}