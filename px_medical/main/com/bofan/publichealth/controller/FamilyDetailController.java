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
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.command.FamilyDetailQueryInfo;
import com.bofan.publichealth.service.FamilyDetailService;
import com.bofan.publichealth.service.PersonDetailService;
import com.bofan.publichealth.service.RegionService;
import com.bofan.publichealth.valueobject.FamilyDetail;
import com.bofan.publichealth.valueobject.HouseCondition;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.manage.service.ManageService;

/**
 * @Description: 家庭基本档案Controller
 * @author lqw
 */
@Controller
@RequestMapping("/familyDetail")
public class FamilyDetailController  extends AbstractAnnotationController{
	/** logger */
    protected static Logger logger = Logger.getLogger(FamilyDetailController.class.getName());
	@Autowired
	private FamilyDetailService familyDetailService;
	@Autowired
	private PersonDetailService personDetailService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private ManageService manageService;
    
    /**
     * 进入家庭基本档案列表页面
     * @return
     */
    @RequestMapping("/list.do")
    public String list() {
        return "publichealth/family/familyDetailList";
    }
    
    /**
     * 获取分页列表数据
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/familyDetailListData.jo")
    @ResponseBody
    public  Map<String, Object> familyDetailListData(HttpServletRequest request,FamilyDetailQueryInfo info) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	info.setValidFlag(Contstants.YES_FLAG);
    	Page page = this.familyDetailService.selectFamilyDetailList(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
   
    /**
     * 进入新增| 编辑 页面
     * @param request
     * @param familyDetailId
     * @param model
     * @return
     */
    @RequestMapping("/editFamilyDetail.do")
    public String editFamilyDetail(HttpServletRequest request,Long familyDetailId,String mode, Model model) {
    	FamilyDetail familyDetail = null;
    	if (null != familyDetailId) {
    		//进入编辑修改 
    		familyDetail = this.familyDetailService.selectAObject(FamilyDetail.class,familyDetailId);
    		model.addAttribute("regionAddress",this.regionService.parseRegionAdress(familyDetail.getRegionId()));
    		model.addAttribute("creatorName",this.manageService.loadSysUserInfo(familyDetail.getCreatorId()).getName());
    		model.addAttribute("familyPersonDetailList",this.personDetailService.selectPersonDetailList(familyDetailId));
    		if (null != familyDetail.getHouseConditionId()) {
    		    model.addAttribute("houseCondition",this.familyDetailService.selectAObject(HouseCondition.class,familyDetail.getHouseConditionId()));
            }
    		   
		} else {
			//进入新增
			SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
			familyDetail = new FamilyDetail();
			familyDetail.setCreatorId(userInfo.getUserInfoId());
			model.addAttribute("creatorName",userInfo.getName());
		}
    	model.addAttribute("familyDetail",familyDetail);
    	model.addAttribute("mode",mode);
    	
    	if(Contstants.SIMPLE_EDIT_PAGE.equals(mode)){
			 return "publichealth/family/familyDetailEditSimple";
		}
        return "publichealth/family/familyDetailEdit";
    }
    
    
    @RequestMapping("/simpleFamilyDetail.do")
    public String simpleFamilyDetail(HttpServletRequest request,Long familyDetailId,String mode, Model model) {
        FamilyDetail familyDetail = null;
        if (null != familyDetailId) {
            //进入编辑修改 
            familyDetail = this.familyDetailService.selectAObject(FamilyDetail.class,familyDetailId);
            model.addAttribute("regionAddress",this.regionService.parseRegionAdress(familyDetail.getRegionId()));
            model.addAttribute("creatorName",this.manageService.loadSysUserInfo(familyDetail.getCreatorId()).getName());
            model.addAttribute("familyPersonDetailList",this.personDetailService.selectPersonDetailList(familyDetailId));
            if (null != familyDetail.getHouseConditionId()) {
                model.addAttribute("houseCondition",this.familyDetailService.selectAObject(HouseCondition.class,familyDetail.getHouseConditionId()));
            }
            
        } else {
            //进入新增
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
            familyDetail = new FamilyDetail();
            familyDetail.setCreatorId(userInfo.getUserInfoId());
            model.addAttribute("creatorName",userInfo.getName());
        }
        model.addAttribute("familyDetail",familyDetail);
        model.addAttribute("mode",mode);
      
        return "publichealth/family/simpleFamilyDetail";
    }
     
    /**
     * 保存家庭基本档案
     * @param info
     * @return
     */
    @RequestMapping(value = "/saveFamilyDetail.jo")
    @ResponseBody 
    public JsonObj saveFamilyDetail(String familyDetailRetionData) { 
    	JsonObj result = new JsonObj();
    	result.setData(this.familyDetailService.saveFamilyDetail(familyDetailRetionData));
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
   /**
    * 删除家庭基本档案
    * @param familyDetailId
    * @return
    */
    @RequestMapping(value = "/delFamilyDetail.jo")
    @ResponseBody 
    public JsonObj delFamilyDetail(Long familyDetailId) {
    	JsonObj result = new JsonObj();
		FamilyDetail familyDetail = this.familyDetailService.selectAObject(FamilyDetail.class, familyDetailId);
		familyDetail.setValidFlag(Contstants.NO_FLAG);
		this.familyDetailService.saveAObject(familyDetail);
    	return result;
    }
    
}
