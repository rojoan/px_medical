package com.bofan.lis.valueobject;

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
 * @Description: lis_inspection_result（检验样本结果表_一般检验）
 * @author lqw
 * @date 2017-10-09
 */
@Entity
@Table(name = "LIS_INSPECTION_RESULT", schema = SchemaConsts.LIS_CLOUD)
@SequenceGenerator(name = "LIS_INSPECTION_RESULT_ID", sequenceName = SchemaConsts.LIS_CLOUD + ".LIS_INSPECTION_RESULT_ID", allocationSize=1)
public class LisInspectionResult {
	// Fields

	/** 检验样本结果-一般检验ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIS_INSPECTION_RESULT_ID")
	@Column(name = "LIS_INSPECTION_RESULT_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long lisInspectionResultId;
	
	/** 医院（医疗机构）标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/** 检验单ID -原主键ID */
	@Column(name = "INSPECTION_ID", nullable = false, length = 40)
	private String inspectionId;
	
	/** 项目代码 */
	@Column(name = "TEST_ITEM_ID", nullable = false, length = 10)
	private String testItemId;
	
	/** 分组代号 */
	@Column(name = "GROUP_ID", nullable = false, length = 10)
	private String groupId;
	
	/** 检验时间 */
	@Column(name = "INSPECTION_TIME", nullable = false)
	private Date inspectionTime;
	
	/** 样本代码 */
	@Column(name = "SAMPLE_NUMBER", nullable = false, length = 10)
	private String sampleNumber;
	
	/** 排序号 */
	@Column(name = "TEST_ITEM_SORT", length = 20)
	private String testItemSort;
	
	/** 英文名称 */
	@Column(name = "ENGLISH_NAME", length = 50)
	private String englishName;
	
	/** 中文名称 */
	@Column(name = "CHINESE_NAME", length = 100)
	private String chineseName;
	
	/** 原始结果 */
	@Column(name = "ORIGINAL_RESULT", length = 50)
	private String originalResult;
	
	/** 检验结果 */
	@Column(name = "QUANTITATIVE_RESULT", length = 50)
	private String quantitativeResult;
	
	/** 结果提示 */
	@Column(name = "QUALITATIVE_RESULT", length = 50)
	private String qualitativeResult;
	
	/** 参考范围 */
	@Column(name = "TEST_ITEM_REFERENCE")
	private String testItemReference;
	
	/** 项目单位 */
	@Column(name = "TEST_ITEM_UNIT", length = 20)
	private String testItemUnit;
	
	/** 项目单价 */
	@Column(name = "TEST_ITEM_CHARGE", precision = 18)
	private BigDecimal testItemCharge;
	
	/** 工作量 */
	@Column(name = "WORKLOAD", precision = 18, scale = 0)
	private Long workload;
	
	/** 项目数 */
	@Column(name = "TEST_COUNT", length = 20)
	private String testCount;
	
	/** 收费项目代码 */
	@Column(name = "TEST_ORDER", length = 20)
	private String testOrder;
	
	/** 检验仪器 */
	@Column(name = "INSPECTION_INSTRUMENT", length = 20)
	private String inspectionInstrument;
	
	/** 检验人员 */
	@Column(name = "INSPECTION_PERSON", length = 20)
	private String inspectionPerson;
	
	/** 检验位置 */
	@Column(name = "INSPECTION_POSITION", length = 20)
	private String inspectionPosition;
	
	/** 报告 */
	@Column(name = "REPORT_ID", length = 10)
	private String reportId;
	
	/** col_position */
	@Column(name = "COL_POSITION", length = 20)
	private String colPosition;
	
	/** 打印序号 */
	@Column(name = "PRINT_ID", length = 20)
	private String printId;
	
	/** 备注 */
	@Column(name = "REMARK", length = 50)
	private String remark;
	
	/** 审核人员 */
	@Column(name = "CHECK_PERSON", length = 20)
	private String checkPerson;
	
	/** 审核时间 */
	@Column(name = "CHECK_TIME")
	private Date checkTime;
	
	/** inspection_reagent */
	@Column(name = "INSPECTION_REAGENT", length = 20)
	private String inspectionReagent;
	
	/** 结果类型 */
	@Column(name = "RESULT_TYPE", length = 20)
	private String resultType;
	
	/** 试验方法 */
	@Column(name = "TEST_METHOD", length = 100)
	private String testMethod;
	
	/** read_doctor */
	@Column(name = "READ_DOCTOR", length = 50)
	private String readDoctor;
	
	/** quantitative_result_old */
	@Column(name = "QUANTITATIVE_RESULT_OLD", length = 50)
	private String quantitativeResultOld;

	// Constructors

	/** default constructor */
	public LisInspectionResult() {
	}

	/**
	 * @return lisInspectionResultId
	 */
	public Long getLisInspectionResultId() {
		return lisInspectionResultId;
	}

	/**
	 * @param lisInspectionResultId 要设置的 lisInspectionResultId
	 */
	public void setLisInspectionResultId(Long lisInspectionResultId) {
		this.lisInspectionResultId = lisInspectionResultId;
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
	 * @return inspectionId
	 */
	public String getInspectionId() {
		return inspectionId;
	}

	/**
	 * @param inspectionId 要设置的 inspectionId
	 */
	public void setInspectionId(String inspectionId) {
		this.inspectionId = inspectionId;
	}

	/**
	 * @return testItemId
	 */
	public String getTestItemId() {
		return testItemId;
	}

	/**
	 * @param testItemId 要设置的 testItemId
	 */
	public void setTestItemId(String testItemId) {
		this.testItemId = testItemId;
	}

	/**
	 * @return groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId 要设置的 groupId
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return inspectionTime
	 */
	public Date getInspectionTime() {
		return inspectionTime;
	}

	/**
	 * @param inspectionTime 要设置的 inspectionTime
	 */
	public void setInspectionTime(Date inspectionTime) {
		this.inspectionTime = inspectionTime;
	}

	/**
	 * @return sampleNumber
	 */
	public String getSampleNumber() {
		return sampleNumber;
	}

	/**
	 * @param sampleNumber 要设置的 sampleNumber
	 */
	public void setSampleNumber(String sampleNumber) {
		this.sampleNumber = sampleNumber;
	}

	/**
	 * @return testItemSort
	 */
	public String getTestItemSort() {
		return testItemSort;
	}

	/**
	 * @param testItemSort 要设置的 testItemSort
	 */
	public void setTestItemSort(String testItemSort) {
		this.testItemSort = testItemSort;
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
	 * @return originalResult
	 */
	public String getOriginalResult() {
		return originalResult;
	}

	/**
	 * @param originalResult 要设置的 originalResult
	 */
	public void setOriginalResult(String originalResult) {
		this.originalResult = originalResult;
	}

	/**
	 * @return quantitativeResult
	 */
	public String getQuantitativeResult() {
		return quantitativeResult;
	}

	/**
	 * @param quantitativeResult 要设置的 quantitativeResult
	 */
	public void setQuantitativeResult(String quantitativeResult) {
		this.quantitativeResult = quantitativeResult;
	}

	/**
	 * @return qualitativeResult
	 */
	public String getQualitativeResult() {
		return qualitativeResult;
	}

	/**
	 * @param qualitativeResult 要设置的 qualitativeResult
	 */
	public void setQualitativeResult(String qualitativeResult) {
		this.qualitativeResult = qualitativeResult;
	}

	/**
	 * @return testItemReference
	 */
	public String getTestItemReference() {
		return testItemReference;
	}

	/**
	 * @param testItemReference 要设置的 testItemReference
	 */
	public void setTestItemReference(String testItemReference) {
		this.testItemReference = testItemReference;
	}

	/**
	 * @return testItemUnit
	 */
	public String getTestItemUnit() {
		return testItemUnit;
	}

	/**
	 * @param testItemUnit 要设置的 testItemUnit
	 */
	public void setTestItemUnit(String testItemUnit) {
		this.testItemUnit = testItemUnit;
	}

	/**
	 * @return testItemCharge
	 */
	public BigDecimal getTestItemCharge() {
		return testItemCharge;
	}

	/**
	 * @param testItemCharge 要设置的 testItemCharge
	 */
	public void setTestItemCharge(BigDecimal testItemCharge) {
		this.testItemCharge = testItemCharge;
	}

	/**
	 * @return workload
	 */
	public Long getWorkload() {
		return workload;
	}

	/**
	 * @param workload 要设置的 workload
	 */
	public void setWorkload(Long workload) {
		this.workload = workload;
	}

	/**
	 * @return testCount
	 */
	public String getTestCount() {
		return testCount;
	}

	/**
	 * @param testCount 要设置的 testCount
	 */
	public void setTestCount(String testCount) {
		this.testCount = testCount;
	}

	/**
	 * @return testOrder
	 */
	public String getTestOrder() {
		return testOrder;
	}

	/**
	 * @param testOrder 要设置的 testOrder
	 */
	public void setTestOrder(String testOrder) {
		this.testOrder = testOrder;
	}

	/**
	 * @return inspectionInstrument
	 */
	public String getInspectionInstrument() {
		return inspectionInstrument;
	}

	/**
	 * @param inspectionInstrument 要设置的 inspectionInstrument
	 */
	public void setInspectionInstrument(String inspectionInstrument) {
		this.inspectionInstrument = inspectionInstrument;
	}

	/**
	 * @return inspectionPerson
	 */
	public String getInspectionPerson() {
		return inspectionPerson;
	}

	/**
	 * @param inspectionPerson 要设置的 inspectionPerson
	 */
	public void setInspectionPerson(String inspectionPerson) {
		this.inspectionPerson = inspectionPerson;
	}

	/**
	 * @return inspectionPosition
	 */
	public String getInspectionPosition() {
		return inspectionPosition;
	}

	/**
	 * @param inspectionPosition 要设置的 inspectionPosition
	 */
	public void setInspectionPosition(String inspectionPosition) {
		this.inspectionPosition = inspectionPosition;
	}

	/**
	 * @return reportId
	 */
	public String getReportId() {
		return reportId;
	}

	/**
	 * @param reportId 要设置的 reportId
	 */
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	/**
	 * @return colPosition
	 */
	public String getColPosition() {
		return colPosition;
	}

	/**
	 * @param colPosition 要设置的 colPosition
	 */
	public void setColPosition(String colPosition) {
		this.colPosition = colPosition;
	}

	/**
	 * @return printId
	 */
	public String getPrintId() {
		return printId;
	}

	/**
	 * @param printId 要设置的 printId
	 */
	public void setPrintId(String printId) {
		this.printId = printId;
	}

	/**
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark 要设置的 remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return checkPerson
	 */
	public String getCheckPerson() {
		return checkPerson;
	}

	/**
	 * @param checkPerson 要设置的 checkPerson
	 */
	public void setCheckPerson(String checkPerson) {
		this.checkPerson = checkPerson;
	}

	/**
	 * @return checkTime
	 */
	public Date getCheckTime() {
		return checkTime;
	}

	/**
	 * @param checkTime 要设置的 checkTime
	 */
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * @return inspectionReagent
	 */
	public String getInspectionReagent() {
		return inspectionReagent;
	}

	/**
	 * @param inspectionReagent 要设置的 inspectionReagent
	 */
	public void setInspectionReagent(String inspectionReagent) {
		this.inspectionReagent = inspectionReagent;
	}

	/**
	 * @return resultType
	 */
	public String getResultType() {
		return resultType;
	}

	/**
	 * @param resultType 要设置的 resultType
	 */
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	/**
	 * @return testMethod
	 */
	public String getTestMethod() {
		return testMethod;
	}

	/**
	 * @param testMethod 要设置的 testMethod
	 */
	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}

	/**
	 * @return readDoctor
	 */
	public String getReadDoctor() {
		return readDoctor;
	}

	/**
	 * @param readDoctor 要设置的 readDoctor
	 */
	public void setReadDoctor(String readDoctor) {
		this.readDoctor = readDoctor;
	}

	/**
	 * @return quantitativeResultOld
	 */
	public String getQuantitativeResultOld() {
		return quantitativeResultOld;
	}

	/**
	 * @param quantitativeResultOld 要设置的 quantitativeResultOld
	 */
	public void setQuantitativeResultOld(String quantitativeResultOld) {
		this.quantitativeResultOld = quantitativeResultOld;
	}
}