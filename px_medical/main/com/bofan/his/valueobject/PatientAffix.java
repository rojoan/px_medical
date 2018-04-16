package com.bofan.his.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: 患者-附件标识表
 * @author lqw
 */
@Entity
@Table(name = "PATIENT_AFFIX", schema = SchemaConsts.REMOTE_CONSULT)
public class PatientAffix {

	/** 附件标识 */
	@Id
	@Column(name = "AFFIX_ID", unique = true, nullable = false, length = 20)
	private String affixId;
	 
	public PatientAffix() {
	}

	public PatientAffix(String affixId) {
		this.affixId = affixId;
	}

	public String getAffixId() {
		return this.affixId;
	}

	public void setAffixId(String affixId) {
		this.affixId = affixId;
	}

}