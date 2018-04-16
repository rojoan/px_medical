package com.bofan.videomeeting.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bofan.reconsult.valueobject.ReConsulting;
import com.bofan.utils.SchemaConsts;


/**
 * video_meeting_queue（视频会议接入队列表）
 */
@Entity
@Table(name = "VIDEO_MEETING_QUEUE" ,schema = SchemaConsts.REMOTE_CONSULT)
public class VideoMeetingQueue  implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7470167249770239479L;
    // Fields    

    @Id
    @Column(name = "MEETING_USER_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long meetingUserId;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MEETING_USER_ID", insertable = false, updatable = false)
    private VideoMeetingUser meetingUser;
    
    /** 会议用户名  */
    @Column(name="USERNAME", nullable=false, length=20)
    private String userName;
    
    /** sys_user_info 表主键主键ID */
    @Column(name = "USER_INFO_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long userInfoId;
    
    /** sys_user_info 表用戶名 */
    @Column(name="NAME", nullable=false, length=20)
    private String name;
    
    /** 会议表的主键ID */
    @Column(name = "VIDEO_MEETING_ID", nullable = false, precision = 18, scale = 0)
    private Long videoMeetingId;
    
    /** 远程会诊表主键ID */
    @Column(name = "RE_CONSULTING_ID", nullable = false, precision = 18, scale = 0)
    private Long reConsultingId;
    /** 会诊对象  */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RE_CONSULTING_ID", insertable = false, updatable = false)
    private ReConsulting consulting;

    /**
     * 
     */
    public VideoMeetingQueue() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the meetingUserId
     */
    public Long getMeetingUserId() {
        return meetingUserId;
    }

    /**
     * @param meetingUserId the meetingUserId to set
     */
    public void setMeetingUserId(Long meetingUserId) {
        this.meetingUserId = meetingUserId;
    }

    /**
     * @return the meetingUser
     */
    public VideoMeetingUser getMeetingUser() {
        return meetingUser;
    }

    /**
     * @param meetingUser the meetingUser to set
     */
    public void setMeetingUser(VideoMeetingUser meetingUser) {
        this.meetingUser = meetingUser;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userInfoId
     */
    public Long getUserInfoId() {
        return userInfoId;
    }

    /**
     * @param userInfoId the userInfoId to set
     */
    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the consulting
     */
    public ReConsulting getConsulting() {
        return consulting;
    }

    /**
     * @param consulting the consulting to set
     */
    public void setConsulting(ReConsulting consulting) {
        this.consulting = consulting;
    }

}