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
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.command.PersonChronicVisitEditInfo;
import com.bofan.publichealth.command.PersonChronicVisitQueryInfo;
import com.bofan.publichealth.service.PersonChronicVisitService;
import com.bofan.publichealth.service.PersonVisitChronicSymService;
import com.bofan.publichealth.service.PersonVisitContentService;
import com.bofan.publichealth.service.PersonVisitCureService;
import com.bofan.publichealth.service.PersonVisitDrugService;
import com.bofan.publichealth.valueobject.PersonChronic;
import com.bofan.publichealth.valueobject.PersonChronicVisit;
import com.bofan.publichealth.valueobject.PersonVisitItem;
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
@RequestMapping("/personChronicVisit")
public class PersonChronicVisitController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(PersonChronicVisitController.class.getName());

    @Autowired
    private PersonVisitCureService personVisitCureService;
    @Autowired
    private PersonVisitDrugService personVisitDrugService;
    @Autowired
    private PersonChronicVisitService personChronicVisitService;
    @Autowired
    private PersonVisitContentService personVisitContentService;
    @Autowired
    private PersonVisitChronicSymService personVisitChronicSymService;
    
    /**
     * 打开高血压随访列表分页页
     * @return
     */
    @RequestMapping("/personHypVisitList.do")
    public String personHypVisitList() {
        return "publichealth/personHypVisitList";
    }
    
    /**
     * 高血压随访列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personHypRecordDataList.jo")
    @ResponseBody
    public Map<String, Object> personHypRecordDataList(HttpServletRequest request, PersonChronicVisitQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_HYP);
        return this.personVisitDataList(request, queryInfo);
    }
    
    /**
     * 打开糖尿病随访列表分页页
     * @return
     */
    @RequestMapping("/personDMVisitList.do")
    public String personDMVisitList() {
        return "publichealth/personDMVisitList";
    }
    
    /**
     * 糖尿病随访列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personDMVisitDataList.jo")
    @ResponseBody
    public Map<String, Object> personDMVisitDataList(HttpServletRequest request, PersonChronicVisitQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_DM);
        return this.personVisitDataList(request, queryInfo);
    }
    
    /**
     * 打开慢阻肺随访列表分页页
     * @return
     */
    @RequestMapping("/personCopdVisitList.do")
    public String personCopdVisitList() {
        return "publichealth/personCopdVisitList";
    }
    
    /**
     * 慢阻肺随访列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personCopdVisitDataList.jo")
    @ResponseBody
    public Map<String, Object> personCopdVisitDataList(HttpServletRequest request, PersonChronicVisitQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_COPD);
        return this.personVisitDataList(request, queryInfo);
    }
    
    /**
     * 打开肿瘤患者随访列表分页页
     * @return
     */
    @RequestMapping("/personTumVisitList.do")
    public String personTumVisitList() {
        return "publichealth/personTumVisitList";
    }
    
    /**
     * 肿瘤患者随访列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personTumVisitDataList.jo")
    @ResponseBody
    public Map<String, Object> personTumVisitDataList(HttpServletRequest request, PersonChronicVisitQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_TUM);
        return this.personVisitDataList(request, queryInfo);
    }
    
    /**
     * 打开冠心病患者随访列表分页页
     * @return
     */
    @RequestMapping("/personChdVisitList.do")
    public String personChdVisitList() {
        return "publichealth/personChdVisitList";
    }
    
    /**
     * 冠心病患者随访列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personChdVisitDataList.jo")
    @ResponseBody
    public Map<String, Object> personChdVisitDataList(HttpServletRequest request, PersonChronicVisitQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_CHD);
        return this.personVisitDataList(request, queryInfo);
    }
    
    /**
     * 打开脑卒中患者随访列表分页页
     * @return
     */
    @RequestMapping("/personCSVisitList.do")
    public String personCSVisitList() {
        return "publichealth/personCSVisitList";
    }
    
    /**
     * 脑卒中患者随访列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personCSVisitDataList.jo")
    @ResponseBody
    public Map<String, Object> personCSVisitDataList(HttpServletRequest request, PersonChronicVisitQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_CS);
        return this.personVisitDataList(request, queryInfo);
    }
    
    /**
     * 打开肺结核患者随访列表分页页
     * @return
     */
    @RequestMapping("/personPtbVisitList.do")
    public String personPtbVisitList() {
        return "publichealth/personPtbVisitList";
    }
    
    /**
     * 肺结核患者随访列表数据分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personPtbVisitDataList.jo")
    @ResponseBody
    public Map<String, Object> personPtbVisitDataList(HttpServletRequest request, PersonChronicVisitQueryInfo queryInfo) {
        queryInfo.setChronicType(Contstants.CHRONNIC_TYPE_PTB);
        return this.personVisitDataList(request, queryInfo);
    }
    
    /**
     * 查询所有慢性病列表数据
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/personVisitDataList.jo")
    @ResponseBody
    public Map<String, Object> personVisitDataList(HttpServletRequest request, PersonChronicVisitQueryInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        queryInfo.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
        
        Page page = this.personChronicVisitService.selectPersonChronicVisitList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 打开高血压登记编辑页
     * @param childDetailId
     * @return
     */
    @RequestMapping("/personVisitEdit.do")
    public String personHypRecordEdit(HttpServletRequest request, Long chronicVisitId, Long personChronicId, String view, Model model) {
        StringBuffer viewPage = new StringBuffer("publichealth/");
        if (null == chronicVisitId) {
            PersonChronicVisit editVisit = new PersonChronicVisit();
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
            SysOrg unitOrg = this.personChronicVisitService.selectAObject(SysOrg.class, userInfo.getSysOrg().getUnitOrgId());
            editVisit.setHospitalId(unitOrg.getOrgId());
            editVisit.setHospitalName(unitOrg.getName());
            editVisit.setHospitalNo(unitOrg.getOrgNo());
            editVisit.setHospitalPhone(unitOrg.getDirectorTel());
            editVisit.setVisitDoctorId(userInfo.getUserInfoId());
            editVisit.setVisitDoctorName(userInfo.getName());
            
            if (null != personChronicId) {
                PersonChronic personChronic = this.personChronicVisitService.selectAObject(PersonChronic.class, personChronicId);
                if (null != personChronic) {
                    editVisit.setPersonChronic(personChronic);
                    editVisit.setPersonChronicId(personChronicId);
                    editVisit.setPersonDetailId(personChronic.getPersonDetailId());
                }
            }
            model.addAttribute("personChronicVisit", editVisit);
            return viewPage.append(view).toString();
        }
        
        PersonChronicVisit chronicVisit = this.personChronicVisitService.selectAObject(PersonChronicVisit.class, chronicVisitId); 
        if (null == chronicVisit) {
            throw new RuntimeException("对应的慢性病患者随访记录不存在");
        }
        
        model.addAttribute("personChronicVisit", chronicVisit);
        // 慢性病患者体格检查/生活行为信息
        model.addAttribute("personVisitItem", this.personChronicVisitService.selectAObject(PersonVisitItem.class, chronicVisit.getChronicVisitId()));
       
        if (null != chronicVisit.getPersonDetailId() && StringUtils.hasText(chronicVisit.getChronicType())) {
            // 慢性病本次药物治疗信息(多条数据)
            model.addAttribute("visitDrugList",
                    this.personVisitDrugService.selectPersonVisitDrug(chronicVisit.getChronicVisitId(),
                            chronicVisit.getPersonDetailId(), chronicVisit.getChronicType()));

            // 慢性病非药物治疗信息(多个ID)
            model.addAttribute("visitChronicSymIds",
                    this.personVisitChronicSymService.selectPersonVisitChronicSymId(
                            chronicVisit.getChronicVisitId(), chronicVisit.getPersonDetailId(),
                            chronicVisit.getChronicType()));
            
            // 治疗情况
            model.addAttribute("visitCureTypes", this.personVisitCureService.selectPersonVisitCureId(chronicVisit.getChronicVisitId(), chronicVisit.getPersonDetailId(), chronicVisit.getChronicType()));
            // 报导内容
            model.addAttribute("visitContentTypes", this.personVisitContentService.selectPersonVisitContentId(chronicVisit.getChronicVisitId(), chronicVisit.getPersonDetailId(), chronicVisit.getChronicType()));
            
        }

        return viewPage.append(view).toString();
    }
    
    /**
     * 保存
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/savePersonChronicVisit.jo")
    @ResponseBody
    public JsonObj savePersonChronicVisit(HttpServletRequest request, PersonChronicVisitEditInfo info) {
        JsonObj result = new JsonObj();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        info.setCurrentUser(userInfo);
        
        if (!StringUtils.hasText(info.getChronicType())) {
            result.setMsg("保存失败，患者疾病类不能为空");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }

        this.personChronicVisitService.savePersonChronicVisit(info);
        result.setMsg("保存成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 删除慢性病患者随访（置为无效）
     * @param childDetailId
     * @return
     */
    @RequestMapping("/deletePersonChronicVisit.jo")
    @ResponseBody
    public JsonObj deletePersonChronicTpye(Long[] ids) {
        JsonObj result = new JsonObj();
        if (null == ids || ids.length <= 0) {
            result.setMsg("删除失败");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        this.personChronicVisitService.deletePersonChronicVisit(ids);
        result.setMsg("删除成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 根据主键ID删除本次用药信息
     * @param chronicDrugId
     * @return
     */
    @RequestMapping("/deletePersonVisitDrug.jo")
    @ResponseBody
    public JsonObj deletePersonVisitDrug(Long visitDrugId) {
        JsonObj result = new JsonObj();
        if (null == visitDrugId || visitDrugId.longValue() < 0) {
            result.setMsg("删除失败");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        this.personVisitDrugService.deletePersonVisitDrug(visitDrugId);
        result.setMsg("删除成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
}
