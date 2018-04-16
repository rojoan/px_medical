package com.bofan.mobile.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.common.util.Md5Encode;
import com.bofan.dictionary.support.DictionarysInVelocityToolbox;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUser;
import com.bofan.manage.valueobject.SysUserInfo;
import com.login.service.LoginService;
import com.manage.service.ManageService;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-11-24
 */
@Controller
@RequestMapping("/mobile.user")
public class UserController {
    
    @Autowired
    private ManageService manageService;
    
    @Autowired
    private LoginService loginService;

    /**
     * @see com.bofan.reconsult.controller.ReConsultingController#list(javax.servlet.http.HttpServletRequest, com.bofan.reconsult.command.ReConsultingQueryInfo)
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/loginInfo.do")
    @ResponseBody
    public Map<String, Object> list(HttpServletRequest request) {
        Map<String, Object> loginInfo = new HashMap<String, Object>();
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        loginInfo.put("userId", userInfo.getUserId());
        loginInfo.put("account", userInfo.getSysUser().getAccount());
        
        loginInfo.put("userInfoId", userInfo.getUserInfoId());
        loginInfo.put("userName", userInfo.getName());
        
        loginInfo.put("orgId", userInfo.getOrgId());
        loginInfo.put("orgName", userInfo.getSysOrg().getName());
        
        SysOrg unitOrg = this.manageService.selectAObject(SysOrg.class, userInfo.getSysOrg().getUnitOrgId());
        loginInfo.put("unitName", unitOrg.getName());
        loginInfo.put("unitOrgId", unitOrg.getOrgId());
                
        // 去除所有单位字典数据
        Map<String, String> unitMap = (Map<String, String>)DictionarysInVelocityToolbox.getDictionary("dicSysOrgUnitIdName");
        loginInfo.put("dicUnitData", unitMap);
        return loginInfo;
    }
    
    /**
     * 修改密码
     * @param request
     * @return
     */
    @RequestMapping("/modifyPassword.jo")
    public @ResponseBody Map<String, Object> modifyPassword(HttpServletRequest request, HttpServletResponse response) {
        String loginName = request.getParameter("account");
        String passowrd = request.getParameter("oldPwd");
        String newPassowrd = request.getParameter("pwd");
        String confirmPassowrd = request.getParameter("cpwd");

        Map<String, Object> result = new HashMap<String, Object>();
        if (!StringUtils.hasText(loginName) 
                || !StringUtils.hasText(passowrd) 
                || !StringUtils.hasText(newPassowrd) 
                || !StringUtils.hasText(confirmPassowrd)
                || !newPassowrd.equals(confirmPassowrd)) {
            result.put("isLogin", false);
            result.put("errorMessage", "失败，请见账号、密码是否为空且新密码与确认密码必须一致！");
            return result;
        }

        LoginService.LoginResult lr = loginService.loadUserData(loginName);
        if(!lr.isLogin() || null == lr.getUserData()){
            result.put("isLogin", false);
            result.put("errorMessage", lr.getErrorMessage());
            return result;
        }
        
        String md5Password = Md5Encode.md5Encoding(passowrd);
        SysUserInfo userInfo = (SysUserInfo) lr.getUserData();
        if(!md5Password.equals(userInfo.getSysUser().getPassword())){
            result.put("isLogin", false);
            result.put("errorMessage", "旧密码错误！");
            return result;
        }
        
        SysUser sysUser = this.manageService.selectAObject(SysUser.class, userInfo.getUserId());
        if (null != sysUser) {
            sysUser.setPassword(Md5Encode.md5Encoding(newPassowrd));
            this.manageService.saveAObject(sysUser);
            result.put("isLogin", true);
            return result;
        }
        
        result.put("isLogin", false);
        result.put("errorMessage", "未知的错误！");
        return result;
    }
    
    /**
     * 检验app客户端配置的服务地址是否正确
     * @param request
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping("/check.action")
    public @ResponseBody Map<String, Object> check(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("GBK");  
        response.setContentType("text/plain; charset=GBK");
        Map loginMap = new HashMap();
        Map<String, Object> result = new HashMap<String, Object>();
        for (Iterator iterator = request.getParameterMap().keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            loginMap.put(key, request.getParameter(key));
        }
        LoginService.LoginResult lr = loginService.login(loginMap);
        if(lr.isLogin()){
            result.put("isLogin", lr.isLogin());
        } else {
            result.put("isLogin", lr.isLogin());
            result.put("errorMessage", lr.getErrorMessage());
        }
        
        return result;
    }
}
