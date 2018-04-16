package com.bofan.publichealth.vaccine.controller;

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
import com.bofan.publichealth.vaccine.command.VaccinationDetailEditInfo;
import com.bofan.publichealth.vaccine.command.VaccinationDetailQueryInfo;
import com.bofan.publichealth.vaccine.service.VaccinationDetailService;
import com.bofan.publichealth.vaccine.valueobject.VaccinationDetail;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.manage.service.ManageService;

/**
 * @Description: 预防接种明细Controller
 * @author wmg
 */
@Controller
@RequestMapping("/vaccinationDetail")
public class VaccinationDetailController  extends AbstractAnnotationController{
    /** logger */
    protected static Logger logger = Logger.getLogger(VaccinationDetailController.class.getName());
    @Autowired
    private VaccinationDetailService vaccinationDetailService;
    @Autowired
    private ManageService manageService;
    
    /**
     * 进入预防接种明细列表页面
     * @return
     */
    @RequestMapping("/vaccinationDetailList.do")
    public String vaccinationDetailList() {
        return "/publichealth/vaccine/vaccinationDetailList";
    }
    
    /**
     * 获取预防接种明细分页数据
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/vaccinationDetailListData.jo")
    @ResponseBody
    public  Map<String, Object> vaccinationDetailListData(HttpServletRequest request,VaccinationDetailQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        Page page = this.vaccinationDetailService.selectVaccinationDetailPage(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
   
    /**
     * 进入预防接种明细新增/编辑 页面
     * @param request
     * @param vaccinationDetailId
     * @param model
     * @return
     */
    @RequestMapping("/vaccinationDetailEdit.do")
    public String vaccinationDetailEdit(HttpServletRequest request,Long vaccinationDetailId, Model model) {
        if (null != vaccinationDetailId) {
            //进入编辑修改 
            VaccinationDetail vaccinationDetail = this.vaccinationDetailService.selectAObject(VaccinationDetail.class, vaccinationDetailId);
            model.addAttribute("vaccinationDetail",vaccinationDetail);
        }else{
            //进入新增
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
            VaccinationDetailEditInfo vaccinationDetailEditInfo = new VaccinationDetailEditInfo();
            vaccinationDetailEditInfo.setVaccinationDoctorId(userInfo.getUserInfoId());
            vaccinationDetailEditInfo.setVaccinationDoctor(userInfo.getName());
            SysOrg unitOrg = this.manageService.loadSysOrg(userInfo.getSysOrg().getUnitOrgId());
            vaccinationDetailEditInfo.setHospitalId(unitOrg.getOrgId());
            vaccinationDetailEditInfo.setHospitalNo(unitOrg.getOrgNo());
            vaccinationDetailEditInfo.setHospitalName(unitOrg.getName());
            model.addAttribute("creatorName",userInfo.getName());
            model.addAttribute("vaccinationDetail",vaccinationDetailEditInfo);
        }
        return "/publichealth/vaccine/vaccinationDetailEdit";
    }
    
    /**
     * 进入预防接种卡基本信息列表页面
     * 
     * @return
     */
    @RequestMapping("/vaccinationDetailSelectList.do")
    public String vaccinationDetailSelectList() {
        return "/publichealth/vaccine/vaccinationDetailSelectList";
    }

    /**
     * 进入疫苗程序表详情展示页面
     * 
     * @param request
     * @param vaccinationDetailId
     * @param model
     * @return
     */
    @RequestMapping("/vaccinationDetailShow.do")
    public String vaccinationDetailShow(HttpServletRequest request, Long vaccinationDetailId, Model model) {
        if (null != vaccinationDetailId) {
            // 进入编辑修改
            VaccinationDetail vaccinationDetail = this.vaccinationDetailService.selectAObject(VaccinationDetail.class, vaccinationDetailId);
            model.addAttribute("vaccinationDetail", vaccinationDetail);
        }
        return "/publichealth/vaccine/vaccinationDetailShow";

    }

    /**
     * 保存预防接种明细信息
     * @param info 
     * @return
     */
    @RequestMapping(value = "/saveVaccinationDetail.jo")
    @ResponseBody 
    public JsonObj saveVaccinationDetail(VaccinationDetailEditInfo info) {
        JsonObj result = new JsonObj();
        result.setData(this.vaccinationDetailService.saveVaccinationDetail(info));
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
   /**
    * 删除预防接种明细
    * @param vaccinationDetailId 删除对象的ID
    * @return
    */
    @RequestMapping(value = "/delVaccinationDetail.jo")
    @ResponseBody 
    public JsonObj delVaccinationDetail(Long vaccinationDetailId) {
        JsonObj result = new JsonObj();
        VaccinationDetail vaccinationDetail =  this.vaccinationDetailService.selectAObject(VaccinationDetail.class, vaccinationDetailId);
        this.vaccinationDetailService.deleteAObject(vaccinationDetail);
        return result;
    }

}
