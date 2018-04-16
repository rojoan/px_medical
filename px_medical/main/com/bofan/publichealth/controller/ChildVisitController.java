package com.bofan.publichealth.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
import com.bofan.dictionary.support.DictionarysInVelocityToolbox;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.command.ChildVisitDateQueryInfo;
import com.bofan.publichealth.command.ChildVisitEditInfo;
import com.bofan.publichealth.command.ChildVisitQueryInfo;
import com.bofan.publichealth.service.ChildVisitAdviseService;
import com.bofan.publichealth.service.ChildVisitService;
import com.bofan.publichealth.service.ChildVisitSickenService;
import com.bofan.publichealth.valueobject.ChildVisit;
import com.bofan.publichealth.valueobject.ChildVisitSicken;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;

/**
 * 新生儿--6岁以内儿童随访控制器
 * @Description
 * @author xlf 
 * 2017-10-26
 */
@Controller
@RequestMapping("/childVisit")
public class ChildVisitController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(ChildVisitController.class.getName());
    
    @Autowired
    private ChildVisitService childVisitService;
    
    @Autowired
    private ChildVisitSickenService childVisitSickenService;
    
    @Autowired
    private ChildVisitAdviseService childVisitAdviseService;
    
    /**
     * 打开新生儿访视（检查）页面
     * @return
     */
    @RequestMapping("/newChildVisitList.do")
    public String newChildVisitList() {
        return "publichealth/newChildVisitList";
    }
    
    /**
     * 获取新生儿访视（检查）分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/newChildVisitDataList.jo")
    @ResponseBody
    public Map<String, Object> newChildVisitDataList(HttpServletRequest request, ChildVisitQueryInfo queryInfo) {
        queryInfo.setAgeStageFlag(Contstants.CHILD_NEW_FALG);
        return this.childVisitDataList(request, queryInfo);
    }
    
    /**
     * 打开一岁以内访视（检查）页面
     * @return
     */
    @RequestMapping("/oneUnderChildVisitList.do")
    public String oneUnderChildVisitList() {
        return "publichealth/oneUnderChildVisitList";
    }
    
    /**
     * 打开一岁以内访视（检查）分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/oneUnderChildVisitDataList.jo")
    @ResponseBody
    public Map<String, Object> oneUnderChildVisitDataList(HttpServletRequest request, ChildVisitQueryInfo queryInfo) {
        queryInfo.setAgeStageFlag(Contstants.CHILD_ONEUNDER_FALG);
        return this.childVisitDataList(request, queryInfo);
    }
    
    /**
     * 打开1-2岁访视（检查）页面
     * @return
     */
    @RequestMapping("/twoUnderChildVisitList.do")
    public String twoUnderChildVisitList() {
        return "publichealth/twoUnderChildVisitList";
    }
    
    /**
     * 打开1-2岁访视（检查）分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/twoUnderChildVisitDataList.jo")
    @ResponseBody
    public Map<String, Object> twoUnderChildVisitDataList(HttpServletRequest request, ChildVisitQueryInfo queryInfo) {
        queryInfo.setAgeStageFlag(Contstants.CHILD_TWOUNDER_FALG);
        return this.childVisitDataList(request, queryInfo);
    }
    
    /**
     * 打开3-6内访视（检查）页面
     * @return
     */
    @RequestMapping("/sixUnderChildVisitList.do")
    public String sixUnderChildVisitList() {
        return "publichealth/sixUnderChildVisitList";
    }
    
    /**
     * 打开3-6访视（检查）分页查询
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/sixUnderChildVisitDataList.jo")
    @ResponseBody
    public Map<String, Object> sixUnderChildVisitDataList(HttpServletRequest request, ChildVisitQueryInfo queryInfo) {
        queryInfo.setAgeStageFlag(Contstants.CHILD_SIXUNDER_FALG);
        return this.childVisitDataList(request, queryInfo);
    }
    
    /**
     * 本类通用的获取访视（检查）数据列表
     * @param request
     * @param queryInfo
     * @return
     */
    private Map<String, Object> childVisitDataList(HttpServletRequest request, ChildVisitQueryInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        queryInfo.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
        
        Page page = this.childVisitService.selectChildVisitList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 本类通用的获取访视（检查）日期数据列表
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/childVisitDateList.jo")
    @ResponseBody
    public Map<String, Object> childVisitDateList(HttpServletRequest request, ChildVisitDateQueryInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        Page page = this.childVisitService.selectChildVisitDateList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 打开新生儿--6岁以内儿童随访登记页
     * @param childDetailId
     * @return
     */
    @RequestMapping("/childVisitEdit.do")
    public String childVisitEdit(Long childVisitId, String view, Model model) {
        StringBuffer viewPage = new StringBuffer("publichealth/");
        if (null != childVisitId) {
            ChildVisit childVisit = this.childVisitService.selectAObject(ChildVisit.class, childVisitId); 
            model.addAttribute("childVisit", childVisit);
            
            // 黄疸部位
            if (!Tools.isEmptyString(childVisit.getJaundiceParts())) {
                model.addAttribute("jaundiceParts", Arrays.asList(childVisit.getJaundiceParts().split(",")));
            }
            // 随访指导
            if (null != childVisit.getChildDetailId()) {
                List<Long> adviseIdList = childVisitAdviseService.selectChildVisitAdviseId(childVisitId, childVisit.getChildDetailId());
                Map<String, ChildVisitSicken> sickenMap = childVisitSickenService.selectChildVisitSickenMap(childVisitId, childVisit.getChildDetailId());
                
                model.addAttribute("adviseIdList", adviseIdList);
                model.addAttribute("sickenMap", sickenMap);
            }
        }
        
        return viewPage.append(view).toString();
    }
    
    /**
     * 保存
     * @param request
     * @param queryInfo
     * @return
     */
    @SuppressWarnings({ "unchecked" })
    @RequestMapping("/saveRegister.jo")
    @ResponseBody
    public Map<String, Object> saveRegister(HttpServletRequest request, ChildVisitEditInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        info.setCurrentUser(userInfo);
        
        // *******bebgin 组装页面传过来的疾病描述内容（患病情况） **
        Map<String, String> visitSickenMap = (Map<String, String>)DictionarysInVelocityToolbox.getDictionary("dicVisitSicken");
        if (null != visitSickenMap) {
            String sickenContent = null;
            String childVisitSickenId = null;
            ChildVisitSicken visitSicken = null;
            Map<Long, ChildVisitSicken> sickenMap = new HashMap<Long, ChildVisitSicken>();
            for (Map.Entry<String, String> entry : visitSickenMap.entrySet()) {  
                if (!StringUtils.hasText(entry.getKey())) {
                    continue ;
                }
                childVisitSickenId = request.getParameter("childVisitSickenId" + entry.getKey());
                sickenContent = request.getParameter("sickenContent" + entry.getKey());
                if(!StringUtils.hasText(childVisitSickenId) && !StringUtils.hasText(sickenContent)) {
                    continue ;
                }
                
                visitSicken = new ChildVisitSicken();
                if (StringUtils.hasText(childVisitSickenId)) {
                    visitSicken.setChildVisitSickenId(Long.valueOf(childVisitSickenId));
                }
                visitSicken.setSickenContent(sickenContent);
                sickenMap.put(Long.valueOf(entry.getKey()), visitSicken);
            }
            info.setVisitSickenMap(sickenMap);
        }
        // *******end 组装页面传过来的疾病描述内容（患病情况） **
        
        this.childVisitService.saveChildVisit(info);
        result.put("msg", "成功");
        result.put("isSuccess", ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    /**
     * 删除儿童访视信息
     * @param ids
     * @return
     */
    @RequestMapping("/deleteChildVisit.jo")
    @ResponseBody
    public JsonObj deleteChildVisit(Long[] ids) {
        JsonObj result = new JsonObj();
        if (null == ids || ids.length <= 0) {
            result.setMsg("删除失败");
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            return result;
        }
        
        this.childVisitService.deleteChildVisit(ids);
        result.setMsg("成功");
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
    
}
