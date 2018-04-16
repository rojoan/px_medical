package com.bofan.publichealth.command;

import com.bofan.infoql.QueryInfo;
import com.bofan.utils.Contstants;

/**
 * 儿童体检(检查)查询条件参数信息
 * 
 * @Description
 * @author wmg 2017-02-05
 */
@QueryInfo(select = "new Map(to_char(ec.examTime, 'yyyy-MM') as name, count(*) as y)", from = "com.bofan.publichealth.valueobject.ExamChild ec ", groupBy = "to_char(ec.examTime, 'yyyy-MM')", orderBy = "to_char(ec.examTime, 'yyyy-MM') asc", where = "ec.validFlag = "
        + Contstants.YES_FLAG)
public class ExamChildMonthNumCalcInfo extends ExamChildQueryInfo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

}
