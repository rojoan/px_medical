/*
 * FileName:    LoginService.java
 * Description:
 * Company:     博繁科技
 * Copyright:   bofan 2017
 * History:     2017-3-13 (pch) 1.0 Create
 */
package com.login.service;

import java.util.Map;

/**
 * @author pch
 *
 */
public interface LoginService {
    public LoginResult login(Map loginData);

    public LoginResult loadUserData(String loginName);

    public interface LoginResult {
        public boolean isLogin();
        public Object getUserData();
        public String getErrorMessage();
    }
}
