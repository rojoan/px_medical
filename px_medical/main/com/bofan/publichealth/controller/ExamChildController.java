package com.bofan.publichealth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.command.ExamChildEditInfo;
import com.bofan.publichealth.command.ExamChildQueryInfo;
import com.bofan.publichealth.service.ExamChildService;
import com.bofan.publichealth.valueobject.ExamChild;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;

/**
 * 儿童体检(检查)控制器
 * @Description
 * @author xlf 
 * 2017-10-26
 */
@Controller
@RequestMapping("/examChild")
public class ExamChildController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(ExamChildController.class.getName());
    
    @Autowired
    private ExamChildService examChildService;

    /**
     * 
     * @return
     */
    @RequestMapping("/examChildList.do")
    public String childVisitRegister() {
        return "publichealth/examChildList";
    }
    
    /**
     * 分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/examChildDataList.jo")
    @ResponseBody
    public Map<String, Object> childDetailList(HttpServletRequest request, ExamChildQueryInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        queryInfo.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
        
        Page page = this.examChildService.selectExamChildList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 打开1岁以内儿童健康检查编辑页
     * @param childDetailId
     * @return
     */
    @RequestMapping("/examChildEdit.do")
    public String examChildEdit(HttpServletRequest request, Long examChildId, String view, Model model) {
        StringBuffer viewPage = new StringBuffer("publichealth/");
        if (null != examChildId) {
            ExamChild examChild = this.examChildService.selectAObject(ExamChild.class, examChildId); 
            model.addAttribute("examChild", examChild);
        }
        
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        if (null != userInfo && null != userInfo.getSysOrg() && null != userInfo.getSysOrg().getUnitOrgId()) {
            model.addAttribute("currentUnit", this.examChildService.selectAObject(SysOrg.class, userInfo.getSysOrg().getUnitOrgId()));
        }
        
        return viewPage.append(view).toString();
    }
    
    /**
     * 保存
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/saveExamChild.jo")
    @ResponseBody
    public Map<String, Object> saveExamChild(HttpServletRequest request, ExamChildEditInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        info.setCurrentUser(userInfo);

        // 检验体检编号是否已存在
        if (StringUtils.hasText(info.getExamBillNo())) {
            ExamChildQueryInfo queryInfo = new ExamChildQueryInfo();
            queryInfo.setExamBillNo(info.getExamBillNo());
            Page page = this.examChildService.selectExamChildList(queryInfo);
            if (null != page && null != page.getData() && page.getData().size() > 0) {
                result.put("msg", "体检编号已经存在");
                result.put("isSuccess", ResponseContstants.RESULT_FAIL_CODE);
            }
        }
        
        this.examChildService.saveExamChild(info);
        result.put("msg", "成功");
        result.put("isSuccess", ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/deleteExamChild.jo")
    @ResponseBody
    public JsonObj deleteExamChild(Long[] ids) {
        JsonObj result = new JsonObj();
        if (null == ids || ids.length <= 0) {
            result.setMsg("删除失败");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        this.examChildService.deleteExamChild(ids);
        result.setMsg("成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
}
