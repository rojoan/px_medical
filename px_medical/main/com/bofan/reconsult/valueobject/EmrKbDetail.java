/*
 * <p> Title:  FaqDetail.java</p>
 * <p>Copyright:   bofan  2017</p>
 * <p>Company: 博繁科技</p>
 */
package com.bofan.reconsult.valueobject;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "EMR_KB_DETAIL", schema = SchemaConsts.REMOTE_CONSULT)
@SequenceGenerator(name = "EMR_KB_DETAIL_ID", sequenceName = SchemaConsts.REMOTE_CONSULT + ".EMR_KB_DETAIL_ID", allocationSize=1)
public class EmrKbDetail implements java.io.Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMR_KB_DETAIL_ID")
    @Column(name = "EMR_KB_DETAIL_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long emrKbDetailId;
    
    @Column(name = "EMR_KB_TYPE_ID", nullable = false, length = 18)
    private Long emrKbTypeId;
    
    @Column(name = "EMR_KB_TITLE", nullable = false, length = 1000)
    private String emrKbTitle;
    
    @Lob 
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "EMR_KB_CONTENT", nullable = false)
    private String emrKbContent;
    
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "CREATE_TIME", nullable = false)
    private Date createTime;
    
    @Column(name = "CREATOR_ID", nullable = false, precision = 22, scale = 0)
    private Long creatorId;
    
    @Column(name = "CLICK_COUNT", nullable = false, precision = 22, scale = 0)
    private Long clickCount;
    
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "CLICK_TIME")
    private Date clickTime;

    /**
     * 
     */
    public EmrKbDetail() {
        super();
    }

    /**
     * @return the emrKbDetailId
     */
    public Long getEmrKbDetailId() {
        return emrKbDetailId;
    }

    /**
     * @param emrKbDetailId the emrKbDetailId to set
     */
    public void setEmrKbDetailId(Long emrKbDetailId) {
        this.emrKbDetailId = emrKbDetailId;
    }

    /**
     * @return the emrKbTypeId
     */
    public Long getEmrKbTypeId() {
        return emrKbTypeId;
    }

    /**
     * @param emrKbTypeId the emrKbTypeId to set
     */
    public void setEmrKbTypeId(Long emrKbTypeId) {
        this.emrKbTypeId = emrKbTypeId;
    }

    /**
     * @return the emrKbTitle
     */
    public String getEmrKbTitle() {
        return emrKbTitle;
    }

    /**
     * @param emrKbTitle the emrKbTitle to set
     */
    public void setEmrKbTitle(String emrKbTitle) {
        this.emrKbTitle = emrKbTitle;
    }

    /**
     * @return the emrKbContent
     */
    public String getEmrKbContent() {
        return emrKbContent;
    }

    /**
     * @param emrKbContent the emrKbContent to set
     */
    public void setEmrKbContent(String emrKbContent) {
        this.emrKbContent = emrKbContent;
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
     * @return the clickTime
     */
    public Date getClickTime() {
        return clickTime;
    }

    /**
     * @param clickTime the clickTime to set
     */
    public void setClickTime(Date clickTime) {
        this.clickTime = clickTime;
    }
    
    
}
