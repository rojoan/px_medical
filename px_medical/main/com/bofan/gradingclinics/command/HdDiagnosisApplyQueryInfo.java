package com.bofan.gradingclinics.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * pressWarnings("serial")
 * @Description: 转诊申请单查询
 * @author lqw
 * @version V1.0
 */
@QueryInfo(
        select = "new Map(hd.patient.patientName as patientName, hd.patient.patientSex as patientSex, hd.patient.patientIdCard as idCard,hd.hdType as hdType,"
        		+ " hd.hdDiagnosisApplyId as hdDiagnosisApplyId, hd.hdDiagnosisNum as hdDiagnosisNum, to_char(hd.applyTime,'yyyy-MM-dd') as applyTime,"
        		+ " hd.transStatus as transStatus, hd.institutionUpName as institutionUpName, hd.officeUpName as officeUpName, hd.doctorUpName as doctorUpName,"
        		+ " hd.institutionDownName as institutionDownName,hd.officeDownName as officeDownName, hd.doctorDownName as doctorDownName)", 
        from = "com.bofan.gradingclinics.valueobject.HdDiagnosisApply hd", 
        orderBy = "hd.hdDiagnosisApplyId desc")
public class HdDiagnosisApplyQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 5267262881584818692L;

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
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "hd.applyTime", op = QueryOperator.GT_EQU)
    private Date beginApplyTime;
    
    /** 结束申请时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
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
    
	/**
	 * @return patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName 要设置的 patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * @return idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard 要设置的 idCard
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return patientCardNo
	 */
	public String getPatientCardNo() {
		return patientCardNo;
	}

	/**
	 * @param patientCardNo 要设置的 patientCardNo
	 */
	public void setPatientCardNo(String patientCardNo) {
		this.patientCardNo = patientCardNo;
	}

	/**
	 * @return beginApplyTime
	 */
	public Date getBeginApplyTime() {
		return beginApplyTime;
	}

	/**
	 * @param beginApplyTime 要设置的 beginApplyTime
	 */
	public void setBeginApplyTime(Date beginApplyTime) {
		this.beginApplyTime = beginApplyTime;
	}

	/**
	 * @return endApplyTime
	 */
	public Date getEndApplyTime() {
		return endApplyTime;
	}

	/**
	 * @param endApplyTime 要设置的 endApplyTime
	 */
	public void setEndApplyTime(Date endApplyTime) {
		this.endApplyTime = endApplyTime;
	}

	/**
	 * @return transStatus
	 */
	public String getTransStatus() {
		return transStatus;
	}

	/**
	 * @param transStatus 要设置的 transStatus
	 */
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}

	/**
	 * @return institutionUpId
	 */
	public Long getInstitutionUpId() {
		return institutionUpId;
	}

	/**
	 * @param institutionUpId 要设置的 institutionUpId
	 */
	public void setInstitutionUpId(Long institutionUpId) {
		this.institutionUpId = institutionUpId;
	}

	/**
	 * @return offficeDownId
	 */
	public Long getOffficeDownId() {
		return offficeDownId;
	}

	/**
	 * @param offficeDownId 要设置的 offficeDownId
	 */
	public void setOffficeDownId(Long offficeDownId) {
		this.offficeDownId = offficeDownId;
	}

	/**
	 * @return hdType
	 */
	public String getHdType() {
		return hdType;
	}

	/**
	 * @param hdType 要设置的 hdType
	 */
	public void setHdType(String hdType) {
		this.hdType = hdType;
	}

	/**
	 * @return institutionDownId
	 */
	public Long getInstitutionDownId() {
		return institutionDownId;
	}

	/**
	 * @param institutionDownId 要设置的 institutionDownId
	 */
	public void setInstitutionDownId(Long institutionDownId) {
		this.institutionDownId = institutionDownId;
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

}
