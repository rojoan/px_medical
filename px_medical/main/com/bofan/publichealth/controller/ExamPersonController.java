package com.bofan.publichealth.controller;

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
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.command.ExamPersonEditInfo;
import com.bofan.publichealth.command.ExamPersonQueryInfo;
import com.bofan.publichealth.service.ExamElderService;
import com.bofan.publichealth.service.ExamHealthProblemService;
import com.bofan.publichealth.service.ExamInHospitalService;
import com.bofan.publichealth.service.ExamLiveWayService;
import com.bofan.publichealth.service.ExamOrganBodyService;
import com.bofan.publichealth.service.ExamPersonService;
import com.bofan.publichealth.service.ExamPersonalDrugService;
import com.bofan.publichealth.service.ExamPersonalNovacService;
import com.bofan.publichealth.service.ExamSymptomService;
import com.bofan.publichealth.valueobject.ExamElder;
import com.bofan.publichealth.valueobject.ExamHealthProblem;
import com.bofan.publichealth.valueobject.ExamInHospital;
import com.bofan.publichealth.valueobject.ExamLiveWay;
import com.bofan.publichealth.valueobject.ExamOrganBody;
import com.bofan.publichealth.valueobject.ExamPerson;
import com.bofan.publichealth.valueobject.ExamPersonalDrug;
import com.bofan.publichealth.valueobject.ExamPersonalNovac;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;

/**
 * 居民健康体检控制器
 * @Description
 * @author xlf 
 * 2017-10-26
 */
@Controller
@RequestMapping("/examPerson")
public class ExamPersonController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(ExamPersonController.class.getName());
    
    @Autowired
    private ExamElderService examElderService;
    @Autowired
    private ExamPersonService examPersonService;
    @Autowired
    private ExamSymptomService examSymptomService;
    @Autowired
    private ExamLiveWayService examLiveWayService;
    @Autowired
    private ExamOrganBodyService examOrganBodyService;
    @Autowired
    private ExamInHospitalService examInHospitalService;
    @Autowired
    private ExamHealthProblemService examHealthProblemService;
    @Autowired
    private ExamPersonalDrugService examPersonalDrugService;
    @Autowired
    private ExamPersonalNovacService examPersonalNovacService;
    
    /**
     * 进入居民健康体检主页面
     * @return
     */
    @RequestMapping("/main.do")
    public String main() {
        return "publichealth/examPersonList";
    }
    
    /**
     * 居民健康体检信息列表
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/examPersonList.do")
    @ResponseBody
    public Map<String, Object> examPersonList(HttpServletRequest request, ExamPersonQueryInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        // 查询有效的健康体检信息
        queryInfo.setValidFlag(Contstants.YES_FLAG);
        queryInfo.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
        
        Page page = this.examPersonService.selectExamPersonList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 编辑居民健康体检信息
     * @param examPersonId
     * @param mode 标识是查看还是编辑动作（show表示查看，其他表示编辑）
     * @param model
     * @return
     */
    @RequestMapping("/editExamPerson.do")
    public String editExamPerson(Long examPersonId, String mode, Model model) {
        String view = "publichealth/examPersonEdit";
        if (null == examPersonId || examPersonId.intValue() <=0) {
            return view;
        }
        
        ExamPerson examPerson = this.examPersonService.selectAObject(ExamPerson.class, examPersonId);
        if (null == examPerson) {
            return view;
        }
        
        // 症状ID集合
        List<Long> sxamSymptomIds = this.examSymptomService.selectExamSymptomId(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
        // 老年人体检信息
        ExamElder examElder = this.examElderService.selectExamElder(examPerson.getExamPersonId());
        // 生活方式信息
        ExamLiveWay liveWay = this.examLiveWayService.selectExamLiveWay(examPerson.getExamPersonId());
        // 饮食习惯ID集合
        List<Long> dietaryIds = this.examLiveWayService.selectLiveWayDietaryIds(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
        // 饮酒习惯ID集合
        List<Long> drinkIds = this.examLiveWayService.selectLiveWayDrinkIds(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
        // 查体信息
        ExamOrganBody organBody = this.examOrganBodyService.selectExamOrganBody(examPerson.getExamPersonId());
        // 健康问题信息
        ExamHealthProblem healthProblem = this.examHealthProblemService.selectAObject(ExamHealthProblem.class, examPerson.getExamPersonId());
        // 健康疾病ID集合
        List<Long> diseaseIds = this.examHealthProblemService.selectPersonDiseaseIds(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
        // 健康异常信息集合
        List<String> healthAssessList = this.examHealthProblemService.selectHealthAssessContent(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
        // 健康指导类型ID集合
        List<Long> guideIds = this.examHealthProblemService.selectHealthGuideIds(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
        // 健康危险控制因素ID集合
        List<Long> dangerIds = this.examHealthProblemService.selectHealthDangerIds(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
        // 个人用药信息集合
        List<ExamPersonalDrug> drugList = this.examPersonalDrugService.selectPersonalDrug(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
        // 非免疫规划预防接种史信息集合
        List<ExamPersonalNovac> novacList = this.examPersonalNovacService.selectPersonalNovac(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
        // 住院情况息集合
        List<ExamInHospital> inHosList = this.examInHospitalService.selectInHospital(examPerson.getExamPersonId(), examPerson.getPersonDetailId());
        if (null != organBody && !Tools.isEmptyString(organBody.getBreast())) {
            // 必须用英文逗号分隔，且必须转为集合传到页面，以方便页面判断是否勾选
            String[] items  = organBody.getBreast().split(",");
            model.addAttribute("breast", java.util.Arrays.asList(items));
        }
        if (null != organBody && !Tools.isEmptyString(organBody.getDorsalArteryBeats())) {
            // 必须用英文逗号分隔，且必须转为集合传到页面，以方便页面判断是否勾选
            String[] items  = organBody.getDorsalArteryBeats().split(",");
            model.addAttribute("dorsalArteryBeats", java.util.Arrays.asList(items));
        }
        
        model.addAttribute("mode", mode);
        model.addAttribute("liveWay", liveWay);
        model.addAttribute("drinkIds", drinkIds);
        model.addAttribute("guideIds", guideIds);
        model.addAttribute("drugList", drugList);
        model.addAttribute("dangerIds", dangerIds);
        model.addAttribute("organBody", organBody);
        model.addAttribute("examElder", examElder);
        model.addAttribute("novacList", novacList);
        model.addAttribute("inHosList", inHosList);
        model.addAttribute("diseaseIds", diseaseIds);
        model.addAttribute("dietaryIds", dietaryIds);
        model.addAttribute("examPerson", examPerson);
        model.addAttribute("healthProblem", healthProblem);
        model.addAttribute("sxamSymptomIds", sxamSymptomIds);
        model.addAttribute("healthAssessList", healthAssessList);
        
        return view;
    }
    
    /**
     * 保存居民健康体检信息
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/saveExamPerson.do")
    public @ResponseBody JsonObj saveExamPerson(HttpServletRequest request, ExamPersonEditInfo info) {
        JsonObj result = new JsonObj();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        info.setCurrentUser(userInfo);
        this.examPersonService.saveExamPerson(info);
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        result.setMsg("保存成功");
        return result;
    }

    /**
     * 删除居民健康体检
     * @param ids
     * @return
     */
    @RequestMapping("/deleteExamPerson.do")
    public @ResponseBody JsonObj deleteExamPerson(Long[] ids) {
        JsonObj result = new JsonObj();
    	if (null != ids && ids.length > 0) {
    	    this.examPersonService.deleteExamPerson(ids);
    	    result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
    	    result.setMsg("删除成功");
    	} else {
    	    result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            result.setMsg("删除失败");
    	}
        return result;
    }
    
    /**
     * 根据主键删除个人用药情况
     * @param Long
     * @return
     */
    @RequestMapping("/deletePersonDrug.do")
    public @ResponseBody JsonObj deletePersonDrug(Long personDrugId) {
        JsonObj result = new JsonObj();
    	if (null != personDrugId) {
    		this.examPersonalDrugService.deletePersonalDrug(personDrugId);
    		result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
    		result.setMsg("删除成功");
    	} else {
    	    result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
            result.setMsg("删除失败");
    	}
        return result;
    }
    
    /**
     * 根据主键删除居民体检--住院情况
     * @param Long
     * @return
     */
    @RequestMapping("/deleteInHospital.do")
    public @ResponseBody JsonObj deleteInHospital(Long inHospitalId) {
        JsonObj result = new JsonObj();
        if (null != inHospitalId) {
            this.examInHospitalService.deleteInHospital(inHospitalId);
            result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
            result.setMsg("删除成功");
        } else {
            result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
            result.setMsg("删除失败");
        }
        return result;
    }
    
    /**
     * 根据主键删除居民体检--非免疫规划预防接种史
     * @param Long
     * @return
     */
    @RequestMapping("/deletePersonNovac.do")
    public @ResponseBody JsonObj deletePersonNovac(Long personNovacId) {
        JsonObj result = new JsonObj();
        if (null != personNovacId) {
            this.examPersonalNovacService.deletePersonNovac(personNovacId);
            result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
            result.setMsg("删除成功");
        } else {
            result.setMsg("删除失败");
        }
        return result;
    }
}
