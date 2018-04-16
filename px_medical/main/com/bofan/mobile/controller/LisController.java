package com.bofan.mobile.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.lis.command.LisInspectionResultQueryInfo;
import com.bofan.lis.command.LisInspectionSampleQueryInfo;
import com.bofan.lis.controller.GeneralSurveyController;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-11-24
 */
@Controller
@RequestMapping("/mobile.lis")
public class LisController extends GeneralSurveyController {

    /**
     * @see com.bofan.lis.controller.GeneralSurveyController#surveyList(javax.servlet.http.HttpServletRequest, com.bofan.lis.command.LisInspectionSampleQueryInfo)
     */
    @RequestMapping("/surveyList.do")
    public Map<String, Object> surveyList(HttpServletRequest request, LisInspectionSampleQueryInfo queryInfo) {
        return super.surveyList(request, queryInfo);
    }

    /**
     * @see com.bofan.lis.controller.GeneralSurveyController#applyList(javax.servlet.http.HttpServletRequest, com.bofan.lis.command.LisInspectionSampleQueryInfo)
     */
    @RequestMapping("/applyList.do")
    public Map<String, Object> applyList(HttpServletRequest request, LisInspectionSampleQueryInfo queryInfo) {
        return super.applyList(request, queryInfo);
    }
    
    /**
     * @see com.bofan.lis.controller.GeneralSurveyController#generalSurveyList(com.bofan.lis.command.LisInspectionResultQueryInfo)
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("/generalSurveyList.do")
    @ResponseBody
    public List generalSurveyList(LisInspectionResultQueryInfo queryInfo) {
        // TODO Auto-generated method stub
        return super.generalSurveyList(queryInfo);
    }

    /**
     * @see com.bofan.lis.controller.GeneralSurveyController#surveyDetail(java.lang.Long, org.springframework.ui.Model)
     */
    @RequestMapping("/showDetail.do")
    @ResponseBody
    public Map<String, Object> showDetail(Long lisInspectionSampleId, Model model) {
         Map<String, Object> result = new HashMap<String, Object>();
         super.surveyDetail(lisInspectionSampleId, model);
         Map<String, Object> dataMap = model.asMap();
         result.putAll(dataMap);
         return result;
    }

}
