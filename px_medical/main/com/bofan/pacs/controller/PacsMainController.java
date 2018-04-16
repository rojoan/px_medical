package com.bofan.pacs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.pacs.command.PatientExamQueryInfo;
import com.bofan.pacs.command.PatientImageQueryInfo;
import com.bofan.pacs.service.PacsDetailService;
import com.bofan.pacs.service.PatientExamService;
import com.bofan.pacs.service.PatientImageService;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.pacs.valueobject.PatientImage;
import com.bofan.pacs.webservice.IPacsService;
import com.bofan.utils.Base64Utils;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;
import com.bofan.zipcompress.ZIPCompressUtils;

import sun.misc.BASE64Encoder;

/**
 * 
 * @author xlf
 *
 */
@Controller
@RequestMapping("/pacs")
public class PacsMainController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(ReConsultApplyController.class.getName());

    /** 存放由base64数据 生成的图片目录 */
    @Value("${pacs.compressImg.imgFolder}")
    private String compressImgFolder;

    /** 存放压缩后的文件 */
    @Value("${pacs.compressImg.rootFolder}")
    private String compressImgRootFolder;
    @Autowired
    private IPacsService pacsService;
    @Autowired
    private PatientImageService patientImageService;
    @Autowired
    private PatientExamService patientExamService;
    @Autowired
    private PacsDetailService pacsDetailService;
    
    /**
     * 根据检查ID获取影像信息
     * @param patientExamQueryInfo
     * @return
     */
    @RequestMapping("/findImageInfo.do")
    @ResponseBody
    public Map<String, Object> findImageInfo(Long patientExamId, Long patientId, Long patientType, Long inpatientId){
        Map<String, Object> result = new HashMap<String, Object>();
        PatientExam patientExam = null;
        // 存放病理、或者内镜、或者超声JPG图片
        List<String> patientExamJpgList = new ArrayList<String>();
        if (null != patientExamId) {
            patientExam = this.patientExamService.selectAObject(PatientExam.class, patientExamId);
        } else {
            patientExam = patientExamService.findPatientExam(patientId, patientType, inpatientId);
        }

        //查询病人图片 或者dicom图片 
        PatientImageQueryInfo patientImageQueryInfo = new PatientImageQueryInfo();
        if (null != patientExam && Contstants.IMAGETYPE_DICOM != patientExam.getImageType()) { 
            patientImageQueryInfo.setHospitalNo(patientExam.getHospitalNo());
            patientImageQueryInfo.setHtFsPacsMark(patientExam.getHtFsPacsMark());
            patientImageQueryInfo.setPatientExamNum(patientExam.getPatientExamNum());
            List<PatientImage> patientImageList = this.patientImageService.selectPatientImages(patientImageQueryInfo);
            if (null != patientImageList && patientImageList.size() > 0) {
                for (PatientImage patientImage : patientImageList) { 
                     //通过bdbkey获取二进制文件
                    byte[] dicomByteArray = null; 
                    try {
                        dicomByteArray = this.pacsService.getFileByte(patientImage.getSavePath(), patientImage.getBdbKey());
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
            
            result.put("patientExam", patientExam);
            result.put("patientExamJpgList", patientExamJpgList);
        }
        return result;
    }
    
    /**
     * 
     * @param patientExamQueryInfo
     * @return
     */
    @RequestMapping("/findPatientExamInfo.do")
    @ResponseBody
    public  JsonObj findPatientExamInfo(PatientExamQueryInfo patientExamQueryInfo){
    	JsonObj result = new JsonObj();
    	result.setData(this.patientExamService.findPatientExam(patientExamQueryInfo));
    	return result;
    }
    
    /**
     * 打包压缩图片
     * 
     * @param patientExamId
     */
    @RequestMapping("/compressImg.do")
    public @ResponseBody String compressImg(HttpServletResponse response, String patientExamId) {
        if (Tools.isEmptyString(patientExamId)) {
            return ResponseContstants.RESULT_FAIL_CODE;
        }
        // 先获取病人检查图片数据，如果没有再从dicm文件解析来的图片数据获取
        String[] base64Array = this.getPatientImageBase64(patientExamId);
        if (null == base64Array || base64Array.length <= 0) {
            base64Array = this.getPacsDicomBase64(patientExamId);
        }
        if (null == base64Array || base64Array.length <= 0 || (base64Array.length == 1 && Tools.isEmptyString(base64Array[0]))) {
            return ResponseContstants.RESULT_FAIL_CODE; 
        }

        int index = 0;
        String fileName = patientExamId + Contstants.PACS_IMG_SEPARATOR;
        String folder = this.compressImgRootFolder + this.compressImgFolder + patientExamId;
        String zipFolder = this.compressImgRootFolder + this.compressImgFolder;
        String zipFileName = patientExamId + Contstants.PACS_IMG_COMPRESS_SUFFIX;
        File file = new File(folder);
        for (String item : base64Array) {
            if (Tools.isEmptyString(item)) {
                continue;
            }
            index++;
            if (!file.exists()) {
                file.mkdirs();
            }
            // base64转成图片
            try {
				Base64Utils.base64ToImg(item, folder + "/" + fileName + index + Contstants.PACS_IMG_SUFFIX);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
        }
        
        // 将图片压缩成zip包
        if (ZIPCompressUtils.existChild(file)) {
            try {
				ZIPCompressUtils.doCompress(folder, zipFolder + zipFileName);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
            ZIPCompressUtils.deleteFolder(file);
        }
        
        return ResponseContstants.RESULT_SUCCESS_CODE;
    }

    /**
     * 下载pacs图片
     * 
     * @param patientExamId
     * @throws Exception
     */
    @RequestMapping("/downloadImg.do")
    public String downloadImg(HttpServletResponse response, String patientExamId) throws Exception {
        ServletOutputStream out = null;
        if (Tools.isEmptyString(patientExamId)) {
        	return null;
        }
        String zipFolder = this.compressImgRootFolder + this.compressImgFolder;
        String zipFileName = patientExamId + Contstants.PACS_IMG_COMPRESS_SUFFIX;
        File zipFile = new File(zipFolder + zipFileName);
        try {
            response.reset();
            response.setContentType("multipart/form-data");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + zipFileName + "\"");
            FileInputStream inputStream = new FileInputStream(zipFile);
            out = response.getOutputStream();

            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            out.write(buffer);
            inputStream.close();
            out.close();
            out.flush();
            zipFile.delete();

        } catch (IOException e) {
            if (null != out) {
                out.close();
                out.flush();
            }
			throw new RuntimeException(e);
        }
        return null;
    }
    
    /**
     * 通过webservice获取从dicm文件解析来的图片数据（base64字符串）
     * @param patientExamId
     * @return
     * @throws Exception
     */
    private String[] getPacsDicomBase64(String patientExamId) {
     // 通过webservice从dbd库中获取base64图片数据
    	String savePath = pacsDetailService.selectSavePath(new Long(patientExamId));
    	if (null == savePath) {
    	    return new String[0];
    	}
        byte[] data = this.pacsService.getFileByte(savePath, Contstants.DICM_BASE64_KEY + patientExamId);
        String base64 = new String(data);
        return base64.split(Contstants.STRING_SEPARATOR);
    }
    
    /**
     * 通过webservice获取病人检查图片数据（base64字符串）
     * @param patientExamId
     * @return
     * @throws Exception
     */
    private String[] getPatientImageBase64(String patientExamId) {
        PatientExam patientExam = this.patientExamService.selectAObject(PatientExam.class, new Long(patientExamId));
        
        PatientImageQueryInfo PatientImageQueryInfo = new PatientImageQueryInfo();
        PatientImageQueryInfo.setHospitalNo(patientExam.getHospitalNo());
        PatientImageQueryInfo.setHtFsPacsMark(patientExam.getHtFsPacsMark());
        PatientImageQueryInfo.setPatientExamNum(patientExam.getPatientExamNum());
        List<PatientImage> patientImageList = this.patientImageService.selectPatientImages(PatientImageQueryInfo);
        if (patientImageList.isEmpty())  {
            return null; 
        }
         
        int index = 0;
        byte[] dicomByteArray = null;
        String[] base64Array = new String[patientImageList.size()];
        
        for (PatientImage patientImage : patientImageList) {
            // 通过bdbkey获取二进制文件
            dicomByteArray = this.pacsService.getFileByte(patientImage.getSavePath(), patientImage.getBdbKey());
            if (dicomByteArray.length <= 0) {
                continue;
            } 
            // 二进制转成base64
            base64Array[index] = Base64Utils.byteToBase64(dicomByteArray);
            index++;
        }
        return base64Array;
        
    }

}
