/*
 * FileName:    StaffSelectWithoutDwController.java
 * Description:
 * Company:     博繁科技
 * Copyright:   bofan 2017
 * History:     2017-11-19 (zq) 1.0 Create
 */

package com.manage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.tree.command.ITreeNode;
import com.bofan.manage.valueobject.SysUserInfo;
import com.manage.service.IDepartmentTreeBuilder;
import com.manage.service.ManageService;

/**
 * @author zq
 * @version 1.0 2017-11-19
 */
public class StaffSelectWithoutUnitController extends AbstractController {

    /**全局**/
    public static final String RANGE_ALL = "all";

    @Autowired
    private ManageService manageService;
    /** IDepartmentTreeBuilder */
    private IDepartmentTreeBuilder departmentTreeBuilder;
    /**选择人员视图**/
    private String selectStaffView;

    /**
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	protected final ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map model = new HashMap();
        SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
        //按根限定组织结构范围
        String rootId = request.getParameter("rootId");
        String range = request.getParameter("range");
        Long depId = null;
        if (rootId != null && rootId.trim().length() > 0) {
            depId = new Long(rootId);
        } else {
            if (!RANGE_ALL.equals(range)) {
                depId = curUser.getSysOrg().getUnitOrgId();
            }
        }
        List depTree = this.departmentTreeBuilder.selectUnitDepTree(depId);
        if (depTree != null && depTree.size() > 0) { //返回默认单位值
            depId = new Long(((ITreeNode) depTree.get(0)).getNodeKey());
        }
        Long firstSelectDep = new Long(((ITreeNode) depTree.get(0)).getNodeKey());
        for (Iterator iterator = depTree.iterator(); iterator.hasNext();) {
            ITreeNode tree_name = (ITreeNode) iterator.next();
            if (tree_name.getNodeKey().equals(curUser.getSysOrg().getOrgId())){
                firstSelectDep = curUser.getSysOrg().getOrgId();
                break;
            }
        }
        model.put("firstSelectDep", firstSelectDep);
        model.put("rootId", rootId);
        model.put("range", range);
        model.put("depId", depId);
        model.put("departmentTree", depTree);
        model.put("loginStaff", curUser);
        //取其他数据
        model.putAll(getCustomDataMap(request));
        return new ModelAndView(this.selectStaffView, model);
    }

    /**
     * @param departmentTreeBuilder the departmentTreeBuilder to set
     */
    public void setDepartmentTreeBuilder(
            IDepartmentTreeBuilder departmentTreeBuilder) {
        this.departmentTreeBuilder = departmentTreeBuilder;
    }

    /** 默认按staffs传递已选择的人员信息，若有其他参数要求，交由子类重载该函数进行处理
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
                    manList.add(this.manageService.selectUserInfo(new Long(man[i])));
                }
            }
            model.put("staffList", manList);
        }
        return model;
    }

    /**
     * @param selectStaffView The selectStaffView to set.
     */
    public void setSelectStaffView(String selectStaffView) {
        this.selectStaffView = selectStaffView;
    }

}
