package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * DietaryHabit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DIETARY_HABIT", schema = SchemaConsts.PUBLIC_HEALTH)
public class DietaryHabit implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -2684881570213565377L;
    // Fields

    @Id
    @Column(name = "DIETARY_HABIT_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long dietaryHabitId;
    
    @Column(name = "DIETARY_HABIT", unique = true, nullable = false, length = 20)
	private String dietaryHabit;
    
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	// Constructors

	/** default constructor */
	public DietaryHabit() {
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
     * @return the dietaryHabit
     */
    public String getDietaryHabit() {
        return dietaryHabit;
    }

    /**
     * @param dietaryHabit the dietaryHabit to set
     */
    public void setDietaryHabit(String dietaryHabit) {
        this.dietaryHabit = dietaryHabit;
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