package com.bofan.pacs.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;


/**
 * @ClassName: ClinicDepQueryInfo.java 
 * @Package com.bofan.command 
 * @Description: 病人检查信息查询
 * @author lqw
 * @date 2017年9月27日 上午9:36:15 
 * @version V1.0
 */
@QueryInfo( from = "com.bofan.pacs.valueobject.PatientExam")
public class PatientExamQueryInfo extends BaseCommandInfo {
	
	private static final long serialVersionUID = 1L;
	/** 根据医院编码获取 SysOrg 的org_id */
	@QueryParam(fieldName = "orgId", op = QueryOperator.EQU)
	private Long orgId;
	
	@QueryParam(fieldName = "hospitalNo", op = QueryOperator.EQU)
	private String hospitalNo; 
	
	@QueryParam(fieldName = "htFsPacsMark", op = QueryOperator.EQU)
	private String htFsPacsMark;
	
	@QueryParam(fieldName = "patientExamId", op = QueryOperator.EQU)
	private Long patientExamId;
	
	@QueryParam(fieldName = "patientExamNum", op = QueryOperator.EQU)
	private String patientExamNum;
	
	/** 病人类别（对应病人来源字段中文的解析） 1=住院 2=门诊 3=住院急诊 4=门诊急诊 5=体检 */
	@QueryParam(fieldName = "patientType", op = QueryOperator.EQU)
    private Long patientType;
    
    /** 检查HIS号 对应HIS的patient表的patientid */
	@QueryParam(fieldName = "patientId", op = QueryOperator.EQU)
    private Long patientId;
    
    /*** HIS辅助号（ 病人门诊住院唯一号） 根据病人类别对应  
     * 门诊--对应云HIS系统   REGISTATION（门诊挂号）的主键ID 住院--对应云HIS系统    HOSPITALREGISTER（住院登记）的主键ID*/
	@QueryParam(fieldName = "inpatientId", op = QueryOperator.EQU)
    private Long inpatientId;
	

	/**
	 * @return orgId
	 */
	public Long getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId 要设置的 orgId
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getHospitalNo() {
		return hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getHtFsPacsMark() {
		return htFsPacsMark;
	}

	public void setHtFsPacsMark(String htFsPacsMark) {
		this.htFsPacsMark = htFsPacsMark;
	}

	public Long getPatientExamId() {
		return patientExamId;
	}

	public void setPatientExamId(Long patientExamId) {
		this.patientExamId = patientExamId;
	}

	public String getPatientExamNum() {
		return patientExamNum;
	}

	public void setPatientExamNum(String patientExamNum) {
		this.patientExamNum = patientExamNum;
	}

    /**
     * @return the patientType
     */
    public Long getPatientType() {
        return patientType;
    }

    /**
     * @param patientType the patientType to set
     */
    public void setPatientType(Long patientType) {
        this.patientType = patientType;
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
     * @return the inpatientId
     */
    public Long getInpatientId() {
        return inpatientId;
    }

    /**
     * @param inpatientId the inpatientId to set
     */
    public void setInpatientId(Long inpatientId) {
        this.inpatientId = inpatientId;
    }
	
}