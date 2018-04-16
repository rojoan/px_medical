package com.bofan.lis.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;
 

/**
 * @Description: lis_base_data（基础信息表_一般检验）
 * @author lqw
 */
@Entity
@Table(name = "LIS_BASE_DATA", schema = SchemaConsts.LIS_CLOUD)
@SequenceGenerator(name = "LIS_BASE_DATA_ID", sequenceName = SchemaConsts.LIS_CLOUD + ".LIS_BASE_DATA_ID", allocationSize=1)
public class LisBaseData {

	// Fields
	/** 基础数据--一般检验ID，自动增长ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIS_BASE_DATA_ID")
	@Column(name = "LIS_BASE_DATA_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long lisBaseDataId;
	
	/** 医院（医疗机构）标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/** 基础数据ID，原主键ID */
	@Column(name = "BASE_DATA_ID", nullable = false, length = 10)
	private String baseDataId;
	
	/** 基础数据类型 */
	@Column(name = "CLASS_ID", length = 20)
	private String classId;

	/** 排序号 */
	@Column(name = "BASE_DATA_SORT", length = 20)
	private String baseDataSort;
	
	/** 中文名称 */
	@Column(name = "CHINESE_NAME", length = 400)
	private String chineseName;

	/** 英文名称 */
	@Column(name = "ENGLISH_NAME", length = 50)
	private String englishName;
	
	/** lis代码 */
	@Column(name = "LIS_ID", length = 20)
	private String lisId;
	
	/** his代码 */
	@Column(name = "HIS_ID", length = 20)
	private String hisId;
	
	/** 标准代码 */
	@Column(name = "STANDART_ID", length = 20)
	private String standartId;
	
	/** 自定义码 */
	@Column(name = "CUSTOM_CODE", length = 20)
	private String customCode;
	
	/** 拼音码 */
	@Column(name = "SPELL_CODE", length = 20)
	private String spellCode;
	
	/** 五笔码 */
	@Column(name = "STROKE_CODE", length = 20)
	private String strokeCode;
	
	/** 使用状态 */
	@Column(name = "STATE_FLAG", length = 2)
	private String stateFlag;

	// Constructors

	/** default constructor */
	public LisBaseData() {
	}

	/**
	 * @return lisBaseDataId
	 */
	public Long getLisBaseDataId() {
		return lisBaseDataId;
	}

	/**
	 * @param lisBaseDataId 要设置的 lisBaseDataId
	 */
	public void setLisBaseDataId(Long lisBaseDataId) {
		this.lisBaseDataId = lisBaseDataId;
	}

	/**
	 * @return hospitalNo
	 */
	public String getHospitalNo() {
		return hospitalNo;
	}

	/**
	 * @param hospitalNo 要设置的 hospitalNo
	 */
	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	/**
	 * @return baseDataId
	 */
	public String getBaseDataId() {
		return baseDataId;
	}

	/**
	 * @param baseDataId 要设置的 baseDataId
	 */
	public void setBaseDataId(String baseDataId) {
		this.baseDataId = baseDataId;
	}

	/**
	 * @return classId
	 */
	public String getClassId() {
		return classId;
	}

	/**
	 * @param classId 要设置的 classId
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}

	/**
	 * @return baseDataSort
	 */
	public String getBaseDataSort() {
		return baseDataSort;
	}

	/**
	 * @param baseDataSort 要设置的 baseDataSort
	 */
	public void setBaseDataSort(String baseDataSort) {
		this.baseDataSort = baseDataSort;
	}

	/**
	 * @return chineseName
	 */
	public String getChineseName() {
		return chineseName;
	}

	/**
	 * @param chineseName 要设置的 chineseName
	 */
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	/**
	 * @return englishName
	 */
	public String getEnglishName() {
		return englishName;
	}

	/**
	 * @param englishName 要设置的 englishName
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	/**
	 * @return lisId
	 */
	public String getLisId() {
		return lisId;
	}

	/**
	 * @param lisId 要设置的 lisId
	 */
	public void setLisId(String lisId) {
		this.lisId = lisId;
	}

	/**
	 * @return hisId
	 */
	public String getHisId() {
		return hisId;
	}

	/**
	 * @param hisId 要设置的 hisId
	 */
	public void setHisId(String hisId) {
		this.hisId = hisId;
	}

	/**
	 * @return standartId
	 */
	public String getStandartId() {
		return standartId;
	}

	/**
	 * @param standartId 要设置的 standartId
	 */
	public void setStandartId(String standartId) {
		this.standartId = standartId;
	}

	/**
	 * @return customCode
	 */
	public String getCustomCode() {
		return customCode;
	}

	/**
	 * @param customCode 要设置的 customCode
	 */
	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}

	/**
	 * @return spellCode
	 */
	public String getSpellCode() {
		return spellCode;
	}

	/**
	 * @param spellCode 要设置的 spellCode
	 */
	public void setSpellCode(String spellCode) {
		this.spellCode = spellCode;
	}

	/**
	 * @return strokeCode
	 */
	public String getStrokeCode() {
		return strokeCode;
	}

	/**
	 * @param strokeCode 要设置的 strokeCode
	 */
	public void setStrokeCode(String strokeCode) {
		this.strokeCode = strokeCode;
	}

	/**
	 * @return stateFlag
	 */
	public String getStateFlag() {
		return stateFlag;
	}

	/**
	 * @param stateFlag 要设置的 stateFlag
	 */
	public void setStateFlag(String stateFlag) {
		this.stateFlag = stateFlag;
	}

}