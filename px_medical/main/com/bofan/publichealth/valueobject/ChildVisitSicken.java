package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * ChildVisitSicken entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CHILD_VISIT_SICKEN", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "CHILD_VISIT_SICKEN_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".CHILD_VISIT_SICKEN_ID", allocationSize = 1)
public class ChildVisitSicken implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 8034695159035241683L;
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHILD_VISIT_SICKEN_ID")
    @Column(name = "CHILD_VISIT_SICKEN_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long childVisitSickenId;
    
    @Column(name = "CHILD_VISIT_ID", nullable = false, precision = 18, scale = 0)
    private Long childVisitId;
    
    @Column(name = "VISIT_SICKEN_ID", nullable = false, precision = 18, scale = 0)
    private Long visitSickenId;
    
    @Column(name = "CHILD_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long childDetailId;
    
    @Column(name = "SICKEN_CONTENT", length = 40)
	private String sickenContent;

	// Constructors

	/** default constructor */
	public ChildVisitSicken() {
	}
	
	// Property accessors

    /**
     * @return the childVisitSickenId
     */
    public Long getChildVisitSickenId() {
        return childVisitSickenId;
    }

    /**
     * @param childVisitSickenId the childVisitSickenId to set
     */
    public void setChildVisitSickenId(Long childVisitSickenId) {
        this.childVisitSickenId = childVisitSickenId;
    }

    /**
     * @return the childVisitId
     */
    public Long getChildVisitId() {
        return childVisitId;
    }

    /**
     * @param childVisitId the childVisitId to set
     */
    public void setChildVisitId(Long childVisitId) {
        this.childVisitId = childVisitId;
    }

    /**
     * @return the visitSickenId
     */
    public Long getVisitSickenId() {
        return visitSickenId;
    }

    /**
     * @param visitSickenId the visitSickenId to set
     */
    public void setVisitSickenId(Long visitSickenId) {
        this.visitSickenId = visitSickenId;
    }

    /**
     * @return the childDetailId
     */
    public Long getChildDetailId() {
        return childDetailId;
    }

    /**
     * @param childDetailId the childDetailId to set
     */
    public void setChildDetailId(Long childDetailId) {
        this.childDetailId = childDetailId;
    }

    /**
     * @return the sickenContent
     */
    public String getSickenContent() {
        return sickenContent;
    }

    /**
     * @param sickenContent the sickenContent to set
     */
    public void setSickenContent(String sickenContent) {
        this.sickenContent = sickenContent;
    }
	
}