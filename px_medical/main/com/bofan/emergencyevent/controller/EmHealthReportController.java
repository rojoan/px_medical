package com.bofan.emergencyevent.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.bofan.emergencyevent.command.EmHealthReportOtherInfo;
import com.bofan.emergencyevent.command.EmHealthReportQueryInfo;
import com.bofan.emergencyevent.command.EmReportEventAreaQueryInfo;
import com.bofan.emergencyevent.command.EmReportEventSourceQueryInfo;
import com.bofan.emergencyevent.command.EmReportSymptomQueryInfo;
import com.bofan.emergencyevent.service.EmHealthReportService;
import com.bofan.emergencyevent.valueobject.EmHealthCheck;
import com.bofan.emergencyevent.valueobject.EmHealthReport;
import com.bofan.emergencyevent.valueobject.EmReportEventArea;
import com.bofan.emergencyevent.valueobject.EmReportEventSource;
import com.bofan.emergencyevent.valueobject.EmReportSymptom;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.service.RegionService;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.manage.service.ManageService;

/**
 * @Description: 突发公卫报告登记
 * @author lqw
 */ 
@Controller
@RequestMapping("/emHealthReport")
public class EmHealthReportController  extends AbstractAnnotationController{
	/** logger */
    protected static Logger logger = Logger.getLogger(EmHealthReportController.class.getName());
	@Autowired
	private EmHealthReportService emHealthReportService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private ManageService manageService;
    /**
     * 进入突发公卫报告登记列表页面
     * @return
     */
    @RequestMapping("/list.do")
    public String list() {
        return "emergencyevent/emHealthReportList";
    }
    
    /**
     * 获取分页列表数据
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/listData.do")
    @ResponseBody
    public  Map<String, Object> applyTurnDownAuditListData(HttpServletRequest request,EmHealthReportQueryInfo info) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	Page page = this.emHealthReportService.selectEmHealthReportList(info);
    	result.put("rows", page.getData());
    	result.put("total", page.getTotalSize());
        return result;
    }
   
    /**
     * 获取街道CityPicker的json数据
     * @return
     */
    @RequestMapping("/regionCityPicker.do")
    @ResponseBody
    public Map<String,Object> regionCityPicker(){
    	return this.regionService.regionCityPicker();
    }
    
    /**
     * 进入新增| 编辑 页面
     * @param request
     * @param healthReportId
     * @param model
     * @return
     */
    @RequestMapping("/edit.do")
    public String edit(HttpServletRequest request,Long healthReportId, Model model) {
    	//填报单位--(所在医院) 及 填报人(医院医生)
    	if (null != healthReportId) {
    		//进入编辑修改
    		EmHealthReport emHealthReport = this.emHealthReportService.selectAObject(EmHealthReport.class,healthReportId);
    		model.addAttribute("emHealthReport",emHealthReport);
			
    		//回显关联的事件发生场所 、事件信息来源、事件信息来源
    		List<EmReportEventArea> reportAreaList = this.emHealthReportService.selectEmReportEventArea(new EmReportEventAreaQueryInfo(emHealthReport.getHealthReportId()));
    		List<EmReportEventSource> reportSourceList = this.emHealthReportService.selectEmReportEventSource(new EmReportEventSourceQueryInfo(emHealthReport.getHealthReportId()));
    		List<EmReportSymptom> reportSymptomList = this.emHealthReportService.selectEmReportSymptom(new EmReportSymptomQueryInfo(emHealthReport.getHealthReportId()));
    		addHealthReportRelatedToModel(model, reportAreaList,reportSourceList, reportSymptomList);
    		
    		//报告地区 - 发生地区 回显名称
    		String  occurRegionAddress = this.regionService.parseRegionAdress(emHealthReport.getOccurRegionId());
    		String  reportRegionAddress = this.regionService.parseRegionAdress(emHealthReport.getReportRegionId());
    		model.addAttribute("occurRegionAddress",occurRegionAddress);
    		model.addAttribute("reportRegionAddress",reportRegionAddress);
		} else {
			//进入新增
			EmHealthReport emHealthReport = new EmHealthReport();
			SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
			SysOrg sysOrg = this.manageService.loadSysOrg(userInfo.getSysOrg().getUnitOrgId());
			emHealthReport.setFillOrgId(sysOrg.getUnitOrgId());
			emHealthReport.setFillOrgName(sysOrg.getName());;
			emHealthReport.setFillManId(userInfo.getUserInfoId());
			emHealthReport.setFillManName(userInfo.getName());
			model.addAttribute("emHealthReport",emHealthReport);
		}
    	
        return "emergencyevent/emHealthReportEdit";
    }

	/**将HealthReport对照表的id集合添加到Model中
	 * @param model
	 * @param reportAreaList
	 * @param reportSourceList
	 * @param reportSymptomList
	 */
	private void addHealthReportRelatedToModel(Model model, List<EmReportEventArea> reportAreaList,
			List<EmReportEventSource> reportSourceList, List<EmReportSymptom> reportSymptomList) {
		//事件发生场所ID集合
		if (null != reportAreaList && reportAreaList.size() > 0) {
			List<String> reportAreaIdsList = new ArrayList<String>();
			for (EmReportEventArea emReportArea : reportAreaList) {
				reportAreaIdsList.add(emReportArea.getEventAreaId());
			}
			model.addAttribute("areaIdsList",reportAreaIdsList);
		} 
		//事件信息来源ID
		if (null != reportSourceList && reportSourceList.size() > 0) {
			List<Long> reportSourceIdsList = new ArrayList<Long>();
			for (EmReportEventSource emReportSource : reportSourceList) {
				reportSourceIdsList.add(emReportSource.getEventSourceId());
			}
			model.addAttribute("sourceIdsList",reportSourceIdsList);
		}
		//主要症状ID集合
		if (null != reportSymptomList && reportSymptomList.size() > 0) {
			List<Long> reportSymptomIdsList = new ArrayList<Long>();
			for (EmReportSymptom emReportSymptom : reportSymptomList) {
				reportSymptomIdsList.add(emReportSymptom.getCheifSymptomId());
			}
			model.addAttribute("symptomIdsList",reportSymptomIdsList);
		}
	}
    
    /**
     * 进入 查看 页面
     * @param request
     * @param healthReportId
     * @param model
     * @return
     */
	@RequestMapping("/show.do")
    public String show(HttpServletRequest request,Long healthReportId, Model model) {
		EmHealthReport emHealthReport = this.emHealthReportService.selectAObject(EmHealthReport.class,healthReportId);
		//审核内容
		EmHealthCheck emHealthCheck = this.emHealthReportService.selectHealthCheckByReportId(healthReportId);
		
		//回显关联的事件发生场所 、事件信息来源、事件信息来源
		List<EmReportEventArea> reportAreaList = this.emHealthReportService.selectEmReportEventArea(new EmReportEventAreaQueryInfo(emHealthReport.getHealthReportId()));
		List<EmReportEventSource> reportSourceList = this.emHealthReportService.selectEmReportEventSource(new EmReportEventSourceQueryInfo(emHealthReport.getHealthReportId()));
		List<EmReportSymptom> reportSymptomList = this.emHealthReportService.selectEmReportSymptom(new EmReportSymptomQueryInfo(emHealthReport.getHealthReportId()));
		
		addHealthReportRelatedToModel(model, reportAreaList, reportSourceList, reportSymptomList);
		//报告地区 - 发生地区 回显名称
		String  occurRegionAddress = this.regionService.parseRegionAdress(emHealthReport.getOccurRegionId());
		String  reportRegionAddress = this.regionService.parseRegionAdress(emHealthReport.getReportRegionId());
		
		model.addAttribute("emHealthReport",emHealthReport);
		model.addAttribute("occurRegionAddress",occurRegionAddress);
		model.addAttribute("reportRegionAddress",reportRegionAddress);
		model.addAttribute("emHealthCheck",emHealthCheck);
    	return "emergencyevent/emHealthReportShow";
    }

    /**
     * 保存突发公卫报告
     * @param info
     * @return
     */
    @RequestMapping(value = "/saveEmHealthReport.do")
    @ResponseBody 
    public JsonObj saveEmHealthReport(EmHealthReportOtherInfo info) {
    	JsonObj result = new JsonObj();
    	result.setData(this.emHealthReportService.saveEmHealthReport(info));
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 保存突发公卫报告的审核内容
     * @param info
     * @return
     */
    @RequestMapping(value = "/saveEmHealthCheck.do")
    @ResponseBody 
    public JsonObj saveEmHealthCheck(EmHealthCheckEditInfo info) {
    	JsonObj result = new JsonObj();
    	result.setData(this.emHealthReportService.saveEmHealthCheck(info));
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
    public String audit(HttpServletRequest request, Long healthReportId, Model model) {
    	EmHealthCheck emHealthCheck = this.emHealthReportService.selectHealthCheckByReportId(healthReportId);
    	
    	if (null != emHealthCheck) {
    		model.addAttribute("emHealthCheck",emHealthCheck);
		} else {
			SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
			SysOrg sysOrg = this.manageService.loadSysOrg(userInfo.getSysOrg().getUnitOrgId());
			emHealthCheck = new EmHealthCheck();
			emHealthCheck.setHealthReportId(healthReportId); //审核的报告Id
			emHealthCheck.setCheckerId(userInfo.getUserInfoId());//审核人Id
			emHealthCheck.setCheckerName(userInfo.getName());//审核人
			emHealthCheck.setCheckOrgId(userInfo.getSysOrg().getUnitOrgId()); // 审核单位Id
			emHealthCheck.setCheckOrgName(sysOrg.getName()); //审核单位
			model.addAttribute("emHealthCheck",emHealthCheck);
		}
    	EmHealthReport emHealthReport = this.emHealthReportService.selectAObject(EmHealthReport.class,healthReportId);
    	//回显关联的事件发生场所 、事件信息来源、事件信息来源
		List<EmReportEventArea> reportAreaList = this.emHealthReportService.selectEmReportEventArea(new EmReportEventAreaQueryInfo(emHealthReport.getHealthReportId()));
		List<EmReportEventSource> reportSourceList = this.emHealthReportService.selectEmReportEventSource(new EmReportEventSourceQueryInfo(emHealthReport.getHealthReportId()));
		List<EmReportSymptom> reportSymptomList = this.emHealthReportService.selectEmReportSymptom(new EmReportSymptomQueryInfo(emHealthReport.getHealthReportId()));
		addHealthReportRelatedToModel(model, reportAreaList, reportSourceList, reportSymptomList);
		//报告地区 - 发生地区 回显名称
		model.addAttribute("reportRegionAddress",this.regionService.parseRegionAdress(emHealthReport.getReportRegionId()));
		model.addAttribute("occurRegionAddress",this.regionService.parseRegionAdress(emHealthReport.getOccurRegionId()));
		model.addAttribute("emHealthReport",emHealthReport);
    	return "emergencyevent/emHealthReportAudit";
    }
    
   /**
    * 删除突发公卫报告
    * @param healthReportId
    * @return
    */
    @RequestMapping(value = "/delemHealthReport.do")
    @ResponseBody 
    public JsonObj delemHealthReport(Long healthReportId) {
		JsonObj result = new JsonObj();
		result = this.emHealthReportService.delemHealthReport(healthReportId);
		return result;
    }
    
}
