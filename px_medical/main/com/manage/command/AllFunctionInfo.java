/*
 * <p> Title:  AllFunctionInfo.java</p>
 * <p>Copyright:   bofan 2017</p>
 * <p>Company: 博繁科技 </p>
 */
package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;

/**
 * <p> Calss Name:  AllFunctionInfo.java</p>
 * <p> Description:   </p>
 * @version 1.0
 * @author pch
 * @created  2017-10-18
 */
@QueryInfo(from="com.bofan.manage.valueobject.SysFunction", orderBy="sort")
public class AllFunctionInfo extends BaseCommandInfo {
	private static final long serialVersionUID = 3197063984812557255L;
	
	private boolean multi;
	private Long rootId;
	
    public boolean isMulti() {
        return multi;
    }

    public void setMulti(boolean multi) {
        this.multi = multi;
    }

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }
	
}
