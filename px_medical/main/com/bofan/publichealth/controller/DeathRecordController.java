package com.bofan.publichealth.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
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
import com.bofan.basesystem.common.controller.AbstractAnnotationController;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.command.DeathRecordEditInfo;
import com.bofan.publichealth.command.DeathRecordQueryInfo;
import com.bofan.publichealth.service.DeathRecordService;
import com.bofan.publichealth.valueobject.DeathRecord;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.Tools;
import com.manage.service.ManageService;

/**
 * @Description: 死亡登记Controller
 * @author lqw
 */
@Controller
@RequestMapping("/deathRecord")
public class DeathRecordController  extends AbstractAnnotationController{
	/** logger */
    protected static Logger logger = Logger.getLogger(DeathRecordController.class.getName());
	@Autowired
	private DeathRecordService deathRecordService;
	@Autowired
	private ManageService manageService;
 
    
    /**
     * 进入死亡登记列表页面
     * @return
     */
    @RequestMapping("/deathRecordList.do")
    public String list(String deathFlag, Model model) {
        model.addAttribute("deathFlag", deathFlag);
        return "publichealth/deathRecordList";
    }
    
    /**
     * 获取分页列表数据
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/deathRecordListData.jo")
    @ResponseBody
    public  Map<String, Object> deathRecordListData(HttpServletRequest request,DeathRecordQueryInfo queryInfo) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	queryInfo.setValidFlag(Contstants.YES_FLAG);
    	Page page = this.deathRecordService.selectDeathRecordList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
   
  //传文件,将文件读取为二进制流进行传递,“请求内容”则为二进制流
    public static  byte[] getFileByteData(String filePath) throws IOException{
        
     FileInputStream inputStream = new FileInputStream(filePath);    
     ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1024);  
        System.out.println("bytes available: " + inputStream.available());  
  
        byte[] b = new byte[1024];        
        int size = 0;  
          
        while((size = inputStream.read(b)) != -1)   
            outputStream.write(b, 0, size);   
          
         inputStream.close();   
        byte[] bytes = outputStream.toByteArray();  
        outputStream.close();
 
        return bytes;  
    }
    
    
    
    /**
     * 进入新增| 编辑 页面
     * @param request
     * @param deathRecordId
     * @param model
     * @return
     * @throws IOException 
     */
    @RequestMapping("/editDeathRecord.do")
    public String editDeathRecord(HttpServletRequest request,Long deathRecordId,String deathFlag,String mode, Model model) throws IOException {
        if (Tools.isEmptyString(deathFlag)) {
            deathFlag =  Contstants.DEATH_FLAG_GRAVIDADETAIL;
        }
        
    	DeathRecord deathRecord = null;
    	if (null != deathRecordId) {
    		//进入编辑修改 
    		deathRecord = this.deathRecordService.selectAObject(DeathRecord.class,deathRecordId);
		} else {
			//进入新增
			SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
			SysOrg unitOrg = this.manageService.loadSysOrg(userInfo.getSysOrg().getUnitOrgId());
			deathRecord = new DeathRecord();
			deathRecord.setCreatorId(userInfo.getUserInfoId());
			deathRecord.setCreatorName(userInfo.getName());
			deathRecord.setHospitalId(unitOrg.getOrgId());
			deathRecord.setHospitalNo(unitOrg.getOrgNo());
			deathRecord.setHospitalName(unitOrg.getName());
			deathRecord.setDeathFlag(deathFlag);
			 
		}
    	model.addAttribute("deathRecord",deathRecord);
    	model.addAttribute("mode",mode);
        return "publichealth/deathRecordEdit";
    }
    
    /**
     * 保存死亡登记
     * @param deathRecordEditInfo
     * @return
     */
    @RequestMapping(value = "/saveDeathRecord.jo")
    @ResponseBody 
    public JsonObj saveDeathRecord(DeathRecordEditInfo deathRecordEditInfo) { 
    	JsonObj result = new JsonObj();
    	this.deathRecordService.saveDeathRecord(deathRecordEditInfo);
        return result;
    }
    
   /**
    * 删除死亡登记
    * @param deathRecordId
    * @return
    */
    @RequestMapping(value = "/delDeathRecord.jo")
    @ResponseBody 
    public JsonObj delDeathRecord(Long deathRecordId) {
    	JsonObj result = new JsonObj();
		DeathRecord DeathRecord = this.deathRecordService.selectAObject(DeathRecord.class, deathRecordId);
		DeathRecord.setValidFlag(Contstants.NO_FLAG);
		this.deathRecordService.saveAObject(DeathRecord);
    	return result;
    }
    
}
