package com.bofan.publichealth.vaccine.command;

import java.util.Date;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 疫苗接种证调动记录表查询对象
 * @author wmg
 */
@QueryInfo(
        from = "com.bofan.publichealth.vaccine.valueobject.VaccinationCardMove vaccinationCardMove ", 
        orderBy = "vaccinationCardMove.cardMoveId desc")
public class VaccinationCardMoveQueryInfo extends BaseCommandInfo {

    private static final long serialVersionUID = 1L;

    /** 接种证调动ID */
    @QueryParam(fieldName = "cardMoveId", op =QueryOperator.EQU)
    private Long  cardMoveId ;

    /** 被接种儿童ID */
    @QueryParam(fieldName = "childDetailId", op =QueryOperator.EQU)
    private Long  childDetailId ;

    /** 操作时间起始 */
    @QueryParam(fieldName = "createTime", op = QueryOperator.GT_EQU)
    private Date createTimeBegin ;

    /** 操作时间截止 */
    @QueryParam(fieldName = "createTime", op = QueryOperator.LESS_EQU)
    private Date createTimeEnd ;

    /** 操作员ID */
    @QueryParam(fieldName = "creatorId", op =QueryOperator.EQU)
    private Long  creatorId ;

    /** 处理医生 */
    @QueryParam(fieldName = "handleDoctor", op =QueryOperator.LIKE)
    private String  handleDoctor ;

    /** 处理医生ID */
    @QueryParam(fieldName = "handleDoctorId", op =QueryOperator.EQU)
    private Long  handleDoctorId ;

    /** 处理结果 */
    @QueryParam(fieldName = "handleResult", op =QueryOperator.EQU)
    private String  handleResult ;

    /** 处理日期起始 */
    @QueryParam(fieldName = "handleTime", op = QueryOperator.GT_EQU)
    private Date handleTimeBegin ;

    /** 处理日期截止 */
    @QueryParam(fieldName = "handleTime", op = QueryOperator.LESS_EQU)
    private Date handleTimeEnd ;

    /** 调入医疗机构ID */
    @QueryParam(fieldName = "inHospitalId", op =QueryOperator.EQU)
    private Long  inHospitalId ;

    /** 调入医疗机构 */
    @QueryParam(fieldName = "inHospitalName", op =QueryOperator.LIKE)
    private String  inHospitalName ;

    /** 调动原因 */
    @QueryParam(fieldName = "moveReason", op =QueryOperator.LIKE)
    private String  moveReason ;

    /** 调动日期起始 */
    @QueryParam(fieldName = "moveTime", op = QueryOperator.GT_EQU)
    private Date moveTimeBegin ;

    /** 调动日期截止 */
    @QueryParam(fieldName = "moveTime", op = QueryOperator.LESS_EQU)
    private Date moveTimeEnd ;

    /** 调出医疗机构ID */
    @QueryParam(fieldName = "outHospitalId", op =QueryOperator.EQU)
    private Long  outHospitalId ;

    /** 调出医疗机构 */
    @QueryParam(fieldName = "outHospitalName", op =QueryOperator.LIKE)
    private String  outHospitalName ;

    /** 调动申请人ID */
    @QueryParam(fieldName = "proposerId", op =QueryOperator.EQU)
    private Long  proposerId ;

    /** 调动申请人 */
    @QueryParam(fieldName = "proposerName", op =QueryOperator.LIKE)
    private String  proposerName ;

    /** 拒绝理由 */
    @QueryParam(fieldName = "refuseReason", op =QueryOperator.LIKE)
    private String  refuseReason ;

    /** 行政区域ID */
    @QueryParam(fieldName = "regionId", op =QueryOperator.LIKE)
    private String  regionId ;

    /** 被接种人姓名 */
    @QueryParam(fieldName = "vaccinatedName", op =QueryOperator.LIKE)
    private String  vaccinatedName ;

    /** 预防接种卡编号 */
    @QueryParam(fieldName = "vaccinationCardNo", op =QueryOperator.LIKE)
    private String  vaccinationCardNo ;



    /**
     * @return cardMoveId(接种证调动ID)
     */
    public Long getCardMoveId() {
        return cardMoveId;
    }

    /**
     * @param cardMoveId 要设置的 cardMoveId(接种证调动ID)
     */
    public void setCardMoveId(Long cardMoveId) {
        this.cardMoveId = cardMoveId;
    }

    /**
     * @return childDetailId(被接种儿童ID)
     */
    public Long getChildDetailId() {
        return childDetailId;
    }

    /**
     * @param childDetailId 要设置的 childDetailId(被接种儿童ID)
     */
    public void setChildDetailId(Long childDetailId) {
        this.childDetailId = childDetailId;
    }

    /**
     * @return createTimeBegin(操作时间)
     */
    public Date getCreateTimeBegin() {
        return createTimeBegin;
    }

    /**
     * @param createTimeBegin 要设置的 createTimeBegin(操作时间)
     */
    public void setCreateTimeBegin(Date createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }


    /**
     * @return createTimeEnd(操作时间)
     */
    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    /**
     * @param createTimeEnd 要设置的 createTimeEnd(操作时间)
     */
    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    /**
     * @return creatorId(操作员ID)
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId 要设置的 creatorId(操作员ID)
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return handleDoctor(处理医生)
     */
    public String getHandleDoctor() {
        return handleDoctor;
    }

    /**
     * @param handleDoctor 要设置的 handleDoctor(处理医生)
     */
    public void setHandleDoctor(String handleDoctor) {
        this.handleDoctor = handleDoctor;
    }

    /**
     * @return handleDoctorId(处理医生ID)
     */
    public Long getHandleDoctorId() {
        return handleDoctorId;
    }

    /**
     * @param handleDoctorId 要设置的 handleDoctorId(处理医生ID)
     */
    public void setHandleDoctorId(Long handleDoctorId) {
        this.handleDoctorId = handleDoctorId;
    }

    /**
     * @return handleResult(处理结果)
     */
    public String getHandleResult() {
        return handleResult;
    }

    /**
     * @param handleResult 要设置的 handleResult(处理结果)
     */
    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    /**
     * @return handleTimeBegin(处理日期)
     */
    public Date getHandleTimeBegin() {
        return handleTimeBegin;
    }

    /**
     * @param handleTimeBegin 要设置的 handleTimeBegin(处理日期)
     */
    public void setHandleTimeBegin(Date handleTimeBegin) {
        this.handleTimeBegin = handleTimeBegin;
    }


    /**
     * @return handleTimeEnd(处理日期)
     */
    public Date getHandleTimeEnd() {
        return handleTimeEnd;
    }

    /**
     * @param handleTimeEnd 要设置的 handleTimeEnd(处理日期)
     */
    public void setHandleTimeEnd(Date handleTimeEnd) {
        this.handleTimeEnd = handleTimeEnd;
    }

    /**
     * @return inHospitalId(调入医疗机构ID)
     */
    public Long getInHospitalId() {
        return inHospitalId;
    }

    /**
     * @param inHospitalId 要设置的 inHospitalId(调入医疗机构ID)
     */
    public void setInHospitalId(Long inHospitalId) {
        this.inHospitalId = inHospitalId;
    }

    /**
     * @return inHospitalName(调入医疗机构)
     */
    public String getInHospitalName() {
        return inHospitalName;
    }

    /**
     * @param inHospitalName 要设置的 inHospitalName(调入医疗机构)
     */
    public void setInHospitalName(String inHospitalName) {
        this.inHospitalName = inHospitalName;
    }

    /**
     * @return moveReason(调动原因)
     */
    public String getMoveReason() {
        return moveReason;
    }

    /**
     * @param moveReason 要设置的 moveReason(调动原因)
     */
    public void setMoveReason(String moveReason) {
        this.moveReason = moveReason;
    }

    /**
     * @return moveTimeBegin(调动日期)
     */
    public Date getMoveTimeBegin() {
        return moveTimeBegin;
    }

    /**
     * @param moveTimeBegin 要设置的 moveTimeBegin(调动日期)
     */
    public void setMoveTimeBegin(Date moveTimeBegin) {
        this.moveTimeBegin = moveTimeBegin;
    }


    /**
     * @return moveTimeEnd(调动日期)
     */
    public Date getMoveTimeEnd() {
        return moveTimeEnd;
    }

    /**
     * @param moveTimeEnd 要设置的 moveTimeEnd(调动日期)
     */
    public void setMoveTimeEnd(Date moveTimeEnd) {
        this.moveTimeEnd = moveTimeEnd;
    }

    /**
     * @return outHospitalId(调出医疗机构ID)
     */
    public Long getOutHospitalId() {
        return outHospitalId;
    }

    /**
     * @param outHospitalId 要设置的 outHospitalId(调出医疗机构ID)
     */
    public void setOutHospitalId(Long outHospitalId) {
        this.outHospitalId = outHospitalId;
    }

    /**
     * @return outHospitalName(调出医疗机构)
     */
    public String getOutHospitalName() {
        return outHospitalName;
    }

    /**
     * @param outHospitalName 要设置的 outHospitalName(调出医疗机构)
     */
    public void setOutHospitalName(String outHospitalName) {
        this.outHospitalName = outHospitalName;
    }

    /**
     * @return proposerId(调动申请人ID)
     */
    public Long getProposerId() {
        return proposerId;
    }

    /**
     * @param proposerId 要设置的 proposerId(调动申请人ID)
     */
    public void setProposerId(Long proposerId) {
        this.proposerId = proposerId;
    }

    /**
     * @return proposerName(调动申请人)
     */
    public String getProposerName() {
        return proposerName;
    }

    /**
     * @param proposerName 要设置的 proposerName(调动申请人)
     */
    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    /**
     * @return refuseReason(拒绝理由)
     */
    public String getRefuseReason() {
        return refuseReason;
    }

    /**
     * @param refuseReason 要设置的 refuseReason(拒绝理由)
     */
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    /**
     * @return regionId(行政区域ID)
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId 要设置的 regionId(行政区域ID)
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

}
