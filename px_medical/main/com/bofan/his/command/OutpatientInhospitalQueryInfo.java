package com.bofan.his.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 门诊-住院表查询
 * @author lqw
 */
@SuppressWarnings("serial")
@QueryInfo(from = "com.bofan.his.valueobject.OutpatientInhospital o ", orderBy = "o.outpatientInhospitalId desc")
public class OutpatientInhospitalQueryInfo extends BaseCommandInfo  {

	/** 组织机构（医院单位）ID 对应sys_org表中，医院编码（标识）对应的单位ID **/
	@QueryParam(fieldName = "o.orgId", op = QueryOperator.EQU)
	private Long orgId;
	
	/** 患者姓名 **/
	@QueryParam(fieldName = "o.patientName", op = QueryOperator.EQU)
	private String patientName;

	/** 证件号码 **/
	@QueryParam(fieldName = "o.patientIdCard", op = QueryOperator.EQU)
	private String patientIdCard;
	
	/** 病人ID */
	@QueryParam(fieldName = "o.patientId", op = QueryOperator.EQU)
	private Long patientId;
	
	/** 住院号ID 住院表的流水号 */
	@QueryParam(fieldName = "o.inhospitalId", op = QueryOperator.EQU)
    private Long inhospitalId;
    
    /** 门诊挂号明细ID */
	@QueryParam(fieldName = "o.outpatientId", op = QueryOperator.EQU)
    private Long outpatientId;

	/** 转诊-远程诊断标识 */
	@QueryParam(fieldName = "o.diagnosisFlag", op = QueryOperator.EQU)
	private String diagnosisFlag;
	
	/** 是否有效 1：有效 0：无效 */
	@QueryParam(fieldName = "o.validFlag", op = QueryOperator.EQU)
	private String validFlag = "1";
	
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
     * @return the patientId
     */
    public Long getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the inhospitalId
     */
    public Long getInhospitalId() {
        return inhospitalId;
    }

    /**
     * @param inhospitalId the inhospitalId to set
     */
    public void setInhospitalId(Long inhospitalId) {
        this.inhospitalId = inhospitalId;
    }

	/**
	 * @return outpatientId
	 */
	public Long getOutpatientId() {
		return outpatientId;
	}

	/**
	 * @param outpatientId 要设置的 outpatientId
	 */
	public void setOutpatientId(Long outpatientId) {
		this.outpatientId = outpatientId;
	}

	/**
	 * @return diagnosisFlag
	 */
	public String getDiagnosisFlag() {
		return diagnosisFlag;
	}

	/**
	 * @param diagnosisFlag 要设置的 diagnosisFlag
	 */
	public void setDiagnosisFlag(String diagnosisFlag) {
		this.diagnosisFlag = diagnosisFlag;
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