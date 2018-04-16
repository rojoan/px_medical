package com.bofan.publichealth.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * ExamInHospital entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_IN_HOSPITAL", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "IN_HOSPITAL_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".EXAM_IN_HOSPITAL_ID", allocationSize = 1)
public class ExamInHospital implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 666752315865986816L;
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IN_HOSPITAL_ID")
    @Column(name = "IN_HOSPITAL_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long inHospitalId;
    
    @Column(name = "EXAM_PERSON_ID", nullable = false, precision = 18, scale = 0)
    private Long examPersonId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXAM_PERSON_ID", nullable = false, insertable = false, updatable = false)
	private ExamPerson examPerson;
    
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
    
    @Column(name = "EXAM_TIME", nullable = false)
	private Date examTime;
    
    @Column(name = "IN_HOSPITAL_TIME", nullable = false, length = 20)
	private String inHospitalTime;
    
    @Column(name = "OUT_HOSPIRAL_TIME", length = 20)
	private String outHospiralTime;
    
    @Column(name = "IN_HOSPITAL_REASON", length = 100)
	private String inHospitalReason;
    
    @Column(name = "HOSPITAL_ORG", length = 80)
	private String hospitalOrg;
    
    @Column(name = "PATIENT_NUM", length = 20)
	private String patientNum;

	// Constructors

	/** default constructor */
	public ExamInHospital() {
	}

    /**
     * @return the inHospitalId
     */
    public Long getInHospitalId() {
        return inHospitalId;
    }

    /**
     * @param inHospitalId the inHospitalId to set
     */
    public void setInHospitalId(Long inHospitalId) {
        this.inHospitalId = inHospitalId;
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
     * @return the examPerson
     */
    public ExamPerson getExamPerson() {
        return examPerson;
    }

    /**
     * @param examPerson the examPerson to set
     */
    public void setExamPerson(ExamPerson examPerson) {
        this.examPerson = examPerson;
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
     * @return the inHospitalTime
     */
    public String getInHospitalTime() {
        return inHospitalTime;
    }

    /**
     * @param inHospitalTime the inHospitalTime to set
     */
    public void setInHospitalTime(String inHospitalTime) {
        this.inHospitalTime = inHospitalTime;
    }

    /**
     * @return the outHospiralTime
     */
    public String getOutHospiralTime() {
        return outHospiralTime;
    }

    /**
     * @param outHospiralTime the outHospiralTime to set
     */
    public void setOutHospiralTime(String outHospiralTime) {
        this.outHospiralTime = outHospiralTime;
    }

    /**
     * @return the inHospitalReason
     */
    public String getInHospitalReason() {
        return inHospitalReason;
    }

    /**
     * @param inHospitalReason the inHospitalReason to set
     */
    public void setInHospitalReason(String inHospitalReason) {
        this.inHospitalReason = inHospitalReason;
    }

    /**
     * @return the hospitalOrg
     */
    public String getHospitalOrg() {
        return hospitalOrg;
    }

    /**
     * @param hospitalOrg the hospitalOrg to set
     */
    public void setHospitalOrg(String hospitalOrg) {
        this.hospitalOrg = hospitalOrg;
    }

    /**
     * @return the patientNum
     */
    public String getPatientNum() {
        return patientNum;
    }

    /**
     * @param patientNum the patientNum to set
     */
    public void setPatientNum(String patientNum) {
        this.patientNum = patientNum;
    }

	// Property accessors
	
}