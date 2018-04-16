package com.manage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUser;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.utils.TreeBuilderByIdLen;
import com.manage.command.SysOrgQueryInfo;
import com.manage.command.UserInfoQueryMapInfo;
import com.manage.service.ManageService;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-10-25
 */
@Controller
@RequestMapping("/sys")
public class CommonController {
    /** logger */
    protected static Logger logger = Logger.getLogger(CommonController.class.getName());

    @Autowired
    private ManageService manageService;
    
    
    /**
     * 根据单位ID查询单位下所有有效的部门
     * @param request
     * @param unitId
     * @return
     */
    @RequestMapping("/queryDepByUnitId.do")
    public @ResponseBody List<SysOrg> queryDepByUnitId(HttpServletRequest request, Long unitId) {
        if (null == unitId) {
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
            return this.manageService.selectDapartment(userInfo.getSysOrg().getUnitOrgId(), true);
        }
        return this.manageService.selectDapartment(unitId, true);
    }
    
    /**
     * 根据部门ID查询部门下所有有效用户
     * @param request
     * @param unitId
     * @return
     */
    @RequestMapping("/queryUserByOrgId.do")
    public @ResponseBody List<Map<String, Object>> queryUserByOrgId(HttpServletRequest request, Long orgId) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        List<SysUserInfo> userInfoList = new ArrayList<SysUserInfo>();
        if (null == orgId) {
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
            userInfoList = this.manageService.selectDepartmentStaffByOrgId(userInfo.getOrgId(), true);
        } else {
            userInfoList = this.manageService.selectDepartmentStaffByOrgId(orgId, true);
        }
        
        Map<String, Object> userMap = null;
        for (SysUserInfo userInfo : userInfoList) {
            userMap = new HashMap<String, Object>();
            userMap.put("name", userInfo.getName());
            userMap.put("userInfoId", userInfo.getUserInfoId());
            result.add(userMap);
        }
        return result;
    }
    
    /**
     * 查询所有有效单位
     * @param request
     * @param unitId
     * @return
     */
    @RequestMapping("/queryUnit.do")
    public @ResponseBody List<SysOrg> queryUnit(HttpServletRequest request, Long orgId) {
        return this.manageService.selectUnit(null, true);
    }
    
    /**
     * 查询所有单位，过滤掉当前用户所在的单位
     * @param request
     * @param unitId
     * @return
     */
    @RequestMapping("/queryUnitFilterUserUnit.do")
    public @ResponseBody List<SysOrg> queryUnitFilterUserUnit(HttpServletRequest request) {
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        return this.manageService.selectUnitFilter(userInfo.getSysOrg().getUnitOrgId(), true);
    }
    
    /**
     * 根据部门ID查询部门下所有有效用户
     * @param request
     * @param unitId
     * @return
     */
    @RequestMapping("/queryUserByUnitId.do")
    public @ResponseBody List<Map<String, Object>> queryUserByUnitId(HttpServletRequest request, Long unitId) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        List<SysUserInfo> userInfoList = new ArrayList<SysUserInfo>();
        if (null == unitId) {
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
            userInfoList = this.manageService.selectDepartmentStaffByUnitId(userInfo.getSysOrg().getUnitOrgId(), true);
        } else {
            userInfoList = this.manageService.selectDepartmentStaffByUnitId(unitId, true);
        }
        
        Map<String, Object> userMap = null;
        for (SysUserInfo userInfo : userInfoList) {
            userMap = new HashMap<String, Object>();
            userMap.put("name", userInfo.getName());
            userMap.put("userInfoId", userInfo.getUserInfoId());
            result.add(userMap);
        }
        return result;
    }
    
    
    /**
     * 根据单位ID查询单位下所有有效的部门
     * @param request
     * @param unitId
     * @return
     */
    @RequestMapping("/queryUser.do")
    public @ResponseBody Map<String, Object> queryUser(UserInfoQueryMapInfo queryInfo) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            queryInfo.setDelFlag(SysUser.VALID_USER);
            Page page = this.manageService.selectStaffPage(queryInfo);
            result.put("rows", page.getData());
            result.put("total", page.getTotalSize());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return result;
    }
    
    /**
     * 构造机构（部门）分类树数据
     * @param request
     * @return
     */
    @RequestMapping(value = "getDepTree.do")
    public @ResponseBody List<Map<String, Object>> getDepTree(HttpServletRequest request, SysOrgQueryInfo info, boolean withCheckBox){
        List<SysOrg> OrgList = this.manageService.selectAllUnitDep(info, true);
        List<Map<String, Object>> result =  new TreeBuilderByIdLen<SysOrg>(withCheckBox, 0) {
            @Override
            protected void copyProperties(Map<String, Object> attrs, SysOrg obj) {
                attrs.put("orgId", obj.getOrgId());
                attrs.put("code", obj.getCode());
                attrs.put("name", obj.getName());
            }
            @Override
            protected String getObjectId(SysOrg object) {
                return object.getCode();
            }
            @Override
            protected String getObjectTitle(SysOrg object) {
                return object.getName();
            }
        }.build(OrgList);
        
        return result;
    }
    
}
