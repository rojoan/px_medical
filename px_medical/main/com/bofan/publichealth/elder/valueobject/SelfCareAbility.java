package com.bofan.publichealth.elder.valueobject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 自理能力评估项目字典表--老年人
 * @author lqw
 */
@Entity
@Table(name = "SELF_CARE_ABILITY", schema = SchemaConsts.PUBLIC_HEALTH)
public class SelfCareAbility {

    /** 自理能力评估项目ID，主键ID */
    @Id
    @Column(name = "SELF_CARE_ABILITY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long selfCareAbilityId;
	
    /** 评估项目内容 */
    @Column(name = "ABILITY_CONTENT", nullable = false, length = 200)
	private String abilityContent;
	
    /** 程度等级--可自理 */
    @Column(name = "SELF_CARE", length = 80)
	private String selfCare;
	
    /** 评分--可自理 */
    @Column(name = "SELF_CARE_SCORE", precision = 2, scale = 0)
	private BigDecimal selfCareScore;
	
    /** 程度等级--轻度依赖 */
    @Column(name = "LOW_DEPEND", length = 80)
	private String lowDepend;
	
    /** 评分--轻度依赖 */
    @Column(name = "LOW_DEPEND_SCORE", precision = 2, scale = 0)
	private BigDecimal lowDependScore;
	
    /** 程度等级--中度依赖 */
    @Column(name = "MIDDLE_DEPEND", length = 80)
	private String middleDepend;
	
    /** 评分--中度依赖 */
    @Column(name = "MIDDLE_DEPEND_SCORE", precision = 2, scale = 0)
	private BigDecimal middleDependScore;
	
    /** 程度等级--不能自理 */
    @Column(name = "NOT_SELF_CARE", length = 80)
	private String notSelfCare;
	
    /** 评分--不能自理 */
    @Column(name = "NOT_SELF_CARE_SCORE", precision = 2, scale = 0)
	private BigDecimal notSelfCareScore;
   
    /** 是否有效 1=有效 0=无效 */
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public SelfCareAbility() {
	}

    /**
     * @return selfCareAbilityId
     */
    public Long getSelfCareAbilityId() {
        return selfCareAbilityId;
    }

    /**
     * @param selfCareAbilityId 要设置的 selfCareAbilityId
     */
    public void setSelfCareAbilityId(Long selfCareAbilityId) {
        this.selfCareAbilityId = selfCareAbilityId;
    }

    /**
     * @return abilityContent
     */
    public String getAbilityContent() {
        return abilityContent;
    }

    /**
     * @param abilityContent 要设置的 abilityContent
     */
    public void setAbilityContent(String abilityContent) {
        this.abilityContent = abilityContent;
    }

    /**
     * @return selfCare
     */
    public String getSelfCare() {
        return selfCare;
    }

    /**
     * @param selfCare 要设置的 selfCare
     */
    public void setSelfCare(String selfCare) {
        this.selfCare = selfCare;
    }

    /**
     * @return selfCareScore
     */
    public BigDecimal getSelfCareScore() {
        return selfCareScore;
    }

    /**
     * @param selfCareScore 要设置的 selfCareScore
     */
    public void setSelfCareScore(BigDecimal selfCareScore) {
        this.selfCareScore = selfCareScore;
    }

    /**
     * @return lowDepend
     */
    public String getLowDepend() {
        return lowDepend;
    }

    /**
     * @param lowDepend 要设置的 lowDepend
     */
    public void setLowDepend(String lowDepend) {
        this.lowDepend = lowDepend;
    }

    /**
     * @return lowDependScore
     */
    public BigDecimal getLowDependScore() {
        return lowDependScore;
    }

    /**
     * @param lowDependScore 要设置的 lowDependScore
     */
    public void setLowDependScore(BigDecimal lowDependScore) {
        this.lowDependScore = lowDependScore;
    }

    /**
     * @return middleDepend
     */
    public String getMiddleDepend() {
        return middleDepend;
    }

    /**
     * @param middleDepend 要设置的 middleDepend
     */
    public void setMiddleDepend(String middleDepend) {
        this.middleDepend = middleDepend;
    }

    /**
     * @return middleDependScore
     */
    public BigDecimal getMiddleDependScore() {
        return middleDependScore;
    }

    /**
     * @param middleDependScore 要设置的 middleDependScore
     */
    public void setMiddleDependScore(BigDecimal middleDependScore) {
        this.middleDependScore = middleDependScore;
    }

    /**
     * @return notSelfCare
     */
    public String getNotSelfCare() {
        return notSelfCare;
    }

    /**
     * @param notSelfCare 要设置的 notSelfCare
     */
    public void setNotSelfCare(String notSelfCare) {
        this.notSelfCare = notSelfCare;
    }

    /**
     * @return notSelfCareScore
     */
    public BigDecimal getNotSelfCareScore() {
        return notSelfCareScore;
    }

    /**
     * @param notSelfCareScore 要设置的 notSelfCareScore
     */
    public void setNotSelfCareScore(BigDecimal notSelfCareScore) {
        this.notSelfCareScore = notSelfCareScore;
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