package com.bofan.reconsult.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.dictionary.support.DictionarysInVelocityToolbox;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.reconsult.valueobject.ReProfessor;
import com.manage.service.ManageService;

@Controller
@RequestMapping("/consult")
public class ConsultMainController {
    
    // @Autowired
    // private HisBaseDataService hisBaseDataService;
    
    @Autowired
    private ManageService manageService;
    
    //@Autowired
    //private ReProfessorService reProfessorService;
    
    /**
     * 
     * @return
     */
    @RequestMapping("/main.do")
    public String main() {
        
        return "reconsulting/index";
        
    }
    
    /**
     * 打开工作站
     * @return
     */
    @RequestMapping("/applyWorkSpace.do")
    public String applyWorkSpace(HttpServletRequest request, String tabIndex, Model model) {
        
        /**
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        
        model.addAttribute("doctorList", this.hisBaseDataService.selectHisDoctorList(userInfo.getSysOrg().getUnitOrgId()));
        model.addAttribute("officeList", this.hisBaseDataService.selectHisOfficeList(userInfo.getSysOrg().getUnitOrgId()));
        model.addAttribute("hospitalList", this.hisBaseDataService.selectHisMedicalInstitutionList(null));
        model.addAttribute("professorList", reProfessorService.selectReProfessorList(null));
        */
        // 用于页面标识页面显示那个选项卡 (1:检查登记；2：已申请；3：诊断中；4：已完成)
        model.addAttribute("tabIndex", tabIndex);
        return "reconsulting/applyWorkSpace";
    }
    
    /**
     * 打开我的会诊
     * @return
     */
    @RequestMapping("/remoteConsultList.do")
    public String remoteConsultList(Model model) {
        model.addAttribute("hospitalList", this.manageService.selectUnit(null, true));
        return "reconsulting/remoteConsultList";
    }

    /**
     * 打开我专家设置
     * @return
     */
    @RequestMapping("/setProfessor.do")
    public String setProfessor(Model model) {
        return "reconsulting/setProfessor";
    }
    
    /**
     * 打开申请审核列表页
     * @return
     */
    @RequestMapping("/applyAuditList.do")
    public String applyAuditList() {
        return "reconsulting/applyAuditList";
    }
    
    /**
     * 获取专家信息
     * @param request
     * @param unitId
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/getProfessorUserInfo.do")
    public @ResponseBody Map<String, Object> getUserInfo(HttpServletRequest request, Long userInfoId) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (null == userInfoId) {
            return result;
        }
        
        ReProfessor professor = this.manageService.selectAObject(ReProfessor.class, userInfoId);
        if (null != professor) {
            result.put("validFlag", professor.getValidFlag());
            result.put("doctorGoodat", professor.getDoctorGoodat());
        }
        
        SysUserInfo userInfo = this.manageService.selectUserInfo(userInfoId);
        if (null != userInfo) {
            Map<String, String> unitMap = (Map<String, String>)DictionarysInVelocityToolbox.getDictionary("dicSysOrgUnitIdName");
            result.put("name", userInfo.getName());
            result.put("sex", userInfo.getSex());
            result.put("phone", userInfo.getPhone());
            result.put("userInfoId", userInfo.getUserInfoId());
            result.put("orgName", userInfo.getSysOrg().getName());
            result.put("unitOrgId", userInfo.getSysOrg().getUnitOrgId());
            result.put("unitName", unitMap.get(userInfo.getSysOrg().getUnitOrgId() + ""));
            if (null != userInfo.getSysDuty()) {
                result.put("dutyName", userInfo.getSysDuty().getName());
            }
            
            
        }
        return result;
    }

}
