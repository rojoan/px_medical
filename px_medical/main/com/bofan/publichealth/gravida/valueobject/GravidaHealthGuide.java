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

/**
 * @Description: 孕妇保健指导表
 * @author lqw
 */
@Entity
@Table(name = "GRAVIDA_HEALTH_GUIDE", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "GRAVIDA_HEALTH_GUIDE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".GRAVIDA_HEALTH_GUIDE_ID", allocationSize = 1)
public class GravidaHealthGuide {

    /** 孕妇保健指导ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRAVIDA_HEALTH_GUIDE_ID")
    @Column(name = "GRAVIDA_HEALTH_GUIDE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long gravidaHealthGuideId;
	
    /** 孕产妇登记卡ID，冗余字段 */
    @Column(name = "GRAVIDA_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long gravidaDetailId;
	
    /** 初次孕检记录ID，自动增长ID */
    @Column(name = "PREGNANCY_FIRST_EXAM_ID", precision = 18, scale = 0)
	private Long pregnancyFirstExamId;
	
    /** 孕期检查记录ID，自动增长ID */
    @Column(name = "PREGNANCY_EXAM_ID", precision = 18, scale = 0)
	private Long pregnancyExamId;
	
    /** 保健类型  01=生活方式  02=避免畸型和疾病对胚胎的不良影响 03=心理  04=产前筛查宣传告知  05=营养  99=其他   */
    @Column(name = "HEALTH_GUIDE_TYPE", nullable = false, length = 2)
	private String healthGuideType;
	
    /** 其他描述 */
    @Column(name = "HEALTH_GUIDE_OTHER_CONTENT", length = 200)
	private String healthGuideOtherContent;
	
    /** 孕检（登记）日期 */
    @Column(name = "CUR_CREATE_TIME", nullable = false)
	private Date curCreateTime;

	/** default constructor */
	public GravidaHealthGuide() {
	}

    /**
     * @return gravidaHealthGuideId
     */
    public Long getGravidaHealthGuideId() {
        return gravidaHealthGuideId;
    }

    /**
     * @param gravidaHealthGuideId 要设置的 gravidaHealthGuideId
     */
    public void setGravidaHealthGuideId(Long gravidaHealthGuideId) {
        this.gravidaHealthGuideId = gravidaHealthGuideId;
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