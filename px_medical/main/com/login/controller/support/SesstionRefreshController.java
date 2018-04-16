/*
 * FileName:    SesstionRefreshController.java
 * Description:
 * Company:     博繁科技
 * Copyright:   bofan 2017
 * History:     2017-12-05  (mg) 1.0 Create
 */

package com.login.controller.support;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
@Controller
@RequestMapping("/sys")
public class SesstionRefreshController extends MultiActionController { 
    /**
     * 
     * @param request
     * @param isDebug 是否调试，可修改main.vm的刷新url来输出信息
     * @return
     */
    @RequestMapping(value = "/sessionRefresh.do")
    public @ResponseBody Map<String, Object> sessionRefresh(HttpServletRequest request, boolean isDebug){
        Map<String, Object> result = new HashMap<String, Object>();
        if (isDebug) {
        	Date lastSessionTime = (Date) request.getSession().getAttribute("lastSessionTime");
        	Date currentTime = new Date();
        	logger.error("lastSessionTime:" +lastSessionTime);
        	logger.error("currentTime:" +currentTime);
        	logger.debug("sessionRefresh.do");
        	System.out.println("currentTime:" + currentTime);
        	request.getSession().setAttribute("lastSessionTime", currentTime);
        }
        return result;
    }
}