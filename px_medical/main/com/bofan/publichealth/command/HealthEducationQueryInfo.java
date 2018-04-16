package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 健康教育活动查询条件参数信息
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.HealthEducation he ", orderBy = "he.healthEducationId desc")
public class HealthEducationQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -7776152868811303401L;

    @QueryParam(fieldName = "he.eduForm", op = QueryOperator.EQU)
    private String eduForm;
    
    @QueryParam(fieldName = "he.hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
    @QueryParam(fieldName = "he.eduName", op = QueryOperator.LIKE)
    private String eduName;
    
    @QueryParam(fieldName = "he.eduThemeId", op = QueryOperator.EQU)
    private Long eduThemeId;

    @QueryParam(fieldName = "he.validFlag", op = QueryOperator.EQU)
    private String validFlag;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "he.eduTime", op = QueryOperator.GT_EQU)
    private Date beginEduTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "he.eduTime", op = QueryOperator.LESS_EQU)
    private Date endEduTime;

    /**
     * @return the eduForm
     */
    public String getEduForm() {
        return eduForm;
    }

    /**
     * @param eduForm the eduForm to set
     */
    public void setEduForm(String eduForm) {
        this.eduForm = eduForm;
    }

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
     * @return the eduName
     */
    public String getEduName() {
        return eduName;
    }

    /**
     * @param eduName the eduName to set
     */
    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    /**
     * @return the eduThemeId
     */
    public Long getEduThemeId() {
        return eduThemeId;
    }

    /**
     * @param eduThemeId the eduThemeId to set
     */
    public void setEduThemeId(Long eduThemeId) {
        this.eduThemeId = eduThemeId;
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
     * @return the beginEduTime
     */
    public Date getBeginEduTime() {
        return beginEduTime;
    }

    /**
     * @param beginEduTime the beginEduTime to set
     */
    public void setBeginEduTime(Date beginEduTime) {
        this.beginEduTime = beginEduTime;
    }

    /**
     * @return the endEduTime
     */
    public Date getEndEduTime() {
        return endEduTime;
    }

    /**
     * @param endEduTime the endEduTime to set
     */
    public void setEndEduTime(Date endEduTime) {
        this.endEduTime = endEduTime;
    }

}
