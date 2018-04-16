package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 居民健康体检查询条件参数信息
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.ExamPerson ep ", orderBy = "ep.examPersonId desc")
public class ExamPersonQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -7776152868811303401L;

    @QueryParam(fieldName = "ep.hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
    @QueryParam(fieldName = "ep.validFlag", op = QueryOperator.EQU)
    private String validFlag;
    
    @QueryParam(fieldName = "ep.examBillNo", op = QueryOperator.EQU)
    private String examBillNo;
    
    @QueryParam(fieldName = "ep.examedPersonPame", op = QueryOperator.LIKE)
    private String examedPersonPame;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "ep.examTime", op = QueryOperator.GT_EQU)
    private Date beginExamTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "ep.examTime", op = QueryOperator.LESS_EQU)
    private Date endExamTime;
    
    @QueryParam(fieldName = "ep.hospitalName", op = QueryOperator.LIKE)
    private String hospitalName; 
    
    @QueryParam(fieldName = "ep.dutyDoctor", op = QueryOperator.LIKE)
    private String dutyDoctor; 
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "ep.createTime", op = QueryOperator.GT_EQU)
    private Date beginCreateTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "ep.createTime", op = QueryOperator.LESS_EQU)
    private Date endCreateTime;

    /**
     * @return the hospitalId
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId the hospitalId to set
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * @return the validFlag
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag the validFlag to set
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    /**
     * @return the examBillNo
     */
    public String getExamBillNo() {
        return examBillNo;
    }

    /**
     * @param examBillNo the examBillNo to set
     */
    public void setExamBillNo(String examBillNo) {
        this.examBillNo = examBillNo;
    }

    /**
     * @return the examedPersonPame
     */
    public String getExamedPersonPame() {
        return examedPersonPame;
    }

    /**
     * @param examedPersonPame the examedPersonPame to set
     */
    public void setExamedPersonPame(String examedPersonPame) {
        this.examedPersonPame = examedPersonPame;
    }

    /**
     * @return the beginExamTime
     */
    public Date getBeginExamTime() {
        return beginExamTime;
    }

    /**
     * @param beginExamTime the beginExamTime to set
     */
    public void setBeginExamTime(Date beginExamTime) {
        this.beginExamTime = beginExamTime;
    }

    /**
     * @return the endExamTime
     */
    public Date getEndExamTime() {
        return endExamTime;
    }

    /**
     * @param endExamTime the endExamTime to set
     */
    public void setEndExamTime(Date endExamTime) {
        this.endExamTime = endExamTime;
    }

    /**
     * @return the hospitalName
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * @param hospitalName the hospitalName to set
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * @return the dutyDoctor
     */
    public String getDutyDoctor() {
        return dutyDoctor;
    }

    /**
     * @param dutyDoctor the dutyDoctor to set
     */
    public void setDutyDoctor(String dutyDoctor) {
        this.dutyDoctor = dutyDoctor;
    }

    /**
     * @return the beginCreateTime
     */
    public Date getBeginCreateTime() {
        return beginCreateTime;
    }

    /**
     * @param beginCreateTime the beginCreateTime to set
     */
    public void setBeginCreateTime(Date beginCreateTime) {
        this.beginCreateTime = beginCreateTime;
    }

    /**
     * @return the endCreateTime
     */
    public Date getEndCreateTime() {
        return endCreateTime;
    }

    /**
     * @param endCreateTime the endCreateTime to set
     */
    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }
    
    
    
}
