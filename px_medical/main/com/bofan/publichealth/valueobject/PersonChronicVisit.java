package com.bofan.publichealth.valueobject;

import java.io.Serializable;
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
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 慢性病患者随访记录表
 * 
 */
@Entity
@Table(name="PERSON_CHRONIC_VISIT", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "CHRONIC_VISIT_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_CHRONIC_VISIT_ID", allocationSize = 1)
public class PersonChronicVisit implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHRONIC_VISIT_ID")
	@Column(name="CHRONIC_VISIT_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long chronicVisitId;

	@Column(name="HOSPITAL_ID", precision = 18, scale = 0)
	private Long hospitalId;

	@Column(name="HOSPITAL_NAME")
	private String hospitalName;

	@Column(name="HOSPITAL_NO")
	private String hospitalNo;

	@Column(name="HOSPITAL_PHONE")
	private String hospitalPhone;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name="NEXT_VISIT_TIME")
	private Date nextVisitTime;

	@Column(name="PERSON_CHRONIC_ID", precision = 18, scale = 0)
	private Long personChronicId;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PERSON_CHRONIC_ID", insertable = false, updatable = false)
    private PersonChronic personChronic;

	@Column(name="PERSON_DETAIL_ID", precision = 18, scale = 0)
	private Long personDetailId;

	@Column(name="TRANS_DIAGNOSIS_DESCRIBE")
	private String transDiagnosisDescribe;

	@Column(name="TRANS_DIAGNOSIS_FLAG")
	private String transDiagnosisFlag;

	@Column(name="TRANS_DIAGNOSIS_OFFICE_ID", precision = 18, scale = 0)
	private Long transDiagnosisOfficeId;

	@Column(name="TRANS_DIAGNOSIS_OFFICE_NAME")
	private String transDiagnosisOfficeName;

	@Column(name="TRANS_DIAGNOSIS_REASON")
	private String transDiagnosisReason;

	@Column(name="VALID_FLAG")
	private String validFlag;

	@Column(name="VISIT_DOCTOR_ID", precision = 18, scale = 0)
	private Long visitDoctorId;

	@Column(name="VISIT_DOCTOR_NAME")
	private String visitDoctorName;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name="VISIT_TIME")
	private Date visitTime;
	
	@Column(name="CHRONIC_TYPE")
	private String chronicType;

	@Column(name="VISIT_WAY")
	private String visitWay;
	
	@Column(name="THERAPY_STOP_REASON", length = 1)
    private String therapyStopReason;
    
    @Column(name="THERAPY_STOP_DATE")
    private Date therapyStopDate;

	public PersonChronicVisit() {
	}

	/**
     * @return the chronicVisitId
     */
    public Long getChronicVisitId() {
        return chronicVisitId;
    }

    /**
     * @param chronicVisitId the chronicVisitId to set
     */
    public void setChronicVisitId(Long chronicVisitId) {
        this.chronicVisitId = chronicVisitId;
    }

    public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalNo() {
		return this.hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getHospitalPhone() {
		return this.hospitalPhone;
	}

	public void setHospitalPhone(String hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
	}

	public Date getNextVisitTime() {
		return this.nextVisitTime;
	}

	public void setNextVisitTime(Date nextVisitTime) {
		this.nextVisitTime = nextVisitTime;
	}

	public Long getPersonChronicId() {
		return this.personChronicId;
	}

	public void setPersonChronicId(Long personChronicId) {
		this.personChronicId = personChronicId;
	}

	/**
     * @return the personChronic
     */
    public PersonChronic getPersonChronic() {
        return personChronic;
    }

    /**
     * @param personChronic the personChronic to set
     */
    public void setPersonChronic(PersonChronic personChronic) {
        this.personChronic = personChronic;
    }

    public Long getPersonDetailId() {
		return this.personDetailId;
	}

	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	public String getTransDiagnosisDescribe() {
		return this.transDiagnosisDescribe;
	}

	public void setTransDiagnosisDescribe(String transDiagnosisDescribe) {
		this.transDiagnosisDescribe = transDiagnosisDescribe;
	}

	public String getTransDiagnosisFlag() {
		return this.transDiagnosisFlag;
	}

	public void setTransDiagnosisFlag(String transDiagnosisFlag) {
		this.transDiagnosisFlag = transDiagnosisFlag;
	}

	public Long getTransDiagnosisOfficeId() {
		return this.transDiagnosisOfficeId;
	}

	public void setTransDiagnosisOfficeId(Long transDiagnosisOfficeId) {
		this.transDiagnosisOfficeId = transDiagnosisOfficeId;
	}

	public String getTransDiagnosisOfficeName() {
		return this.transDiagnosisOfficeName;
	}

	public void setTransDiagnosisOfficeName(String transDiagnosisOfficeName) {
		this.transDiagnosisOfficeName = transDiagnosisOfficeName;
	}

	public String getTransDiagnosisReason() {
		return this.transDiagnosisReason;
	}

	public void setTransDiagnosisReason(String transDiagnosisReason) {
		this.transDiagnosisReason = transDiagnosisReason;
	}

	public String getValidFlag() {
		return this.validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

	public Long getVisitDoctorId() {
		return this.visitDoctorId;
	}

	public void setVisitDoctorId(Long visitDoctorId) {
		this.visitDoctorId = visitDoctorId;
	}

	public String getVisitDoctorName() {
		return this.visitDoctorName;
	}

	public void setVisitDoctorName(String visitDoctorName) {
		this.visitDoctorName = visitDoctorName;
	}

	public Date getVisitTime() {
		return this.visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	/**
     * @return the chronicType
     */
    public String getChronicType() {
        return chronicType;
    }

    /**
     * @param chronicType the chronicType to set
     */
    public void setChronicType(String chronicType) {
        this.chronicType = chronicType;
    }

    public String getVisitWay() {
		return this.visitWay;
	}

	public void setVisitWay(String visitWay) {
		this.visitWay = visitWay;
	}

    /**
     * @return the therapyStopReason
     */
    public String getTherapyStopReason() {
        return therapyStopReason;
    }

    /**
     * @param therapyStopReason the therapyStopReason to set
     */
    public void setTherapyStopReason(String therapyStopReason) {
        this.therapyStopReason = therapyStopReason;
    }

    /**
     * @return the therapyStopDate
     */
    public Date getTherapyStopDate() {
        return therapyStopDate;
    }

    /**
     * @param therapyStopDate the therapyStopDate to set
     */
    public void setTherapyStopDate(Date therapyStopDate) {
        this.therapyStopDate = therapyStopDate;
    }

}