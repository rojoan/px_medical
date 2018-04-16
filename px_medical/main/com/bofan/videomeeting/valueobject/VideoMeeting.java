package com.bofan.videomeeting.valueobject;

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
 * video_meeting（视频会议表）
 */
@Entity
@Table(name = "VIDEO_MEETING" ,schema = SchemaConsts.REMOTE_CONSULT)
@SequenceGenerator(name = "VIDEO_MEETING_ID", sequenceName = SchemaConsts.REMOTE_CONSULT + ".VIDEO_MEETING_ID", allocationSize = 1)
public class VideoMeeting  implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7470167249770239479L;
    // Fields    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIDEO_MEETING_ID")
    @Column(name = "VIDEO_MEETING_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long videoMeetingId;
    
    /** 用户账号  */
    @Column(name="USERNAME", nullable=false, length=20)
    private String username;
    
    /** 账号登录密码 */
    @Column(name="USERPASSWORD", nullable=false, length=128)
    private String userpassword;
    
    /** 会议名称  */
    @Column(name="TOPIC", nullable=false, length=128)
    private String topic;
    
    @Column(name="CHAIRMANPWD", length=128)
    private String chairmanpwd;
    
    @Column(name="CONFUSERPWD", length=128)
    private String confuserpwd;
    
    /** 会议密码 */
    @Column(name="CONFKEY", length=128)
    private String confkey;
    
    @Column(name="WEBSERVICEPWD", length=128)
    private String webservicepwd;
    
    /** 会议内容 */
    @Column(name="CONTENT", length=500)
    private String content;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
    @Column(name="BEGINTIME", nullable=false, length=22)
    private Date beginTime;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh" , timezone="GMT+8")
    @Column(name="ENDTIME", nullable=false, length=22)
    private Date endTime;
    
    @Column(name="ATTENDNUM", nullable=false, precision=18, scale=0)
    private Long attendnum;
    
    @Column(name="BANDWIDTH", nullable=false, length=10)
    private String bandwidth;
    
    @Column(name="MAXPERSONSPEAK", nullable=false, precision=18, scale=0)
    private Long maxpersonspeak;
    
    @Column(name="RESERVETYPE", nullable=false, length=1)
    private String reservetype;
    
    @Column(name="MAXVIDEO", precision=18, scale=0)
    private Long maxvideo;
    
    @Column(name="VIDEOTYPE", length=30)
    private String videotype;
    
    @Column(name="AUDIOTYPE", precision=18, scale=0)
    private Long audiotype;
    
    /** 远程会诊信息主键ID */
    @Column(name="RE_CONSULTING_ID", nullable=false, precision=18, scale=0)
    private Long reConsultingId;
    
    /** 会议Id（对应远程视频会议系统的会议Id） */
    @Column(name="CONFID", length = 40)
    private String confId;

    /**
     * 
     */
    public VideoMeeting() {
        super();
        // TODO Auto-generated constructor stub
    }
    
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
    public void setEndTime(Date endtime) {
        this.endTime = endtime;
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
     * @return the confId
     */
    public String getConfId() {
        return confId;
    }

    /**
     * @param confId the confId to set
     */
    public void setConfId(String confId) {
        this.confId = confId;
    }

    
}