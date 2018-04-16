package com.bofan.publichealth.gravida.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;
/**
 * @Description: 孕妇孕期检查/手术方式表
 * @author lqw
 */
@Entity
@Table(name = "GRAVIDA_SURGERY_WAY", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "GRAVIDA_SURGERY_WAY_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".GRAVIDA_SURGERY_WAY_ID", allocationSize = 1)
public class GravidaSurgeryWay {

    /** 孕妇孕期检查/手术方式ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRAVIDA_SURGERY_WAY_ID")
    @Column(name = "GRAVIDE_SURGERY_WAY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long gravideSurgeryWayId;
 
	/** 产前手术记录ID，自动增长ID */
//    @Column(name = "GRAVIDA_SURGERY_ID", nullable = false, precision = 18, scale = 0)
//    private Long gravidaSurgeryId;
    @Column(name = "PREGNANCY_SURGERY_ID", nullable = false, precision = 18, scale = 0)
    private Long pregnancySurgeryId;
	
	/** 检查/手术方式ID，自动增长ID */
    @Column(name = "SURGERY_WAY_ID", nullable = false, precision = 18, scale = 0)
	private Long surgeryWayId;

	/** default constructor */
	public GravidaSurgeryWay() {
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
//    public Long getGravidaSurgeryId() {
//        return gravidaSurgeryId;
//    }
//
//    /**
//     * @param gravidaSurgeryId 要设置的 gravidaSurgeryId
//     */
//    public void setGravidaSurgeryId(Long gravidaSurgeryId) {
//        this.gravidaSurgeryId = gravidaSurgeryId;
//    }

    /**
     * @return surgeryWayId
     */
    public Long getSurgeryWayId() {
        return surgeryWayId;
    }

    /**
     * @return pregnancySurgeryId
     */
    public Long getPregnancySurgeryId() {
        return pregnancySurgeryId;
    }

    /**
     * @param pregnancySurgeryId 要设置的 pregnancySurgeryId
     */
    public void setPregnancySurgeryId(Long pregnancySurgeryId) {
        this.pregnancySurgeryId = pregnancySurgeryId;
    }

    /**
     * @param surgeryWayId 要设置的 surgeryWayId
     */
    public void setSurgeryWayId(Long surgeryWayId) {
        this.surgeryWayId = surgeryWayId;
    }

}