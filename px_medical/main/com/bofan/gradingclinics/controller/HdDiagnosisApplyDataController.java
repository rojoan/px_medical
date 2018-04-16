package com.bofan.gradingclinics.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.gradingclinics.command.HdDiagnosisApplyMonthDownCalcInfo;
import com.bofan.gradingclinics.service.HdDiagnosisApplyService;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.utils.DateHelper;
import com.bofan.utils.TimeCalculateUtil;
import com.mongo.command.HiDataBaseQueryInfo;
import com.mongo.hchart.DataCycleType;
import com.mongo.hchart.HiDataCommon;

@Controller
@RequestMapping("/hdDiagnosisData")
public class HdDiagnosisApplyDataController {
    @Autowired
    protected HdDiagnosisApplyService hdDiagnosisApplyService;

    @RequestMapping("/calcApplyMonthDown.action")
    public String calcHdDiagnosisApplyMonthDownNum(HdDiagnosisApplyMonthDownCalcInfo calcInfo, Model model) {
        if (calcInfo.getBeginApplyTime() == null && calcInfo.getEndApplyTime() == null) {
            calcInfo.setBeginApplyTime(TimeCalculateUtil.getFirstDayOfThisMonth());
            calcInfo.setEndApplyTime(TimeCalculateUtil.getLastDayOfThisMonth());
        }

        if (calcInfo.getBeginApplyTime() == null && calcInfo.getEndApplyTime() == null) {
            model.addAttribute("message", "计算起始时间与结束时间不能只填其中一个,请填写完整; 如果起始与结束都不填，则取当前月份作为统计时间段");
            return "common/test";
        }
        String beginMonth = DateHelper.formatDateYearMonth(calcInfo.getBeginApplyTime());
        String endMonth = DateHelper.formatDateYearMonth(calcInfo.getEndApplyTime());
        if (!beginMonth.equals(endMonth)) {
            model.addAttribute("message", "计算起始时间与结束时间不允许跨月份，请改正！");
            return "common/test";
        }
        hdDiagnosisApplyService.calcHdDiagnosisApplyMonthDownCount(calcInfo);

        return "common/test";
    }

    @RequestMapping(value = "/hdDiagnosisMonthDownCountData.jo")
    @ResponseBody
    public HiDataCommon getHdDiagnosisMonthDownCountData(HttpServletRequest request,
            HiDataBaseQueryInfo hiDataQueryInfo) {
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        // 计算月数量
        HdDiagnosisApplyMonthDownCalcInfo monthCalcInfo = new HdDiagnosisApplyMonthDownCalcInfo();
        if (monthCalcInfo.getBeginApplyTime() == null && monthCalcInfo.getEndApplyTime() == null) {
            monthCalcInfo.setCycleType(DataCycleType.MONTH.getCycleType());
            monthCalcInfo.setBeginApplyTime(TimeCalculateUtil.getFirstDayOfThisMonth());
            monthCalcInfo.setEndApplyTime(TimeCalculateUtil.getLastDayOfThisMonth());
        }
        monthCalcInfo.setInstitutionUpId(userInfo.getSysOrg().getUnitOrgId());
        hdDiagnosisApplyService.calcHdDiagnosisApplyMonthDownCount(monthCalcInfo);

        // 获取显示数量
        if (hiDataQueryInfo.getDataCycle() == null) {
            hiDataQueryInfo.setDataCycle(DateHelper.formatDateYearMonth(new Date()));// 当前月份
        }
        HiDataCommon hiData = hdDiagnosisApplyService.selectHdDiagnosisMonthDownCount(hiDataQueryInfo);
        return hiData;
    }

    @RequestMapping(value = "/hdDiagnosisDayDownCountData.jo")
    @ResponseBody
    public HiDataCommon getHdDiagnosisDayDownCountData(HttpServletRequest request,
            HiDataBaseQueryInfo hiDataQueryInfo) {
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);

        // 计算当天数量
        HdDiagnosisApplyMonthDownCalcInfo dayCalcInfo = new HdDiagnosisApplyMonthDownCalcInfo();
        if (dayCalcInfo.getBeginApplyTime() == null && dayCalcInfo.getEndApplyTime() == null) {
            dayCalcInfo.setCycleType(DataCycleType.DAY.getCycleType());
            dayCalcInfo.setBeginApplyTime(new Date());
            dayCalcInfo.setEndApplyTime(new Date());
        }
        dayCalcInfo.setInstitutionUpId(userInfo.getSysOrg().getUnitOrgId());
        hdDiagnosisApplyService.calcHdDiagnosisApplyMonthDownCount(dayCalcInfo);

        // 获取显示数量
        if (hiDataQueryInfo.getDataCycle() == null) {
            hiDataQueryInfo.setDataCycle(DateHelper.formatDateYearMonth(new Date()));// 当前月份
        }
        HiDataCommon hiData = hdDiagnosisApplyService.selectHdDiagnosisMonthDownCount(hiDataQueryInfo);
        return hiData;
    }

}
