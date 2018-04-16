/*
 * FileName:    StaffMultiSelectController.java
 * Description:
 * Company:
 * Copyright:   (c) 2017
 * History:     2017-12-17 (lty) 1.0 Create
 */

package com.manage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lty
 * @version 1.0 2017-12-17
 */
public class StaffMultiSelectController extends StaffSelectController {

    /**
     * @param request HttpServletRequest
     * @return 已选择的人员信息Map
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map getCustomDataMap(HttpServletRequest request) {
        //解析初始选择的人员
        String staffs = request.getParameter("staffs");
        Map model = new HashMap();
        if (staffs != null) {
            String[] man = staffs.split(",");
            List manList = new ArrayList();
            for (int i = 0; i < man.length; i++) {
                if (man[i] != null && man[i].trim().length() > 0) {
                    manList.add(man[i]);
                }
            }
            model.put("staffList", manList);
        }
        return model;
    }

}
