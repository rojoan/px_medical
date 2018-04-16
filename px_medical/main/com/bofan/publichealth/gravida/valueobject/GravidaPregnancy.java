package com.bofan.publichealth.gravida.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;
/**
 * @Description: 孕妇孕早期情况对照表
 * @author lqw
 */
@Entity
@Table(name = "GRAVIDA_PREGNANCY", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "GRAVIDA_PREGNANCY_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".GRAVIDA_PREGNANCY_ID", allocationSize = 1)
public class GravidaPregnancy {
	
    /** 孕妇孕早期情况ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRAVIDA_PREGNANCY_ID")
    @Column(name = "GRAVIDA_PREGNANCY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long gravidaPregnancyId;
	
    /** 孕产妇登记卡ID，冗余字段 */
    @Column(name = "GRAVIDA_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long gravidaDetailId;
	
    /** 孕早期情况ID */
    @Column(name = "PREGNANCY_CASE_ID", nullable = false, precision = 18, scale = 0)
	private Long pregnancyCaseId;
	
    /** 初次孕检记录ID，自动增长ID */
    @Column(name = "PREGNANCY_FIRST_EXAM_ID", nullable = false, precision = 18, scale = 0)
	private Long pregnancyFirstExamId;
	
    /** 孕早期情况，冗余字段  0=无1=阴道流血2=风疹3=感冒4=发烧5=其他 */
    @Column(name = "PREGNANCY_CASE", nullable = false, length = 40)
	private String pregnancyCase;

	/** default constructor */
	public GravidaPregnancy() {
	}

    /**
     * @return gravidaPregnancyId
     */
    public Long getGravidaPregnancyId() {
        return gravidaPregnancyId;
    }

    /**
     * @param gravidaPregnancyId 要设置的 gravidaPregnancyId
     */
    public void setGravidaPregnancyId(Long gravidaPregnancyId) {
        this.gravidaPregnancyId = gravidaPregnancyId;
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