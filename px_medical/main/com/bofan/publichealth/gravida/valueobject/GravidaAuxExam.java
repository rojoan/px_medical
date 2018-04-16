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
 * @Description: 孕妇孕检辅助检查项目情况对照表
 * @author lqw
 */
@Entity
@Table(name = "GRAVIDA_AUX_EXAM", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "GRAVIDA_AUX_EXAM_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".GRAVIDA_AUX_EXAM_ID", allocationSize = 1)
public class GravidaAuxExam {

    /** 孕检辅助项目情况ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRAVIDA_AUX_EXAM_ID")
    @Column(name = "GRAVIDA_AUX_EXAM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long gravidaAuxExamId;
	
    /** 孕检辅助检查项目ID */
    @Column(name = "PREGNANCY_EXAM_ITEM_ID", nullable = false, precision = 18, scale = 0)
	private Long pregnancyExamItemId;
	
    /** 初次孕检记录ID，自动增长ID */
    @Column(name = "PREGNANCY_FIRST_EXAM_ID", precision = 18, scale = 0)
	private Long pregnancyFirstExamId;
	
    /** 孕产妇登记卡ID，冗余字段 */
    @Column(name = "GRAVIDA_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long gravidaDetailId;
	
    /** 检测结果 */
    @Column(name = "EXAM_ITEM_CONTEM", length = 200)
	private String examItemContem;
	
    /** 检测单位 */
    @Column(name = "EXAM_ITEM_UNIT", length = 20)
	private String examItemUnit;
	
    /** 孕检（登记）日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "CUR_CREATE_TIME", nullable = false)
	private Date curCreateTime;

	/** default constructor */
	public GravidaAuxExam() {
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

    /**
     * @return curCreateTime
     */
    public Date getCurCreateTime() {
        return curCreateTime;
    }

    /**
     * @param curCreateTime 要设置的 curCreateTime
     */
    public void setCurCreateTime(Date curCreateTime) {
        this.curCreateTime = curCreateTime;
    }

}