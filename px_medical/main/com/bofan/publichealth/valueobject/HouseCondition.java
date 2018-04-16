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
 * @Description:  house_condition（家庭居住条件和卫生设施）
 * @author lqw
 */
@Entity
@Table(name = "HOUSE_CONDITION", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "HOUSE_CONDITION_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".HOUSE_CONDITION_ID", allocationSize = 1)
public class HouseCondition {
	
	/**家庭居住条件ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOUSE_CONDITION_ID")
	@Column(name = "HOUSE_CONDITION_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long houseConditionId;
	
	/** 住房类型 1、电梯 2、非电梯  3、平房  4、其他 */
	@Column(name = "HOUSE_TYPE", length = 1)
	private String houseType;
	
	/** 住房面积 */
	@Column(name = "HOUSE_AREA", length = 10)
	private String houseArea;
	
	/** 保暖情况 1、保暖 2、寒冷*/
	@Column(name = "WARM_CONDITION", length = 1)
	private String warmCondition;
	
	/** 厨房使用方式 1、独用 2、合用  3、无*/
	@Column(name = "KITCHEN_USE", length = 1)
	private String kitchenUse;
	
	/**厨房排风设施 1、油烟机 2、换气扇 3、烟囱 4、其他 */
	@Column(name = "KITCHEN_AIR", length = 1)
	private String kitchenAir;
	
	/** 厨房饮水 1、纯水或桶装水 2、经净化过滤的水 3、自来水 4、塘水 5、河湖水 6、井水 7、其他 */
	@Column(name = "KITCHEN_WATER", length = 1)
	private String kitchenWater;
	
	/** 厨房燃料类型  1、天然气 2、液化气  3、沼气 4、煤 5、柴火 6、其他*/
	@Column(name = "KITCHEN_FUEL", length = 1)
	private String kitchenFuel;
	
	/** 厨房湿度情况 1、正常 2、干燥 3、潮湿 */
	@Column(name = "KITCHEN_HUMIDITY", length = 1)
	private String kitchenHumidity;
	
	/** 厨房采光情况 1、阳光充足 2、昏暗 */
	@Column(name = "KITCHEN_RAY", length = 1)
	private String kitchenRay;
	
	/** 厨房卫生情况 1、整洁 2、一般 3、较差 */
	@Column(name = "KITCHEN_CLEAN", length = 1)
	private String kitchenClean;
	
	/** 卫生厕所 1、完整下水道式 2、双瓮漏斗式 3、粪尿分集式 4、水冲式 5、双坑交替式 6、三联沼气池式 7、三格化粪池式  8、其他 */
	@Column(name = "TOILET_CLEAN", length = 1)
	private String toiletClean;
	
	/** 禽畜栏 1、无  2、单设  3、室内  4、室外 */
	@Column(name = "LIVESTOCK_BAR", length = 1)
	private String livestockBar;

	/** default constructor */
	public HouseCondition() {
	}
	        
	/**
	 * @return houseConditionId
	 */
	public Long getHouseConditionId() {
		return houseConditionId;
	}

	/**
	 * @param houseConditionId 要设置的 houseConditionId
	 */
	public void setHouseConditionId(Long houseConditionId) {
		this.houseConditionId = houseConditionId;
	}

	/**
	 * @return houseType
	 */
	public String getHouseType() {
		return houseType;
	}

	/**
	 * @param houseType 要设置的 houseType
	 */
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	/**
	 * @return houseArea
	 */
	public String getHouseArea() {
		return houseArea;
	}

	/**
	 * @param houseArea 要设置的 houseArea
	 */
	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	/**
	 * @return warmCondition
	 */
	public String getWarmCondition() {
		return warmCondition;
	}

	/**
	 * @param warmCondition 要设置的 warmCondition
	 */
	public void setWarmCondition(String warmCondition) {
		this.warmCondition = warmCondition;
	}

	/**
	 * @return kitchenUse
	 */
	public String getKitchenUse() {
		return kitchenUse;
	}

	/**
	 * @param kitchenUse 要设置的 kitchenUse
	 */
	public void setKitchenUse(String kitchenUse) {
		this.kitchenUse = kitchenUse;
	}

	/**
	 * @return kitchenAir
	 */
	public String getKitchenAir() {
		return kitchenAir;
	}

	/**
	 * @param kitchenAir 要设置的 kitchenAir
	 */
	public void setKitchenAir(String kitchenAir) {
		this.kitchenAir = kitchenAir;
	}

	/**
	 * @return kitchenWater
	 */
	public String getKitchenWater() {
		return kitchenWater;
	}

	/**
	 * @param kitchenWater 要设置的 kitchenWater
	 */
	public void setKitchenWater(String kitchenWater) {
		this.kitchenWater = kitchenWater;
	}

	/**
	 * @return kitchenFuel
	 */
	public String getKitchenFuel() {
		return kitchenFuel;
	}

	/**
	 * @param kitchenFuel 要设置的 kitchenFuel
	 */
	public void setKitchenFuel(String kitchenFuel) {
		this.kitchenFuel = kitchenFuel;
	}

	/**
	 * @return kitchenHumidity
	 */
	public String getKitchenHumidity() {
		return kitchenHumidity;
	}

	/**
	 * @param kitchenHumidity 要设置的 kitchenHumidity
	 */
	public void setKitchenHumidity(String kitchenHumidity) {
		this.kitchenHumidity = kitchenHumidity;
	}

	/**
	 * @return kitchenRay
	 */
	public String getKitchenRay() {
		return kitchenRay;
	}

	/**
	 * @param kitchenRay 要设置的 kitchenRay
	 */
	public void setKitchenRay(String kitchenRay) {
		this.kitchenRay = kitchenRay;
	}

	/**
	 * @return kitchenClean
	 */
	public String getKitchenClean() {
		return kitchenClean;
	}

	/**
	 * @param kitchenClean 要设置的 kitchenClean
	 */
	public void setKitchenClean(String kitchenClean) {
		this.kitchenClean = kitchenClean;
	}

	/**
	 * @return toiletClean
	 */
	public String getToiletClean() {
		return toiletClean;
	}

	/**
	 * @param toiletClean 要设置的 toiletClean
	 */
	public void setToiletClean(String toiletClean) {
		this.toiletClean = toiletClean;
	}

	/**
	 * @return livestockBar
	 */
	public String getLivestockBar() {
		return livestockBar;
	}

	/**
	 * @param livestockBar 要设置的 livestockBar
	 */
	public void setLivestockBar(String livestockBar) {
		this.livestockBar = livestockBar;
	}

}