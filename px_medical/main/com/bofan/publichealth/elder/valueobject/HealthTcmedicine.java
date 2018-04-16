package com.bofan.publichealth.elder.valueobject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 中医药健康字典表--老年人
 * @author lqw
 */
@Entity
@Table(name = "HEALTH_TCMEDICINE", schema = SchemaConsts.PUBLIC_HEALTH)
public class HealthTcmedicine {

    /** 中医药健康评估项目ID，主键ID */
    @Id
    @Column(name = "HEALTH_TCMEDICINE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long healthTcmedicineId;

    /** 评估项目名称 */
    @Column(name = "TCMEDICINE_NAME", nullable = false, length = 60)
	private String tcmedicineName;
	
    /** 评估项目描述 */
    @Column(name = "TCMEDICINE_CONTENT", length = 100)
	private String tcmedicineContent;
	
    /** 选项--没有 */
    @Column(name = "CHOICE_NOT", length = 60)
	private String choiceNot;
	
    /** 选项--很少 */
    @Column(name = "CHOICE_LITTLE", length = 60)
	private String choiceLittle;
	
    /** 选项--有时 */
    @Column(name = "CHOICE_SOMETIMES", length = 60)
	private String choiceSometimes;
	
    /** 选项--经常 */
    @Column(name = "CHOICE_OFTEN", length = 60)
	private String choiceOften;
	
    /** 选项--总是 */
    @Column(name = "CHOICE_ALWAYS", length = 60)
	private String choiceAlways;
	
	/** 选项--没有--分数 */
    @Column(name = "CHOICE_NOT_SCORE", precision = 2, scale = 0)
	private BigDecimal choiceNotScore;
	
    /** 选项--很少--分数 */
    @Column(name = "CHOICE_LITTLE_SCORE", precision = 2, scale = 0)
	private BigDecimal choiceLittleScore;
	
    /** 选项--有时--分数 */
    @Column(name = "CHOICE_SOMETIMES_SCORE", precision = 2, scale = 0)
	private BigDecimal choiceSometimesScore;
	
    /** 选项--经常--分数 */
    @Column(name = "CHOICE_OFTEN_SCORE", precision = 2, scale = 0)
	private BigDecimal choiceOftenScore;
	
    /** 选项--总是--分数 */
    @Column(name = "CHOICE_ALWAYS_SCORE", precision = 2, scale = 0)
	private BigDecimal choiceAlwaysScore;

	/** 选项--有时--分数 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
    private String validFlag;
    
	/** default constructor */
	public HealthTcmedicine() {
	}

    /**
     * @return healthTcmedicineId
     */
    public Long getHealthTcmedicineId() {
        return healthTcmedicineId;
    }

    /**
     * @param healthTcmedicineId 要设置的 healthTcmedicineId
     */
    public void setHealthTcmedicineId(Long healthTcmedicineId) {
        this.healthTcmedicineId = healthTcmedicineId;
    }

    /**
     * @return tcmedicineName
     */
    public String getTcmedicineName() {
        return tcmedicineName;
    }

    /**
     * @param tcmedicineName 要设置的 tcmedicineName
     */
    public void setTcmedicineName(String tcmedicineName) {
        this.tcmedicineName = tcmedicineName;
    }

    /**
     * @return tcmedicineContent
     */
    public String getTcmedicineContent() {
        return tcmedicineContent;
    }

    /**
     * @param tcmedicineContent 要设置的 tcmedicineContent
     */
    public void setTcmedicineContent(String tcmedicineContent) {
        this.tcmedicineContent = tcmedicineContent;
    }

    /**
     * @return choiceNot
     */
    public String getChoiceNot() {
        return choiceNot;
    }

    /**
     * @param choiceNot 要设置的 choiceNot
     */
    public void setChoiceNot(String choiceNot) {
        this.choiceNot = choiceNot;
    }

    /**
     * @return choiceLittle
     */
    public String getChoiceLittle() {
        return choiceLittle;
    }

    /**
     * @param choiceLittle 要设置的 choiceLittle
     */
    public void setChoiceLittle(String choiceLittle) {
        this.choiceLittle = choiceLittle;
    }

    /**
     * @return choiceSometimes
     */
    public String getChoiceSometimes() {
        return choiceSometimes;
    }

    /**
     * @param choiceSometimes 要设置的 choiceSometimes
     */
    public void setChoiceSometimes(String choiceSometimes) {
        this.choiceSometimes = choiceSometimes;
    }

    /**
     * @return choiceOften
     */
    public String getChoiceOften() {
        return choiceOften;
    }

    /**
     * @param choiceOften 要设置的 choiceOften
     */
    public void setChoiceOften(String choiceOften) {
        this.choiceOften = choiceOften;
    }

    /**
     * @return choiceAlways
     */
    public String getChoiceAlways() {
        return choiceAlways;
    }

    /**
     * @param choiceAlways 要设置的 choiceAlways
     */
    public void setChoiceAlways(String choiceAlways) {
        this.choiceAlways = choiceAlways;
    }

    /**
     * @return choiceNotScore
     */
    public BigDecimal getChoiceNotScore() {
        return choiceNotScore;
    }

    /**
     * @param choiceNotScore 要设置的 choiceNotScore
     */
    public void setChoiceNotScore(BigDecimal choiceNotScore) {
        this.choiceNotScore = choiceNotScore;
    }

    /**
     * @return choiceLittleScore
     */
    public BigDecimal getChoiceLittleScore() {
        return choiceLittleScore;
    }

    /**
     * @param choiceLittleScore 要设置的 choiceLittleScore
     */
    public void setChoiceLittleScore(BigDecimal choiceLittleScore) {
        this.choiceLittleScore = choiceLittleScore;
    }

    /**
     * @return choiceSometimesScore
     */
    public BigDecimal getChoiceSometimesScore() {
        return choiceSometimesScore;
    }

    /**
     * @param choiceSometimesScore 要设置的 choiceSometimesScore
     */
    public void setChoiceSometimesScore(BigDecimal choiceSometimesScore) {
        this.choiceSometimesScore = choiceSometimesScore;
    }

    /**
     * @return choiceOftenScore
     */
    public BigDecimal getChoiceOftenScore() {
        return choiceOftenScore;
    }

    /**
     * @param choiceOftenScore 要设置的 choiceOftenScore
     */
    public void setChoiceOftenScore(BigDecimal choiceOftenScore) {
        this.choiceOftenScore = choiceOftenScore;
    }

    /**
     * @return choiceAlwaysScore
     */
    public BigDecimal getChoiceAlwaysScore() {
        return choiceAlwaysScore;
    }

    /**
     * @param choiceAlwaysScore 要设置的 choiceAlwaysScore
     */
    public void setChoiceAlwaysScore(BigDecimal choiceAlwaysScore) {
        this.choiceAlwaysScore = choiceAlwaysScore;
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