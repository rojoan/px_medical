package com.bofan.pacs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.pacs.command.PatientExamCloudQueryInfo;
import com.bofan.pacs.service.PatientExamCloudService;
import com.bofan.utils.Contstants;

/**
 * 
 * @author xlf
 *
 */
@Controller
@RequestMapping("/systemCloud")
public class SystemCloudController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(SystemCloudController.class.getName());

    @Autowired
    private PatientExamCloudService patientExamCloudService;
    
    /**
     * 打开系统云盘列表
     * @return
     */
    @RequestMapping("/systemCloudList.do")
    public String systemCloudList(PatientExamCloudQueryInfo info) {
        return "pacs/systemCloudList";
    }
    
    /**
     * 打开影像申请列表
     * @return
     */
    @RequestMapping("/imageApplyList.do")
    public String imageApplyList(PatientExamCloudQueryInfo info) {
        return "pacs/imageApplyList";
    }
    
    /**
     * 云盘分页列表数据
     * @return
     */
    @RequestMapping("/cloudList.do")
    public @ResponseBody Map<String, Object> cloudList(HttpServletRequest request, PatientExamCloudQueryInfo info) {
        return this.list(request, info);
    }
    
    /**
     * 申请分页列表数据
     * @return
     */
    @RequestMapping("/applyList.do")
    public @ResponseBody Map<String, Object> applyList(HttpServletRequest request, PatientExamCloudQueryInfo info) {
        // 只查询未申请远程会诊及当前用户单位下的数据
        info.setDiagnosisFlag(Contstants.DIAGNOSIS_FLAG_NONE);
        
        return this.list(request, info);
    }
    
    /**
     * 查询病人检查表数据（PATIENT_EXAM）
     * @param request
     * @param info
     * @return
     */
    private Map<String, Object> list(HttpServletRequest request, PatientExamCloudQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        info.setOrgId(userInfo.getSysOrg().getUnitOrgId());
        Page page = this.patientExamCloudService.selectPatientExamCloudList(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        
        return result;
    }
}
