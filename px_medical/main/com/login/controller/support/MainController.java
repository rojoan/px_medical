/*
 * FileName:    LogoutController.java
 * Description:
 * Company:     博繁科技
 * Copyright:   bofan 2017
 * History:     2017-3-13 (pch) 1.0 Create
 */

package com.login.controller.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bofan.basesystem.common.Constants;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.share.utils.TreeUtils;
import com.bofan.utils.AlertRedirectPage;
import com.manage.service.ManageService;

/**
 * @author pch
 *
 */
public final class MainController extends AbstractController {

    @Autowired
    private ManageService manageService;
    /** 系统编号串,逗号分隔 */
    private String sysTypes;
    private String defaultSysType;
    private String menuTreeRootId;
    private String mainView;
    private AlertRedirectPage alertRedirectPage;
    private String messageVerifyLoginUrl;
    private String loginUrl;
    private String localSessionRefreshUrl;
    private String ssoSessionRefreshUrl;

    /**
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        Map model = new HashMap();
        String sysType = request.getParameter("sysType");
        List menudata = null;

        String[] sysTypeArray = sysTypes.split(",");
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        if (null != userInfo) { //系统用户登录
            menudata = this.manageService.selectUserFunction(sysTypeArray, userInfo.isAdmin(), userInfo);
        }

        Map sysMenuData = new HashMap();
        for (int i = 0; i < sysTypeArray.length; i++) {
            Map menu = TreeUtils.buildFullTree(takeMenuBySysType(menudata, sysTypeArray[i]), menuTreeRootId);
            sysMenuData.put("sys" + sysTypeArray[i], menu);
        }
        //new JSONObject(sysMenuData)
        model.put("sysType", sysType);
        model.put("defaultSysType", defaultSysType);
        model.put("sysMenuData", sysMenuData);
        model.put("userdata", userInfo);
        model.put("firstFunctionId", request.getParameter("firstFunctionId"));
        model.put("needChangePassword", request.getParameter("needChangePassword"));
        model.put("firstFunctionId", "entpPortal/display.do");
        model.put("localSessionRefreshUrl", localSessionRefreshUrl);
        model.put("ssoSessionRefreshUrl", ssoSessionRefreshUrl);
        return new ModelAndView(mainView, model);
    }

    /**
     * 从全部菜单中根据sysType提取相应的菜单
     * @param List
     * @param String
     * @return List
     */
    private List takeMenuBySysType(List menudata, String sysType) {
        List result = new ArrayList();
        if (null == menudata) {
        	return result;
        }
        for (int i = 0; i < menudata.size(); i++) {
            Object[] nodeData = (Object[])menudata.get(i);
            if (sysType.equals(nodeData[5])) {
                result.add(nodeData);
            }
        }
        return result;
    }

    /**
    * @param sysTypes the sysTypes to set
    */
    public void setSysTypes(String sysTypes) {
        this.sysTypes = sysTypes;
    }

    /**
    * @param menuTreeRootId the menuTreeRootId to set
    */
    public void setMenuTreeRootId(String menuTreeRootId) {
        this.menuTreeRootId = menuTreeRootId;
    }

    /**
    * @param mainView the mainView to set
    */
    public void setMainView(String mainView) {
        this.mainView = mainView;
    }


    public AlertRedirectPage getAlertRedirectPage() {
        return alertRedirectPage;
    }


    public void setAlertRedirectPage(AlertRedirectPage alertRedirectPage) {
        this.alertRedirectPage = alertRedirectPage;
    }


    public String getMessageVerifyLoginUrl() {
        return messageVerifyLoginUrl;
    }


    public void setMessageVerifyLoginUrl(String messageVerifyLoginUrl) {
        this.messageVerifyLoginUrl = messageVerifyLoginUrl;
    }


    public String getLoginUrl() {
        return loginUrl;
    }


    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

	public void setDefaultSysType(String defaultSysType) {
		this.defaultSysType = defaultSysType;
	}

	public void setLocalSessionRefreshUrl(String localSessionRefreshUrl) {
		this.localSessionRefreshUrl = localSessionRefreshUrl;
	}

	public void setSsoSessionRefreshUrl(String ssoSessionRefreshUrl) {
		this.ssoSessionRefreshUrl = ssoSessionRefreshUrl;
	}

}
