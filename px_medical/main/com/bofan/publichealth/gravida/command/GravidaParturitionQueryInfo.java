package com.bofan.publichealth.gravida.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;

/**
 * @Description: 孕妇分娩记录表 分娩记录中新生儿登记
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.gravida.valueobject.GravidaParturition ", orderBy = "gravidaParturitionId asc")
public class GravidaParturitionQueryInfo extends BaseCommandInfo {
 
    private static final long serialVersionUID = 5747132770294419954L;
    
    /** 产前手术记录ID，自动增长ID */
    private Long gravidaParturitionId;
    
    /** 孕产妇登记卡ID */
    private Long gravidaDetailId;
    
    /** 个人基本信息ID */
    private Long personDetailId;

	/** default constructor */
	public GravidaParturitionQueryInfo() {
	}

	/**
	 * @param gravidaDetailId
	 */
    public GravidaParturitionQueryInfo(Long gravidaDetailId) {
        this.gravidaDetailId = gravidaDetailId;
    }

    /**
     * @return gravidaParturitionId
     */
    public Long getGravidaParturitionId() {
        return gravidaParturitionId;
    }

    /**
     * @param gravidaParturitionId 要设置的 gravidaParturitionId
     */
    public void setGravidaParturitionId(Long gravidaParturitionId) {
        this.gravidaParturitionId = gravidaParturitionId;
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