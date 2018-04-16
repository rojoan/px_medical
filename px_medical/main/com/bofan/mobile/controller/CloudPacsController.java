package com.bofan.mobile.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Encoder;

import com.bofan.pacs.command.PatientExamCloudQueryInfo;
import com.bofan.pacs.command.PatientImageQueryInfo;
import com.bofan.pacs.controller.SystemCloudController;
import com.bofan.pacs.service.PatientExamService;
import com.bofan.pacs.service.PatientImageService;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.pacs.valueobject.PatientImage;
import com.bofan.pacs.webservice.IPacsService;
import com.bofan.utils.Contstants;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-11-24
 */
@Controller
@RequestMapping("/mobile.cloudPacs")
public class CloudPacsController extends SystemCloudController {
    @Autowired
    private PatientExamService patientExamService;
    
    @Autowired
    private PatientImageService patientImageService; 
    @Autowired
    private IPacsService pacsService;  
    
    /**
     * @see com.bofan.pacs.controller.SystemCloudController#cloudList(javax.servlet.http.HttpServletRequest, com.bofan.pacs.command.PatientExamCloudQueryInfo)
     */
    @RequestMapping("/cloudList.do")
    public Map<String, Object> cloudList(HttpServletRequest request, PatientExamCloudQueryInfo info) {
        return super.cloudList(request, info);
    }

    /**
     * @see com.bofan.pacs.controller.SystemCloudController#applyList(javax.servlet.http.HttpServletRequest, com.bofan.pacs.command.PatientExamCloudQueryInfo)
     */
    @RequestMapping("/applyList.do")
    public Map<String, Object> applyList(HttpServletRequest request, PatientExamCloudQueryInfo info) {
        return super.applyList(request, info);
    }
    
    
    /**
     * 查询pacs检查结果
     * @param patientExamId
     * @param model
     * @return
     */
    @RequestMapping("/showImage.do")
    @ResponseBody
    public Map<String, Object> showPacs(Long patientExamId, Model model) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (null == patientExamId) {
            return result;
        }
        PatientExam patientExam = this.patientExamService.selectAObject(PatientExam.class, patientExamId);
        if (null == patientExam) {
            return result;
        }
        
        // 读取 病理、或者内镜、或者超声JPG图片
        List<String> patientExamJpgList = new ArrayList<String>();
        //查询病人图片 或者dicom图片 
        PatientImageQueryInfo patientImageQueryInfo = new PatientImageQueryInfo();
        
        if (Contstants.IMAGETYPE_DICOM != patientExam.getImageType()) { 
            patientImageQueryInfo.setHospitalNo(patientExam.getHospitalNo());
            patientImageQueryInfo.setHtFsPacsMark(patientExam.getHtFsPacsMark());
            patientImageQueryInfo.setPatientExamNum(patientExam.getPatientExamNum());
            List<PatientImage> patientImageList = this.patientImageService.selectPatientImages(patientImageQueryInfo);
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
        result.put("patientExam", patientExam);
        result.put("patientExamJpgList", patientExamJpgList);
        return result;
    }

}
