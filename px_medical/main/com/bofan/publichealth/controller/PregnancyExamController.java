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
import com.bofan.publichealth.gravida.command.GravidaHealthGuideQueryInfo;
import com.bofan.publichealth.gravida.command.PregnancyExamQueryInfo;
import com.bofan.publichealth.gravida.service.GravidaHealthGuideService;
import com.bofan.publichealth.gravida.service.PregnancyExamService;
import com.bofan.publichealth.gravida.valueobject.PregnancyExam;
import com.bofan.utils.JsonObj;
import com.manage.service.ManageService;

/**
 * @Description: 孕妇孕期检查Controller
 * @author lqw
 */
@Controller
@RequestMapping("/pregnancyExam")
public class PregnancyExamController  extends AbstractAnnotationController{
	/** logger */
    protected static Logger logger = Logger.getLogger(PregnancyExamController.class.getName());
	@Autowired
	private GravidaHealthGuideService gravidaHealthGuideService;
	@Autowired
	private PregnancyExamService pregnancyExamService;
	@Autowired
    private ManageService manageService;
	  
    /**
     * 进入孕妇基本档案列表页面
     * @return
     */
    @RequestMapping("/pregnancyExamList.do")
    public String list() {
        return "publichealth/gravida/pregnancyExamList";
    }
    
    /**
     * 获取分页列表数据
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/pregnancyExamListData.do")
    @ResponseBody
    public  Map<String, Object> listData(HttpServletRequest request,PregnancyExamQueryInfo queryInfo) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	Page page = this.pregnancyExamService.selectPregnancyExamPage(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 进入 孕妇孕期检查 编辑页面
     * @param request
     * @param gravidaDetailId
     * @param pregnancyExamId
     * @param model
     * @return
     */
    @RequestMapping("/editPregnancyExam.do") 
    public String editPregnancyExam(HttpServletRequest request, Long gravidaDetailId,Long pregnancyExamId, Model model) {
        PregnancyExam pregnancyExam = null;
        if (null != pregnancyExamId) {
            pregnancyExam = this.pregnancyExamService.findPregnancyExam(new PregnancyExamQueryInfo(gravidaDetailId));
            model.addAttribute("gravidaHealthGuideList",this.gravidaHealthGuideService.selectGravidaHealthGuideList(
                    new GravidaHealthGuideQueryInfo(null,pregnancyExamId)));//孕妇保健指导 key为HealthGuideType的 列表集合
        } else {
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY); 
            Long currenUserUnitOrgId = userInfo.getSysOrg().getUnitOrgId();
            SysOrg sysOrg = this.manageService.loadSysOrg(currenUserUnitOrgId);
            pregnancyExam = new PregnancyExam();
            pregnancyExam.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
            pregnancyExam.setHospitalName(sysOrg.getName());
            pregnancyExam.setTransDiagnosisOfficeId(userInfo.getOrgId());
            pregnancyExam.setTransDiagnosisOfficeName(userInfo.getSysOrg().getName());
            pregnancyExam.setDutyDoctorId(userInfo.getUserInfoId());
            pregnancyExam.setDutyDoctorName(userInfo.getName());
        }
        model.addAttribute("pregnancyExam",pregnancyExam); //孕妇孕期检查
        return "publichealth/gravida/pregnancyExamEdit";
    }
    
    /**
     * 保存 孕妇孕期体检
     * @param pregnancyExamRetionData
     * @return
     */
    @RequestMapping(value = "/savePregnancyExam.jo")
    @ResponseBody 
    public JsonObj savePregnancyExam(String pregnancyExamRetionData) { 
        JsonObj result = new JsonObj();
        this.pregnancyExamService.savePregnancyExam(pregnancyExamRetionData);
        return result;
    }
     
    
}
