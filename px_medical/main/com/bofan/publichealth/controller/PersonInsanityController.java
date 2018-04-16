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
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.command.PersonInsanityEditInfo;
import com.bofan.publichealth.command.PersonInsanityQueryInfo;
import com.bofan.publichealth.command.PersonInsanityVisitEditInfo;
import com.bofan.publichealth.command.PersonInsanityVisitGroupQueryInfo;
import com.bofan.publichealth.command.PersonInsanityVisitQueryInfo;
import com.bofan.publichealth.service.PersonInsanityBehaviorService;
import com.bofan.publichealth.service.PersonInsanityGuidedrugService;
import com.bofan.publichealth.service.PersonInsanityRecoveryService;
import com.bofan.publichealth.service.PersonInsanityService;
import com.bofan.publichealth.service.PersonInsanitySymService;
import com.bofan.publichealth.service.PersonInsanityUsedrugService;
import com.bofan.publichealth.valueobject.PersonInsanity;
import com.bofan.publichealth.valueobject.PersonInsanityVisit;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;

/**
 * 慢性病患者随访记录控制器（包括高血压及糖尿病等）
 * @Description
 * @author xlf 
 * 2017-10-26
 */
@Controller
@RequestMapping("/personInsanity")
public class PersonInsanityController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(PersonInsanityController.class.getName());

    @Autowired
    private PersonInsanityService personInsanityService;
    @Autowired
    private PersonInsanitySymService personInsanitySymService;
    @Autowired
    private PersonInsanityUsedrugService personInsanityUsedrugService;
    @Autowired
    private PersonInsanityRecoveryService personInsanityRecoveryService;
    @Autowired
    private PersonInsanityBehaviorService personInsanityBehaviorService;
    @Autowired
    private PersonInsanityGuidedrugService personInsanityGuidedrugService;
    
    /**
     * 打开重性精神病公共选择分页列表页
     * @return
     */
    @RequestMapping("/selectCommonPersonInsanityList.do")
    public String selectCommonPersonInsanityList() {
        return "publichealth/select/selectCommonPersonInsanityList";
    }
    
    /**
     * 打开重性精神病分页列表页
     * @return
     */
    @RequestMapping("/personInsanityRecordList.do")
    public String personInsanityRecordList() {
        return "publichealth/personInsanityRecordList";
    }
    
    /**
     * 重性精神病列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personInsanityRecordDataList.jo")
    @ResponseBody
    public Map<String, Object> personInsanityRecordDataList(HttpServletRequest request, PersonInsanityQueryInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        queryInfo.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
        
        Page page = this.personInsanityService.selectPersonInsanityList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 打开重性精神病随访分页列表页
     * @return
     */
    @RequestMapping("/personInsanityVisitList.do")
    public String personInsanityVisitList() {
        return "publichealth/personInsanityVisitList";
    }
    
    /**
     * 重性精神病随访列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personInsanityVisitDataList.jo")
    @ResponseBody
    public Map<String, Object> personInsanityVisitDataList(HttpServletRequest request, PersonInsanityVisitQueryInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        queryInfo.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
        
        Page page = this.personInsanityService.selectPersonChronicVisitList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 打开患者信息页面（包含登记和随访信息）
     * @return
     */
    @RequestMapping("/personInsanityShow.do")
    public String personInsanityShow(Long personInsanityId, Model model) {
        model.addAttribute("personInsanityId", personInsanityId);
        return "publichealth/personInsanityShow";
    }
    
    /**
     * 重性精神病随访分组列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personInsanityVisitGroupDataList.jo")
    @ResponseBody
    public Map<String, Object> personInsanityVisitGroupDataList(HttpServletRequest request, PersonInsanityVisitGroupQueryInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        queryInfo.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
        
        Page page = this.personInsanityService.selectPersonChronicVisitGroupList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 打开重性精神病登记编辑页
     * @param childDetailId
     * @return
     */
    @RequestMapping("/personInsanityEdit.do")
    public String personInsanityEdit(HttpServletRequest request, Long personInsanityId, String view, Model model) {
        StringBuffer viewPage = new StringBuffer("publichealth/");
        if (null == personInsanityId) {
            PersonInsanity editInsanity = new PersonInsanity();
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
            SysOrg unitOrg = this.personInsanityService.selectAObject(SysOrg.class, userInfo.getSysOrg().getUnitOrgId());
            editInsanity.setHospitalId(unitOrg.getOrgId());
            editInsanity.setHospitalName(unitOrg.getName());
            editInsanity.setHospitalNo(unitOrg.getOrgNo());
            editInsanity.setHospitalPhone(unitOrg.getDirectorTel());
            editInsanity.setCreatorId(userInfo.getUserInfoId());
            editInsanity.setCreatorName(userInfo.getName());
            model.addAttribute("personInsanity", editInsanity);
            return viewPage.append(view).toString();
        }
        
        PersonInsanity personInsanity = this.personInsanityService.selectAObject(PersonInsanity.class, personInsanityId); 
        if (null == personInsanity) {
            throw new RuntimeException("对应的重性精神病患者登记记录不存在");
        }
        
        model.addAttribute("personInsanity", personInsanity);
        
        if (null != personInsanity.getPersonInsanityId() && null != personInsanity.getPersonDetailId()) {
            // 重性精神病--症状ID(多个ID)
            model.addAttribute("insanitySymIds", this.personInsanitySymService.selectPersonInsanitySymId(
                    personInsanity.getPersonInsanityId(), null, Contstants.INSANITY_REG_RECODE_TYPE));

            // 重性精神病--危险行为类型(map格式)
            model.addAttribute("behaviorMap", this.personInsanityBehaviorService.selectPersonInsanityBehavior(
                    personInsanity.getPersonInsanityId(), null, Contstants.INSANITY_REG_RECODE_TYPE));
        }

        return viewPage.append(view).toString();
    }
    
    /**
     * 打开重性精神病随访编辑页
     * @param childDetailId
     * @return
     */
    @RequestMapping("/personInsanityVisitEdit.do")
    public String personInsanityVisitEdit(HttpServletRequest request, Long personInsanityVisitId, Long personInsanityId, String view, Model model) {
        StringBuffer viewPage = new StringBuffer("publichealth/");
        if (null == personInsanityVisitId) {
            PersonInsanityVisit editInsanityVisit = new PersonInsanityVisit();
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
            SysOrg unitOrg = this.personInsanityService.selectAObject(SysOrg.class, userInfo.getSysOrg().getUnitOrgId());
            editInsanityVisit.setHospitalId(unitOrg.getOrgId());
            editInsanityVisit.setHospitalName(unitOrg.getName());
            editInsanityVisit.setHospitalNo(unitOrg.getOrgNo());
            editInsanityVisit.setHospitalPhone(unitOrg.getDirectorTel());
            editInsanityVisit.setVisitDoctorId(userInfo.getUserInfoId());
            editInsanityVisit.setVisitDoctorName(userInfo.getName());
            if (null != personInsanityId) {
                PersonInsanity personInsanity = this.personInsanityService.selectAObject(PersonInsanity.class, personInsanityId);
                if (null != personInsanity) {
                    editInsanityVisit.setPersonInsanity(personInsanity);
                    editInsanityVisit.setPersonInsanityId(personInsanityId);
                    editInsanityVisit.setPersonDetailId(personInsanity.getPersonDetailId());
                }
            }
            
            model.addAttribute("personInsanityVisit", editInsanityVisit);
            return viewPage.append(view).toString();
        }
        
        PersonInsanityVisit insanityVisit = this.personInsanityService.selectAObject(PersonInsanityVisit.class, personInsanityVisitId); 
        if (null == insanityVisit) {
            throw new RuntimeException("对应的重性精神病患者随访记录不存在");
        }
        
        model.addAttribute("personInsanityVisit", insanityVisit);
        if (null != insanityVisit.getPersonInsanityVisitId() && null != insanityVisit.getPersonDetailId()) {
            // 重性精神病--症状ID(多个ID)
            model.addAttribute("insanitySymIds",
                    this.personInsanitySymService.selectPersonInsanitySymId(insanityVisit.getPersonInsanityId(),
                            insanityVisit.getPersonInsanityVisitId(), Contstants.INSANITY_VISIT_RECODE_TYPE));

            // 重性精神病--危险行为类型(map格式)
            model.addAttribute("behaviorMap", this.personInsanityBehaviorService.selectPersonInsanityBehavior(
                    null, insanityVisit.getPersonInsanityVisitId(), Contstants.INSANITY_VISIT_RECODE_TYPE));
            
            // 重性精神病--康复措施类型(多条)
            model.addAttribute("insanityRecoveryTypes", this.personInsanityRecoveryService
                    .selectPersonInsanityRecoveryType(insanityVisit.getPersonInsanityVisitId(), insanityVisit.getPersonDetailId()));

            // 重性精神病--用药情况(多條)
            model.addAttribute("usedrugList", this.personInsanityUsedrugService.selectPersonInsanityUsedrug(
                    insanityVisit.getPersonInsanityVisitId(), insanityVisit.getPersonDetailId()));

            // 重性精神病--危险行为类型(多条)
            model.addAttribute("guidedrugList", this.personInsanityGuidedrugService
                    .selectPersonInsanityGuidedrug(insanityVisit.getPersonInsanityVisitId(), insanityVisit.getPersonDetailId()));
        }

        return viewPage.append(view).toString();
    }
    
    /**
     * 保存 重性精神病患者登記
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/savePersonInsanity.jo")
    @ResponseBody
    public JsonObj savePersonInsanity(HttpServletRequest request, PersonInsanityEditInfo info) {
        JsonObj result = new JsonObj();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        info.setCurrentUser(userInfo);
        info.setRecordFlag(Contstants.INSANITY_REG_RECODE_TYPE);

        if (null == info.getPersonInsanityId() && null != info.getPersonDetailId()) {
            PersonInsanityQueryInfo queryInfo = new PersonInsanityQueryInfo();
            queryInfo.setPersonDetailId(info.getPersonDetailId());
            Page page = this.personInsanityService.selectPersonInsanityList(queryInfo);
            
            if (null != page.getData() && page.getData().size() > 0) {
                result.setMsg("该患者已经存在，不能重复登记");
                result.setCode(ResponseContstants.RESULT_FAIL_CODE);
                return result;
            }
        }
        
        this.personInsanityService.savePersonInsanity(info);
        result.setMsg("保存成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 保存 重性精神病患者随访
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/savePersonInsanityVisit.jo")
    @ResponseBody
    public JsonObj savePersonInsanityVisit(HttpServletRequest request, PersonInsanityVisitEditInfo info) {
        JsonObj result = new JsonObj();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        info.setCurrentUser(userInfo);
        info.setRecordFlag(Contstants.INSANITY_VISIT_RECODE_TYPE);

        this.personInsanityService.savePersonInsanityVisit(info);
        result.setMsg("保存成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 删除慢性病患者登记（置为无效）
     * @param ids
     * @return
     */
    @RequestMapping("/deletePersonInsanity.jo")
    @ResponseBody
    public JsonObj deletePersonInsanity(Long[] ids) {
        JsonObj result = new JsonObj();
        if (null == ids || ids.length <= 0) {
            result.setMsg("删除失败");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        this.personInsanityService.deletePersonInsanity(ids);
        result.setMsg("删除成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 
     * @param ids
     * @return
     */
    @RequestMapping("/deletePersonInsanityVisit.jo")
    @ResponseBody
    public JsonObj deletePersonInsanityVisit(Long[] ids) {
        JsonObj result = new JsonObj();
        if (null == ids || ids.length < 0) {
            result.setMsg("删除失败");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        this.personInsanityService.deletePersonInsanityVisit(ids);
        result.setMsg("删除成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 根据主键ID删除用药信息
     * @param personInsanityUsedrugId
     * @return
     */
    @RequestMapping("/deletePersonInsanityUsedrug.jo")
    @ResponseBody
    public JsonObj deletePersonInsanityUsedrug(Long personInsanityUsedrugId) {
        JsonObj result = new JsonObj();
        if (null == personInsanityUsedrugId || personInsanityUsedrugId.longValue() < 0) {
            result.setMsg("删除失败");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        this.personInsanityUsedrugService.deletePersonInsanityUsedrug(personInsanityUsedrugId);
        result.setMsg("删除成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 根据主键ID删除指导用药信息
     * @param personInsanityGuidedrugId
     * @return
     */
    @RequestMapping("/deletePersonInsanityGuidedrug.jo")
    @ResponseBody
    public JsonObj deletePersonInsanityGuidedrug(Long personInsanityGuidedrugId) {
        JsonObj result = new JsonObj();
        if (null == personInsanityGuidedrugId || personInsanityGuidedrugId.longValue() < 0) {
            result.setMsg("删除失败");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        this.personInsanityGuidedrugService.deletePersonInsanityGuidedrug(personInsanityGuidedrugId);
        result.setMsg("删除成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
}
