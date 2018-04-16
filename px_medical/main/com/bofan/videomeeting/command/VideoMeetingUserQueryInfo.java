package com.bofan.videomeeting.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description
 * @author xlf
 * @version 1.0
 * 2017-10-02
 */
@SuppressWarnings("serial")
@QueryInfo(from = "com.bofan.videomeeting.valueobject.VideoMeetingUser vmu", orderBy = "vmu.meetingUserId")
public class VideoMeetingUserQueryInfo extends BaseCommandInfo {

    /** 会议用户ID数组 */
    @QueryParam(fieldName = "vmu.meetingUserId", op = QueryOperator.NOT_IN)
    private Long[] meetingUserId;
    
    //private String 

    /**
     * @return the meetingUserId
     */
    public Long[] getMeetingUserId() {
        return meetingUserId;
    }

    /**
     * @param meetingUserId the meetingUserId to set
     */
    public void setMeetingUserId(Long[] meetingUserId) {
        this.meetingUserId = meetingUserId;
    }


}
