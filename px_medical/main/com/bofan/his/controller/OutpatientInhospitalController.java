package com.bofan.his.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.his.command.OutpatientInhospitalQueryInfo;
import com.bofan.his.service.OutpatientInhospitalService;
import com.bofan.his.service.PatientAffixItemService;
import com.bofan.his.valueobject.OutpatientInhospital;
import com.bofan.his.valueobject.PatientAffixItem;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.pacs.command.PacsDetailQueryInfo;
import com.bofan.pacs.service.PacsDetailService;
import com.bofan.pacs.service.PatientExamService;
import com.bofan.pacs.service.PatientImageService;
import com.bofan.pacs.valueobject.PacsDetail;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.pacs.valueobject.PatientImage;
import com.bofan.pacs.webservice.IPacsService;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;
import com.manage.service.ManageService;

import sun.misc.BASE64Encoder;

/**
 * @Description: 门诊-住院
 * @author lqw
 */
@Controller
@RequestMapping("/outInhospital")
public class OutpatientInhospitalController {
	/** logger */
	protected static Logger logger = Logger.getLogger(OutpatientInhospitalController.class.getName());
	@Autowired
	private OutpatientInhospitalService outInhospitalService;
	@Autowired
	private ManageService manageService;
	@Autowired
    private IPacsService pacsService;
	@Autowired
	private PatientExamService patientExamService;
    @Autowired
    private PacsDetailService pacsDetailService;
	@Autowired
	private PatientImageService patientImageService; 
	@Autowired
	private PatientAffixItemService patientAffixItemService; 
	
	/**
	 * 获取登录用户所在单位的id
	 * @param request
	 * @return
	 */
	public Long getCurrentSysUserUnitOrgId(HttpServletRequest request){
		SysUserInfo sysUserInfo = (SysUserInfo)request.getSession().getAttribute( Constants.USER_KEY);
		return sysUserInfo.getSysOrg().getUnitOrgId();
	}
	
	/**
	 * 
	 * @param request
	 * @param info
	 * @return
	 */
	@RequestMapping("/listData")
	@ResponseBody
    public  Map<String, Object> listData(HttpServletRequest request, OutpatientInhospitalQueryInfo info) {
		Map<String, Object> result = new HashMap<String, Object>();
		info.setOrgId(this.getCurrentSysUserUnitOrgId(request));//查询本院的患者 
        Page page = this.outInhospitalService.selectOutpatientInhospitalList(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
	}
	
	/**
	 * 进入门诊|住院患者登记、PACS检查页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register.do")
    public  String register(HttpServletRequest request, Model model) {
		SysUserInfo sysUserInfo = (SysUserInfo)request.getSession().getAttribute( Constants.USER_KEY);
		SysOrg sysOrg =  this.manageService.loadSysOrg(sysUserInfo.getSysOrg().getUnitOrgId());
		model.addAttribute("orgId", sysOrg.getOrgId());
		model.addAttribute("hospitalNo", sysOrg.getOrgNo());
        return "his/patientRegister";
	}
	
	/**
	 * 进入 门诊|住院 编辑页面
	 * @param request
	 * @param outpatientInhospitalId
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit.do")
	public String edit(HttpServletRequest request,Long outpatientInhospitalId, String mode, Model model) {
		OutpatientInhospital outInHospital = null;
		if (null != outpatientInhospitalId) {
			outInHospital = this.outInhospitalService.selectAObject(OutpatientInhospital.class,outpatientInhospitalId);
			PatientExam patientExam = null;
			List<PatientImage> patientImageList = new ArrayList<PatientImage>();
			List<PacsDetail> pacsDetailList = new ArrayList<PacsDetail>();
			if (null != outInHospital.getInhospitalId()) {
				patientExam = this.patientExamService.findPatientExam(
						outInHospital.getPatientId(),new Long(Contstants.PATIENT_TYPE_INHOSPITAL),outInHospital.getInhospitalId());
			} else {
				patientExam = this.patientExamService.findPatientExam(
						outInHospital.getPatientId(),new Long(Contstants.PATIENT_TYPE_OUTPATIENT),outInHospital.getOutpatientId());
			}
			if (null != patientExam) {
				patientImageList = this.selectPatientImageList(patientExam.getHospitalNo(),patientExam.getHtFsPacsMark(), patientExam.getPatientExamNum());
				pacsDetailList = this.pacsDetailService.selectPacsDetailList(new PacsDetailQueryInfo(String.valueOf(patientExam.getPatientExamId())));
			}
			List<PatientAffixItem>  patientAffixItemList = this.patientAffixItemService.selectPatientAffixItem(outInHospital.getAffixId());
			model.addAttribute("patientExam", patientExam);
			model.addAttribute("patientImageList", patientImageList);
			model.addAttribute("pacsDetailList", pacsDetailList);
			model.addAttribute("patientAffixItemList", patientAffixItemList);
			
		} else {
			SysUserInfo sysUserInfo = (SysUserInfo)request.getSession().getAttribute( Constants.USER_KEY);
			SysOrg sysOrg =  this.manageService.loadSysOrg(sysUserInfo.getSysOrg().getUnitOrgId());
			outInHospital = new OutpatientInhospital();
			outInHospital.setOrgId(sysOrg.getOrgId());
			outInHospital.setHospitalNo(sysOrg.getOrgNo());
			outInHospital.setDiagnosisDate(new Date());
		}  
		model.addAttribute("outInHospital", outInHospital);
		if (Contstants.SHOW_PAGE.equals(mode)) {
			return "his/outInHospitalShow";
		}
		return "his/outInHospitalEdit"; 
	}
	
	/**
	 * 查询病人图像转出base64图像数据
	 * @param hospitalNo
	 * @param htFsPacsMark
	 * @param patientExamNum
	 * @return
	 */
	private List<PatientImage> selectPatientImageList(String hospitalNo, String htFsPacsMark, String patientExamNum) {
		List<PatientImage> patientImageList = this.patientImageService.selectPatientImageList(hospitalNo,htFsPacsMark,patientExamNum);
		if (Tools.isNotEmptyList(patientImageList)) {
			for (PatientImage patientImage : patientImageList) {
				//通过bdbkey获取二进制文件 
				byte[]  dicomByteArray = this.pacsService.getFileByte(patientImage.getSavePath(),patientImage.getBdbKey());
				 // 对字节数组Base64编码  
		        BASE64Encoder encoder = new BASE64Encoder();  
		        // 添加Base64编码过的字节数组字符串  
				patientImage.setImgBase64Data(encoder.encode(dicomByteArray));
			}
		}
		return patientImageList;
	}
	
	@RequestMapping("/list.do")
	public String list(HttpServletRequest request, Model model) {
		  return "his/outInHospitalList";
	}

	 /**
     * 保存门诊|住院登记信息 和 PACS检查信息
     * @param info
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/saveOutInhospital.do")
    @ResponseBody 
    public JsonObj saveOutpatientInhospital(String regPatientExamData) { 
        //保存页面数据
        JsonObj result = this.outInhospitalService.saveOutpatientInhospital(regPatientExamData);
        if (result.isSuccess()) {
            Map<String,Object> data  = (Map<String, Object>) result.getData();
            PatientExam patientExam = (PatientExam) data.get("patientExam");
            if (null != patientExam && Contstants.IMAGETYPE_DICOM.equals(patientExam.getImageType())) {
                //请求webservice 让dicomService解析dicom文件内容并更新pacsDetail的表数据
                try {
                    this.pacsService.parseDicomToPacsDetail(String.valueOf(patientExam.getPatientExamId()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
     
   /**
    * 保存检查图片
    * @param filedata
    * @param request
    * @return
 * @throws UnsupportedEncodingException 
    */
    @RequestMapping("/upload.do")
    @ResponseBody 
    public  String upload(@RequestParam("filedata") CommonsMultipartFile filedata, HttpServletRequest request) throws UnsupportedEncodingException {
    	 JsonObj  result = new JsonObj();
    	 Map<String, String> data = new HashMap<String, String>();
         // MultipartFile是对当前上传的文件的封装，当要同时上传多个文件时，可以给定多个MultipartFile参数(数组)
         if (filedata.isEmpty()) {
        	 result.setCode(ResponseContstants.RESULT_FAIL_CODE);
        	 return JSON.toJSONString(result);
         } 
          
    	 byte[] byteData;
		 try {
			byteData = readInputStreamToByte(filedata.getInputStream());
		 } catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		 }
    	 String imageFileName = filedata.getOriginalFilename();
    	 String imageType = filedata.getOriginalFilename().substring(imageFileName.indexOf("."));// 取文件格式后缀名
         imageFileName = this.patientImageService.bulidImageFileName();
         String fileUuid = this.patientImageService.bulidBdbKey();
         
         String savePath = this.pacsService.putByteFile(fileUuid,byteData);
         data.put("imgBase64Data", new BASE64Encoder().encode(byteData)); 
         data.put("savePath", savePath); 
         data.put("bdbKey", fileUuid); 
         data.put("imageFileName", imageFileName); 
         data.put("imageType", imageType); 
         result.setData(data);
         return new String(JSON.toJSONString(result).getBytes("UTF-8"), "ISO-8859-1");
    }
    
    /**
     * 删除家庭基本档案
     * @param gravidaDetailId 
     * @return
     */
     @RequestMapping(value = "/markInvalid.do")
     @ResponseBody 
     public JsonObj markInvalid(Long outpatientInhospitalId ) {
     	return this.outInhospitalService.markInvalid(outpatientInhospitalId);
     }
     
     /**
      * 将InputStream读取到字节数组中
      * @param inStream
      * @return
      * @throws IOException
      */
    public  byte[] readInputStreamToByte(InputStream inStream) {     
         ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
         byte[] buffer = new byte[1024];     
         int len = -1;     
         try {
 			while((len = inStream.read(buffer)) != -1){     
 			  outStream.write(buffer, 0, len);      
 			}
 		} catch (IOException e) {
             throw new RuntimeException(e);
 		} finally {
 			try {
 				if (outStream != null) {
 					outStream.close();
 				}
 			} catch (IOException e) {
 				throw new RuntimeException(e);
 			}      
 			try {
 				if (inStream != null) {
 					inStream.close();
 				}
 			} catch (IOException e) {
 				throw new RuntimeException(e);
 			}      
 		}
         return outStream.toByteArray();     
     } 
     
     
}
