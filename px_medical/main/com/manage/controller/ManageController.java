/*
 * FileName:    ManageController.java
 * Description:
 * Company:     博繁科技
 * Copyright:   bofan 2017
 * History:     2017-12-2 (PCH) 1.0 Create
 */
package com.manage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.controller.AbstractAnnotationController;
import com.bofan.basesystem.tree.command.ITreeNode;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUser;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.utils.Tools;
import com.manage.command.MultiUserQueryInfo;
import com.manage.command.OrgQueryInfo;
import com.manage.command.SysOrgQueryInfo;
import com.manage.command.SysUserInfoQueryInfo;
import com.manage.service.IDepartmentTreeBuilder;
import com.manage.service.ManageService;

/**
 * The <code>ManageController</code>
 *
 * @author PCH
 * @version 1.0, 2017-12-2
 *
 */
public class ManageController extends AbstractAnnotationController {
    @Autowired
    private ManageService manageService;
    /** IDepartmentTreeBuilder */
    private IDepartmentTreeBuilder departmentTreeBuilder;

    /**
     * 直接定位到指定的view
     * @param request
     * @param response
     * @return
     */
    public ModelAndView commonFindView(HttpServletRequest request, HttpServletResponse response) {
        String view = "";
        if (request.getParameter("view") != null) {
            view = request.getParameter("view");
        }
        return new ModelAndView(view);
    }

    /**
     * 展示多选单位树
     * @param request
     * @see HttpServletRequest
     * @param response
     * @see HttpServletResponse
     * @return ModelAndView
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectMulDepartmentTree(HttpServletRequest request, HttpServletResponse response) {
        Map model = new HashMap();
        ITreeNode rootNode = this.departmentTreeBuilder.createUnitTree();
        model.put("departmentTree", rootNode.getChildren());
        model.put("currentUser", Constants.getCurrentLoginUser(request));
        model.put("mapId", request.getParameter("mapId"));
        // 已选的单位
        model.put("selectDepId", null == request.getParameter("selectDepId") ? null : ((String) request
                .getParameter("selectDepId")).split(","));
        // 不可选的单位
        model.put("notSelectDepId", null == request.getParameter("notSelectDepId") ? null : ((String) request
                .getParameter("notSelectDepId")).split(","));
        String nextUrl = request.getParameter("nextUrl");
        if (nextUrl != null && nextUrl.length() != 0) {
            model.put("nextUrl", nextUrl);
        }
        return new ModelAndView("manage/departmentMutlTree", model);
    }

    /**
     * 展示多选单位树
     * @param request
     * @see HttpServletRequest
     * @param response
     * @see HttpServletResponse
     * @return ModelAndView
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ModelAndView selectMulDepartmentTree2(HttpServletRequest request, HttpServletResponse response) {
        Map model = new HashMap();
        ITreeNode rootNode = this.departmentTreeBuilder.createUnitTree();
        model.put("departmentTree", rootNode.getChildren());
        model.put("currentUser", Constants.getCurrentLoginUser(request));
        model.put("mapId", request.getParameter("mapId"));
        // 已选的单位
        model.put("selectDepId", null == request.getParameter("selectDepId") ? null : ((String) request
                .getParameter("selectDepId")).split(","));
        // 不可选的单位
        model.put("notSelectDepId", null == request.getParameter("notSelectDepId") ? null : ((String) request
                .getParameter("notSelectDepId")).split(","));
        String nextUrl = request.getParameter("nextUrl");
        if (nextUrl != null && nextUrl.length() != 0) {
            model.put("nextUrl", nextUrl);
        }
        return new ModelAndView("manage/departmentMutlTree2", model);
    }

    /**
     * 展示单选单位树
     * @param request
     * @see HttpServletRequest
     * @param response
     * @see HttpServletResponse
     * @return ModelAndView
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ModelAndView selectSingleDepartmentTree(HttpServletRequest request, HttpServletResponse response) {
        Map model = new HashMap();
        model.put("departmentTree", this.departmentTreeBuilder.selectUnitTree());
        model.put("mapId", request.getParameter("mapId"));
        // 已选的单位
        model.put("selectDepId", null == request.getParameter("selectDepId") ? null : ((String) request
                .getParameter("selectDepId")).split(","));
        // 不可选的单位
        model.put("notSelectDepId", null == request.getParameter("notSelectDepId") ? null : ((String) request
                .getParameter("notSelectDepId")).split(","));
        String nextUrl = request.getParameter("nextUrl");
        if (nextUrl != null && nextUrl.length() != 0) {
            model.put("nextUrl", nextUrl);
        }
        return new ModelAndView("manage/departmentSingleTree", model);
    }

    /**
     * 展示单选地市县单位树
     * @param request
     * @see HttpServletRequest
     * @param response
     * @see HttpServletResponse
     * @return ModelAndView
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ModelAndView selectSingleProviceCityCountryUniFromAll(HttpServletRequest request, HttpServletResponse response) {
        Map model = new HashMap();
        model.put("departmentTree", this.departmentTreeBuilder.selectProviceCityContryArbanUnitTree());
        model.put("mapId", request.getParameter("mapId"));
        // 已选的单位
        model.put("selectDepId", null == request.getParameter("selectDepId") ?
                                                 null : ((String) request.getParameter("selectDepId")).split(","));
        // 不可选的单位
        model.put("notSelectDepId", null == request.getParameter("notSelectDepId") ?
                                                    null : ((String) request.getParameter("notSelectDepId")).split(","));
        String nextUrl = request.getParameter("nextUrl");
        if (nextUrl != null && nextUrl.length() != 0) {
            model.put("nextUrl", nextUrl);
        }
        return new ModelAndView("manage/departmentSingleTree", model);
    }

    /**
     * 列出指定部门的员工列表.
     * @param request HttpServletRequest实例
     * @param response HttpServletResponse实例
     * @return ModelAndView实例
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ModelAndView departmentStaffList(HttpServletRequest request, HttpServletResponse response, OrgQueryInfo info) {
        Map model = new HashMap();
        info = (OrgQueryInfo) Constants.getQueryCondition(request, info);
        if (null == info.getOrgId()) {
            info.setUnitOrgId(((SysUserInfo) Constants.getCurrentLoginUser(request)).getSysOrg().getUnitOrgId());
        }
        Page page = this.manageService.selectStaffPage(info);
        if (request.getParameter("unit") != null) {
            model.put("unit", "true");
        }
        Constants.putQueryCondition(request, page, info);
        model.put("page", page);
        return new ModelAndView("manage/selectStaff", model);

    }

    /**
     * 根据候选部门及候选人员查询人员列表
     * @param request HttpServletRequest实例
     * @param response HttpServletResponse实例
     * @return ModelAndView实例
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView departmentStaffListWithCandidate(HttpServletRequest request, HttpServletResponse response,
            OrgQueryInfo info) {
        Map model = new HashMap();
        info = (OrgQueryInfo) Constants.getQueryCondition(request, info);
        if (null == info.getOrgId()) {
            info.setUnitOrgId(((SysUserInfo) Constants.getCurrentLoginUser(request)).getSysOrg().getUnitOrgId());
        }
        Page page = this.manageService.selectStaffPage(info);
        if (request.getParameter("unit") != null) {
            model.put("unit", "true");
        }
        Constants.putQueryCondition(request, page, info);
        model.put("page", page);
        return new ModelAndView("manage/selectStaff", model);

    }

    /**
     * 列出指定部门可选员工和已选员工列表
     * @param request HttpServletRequest实例
     * @param response HttpServletResponse实例
     * @return ModelAndView实例
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectMultiStaffWithFilter(HttpServletRequest request, HttpServletResponse response,MultiUserQueryInfo info) {
        Map model = new HashMap();
        OrgQueryInfo orgInfo = new OrgQueryInfo();
        orgInfo.setUnitOrgId(info.getUnitOrgId());
        orgInfo.setOrgId(info.getOrgId());
        orgInfo.setDelFlag(SysOrg.NORMAL_STATE);
        orgInfo.setUserDelFlag(SysUser.INVALID_USER);
        if (null == orgInfo.getUnitOrgId() && null == orgInfo.getOrgId()) {
            orgInfo.setUnitOrgId(((SysUserInfo) Constants.getCurrentLoginUser(request)).getSysOrg().getUnitOrgId());
        }
        List staffList = this.manageService.selectStaffList(orgInfo, true);
        model.put("staffList", staffList);
        List preStaffList = new ArrayList();
        if (null != info.getUserIds() && !"".equals(info.getUserIds())) {
            SysUserInfoQueryInfo preUsersInfo = new SysUserInfoQueryInfo();
            preUsersInfo.setUserInfoIds(info.getUserIds());
            preStaffList = this.manageService.selectDepartmentStaff(preUsersInfo, true);
        }
        model.put("preStaffList", preStaffList);
        return new ModelAndView("manage/selectMultiStaffWithFilter", model);
    }

    /**
     * 列出预设人员列表.
     * @param request HttpServletRequest实例
     * @param response HttpServletResponse实例
     * @return ModelAndView实例
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ModelAndView selectSingleStaffFromCandidate(HttpServletRequest request, HttpServletResponse response, OrgQueryInfo info) {
        Map model = new HashMap();
        info = (OrgQueryInfo) Constants.getQueryCondition(request, info);
        if (null == info.getOrgId()) {
            info.setUnitOrgId(((SysUserInfo) Constants.getCurrentLoginUser(request)).getSysOrg().getUnitOrgId());
        }
        List staffList = this.buildStaffFromCandidate(info);
        model.put("staffList", staffList);
        model.put("info", info);
        return new ModelAndView("manage/selectSingleStaffFromCandidate", model);

    }

    /**
     * 将预设部门与预设人员所在部门构造成列表
     * @param request
     * @param response
     * @param info
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectDepListWithCandidate(HttpServletRequest request, HttpServletResponse response, OrgQueryInfo info) {
        Map model = new HashMap();
        SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
        // 按根限定组织结构范围
        String rootId = request.getParameter("rootId");
        //单位ID
        Long unitOrgId = null;
        if (rootId != null && rootId.trim().length() > 0) {
            unitOrgId = new Long(rootId);
        } else {
            unitOrgId = curUser.getSysOrg().getUnitOrgId();
        }
        // 如果有预设人员，则合并预设人员所在部门及预设部门
        Set<Long> candidateDeps = new HashSet<Long>();
        if (null == info.getOrgIds() && null == info.getUserIds()) {
        	candidateDeps.add(curUser.getSysOrg().getOrgId());
        }
        if (null != info.getUserIds() && !"".equals(info.getUserIds())) {
            SysUserInfoQueryInfo candidateUserInfo = new SysUserInfoQueryInfo();
            candidateUserInfo.setUserInfoIds(info.getUserIds());
            List<SysUserInfo> candidateUsers = this.manageService.selectDepartmentStaff(candidateUserInfo, true);
            for (int i = 0; i < candidateUsers.size(); i++) {
                candidateDeps.add(candidateUsers.get(i).getOrgId());
            }
        }
        if (info.getOrgIds() != null && !"".equals(info.getOrgIds())) {
            String[] deps = info.getOrgIds().split(",");
            for (String dep : deps) {
                candidateDeps.add(Long.parseLong(dep));
            }
        }
        String candidateDepStr = StringUtils.join(candidateDeps, ",");
        // 构造单位树
        List depTree = this.departmentTreeBuilder.selectDepListWithCandidate(unitOrgId, candidateDepStr);
        model.put("departmentTree", depTree);
        model.put("loginStaff", curUser);
        return new ModelAndView("manage/selectDepTreeWithCandidate", model);
    }

    /**
     * 将预设部门与预设人员所在部门构造成列表,不按单位和部门构建树形而是直接并列首列显示
     * @param request
     * @param response
     * @param info
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectDepListWithEquallyCandidate(HttpServletRequest request, HttpServletResponse response, OrgQueryInfo info) {
        Map model = new HashMap();
        SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
        // 如果有预设人员，则合并预设人员所在部门及预设部门
        Set<Long> candidateDeps = new HashSet<Long>();
        if (null == info.getOrgIds() && null == info.getUserIds()) {
            candidateDeps.add(curUser.getSysOrg().getOrgId());
        }

        if (null != info.getUserIds() && !"".equals(info.getUserIds())) {
            SysUserInfoQueryInfo candidateUserInfo = new SysUserInfoQueryInfo();
            candidateUserInfo.setUserInfoIds(info.getUserIds());
            List<SysUserInfo> candidateUsers = this.manageService.selectDepartmentStaff(candidateUserInfo, true);
            for (int i = 0; i < candidateUsers.size(); i++) {
                candidateDeps.add(candidateUsers.get(i).getOrgId());
            }
        }
        if (info.getOrgIds() != null && !"".equals(info.getOrgIds())) {
            String[] deps = info.getOrgIds().split(",");
            for (String dep : deps) {
                candidateDeps.add(Long.parseLong(dep));
            }
        }
        String candidateDepStr = StringUtils.join(candidateDeps, ",");
        // 构造单位树
        List depTree = this.departmentTreeBuilder.selectDepListWithEquallyCandidate(candidateDepStr);
        model.put("departmentTree", depTree);
        model.put("loginStaff", curUser);
        return new ModelAndView("manage/selectDepTreeWithCandidate", model);
    }

    /**
     * 将预设部门与预设人员所在部门合并构造部门树
     * @param request
     * @param response
     * @param info
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectDepTreeWithCandidate(HttpServletRequest request, HttpServletResponse response, OrgQueryInfo info) {
        Map model = new HashMap();
        SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
        // 按根限定组织结构范围
        String rootId = request.getParameter("rootId");
    	//单位ID
        Long unitOrgId = null;
        if (rootId != null && rootId.trim().length() > 0) {
            unitOrgId = new Long(rootId);
        } else {
            unitOrgId = curUser.getSysOrg().getUnitOrgId();
        }
        //如无预设部门和预设人员，则查找当前单位所有部门
        if( (Tools.isEmptyString(info.getOrgIds())) && (Tools.isEmptyString(info.getUserIds())) ){
            List depTree =  this.departmentTreeBuilder.selectUnitDepTree(unitOrgId);
            model.put("rootId", rootId);
            model.put("depId", unitOrgId);
            model.put("departmentTree", depTree);
            model.put("loginStaff", curUser);
            return new ModelAndView("manage/selectDepTreeWithCandidate", model);

        }

        // 如果有预设人员，则合并预设人员所在部门及预设部门
        String candidateDepStr = unitOrgId.toString();
        if(null != info.getOrgIds() && !"".equals(info.getOrgIds())) {
            candidateDepStr += "," + info.getOrgIds();
        }
        if (null != info.getUserIds() && !"".equals(info.getUserIds())) {
            SysUserInfoQueryInfo candidateUserInfo = new SysUserInfoQueryInfo();
            candidateUserInfo.setUserInfoIds(info.getUserIds());
            List<SysUserInfo> candidateUsers = this.manageService.selectDepartmentStaff(candidateUserInfo, true);
            Map<Long, Object> candidateDeps = new HashMap();
            for (int i = 0; i < candidateUsers.size(); i++) {
                candidateDeps.put(candidateUsers.get(i).getOrgId(), "");
            }
            if (info.getOrgIds() != null && !"".equals(info.getOrgIds())) {
                String[] deps = info.getOrgIds().split(",");
                for (String dep : deps) {
                    candidateDeps.put(Long.parseLong(dep), "");
                }
            }
            StringBuffer candidateDepBuf = new StringBuffer(100);
            // 包含本单位及候选部门，包含本单位是为了构造树根节点
            candidateDepBuf.append(unitOrgId);
            for (Long candidateDepId : candidateDeps.keySet()) {
                candidateDepBuf.append(",").append(candidateDepId);
            }
            candidateDepStr = candidateDepBuf.toString();
        }

        // 构造单位树
        List depTree = this.departmentTreeBuilder.selectUnitDepTreeWithCandidate(unitOrgId, candidateDepStr);
        if (depTree != null && depTree.size() > 0) { // 返回默认单位值
            unitOrgId = new Long(((ITreeNode) depTree.get(0)).getNodeKey());
        }
        model.put("rootId", rootId);
        model.put("depId", unitOrgId);
        model.put("departmentTree", depTree);
        model.put("loginStaff", curUser);
        return new ModelAndView("manage/selectDepTreeWithCandidate", model);
    }
    /**
     * 将预设部门与预设人员所在部门合并构造单位（区局仅包括区单位和区部门，市局包括本部门、子单位和子单位部门）树
     * @param request
     * @param response
     * @param info
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectUnitDepTreeWithCandidateNotProvice(HttpServletRequest request, HttpServletResponse response, OrgQueryInfo info) {
    	Map model = new HashMap();
    	SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
    	// 按根限定组织结构范围
    	String rootId = request.getParameter("rootId");
    	//单位ID
    	Long unitOrgId = null;
    	if (rootId != null && rootId.trim().length() > 0) {
    		unitOrgId = new Long(rootId);
    	} else {
    		unitOrgId = curUser.getSysOrg().getUnitOrgId();
    	}
    	//如无预设部门和预设人员，则查找当前单位所有部门
    	if( (Tools.isEmptyString(info.getOrgIds())) && (Tools.isEmptyString(info.getUserIds())) ) {
    		List depTree = null;
    		SysOrg unitOrg = this.manageService.loadSysOrg(unitOrgId);
    		if (null != unitOrg && SysOrg.PROVINCE_UNIT.equals(unitOrg.getOrgRank())) {
    			depTree =  this.departmentTreeBuilder.selectUnitDepTree(unitOrgId);
    		} else {
        		depTree =  this.departmentTreeBuilder.selectUnitDepAllTree(unitOrgId);
    		}
    		model.put("rootId", rootId);
    		model.put("depId", unitOrgId);
    		model.put("departmentTree", depTree);
    		model.put("loginStaff", curUser);
    		return new ModelAndView("manage/selectDepTreeWithCandidate", model);

    	}

    	// 如果有预设人员，则合并预设人员所在部门及预设部门
    	String candidateDepStr = unitOrgId.toString();
    	if(null != info.getOrgIds() && !"".equals(info.getOrgIds())){
    		candidateDepStr += "," + info.getOrgIds();
    	}
    	if (null != info.getUserIds() && !"".equals(info.getUserIds())) {
    	    SysUserInfoQueryInfo candidateUserInfo = new SysUserInfoQueryInfo();
    		candidateUserInfo.setUserInfoIds(info.getUserIds());
    		List<SysUserInfo> candidateUsers = this.manageService.selectDepartmentStaff(candidateUserInfo, true);
    		Map<Long, Object> candidateDeps = new HashMap();
    		for (int i = 0; i < candidateUsers.size(); i++) {
    			candidateDeps.put(candidateUsers.get(i).getOrgId(), "");
    		}
    		if (info.getOrgIds() != null && !"".equals(info.getOrgIds())) {
    			String[] deps = info.getOrgIds().split(",");
    			for (String dep : deps) {
    				candidateDeps.put(Long.parseLong(dep), "");
    			}
    		}
    		StringBuffer candidateDepBuf = new StringBuffer(100);
    		// 包含本单位及候选部门，包含本单位是为了构造树根节点
    		candidateDepBuf.append(unitOrgId);
    		for (Long candidateDepId : candidateDeps.keySet()) {
    			candidateDepBuf.append(",").append(candidateDepId);
    		}
    		candidateDepStr = candidateDepBuf.toString();
    	}

    	// 构造单位树
    	List depTree = this.departmentTreeBuilder.selectUnitDepTreeWithCandidate(unitOrgId, candidateDepStr);
    	if (depTree != null && depTree.size() > 0) { // 返回默认单位值
    		unitOrgId = new Long(((ITreeNode) depTree.get(0)).getNodeKey());
    	}
    	model.put("rootId", rootId);
    	model.put("depId", unitOrgId);
    	model.put("departmentTree", depTree);
    	model.put("loginStaff", curUser);
        return new ModelAndView("manage/selectDepTreeWithCandidate", model);
    }
    /**
     * 将预设部门与预设人员所在部门合并构造单位（包括本部门、子单位和子单位部门）树
     * @param request
     * @param response
     * @param info
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectUnitDepTreeWithCandidate(HttpServletRequest request, HttpServletResponse response, OrgQueryInfo info) {
    	Map model = new HashMap();
    	SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
    	// 按根限定组织结构范围
    	String rootId = request.getParameter("rootId");
    	//单位ID
    	Long unitOrgId = null;
    	if (rootId != null && rootId.trim().length() > 0) {
    		unitOrgId = new Long(rootId);
    	} else {
    		unitOrgId = curUser.getSysOrg().getUnitOrgId();
    	}
    	//如无预设部门和预设人员，则查找当前单位所有部门
    	if( (Tools.isEmptyString(info.getOrgIds())) && (Tools.isEmptyString(info.getUserIds())) ){
    		List depTree =  this.departmentTreeBuilder.selectUnitDepAllTree(unitOrgId);
    		model.put("rootId", rootId);
    		model.put("depId", unitOrgId);
    		model.put("departmentTree", depTree);
    		model.put("loginStaff", curUser);
    		return new ModelAndView("manage/selectDepTreeWithCandidate", model);

    	}

    	// 如果有预设人员，则合并预设人员所在部门及预设部门
    	String candidateDepStr = unitOrgId.toString();
    	if(null != info.getOrgIds() && !"".equals(info.getOrgIds())){
    		candidateDepStr += "," + info.getOrgIds();
    	}
    	if (null != info.getUserIds() && !"".equals(info.getUserIds())) {
    	    SysUserInfoQueryInfo candidateUserInfo = new SysUserInfoQueryInfo();
    		candidateUserInfo.setUserInfoIds(info.getUserIds());
    		List<SysUserInfo> candidateUsers = this.manageService.selectDepartmentStaff(candidateUserInfo, true);
    		Map<Long, Object> candidateDeps = new HashMap();
    		for (int i = 0; i < candidateUsers.size(); i++) {
    			candidateDeps.put(candidateUsers.get(i).getOrgId(), "");
    		}
    		if (info.getOrgIds() != null && !"".equals(info.getOrgIds())) {
    			String[] deps = info.getOrgIds().split(",");
    			for (String dep : deps) {
    				candidateDeps.put(Long.parseLong(dep), "");
    			}
    		}
    		StringBuffer candidateDepBuf = new StringBuffer(100);
    		// 包含本单位及候选部门，包含本单位是为了构造树根节点
    		candidateDepBuf.append(unitOrgId);
    		for (Long candidateDepId : candidateDeps.keySet()) {
    			candidateDepBuf.append(",").append(candidateDepId);
    		}
    		candidateDepStr = candidateDepBuf.toString();
    	}

    	// 构造单位树
    	List depTree = this.departmentTreeBuilder.selectUnitDepTreeWithCandidate(unitOrgId, candidateDepStr);
    	if (depTree != null && depTree.size() > 0) { // 返回默认单位值
    		unitOrgId = new Long(((ITreeNode) depTree.get(0)).getNodeKey());
    	}
    	model.put("rootId", rootId);
    	model.put("depId", unitOrgId);
    	model.put("departmentTree", depTree);
    	model.put("loginStaff", curUser);
    	return new ModelAndView("manage/selectDepTreeWithCandidate", model);
    }

    /**
     * 将预设上级单位和部门与预设人员所在部门合并构造部门树
     * @param request
     * @param response
     * @param info
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectParentUnitDepTreeWithCandidate(HttpServletRequest request, HttpServletResponse response, OrgQueryInfo info) {
        Map model = new HashMap();
        SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
        // 按根限定组织结构范围
        String rootId = request.getParameter("rootId");
        Long depId = null;
        if (rootId != null && rootId.trim().length() > 0) {
            depId = new Long(rootId);
        } else {
            depId = curUser.getSysOrg().getUnitOrgId();
        }
        //如无预设部门和预设人员，则查找当前单位所有部门
        if( (Tools.isEmptyString(info.getOrgIds())) && (Tools.isEmptyString(info.getUserIds())) ){
            //获取是否包含本单位标识
            String itself = request.getParameter("itself");
            //通过登录用户获取上级单位和部门
            List depTree =  this.departmentTreeBuilder.selectParentUnitDepTree(depId, curUser.getSysOrg().getUnitOrgId(), Boolean.parseBoolean(itself));
            model.put("rootId", rootId);
            model.put("depId", depId);
            model.put("departmentTree", depTree);
            model.put("loginStaff", curUser);
            return new ModelAndView("manage/selectParentUnitDepTreeWithCandidate", model);

        }

        // 如果有预设人员，则合并预设人员所在部门及预设部门
        String candidateDepStr = depId.toString();
        if(null != info.getOrgIds() && !"".equals(info.getOrgIds())){
            candidateDepStr += "," + info.getOrgIds();
        }
        if (null != info.getUserIds() && !"".equals(info.getUserIds())) {
            SysUserInfoQueryInfo candidateUserInfo = new SysUserInfoQueryInfo();
            candidateUserInfo.setUserInfoIds(info.getUserIds());
            List<SysUserInfo> candidateUsers = this.manageService.selectDepartmentStaff(candidateUserInfo, true);
            Map<Long, Object> candidateDeps = new HashMap();
            for (int i = 0; i < candidateUsers.size(); i++) {
                candidateDeps.put(candidateUsers.get(i).getOrgId(), "");
            }
            if (info.getOrgIds() != null && !"".equals(info.getOrgIds())) {
                String[] deps = info.getOrgIds().split(",");
                for (String dep : deps) {
                    candidateDeps.put(Long.parseLong(dep), "");
                }
            }
            StringBuffer candidateDepBuf = new StringBuffer(100);
            // 包含本单位及候选部门，包含本单位是为了构造树根节点
            candidateDepBuf.append(depId);
            for (Long candidateDepId : candidateDeps.keySet()) {
                candidateDepBuf.append(",").append(candidateDepId);
            }
            candidateDepStr = candidateDepBuf.toString();
        }

        // 构造单位树
        List depTree = this.departmentTreeBuilder.selectUnitDepTreeWithCandidate(depId, candidateDepStr);
        if (depTree != null && depTree.size() > 0) { // 返回默认单位值
            depId = new Long(((ITreeNode) depTree.get(0)).getNodeKey());
        }
        model.put("rootId", rootId);
        model.put("depId", depId);
        model.put("departmentTree", depTree);
        model.put("loginStaff", curUser);
        return new ModelAndView("manage/selectParentUnitDepTreeWithCandidate", model);
    }

    /**
     * 选择上级单位所有部门的树(与预设部门无关)
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectParentUnitDepTree(HttpServletRequest request, HttpServletResponse response) {
        Map model = new HashMap();
        SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
        // 按根限定组织结构范围
        String rootId = request.getParameter("rootId");
        //所在单位
        SysOrg sysOrg = null;
        if (rootId != null && rootId.trim().length() > 0) {
            sysOrg = this.manageService.loadSysOrg(new Long(rootId));
        } else {
            sysOrg = this.manageService.loadSysOrg(curUser.getSysOrg().getUnitOrgId());
        }
        if (null == sysOrg || null == sysOrg.getParentOrgId()) {
            return new ModelAndView("manage/selectDepTreeWithCandidate", model);
        }
        //父单位
        SysOrg parentSysOrg = this.manageService.loadSysOrg(sysOrg.getParentOrgId());
        List depTree =  this.departmentTreeBuilder.selectUnitDepAllTree(parentSysOrg.getOrgId());
        model.put("rootId", rootId);
        model.put("depId", parentSysOrg.getOrgId());
        model.put("departmentTree", depTree);
        return new ModelAndView("manage/selectDepTreeWithCandidate", model);
    }

    /**
     * 根据预设部门和预设人员显示可选人员
     * @param request
     * @param response
     * @param info
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectMultiStaffFromCandidate(HttpServletRequest request, HttpServletResponse response, OrgQueryInfo info) {
        Map model = new HashMap();
        List candidateUserList = new ArrayList();
        //如果有预设部门，加载预设部门的人员到选择框
        if (Tools.isNotEmptyString(info.getOrgIds()) && null == info.getOrgId()) {
            String[] orgIdStringArray = info.getOrgIds().split(",");
            List candidateUserTempList = new ArrayList();
            for (int i = 0; i < orgIdStringArray.length; i++) {
                info.setOrgId(Long.parseLong(orgIdStringArray[i]));
                candidateUserTempList = this.buildStaffFromCandidate(info);
                //去除多个预设部门中重复的人员信息
                candidateUserList.removeAll(candidateUserTempList);
                candidateUserList.addAll(candidateUserTempList);
            }
        } else {
            //没有预设部门
            candidateUserList = this.buildStaffFromCandidate(info);
        }
        //已选人员回传
        List preStaffList = new ArrayList();
        if (null != info.getFilterIds() && !"".equals(info.getFilterIds())) {
            OrgQueryInfo preUsersInfo = new OrgQueryInfo();
            preUsersInfo.setUserIds(info.getFilterIds());
            preStaffList = this.manageService.selectStaffList(preUsersInfo, true);
        }

        model.put("preStaffList", preStaffList);
        model.put("candidateUserList", candidateUserList);
        return new ModelAndView("manage/selectMultiStaffFromCandidate", model);
    }

    /**
     * 根据预设部门和预设人员显示可选人员,默认显示当前部门所有人员(内部转办专用)
     * @param request
     * @param response
     * @param info
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectMultiStaffFromCandidateDeliver(HttpServletRequest request, HttpServletResponse response, OrgQueryInfo info) {
    	Map model = new HashMap();
    	List candidateUserList = new ArrayList();
    	SysUserInfo currUser = (SysUserInfo)Constants.getCurrentLoginUser(request);
    	info.setUserIds(currUser.getUserId().toString());
    	info.setOrgId(currUser.getOrgId());
    	candidateUserList = this.buildStaffFromCandidate(info);
    	//已选人员回传
    	List preStaffList = new ArrayList();
    	if (null != info.getFilterIds() && !"".equals(info.getFilterIds())) {
    		OrgQueryInfo preUsersInfo = new OrgQueryInfo();
    		preUsersInfo.setUserIds(info.getFilterIds());
    		preStaffList = this.manageService.selectStaffList(preUsersInfo, true);
    	}
    	Map staffMap = new HashMap();
    	List preStaffListNew = new ArrayList();
    	Object[] tempObject = new Object[3];
    	int len = null != preStaffList && preStaffList.size() > 0 ? preStaffList.size() : 0;
    	for (int i = 0; i < len; i++) {
    		tempObject = (Object[]) preStaffList.get(i);
    		SysUserInfo userInfo = (SysUserInfo) tempObject[0];
    		if (null == staffMap.get(userInfo.getUserInfoId())) {
    			preStaffListNew.add(tempObject);
    			staffMap.put(userInfo.getUserInfoId(), userInfo.getUserInfoId());
    		} else {
    			continue;
    		}
    	}
    	model.put("preStaffList", preStaffListNew);
    	model.put("candidateUserList", candidateUserList);
    	return new ModelAndView("manage/selectMultiStaffFromCandidate", model);
    }

    /**
     * 选择多个部门
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param info OrgQueryInfo
     * @return ModelAndView
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ModelAndView selectMultiDepBox(HttpServletRequest request, HttpServletResponse response, SysOrgQueryInfo info) {
        Map model = new HashMap();
        SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
        if(null == info.getUnitOrgId() || "".equals(info.getUnitOrgId())){
            info.setUnitOrgId(curUser.getSysOrg().getUnitOrgId());
        }
        List list = this.manageService.selectUnitAllDepts(info.getUnitOrgId());
        model.put("allDepInUnitList", list);
        if(null != info.getOrgIds() && !"".equals(info.getOrgIds())){
           List<SysOrg> selectedDepList =  this.manageService.selectDapartment(info, true);
           model.put("selectedDepList", selectedDepList);
        }
        model.put("info", info);
        return new ModelAndView("manage/selectMultiDepBox", model);
    }


    /**
     * @param departmentTreeBuilder the departmentTreeBuilder to set
     */
    public void setDepartmentTreeBuilder(IDepartmentTreeBuilder departmentTreeBuilder) {
        this.departmentTreeBuilder = departmentTreeBuilder;
    }

    /**
     * 构建候选人
     * @param info OrgQueryInfo
     * @return candidateUserList <ArrayList>
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private List buildStaffFromCandidate(OrgQueryInfo info) {
        List candidateUserList = new ArrayList();
        if (Tools.isNotEmptyString(info.getUserIds())) {
            OrgQueryInfo candidateUserInfo = new OrgQueryInfo();
            candidateUserInfo.setUserIds(info.getUserIds());
            candidateUserList = this.manageService.selectStaffList(candidateUserInfo, true);
        }
        Map userMap = new HashMap();
        if(candidateUserList.size() > 0){
            for(int i=0; i < candidateUserList.size(); i++ ){
                Object[] data = (Object[])candidateUserList.get(i);
                SysUserInfo sysUserInfo = (SysUserInfo)(data[0]);
                userMap.put(sysUserInfo.getUserInfoId(), "");
            }
        }
        //查询已预设部门用户，如果该部门已存在预设用户，则剔除该部门全部用户
        if (info.getOrgId() != null) {
            OrgQueryInfo candidateUserInfo = new OrgQueryInfo();
            candidateUserInfo.setOrgId(info.getOrgId());
            List candidateDepUserList = this.manageService.selectStaffList(candidateUserInfo, true);
            List allCandidtateDepUserList = new ArrayList(candidateDepUserList);
            for(Iterator i = candidateDepUserList.iterator(); i.hasNext();  ){
                Object[] data = (Object[])i.next();
                SysUserInfo sysUserInfo = (SysUserInfo)data[0];
                if (!userMap.containsKey(sysUserInfo.getUserInfoId())) {
                    i.remove();
                }
            }
            if (candidateDepUserList.isEmpty()) {
                return allCandidtateDepUserList;
            } else {
                return candidateDepUserList;
            }
        }
        return candidateUserList;
    }

    /**
     * 以rootId为根节点构造出来的单选部门树
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectMultiStaffFromAll(HttpServletRequest request, HttpServletResponse response) {
        Map model = new HashMap();
        SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
        // 按根限定组织结构范围
        String rootId = request.getParameter("rootId");
        //单位ID
        Long unitOrgId = null;
        if (rootId != null && rootId.trim().length() > 0) {
            unitOrgId = new Long(rootId);
        } else {
            unitOrgId = curUser.getSysOrg().getUnitOrgId();
        }
        List depTree =  this.departmentTreeBuilder.selectUnitDepAllTree(unitOrgId);
        model.put("rootId", rootId);
        model.put("depId", unitOrgId);
        model.put("departmentTree", depTree);
        return new ModelAndView("manage/selectDepTreeWithCandidate", model);
    }

    /**
     * 以rootId为根节点构造出来的单选部门树
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectRootIdDepTree(HttpServletRequest request, HttpServletResponse response) {
        Map model = new HashMap();
        SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
        // 按根限定组织结构范围
        String rootId = request.getParameter("rootId");
        //单位ID
        Long unitOrgId = null;
        if (rootId != null && rootId.trim().length() > 0) {
            unitOrgId = new Long(rootId);
        } else {
            unitOrgId = curUser.getSysOrg().getUnitOrgId();
        }
        List depTree =  this.departmentTreeBuilder.selectUnitDepAllTree(unitOrgId);
        model.put("rootId", rootId);
        model.put("depId", unitOrgId);
        model.put("departmentTree", depTree);
        return new ModelAndView("manage/departmentSingleTree", model);
    }

    /**
     * 以rootId为根节点构造出来的多选部门树
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView checkbox形式的多选部门树
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectRootIdMultiDepTree(HttpServletRequest request, HttpServletResponse response) {
        Map model = new HashMap();
        SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
        // 按根限定组织结构范围
        String rootId = request.getParameter("rootId");
        //单位ID
        Long unitOrgId = null;
        if (rootId != null && rootId.trim().length() > 0) {
            unitOrgId = new Long(rootId);
        } else {
            unitOrgId = curUser.getSysOrg().getUnitOrgId();
        }
        List depTree =  this.departmentTreeBuilder.selectUnitDepAllTree(unitOrgId);
        model.put("rootId", rootId);
        model.put("depId", unitOrgId);
        model.put("departmentTree", depTree);
        model.put("selectDepId", null == request.getParameter("selectDepId") ? null : ((String) request
                .getParameter("selectDepId")).split(","));
        // 不可选的单位
        model.put("notSelectDepId", null == request.getParameter("notSelectDepId") ? null : ((String) request
                .getParameter("notSelectDepId")).split(","));
        String nextUrl = request.getParameter("nextUrl");
        if (nextUrl != null && nextUrl.length() != 0) {
            model.put("nextUrl", nextUrl);
        }
        return new ModelAndView("manage/departmentMutlTreeCheckbox", model);
    }

    /**
     * 以rootId为根节点构造出来的多选单位树
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView checkbox形式的多选部门树
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ModelAndView selectRootIdMultiUnitRanksTree(HttpServletRequest request, HttpServletResponse response, SysOrgQueryInfo info) {
        Map model = new HashMap();
        SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
        // 按根限定组织结构范围
        //单位ID
        Long unitOrgId = null;
        if (info.getRootId() != null) {
            unitOrgId = info.getRootId();
        } else {
            unitOrgId = curUser.getSysOrg().getUnitOrgId();
        }
        info.setUnitOrgId(unitOrgId);
        List depTree =  this.departmentTreeBuilder.selectUnitWithRanksTree(info);
        model.put("rootId", info.getRootId());
        model.put("depId", unitOrgId);
        model.put("departmentTree", depTree);
        //已选单位
        model.put("selectDepId", null == request.getParameter("selectDepId") ? null : ((String) request
                .getParameter("selectDepId")).split(","));
        // 不可选的单位
        model.put("notSelectDepId", null == request.getParameter("notSelectDepId") ? null : ((String) request
                .getParameter("notSelectDepId")).split(","));
        //必须选择的单位
        model.put("mustSelectDepId", null == request.getParameter("mustSelectDepId") ? null : ((String) request
                .getParameter("mustSelectDepId")).split(","));
        String nextUrl = request.getParameter("nextUrl");
        if (nextUrl != null && nextUrl.length() != 0) {
            model.put("nextUrl", nextUrl);
        }
        return new ModelAndView("manage/mutiUnitTree", model);
    }
}
