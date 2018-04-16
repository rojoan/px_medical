package com.bofan.publichealth.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * ExamElder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_ELDER", schema = SchemaConsts.PUBLIC_HEALTH)
public class ExamElder implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1900682117725488678L;
    // Fields

    @Id
    @Column(name = "EXAM_PERSON_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long examPersonId;
    
    @Column(name = "EXAM_TIME")
	private Date examTime;
    
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
    
    @Column(name = "HEALTH_ASSESS", length = 1)
	private String healthAssess;
	
	@Column(name = "LIVE_SELF_ASSESS", length = 1)
	private String liveSelfAssess;
	
	@Column(name = "COGNITIVE_FUNCTION", length = 1)
	private String cognitiveFunction;
	
	@Column(name = "INTELLIGENCE_CHECK", precision = 18, scale = 0)
	private Long intelligenceCheck;
	
	@Column(name = "EMOTION_CONDITION", length = 1)
	private String emotionCondition;
	
	@Column(name = "DEPRESSION_CHECK", precision = 18, scale = 0)
	private Long depressionCheck;
	
	@Column(name = "CREATOR_ID", nullable = false, precision = 18, scale = 0)
	private Long creatorId;
	
	@Column(name = "CREATOR_NAME", nullable = false, length = 20)
	private String creatorName;
	
	@Column(name = "CREATE_TIME", nullable = false)
	private Date createTime;

	// Constructors

	/** default constructor */
	public ExamElder() {
	}
	// Property accessors

    /**
     * @return the examPersonId
     */
    public Long getExamPersonId() {
        return examPersonId;
    }

    /**
     * @param examPersonId the examPersonId to set
     */
    public void setExamPersonId(Long examPersonId) {
        this.examPersonId = examPersonId;
    }

    /**
     * @return the examTime
     */
    public Date getExamTime() {
        return examTime;
    }

    /**
     * @param examTime the examTime to set
     */
    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    /**
     * @return the personDetailId
     */
    public Long getPersonDetailId() {
        return personDetailId;
    }

    /**
     * @param personDetailId the personDetailId to set
     */
    public void setPersonDetailId(Long personDetailId) {
        this.personDetailId = personDetailId;
    }

    /**
     * @return the healthAssess
     */
    public String getHealthAssess() {
        return healthAssess;
    }

    /**
     * @param healthAssess the healthAssess to set
     */
    public void setHealthAssess(String healthAssess) {
        this.healthAssess = healthAssess;
    }

    /**
     * @return the liveSelfAssess
     */
    public String getLiveSelfAssess() {
        return liveSelfAssess;
    }

    /**
     * @param liveSelfAssess the liveSelfAssess to set
     */
    public void setLiveSelfAssess(String liveSelfAssess) {
        this.liveSelfAssess = liveSelfAssess;
    }

    /**
     * @return the cognitiveFunction
     */
    public String getCognitiveFunction() {
        return cognitiveFunction;
    }

    /**
     * @param cognitiveFunction the cognitiveFunction to set
     */
    public void setCognitiveFunction(String cognitiveFunction) {
        this.cognitiveFunction = cognitiveFunction;
    }

    /**
     * @return the intelligenceCheck
     */
    public Long getIntelligenceCheck() {
        return intelligenceCheck;
    }

    /**
     * @param intelligenceCheck the intelligenceCheck to set
     */
    public void setIntelligenceCheck(Long intelligenceCheck) {
        this.intelligenceCheck = intelligenceCheck;
    }

    /**
     * @return the emotionCondition
     */
    public String getEmotionCondition() {
        return emotionCondition;
    }

    /**
     * @param emotionCondition the emotionCondition to set
     */
    public void setEmotionCondition(String emotionCondition) {
        this.emotionCondition = emotionCondition;
    }

    /**
     * @return the depressionCheck
     */
    public Long getDepressionCheck() {
        return depressionCheck;
    }

    /**
     * @param depressionCheck the depressionCheck to set
     */
    public void setDepressionCheck(Long depressionCheck) {
        this.depressionCheck = depressionCheck;
    }

    /**
     * @return the creatorId
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId the creatorId to set
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return the creatorName
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * @param creatorName the creatorName to set
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
	

}