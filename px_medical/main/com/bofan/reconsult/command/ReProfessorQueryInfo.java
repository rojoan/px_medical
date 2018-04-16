package com.bofan.reconsult.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description
 * @author xlf
 * @version 1.0
 * 2017-10-02
 */
@SuppressWarnings("serial")
@QueryInfo(from = "com.bofan.reconsult.valueobject.ReProfessor vm")
public class ReProfessorQueryInfo extends BaseCommandInfo {
    
    @QueryParam(fieldName = "vm.professorId", op = QueryOperator.EQU)
    private String professorId ;

	/**
	 * @return the professorId
	 */
	public String getProfessorId() {
		return professorId;
	}

	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

}
