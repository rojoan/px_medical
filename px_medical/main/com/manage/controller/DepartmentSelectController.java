/*
 * FileName:    StaffManageController.java
 * Description:
 * Company:     �����Ƽ�
 * Copyright:   bofan 2017
 * History:     2017-12-7 (pch) 1.0 Create
 */
package com.manage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bofan.manage.valueobject.SysOrg;

/**
 * @author  pch
 * @version 1.0, 2017-12-7
 */
public class DepartmentSelectController extends AbstractController {

    /**ѡ����Ա��ͼ**/
    private String selectView;

    /**
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	protected final ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Map model = getCustomDataMap(request);
        return new ModelAndView(this.selectView, model);
    }

    /** Ĭ�ϰ�staffs������ѡ�����Ա��Ϣ�������������Ҫ�󣬽����������ظú�����д���
     * @param request HttpServletRequest
     * @return ��ѡ�����Ա��ϢMap
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map getCustomDataMap(HttpServletRequest request) {
        //������ʼѡ�����Ա
        Map model = new HashMap();
        String depId = request.getParameter("depId");
        String depName = request.getParameter("depName");
        if (depId != null && depName != null) {
            String[] id = depId.split(",");
            String[] name = depName.split(",");
            if (id.length == name.length) {
                List depList = new ArrayList();
                for (int i = 0; i < id.length; i++) {
                    if (id[i] == null || id[i].trim().length() == 0) {
                        break;
                    }
                    SysOrg dep = new SysOrg();
                    dep.setOrgId(new Long(id[i]));
                    dep.setName(name[i]);
                    depList.add(dep);
                }
                model.put("depSelectedList", depList);
            }
        }
        return model;
    }

    /**
     * @param selectStaffView The selectStaffView to set.
     */
    public void setSelectView(String selectStaffView) {
        this.selectView = selectStaffView;
    }


}
