/*
 * FileName:    UserDetail.java
 * Description:
 * Company:     �����Ƽ�
 * Copyright:   bofan 2017
 * History:     2017-3-13 (pch) 1.0 Create
 */
package com.login;

import javax.servlet.http.HttpServletRequest;


/**
 * @author pch
 *
 */
public interface LoginAction {

    public void initAfterLogin(HttpServletRequest request, String userLoginName);

}
