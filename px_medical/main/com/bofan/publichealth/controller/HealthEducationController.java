package com.bofan.publichealth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.command.HealthEducationEditInfo;
import com.bofan.publichealth.command.HealthEducationQueryInfo;
import com.bofan.publichealth.service.HealthEduArchiveService;
import com.bofan.publichealth.service.HealthEduAreaService;
import com.bofan.publichealth.service.HealthEduCrowdService;
import com.bofan.publichealth.service.HealthEduDatumTypeService;
import com.bofan.publichealth.service.HealthEducationService;
import com.bofan.publichealth.valueobject.HealthEduAffix;
import com.bofan.publichealth.valueobject.HealthEduBulletin;
import com.bofan.publichealth.valueobject.HealthEduReadyDatum;
import com.bofan.publichealth.valueobject.HealthEducation;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;

/**
 * 健康教育控制器
 * @Description
 * @author xlf 
 * 2017-10-26
 */
@Controller
@RequestMapping("/healthEducation")
public class HealthEducationController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(HealthEducationController.class.getName());

    @Autowired
    private HealthEducationService healthEducationService;
    @Autowired
    private HealthEduAreaService healthEduAreaService;
    @Autowired
    private HealthEduCrowdService healthEduCrowdService;
    @Autowired
    private HealthEduArchiveService healthEduArchiveService;
    @Autowired
    private HealthEduDatumTypeService healthEduDatumTypeService;
    
    /**
     * 打开活动形式:提供健康教育资料的列表页面
     * @return
     */
    @RequestMapping("/healthEducationMaterialList.do")
    public String healthEducationMaterialList() {
        return "publichealth/edu/healthEducationMaterialList";
    }
    
    /**
     * 查询活动形式:提供健康教育资料数据列表
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/materialList.jo")
    @ResponseBody
    public Map<String, Object> materialList(HttpServletRequest request, HealthEducationQueryInfo queryInfo) {
        queryInfo.setEduForm(Contstants.EDU_ACTIVITY_MATERIAL);
        return this.healthEducationList(request, queryInfo);
    }
    
    /**
     * 保存活动形式:提供健康教育资料
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/saveMaterial.jo")
    @ResponseBody
    public JsonObj saveMaterial(HttpServletRequest request, HealthEducationEditInfo info) {
        info.setEduForm(Contstants.EDU_ACTIVITY_MATERIAL);
        return this.saveHealthEducation(request, info);
    }
    
    /**
     * 打开活动形式:设置健康教育宣传栏列表页面
     * @return
     */
    @RequestMapping("/healthEducationPropagateList.do")
    public String healthEducationPropagateList() {
        return "publichealth/edu/healthEducationPropagateList";
    }
    
    /**
     * 查询活动形式:设置健康教育宣传栏数据列表
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/propagateList.jo")
    @ResponseBody
    public Map<String, Object> propagateList(HttpServletRequest request, HealthEducationQueryInfo queryInfo) {
        queryInfo.setEduForm(Contstants.EDU_ACTIVITY_PROPAGATE);
        return this.healthEducationList(request, queryInfo);
    }
    
    /**
     * 保存活动形式:设置健康教育宣传
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/savePropagate.jo")
    @ResponseBody
    public JsonObj savePropagate(HttpServletRequest request, HealthEducationEditInfo info) {
        info.setEduForm(Contstants.EDU_ACTIVITY_PROPAGATE);
        return this.saveHealthEducation(request, info);
    }
    
    /**
     * 打开活动形式:开展公众健康咨询活动列表页面
     * @return
     */
    @RequestMapping("/healthEducationInquiryList.do")
    public String healthEducationInquiryList() {
        return "publichealth/edu/healthEducationInquiryList";
    }
    
    /**
     * 查询活动形式:开展公众健康咨询活动数据列表
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/inquiryList.jo")
    @ResponseBody
    public Map<String, Object> inquiryList(HttpServletRequest request, HealthEducationQueryInfo queryInfo) {
        queryInfo.setEduForm(Contstants.EDU_ACTIVITY_INQUIRY);
        return this.healthEducationList(request, queryInfo);
    }
    
    /**
     * 保存活动形式:开展公众健康咨询活动
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/saveInquiry.jo")
    @ResponseBody
    public JsonObj saveInquiry(HttpServletRequest request, HealthEducationEditInfo info) {
        info.setEduForm(Contstants.EDU_ACTIVITY_INQUIRY);
        return this.saveHealthEducation(request, info);
    }
    
    /**
     * 打开活动形式:举办健康知识讲座列表页面
     * @return
     */
    @RequestMapping("/healthEducationLectureList.do")
    public String healthEducationLectureList() {
        return "publichealth/edu/healthEducationLectureList";
    }
    
    /**
     * 查询活动形式:举办健康知识讲座数据列表
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/lectureList.jo")
    @ResponseBody
    public Map<String, Object> lectureList(HttpServletRequest request, HealthEducationQueryInfo queryInfo) {
        queryInfo.setEduForm(Contstants.EDU_ACTIVITY_LECTURE);
        return this.healthEducationList(request, queryInfo);
    }
    
    /**
     * 保存活动形式:举办健康知识讲座
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/saveLecture.jo")
    @ResponseBody
    public JsonObj saveLecture(HttpServletRequest request, HealthEducationEditInfo info) {
        info.setEduForm(Contstants.EDU_ACTIVITY_LECTURE);
        return this.saveHealthEducation(request, info);
    }
    
    /**
     * 编辑健康教育活动
     * @param childDetailId
     * @return
     */
    @RequestMapping("/healthEducationEdit.do")
    public String healthEducationEdit(Long healthEducationId, String view, Model model) {
        StringBuffer viewPage = new StringBuffer("publichealth/edu/");
        if (null != healthEducationId) {
            HealthEducation healthEducation  = this.healthEducationService.selectAObject(HealthEducation.class, healthEducationId);
            model.addAttribute("healthEducation", healthEducation);
            // 健康教育宣传栏
            model.addAttribute("healthEduBulletin", this.healthEducationService.selectAObject(HealthEduBulletin.class, healthEducationId));
            // 健康教育--准备活动资料
            model.addAttribute("healthEduReadyDatum", this.healthEducationService.selectAObject(HealthEduReadyDatum.class, healthEducationId));
            // 资料发放位置
            model.addAttribute("givePositions", this.healthEduAreaService.selectHealthEduAreaId(healthEducationId, Contstants.EDU_AREA_PUT));
            // 播放发放位置
            model.addAttribute("playPositions", this.healthEduAreaService.selectHealthEduAreaId(healthEducationId, Contstants.EDU_AREA_PALY));
            // 资料发放种类
            model.addAttribute("datumTypes", this.healthEduDatumTypeService.selectHealthEduDatumTypeId(healthEducationId));
            // 资料存档类型
            model.addAttribute("archiveTypes", this.healthEduArchiveService.selectHealthEduArchiveId(healthEducationId));
            // 资料发放/接受教育对象
            model.addAttribute("receiveObjects", this.healthEduCrowdService.selectHealthEduCrowdId(healthEducationId));
            
            if(null != healthEducation && StringUtils.hasText(healthEducation.getAffixId())) {
                // 附件
                model.addAttribute("fileList", this.healthEducationService.selectAObject(HealthEduAffix.class, healthEducation.getAffixId()));
            }
        }
        return viewPage.append(view).toString();
    }
    
    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/deleteHealthEducation.jo")
    @ResponseBody
    public JsonObj deleteHealthEducation(Long[] ids) {
        JsonObj result = new JsonObj();
        if (null == ids || ids.length <= 0) {
            result.setMsg("删除失败");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        this.healthEducationService.deleteHealthEducation(ids);
        result.setMsg("成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 保存
     * @param request
     * @param queryInfo
     * @return
     */
    protected JsonObj saveHealthEducation(HttpServletRequest request, HealthEducationEditInfo info) {
        JsonObj result = new JsonObj();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        info.setCurrentUser(userInfo);
        
        this.healthEducationService.saveHealthEducation(info);
        result.setMsg("成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 查询健康教育活动数据列表
     * @param request
     * @param queryInfo
     * @return
     */
    protected Map<String, Object> healthEducationList(HttpServletRequest request, HealthEducationQueryInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        queryInfo.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
        queryInfo.setValidFlag(Contstants.YES_FLAG);
        
        Page page = this.healthEducationService.selectHealthEducationList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
}
