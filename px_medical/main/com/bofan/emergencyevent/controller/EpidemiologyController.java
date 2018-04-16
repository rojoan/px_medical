package com.bofan.emergencyevent.controller;

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
import com.bofan.emergencyevent.command.EmHealthCheckEditInfo;
import com.bofan.emergencyevent.command.EpidemiologyEditInfo;
import com.bofan.emergencyevent.command.EpidemiologyQueryInfo;
import com.bofan.emergencyevent.service.EpidemiologyService;
import com.bofan.emergencyevent.valueobject.EmHealthCheck;
import com.bofan.emergencyevent.valueobject.Epidemiology;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.manage.service.ManageService;

/**
 * @Description: 流行病学记录
 * @author lqw
 */
@Controller
@RequestMapping("/epidemiology")
public class EpidemiologyController  extends AbstractAnnotationController{
	/** logger */
    protected static Logger logger = Logger.getLogger(EpidemiologyController.class.getName());
	@Autowired
	private EpidemiologyService epidemiologyService;
	@Autowired
	private ManageService manageService; 
	
    
    /**
     * 进入流行病学记录列表页面
     * @return
     */
    @RequestMapping("/list.do")
    public String list() {
        return "emergencyevent/epidemiologyList";
    }
    
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
     * 获取分页列表数据
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/listData.do")
    @ResponseBody
    public  Map<String, Object> listData(HttpServletRequest request,EpidemiologyQueryInfo info) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	Page page = this.epidemiologyService.selectEpidemiologyList(info);
    	result.put("rows", page.getData());
    	result.put("total", page.getTotalSize());
        return result;
    }
   
    /**
     * 进入新增| 编辑 页面
     * @param request
     * @param epidemiologyId
     * @param model
     * @return
     */
    @RequestMapping("/edit.do")
    public String edit(HttpServletRequest request,Long epidemiologyId, Model model) {
    	Epidemiology epidemiology = null;
    	//填报单位--(所在医院) 及 填报人(医院医生)
    	if (null != epidemiologyId) {
    		//进入编辑修改
    		epidemiology = this.epidemiologyService.selectAObject(Epidemiology.class,epidemiologyId);
		} else {
			//进入新增
			epidemiology = new Epidemiology();
			SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
			SysOrg sysOrg = this.manageService.loadSysOrg(getCurrentSysUserUnitOrgId(request));
			epidemiology.setFillOrgId(sysOrg.getUnitOrgId());
			epidemiology.setFillOrgName(sysOrg.getName());
			epidemiology.setFillOrgPhone(sysOrg.getDirectorTel());
			epidemiology.setFillDoctorId(userInfo.getUserInfoId());
			epidemiology.setFillDoctorName(userInfo.getName());
		}
    	model.addAttribute("epidemiology",epidemiology);
        return "emergencyevent/epidemiologyEdit";
    }
    
    /**
     * 保存流行病学记录
     * @param info
     * @return
     */
    @RequestMapping(value = "/saveEpidemiology.do")
    @ResponseBody 
    public JsonObj saveEpidemiology(EpidemiologyEditInfo info) {
    	JsonObj result = new JsonObj();
    	result.setData(this.epidemiologyService.saveEpidemiology(info));
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 进入审核页面
     * @param request
     * @param healthCheckId
     * @param healthReportId
     * @param model
     * @return
     */
    @RequestMapping("/audit.do")
    public String audit(HttpServletRequest request, Long epidemiologyId, Model model) {
    	EmHealthCheck emHealthCheck = this.epidemiologyService.selectHealthCheckByEpidemiologyId(epidemiologyId);
    	
    	if (null != emHealthCheck) {
    		model.addAttribute("emHealthCheck",emHealthCheck);
		} else {
			SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
			SysOrg sysOrg = this.manageService.loadSysOrg(userInfo.getSysOrg().getUnitOrgId());
			emHealthCheck = new EmHealthCheck();
			emHealthCheck.setEpidemiologyId(epidemiologyId);; // 流行病学记录ID
			emHealthCheck.setCheckerId(userInfo.getUserId());//审核人Id
			emHealthCheck.setCheckerName(userInfo.getName());//审核人
			emHealthCheck.setCheckOrgId(userInfo.getSysOrg().getUnitOrgId()); // 审核单位Id
			emHealthCheck.setCheckOrgName(sysOrg.getName()); //审核单位
			model.addAttribute("emHealthCheck",emHealthCheck);
		}
    	Epidemiology epidemiology = this.epidemiologyService.selectAObject(Epidemiology.class,epidemiologyId);
		model.addAttribute("epidemiology",epidemiology);
    	return "emergencyevent/epidemiologyAudit";
    }
    

    /**
     * 进入 查看 页面
     * @param request
     * @param epidemiologyId
     * @param model
     * @return
     */
    @RequestMapping("/show.do")
    public String show(HttpServletRequest request,Long epidemiologyId, Model model) {
		//进入编辑修改
    	Epidemiology epidemiology = this.epidemiologyService.selectAObject(Epidemiology.class,epidemiologyId);
		model.addAttribute("epidemiology",epidemiology);
		model.addAttribute("fillOrg", this.manageService.loadSysOrg(epidemiology.getFillOrgId()));
		model.addAttribute("sysUserInfo", this.manageService.loadSysUserInfo(epidemiology.getFillDoctorId()));
		
		EmHealthCheck emHealthCheck = this.epidemiologyService.selectHealthCheckByEpidemiologyId(epidemiologyId);
		model.addAttribute("emHealthCheck",emHealthCheck);
    	return "emergencyevent/epidemiologyShow";
    }
    
    /**
     * 保存流行病学记录 审核内容
     * @param info
     * @return
     */
    @RequestMapping(value = "/saveEmHealthCheck.do")
    @ResponseBody 
    public JsonObj saveEmHealthCheck(EmHealthCheckEditInfo info) {
    	JsonObj result = new JsonObj();
    	result.setData(this.epidemiologyService.saveEmHealthCheck(info));
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
    	return result;
    }
    
   /**
    * 删除流行病学记录
    * @param epidemiologyId
    * @return
    */
    @RequestMapping(value = "/delEpidemiology.do")
    @ResponseBody 
    public JsonObj delEpidemiology(Long epidemiologyId) {
    	JsonObj result = new JsonObj();
    	Epidemiology emHealthReport = this.epidemiologyService.selectAObject(Epidemiology.class,epidemiologyId);
    	this.epidemiologyService.deleteAObject(emHealthReport);
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
    	return result;
    }
    
}
