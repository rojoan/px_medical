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
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description: 健康教育活动
 * @author xlf
 */
@Entity
@Table(name = "HEALTH_EDUCATION", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "HEALTH_EDUCATION_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".HEALTH_EDUCATION_ID", allocationSize = 1)
public class HealthEducation implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1655357154245841636L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HEALTH_EDUCATION_ID")
	@Column(name = "HEALTH_EDUCATION_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long healthEducationId;
    
    @Column(name = "EDU_THEME_ID", nullable = false, precision = 18, scale = 0)
    private Long eduThemeId;
	
    /** 行政街道 */
    @Column(name = "REGION_ID", length = 18)
    private String regionId;
    
    /** 附件标识符 */
    @Column(name = "AFFIX_ID", length = 20)
    private String affixId;

    /** 医疗机构ID */
    @Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
    private Long hospitalId;
    
    /** 医疗机构编码 */
    @Column(name = "HOSPITAL_NO", nullable = false, length = 40)
    private String hospitalNo;
    
    /** 医疗机构名称 */
    @Column(name = "HOSPITAL_NAME", length = 80)
    private String hospitalName;
    
    /** 活动名称 */
    @Column(name = "EDU_NAME", length = 100)
    private String eduName;
    
    /** 活动时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
    @Column(name = "EDU_TIME")
    private Date eduTime;
    
    /** 活动组织者*/
    @Column(name = "ORGANIZER", length = 20)
    private String organizer;
    
    /** 专家人数*/
    @Column(name = "DOCTOR_PROFESSOR", length = 2)
    private Integer doctorProfessor;
    
    /** 活动地点 */
    @Column(name = "EDU_SITE", length = 100)
    private String eduSite;
    
    /** 活动形式 */
    @Column(name = "EDU_FORM", length = 1)
    private String eduForm;
    
    /** 提供资料类型--是否发放资料 */
    @Column(name = "GIVE_DATUM_FLAG", length = 1)
    private String giveDatumFlag;
    
    /** 提供资料类型--是否播放音频资料 */
    @Column(name = "PLAY_DATUM_FLAG", length = 1)
    private String playDatumFlag;
    
    /** 主办单位 */
    @Column(name = "HOST_ORG", length = 100)
    private String hostOrg;
    
    /** 合作伙伴 */
    @Column(name = "COLLABORATE_PARTNER", length = 20)
    private String collaboratePartner;
    
    /** 参与教育人数*/
    @Column(name = "TAKE_PART_NUM", length = 20)
    private Integer takePartNum;
    
    /** 发放印刷资料名称 */
    @Column(name = "PRINTING_DATUM_NAME", length = 100)
    private String printingDatumName;
    
    /** 资料数量 */
    @Column(name = "DATUM_COUNT", length = 20)
    private Integer datumCount;

    /** 资料发放人 */
    @Column(name = "DATUM_GIVER_NAME", length = 20)
    private String datumGiverName;
    
    /** 开始播放时间 */
    @Column(name = "VIDEO_PLAY_START_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
    private Date videoPlayStartTime;
    
    /** 结束播放时间 */
    @Column(name = "VIDEO_PLAY_END_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
    private Date videoPlayEndTime;
    
    /** 资料播放人 */
    @Column(name = "VIDEO_PLAYER_NAME", length = 20)
    private String videoPlayerName;

    /** 活动小结 */
    @Column(name = "BRIEF_SUMMARY", length = 4000)
    private String briefSummary;
    
    /** 活动评价 */
    @Column(name = "EDU_ESTIMATE", length = 4000)
    private String eduEstimate;
    
    /** 活动口号 */
    @Column(name = "EDU_CATCHWORD", length = 100)
    private String eduCatchword;
    
    /** 活动目标 */
    @Column(name = "EDU_AIM", length = 100)
    private String eduAim;
    
    /** 授课老师 */
    @Column(name = "EDU_TEACHER", length = 40)
    private String eduTeacher;
    
    /** 操作时间 */
    @Column(name = "CREATE_TIME", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
    private Date createTime;
    
    /** 操作人 */
    @Column(name = "CREATOR_ID", nullable = false, precision = 18, scale = 0)
    private Long creatorId;
    
	/** 是否有效 1：有效 0：无效 */
	@Column(name = "VALID_FLAG", nullable = false, length = 1)
	private String validFlag;

	/** default constructor */
	public HealthEducation() {
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
     * @return the regionId
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId the regionId to set
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
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
     * @return the hospitalNo
     */
    public String getHospitalNo() {
        return hospitalNo;
    }

    /**
     * @param hospitalNo the hospitalNo to set
     */
    public void setHospitalNo(String hospitalNo) {
        this.hospitalNo = hospitalNo;
    }

    /**
     * @return the hospitalName
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * @param hospitalName the hospitalName to set
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * @return the eduName
     */
    public String getEduName() {
        return eduName;
    }

    /**
     * @param eduName the eduName to set
     */
    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    /**
     * @return the eduTime
     */
    public Date getEduTime() {
        return eduTime;
    }

    /**
     * @param eduTime the eduTime to set
     */
    public void setEduTime(Date eduTime) {
        this.eduTime = eduTime;
    }

    /**
     * @return the organizer
     */
    public String getOrganizer() {
        return organizer;
    }

    /**
     * @param organizer the organizer to set
     */
    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    /**
     * @return the doctorProfessor
     */
    public Integer getDoctorProfessor() {
        return doctorProfessor;
    }

    /**
     * @param doctorProfessor the doctorProfessor to set
     */
    public void setDoctorProfessor(Integer doctorProfessor) {
        this.doctorProfessor = doctorProfessor;
    }

    /**
     * @return the eduSite
     */
    public String getEduSite() {
        return eduSite;
    }

    /**
     * @param eduSite the eduSite to set
     */
    public void setEduSite(String eduSite) {
        this.eduSite = eduSite;
    }

    /**
     * @return the eduForm
     */
    public String getEduForm() {
        return eduForm;
    }

    /**
     * @param eduForm the eduForm to set
     */
    public void setEduForm(String eduForm) {
        this.eduForm = eduForm;
    }

    /**
     * @return the giveDatumFlag
     */
    public String getGiveDatumFlag() {
        return giveDatumFlag;
    }

    /**
     * @param giveDatumFlag the giveDatumFlag to set
     */
    public void setGiveDatumFlag(String giveDatumFlag) {
        this.giveDatumFlag = giveDatumFlag;
    }

    /**
     * @return the playDatumFlag
     */
    public String getPlayDatumFlag() {
        return playDatumFlag;
    }

    /**
     * @param playDatumFlag the playDatumFlag to set
     */
    public void setPlayDatumFlag(String playDatumFlag) {
        this.playDatumFlag = playDatumFlag;
    }

    /**
     * @return the hostOrg
     */
    public String getHostOrg() {
        return hostOrg;
    }

    /**
     * @param hostOrg the hostOrg to set
     */
    public void setHostOrg(String hostOrg) {
        this.hostOrg = hostOrg;
    }

    /**
     * @return the collaboratePartner
     */
    public String getCollaboratePartner() {
        return collaboratePartner;
    }

    /**
     * @param collaboratePartner the collaboratePartner to set
     */
    public void setCollaboratePartner(String collaboratePartner) {
        this.collaboratePartner = collaboratePartner;
    }

    /**
     * @return the takePartNum
     */
    public Integer getTakePartNum() {
        return takePartNum;
    }

    /**
     * @param takePartNum the takePartNum to set
     */
    public void setTakePartNum(Integer takePartNum) {
        this.takePartNum = takePartNum;
    }

    /**
     * @return the printingDatumName
     */
    public String getPrintingDatumName() {
        return printingDatumName;
    }

    /**
     * @param printingDatumName the printingDatumName to set
     */
    public void setPrintingDatumName(String printingDatumName) {
        this.printingDatumName = printingDatumName;
    }

    /**
     * @return the datumCount
     */
    public Integer getDatumCount() {
        return datumCount;
    }

    /**
     * @param datumCount the datumCount to set
     */
    public void setDatumCount(Integer datumCount) {
        this.datumCount = datumCount;
    }

    /**
     * @return the datumGiverName
     */
    public String getDatumGiverName() {
        return datumGiverName;
    }

    /**
     * @param datumGiverName the datumGiverName to set
     */
    public void setDatumGiverName(String datumGiverName) {
        this.datumGiverName = datumGiverName;
    }

    /**
     * @return the videoPlayStartTime
     */
    public Date getVideoPlayStartTime() {
        return videoPlayStartTime;
    }

    /**
     * @param videoPlayStartTime the videoPlayStartTime to set
     */
    public void setVideoPlayStartTime(Date videoPlayStartTime) {
        this.videoPlayStartTime = videoPlayStartTime;
    }

    /**
     * @return the videoPlayEndTime
     */
    public Date getVideoPlayEndTime() {
        return videoPlayEndTime;
    }

    /**
     * @param videoPlayEndTime the videoPlayEndTime to set
     */
    public void setVideoPlayEndTime(Date videoPlayEndTime) {
        this.videoPlayEndTime = videoPlayEndTime;
    }

    /**
     * @return the videoPlayerName
     */
    public String getVideoPlayerName() {
        return videoPlayerName;
    }

    /**
     * @param videoPlayerName the videoPlayerName to set
     */
    public void setVideoPlayerName(String videoPlayerName) {
        this.videoPlayerName = videoPlayerName;
    }

    /**
     * @return the briefSummary
     */
    public String getBriefSummary() {
        return briefSummary;
    }

    /**
     * @param briefSummary the briefSummary to set
     */
    public void setBriefSummary(String briefSummary) {
        this.briefSummary = briefSummary;
    }

    /**
     * @return the eduEstimate
     */
    public String getEduEstimate() {
        return eduEstimate;
    }

    /**
     * @param eduEstimate the eduEstimate to set
     */
    public void setEduEstimate(String eduEstimate) {
        this.eduEstimate = eduEstimate;
    }

    /**
     * @return the eduCatchword
     */
    public String getEduCatchword() {
        return eduCatchword;
    }

    /**
     * @param eduCatchword the eduCatchword to set
     */
    public void setEduCatchword(String eduCatchword) {
        this.eduCatchword = eduCatchword;
    }

    /**
     * @return the eduAim
     */
    public String getEduAim() {
        return eduAim;
    }

    /**
     * @param eduAim the eduAim to set
     */
    public void setEduAim(String eduAim) {
        this.eduAim = eduAim;
    }

    /**
     * @return the eduTeacher
     */
    public String getEduTeacher() {
        return eduTeacher;
    }

    /**
     * @param eduTeacher the eduTeacher to set
     */
    public void setEduTeacher(String eduTeacher) {
        this.eduTeacher = eduTeacher;
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