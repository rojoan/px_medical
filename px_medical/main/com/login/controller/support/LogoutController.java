/*
 * FileName:    LogoutController.java
 * Description:
 * Company:     博繁科技
 * Copyright:   bofan 2017
 * History:     2017-3-13 (pch) 1.0 Create
 */

package com.login.controller.support;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * @author pch
 *
 */
public final class LogoutController extends AbstractController {

    private String logoutPage;

    /**
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
        PrintWriter writer = response.getWriter();
        
        writer.println("<script>");
        if (logoutPage != null) {
            System.out.println(request.getContextPath());
            writer.println("top.window.location='" + request.getContextPath() + "/" + logoutPage + "'");
        } else {
            writer.println("top.window.location='" + logoutPage + "'");
        }
        writer.println("</script>");
        writer.close();
        return null;
    }

    /**
    * @return the logoutPage
    */
    public String getLogoutPage() {
        return logoutPage;
    }

    /**
    * @param logoutPage the logoutPage to set
    */
    public void setLogoutPage(String logoutPage) {
        this.logoutPage = logoutPage;
    }

}
