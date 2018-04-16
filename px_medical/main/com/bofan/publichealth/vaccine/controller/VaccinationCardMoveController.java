package com.bofan.publichealth.vaccine.controller;

import java.util.Date;
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
import com.bofan.basesystem.common.controller.AbstractAnnotationController;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.vaccine.command.VaccinationCardMoveEditInfo;
import com.bofan.publichealth.vaccine.command.VaccinationCardMoveQueryInfo;
import com.bofan.publichealth.vaccine.service.VaccinationCardMoveService;
import com.bofan.publichealth.vaccine.valueobject.VaccinationCardMove;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;
import com.manage.service.ManageService;

/**
 * @Description: 疫苗接种证调动记录表Controller
 * @author wmg
 */
@Controller
@RequestMapping("/vaccinationCardMove")
public class VaccinationCardMoveController  extends AbstractAnnotationController{
    /** logger */
    protected static Logger logger = Logger.getLogger(VaccinationCardMoveController.class.getName());
    @Autowired
    private VaccinationCardMoveService vaccinationCardMoveService;
    @Autowired
    private ManageService manageService;
    
    /**
     * 进入疫苗接种证调动记录表列表页面
     * @return
     */
    @RequestMapping("/vaccinationCardMoveList.do")
    public String vaccinationCardMoveList() {
        return "/publichealth/vaccine/vaccinationCardMoveList";
    }
    
    /**
     * 获取疫苗接种证调动记录表分页数据
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/vaccinationCardMoveListData.jo")
    @ResponseBody
    public  Map<String, Object> vaccinationCardMoveListData(HttpServletRequest request,VaccinationCardMoveQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        Page page = this.vaccinationCardMoveService.selectVaccinationCardMovePage(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
   
    /**
     * 进入疫苗接种证调动记录表新增/编辑 页面
     * 
     * @param request
     * @param cardMoveId
     * @param model
     * @return // TODO 加vaccinationCardMoveEditInfo
     */
    @RequestMapping("/vaccinationCardMoveEdit.do")
    public String vaccinationCardMoveEdit(HttpServletRequest request,Long cardMoveId, Model model) {
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        SysOrg unitOrg = this.manageService.loadSysOrg(userInfo.getSysOrg().getUnitOrgId());
        if (null != cardMoveId) {
            //进入编辑修改 
            VaccinationCardMove vaccinationCardMove = this.vaccinationCardMoveService.selectAObject(VaccinationCardMove.class, cardMoveId);
            model.addAttribute("creatorName",this.manageService.loadSysUserInfo(vaccinationCardMove.getCreatorId()).getName());
            model.addAttribute("vaccinationCardMove",vaccinationCardMove);
        }else{
            //进入新增
            VaccinationCardMoveEditInfo vaccinationCardMoveEditInfo = new VaccinationCardMoveEditInfo();
            vaccinationCardMoveEditInfo.setCreatorId(userInfo.getUserInfoId());
            vaccinationCardMoveEditInfo.setCreateTime(new Date());
            vaccinationCardMoveEditInfo.setMoveTime(new Date());
            vaccinationCardMoveEditInfo.setProposerId(userInfo.getUserInfoId());
            vaccinationCardMoveEditInfo.setProposerName(userInfo.getName());
            vaccinationCardMoveEditInfo.setHandleDoctorId(userInfo.getUserInfoId());
            vaccinationCardMoveEditInfo.setHandleDoctor(userInfo.getName());

            model.addAttribute("hospitalId", unitOrg.getOrgId());
            model.addAttribute("hospitalName", unitOrg.getName());
            model.addAttribute("creatorName",userInfo.getName());
            model.addAttribute("vaccinationCardMove",vaccinationCardMoveEditInfo);
        }
        model.addAttribute("hospitalMap", this.changUnitListToMapExclude(this.manageService.selectUnit(null, true),
                userInfo.getSysOrg().getUnitOrgId())); // 转入医院列表
        return "/publichealth/vaccine/vaccinationCardMoveEdit";
    }

    /**
     * 进入疫苗程序表详情展示页面
     * @param request
     * @param cardMoveId
     * @param model
     * @return
     */
    @RequestMapping("/vaccinationCardMoveShow.do")
    public String vaccinationCardMoveShow(HttpServletRequest request, Long cardMoveId, Model model) {
        if (null != cardMoveId) {
            // 进入编辑修改
            VaccinationCardMove vaccinationCardMove = this.vaccinationCardMoveService.selectAObject(VaccinationCardMove.class, cardMoveId);
            model.addAttribute("vaccinationCardMove", vaccinationCardMove);
        }
        return "/publichealth/vaccine/vaccinationCardMoveShow";

    }

    /**
     * 保存疫苗接种证调动记录表信息
     * @param info 
     * @return
     */
    @RequestMapping(value = "/saveVaccinationCardMove.jo")
    @ResponseBody 
    public JsonObj saveVaccinationCardMove(VaccinationCardMoveEditInfo info) {
        JsonObj result = new JsonObj();
        result.setData(this.vaccinationCardMoveService.saveVaccinationCardMove(info));
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
   /**
    * 删除疫苗接种证调动记录表
    * @param cardMoveId 删除对象的ID
    * @return
    */
    @RequestMapping(value = "/delVaccinationCardMove.jo")
    @ResponseBody 
    public JsonObj delVaccinationCardMove(Long cardMoveId) {
        JsonObj result = new JsonObj();
        VaccinationCardMove vaccinationCardMove =  this.vaccinationCardMoveService.selectAObject(VaccinationCardMove.class, cardMoveId);
        this.vaccinationCardMoveService.deleteAObject(vaccinationCardMove);
        return result;
    }

    /**
     * 将医院list转成Map ，排除不需要的医院
     * 
     * @param unitList
     * @param unitOrgId
     *            排除不需要的医院的Id
     * @return
     */
    public Map<Object, Object> changUnitListToMapExclude(List<SysOrg> unitList, Long unitOrgId) {
        Map<Object, Object> unitMap = new HashMap<Object, Object>();
        if (Tools.isNotEmptyList(unitList)) {
            for (SysOrg sysOrg : unitList) {
                // if (unitOrgId.longValue() == sysOrg.getOrgId().longValue()) {
                // continue;
                // }
                unitMap.put(sysOrg.getOrgId(), sysOrg.getName());
            }
        }
        return unitMap;
    }
}
