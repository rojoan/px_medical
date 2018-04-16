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
 * The persistent class for the VACCINE database table.
 * 
 */
@Entity
@Table(name="VACCINE", schema = SchemaConsts.PUBLIC_HEALTH)
@NamedQuery(name="Vaccine.findAll", query="SELECT v FROM Vaccine v")
public class Vaccine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "VACCINE_VACCINEID_GENERATOR", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".VACCINE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VACCINE_VACCINEID_GENERATOR")
	@Column(name="VACCINE_ID", unique=true, nullable=false, precision=18)
	private Long vaccineId;

    @Column(name = "CONTRAINDICATION", nullable = true, length = 200)
	private String contraindication;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", nullable = false)
    private Date createTime;

    @Column(name = "CREATOR_ID", nullable = false, precision = 18)
    private Long creatorId;

	@Column(name="PLAN_FLAG", nullable=false, length=1)
	private String planFlag;

	@Column(name="PREVENT_DISEASE", nullable=false, length=200)
	private String preventDisease;

	@Column(name="PRODUCT_ENTP", length=100)
	private String productEntp;

	@Column(name="REINFORCE_FLAG", length=1)
	private String reinforceFlag;

	@Column(name="SIDE_EFFECT", length=200)
	private String sideEffect;

	@Column(name="SORT", precision=18)
	private Long sort;

	@Column(name="USE_FLAG", nullable=false, length=1)
	private String useFlag;

	@Column(name="VACCINE_CODE", length=50)
	private String vaccineCode;

	@Column(name="VACCINE_CONTENT", length=200)
	private String vaccineContent;

	@Column(name="VACCINE_DOSE", nullable=false, length=100)
	private String vaccineDose;

	@Column(name="VACCINE_DOSE_NUM", nullable=false, length=200)
	private String vaccineDoseNum;

	@Column(name="VACCINE_NAME", nullable=false, length=50)
	private String vaccineName;

	@Column(name="VACCINE_NO", nullable=false, length=20)
	private String vaccineNo;

	@Column(name="VACCINE_OBJECT", nullable=false, length=100)
	private String vaccineObject;

	@Column(name="VACCINE_PART", nullable=false, length=100)
	private String vaccinePart;

	@Column(name="VACCINE_PRICE", precision=18, scale=2)
	private BigDecimal vaccinePrice;

	@Column(name="VACCINE_PRODUCT_AREA", length=100)
	private String vaccineProductArea;

	@Column(name="VACCINE_REMARK", length=200)
	private String vaccineRemark;

	@Column(name="VACCINE_TIME", length=100)
	private String vaccineTime;

	@Column(name="VACCINE_UNIT", nullable=false, length=1)
	private String vaccineUnit;

	@Column(name="VACCINE_USE", nullable=false, length=200)
	private String vaccineUse;

    // bi-directional many-to-one association to VaccinationDetail
    // @OneToMany(mappedBy="vaccine")
    // private List<VaccinationDetail> vaccinationDetails;

	public Vaccine() {
	}

	public Long getVaccineId() {
		return this.vaccineId;
	}

	public void setVaccineId(Long vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getContraindication() {
		return this.contraindication;
	}

	public void setContraindication(String contraindication) {
		this.contraindication = contraindication;
	}

    /*
     * public Date getCreateTime() { return this.createTime; }
     * 
     * public void setCreateTime(Date createTime) { this.createTime = createTime; }
     */

    public Long getCreatorId() {
        return this.creatorId;
	}

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
	}

	public String getPlanFlag() {
		return this.planFlag;
	}

	public void setPlanFlag(String planFlag) {
		this.planFlag = planFlag;
	}

	public String getPreventDisease() {
		return this.preventDisease;
	}

	public void setPreventDisease(String preventDisease) {
		this.preventDisease = preventDisease;
	}

	public String getProductEntp() {
		return this.productEntp;
	}

	public void setProductEntp(String productEntp) {
		this.productEntp = productEntp;
	}

	public String getReinforceFlag() {
		return this.reinforceFlag;
	}

	public void setReinforceFlag(String reinforceFlag) {
		this.reinforceFlag = reinforceFlag;
	}

	public String getSideEffect() {
		return this.sideEffect;
	}

	public void setSideEffect(String sideEffect) {
		this.sideEffect = sideEffect;
	}

	public Long getSort() {
		return this.sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public String getUseFlag() {
		return this.useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}

	public String getVaccineCode() {
		return this.vaccineCode;
	}

	public void setVaccineCode(String vaccineCode) {
		this.vaccineCode = vaccineCode;
	}

	public String getVaccineContent() {
		return this.vaccineContent;
	}

	public void setVaccineContent(String vaccineContent) {
		this.vaccineContent = vaccineContent;
	}

	public String getVaccineDose() {
		return this.vaccineDose;
	}

	public void setVaccineDose(String vaccineDose) {
		this.vaccineDose = vaccineDose;
	}

	public String getVaccineDoseNum() {
		return this.vaccineDoseNum;
	}

	public void setVaccineDoseNum(String vaccineDoseNum) {
		this.vaccineDoseNum = vaccineDoseNum;
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

	public String getVaccineObject() {
		return this.vaccineObject;
	}

	public void setVaccineObject(String vaccineObject) {
		this.vaccineObject = vaccineObject;
	}

	public String getVaccinePart() {
		return this.vaccinePart;
	}

	public void setVaccinePart(String vaccinePart) {
		this.vaccinePart = vaccinePart;
	}

	public BigDecimal getVaccinePrice() {
		return this.vaccinePrice;
	}

	public void setVaccinePrice(BigDecimal vaccinePrice) {
		this.vaccinePrice = vaccinePrice;
	}

	public String getVaccineProductArea() {
		return this.vaccineProductArea;
	}

	public void setVaccineProductArea(String vaccineProductArea) {
		this.vaccineProductArea = vaccineProductArea;
	}

	public String getVaccineRemark() {
		return this.vaccineRemark;
	}

	public void setVaccineRemark(String vaccineRemark) {
		this.vaccineRemark = vaccineRemark;
	}

	public String getVaccineTime() {
		return this.vaccineTime;
	}

	public void setVaccineTime(String vaccineTime) {
		this.vaccineTime = vaccineTime;
	}

	public String getVaccineUnit() {
		return this.vaccineUnit;
	}

	public void setVaccineUnit(String vaccineUnit) {
		this.vaccineUnit = vaccineUnit;
	}

	public String getVaccineUse() {
		return this.vaccineUse;
	}

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setVaccineUse(String vaccineUse) {
		this.vaccineUse = vaccineUse;
	}

    // public List<VaccinationDetail> getVaccinationDetails() {
    // return this.vaccinationDetails;
    // }
    //
    // public void setVaccinationDetails(List<VaccinationDetail> vaccinationDetails)
    // {
    // this.vaccinationDetails = vaccinationDetails;
    // }
    //
    // public VaccinationDetail addVaccinationDetail(VaccinationDetail
    // vaccinationDetail) {
    // getVaccinationDetails().add(vaccinationDetail);
    // vaccinationDetail.setVaccine(this);
    //
    // return vaccinationDetail;
    // }
    //
    // public VaccinationDetail removeVaccinationDetail(VaccinationDetail
    // vaccinationDetail) {
    // getVaccinationDetails().remove(vaccinationDetail);
    // vaccinationDetail.setVaccine(null);
    //
    // return vaccinationDetail;
    // }

}