package com.login.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.common.util.Md5Encode;
import com.bofan.manage.valueobject.SysUser;
import com.bofan.manage.valueobject.SysUserInfo;
import com.login.service.LoginService.LoginResult;
import com.manage.service.ManageService;

@Service
public class MessageVerifyLoginService extends AbstractAnnoCommonService{
    private String loginNameKey = "account";
    private String passwordKey = "password";

    private String passwordField = "password";

    @Autowired
    ManageService manageService;

   /**
    * @see com.bofan.manage.service.LoginService#login(java.util.Map)
    */
    public LoginResult login(Map loginData) {

        SimpleLoginResult result = new SimpleLoginResult();

        String account = (String) loginData.get(loginNameKey);
        String passowrd = (String) loginData.get(passwordKey);

        if (account == null || !StringUtils.hasText(account)) {
            result.errorMessage = "必须输入用户名！";
            result.isLogin = false;
            return result;
        }

        if (passowrd == null || !StringUtils.hasText(passowrd)) {
            result.errorMessage = "必须输入密码！";
            result.isLogin = false;
            return result;
        }

        SysUserInfo userInfo = this.manageService.loadValidate(account);
        if (null == userInfo) {
            result.errorMessage = "该用户名不存在！";
            result.isLogin = false;
            return result;
        } else if (SysUser.INVALID_USER.equals(userInfo.getSysUser().getDelFlag())) {
            result.errorMessage = "该用户为无效用户！";
            result.isLogin = false;
            return result;
        }

        String md5Password = userInfo.getSysUser().getPassword();
        if (!md5Password.equals(Md5Encode.md5Encoding(passowrd))) {
            result.errorMessage = "输入的密码错误！";
            result.isLogin = false;
            return result;
        }

        result.isLogin = true;
        result.userData = userInfo;
        return result;
    }

    /* (non-Javadoc)
     * @see com.bofan.manage.service.LoginService#loadUserData(java.lang.String)
     */
    public LoginResult loadUserData(String loginName) {
        SimpleLoginResult result = new SimpleLoginResult();

        SysUserInfo userInfo = this.manageService.loadValidate(loginName);
        if (null == userInfo) {
            result.errorMessage = "该用户名不存在！";
            result.isLogin = false;
            return result;
        }

        result.isLogin = true;
        result.userData = userInfo;
        return result;
    }

    /**
    * @return the loginNameKey
    */
    public String getLoginNameKey() {
        return loginNameKey;
    }

    /**
    * @param loginNameKey the loginNameKey to set
    */
    public void setLoginNameKey(String loginNameKey) {
        this.loginNameKey = loginNameKey;
    }

    /**
    * @return the passwordKey
    */
    public String getPasswordKey() {
        return passwordKey;
    }

    /**
    * @param passwordKey the passwordKey to set
    */
    public void setPasswordKey(String passwordKey) {
        this.passwordKey = passwordKey;
    }

    /**
    * @return the passwordField
    */
    public String getPasswordField() {
        return passwordField;
    }

    /**
    * @param passwordField the passwordField to set
    */
    public void setPasswordField(String passwordField) {
        this.passwordField = passwordField;
    }


    public class SimpleLoginResult implements LoginResult {

        private boolean isLogin;

        private String errorMessage;

        private SysUserInfo userData;

        private boolean isOuterLogin;

        /* (non-Javadoc)
        * @see com.bofan.manage.service.LoginService.LoginResult#getErrorMessage()
        */
        public String getErrorMessage() {
            return errorMessage;
        }

        /* (non-Javadoc)
        * @see com.bofan.manage.service.LoginService.LoginResult#getUserData()
        */
        public SysUserInfo getUserData() {
            return userData;
        }

        /* (non-Javadoc)
        * @see com.bofan.manage.service.LoginService.LoginResult#isLogin()
        */
        public boolean isLogin() {
            return isLogin;
        }

        public boolean isOuterLogin() {
            return isOuterLogin;
        }

    }
}
