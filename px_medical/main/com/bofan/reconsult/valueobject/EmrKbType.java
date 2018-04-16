/*
 * <p> Title:  FaqType.java</p>
 * <p>Copyright:   bofan 2017</p>
 * <p>Company: 博繁科技</p>
 */
package com.bofan.reconsult.valueobject;

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
@Table(name = "EMR_KB_TYPE", schema = SchemaConsts.REMOTE_CONSULT)
@SequenceGenerator(name = "EMR_KB_TYPE_ID", sequenceName = SchemaConsts.REMOTE_CONSULT + ".EMR_KB_TYPE_ID", allocationSize=1)
public class EmrKbType implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMR_KB_TYPE_ID")
    @Column(name = "EMR_KB_TYPE_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long emrKbTypeId;
    
    @Column(name = "EMR_KB_TYPE_CODE", nullable = false, length = 18, unique=true)
    private String emrKbTypeCode;
    
    @Column(name = "EMR_KB_TYPE_NAME", nullable = false, length = 40)
    private String emrKbTypeName;

    /**
     * 
     */
    public EmrKbType() {
        
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
     * @return the emrKbTypeCode
     */
    public String getEmrKbTypeCode() {
        return emrKbTypeCode;
    }

    /**
     * @param emrKbTypeCode the emrKbTypeCode to set
     */
    public void setEmrKbTypeCode(String emrKbTypeCode) {
        this.emrKbTypeCode = emrKbTypeCode;
    }

    /**
     * @return the emrKbTypeName
     */
    public String getEmrKbTypeName() {
        return emrKbTypeName;
    }

    /**
     * @param emrKbTypeName the emrKbTypeName to set
     */
    public void setEmrKbTypeName(String emrKbTypeName) {
        this.emrKbTypeName = emrKbTypeName;
    }

}

