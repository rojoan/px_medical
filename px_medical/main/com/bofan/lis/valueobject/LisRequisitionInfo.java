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
 * @Description: lis_requisition_info（申请单病人信息表）
 * @author lqw
 * @date 2017-10-09
 */
@Entity
@Table(name = "LIS_REQUISITION_INFO", schema = SchemaConsts.LIS_CLOUD)
@SequenceGenerator(name = "LIS_REQUISITION_INFO_ID", sequenceName = SchemaConsts.LIS_CLOUD + ".LIS_REQUISITION_INFO_ID", allocationSize=1)
public class LisRequisitionInfo {

	// Fields
	/**	申请单病人信息ID，自动增长ID	*/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIS_REQUISITION_INFO_ID")
	@Column(name = "LIS_REQUISITION_INFO_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long lisRequisitionInfoId;
	
	/**	医院（医疗机构）标识	对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/**	申请单ID，原主键ID	*/
	@Column(name = "REQUISITION_ID", nullable = false, length = 20)
	private String requisitionId;
	
	/**	病人类别	*/
	@Column(name = "PATIENT_TYPE", length = 20)
	private String patientType;
	
	/** 病员号，即 病员ID */
	@Column(name = "PATIENT_ID", length = 50)
	private String patientId;
	
	/** 病人唯一号，即 门诊/住院流水号 */
	@Column(name = "INPATIENT_ID", length = 50)
	private String inpatientId;
	
	/**	收费类别	*/
	@Column(name = "CHARGE_TYPE", length = 20)
	private String chargeType;
	
	/**	病人名称	*/
	@Column(name = "PATIENT_NAME", length = 50)
	private String patientName;
	
	/**	病人性别	*/
	@Column(name = "PATIENT_SEX", length = 2)
	private String patientSex;
	
	/**	病人年龄	*/
	@Column(name = "PATIENT_AGE", length = 20)
	private String patientAge;
	
	/**	病人民族	*/
	@Column(name = "PATIENT_NATION", length = 20)
	private String patientNation;
	
	/**	ABO血型	*/
	@Column(name = "BLOODTYPE_ABO", length = 20)
	private String bloodtypeAbo;
	
	/**	RH血型	*/
	@Column(name = "BLOODTYPE_RH", length = 20)
	private String bloodtypeRh;
	
	/**	病人科别	*/
	@Column(name = "PATIENT_DEPT", length = 20)
	private String patientDept;
	
	/**	病人病区	*/
	@Column(name = "PATIENT_WARD", length = 20)
	private String patientWard;
	
	/**	病人床号	*/
	@Column(name = "PATIENT_BED", length = 20)
	private String patientBed;
	
	/**	特殊条件	*/
	@Column(name = "ESPECIAL_CONDITION", length = 20)
	private String especialCondition;
	
	/**	检验信息	*/
	@Column(name = "INSPECTED_INFO", length = 100)
	private String inspectedInfo;
	
	/**	传染标记	*/
	@Column(name = "INFECTION", length = 50)
	private String infection;
	
	/**	临床诊断	*/
	@Column(name = "CLINICAL_DIAGNOSES", length = 100)
	private String clinicalDiagnoses;
	
	/**	medical_record	*/
	@Column(name = "MEDICAL_RECORD", length = 200)
	private String medicalRecord;
	
	/**	送检单位	*/
	@Column(name = "DELIVER_HOSPITAL", length = 50)
	private String deliverHospital;
	
	/**	requisition_from	*/
	@Column(name = "REQUISITION_FROM", length = 50)
	private String requisitionFrom;
	
	/**	申请科室	*/
	@Column(name = "REQUISITION_DEPT", length = 20)
	private String requisitionDept;
	
	/**	申请时间	*/
	@Column(name = "REQUISITION_TIME")
	private Date requisitionTime;
	
	/**	申请人员	*/
	@Column(name = "REQUISITION_PERSON", length = 20)
	private String requisitionPerson;
	
	/**	咨询科室	*/
	@Column(name = "EXECUTE_DEPT", length = 20)
	private String executeDept;
	
	/**	执行时间	*/
	@Column(name = "EXECUTE_TIME")
	private Date executeTime;
	
	/**	执行人员	*/
	@Column(name = "EXECUTE_PERSON", length = 20)
	private String executePerson;
	
	/**	打印科室	*/
	@Column(name = "PRINT_DEPT", length = 20)
	private String printDept;
	
	/**	打印时间	*/
	@Column(name = "PRINT_TIME")
	private Date printTime;
	
	/**	打印人员	*/
	@Column(name = "PRINT_PERSON", length = 20)
	private String printPerson;
	
	/**	样本类型	*/
	@Column(name = "SAMPLE_CLASS", length = 20)
	private String sampleClass;
	
	/**	标本位置	*/
	@Column(name = "SAMPLING_POSITION", length = 50)
	private String samplingPosition;
	
	/**	采样科室	*/
	@Column(name = "SAMPLING_DEPT", length = 20)
	private String samplingDept;
	
	/**	采样时间	*/
	@Column(name = "SAMPLING_TIME")
	private Date samplingTime;
	
	/**	采样人员	*/
	@Column(name = "SAMPLING_PERSON", length = 20)
	private String samplingPerson;
	
	/**	接收科室	*/
	@Column(name = "RECEIVE_DEPT", length = 20)
	private String receiveDept;
	
	/**	接收时间	*/
	@Column(name = "RECEIVE_TIME")
	private Date receiveTime;
	
	/**	接收人员	*/
	@Column(name = "RECEIVE_PERSON", length = 20)
	private String receivePerson;
	
	/**	流转科室	*/
	@Column(name = "LIST_DEPT", length = 20)
	private String listDept;
	
	/**	流转时间	*/
	@Column(name = "LIST_TIME")
	private Date listTime;
	
	/**	流转人员	*/
	@Column(name = "LIST_PERSON", length = 20)
	private String listPerson;
	
	/**	发送科室	*/
	@Column(name = "SEND_DEPT", length = 20)
	private String sendDept;
	
	/**	发送时间	*/
	@Column(name = "SEND_TIME")
	private Date sendTime;
	
	/**	发送人员	*/
	@Column(name = "SEND_PERSON", length = 20)
	private String sendPerson;
	
	/**	位置1	*/
	@Column(name = "POSITION_ONE", length = 20)
	private String positionOne;
	
	/**	位置2	*/
	@Column(name = "POSITION_TWO", length = 20)
	private String positionTwo;
	
	/**	"申请单状态 deleted=已删除  inspecting=正在检验  printed=已打印  received=已接收  reported=已报告  returned=已退回  samplinged=已采样 */
	@Column(name = "REQUISITION_STATE", length = 10)
	private String requisitionState;
	
	/**	备注	*/
	@Column(name = "REMARK", length = 200)
	private String remark;
	
	/**	his代码	*/
	@Column(name = "HIS_ID", length = 50)
	private String hisId;
	
	/**	身份证号	*/
	@Column(name = "ID_CARD", length = 30)
	private String idCard;
	
	/**	退回人员	*/
	@Column(name = "RETURN_PERSON", length = 20)
	private String returnPerson;
	
	/**	退回时间	*/
	@Column(name = "RETURN_TIME")
	private Date returnTime;
	
	/**	退回原因	*/
	@Column(name = "RETURN_CAUSE", length = 100)
	private String returnCause;
	
	/**	退回接收人员	*/
	@Column(name = "RETURN_ACCEPT_PERSON", length = 20)
	private String returnAcceptPerson;
	
	/**	退回方法	*/
	@Column(name = "RETURN_METHOD", length = 50)
	private String returnMethod;
	
	/**	退回原因说明	*/
	@Column(name = "RETURN_ACCEPT_REMARK", length = 50)
	private String returnAcceptRemark;
	
	/**	旧病人类型	*/
	@Column(name = "PATIENT_TYPE_OLD", length = 20)
	private String patientTypeOld;
	
	/**	病人科别名称	*/
	@Column(name = "PATIENT_DEPT_NAME", length = 50)
	private String patientDeptName;
	
	/**	病人病区名称	*/
	@Column(name = "PATIENT_WARD_NAME", length = 50)
	private String patientWardName;
	
	/**	申请人	*/
	@Column(name = "REQUISITION_PERSON_NAME", length = 50)
	private String requisitionPersonName;
	
	/**	申请日期	*/
	@Column(name = "INSPECTION_DATE", length = 8)
	private String inspectionDate;
	
	/**	检验目的	*/
	@Column(name = "TEST_ORDER_NAME")
	private String testOrderName;
	
	/**	金额	*/
	@Column(name = "CHARGE", precision = 10)
	private BigDecimal charge; 
	
	/**	采样时间2	*/
	@Column(name = "SAMPLING_TIME_TWO")
	private Date samplingTimeTwo;
	
	/**	mobile_no	*/
	@Column(name = "MOBILE_NO", length = 50)
	private String mobileNo;
	
	/**	queue_numbe	*/
	@Column(name = "QUEUE_NUMBE", length = 20)
	private String queueNumbe;
	
	/**	queue_number	*/
	@Column(name = "QUEUE_NUMBER", length = 20)
	private String queueNumber;
	
	/**	patient_birthday	*/	
	@Column(name = "PATIENT_BIRTHDAY", length = 20)
	private String patientBirthday;
	
	/**	queue_state	*/
	@Column(name = "QUEUE_STATE", length = 10)
	private String queueState;
	
	/**	条码科室	*/
	@Column(name = "BARCODE_DEPT", length = 20)
	private String barcodeDept;

	// Constructors

	/** default constructor */
	public LisRequisitionInfo() {
	}

	/**
	 * @return lisRequisitionInfoId
	 */
	public Long getLisRequisitionInfoId() {
		return lisRequisitionInfoId;
	}

	/**
	 * @param lisRequisitionInfoId 要设置的 lisRequisitionInfoId
	 */
	public void setLisRequisitionInfoId(Long lisRequisitionInfoId) {
		this.lisRequisitionInfoId = lisRequisitionInfoId;
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
	 * @return requisitionId
	 */
	public String getRequisitionId() {
		return requisitionId;
	}

	/**
	 * @param requisitionId 要设置的 requisitionId
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
	 * @param patientType 要设置的 patientType
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
	 * @param inpatientId 要设置的 inpatientId
	 */
	public void setInpatientId(String inpatientId) {
		this.inpatientId = inpatientId;
	}

	/**
	 * @return chargeType
	 */
	public String getChargeType() {
		return chargeType;
	}

	/**
	 * @param chargeType 要设置的 chargeType
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
	 * @param patientName 要设置的 patientName
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
	 * @param patientSex 要设置的 patientSex
	 */
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}

	/**
	 * @return patientAge
	 */
	public String getPatientAge() {
		return patientAge;
	}

	/**
	 * @param patientAge 要设置的 patientAge
	 */
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	/**
	 * @return patientNation
	 */
	public String getPatientNation() {
		return patientNation;
	}

	/**
	 * @param patientNation 要设置的 patientNation
	 */
	public void setPatientNation(String patientNation) {
		this.patientNation = patientNation;
	}

	/**
	 * @return bloodtypeAbo
	 */
	public String getBloodtypeAbo() {
		return bloodtypeAbo;
	}

	/**
	 * @param bloodtypeAbo 要设置的 bloodtypeAbo
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
	 * @param bloodtypeRh 要设置的 bloodtypeRh
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
	 * @param patientDept 要设置的 patientDept
	 */
	public void setPatientDept(String patientDept) {
		this.patientDept = patientDept;
	}

	/**
	 * @return patientWard
	 */
	public String getPatientWard() {
		return patientWard;
	}

	/**
	 * @param patientWard 要设置的 patientWard
	 */
	public void setPatientWard(String patientWard) {
		this.patientWard = patientWard;
	}

	/**
	 * @return patientBed
	 */
	public String getPatientBed() {
		return patientBed;
	}

	/**
	 * @param patientBed 要设置的 patientBed
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
	 * @param especialCondition 要设置的 especialCondition
	 */
	public void setEspecialCondition(String especialCondition) {
		this.especialCondition = especialCondition;
	}

	/**
	 * @return inspectedInfo
	 */
	public String getInspectedInfo() {
		return inspectedInfo;
	}

	/**
	 * @param inspectedInfo 要设置的 inspectedInfo
	 */
	public void setInspectedInfo(String inspectedInfo) {
		this.inspectedInfo = inspectedInfo;
	}

	/**
	 * @return infection
	 */
	public String getInfection() {
		return infection;
	}

	/**
	 * @param infection 要设置的 infection
	 */
	public void setInfection(String infection) {
		this.infection = infection;
	}

	/**
	 * @return clinicalDiagnoses
	 */
	public String getClinicalDiagnoses() {
		return clinicalDiagnoses;
	}

	/**
	 * @param clinicalDiagnoses 要设置的 clinicalDiagnoses
	 */
	public void setClinicalDiagnoses(String clinicalDiagnoses) {
		this.clinicalDiagnoses = clinicalDiagnoses;
	}

	/**
	 * @return medicalRecord
	 */
	public String getMedicalRecord() {
		return medicalRecord;
	}

	/**
	 * @param medicalRecord 要设置的 medicalRecord
	 */
	public void setMedicalRecord(String medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	/**
	 * @return deliverHospital
	 */
	public String getDeliverHospital() {
		return deliverHospital;
	}

	/**
	 * @param deliverHospital 要设置的 deliverHospital
	 */
	public void setDeliverHospital(String deliverHospital) {
		this.deliverHospital = deliverHospital;
	}

	/**
	 * @return requisitionFrom
	 */
	public String getRequisitionFrom() {
		return requisitionFrom;
	}

	/**
	 * @param requisitionFrom 要设置的 requisitionFrom
	 */
	public void setRequisitionFrom(String requisitionFrom) {
		this.requisitionFrom = requisitionFrom;
	}

	/**
	 * @return requisitionDept
	 */
	public String getRequisitionDept() {
		return requisitionDept;
	}

	/**
	 * @param requisitionDept 要设置的 requisitionDept
	 */
	public void setRequisitionDept(String requisitionDept) {
		this.requisitionDept = requisitionDept;
	}

	/**
	 * @return requisitionTime
	 */
	public Date getRequisitionTime() {
		return requisitionTime;
	}

	/**
	 * @param requisitionTime 要设置的 requisitionTime
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
	 * @param requisitionPerson 要设置的 requisitionPerson
	 */
	public void setRequisitionPerson(String requisitionPerson) {
		this.requisitionPerson = requisitionPerson;
	}

	/**
	 * @return executeDept
	 */
	public String getExecuteDept() {
		return executeDept;
	}

	/**
	 * @param executeDept 要设置的 executeDept
	 */
	public void setExecuteDept(String executeDept) {
		this.executeDept = executeDept;
	}

	/**
	 * @return executeTime
	 */
	public Date getExecuteTime() {
		return executeTime;
	}

	/**
	 * @param executeTime 要设置的 executeTime
	 */
	public void setExecuteTime(Date executeTime) {
		this.executeTime = executeTime;
	}

	/**
	 * @return executePerson
	 */
	public String getExecutePerson() {
		return executePerson;
	}

	/**
	 * @param executePerson 要设置的 executePerson
	 */
	public void setExecutePerson(String executePerson) {
		this.executePerson = executePerson;
	}

	/**
	 * @return printDept
	 */
	public String getPrintDept() {
		return printDept;
	}

	/**
	 * @param printDept 要设置的 printDept
	 */
	public void setPrintDept(String printDept) {
		this.printDept = printDept;
	}

	/**
	 * @return printTime
	 */
	public Date getPrintTime() {
		return printTime;
	}

	/**
	 * @param printTime 要设置的 printTime
	 */
	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}

	/**
	 * @return printPerson
	 */
	public String getPrintPerson() {
		return printPerson;
	}

	/**
	 * @param printPerson 要设置的 printPerson
	 */
	public void setPrintPerson(String printPerson) {
		this.printPerson = printPerson;
	}

	/**
	 * @return sampleClass
	 */
	public String getSampleClass() {
		return sampleClass;
	}

	/**
	 * @param sampleClass 要设置的 sampleClass
	 */
	public void setSampleClass(String sampleClass) {
		this.sampleClass = sampleClass;
	}

	/**
	 * @return samplingPosition
	 */
	public String getSamplingPosition() {
		return samplingPosition;
	}

	/**
	 * @param samplingPosition 要设置的 samplingPosition
	 */
	public void setSamplingPosition(String samplingPosition) {
		this.samplingPosition = samplingPosition;
	}

	/**
	 * @return samplingDept
	 */
	public String getSamplingDept() {
		return samplingDept;
	}

	/**
	 * @param samplingDept 要设置的 samplingDept
	 */
	public void setSamplingDept(String samplingDept) {
		this.samplingDept = samplingDept;
	}

	/**
	 * @return samplingTime
	 */
	public Date getSamplingTime() {
		return samplingTime;
	}

	/**
	 * @param samplingTime 要设置的 samplingTime
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
	 * @param samplingPerson 要设置的 samplingPerson
	 */
	public void setSamplingPerson(String samplingPerson) {
		this.samplingPerson = samplingPerson;
	}

	/**
	 * @return receiveDept
	 */
	public String getReceiveDept() {
		return receiveDept;
	}

	/**
	 * @param receiveDept 要设置的 receiveDept
	 */
	public void setReceiveDept(String receiveDept) {
		this.receiveDept = receiveDept;
	}

	/**
	 * @return receiveTime
	 */
	public Date getReceiveTime() {
		return receiveTime;
	}

	/**
	 * @param receiveTime 要设置的 receiveTime
	 */
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	/**
	 * @return receivePerson
	 */
	public String getReceivePerson() {
		return receivePerson;
	}

	/**
	 * @param receivePerson 要设置的 receivePerson
	 */
	public void setReceivePerson(String receivePerson) {
		this.receivePerson = receivePerson;
	}

	/**
	 * @return listDept
	 */
	public String getListDept() {
		return listDept;
	}

	/**
	 * @param listDept 要设置的 listDept
	 */
	public void setListDept(String listDept) {
		this.listDept = listDept;
	}

	/**
	 * @return listTime
	 */
	public Date getListTime() {
		return listTime;
	}

	/**
	 * @param listTime 要设置的 listTime
	 */
	public void setListTime(Date listTime) {
		this.listTime = listTime;
	}

	/**
	 * @return listPerson
	 */
	public String getListPerson() {
		return listPerson;
	}

	/**
	 * @param listPerson 要设置的 listPerson
	 */
	public void setListPerson(String listPerson) {
		this.listPerson = listPerson;
	}

	/**
	 * @return sendDept
	 */
	public String getSendDept() {
		return sendDept;
	}

	/**
	 * @param sendDept 要设置的 sendDept
	 */
	public void setSendDept(String sendDept) {
		this.sendDept = sendDept;
	}

	/**
	 * @return sendTime
	 */
	public Date getSendTime() {
		return sendTime;
	}

	/**
	 * @param sendTime 要设置的 sendTime
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * @return sendPerson
	 */
	public String getSendPerson() {
		return sendPerson;
	}

	/**
	 * @param sendPerson 要设置的 sendPerson
	 */
	public void setSendPerson(String sendPerson) {
		this.sendPerson = sendPerson;
	}

	/**
	 * @return positionOne
	 */
	public String getPositionOne() {
		return positionOne;
	}

	/**
	 * @param positionOne 要设置的 positionOne
	 */
	public void setPositionOne(String positionOne) {
		this.positionOne = positionOne;
	}

	/**
	 * @return positionTwo
	 */
	public String getPositionTwo() {
		return positionTwo;
	}

	/**
	 * @param positionTwo 要设置的 positionTwo
	 */
	public void setPositionTwo(String positionTwo) {
		this.positionTwo = positionTwo;
	}

	/**
	 * @return requisitionState
	 */
	public String getRequisitionState() {
		return requisitionState;
	}

	/**
	 * @param requisitionState 要设置的 requisitionState
	 */
	public void setRequisitionState(String requisitionState) {
		this.requisitionState = requisitionState;
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
	 * @return idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard 要设置的 idCard
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return returnPerson
	 */
	public String getReturnPerson() {
		return returnPerson;
	}

	/**
	 * @param returnPerson 要设置的 returnPerson
	 */
	public void setReturnPerson(String returnPerson) {
		this.returnPerson = returnPerson;
	}

	/**
	 * @return returnTime
	 */
	public Date getReturnTime() {
		return returnTime;
	}

	/**
	 * @param returnTime 要设置的 returnTime
	 */
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	/**
	 * @return returnCause
	 */
	public String getReturnCause() {
		return returnCause;
	}

	/**
	 * @param returnCause 要设置的 returnCause
	 */
	public void setReturnCause(String returnCause) {
		this.returnCause = returnCause;
	}

	/**
	 * @return returnAcceptPerson
	 */
	public String getReturnAcceptPerson() {
		return returnAcceptPerson;
	}

	/**
	 * @param returnAcceptPerson 要设置的 returnAcceptPerson
	 */
	public void setReturnAcceptPerson(String returnAcceptPerson) {
		this.returnAcceptPerson = returnAcceptPerson;
	}

	/**
	 * @return returnMethod
	 */
	public String getReturnMethod() {
		return returnMethod;
	}

	/**
	 * @param returnMethod 要设置的 returnMethod
	 */
	public void setReturnMethod(String returnMethod) {
		this.returnMethod = returnMethod;
	}

	/**
	 * @return returnAcceptRemark
	 */
	public String getReturnAcceptRemark() {
		return returnAcceptRemark;
	}

	/**
	 * @param returnAcceptRemark 要设置的 returnAcceptRemark
	 */
	public void setReturnAcceptRemark(String returnAcceptRemark) {
		this.returnAcceptRemark = returnAcceptRemark;
	}

	/**
	 * @return patientTypeOld
	 */
	public String getPatientTypeOld() {
		return patientTypeOld;
	}

	/**
	 * @param patientTypeOld 要设置的 patientTypeOld
	 */
	public void setPatientTypeOld(String patientTypeOld) {
		this.patientTypeOld = patientTypeOld;
	}

	/**
	 * @return patientDeptName
	 */
	public String getPatientDeptName() {
		return patientDeptName;
	}

	/**
	 * @param patientDeptName 要设置的 patientDeptName
	 */
	public void setPatientDeptName(String patientDeptName) {
		this.patientDeptName = patientDeptName;
	}

	/**
	 * @return patientWardName
	 */
	public String getPatientWardName() {
		return patientWardName;
	}

	/**
	 * @param patientWardName 要设置的 patientWardName
	 */
	public void setPatientWardName(String patientWardName) {
		this.patientWardName = patientWardName;
	}

	/**
	 * @return requisitionPersonName
	 */
	public String getRequisitionPersonName() {
		return requisitionPersonName;
	}

	/**
	 * @param requisitionPersonName 要设置的 requisitionPersonName
	 */
	public void setRequisitionPersonName(String requisitionPersonName) {
		this.requisitionPersonName = requisitionPersonName;
	}

	/**
	 * @return inspectionDate
	 */
	public String getInspectionDate() {
		return inspectionDate;
	}

	/**
	 * @param inspectionDate 要设置的 inspectionDate
	 */
	public void setInspectionDate(String inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	/**
	 * @return testOrderName
	 */
	public String getTestOrderName() {
		return testOrderName;
	}

	/**
	 * @param testOrderName 要设置的 testOrderName
	 */
	public void setTestOrderName(String testOrderName) {
		this.testOrderName = testOrderName;
	}

	/**
	 * @return charge
	 */
	public BigDecimal getCharge() {
		return charge;
	}

	/**
	 * @param charge 要设置的 charge
	 */
	public void setCharge(BigDecimal charge) {
		this.charge = charge;
	}

	/**
	 * @return samplingTimeTwo
	 */
	public Date getSamplingTimeTwo() {
		return samplingTimeTwo;
	}

	/**
	 * @param samplingTimeTwo 要设置的 samplingTimeTwo
	 */
	public void setSamplingTimeTwo(Date samplingTimeTwo) {
		this.samplingTimeTwo = samplingTimeTwo;
	}

	/**
	 * @return mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo 要设置的 mobileNo
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return queueNumbe
	 */
	public String getQueueNumbe() {
		return queueNumbe;
	}

	/**
	 * @param queueNumbe 要设置的 queueNumbe
	 */
	public void setQueueNumbe(String queueNumbe) {
		this.queueNumbe = queueNumbe;
	}

	/**
	 * @return queueNumber
	 */
	public String getQueueNumber() {
		return queueNumber;
	}

	/**
	 * @param queueNumber 要设置的 queueNumber
	 */
	public void setQueueNumber(String queueNumber) {
		this.queueNumber = queueNumber;
	}

	/**
	 * @return patientBirthday
	 */
	public String getPatientBirthday() {
		return patientBirthday;
	}

	/**
	 * @param patientBirthday 要设置的 patientBirthday
	 */
	public void setPatientBirthday(String patientBirthday) {
		this.patientBirthday = patientBirthday;
	}

	/**
	 * @return queueState
	 */
	public String getQueueState() {
		return queueState;
	}

	/**
	 * @param queueState 要设置的 queueState
	 */
	public void setQueueState(String queueState) {
		this.queueState = queueState;
	}

	/**
	 * @return barcodeDept
	 */
	public String getBarcodeDept() {
		return barcodeDept;
	}

	/**
	 * @param barcodeDept 要设置的 barcodeDept
	 */
	public void setBarcodeDept(String barcodeDept) {
		this.barcodeDept = barcodeDept;
	}

}