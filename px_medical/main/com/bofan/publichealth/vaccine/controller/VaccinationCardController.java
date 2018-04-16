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
import com.bofan.publichealth.vaccine.command.VaccinationCardEditInfo;
import com.bofan.publichealth.vaccine.command.VaccinationCardQueryInfo;
import com.bofan.publichealth.vaccine.service.VaccinationCardService;
import com.bofan.publichealth.vaccine.valueobject.VaccinationCard;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.manage.service.ManageService;

/**
 * @Description: 预防接种卡基本信息Controller
 * @author wmg
 */
@Controller
@RequestMapping("/vaccinationCard")
public class VaccinationCardController  extends AbstractAnnotationController{
    /** logger */
    protected static Logger logger = Logger.getLogger(VaccinationCardController.class.getName());
    @Autowired
    private VaccinationCardService vaccinationCardService;
    @Autowired
    private ManageService manageService;
    
    /**
     * 进入预防接种卡基本信息列表页面
     * @return
     */
    @RequestMapping("/vaccinationCardList.do")
    public String vaccinationCardList() {
        return "/publichealth/vaccine/vaccinationCardList";
    }

    /**
     * 进入预防接种卡基本信息列表页面
     * 
     * @return
     */
    @RequestMapping("/vaccinationCardSelectList.do")
    public String vaccinationCardSelectList() {
        return "/publichealth/vaccine/vaccinationCardSelectList";
    }

    /**
     * 打开选泽儿童/新生儿信息页
     * 
     * @param childDetailId
     * @return
     */
    @RequestMapping("/selectCommonChildDetail.do")
    public String selectCommonChildDetail(Long childDetailId, Model model) {
        return "publichealth/select/selectCommonChildDetail";
    }

    /**
     * 获取预防接种卡基本信息分页数据
     * 
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/vaccinationCardListData.jo")
    @ResponseBody
    public  Map<String, Object> vaccinationCardListData(HttpServletRequest request,VaccinationCardQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        Page page = this.vaccinationCardService.selectVaccinationCardPage(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
   
    /**
     * 进入预防接种卡基本信息新增/编辑 页面
     * @param request
     * @param vaccinationCardId
     * @param model
     * @return
     */
    @RequestMapping("/vaccinationCardEdit.do")
    public String vaccinationCardEdit(HttpServletRequest request,Long vaccinationCardId, Model model) {
        if (null != vaccinationCardId) {
            //进入编辑修改 
            VaccinationCard vaccinationCard = this.vaccinationCardService.selectAObject(VaccinationCard.class, vaccinationCardId);
            model.addAttribute("creatorName",this.manageService.loadSysUserInfo(vaccinationCard.getCreatorId()).getName());
            model.addAttribute("vaccinationCard",vaccinationCard);
        }else{
            //进入新增
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
            VaccinationCardEditInfo vaccinationCardEditInfo = new VaccinationCardEditInfo();
            vaccinationCardEditInfo.setCreatorId(userInfo.getUserInfoId());
            SysOrg unitOrg = this.manageService.loadSysOrg(userInfo.getSysOrg().getUnitOrgId());
            vaccinationCardEditInfo.setCreatorId(userInfo.getUserInfoId());
            vaccinationCardEditInfo.setCreatorName(userInfo.getName());
            vaccinationCardEditInfo.setHospitalId(unitOrg.getOrgId());
            vaccinationCardEditInfo.setHospitalNo(unitOrg.getOrgNo());
            vaccinationCardEditInfo.setHospitalName(unitOrg.getName());
            model.addAttribute("vaccinationCard", vaccinationCardEditInfo);

        }
        return "/publichealth/vaccine/vaccinationCardEdit";
    }

    /**
     * 进入疫苗程序表详情展示页面
     * @param request
     * @param vaccinationCardId
     * @param model
     * @return
     */
    @RequestMapping("/vaccinationCardShow.do")
    public String vaccinationCardShow(HttpServletRequest request, Long vaccinationCardId, Model model) {
        if (null != vaccinationCardId) {
            // 进入编辑修改
            VaccinationCard vaccinationCard = this.vaccinationCardService.selectAObject(VaccinationCard.class, vaccinationCardId);
            model.addAttribute("vaccinationCard", vaccinationCard);
        }
        return "/publichealth/vaccine/vaccinationCardShow";

    }

    /**
     * 保存预防接种卡基本信息信息
     * @param info 
     * @return
     */
    @RequestMapping(value = "/saveVaccinationCard.jo")
    @ResponseBody 
    public JsonObj saveVaccinationCard(VaccinationCardEditInfo info) {
        JsonObj result = new JsonObj();
        result.setData(this.vaccinationCardService.saveVaccinationCard(info));
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
   /**
    * 删除预防接种卡基本信息
    * @param vaccinationCardId 删除对象的ID
    * @return
    */
    @RequestMapping(value = "/delVaccinationCard.jo")
    @ResponseBody 
    public JsonObj delVaccinationCard(Long vaccinationCardId) {
        JsonObj result = new JsonObj();
        VaccinationCard vaccinationCard =  this.vaccinationCardService.selectAObject(VaccinationCard.class, vaccinationCardId);
        this.vaccinationCardService.deleteAObject(vaccinationCard);
        return result;
    }

}
