package com.bofan.publichealth.valueobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 健康教育宣传栏
 * @author xlf
 */
@Entity
@Table(name = "HEALTH_EDU_BULLETIN", schema = SchemaConsts.PUBLIC_HEALTH)
public class HealthEduBulletin implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1655357154245841636L;

    @Id
	@Column(name = "HEALTH_EDUCATION_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long healthEducationId;
    
    /** 宣传栏种类 */
    @Column(name = "EDU_BULLETIN_TYPE", nullable = false, length = 40)
    private String eduBulletinType;
    
    /** 宣传栏面积（平方米） */
    @Column(name = "EDU_BULLETIN_AREA", precision = 18, scale = 2)
    private Double eduBulletinArea;
    
    /** 宣传栏长（m） */
    @Column(name = "EDU_BULLETIN_HEIGTH", precision = 18, scale = 2)
    private Double eduBulletinHeigth;
    
    /** 宣传栏宽（m）  */
    @Column(name = "EDU_BULLETIN_WIDTH", precision = 18, scale = 2)
    private Double eduBulletinWidth;
    
    /** 宣传栏距地面高度（m） */
    @Column(name = "VERTICAL_HEIGTH", precision = 18, scale = 2)
    private Double verticalHeigth;
    
    /** 宣传栏位置  */
    @Column(name = "EDU_BULLETIIN_SITE", precision = 18, scale = 2)
    private Double eduBulletiinSite;

    /** 宣传栏负责人 */
	@Column(name = "PERSON_IN_CHARGE", length = 20)
	private String personInCharge;

	/** default constructor */
	public HealthEduBulletin() {
	}

    /**
     * @return the healthEducationId
     */
    public Long getHealthEducationId() {
        return healthEducationId;
    }

    /**
     * @param healthEducationId the healthEducationId to set
     */
    public void setHealthEducationId(Long healthEducationId) {
        this.healthEducationId = healthEducationId;
    }

    /**
     * @return the eduBulletinType
     */
    public String getEduBulletinType() {
        return eduBulletinType;
    }

    /**
     * @param eduBulletinType the eduBulletinType to set
     */
    public void setEduBulletinType(String eduBulletinType) {
        this.eduBulletinType = eduBulletinType;
    }

    /**
     * @return the eduBulletinArea
     */
    public Double getEduBulletinArea() {
        return eduBulletinArea;
    }

    /**
     * @param eduBulletinArea the eduBulletinArea to set
     */
    public void setEduBulletinArea(Double eduBulletinArea) {
        this.eduBulletinArea = eduBulletinArea;
    }

    /**
     * @return the eduBulletinHeigth
     */
    public Double getEduBulletinHeigth() {
        return eduBulletinHeigth;
    }

    /**
     * @param eduBulletinHeigth the eduBulletinHeigth to set
     */
    public void setEduBulletinHeigth(Double eduBulletinHeigth) {
        this.eduBulletinHeigth = eduBulletinHeigth;
    }

    /**
     * @return the eduBulletinWidth
     */
    public Double getEduBulletinWidth() {
        return eduBulletinWidth;
    }

    /**
     * @param eduBulletinWidth the eduBulletinWidth to set
     */
    public void setEduBulletinWidth(Double eduBulletinWidth) {
        this.eduBulletinWidth = eduBulletinWidth;
    }

    /**
     * @return the verticalHeigth
     */
    public Double getVerticalHeigth() {
        return verticalHeigth;
    }

    /**
     * @param verticalHeigth the verticalHeigth to set
     */
    public void setVerticalHeigth(Double verticalHeigth) {
        this.verticalHeigth = verticalHeigth;
    }

    /**
     * @return the eduBulletiinSite
     */
    public Double getEduBulletiinSite() {
        return eduBulletiinSite;
    }

    /**
     * @param eduBulletiinSite the eduBulletiinSite to set
     */
    public void setEduBulletiinSite(Double eduBulletiinSite) {
        this.eduBulletiinSite = eduBulletiinSite;
    }

    /**
     * @return the personInCharge
     */
    public String getPersonInCharge() {
        return personInCharge;
    }

    /**
     * @param personInCharge the personInCharge to set
     */
    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

}