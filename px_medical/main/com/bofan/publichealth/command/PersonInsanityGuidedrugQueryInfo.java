package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 居民健康体检个人用药情况信息查询参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(from = "com.bofan.publichealth.valueobject.PersonInsanityGuidedrug pig", orderBy = "pig.personInsanityGuidedrugId asc")
public class PersonInsanityGuidedrugQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 9065496992044630401L;

    @QueryParam(fieldName = "pig.personInsanityId", op = QueryOperator.EQU)
    private Long personInsanityId;

    @QueryParam(fieldName = "pig.personDetailId", op = QueryOperator.EQU)
    private Long personDetailId;
    
    @QueryParam(fieldName = "pig.personInsanityVisitId", op = QueryOperator.EQU)
    private Long personInsanityVisitId;

    /**
     * @return the personInsanityId
     */
    public Long getPersonInsanityId() {
        return personInsanityId;
    }

    /**
     * @param personInsanityId the personInsanityId to set
     */
    public void setPersonInsanityId(Long personInsanityId) {
        this.personInsanityId = personInsanityId;
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
     * @return the personInsanityVisitId
     */
    public Long getPersonInsanityVisitId() {
        return personInsanityVisitId;
    }

    /**
     * @param personInsanityVisitId the personInsanityVisitId to set
     */
    public void setPersonInsanityVisitId(Long personInsanityVisitId) {
        this.personInsanityVisitId = personInsanityVisitId;
    }

}
