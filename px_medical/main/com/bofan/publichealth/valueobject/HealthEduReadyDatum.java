package com.bofan.publichealth.valueobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 健康教育宣传栏
 * @author xlf
 */
@Entity
@Table(name = "HEALTH_EDU_READY_DATUM", schema = SchemaConsts.PUBLIC_HEALTH)
public class HealthEduReadyDatum implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1655357154245841636L;

    @Id
	@Column(name = "HEALTH_EDUCATION_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long healthEducationId;
    
    /** 活动教案 */
    @Column(name = "TEACHING_PLAN", length = 200)
    private String teachingPlan;
    
    /** 宣传横幅内容 */
    @Column(name = "BANNER_CONTENT", length = 200)
    private String bannerContent;
    
    /** 海报 */
    @Column(name = "EDU_POSTER", length = 200)
    private String eduPoster;
    
    /** 展板 */
    @Column(name = "DISPLAY_BOARD", length = 200)
    private String displayBoard;
    
    /** 宣传单 */
    @Column(name = "EDU_LEAFLET", length = 200)
    private String eduLeaflet;
    
    /** 签到表 */
    @Column(name = "SIGN_IN", length = 200)
    private String signIn;
    
    /** 效果评价问卷表 */
    @Column(name = "EDU_ESTIMATE", length = 200)
    private String eduEstimate;
    
    /** 资料发放登记表 */
    @Column(name = "GIVE_DATUM_RECORD", length = 200)
    private String giveDatumRecord;
    
    /** 传播实物、小礼品 */
    @Column(name = "SMALL_GIFT", length = 200)
    private String smallGift;
    
	/** default constructor */
	public HealthEduReadyDatum() {
	}

    /**
     * @return the healthEducationId
     */
    public Long getHealthEducationId() {
        return healthEducationId;
    }

    /**
     * @param healthEducationId the healthEducationId to set
     */
    public void setHealthEducationId(Long healthEducationId) {
        this.healthEducationId = healthEducationId;
    }

    /**
     * @return the teachingPlan
     */
    public String getTeachingPlan() {
        return teachingPlan;
    }

    /**
     * @param teachingPlan the teachingPlan to set
     */
    public void setTeachingPlan(String teachingPlan) {
        this.teachingPlan = teachingPlan;
    }

    /**
     * @return the bannerContent
     */
    public String getBannerContent() {
        return bannerContent;
    }

    /**
     * @param bannerContent the bannerContent to set
     */
    public void setBannerContent(String bannerContent) {
        this.bannerContent = bannerContent;
    }

    /**
     * @return the eduPoster
     */
    public String getEduPoster() {
        return eduPoster;
    }

    /**
     * @param eduPoster the eduPoster to set
     */
    public void setEduPoster(String eduPoster) {
        this.eduPoster = eduPoster;
    }

    /**
     * @return the displayBoard
     */
    public String getDisplayBoard() {
        return displayBoard;
    }

    /**
     * @param displayBoard the displayBoard to set
     */
    public void setDisplayBoard(String displayBoard) {
        this.displayBoard = displayBoard;
    }

    /**
     * @return the eduLeaflet
     */
    public String getEduLeaflet() {
        return eduLeaflet;
    }

    /**
     * @param eduLeaflet the eduLeaflet to set
     */
    public void setEduLeaflet(String eduLeaflet) {
        this.eduLeaflet = eduLeaflet;
    }

    /**
     * @return the signIn
     */
    public String getSignIn() {
        return signIn;
    }

    /**
     * @param signIn the signIn to set
     */
    public void setSignIn(String signIn) {
        this.signIn = signIn;
    }

    /**
     * @return the eduEstimate
     */
    public String getEduEstimate() {
        return eduEstimate;
    }

    /**
     * @param eduEstimate the eduEstimate to set
     */
    public void setEduEstimate(String eduEstimate) {
        this.eduEstimate = eduEstimate;
    }

    /**
     * @return the giveDatumRecord
     */
    public String getGiveDatumRecord() {
        return giveDatumRecord;
    }

    /**
     * @param giveDatumRecord the giveDatumRecord to set
     */
    public void setGiveDatumRecord(String giveDatumRecord) {
        this.giveDatumRecord = giveDatumRecord;
    }

    /**
     * @return the smallGift
     */
    public String getSmallGift() {
        return smallGift;
    }

    /**
     * @param smallGift the smallGift to set
     */
    public void setSmallGift(String smallGift) {
        this.smallGift = smallGift;
    }

}