package com.bofan.mobile.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.dictionary.support.DictionarysInVelocityToolbox;
import com.bofan.gradingclinics.command.HdDiagnosisApplyEditInfo;
import com.bofan.gradingclinics.command.HdDiagnosisApplyQueryInfo;
import com.bofan.gradingclinics.controller.HdDiagnosisApplyController;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.utils.JsonObj;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-11-24
 */
@Controller
@RequestMapping("/mobile.diagnosi")
public class DiagnosisApplyController extends HdDiagnosisApplyController {

    /**
     * @see com.bofan.gradingclinics.controller.HdDiagnosisApplyController#applyDeatail(java.lang.Long)
     */
    @RequestMapping("/applyDetail.do")
    @ResponseBody
    public JsonObj applyDeatail(Long hdDiagnosisApplyId) {
        return super.applyDeatail(hdDiagnosisApplyId);
    }

    /**
     * @see com.bofan.gradingclinics.controller.HdDiagnosisApplyController#saveDiagnosisApply(com.bofan.gradingclinics.command.HdDiagnosisApplyEditInfo)
     */
    @RequestMapping("/saveDiagnosisApply.jo")
    @ResponseBody
    public JsonObj saveDiagnosisApply(HdDiagnosisApplyEditInfo info) {
        return super.saveDiagnosisApply(info);
    }
    
    /**
     * @see com.bofan.gradingclinics.controller.HdDiagnosisApplyController#saveDiagnosisApply(com.bofan.gradingclinics.command.HdDiagnosisApplyEditInfo)
     */
    @RequestMapping("/saveDiagnosisAudit.jo")
    @ResponseBody
    public JsonObj saveDiagnosisAudit(Long hdDiagnosisApplyId, String auditStatus, Long checkDoctorId,
            String checkDoctorName, String checkOpinion) {
        return super.applyAudit(hdDiagnosisApplyId, auditStatus, checkDoctorId, checkDoctorName, checkOpinion);
    }
    
    /**
     * 获取转诊审核列表数据
     * @param info
     * @return
     */
    @RequestMapping("/applyList.do")
    @ResponseBody
    public Map<String, Object> applyList(HttpServletRequest request,HdDiagnosisApplyQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            SysUserInfo sysUserInfo = (SysUserInfo)request.getSession().getAttribute( Constants.USER_KEY);
            // 转入医院的ID，根据当前登录用户的医院ID设置
            info.setInstitutionUpId(sysUserInfo.getSysOrg().getUnitOrgId());
            //info.setHdType(Contstants.DIAGNOSISAPPLY_HDTYPE_DOWN);
            //info.setTransStatus(Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_WAIT_RECEIVE);//已申请待审核状态
            Page page = this.hdDiagnosisApplyService.selectHdDiagnosisApply(info); 
            result.put("rows", page.getData());
            result.put("total", page.getTotalSize());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return result;
    }

    /**
     * @see com.bofan.gradingclinics.controller.HdDiagnosisApplyController#applyTurnInListData(javax.servlet.http.HttpServletRequest, com.bofan.gradingclinics.command.HdDiagnosisApplyQueryInfo)
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/inRecordList.do")
    @ResponseBody
    public Map<String, Object> inRecordList(HttpServletRequest request, HdDiagnosisApplyQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (info.getPageNumber() == 1L) {
            // 转诊状态字典
            Map<String, String> statusMap = (Map<String, String>)DictionarysInVelocityToolbox.getDictionary("dicTransStatus");
            result.put("dicMap", statusMap);
        }

        result.putAll(super.applyTurnInListData(request, info));
        
        return result;
    }

    /**
     * @see com.bofan.gradingclinics.controller.HdDiagnosisApplyController#applyTurnOutListData(javax.servlet.http.HttpServletRequest, com.bofan.gradingclinics.command.HdDiagnosisApplyQueryInfo)
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/outRecordList.do")
    @ResponseBody
    public Map<String, Object> applyTurnOutListData(HttpServletRequest request, HdDiagnosisApplyQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (info.getPageNumber() == 1L) {
            // 转诊状态字典
            Map<String, String> statusMap = (Map<String, String>)DictionarysInVelocityToolbox.getDictionary("dicTransStatus");
            result.put("dicMap", statusMap);
        }

        result.putAll(super.applyTurnOutListData(request, info));
        
        return result;
    }

    /**
     * @see com.bofan.gradingclinics.controller.HdDiagnosisApplyController#receivePatient(javax.servlet.http.HttpServletRequest, java.lang.String[], java.lang.String)
     */
    @RequestMapping("/receivePatient.do")
    @ResponseBody
    public JsonObj receivePatient(HttpServletRequest request, String[] ids, String transStatus) {
        return super.receivePatient(request, ids, transStatus);
    }

    /**
     * 编辑就诊报告
     * 
     * @see com.bofan.gradingclinics.controller.HdDiagnosisApplyController#diagnosisReportEdit(java.lang.Long, org.springframework.ui.Model)
     */
    @RequestMapping("/visitReportEdit.do")
    @ResponseBody
    public Map<String, Object> visitReportEdit(Long hdDiagnosisApplyId, Model model) {
        Map<String, Object> result = new HashMap<String, Object>();
        super.diagnosisReportEdit(hdDiagnosisApplyId, model);
        Map<String, Object> dataMap = model.asMap();
        result.putAll(dataMap);
        return result;
    }

    /**
     * 保存就诊报告
     * 
     * @see com.bofan.gradingclinics.controller.HdDiagnosisApplyController#saveDiagnosisReport(java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @RequestMapping("/saveVisitReport.jo")
    @ResponseBody
    public JsonObj saveVisitReport(Long hdDiagnosisApplyId, String examFinding, String examHint,
            String diagnosticOpinion, String examAdvise, String transStatus) {
        return super.saveDiagnosisReport(hdDiagnosisApplyId, examFinding, examHint, diagnosticOpinion, examAdvise, transStatus);
    }

}
