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
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description: lis_inspection_sample（检验样本信息表）
 * @author lqw
 * @date 2017-10-09
 */

@Entity
@Table(name = "LIS_INSPECTION_SAMPLE", schema = SchemaConsts.LIS_CLOUD)
@SequenceGenerator(name = "LIS_INSPECTION_SAMPLE_ID", sequenceName = SchemaConsts.LIS_CLOUD + ".LIS_INSPECTION_SAMPLE_ID", allocationSize=1)
public class LisInspectionSample {

	// Fields

	/** 检验样本信息ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIS_INSPECTION_SAMPLE_ID")
	@Column(name = "LIS_INSPECTION_SAMPLE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long lisInspectionSampleId;

	/** 根据医院编码(hospitalNo) 获取 SysOrg 的org_id */
	@Column(name = "ORG_ID", nullable = false, precision = 18, scale = 0)
	private Long orgId;

	
	/** 医院（医疗机构）标识  对应sys_org表中org_no字段*/
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;

	/** 检验单ID,原主键ID */
	@Column(name = "INSPECTION_ID", nullable = false, length = 40)
	private String inspectionId;

	/** 分组代码 对应 lis_inspection_group（检验分组信息表）主键ID  */
	@Column(name = "GROUP_ID", nullable = false, length = 10)
	private String groupId;
	
	/**	检验时间	*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
	@Column(name = "INSPECTION_TIME", nullable = false)
	private Date inspectionTime;
	

	/** 样本编号 */
	@Column(name = "SAMPLE_NUMBER", nullable = false, length = 10)
	private String sampleNumber;

	/** "申请单ID 对应 lis_requisition_info（申请单病人信息表）主键ID" */
	@Column(name = "REQUISITION_ID", length = 20)
	private String requisitionId;

	/** "病人类别  1=住院  2=门诊  3=住院急诊  4=门诊急诊" */
	@Column(name = "PATIENT_TYPE", nullable = false, length = 1)
	private String patientType;

	/** 病员号，即 病员ID */
	@Column(name = "PATIENT_ID", length = 50)
	private String patientId;

	/** 病人唯一号，即 门诊/住院流水号 */
	@Column(name = "INPATIENT_ID", length = 50)
	private String inpatientId;
	
	/** 患者院内档案ID（HIS系统） */
	@Column(name = "PATIENT_NO", precision = 18, scale = 0)
	private Long patientNo;
	
	/** 发票号码 */
	@Column(name = "INVOICE_ID", length = 50)
	private String invoiceId;

	/** "收费类别 无数据" */
	@Column(name = "CHARGE_TYPE", length = 20)
	private String chargeType;

	/** 患者姓名 */
	@Column(name = "PATIENT_NAME", length = 50)
	private String patientName;

	/** "病人性别 1=男  2=女" */
	@Column(name = "PATIENT_SEX", length = 10)
	private String patientSex;

	/** 年龄类型 */
	@Column(name = "AGE_TYPE", length = 20)
	private String ageType;

	/** 输入年龄 */
	@Column(name = "AGE_INPUT", length = 20)
	private String ageInput;

	/** 保存年龄 */
	@Column(name = "AGE_SAVE", precision = 18, scale = 0)
	private Long ageSave;

	/** 民族代码 */
	@Column(name = "PATIENT_NATION", length = 50)
	private String patientNation;

	/** 民族名称 */
	@Column(name = "PATIENT_NATION_NAME", length = 50)
	private String patientNationName;

	/** ABO血型 */
	@Column(name = "BLOODTYPE_ABO", length = 10)
	private String bloodtypeAbo;

	/** RH血型 */
	@Column(name = "BLOODTYPE_RH", length = 10)
	private String bloodtypeRh;

	/** 科别代码 */
	@Column(name = "PATIENT_DEPT", length = 10)
	private String patientDept;

	/** 科别名称 */
	@Column(name = "PATIENT_DEPT_NAME", length = 50)
	private String patientDeptName;

	/** 病区代码 */
	@Column(name = "PATIENT_WARD", length = 10)
	private String patientWard;

	/** 病区名称 */
	@Column(name = "PATIENT_WARD_NAME", length = 50)
	private String patientWardName;

	/** 床号 */
	@Column(name = "PATIENT_BED", length = 10)
	private String patientBed;

	/** 特殊条件 */
	@Column(name = "ESPECIAL_CONDITION", length = 100)
	private String especialCondition;

	/** 诊断代码 */
	@Column(name = "CLINICAL_DIAGNOSES", length = 100)
	private String clinicalDiagnoses;

	/** 诊断名称 */
	@Column(name = "CLINICAL_DIAGNOSES_NAME", length = 100)
	private String clinicalDiagnosesName;

	/** 标本种类代码 */
	@Column(name = "SAMPLE_CLASS", length = 10)
	private String sampleClass;

	/** 标本种类名称 */
	@Column(name = "SAMPLE_CLASS_NAME", length = 50)
	private String sampleClassName;

	/** 感染状况 */
	@Column(name = "INFECT_STATUS", length = 24)
	private String infectStatus;

	/** 标本性状代码 */
	@Column(name = "SAMPLE_STATUS", length = 20)
	private String sampleStatus;

	/** 标本性状名称 */
	@Column(name = "SAMPLE_STATUS_NAME", length = 50)
	private String sampleStatusName;

	/** 采样地点代码 */
	@Column(name = "SAMPLING_POSITION", length = 20)
	private String samplingPosition;

	/** 采样地点名称 */
	@Column(name = "SAMPLING_POSITION_NAME", length = 50)
	private String samplingPositionName;

	/** 收费项目代码 */
	@Column(name = "TEST_ORDER")
	private String testOrder;

	/** 收费项目名称 */
	@Column(name = "TEST_ORDER_NAME")
	private String testOrderName;

	/** 样本收费 */
	@Column(name = "SAMPLE_CHARGE", precision = 18)
	private BigDecimal sampleCharge;

	/** 项目数 */
	@Column(name = "ITEM_COUNT", precision = 18, scale = 0)
	private Long itemCount;

	/** 工作量 */
	@Column(name = "WORKLOAD", precision = 18, scale = 0)
	private Long workload;

	/** 采样时间 */
	@Column(name = "SAMPLING_TIME")
	private Date samplingTime;

	/** 采样人员 */
	@Column(name = "SAMPLING_PERSON", length = 20)
	private String samplingPerson;

	/** 开单时间 */
	@Column(name = "REQUISITION_TIME")
	private Date requisitionTime;

	/** 开单人员 */
	@Column(name = "REQUISITION_PERSON", length = 20)
	private String requisitionPerson;

	/** 送检单位 */
	@Column(name = "DELIVER_HOSPITAL", length = 100)
	private String deliverHospital;

	/** 接收时间 */
	@Column(name = "INCEPT_TIME")
	private Date inceptTime;

	/** 接收人员 */
	@Column(name = "INCEPT_PERSON", length = 20)
	private String inceptPerson;

	/** 录入人员 */
	@Column(name = "INPUT_PERSON", length = 20)
	private String inputPerson;

	/** 录入时间 */
	@Column(name = "INPUT_TIME")
	private Date inputTime;

	/** 检验人员 */
	@Column(name = "INSPECTION_PERSON", length = 20)
	private String inspectionPerson;

	/** 审核人员 */
	@Column(name = "CHECK_PERSON", length = 20)
	private String checkPerson;

	/** 审核时间 */
	@Column(name = "CHECK_TIME")
	private Date checkTime;

	/** 打印人员 */
	@Column(name = "PRINT_PERSON", length = 20)
	private String printPerson;

	/** 打印时间 */
	@Column(name = "PRINT_TIME")
	private Date printTime;

	/** 打印次数 */
	@Column(name = "PRINT_COUNT", precision = 22, scale = 0)
	private BigDecimal printCount;

	/** 专家规则 */
	@Column(name = "EXPERT_RULE", length = 50)
	private String expertRule;

	/** 身份号 */
	@Column(name = "ID_CARD", length = 30)
	private String idCard;

	/** 收费状态 */
	@Column(name = "CHARGE_STATE", length = 10)
	private String chargeState;

	/** "检验状态 audited=已审核 inspecting=正在检验 reported=已报告 */
	@Column(name = "INSPECTION_STATE", length = 10)
	private String inspectionState;

	/** 读取状态 */
	@Column(name = "READ_STATE", length = 10)
	private String readState;

	/** 备注代码 */
	@Column(name = "REMARK", length = 1000)
	private String remark;

	/** 备注内容 */
	@Column(name = "REMARK_NAME", length = 1000)
	private String remarkName;

	/** 确认时间 */
	@Column(name = "CONFIRM_TIME")
	private Date confirmTime;

	/** 确认人员 */
	@Column(name = "CONFIRM_PERSON", length = 20)
	private String confirmPerson;

	/** patient_type_old */
	@Column(name = "PATIENT_TYPE_OLD", length = 20)
	private String patientTypeOld;

	/** 检验仪器 */
	@Column(name = "INSTRUMENT", length = 100)
	private String instrument;

	/** mobileno */
	@Column(name = "MOBILENO", length = 50)
	private String mobileno;

	/** 发送状态 */
	@Column(name = "SEND_STATE", length = 10)
	private String sendState;

	/** 发送时间 */
	@Column(name = "SEND_DATE", length = 10)
	private String sendDate;

	/** 出生年月 */
	@Column(name = "PATIENT_BIRTHDAY", length = 10)
	private String patientBirthday;

	/** 采血顺序 */
	@Column(name = "BLOOD_ORDER", length = 50)
	private String bloodOrder;

	/** 采血模式 */
	@Column(name = "BLOOD_MODE", length = 50)
	private String bloodMode;

	/** read_doctor */
	@Column(name = "READ_DOCTOR", length = 50)
	private String readDoctor;

	/** read_time */
	@Column(name = "READ_TIME", length = 50)
	private String readTime;

	/** 初步审核时间 */
	@Column(name = "CHECK_TEMP_TIME")
	private Date checkTempTime;

	/** 检验审核时间 */
	@Column(name = "INSPECTIONTIME")
	private Date inspectiontime;

	/** 血液出库打印时间 */
	@Column(name = "BLOOD_OUTPUT_PRINT_TIME")
	private Date bloodOutputPrintTime;

	/** 收样人员 */
	@Column(name = "RECEIVE_PERSON", length = 20)
	private String receivePerson;

	/** 结果解释状态 */
	@Column(name = "RESULT_INCEPT_STATE", length = 1)
	private String resultInceptState;

	/** police_state */
	@Column(name = "POLICE_STATE", nullable = false, length = 1)
	private String policeState;

	/** police_person */
	@Column(name = "POLICE_PERSON")
	private String policePerson;

	/** police_time */
	@Column(name = "POLICE_TIME")
	private Date policeTime;

	/** police_Minute */
	@Column(name = "POLICE_MINUTE", precision = 18, scale = 0)
	private Long policeMinute;

	/** readed_state */
	@Column(name = "READED_STATE", length = 1)
	private String readedState;

	/** audited_person */
	@Column(name = "AUDITED_PERSON", length = 20)
	private String auditedPerson;

	/** audited_time */
	@Column(name = "AUDITED_TIME")
	private Date auditedTime;
	
	/** 转诊-远程诊断标识 */
    @Column(name = "DIAGNOSIS_FLAG", length = 1)
    private String diagnosisFlag;

	// Constructors

	/** default constructor */
	public LisInspectionSample() {
	}

	/**
	 * @return lisInspectionSampleId
	 */
	public Long getLisInspectionSampleId() {
		return lisInspectionSampleId;
	}

	/**
	 * @param lisInspectionSampleId
	 *            要设置的 lisInspectionSampleId
	 */
	public void setLisInspectionSampleId(Long lisInspectionSampleId) {
		this.lisInspectionSampleId = lisInspectionSampleId;
	}

	/**
	 * @return orgId
	 */
	public Long getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId 要设置的 orgId
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return hospitalNo
	 */
	public String getHospitalNo() {
		return hospitalNo;
	}

	/**
	 * @param hospitalNo
	 *            要设置的 hospitalNo
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
	 * @param inspectionId
	 *            要设置的 inspectionId
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
	 * @param groupId
	 *            要设置的 groupId
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
	 * @param sampleNumber
	 *            要设置的 sampleNumber
	 */
	public void setSampleNumber(String sampleNumber) {
		this.sampleNumber = sampleNumber;
	}

	/**
	 * @return requisitionId
	 */
	public String getRequisitionId() {
		return requisitionId;
	}

	/**
	 * @param requisitionId
	 *            要设置的 requisitionId
	 */
	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	/**
	 * @return patientType
	 */
	public String getPatientType() {
		return patientType;
	}

	/**
	 * @param patientType
	 *            要设置的 patientType
	 */
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	/**
	 * @return patientId
	 */
	public String getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId 要设置的 patientId
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return inpatientId
	 */
	public String getInpatientId() {
		return inpatientId;
	}

	/**
	 * @param inpatientId
	 *            要设置的 inpatientId
	 */
	public void setInpatientId(String inpatientId) {
		this.inpatientId = inpatientId;
	}

	/**
	 * @return patientNo
	 */
	public Long getPatientNo() {
		return patientNo;
	}

	/**
	 * @param patientNo 要设置的 patientNo
	 */
	public void setPatientNo(Long patientNo) {
		this.patientNo = patientNo;
	}

	/**
	 * @return invoiceId
	 */
	public String getInvoiceId() {
		return invoiceId;
	}

	/**
	 * @param invoiceId
	 *            要设置的 invoiceId
	 */
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	/**
	 * @return chargeType
	 */
	public String getChargeType() {
		return chargeType;
	}

	/**
	 * @param chargeType
	 *            要设置的 chargeType
	 */
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	/**
	 * @return patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName
	 *            要设置的 patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * @return patientSex
	 */
	public String getPatientSex() {
		return patientSex;
	}

	/**
	 * @param patientSex
	 *            要设置的 patientSex
	 */
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}

	/**
	 * @return ageType
	 */
	public String getAgeType() {
		return ageType;
	}

	/**
	 * @param ageType
	 *            要设置的 ageType
	 */
	public void setAgeType(String ageType) {
		this.ageType = ageType;
	}

	/**
	 * @return ageInput
	 */
	public String getAgeInput() {
		return ageInput;
	}

	/**
	 * @param ageInput
	 *            要设置的 ageInput
	 */
	public void setAgeInput(String ageInput) {
		this.ageInput = ageInput;
	}

	/**
	 * @return ageSave
	 */
	public Long getAgeSave() {
		return ageSave;
	}

	/**
	 * @param ageSave
	 *            要设置的 ageSave
	 */
	public void setAgeSave(Long ageSave) {
		this.ageSave = ageSave;
	}

	/**
	 * @return patientNation
	 */
	public String getPatientNation() {
		return patientNation;
	}

	/**
	 * @param patientNation
	 *            要设置的 patientNation
	 */
	public void setPatientNation(String patientNation) {
		this.patientNation = patientNation;
	}

	/**
	 * @return patientNationName
	 */
	public String getPatientNationName() {
		return patientNationName;
	}

	/**
	 * @param patientNationName
	 *            要设置的 patientNationName
	 */
	public void setPatientNationName(String patientNationName) {
		this.patientNationName = patientNationName;
	}

	/**
	 * @return bloodtypeAbo
	 */
	public String getBloodtypeAbo() {
		return bloodtypeAbo;
	}

	/**
	 * @param bloodtypeAbo
	 *            要设置的 bloodtypeAbo
	 */
	public void setBloodtypeAbo(String bloodtypeAbo) {
		this.bloodtypeAbo = bloodtypeAbo;
	}

	/**
	 * @return bloodtypeRh
	 */
	public String getBloodtypeRh() {
		return bloodtypeRh;
	}

	/**
	 * @param bloodtypeRh
	 *            要设置的 bloodtypeRh
	 */
	public void setBloodtypeRh(String bloodtypeRh) {
		this.bloodtypeRh = bloodtypeRh;
	}

	/**
	 * @return patientDept
	 */
	public String getPatientDept() {
		return patientDept;
	}

	/**
	 * @param patientDept
	 *            要设置的 patientDept
	 */
	public void setPatientDept(String patientDept) {
		this.patientDept = patientDept;
	}

	/**
	 * @return patientDeptName
	 */
	public String getPatientDeptName() {
		return patientDeptName;
	}

	/**
	 * @param patientDeptName
	 *            要设置的 patientDeptName
	 */
	public void setPatientDeptName(String patientDeptName) {
		this.patientDeptName = patientDeptName;
	}

	/**
	 * @return patientWard
	 */
	public String getPatientWard() {
		return patientWard;
	}

	/**
	 * @param patientWard
	 *            要设置的 patientWard
	 */
	public void setPatientWard(String patientWard) {
		this.patientWard = patientWard;
	}

	/**
	 * @return patientWardName
	 */
	public String getPatientWardName() {
		return patientWardName;
	}

	/**
	 * @param patientWardName
	 *            要设置的 patientWardName
	 */
	public void setPatientWardName(String patientWardName) {
		this.patientWardName = patientWardName;
	}

	/**
	 * @return patientBed
	 */
	public String getPatientBed() {
		return patientBed;
	}

	/**
	 * @param patientBed
	 *            要设置的 patientBed
	 */
	public void setPatientBed(String patientBed) {
		this.patientBed = patientBed;
	}

	/**
	 * @return especialCondition
	 */
	public String getEspecialCondition() {
		return especialCondition;
	}

	/**
	 * @param especialCondition
	 *            要设置的 especialCondition
	 */
	public void setEspecialCondition(String especialCondition) {
		this.especialCondition = especialCondition;
	}

	/**
	 * @return clinicalDiagnoses
	 */
	public String getClinicalDiagnoses() {
		return clinicalDiagnoses;
	}

	/**
	 * @param clinicalDiagnoses
	 *            要设置的 clinicalDiagnoses
	 */
	public void setClinicalDiagnoses(String clinicalDiagnoses) {
		this.clinicalDiagnoses = clinicalDiagnoses;
	}

	/**
	 * @return clinicalDiagnosesName
	 */
	public String getClinicalDiagnosesName() {
		return clinicalDiagnosesName;
	}

	/**
	 * @param clinicalDiagnosesName
	 *            要设置的 clinicalDiagnosesName
	 */
	public void setClinicalDiagnosesName(String clinicalDiagnosesName) {
		this.clinicalDiagnosesName = clinicalDiagnosesName;
	}

	/**
	 * @return sampleClass
	 */
	public String getSampleClass() {
		return sampleClass;
	}

	/**
	 * @param sampleClass
	 *            要设置的 sampleClass
	 */
	public void setSampleClass(String sampleClass) {
		this.sampleClass = sampleClass;
	}

	/**
	 * @return sampleClassName
	 */
	public String getSampleClassName() {
		return sampleClassName;
	}

	/**
	 * @param sampleClassName
	 *            要设置的 sampleClassName
	 */
	public void setSampleClassName(String sampleClassName) {
		this.sampleClassName = sampleClassName;
	}

	/**
	 * @return infectStatus
	 */
	public String getInfectStatus() {
		return infectStatus;
	}

	/**
	 * @param infectStatus
	 *            要设置的 infectStatus
	 */
	public void setInfectStatus(String infectStatus) {
		this.infectStatus = infectStatus;
	}

	/**
	 * @return sampleStatus
	 */
	public String getSampleStatus() {
		return sampleStatus;
	}

	/**
	 * @param sampleStatus
	 *            要设置的 sampleStatus
	 */
	public void setSampleStatus(String sampleStatus) {
		this.sampleStatus = sampleStatus;
	}

	/**
	 * @return sampleStatusName
	 */
	public String getSampleStatusName() {
		return sampleStatusName;
	}

	/**
	 * @param sampleStatusName
	 *            要设置的 sampleStatusName
	 */
	public void setSampleStatusName(String sampleStatusName) {
		this.sampleStatusName = sampleStatusName;
	}

	/**
	 * @return samplingPosition
	 */
	public String getSamplingPosition() {
		return samplingPosition;
	}

	/**
	 * @param samplingPosition
	 *            要设置的 samplingPosition
	 */
	public void setSamplingPosition(String samplingPosition) {
		this.samplingPosition = samplingPosition;
	}

	/**
	 * @return samplingPositionName
	 */
	public String getSamplingPositionName() {
		return samplingPositionName;
	}

	/**
	 * @param samplingPositionName
	 *            要设置的 samplingPositionName
	 */
	public void setSamplingPositionName(String samplingPositionName) {
		this.samplingPositionName = samplingPositionName;
	}

	/**
	 * @return testOrder
	 */
	public String getTestOrder() {
		return testOrder;
	}

	/**
	 * @param testOrder
	 *            要设置的 testOrder
	 */
	public void setTestOrder(String testOrder) {
		this.testOrder = testOrder;
	}

	/**
	 * @return testOrderName
	 */
	public String getTestOrderName() {
		return testOrderName;
	}

	/**
	 * @param testOrderName
	 *            要设置的 testOrderName
	 */
	public void setTestOrderName(String testOrderName) {
		this.testOrderName = testOrderName;
	}

	/**
	 * @return sampleCharge
	 */
	public BigDecimal getSampleCharge() {
		return sampleCharge;
	}

	/**
	 * @param sampleCharge
	 *            要设置的 sampleCharge
	 */
	public void setSampleCharge(BigDecimal sampleCharge) {
		this.sampleCharge = sampleCharge;
	}

	/**
	 * @return itemCount
	 */
	public Long getItemCount() {
		return itemCount;
	}

	/**
	 * @param itemCount
	 *            要设置的 itemCount
	 */
	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}

	/**
	 * @return workload
	 */
	public Long getWorkload() {
		return workload;
	}

	/**
	 * @param workload
	 *            要设置的 workload
	 */
	public void setWorkload(Long workload) {
		this.workload = workload;
	}

	/**
	 * @return samplingTime
	 */
	public Date getSamplingTime() {
		return samplingTime;
	}

	/**
	 * @param samplingTime
	 *            要设置的 samplingTime
	 */
	public void setSamplingTime(Date samplingTime) {
		this.samplingTime = samplingTime;
	}

	/**
	 * @return samplingPerson
	 */
	public String getSamplingPerson() {
		return samplingPerson;
	}

	/**
	 * @param samplingPerson
	 *            要设置的 samplingPerson
	 */
	public void setSamplingPerson(String samplingPerson) {
		this.samplingPerson = samplingPerson;
	}

	/**
	 * @return requisitionTime
	 */
	public Date getRequisitionTime() {
		return requisitionTime;
	}

	/**
	 * @param requisitionTime
	 *            要设置的 requisitionTime
	 */
	public void setRequisitionTime(Date requisitionTime) {
		this.requisitionTime = requisitionTime;
	}

	/**
	 * @return requisitionPerson
	 */
	public String getRequisitionPerson() {
		return requisitionPerson;
	}

	/**
	 * @param requisitionPerson
	 *            要设置的 requisitionPerson
	 */
	public void setRequisitionPerson(String requisitionPerson) {
		this.requisitionPerson = requisitionPerson;
	}

	/**
	 * @return deliverHospital
	 */
	public String getDeliverHospital() {
		return deliverHospital;
	}

	/**
	 * @param deliverHospital
	 *            要设置的 deliverHospital
	 */
	public void setDeliverHospital(String deliverHospital) {
		this.deliverHospital = deliverHospital;
	}

	/**
	 * @return inceptTime
	 */
	public Date getInceptTime() {
		return inceptTime;
	}

	/**
	 * @param inceptTime
	 *            要设置的 inceptTime
	 */
	public void setInceptTime(Date inceptTime) {
		this.inceptTime = inceptTime;
	}

	/**
	 * @return inceptPerson
	 */
	public String getInceptPerson() {
		return inceptPerson;
	}

	/**
	 * @param inceptPerson
	 *            要设置的 inceptPerson
	 */
	public void setInceptPerson(String inceptPerson) {
		this.inceptPerson = inceptPerson;
	}

	/**
	 * @return inputPerson
	 */
	public String getInputPerson() {
		return inputPerson;
	}

	/**
	 * @param inputPerson
	 *            要设置的 inputPerson
	 */
	public void setInputPerson(String inputPerson) {
		this.inputPerson = inputPerson;
	}

	/**
	 * @return inputTime
	 */
	public Date getInputTime() {
		return inputTime;
	}

	/**
	 * @param inputTime
	 *            要设置的 inputTime
	 */
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	/**
	 * @return inspectionPerson
	 */
	public String getInspectionPerson() {
		return inspectionPerson;
	}

	/**
	 * @param inspectionPerson
	 *            要设置的 inspectionPerson
	 */
	public void setInspectionPerson(String inspectionPerson) {
		this.inspectionPerson = inspectionPerson;
	}

	/**
	 * @return checkPerson
	 */
	public String getCheckPerson() {
		return checkPerson;
	}

	/**
	 * @param checkPerson
	 *            要设置的 checkPerson
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
	 * @param checkTime
	 *            要设置的 checkTime
	 */
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * @return printPerson
	 */
	public String getPrintPerson() {
		return printPerson;
	}

	/**
	 * @param printPerson
	 *            要设置的 printPerson
	 */
	public void setPrintPerson(String printPerson) {
		this.printPerson = printPerson;
	}

	/**
	 * @return printTime
	 */
	public Date getPrintTime() {
		return printTime;
	}

	/**
	 * @param printTime
	 *            要设置的 printTime
	 */
	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}

	/**
	 * @return printCount
	 */
	public BigDecimal getPrintCount() {
		return printCount;
	}

	/**
	 * @param printCount
	 *            要设置的 printCount
	 */
	public void setPrintCount(BigDecimal printCount) {
		this.printCount = printCount;
	}

	/**
	 * @return expertRule
	 */
	public String getExpertRule() {
		return expertRule;
	}

	/**
	 * @param expertRule
	 *            要设置的 expertRule
	 */
	public void setExpertRule(String expertRule) {
		this.expertRule = expertRule;
	}

	/**
	 * @return idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard
	 *            要设置的 idCard
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return chargeState
	 */
	public String getChargeState() {
		return chargeState;
	}

	/**
	 * @param chargeState
	 *            要设置的 chargeState
	 */
	public void setChargeState(String chargeState) {
		this.chargeState = chargeState;
	}

	/**
	 * @return inspectionState
	 */
	public String getInspectionState() {
		return inspectionState;
	}

	/**
	 * @param inspectionState
	 *            要设置的 inspectionState
	 */
	public void setInspectionState(String inspectionState) {
		this.inspectionState = inspectionState;
	}

	/**
	 * @return readState
	 */
	public String getReadState() {
		return readState;
	}

	/**
	 * @param readState
	 *            要设置的 readState
	 */
	public void setReadState(String readState) {
		this.readState = readState;
	}

	/**
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            要设置的 remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return remarkName
	 */
	public String getRemarkName() {
		return remarkName;
	}

	/**
	 * @param remarkName
	 *            要设置的 remarkName
	 */
	public void setRemarkName(String remarkName) {
		this.remarkName = remarkName;
	}

	/**
	 * @return confirmTime
	 */
	public Date getConfirmTime() {
		return confirmTime;
	}

	/**
	 * @param confirmTime
	 *            要设置的 confirmTime
	 */
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	/**
	 * @return confirmPerson
	 */
	public String getConfirmPerson() {
		return confirmPerson;
	}

	/**
	 * @param confirmPerson
	 *            要设置的 confirmPerson
	 */
	public void setConfirmPerson(String confirmPerson) {
		this.confirmPerson = confirmPerson;
	}

	/**
	 * @return patientTypeOld
	 */
	public String getPatientTypeOld() {
		return patientTypeOld;
	}

	/**
	 * @param patientTypeOld
	 *            要设置的 patientTypeOld
	 */
	public void setPatientTypeOld(String patientTypeOld) {
		this.patientTypeOld = patientTypeOld;
	}

	/**
	 * @return instrument
	 */
	public String getInstrument() {
		return instrument;
	}

	/**
	 * @param instrument
	 *            要设置的 instrument
	 */
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	/**
	 * @return mobileno
	 */
	public String getMobileno() {
		return mobileno;
	}

	/**
	 * @param mobileno
	 *            要设置的 mobileno
	 */
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	/**
	 * @return sendState
	 */
	public String getSendState() {
		return sendState;
	}

	/**
	 * @param sendState
	 *            要设置的 sendState
	 */
	public void setSendState(String sendState) {
		this.sendState = sendState;
	}

	/**
	 * @return sendDate
	 */
	public String getSendDate() {
		return sendDate;
	}

	/**
	 * @param sendDate
	 *            要设置的 sendDate
	 */
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	/**
	 * @return patientBirthday
	 */
	public String getPatientBirthday() {
		return patientBirthday;
	}

	/**
	 * @param patientBirthday
	 *            要设置的 patientBirthday
	 */
	public void setPatientBirthday(String patientBirthday) {
		this.patientBirthday = patientBirthday;
	}

	/**
	 * @return bloodOrder
	 */
	public String getBloodOrder() {
		return bloodOrder;
	}

	/**
	 * @param bloodOrder
	 *            要设置的 bloodOrder
	 */
	public void setBloodOrder(String bloodOrder) {
		this.bloodOrder = bloodOrder;
	}

	/**
	 * @return bloodMode
	 */
	public String getBloodMode() {
		return bloodMode;
	}

	/**
	 * @param bloodMode
	 *            要设置的 bloodMode
	 */
	public void setBloodMode(String bloodMode) {
		this.bloodMode = bloodMode;
	}

	/**
	 * @return readDoctor
	 */
	public String getReadDoctor() {
		return readDoctor;
	}

	/**
	 * @param readDoctor
	 *            要设置的 readDoctor
	 */
	public void setReadDoctor(String readDoctor) {
		this.readDoctor = readDoctor;
	}

	/**
	 * @return readTime
	 */
	public String getReadTime() {
		return readTime;
	}

	/**
	 * @param readTime
	 *            要设置的 readTime
	 */
	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}

	/**
	 * @return checkTempTime
	 */
	public Date getCheckTempTime() {
		return checkTempTime;
	}

	/**
	 * @param checkTempTime
	 *            要设置的 checkTempTime
	 */
	public void setCheckTempTime(Date checkTempTime) {
		this.checkTempTime = checkTempTime;
	}

	/**
	 * @return inspectiontime
	 */
	public Date getInspectiontime() {
		return inspectiontime;
	}

	/**
	 * @param inspectiontime
	 *            要设置的 inspectiontime
	 */
	public void setInspectiontime(Date inspectiontime) {
		this.inspectiontime = inspectiontime;
	}

	/**
	 * @return bloodOutputPrintTime
	 */
	public Date getBloodOutputPrintTime() {
		return bloodOutputPrintTime;
	}

	/**
	 * @param bloodOutputPrintTime
	 *            要设置的 bloodOutputPrintTime
	 */
	public void setBloodOutputPrintTime(Date bloodOutputPrintTime) {
		this.bloodOutputPrintTime = bloodOutputPrintTime;
	}

	/**
	 * @return receivePerson
	 */
	public String getReceivePerson() {
		return receivePerson;
	}

	/**
	 * @param receivePerson
	 *            要设置的 receivePerson
	 */
	public void setReceivePerson(String receivePerson) {
		this.receivePerson = receivePerson;
	}

	/**
	 * @return resultInceptState
	 */
	public String getResultInceptState() {
		return resultInceptState;
	}

	/**
	 * @param resultInceptState
	 *            要设置的 resultInceptState
	 */
	public void setResultInceptState(String resultInceptState) {
		this.resultInceptState = resultInceptState;
	}

	/**
	 * @return policeState
	 */
	public String getPoliceState() {
		return policeState;
	}

	/**
	 * @param policeState
	 *            要设置的 policeState
	 */
	public void setPoliceState(String policeState) {
		this.policeState = policeState;
	}

	/**
	 * @return policePerson
	 */
	public String getPolicePerson() {
		return policePerson;
	}

	/**
	 * @param policePerson
	 *            要设置的 policePerson
	 */
	public void setPolicePerson(String policePerson) {
		this.policePerson = policePerson;
	}

	/**
	 * @return policeTime
	 */
	public Date getPoliceTime() {
		return policeTime;
	}

	/**
	 * @param policeTime
	 *            要设置的 policeTime
	 */
	public void setPoliceTime(Date policeTime) {
		this.policeTime = policeTime;
	}

	/**
	 * @return policeMinute
	 */
	public Long getPoliceMinute() {
		return policeMinute;
	}

	/**
	 * @param policeMinute
	 *            要设置的 policeMinute
	 */
	public void setPoliceMinute(Long policeMinute) {
		this.policeMinute = policeMinute;
	}

	/**
	 * @return readedState
	 */
	public String getReadedState() {
		return readedState;
	}

	/**
	 * @param readedState
	 *            要设置的 readedState
	 */
	public void setReadedState(String readedState) {
		this.readedState = readedState;
	}

	/**
	 * @return auditedPerson
	 */
	public String getAuditedPerson() {
		return auditedPerson;
	}

	/**
	 * @param auditedPerson
	 *            要设置的 auditedPerson
	 */
	public void setAuditedPerson(String auditedPerson) {
		this.auditedPerson = auditedPerson;
	}

	/**
	 * @return auditedTime
	 */
	public Date getAuditedTime() {
		return auditedTime;
	}

	/**
	 * @param auditedTime
	 *            要设置的 auditedTime
	 */
	public void setAuditedTime(Date auditedTime) {
		this.auditedTime = auditedTime;
	}

    /**
     * @return the diagnosisFlag
     */
    public String getDiagnosisFlag() {
        return diagnosisFlag;
    }

    /**
     * @param diagnosisFlag the diagnosisFlag to set
     */
    public void setDiagnosisFlag(String diagnosisFlag) {
        this.diagnosisFlag = diagnosisFlag;
    }
	
}
