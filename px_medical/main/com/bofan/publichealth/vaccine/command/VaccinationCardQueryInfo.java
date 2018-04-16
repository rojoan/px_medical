package com.bofan.publichealth.vaccine.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;
import java.lang.Long;
import java.util.Date;
import java.lang.String;

/**
 * @Description: 预防接种卡基本信息查询对象
 * @author wmg
 */
@QueryInfo(
        from = "com.bofan.publichealth.vaccine.valueobject.VaccinationCard vaccinationCard ", 
        orderBy = "vaccinationCard.vaccinationCardId desc")
public class VaccinationCardQueryInfo extends BaseCommandInfo {

    private static final long serialVersionUID = 1L;

    /** 预防接种卡ID */
    @QueryParam(fieldName = "vaccinationCardId", op =QueryOperator.EQU)
    private Long  vaccinationCardId ;

    /** 被接种人 */
    @QueryParam(fieldName = "childDetailId", op =QueryOperator.EQU)
    private Long  childDetailId ;

    /** 传染病史 */
    @QueryParam(fieldName = "contagionHistory", op =QueryOperator.LIKE)
    private String  contagionHistory ;

    /** 建卡日期起始 */
    @QueryParam(fieldName = "createTime", op = QueryOperator.GT_EQU)
    private Date createTimeBegin ;

    /** 建卡日期截止 */
    @QueryParam(fieldName = "createTime", op = QueryOperator.LESS_EQU)
    private Date createTimeEnd ;

    /** 建卡人ID */
    @QueryParam(fieldName = "creatorId", op =QueryOperator.EQU)
    private Long  creatorId ;

    /** 建卡人 */
    @QueryParam(fieldName = "creatorName", op =QueryOperator.LIKE)
    private String  creatorName ;

    /** 填写时间起始 */
    @QueryParam(fieldName = "fillTime", op = QueryOperator.GT_EQU)
    private Date fillTimeBegin ;

    /** 填写时间截止 */
    @QueryParam(fieldName = "fillTime", op = QueryOperator.LESS_EQU)
    private Date fillTimeEnd ;

    /** 监护人姓名 */
    @QueryParam(fieldName = "guardiansName", op =QueryOperator.LIKE)
    private String  guardiansName ;

    /** 监护人与儿童的关系 */
    @QueryParam(fieldName = "guardiansRelation", op =QueryOperator.LIKE)
    private String  guardiansRelation ;

    /** 医疗机构ID */
    @QueryParam(fieldName = "hospitalId", op =QueryOperator.EQU)
    private Long  hospitalId ;

    /** 医疗机构名称 */
    @QueryParam(fieldName = "hospitalName", op =QueryOperator.LIKE)
    private String  hospitalName ;

    /** 医疗机构代码 */
    @QueryParam(fieldName = "hospitalNo", op =QueryOperator.LIKE)
    private String  hospitalNo ;

    /** 迁入时间起始 */
    @QueryParam(fieldName = "moveInTime", op = QueryOperator.GT_EQU)
    private Date moveInTimeBegin ;

    /** 迁入时间截止 */
    @QueryParam(fieldName = "moveInTime", op = QueryOperator.LESS_EQU)
    private Date moveInTimeEnd ;

    /** 迁出时间起始 */
    @QueryParam(fieldName = "moveOutTime", op = QueryOperator.GT_EQU)
    private Date moveOutTimeBegin ;

    /** 迁出时间截止 */
    @QueryParam(fieldName = "moveOutTime", op = QueryOperator.LESS_EQU)
    private Date moveOutTimeEnd ;

    /** 迁出原因 */
    @QueryParam(fieldName = "moveReason", op =QueryOperator.LIKE)
    private String  moveReason ;

    /** 被接种人个人ID */
    @QueryParam(fieldName = "personDetailId", op =QueryOperator.EQU)
    private Long  personDetailId ;

    /** 行政区域 */
    @QueryParam(fieldName = "regionId", op =QueryOperator.LIKE)
    private String  regionId ;

    /** 被接种人姓名 */
    @QueryParam(fieldName = "vaccinatedName", op =QueryOperator.LIKE)
    private String  vaccinatedName ;

    /** 联系电话 */
    @QueryParam(fieldName = "vaccinatedPhone", op =QueryOperator.LIKE)
    private String  vaccinatedPhone ;

    /** 预防接种卡编号 */
    @QueryParam(fieldName = "vaccinationCardNo", op =QueryOperator.LIKE)
    private String  vaccinationCardNo ;

    /** 疫苗异常反应史 */
    @QueryParam(fieldName = "vaccineUnReaction", op =QueryOperator.LIKE)
    private String  vaccineUnReaction ;

    /** 是否有效 */
    @QueryParam(fieldName = "validFlag", op =QueryOperator.EQU)
    private String  validFlag ;



    /**
     * @return vaccinationCardId(预防接种卡ID)
     */
    public Long getVaccinationCardId() {
        return vaccinationCardId;
    }

    /**
     * @param vaccinationCardId 要设置的 vaccinationCardId(预防接种卡ID)
     */
    public void setVaccinationCardId(Long vaccinationCardId) {
        this.vaccinationCardId = vaccinationCardId;
    }

    /**
     * @return childDetailId(被接种人)
     */
    public Long getChildDetailId() {
        return childDetailId;
    }

    /**
     * @param childDetailId 要设置的 childDetailId(被接种人)
     */
    public void setChildDetailId(Long childDetailId) {
        this.childDetailId = childDetailId;
    }

    /**
     * @return contagionHistory(传染病史)
     */
    public String getContagionHistory() {
        return contagionHistory;
    }

    /**
     * @param contagionHistory 要设置的 contagionHistory(传染病史)
     */
    public void setContagionHistory(String contagionHistory) {
        this.contagionHistory = contagionHistory;
    }

    /**
     * @return createTimeBegin(建卡日期)
     */
    public Date getCreateTimeBegin() {
        return createTimeBegin;
    }

    /**
     * @param createTimeBegin 要设置的 createTimeBegin(建卡日期)
     */
    public void setCreateTimeBegin(Date createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }


    /**
     * @return createTimeEnd(建卡日期)
     */
    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    /**
     * @param createTimeEnd 要设置的 createTimeEnd(建卡日期)
     */
    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    /**
     * @return creatorId(建卡人ID)
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId 要设置的 creatorId(建卡人ID)
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return creatorName(建卡人)
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * @param creatorName 要设置的 creatorName(建卡人)
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     * @return fillTimeBegin(填写时间)
     */
    public Date getFillTimeBegin() {
        return fillTimeBegin;
    }

    /**
     * @param fillTimeBegin 要设置的 fillTimeBegin(填写时间)
     */
    public void setFillTimeBegin(Date fillTimeBegin) {
        this.fillTimeBegin = fillTimeBegin;
    }


    /**
     * @return fillTimeEnd(填写时间)
     */
    public Date getFillTimeEnd() {
        return fillTimeEnd;
    }

    /**
     * @param fillTimeEnd 要设置的 fillTimeEnd(填写时间)
     */
    public void setFillTimeEnd(Date fillTimeEnd) {
        this.fillTimeEnd = fillTimeEnd;
    }

    /**
     * @return guardiansName(监护人姓名)
     */
    public String getGuardiansName() {
        return guardiansName;
    }

    /**
     * @param guardiansName 要设置的 guardiansName(监护人姓名)
     */
    public void setGuardiansName(String guardiansName) {
        this.guardiansName = guardiansName;
    }

    /**
     * @return guardiansRelation(监护人与儿童的关系)
     */
    public String getGuardiansRelation() {
        return guardiansRelation;
    }

    /**
     * @param guardiansRelation 要设置的 guardiansRelation(监护人与儿童的关系)
     */
    public void setGuardiansRelation(String guardiansRelation) {
        this.guardiansRelation = guardiansRelation;
    }

    /**
     * @return hospitalId(医疗机构ID)
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId 要设置的 hospitalId(医疗机构ID)
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * @return hospitalName(医疗机构名称)
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * @param hospitalName 要设置的 hospitalName(医疗机构名称)
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * @return hospitalNo(医疗机构代码)
     */
    public String getHospitalNo() {
        return hospitalNo;
    }

    /**
     * @param hospitalNo 要设置的 hospitalNo(医疗机构代码)
     */
    public void setHospitalNo(String hospitalNo) {
        this.hospitalNo = hospitalNo;
    }

    /**
     * @return moveInTimeBegin(迁入时间)
     */
    public Date getMoveInTimeBegin() {
        return moveInTimeBegin;
    }

    /**
     * @param moveInTimeBegin 要设置的 moveInTimeBegin(迁入时间)
     */
    public void setMoveInTimeBegin(Date moveInTimeBegin) {
        this.moveInTimeBegin = moveInTimeBegin;
    }


    /**
     * @return moveInTimeEnd(迁入时间)
     */
    public Date getMoveInTimeEnd() {
        return moveInTimeEnd;
    }

    /**
     * @param moveInTimeEnd 要设置的 moveInTimeEnd(迁入时间)
     */
    public void setMoveInTimeEnd(Date moveInTimeEnd) {
        this.moveInTimeEnd = moveInTimeEnd;
    }

    /**
     * @return moveOutTimeBegin(迁出时间)
     */
    public Date getMoveOutTimeBegin() {
        return moveOutTimeBegin;
    }

    /**
     * @param moveOutTimeBegin 要设置的 moveOutTimeBegin(迁出时间)
     */
    public void setMoveOutTimeBegin(Date moveOutTimeBegin) {
        this.moveOutTimeBegin = moveOutTimeBegin;
    }


    /**
     * @return moveOutTimeEnd(迁出时间)
     */
    public Date getMoveOutTimeEnd() {
        return moveOutTimeEnd;
    }

    /**
     * @param moveOutTimeEnd 要设置的 moveOutTimeEnd(迁出时间)
     */
    public void setMoveOutTimeEnd(Date moveOutTimeEnd) {
        this.moveOutTimeEnd = moveOutTimeEnd;
    }

    /**
     * @return moveReason(迁出原因)
     */
    public String getMoveReason() {
        return moveReason;
    }

    /**
     * @param moveReason 要设置的 moveReason(迁出原因)
     */
    public void setMoveReason(String moveReason) {
        this.moveReason = moveReason;
    }

    /**
     * @return personDetailId(被接种人个人ID)
     */
    public Long getPersonDetailId() {
        return personDetailId;
    }

    /**
     * @param personDetailId 要设置的 personDetailId(被接种人个人ID)
     */
    public void setPersonDetailId(Long personDetailId) {
        this.personDetailId = personDetailId;
    }

    /**
     * @return regionId(行政区域)
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId 要设置的 regionId(行政区域)
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * @return vaccinatedName(被接种人姓名)
     */
    public String getVaccinatedName() {
        return vaccinatedName;
    }

    /**
     * @param vaccinatedName 要设置的 vaccinatedName(被接种人姓名)
     */
    public void setVaccinatedName(String vaccinatedName) {
        this.vaccinatedName = vaccinatedName;
    }

    /**
     * @return vaccinatedPhone(联系电话)
     */
    public String getVaccinatedPhone() {
        return vaccinatedPhone;
    }

    /**
     * @param vaccinatedPhone 要设置的 vaccinatedPhone(联系电话)
     */
    public void setVaccinatedPhone(String vaccinatedPhone) {
        this.vaccinatedPhone = vaccinatedPhone;
    }

    /**
     * @return vaccinationCardNo(预防接种卡编号)
     */
    public String getVaccinationCardNo() {
        return vaccinationCardNo;
    }

    /**
     * @param vaccinationCardNo 要设置的 vaccinationCardNo(预防接种卡编号)
     */
    public void setVaccinationCardNo(String vaccinationCardNo) {
        this.vaccinationCardNo = vaccinationCardNo;
    }

    /**
     * @return vaccineUnReaction(疫苗异常反应史)
     */
    public String getVaccineUnReaction() {
        return vaccineUnReaction;
    }

    /**
     * @param vaccineUnReaction 要设置的 vaccineUnReaction(疫苗异常反应史)
     */
    public void setVaccineUnReaction(String vaccineUnReaction) {
        this.vaccineUnReaction = vaccineUnReaction;
    }

    /**
     * @return validFlag(是否有效)
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag 要设置的 validFlag(是否有效)
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

}
