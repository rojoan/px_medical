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
@QueryInfo(from = "com.bofan.videomeeting.valueobject.VideoMeetingQueue vmq")
public class VideoMeetingQueueQueryInfo extends BaseCommandInfo {

    /** 远程会诊ID */
    @QueryParam(fieldName = "vmq.reConsultingId", op = QueryOperator.EQU)
    private Long reConsultingId;
    
    /** 会议ID */
    @QueryParam(fieldName = "vmq.videoMeetingId", op = QueryOperator.EQU)
    private Long videoMeetingId;
    
    /** 会议ID */
    @QueryParam(fieldName = "vmq.consulting.consultingStatus", op = QueryOperator.EQU)
    private String consultingStatus;

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
     * @return the consultingStatus
     */
    public String getConsultingStatus() {
        return consultingStatus;
    }

    /**
     * @param consultingStatus the consultingStatus to set
     */
    public void setConsultingStatus(String consultingStatus) {
        this.consultingStatus = consultingStatus;
    }
    
    
}
