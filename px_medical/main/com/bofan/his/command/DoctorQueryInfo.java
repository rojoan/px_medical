package com.bofan.his.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 
 * @author xlf
 *
 */
@SuppressWarnings("serial")
@QueryInfo(from = "com.bofan.his.valueobject.Doctor", orderBy = "doctorNo asc")
public class DoctorQueryInfo extends BaseCommandInfo {
    
    /** 所属科室ID */
    @QueryParam(fieldName = "officeId", op = QueryOperator.EQU)
    private Long officeId;
    
    /** 所属医院ID */
    @QueryParam(fieldName = "hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;

    /**
     * @return the officeId
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * @param officeId the officeId to set
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

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
    

}
