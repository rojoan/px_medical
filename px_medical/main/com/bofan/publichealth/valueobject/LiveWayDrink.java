package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * LiveWayDrink entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "LIVE_WAY_DRINK", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "LIVE_WAY_DRINK_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".LIVE_WAY_DRINK_ID", allocationSize = 1)
public class LiveWayDrink implements java.io.Serializable {

	// Fields

	/**
     * 
     */
    private static final long serialVersionUID = -7910955086448359336L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIVE_WAY_DRINK_ID")
    @Column(name = "LIVE_WAY_DRINK_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long liveWayDrinkId;

    @Column(name = "drink_type_id", nullable = false, precision = 18, scale = 0)
    private Long drinkTypeId;
    
    @Column(name = "exam_person_id", nullable = false, precision = 18, scale = 0)
    private Long examPersonId;
	
	@Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;

	// Constructors

	/** default constructor */
	public LiveWayDrink() {
	}
	
	// Property accessors
    /**
     * @return the liveWayDrinkId
     */
    public Long getLiveWayDrinkId() {
        return liveWayDrinkId;
    }

    /**
     * @param liveWayDrinkId the liveWayDrinkId to set
     */
    public void setLiveWayDrinkId(Long liveWayDrinkId) {
        this.liveWayDrinkId = liveWayDrinkId;
    }

    /**
     * @return the drinkTypeId
     */
    public Long getDrinkTypeId() {
        return drinkTypeId;
    }

    /**
     * @param drinkTypeId the drinkTypeId to set
     */
    public void setDrinkTypeId(Long drinkTypeId) {
        this.drinkTypeId = drinkTypeId;
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

	
}