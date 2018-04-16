package com.bofan.publichealth.valueobject;

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
 * ExamPersonalNovac entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_PERSONAL_NOVAC", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PERSON_NOVAC_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".EXAM_PERSON_NOVAC_ID", allocationSize = 1)
public class ExamPersonalNovac implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 4234976130706657548L;
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_NOVAC_ID")
    @Column(name = "PERSON_NOVAC_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long personNovacId;
	
	@Column(name = "EXAM_PERSON_ID", nullable = false, precision = 18, scale = 0)
    private Long examPersonId;
    
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
    
    @Column(name = "EXAM_TIME", nullable = false)
	private Date examTime;
    
    @Column(name = "VAC_NAME", nullable = false, length = 80)
	private String vacName;
    
    @Column(name = "VAC_TIME", length = 20)
	private String vacTime;
    
    @Column(name = "VAC_ORG", length = 80)
	private String vacOrg;

	// Constructors

	/** default constructor */
	public ExamPersonalNovac() {
	}

    /**
     * @return the personNovacId
     */
    public Long getPersonNovacId() {
        return personNovacId;
    }

    /**
     * @param personNovacId the personNovacId to set
     */
    public void setPersonNovacId(Long personNovacId) {
        this.personNovacId = personNovacId;
    }

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
     * @return the vacName
     */
    public String getVacName() {
        return vacName;
    }

    /**
     * @param vacName the vacName to set
     */
    public void setVacName(String vacName) {
        this.vacName = vacName;
    }

    /**
     * @return the vacTime
     */
    public String getVacTime() {
        return vacTime;
    }

    /**
     * @param vacTime the vacTime to set
     */
    public void setVacTime(String vacTime) {
        this.vacTime = vacTime;
    }

    /**
     * @return the vacOrg
     */
    public String getVacOrg() {
        return vacOrg;
    }

    /**
     * @param vacOrg the vacOrg to set
     */
    public void setVacOrg(String vacOrg) {
        this.vacOrg = vacOrg;
    }
}