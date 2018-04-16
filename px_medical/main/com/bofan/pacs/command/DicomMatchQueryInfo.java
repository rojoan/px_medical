package com.bofan.pacs.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryParam;


/**
 * @Description: 图像匹配信息查询
 * @author lqw
 * @date 2017年9月27日 上午9:36:15 
 * @version V1.0
 */
@QueryInfo( from = "com.bofan.pacs.valueobject.DicomMatch")
public class DicomMatchQueryInfo extends BaseCommandInfo {
	
	private static final long serialVersionUID = 1L;
	
	@QueryParam
	private String hospitalNo; 
	
	@QueryParam
	private String htFsPacsMark;
	
	@QueryParam
	private Long dicomMatchNum;
	
	/**  病人检查号  */
	@QueryParam
	private String patientExamNum;

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
	 * @return dicomMatchNum
	 */
	public Long getDicomMatchNum() {
		return dicomMatchNum;
	}

	/**
	 * @param dicomMatchNum 要设置的 dicomMatchNum
	 */
	public void setDicomMatchNum(Long dicomMatchNum) {
		this.dicomMatchNum = dicomMatchNum;
	}

	/**
	 * @return patientExamNum
	 */
	public String getPatientExamNum() {
		return patientExamNum;
	}

	/**
	 * @param patientExamNum 要设置的 patientExamNum
	 */
	public void setPatientExamNum(String patientExamNum) {
		this.patientExamNum = patientExamNum;
	}
}