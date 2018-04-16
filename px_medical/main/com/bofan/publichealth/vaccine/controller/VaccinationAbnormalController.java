package com.bofan.publichealth.vaccine.controller;

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
import com.bofan.publichealth.vaccine.command.VaccinationAbnormalEditInfo;
import com.bofan.publichealth.vaccine.command.VaccinationAbnormalQueryInfo;
import com.bofan.publichealth.vaccine.service.VaccinationAbnormalService;
import com.bofan.publichealth.vaccine.valueobject.VaccinationAbnormal;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.manage.service.ManageService;

/**
 * @Description: 预防接种异常表Controller
 * @author wmg
 */
@Controller
@RequestMapping("/vaccinationAbnormal")
public class VaccinationAbnormalController  extends AbstractAnnotationController{
    /** logger */
    protected static Logger logger = Logger.getLogger(VaccinationAbnormalController.class.getName());
    @Autowired
    private VaccinationAbnormalService vaccinationAbnormalService;
    @Autowired
    private ManageService manageService;
    
    /**
     * 进入预防接种异常表列表页面
     * @return
     */
    @RequestMapping("/vaccinationAbnormalList.do")
    public String vaccinationAbnormalList() {
        return "/publichealth/vaccine/vaccinationAbnormalList";
    }
    
    /**
     * 获取预防接种异常表分页数据
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/vaccinationAbnormalListData.jo")
    @ResponseBody
    public  Map<String, Object> vaccinationAbnormalListData(HttpServletRequest request,VaccinationAbnormalQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        Page page = this.vaccinationAbnormalService.selectVaccinationAbnormalPage(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
   
    /**
     * 进入预防接种异常表新增/编辑 页面
     * @param request
     * @param vaccinationDetailId
     * @param model
     * @return
     */
    @RequestMapping("/vaccinationAbnormalEdit.do")
    public String vaccinationAbnormalEdit(HttpServletRequest request,Long vaccinationDetailId, Model model) {
        if (null != vaccinationDetailId) {
            //进入编辑修改 
            VaccinationAbnormal vaccinationAbnormal = this.vaccinationAbnormalService.selectAObject(VaccinationAbnormal.class, vaccinationDetailId);
            model.addAttribute("vaccinationAbnormal",vaccinationAbnormal);
        }else{
            //进入新增
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
            VaccinationAbnormalEditInfo vaccinationAbnormalEditInfo = new VaccinationAbnormalEditInfo();
            vaccinationAbnormalEditInfo.setReportDoctorId(userInfo.getUserInfoId());
            vaccinationAbnormalEditInfo.setReportDoctor(userInfo.getName());
            model.addAttribute("vaccinationAbnormal",vaccinationAbnormalEditInfo);

            SysOrg unitOrg = this.manageService.loadSysOrg(userInfo.getSysOrg().getUnitOrgId());
            // vaccinationAbnormalEditInfo.setHospitalId(unitOrg.getOrgId());
            // vaccinationAbnormalEditInfo.setHospitalNo(unitOrg.getOrgNo());
            // vaccinationAbnormalEditInfo.setHospitalName(unitOrg.getName());
            vaccinationAbnormalEditInfo.setClinicHospital(unitOrg.getName());
            vaccinationAbnormalEditInfo.setClinicTime(new Date());
            model.addAttribute("vaccinationCard", vaccinationAbnormalEditInfo);
        }
        return "/publichealth/vaccine/vaccinationAbnormalEdit";
    }

    /**
     * 进入疫苗程序表详情展示页面
     * @param request
     * @param vaccinationDetailId
     * @param model
     * @return
     */
    @RequestMapping("/vaccinationAbnormalShow.do")
    public String vaccinationAbnormalShow(HttpServletRequest request, Long vaccinationDetailId, Model model) {
        if (null != vaccinationDetailId) {
            // 进入编辑修改
            VaccinationAbnormal vaccinationAbnormal = this.vaccinationAbnormalService.selectAObject(VaccinationAbnormal.class, vaccinationDetailId);
            model.addAttribute("vaccinationAbnormal", vaccinationAbnormal);
        }
        return "/publichealth/vaccine/vaccinationAbnormalShow";

    }

    /**
     * 保存预防接种异常表信息
     * @param info 
     * @return
     */
    @RequestMapping(value = "/saveVaccinationAbnormal.jo")
    @ResponseBody 
    public JsonObj saveVaccinationAbnormal(VaccinationAbnormalEditInfo info) {
        JsonObj result = new JsonObj();
        result.setData(this.vaccinationAbnormalService.saveVaccinationAbnormal(info));
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
   /**
    * 删除预防接种异常表
    * @param vaccinationDetailId 删除对象的ID
    * @return
    */
    @RequestMapping(value = "/delVaccinationAbnormal.jo")
    @ResponseBody 
    public JsonObj delVaccinationAbnormal(Long vaccinationDetailId) {
        JsonObj result = new JsonObj();
        VaccinationAbnormal vaccinationAbnormal =  this.vaccinationAbnormalService.selectAObject(VaccinationAbnormal.class, vaccinationDetailId);
        this.vaccinationAbnormalService.deleteAObject(vaccinationAbnormal);
        return result;
    }

}
