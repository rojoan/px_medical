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
 * LiveWayDietary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "LIVE_WAY_DIETARY", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "LIVE_WAY_DIETARY_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".LIVE_WAY_DIETARY_ID", allocationSize = 1)
public class LiveWayDietary implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 5558801164375516620L;
    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIVE_WAY_DIETARY_ID")
    @Column(name = "LIVE_WAY_DIETARY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long liveWayDietaryId;
    
    @Column(name = "EXAM_PERSON_ID", nullable = false, precision = 18, scale = 0)
    private Long examPersonId;
    
    @Column(name = "DIETARY_HABIT_ID", nullable = false, precision = 18, scale = 0)
    private Long dietaryHabitId;
    
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;

	// Constructors

	/** default constructor */
	public LiveWayDietary() {
	}

	// Property accessors
	
    /**
     * @return the liveWayDietaryId
     */
    public Long getLiveWayDietaryId() {
        return liveWayDietaryId;
    }

    /**
     * @param liveWayDietaryId the liveWayDietaryId to set
     */
    public void setLiveWayDietaryId(Long liveWayDietaryId) {
        this.liveWayDietaryId = liveWayDietaryId;
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
     * @return the dietaryHabitId
     */
    public Long getDietaryHabitId() {
        return dietaryHabitId;
    }

    /**
     * @param dietaryHabitId the dietaryHabitId to set
     */
    public void setDietaryHabitId(Long dietaryHabitId) {
        this.dietaryHabitId = dietaryHabitId;
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