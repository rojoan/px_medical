package com.bofan.publichealth.gravida.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;

/**
 * @Description: 孕妇孕期检查/手术方式表
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.gravida.valueobject.GravidaSurgeryWay ", orderBy = "gravideSurgeryWayId asc")
public class GravidaSurgeryWayQueryInfo extends BaseCommandInfo {
 
    private static final long serialVersionUID = 5747132770294419954L;
    /** 产前手术记录ID，自动增长ID */
    private Long gravidaSurgeryId;

	/** default constructor */
	public GravidaSurgeryWayQueryInfo() {
	}

	/**
	 * @param gravidaSurgeryId
	 */
    public GravidaSurgeryWayQueryInfo(Long gravidaSurgeryId) {
        this.gravidaSurgeryId = gravidaSurgeryId;
    }

    /**
     * @return gravidaSurgeryId
     */
    public Long getGravidaSurgeryId() {
        return gravidaSurgeryId;
    }

    /**
     * @param gravidaSurgeryId 要设置的 gravidaSurgeryId
     */
    public void setGravidaSurgeryId(Long gravidaSurgeryId) {
        this.gravidaSurgeryId = gravidaSurgeryId;
    }

}