package  com.bofan.publichealth.vaccine.command;
import java.lang.Long;
import java.util.Date;
import java.lang.String;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description:  包含家庭居住条件和卫生设施编辑
 * @author wmg
 */
public class  VaccinationCardEditInfo extends BaseCommandInfo {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

     /** 预防接种卡ID */
    private Long vaccinationCardId;

    /** 被接种人--儿童基本信息ID（与个人基本信息ID不能同时为空）  对应  child_detail（儿童基本信息表） 主键ID */
    private Long childDetailId;

    /** 传染病史 */
    private String contagionHistory;

    /** 建卡日期 */
    private Date createTime;

    /** 建卡人ID */
    private Long creatorId;

    /** 建卡人 */
    private String creatorName;

    /** 操作（填写）时间 */
    private Date fillTime;

    /** 被接种人--监护人姓名 */
    private String guardiansName;

    /** 监护人与儿童的关系 */
    private String guardiansRelation;

    /** 医疗机构ID  对应sys_org表的 主键ID */
    private Long hospitalId;

    /** 医疗机构名称 */
    private String hospitalName;

    /** 医院编码（医疗机构代码）  对应sys_org 表中的 org_no  */
    private String hospitalNo;

    /** 迁入时间 */
    private Date moveInTime;

    /** 迁出时间 */
    private Date moveOutTime;

    /** 迁出原因 */
    private String moveReason;

    /** 被接种人个人基本信息ID  对应  person_detail（个人基本信息表） 主键ID */
    private Long personDetailId;

    /** 行政区域--城镇街道ID  分三级管理  省（直辖市） ：001 市（地区）     ：001001 县（城区）     ：001001001 */
    private String regionId;

    /** 被接种人--姓名（冗余字段） */
    private String vaccinatedName;

    /** 被接种人（监护人）联系电话 */
    private String vaccinatedPhone;

    /** 预防接种卡编号 */
    private String vaccinationCardNo;

    /** 疫苗异常反应史 */
    private String vaccineUnReaction;

    /** 是否有效 */
    private String validFlag;


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
     * @return createTime(建卡日期)
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 要设置的 createTime(建卡日期)
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
     * @return fillTime(填写时间)
     */
    public Date getFillTime() {
        return fillTime;
    }

    /**
     * @param fillTime 要设置的 fillTime(填写时间)
     */
    public void setFillTime(Date fillTime) {
        this.fillTime = fillTime;
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
     * @return moveInTime(迁入时间)
     */
    public Date getMoveInTime() {
        return moveInTime;
    }

    /**
     * @param moveInTime 要设置的 moveInTime(迁入时间)
     */
    public void setMoveInTime(Date moveInTime) {
        this.moveInTime = moveInTime;
    }

    /**
     * @return moveOutTime(迁出时间)
     */
    public Date getMoveOutTime() {
        return moveOutTime;
    }

    /**
     * @param moveOutTime 要设置的 moveOutTime(迁出时间)
     */
    public void setMoveOutTime(Date moveOutTime) {
        this.moveOutTime = moveOutTime;
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
