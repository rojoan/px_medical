package com.bofan.videomeeting.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.pacs.service.ExamResultService;
import com.bofan.pacs.service.PatientArchiveService;
import com.bofan.pacs.service.PatientExamService;
import com.bofan.pacs.valueobject.ExamResult;
import com.bofan.pacs.valueobject.PatientArchive;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.reconsult.service.ReConsultingProfessorService;
import com.bofan.reconsult.service.ReConsultingService;
import com.bofan.reconsult.valueobject.ReConsulting;
import com.bofan.utils.Contstants;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;
import com.bofan.videomeeting.service.VideoMeetingService;
import com.bofan.videomeeting.valueobject.VideoMeeting;
import com.bofan.videomeeting.valueobject.VideoMeetingUser;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017年10月12日
 */
@Controller
@RequestMapping("/meeting")
public class VideoMeetingController {
    /** logger */
    protected static Logger logger = Logger.getLogger(VideoMeetingController.class.getName());
    
    @Autowired
    private VideoMeetingService videoMeetingService;
    
    @Autowired
    private ReConsultingService reConsultingService;
    
    @Autowired
    private PatientExamService patientExamService;
    
    @Autowired
    private PatientArchiveService patientArchiveService;
    
    @Autowired
    private ExamResultService examResultService;
    
    @Autowired
    private ReConsultingProfessorService reConsultingProfessorService;
    
    /**
     * 进入交互式会议
     * @return
     */
    @RequestMapping("/enterMeeting.do")
    public @ResponseBody Map<String, String> enterMeeting(HttpServletRequest request, Long reConsultingId, String isMobile) {
        Map<String, String> result = new HashMap<String, String>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        
        if (null == reConsultingId || reConsultingId <= 0) {
            return result;
        }
        boolean fromMobile = Tools.isNotEmptyString(isMobile) ? true : false;
        VideoMeeting VideoMeeting = videoMeetingService.selectVideoMeetingByReConsultingId(reConsultingId, true);
        VideoMeetingUser meetingUser = this.videoMeetingService.saveVideoMeetingQueue(reConsultingId, VideoMeeting.getVideoMeetingId(), userInfo.getUserInfoId(), userInfo.getName());
        String url = this.videoMeetingService.buildMeetingUrl(VideoMeeting.getConfId(), userInfo.getName(),
        		VideoMeeting.getConfkey(), meetingUser.getUserName(), meetingUser.getUserPassword(), fromMobile);
        result.put("isSuccess", ResponseContstants.RESULT_SUCCESS_CODE);
        result.put("msg", url);
        return result;
    }
    
    /**
     * 进入非交互式会议
     * @return
     */
    @RequestMapping("/notInteractiveMeeting.do")
    public String  notInteractiveMeeting(Long reConsultingId, Model model) {
        String view = "reconsulting/notInteractiveMeeting";
        if (null == reConsultingId || reConsultingId <= 0) {
            return view;
        }
        ReConsulting consulting = this.reConsultingService.selectReConsultingById(reConsultingId);
        model.addAttribute("meeting", videoMeetingService.selectVideoMeetingByReConsultingId(reConsultingId, false));
        model.addAttribute("professorList", reConsultingProfessorService.selectReConsultingProfessorList(reConsultingId));
        if (null == consulting) {
            return view;
        }
        
        Date curDate = new Date();
        Date consultDate = consulting.getReConsultingTime();
        if (!Contstants.RE_CONSULT_STATUS_ING.equals(consulting.getConsultingStatus()) && curDate.getTime() > consultDate.getTime()) {
            model.addAttribute("meetingStatus", "1");
        }
        PatientExam patientExam = this.patientExamService.selectAObject(PatientExam.class, consulting.getPatientExamId());
        PatientArchive patientArchive = this.patientArchiveService.selectPatientArchives(consulting.getPatientId());
        // 查询病人检查结果表
        ExamResult examResult = this.examResultService.findExamResult(patientExam.getHospitalNo(), patientExam.getHtFsPacsMark(), patientExam.getPatientExamNum());
        model.addAttribute("examResult", examResult);
        model.addAttribute("patientExam", patientExam);
        model.addAttribute("patientArchive", patientArchive);
        model.addAttribute("consult", consulting);
       
        return view;
    }

}
