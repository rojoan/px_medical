package com.bofan.publichealth.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: committee（居委会）
 * @author lqw
 */
@Entity
@Table(name = "COMMITTEE", schema = SchemaConsts.PUBLIC_HEALTH )
@SequenceGenerator(name = "COMMITTEE_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".COMMITTEE_ID", allocationSize = 1)
public class Committee {

	
	/** 居委会ID */ 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMITTEE_ID")
	@Column(name = "COMMITTEE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long committeeId;
	
	/** 居委会街道 */
	@Column(name = "REGION_ID", nullable = false, length = 18)
	private String regionId;
	
	/** 居委会名称 */
	@Column(name = "COMMITTEE_NAME", unique = true, nullable = false, length = 200)
	private String committeeName;
	
	/** 居委会地址 */
	@Column(name = "COMMITTEE_ADDR", length = 1000)
	private String committeeAddr;
	
	/** 居委会电话 */
	@Column(name = "COMMITTEE_PHONE", length = 200)
	private String committeePhone;
	
	/** 居委会联系人 */
	@Column(name = "COMMITTEE_LINKMAN", length = 200)
	private String committeeLinkman;
	
	/** 备注 */
	@Column(name = "REMARK", length = 200)
	private String remark;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public Committee() {
	}

	/**
	 * @return committeeId
	 */
	public Long getCommitteeId() {
		return committeeId;
	}

	/**
	 * @param committeeId 要设置的 committeeId
	 */
	public void setCommitteeId(Long committeeId) {
		this.committeeId = committeeId;
	}

	/**
	 * @return regionId
	 */
	public String getRegionId() {
		return regionId;
	}

	/**
	 * @param regionId 要设置的 regionId
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	/**
	 * @return committeeName
	 */
	public String getCommitteeName() {
		return committeeName;
	}

	/**
	 * @param committeeName 要设置的 committeeName
	 */
	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}

	/**
	 * @return committeeAddr
	 */
	public String getCommitteeAddr() {
		return committeeAddr;
	}

	/**
	 * @param committeeAddr 要设置的 committeeAddr
	 */
	public void setCommitteeAddr(String committeeAddr) {
		this.committeeAddr = committeeAddr;
	}

	/**
	 * @return committeePhone
	 */
	public String getCommitteePhone() {
		return committeePhone;
	}

	/**
	 * @param committeePhone 要设置的 committeePhone
	 */
	public void setCommitteePhone(String committeePhone) {
		this.committeePhone = committeePhone;
	}

	/**
	 * @return committeeLinkman
	 */
	public String getCommitteeLinkman() {
		return committeeLinkman;
	}

	/**
	 * @param committeeLinkman 要设置的 committeeLinkman
	 */
	public void setCommitteeLinkman(String committeeLinkman) {
		this.committeeLinkman = committeeLinkman;
	}

	/**
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark 要设置的 remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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