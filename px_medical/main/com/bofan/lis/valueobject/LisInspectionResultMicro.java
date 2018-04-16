package com.bofan.lis.valueobject;

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
 * @Description: lis_inspection_result_micro（检验样本结果表_微生物）
 * @author lqw
 * @date 2017-10-09
 */
@Entity
@Table(name = "LIS_INSPECTION_RESULT_MICRO", schema = SchemaConsts.LIS_CLOUD)
@SequenceGenerator(name = "LIS_INSPECTION_RESULT_MICRO_ID", sequenceName = SchemaConsts.LIS_CLOUD + ".LIS_INSPECTION_RESULT_MICRO_ID", allocationSize=1)
public class LisInspectionResultMicro {

	// Fields
	/**	检验样本结果-微生物ID	*/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIS_INSPECTION_RESULT_MICRO_ID")
	@Column(name = "LIS_INSPECTION_RESULT_MICRO_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long lisInspectionResultMicroId;
	
	/**	医院（医疗机构）标识	对应sys_org表中org_no字段*/
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/**	检验单ID	*/
	@Column(name = "INSPECTION_ID", nullable = false, length = 40)
	private String inspectionId;
	
	/**	分组代号	*/
	@Column(name = "GROUP_ID", nullable = false, length = 10)
	private String groupId;
	
	/**	检验时间	*/
	@Column(name = "INSPECTION_TIME", nullable = false)
	private Date inspectionTime;
	
	/**	样本编号	*/
	@Column(name = "SAMPLE_NUMBER", nullable = false, length = 10)
	private String sampleNumber;
	
	/**	结果类型	*/
	@Column(name = "RESULT_TYPE", nullable = false, length = 10)
	private String resultType;
	
	/**	结果方法	*/
	@Column(name = "RESULT_METHOD", length = 10)
	private String resultMethod;
	
	/**	简称结果代码	*/
	@Column(name = "MICRO_DATA_ID", nullable = false, length = 20)
	private String microDataId;
	
	/**	简称结果代码检简称	*/
	@Column(name = "MICRO_DATA_ID_SORT", nullable = false, length = 10)
	private String microDataIdSort;
	
	/**	检测结果名称	*/
	@Column(name = "MICRO_DATA_ID_NAME", length = 50)
	private String microDataIdName;
	
	/**	micro_data_id_result1	*/
	@Column(name = "MICRO_DATA_ID_RESULT", length = 50)
	private String microDataIdResult;
	
	/**	抗生素代码	*/
	@Column(name = "MICRA_DATA_IDT", length = 20)
	private String micraDataIdt;
	
	/**	抗生素代码检简称	*/
	@Column(name = "MICRA_DATA_IDT_SORT", length = 20)
	private String micraDataIdtSort;
	
	/**	抗生素名称	*/
	@Column(name = "MICRO_DATA_IDT_NAME", length = 50)
	private String microDataIdtName;
	
	/**	定量结果	*/
	@Column(name = "MICRO_DATA_IDT_RESULTO", length = 50)
	private String microDataIdtResulto;
	
	/**	定性结果	*/
	@Column(name = "MICRO_DATA_IDT_RESULTT", length = 20)
	private String microDataIdtResultt;
	
	/**	micro_data_id2_range	*/
	@Column(name = "MICRO_DATA_IDT_RANGE", length = 200)
	private String microDataIdtRange;
	
	/**	检验仪器	*/
	@Column(name = "INSPECTION_INSTRUMENT", length = 20)
	private String inspectionInstrument;
	
	/**	检验位置	*/
	@Column(name = "INSPECTION_POSITION", length = 20)
	private String inspectionPosition;
	
	/**	检验人员	*/
	@Column(name = "INSPECTION_PERSON", length = 20)
	private String inspectionPerson;
	
	/**	备注	*/
	@Column(name = "REMARK", length = 50)
	private String remark;
	
	/**	esbl	*/
	@Column(name = "ESBL", length = 10)
	private String esbl;
	
	/**	read_doctor	*/
	@Column(name = "READ_DOCTOR", length = 50)
	private String readDoctor;
	
	/**	报告代码	*/
//	@Column(name = "REPORT_ID", nullable = false, length = 2)
//	private String reportId;

	// Constructors

	/** default constructor */
	public LisInspectionResultMicro() {
	}

	// Property accessors
	
	/**
	 * @return lisInspectionResultMicroId
	 */
	public Long getLisInspectionResultMicroId() {
		return lisInspectionResultMicroId;
	}

	/**
	 * @param lisInspectionResultMicroId 要设置的 lisInspectionResultMicroId
	 */
	public void setLisInspectionResultMicroId(Long lisInspectionResultMicroId) {
		this.lisInspectionResultMicroId = lisInspectionResultMicroId;
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
	 * @return resultMethod
	 */
	public String getResultMethod() {
		return resultMethod;
	}

	/**
	 * @param resultMethod 要设置的 resultMethod
	 */
	public void setResultMethod(String resultMethod) {
		this.resultMethod = resultMethod;
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
	 * @return microDataIdSort
	 */
	public String getMicroDataIdSort() {
		return microDataIdSort;
	}

	/**
	 * @param microDataIdSort 要设置的 microDataIdSort
	 */
	public void setMicroDataIdSort(String microDataIdSort) {
		this.microDataIdSort = microDataIdSort;
	}

	/**
	 * @return microDataIdName
	 */
	public String getMicroDataIdName() {
		return microDataIdName;
	}

	/**
	 * @param microDataIdName 要设置的 microDataIdName
	 */
	public void setMicroDataIdName(String microDataIdName) {
		this.microDataIdName = microDataIdName;
	}

	/**
	 * @return the microDataIdResult
	 */
	public String getMicroDataIdResult() {
		return microDataIdResult;
	}

	/**
	 * @param microDataIdResult the microDataIdResult to set
	 */
	public void setMicroDataIdResult(String microDataIdResult) {
		this.microDataIdResult = microDataIdResult;
	}

	/**
	 * @return the micraDataIdt
	 */
	public String getMicraDataIdt() {
		return micraDataIdt;
	}

	/**
	 * @param micraDataIdt the micraDataIdt to set
	 */
	public void setMicraDataIdt(String micraDataIdt) {
		this.micraDataIdt = micraDataIdt;
	}

	/**
	 * @return the micraDataIdtSort
	 */
	public String getMicraDataIdtSort() {
		return micraDataIdtSort;
	}

	/**
	 * @param micraDataIdtSort the micraDataIdtSort to set
	 */
	public void setMicraDataIdtSort(String micraDataIdtSort) {
		this.micraDataIdtSort = micraDataIdtSort;
	}

	/**
	 * @return the microDataIdtName
	 */
	public String getMicroDataIdtName() {
		return microDataIdtName;
	}

	/**
	 * @param microDataIdtName the microDataIdtName to set
	 */
	public void setMicroDataIdtName(String microDataIdtName) {
		this.microDataIdtName = microDataIdtName;
	}

	/**
	 * @return the microDataIdtResulto
	 */
	public String getMicroDataIdtResulto() {
		return microDataIdtResulto;
	}

	/**
	 * @param microDataIdtResulto the microDataIdtResulto to set
	 */
	public void setMicroDataIdtResulto(String microDataIdtResulto) {
		this.microDataIdtResulto = microDataIdtResulto;
	}

	/**
	 * @return the microDataIdtResultt
	 */
	public String getMicroDataIdtResultt() {
		return microDataIdtResultt;
	}

	/**
	 * @param microDataIdtResultt the microDataIdtResultt to set
	 */
	public void setMicroDataIdtResultt(String microDataIdtResultt) {
		this.microDataIdtResultt = microDataIdtResultt;
	}

	/**
	 * @return the microDataIdtRange
	 */
	public String getMicroDataIdtRange() {
		return microDataIdtRange;
	}

	/**
	 * @param microDataIdtRange the microDataIdtRange to set
	 */
	public void setMicroDataIdtRange(String microDataIdtRange) {
		this.microDataIdtRange = microDataIdtRange;
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
	 * @return esbl
	 */
	public String getEsbl() {
		return esbl;
	}

	/**
	 * @param esbl 要设置的 esbl
	 */
	public void setEsbl(String esbl) {
		this.esbl = esbl;
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
	 * @return reportId
	 */
//	public String getReportId() {
//		return reportId;
//	}
//
//	/**
//	 * @param reportId 要设置的 reportId
//	 */
//	public void setReportId(String reportId) {
//		this.reportId = reportId;
//	}
}