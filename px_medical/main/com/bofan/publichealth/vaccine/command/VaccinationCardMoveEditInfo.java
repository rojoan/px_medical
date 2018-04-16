package  com.bofan.publichealth.vaccine.command;
import java.math.BigDecimal;
import java.lang.Long;
import java.util.Date;
import java.lang.String;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description:  包含家庭居住条件和卫生设施编辑
 * @author wmg
 */
public class  VaccinationCardMoveEditInfo extends BaseCommandInfo {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

     /** 接种证调动ID */
    private Long cardMoveId;

    /** 被接种人--儿童基本信息ID（与个人基本信息ID不能同时为空）  对应  child_detail（儿童基本信息表） 主键ID */
    private Long childDetailId;

    /** 操作时间 */
    private Date createTime;

    /** 操作员ID */
    private Long creatorId;

    /** 处理医生 */
    private String handleDoctor;

    /** 处理医生ID */
    private Long handleDoctorId;

    /** 处理结果 1:成功 2:拒绝 */
    private String handleResult;

    /** 处理日期 */
    private Date handleTime;

    /** 调入医疗机构ID */
    private Long inHospitalId;

    /** 调入医疗机构 */
    private String inHospitalName;

    /** 调动原因 */
    private String moveReason;

    /** 调动日期 */
    private Date moveTime;

    /** 调出医疗机构ID */
    private Long outHospitalId;

    /** 调出医疗机构 */
    private String outHospitalName;

    /** 被接种人个人基本信息ID  对应  person_detail（个人基本信息表） 主键ID */
    private BigDecimal personDetailId;

    /** 调动申请人ID */
    private Long proposerId;

    /** 调动申请人 */
    private String proposerName;

    /** 拒绝理由 */
    private String refuseReason;

    /** 行政区域--城镇街道ID  分三级管理  省（直辖市） ：001 市（地区）     ：001001 县（城区）     ：001001001 */
    private String regionId;

    /** 被接种人--姓名（冗余字段） */
    private String vaccinatedName;

    /** 预防接种卡编号 */
    private String vaccinationCardNo;


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
     * @return createTime(操作时间)
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 要设置的 createTime(操作时间)
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
     * @return handleTime(处理日期)
     */
    public Date getHandleTime() {
        return handleTime;
    }

    /**
     * @param handleTime 要设置的 handleTime(处理日期)
     */
    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
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
     * @return moveTime(调动日期)
     */
    public Date getMoveTime() {
        return moveTime;
    }

    /**
     * @param moveTime 要设置的 moveTime(调动日期)
     */
    public void setMoveTime(Date moveTime) {
        this.moveTime = moveTime;
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
     * @return personDetailId(被接种人个人ID)
     */
    public BigDecimal getPersonDetailId() {
        return personDetailId;
    }

    /**
     * @param personDetailId 要设置的 personDetailId(被接种人个人ID)
     */
    public void setPersonDetailId(BigDecimal personDetailId) {
        this.personDetailId = personDetailId;
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
