package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 死亡登记查询参数
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.DeathRecord dr", orderBy = "dr.deathRecordId desc")
public class DeathRecordQueryInfo extends BaseCommandInfo {

    private static final long serialVersionUID = 9065496992044630401L;
    
    /** 医院标识 */
    @QueryParam(fieldName = "dr.hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
    /** 姓名（冗余字段） */
    @QueryParam(fieldName = "dr.vaccinatedName", op = QueryOperator.LIKE)
    private String vaccinatedName;
    
    /** 性别，冗余字段  1：男 2：女 */
    @QueryParam(fieldName = "dr.gender", op = QueryOperator.EQU)
    private String gender;
    
    /** 是否有效 1=有效 0=无效 */
    @QueryParam(fieldName = "dr.validFlag", op = QueryOperator.EQU)
    private String validFlag;

    /** 是否孕妇-儿童  0= 1=孕妇 2=儿童 */
    @QueryParam(fieldName = "dr.deathFlag", op = QueryOperator.EQU)
    private String deathFlag;
    
    /** 死亡日期 -开始日期*/
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "dr.deathTime", op = QueryOperator.GT_EQU)
    private Date beginDeathTime;
    
    /** 死亡日期 -结束日期*/
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "dr.deathTime", op = QueryOperator.LESS_EQU)
    private Date endDeathTime;
    
    
    /**
     * @return hospitalId
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId 要设置的 hospitalId
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * @return vaccinatedName
     */
    public String getVaccinatedName() {
        return vaccinatedName;
    }

    /**
     * @param vaccinatedName 要设置的 vaccinatedName
     */
    public void setVaccinatedName(String vaccinatedName) {
        this.vaccinatedName = vaccinatedName;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender 要设置的 gender
     */
    public void setGender(String gender) {
        this.gender = gender;
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

    /**
     * @return deathFlag
     */
    public String getDeathFlag() {
        return deathFlag;
    }

    /**
     * @param deathFlag 要设置的 deathFlag
     */
    public void setDeathFlag(String deathFlag) {
        this.deathFlag = deathFlag;
    }

    /**
     * @return beginDeathTime
     */
    public Date getBeginDeathTime() {
        return beginDeathTime;
    }

    /**
     * @param beginDeathTime 要设置的 beginDeathTime
     */
    public void setBeginDeathTime(Date beginDeathTime) {
        this.beginDeathTime = beginDeathTime;
    }

    /**
     * @return endDeathTime
     */
    public Date getEndDeathTime() {
        return endDeathTime;
    }

    /**
     * @param endDeathTime 要设置的 endDeathTime
     */
    public void setEndDeathTime(Date endDeathTime) {
        this.endDeathTime = endDeathTime;
    }

}
