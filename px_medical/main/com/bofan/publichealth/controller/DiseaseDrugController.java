package com.bofan.publichealth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.command.Page;
import com.bofan.publichealth.command.DiseaseDrugQueryInfo;
import com.bofan.publichealth.service.DiseaseDrugService;

/**
 * 居民健康体检控制器
 * @Description
 * @author xlf 
 * 2017-10-26
 */
@Controller
@RequestMapping("/diseaseDrug")
public class DiseaseDrugController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(DiseaseDrugController.class.getName());
    
    @Autowired
    private DiseaseDrugService diseaseDrugService;
    
    /**
     * 进入公用选择药品页面
     * @return
     */
    @RequestMapping("/selectCommonChronicDrugList.do")
    public String selectCommonChronicDrugList() {
        return "publichealth/select/selectCommonChronicDrugList";
    }
    
    /**
     * 进入药品列表页面
     * @return
     */
    @RequestMapping("/chronicDrugList.do")
    public String enter() {
        return "publichealth/chronicDrugList";
    }
    
    /**
     * 居民健康体检信息列表
     * @param request
     * @param queryInfo
     * @return
     */
    @RequestMapping("/diseaseDrugList.do")
    @ResponseBody
    public Map<String, Object> diseaseDrugList(HttpServletRequest request, DiseaseDrugQueryInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        Page page = this.diseaseDrugService.selectDiseaseDrugList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
}
