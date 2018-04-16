package com.bofan.mobile.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.his.valueobject.Patient;
import com.bofan.lis.valueobject.LisInspectionSample;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.pacs.command.PatientImageQueryInfo;
import com.bofan.pacs.service.PatientImageService;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.pacs.valueobject.PatientImage;
import com.bofan.pacs.webservice.IPacsService;
import com.bofan.reconsult.command.ConsultingProfessorQueryInfo;
import com.bofan.reconsult.command.EmrKbDetailQueryInfo;
import com.bofan.reconsult.command.ReConsultingEditInfo;
import com.bofan.reconsult.command.ReConsultingQueryInfo;
import com.bofan.reconsult.controller.ReConsultingController;
import com.bofan.reconsult.valueobject.EmrKbDetail;
import com.bofan.reconsult.valueobject.ReConsulting;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.videomeeting.command.VideoMeetingEditInfo;

import sun.misc.BASE64Encoder;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-11-24
 */
@Controller
@RequestMapping("/mobile.reconsult")
public class ReconsultController extends ReConsultingController {
    
    @Autowired
    private PatientImageService patientImageService; 
    @Autowired
    private IPacsService pacsService; 
    
    /**
     * @see com.bofan.reconsult.controller.ReConsultingController#list(javax.servlet.http.HttpServletRequest, com.bofan.reconsult.command.ReConsultingQueryInfo)
     */
    @RequestMapping("/list.do")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request, ReConsultingQueryInfo info) {
        //info.setConsultingStatus("");
        return super.list(request, info);
    }

    /**
     * @see com.bofan.reconsult.controller.ReConsultingController#auditList(javax.servlet.http.HttpServletRequest, com.bofan.reconsult.command.ReConsultingQueryInfo)
     */
    @RequestMapping("/auditList.do")
    @ResponseBody
    public Map<String, Object> auditList(HttpServletRequest request, ReConsultingQueryInfo info) {
        return super.auditList(request, info);
    }

    /**
     * @see com.bofan.reconsult.controller.ReConsultingController#consultingProfessorList(javax.servlet.http.HttpServletRequest, com.bofan.reconsult.command.ConsultingProfessorQueryInfo)
     */
    @RequestMapping("consultingProfessorList.do")
    public Map<String, Object> consultingProfessorList(HttpServletRequest request, ConsultingProfessorQueryInfo info) {
        return super.consultingProfessorList(request, info);
    }

    /**
     * @see com.bofan.reconsult.controller.ReConsultingController#meetingInfo(java.lang.Long, java.lang.String, org.springframework.ui.Model)
     */
    @RequestMapping("/consultInfo.do")
    @ResponseBody
    public Map<String, Object> consultInfo(Long reConsultingId, String fromFlag, Model model) {
        Map<String, Object> result = new HashMap<String, Object>();
        super.meetingInfo(reConsultingId, fromFlag, model);
        Map<String, Object> dataMap = model.asMap();
        result.putAll(dataMap);
        return result;
    }

    /**
     * 跳转病人检查申请编辑页面
     * @param patientInfoId
     * @param patientExamId
     * @param model
     * @return
     */
    @RequestMapping("/exmaApplyForm.do")
    public @ResponseBody Map<String, Object> applyForm(HttpServletRequest request, Long patientExamId) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        if ( null == patientExamId) {
            return dataMap;
        }
        // 获取病人检查信息
        PatientExam patientExam = patientExamService.selectAObject(PatientExam.class, patientExamId);
        if (null != patientExam) {
            ReConsulting reConsulting = reConsultingService.selectReConsultingByPatientExamId(patientExam.getPatientExamId(), Contstants.RE_CONSULT_STATUS_FINISH);
            dataMap.put("reConsulting", reConsulting);
            dataMap.put("patient", this.patientService.selectAObject(Patient.class, patientExam.getPatientId()));
        }
        
        dataMap.put("patientExam", patientExam);
        return dataMap;
    }
    
    /**
     * 跳转检验申请编辑页面
     * @param request
     * @param lisInspectionSampleId
     * @return
     */
    @RequestMapping("/listApplyForm.do")
    @ResponseBody
    public Map<String, Object> lisReConsultApplyEdit(HttpServletRequest request, Long lisInspectionSampleId) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        ReConsulting reConsulting = reConsultingService.selectReConsultingByInspectionSampleId(lisInspectionSampleId, Contstants.RE_CONSULT_STATUS_FINISH);
        LisInspectionSample inspectionSample = lisInspectionSampleServcie.selectAObject(LisInspectionSample.class, lisInspectionSampleId);
        if (null == inspectionSample) {
            return dataMap;
        }
        
        dataMap.put("reConsulting", reConsulting);
        dataMap.put("inspectionSample", inspectionSample);
        dataMap.put("patient", this.patientService.selectAObject(Patient.class, Long.valueOf(inspectionSample.getPatientId())));
        dataMap.put("patientExam", patientExamService.findPatientExam(new Long(inspectionSample.getPatientId()), new Long(inspectionSample.getPatientType()), new Long(inspectionSample.getInpatientId())));
        return dataMap;
    }
    
    /**
     * 保存申请
     * @param info
     * @param model
     * @return
     */
    @RequestMapping(value = "/applySave.jo")
    public @ResponseBody JsonObj applySave(HttpServletRequest request, ReConsultingEditInfo info) {
        JsonObj result = new JsonObj();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        info.setProposerId(userInfo.getUserInfoId());
        info.setProposerName(userInfo.getName());
        
        if (!Contstants.RE_CONSULT_STATUS_FINISH.equals(info.getConsultingStatus())) {
            info.setReConsultingTime(new Date());
        }
        if (Contstants.RE_CONSULT_STATUS_APPLY.equals(info.getConsultingStatus())) {
            info.setReApplyTime(new Date());
            
        }
        if (Contstants.RE_CONSULT_STATUS_ING.equals(info.getConsultingStatus())) {
            info.setReConsultingTime(info.getReConsultingStart());
        }
        reConsultingService.saveReConsulting(info);
        result.setCode(info.getReConsultingId().toString());
        result.setMsg("保存成功");
        return result;
    }
    
    /**
     * @see com.bofan.reconsult.controller.ReConsultingController#showConsult(java.lang.Long, java.lang.String, java.lang.String, org.springframework.ui.Model)
     */
    @RequestMapping("/auditEidt.do")
    @ResponseBody
    public Map<String, Object> auditEidt(Long reConsultingId, Model model) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (null == reConsultingId || reConsultingId <= 0) {
            return result;
        }
        try {
            ReConsulting consulting = this.reConsultingService.selectReConsultingById(reConsultingId);
            if (null == consulting) {
                return result;
            }
            if (null != consulting.getPatientId()) {
                result.put("patient", this.patientService.selectAObject(Patient.class, consulting.getPatientId()));
            }
            if (!Contstants.RE_CONSULT_STATUS_SVAE.equals(consulting.getConsultingStatus())) {
                result.put("meeting", videoMeetingService.selectVideoMeetingByReConsultingId(reConsultingId, false));
                result.put("consultUserIds", reConsultingProfessorService.selectConsultingUserIds(reConsultingId));
            }
            
            result.put("consult", consulting);
            result.put("professorList", reProfessorService.selectReProfessorList(null));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return result;
    }

    /**
     * @see com.bofan.reconsult.controller.ReConsultingController#saveAudit(javax.servlet.http.HttpServletRequest, com.bofan.videomeeting.command.VideoMeetingEditInfo)
     */
    @RequestMapping("/saveAudit.jo")
    public @ResponseBody JsonObj saveAudit(HttpServletRequest request, VideoMeetingEditInfo info) {
        return super.saveAudit(request, info);
    }

    /**
     * @see com.bofan.reconsult.controller.ReConsultingController#showMedicalRecord(java.lang.Long, org.springframework.ui.Model)
     */
    @RequestMapping("/consultDetailInfo.do")
    @ResponseBody
    public Map<String, Object> consultDetailInfo(Long reConsultingId, Model model) {
        Map<String, Object> result = new HashMap<String, Object>();
        super.showMedicalRecord(reConsultingId, model);
        Map<String, Object> dataMap = model.asMap();
        result.putAll(dataMap);
        return result;
    }

    /**
     * @see com.bofan.reconsult.controller.ReConsultingController#getConsult(java.lang.Long, java.lang.Long)
     */
    @RequestMapping("/getConsult.do")
    @ResponseBody
    public Map<String, Object> getConsult(Long patientId, Long patientExamId, Long lisInspectionSampleId) {
        return super.getConsult(patientId, patientExamId, lisInspectionSampleId);
    }
    
    /**
     * 编辑填写报告
     * @param request
     * @param patientExamId
     * @param reConsultingId
     * @param model
     * @return
     */
    @RequestMapping("/examReportEdit.do")
    @ResponseBody
    public Map<String, Object> examReportEdit(Long reConsultingId) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (null == reConsultingId) {
            return result;
        }
        
        ReConsulting consulting = this.reConsultingService.selectReConsultingById(reConsultingId);
        if (null == consulting) {
            return result;
        }
        PatientExam patientExam = null;
        if (null != consulting.getPatientExamId()) {
            patientExam = this.patientExamService.selectAObject(PatientExam.class, consulting.getPatientExamId());
        }
        
        //根据影像科室标识判断患者检查类型 
        List<String> patientExamJpgList = new ArrayList<String>();
        if (null != patientExam && Contstants.IMAGETYPE_DICOM != patientExam.getImageType()) { 
            // 读取 病理、或者内镜、或者超声JPG图片
            //查询病人图片 或者dicom图片 
            PatientImageQueryInfo PatientImageQueryInfo = new PatientImageQueryInfo();
            
            PatientImageQueryInfo.setHospitalNo(patientExam.getHospitalNo());
            PatientImageQueryInfo.setHtFsPacsMark(patientExam.getHtFsPacsMark());
            PatientImageQueryInfo.setPatientExamNum(patientExam.getPatientExamNum());
            List<PatientImage> patientImageList = this.patientImageService.selectPatientImages(PatientImageQueryInfo);
            if (null != patientImageList && patientImageList.size() > 0) {
                for (PatientImage patientImage : patientImageList) {
                    //通过bdbkey获取二进制文件
                    byte[] dicomByteArray = null;
                    try {
                        dicomByteArray = this.pacsService.getFileByte(patientImage.getSavePath(),patientImage.getBdbKey()); 
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                     // 对字节数组Base64编码  
                    BASE64Encoder encoder = new BASE64Encoder();  
                    // 添加Base64编码过的字节数组字符串  
                    patientExamJpgList.add(encoder.encode(dicomByteArray));
                }
            }
        }
        
        result.put("patientExamJpgList", patientExamJpgList);
        result.put("patientExam", patientExam);
        result.put("consulting", consulting);
        
        return result;
    }
    
    /**
     * 获取知识内容列表
     * @param queryInfo
     * @return
     */
    @RequestMapping("/getEmrkbDetailList.do")
    @ResponseBody
    public List<EmrKbDetail> getEmrkbDetailList(EmrKbDetailQueryInfo queryInfo) {
        List<EmrKbDetail> dataList = emrKbService.selectEmrKbDetail(queryInfo);
        return dataList;
    }

    /**
     * @see com.bofan.reconsult.controller.ReConsultingController#finish(javax.servlet.http.HttpServletRequest, com.bofan.videomeeting.command.VideoMeetingEditInfo)
     */
    @RequestMapping("/finish.jo")
    @ResponseBody
    public JsonObj finish(HttpServletRequest request, VideoMeetingEditInfo info) {
        return super.finish(request, info);
    }
    
}
