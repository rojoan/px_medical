package com.bofan.his.command;


import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

@SuppressWarnings("serial")
@QueryInfo(from = "com.bofan.his.valueobject.Office", orderBy = "officeNo asc")
public class OfficeQueryInfo extends BaseCommandInfo {
    
    /** 所属医院ID */
    @QueryParam(fieldName = "hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
    /** 机构编码 */
    @QueryParam(fieldName = "hospitalNo", op = QueryOperator.EQU)
    private Long hospitalNo;
   
    /** 科室主键 */
    @QueryParam(fieldName = "officeId", op = QueryOperator.EQU)
    private Long officeId;
    
    /**
     * @return the hospitalId
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId the hospitalId to set
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

	/**
	 * @return hospitalNo
	 */
	public Long getHospitalNo() {
		return hospitalNo;
	}

	/**
	 * @param hospitalNo 要设置的 hospitalNo
	 */
	public void setHospitalNo(Long hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	/**
	 * @return officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId 要设置的 officeId
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
    
    
}
