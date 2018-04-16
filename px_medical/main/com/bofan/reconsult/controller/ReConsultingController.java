package com.bofan.reconsult.controller;

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
import com.bofan.basesystem.common.command.Page;
import com.bofan.his.service.PatientService;
import com.bofan.his.valueobject.Patient;
import com.bofan.lis.service.LisInspectionSampleServcie;
import com.bofan.lis.valueobject.LisInspectionSample;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.pacs.service.ExamResultService;
import com.bofan.pacs.service.PatientArchiveService;
import com.bofan.pacs.service.PatientExamService;
import com.bofan.pacs.valueobject.ExamResult;
import com.bofan.pacs.valueobject.PatientArchive;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.reconsult.command.ConsultingProfessorQueryInfo;
import com.bofan.reconsult.command.ReConsultingQueryInfo;
import com.bofan.reconsult.service.EmrKbService;
import com.bofan.reconsult.service.ReConsultingProfessorService;
import com.bofan.reconsult.service.ReConsultingService;
import com.bofan.reconsult.service.ReProfessorService;
import com.bofan.reconsult.valueobject.ReConsulting;
import com.bofan.reconsult.valueobject.ReConsultingProfessor;
import com.bofan.reconsult.valueobject.ReProfessor;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;
import com.bofan.videomeeting.command.VideoMeetingEditInfo;
import com.bofan.videomeeting.service.VideoMeetingService;

@Controller
@RequestMapping("/reConsult")
public class ReConsultingController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(ReConsultingController.class.getName());
    
    /** 标识提交数据 */
    private static final String SUBMIT_SAVE = "1";
    
    @Autowired
    protected EmrKbService emrKbService;
    
    @Autowired
    protected PatientService patientService;
    
    @Autowired
    protected ReConsultingService reConsultingService;
    
    @Autowired
    protected VideoMeetingService videoMeetingService;
    
    @Autowired
    protected PatientExamService patientExamService;
    
    @Autowired
    protected PatientArchiveService patientArchiveService;
    
    @Autowired
    protected ReProfessorService reProfessorService;
    
    @Autowired
    protected ExamResultService examResultService;
    
    @Autowired
    protected ReConsultingProfessorService reConsultingProfessorService;
    
    @Autowired
    protected LisInspectionSampleServcie lisInspectionSampleServcie;
    
    /**
     * 远程会诊列表
     * @return
     */
    @RequestMapping("/list.do")
    public @ResponseBody Map<String, Object> list(HttpServletRequest request, ReConsultingQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        try {
            info.setProposerId(userInfo.getUserInfoId());
            Page page = this.reConsultingService.selectReConsultingList(info);
            result.put("rows", page.getData());
            result.put("total", page.getTotalSize());
        } catch (Exception e) {
            logger.error(e);
        }
        return result;
    }
    
    /**
     * 会诊审核列表
     * @return
     */
    @RequestMapping("/auditList.do")
    public @ResponseBody Map<String, Object> auditList(HttpServletRequest request, ReConsultingQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        try {
            info.setMedicalInstitutionId(userInfo.getSysOrg().getUnitOrgId());
            info.setConsultingStatus(Contstants.RE_CONSULT_STATUS_APPLY);
            Page page = this.reConsultingService.selectReConsultingList(info);
            result.put("rows", page.getData());
            result.put("total", page.getTotalSize());
        } catch (Exception e) {
            logger.error(e);
        }
        return result;
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping("consultingProfessorList.do")
    public @ResponseBody Map<String, Object> consultingProfessorList(HttpServletRequest request, ConsultingProfessorQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        try {
            info.setReProfessorId(userInfo.getUserInfoId());
            Page page = this.reConsultingProfessorService.selectConsultingProfessorList(info);
            result.put("rows", page.getData());
            result.put("total", page.getTotalSize());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return result;

    }
    
    /**
     * 进入审核页面
     * @return
     */
    @RequestMapping("/enterAudit.do")
    public String enterAudit(Long reConsultingId, Model model) {
        String view = "reconsulting/remoteConsultAudit";
        if (null == reConsultingId || reConsultingId <= 0) {
            return view;
        }
        try {
            ReConsulting ReConsulting = this.reConsultingService.selectReConsultingById(reConsultingId);
            if (null != ReConsulting) {
                PatientExam patientExam = this.patientExamService.selectAObject(PatientExam.class, ReConsulting.getPatientExamId());
                PatientArchive patientArchive = this.patientArchiveService.selectPatientArchives(ReConsulting.getPatientId());
                model.addAttribute("patientExam", patientExam);
                model.addAttribute("patientArchive", patientArchive);
            }
            
            if (Contstants.RE_CONSULT_STATUS_APPLY.equals(ReConsulting.getConsultingStatus())) {
                model.addAttribute("professorList", reProfessorService.selectReProfessorList(null));
            }
            model.addAttribute("consult", ReConsulting);
        } catch (Exception e) {
            logger.error(e);
        }
        
        return view;
    }
    
    @RequestMapping("/showConsult.do")
    public String showConsult(Long reConsultingId, String mode, String show, Model model) {
        String view = "reconsulting/showConsult";
        if (null == reConsultingId || reConsultingId <= 0) {
            return view;
        }
        try {
            Long patientId = null;
            ReConsulting ReConsulting = this.reConsultingService.selectReConsultingById(reConsultingId);
            if (null == ReConsulting) {
                return view;
            }
            
            if (null != ReConsulting.getLisInspectionSampleId()) {
                LisInspectionSample inspectionSample = this.lisInspectionSampleServcie.selectAObject(LisInspectionSample.class, ReConsulting.getLisInspectionSampleId());
                patientId = (null !=  inspectionSample && null != inspectionSample.getPatientId() ? new Long(inspectionSample.getPatientId()) : null);
                model.addAttribute("examInfo", inspectionSample);
            } else if (null != ReConsulting.getPatientExamId()) {
                PatientExam patientExam = this.patientExamService.selectAObject(PatientExam.class, ReConsulting.getPatientExamId());
                patientId = (null !=  patientExam ? patientExam.getPatientId() : null);
                model.addAttribute("examInfo", patientExam);
            }
            if (null != patientId) {
                model.addAttribute("patient", this.patientService.selectAObject(Patient.class, patientId));
            }
            if (!Contstants.RE_CONSULT_STATUS_SVAE.equals(ReConsulting.getConsultingStatus())) {
                model.addAttribute("meeting", videoMeetingService.selectVideoMeetingByReConsultingId(reConsultingId, false));
                model.addAttribute("professorList", reProfessorService.selectReProfessorList(null));
            }
            
            model.addAttribute("consult", ReConsulting);
            model.addAttribute("mode", mode);
            model.addAttribute("show", show);
            model.addAttribute("consultUserIds", reConsultingProfessorService.selectConsultingUserIds(reConsultingId));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        
        return  view;
    }
    
    /**
     * ajax 加载远程会诊信息
     * @return
     */
    @RequestMapping("/loadReConsultData.do")
    public @ResponseBody Map<String, Object> loadReConsultData(Long reConsultingId) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (null == reConsultingId || reConsultingId <= 0) {
            return result;
        }
        try {
            ReConsulting ReConsulting = this.reConsultingService.selectReConsultingById(reConsultingId);
            if (null != ReConsulting) {
                PatientExam patientExam = this.patientExamService.selectAObject(PatientExam.class, ReConsulting.getPatientExamId());
                PatientArchive patientArchive = this.patientArchiveService.selectPatientArchives(ReConsulting.getPatientId());
                result.put("patientExam", patientExam);
                result.put("patientArchive", patientArchive);
            }
            if (!Contstants.RE_CONSULT_STATUS_SVAE.equals(ReConsulting.getConsultingStatus())) {
                result.put("meeting", videoMeetingService.selectVideoMeetingByReConsultingId(reConsultingId, false));
                result.put("professorList", reConsultingProfessorService.selectReConsultingProfessorList(reConsultingId));
            }
            result.put("consult", ReConsulting);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        
        return result;
    }
    
    
    /**
     * 保存审核
     * @return
     */
    @RequestMapping("/saveAudit.jo")
    public @ResponseBody JsonObj saveAudit(HttpServletRequest request, VideoMeetingEditInfo info) {
        JsonObj result = new JsonObj();
    	SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
    	if (null == userInfo || null == info.getReConsultingId()) {
    		result.setCode(ResponseContstants.RESULT_FAIL_CODE);
    		result.setMsg("审核失败");
    		return result;
    	}
    	
    	info.setCurrentUser(userInfo);
    	boolean isPass = SUBMIT_SAVE.equals(info.getSubmitType());
    	this.videoMeetingService.saveVideoMeeting(info, isPass);
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        result.setMsg("审核成功");
        return result;
    }
    
    /**
     * 保存完成
     * @return
     */
    @RequestMapping("/finish.jo")
    public @ResponseBody JsonObj finish(HttpServletRequest request, VideoMeetingEditInfo info) {
        JsonObj result = new JsonObj();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        if (null != userInfo && null != info.getReConsultingId()) {
        	this.reConsultingService.saveReConsultFinish(info.getReConsultingId());
        	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
            result.setMsg("保存成功");
            return result;
        }
        return result;
    }
    
    /**
     * 展示会诊及会议信息
     * @return
     */
    @RequestMapping("/meetingInfo.do")
    public String meetingInfo(Long reConsultingId, String fromFlag, Model model) {
        String view = "reconsulting/meetingInfo";
        model.addAttribute("fromFlag", fromFlag);
        if (null == reConsultingId || reConsultingId <= 0) {
            return view;
        }
        ReConsulting ReConsulting = this.reConsultingService.selectReConsultingById(reConsultingId);
        if (null == ReConsulting) {
        	return view;
        }
        
        Date curDate = new Date();
        Date begniDate = ReConsulting.getReConsultingStart();
        Date endDate = ReConsulting.getReConsultingEnd();
        if (curDate.getTime() > begniDate.getTime() && endDate.getTime() > curDate.getTime()) {
        	model.addAttribute("meetingStatus", "1");
        } else if (curDate.getTime() > begniDate.getTime() && curDate.getTime() > endDate.getTime()) {
        	model.addAttribute("meetingStatus", "2");
        }
        
        if (null != ReConsulting.getPatientId()) {
        	model.addAttribute("patient", this.patientService.selectAObject(Patient.class, ReConsulting.getPatientId()));
        }
        
        model.addAttribute("meeting", videoMeetingService.selectVideoMeetingByReConsultingId(reConsultingId, false));
        model.addAttribute("professorList", reConsultingProfessorService.selectReConsultingProfessorList(reConsultingId));
        model.addAttribute("consult", ReConsulting);
        return view;
    }
    
    /**
     * 填写报告
     * @return
     */
    @RequestMapping("/fillReport.do")
    public String fillReport(Long reConsultingId, Model model) {
        String view = "reconsulting/fillReport";
        if (null == reConsultingId || reConsultingId <= 0) {
            return view;
        }
        ReConsulting consulting = this.reConsultingService.selectReConsultingById(reConsultingId);
        if (null == consulting) {
        	return view;
        }
        if (Contstants.RE_CONSULT_STATUS_FINISH.equals(consulting.getConsultingStatus())) {
            throw new RuntimeException("会诊已结束，不能编辑会诊报告！");
        }
        
        Long patientId = null;
        Date curDate = new Date();
        Date consultDate = consulting.getReConsultingTime();
        if (!Contstants.RE_CONSULT_STATUS_ING.equals(consulting.getConsultingStatus()) && curDate.getTime() > consultDate.getTime()) {
        	model.addAttribute("meetingStatus", "1");
        }
        
        if (null != consulting.getPatientExamId()) {
        	PatientExam patientExam = this.patientExamService.selectAObject(PatientExam.class, consulting.getPatientExamId());
        	if (null != patientExam) {
        		patientId = patientExam.getPatientId();
        		model.addAttribute("examInfo", patientExam);
        		// 查询病人检查结果表
        		ExamResult examResult = this.examResultService.findExamResult(patientExam.getHospitalNo(), patientExam.getHtFsPacsMark(), patientExam.getPatientExamNum());
        		model.addAttribute("examResult", examResult);
        	}
        }
        if (null != consulting.getLisInspectionSampleId()) {
        	LisInspectionSample inspectionSample = this.lisInspectionSampleServcie.selectAObject(LisInspectionSample.class, consulting.getLisInspectionSampleId());
        	if (null != inspectionSample) {
        		patientId = (null != inspectionSample.getPatientId() ? new Long(inspectionSample.getPatientId()) : null);
        		model.addAttribute("examInfo", inspectionSample);
        	}
        }
        if (null != patientId) {
        	model.addAttribute("patient", this.patientService.selectAObject(Patient.class, patientId));
        }
        
        model.addAttribute("meeting", videoMeetingService.selectVideoMeetingByReConsultingId(reConsultingId, false));
        model.addAttribute("professorList", reConsultingProfessorService.selectReConsultingProfessorList(reConsultingId));
        model.addAttribute("consult", consulting);
        return view;
    }
    
    /**
     * 获取专家意见信息
     * @param reConsultingProfessorId
     * @return
     */
    @RequestMapping("/getPersonOpinion.do")
    public @ResponseBody ReConsultingProfessor getPersonOpinion(Long consultingProfessorId) {
    	return reConsultingProfessorService.selectAObject(ReConsultingProfessor.class, consultingProfessorId);
    }
    
    /**
     * 保存更新专家诊断意见
     * @param opinion
     * @return
     */
    @RequestMapping("/savePersonOpinion.jo")
    public @ResponseBody JsonObj savePersonOpinion(HttpServletRequest request, Long reConsultingId, String opinion) {
        JsonObj result = new JsonObj();
    	SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
    	if (null != reConsultingId) {
    		reConsultingProfessorService.updateConsultingProfessorOpinion(reConsultingId, userInfo.getUserInfoId(), opinion);
    	}
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        result.setMsg("保存成功");
        return result;
    }
    
    /**
     * 查看病人病历信息（检验报告、病例文书、映像资料、患者信息）
     * @param reConsultingId
     * @return
     */
    @RequestMapping("/showMedicalRecord")
    public String showMedicalRecord(Long reConsultingId, Model model) {
        String view = "reconsulting/showMedicalRecord";
        if (null == reConsultingId) {
            return view;
        }
        model.addAttribute("consult", this.reConsultingService.selectReConsultingById(reConsultingId));
        model.addAttribute("professorList", this.reConsultingProfessorService.selectReConsultingProfessorList(reConsultingId));
        return view;
    }
    
    /**
     * 将系统用户添加为会诊专家
     * @param ReProfessor
     * @return
     */
    @RequestMapping("/saveProfessor.jo")
    public @ResponseBody JsonObj saveProfessor(ReProfessor info) {
        JsonObj result = new JsonObj();
        if (null == info || null == info.getProfessorId()) {
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            result.setMsg("保存失败，参数无效。");
            return result;
        }
        
        ReProfessor professor = this.reProfessorService.selectAObject(ReProfessor.class, info.getProfessorId());
        if (null == professor) {
        	professor = new ReProfessor();
        }
        
        NullBeanUtils.copyProperties(professor, info);
        //professor.setValidFlag(Contstants.YES_FLAG);
        this.reProfessorService.saveAObject(professor);
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        result.setMsg("保存成功");
        return result;
    }
    
    /**
     * 根据患者ID和检查Id获取会诊对象信息 patientExamId 和 lisInspectionSampleId 不能同时有值
     * @param patientId
     * @param patientExamId
     * @param lisInspectionSampleId
     * @return
     */
    public Map<String, Object> getConsult(Long patientId, Long patientExamId, Long lisInspectionSampleId) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (null == patientId || (null == patientExamId && null == lisInspectionSampleId)) {
            return result;
        }
        
        ReConsultingQueryInfo queryInfo = new ReConsultingQueryInfo();
        queryInfo.setPatientId(patientId);
        queryInfo.setPatientExamId(patientExamId);
        queryInfo.setLisInspectionSampleId(lisInspectionSampleId);
        Page page = this.reConsultingService.selectReConsultingList(queryInfo);
        
        if (Tools.isNotEmptyList(page.getData())) {
        	ReConsulting consulting = (ReConsulting) page.getData().get(0);
        	result.put("consult", consulting);
        }
        
        return result;
    }
    
}
