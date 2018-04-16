package com.bofan.publichealth.valueobject;

import java.io.Serializable;
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
 * 慢性病随访--体征
 * 
 */
@Entity
@Table(name="PERSON_VISIT_SIGN", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "VISIT_SIGN_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_VISIT_SIGN_ID", allocationSize = 1)
public class PersonVisitSign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VISIT_SIGN_ID")
	@Column(name="VISIT_SIGN_ID", unique=true, nullable=false, precision=18)
	private Long visitSignId;
	
	@Column(name="PERSON_CHRONIC_ID", unique=true, nullable=false, precision=18)
    private Long personChronicId;
	
	@Column(name="PERSON_DETAIL_ID", unique=true, nullable=false, precision=18)
    private Long personDetailId;

	@Column(name="CHRONIC_TYPE", length = 1)
	private String chronicType;
	
	@Column(name="SIGN_TYPE", length = 1)
    private String signType;
	
	@Column(name="HOSPITAL_ID", nullable=false, precision=18)
    private Long hospitalId;
	
	@Column(name="VISIT_DOCTOR_ID", nullable=false, precision=18)
    private Long visitDoctorId;

	@Column(name="VISIT_TIME")
	private Date visitTime;

	@Column(name="VALID_FLAG", length = 1)
	private String validFlag;

	public PersonVisitSign() {
	}

    /**
     * @return the visitSignId
     */
    public Long getVisitSignId() {
        return visitSignId;
    }

    /**
     * @param visitSignId the visitSignId to set
     */
    public void setVisitSignId(Long visitSignId) {
        this.visitSignId = visitSignId;
    }

    /**
     * @return the personChronicId
     */
    public Long getPersonChronicId() {
        return personChronicId;
    }

    /**
     * @param personChronicId the personChronicId to set
     */
    public void setPersonChronicId(Long personChronicId) {
        this.personChronicId = personChronicId;
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

    /**
     * @return the signType
     */
    public String getSignType() {
        return signType;
    }

    /**
     * @param signType the signType to set
     */
    public void setSignType(String signType) {
        this.signType = signType;
    }

    /**
     * @return the hospitalId
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId the hospitalId to set
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * @return the visitDoctorId
     */
    public Long getVisitDoctorId() {
        return visitDoctorId;
    }

    /**
     * @param visitDoctorId the visitDoctorId to set
     */
    public void setVisitDoctorId(Long visitDoctorId) {
        this.visitDoctorId = visitDoctorId;
    }

    /**
     * @return the visitTime
     */
    public Date getVisitTime() {
        return visitTime;
    }

    /**
     * @param visitTime the visitTime to set
     */
    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    /**
     * @return the validFlag
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag the validFlag to set
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

}