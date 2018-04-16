package com.bofan.publichealth.elder.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.controller.AbstractAnnotationController;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.command.HealthTcmedicineQueryInfo;
import com.bofan.publichealth.elder.command.ElderHealthAssessItemQueryInfo;
import com.bofan.publichealth.elder.command.ElderHealthAssessQueryInfo;
import com.bofan.publichealth.elder.command.ElderHealthTcmedicineQueryInfo;
import com.bofan.publichealth.elder.command.ElderSelfCareAbilityQueryInfo;
import com.bofan.publichealth.elder.command.SelfCareAbilityQueryInfo;
import com.bofan.publichealth.elder.service.ElderHealthAssessService;
import com.bofan.publichealth.elder.service.ElderHealthTcmedicineService;
import com.bofan.publichealth.elder.service.ElderSelfCareAbilityService;
import com.bofan.publichealth.elder.service.HealthAssessItemService;
import com.bofan.publichealth.elder.service.HealthAssessTypeService;
import com.bofan.publichealth.elder.valueobject.ElderHealthAssess;
import com.bofan.publichealth.elder.valueobject.ElderHealthTcmedicine;
import com.bofan.publichealth.elder.valueobject.ElderSelfCareAbility;
import com.bofan.publichealth.service.PersonDetailService;
import com.bofan.publichealth.valueobject.PersonDetail;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.manage.service.ManageService;

/**
 * @Description: 老人 Controller
 * @author lqw
 */
@Controller
@RequestMapping("/elder")
public class ElderController  extends AbstractAnnotationController{
	/** logger */
    protected static Logger logger = Logger.getLogger(ElderController.class.getName());
	@Autowired
	private PersonDetailService personDetailService;
	@Autowired
	private ElderHealthAssessService elderHealthAssessService;
	@Autowired
	private ManageService manageService;
	@Autowired
	private HealthAssessTypeService healthAssessTypeService;
	@Autowired
	private HealthAssessItemService healthAssessItemService;
	@Autowired
	private ElderHealthTcmedicineService elderHealthTcmedicineService;
	@Autowired
	private ElderSelfCareAbilityService elderSelfCareAbilityService;
 
	
	
    /**
     * 进入老人列表页面
     * @return
     */
    @RequestMapping("/elderList.do")
    public String list() {
        return "publichealth/elder/elderList";
    }
    
    /**
     * 进入一般健康评估老人列表页面
     * @return
     */
    @RequestMapping("/elderHealthAssessList.do")
    public String elderHealthAssessList() {
        return "publichealth/elder/elderHealthAssessList";
    }
    
    @RequestMapping("/elderHealthAssessDetail.do")
    public String elderHealthAssessDetail(Long personDetailId, Model model) {
        PersonDetail  personDetail = this.personDetailService.selectAObject(PersonDetail.class,personDetailId);
        
        List<ElderHealthAssess> elderHealthAssessList =  
                this.elderHealthAssessService.selectElderHealthAssessList(new ElderHealthAssessQueryInfo(personDetailId));
        model.addAttribute("elderHealthAssessList",elderHealthAssessList); //一般健康评估列表
        model.addAttribute("personDetail",personDetail);
        return "publichealth/elder/elderHealthAssessDetail";
    }
   
    /**
     * 进入自理能力评估老人列表页面
     * @return
     */
    @RequestMapping("/elderSelfCareAbilityList.do")
    public String elderSelfCareAbilityList() {
        return "publichealth/elder/elderSelfCareAbilityList";
    }
    
    /**
     * 进入 自理能力评估 的操作页面
     * @param personDetailId
     * @param model
     * @return
     */
    @RequestMapping("/elderSelfCareAbilityDetail.do")
    public String elderSelfCareAbilityDetail(Long personDetailId, Model model) {
        PersonDetail  personDetail = this.personDetailService.selectAObject(PersonDetail.class,personDetailId);
        
        List<ElderSelfCareAbility> elderSelfCareAbilityList =  
                this.elderSelfCareAbilityService.selectElderSelfCareAbilityList(new ElderSelfCareAbilityQueryInfo(personDetailId));
        model.addAttribute("elderSelfCareAbilityList",elderSelfCareAbilityList); //一般健康评估列表
        model.addAttribute("personDetail",personDetail);
        return "publichealth/elder/elderSelfCareAbilityDetail";
    }
    
    /**
     * 进入自理能力评估老人列表页面
     * @return
     */
    @RequestMapping("/elderHealthTcmedicineList.do")
    public String elderHealthTcmedicineList() {
        return "publichealth/elder/elderHealthTcmedicineList";
    }
    
    @RequestMapping("/elderHealthTcmedicineDetail.do")
    public String elderHealthTcmedicineDetail(Long personDetailId, Model model) {
        PersonDetail  personDetail = this.personDetailService.selectAObject(PersonDetail.class,personDetailId);
        
        List<ElderHealthTcmedicine> elderHealthTcmedicineList =  
                this.elderHealthTcmedicineService.selectElderHealthTcmedicineList(new ElderHealthTcmedicineQueryInfo(personDetailId));
        model.addAttribute("elderHealthTcmedicineList",elderHealthTcmedicineList); //一般健康评估列表
        model.addAttribute("personDetail",personDetail);
        return "publichealth/elder/elderHealthTcmedicineDetail";
    }
    
    /**
     *  进入 老年人健康评估结果 页面
     * @param request
     * @param personDetailId
     * @param elderHealthAssessId
     * @param mode
     * @param model
     * @return
     */
    @RequestMapping("/editElderHealthAssess.do") 
    public String editElderHealthAssess(HttpServletRequest request,Long personDetailId, Long elderHealthAssessId,String mode, Model model) {
        PersonDetail  personDetail = this.personDetailService.selectAObject(PersonDetail.class,personDetailId);
        ElderHealthAssess elderHealthAssess = null;
        
        if (null != elderHealthAssessId ) {
            elderHealthAssess = this.elderHealthAssessService.selectAObject(ElderHealthAssess.class,elderHealthAssessId);
            model.addAttribute("healthAssessItemIdMap", this.elderHealthAssessService.selectHealthAssessItemIdMap(
                    new ElderHealthAssessItemQueryInfo(elderHealthAssessId))); //根据条件查询 HealthAssessItem 的Map集合
        } else {
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY); 
            Long currenUserUnitOrgId = userInfo.getSysOrg().getUnitOrgId();
            SysOrg sysOrg = this.manageService.loadSysOrg(currenUserUnitOrgId);
            elderHealthAssess = new ElderHealthAssess();
            elderHealthAssess.setHospitalId(currenUserUnitOrgId);
            elderHealthAssess.setHospitalName(sysOrg.getName());
            elderHealthAssess.setHospitalNo(sysOrg.getOrgNo());
            elderHealthAssess.setAssessDoctorId(userInfo.getUserInfoId());
            elderHealthAssess.setAssessDoctorName(userInfo.getName());
            elderHealthAssess.setRegionId(personDetail.getRegionId());
            elderHealthAssess.setPersonDetailId(personDetailId);
        }
        model.addAttribute("healthAssessItemHealthNoGroupMap",healthAssessItemService.selectHealthAssessItemItemHealthNoGroupMap());
        model.addAttribute("healthAssessItemHealthYesGroupMap",healthAssessItemService.selectHealthAssessItemHealthYesGroupMap());
        model.addAttribute("healthSecondAssessTypeMap",healthAssessTypeService.selectSecondLevelHealthAssessTypeMap());
        model.addAttribute("healthAssessTypeMap",healthAssessTypeService.selectFirstLevelHealthAssessTypeMap());
        model.addAttribute("mode",mode); //查看/编辑
        model.addAttribute("elderHealthAssess",elderHealthAssess); //孕产妇初次孕检记录
        model.addAttribute("personDetail",personDetail); //孕产妇登记卡
        return "publichealth/elder/elderHealthAssessEdit";
    }
    
    /**
     * 保存 老年人健康评估结果
     * @param elderHealthAssessRetionData
     * @return
     */
    @RequestMapping(value = "/saveElderHealthAssess.jo")
    @ResponseBody 
    public JsonObj saveElderHealthAssess(String elderHealthAssessRetionData) { 
        JsonObj result = new JsonObj();
        this.elderHealthAssessService.saveElderHealthAssess(elderHealthAssessRetionData);
        return result;
    }
    
    /**
     * 删除 老年人健康评估
     * @param elderHealthAssessId
     * @return
     */
    @RequestMapping(value = "/delElderHealthAssess.jo")
    @ResponseBody 
    public JsonObj delElderHealthAssess(Long elderHealthAssessId) { 
        JsonObj result = new JsonObj();
        this.elderHealthAssessService.delElderHealthAssess(elderHealthAssessId);
        return result;
    }
    
    /**
     * 编辑 老年人自理能力评估
     * @param request
     * @param personDetailId
     * @param elderSelfCareAbilityId
     * @param mode
     * @param model
     * @return
     */
    @RequestMapping("/editElderSelfCareAbility.do") 
    public String editElderSelfCareAbility(HttpServletRequest request,Long personDetailId, Long elderSelfCareAbilityId,String mode, Model model) {
        PersonDetail  personDetail = this.personDetailService.selectAObject(PersonDetail.class,personDetailId);
        ElderSelfCareAbility elderSelfCareAbility = null;
        
        if (null != elderSelfCareAbilityId ) {
            elderSelfCareAbility = this.elderSelfCareAbilityService.selectAObject(ElderSelfCareAbility.class,elderSelfCareAbilityId);
            model.addAttribute("elderSelfCareItemMap",elderSelfCareAbilityService.selectElderSelfCareItemMap(elderSelfCareAbilityId));
        } else {
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY); 
            Long currenUserUnitOrgId = userInfo.getSysOrg().getUnitOrgId();
            SysOrg sysOrg = this.manageService.loadSysOrg(currenUserUnitOrgId);
            elderSelfCareAbility = new ElderSelfCareAbility();
            elderSelfCareAbility.setHospitalId(currenUserUnitOrgId);
            elderSelfCareAbility.setHospitalName(sysOrg.getName());
            elderSelfCareAbility.setHospitalNo(sysOrg.getOrgNo());
            elderSelfCareAbility.setAssessDoctorId(userInfo.getUserInfoId());
            elderSelfCareAbility.setAssessDoctorName(userInfo.getName());
            elderSelfCareAbility.setRegionId(personDetail.getRegionId());
            elderSelfCareAbility.setPersonDetailId(personDetailId);
        }
 
        model.addAttribute("mode",mode); //查看/编辑
        model.addAttribute("selfCareAbilityList",this.elderSelfCareAbilityService.selectSelfCareAbilityList(new SelfCareAbilityQueryInfo(Contstants.YES_FLAG)));  
        model.addAttribute("elderSelfCareAbility",elderSelfCareAbility); //孕产妇初次孕检记录
        model.addAttribute("personDetail",personDetail); //孕产妇登记卡
        return "publichealth/elder/elderSelfCareAbilityEdit";
    }
    
    /**
     * 保存  老年人自理能力评估
     * @param elderSelfCareAbilityRetionData
     * @return
     */
    @RequestMapping(value = "/saveElderSelfCareAbility.jo")
    @ResponseBody 
    public JsonObj saveElderSelfCareAbility(String elderSelfCareAbilityRetionData) { 
        JsonObj result = new JsonObj();
        this.elderSelfCareAbilityService.saveElderSelfCareAbility(elderSelfCareAbilityRetionData);
        return result;
    }
    
    /**
     * 删除 老年人自理能力评估 相关表
     * @param elderSelfCareAbilityId
     * @return
     */
    @RequestMapping(value = "/delElderSelfCareAbility.jo")
    @ResponseBody 
    public JsonObj delElderSelfCareAbility(Long elderSelfCareAbilityId) { 
        JsonObj result = new JsonObj();
        this.elderSelfCareAbilityService.delElderSelfCareAbility(elderSelfCareAbilityId);
        return result;
    }
    
    /**
     * 进入  老年人中医药评估 编辑页面
     * @param request
     * @param personDetailId
     * @param elderHealthTcmedicineId
     * @param mode
     * @param model
     * @return
     */
    @RequestMapping("/editElderHealthTcmedicine.do") 
    public String editElderHealthTcmedicine(HttpServletRequest request,Long personDetailId, Long elderHealthTcmedicineId,String mode, Model model) {
        PersonDetail  personDetail = this.personDetailService.selectAObject(PersonDetail.class,personDetailId);
        ElderHealthTcmedicine elderHealthTcmedicine = null;
        
        if (null != elderHealthTcmedicineId ) {
            elderHealthTcmedicine = this.elderHealthTcmedicineService.selectAObject(ElderHealthTcmedicine.class,elderHealthTcmedicineId);
            model.addAttribute("elderHealthTcmItemMap",this.elderHealthTcmedicineService.selectElderHealthTcmItemMap(elderHealthTcmedicineId));
            model.addAttribute("elderHealthTcmResult",this.elderHealthTcmedicineService.scoreResult(elderHealthTcmedicineId));
        } else {
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY); 
            Long currenUserUnitOrgId = userInfo.getSysOrg().getUnitOrgId();
            SysOrg sysOrg = this.manageService.loadSysOrg(currenUserUnitOrgId);
            elderHealthTcmedicine = new ElderHealthTcmedicine();
            elderHealthTcmedicine.setHospitalId(currenUserUnitOrgId);
            elderHealthTcmedicine.setHospitalName(sysOrg.getName());
            elderHealthTcmedicine.setHospitalNo(sysOrg.getOrgNo());
            elderHealthTcmedicine.setAssessDoctorId(userInfo.getUserInfoId());
            elderHealthTcmedicine.setAssessDoctorName(userInfo.getName());
            elderHealthTcmedicine.setRegionId(personDetail.getRegionId());
            elderHealthTcmedicine.setPersonDetailId(personDetailId);
            model.addAttribute("elderHealthTcmResult",this.elderHealthTcmedicineService.initElderHealthTcmResult());
        }
        
        model.addAttribute("healthTcmedicineList",
                this.elderHealthTcmedicineService.selectHealthTcmedicineList(new HealthTcmedicineQueryInfo(Contstants.YES_FLAG))); 
        model.addAttribute("mode",mode); //查看/编辑
        model.addAttribute("elderHealthTcmedicine",elderHealthTcmedicine); //孕产妇初次孕检记录
        model.addAttribute("personDetail",personDetail); //孕产妇登记卡
        return "publichealth/elder/elderHealthTcmedicineEdit";
    }
    
    /**
     * 保存 老年人中医药评估
     * @param elderHealthTcmedicineRetionData
     * @return
     */
    @RequestMapping(value = "/saveElderHealthTcmedicine.jo")
    @ResponseBody 
    public JsonObj saveElderHealthTcmedicine(String elderHealthTcmedicineRetionData) { 
        return  this.elderHealthTcmedicineService.saveElderHealthTcmedicine(elderHealthTcmedicineRetionData);
    }
    
    /**
     * 删除  老年人中医药评估 
     * @param elderHealthTcmedicineId
     * @return
     */
    @RequestMapping(value = "/delElderHealthTcmedicine.jo")
    @ResponseBody 
    public JsonObj delElderHealthTcmedicine(Long elderHealthTcmedicineId) { 
        JsonObj result = new JsonObj();
        this.elderHealthTcmedicineService.delElderHealthTcmedicine(elderHealthTcmedicineId);
        return result;
    }
    
 }
