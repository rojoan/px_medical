package com.bofan.publichealth.controller;

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
import com.bofan.publichealth.command.PersonDetailEditInfo;
import com.bofan.publichealth.command.PersonDetailQueryInfo;
import com.bofan.publichealth.service.FamilyDetailService;
import com.bofan.publichealth.service.PersonDetailService;
import com.bofan.publichealth.service.RegionService;
import com.bofan.publichealth.valueobject.FamilyDetail;
import com.bofan.publichealth.valueobject.PersonDetail;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.manage.service.ManageService;

/**
 * @Description: 个人基本档案Controller
 * @author lqw
 */
@Controller
@RequestMapping("/personDetail")
public class PersonDetailController  extends AbstractAnnotationController{
	/** logger */
    protected static Logger logger = Logger.getLogger(PersonDetailController.class.getName());
	@Autowired
	private PersonDetailService personDetailService;
	@Autowired
	private FamilyDetailService familyDetailService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private ManageService manageService;
    
    /**
     * 进入个人基本档案列表页面
     * @return
     */
    @RequestMapping("/list.do")
    public String list() {
        return "publichealth/personDetail/personDetailList";
    }
    
    @RequestMapping("/personChangeList.do")
    public String personChangeList() {
    	return "publichealth/personDetail/personChangeList";
    }
    
    /**
     * 进入人家选择家庭通用页面（任何页面都可以调用）
     * @return
     */
    @RequestMapping("/selectCommonPersonFamily.do")
    public String selectCommonPersonFamily() {
        return "publichealth/select/selectCommonPersonFamily";
    }
    
    /**
     * 进入选择居民信息页面
     * @return
     */
    @RequestMapping("/selectPersonDetail.do")
    public String selectPersonDetail(String mode,Model model) {
    	model.addAttribute("mode",mode);
        return "publichealth/personDetail/selectPersonDetail";
    }
    
    /**
     * 打开公共选择居民列表信息页
     * @return
     */
    @RequestMapping("/selectCommonPersonDetail.do")
    public String selectCommonPersonDetail(String mode, Model model) {
        model.addAttribute("mode",mode);// 如果 参数 mode = "gravida" ,页面将默认性别为女性
        return "publichealth/select/selectCommonPersonDetail";
    }
    
    /**
     * 进入居民迁档页面
     * @param request
     * @param personDetailId
     * @param model
     * @return
     */
	@RequestMapping("/changeFamily.do")
	public String changeFamily(HttpServletRequest request,Long personDetailId, Model model) {
		PersonDetail  personDetail = this.personDetailService.selectAObject(PersonDetail.class,personDetailId);//个人基本档案
		model.addAttribute("regionAddress",this.regionService.parseRegionAdress(personDetail.getRegionId())); //街道地址
		model.addAttribute("familyDetail",this.familyDetailService.selectAObject(FamilyDetail.class,personDetail.getFamilyDetailId())); //家庭信息
    	model.addAttribute("personDetail",personDetail);
        return "publichealth/personDetail/changeFamily";
	}
	
	/**
	 * 修改人员家庭变动
	 * @param editInfo
	 * @return
	 */
	@RequestMapping("/changPersonFamily.jo")
	@ResponseBody
	public JsonObj changPersonFamily(PersonDetailEditInfo editInfo) { 
		return this.personDetailService.changPersonFamily(editInfo);
	}
	
    /**
     * 获取分页列表数据
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/personDetailListData.jo")
    @ResponseBody
    public  Map<String, Object> personDetailListData(HttpServletRequest request,PersonDetailQueryInfo info) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	info.setValidFlag(Contstants.YES_FLAG);
    	Page page = this.personDetailService.selectPersonDetailList(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
   
    /**
     * 根据条件查询 单个 居民信息
     * @param queryInfo
     * @return
     */
    @RequestMapping("/findPersonDetail.jo")
    @ResponseBody
    public JsonObj findPersonDetail(PersonDetailQueryInfo queryInfo) {
        JsonObj result = new JsonObj();
        PersonDetail personDetail = this.personDetailService.findPersonDetail(queryInfo);
        if (null == personDetail) {
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        result.setData(personDetail);
        return result;
    }
    
    /**
     * 进入新增| 编辑 页面
     * @param request
     * @param personType 人员类型，如果指定此类型 ，如personType=7 则表示添加老人 
     * @param personDetailId
     * @param model 
     * @return
     */
    @RequestMapping("/editPersonDetail.do")
    public String edit(HttpServletRequest request,Long personDetailId,Long familyDetailId,String personType, String mode, Model model) {
    	PersonDetail personDetail = null;
    	if (null != personDetailId) {
    		//进入编辑修改 
    		personDetail = this.personDetailService.selectAObject(PersonDetail.class,personDetailId);//个人基本档案
    		model.addAttribute("org",this.manageService.loadSysOrg(personDetail.getHospitalId())); // 所在医院机构
    		model.addAttribute("regionAddress",this.regionService.parseRegionAdress(personDetail.getRegionId())); //街道地址
    		model.addAttribute("familyDetail",this.familyDetailService.selectAObject(FamilyDetail.class,personDetail.getFamilyDetailId())); //家庭信息
    		model.addAttribute("pastDiseaseList",this.personDetailService.selectPersonPastDiseaseList(personDetailId));//既往疾病史
    		model.addAttribute("personExposeIdsList",this.personDetailService.selectPersonExposeIdsList(personDetailId));//个人暴露史
    		model.addAttribute("drugAllergyList",this.personDetailService.selectPersonDrugAllergyList(personDetailId));//个人过敏史
    		model.addAttribute("disabilityIdsList",this.personDetailService.selectPersonDisabilityIdsList(personDetailId));//残疾情况
    		model.addAttribute("personSurgeryList",this.personDetailService.selectPersonSurgeryList(personDetailId));//既往手术、外伤、输血史
    		model.addAttribute("familyDiseaseList",this.personDetailService.selectPersonFamilyDiseaseList(personDetailId));//家族疾病史列表
		} else {
			//进入新增
			SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
			SysOrg orgUnit = this.manageService.loadSysOrg(userInfo.getSysOrg().getUnitOrgId());
			personDetail = new PersonDetail();
			personDetail.setCreatorId(userInfo.getUserInfoId());
			personDetail.setCreatorName(userInfo.getName());
			personDetail.setHospitalId(orgUnit.getUnitOrgId());
			model.addAttribute("org",orgUnit); // 所在医院机构
			//由家庭基本信息页面跳转添加
			if (null != familyDetailId) {
				model.addAttribute("familyDetail",this.familyDetailService.selectAObject(FamilyDetail.class,familyDetailId)); //家庭信息
			}
		}
    	model.addAttribute("personType", personType);//当前仅用于添加页面的判断 ，如判断是否指定添加为老人
    	model.addAttribute("mode", mode);
    	model.addAttribute("personDetail",personDetail);
    	if (Contstants.SIMPLE_EDIT_PAGE.equals(mode)) {
    		return "publichealth/personDetail/personDetailEditSimple";
		}
        return "publichealth/personDetail/personDetailEdit";
    }
    
    
    /**
     * 保存个人基本档案
     * @param info
     * @return
     */
    @RequestMapping(value = "/savePersonDetail.jo")
    @ResponseBody 
    public JsonObj savePersonDetail(HttpServletRequest request,String personDetailRetionData) {
    	JsonObj result = new JsonObj();
    	SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
    	result.setData(this.personDetailService.savePersonDetail(personDetailRetionData,userInfo));
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 删除个人基本档案
     * @param personDetailId
     * @return
     */
     @RequestMapping(value = "/delPersonDetail.jo")
     @ResponseBody 
     public JsonObj delPersonDetail(Long personDetailId) {
         JsonObj result = new JsonObj();
         PersonDetail personDetail = this.personDetailService.selectAObject(PersonDetail.class, personDetailId);
         personDetail.setValidFlag(Contstants.NO_FLAG);
         this.personDetailService.saveAObject(personDetail);
         return result;
     }
}
