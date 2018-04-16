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
import com.bofan.basesystem.common.controller.AbstractAnnotationController;
import com.bofan.publichealth.gravida.command.PostpartumVisitQueryInfo;
import com.bofan.publichealth.gravida.service.PostpartumVisitService;

/**
 * @Description: 产后访视Controller
 * @author lqw
 */
@Controller
@RequestMapping("/postpartumvisit")
public class PostpartumVisitController  extends AbstractAnnotationController{
	/** logger */
    protected static Logger logger = Logger.getLogger(PostpartumVisitController.class.getName());
 
    /** 产后访视 Service */
	@Autowired
	private PostpartumVisitService postpartumVisitService;
 
    /**
     * 进入产后访视列表页面
     * @return
     */
    @RequestMapping("/postpartumVisitList.do")
    public String postpartumVisitList() {
        return "publichealth/gravida/postpartumVisitList";
    }
    
    /**
     * 获取分页列表数据
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/postpartumVisitListData.do")
    @ResponseBody
    public  Map<String, Object> listData(HttpServletRequest request,PostpartumVisitQueryInfo info) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	Page page = this.postpartumVisitService.selectGravidaDetailPage(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
}
