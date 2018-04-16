package com.bofan.publichealth.vaccine.valueobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bofan.utils.SchemaConsts;


/**
 * The persistent class for the VACCINATION_DETAIL database table.
 * 
 */
@Entity
@Table(name="VACCINATION_DETAIL", schema = SchemaConsts.PUBLIC_HEALTH)
@NamedQuery(name="VaccinationDetail.findAll", query="SELECT v FROM VaccinationDetail v")
public class VaccinationDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "VACCINATION_DETAIL_VACCINATIONDETAILID_GENERATOR", sequenceName = SchemaConsts.PUBLIC_HEALTH
            + ".VACCINATION_DETAIL_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VACCINATION_DETAIL_VACCINATIONDETAILID_GENERATOR")
	@Column(name="VACCINATION_DETAIL_ID", unique=true, nullable=false, precision=18)
	private Long vaccinationDetailId;

	@Column(name="CHILD_DETAIL_ID", precision=18)
	private Long childDetailId;

	@Temporal(TemporalType.DATE)
	@Column(name="EFFECTIVE_DATE", nullable=false)
	private Date effectiveDate;

	@Column(name="HOSPITAL_ID", nullable=false, precision=18)
	private Long hospitalId;

	@Column(name="HOSPITAL_NAME", nullable=false, length=80)
	private String hospitalName;

	@Column(name="HOSPITAL_NO", nullable=false, length=40)
	private String hospitalNo;

	@Column(name="PERSON_DETAIL_ID", precision=18)
	private Long personDetailId;

	@Column(name="PRODUCTION_ENTP", nullable=false, length=100)
	private String productionEntp;

	@Column(name="PRODUCTION_ENTP_NO", precision=18)
	private BigDecimal productionEntpNo;

	@Column(length=100)
	private String remark;

	@Column(name="VACCINATED_NAME", nullable=false, length=50)
	private String vaccinatedName;

	@Column(name="VACCINATION_CARD_NO", nullable=false, length=20)
	private String vaccinationCardNo;

	@Temporal(TemporalType.DATE)
	@Column(name="VACCINATION_DATE", nullable=false)
	private Date vaccinationDate;

	@Column(name="VACCINATION_DOCTOR", length=20)
	private String vaccinationDoctor;

	@Column(name="VACCINATION_DOCTOR_ID", precision=18)
	private Long vaccinationDoctorId;

	@Column(name="VACCINE_BATCH", length=100)
	private String vaccineBatch;

	@Column(name="VACCINE_NAME", nullable=false, length=50)
	private String vaccineName;

	@Column(name="VACCINE_NO", length=20)
	private String vaccineNo;

	@Column(name="VACCINE_SITE", nullable=false, length=100)
	private String vaccineSite;

    @Column(name = "VACCINATION_CARD_ID", precision = 18, nullable = false)
    private Long vaccinationCardId;

    @Column(name = "VACCINE_ID", precision = 18, nullable = false)
    private Long vaccineId;

	public VaccinationDetail() {
	}

	public Long getVaccinationDetailId() {
		return this.vaccinationDetailId;
	}

	public void setVaccinationDetailId(Long vaccinationDetailId) {
		this.vaccinationDetailId = vaccinationDetailId;
	}

	public Long getChildDetailId() {
		return this.childDetailId;
	}

	public void setChildDetailId(Long childDetailId) {
		this.childDetailId = childDetailId;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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

	public Long getPersonDetailId() {
		return this.personDetailId;
	}

	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	public String getProductionEntp() {
		return this.productionEntp;
	}

	public void setProductionEntp(String productionEntp) {
		this.productionEntp = productionEntp;
	}

	public BigDecimal getProductionEntpNo() {
		return this.productionEntpNo;
	}

	public void setProductionEntpNo(BigDecimal productionEntpNo) {
		this.productionEntpNo = productionEntpNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVaccinatedName() {
		return this.vaccinatedName;
	}

	public void setVaccinatedName(String vaccinatedName) {
		this.vaccinatedName = vaccinatedName;
	}

	public String getVaccinationCardNo() {
		return this.vaccinationCardNo;
	}

	public void setVaccinationCardNo(String vaccinationCardNo) {
		this.vaccinationCardNo = vaccinationCardNo;
	}

	public Date getVaccinationDate() {
		return this.vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public String getVaccinationDoctor() {
		return this.vaccinationDoctor;
	}

	public void setVaccinationDoctor(String vaccinationDoctor) {
		this.vaccinationDoctor = vaccinationDoctor;
	}

	public Long getVaccinationDoctorId() {
		return this.vaccinationDoctorId;
	}

	public void setVaccinationDoctorId(Long vaccinationDoctorId) {
		this.vaccinationDoctorId = vaccinationDoctorId;
	}

	public String getVaccineBatch() {
		return this.vaccineBatch;
	}

	public void setVaccineBatch(String vaccineBatch) {
		this.vaccineBatch = vaccineBatch;
	}

	public String getVaccineName() {
		return this.vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getVaccineNo() {
		return this.vaccineNo;
	}

	public void setVaccineNo(String vaccineNo) {
		this.vaccineNo = vaccineNo;
	}

	public String getVaccineSite() {
		return this.vaccineSite;
	}

	public void setVaccineSite(String vaccineSite) {
		this.vaccineSite = vaccineSite;
	}

    public Long getVaccinationCardId() {
        return vaccinationCardId;
    }

    public void setVaccinationCardId(Long vaccinationCardId) {
        this.vaccinationCardId = vaccinationCardId;
    }

    public Long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Long vaccineId) {
        this.vaccineId = vaccineId;
    }

}