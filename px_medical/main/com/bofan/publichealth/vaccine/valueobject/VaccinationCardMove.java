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
 * The persistent class for the VACCINATION_CARD_MOVE database table.
 * 
 */
@Entity
@Table(name="VACCINATION_CARD_MOVE", schema = SchemaConsts.PUBLIC_HEALTH)
@NamedQuery(name="VaccinationCardMove.findAll", query="SELECT v FROM VaccinationCardMove v")
public class VaccinationCardMove implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "VACCINATION_CARD_MOVE_CARDMOVEID_GENERATOR", sequenceName = SchemaConsts.PUBLIC_HEALTH
            + ".VACCINATION_CARD_MOVE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VACCINATION_CARD_MOVE_CARDMOVEID_GENERATOR")
	@Column(name="CARD_MOVE_ID", unique=true, nullable=false, precision=18)
	private Long cardMoveId;

	@Column(name="CHILD_DETAIL_ID", precision=18)
	private Long childDetailId;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_TIME", nullable=false)
	private Date createTime;

	@Column(name="CREATOR_ID", nullable=false, precision=18)
	private Long creatorId;

	@Column(name="HANDLE_DOCTOR", length=20)
	private String handleDoctor;

	@Column(name="HANDLE_DOCTOR_ID", precision=18)
	private Long handleDoctorId;

	@Column(name="HANDLE_RESULT", length=1)
	private String handleResult;

	@Temporal(TemporalType.DATE)
	@Column(name="HANDLE_TIME")
	private Date handleTime;

	@Column(name="IN_HOSPITAL_ID", nullable=false, precision=18)
	private Long inHospitalId;

	@Column(name="IN_HOSPITAL_NAME", nullable=false, length=100)
	private String inHospitalName;

	@Column(name="MOVE_REASON", length=200)
	private String moveReason;

	@Temporal(TemporalType.DATE)
	@Column(name="MOVE_TIME", nullable=false)
	private Date moveTime;

	@Column(name="OUT_HOSPITAL_ID", nullable=false, precision=18)
	private Long outHospitalId;

	@Column(name="OUT_HOSPITAL_NAME", nullable=false, length=100)
	private String outHospitalName;

	@Column(name="PERSON_DETAIL_ID", precision=18)
	private BigDecimal personDetailId;

	@Column(name="PROPOSER_ID", precision=18)
	private Long proposerId;

	@Column(name="PROPOSER_NAME", length=30)
	private String proposerName;

	@Column(name="REFUSE_REASON", length=200)
	private String refuseReason;

	@Column(name="REGION_ID", nullable=false, length=18)
	private String regionId;

	@Column(name="VACCINATED_NAME", nullable=false, length=50)
	private String vaccinatedName;

	@Column(name="VACCINATION_CARD_NO", nullable=false, length=20)
	private String vaccinationCardNo;

	public VaccinationCardMove() {
	}

	public Long getCardMoveId() {
		return this.cardMoveId;
	}

	public void setCardMoveId(Long cardMoveId) {
		this.cardMoveId = cardMoveId;
	}

	public Long getChildDetailId() {
		return this.childDetailId;
	}

	public void setChildDetailId(Long childDetailId) {
		this.childDetailId = childDetailId;
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

	public String getHandleDoctor() {
		return this.handleDoctor;
	}

	public void setHandleDoctor(String handleDoctor) {
		this.handleDoctor = handleDoctor;
	}

	public Long getHandleDoctorId() {
		return this.handleDoctorId;
	}

	public void setHandleDoctorId(Long handleDoctorId) {
		this.handleDoctorId = handleDoctorId;
	}

	public String getHandleResult() {
		return this.handleResult;
	}

	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}

	public Date getHandleTime() {
		return this.handleTime;
	}

	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}

	public Long getInHospitalId() {
		return this.inHospitalId;
	}

	public void setInHospitalId(Long inHospitalId) {
		this.inHospitalId = inHospitalId;
	}

	public String getInHospitalName() {
		return this.inHospitalName;
	}

	public void setInHospitalName(String inHospitalName) {
		this.inHospitalName = inHospitalName;
	}

	public String getMoveReason() {
		return this.moveReason;
	}

	public void setMoveReason(String moveReason) {
		this.moveReason = moveReason;
	}

	public Date getMoveTime() {
		return this.moveTime;
	}

	public void setMoveTime(Date moveTime) {
		this.moveTime = moveTime;
	}

	public Long getOutHospitalId() {
		return this.outHospitalId;
	}

	public void setOutHospitalId(Long outHospitalId) {
		this.outHospitalId = outHospitalId;
	}

	public String getOutHospitalName() {
		return this.outHospitalName;
	}

	public void setOutHospitalName(String outHospitalName) {
		this.outHospitalName = outHospitalName;
	}

	public BigDecimal getPersonDetailId() {
		return this.personDetailId;
	}

	public void setPersonDetailId(BigDecimal personDetailId) {
		this.personDetailId = personDetailId;
	}

	public Long getProposerId() {
		return this.proposerId;
	}

	public void setProposerId(Long proposerId) {
		this.proposerId = proposerId;
	}

	public String getProposerName() {
		return this.proposerName;
	}

	public void setProposerName(String proposerName) {
		this.proposerName = proposerName;
	}

	public String getRefuseReason() {
		return this.refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
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

	public String getVaccinationCardNo() {
		return this.vaccinationCardNo;
	}

	public void setVaccinationCardNo(String vaccinationCardNo) {
		this.vaccinationCardNo = vaccinationCardNo;
	}

}