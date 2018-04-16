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
import com.bofan.publichealth.command.PersonChronicEditInfo;
import com.bofan.publichealth.command.PersonChronicTypeQueryInfo;
import com.bofan.publichealth.service.PersonChronicDangerService;
import com.bofan.publichealth.service.PersonChronicDiagBasisService;
import com.bofan.publichealth.service.PersonChronicDiagnoseService;
import com.bofan.publichealth.service.PersonChronicDrinkService;
import com.bofan.publichealth.service.PersonChronicDrugService;
import com.bofan.publichealth.service.PersonChronicNonDrugService;
import com.bofan.publichealth.service.PersonChronicService;
import com.bofan.publichealth.valueobject.PersonChronicDisease;
import com.bofan.publichealth.valueobject.PersonChronicItem;
import com.bofan.publichealth.valueobject.PersonChronicType;
import com.bofan.publichealth.valueobject.PersonDiabetesCure;
import com.bofan.publichealth.valueobject.PersonHypCure;
import com.bofan.publichealth.valueobject.PersonPhthisisCure;
import com.bofan.publichealth.valueobject.PersonTumourCure;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;

/**
 * 慢性病患者登记管理控制器（包括高血压及糖尿病）
 * @Description
 * @author xlf 
 * 2017-10-26
 */
@Controller
@RequestMapping("/personChronic")
public class PersonChronicController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(PersonChronicController.class.getName());

    @Autowired
    private PersonChronicService personChronicService;
    @Autowired
    private PersonChronicDrugService personChronicDrugService;
    @Autowired
    private PersonChronicDrinkService personChronicDrinkService;
    @Autowired
    private PersonChronicDangerService personChronicDangerService;
    @Autowired
    private PersonChronicNonDrugService personChronicNonDrugService;
    @Autowired
    private PersonChronicDiagnoseService personChronicDiagnoseService;
    @Autowired
    private PersonChronicDiagBasisService personChronicDiagBasisService;
    
    /**
     * 打开慢性病公共选择页面
     * @return
     */
    @RequestMapping("/selectCommonPersonChronicList.do")
    public String selectCommonPersonChronicList(String chronicType, Model model) {
        model.addAttribute("chronicType", chronicType);
        return "publichealth/select/selectCommonPersonChronicList";
    }
    
    /**
     * 打开患者信息页面（包含登记和随访信息）
     * @return
     */
    @RequestMapping("/personChronicShow.do")
    public String personChronicShow(Long personChronicId, Long chronicTypeId, String chronicType, String editView, String showView, Model model) {
        model.addAttribute("editView", editView);
        model.addAttribute("showView", showView);
        model.addAttribute("chronicType", chronicType);
        model.addAttribute("chronicTypeId", chronicTypeId);
        model.addAttribute("personChronicId", personChronicId);
        return "publichealth/personChronicShow";
    }
    
    /**
     * 慢性病公共选择列表数据
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/selectCommonPersonChronicDataList.jo")
    @ResponseBody
    public Map<String, Object> selectCommonPersonChronicDataList(HttpServletRequest request, PersonChronicTypeQueryInfo queryInfo) {
        return this.personChronicDataList(request, queryInfo);
    }
    
    /**
     * 打开高血压列表分页页
     * @return
     */
    @RequestMapping("/personHypRecordList.do")
    public String personHypRecordList() {
        return "publichealth/personHypRecordList";
    }
    
    /**
     * 高血压列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personHypRecordDataList.jo")
    @ResponseBody
    public Map<String, Object> personHypRecordDataList(HttpServletRequest request, PersonChronicTypeQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_HYP);
        return this.personChronicDataList(request, queryInfo);
    }
    
    /**
     * 打开糖尿病列表分页页
     * @return
     */
    @RequestMapping("/personDMRecordList.do")
    public String personDMRecordList() {
        return "publichealth/personDMRecordList";
    }
    
    /**
     * 糖尿病列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personDMRecordDataList.jo")
    @ResponseBody
    public Map<String, Object> personDMRecordDataList(HttpServletRequest request, PersonChronicTypeQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_DM);
        return this.personChronicDataList(request, queryInfo);
    }
    
    /**
     * 打开慢阻肺列表分页页
     * @return
     */
    @RequestMapping("/personCopdRecordList.do")
    public String personCopdRecordList() {
        return "publichealth/personCopdRecordList";
    }
    
    /**
     * 慢阻肺列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personCopdRecordDataList.jo")
    @ResponseBody
    public Map<String, Object> personCopdRecordDataList(HttpServletRequest request, PersonChronicTypeQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_COPD);
        return this.personChronicDataList(request, queryInfo);
    }
    
    /**
     * 打开肿瘤患者列表分页页
     * @return
     */
    @RequestMapping("/personTumRecordList.do")
    public String personTumRecordList() {
        return "publichealth/personTumRecordList";
    }
    
    /**
     * 肿瘤患者列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personTumRecordDataList.jo")
    @ResponseBody
    public Map<String, Object> personTumRecordDataList(HttpServletRequest request, PersonChronicTypeQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_TUM);
        return this.personChronicDataList(request, queryInfo);
    }
    
    /**
     * 打开冠心病患者列表分页页
     * @return
     */
    @RequestMapping("/personChdRecordList.do")
    public String personChdRecordList() {
        return "publichealth/personChdRecordList";
    }
    
    /**
     * 冠心病患者列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personChdRecordDataList.jo")
    @ResponseBody
    public Map<String, Object> personChdRecordDataList(HttpServletRequest request, PersonChronicTypeQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_CHD);
        return this.personChronicDataList(request, queryInfo);
    }

    /**
     * 打开脑卒中患者列表分页页
     * @return
     */
    @RequestMapping("/personCSRecordList.do")
    public String personCSRecordList() {
        return "publichealth/personCSRecordList";
    }
    
    /**
     * 脑卒中患者列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personCSRecordDataList.jo")
    @ResponseBody
    public Map<String, Object> personCSRecordDataList(HttpServletRequest request, PersonChronicTypeQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_CS);
        return this.personChronicDataList(request, queryInfo);
    }
    
    /**
     * 打开肺结核患者列表分页页
     * @return
     */
    @RequestMapping("/personPtbRecordList.do")
    public String personPtbRecordList() {
        return "publichealth/personPtbRecordList";
    }
    
    /**
     * 肺结核患者列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personPtbRecordDataList.jo")
    @ResponseBody
    public Map<String, Object> personPtbRecordDataList(HttpServletRequest request, PersonChronicTypeQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_PTB);
        return this.personChronicDataList(request, queryInfo);
    }
    
    /**
     * 查询所有慢性病列表数据
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personChronicDataList.jo")
    @ResponseBody
    public Map<String, Object> personChronicDataList(HttpServletRequest request, PersonChronicTypeQueryInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        queryInfo.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
        
        Page page = this.personChronicService.selectPersonChronicTypeList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 打开登记编辑页
     * @param childDetailId
     * @return
     */
    @RequestMapping("/personRecordEdit.do")
    public String personRecordEdit(Long chronicTypeId, String view, Model model) {
        StringBuffer viewPage = new StringBuffer("publichealth/");
        if (null == chronicTypeId) {
            return viewPage.append(view).toString();
        }
        PersonChronicType chronicType = this.personChronicService.selectAObject(PersonChronicType.class, chronicTypeId); 
        if (null == chronicType) {
            throw new RuntimeException("对应的慢性病患者记录不存在");
        }
        
        model.addAttribute("chronicType", chronicType);
        if (null != chronicType) {
            // 慢性病患者登记信息
            model.addAttribute("personChronic", chronicType.getPersonChronic());
            if(Contstants.CHRONNIC_TYPE_HYP.equals(chronicType.getChronicType())) {
                // 慢性病患者体格检查/生活行为信息
                model.addAttribute("personChronicItem", this.personChronicService.selectAObject(PersonChronicItem.class, chronicType.getPersonChronicId()));
                // 慢性病患者相关病史和家族史信息
                model.addAttribute("personChronicDisease", this.personChronicService.selectAObject(PersonChronicDisease.class, chronicType.getPersonChronicId()));
                // 高血压患者用药和治疗信息
                model.addAttribute("personHypCure", this.personChronicService.selectAObject(PersonHypCure.class, chronicType.getPersonChronicId()));
                // 慢性病本次药物治疗信息(多条数据)
                model.addAttribute("chronicDrugList", this.personChronicDrugService.selectPersonChronicDrug(chronicType.getPersonChronicId(), chronicType.getPersonDetailId())); 
                // 慢性病非药物治疗信息(多个ID)
                model.addAttribute("chronicNonDrugIds",
                        this.personChronicNonDrugService.selectPersonChronicNonDrugId(chronicType.getPersonChronicId(),
                                chronicType.getPersonDetailId(), chronicType.getChronicType()));
                // 慢性病患者--饮酒种类对照
                model.addAttribute("chronicDrinkMap", this.personChronicDrinkService.selectPersonChronicDrinkMap(chronicType.getPersonChronicId(), chronicType.getPersonDetailId()));
            }
            
            if(Contstants.CHRONNIC_TYPE_DM.equals(chronicType.getChronicType())) {
                // 慢性病患者体格检查/生活行为信息
                model.addAttribute("personChronicItem", this.personChronicService.selectAObject(PersonChronicItem.class, chronicType.getPersonChronicId()));
                // 慢性病患者相关病史和家族史信息
                model.addAttribute("personChronicDisease", this.personChronicService.selectAObject(PersonChronicDisease.class, chronicType.getPersonChronicId()));
                // 高血压患者用药和治疗信息
                model.addAttribute("personDiabetesCure", this.personChronicService.selectAObject(PersonDiabetesCure.class, chronicType.getPersonChronicId()));
                // 慢性病本次药物治疗信息(多条数据)
                model.addAttribute("chronicDrugList", this.personChronicDrugService.selectPersonChronicDrug(chronicType.getPersonChronicId(), chronicType.getPersonDetailId())); 
                // 慢性病非药物治疗信息(多个ID)
                model.addAttribute("chronicNonDrugIds",
                        this.personChronicNonDrugService.selectPersonChronicNonDrugId(chronicType.getPersonChronicId(),
                                chronicType.getPersonDetailId(), chronicType.getChronicType()));
                // 慢性病患者--饮酒种类对照
                model.addAttribute("chronicDrinkMap", this.personChronicDrinkService.selectPersonChronicDrinkMap(chronicType.getPersonChronicId(), chronicType.getPersonDetailId()));
            }
            
            if(Contstants.CHRONNIC_TYPE_COPD.equals(chronicType.getChronicType())) {
                // 慢性病非药物治疗信息(多个ID)
                model.addAttribute("chronicNonDrugIds",
                        this.personChronicNonDrugService.selectPersonChronicNonDrugId(chronicType.getPersonChronicId(),
                                chronicType.getPersonDetailId(), chronicType.getChronicType()));
                // 慢性病--危险因素(多个ID)
                model.addAttribute("dangerTypes", this.personChronicDangerService.selectPersonChronicDangerId(chronicType.getPersonChronicId(), chronicType.getPersonDetailId(), chronicType.getChronicType()));  
            }
            
            if(Contstants.CHRONNIC_TYPE_TUM.equals(chronicType.getChronicType())) {
                // 肿瘤患者治疗和进展情况
                model.addAttribute("personTumourCure", this.personChronicService.selectAObject(PersonTumourCure.class, chronicType.getPersonChronicId()));
                // 诊断依据
                model.addAttribute("diagnoseBasis", this.personChronicDiagBasisService.selectPersonChronicDiagBasisId(chronicType.getPersonChronicId(), chronicType.getPersonDetailId(), chronicType.getChronicType()));
                // 慢性病非药物治疗信息(多个ID)
                model.addAttribute("chronicNonDrugIds",
                        this.personChronicNonDrugService.selectPersonChronicNonDrugId(chronicType.getPersonChronicId(),
                                chronicType.getPersonDetailId(), chronicType.getChronicType()));
            }
            
            if(Contstants.CHRONNIC_TYPE_CHD.equals(chronicType.getChronicType())) {
                // 诊断依据
                model.addAttribute("diagnoseBasis", this.personChronicDiagBasisService.selectPersonChronicDiagBasisId(chronicType.getPersonChronicId(), chronicType.getPersonDetailId(), chronicType.getChronicType()));
                // 慢性病--具体诊断信息(多个ID)
                model.addAttribute("chronicDiagnoses", this.personChronicDiagnoseService.selectPersonChronicDiagnoseId(chronicType.getPersonChronicId(), chronicType.getPersonDetailId(), chronicType.getChronicType()));
            }
            
            if(Contstants.CHRONNIC_TYPE_CS.equals(chronicType.getChronicType())) {
                // 诊断依据
                model.addAttribute("diagnoseBasis", this.personChronicDiagBasisService.selectPersonChronicDiagBasisId(chronicType.getPersonChronicId(), chronicType.getPersonDetailId(), chronicType.getChronicType()));
                // 慢性病--具体诊断信息(多个ID)
                model.addAttribute("chronicDiagnoses", this.personChronicDiagnoseService.selectPersonChronicDiagnoseId(chronicType.getPersonChronicId(), chronicType.getPersonDetailId(), chronicType.getChronicType()));
            }
            
            if(Contstants.CHRONNIC_TYPE_PTB.equals(chronicType.getChronicType())) {
                // 慢性病患者体格检查/生活行为信息
                model.addAttribute("personChronicItem", this.personChronicService.selectAObject(PersonChronicItem.class, chronicType.getPersonChronicId()));
                // 肺结核诊断和治疗情况
                model.addAttribute("personPhthisisCure", this.personChronicService.selectAObject(PersonPhthisisCure.class, chronicType.getPersonChronicId()));
                // 慢性病非药物治疗信息(多个ID)
                model.addAttribute("chronicNonDrugIds",
                        this.personChronicNonDrugService.selectPersonChronicNonDrugId(chronicType.getPersonChronicId(),
                                chronicType.getPersonDetailId(), chronicType.getChronicType()));}
        }

        return viewPage.append(view).toString();
    }
    
    /**
     * 保存
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/savePersonRecord.jo")
    @ResponseBody
    public JsonObj savePersonRecord(HttpServletRequest request, PersonChronicEditInfo info) {
        JsonObj result = new JsonObj();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        info.setCurrentUser(userInfo);

        if (!StringUtils.hasText(info.getChronicType())) {
            result.setMsg("保存失败，患者疾病类不能为空");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        if (null == info.getPersonChronicId() && null != info.getPersonDetailId()) {
            PersonChronicTypeQueryInfo queryInfo = new PersonChronicTypeQueryInfo();
            queryInfo.setPersonDetailId(info.getPersonDetailId());
            queryInfo.setChronicType(info.getChronicType());
            Page page = this.personChronicService.selectPersonChronicTypeList(queryInfo);
            
            if (null != page.getData() && page.getData().size() > 0) {
                result.setMsg("该患者已经存在，不能重复登记");
                result.setCode(ResponseContstants.RESULT_FAIL_CODE);
                return result;
            }
        }
        
        this.personChronicService.savePersonChronic(info);
        result.setMsg("保存成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 删除慢性病患者类型（置为无效）
     * @param childDetailId
     * @return
     */
    @RequestMapping("/deletePersonChronicTpye.jo")
    @ResponseBody
    public JsonObj deletePersonChronicTpye(Long[] ids) {
        JsonObj result = new JsonObj();
        if (null == ids || ids.length < 0) {
            result.setMsg("删除失败");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        this.personChronicService.deletePersonHypRecord(ids);
        result.setMsg("删除成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 根据主键ID删除本次用药信息
     * @param chronicDrugId
     * @return
     */
    @RequestMapping("/deletePersonChronicDrug.jo")
    @ResponseBody
    public JsonObj deletePersonChronicDrug(Long chronicDrugId) {
        JsonObj result = new JsonObj();
        if (null == chronicDrugId || chronicDrugId.longValue() < 0) {
            result.setMsg("删除失败");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        this.personChronicDrugService.deletePersonChronicDrug(chronicDrugId);
        result.setMsg("删除成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
}
