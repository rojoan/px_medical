/*
 * FileName:    SchemaController.java
 * Description:
 * Company:     博繁科技
 * Copyright:   bofan 2017
 * History:     2017-3-13 (pch) 1.0 Create
 */

package com.login.controller.support;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import com.bofan.basesystem.common.Constants;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.sso.client.service.NavigateLocalService;
import com.bofan.sso.common.service.impl.SessionUtils;
import com.bofan.sso.common.service.impl.UserSession;
import com.bofan.utils.AlertRedirectPage;
import com.login.LoginAction;
import com.login.service.LoginService;

/**
 * @author pch
 *
 */
public final class LoginController extends NavigateLocalService implements Controller {

    private LoginService loginService;

    private String systemEntryUrl;
    private String loginUrl;
    private String outerIpAddress;
    private String outerNameAddress;

    private LoginAction[] loginActions;

    private AlertRedirectPage alertRedirectPage;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void putTimeFlag(Map model) {
        model.put("_dc", String.valueOf(System.currentTimeMillis()));
    }

    private void doLoginActions(HttpServletRequest request, String loginname) {
        if (this.loginActions != null) {
            for (int i = 0; i < this.loginActions.length; i++) {
                LoginAction la = this.loginActions[i];
                if (la != null) {
                    la.initAfterLogin(request, loginname);
                }
            }
        }
    }

    /**
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("text/plain; charset=UTF-8");
        StringBuffer result = new StringBuffer();
        Map loginMap = new HashMap();
        for (Iterator iterator = request.getParameterMap().keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            loginMap.put(key, request.getParameter(key));
        }
        LoginService.LoginResult lr = loginService.login(loginMap);
        if(lr.isLogin()){
            Map model = new HashMap();
            putTimeFlag(model);
            SysUserInfo userInfo = (SysUserInfo) lr.getUserData();
            doLoginActions(request, userInfo.getSysUser().getAccount());
            String verifyLoginUrl = this.outNetClientCheck(userInfo, request);
            
            result.append("{\"isLogin\":").append(lr.isLogin());
            result.append(", \"url\":\"").append(verifyLoginUrl);
            result.append("?_t=").append(model.get("_dc"));
            result.append("\"}");
            response.getWriter().write(result.toString());
            return null; 
            //new ModelAndView(new RedirectView(this.mainUrl), model);
            // return new ModelAndView(new RedirectView(verifyLoginUrl),model);
        } else {
            request.getSession().invalidate();
            
            result.append("{\"isLogin\":").append(lr.isLogin());
            result.append(", \"msg\":\"").append(lr.getErrorMessage()).append("\"}");
            response.getWriter().write(result.toString());
            return null; 
        }
    }

    /**
     * 判断用户是否是外网登陆
     * @param userInfo
     * @param request
     * @return
     */
    private String  outNetClientCheck(SysUserInfo userInfo,HttpServletRequest request) {
        String clientUrl = request.getRequestURL().toString();
        if(clientUrl.contains(this.outerIpAddress)||clientUrl.contains(this.outerNameAddress)){
            return loginUrl;
        } else {
            request.getSession().setAttribute(Constants.USER_KEY, userInfo);
            request.getSession().setAttribute("loginMode", "noSSO");
            return systemEntryUrl;
        }
    }
    /**
     * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.handleRequestInternal(request, response);
    }

    /**
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {
        super.register(this);
    }

    private String alignPath(String url) {
        if (url != null && !url.startsWith("..")) {
            return "../" + url;
        }
        return url;
    }

    /**
     * @see com.bofan.sso.client.service.NavigateLocalService#doNavigate(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView doNavigate(HttpServletRequest request, HttpServletResponse response) {
        UserSession us = SessionUtils.getUserSessionFromRequest(request);
        LoginService.LoginResult lr = loginService.loadUserData(us.getUserId());
        if (lr.isLogin()) {
            SysUserInfo userInfo = (SysUserInfo) lr.getUserData();
            request.getSession().setAttribute(Constants.USER_KEY, userInfo);
            doLoginActions(request, userInfo.getSysUser().getAccount());

            Map model = new HashMap();
            putTimeFlag(model);
            String targetUrl = request.getParameter("targetUrl");
            if (targetUrl != null) {
                return new ModelAndView(new RedirectView(alignPath(targetUrl)), model);
            } else {
                return new ModelAndView(new RedirectView(alignPath(systemEntryUrl)), model);
            }
        } else {
            request.getSession().invalidate();
            Map model = new HashMap();
            model.put("message", lr.getErrorMessage());
            putTimeFlag(model);
            return new ModelAndView(new RedirectView(alignPath(loginUrl)), model);
        }
    }

    /**
     * @param loginService the loginService to set
     */
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * @param systemEntryUrl
     *            the systemEntryUrl to set
     */
    public void setSystemEntryUrl(String systemEntryUrl) {
        this.systemEntryUrl = systemEntryUrl;
    }

    /**
     * @param loginUrl
     *            the loginUrl to set
     */
    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    /**
     * @param loginAction the loginAction to set
     */
    public void setLoginAction(LoginAction loginAction) {
        this.loginActions = new LoginAction[] {loginAction};
    }

    /**
     * @param loginActions the loginActions to set
     */
    public void setLoginActions(LoginAction[] loginActions) {
        this.loginActions = loginActions;
    }

    /**
     * @return the alertRedirectPage
     */
    public AlertRedirectPage getAlertRedirectPage() {
        return alertRedirectPage;
    }

    /**
     * @param alertRedirectPage the alertRedirectPage to set
     */
    public void setAlertRedirectPage(AlertRedirectPage alertRedirectPage) {
        this.alertRedirectPage = alertRedirectPage;
    }

    /**
     * @return the outerIpAddress
     */
    public String getOuterIpAddress() {
        return outerIpAddress;
    }

    /**
     * @param outerIpAddress the outerIpAddress to set
     */
    public void setOuterIpAddress(String outerIpAddress) {
        this.outerIpAddress = outerIpAddress;
    }

    /**
     * @return the outerNameAddress
     */
    public String getOuterNameAddress() {
        return outerNameAddress;
    }

    /**
     * @param outerNameAddress the outerNameAddress to set
     */
    public void setOuterNameAddress(String outerNameAddress) {
        this.outerNameAddress = outerNameAddress;
    }
}
