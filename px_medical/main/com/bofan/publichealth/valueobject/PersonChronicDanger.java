package com.bofan.publichealth.valueobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;


/**
 * 慢性病--危险因素
 * 
 */
@Entity
@Table(name="PERSON_CHRONIC_DANGER", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "CHRONIC_DANGER_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PERSON_CHRONIC_DANGER_ID", allocationSize = 1)
public class PersonChronicDanger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHRONIC_DANGER_ID")
	@Column(name="CHRONIC_DANGER_ID", unique=true, nullable=false, precision=18)
	private Long chronicDangerId;
	
	@Column(name="PERSON_CHRONIC_ID", unique=true, nullable=false, precision=18)
    private Long personChronicId;
	
	@Column(name="PERSON_DETAIL_ID", unique=true, nullable=false, precision=18)
    private Long personDetailId;

	@Column(name="CHRONIC_TYPE", length = 1)
	private String chronicType;
	
	@Column(name="DANGER_TYPE", length = 1)
    private String dangerType;
	
	@Column(name="HOSPITAL_ID", nullable=false, precision=18)
    private Long hospitalId;
	
	@Column(name="CREATOR_ID", nullable=false, precision=18)
    private Long creatorId;

	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="VALID_FLAG", length = 1)
	private String validFlag;

	public PersonChronicDanger() {
	}

    /**
     * @return the chronicDangerId
     */
    public Long getChronicDangerId() {
        return chronicDangerId;
    }

    /**
     * @param chronicDangerId the chronicDangerId to set
     */
    public void setChronicDangerId(Long chronicDangerId) {
        this.chronicDangerId = chronicDangerId;
    }

    /**
     * @return the personChronicId
     */
    public Long getPersonChronicId() {
        return personChronicId;
    }

    /**
     * @param personChronicId the personChronicId to set
     */
    public void setPersonChronicId(Long personChronicId) {
        this.personChronicId = personChronicId;
    }

    /**
     * @return the personDetailId
     */
    public Long getPersonDetailId() {
        return personDetailId;
    }

    /**
     * @param personDetailId the personDetailId to set
     */
    public void setPersonDetailId(Long personDetailId) {
        this.personDetailId = personDetailId;
    }

    /**
     * @return the chronicType
     */
    public String getChronicType() {
        return chronicType;
    }

    /**
     * @param chronicType the chronicType to set
     */
    public void setChronicType(String chronicType) {
        this.chronicType = chronicType;
    }

    /**
     * @return the dangerType
     */
    public String getDangerType() {
        return dangerType;
    }

    /**
     * @param dangerType the dangerType to set
     */
    public void setDangerType(String dangerType) {
        this.dangerType = dangerType;
    }

    /**
     * @return the hospitalId
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId the hospitalId to set
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * @return the creatorId
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId the creatorId to set
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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