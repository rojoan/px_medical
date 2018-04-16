package com.bofan.publichealth.gravida.controller;

import java.util.Date;
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
import com.bofan.publichealth.gravida.command.GravidaDetailEditInfo;
import com.bofan.publichealth.gravida.command.GravidaDetailQueryInfo;
import com.bofan.publichealth.gravida.service.GravidaDetailService;
import com.bofan.publichealth.gravida.valueobject.GravidaDetail;
import com.bofan.publichealth.service.PersonDetailService;
import com.bofan.publichealth.service.RegionService;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.manage.service.ManageService;

/**
 * @Description: 孕妇基本档案Controller
 * @author lqw
 */
@Controller
@RequestMapping("/gravidaDetail")
public class GravidaDetailController  extends AbstractAnnotationController{
	/** logger */
    protected static Logger logger = Logger.getLogger(GravidaDetailController.class.getName());
	@Autowired
	private GravidaDetailService gravidaDetailService;
	@Autowired
	private PersonDetailService personDetailService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private ManageService manageService;
    
    /**
     * 进入孕妇登记列表页面
     * @return
     */
    @RequestMapping("/list.do")
    public String list() {
        return "publichealth/gravida/gravidaDetailList";
    }
    
    /**
     * 获取分页列表数据
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/listData.do")
    @ResponseBody
    public  Map<String, Object> listData(HttpServletRequest request,GravidaDetailQueryInfo queryInfo) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	queryInfo.setValidFlag(Contstants.YES_FLAG);
    	Page page = this.gravidaDetailService.selectGravidaDetailPage(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 打开选择孕妇列表信息页
     * @return
     */
    @RequestMapping("/selectCommonGravidaDetail.do")
    public String selectCommonGravidaDetail() {
        return "publichealth/select/selectCommonGravidaDetail";
    }
   
    /**
     * 查询孕妇信息
     * @return
     */
    @RequestMapping("/findGravidaDetail.jo")
    @ResponseBody 
    public JsonObj findGravidaDetail(GravidaDetailQueryInfo info) {
        JsonObj result = new JsonObj();
        GravidaDetail gravidaDetail  =  this.gravidaDetailService.findGravidaDetailList(info);
        if (null == gravidaDetail) {
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        result.setData(gravidaDetail);
        return result;
    }
    /**
     * 进入新增| 编辑 页面
     * @param request
     * @param gravidaDetailId
     * @param model
     * @return
     */
    @RequestMapping("/edit.do") 
    public String edit(HttpServletRequest request,Long gravidaDetailId,String mode, Model model) {
    	GravidaDetail gravidaDetail = null; 
    	if (null != gravidaDetailId) {
    		//进入编辑修改 
    		gravidaDetail = this.gravidaDetailService.selectAObject(GravidaDetail.class,gravidaDetailId);
    		Long personDetailId =  gravidaDetail.getPersonDetailId();
            model.addAttribute("pastDiseaseList",this.personDetailService.selectPersonPastDiseaseList(personDetailId));//既往疾病史
            model.addAttribute("personExposeIdsList",this.personDetailService.selectPersonExposeIdsList(personDetailId));//个人暴露史
            model.addAttribute("drugAllergyList",this.personDetailService.selectPersonDrugAllergyList(personDetailId));//个人过敏史
            model.addAttribute("disabilityIdsList",this.personDetailService.selectPersonDisabilityIdsList(personDetailId));//残疾情况
            model.addAttribute("personSurgeryList",this.personDetailService.selectPersonSurgeryList(personDetailId));//既往手术、外伤、输血史
            model.addAttribute("familyDiseaseList",this.personDetailService.selectPersonFamilyDiseaseList(personDetailId));//家族疾病史列表
    		model.addAttribute("regionAddress",this.regionService.parseRegionAdress(gravidaDetail.getRegionId()));
		} else {
			//进入新增
			SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY); 
			Long currenUserUnitOrgId = userInfo.getSysOrg().getUnitOrgId();
			SysOrg sysOrg = this.manageService.loadSysOrg(currenUserUnitOrgId);
			gravidaDetail = new GravidaDetail();
			gravidaDetail.setCreatorId(userInfo.getUserInfoId());
			gravidaDetail.setCreatorName(userInfo.getName());
			gravidaDetail.setHospitalId(sysOrg.getUnitOrgId());
			gravidaDetail.setHospitalNo(sysOrg.getOrgNo());
			gravidaDetail.setHospitalName(sysOrg.getName());
			gravidaDetail.setHospitalPhone(sysOrg.getDirectorTel());
			gravidaDetail.setCreateTime(new Date());
		}
    	model.addAttribute("gravidaDetail",gravidaDetail);
    	model.addAttribute("mode",mode);
 
        return "publichealth/gravida/gravidaDetailEdit";
    }
    
    /**
     * 保存孕妇基本档案
     * @param editInfo
     * @return 
     */
    @RequestMapping(value = "/saveGravidaDetail.do")
    @ResponseBody 
    public JsonObj saveGravidaDetail(GravidaDetailEditInfo editInfo) { 
    	JsonObj result = new JsonObj(); 
    	result.setData(this.gravidaDetailService.saveGravidaDetail(editInfo));
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
   /**
    * 删除孕妇基本档案
    * @param gravidaDetailId 
    * @return
    */
    @RequestMapping(value = "/delGravidaDetail.jo")
    @ResponseBody 
    public JsonObj delGravidaDetail(Long gravidaDetailId ) {
    	JsonObj result = new JsonObj(); 
    	this.gravidaDetailService.delGravidaDetail(gravidaDetailId );
        return result;
    }
    
}
