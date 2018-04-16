package com.bofan.lis.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.lis.command.GroupResultMicroQueryInfo;
import com.bofan.lis.command.LisInspectionResultMicroQueryInfo;
import com.bofan.lis.command.LisInspectionResultQueryInfo;
import com.bofan.lis.command.LisInspectionSampleQueryInfo;
import com.bofan.lis.service.LisInspectionResultServcie;
import com.bofan.lis.service.LisInspectionSampleGraphServcie;
import com.bofan.lis.service.LisInspectionSampleServcie;
import com.bofan.lis.service.LisRequisitionInfoServcie;
import com.bofan.lis.valueobject.LisInspectionSample;
import com.bofan.lis.webservice.ILisService;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.utils.Contstants;

/**
 * 一般检验控制器
 * 
 * @Description
 * @author xlf
 * @version 2017-10-08
 */
@Controller
@RequestMapping("/lis")
public class GeneralSurveyController {
    
    //@Autowired
    //private PatientService patientService;
    
//    @Autowired
//    private BdbWebProxyService lisService;
    @Autowired
    private ILisService lisService;
    @Autowired
    private LisInspectionSampleServcie lisInspectionSampleServcie;

    @Autowired
    private LisRequisitionInfoServcie LisRequisitionInfoServcie;

    @Autowired
    private LisInspectionResultServcie lisInspectionResultServcie;
    
    @Autowired
    private LisInspectionSampleGraphServcie lisInspectionSampleGraphServcie;

    /**
     * 打开检验分页列表页面
     * @return
     */
    @RequestMapping("/surveyAllList.do")
    public String generalSurveyList() {
        return "lis/generalSurveyList";
    }
    
    /**
     * 打开检验申请分页列表页面
     * @return
     */
    @RequestMapping("/surveyApplyList.do")
    public String surveyApplyList() {
        return "lis/surveyApplyList";
    }

    /**
     * 查询检验样本所有信息分页列表
     * @param queryInfo
     * @return
     */
    @RequestMapping("/surveyList.do")
    public @ResponseBody Map<String, Object> surveyList(HttpServletRequest request, LisInspectionSampleQueryInfo queryInfo) {
        return this.list(request, queryInfo);
    }
    
    /**
     * 查询检验样本申请信息分页列表
     * @param queryInfo
     * @return
     */
    @RequestMapping("/applyList.do")
    public @ResponseBody Map<String, Object> applyList(HttpServletRequest request, LisInspectionSampleQueryInfo queryInfo) {
        queryInfo.setDiagnosisFlag(Contstants.DIAGNOSIS_FLAG_NONE);
        return this.list(request, queryInfo);
    }
    
    /**
     * 查询检验数据列表
     * @param queryInfo
     * @return
     */
    private Map<String, Object> list(HttpServletRequest request, LisInspectionSampleQueryInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        queryInfo.setOrgId(userInfo.getSysOrg().getUnitOrgId());
        Page page = lisInspectionSampleServcie.selectLisInspectionSampleList(queryInfo);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }

    /**
     * 查询一般检验结果分页列表
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("/generalSurveyList.do")
    public @ResponseBody List generalSurveyList(LisInspectionResultQueryInfo queryInfo) {
        Page page = lisInspectionResultServcie.selectLisInspectionResultByInspectionId(queryInfo);
        return page.getData();
    }
    
    /**
     * 查询微生物检验结果分页列表
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("/microbeSurveyList.do")
    public @ResponseBody List microbeSurveyList(LisInspectionResultMicroQueryInfo queryInfo) {
        Page page = lisInspectionResultServcie.selectLisInspectionResultMicroByInspectionId(queryInfo);
        return page.getData();
    }
    
    /**
     * 分组查询微生物检验结果分页列表
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("/microbeGroupList.do")
    public @ResponseBody List microbeGroupList(GroupResultMicroQueryInfo queryInfo) {
        List<Map<String, Object>> dataList = lisInspectionResultServcie.selectGroupResultMicroByInspectionId(queryInfo);
        return dataList;
    }
    
    /**
     * 查询检验结果详情
     * @return
     */
    @RequestMapping("/surveyDetail.do")
    public String surveyDetail(Long lisInspectionSampleId, Model model) {
        String view = "lis/generalSurveyDetail";
        if (null == lisInspectionSampleId || lisInspectionSampleId.intValue() <= 0) {
            return view;
        }

        LisInspectionSample inspectionSample = this.lisInspectionSampleServcie.selectAObject(LisInspectionSample.class, lisInspectionSampleId);
        if (null == inspectionSample) {
            return view;
        }

        // 申请信息
        model.addAttribute("requisitionInfo", this.LisRequisitionInfoServcie.selectLisRequisitionInfoByRequisitionId(inspectionSample.getRequisitionId()));
        model.addAttribute("inspectionSample", inspectionSample);

        // 判断如果一般检验结果，则返回一般检验视图
        if (lisInspectionResultServcie.selectExistGeneralResultByInspectionId(inspectionSample.getInspectionId())) {
            model.addAttribute("resultImg", lisInspectionSampleGraphServcie.selectLisInspectionSampleGraphList(inspectionSample.getInspectionId()));
            return "lis/generalSurveyDetail";
        }
        // 判断如果微生物检验结果，则返回微生物检验视图
        if (lisInspectionResultServcie.selectExistMicroResultByInspectionId(inspectionSample.getInspectionId())) {
            model.addAttribute("sampleExplain", this.lisInspectionResultServcie.selectInspectionSampleExplainByInspectionId(inspectionSample.getInspectionId()));
            return "lis/microbeSurveyDetail";
        }

        return view;
    }
    
    /**
     * 从bdb库中获取图片二进制数据并生成图片
     * @param fileUid
     * @throws IOException 
     */
    @RequestMapping("/downloadImg.do")
    public void downloadImg(HttpServletRequest request,HttpServletResponse response, String fileUid, String path) {
        OutputStream outputStream = null;
        try {
            byte[] imgData = lisService.getFileByte(path, fileUid);
            
            response.setHeader("Content-Type","application/octet-stream");
            response.setHeader("Content-Disposition","attachment;filename=");
            outputStream = response.getOutputStream();
            outputStream.write(imgData);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            if (null != outputStream) {
                try {
					outputStream.flush();
					outputStream.close();
				} catch (IOException e1) {
					throw new RuntimeException(e);
				}
            }
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 查看检验信息相关
     */
    @RequestMapping("/generalSurveyInfo.do")
    public String generalSurveyInfo(Long lisInspectionSampleId, Model model) {
        model.addAttribute("lisInspectionSampleId", lisInspectionSampleId);
        model.addAttribute("inspectionSample", this.lisInspectionSampleServcie.selectAObject(LisInspectionSample.class, lisInspectionSampleId));
        //patientService
    	return "lis/generalSurveyInfo";
    }
    
    
}
