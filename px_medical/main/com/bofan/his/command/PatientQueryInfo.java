package com.bofan.his.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 患者信息表查询
 * @author lqw
 */
@SuppressWarnings("serial")
@QueryInfo(from = "com.bofan.his.valueobject.Patient", orderBy = "patientId asc")
public class PatientQueryInfo extends BaseCommandInfo  {

	/** 组织机构（医院单位）ID 对应sys_org表中，医院编码（标识）对应的单位ID **/
	@QueryParam(fieldName = "orgId", op = QueryOperator.EQU)
	private Long orgId;
	
	/** 患者ID **/
	@QueryParam(fieldName = "patientId", op = QueryOperator.EQU)
	private Long patientId;

	/** 病人名称 **/
	@QueryParam(fieldName = "patientName", op = QueryOperator.LIKE)
	private String patientName;
	
	/** 病人名称 精确查询 **/
	@QueryParam(fieldName = "patientName", op = QueryOperator.EQU)
	private String patientNameEqu;

	/** 性别 **/
	@QueryParam(fieldName = "patientSex", op = QueryOperator.EQU)
	private String patientSex;
	
	/** 患者院内档案ID（HIS系统） */
	@QueryParam(fieldName = "patientNo", op = QueryOperator.EQU)
	private Long patientNo;

	/** 证件号码 **/
	@QueryParam(fieldName = "patientIdCard", op = QueryOperator.LIKE)
	private String patientIdCard;
	
	/** 证件号码  精确查询**/
	@QueryParam(fieldName = "patientIdCard", op = QueryOperator.EQU)
	private String patientIdCardEqu;
	
	/** 医/农保证号 **/
	@QueryParam(fieldName = "insuranceNo", op = QueryOperator.LIKE)
	private String insuranceNo;
	
	/** 医/农保证号  精确查询**/
	@QueryParam(fieldName = "insuranceNo", op = QueryOperator.EQU)
	private String insuranceNoEqu;
	
	/** 医院编码 **/
	@QueryParam(fieldName = "hospitalNo", op = QueryOperator.EQU)
	private String hospitalNo;

	/** 就诊卡号 **/
	@QueryParam(fieldName = "patientCardNo", op = QueryOperator.LIKE)
	private String patientCardNo;

	/** 病人电话  精确查询**/
	@QueryParam(fieldName = "patientPhone", op = QueryOperator.EQU)
	private String patientPhoneEqu;
	
	/** 病人有效标志  **/
	@QueryParam(fieldName = "validFlag", op = QueryOperator.EQU)
	private String validFlag;

	/**
	 * default constructor
	 */
	public PatientQueryInfo() {
	}

	/**
	 * @param patientNameEqu
	 * @param patientIdCardEqu
	 */
	public PatientQueryInfo(String patientNameEqu, String patientIdCardEqu, String validFlag) {
		this.patientNameEqu = patientNameEqu;
		this.patientIdCardEqu = patientIdCardEqu;
	}

	/**
	 * @param patientName
	 * @param insuranceNoEqu
	 */
	public PatientQueryInfo(String insuranceNoEqu, String validFlag) {
		this.insuranceNoEqu = insuranceNoEqu;
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
	 * @return patientPhoneEqu
	 */
	public String getPatientPhoneEqu() {
		return patientPhoneEqu;
	}

	/**
	 * @param patientPhoneEqu 要设置的 patientPhoneEqu
	 */
	public void setPatientPhoneEqu(String patientPhoneEqu) {
		this.patientPhoneEqu = patientPhoneEqu;
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
	 * @return patientNameEqu
	 */
	public String getPatientNameEqu() {
		return patientNameEqu;
	}

	/**
	 * @param patientNameEqu 要设置的 patientNameEqu
	 */
	public void setPatientNameEqu(String patientNameEqu) {
		this.patientNameEqu = patientNameEqu;
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