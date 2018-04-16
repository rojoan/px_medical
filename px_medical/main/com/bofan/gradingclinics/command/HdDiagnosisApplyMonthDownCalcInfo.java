package com.bofan.gradingclinics.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 转诊申请单数据统计条件参数信息
 * 
 * @Description
 * @author wmg 2017-02-11
 */
@QueryInfo(select = "new Map(hd.institutionDownId, hd.institutionDownName as name, count(*) as y)",
        from = "com.bofan.gradingclinics.valueobject.HdDiagnosisApply hd", groupBy = "hd.institutionDownId, hd.institutionDownName", orderBy = "hd.institutionDownId asc"
// where = "hd.transStatus <> ‘" + Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_STORE
// + "'",
)

public class HdDiagnosisApplyMonthDownCalcInfo extends HdDiagnosisApplyQueryInfo {
    /**
     * 序列化版本id,默认版本号1L
     */
    private static final long serialVersionUID = 1L;
    // 周期类别:0所有时期,1年，2半年，3季，4月，5，周，6日，7时，9自定义时期, @DataCycleType
    private String cycleType;
    // 数据周期，用来传递周期信息
    private String dataCycle;
    /** 患者姓名 */
    @QueryParam(fieldName = "hd.patient.patientName", op = QueryOperator.LIKE)
    private String patientName;

    /** 身份证号 */
    @QueryParam(fieldName = "hd.patient.patientIdCard", op = QueryOperator.LIKE)
    private String idCard;

    /** 病人就诊卡号 **/
    @QueryParam(fieldName = "hd.patient.patientCardNo", op = QueryOperator.LIKE)
    private String patientCardNo;

    /** 开始申请时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @QueryParam(fieldName = "hd.applyTime", op = QueryOperator.GT_EQU)
    private Date beginApplyTime;

    /** 结束申请时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @QueryParam(fieldName = "hd.applyTime", op = QueryOperator.LESS_EQU)
    private Date endApplyTime;

    /** 转诊状态 0：暂存 1：已申请待审核 2：已审核待接诊 3：已接诊待患者就诊 4：已到医院就诊 5：取消转诊 **/
    @QueryParam(fieldName = "hd.transStatus", op = QueryOperator.EQU)
    private String transStatus;

    @QueryParam(fieldName = "hd.transStatus", op = QueryOperator.IN)
    private String[] transStatusIn;

    @QueryParam(fieldName = "hd.transStatus", op = QueryOperator.NOT_IN)
    private String[] transStatusNotIn;

    /** 转入医院ID MEDICALINSTITUTION（医疗机构） 主键ID **/
    @QueryParam(fieldName = "hd.institutionUpId", op = QueryOperator.EQU)
    private Long institutionUpId;

    /** 转出科室ID **/
    @QueryParam(fieldName = "hd.offficeDownId", op = QueryOperator.EQU)
    private Long offficeDownId;

    /** 转出医院ID **/
    @QueryParam(fieldName = "hd.institutionDownId", op = QueryOperator.EQU)
    private Long institutionDownId;

    /** 转诊类型 1：上转 2：下转 **/
    @QueryParam(fieldName = "hd.hdType", op = QueryOperator.EQU)
    private String hdType;
    public String getDataCycle() {
        return dataCycle;
    }


    public void setDataCycle(String dataCycle) {
        this.dataCycle = dataCycle;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPatientCardNo() {
        return patientCardNo;
    }

    public void setPatientCardNo(String patientCardNo) {
        this.patientCardNo = patientCardNo;
    }

    public Date getBeginApplyTime() {
        return beginApplyTime;
    }

    public void setBeginApplyTime(Date beginApplyTime) {
        this.beginApplyTime = beginApplyTime;
    }

    public Date getEndApplyTime() {
        return endApplyTime;
    }

    public void setEndApplyTime(Date endApplyTime) {
        this.endApplyTime = endApplyTime;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public String[] getTransStatusIn() {
        return transStatusIn;
    }

    public void setTransStatusIn(String[] transStatusIn) {
        this.transStatusIn = transStatusIn;
    }

    public String[] getTransStatusNotIn() {
        return transStatusNotIn;
    }

    public void setTransStatusNotIn(String[] transStatusNotIn) {
        this.transStatusNotIn = transStatusNotIn;
    }

    public Long getInstitutionUpId() {
        return institutionUpId;
    }

    public void setInstitutionUpId(Long institutionUpId) {
        this.institutionUpId = institutionUpId;
    }

    public Long getOffficeDownId() {
        return offficeDownId;
    }

    public void setOffficeDownId(Long offficeDownId) {
        this.offficeDownId = offficeDownId;
    }

    public Long getInstitutionDownId() {
        return institutionDownId;
    }

    public void setInstitutionDownId(Long institutionDownId) {
        this.institutionDownId = institutionDownId;
    }

    public String getHdType() {
        return hdType;
    }

    public void setHdType(String hdType) {
        this.hdType = hdType;
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

}
