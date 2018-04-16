package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 0-6岁儿童基本情况登记查询条件参数信息
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.ChildDetail cd ", orderBy = "cd.childDetailId desc")
public class ChildDetailQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -7776152868811303401L;

    @QueryParam(fieldName = "cd.hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
    @QueryParam(fieldName = "cd.gender", op = QueryOperator.EQU)
    private String gender;
    
    @QueryParam(fieldName = "cd.childName", op = QueryOperator.LIKE)
    private String childName;
    
    @QueryParam(fieldName = "cd.familyDetailId", op = QueryOperator.EQU)
    private Long familyDetailId;
    
    @QueryParam(fieldName = "cd.validFlag", op = QueryOperator.EQU)
    private String validFlag;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "cd.birthDate", op = QueryOperator.GT_EQU)
    private Date beginBirthDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "cd.birthDate", op = QueryOperator.LESS_EQU)
    private Date endBirthDate;

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
     * @return the familyDetailId
     */
    public Long getFamilyDetailId() {
        return familyDetailId;
    }

    /**
     * @param familyDetailId the familyDetailId to set
     */
    public void setFamilyDetailId(Long familyDetailId) {
        this.familyDetailId = familyDetailId;
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
     * @return the beginBirthDate
     */
    public Date getBeginBirthDate() {
        return beginBirthDate;
    }

    /**
     * @param beginBirthDate the beginBirthDate to set
     */
    public void setBeginBirthDate(Date beginBirthDate) {
        this.beginBirthDate = beginBirthDate;
    }

    /**
     * @return the endBirthDate
     */
    public Date getEndBirthDate() {
        return endBirthDate;
    }

    /**
     * @param endBirthDate the endBirthDate to set
     */
    public void setEndBirthDate(Date endBirthDate) {
        this.endBirthDate = endBirthDate;
    }
    


}
