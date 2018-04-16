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
 * @Description: 孕期检查/手术方式表
 * @author lqw
 */
@Entity
@Table(name = "PREGNANCY_SURGERY_WAY", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "PREGNANCY_SURGERY_WAY_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PREGNANCY_SURGERY_WAY_ID", allocationSize = 1)
public class PregnancySurgeryWay {
	
    /** 检查/手术方式ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREGNANCY_SURGERY_WAY_ID")
    @Column(name = "SURGERY_WAY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long surgeryWayId;
	
    /** 检查/手术方式名称 羊膜腔穿刺术  脐带血管穿刺术 绒毛穿刺术 宫内治疗 */
    @Column(name = "SURGERY_WAY", nullable = false, length = 40)
	private String surgeryWay;
	
    /** 是否有效 1=有效 0=无效 */
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public PregnancySurgeryWay() {
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

    /**
     * @return surgeryWay
     */
    public String getSurgeryWay() {
        return surgeryWay;
    }

    /**
     * @param surgeryWay 要设置的 surgeryWay
     */
    public void setSurgeryWay(String surgeryWay) {
        this.surgeryWay = surgeryWay;
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