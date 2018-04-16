package com.bofan.publichealth.gravida.command;

/**
 * @Description: 孕妇孕期检查/手术方式表
 * @author lqw
 */
public class GravidaSurgeryWayEditInfo {

    /** 孕妇孕期检查/手术方式ID，自动增长ID */
	private Long gravideSurgeryWayId;
 
	/** 产前手术记录ID，自动增长ID */
    private Long gravidaSurgeryId;
	
	/** 检查/手术方式ID，自动增长ID */
	private Long surgeryWayId;

	/** default constructor */
	public GravidaSurgeryWayEditInfo() {
	}

    /**
     * @return gravideSurgeryWayId
     */
    public Long getGravideSurgeryWayId() {
        return gravideSurgeryWayId;
    }

    /**
     * @param gravideSurgeryWayId 要设置的 gravideSurgeryWayId
     */
    public void setGravideSurgeryWayId(Long gravideSurgeryWayId) {
        this.gravideSurgeryWayId = gravideSurgeryWayId;
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
     * @return surgeryWayId
     */
    public Long getSurgeryWayId() {
        return surgeryWayId;
    }

    /**
     * @param surgeryWayId 要设置的 surgeryWayId
     */
    public void setSurgeryWayId(Long surgeryWayId) {
        this.surgeryWayId = surgeryWayId;
    }

}