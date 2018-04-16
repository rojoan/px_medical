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
@QueryInfo(
        select = "vm.professorId",
        from = "com.bofan.reconsult.valueobject.ReConsultingProfessor vm", 
        orderBy="vm.consulting.reConsultingTime desc, vm.consulting.consultingStatus asc")
public class ConsultingUserIdsQueryInfo extends BaseCommandInfo {

    /** 远程会诊ID */
    @QueryParam(fieldName = "vm.reConsultingId", op = QueryOperator.EQU)
    private Long reConsultingId;
    
    /**
	 * @return the reConsultingId
	 */
	public Long getReConsultingId() {
		return reConsultingId;
	}

	/**
	 * @param reConsultingId the reConsultingId to set
	 */
	public void setReConsultingId(Long reConsultingId) {
		this.reConsultingId = reConsultingId;
	}

}
