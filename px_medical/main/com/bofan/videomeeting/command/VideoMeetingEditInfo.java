package com.bofan.videomeeting.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description
 * @author xlf
 * @version 1.0
 * 2017-10-02
 */
@SuppressWarnings("serial")
public class VideoMeetingEditInfo extends BaseCommandInfo {
    
    /** 会议主键  */
    private Long videoMeetingId;
    
    /** 用户账号  */
    private String username;
    
    /** 账号登录密码 */
    private String userpassword;
    
    /** 会议名称  */
    private String topic;
    
    private String chairmanpwd;
    
    private String confuserpwd;
    
    /** 会议密码 */
    private String confkey;
    
    private String webservicepwd;
    
    private String content;

    /** 会议开始时间  */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") 
    private Date beginTime;
    
    /** 会议结束时间  */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") 
    private Date endTime;
    
    private Long attendnum;
    
    private String bandwidth;
    
    private Long maxpersonspeak;
    
    private String reservetype;
    
    private Long maxvideo;
    
    private String videotype;
    
    private Long audiotype;
    
    private Long reConsultingId;
    
    /** 会议参与人 */
    private String[] ponsultingProfessor;
    
    /** 请求类型: 1 申通通过，其他值为暂存 */
    private String submitType;

    /**
     * @return the videoMeetingId
     */
    public Long getVideoMeetingId() {
        return videoMeetingId;
    }

    /**
     * @param videoMeetingId the videoMeetingId to set
     */
    public void setVideoMeetingId(Long videoMeetingId) {
        this.videoMeetingId = videoMeetingId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the userpassword
     */
    public String getUserpassword() {
        return userpassword;
    }

    /**
     * @param userpassword the userpassword to set
     */
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    /**
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * @param topic the topic to set
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * @return the chairmanpwd
     */
    public String getChairmanpwd() {
        return chairmanpwd;
    }

    /**
     * @param chairmanpwd the chairmanpwd to set
     */
    public void setChairmanpwd(String chairmanpwd) {
        this.chairmanpwd = chairmanpwd;
    }

    /**
     * @return the confuserpwd
     */
    public String getConfuserpwd() {
        return confuserpwd;
    }

    /**
     * @param confuserpwd the confuserpwd to set
     */
    public void setConfuserpwd(String confuserpwd) {
        this.confuserpwd = confuserpwd;
    }

    /**
     * @return the confkey
     */
    public String getConfkey() {
        return confkey;
    }

    /**
     * @param confkey the confkey to set
     */
    public void setConfkey(String confkey) {
        this.confkey = confkey;
    }

    /**
     * @return the webservicepwd
     */
    public String getWebservicepwd() {
        return webservicepwd;
    }

    /**
     * @param webservicepwd the webservicepwd to set
     */
    public void setWebservicepwd(String webservicepwd) {
        this.webservicepwd = webservicepwd;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the begintime
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * @param begintime the begintime to set
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * @return the endtime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endtime the endtime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the attendnum
     */
    public Long getAttendnum() {
        return attendnum;
    }

    /**
     * @param attendnum the attendnum to set
     */
    public void setAttendnum(Long attendnum) {
        this.attendnum = attendnum;
    }

    /**
     * @return the bandwidth
     */
    public String getBandwidth() {
        return bandwidth;
    }

    /**
     * @param bandwidth the bandwidth to set
     */
    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * @return the maxpersonspeak
     */
    public Long getMaxpersonspeak() {
        return maxpersonspeak;
    }

    /**
     * @param maxpersonspeak the maxpersonspeak to set
     */
    public void setMaxpersonspeak(Long maxpersonspeak) {
        this.maxpersonspeak = maxpersonspeak;
    }

    /**
     * @return the reservetype
     */
    public String getReservetype() {
        return reservetype;
    }

    /**
     * @param reservetype the reservetype to set
     */
    public void setReservetype(String reservetype) {
        this.reservetype = reservetype;
    }

    /**
     * @return the maxvideo
     */
    public Long getMaxvideo() {
        return maxvideo;
    }

    /**
     * @param maxvideo the maxvideo to set
     */
    public void setMaxvideo(Long maxvideo) {
        this.maxvideo = maxvideo;
    }

    /**
     * @return the videotype
     */
    public String getVideotype() {
        return videotype;
    }

    /**
     * @param videotype the videotype to set
     */
    public void setVideotype(String videotype) {
        this.videotype = videotype;
    }

    /**
     * @return the audiotype
     */
    public Long getAudiotype() {
        return audiotype;
    }

    /**
     * @param audiotype the audiotype to set
     */
    public void setAudiotype(Long audiotype) {
        this.audiotype = audiotype;
    }

    /**
	 * @return the reConsultingId
	 */
	public Long getReConsultingId() {
		return reConsultingId;
	}

	/**
	 * @param reConsultingId the reConsultingId to set
	 */
	public void setReConsultingId(Long reConsultingId) {
		this.reConsultingId = reConsultingId;
	}

	/**
     * @return the ponsultingProfessor
     */
    public String[] getPonsultingProfessor() {
        return ponsultingProfessor;
    }

    /**
     * @param ponsultingProfessor the ponsultingProfessor to set
     */
    public void setPonsultingProfessor(String[] ponsultingProfessor) {
        this.ponsultingProfessor = ponsultingProfessor;
    }

    /**
     * @return the submitType
     */
    public String getSubmitType() {
        return submitType;
    }

    /**
     * @param submitType the submitType to set
     */
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }
    
    
    
}
