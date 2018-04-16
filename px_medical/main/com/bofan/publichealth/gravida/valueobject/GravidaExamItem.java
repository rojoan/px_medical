package com.bofan.publichealth.gravida.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description: 孕妇孕检项目情况对照表
 * @author lqw
 */
@Entity
@Table(name = "GRAVIDA_EXAM_ITEM", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "GRAVIDA_EXAM_ITEM_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".GRAVIDA_EXAM_ITEM_ID", allocationSize = 1)
public class GravidaExamItem {

    /** 孕妇孕检项目情况ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRAVIDA_EXAM_ITEM_ID")
    @Column(name = "GRAVIDA_EXAM_ITEM_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long gravidaExamItemId;

    /** 初次孕检记录ID，自动增长ID */
    @Column(name = "PREGNANCY_FIRST_EXAM_ID", precision = 18, scale = 0)
    private Long pregnancyFirstExamId;

    /** 孕产妇登记卡ID，冗余字段 */
    @Column(name = "GRAVIDA_DETAIL_ID", nullable = false, precision = 18, scale = 0)
    private Long gravidaDetailId;

    /**
     * 孕检项目类型 11=听诊--心脏 12=听诊--肺部 21=妇科检查--外阴 22=妇科检查--阴道 23=妇科检查--宫颈
     * 24=妇科检查--子宫 25=妇科检查--附件
     */
    @Column(name = "EXAM_ITEM_TYPE", nullable = false, length = 2)
    private String examItemType;

    /** 孕检项目是否正常 0=未见异常 1=异常 */
    @Column(name = "EXAM_FLAG", nullable = false, length = 1)
    private String examFlag;

    /** 孕检项目描述 */
    @Column(name = "EXAM_CONTENT", length = 100)
    private String examContent;

    /** 孕检（登记）日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "CUR_CREATE_TIME")
    private Date curCreateTime;

    /** default constructor */
    public GravidaExamItem() {
    }

    /**
     * @return gravidaExamItemId
     */
    public Long getGravidaExamItemId() {
        return gravidaExamItemId;
    }

    /**
     * @param gravidaExamItemId
     *            要设置的 gravidaExamItemId
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
     * @param pregnancyFirstExamId
     *            要设置的 pregnancyFirstExamId
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
     * @param gravidaDetailId
     *            要设置的 gravidaDetailId
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
     * @param examItemType
     *            要设置的 examItemType
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
     * @param examFlag
     *            要设置的 examFlag
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
     * @param examContent
     *            要设置的 examContent
     */
    public void setExamContent(String examContent) {
        this.examContent = examContent;
    }

    /**
     * @return curCreateTime
     */
    public Date getCurCreateTime() {
        return curCreateTime;
    }

    /**
     * @param curCreateTime
     *            要设置的 curCreateTime
     */
    public void setCurCreateTime(Date curCreateTime) {
        this.curCreateTime = curCreateTime;
    }

}