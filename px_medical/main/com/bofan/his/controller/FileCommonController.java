package com.bofan.his.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.affix.utils.AffixUtility;
import com.alibaba.fastjson.JSON;
import com.bofan.basesystem.common.controller.AbstractAnnotationController;
import com.bofan.his.service.PatientAffixItemService;
import com.bofan.his.valueobject.PatientAffixItem;
import com.bofan.lis.webservice.ILisService;
import com.bofan.pacs.webservice.IPacsService;
import com.bofan.patient.webservice.IPatientService;
import com.bofan.utils.Contstants;
import com.bofan.utils.DateHelper;
import com.bofan.utils.DicTools;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;

/**
 * 
 * @Description: 附件上传
 * @author lqw
 */
@Controller
public class FileCommonController extends AbstractAnnotationController {

    @Autowired
    protected AffixUtility affixUtility;
    @Autowired
    private PatientAffixItemService patientAffixItemService;
    @Autowired
    private IPacsService pacsService;
    @Autowired
    private ILisService lisService;
    @Autowired
    private IPatientService patientWebService;
    /**
     * 
     * @param filedata
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("common/upload.do")
    @ResponseBody
    public  String upload(@RequestParam("filedata") CommonsMultipartFile filedata,String bdbType) throws UnsupportedEncodingException{
    	JsonObj  result = new JsonObj();
    	Map<String, String> data = new HashMap<String, String>();
    	byte[] fileByteData;
    	if (filedata.isEmpty()) {
         	 result.setCode(ResponseContstants.RESULT_FAIL_CODE);
         	return new String(JSON.toJSONString(result).getBytes("UTF-8"), "ISO-8859-1");
        } 
    	  
        String trueName = filedata.getOriginalFilename();
      	String bdbKey = DateHelper.getDateFormatStr(new Date(),"yyyyMMddHHmmss")  + DicTools.getRondomNum(4);
      	 
		try {
			fileByteData = readInputStreamToByte(filedata.getInputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		 
	    String savePath = saveFileToBdbDabase(bdbType, bdbKey, fileByteData);
	    data.put("saveName", bdbKey); 
        data.put("fileSize", filedata.getSize()+""); 
        data.put("formatSize", Tools.formatSize(filedata.getSize())); 
        data.put("trueName", trueName); 
        data.put("savePath", savePath);
        data.put("bdbKey", bdbKey); 
        data.put("isImage", affixUtility.isImage(trueName) ? Contstants.YES_FLAG : Contstants.NO_FLAG); 
        data.put("pdfFlag", filedata.getName().endsWith(".pdf") ? Contstants.YES_FLAG : Contstants.NO_FLAG);    
	    result.setData(data);
	    return new String(JSON.toJSONString(result).getBytes("UTF-8"), "ISO-8859-1");
    }
    
    private String saveFileToBdbDabase(String bdbType, String bdbKey, byte[] fileByteData){
        String savePath = "";
        if (Contstants.PACS_BDB.equals(bdbType)) {
            savePath = this.pacsService.putByteFile(bdbKey,fileByteData);
        } else if (Contstants.LIS_BDB.equals(bdbType)) {
            savePath = this.lisService.putByteFile(bdbKey,fileByteData);
        } else if (Contstants.PATIENT_BDB.equals(bdbType)) {
            savePath = this.patientWebService.putByteFile(bdbKey,fileByteData);
        }
        return savePath;
    }
    
    /**
     * 下载文件
     * @param request
     * @param response
     * @param affixItemId
     * @throws IOException
     */
    @RequestMapping("pateintAffix/download.do")
    public void download(HttpServletResponse response, Long affixItemId) throws IOException {
    	PatientAffixItem patientAffixItem = this.patientAffixItemService.selectAObject(PatientAffixItem.class,affixItemId);
        OutputStream os = null; 
        try {
            response.setContentType("application/octet-stream");
            String trueName = new String(patientAffixItem.getTrueName().getBytes("UTF-8"), "ISO-8859-1");
            if ( Contstants.YES_FLAG.equals(patientAffixItem.getIsImage()) ) {
                response.setHeader("Content-Disposition", "inline; filename=\"" + trueName + "\"");
            } else {
                response.setHeader("Content-Disposition", "attachment; filename=\"" + trueName + "\"");
            }
            byte[] affixByte = this.patientWebService.getFileByte(patientAffixItem.getSavePath(),patientAffixItem.getBdbKey());
            os = response.getOutputStream();
            response.setContentLength(affixByte.length);
            os.write(affixByte);
           
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.flush();
                } catch (IOException ex) {
                	ex.printStackTrace();
                }
                try {
                    os.close();
                } catch (IOException ex) {
                	ex.printStackTrace();
                }
            }
        }
         
    }
	
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
 
    @RequestMapping("pateintAffix/selectAffixList.do")
	@ResponseBody 
	public JsonObj selectAffixList(String affixId) {
    	JsonObj result = new JsonObj();
    	result.setData(this.patientAffixItemService.selectPatientAffixItem(affixId));
		return result;
	}
    
}
