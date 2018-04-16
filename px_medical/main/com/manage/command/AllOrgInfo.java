package com.manage.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

@QueryInfo(from="com.bofan.manage.valueobject.SysOrg", orderBy="sort")
public class AllOrgInfo extends BaseCommandInfo {
	private static final long serialVersionUID = 3461858042844522574L;
	
	@QueryParam
	private String delFlag;
	
	
	@QueryParam(fieldName="code", op = QueryOperator.RIGHTLIKE)
    private String topCode; //������λ
	
	public AllOrgInfo(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

    public String getTopCode() {
        return topCode;
    }

    public void setTopCode(String topCode) {
        this.topCode = topCode;
    }
}
