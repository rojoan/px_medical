package com.bofan.publichealth.gravida.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.bofan.utils.SchemaConsts;
/**
 * @Description: 孕早期情况表
 * @author lqw
 */
@Entity
@Table(name = "PREGNANCY_CASE", schema = SchemaConsts.PUBLIC_HEALTH, uniqueConstraints = @UniqueConstraint(columnNames = "PREGNANCY_CASE"))
@SequenceGenerator(name = "PREGNANCY_CASE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PREGNANCY_CASE_ID", allocationSize = 1)
public class PregnancyCase {

    /** 孕早期情况ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREGNANCY_CASE_ID")
    @Column(name = "PREGNANCY_CASE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long pregnancyCaseId;
	
    /** 孕早期情况 0=无  1=阴道流血 2=风疹 3=感冒 4=发烧 5=其他 */
    @Column(name = "PREGNANCY_CASE", unique = true, nullable = false, length = 40)
	private String pregnancyCase;
	
    /** 是否有效 1=有效 0=无效 */
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public PregnancyCase() {
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

    /**
     * @return validFlag
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag 要设置的 validFlag
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

}