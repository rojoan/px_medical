package com.bofan.publichealth.controller;

import java.util.Arrays;
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
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.command.ChildDetailEditInfo;
import com.bofan.publichealth.command.ChildDetailQueryInfo;
import com.bofan.publichealth.service.ChildDetailService;
import com.bofan.publichealth.service.RegionService;
import com.bofan.publichealth.valueobject.ChildDetail;
import com.bofan.publichealth.valueobject.FamilyDetail;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;

/**
 * 0-6岁儿童基本情况控制器
 * @Description
 * @author xlf 
 * 2017-10-26
 */
@Controller
@RequestMapping("/childDetail")
public class ChildDetailController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(ChildDetailController.class.getName());
    
    @Autowired
    private RegionService regionService;
    
    @Autowired
    private ChildDetailService childDetailService;
    
    /**
     * 
     * @return
     */
    @RequestMapping("/childDetailShow.do")
    public String childDetailShow(Long childDetailId, Model model) {
        model.addAttribute("childDetailId", childDetailId);
        return "publichealth/childDetailShow";
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping("/childDetailRegister.do")
    public String childDetailRegister() {
        return "publichealth/childDetailRegister";
    }
    
    /**
     * 分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/childDetailList.do")
    @ResponseBody
    public Map<String, Object> childDetailList(HttpServletRequest request, ChildDetailQueryInfo queryInfo) {
        queryInfo.setValidFlag(Contstants.YES_FLAG);
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        queryInfo.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
        
        Page page = this.childDetailService.selectChildDetailList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 打开选泽儿童/新生儿信息页
     * @param childDetailId
     * @return
     */
    @RequestMapping("/selectCommonChildDetail.do")
    public String selectCommonChildDetail(Long childDetailId, Model model) {
        return "publichealth/select/selectCommonChildDetail";
    }
    
    /**
     * 打开儿童/新生儿信息登记页
     * @param childDetailId
     * @return
     */
    @RequestMapping("/childDetailRegisterEdit.do")
    public String childDetailRegister(Long childDetailId, boolean isReadOnly, Model model) {
        if (null != childDetailId) {
            ChildDetail childDetail = this.childDetailService.selectAObject(ChildDetail.class, childDetailId); 
            model.addAttribute("childDetail", childDetail);
            // 家庭档案信息
            if (null != childDetail.getFamilyDetailId()) {
                model.addAttribute("familyDetail", this.childDetailService.selectAObject(FamilyDetail.class, childDetail.getFamilyDetailId()));
            }
            // 母亲妊娠期患病情况
            if (!Tools.isEmptyString(childDetail.getFetationFlag())) {
                model.addAttribute("fetationFlags", Arrays.asList(childDetail.getFetationFlag().split(",")));
            }
            // 出生情况
            if (!Tools.isEmptyString(childDetail.getBirthCondition())) {
                model.addAttribute("birthConditions", Arrays.asList(childDetail.getBirthCondition().split(",")));
            }
            // 新生儿疾病筛查
            if (!Tools.isEmptyString(childDetail.getDiseaseScreening())) {
                model.addAttribute("diseaseScreenings", Arrays.asList(childDetail.getDiseaseScreening().split(",")));
            }
            
            // 获取街道地址
            if (null != childDetail && null != childDetail.getRegionId()) {
              model.addAttribute("regionAddress",this.regionService.parseRegionAdress(childDetail.getRegionId()));
            }
        }
        if (isReadOnly) {
            return "publichealth/childDetailRegisterShow";
        } else {
            return "publichealth/childDetailRegisterEdit";
        }
    }
    
    /**
     * 保存
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/saveRegister.jo")
    @ResponseBody
    public JsonObj saveRegister(HttpServletRequest request, ChildDetailEditInfo info) {
        JsonObj result = new JsonObj();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        info.setCurrentUser(userInfo);
        if (StringUtils.hasText(info.getChildName())) {
            info.setChildName(info.getChildName().trim());
        }
        
        if (null == info.getChildDetailId() && StringUtils.hasText(info.getChildName()) && null != info.getFamilyDetailId()) {
            ChildDetailQueryInfo queryInfo = new ChildDetailQueryInfo();
            queryInfo.setChildName(info.getChildName());
            queryInfo.setFamilyDetailId(info.getFamilyDetailId());
            Page page = this.childDetailService.selectChildDetailList(queryInfo);
            
            if (null != page.getData() && page.getData().size() > 0) {
                result.setMsg("该儿童已经存在，不能重复登记");
                result.setCode(ResponseContstants.RESULT_FAIL_CODE);
                return result;
            }
        }
        
        this.childDetailService.saveChildDetail(info);
        result.setMsg("成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 删除儿童登记信息
     * @param ids
     * @return
     */
    @RequestMapping("/deleteChildDetail.jo")
    @ResponseBody
    public JsonObj deleteChildDetail(Long[] ids) {
        JsonObj result = new JsonObj();
        if (null == ids || ids.length <= 0) {
            result.setMsg("删除失败");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        this.childDetailService.deleteChildDetail(ids);
        result.setMsg("成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
}
