package com.bofan.videomeeting.timer;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bofan.utils.Contstants;
import com.bofan.videomeeting.command.VideoMeetingQueueQueryInfo;
import com.bofan.videomeeting.service.VideoMeetingService;
import com.bofan.videomeeting.valueobject.VideoMeetingQueue;

/**
 * 定时扫描清除视频会议接入队列的用户（只要会议结束，就要清除对列表中对应的用户）
 * @Description
 * @author xlf
 * @version 
 * 2017-10-26
 */
@Component
public class CleanMeetingUserQeueJob {
    /** logger */
    protected static Logger logger = Logger.getLogger(CleanMeetingUserQeueJob.class.getName());
    
    @Autowired
    private VideoMeetingService videoMeetingService;
    
    /**
     * 默认构造函数
     */
    public CleanMeetingUserQeueJob(){    
        logger.info("已启动定时清除视频会议用户队列定时器");
    }   
    
    
    /**
     * 每天12点和19点执行一次
     */
    @Scheduled(cron = "0 0 12,19 * * ?")
    public void run(){
        logger.info("开始清除视频会议已结束的用户队列...");
        try {
            VideoMeetingQueueQueryInfo queryInfo = new VideoMeetingQueueQueryInfo();
            queryInfo.setConsultingStatus(Contstants.RE_CONSULT_STATUS_FINISH);
            List<VideoMeetingQueue> dataList = this.videoMeetingService.selectVideoMeetingQueue(queryInfo);
            
            if (!dataList.isEmpty()) {
                this.videoMeetingService.deleteVideoMeetingQueueList(dataList);
            }
            
            logger.info("已成功清除" + dataList.size() + "个用户...");
        } catch (Exception e) {
            logger.error("清除失败", e);
        }  
    } 
}
