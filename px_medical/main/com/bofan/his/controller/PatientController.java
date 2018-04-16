package com.bofan.his.controller;

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
import com.bofan.his.command.PatientEditInfo;
import com.bofan.his.command.PatientHospitalQueryInfo;
import com.bofan.his.service.PatientHospitalService;
import com.bofan.his.service.PatientService;
import com.bofan.his.valueobject.Patient;
import com.bofan.his.valueobject.PatientHospital;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;
import com.manage.service.ManageService;

/**
 * 
 * @Description: 病人信息
 * @author lqw
 * @date 2017-9-30
 * @version V1.0
 */
@Controller
@RequestMapping("/patient")
public class PatientController {
	/** logger */
	protected static Logger logger = Logger.getLogger(PatientController.class.getName());
	@Autowired
	private PatientService patientService;
	@Autowired
	private PatientHospitalService patientHospitalService;
	@Autowired
	private ManageService manageService;

	@RequestMapping("/list.do")
	public String list(HttpServletRequest request) {
		  return "his/patientList";
	}
	
	/**
	 * 查询患者分页列表
	 */
	@RequestMapping("/listData.do")
	@ResponseBody
    public  Map<String, Object> listData(HttpServletRequest request, PatientHospitalQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        info.setOrgId(userInfo.getSysOrg().getUnitOrgId());//查询本院的患者
        Page page = this.patientService.selectPatientPage(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
	
	/**
	 * 匹配出患者信息
	 * 根据 姓名 与 证件号码或 电话号码或 医/农保证号 查询
	 * @param PatientHospitalQueryInfo
	 * @return
	 */
	@RequestMapping("/matchPatient.jo")
	@ResponseBody
	public JsonObj matchPatient(PatientEditInfo patientEditInfo) {
		JsonObj result = new JsonObj();
		if (Tools.isEmptyString(patientEditInfo.getPatientIdCard())
             && Tools.isEmptyString(patientEditInfo.getInsuranceNo()) ) {
			result.setCode(ResponseContstants.RESULT_FAIL_CODE);
			return result;
		}
		PatientHospitalQueryInfo queryInfo = new PatientHospitalQueryInfo();
		queryInfo.setValidFlag(Contstants.YES_FLAG);
		queryInfo.setPatientIdCardEqu(patientEditInfo.getPatientIdCard());
		queryInfo.setInsuranceNoEqu(patientEditInfo.getInsuranceNo());
		PatientHospital  patientHospital = this.patientHospitalService.findPatientHospital(queryInfo);
		if (null != patientHospital) {
			if (!Tools.isEmptyString(patientEditInfo.getPatientIdCard()) && !patientHospital.getPatientName().equals(patientEditInfo.getPatientName())) {
				result.setCode("1");
				result.setMsg("患者姓名与身份证对不上！");
				return result;
			}
			if (!Tools.isEmptyString(patientEditInfo.getInsuranceNo()) && !patientHospital.getPatientName().equals(patientEditInfo.getPatientName())) {
			    result.setCode("1");
			    result.setMsg("患者姓名与患者医/农卡号对不上！");
			    return result;
			}
			
			
			Patient patient = this.patientService.selectAObject(Patient.class, patientHospital.getPatientId());
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("patientHospita", patientHospital);
			data.put("patient", patient);
			result.setData(data);
		} else {
			result.setCode(ResponseContstants.RESULT_FAIL_CODE);
		}
        
        return result;
	}
    
	
	/**
     * 进入新增| 编辑 页面
     * @param request
     * @param patientId
     * @param model
     * @return
     */
    @RequestMapping("/edit.do")
    public String edit(HttpServletRequest request, Long patientHospitalId, Long patientId, String mode, Model model) {
    	Patient patient = null;
    	PatientHospital patientHospital = null;
    	if (null != patientHospitalId) { 
    		//进入编辑修改 
    		patientHospital = this.patientHospitalService.selectAObject(PatientHospital.class, patientHospitalId);
    		patient = this.patientService.selectAObject(Patient.class, patientHospital.getPatientId());
		} else {
			//进入新增
			SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
			SysOrg sysOrg = this.manageService.loadSysOrg(userInfo.getSysOrg().getUnitOrgId());
			patient = new Patient();
			patientHospital = new PatientHospital();
			
			patient.setCreatorId(userInfo.getUserInfoId());
			patient.setOrgId(sysOrg.getUnitOrgId());
			patient.setHospitalNo(sysOrg.getOrgNo());
			patientHospital.setOrgId(sysOrg.getUnitOrgId());
			patientHospital.setHospitalNo(sysOrg.getOrgNo());
		}
    	model.addAttribute("patientHospital",patientHospital);
    	model.addAttribute("patient",patient);
    	if (Contstants.SHOW_PAGE.equals(mode)) {
			return "his/patientShow";
		}
        return "his/patientEdit";
    }
    
    /**
     * 保存患者档案信息
     * @param info
     * @return
     */
    @RequestMapping("/savePatient.do")
    @ResponseBody 
    public JsonObj savePatient(PatientEditInfo editInfo) {
		JsonObj result = new JsonObj();
		Patient patient = null;
		PatientHospital patientHospital = null;
		if (null != editInfo.getPatientId()) {
			patient = this.patientService.selectAObject(Patient.class, editInfo.getPatientId());
			if (null == patient) {
				result.setCode(ResponseContstants.RESULT_FAIL_CODE);
				result.setMsg("系统数据错误！");
				return result;
			}
			if (!editInfo.getPatientName().equals(patient.getPatientName())) { //患者名字对不上
				result.setCode(ResponseContstants.RESULT_FAIL_CODE);
				result.setMsg("患者姓名与系统对不上！");
				return result;
			}
		}
		if (null != editInfo.getPatientHospitalId()) {
		    patientHospital =  this.patientHospitalService.selectAObject(PatientHospital.class, editInfo.getPatientHospitalId());
		}
		//页面输入患者证件号  
		if (!Tools.isEmptyString(editInfo.getPatientIdCard())) {
			PatientHospitalQueryInfo patientHospitalQueryInfo = new PatientHospitalQueryInfo();
			patientHospitalQueryInfo.setOrgId(editInfo.getOrgId());
			patientHospitalQueryInfo.setPatientIdCard(editInfo.getPatientIdCard());
			patientHospitalQueryInfo.setValidFlag(Contstants.YES_FLAG);
			PatientHospital patientByCard = this.patientHospitalService.findPatientHospital(patientHospitalQueryInfo);
			
			if (null != patientByCard && !editInfo.getPatientName().equals(patientByCard.getPatientName())) {
				//此证件号被其他患者使用
				result.setCode(ResponseContstants.RESULT_FAIL_CODE);
				result.setMsg("此患者证件号被其他患者使用！");
				return result;
			}
			if (null != patientHospital && !editInfo.getPatientIdCard().equals(patientHospital.getPatientIdCard())) {
					result.setCode(ResponseContstants.RESULT_FAIL_CODE);
					result.setMsg("患者证件号码与系统对不上！");
					return result;
			}
		}
		//页面输入患者医/农卡号
		if (!Tools.isEmptyString(editInfo.getInsuranceNo())) {
		    PatientHospitalQueryInfo patientHospitalQueryInfo = new PatientHospitalQueryInfo();
            patientHospitalQueryInfo.setOrgId(editInfo.getOrgId());
            patientHospitalQueryInfo.setInsuranceNo(editInfo.getInsuranceNo());
            patientHospitalQueryInfo.setValidFlag(Contstants.YES_FLAG);
		    PatientHospital patientByInsurance = this.patientHospitalService.findPatientHospital(patientHospitalQueryInfo);
		    
			if (null != patientByInsurance && !editInfo.getPatientName().equals(patientByInsurance.getPatientName())) {
				//此医/农卡号被其他患者使用
				result.setCode(ResponseContstants.RESULT_FAIL_CODE);
				result.setMsg("此医/农卡号被其他患者使用！");
				return result;
			}
			if (null != patientHospital && !Tools.isEmptyString(patientHospital.getInsuranceNo())
			        && !editInfo.getInsuranceNo().equals(patientHospital.getInsuranceNo())) {
					result.setCode(ResponseContstants.RESULT_FAIL_CODE);
					result.setMsg("患者医/农卡号与系统对不上！");
					return result;
			}
		}
		//就诊卡不允许为空
		PatientHospital patientHospitalByCard = this.patientHospitalService.findPatientHospital(
				new PatientHospitalQueryInfo(editInfo.getOrgId(), editInfo.getPatientCardNo(), Contstants.YES_FLAG));
		if (null != patientHospitalByCard && !patientHospitalByCard.getPatientName().equals(editInfo.getPatientName())) {
			result.setCode(ResponseContstants.RESULT_FAIL_CODE);
			result.setMsg("此就诊卡已被" + patientHospitalByCard.getPatientName() + "患者使用！");
			return result;
		}
		if (null != patientHospitalByCard && !Tools.isEmptyString(patientHospitalByCard.getPatientCardNo())
				&& !editInfo.getPatientCardNo().equals(patientHospitalByCard.getPatientCardNo())) {
			result.setCode(ResponseContstants.RESULT_FAIL_CODE);
			result.setMsg("患者就诊卡与系统对不上，请将旧就诊卡设置无无效！");
			return result;
		}
    	this.patientService.savePatient(editInfo);
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
    	result.setMsg("保存成功！");
    	return result;
    }
    
	/**
	 * 查询患者信息
	 * @param patientId
	 * @return
	 */
	@RequestMapping("/selectPatient.do")
	@ResponseBody
	public JsonObj selectPatient(Long patientId) {
		JsonObj result = new JsonObj();
        result.setData(this.patientService.selectAObject(Patient.class, patientId));
        return result;
	}
	
	/**
	 * 选择患者公共列表页面
	 * @param request
	 * @param model
	 * @return
	 */
    @RequestMapping("/selectCommonPatientList.do")
    public String selectCommonPatientList(HttpServletRequest request, Model model) {
        return "his/select/selectCommonPatientList";
    }
	   
	/**
	 * 
	 * 查看his病人信息
	 * @param patientId
	 * @return
	 */
	@RequestMapping("/showPatient.do")
	public String showPatient(Long patientId, Model model) {
	    model.addAttribute("patient", this.patientService.selectAObject(Patient.class, patientId));
	    return "his/showPatient";
	}
	
	@RequestMapping("/markPatientInvalid.do")
	@ResponseBody
	public JsonObj markInvalid(Long patientHospitalId) {
		JsonObj result = new JsonObj();
		this.patientService.markInvalid(patientHospitalId);
    	result.setMsg("设置成功！");
    	return result;
	}

}
