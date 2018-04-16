package com.bofan.publichealth.gravida.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 产后访视--42天检查）包括42天后健康检查
 * @author lqw
 */
@QueryInfo(from = "com.bofan.publichealth.gravida.valueobject.PostpartumVisit pv ", orderBy = "pv.postpartumVisitId asc")
public class PostpartumVisitQueryInfo extends BaseCommandInfo {
 
    private static final long serialVersionUID = 5747132770294419954L;
    
    /** 孕产妇登记卡ID */
    @QueryParam(fieldName = "pv.gravidaDetailId", op = QueryOperator.EQU)
    private Long gravidaDetailId;
    
    /** 是否产后42天检查  1=是  0=否 */
    @QueryParam(fieldName = "pv.fortyTwoExamFlag", op = QueryOperator.EQU)
    private String fortyTwoExamFlag;
    
    /** 保健卡号 */
    @QueryParam(fieldName = "pv.gravidaDetail.gravidaCard", op = QueryOperator.LIKE)
    private String gravidaCard;
    
    /** 孕妇姓名 */
    @QueryParam(fieldName = "pv.gravidaDetail.gravidaName", op = QueryOperator.LIKE)
    private String gravidaName;
    
    /** 身份证号码 */
    @QueryParam(fieldName = "pv.gravidaDetail.gravidaIdCard", op = QueryOperator.LIKE)
    private String gravidaIdCard;

	/** default constructor */
	public PostpartumVisitQueryInfo() {
	}

	/**
	 * @param gravidaDetailId
	 */
    public PostpartumVisitQueryInfo(Long gravidaDetailId) {
        this.gravidaDetailId = gravidaDetailId;
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
     * @return fortyTwoExamFlag
     */
    public String getFortyTwoExamFlag() {
        return fortyTwoExamFlag;
    }

    /**
     * @param fortyTwoExamFlag 要设置的 fortyTwoExamFlag
     */
    public void setFortyTwoExamFlag(String fortyTwoExamFlag) {
        this.fortyTwoExamFlag = fortyTwoExamFlag;
    }

    /**
     * @return gravidaCard
     */
    public String getGravidaCard() {
        return gravidaCard;
    }

    /**
     * @param gravidaCard 要设置的 gravidaCard
     */
    public void setGravidaCard(String gravidaCard) {
        this.gravidaCard = gravidaCard;
    }

    /**
     * @return gravidaName
     */
    public String getGravidaName() {
        return gravidaName;
    }

    /**
     * @param gravidaName 要设置的 gravidaName
     */
    public void setGravidaName(String gravidaName) {
        this.gravidaName = gravidaName;
    }

    /**
     * @return gravidaIdCard
     */
    public String getGravidaIdCard() {
        return gravidaIdCard;
    }

    /**
     * @param gravidaIdCard 要设置的 gravidaIdCard
     */
    public void setGravidaIdCard(String gravidaIdCard) {
        this.gravidaIdCard = gravidaIdCard;
    }
}