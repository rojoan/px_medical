package com.bofan.pacs.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;


/**
 * @Description: 病人档案信息查询
 * @author lqw
 * @date 2017年9月27日 上午9:36:15 
 * @version V1.0
 */
@QueryInfo( from = "com.bofan.pacs.valueobject.PatientArchive")
public class PatientArchiveQueryInfo extends BaseCommandInfo {
	
	private static final long serialVersionUID = 1L;
	
	@QueryParam(fieldName = "patientArchiveId", op = QueryOperator.EQU)
	private Long patientArchiveId;
	
	@QueryParam
	private String hospitalNo; 
	
	@QueryParam
	private String htFsPacsMark;
	
	@QueryParam
	private String patientArchiveNum;
	
	@QueryParam
	private String patientId;

	/**
	 * @return patientArchiveId
	 */
	public Long getPatientArchiveId() {
		return patientArchiveId;
	}

	/**
	 * @param patientArchiveId 要设置的 patientArchiveId
	 */
	public void setPatientArchiveId(Long patientArchiveId) {
		this.patientArchiveId = patientArchiveId;
	}

	/**
	 * @return hospitalNo
	 */
	public String getHospitalNo() {
		return hospitalNo;
	}

	/**
	 * @param hospitalNo 要设置的 hospitalNo
	 */
	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	/**
	 * @return htFsPacsMark
	 */
	public String getHtFsPacsMark() {
		return htFsPacsMark;
	}

	/**
	 * @param htFsPacsMark 要设置的 htFsPacsMark
	 */
	public void setHtFsPacsMark(String htFsPacsMark) {
		this.htFsPacsMark = htFsPacsMark;
	}

	/**
	 * @return patientArchiveNum
	 */
	public String getPatientArchiveNum() {
		return patientArchiveNum;
	}

	/**
	 * @param patientArchiveNum 要设置的 patientArchiveNum
	 */
	public void setPatientArchiveNum(String patientArchiveNum) {
		this.patientArchiveNum = patientArchiveNum;
	}

    /**
     * @return the patientId
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

     
}