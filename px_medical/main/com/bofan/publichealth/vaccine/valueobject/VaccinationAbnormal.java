package com.bofan.publichealth.vaccine.valueobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bofan.utils.SchemaConsts;


/**
 * The persistent class for the VACCINATION_ABNORMAL database table.
 * 
 */
@Entity
@Table(name="VACCINATION_ABNORMAL", schema = SchemaConsts.PUBLIC_HEALTH)
@NamedQuery(name="VaccinationAbnormal.findAll", query="SELECT v FROM VaccinationAbnormal v")
public class VaccinationAbnormal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VACCINATION_DETAIL_ID", unique=true, nullable=false, precision=18)
	private Long vaccinationDetailId;

	@Temporal(TemporalType.DATE)
	@Column(name="ABNORMAL_TIME")
	private Date abnormalTime;

	@Column(name="CHILD_DETAIL_ID", precision=18)
	private Long childDetailId;

	@Column(name="CLINIC_DIAGNOSE", length=4000)
	private String clinicDiagnose;

	@Column(name="CLINIC_HOSPITAL", length=100)
	private String clinicHospital;

	@Temporal(TemporalType.DATE)
	@Column(name="CLINIC_TIME")
	private Date clinicTime;

	@Column(name="HOSPITAL_ID", nullable=false, precision=18)
	private Long hospitalId;

	@Column(name="HOSPITAL_NAME", length=80)
	private String hospitalName;

	@Column(name="HOSPITAL_NO", nullable=false, length=40)
	private String hospitalNo;

	@Column(name="IN_HOSPITAL_FLAG", length=1)
	private String inHospitalFlag;

	@Column(name="PERSON_DETAIL_ID", precision=18)
	private Long personDetailId;

	@Column(length=100)
	private String remark;

	@Column(name="REPORT_DOCTOR", length=20)
	private String reportDoctor;

	@Column(name="REPORT_DOCTOR_ID", precision=18)
	private Long reportDoctorId;

	@Temporal(TemporalType.DATE)
	@Column(name="REPORT_TIME")
	private Date reportTime;

	@Column(name="VACCINATED_NAME", length=50)
	private String vaccinatedName;

	@Column(name="VACCINATION_CARD_ID", precision=18)
	private Long vaccinationCardId;

	@Column(name="VACCINATION_CARD_NO", nullable=false, length=20)
	private String vaccinationCardNo;

	@Column(name="VACCINE_BATCH", length=100)
	private String vaccineBatch;

	@Temporal(TemporalType.DATE)
	@Column(name="VACCINE_DATE")
	private Date vaccineDate;

	@Column(name="VACCINE_ID", precision=18)
	private Long vaccineId;

	@Column(name="VACCINE_NAME", length=50)
	private String vaccineName;

	@Column(name="VACCINE_SITE", length=100)
	private String vaccineSite;

	public VaccinationAbnormal() {
	}

	public Long getVaccinationDetailId() {
		return this.vaccinationDetailId;
	}

	public void setVaccinationDetailId(Long vaccinationDetailId) {
		this.vaccinationDetailId = vaccinationDetailId;
	}

	public Date getAbnormalTime() {
		return this.abnormalTime;
	}

	public void setAbnormalTime(Date abnormalTime) {
		this.abnormalTime = abnormalTime;
	}

	public Long getChildDetailId() {
		return this.childDetailId;
	}

	public void setChildDetailId(Long childDetailId) {
		this.childDetailId = childDetailId;
	}

	public String getClinicDiagnose() {
		return this.clinicDiagnose;
	}

	public void setClinicDiagnose(String clinicDiagnose) {
		this.clinicDiagnose = clinicDiagnose;
	}

	public String getClinicHospital() {
		return this.clinicHospital;
	}

	public void setClinicHospital(String clinicHospital) {
		this.clinicHospital = clinicHospital;
	}

	public Date getClinicTime() {
		return this.clinicTime;
	}

	public void setClinicTime(Date clinicTime) {
		this.clinicTime = clinicTime;
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

	public String getInHospitalFlag() {
		return this.inHospitalFlag;
	}

	public void setInHospitalFlag(String inHospitalFlag) {
		this.inHospitalFlag = inHospitalFlag;
	}

	public Long getPersonDetailId() {
		return this.personDetailId;
	}

	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReportDoctor() {
		return this.reportDoctor;
	}

	public void setReportDoctor(String reportDoctor) {
		this.reportDoctor = reportDoctor;
	}

	public Long getReportDoctorId() {
		return this.reportDoctorId;
	}

	public void setReportDoctorId(Long reportDoctorId) {
		this.reportDoctorId = reportDoctorId;
	}

	public Date getReportTime() {
		return this.reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getVaccinatedName() {
		return this.vaccinatedName;
	}

	public void setVaccinatedName(String vaccinatedName) {
		this.vaccinatedName = vaccinatedName;
	}

	public Long getVaccinationCardId() {
		return this.vaccinationCardId;
	}

	public void setVaccinationCardId(Long vaccinationCardId) {
		this.vaccinationCardId = vaccinationCardId;
	}

	public String getVaccinationCardNo() {
		return this.vaccinationCardNo;
	}

	public void setVaccinationCardNo(String vaccinationCardNo) {
		this.vaccinationCardNo = vaccinationCardNo;
	}

	public String getVaccineBatch() {
		return this.vaccineBatch;
	}

	public void setVaccineBatch(String vaccineBatch) {
		this.vaccineBatch = vaccineBatch;
	}

	public Date getVaccineDate() {
		return this.vaccineDate;
	}

	public void setVaccineDate(Date vaccineDate) {
		this.vaccineDate = vaccineDate;
	}

	public Long getVaccineId() {
		return this.vaccineId;
	}

	public void setVaccineId(Long vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getVaccineName() {
		return this.vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getVaccineSite() {
		return this.vaccineSite;
	}

	public void setVaccineSite(String vaccineSite) {
		this.vaccineSite = vaccineSite;
	}

}