/*
 * <p> Title:  FaqDetail.java</p>
 * <p>Copyright:   bofan  2017</p>
 * <p>Company: 博繁科技</p>
 */
package com.bofan.faq.valueobject;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p> Calss Name:  FaqInfo.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author pch
 * @created  2017-10-16
 */
@Entity
@Table(name = "FAQ_DETAIL", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "FAQ_DETAIL_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".FAQ_DETAIL_ID", allocationSize=1)
public class FaqDetail implements java.io.Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FAQ_DETAIL_ID")
    @Column(name = "FAQ_DETAIL_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long faqDetailId;
    
    @Column(name = "FAQ_TYPE_ID", nullable = false, length = 18)
    private Long faqTypeId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FAQ_TYPE_ID", nullable = true, insertable = false, updatable = false)
    private FaqType faqType;
    
    @Column(name = "FAQ_TITLE", nullable = false, length = 1000)
    private String faqTitle;
    
    @Lob 
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "FAQ_CONTENT", nullable = false)
    private String faqContent;
    
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "CREATE_TIME", nullable = false)
    private Date createTime;
    
    @Column(name = "CREATOR_ID", nullable = false, precision = 22, scale = 0)
    private Long creatorId;
    
    @Column(name = "CLICK_COUNT", nullable = false, precision = 22, scale = 0)
    private Long clickCount;
    
    @Column(name = "AFFIX_ID", length = 40)
    private String affixId;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AFFIX_ID", nullable = true, insertable = false, updatable = false)
    private FaqAffix affix;
    
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "CLICK_TIME")
    private Date clickTime;
    
    /**
	 * @return the faqDetailId
	 */
	public Long getFaqDetailId() {
		return faqDetailId;
	}

	/**
	 * @param faqDetailId the faqDetailId to set
	 */
	public void setFaqDetailId(Long faqDetailId) {
		this.faqDetailId = faqDetailId;
	}

	/**
     * @return the faqTitle
     */
    public String getFaqTitle() {
        return faqTitle;
    }

    /**
     * @param faqTitle the faqTitle to set
     */
    public void setFaqTitle(String faqTitle) {
        this.faqTitle = faqTitle;
    }

    /**
     * @return the faqContent
     */
    public String getFaqContent() {
        return faqContent;
    }

    /**
     * @param faqContent the faqContent to set
     */
    public void setFaqContent(String faqContent) {
        this.faqContent = faqContent;
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

    /**
     * @return the creatorId
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId
     *            the creatorId to set
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return the clickCount
     */
    public Long getClickCount() {
        return clickCount;
    }

    /**
     * @param clickCount the clickCount to set
     */
    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    /**
     * @return the affixId
     */
    public String getAffixId() {
        return affixId;
    }

    /**
     * @param affixId the affixId to set
     */
    public void setAffixId(String affixId) {
        this.affixId = affixId;
    }

    public FaqType getFaqType() {
        return faqType;
    }

    public void setFaqType(FaqType faqType) {
        this.faqType = faqType;
    }

    public Date getClickTime() {
        return clickTime;
    }

    public void setClickTime(Date clickTime) {
        this.clickTime = clickTime;
    }

    public FaqAffix getAffix() {
        return affix;
    }

    public void setAffix(FaqAffix affix) {
        this.affix = affix;
    }

    public Long getFaqTypeId() {
        return faqTypeId;
    }

    public void setFaqTypeId(Long faqTypeId) {
        this.faqTypeId = faqTypeId;
    }
    
}
