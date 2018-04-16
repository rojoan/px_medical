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
 * @Description: 高危因素表
 * @author lqw
 */
@Entity
@Table(name = "PREGNANCY_HIGH_RISK", schema = SchemaConsts.PUBLIC_HEALTH, uniqueConstraints = @UniqueConstraint(columnNames = "HIGH_RISK_NAME"))
@SequenceGenerator(name = "PREGNANCY_HIGH_RISK_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PREGNANCY_HIGH_RISK_ID", allocationSize = 1)
public class PregnancyHighRisk {

    /** 高危因素ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREGNANCY_HIGH_RISK_ID")
    @Column(name = "PREGNANCY_HIGH_RISK_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long pregnancyHighRiskId;
	
    /** 高危因素  0=无  1=阴道流血  2=风疹  3=感冒  4=发烧  5=其他 */
    @Column(name = "HIGH_RISK_NAME", unique = true, nullable = false, length = 200)
	private String highRiskName;
	
    /** 是否有效  1=有效  0=无效 */
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public PregnancyHighRisk() {
	}

    /**
     * @return pregnancyHighRiskId
     */
    public Long getPregnancyHighRiskId() {
        return pregnancyHighRiskId;
    }

    /**
     * @param pregnancyHighRiskId 要设置的 pregnancyHighRiskId
     */
    public void setPregnancyHighRiskId(Long pregnancyHighRiskId) {
        this.pregnancyHighRiskId = pregnancyHighRiskId;
    }

    /**
     * @return highRiskName
     */
    public String getHighRiskName() {
        return highRiskName;
    }

    /**
     * @param highRiskName 要设置的 highRiskName
     */
    public void setHighRiskName(String highRiskName) {
        this.highRiskName = highRiskName;
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