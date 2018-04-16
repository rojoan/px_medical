package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;
import com.bofan.utils.Contstants;

/**
 * 儿童体检(检查)查询条件参数信息
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.ExamChild ec ", orderBy = "ec.examChildId desc", where = "ec.validFlag = " + Contstants.YES_FLAG)
public class ExamChildQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -7776152868811303401L;
    
    @QueryParam(fieldName = "ec.hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
    @QueryParam(fieldName = "ec.childDetailId", op = QueryOperator.EQU)
    private Long childDetailId;
    
    @QueryParam(fieldName = "ec.gender", op = QueryOperator.EQU)
    private String gender;
    
    @QueryParam(fieldName = "ec.childName", op = QueryOperator.LIKE)
    private String childName;
    
    @QueryParam(fieldName = "ec.dutyDoctor", op = QueryOperator.LIKE)
    private String dutyDoctor;
    
    @QueryParam(fieldName = "ec.examBillNo", op = QueryOperator.EQU)
    private String examBillNo;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "ec.examTime", op = QueryOperator.GT_EQU)
    private Date beginExamTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "ec.examTime", op = QueryOperator.LESS_EQU)
    private Date endExamTime;

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
     * @return the childDetailId
     */
    public Long getChildDetailId() {
        return childDetailId;
    }

    /**
     * @param childDetailId the childDetailId to set
     */
    public void setChildDetailId(Long childDetailId) {
        this.childDetailId = childDetailId;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the childName
     */
    public String getChildName() {
        return childName;
    }

    /**
     * @param childName the childName to set
     */
    public void setChildName(String childName) {
        this.childName = childName;
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

}
