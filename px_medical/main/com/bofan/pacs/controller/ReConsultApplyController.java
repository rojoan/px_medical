package com.bofan.pacs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.his.service.PatientService;
import com.bofan.his.valueobject.Patient;
import com.bofan.lis.service.LisInspectionSampleServcie;
import com.bofan.lis.valueobject.LisInspectionSample;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.pacs.command.PatientArchiveQueryInfo;
import com.bofan.pacs.command.PatientExamQueryInfo;
import com.bofan.pacs.command.PatientImageQueryInfo;
import com.bofan.pacs.service.PatientExamService;
import com.bofan.pacs.service.PatientImageService;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.pacs.valueobject.PatientImage;
import com.bofan.pacs.webservice.IPacsService;
import com.bofan.reconsult.command.ReConsultingEditInfo;
import com.bofan.reconsult.service.ReConsultingService;
import com.bofan.reconsult.service.ReProfessorService;
import com.bofan.reconsult.valueobject.ReConsulting;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.manage.service.ManageService;

import sun.misc.BASE64Encoder;

/**
 * 
 * @ClassName: ExamRegisterController.java 
 * @Package com.bofan.pacs.controller 
 * @Description: 
 * @author lqw
 * @date 2017年9月29日 上午8:40:03 
 * @version V1.0
 */
@Controller
@RequestMapping("/reConsult")
public class ReConsultApplyController {
    /** logger */
    protected static Logger logger = Logger.getLogger(ReConsultApplyController.class.getName());
    @Autowired
    private ManageService manageService;
    @Autowired
    private PatientService patientService;
	@Autowired
	private PatientExamService patientExamService;
	@Autowired
	private PatientImageService patientImageService;
	@Autowired
    private IPacsService pacsService; 
	@Autowired
	private ReConsultingService reConsultingService;
	@Autowired
    private LisInspectionSampleServcie lisInspectionSampleServcie;
    @Autowired
    protected ReProfessorService reProfessorService;
	
	/**
	 * 跳转到浏览申请编辑页面
	 * @param patientInfoId
	 * @param patientExamId
	 * @param model
	 * @return
	 */
    @RequestMapping("/applyEdit.do")
    public String applyEdit(HttpServletRequest request, Long patientArchiveId, Long patientExamId, Model model) {
        String view = "pacs/reConsultEdit";
        if ( null == patientExamId) {
            return view;
        }
        // 获取病人检查信息
        PatientExamQueryInfo patientExamQueryInfo = new PatientExamQueryInfo();
        patientExamQueryInfo.setPatientExamId(patientExamId);
        PatientExam patientExam = patientExamService.findPatientExam(patientExamQueryInfo);

        // 获取病人档案信息
        PatientArchiveQueryInfo patientArchiveQueryInfo = new PatientArchiveQueryInfo();
        //patientArchiveQueryInfo.setPatientArchiveId(patientArchiveId);
        patientArchiveQueryInfo.setHospitalNo(patientExam.getHospitalNo());
        patientArchiveQueryInfo.setHtFsPacsMark(patientExam.getHtFsPacsMark());
        patientArchiveQueryInfo.setPatientArchiveNum(patientExam.getPatientArchiveNum());
        
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        if (null != patientExam) {
            ReConsulting reConsulting = reConsultingService.selectReConsultingByPatientExamId(patientExam.getPatientExamId(), Contstants.RE_CONSULT_STATUS_FINISH);
            model.addAttribute("reConsulting", reConsulting);
            model.addAttribute("patient", this.patientService.selectAObject(Patient.class, patientExam.getPatientId()));
            model.addAttribute("doctorList",  this.manageService.selectDepartmentStaffByUnitId(userInfo.getSysOrg().getUnitOrgId(), true));
            model.addAttribute("officeList", this.manageService.selectDapartment(userInfo.getSysOrg().getUnitOrgId(), true));
        }
        
        // 读取检查 JPG图片
 		List<String> patientExamJpgList = new ArrayList<String>();
 		if (Contstants.IMAGETYPE_DICOM != patientExam.getImageType()) { 
     		//查询病人图片 或者dicom图片 
         	PatientImageQueryInfo PatientImageQueryInfo = new PatientImageQueryInfo();
         	PatientImageQueryInfo.setHospitalNo(patientExam.getHospitalNo());
         	PatientImageQueryInfo.setHtFsPacsMark(patientExam.getHtFsPacsMark());
         	PatientImageQueryInfo.setPatientExamNum(patientExam.getPatientExamNum());
         	List<PatientImage> patientImageList = this.patientImageService.selectPatientImages(PatientImageQueryInfo);
         	if (null != patientImageList && patientImageList.size() > 0) {
     			for (int i = 0; i < patientImageList.size(); i++) { 
     				//通过bdbkey获取二进制文件
     				byte[]  dicomByteArray = this.pacsService.getFileByte(patientImageList.get(i).getSavePath(),patientImageList.get(i).getBdbKey());
     				if (null == dicomByteArray) {
     				    continue ;
     				}
     				
     				// 对字节数组Base64编码  
     		        BASE64Encoder encoder = new BASE64Encoder();  
     		        // 添加Base64编码过的字节数组字符串  
     				patientExamJpgList.add(encoder.encode(dicomByteArray));
     			}
     		}
 		}
       
        model.addAttribute("patientExamJpgList", patientExamJpgList);
        model.addAttribute("patientExam", patientExam);
        model.addAttribute("hospitalList", this.manageService.selectUnit(null, true));
        model.addAttribute("professorList", reProfessorService.selectReProfessorList(null));
        return view;
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
     * lis 远程会诊申请
     * @param request
     * @param lisInspectionSampleId
     * @param model
     * @return
     */
    @RequestMapping("/lisReConsultApplyEdit.do")
    public String lisReConsultApplyEdit(HttpServletRequest request, Long lisInspectionSampleId, Model model) {
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        ReConsulting reConsulting = reConsultingService.selectReConsultingByInspectionSampleId(lisInspectionSampleId, Contstants.RE_CONSULT_STATUS_FINISH);
        LisInspectionSample inspectionSample = this.lisInspectionSampleServcie.selectAObject(LisInspectionSample.class, lisInspectionSampleId);
        if (null != inspectionSample) {
            model.addAttribute("patientExam",
                    this.patientExamService.findPatientExam(new Long(inspectionSample.getPatientId()),
                            new Long(inspectionSample.getPatientType()), new Long(inspectionSample.getInpatientId())));
        }
        model.addAttribute("reConsulting", reConsulting);
        model.addAttribute("inspectionSample", inspectionSample);
        model.addAttribute("doctorList",  this.manageService.selectDepartmentStaffByUnitId(userInfo.getSysOrg().getUnitOrgId(), true));
        model.addAttribute("officeList", this.manageService.selectDapartment(userInfo.getSysOrg().getUnitOrgId(), true));
        model.addAttribute("hospitalList", this.manageService.selectUnit(null, true));
        return "lis/lisReConsultEdit";
    }
}
