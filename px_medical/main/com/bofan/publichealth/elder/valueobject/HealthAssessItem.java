package com.bofan.publichealth.elder.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 健康评估项目字典表--老年人
 * @author lqw
 */
@Entity
@Table(name = "HEALTH_ASSESS_ITEM", schema = SchemaConsts.PUBLIC_HEALTH)
public class HealthAssessItem {

	/** 健康评估项目ID，主键ID */
	@Id
	@Column(name = "HEALTH_ASSESS_ITEM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long healthAssessItemId;
 
	/** 项目评估类型ID，主键ID 目前只分两级，每三个字符为一级 001  躯干 002  肌肉皮肤 */
	@Column(name = "HEALTH_ASSESS_TYPE_ID", nullable = false, length = 18)
	private String healthAssessTypeId;
	
	/** 项目名称 */
	@Column(name = "HEALTH_ASSESS_ITEM", nullable = false, length = 40)
	private String healthAssessItem;
	
	/** 项目排序 */
	@Column(name = "ITEM_SORT", nullable = false, precision = 18, scale = 0)
	private Long itemSort;
	
	/** 是否属于健康评估 1=是 0=否 */
	@Column(name = "HEALTH_FLAG", nullable = false, length = 1)
	private String healthFlag;
	
	/** 是否有效 1=有效 0=无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;
	 
	/** default constructor */
	public HealthAssessItem() {
	}

	/**
	 * @return healthAssessItemId
	 */
	public Long getHealthAssessItemId() {
		return healthAssessItemId;
	}

	/**
	 * @param healthAssessItemId 要设置的 healthAssessItemId
	 */
	public void setHealthAssessItemId(Long healthAssessItemId) {
		this.healthAssessItemId = healthAssessItemId;
	}

	/**
	 * @return healthAssessTypeId
	 */
	public String getHealthAssessTypeId() {
		return healthAssessTypeId;
	}

	/**
	 * @param healthAssessTypeId 要设置的 healthAssessTypeId
	 */
	public void setHealthAssessTypeId(String healthAssessTypeId) {
		this.healthAssessTypeId = healthAssessTypeId;
	}

	/**
	 * @return healthAssessItem
	 */
	public String getHealthAssessItem() {
		return healthAssessItem;
	}

	/**
	 * @param healthAssessItem 要设置的 healthAssessItem
	 */
	public void setHealthAssessItem(String healthAssessItem) {
		this.healthAssessItem = healthAssessItem;
	}

	/**
	 * @return itemSort
	 */
	public Long getItemSort() {
		return itemSort;
	}

	/**
	 * @param itemSort 要设置的 itemSort
	 */
	public void setItemSort(Long itemSort) {
		this.itemSort = itemSort;
	}

	/**
	 * @return healthFlag
	 */
	public String getHealthFlag() {
		return healthFlag;
	}

	/**
	 * @param healthFlag 要设置的 healthFlag
	 */
	public void setHealthFlag(String healthFlag) {
		this.healthFlag = healthFlag;
	}

	/**
	 * @return validFlag
	 */
	public String getValidFlag() {
		return validFlag;
	}

	/**
	 * @param validFlag 要设置的 validFlag
	 */
	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}
}