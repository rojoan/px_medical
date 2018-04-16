package com.bofan.lis.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-10-11
 */
@QueryInfo(from = "com.bofan.lis.valueobject.LisInspectionSample lis")
public class LisInspectionSampleQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 7491257076018569669L;
    
    /** 病人唯一号 = 住院|挂号 的唯一号 */
	@QueryParam(fieldName = "lis.inpatientId", op = QueryOperator.EQU)
	private String inpatientId;
    
    /** 申请状态 */
    @QueryParam(fieldName = "lis.diagnosisFlag", op = QueryOperator.EQU)
    private String diagnosisFlag;
    
    /** 类别 */
    @QueryParam(fieldName = "lis.orgId", op = QueryOperator.EQU)
    private Long orgId;
    
    /** 类别 */
    @QueryParam(fieldName = "lis.patientType", op = QueryOperator.EQU)
    private String patientType;
    
    /** 患者姓名 */
    @QueryParam(fieldName = "lis.patientName", op = QueryOperator.LIKE)
    private String patientName;
    
    /** 标本种类  */
    @QueryParam(fieldName = "lis.sampleClassName", op = QueryOperator.LIKE)
    private String sampleClassName;
    
    /**  */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "lis.inspectionTime", op = QueryOperator.EQU)
    private Date inspectionDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "lis.inspectionTime", op = QueryOperator.GT_EQU)
    private Date beginInspectionDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "lis.inspectionTime", op = QueryOperator.LESS_EQU)
    private Date endInspectionDate;
    
    
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

    /**
     * @return the orgId
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * @param orgId the orgId to set
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * @return the patientType
     */
    public String getPatientType() {
        return patientType;
    }

    /**
     * @param patientType the patientType to set
     */
    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    /**
     * @return the patientName
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * @param patientName the patientName to set
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * @return the sampleClassName
     */
    public String getSampleClassName() {
        return sampleClassName;
    }

    /**
     * @param sampleClassName the sampleClassName to set
     */
    public void setSampleClassName(String sampleClassName) {
        this.sampleClassName = sampleClassName;
    }

    /**
     * @return the inspectionDate
     */
    public Date getInspectionDate() {
        return inspectionDate;
    }

    /**
     * @param inspectionDate the inspectionDate to set
     */
    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    /**
     * @return the beginInspectionDate
     */
    public Date getBeginInspectionDate() {
        return beginInspectionDate;
    }

    /**
     * @param beginInspectionDate the beginInspectionDate to set
     */
    public void setBeginInspectionDate(Date beginInspectionDate) {
        this.beginInspectionDate = beginInspectionDate;
    }

    /**
     * @return the endInspectionDate
     */
    public Date getEndInspectionDate() {
        return endInspectionDate;
    }

    /**
     * @param endInspectionDate the endInspectionDate to set
     */
    public void setEndInspectionDate(Date endInspectionDate) {
        this.endInspectionDate = endInspectionDate;
    }

}
