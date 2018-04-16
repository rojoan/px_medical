package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * 0-6岁儿童基本情况登记查询条件参数信息
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@QueryInfo(
        select="cv.childVisitId, cv.ageStageFlag, to_char(cv.visitDate,'yyyy-MM-dd')", 
        from = "com.bofan.publichealth.valueobject.ChildVisit cv ", 
        orderBy = "cv.ageStageFlag asc, cv.childVisitId desc")
public class ChildVisitDateQueryInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -7776152868811303401L;

    @QueryParam(fieldName = "cv.childDetailId", op = QueryOperator.EQU)
    private Long childDetailId;

    /**
     * @return the childDetailId
     */
    public Long getChildDetailId() {
        return childDetailId;
    }

    /**
     * @param childDetailId the childDetailId to set
     */
    public void setChildDetailId(Long childDetailId) {
        this.childDetailId = childDetailId;
    }

}
