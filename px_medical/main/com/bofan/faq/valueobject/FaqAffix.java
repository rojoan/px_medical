package com.bofan.faq.valueobject;

// Generated 2018-2-21 12:16:38 by Hibernate Tools 3.4.0.CR1

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * WorkAffix generated by hbm2java
 */
@Entity
@Table(name = "FAQ_AFFIX", schema =  SchemaConsts.EMERGENCY_EVENT_SCHEMA)
public class FaqAffix implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AFFIX_ID", unique = true, nullable = false, length = 20)
    private String affixId;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="affixId")
    private Set<FaqAffixItem> items;

    public FaqAffix() {
    }

    public FaqAffix(String affixId) {
        this.affixId = affixId;
    }

    public String getAffixId() {
        return this.affixId;
    }

    public void setAffixId(String affixId) {
        this.affixId = affixId;
    }

	public Set<FaqAffixItem> getItems() {
		return items;
	}

	public void setItems(Set<FaqAffixItem> items) {
		this.items = items;
	}

}
