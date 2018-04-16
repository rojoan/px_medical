package com.login.controller.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class DesktopController extends AbstractController {

    private String desktopView;

    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView(desktopView);
    }

    public void setDesktopView(String desktopView) {
        this.desktopView = desktopView;
    }

}
