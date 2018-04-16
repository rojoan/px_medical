package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 慢性病随访--症状查询参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(select = "pvc.symptomId", from = "com.bofan.publichealth.valueobject.PersonVisitChronicSym pvc", orderBy = "pvc.visitChronicSymId asc")
public class PersonVisitChronicSymIdQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 9065496992044630401L;

    @QueryParam(fieldName = "pvc.chronicVisitId", op = QueryOperator.EQU)
    private Long chronicVisitId;

    @QueryParam(fieldName = "pvc.personDetailId", op = QueryOperator.EQU)
    private Long personDetailId;
    
    @QueryParam(fieldName = "pvc.chronicType", op = QueryOperator.EQU)
    private String chronicType;

    /**
     * @return the chronicVisitId
     */
    public Long getChronicVisitId() {
        return chronicVisitId;
    }

    /**
     * @param chronicVisitId the chronicVisitId to set
     */
    public void setChronicVisitId(Long chronicVisitId) {
        this.chronicVisitId = chronicVisitId;
    }

    /**
     * @return the personDetailId
     */
    public Long getPersonDetailId() {
        return personDetailId;
    }

    /**
     * @param personDetailId the personDetailId to set
     */
    public void setPersonDetailId(Long personDetailId) {
        this.personDetailId = personDetailId;
    }

    /**
     * @return the chronicType
     */
    public String getChronicType() {
        return chronicType;
    }

    /**
     * @param chronicType the chronicType to set
     */
    public void setChronicType(String chronicType) {
        this.chronicType = chronicType;
    }

}
