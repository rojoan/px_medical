package com.bofan.publichealth.valueobject;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 健康教育--附件标识
 * @author xlf
 */
@Entity
@Table(name = "HEALTH_EDU_AFFIX", schema = SchemaConsts.PUBLIC_HEALTH)
public class HealthEduAffix implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1655357154245841636L;

    @Id
    @Column(name = "AFFIX_ID", nullable = false, length = 20)
    private String affixId;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="affixId")
    private Set<HealthEduAffixItem> items;

	/** default constructor */
	public HealthEduAffix() {
	}

    /**
     * @return the affixId
     */
    public String getAffixId() {
        return affixId;
    }

    /**
     * @param affixId the affixId to set
     */
    public void setAffixId(String affixId) {
        this.affixId = affixId;
    }

    /**
     * @return the items
     */
    public Set<HealthEduAffixItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(Set<HealthEduAffixItem> items) {
        this.items = items;
    }

}