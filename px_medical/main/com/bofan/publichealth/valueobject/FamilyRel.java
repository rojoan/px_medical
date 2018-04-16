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
 * @Description:family_rel（户主--家庭关系表）
 * @author lqw
 */
@Entity
@Table(name = "FAMILY_REL", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "FAMILY_REL_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".FAMILY_REL_ID", allocationSize = 1)
public class FamilyRel {

	/** 家庭关系ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FAMILY_REL_ID")
	@Column(name = "FAMILY_REL_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long familyRelId;
	
	/** 家庭关系  家庭关系
		本人或户主;配偶; 父母; 岳父、岳母; 公公、婆婆; 祖父母或外祖父母; 儿子; 女儿; 儿媳; 女婿; 兄、弟、姐、妹
		; 孙子或孙女; 养子; 养女; 养父、养母; 伯父、伯母; 叔叔、婶婶; 姑父、姑妈; 舅舅、舅妈; 阿姨、姨夫等*/
	@Column(name = "FAMILY_REL", unique = true, nullable = false, length = 40)
	private String familyRel;
	
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public FamilyRel() {
	}

	/**
	 * @return familyRelId
	 */
	public Long getFamilyRelId() {
		return familyRelId;
	}

	/**
	 * @param familyRelId
	 *            要设置的 familyRelId
	 */
	public void setFamilyRelId(Long familyRelId) {
		this.familyRelId = familyRelId;
	}

	/**
	 * @return familyRel
	 */
	public String getFamilyRel() {
		return familyRel;
	}

	/**
	 * @param familyRel
	 *            要设置的 familyRel
	 */
	public void setFamilyRel(String familyRel) {
		this.familyRel = familyRel;
	}

	/**
	 * @return validFlag
	 */
	public String getValidFlag() {
		return validFlag;
	}

	/**
	 * @param validFlag
	 *            要设置的 validFlag
	 */
	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}
}