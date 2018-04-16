package com.bofan.his.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: patient_hospital患者医院对应表 查询
 * @author lqw
 */
@SuppressWarnings("serial")
@QueryInfo(from = "com.bofan.his.valueobject.PatientHospital o ", orderBy = "o.patientHospitalId desc")
public class PatientHospitalQueryInfo  extends BaseCommandInfo  {
	
	/** 组织机构（医院单位）ID 对应sys_org表中，医院编码（标识）对应的单位ID **/
	@QueryParam(fieldName = "o.orgId", op = QueryOperator.EQU)
	private Long orgId;
	
	/** 患者主键ID **/
	@QueryParam(fieldName = "o.patientId", op = QueryOperator.EQU)
	private Long patientId;
	
	/** 病人名称 **/
	@QueryParam(fieldName = "o.patientName", op = QueryOperator.LIKE)
	private String patientName;
	
	/** 患者院内档案ID（HIS系统） */
	@QueryParam(fieldName = "o.patientNo", op = QueryOperator.EQU)
	private Long patientNo;

	/** 证件号码 **/
	@QueryParam(fieldName = "o.patientIdCard", op = QueryOperator.LIKE)
	private String patientIdCard;
	
	/** 证件号码  精确查询**/
	@QueryParam(fieldName = "o.patientIdCard", op = QueryOperator.EQU)
	private String patientIdCardEqu;
	
	/** 医/农保证号 **/
	@QueryParam(fieldName = "o.insuranceNo", op = QueryOperator.LIKE)
	private String insuranceNo;

	/** 医/农保证号  精确查询**/
	@QueryParam(fieldName = "o.insuranceNo", op = QueryOperator.EQU)
	private String insuranceNoEqu;
	
	/** 就诊卡号 **/
	@QueryParam(fieldName = "o.patientCardNo", op = QueryOperator.LIKE)
	private String patientCardNo;
	
	/** 就诊卡号  精确查询**/
	@QueryParam(fieldName = "o.patientCardNo", op = QueryOperator.EQU)
	private String patientCardNoEqu;
	
	/** 电话 **/
	@QueryParam(fieldName = "o.patientPhone", op = QueryOperator.LIKE)
	private String patientPhone;
	
	/** 医院编码 **/
	@QueryParam(fieldName = "o.hospitalNo", op = QueryOperator.EQU)
	private String hospitalNo;
	
	/** 是否有效 1：有效 0：无效 */
	@QueryParam(fieldName = "o.validFlag", op = QueryOperator.EQU)
	private String validFlag ;

	/**
	 * defalult constructor
	 */
	public PatientHospitalQueryInfo() {
	}

	/**
	 * @param patientId
	 * @param patientNo
	 */
	public PatientHospitalQueryInfo(Long patientId, Long patientNo) {
		this.patientId = patientId;
		this.patientNo = patientNo;
	}
	
	/**
	 * @param orgId
	 * @param patientIdCardEqu
	 * @param validFlag
	 */
	public PatientHospitalQueryInfo(Long orgId, String patientIdCardEqu, String validFlag) {
		this.orgId = orgId;
		this.patientIdCardEqu = patientIdCardEqu;
		this.validFlag = validFlag;
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
	 * @return patientId
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId 要设置的 patientId
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
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
	 * @return patientIdCard
	 */
	public String getPatientIdCard() {
		return patientIdCard;
	}

	/**
	 * @param patientIdCard 要设置的 patientIdCard
	 */
	public void setPatientIdCard(String patientIdCard) {
		this.patientIdCard = patientIdCard;
	}

	/**
	 * @return patientIdCardEqu
	 */
	public String getPatientIdCardEqu() {
		return patientIdCardEqu;
	}

	/**
	 * @param patientIdCardEqu 要设置的 patientIdCardEqu
	 */
	public void setPatientIdCardEqu(String patientIdCardEqu) {
		this.patientIdCardEqu = patientIdCardEqu;
	}

	/**
	 * @return insuranceNo
	 */
	public String getInsuranceNo() {
		return insuranceNo;
	}

	/**
	 * @param insuranceNo 要设置的 insuranceNo
	 */
	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	/**
	 * @return insuranceNoEqu
	 */
	public String getInsuranceNoEqu() {
		return insuranceNoEqu;
	}

	/**
	 * @param insuranceNoEqu 要设置的 insuranceNoEqu
	 */
	public void setInsuranceNoEqu(String insuranceNoEqu) {
		this.insuranceNoEqu = insuranceNoEqu;
	}

	/**
	 * @return patientCardNo
	 */
	public String getPatientCardNo() {
		return patientCardNo;
	}

	/**
	 * @param patientCardNo 要设置的 patientCardNo
	 */
	public void setPatientCardNo(String patientCardNo) {
		this.patientCardNo = patientCardNo;
	}

	/**
	 * @return patientCardNoEqu
	 */
	public String getPatientCardNoEqu() {
		return patientCardNoEqu;
	}

	/**
	 * @param patientCardNoEqu 要设置的 patientCardNoEqu
	 */
	public void setPatientCardNoEqu(String patientCardNoEqu) {
		this.patientCardNoEqu = patientCardNoEqu;
	}

	/**
	 * @return patientPhone
	 */
	public String getPatientPhone() {
		return patientPhone;
	}

	/**
	 * @param patientPhone 要设置的 patientPhone
	 */
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
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