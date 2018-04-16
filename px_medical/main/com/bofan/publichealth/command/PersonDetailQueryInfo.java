package com.bofan.publichealth.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;


/**
 * @Description: 家庭基本档案查询
 * @author lqw
 */
@QueryInfo(
        from = "com.bofan.publichealth.valueobject.PersonDetail pd ", 
        orderBy = "pd.personDetailId desc")
public class PersonDetailQueryInfo extends BaseCommandInfo {

	private static final long serialVersionUID = 1L;
    
	/** 个人基本档案ID */
	@QueryParam(fieldName = "pd.personDetailId", op = QueryOperator.EQU)
	private Long personDetailId;

	/** 家庭基本档案ID */
	@QueryParam(fieldName = "pd.familyDetailId", op = QueryOperator.EQU)
	private Long familyDetailId;
	
	/** 民族ID */
	@QueryParam(fieldName = "pd.nationId", op = QueryOperator.EQU)
	private Long nationId;


	/** 医疗机构ID 对应sys_org表的 主键ID */
	@QueryParam(fieldName = "pd.hospitalId", op = QueryOperator.EQU)
	private Long hospitalId;
	
	
	/** 姓名 */
	@QueryParam(fieldName = "pd.personalName", op = QueryOperator.LIKE)
	private String personalName;
	
	/** 健康档案编号 */
	@QueryParam(fieldName = "pd.archivePersonalNum", op = QueryOperator.LIKE)
	private String archivePersonalNum;
	
	
	/** 证件类型 身份证、居住证、签证、护照、户口本、军人证、港澳通行证 */
	@QueryParam(fieldName = "pd.certificateType", op = QueryOperator.LIKE)
	private String certificateType;
	
	/** 证件编号 */
	@QueryParam(fieldName = "pd.certificateNumber", op = QueryOperator.LIKE)
	private String certificateNumber;
	
	/** 人员性别 1：男 2：女 */
	@QueryParam(fieldName = "pd.gender", op = QueryOperator.EQU)
	private String gender;
	
	/** 户籍类型 */
    @QueryParam(fieldName = "pd.censusType", op = QueryOperator.EQU)
    private String censusType;
    
    /** 是否有效 1=有效 0=无效 */
    @QueryParam(fieldName = "pd.validFlag", op = QueryOperator.EQU)
    private String validFlag;
    
    /**
     * 个人类别 1=婴儿期：0～2岁 2=幼儿期：3～6岁 3=儿童期：7～11岁 4=少年期：12～17岁
     *   5=青年期：18～25岁 6=成年期：25～65岁 7=老年：65岁以上为老年
     */
    @QueryParam(fieldName = "pd.personalType", op = QueryOperator.EQU)
    private String personalType;
    

	/**
	 * @return personDetailId
	 */
	public Long getPersonDetailId() {
		return personDetailId;
	}

	/**
	 * @param personDetailId 要设置的 personDetailId
	 */
	public void setPersonDetailId(Long personDetailId) {
		this.personDetailId = personDetailId;
	}

	/**
	 * @return familyDetailId
	 */
	public Long getFamilyDetailId() {
		return familyDetailId;
	}

	/**
	 * @param familyDetailId 要设置的 familyDetailId
	 */
	public void setFamilyDetailId(Long familyDetailId) {
		this.familyDetailId = familyDetailId;
	}

	/**
	 * @return nationId
	 */
	public Long getNationId() {
		return nationId;
	}

	/**
	 * @param nationId 要设置的 nationId
	 */
	public void setNationId(Long nationId) {
		this.nationId = nationId;
	}

	/**
	 * @return hospitalId
	 */
	public Long getHospitalId() {
		return hospitalId;
	}

	/**
	 * @param hospitalId 要设置的 hospitalId
	 */
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * @return personalName
	 */
	public String getPersonalName() {
		return personalName;
	}

	/**
	 * @param personalName 要设置的 personalName
	 */
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	/**
	 * @return archivePersonalNum
	 */
	public String getArchivePersonalNum() {
		return archivePersonalNum;
	}

	/**
	 * @param archivePersonalNum 要设置的 archivePersonalNum
	 */
	public void setArchivePersonalNum(String archivePersonalNum) {
		this.archivePersonalNum = archivePersonalNum;
	}

	/**
	 * @return certificateType
	 */
	public String getCertificateType() {
		return certificateType;
	}

	/**
	 * @param certificateType 要设置的 certificateType
	 */
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	/**
	 * @return certificateNumber
	 */
	public String getCertificateNumber() {
		return certificateNumber;
	}

	/**
	 * @param certificateNumber 要设置的 certificateNumber
	 */
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender 要设置的 gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

    /**
     * @return the censusType
     */
    public String getCensusType() {
        return censusType;
    }

    /**
     * @param censusType the censusType to set
     */
    public void setCensusType(String censusType) {
        this.censusType = censusType;
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

    /**
     * @return personalType
     */
    public String getPersonalType() {
        return personalType;
    }

    /**
     * @param personalType 要设置的 personalType
     */
    public void setPersonalType(String personalType) {
        this.personalType = personalType;
    }
    
}