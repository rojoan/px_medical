package com.bofan.videomeeting.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;


/**
 * video_meeting_user（视频会议接入用户表）
 */
@Entity
@Table(name = "VIDEO_MEETING_USER" ,schema = SchemaConsts.REMOTE_CONSULT)
@SequenceGenerator(name = "VIDEO_MEETING_USER_ID", sequenceName = SchemaConsts.REMOTE_CONSULT + ".VIDEO_MEETING_USER_ID", allocationSize = 1)
public class VideoMeetingUser  implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7470167249770239479L;
    // Fields    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIDEO_MEETING_USER_ID")
    @Column(name = "MEETING_USER_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long meetingUserId;
    
    /** 账号名称  */
    @Column(name="USERNAME", nullable=false, length=20)
    private String userName;
    
    /** 账号密码 */
    @Column(name="USERPASSWORD", nullable=false, length=128)
    private String userPassword;
    
    /** 视频会议接入用户角色 1：部门管理员；2：预订用户；3：普通用户 */
    @Column(name="ROLE_FLAG", nullable=false, length=1)
    private String roleFlag;

    /**
     * 
     */
    public VideoMeetingUser() {
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
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}