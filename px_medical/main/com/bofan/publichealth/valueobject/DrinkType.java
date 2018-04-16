package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.bofan.utils.SchemaConsts;

/**
 * DrinkType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DRINK_TYPE", schema = SchemaConsts.PUBLIC_HEALTH, uniqueConstraints = @UniqueConstraint(columnNames = "DRINK_TYPE"))
public class DrinkType implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 6387533618606354745L;
    // Fields

    @Id
    @Column(name = "DRINK_TYPE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long drinkTypeId;
    
    @Column(name = "DRINK_TYPE", unique = true, nullable = false, length = 20)
	private String drinkType;
    
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	// Constructors

	/** default constructor */
	public DrinkType() {
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
     * @return the drinkType
     */
    public String getDrinkType() {
        return drinkType;
    }

    /**
     * @param drinkType the drinkType to set
     */
    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
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

	// Property accessors
	

}