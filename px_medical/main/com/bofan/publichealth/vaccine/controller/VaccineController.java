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
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.vaccine.command.VaccineEditInfo;
import com.bofan.publichealth.vaccine.command.VaccineQueryInfo;
import com.bofan.publichealth.vaccine.service.VaccineService;
import com.bofan.publichealth.vaccine.valueobject.Vaccine;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.manage.service.ManageService;

/**
 * @Description: 疫苗程序表Controller
 * @author wmg
 */
@Controller
@RequestMapping("/vaccine")
public class VaccineController extends AbstractAnnotationController {
    /** logger */
    protected static Logger logger = Logger.getLogger(VaccineController.class.getName());
    @Autowired
    private VaccineService vaccineService;
    @Autowired
    private ManageService manageService;
    
    /**
     * 进入疫苗程序表列表页面
     * @return
     */
    @RequestMapping("/vaccineList.do")
    public String list() {
        return "publichealth/vaccine/vaccineList";
    }

    /**
     * 进入预防接种卡基本信息列表页面
     * 
     * @return
     */
    @RequestMapping("/vaccineSelectList.do")
    public String vaccineSelectList() {
        return "/publichealth/vaccine/vaccineSelectList";
    }

    /**
     * 获取疫苗程序表分页数据
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/vaccineListData.jo")
    @ResponseBody
    public  Map<String, Object> listData(HttpServletRequest request,VaccineQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        Page page = this.vaccineService.selectVaccinePage(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
   
    /**
     * 进入疫苗程序表新增/编辑 页面
     * @param request
     * @param vaccineId
     * @param model
     * @return
     */
    @RequestMapping("/vaccineEdit.do")
    public String vaccineEdit(HttpServletRequest request, Long vaccineId, Model model) {
        if (null != vaccineId) {
            //进入编辑修改 
            Vaccine vaccine = this.vaccineService.selectAObject(Vaccine.class, vaccineId);
            model.addAttribute("creatorName",this.manageService.loadSysUserInfo(vaccine.getCreatorId()).getName());
            model.addAttribute("vaccine", vaccine);
        }else{
            //进入新增
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
            VaccineEditInfo vaccineEditInfo = new VaccineEditInfo();
            vaccineEditInfo.setCreatorId(userInfo.getUserInfoId());

            // vaccineEditInfo.setCreatorName(userInfo.getName());
            // vaccineEditInfo.setHospitalId(unitOrg.getOrgId());
            // vaccineEditInfo.setHospitalNo(unitOrg.getOrgNo());
            // vaccineEditInfo.setHospitalName(unitOrg.getName());
            vaccineEditInfo.setCreateTime(new Date());
            model.addAttribute("creatorName",userInfo.getName());
            model.addAttribute("vaccine", vaccineEditInfo);
        }
        return "publichealth/vaccine/vaccineEdit";
    }

    /**
     * 进入疫苗程序表新增/编辑 页面
     * 
     * @param request
     * @param vaccineId
     * @param model
     * @return
     */
    @RequestMapping("/vaccineShow.do")
    public String vaccineShow(HttpServletRequest request, Long vaccineId, Model model) {
        if (null != vaccineId) {
            // 进入编辑修改
            Vaccine vaccine = this.vaccineService.selectAObject(Vaccine.class, vaccineId);
            model.addAttribute("vaccine", vaccine);
        }
        return "publichealth/vaccine/vaccineShow";

    }

    /**
     * 保存疫苗程序表信息
     * @param info 
     * @return
     */
    @RequestMapping(value = "/saveVaccine.jo")
    @ResponseBody 
    public JsonObj saveVaccine(VaccineEditInfo info) {
        JsonObj result = new JsonObj();
        result.setData(this.vaccineService.saveVaccine(info));
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
   /**
    * 删除疫苗程序表
    * @param vaccineId 删除对象的ID
    * @return
    */
    @RequestMapping(value = "/delVaccine.jo")
    @ResponseBody 
    public JsonObj delVaccine(Long vaccineId) {
        JsonObj result = new JsonObj();
        Vaccine vaccine =  this.vaccineService.selectAObject(Vaccine.class, vaccineId);
        this.vaccineService.deleteAObject(vaccine);
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }

}
