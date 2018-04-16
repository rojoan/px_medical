package com.bofan.publichealth.command;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.publichealth.valueobject.HealthEduBulletin;
import com.bofan.publichealth.valueobject.HealthEduReadyDatum;

/**
 * 健康教育活动，接收来自页面编辑参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
public class HealthEducationEditInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = -4838997932144501779L;

    private Long healthEducationId;
    
    /** 附件标识符 */
    private String affixId;
    
    private Long eduThemeId;
    
    /** 行政街道 */
    private String regionId;
    
    /** 活动名称 */
    private String eduName;
    
    /** 活动时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date eduTime;
    
    /** 活动组织者*/
    private String organizer;
    
    /** 专家人数*/
    private Integer doctorProfessor;
    
    /** 活动地点 */
    @Column(name = "EDU_SITE", length = 100)
    private String eduSite;
    
    /** 活动形式 */
    private String eduForm;
    
    /** 提供资料类型--是否发放资料 */
    private String giveDatumFlag;
    
    /** 提供资料类型--是否播放音频资料 */
    private String playDatumFlag;
    
    /** 主办单位 */
    private String hostOrg;
    
    /** 合作伙伴 */
    private String collaboratePartner;
    
    /** 参与教育人数*/
    private Integer takePartNum;
    
    /** 活动小结 */
    private String briefSummary;
    
    /** 活动评价 */
    private String eduEstimate;
    
    /** 资料发放人 */
    private String printingDatumName;
    
    /** 资料数量 */
    private Integer datumCount;

    /** 资料发放人 */
    private String datumGiverName;
    
    /** 开始播放时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date videoPlayStartTime;
    
    /** 结束播放时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date videoPlayEndTime;
    
    /** 资料播放人 */
    private String videoPlayerName;
    
    /** 活动口号 */
    private String eduCatchword;
    
    /** 活动目标 */
    private String eduAim;
    
    /** 授课老师 */
    private String eduTeacher;
    
    /** 资料种类 */
    private String[] datumTypes;
    
    /** 发放位置 */
    private String[] givePositions;
    
    /** 播放位置 */
    private String[] playPositions;
    
    /** 资料领取对象（发放对象） */
    private String[] receiveObjects;
    
    /** 存档类型 */
    private String[] archiveTypes;
    
    /** 健康教育宣传栏 */
    private HealthEduBulletin healthEduBulletin;
    
    /** 健康教育--准备活动资料 */
    private HealthEduReadyDatum healthEduReadyDatum;

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
     * @return the datumTypes
     */
    public String[] getDatumTypes() {
        return datumTypes;
    }

    /**
     * @param datumTypes the datumTypes to set
     */
    public void setDatumTypes(String[] datumTypes) {
        this.datumTypes = datumTypes;
    }

    /**
     * @return the givePositions
     */
    public String[] getGivePositions() {
        return givePositions;
    }

    /**
     * @param givePositions the givePositions to set
     */
    public void setGivePositions(String[] givePositions) {
        this.givePositions = givePositions;
    }

    /**
     * @return the playPositions
     */
    public String[] getPlayPositions() {
        return playPositions;
    }

    /**
     * @param playPositions the playPositions to set
     */
    public void setPlayPositions(String[] playPositions) {
        this.playPositions = playPositions;
    }

    /**
     * @return the receiveObjects
     */
    public String[] getReceiveObjects() {
        return receiveObjects;
    }

    /**
     * @param receiveObjects the receiveObjects to set
     */
    public void setReceiveObjects(String[] receiveObjects) {
        this.receiveObjects = receiveObjects;
    }

    /**
     * @return the archiveTypes
     */
    public String[] getArchiveTypes() {
        return archiveTypes;
    }

    /**
     * @param archiveTypes the archiveTypes to set
     */
    public void setArchiveTypes(String[] archiveTypes) {
        this.archiveTypes = archiveTypes;
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
     * @return the healthEduBulletin
     */
    public HealthEduBulletin getHealthEduBulletin() {
        return healthEduBulletin;
    }

    /**
     * @param healthEduBulletin the healthEduBulletin to set
     */
    public void setHealthEduBulletin(HealthEduBulletin healthEduBulletin) {
        this.healthEduBulletin = healthEduBulletin;
    }

    /**
     * @return the healthEduReadyDatum
     */
    public HealthEduReadyDatum getHealthEduReadyDatum() {
        return healthEduReadyDatum;
    }

    /**
     * @param healthEduReadyDatum the healthEduReadyDatum to set
     */
    public void setHealthEduReadyDatum(HealthEduReadyDatum healthEduReadyDatum) {
        this.healthEduReadyDatum = healthEduReadyDatum;
    }
    
}
