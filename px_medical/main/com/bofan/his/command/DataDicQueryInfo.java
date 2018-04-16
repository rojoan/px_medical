package com.bofan.his.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;

/**
 * 查询科室数据配置
 * @Description
 * @author xlf
 * @version 
 * 2017-10-12
 */
@SuppressWarnings("serial")
@QueryInfo(
        select = "new Map(dic.dataNo as officeId, dic.name as name)", 
        from = "com.bofan.his.valueobject.Datadic dic", 
        where = "dic.type = '74'", 
        orderBy = "dic.dataNo asc")
public class DataDicQueryInfo extends BaseCommandInfo {

}
