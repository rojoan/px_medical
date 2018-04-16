package com.bofan.gradingclinics.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.dictionary.support.DictionarysInVelocityToolbox;
import com.bofan.gradingclinics.command.HdDiagnosisApplyEditInfo;
import com.bofan.gradingclinics.command.HdDiagnosisApplyQueryInfo;
import com.bofan.gradingclinics.service.HdDiagnosisApplyService;
import com.bofan.gradingclinics.valueobject.HdDiagnosisApply;
import com.bofan.his.command.PatientHospitalQueryInfo;
import com.bofan.his.service.OutpatientInhospitalService;
import com.bofan.his.service.PatientAffixItemService;
import com.bofan.his.service.PatientHospitalService;
import com.bofan.his.service.PatientService;
import com.bofan.his.valueobject.OutpatientInhospital;
import com.bofan.his.valueobject.Patient;
import com.bofan.his.valueobject.PatientAffixItem;
import com.bofan.his.valueobject.PatientHospital;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.pacs.command.PatientExamQueryInfo;
import com.bofan.pacs.command.PatientImageQueryInfo;
import com.bofan.pacs.service.PatientExamService;
import com.bofan.pacs.service.PatientImageService;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.pacs.valueobject.PatientImage;
import com.bofan.pacs.webservice.IPacsService;
import com.bofan.utils.Contstants;
import com.bofan.utils.DateHelper;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;
import com.manage.service.ManageService;

import sun.misc.BASE64Encoder;

@Controller
@RequestMapping("/gradingclinics")
public class HdDiagnosisApplyController {
	/** logger */
    protected static Logger logger = Logger.getLogger(HdDiagnosisApplyController.class.getName());
	
	@Autowired
	protected HdDiagnosisApplyService hdDiagnosisApplyService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private PatientHospitalService patientHospitalService;
	@Autowired
	private ManageService manageService;
	@Autowired
	private PatientExamService patientExamService;
	@Autowired
	private OutpatientInhospitalService outInhospitalService;
	@Autowired
	private PatientAffixItemService patientAffixItemService;
	@Autowired
    private PatientImageService patientImageService; 
    @Autowired
    private IPacsService pacsService; 
	
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
     * 转出记录列表数据
     * @param info
     * @return
     */
    @RequestMapping("/applyTurnOutListData.do")
    @ResponseBody
    public  Map<String, Object> applyTurnOutListData(HttpServletRequest request,HdDiagnosisApplyQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        info.setInstitutionDownId(this.getCurrentSysUserUnitOrgId(request));//转出医院Id为当前用户对应的医院ID
        Page page = this.hdDiagnosisApplyService.selectHdDiagnosisApply(info); 
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 转入记录列表数据
     * @param info
     * @return
     */
    @RequestMapping("/applyTurnInListData.do")
    @ResponseBody
    public  Map<String, Object> applyTurnInListData(HttpServletRequest request,HdDiagnosisApplyQueryInfo info) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	info.setInstitutionUpId(this.getCurrentSysUserUnitOrgId(request));// 转入医院的ID，根据当前登录用户的医院ID设置
    	Page page = this.hdDiagnosisApplyService.selectHdDiagnosisApply(info); 
    	result.put("rows", page.getData());
    	result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 获取上转审核列表数据
     * @param info
     * @return
     */
    @RequestMapping("/applyTurnUpAuditListData.do")
    @ResponseBody
    public  Map<String, Object> applyTurnUpAuditListData(HttpServletRequest request,HdDiagnosisApplyQueryInfo info) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	info.setInstitutionUpId(this.getCurrentSysUserUnitOrgId(request));// 转入医院的ID，根据当前登录用户的医院ID设置
    	info.setHdType(Contstants.DIAGNOSISAPPLY_HDTYPE_UP);
    	info.setTransStatus(Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_APPLYED);//已申请待审核状态
    	Page page = this.hdDiagnosisApplyService.selectHdDiagnosisApply(info); 
    	result.put("rows", page.getData());
    	result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 进入上转审核列表页面
     * @return
     */
    @RequestMapping("/applyTurnUpAuditList.do")
    public String applyTurnUpAuditList(HttpServletRequest request, Model model) {
    	SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
    	model.addAttribute("currentDoctorId",userInfo.getUserInfoId());
    	model.addAttribute("currentUnitOrgId",this.getCurrentSysUserUnitOrgId(request));
    	return "gradingclinics/applyTurnUpAuditList";
    }
    
    /**
     * 获取下转审核列表数据
     * @param info
     * @return
     */
    @RequestMapping("/applyTurnDownAuditListData.do")
    public @ResponseBody Map<String, Object> applyTurnDownAuditListData(HttpServletRequest request,HdDiagnosisApplyQueryInfo info) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	info.setInstitutionUpId(this.getCurrentSysUserUnitOrgId(request));// 转入医院的ID，根据当前登录用户的医院ID设置
    	info.setHdType(Contstants.DIAGNOSISAPPLY_HDTYPE_DOWN);
    	info.setTransStatus(Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_APPLYED);//已申请待审核状态
    	Page page = this.hdDiagnosisApplyService.selectHdDiagnosisApply(info); 
    	result.put("rows", page.getData());
    	result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 进入下转审核列表页面
     * @return
     */
    @RequestMapping("/applyTurnDownAuditList.do")
    public String applyTurnDownAuditList(HttpServletRequest request, Model model) {
    	SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
    	model.addAttribute("currentDoctorId",userInfo.getUserInfoId());
    	model.addAttribute("currentUnitOrgId",this.getCurrentSysUserUnitOrgId(request));
    	return "gradingclinics/applyTurnDownAuditList";
    }
    
    /**
     * 进入转入记录列表页面
     * @return
     */
    @RequestMapping("/applyTurnInList.do")
    public String applyTurnInList(HttpServletRequest request, Model model) {
    	Long unitOrgId =  this.getCurrentSysUserUnitOrgId(request);
    	List<SysOrg> unitList = this.manageService.selectUnit(null, true);
    	model.addAttribute("hospitalMap",changUnitListToMapExclude(unitList,unitOrgId));
        return "gradingclinics/applyTurnInList";
    }
    
    /**
     * 转诊单信息信息-包括患者信息
     * @param hdDiagnosisApplyId
     * @return
     */
    @RequestMapping("/applyDeatail.do")
    @ResponseBody
    public JsonObj  applyDeatail(Long hdDiagnosisApplyId){
    	//查询转诊信息和病人信息
    	HdDiagnosisApply hdDiagnosisApply = this.hdDiagnosisApplyService.selectAObject(HdDiagnosisApply.class, hdDiagnosisApplyId);
    	Patient patient = this.patientService.selectAObject(Patient.class, hdDiagnosisApply.getPatientId());
    	Map<String,Object>  data = new HashMap<String,Object>();
    	data.put("patient", patient);
    	data.put("hdDiagnosisApply", hdDiagnosisApply);
    	JsonObj result = new JsonObj();
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
    	result.setData(data);
		return result;
    }
    
    /**
     * 对转诊进行审核
     * @return
     */
    @RequestMapping("/applyAudit.do")
    @ResponseBody
    public JsonObj applyAudit(Long hdDiagnosisApplyId,String auditStatus,
    		Long checkDoctorId,String checkDoctorName,String checkOpinion) {
    	return this.hdDiagnosisApplyService.updateAudit(
    			hdDiagnosisApplyId, auditStatus, checkDoctorId, checkDoctorName, checkOpinion);
         
    }

    /**
     * 进入接诊页面
     * @param request
     * @param model
     * @return
     */
	@RequestMapping("/toReceiveTreatment.do") 
	public String toReceiveTreatment(Long hdDiagnosisApplyId, Model model) {
		HdDiagnosisApply  hdDiagnosisApply = this.hdDiagnosisApplyService.selectAObject(HdDiagnosisApply.class,hdDiagnosisApplyId);
		model.addAttribute("hdDiagnosisApply",hdDiagnosisApply);
		return "gradingclinics/receiveTreatment";
	}
	
	/**
	 * 接诊
	 * @param hdDiagnosisApplyId
	 * @param clinicalOfficeId
	 * @param clinicalOfficeName
	 * @param clinicalDoctorId
	 * @param clinicalDoctorName
	 * @return
	 */
	@RequestMapping("/receiveTreatment.do")
	@ResponseBody
	public JsonObj receiveTreatment(Long hdDiagnosisApplyId, Long clinicalOfficeId,String clinicalOfficeName, Long clinicalDoctorId, String clinicalDoctorName) {
		return this.hdDiagnosisApplyService.receiveTreatment(hdDiagnosisApplyId,clinicalOfficeId, clinicalOfficeName, clinicalDoctorId, clinicalDoctorName);

	}
	
	@RequestMapping("/hadTreatmented.do")
	@ResponseBody
	public JsonObj hadTreatmented(Long hdDiagnosisApplyId) {
		JsonObj result = new JsonObj();
		HdDiagnosisApply  hdDiagnosisApply = this.hdDiagnosisApplyService.selectAObject(HdDiagnosisApply.class,hdDiagnosisApplyId);
    	hdDiagnosisApply.setTransStatus(Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_HAD_TREAT);
    	this.hdDiagnosisApplyService.saveAObject(hdDiagnosisApply);
    	return result;
		
	}
    
    /**
     * 进入转出记录列表页面
     * @return
     */
    @RequestMapping("/applyTurnOutList.do")
    public String applyTurnOutList(HttpServletRequest request, Model model) {
    	Long unitOrgId =  this.getCurrentSysUserUnitOrgId(request);
    	List<SysOrg> unitList = this.manageService.selectUnit(null, true);
    	model.addAttribute("hospitalMap",changUnitListToMapExclude(unitList,unitOrgId));
    	return "gradingclinics/applyTurnOutList";
    }
    
    /**
     * 进入转出查看页面
     * @return
     */
    @RequestMapping("/applyTurnOutShow.do")
    public String applyTurnOutShow(Long hdDiagnosisApplyId, Model model) {
    	//查询转诊信息和病人信息
    	HdDiagnosisApply hdDiagnosisApply = this.hdDiagnosisApplyService.selectAObject(HdDiagnosisApply.class,hdDiagnosisApplyId);
    	Patient patient = this.patientService.selectAObject(Patient.class, hdDiagnosisApply.getPatientId());
    	OutpatientInhospital outpatientInhospital  = this.hdDiagnosisApplyService.selectOutpatientInhospital(hdDiagnosisApply.getPatientType(), hdDiagnosisApply.getInpatientId());
    	List<PatientAffixItem>  patientAffixItemList = this.patientAffixItemService.selectPatientAffixItem(outpatientInhospital.getAffixId());
    	
    	model.addAttribute("hdDiagnosisApply",hdDiagnosisApply);
    	model.addAttribute("patient",patient);
    	model.addAttribute("patientAffixItemList",patientAffixItemList);
    	return "gradingclinics/applyTurnOutShow";
    }
    
    /**
     * 进入转入记录查看页面
     * @return
     */
    @RequestMapping("/applyTurnInShow.do")
    public String applyTurnInShow(Long hdDiagnosisApplyId, Model model) {
    	//查询转诊信息和病人信息
    	HdDiagnosisApply hdDiagnosisApply = this.hdDiagnosisApplyService.selectAObject(HdDiagnosisApply.class,hdDiagnosisApplyId);
    	Patient patient = this.patientService.selectAObject(Patient.class, hdDiagnosisApply.getPatientId());
    	OutpatientInhospital outpatientInhospital  = this.hdDiagnosisApplyService.selectOutpatientInhospital(hdDiagnosisApply.getPatientType(), hdDiagnosisApply.getInpatientId());
    	List<PatientAffixItem>  patientAffixItemList = this.patientAffixItemService.selectPatientAffixItem(outpatientInhospital.getAffixId());
    	
    	model.addAttribute("hdDiagnosisApply",hdDiagnosisApply);
    	model.addAttribute("patient",patient);
    	model.addAttribute("patientAffixItemList",patientAffixItemList);
    	return "gradingclinics/applyTurnInShow";
    }
    
    /**
     * 进入查看、编辑转出记录页面
     * @return
     */
    @RequestMapping("/applyTurnOutEdit.do")
    public String applyTurnOutEdit(HttpServletRequest request,Long hdDiagnosisApplyId, Model model) {
    	Long currenUserUnitOrgId = this.getCurrentSysUserUnitOrgId(request);
    	//查询转诊信息和病人信息
    	HdDiagnosisApply hdDiagnosisApply = this.hdDiagnosisApplyService.selectAObject(HdDiagnosisApply.class,hdDiagnosisApplyId);
    	Patient patient = hdDiagnosisApply.getPatient();
    	
    	model.addAttribute("institutionDownUnit",this.manageService.loadSysOrg(currenUserUnitOrgId));
    	//申请单 、 患者 信息
    	model.addAttribute("hdDiagnosisApply",hdDiagnosisApply);
    	model.addAttribute("patient",patient);
    	
    	//转出医院信息
    	model.addAttribute("institutionDownId",currenUserUnitOrgId);//转成医院的id
    	model.addAttribute("offficeDownList", this.manageService.selectDapartment(currenUserUnitOrgId, true));//转出医院科室列表
    	model.addAttribute("doctorDownList",this.queryUserByOrgId(hdDiagnosisApply.getOffficeDownId()));//查询转出科室下的医生
    	//转入医院信息
    	model.addAttribute("hospitalMap", this.changUnitListToMapExclude(this.manageService.selectUnit(null, true),currenUserUnitOrgId)); //转入医院列表
    	model.addAttribute("offficeUpList", this.manageService.selectDapartment(hdDiagnosisApply.getInstitutionUpId(), true));//转入医院科室列表
    	model.addAttribute("doctorUpList",this.queryUserByOrgId(hdDiagnosisApply.getOfficeUpId()));//查询转入科室下的医生 
    	
    	return "gradingclinics/applyTurnOutEdit";
    }
    
    /**
     * 进入上转申请添加页面
     * @return
     */
    @RequestMapping("/applyTurnUpAdd.do")
    public String applyTurnUpAdd(HttpServletRequest request, Model model) {
    	SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
    	Long currenUserUnitOrgId = this.getCurrentSysUserUnitOrgId(request);
    	model.addAttribute("institutionDownUnit",this.manageService.loadSysOrg(currenUserUnitOrgId));
        model.addAttribute("doctorList",  this.manageService.selectDepartmentStaffByUnitId(currenUserUnitOrgId, true));
        model.addAttribute("hospitalMap", this.getTurnUpUnitIdName(currenUserUnitOrgId)); //转入医院列表
        model.addAttribute("currentDoctorId",userInfo.getUserInfoId());
        model.addAttribute("currentDeptId",userInfo.getOrgId());
        model.addAttribute("doctorPhone",userInfo.getPhone());
        model.addAttribute("validStartTime",new Date());
        
        return "gradingclinics/applyTurnUpAdd";
    }
    
    /**
     * 将医院list转出Map ，排除不需要的医院
     * @param unitList
     * @param unitOrgId 排除不需要的医院的Id
     * @return
     */
    public Map<Object,Object> changUnitListToMapExclude(List<SysOrg> unitList,Long unitOrgId){
    	Map<Object,Object> unitMap = new HashMap<Object,Object>();
    	if (Tools.isNotEmptyList(unitList)) {
			for (SysOrg sysOrg : unitList) {
				if (unitOrgId.longValue() == sysOrg.getOrgId().longValue()) {
					continue;
				}
				unitMap.put(sysOrg.getOrgId(),sysOrg.getName() );
			}
		}
    	return unitMap;
    }
    
    /**
     * 获取上转单位列表，不包含最低级单位，并排除指定单位
     * @param unitOrgId
     * @return
     */
    @SuppressWarnings("rawtypes")
	public Map getTurnUpUnitIdName(Long unitOrgId){
    	Map unitMap = (Map) DictionarysInVelocityToolbox.getDictionary("dicSysOrgUpUnitIdName");
    	if (unitMap.containsKey(unitOrgId+"")) {
    		unitMap.remove(unitOrgId+"");
		}
    	return unitMap;
    }
    
    /**
     * 获取下转单位列表，不包含最低级单位，并排除指定单位
     * @param unitOrgId
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Map getTurnDownUnitIdName(Long unitOrgId){
    	Map unitMap = (Map) DictionarysInVelocityToolbox.getDictionary("dicSysOrgDownUnitIdName");
    	if (unitMap.containsKey(unitOrgId+"")) {
    		unitMap.remove(unitOrgId+"");
    	}
    	return unitMap;
    }
    
    
    
    
    /**
     * 进入下转申请添加页面
     * @return
     */
    @RequestMapping("/applyTurnDownAdd.do")
    public String applyTurnDownAdd(HttpServletRequest request,String patientName,String patientIdCard, Model model) { 
    	SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
    	Long currenUserUnitOrgId = this.getCurrentSysUserUnitOrgId(request);
    	model.addAttribute("institutionDownUnit",this.manageService.loadSysOrg(currenUserUnitOrgId));
        model.addAttribute("doctorList",  this.manageService.selectDepartmentStaffByUnitId(currenUserUnitOrgId, true));
        model.addAttribute("hospitalMap", this.getTurnDownUnitIdName(currenUserUnitOrgId)); //转入医院列表
        model.addAttribute("patientName",patientName);
        model.addAttribute("patientIdCard",patientIdCard);
        model.addAttribute("currentDoctorId",userInfo.getUserInfoId());
        model.addAttribute("currentDeptId",userInfo.getOrgId());
        model.addAttribute("doctorPhone",userInfo.getPhone());
    	return "gradingclinics/applyTurnDownAdd";
    }
    
    
    /**
     * 保存双向转诊申请单信息
     * @param info
     * @return
     */
    @RequestMapping(value = "/saveDiagnosisApply.do")
    @ResponseBody 
    public JsonObj saveDiagnosisApply(HdDiagnosisApplyEditInfo info) {
    	JsonObj result = new JsonObj();
    	result.setData(this.hdDiagnosisApplyService.saveHdDiagnosisApply(info));
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 转诊(转出)申请单打印
     * @param info
     * @return
     */
    @RequestMapping(value = "/applyTurnOutReceiptPrint.do")
    public String reportPrint(Long hdDiagnosisApplyId, String hdType, Model model) {
    	if (Contstants.DIAGNOSISAPPLY_HDTYPE_UP.equals(hdType)) {
    		model.addAttribute("grfPathUrl","../report/gradingclinics/turnUp.grf"); 
		} else {
			model.addAttribute("grfPathUrl","../report/gradingclinics/turnDown.grf"); 
		}
    	model.addAttribute("printDataUrl","../gradingclinics/turnOutPrintData.do?hdDiagnosisApplyId="+hdDiagnosisApplyId);
    	return "gradingclinics/reportPrint";
    }
    
    /**
     * 获取转诊单打印的数据
     * @param hdDiagnosisApplyId
     * @return
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/turnOutPrintData.do")
    @ResponseBody 
    public Map<String,Object> turnOutPrintData(Long hdDiagnosisApplyId) {
    	//查询转诊单信息 和 患者信息
    	HdDiagnosisApply hdDiagnosisApply = this.hdDiagnosisApplyService.selectAObject(HdDiagnosisApply.class,hdDiagnosisApplyId);
    	Patient patient = hdDiagnosisApply.getPatient();
    	//数据字典
        Map dicSexMap = (Map) DictionarysInVelocityToolbox.getDictionary("dicSex");
        Map dicTransAimMap = (Map) DictionarysInVelocityToolbox.getDictionary("dicTransAim");
        
    	//将数据设置指定格式的json
    	Map<String,Object> data = new HashMap<String,Object>();
    	data.put("patientName", patient.getPatientName());// 患者姓名
    	data.put("patientSex", dicSexMap.get(patient.getPatientSex()));// 性别
    	data.put("patientAge", patient.getAge() > 0 ? patient.getAge()+"":"");// 年龄
    	data.put("patientPhone", patient.getPatientPhone());// 联系电话
    	data.put("homeadd", patient.getHomeAddr());// 家庭住址
    	data.put("idcard", patient.getPatientIdCard());// 身份证号
    	data.put("contactname", patient.getContactName());// 家属姓名
    	data.put("contactphone", patient.getContactPhone());// 联系电话
    	data.put("institutionUpName", hdDiagnosisApply.getInstitutionUpName());// 转往医疗机构
    	data.put("institutionDownName", hdDiagnosisApply.getInstitutionDownName());// 转出医疗机构
    	data.put("transReason", hdDiagnosisApply.getTransReason());// 转诊原因
    	data.put("institutionPhoneDow", hdDiagnosisApply.getInstitutionPhoneDow());// 转出医院联系电话
    	data.put("doctorDownName", hdDiagnosisApply.getDoctorDownName());// 转出医生签名 
    	data.put("doctorMobileDown", hdDiagnosisApply.getDoctorMobileDown());// 转出医生联系电话
    	data.put("transAim", dicTransAimMap.get(hdDiagnosisApply.getTransAim()));// 转诊目的
    	data.put("applyTime", hdDiagnosisApply.getApplyTime() != null ? 
    			DateHelper.getDateFormatStr(hdDiagnosisApply.getApplyTime(),"yyyy 年 MM 月 dd 日") : "");// 转诊申请日期
    	
    	if (Contstants.DIAGNOSISAPPLY_HDTYPE_UP.equals(hdDiagnosisApply.getHdType())) {
    		data.put("officeUpName", "门诊住院外科方式科");// 转往医疗机构 科室
    		data.put("firstDiagnosisUp", hdDiagnosisApply.getFirstDiagnosisUp());// 初步诊断
    		data.put("validStartTime", hdDiagnosisApply.getValidStartTime() != null ? 
    				DateHelper.getDateFormatStr(hdDiagnosisApply.getValidStartTime(),"yyyy 年 MM 月 dd 日") : "");// 转诊时限(有效期)开始日期
        	data.put("validEndTime", hdDiagnosisApply.getValidEndTime() != null ? 
        			DateHelper.getDateFormatStr(hdDiagnosisApply.getValidEndTime(),"yyyy 年 MM 月 dd 日") : "");// 转诊时限(有效期)结束日期
        	
		} else {
			data.put("diagnosisDown", hdDiagnosisApply.getDiagnosisDown());// 病情诊断
			data.put("diagnosisResultDown", hdDiagnosisApply.getDiagnosisResultDown());// 转诊检查结果（下转）
			data.put("diagnosisCureDown", hdDiagnosisApply.getDiagnosisCureDown());// 转诊治疗经过（下转）
			data.put("recoverySuggestDown", hdDiagnosisApply.getRecoverySuggestDown());// 转诊康复建议（下转） 
		}
    	//返回json数据
    	Map<String,Object> reportData = new HashMap<String,Object>();
    	List<Object> list = new ArrayList<Object>();
    	list.add(data);
    	reportData.put("reportData", list);
        return reportData;
    }
    
    /**
     * 接诊回执单打印
     * @param info
     * @return
     */
    @RequestMapping(value = "/backReceiptPrint.do")
    public String backReceiptPrint(Long hdDiagnosisApplyId, String hdType, Model model) {
    	if (Contstants.DIAGNOSISAPPLY_HDTYPE_UP.equals(hdType)) {
    		model.addAttribute("grfPathUrl","../report/gradingclinics/upBackReceipt.grf"); 
    	} else {
    		model.addAttribute("grfPathUrl","../report/gradingclinics/downBackReceipt.grf"); 
    	}
    	model.addAttribute("printDataUrl","../gradingclinics/backReceiptPrintData.do?hdDiagnosisApplyId="+hdDiagnosisApplyId);
    	return "gradingclinics/reportPrint";
    }
    
    @RequestMapping(value = "/diagnosisReportPrintPage.do")
    public String diagnosisReportPrint(Long hdDiagnosisApplyId,Model model) {
        model.addAttribute("grfPathUrl","../report/gradingclinics/diagnosisReport.grf"); 
        model.addAttribute("printDataUrl","../gradingclinics/diagnosisReportPrintData.jo?hdDiagnosisApplyId="+hdDiagnosisApplyId);
        return "gradingclinics/reportPrint";
    }
    
    @RequestMapping("/diagnosisReportPrintData.jo")
    @ResponseBody
    @SuppressWarnings("rawtypes")
    public Map<String,Object> diagnosisReportPrint(Long hdDiagnosisApplyId) {
      //查询转诊单信息 和 患者信息
        HdDiagnosisApply hdDiagnosisApply = this.hdDiagnosisApplyService.selectAObject(HdDiagnosisApply.class,hdDiagnosisApplyId);
        Patient patient = hdDiagnosisApply.getPatient();
        
        PatientExamQueryInfo patientExamQueryInfo = new PatientExamQueryInfo();
        patientExamQueryInfo.setPatientType(new Long(hdDiagnosisApply.getPatientType()));
        patientExamQueryInfo.setInpatientId(new Long(hdDiagnosisApply.getInpatientId()));
        patientExamQueryInfo.setOrgId(hdDiagnosisApply.getOrgId());
        patientExamQueryInfo.setPatientId(hdDiagnosisApply.getPatientId());
        PatientExam patientExam = this.patientExamService.findPatientExam(patientExamQueryInfo);
        
        //数据字典
        Map dicSexMap = (Map) DictionarysInVelocityToolbox.getDictionary("dicSex");
        Map patientTypeMap = (Map) DictionarysInVelocityToolbox.getDictionary("dicOutInhosPatientType");
        
        //将数据设置指定格式的json
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("patientName", patient.getPatientName());// 患者姓名
        data.put("patientSex", dicSexMap.get(patient.getPatientSex()));// 性别
        data.put("patientAge", patient.getAge() > 0 ? patient.getAge()+"":"");// 年龄
        data.put("patientType", patientTypeMap.get(hdDiagnosisApply.getPatientType()));
        data.put("inpatientId", hdDiagnosisApply.getInpatientId());//门诊/住院号
        data.put("institutionUpName", hdDiagnosisApply.getInstitutionUpName());// 转入医院机构-医院名称
        data.put("officeUpName", hdDiagnosisApply.getOfficeUpName());// 转入科室 -科室
        data.put("doctorUpName", hdDiagnosisApply.getDoctorUpName());// 转入医生-报告医生
        data.put("examFindings",hdDiagnosisApply.getExamFinding());
        data.put("examHint", hdDiagnosisApply.getExamHint()); 
        data.put("diagnosticOpinion", hdDiagnosisApply.getDiagnosticOpinion()); 
        data.put("diagnosisTime", hdDiagnosisApply.getDiagnosisTime() != null ? 
                DateHelper.getDateFormatStr(hdDiagnosisApply.getDiagnosisTime(), "yyyy-MM-dd") : ""); 
        data.put("patientExamNum", patientExam != null ? patientExam.getPatientExamNum() : ""); 
        data.put("bedNum", patientExam != null ? patientExam.getBedNum() : ""); 
        data.put("examPart", patientExam != null ? patientExam.getExamPart() : ""); 
        data.put("examDate", (patientExam != null && patientExam.getExamDate() != null )? 
                DateHelper.getDateFormatStr(patientExam.getExamDate(), "yyyy-MM-dd") : ""); 
        
        //返回json数据
        Map<String,Object> reportData = new HashMap<String,Object>();
        List<Object> list = new ArrayList<Object>();
        list.add(data);
        reportData.put("reportData", list);
        return reportData;
    }
    
    /**
     * 获取接诊回执打印的数据
     * @param hdDiagnosisApplyId
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/backReceiptPrintData.do")
    @ResponseBody 
    public Map<String,Object> backReceiptPrintData(Long hdDiagnosisApplyId) {
    	//查询转诊单信息 和 患者信息
    	HdDiagnosisApply hdDiagnosisApply = this.hdDiagnosisApplyService.selectAObject(HdDiagnosisApply.class,hdDiagnosisApplyId);
    	Patient patient = hdDiagnosisApply.getPatient();
    	
    	//数据字典
    	Map dicSexMap = (Map) DictionarysInVelocityToolbox.getDictionary("dicSex");
    	Map dicTransAimMap = (Map) DictionarysInVelocityToolbox.getDictionary("dicTransAim");
    	
    	//将数据设置指定格式的json
    	Map<String,Object> data = new HashMap<String,Object>();
    	data.put("patientName", patient.getPatientName());// 患者姓名
    	data.put("patientSex", dicSexMap.get(patient.getPatientSex()));// 性别
    	data.put("patientAge", patient.getAge() > 0 ? patient.getAge()+"":"");// 年龄
    	data.put("patientPhone", patient.getPatientPhone());// 联系电话
    	data.put("homeadd", patient.getHomeAddr());// 家庭住址
    	data.put("doctorDownName", hdDiagnosisApply.getDoctorDownName());// 转出(经治)医生签名 
    	data.put("doctorMobileDown", hdDiagnosisApply.getDoctorMobileDown());// 转出(经治)医生联系电话
    	data.put("institutionUpName", hdDiagnosisApply.getInstitutionUpName());// 转入医疗机构
    	data.put("institutionDownName", hdDiagnosisApply.getInstitutionDownName());// 转出医院机构
    	data.put("applyTime", hdDiagnosisApply.getApplyTime() != null ? DateHelper.getDateFormatStr(hdDiagnosisApply.getApplyTime(),"yyyy 年 MM 月 dd 日") : "");// 转诊申请日期
    	data.put("clinicalDoctorName", hdDiagnosisApply.getClinicalDoctorName());// 接诊医生
    	
    	if (Contstants.DIAGNOSISAPPLY_HDTYPE_UP.equals(hdDiagnosisApply.getHdType())) {
        	data.put("firstDiagnosisUp", hdDiagnosisApply.getFirstDiagnosisUp());// 初步诊断
        	data.put("transAim", dicTransAimMap.get(hdDiagnosisApply.getTransAim()));// 转诊目的
        	data.put("firstImpressUp", dicTransAimMap.get(hdDiagnosisApply.getTransAim()));// 初步印象
        	data.put("mainSickUp", dicTransAimMap.get(hdDiagnosisApply.getTransAim()));// 主要现病史（上转） 上转单
        	data.put("historySickUp", dicTransAimMap.get(hdDiagnosisApply.getTransAim()));// 主要既往史（上转）
        	data.put("cureUp", dicTransAimMap.get(hdDiagnosisApply.getTransAim()));// 治疗经过
    	} else {
    		data.put("diagnosisDown", hdDiagnosisApply.getDiagnosisDown());// 病情诊断-诊断结果
    		data.put("diagnosisResultDown", hdDiagnosisApply.getDiagnosisResultDown());// 转诊检查结果（下转）
    		data.put("diagnosisCureDown", hdDiagnosisApply.getDiagnosisCureDown());// 转诊治疗经过（下转）
    		data.put("recoverySuggestDown", hdDiagnosisApply.getRecoverySuggestDown());// 转诊康复建议（下转） 
    	}
    	
    	//返回json数据
    	Map<String,Object> reportData = new HashMap<String,Object>();
    	List<Object> list = new ArrayList<Object>();
    	list.add(data);
    	reportData.put("reportData", list);
    	return reportData;
    }
    
    /**
     * 根据科室id 查询出 医生列表
     * @param orgId
     * @return
     */
    public List<Map<String, Object>> queryUserByOrgId(Long orgId) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        List<SysUserInfo> userInfoList = new ArrayList<SysUserInfo>();
     
        if (null == orgId) {
			return result;
		}
        userInfoList = this.manageService.selectDepartmentStaffByOrgId(orgId, true);
        Map<String, Object> userMap = null;
        for (SysUserInfo userInfo : userInfoList) {
            userMap = new HashMap<String, Object>();
            userMap.put("name", userInfo.getName());
            userMap.put("userInfoId", userInfo.getUserInfoId());
            result.add(userMap);
        }
        return result;
    }
    
    /**
     * 跳转到接诊列表页
     * @param info
     * @return
     */
    @RequestMapping("/transferReceivePage.do")
    public String transferAuditPage(HttpServletRequest request,HdDiagnosisApplyQueryInfo info, Model model) {
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        model.addAttribute("hospitalList", this.manageService.selectUnitFilter(userInfo.getSysOrg().getUnitOrgId(), true));
        return "gradingclinics/transferReceivePage";
    }
    
    /**
     * 跳转到填写诊断报告列表页
     * @param info
     * @return
     */
    @RequestMapping("/transferReportPage.do")
    public String transferReportPage(HttpServletRequest request,HdDiagnosisApplyQueryInfo info, Model model) {
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        model.addAttribute("hospitalList", this.manageService.selectUnitFilter(userInfo.getSysOrg().getUnitOrgId(), true));
        return "gradingclinics/transferReportPage";
    }
    
    /**
     * 获取当前单位的转诊列表数据
     * @param info
     * @return
     */
    @RequestMapping("/diagnosisApplyList.do")
    @ResponseBody
    public Map<String, Object> diagnosisApplyList(HttpServletRequest request,HdDiagnosisApplyQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo sysUserInfo = (SysUserInfo)request.getSession().getAttribute(Constants.USER_KEY);
        // 转入医院的ID，根据当前登录用户的医院ID设置
        info.setInstitutionUpId(sysUserInfo.getSysOrg().getUnitOrgId());
        //已申请待审核状态
        //info.setTransStatus(Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_APPLYED);
        Page page = this.hdDiagnosisApplyService.selectHdDiagnosisApply(info); 
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 接诊或拒绝（接收患者）
     * @param info
     * @return
     */
    @RequestMapping("/receivePatient.do")
    @ResponseBody
    public JsonObj receivePatient(HttpServletRequest request, String[] ids, String transStatus) {
        JsonObj result = new JsonObj();
        SysUserInfo sysUserInfo = (SysUserInfo)request.getSession().getAttribute(Constants.USER_KEY);
        this.hdDiagnosisApplyService.saveReceivePatient(ids, sysUserInfo, transStatus);
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        if (Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_WAIT_TREAT.equals(transStatus)) {
            result.setMsg("接诊完成");
        }
        if (Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_REFUSE.equals(transStatus)) {
            result.setMsg("已拒绝");
        }
        return result;
    }
    
    /**
     * 跳转到填写报告页面
     * @param hdDiagnosisApplyId
     * @return
     */
    @RequestMapping("/diagnosisReportEdit.do")
    public String diagnosisReportEdit(Long hdDiagnosisApplyId, Model model) {
        String view = "gradingclinics/diagnosisReportEdit";
        if (null == hdDiagnosisApplyId || hdDiagnosisApplyId.intValue() <= 0) {
            return view;
        }

        PatientExam patientExam = null;
        OutpatientInhospital outpatientInhospital = null;
        // 存放病理、或者内镜、或者超声JPG图片
        List<String> patientExamJpgList = new ArrayList<String>();
        HdDiagnosisApply diagnosisApply = this.hdDiagnosisApplyService.selectAObject(HdDiagnosisApply.class,hdDiagnosisApplyId);
        if (null != diagnosisApply.getPatientId() 
                && !Tools.isEmptyString(diagnosisApply.getPatientType()) 
                && !Tools.isEmptyString(diagnosisApply.getInpatientId())) {
            
            Long patientType = null != diagnosisApply.getPatientType() ? Long.valueOf(diagnosisApply.getPatientType()) : -1L;
            Long inpatientId = null != diagnosisApply.getInpatientId() ? Long.valueOf(diagnosisApply.getInpatientId()) : -1L;
            
            // 门诊住院信息
            outpatientInhospital = outInhospitalService.selectOutpatientInhospital(diagnosisApply.getOrgId(),
                    diagnosisApply.getPatientId(), diagnosisApply.getPatientType(), inpatientId);
            // 病人检查信息
            patientExam = patientExamService.findPatientExam(diagnosisApply.getPatientId(), patientType, inpatientId);

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
            }
        }
        model.addAttribute("patientExam", patientExam);
        model.addAttribute("diagnosisApply", diagnosisApply);
        model.addAttribute("patientExamJpgList", patientExamJpgList);
        model.addAttribute("outpatientInhospital", outpatientInhospital);

        return "gradingclinics/diagnosisReportEdit";
    }
    
    /**
     * 保存诊断报告
     * @param info
     * @return
     */
    @RequestMapping("/saveDiagnosisReport.jo")
    @ResponseBody
    public JsonObj saveDiagnosisReport(Long hdDiagnosisApplyId, String examFinding, String examHint,
            String diagnosticOpinion, String examAdvise, String transStatus) {
        JsonObj result = new JsonObj();
        HdDiagnosisApply diagnosisApply = this.hdDiagnosisApplyService.selectAObject(HdDiagnosisApply.class,hdDiagnosisApplyId);
        if (!Tools.isEmptyString(transStatus)) {
            diagnosisApply.setTransStatus(transStatus);
            diagnosisApply.setDiagnosisTime(new Date());
        }
        
        diagnosisApply.setExamAdvise(examAdvise);
        diagnosisApply.setExamFinding(examFinding);
        diagnosisApply.setExamHint(examHint);
        diagnosisApply.setDiagnosticOpinion(diagnosticOpinion);
        this.hdDiagnosisApplyService.saveAObject(diagnosisApply);
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        result.setMsg("接诊完成");
        return result;
    }

    /**
     * 进入快捷上转申请添加页面
     * @return
     */
    @RequestMapping("/applyUpAdd.do")
    public String applyUpAdd(HttpServletRequest request,Long outpatientInhospitalId, Model model) {
    	SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
    	Long currenUserUnitOrgId = this.getCurrentSysUserUnitOrgId(request);
    	OutpatientInhospital  outInHospital = this.outInhospitalService.selectAObject(OutpatientInhospital.class,outpatientInhospitalId);
    	Patient patient = this.patientService.selectAObject(Patient.class, outInHospital.getPatientId());
    	List<PatientAffixItem>  patientAffixItemList = this.patientAffixItemService.selectPatientAffixItem(outInHospital.getAffixId());
    	
    	model.addAttribute("institutionDownUnit",this.manageService.loadSysOrg(currenUserUnitOrgId));
        model.addAttribute("doctorList",  this.manageService.selectDepartmentStaffByUnitId(currenUserUnitOrgId, true));
        model.addAttribute("hospitalMap", this.getTurnUpUnitIdName(currenUserUnitOrgId)); //转入医院列表
        model.addAttribute("currentDoctorId",userInfo.getUserInfoId());
        model.addAttribute("currentDeptId",userInfo.getOrgId());
        model.addAttribute("doctorPhone",userInfo.getPhone());
        model.addAttribute("validStartTime",new Date());
        model.addAttribute("outInHospital",outInHospital);
        model.addAttribute("patient",patient);
        model.addAttribute("patientAffixItemList",patientAffixItemList);
        
        return "gradingclinics/applyUpAdd";
    }
    
    /**
     * 进入快捷下转申请添加页面
     * @return
     */
    @RequestMapping("/applyDownAdd.do")
    public String applyDownAdd(HttpServletRequest request,Long outpatientInhospitalId, Model model) {
    	SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
    	Long currenUserUnitOrgId = this.getCurrentSysUserUnitOrgId(request);
    	OutpatientInhospital  outInHospital = this.outInhospitalService.selectAObject(OutpatientInhospital.class,outpatientInhospitalId);
    	Patient patient = this.patientService.selectAObject(Patient.class, outInHospital.getPatientId());
    	PatientHospital patientHospital = this.patientHospitalService.findPatientHospital(
    			          new PatientHospitalQueryInfo(outInHospital.getPatientId(), outInHospital.getPatientNo()));
    	List<PatientAffixItem>  patientAffixItemList = this.patientAffixItemService.selectPatientAffixItem(outInHospital.getAffixId());
    	
    	model.addAttribute("institutionDownUnit",this.manageService.loadSysOrg(currenUserUnitOrgId));
    	model.addAttribute("doctorList",  this.manageService.selectDepartmentStaffByUnitId(currenUserUnitOrgId, true));
    	model.addAttribute("hospitalMap", this.getTurnUpUnitIdName(currenUserUnitOrgId)); //转入医院列表
    	
    	model.addAttribute("currentDoctorId",userInfo.getUserInfoId());
    	model.addAttribute("currentDeptId",userInfo.getOrgId());
    	model.addAttribute("doctorPhone",userInfo.getPhone());
    	model.addAttribute("validStartTime",new Date());
    	model.addAttribute("outInHospital",outInHospital);
    	model.addAttribute("patient",patient);
    	model.addAttribute("patientHospital",patientHospital);
    	model.addAttribute("patientAffixItemList",patientAffixItemList);
    	
    	return "gradingclinics/applyDownAdd";
    }
    
    /**
     * 获取病人登记上传的附件列表
     * @param queryInfo
     * @return
     */
    @RequestMapping("/getPatientAffixItem.do")
    public @ResponseBody List<PatientAffixItem> getPatientAffixItem(String affixId) {
        return patientAffixItemService.selectPatientAffixItem(affixId);
    }

}
