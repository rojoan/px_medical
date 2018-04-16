package com.bofan.publichealth.vaccine.valueobject;

import java.io.Serializable;
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
 * The persistent class for the VACCINATION_CARD database table.
 * 
 */
@Entity
@Table(name="VACCINATION_CARD", schema = SchemaConsts.PUBLIC_HEALTH)
@NamedQuery(name="VaccinationCard.findAll", query="SELECT v FROM VaccinationCard v")
public class VaccinationCard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "VACCINATION_CARD_VACCINATIONCARDID_GENERATOR", sequenceName = SchemaConsts.PUBLIC_HEALTH
            + ".VACCINATION_CARD_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VACCINATION_CARD_VACCINATIONCARDID_GENERATOR")
	@Column(name="VACCINATION_CARD_ID", unique=true, nullable=false, precision=18)
	private Long vaccinationCardId;

	@Column(name="CHILD_DETAIL_ID", precision=18)
	private Long childDetailId;

	@Column(name="CONTAGION_HISTORY", length=200)
	private String contagionHistory;

	@Column(length=200)
	private String contraindication;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_TIME", nullable=false)
	private Date createTime;

	@Column(name="CREATOR_ID", nullable=false)
	private Long creatorId;

	@Column(name="CREATOR_NAME", nullable=false, length=20)
	private String creatorName;

	@Temporal(TemporalType.DATE)
	@Column(name="FILL_TIME", nullable=false)
	private Date fillTime;

	@Column(name="GUARDIANS_NAME", length=50)
	private String guardiansName;

	@Column(name="GUARDIANS_RELATION", length=20)
	private String guardiansRelation;

	@Column(name="HOSPITAL_ID", nullable=false, precision=18)
	private Long hospitalId;

	@Column(name="HOSPITAL_NAME", nullable=false, length=80)
	private String hospitalName;

	@Column(name="HOSPITAL_NO", nullable=false, length=40)
	private String hospitalNo;

	@Temporal(TemporalType.DATE)
	@Column(name="MOVE_IN_TIME")
	private Date moveInTime;

	@Temporal(TemporalType.DATE)
	@Column(name="MOVE_OUT_TIME")
	private Date moveOutTime;

	@Column(name="MOVE_REASON", length=100)
	private String moveReason;

	@Column(name="PERSON_DETAIL_ID", precision=18)
	private Long personDetailId;

	@Column(name="REGION_ID", nullable=false, length=18)
	private String regionId;

	@Column(name="VACCINATED_NAME", nullable=false, length=50)
	private String vaccinatedName;

	@Column(name="VACCINATED_PHONE", length=20)
	private String vaccinatedPhone;

	@Column(name="VACCINATION_CARD_NO", nullable=false, length=20)
	private String vaccinationCardNo;

	@Column(name="VACCINE_UN_REACTION", length=200)
	private String vaccineUnReaction;

	@Column(name="VALID_FLAG", nullable=false, length=1)
	private String validFlag;

    // bi-directional many-to-one association to VaccinationDetail
    // @OneToMany(mappedBy="vaccinationCard")
    // private List<VaccinationDetail> vaccinationDetails;

	public VaccinationCard() {
	}

	public Long getVaccinationCardId() {
		return this.vaccinationCardId;
	}

	public void setVaccinationCardId(Long vaccinationCardId) {
		this.vaccinationCardId = vaccinationCardId;
	}

	public Long getChildDetailId() {
		return this.childDetailId;
	}

	public void setChildDetailId(Long childDetailId) {
		this.childDetailId = childDetailId;
	}

	public String getContagionHistory() {
		return this.contagionHistory;
	}

	public void setContagionHistory(String contagionHistory) {
		this.contagionHistory = contagionHistory;
	}

	public String getContraindication() {
		return this.contraindication;
	}

	public void setContraindication(String contraindication) {
		this.contraindication = contraindication;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return this.creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Date getFillTime() {
		return this.fillTime;
	}

	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}

	public String getGuardiansName() {
		return this.guardiansName;
	}

	public void setGuardiansName(String guardiansName) {
		this.guardiansName = guardiansName;
	}

	public String getGuardiansRelation() {
		return this.guardiansRelation;
	}

	public void setGuardiansRelation(String guardiansRelation) {
		this.guardiansRelation = guardiansRelation;
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

	public Date getMoveInTime() {
		return this.moveInTime;
	}

	public void setMoveInTime(Date moveInTime) {
		this.moveInTime = moveInTime;
	}

	public Date getMoveOutTime() {
		return this.moveOutTime;
	}

	public void setMoveOutTime(Date moveOutTime) {
		this.moveOutTime = moveOutTime;
	}

	public String getMoveReason() {
		return this.moveReason;
	}

	public void setMoveReason(String moveReason) {
		this.moveReason = moveReason;
	}

	public Long getPersonDetailId() {
		return this.personDetailId;
	}

	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	public String getRegionId() {
		return this.regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getVaccinatedName() {
		return this.vaccinatedName;
	}

	public void setVaccinatedName(String vaccinatedName) {
		this.vaccinatedName = vaccinatedName;
	}

	public String getVaccinatedPhone() {
		return this.vaccinatedPhone;
	}

	public void setVaccinatedPhone(String vaccinatedPhone) {
		this.vaccinatedPhone = vaccinatedPhone;
	}

	public String getVaccinationCardNo() {
		return this.vaccinationCardNo;
	}

	public void setVaccinationCardNo(String vaccinationCardNo) {
		this.vaccinationCardNo = vaccinationCardNo;
	}

	public String getVaccineUnReaction() {
		return this.vaccineUnReaction;
	}

	public void setVaccineUnReaction(String vaccineUnReaction) {
		this.vaccineUnReaction = vaccineUnReaction;
	}

	public String getValidFlag() {
		return this.validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

    // public List<VaccinationDetail> getVaccinationDetails() {
    // return this.vaccinationDetails;
    // }
    //
    // public void setVaccinationDetails(List<VaccinationDetail> vaccinationDetails)
    // {
    // this.vaccinationDetails = vaccinationDetails;
    // }

    // public VaccinationDetail addVaccinationDetail(VaccinationDetail
    // vaccinationDetail) {
    // getVaccinationDetails().add(vaccinationDetail);
    // vaccinationDetail.setVaccinationCard(this);
    //
    // return vaccinationDetail;
    // }

    // public VaccinationDetail removeVaccinationDetail(VaccinationDetail
    // vaccinationDetail) {
    // getVaccinationDetails().remove(vaccinationDetail);
    // vaccinationDetail.setVaccinationCard(null);
    //
    // return vaccinationDetail;
    // }

}