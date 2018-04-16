package com.bofan.pacs.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryParam;


/**
 * @Description: 检查结果信息查询
 * @author lqw
 * @date 2017年9月27日 上午9:36:15 
 * @version V1.0
 */
@QueryInfo( from = "com.bofan.pacs.valueobject.ExamResult")
public class ExamResultQueryInfo extends BaseCommandInfo {
	
	private static final long serialVersionUID = 1L;
	
	@QueryParam
	private String hospitalNo; 
	
	@QueryParam
	private String htFsPacsMark;
	
	@QueryParam
	private String patientExamNum;

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

	public String getPatientExamNum() {
		return patientExamNum;
	}

	public void setPatientExamNum(String patientExamNum) {
		this.patientExamNum = patientExamNum;
	}
 
}