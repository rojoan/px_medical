package com.bofan.publichealth.gravida.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;


/**
 * @Description: 孕产妇登记卡查询
 * @author lqw
 */
@QueryInfo( from = "com.bofan.publichealth.gravida.valueobject.GravidaDetail g ",  orderBy = "g.gravidaDetailId desc")
public class GravidaDetailQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;

    /** 医院标识 */
    @QueryParam(fieldName = "g.hospitalId", op = QueryOperator.EQU)
    private Long hospitalId;
    
	/** 个人基本信息ID */
	@QueryParam(fieldName = "g.personDetailId", op = QueryOperator.EQU)
    private Long personDetailId;
    
	/** 保健卡号 */
	@QueryParam(fieldName = "g.gravidaCard", op = QueryOperator.LIKE)
	private String gravidaCard;
	
	/** 孕妇姓名 */
	@QueryParam(fieldName = "g.gravidaName", op = QueryOperator.LIKE)
	private String gravidaName;
	
	/** 身份证号码 */
	@QueryParam(fieldName = "g.gravidaIdCard", op = QueryOperator.LIKE)
	private String gravidaIdCard;

	/** 是否定义为高危孕妇 1=是 0=否 */
	@QueryParam(fieldName = "g.highRiskPregnancy", op = QueryOperator.EQU)
    private String highRiskPregnancy;
    
    /** 是否有效 1=有效 0=无效 */
    @QueryParam(fieldName = "g.validFlag", op = QueryOperator.EQU)
    private String validFlag;
    
    
	/**
     * @return hospitalId
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId 要设置的 hospitalId
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
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

    /**
     * @return highRiskPregnancy
     */
    public String getHighRiskPregnancy() {
        return highRiskPregnancy;
    }

    /**
     * @param highRiskPregnancy 要设置的 highRiskPregnancy
     */
    public void setHighRiskPregnancy(String highRiskPregnancy) {
        this.highRiskPregnancy = highRiskPregnancy;
    }

    /**
     * @return validFlag
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag 要设置的 validFlag
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }
    
}