package com.bofan.pacs.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;


/**
 * @ClassName: PacsDetailQueryInfo.java 
 * @Description: 检查方式查询
 * @author lqw
 * @date 2017年9月27日 上午9:36:15 
 * @version V1.0
 */
@QueryInfo( from = "com.bofan.pacs.valueobject.PacsDetail")
public class PacsDetailQueryInfo extends BaseCommandInfo {
	
	private static final long serialVersionUID = 1L;
	
	@QueryParam(fieldName = "hospitalNo", op = QueryOperator.EQU)
	private String hospitalNo; 
	
	@QueryParam(fieldName = "htFsPacsMark", op = QueryOperator.EQU)
	private String htFsPacsMark;
	
	@QueryParam(fieldName="dicomFileName",op = QueryOperator.EQU)
	private String dicomFileName;

	/** bdb数据库关键字 */
    @QueryParam(fieldName="bdbKey",op = QueryOperator.EQU)
	private String bdbKey;
    
    /** 病人id -- 对应 patientExam 主键id **/
    @QueryParam(fieldName="patientId",op = QueryOperator.EQU)
	private String patientId;
    
    /** default construction */
	public PacsDetailQueryInfo() {
    }

	/**
	 * @param patientId
	 */
    public PacsDetailQueryInfo(String patientId) {
        this.patientId = patientId;
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

	public String getDicomFileName() {
		return dicomFileName;
	}

	public void setDicomFileName(String dicomFileName) {
		this.dicomFileName = dicomFileName;
	}

	/**
	 * @return bdbKey
	 */
	public String getBdbKey() {
		return bdbKey;
	}

	/**
	 * @param bdbKey 要设置的 bdbKey
	 */
	public void setBdbKey(String bdbKey) {
		this.bdbKey = bdbKey;
	}

	/**
	 * @return patientId
	 */
	public String getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId 要设置的 patientId
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	 
}