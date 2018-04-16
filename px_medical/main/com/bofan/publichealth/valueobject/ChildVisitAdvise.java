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
 * ChildVisitAdvise entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CHILD_VISIT_ADVISE", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "CHILD_VISIT_ADVISE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".CHILD_VISIT_ADVISE_ID", allocationSize = 1)
public class ChildVisitAdvise implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -5760238434348617047L;
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHILD_VISIT_ADVISE_ID")
    @Column(name = "CHILD_VISIT_ADVISE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long childVisitAdviseId;
    
    @Column(name = "VISIT_ADIVSE_ID", nullable = false, precision = 18, scale = 0)
    private Long visitAdivseId;
    
    @Column(name = "CHILD_VISIT_ID", nullable = false, precision = 18, scale = 0)
    private Long childVisitId;
    
    @Column(name = "CHILD_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long childDetailId;

	// Constructors

	/** default constructor */
	public ChildVisitAdvise() {
	}
	// Property accessors

    /**
     * @return the childVisitAdviseId
     */
    public Long getChildVisitAdviseId() {
        return childVisitAdviseId;
    }

    /**
     * @param childVisitAdviseId the childVisitAdviseId to set
     */
    public void setChildVisitAdviseId(Long childVisitAdviseId) {
        this.childVisitAdviseId = childVisitAdviseId;
    }

    /**
     * @return the visitAdivseId
     */
    public Long getVisitAdivseId() {
        return visitAdivseId;
    }

    /**
     * @param visitAdivseId the visitAdivseId to set
     */
    public void setVisitAdivseId(Long visitAdivseId) {
        this.visitAdivseId = visitAdivseId;
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
	
}