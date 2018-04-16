package com.bofan.pacs.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 
 * @author xlf
 *
 */
@SuppressWarnings("serial")
@QueryInfo(
        select = "new Map(pe.patientName as patientName, pe.patientId as patientId, pe.examPart as examPart, pe.patientExamId as patientExamId, pe.patientExamNum as patientExamNum, to_char(pe.examDate,'yyyy-mm-dd HH24:mm') as examDate, pe.examType as examType, pe.patientFrom as patientFrom, pe.diagnosisFlag as diagnosisFlag)", 
        from = "com.bofan.pacs.valueobject.PatientExam pe", 
        orderBy = "pe.examDate desc")
public class PatientExamCloudQueryInfo extends BaseCommandInfo {

    /** 机构ID */
    @QueryParam(fieldName = "pe.orgId", op = QueryOperator.EQU)
    private Long orgId;
    
    /** 是否远程会诊 */
    @QueryParam(fieldName = "pe.diagnosisFlag", op = QueryOperator.EQU)
    private String diagnosisFlag;
    
    /** 患者ID */
    @QueryParam(fieldName = "pe.patientExamNum", op = QueryOperator.EQU)
    private String patientExamNum;
    
    /** 患者ID */
    @QueryParam(fieldName = "pe.patientInfoId", op = QueryOperator.EQU)
    private Long patientInfoId;
    
    /** 患者姓名 */
    @QueryParam(fieldName = "pe.patientName", op = QueryOperator.EQU)
    private String patientName;
    
    /** 检查分类： 1=超声 ，2=放射 ，3=内镜 ，4=病理*/
    @QueryParam(fieldName = "pe.examCategory", op = QueryOperator.IN)
    private String[] examCategory;
    
    /** 开始检查时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "pe.examDate", op = QueryOperator.GT_EQU)
    private Date beginExamDate;
    
    /** 结束检查时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "pe.examDate", op = QueryOperator.LESS_EQU)
    private Date endExamDate;
    

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

    public String getPatientExamNum() {
        return patientExamNum;
    }
    
    public void setPatientExamNum(String patientExamNum) {
        this.patientExamNum = patientExamNum;
    }
    
    public Long getPatientInfoId() {
        return patientInfoId;
    }
    
    public void setPatientInfoId(Long patientInfoId) {
        this.patientInfoId = patientInfoId;
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String[] getExamCategory() {
        return examCategory;
    }

    public void setExamCategory(String[] examCategory) {
        this.examCategory = examCategory;
    }

    public Date getBeginExamDate() {
        return beginExamDate;
    }

    public void setBeginExamDate(Date beginExamDate) {
        this.beginExamDate = beginExamDate;
    }

    public Date getEndExamDate() {
        return endExamDate;
    }

    public void setEndExamDate(Date endExamDate) {
        this.endExamDate = endExamDate;
    }
    
    
}
