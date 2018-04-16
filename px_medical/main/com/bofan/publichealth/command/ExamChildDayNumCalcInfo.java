package com.bofan.publichealth.command;

import com.bofan.infoql.QueryInfo;
import com.bofan.utils.Contstants;

/**
 * 儿童体检(检查)查询条件参数信息
 * 
 * @Description
 * @author wmg 2017-02-05
 */
@QueryInfo(select = "new Map(to_char(ec.examTime, 'yyyy-MM-dd') as name, count(*) as y)", from = "com.bofan.publichealth.valueobject.ExamChild ec ", groupBy = "to_char(ec.examTime, 'yyyy-MM-dd')", orderBy = "to_char(ec.examTime, 'yyyy-MM-dd') asc", where = "ec.validFlag = "
        + Contstants.YES_FLAG)
public class ExamChildDayNumCalcInfo extends ExamChildQueryInfo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    // 数据周期，用来传递周期信息
    private String dataCycle;

    public String getDataCycle() {
        return dataCycle;
    }

    public void setDataCycle(String dataCycle) {
        this.dataCycle = dataCycle;
    }

}
