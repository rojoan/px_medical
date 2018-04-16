package com.bofan.publichealth.gravida.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;

/**
 * @Description: 产前筛查检查/手术记录表 
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.gravida.valueobject.GravidaSurgery ", orderBy = "gravidaSurgeryId asc")
public class GravidaSurgeryQueryInfo extends BaseCommandInfo {
 
    private static final long serialVersionUID = 5747132770294419954L;
    
    /** 产前手术记录ID，自动增长ID */
    private Long gravidaSurgeryId;
    
    /** 孕产妇登记卡ID */
    private Long gravidaDetailId;
    
    /** 个人基本信息ID */
    private Long personDetailId;

	/** default constructor */
	public GravidaSurgeryQueryInfo() {
	}

	/**
	 * @param gravidaDetailId
	 */
    public GravidaSurgeryQueryInfo(Long gravidaDetailId) {
        this.gravidaDetailId = gravidaDetailId;
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

    /**
     * @return gravidaDetailId
     */
    public Long getGravidaDetailId() {
        return gravidaDetailId;
    }

    /**
     * @param gravidaDetailId 要设置的 gravidaDetailId
     */
    public void setGravidaDetailId(Long gravidaDetailId) {
        this.gravidaDetailId = gravidaDetailId;
    }

    /**
     * @return personDetailId
     */
    public Long getPersonDetailId() {
        return personDetailId;
    }

    /**
     * @param personDetailId 要设置的 personDetailId
     */
    public void setPersonDetailId(Long personDetailId) {
        this.personDetailId = personDetailId;
    }

}