package com.bofan.publichealth.valueobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 健康教育活动主题
 * @author xlf
 */
@Entity
@Table(name = "HEALTH_EDU_THEME", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "EDU_THEME_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".HEALTH_EDU_THEME_ID", allocationSize = 1)
public class HealthEduTheme implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1655357154245841636L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDU_THEME_ID")
	@Column(name = "EDU_THEME_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long eduThemeId;
	
    @Column(name = "EDU_THEME_NAME", nullable = false, length = 40)
    private String eduThemeName;
    
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public HealthEduTheme() {
	}

    /**
     * @return the eduThemeId
     */
    public Long getEduThemeId() {
        return eduThemeId;
    }

    /**
     * @param eduThemeId the eduThemeId to set
     */
    public void setEduThemeId(Long eduThemeId) {
        this.eduThemeId = eduThemeId;
    }

    /**
     * @return the eduThemeName
     */
    public String getEduThemeName() {
        return eduThemeName;
    }

    /**
     * @param eduThemeName the eduThemeName to set
     */
    public void setEduThemeName(String eduThemeName) {
        this.eduThemeName = eduThemeName;
    }

    /**
     * @return the validFlag
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag the validFlag to set
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

}