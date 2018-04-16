package com.bofan.videomeeting.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.dictionary.support.DictionarysInVelocityToolbox;
import com.bofan.reconsult.service.ReConsultingProfessorService;
import com.bofan.reconsult.service.ReConsultingService;
import com.bofan.reconsult.valueobject.ReConsulting;
import com.bofan.utils.Contstants;
import com.bofan.utils.DateHelper;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;
import com.bofan.videomeeting.command.VideoMeetingEditInfo;
import com.bofan.videomeeting.command.VideoMeetingQueryInfo;
import com.bofan.videomeeting.command.VideoMeetingQueueQueryInfo;
import com.bofan.videomeeting.command.VideoMeetingUserQueryInfo;
import com.bofan.videomeeting.valueobject.VideoMeeting;
import com.bofan.videomeeting.valueobject.VideoMeetingQueue;
import com.bofan.videomeeting.valueobject.VideoMeetingUser;
import com.bofan.videomeeting.video.VideoMeetingUtils;

/**
 * @Description
 * @author xlf
 * @version 1.0
 * 2017-10-02
 */
@Service
@Transactional
public class VideoMeetingService extends AbstractAnnoCommonService {
    @Autowired
    private VideoMeetingUtils videoMeetingUtils;
    @Autowired
    private ReConsultingService reConsultingService;
    @Autowired
    private ReConsultingProfessorService reConsultingProfessorService;
    
    /**
     * 根据主键获取会议信息
     * @param videoMeetingId
     * @return
     */
    public VideoMeeting selectVideoMeetingById(Long videoMeetingId) {
        return super.load(VideoMeeting.class, videoMeetingId);
    }
    
    /**
     * 根据远程会诊ID获取会议信息
     * @param reConsultingId
     * @return
     */
    public VideoMeeting selectVideoMeetingByReConsultingId(Long reConsultingId, boolean isException) {
        VideoMeetingQueryInfo queryInfo = new VideoMeetingQueryInfo();
        queryInfo.setReConsultingId(reConsultingId);
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<VideoMeeting> dataList = super.executeSql(VideoMeeting.class, qo.getQueryString(), qo.getParam());
        VideoMeeting meeting = dataList.isEmpty() ? null : dataList.get(0);
        if (null == meeting && isException) {
            throw new RuntimeException("会议不存在");
        }
        Date curDate = new Date();
        if (isException && (null == meeting || curDate.getTime() > meeting.getEndTime().getTime())) {
            throw new RuntimeException("会议已结束");
        }
        return meeting;
    }
    
    /**
     * 保存会议信息(即保存审核，审核通过时创建会议)
     * @param info
     */
    @SuppressWarnings("unchecked")
    public void saveVideoMeeting(VideoMeetingEditInfo info, boolean isPass) {
        Map<String, String> meetingUser = (Map<String, String>)DictionarysInVelocityToolbox.getDictionary("dicCreateMeetingUser");
        Iterator<Entry<String,String>> iter = meetingUser.entrySet().iterator(); 
        Entry<String,String> entry = iter.next(); 
        if (Tools.isEmptyString(entry.getKey()) || Tools.isEmptyString(entry.getValue())) {
            throw new RuntimeException("不存在可创建会议的用户，请检查字典是否已配置好");
        }
        
        String[] consultPerson = info.getPonsultingProfessor(); 
        VideoMeeting videoMeeting = null;
        if (null == consultPerson) {
            consultPerson = new String[0];
        }
        if (null != info.getVideoMeetingId()) {
            videoMeeting = this.selectVideoMeetingById(info.getVideoMeetingId());
        } else {
            videoMeeting = new VideoMeeting();
        }
        // 保存会议信息，会议人数为参会人数 + 1(会议发起人)
        Long num = Long.valueOf(consultPerson.length + 1);
        NullBeanUtils.copyProperties(videoMeeting, info);
        //SysUserInfo userInfo = info.getCurrentUser();
        
        videoMeeting.setUsername(entry.getKey());
        videoMeeting.setUserpassword(entry.getValue());
        videoMeeting.setReservetype("1");
        videoMeeting.setBandwidth("4096");
        videoMeeting.setMaxpersonspeak(num);
        videoMeeting.setAttendnum(num);
        super.saveAndRefresh(videoMeeting);
        
        // 更新远程会诊信息
        ReConsulting consulting = reConsultingService.selectReConsultingById(info.getReConsultingId());
        consulting.setConsultingStatus(isPass ? Contstants.RE_CONSULT_STATUS_ING : Contstants.RE_CONSULT_STATUS_APPLY);
        consulting.setReConsultingTime(info.getBeginTime());
        consulting.setReConsultingStart(info.getBeginTime());
        consulting.setReConsultingEnd(info.getEndTime());
        super.save(consulting);
        
        // 保存参会人
        reConsultingProfessorService.saveReConsultingProfessor(info.getReConsultingId(), consultPerson, Contstants.YES_FLAG);
        // 通过webserice，在远程视频会议系统创建会议
        if (isPass && Contstants.RE_CONSULT_TYPE_MUTUAL.equals(consulting.getConsultationType())) {
            String beginTime = DateHelper.getFormateDateStr(info.getBeginTime());
            String endTime = DateHelper.getFormateDateStr(info.getEndTime());
            String confId = videoMeetingUtils.createMeeting(entry.getKey(), entry.getValue(), info.getTopic(), beginTime, endTime, num.intValue());
            if (StringUtils.isBlank(confId)) {
                throw new RuntimeException("创建会议失败");
            } else {
                videoMeeting.setConfId(confId);
                super.save(videoMeeting);
            }
        }
    }
    
    /**
     * 更新会议Id
     * @param videoMeeting
     */
    public void updateVideoMeeting(Long videoMeetingId, String confId) {
        if (null != videoMeetingId && null != confId) {
            VideoMeeting videoMeeting = this.selectVideoMeetingById(videoMeetingId);
            if (null != videoMeeting) {
                videoMeeting.setConfId(confId);
                super.save(videoMeeting);
            }
        
        }
    }
    
    /**
     * 添加一个会议用户到对列表中，
     * @param reConsultingId
     * @param meetingId
     * @param userInfoId
     * @param name
     * @return
     */
    public VideoMeetingUser saveVideoMeetingQueue(Long reConsultingId, Long meetingId, Long userInfoId, String name) {
        // 获取已存在队列表中的用户
        List<VideoMeetingQueue> QueueList = this.selectVideoMeetingQueue(reConsultingId, meetingId);
        // 标识当前用户已经登录过
        boolean existQueue = false;
        Long tempMeetingUserId = null;
        Long[] meetingUserIds = null;
        if (null != QueueList && QueueList.size() > 0) {
            int index = 0;
            meetingUserIds = new Long[QueueList.size()];
            for (VideoMeetingQueue queue : QueueList) {
                if (userInfoId.longValue() == queue.getUserInfoId().longValue()) {
                    existQueue = true;
                    tempMeetingUserId = queue.getMeetingUserId();
                    break;
                }
                meetingUserIds[index] = queue.getMeetingUserId();
                index++;
            }
        }
        
        if (existQueue && null != tempMeetingUserId) {
            return super.load(VideoMeetingUser.class, tempMeetingUserId);
        }
        
        // 获取未存在对列表中的会议用户，null表示用户已用完
        VideoMeetingUser meetingUser = this.selectVideoMeetingUser(meetingUserIds);
        if (null == meetingUser) {
            throw new RuntimeException("会议用户人数已满");
        }
        
        // 添加一个会议用户到对列表中
        VideoMeetingQueue meetingQueue = new VideoMeetingQueue();
        meetingQueue.setMeetingUserId(meetingUser.getMeetingUserId());
        meetingQueue.setUserName(meetingUser.getUserName());
        meetingQueue.setReConsultingId(reConsultingId);
        meetingQueue.setVideoMeetingId(meetingId);
        meetingQueue.setUserInfoId(userInfoId);
        meetingQueue.setName(name);
        super.save(meetingQueue);
        
        return meetingUser;
    }
    
    /**
     * 删除多个用户队列
     * @param dataList
     */
    public void deleteVideoMeetingQueueList(List<VideoMeetingQueue> dataList) {
        super.deleteAll(dataList);
    }
    
    /**
     * 根据远程会诊ID和会议ID获取会议用户的队列信息
     * @param reConsultingId 远程会诊ID
     * @param meetingId 会议ID
     * @return
     */
    public List<VideoMeetingQueue> selectVideoMeetingQueue(Long reConsultingId, Long meetingId) {
        if (null == reConsultingId || null == meetingId) {
            return null;
        }
        
        VideoMeetingQueueQueryInfo queryInfo = new VideoMeetingQueueQueryInfo();
        queryInfo.setReConsultingId(reConsultingId);
        queryInfo.setVideoMeetingId(meetingId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<VideoMeetingQueue> dataList = super.executeSql(VideoMeetingQueue.class, qo.getQueryString(), qo.getParam());
        return dataList;
    }
    
    /**
     * 查询会议用户的队列信息
     * @param queryInfo
     * @return
     */
    public List<VideoMeetingQueue> selectVideoMeetingQueue(VideoMeetingQueueQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<VideoMeetingQueue> dataList = super.executeSql(VideoMeetingQueue.class, qo.getQueryString(), qo.getParam());
        return dataList;
    }
    
    /**
     * 查询不存在会议用户ID数组（meetingUserIds）中的会议用户
     * @param meetingUserIds 会议用户ID数组
     * @return
     */
    public VideoMeetingUser selectVideoMeetingUser(Long[] meetingUserIds) {
        VideoMeetingUserQueryInfo queryInfo = new VideoMeetingUserQueryInfo();
        queryInfo.setMeetingUserId(meetingUserIds);
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<VideoMeetingUser> dataList = super.executeSql(VideoMeetingUser.class, qo.getQueryString(), qo.getParam());
        return dataList.isEmpty() ? null : dataList.get(0);
    }

    /**
     * 生成进入会议URL地址
     * @param confId
     * @param sysUserName
     * @param meetingPwd
     * @param meetingUser
     * @param meetingUserPwd
     * @return
     * @throws UnsupportedEncodingException
     */
    public String buildMeetingUrl(String confId, String sysUserName, String meetingPwd, String meetingUser,
            String meetingUserPwd, boolean isMobile) {
        confId = null != confId ? confId : "";
        sysUserName = null != sysUserName ? sysUserName : "";
        meetingPwd = null != meetingPwd ? meetingPwd : "";
        meetingUser = null != meetingUser ? meetingUser : "";
        meetingUserPwd = null != meetingUserPwd ? meetingUserPwd : "";
        
        return this.videoMeetingUtils.buildMeetingUrl(confId, sysUserName, meetingPwd, meetingUser, meetingUserPwd, isMobile);
    }
}
