package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 慢性病随访--报导内容信息查询参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.PersonVisitContent pvc", orderBy = "pvc.visitContentId asc")
public class PersonVisitContentQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 9065496992044630401L;

    @QueryParam(fieldName = "pvc.personChronicId", op = QueryOperator.EQU)
    private Long personChronicId;
    
    @QueryParam(fieldName = "pvc.chronicVisitId", op = QueryOperator.EQU)
    private Long chronicVisitId;

    @QueryParam(fieldName = "pvc.personDetailId", op = QueryOperator.EQU)
    private Long personDetailId;
    
    @QueryParam(fieldName = "pvc.chronicType", op = QueryOperator.EQU)
    private String chronicType;


    /**
     * @return the personChronicId
     */
    public Long getPersonChronicId() {
        return personChronicId;
    }

    /**
     * @param personChronicId the personChronicId to set
     */
    public void setPersonChronicId(Long personChronicId) {
        this.personChronicId = personChronicId;
    }

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
