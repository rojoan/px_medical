package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;
import com.bofan.utils.Contstants;

/**
 * 0-6岁儿童基本情况登记查询条件参数信息
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.ChildVisit cv ", orderBy = "cv.childVisitId desc", where = "cv.validFlag = " + Contstants.YES_FLAG)
public class ChildVisitQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -7776152868811303401L;
    
    @QueryParam(fieldName = "cv.hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
    @QueryParam(fieldName = "cv.gender", op = QueryOperator.EQU)
    private String gender;
    
    @QueryParam(fieldName = "cv.childName", op = QueryOperator.LIKE)
    private String childName;
    
    @QueryParam(fieldName = "cv.visitDoctor", op = QueryOperator.LIKE)
    private String visitDoctor;
    
    @QueryParam(fieldName = "cv.ageStageFlag", op = QueryOperator.EQU)
    private String ageStageFlag;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "cv.visitDate", op = QueryOperator.GT_EQU)
    private Date beginVisitDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "cv.visitDate", op = QueryOperator.LESS_EQU)
    private Date endVisitDate;

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
     * @return the visitDoctor
     */
    public String getVisitDoctor() {
        return visitDoctor;
    }

    /**
     * @param visitDoctor the visitDoctor to set
     */
    public void setVisitDoctor(String visitDoctor) {
        this.visitDoctor = visitDoctor;
    }

    /**
     * @return the ageStageFlag
     */
    public String getAgeStageFlag() {
        return ageStageFlag;
    }

    /**
     * @param ageStageFlag the ageStageFlag to set
     */
    public void setAgeStageFlag(String ageStageFlag) {
        this.ageStageFlag = ageStageFlag;
    }

    /**
     * @return the beginVisitDate
     */
    public Date getBeginVisitDate() {
        return beginVisitDate;
    }

    /**
     * @param beginVisitDate the beginVisitDate to set
     */
    public void setBeginVisitDate(Date beginVisitDate) {
        this.beginVisitDate = beginVisitDate;
    }

    /**
     * @return the endVisitDate
     */
    public Date getEndVisitDate() {
        return endVisitDate;
    }

    /**
     * @param endVisitDate the endVisitDate to set
     */
    public void setEndVisitDate(Date endVisitDate) {
        this.endVisitDate = endVisitDate;
    }

}
