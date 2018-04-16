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
 * @Description: lis_micro_data（基础数据表_微生物）
 * @author lqw
 */
@Entity
@Table(name = "LIS_MICRO_DATA", schema = SchemaConsts.LIS_CLOUD)
@SequenceGenerator(name = "LIS_MICRO_DATA_ID", sequenceName = SchemaConsts.LIS_CLOUD + ".LIS_MICRO_DATA_ID", allocationSize=1)
public class LisMicroData {

	// Fields
	/** 基础数据--微生物ID，自动增长ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIS_MICRO_DATA_ID")
	@Column(name = "LIS_MICRO_DATA_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long lisMicroDataId;
	
	/** 医院（医疗机构）标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/** 基础数据ID，原主键ID */
	@Column(name = "MICRO_DATA_ID", nullable = false, length = 20)
	private String microDataId;
	
	/** 数据类型 */
	@Column(name = "MICRO_DATA_CLASS", length = 20)
	private String microDataClass;
	
	/** 排序号 */
	@Column(name = "MICRO_DATA_SORT", length = 20)
	private String microDataSort;
	
	/** 类型代码 */
	@Column(name = "CLASSIFY_ID", nullable = false, length = 20)
	private String classifyId;
	
	/** coding */
	@Column(name = "CODING", nullable = false, length = 30)
	private String coding;
	
	/** 英文名称  */
	@Column(name = "ENGLISH_NAME", length = 100)
	private String englishName;
	
	/** 英文简称 */
	@Column(name = "ENGLISH_NAME_SHORT", length = 20)
	private String englishNameShort;
	
	/** 中文名称 */
	@Column(name = "CHINESE_NAME", length = 100)
	private String chineseName;
	
	/** 中文简称 */
	@Column(name = "CHINESE_NAME_SHORT", length = 20)
	private String chineseNameShort;
	
	/** 标准代码 */
	@Column(name = "STANDART_ID", length = 20)
	private String standartId;
	
	/** 标准名称 */
	@Column(name = "STANDARD_NAME", length = 100)
	private String standardName;
	
	/** 自定义码 */
	@Column(name = "CUSTOM_CODE", length = 20)
	private String customCode;
	
	/** 拼音代码 */
	@Column(name = "SPELL_CODE", length = 20)
	private String spellCode;
	
	/** 五笔代码 */
	@Column(name = "STROKE_CODE", length = 20)
	private String strokeCode;
	
	/** 类型 */
	@Column(name = "CLASSIFY", length = 10)
	private String classify;
	
	/** 组合代码 */
	@Column(name = "MICRO_COMBINE_ID", length = 20)
	private String microCombineId;
	
	/** 试验方法 */
	@Column(name = "MICRO_METHOD", length = 200)
	private String microMethod;
	
	/** MIC浓度范围 */
	@Column(name = "MICRO_REFERENCE_MIC", length = 20)
	private String microReferenceMic;
	
	/** KB法抑径圈范围 */
	@Column(name = "MICRO_REFERENCE_KB", length = 20)
	private String microReferenceKb;
	
	/** 参考范围1 */
	@Column(name = "MICRO_REFERENCE_ONE", length = 50)
	private String microReferenceOne;
	
	/** 参考范围2 */
	@Column(name = "MICRO_REFERENCE_TWO", length = 50)
	private String microReferenceTwo;
	
	/** 状态 */
	@Column(name = "STATE_FLAG", length = 2)
	private String stateFlag;
	
	/** 第一级分类 */
	@Column(name = "ONE_CLASSIFY", length = 50)
	private String oneClassify;
	
	/** 第二级分类 */
	@Column(name = "TWO_CLASSIFY", length = 50)
	private String twoClassify;
	
	/** 第三级分类 */
	@Column(name = "THREE_CLASSIFY", length = 50)
	private String threeClassify;
	
	/** 第四级分类 */
	@Column(name = "FOUR_CLASSIFY", length = 50)
	private String fourClassify;
	
	/** MIC浓度范围（显示） */
	@Column(name = "REF_MIC_DISPLAY", length = 50)
	private String refMicDisplay;
	
	/** KB法抑径圈范围（显示） */
	@Column(name = "REF_KB_DISPLAY", length = 50)
	private String refKbDisplay;

	// Constructors

	/** default constructor */
	public LisMicroData() {
	}

	/**
	 * @return lisMicroDataId
	 */
	public Long getLisMicroDataId() {
		return lisMicroDataId;
	}

	/**
	 * @param lisMicroDataId 要设置的 lisMicroDataId
	 */
	public void setLisMicroDataId(Long lisMicroDataId) {
		this.lisMicroDataId = lisMicroDataId;
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
	 * @return microDataId
	 */
	public String getMicroDataId() {
		return microDataId;
	}

	/**
	 * @param microDataId 要设置的 microDataId
	 */
	public void setMicroDataId(String microDataId) {
		this.microDataId = microDataId;
	}

	/**
	 * @return microDataClass
	 */
	public String getMicroDataClass() {
		return microDataClass;
	}

	/**
	 * @param microDataClass 要设置的 microDataClass
	 */
	public void setMicroDataClass(String microDataClass) {
		this.microDataClass = microDataClass;
	}

	/**
	 * @return microDataSort
	 */
	public String getMicroDataSort() {
		return microDataSort;
	}

	/**
	 * @param microDataSort 要设置的 microDataSort
	 */
	public void setMicroDataSort(String microDataSort) {
		this.microDataSort = microDataSort;
	}

	/**
	 * @return coding
	 */
	public String getCoding() {
		return coding;
	}

	/**
	 * @param coding 要设置的 coding
	 */
	public void setCoding(String coding) {
		this.coding = coding;
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
	 * @return englishNameShort
	 */
	public String getEnglishNameShort() {
		return englishNameShort;
	}

	/**
	 * @param englishNameShort 要设置的 englishNameShort
	 */
	public void setEnglishNameShort(String englishNameShort) {
		this.englishNameShort = englishNameShort;
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
	 * @return chineseNameShort
	 */
	public String getChineseNameShort() {
		return chineseNameShort;
	}

	/**
	 * @param chineseNameShort 要设置的 chineseNameShort
	 */
	public void setChineseNameShort(String chineseNameShort) {
		this.chineseNameShort = chineseNameShort;
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
	 * @return standardName
	 */
	public String getStandardName() {
		return standardName;
	}

	/**
	 * @param standardName 要设置的 standardName
	 */
	public void setStandardName(String standardName) {
		this.standardName = standardName;
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
	 * @return classify
	 */
	public String getClassify() {
		return classify;
	}

	/**
	 * @param classify 要设置的 classify
	 */
	public void setClassify(String classify) {
		this.classify = classify;
	}

	/**
	 * @return microCombineId
	 */
	public String getMicroCombineId() {
		return microCombineId;
	}

	/**
	 * @param microCombineId 要设置的 microCombineId
	 */
	public void setMicroCombineId(String microCombineId) {
		this.microCombineId = microCombineId;
	}

	/**
	 * @return microMethod
	 */
	public String getMicroMethod() {
		return microMethod;
	}

	/**
	 * @param microMethod 要设置的 microMethod
	 */
	public void setMicroMethod(String microMethod) {
		this.microMethod = microMethod;
	}

	/**
	 * @return microReferenceMic
	 */
	public String getMicroReferenceMic() {
		return microReferenceMic;
	}

	/**
	 * @param microReferenceMic 要设置的 microReferenceMic
	 */
	public void setMicroReferenceMic(String microReferenceMic) {
		this.microReferenceMic = microReferenceMic;
	}

	/**
	 * @return microReferenceKb
	 */
	public String getMicroReferenceKb() {
		return microReferenceKb;
	}

	/**
	 * @param microReferenceKb 要设置的 microReferenceKb
	 */
	public void setMicroReferenceKb(String microReferenceKb) {
		this.microReferenceKb = microReferenceKb;
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

	/**
	 * @return the classifyId
	 */
	public String getClassifyId() {
		return classifyId;
	}

	/**
	 * @param classifyId the classifyId to set
	 */
	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}

	/**
	 * @return the microReferenceOne
	 */
	public String getMicroReferenceOne() {
		return microReferenceOne;
	}

	/**
	 * @param microReferenceOne the microReferenceOne to set
	 */
	public void setMicroReferenceOne(String microReferenceOne) {
		this.microReferenceOne = microReferenceOne;
	}

	/**
	 * @return the microReferenceTwo
	 */
	public String getMicroReferenceTwo() {
		return microReferenceTwo;
	}

	/**
	 * @param microReferenceTwo the microReferenceTwo to set
	 */
	public void setMicroReferenceTwo(String microReferenceTwo) {
		this.microReferenceTwo = microReferenceTwo;
	}

	/**
	 * @return the oneClassify
	 */
	public String getOneClassify() {
		return oneClassify;
	}

	/**
	 * @param oneClassify the oneClassify to set
	 */
	public void setOneClassify(String oneClassify) {
		this.oneClassify = oneClassify;
	}

	/**
	 * @return the twoClassify
	 */
	public String getTwoclassify() {
		return twoClassify;
	}

	/**
	 * @param twoClassify the twoClassify to set
	 */
	public void setTwoclassify(String twoClassify) {
		this.twoClassify = twoClassify;
	}

	/**
	 * @return the threeClassify
	 */
	public String getThreeClassify() {
		return threeClassify;
	}

	/**
	 * @param threeClassify the threeClassify to set
	 */
	public void setThreeClassify(String threeClassify) {
		this.threeClassify = threeClassify;
	}

	/**
	 * @return the fourClassify
	 */
	public String getFourClassify() {
		return fourClassify;
	}

	/**
	 * @param fourClassify the fourClassify to set
	 */
	public void setFourClassify(String fourClassify) {
		this.fourClassify = fourClassify;
	}

	/**
	 * @return refMicDisplay
	 */
	public String getRefMicDisplay() {
		return refMicDisplay;
	}

	/**
	 * @param refMicDisplay 要设置的 refMicDisplay
	 */
	public void setRefMicDisplay(String refMicDisplay) {
		this.refMicDisplay = refMicDisplay;
	}

	/**
	 * @return refKbDisplay
	 */
	public String getRefKbDisplay() {
		return refKbDisplay;
	}

	/**
	 * @param refKbDisplay 要设置的 refKbDisplay
	 */
	public void setRefKbDisplay(String refKbDisplay) {
		this.refKbDisplay = refKbDisplay;
	}

	
}