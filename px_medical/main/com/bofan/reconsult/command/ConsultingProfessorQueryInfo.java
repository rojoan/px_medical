package com.bofan.reconsult.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description
 * @author xlf
 * @version 1.0
 * 2017-10-02
 */
@SuppressWarnings("serial")
@QueryInfo(from = "com.bofan.reconsult.valueobject.ReConsultingProfessor vm", orderBy=" vm.consulting.consultingStatus asc, vm.consulting.reConsultingTime desc")
public class ConsultingProfessorQueryInfo extends BaseCommandInfo {

    /** 远程会诊ID */
    @QueryParam(fieldName = "vm.reConsultingId", op = QueryOperator.EQU)
    private Long reConsultingId;
    
    /** 专家主键ID */
    @QueryParam(fieldName = "vm.professorId", op = QueryOperator.EQU)
    private Long reProfessorId ;
    
    /** 会诊状态 */
    @QueryParam(fieldName = "vm.consulting.consultingStatus", op = QueryOperator.EQU)
    private String consultingStatus;
    
    /** 会诊类型  */
    @QueryParam(fieldName = "vm.consulting.consultationType", op = QueryOperator.EQU)
    private String consultationType;
    
    /** 患者姓名 */
    @QueryParam(fieldName = "vm.consulting.patientName", op = QueryOperator.LIKE)
    private String patientName ;
    
    /** 会诊医院 */
    @QueryParam(fieldName = "vm.consulting.medicalInstitutionId", op = QueryOperator.EQU)
    private Long medicalInstitutionId ;
    
    /** 开始申请日期 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @QueryParam(fieldName = "vm.consulting.reApplyTime", op = QueryOperator.GT_EQU)
    private Date beginQueryDate ;
    
    /** 结束申请日期 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @QueryParam(fieldName = "vm.consulting.reApplyTime", op = QueryOperator.LESS_EQU)
    private Date endQueryDate ;

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
     * @return the reProfessorId
     */
    public Long getReProfessorId() {
        return reProfessorId;
    }

    /**
     * @param reProfessorId the reProfessorId to set
     */
    public void setReProfessorId(Long reProfessorId) {
        this.reProfessorId = reProfessorId;
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
    
    
}
