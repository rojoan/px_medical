package com.bofan.emergencyevent.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @desc cheif_symptom（主要症状）
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CHEIF_SYMPTOM", schema = SchemaConsts.EMERGENCY_EVENT_SCHEMA)
@SequenceGenerator(name = "CHEIF_SYMPTOM_ID", sequenceName = SchemaConsts.EMERGENCY_EVENT_SCHEMA + ".CHEIF_SYMPTOM_ID", allocationSize = 1)
public class CheifSymptom {

	/** 主要症状ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHEIF_SYMPTOM_ID")
	@Column(name = "CHEIF_SYMPTOM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long cheifSymptomId;
	
	/** 主要症状 呼吸道症状、胃肠道症状、神经系统症状、皮肤粘膜症状、精神症状、其他 */
	@Column(name = "CHEIF_SYMPTOM", unique = true, nullable = false, length = 40)
	private String cheifSymptom;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/**
	 * @return cheifSymptomId
	 */
	public Long getCheifSymptomId() {
		return cheifSymptomId;
	}

	/**
	 * @param cheifSymptomId 要设置的 cheifSymptomId
	 */
	public void setCheifSymptomId(Long cheifSymptomId) {
		this.cheifSymptomId = cheifSymptomId;
	}

	/**
	 * @return cheifSymptom
	 */
	public String getCheifSymptom() {
		return cheifSymptom;
	}

	/**
	 * @param cheifSymptom 要设置的 cheifSymptom
	 */
	public void setCheifSymptom(String cheifSymptom) {
		this.cheifSymptom = cheifSymptom;
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