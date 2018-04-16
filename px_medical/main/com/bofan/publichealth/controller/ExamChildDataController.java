package com.bofan.publichealth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.publichealth.command.ExamChildDayNumCalcInfo;
import com.bofan.publichealth.service.ExamChildService;
import com.bofan.utils.DateHelper;
import com.bofan.utils.TimeCalculateUtil;
import com.mongo.command.HiDataBaseQueryInfo;
import com.mongo.hchart.HiDataCommon;

@Controller
@RequestMapping("/childData")
public class ExamChildDataController {

    @Autowired
    private ExamChildService examChildService;
    @RequestMapping("/calcExamChildDayNum.action")
    public String calcExamChildDayNum(ExamChildDayNumCalcInfo calcInfo, Model model) {
        if(calcInfo.getBeginExamTime() == null && calcInfo.getEndExamTime() == null) {
            calcInfo.setBeginExamTime(TimeCalculateUtil.getPreviousMonthFirst());
            calcInfo.setEndExamTime(TimeCalculateUtil.getPreviousMonthEnd());
        }

        if (calcInfo.getBeginExamTime() == null && calcInfo.getEndExamTime() == null) {
            model.addAttribute("message", "计算起始时间与结束时间不能只填其中一个,请填写完整; 如果起始与结束都不填，则取当前时间的上月作为统计时间段");
            return "common/test";
        }
        String beginMonth = DateHelper.formatDateYearMonth(calcInfo.getBeginExamTime());
        String endMonth = DateHelper.formatDateYearMonth(calcInfo.getEndExamTime());
        if (!beginMonth.equals(endMonth)) {
            model.addAttribute("message", "计算起始时间与结束时间不允许跨月份，请改正！");
            return "common/test";
        }
        examChildService.calcExamChildDateCount(calcInfo);

        return "common/test";
    }

    @RequestMapping(value = "/getExamChildDateCount.jo")
    @ResponseBody
    public HiDataCommon getExamChildDateCount(HiDataBaseQueryInfo hiDataQueryInfo) {
        if (hiDataQueryInfo.getDataCycle() == null) {
            hiDataQueryInfo.setDataCycle(DateHelper.formatDateYearMonth(TimeCalculateUtil.getPreviousMonthFirst()));
        }
        HiDataCommon hiData = examChildService.selectExamChildDateCount(hiDataQueryInfo);
        return hiData;
    }
}
