package com.bofan.reconsult.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

@QueryInfo(from = "com.bofan.reconsult.valueobject.ReConsulting rc", orderBy = "rc.reApplyTime desc, rc.reConsultingId desc")
public class ReConsultingQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -9044087050640885756L;
    /** 创建时间查询类型  */
    private static final String QUERY_DATE_CREATE = "create";
    /** 创建申请查询类型  */
    private static final String QUERY_DATE_APPLY = "apply";
    /** 创建会诊查询类型  */
    private static final String QUERY_DATE_CONSULT = "consult";
    /** 创建完成查询类型  */
    private static final String QUERY_DATE_FINISH = "finish";
    
    /** 查询字段  */
    private String queryField;
    
    /** 查询关键词 */
    private String keyword;
    
    /** 查询时间类型 */
    private String queryDateType;
    
    /** 开始查询日期  */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date beginQueryDate;
    
    /** 结束查询日期  */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endQueryDate;

    /** 会诊主键ID **/
    @QueryParam(fieldName = "rc.reConsultingId", op = QueryOperator.EQU)
    private Long reConsultingId;
    
    /** 发起人ID **/
    @QueryParam(fieldName = "rc.proposerId", op = QueryOperator.EQU)
    private Long proposerId;
    
    /** 患者主键ID **/
    @QueryParam(fieldName = "rc.patientId", op = QueryOperator.EQU)
    private Long patientId;
    
    /** 患者主键ID **/
    @QueryParam(fieldName = "rc.patientExamId", op = QueryOperator.EQU)
    private Long patientExamId;
    
    /** 对应LIS系统  lis_inspection_sample（检验样本信息表）的主键ID **/
    @QueryParam(fieldName = "rc.lisInspectionSampleId", op = QueryOperator.EQU)
    private Long lisInspectionSampleId;
    
    /** RIS病人检查表 ID主键 **/
    @QueryParam(fieldName = "rc.risInspectionId", op = QueryOperator.EQU)
    private Long risInspectionId;
    
    /** 会诊状态(用户不等于查询) **/
    @QueryParam(fieldName = "rc.consultingStatus", op = QueryOperator.NOT_EQU)
    private String notEquStatus;
    
    /** 会诊状态 **/
    @QueryParam(fieldName = "rc.consultingStatus", op = QueryOperator.EQU)
    private String consultingStatus;
    
    /** 会诊类型  */
    @QueryParam(fieldName = "rc.consultationType", op = QueryOperator.EQU)
    private String consultationType;
    
    /** 开始查询日期（创建日期）  */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "rc.reCreateTime", op = QueryOperator.GT_EQU)
    private Date beginCreateDate;
    
    /** 结束查询日期（创建日期）  */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @QueryParam(fieldName = "rc.reCreateTime", op = QueryOperator.LESS_EQU)
    private Date endCreateDate;
    
    /** 开始查询日期（申请日期）  */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "rc.reApplyTime", op = QueryOperator.GT_EQU)
    private Date beginApplyDate;
    
    /** 结束查询日期（申请日期）  */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @QueryParam(fieldName = "rc.reApplyTime", op = QueryOperator.LESS_EQU)
    private Date endApplyDate;
    
    /** 开始查询日期（会诊日期）  */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "rc.reConsultingTime", op = QueryOperator.GT_EQU)
    private Date beginConsultDate;
    
    /** 结束查询日期（会诊日期）  */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @QueryParam(fieldName = "rc.reConsultingTime", op = QueryOperator.LESS_EQU)
    private Date endConsultDate;
    
    /** 开始查询日期（完成日期）  */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "rc.reConsultingEnd", op = QueryOperator.GT_EQU)
    private Date beginFinishDate;
    
    /** 结束查询日期（完成日期）  */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @QueryParam(fieldName = "rc.reConsultingEnd", op = QueryOperator.LESS_EQU)
    private Date endFinishDate;
    
    /** 患者姓名 */
    @QueryParam(fieldName = "rc.patientName", op = QueryOperator.LIKE)
    private String patientName;
    
    /** 医疗结构Id */
    @QueryParam(fieldName = "rc.medicalInstitutionId", op = QueryOperator.EQU)
    private Long medicalInstitutionId;
    
    /**
     * 处理查询日期时间类型
     */
    public void handleQueryDate() {
        if (QUERY_DATE_CREATE.equals(this.queryDateType)) {
            this.setBeginCreateDate(this.getBeginQueryDate());
            this.setEndCreateDate(this.getEndQueryDate());
        }
        if (QUERY_DATE_APPLY.equals(this.queryDateType)) {
            this.setBeginApplyDate(this.getBeginQueryDate());
            this.setEndApplyDate(this.getEndQueryDate());
        }
        if (QUERY_DATE_CONSULT.equals(this.queryDateType)) {
            this.setBeginConsultDate(this.getBeginQueryDate());
            this.setEndConsultDate(this.getEndQueryDate());
        }
        if (QUERY_DATE_FINISH.equals(this.queryDateType)) {
            this.setBeginFinishDate(this.getBeginQueryDate());
            this.setEndFinishDate(this.getEndQueryDate());
        }
    }

    /**
     * @return the patientId
     */
    public Long getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the patientExamId
     */
    public Long getPatientExamId() {
        return patientExamId;
    }

    /**
     * @param patientExamId the patientExamId to set
     */
    public void setPatientExamId(Long patientExamId) {
        this.patientExamId = patientExamId;
    }

    /**
     * @return the lisInspectionSampleId
     */
    public Long getLisInspectionSampleId() {
        return lisInspectionSampleId;
    }

    /**
     * @param lisInspectionSampleId the lisInspectionSampleId to set
     */
    public void setLisInspectionSampleId(Long lisInspectionSampleId) {
        this.lisInspectionSampleId = lisInspectionSampleId;
    }

    /**
     * @return the risInspectionId
     */
    public Long getRisInspectionId() {
        return risInspectionId;
    }

    /**
     * @param risInspectionId the risInspectionId to set
     */
    public void setRisInspectionId(Long risInspectionId) {
        this.risInspectionId = risInspectionId;
    }

    /**
	 * @return the reConsultingId
	 */
	public Long getReConsultingId() {
		return reConsultingId;
	}

	/**
	 * @param reConsultingId the reConsultingId to set
	 */
	public void setReConsultingId(Long reConsultingId) {
		this.reConsultingId = reConsultingId;
	}

	/**
     * @return the proposerId
     */
    public Long getProposerId() {
        return proposerId;
    }

    /**
     * @param proposerId the proposerId to set
     */
    public void setProposerId(Long proposerId) {
        this.proposerId = proposerId;
    }

    /**
     * @return the notEquStatus
     */
    public String getNotEquStatus() {
        return notEquStatus;
    }

    /**
     * @param notEquStatus the notEquStatus to set
     */
    public void setNotEquStatus(String notEquStatus) {
        this.notEquStatus = notEquStatus;
    }

    /**
     * @return the consultingStatus
     */
    public String getConsultingStatus() {
        return consultingStatus;
    }

    /**
     * @param consultingStatus the consultingStatus to set
     */
    public void setConsultingStatus(String consultingStatus) {
        this.consultingStatus = consultingStatus;
    }

    /**
     * @return the queryField
     */
    public String getQueryField() {
        return queryField;
    }

    /**
     * @param queryField the queryField to set
     */
    public void setQueryField(String queryField) {
        this.queryField = queryField;
    }

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the consultationType
     */
    public String getConsultationType() {
        return consultationType;
    }

    /**
     * @param consultationType the consultationType to set
     */
    public void setConsultationType(String consultationType) {
        this.consultationType = consultationType;
    }

    /**
     * @return the beginApplyDate
     */
    public Date getBeginCreateDate() {
        return beginCreateDate;
    }

    /**
     * @param beginCreateDate the beginCreateDate to set
     */
    public void setBeginCreateDate(Date beginCreateDate) {
        this.beginCreateDate = beginCreateDate;
    }

    /**
     * @return the endCreateDate
     */
    public Date getEndCreateDate() {
        return endCreateDate;
    }

    /**
     * @param endCreateDate the endCreateDate to set
     */
    public void setEndCreateDate(Date endCreateDate) {
        this.endCreateDate = endCreateDate;
    }

    /**
     * @return the queryDateType
     */
    public String getQueryDateType() {
        return queryDateType;
    }

    /**
     * @param queryDateType the queryDateType to set
     */
    public void setQueryDateType(String queryDateType) {
        this.queryDateType = queryDateType;
    }

    /**
     * @return the beginQueryDate
     */
    public Date getBeginQueryDate() {
        return beginQueryDate;
    }

    /**
     * @param beginQueryDate the beginQueryDate to set
     */
    public void setBeginQueryDate(Date beginQueryDate) {
        this.beginQueryDate = beginQueryDate;
    }

    /**
     * @return the endQueryDate
     */
    public Date getEndQueryDate() {
        return endQueryDate;
    }

    /**
     * @param endQueryDate the endQueryDate to set
     */
    public void setEndQueryDate(Date endQueryDate) {
        this.endQueryDate = endQueryDate;
    }

    /**
     * @return the beginApplyDate
     */
    public Date getBeginApplyDate() {
        return beginApplyDate;
    }

    /**
     * @param beginApplyDate the beginApplyDate to set
     */
    public void setBeginApplyDate(Date beginApplyDate) {
        this.beginApplyDate = beginApplyDate;
    }

    /**
     * @return the endApplyDate
     */
    public Date getEndApplyDate() {
        return endApplyDate;
    }

    /**
     * @param endApplyDate the endApplyDate to set
     */
    public void setEndApplyDate(Date endApplyDate) {
        this.endApplyDate = endApplyDate;
    }

    /**
     * @return the beginConsultDate
     */
    public Date getBeginConsultDate() {
        return beginConsultDate;
    }

    /**
     * @param beginConsultDate the beginConsultDate to set
     */
    public void setBeginConsultDate(Date beginConsultDate) {
        this.beginConsultDate = beginConsultDate;
    }

    /**
     * @return the endConsultDate
     */
    public Date getEndConsultDate() {
        return endConsultDate;
    }

    /**
     * @param endConsultDate the endConsultDate to set
     */
    public void setEndConsultDate(Date endConsultDate) {
        this.endConsultDate = endConsultDate;
    }

    /**
     * @return the beginFinishDate
     */
    public Date getBeginFinishDate() {
        return beginFinishDate;
    }

    /**
     * @param beginFinishDate the beginFinishDate to set
     */
    public void setBeginFinishDate(Date beginFinishDate) {
        this.beginFinishDate = beginFinishDate;
    }

    /**
     * @return the endFinishDate
     */
    public Date getEndFinishDate() {
        return endFinishDate;
    }

    /**
     * @param endFinishDate the endFinishDate to set
     */
    public void setEndFinishDate(Date endFinishDate) {
        this.endFinishDate = endFinishDate;
    }

    /**
     * @return the patientName
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * @param patientName the patientName to set
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * @return the medicalInstitutionId
     */
    public Long getMedicalInstitutionId() {
        return medicalInstitutionId;
    }

    /**
     * @param medicalInstitutionId the medicalInstitutionId to set
     */
    public void setMedicalInstitutionId(Long medicalInstitutionId) {
        this.medicalInstitutionId = medicalInstitutionId;
    }

}
