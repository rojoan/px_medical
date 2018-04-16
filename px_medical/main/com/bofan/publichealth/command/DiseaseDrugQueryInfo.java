package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.DiseaseDrug cd ", orderBy = "cd.diseaseDrugId desc")
public class DiseaseDrugQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -7776152868811303401L;
    
    @QueryParam(fieldName = "cd.diseaseDrugName", op = QueryOperator.LIKE)
    private String diseaseDrugName;
    
    @QueryParam(fieldName = "cd.diseaseDrugType", op = QueryOperator.EQU)
    private String diseaseDrugType;

    /**
     * @return the diseaseDrugName
     */
    public String getDiseaseDrugName() {
        return diseaseDrugName;
    }

    /**
     * @param diseaseDrugName the diseaseDrugName to set
     */
    public void setDiseaseDrugName(String diseaseDrugName) {
        this.diseaseDrugName = diseaseDrugName;
    }

    /**
     * @return the diseaseDrugType
     */
    public String getDiseaseDrugType() {
        return diseaseDrugType;
    }

    /**
     * @param diseaseDrugType the diseaseDrugType to set
     */
    public void setDiseaseDrugType(String diseaseDrugType) {
        this.diseaseDrugType = diseaseDrugType;
    }


}
