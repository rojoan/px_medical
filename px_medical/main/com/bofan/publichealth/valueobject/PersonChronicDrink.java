package com.bofan.publichealth.valueobject;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * 慢性病患者--饮酒种类对照实体
 * 
 */
@Entity
@Table(name="PERSON_CHRONIC_DRINK", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "CHRONIC_DRINK_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_CHRONIC_DRINK_ID", allocationSize = 1)
public class PersonChronicDrink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHRONIC_DRINK_ID")
    @Column(name="CHRONIC_DRINK_ID")
    private Long chronicDrinkId;
	
	@Column(name="PERSON_CHRONIC_ID")
	private Long personChronicId;

	@Column(name="ALCOHOL_UNIT")
	private String alcoholUnit;

	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="CREATOR_ID")
	private Long creatorId;

	@Column(name="DRINK_ALCOHOL_CAPACITY")
	private BigDecimal drinkAlcoholCapacity;

	@Column(name="DRINK_TYPE_ID")
	private Long drinkTypeId;

	@Column(name="HOSPITAL_ID")
	private Long hospitalId;

	@Column(name="PERSON_DETAIL_ID")
	private Long personDetailId;

	@Column(name="VALID_FLAG")
	private String validFlag;

	public PersonChronicDrink() {
	}

	/**
     * @return the chronicDrinkId
     */
    public Long getChronicDrinkId() {
        return chronicDrinkId;
    }

    /**
     * @param chronicDrinkId the chronicDrinkId to set
     */
    public void setChronicDrinkId(Long chronicDrinkId) {
        this.chronicDrinkId = chronicDrinkId;
    }

    public Long getPersonChronicId() {
		return this.personChronicId;
	}

	public void setPersonChronicId(Long personChronicId) {
		this.personChronicId = personChronicId;
	}

	public String getAlcoholUnit() {
		return this.alcoholUnit;
	}

	public void setAlcoholUnit(String alcoholUnit) {
		this.alcoholUnit = alcoholUnit;
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

	public BigDecimal getDrinkAlcoholCapacity() {
		return this.drinkAlcoholCapacity;
	}

	public void setDrinkAlcoholCapacity(BigDecimal drinkAlcoholCapacity) {
		this.drinkAlcoholCapacity = drinkAlcoholCapacity;
	}

	public Long getDrinkTypeId() {
		return this.drinkTypeId;
	}

	public void setDrinkTypeId(Long drinkTypeId) {
		this.drinkTypeId = drinkTypeId;
	}

	public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Long getPersonDetailId() {
		return this.personDetailId;
	}

	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	public String getValidFlag() {
		return this.validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

}