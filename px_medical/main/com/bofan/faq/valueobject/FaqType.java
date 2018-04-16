/*
 * <p> Title:  FaqType.java</p>
 * <p>Copyright:   bofan 2017</p>
 * <p>Company: 博繁科技</p>
 */
package com.bofan.faq.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * <p> Calss Name:  FaqType.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author pch
 * @created  2017-10-16
 */
@Entity
@Table(name = "FAQ_TYPE", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "FAQ_TYPE_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".FAQ_TYPE_ID", allocationSize=1)
public class FaqType implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FAQ_TYPE_ID")
    @Column(name = "FAQ_TYPE_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long faqTypeId;
    
    @Column(name = "FAQ_TYPE_CODE", nullable = false, length = 18, unique=true)
    private String faqTypeCode;
    
    @Column(name = "FAQ_TYPE_NAME", nullable = false, length = 40)
    private String faqTypeName;

    public Long getFaqTypeId() {
        return faqTypeId;
    }

    public void setFaqTypeId(Long faqTypeId) {
        this.faqTypeId = faqTypeId;
    }

    public String getFaqTypeCode() {
        return faqTypeCode;
    }

    public void setFaqTypeCode(String faqTypeCode) {
        this.faqTypeCode = faqTypeCode;
    }

    public String getFaqTypeName() {
        return faqTypeName;
    }

    public void setFaqTypeName(String faqTypeName) {
        this.faqTypeName = faqTypeName;
    }
  
}

