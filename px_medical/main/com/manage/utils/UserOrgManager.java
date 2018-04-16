/*
 * <p> Title:  UserOrgManager.java</p>
 * <p>Copyright:   BoFan (b) 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.manage.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bofan.basesystem.common.command.Page;
import com.bofan.manage.valueobject.SysFunction;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysRole;
import com.bofan.manage.valueobject.SysRoleFunctionMapping;
import com.bofan.manage.valueobject.SysRoleOrgMapping;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.utils.DataPage;
import com.bofan.utils.JsonNodeUtils;
import com.manage.command.RoleFunctionMappingQueryInfo;
import com.manage.command.SysRoleOrgMappingQueryInfo;
import com.manage.command.SysRoleQueryInfo;
import com.manage.command.SysUserInfoInOrgQueryInfo;
import com.manage.command.SysUserInfoOrgFullQueryInfo;
import com.manage.command.SysUserInfoRoleFullQueryInfo;
import com.manage.service.UserOrgService;

/**
 * <p>
 * Calss Name: UserOrgManager.java
 * </p>
 * <p>
 * Description: 用户、机构数据共享池管理器 ,用于提供共享池数据加载、访问等
 * </p>
 *
 * @version 1.0
 * @author pch
 * @created 2018-2-18
 */
@Component
public class UserOrgManager {

    /**
     * 数据库查询服务对象
     */
    @Autowired
    private UserOrgService userOrgService;

    private long lastReloadTime;

    /**
     * 根节点机构
     */
    private Org rootOrg;
    /**
     * 根节点功能模块
     */
    private Function rootFunction;
    /**
     * 共享池机构Map(orgId:org)
     */
    private LinkedHashMap<Long, Org> orgMap;
    /**
     * 共享池用户Map(userInfoId:User)
     */
    private HashMap<Long, User> userMap;
    /**
     * 共享池模块Map(funcitonId:Function)
     */
    private LinkedHashMap<Long, Function> functionMap;
    /**
     * 共享池角色Map(roleId: Role)
     */
   // private LinkedHashMap<Long, Role> roleMap;

    private boolean checkTimeout() {
        return (System.currentTimeMillis() - this.lastReloadTime > 10 * 1000);
    }

    public Org getRootOrg() {
        synchronized (this) {
            if (this.rootOrg != null && !checkTimeout()) {
                return this.rootOrg;
            }
        }
        LinkedHashMap<Long, Org> orgMap = new LinkedHashMap<Long, Org>();
        Org rootOrg = new Org();
        reloadOrgTree(orgMap, rootOrg);
        synchronized (this) {
            this.rootOrg = rootOrg;
            this.orgMap = orgMap;
            return rootOrg;
        }
    }

    public void setTimeOut() {
        this.lastReloadTime = this.lastReloadTime - 11 * 1000;
    }

    public void reflushLoadTime() {
        this.lastReloadTime = System.currentTimeMillis();
    }

    /**
     * 通过orgId获取机构信息
     *
     * @param orgId
     * @return
     */
    public Org getOrg(Long orgId) {
        synchronized (this) {
            if (this.orgMap != null && !checkTimeout()) {
                return this.orgMap.get(orgId);
            }
        }
        LinkedHashMap<Long, Org> orgMap = new LinkedHashMap<Long, Org>();
        Org rootOrg = new Org();
        reloadOrgTree(orgMap, rootOrg);
        synchronized (this) {
            this.rootOrg = rootOrg;
            this.orgMap = orgMap;
            this.reflushLoadTime();
            return orgMap.get(orgId);
        }
    }

    /**
     * 通过userInfoId获取用户信息
     *
     * @param userInfoId
     * @return
     */
    public User getUser(Long userInfoId) {
        synchronized (this) {
            if (this.userMap != null && this.userMap.get(userInfoId) != null && !checkTimeout()) {
                return this.userMap.get(userInfoId);
            }
        }
        User user = this.reloadUser(userInfoId);
        synchronized (this) {
            if (this.userMap == null) {
                this.userMap = new HashMap<Long, User>();
            }
            this.userMap.put(userInfoId, user);
            this.reflushLoadTime();
            return user;
        }
    }

    /**
     * 根据用户userInfoId查询用户列表
     * @param userInfoIds
     * @return
     */
    public List<User> getUserList(Long[] userInfoIds) {
        if (userInfoIds == null || userInfoIds.length == 0) {
            return null;
        }
        SysUserInfoOrgFullQueryInfo info = new SysUserInfoOrgFullQueryInfo();
        info.setUserInfoIds(userInfoIds);
        List<SysUserInfo> sysUserInfoList = this.userOrgService.selectUserInfoWithOrg(info);
        if (sysUserInfoList != null ) {
            List<User> users = new ArrayList<User>();
            for (SysUserInfo sui : sysUserInfoList) {
                users.add(new User(sui));
            }
            return users;
        }
        return null;
    }

    /**
     * 取一个机构下的所有用户
     *
     * @param orgId
     * @return List<User>
     */
    public List<User> getUsersInOrg(Long orgId) {
        Org org = this.getOrg(orgId);
        synchronized (org) {
            if (org != null && org.users != null && !checkTimeout()) {
                return org.users;
            }
        }
        SysUserInfoInOrgQueryInfo info = new SysUserInfoInOrgQueryInfo();
        info.setOrgIds(new Long[] { orgId });
        List<SysUserInfo> userInfoList = userOrgService.selectUserInfoInOrg(info);
        if (userInfoList == null || userInfoList.size() == 0) {
            return null;
        }
        List<User> users = new ArrayList<User>();
        for (SysUserInfo userInfo : userInfoList) {
            users.add(new User(userInfo));
        }
        synchronized (org) {
            org.users = users;
            if (this.userMap == null) {
                this.userMap = new HashMap<Long, User>();
            }
            for (User user : users) {
                this.userMap.put(user.userInfoId, user);
            }
            this.reflushLoadTime();
        }
        return users;
    }

    /**
     * 取得功能模块树结构数据
     * @return
     */
    public Function getRootFunction() {
        rootFunction = new Function(1L);
        this.functionMap = new LinkedHashMap<Long, Function>();
        reloadFunctionTree(functionMap, rootFunction);
        return rootFunction;
    }

//    public synchronized List<Function> getAllFunctions() {
//        synchronized (this) {
//            if (this.functionMap != null && !checkTimeout()) {
//                return new ArrayList<Function>(this.functionMap.values());
//            }
//        }
//        LinkedHashMap<Long, Function> functionMap = new LinkedHashMap<Long, Function>();
//        Function rootFunc = new Function(1L);
//        reloadFunctionTree(functionMap, rootFunc);
//        synchronized (this) {
//            this.rootFunction = rootFunc;
//            this.functionMap = functionMap;
//            return new ArrayList<Function>(this.functionMap.values());
//        }
//    }

    public Function getFunction(Long functionId) {
        synchronized (this) {
            if (this.functionMap != null && !checkTimeout()) {
                return this.functionMap.get(functionId);
            }
        }
        LinkedHashMap<Long, Function> functionMap = new LinkedHashMap<Long, Function>();
        Function rootFunc = new Function(1L);
        reloadFunctionTree(functionMap, rootFunc);
        synchronized (this) {
            this.rootFunction = rootFunc;
            this.functionMap = functionMap;
            return functionMap.get(functionId);
        }
    }

    public Role getRole(Long roleId) {
        SysRoleQueryInfo info = new SysRoleQueryInfo();
        info.setRoleId(roleId);
        return this.findRole(info);
    }

    /**
     * 查找角色对象
     *
     * @param info
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Role findRole(SysRoleQueryInfo info) {
        Page page = this.userOrgService.selectRolePage(info);
        List data = page.getData();
        if (data == null || data.size() == 0) {
            return null;
        }
        return new Role((SysRole) data.get(0));
    }

    public Role getRole(String roleName) {
        SysRoleQueryInfo info = new SysRoleQueryInfo();
        info.setRoleName(roleName);
        return this.findRole(info);
    }

    /**
     * 角色分页查询
     *
     * @param info
     *            SysRoleQueryInfo
     * @return Page<Role>
     */
    @SuppressWarnings({ "unchecked" })
    public Page selectRolePage(SysRoleQueryInfo info) {
        Page page = this.userOrgService.selectRolePage(info);
        List<Role> roleList = new ArrayList<Role>();
        for (SysRole role : (List<SysRole>) page.getData()) {
            roleList.add(new Role(role));
        }
        return new DataPage(roleList, page.getTotalSize(), page.getPageSize(), page.getPageNumber(), page.getToken());
    }

    /**
     * 角色信息查询, 不分页
     *
     * @param info
     *            SysRoleQueryInfo
     * @return List<Role>
     */
    public List<Role> selectRoleList(SysRoleQueryInfo info) {
        List<SysRole> sysRoles = this.userOrgService.selectRoleList(info);
        List<Role> roleList = new ArrayList<Role>();
        for (SysRole role : sysRoles) {
            roleList.add(new Role(role));
        }
        return roleList;
    }

    /**
     * 查询用户对应的部门信息
     *
     * @param userInfoIds
     * @return Map<Long, List<Org>> (userInfoId:List<Org>)
     */
    public Map<Long, List<Org>> getOrgOfUsers(Long[] userInfoIds) {
        SysUserInfoOrgFullQueryInfo info = new SysUserInfoOrgFullQueryInfo();
        info.setUserInfoIds(userInfoIds);
        List<SysUserInfo> userInfoList = this.userOrgService.selectUserInfoWithOrg(info);
        if (userInfoList == null || userInfoList.size() == 0) {
            return null;
        }
        Map<Long, List<Org>> userOrgMap = new LinkedHashMap<Long, List<Org>>();
        for (SysUserInfo ui : userInfoList) {
            Set<SysOrg> orgs = ui.getSysUser().getUserOrgs();
            if (orgs == null || orgs.size() == 0) {
                continue;
            }
            Long userInfoId = ui.getUserInfoId();
            List<Org> orgList = userOrgMap.get(userInfoId);
            if (orgList == null) {
                orgList = new ArrayList<Org>();
            }
            for (SysOrg sysOrg : orgs) {
                Org org = new Org(sysOrg);
                orgList.add(org);
            }
            userOrgMap.put(userInfoId, orgList);
        }
        return userOrgMap;
    }

    /**
     * 根据userInfoId获得该用户所在所有部门ID
     * @param userInfoId Long
     * @return Long[]
     */
    public Long[] getOrgIdsOfUser(Long userInfoId) {
        Map<Long, List<Org>> userOrgMap = this.getOrgOfUsers(new Long[]{userInfoId});
        List<Long> orgIdList = new ArrayList<Long>();
        if (userOrgMap != null && userOrgMap.containsKey(userInfoId)) {
            this.buildOrgIdNameToList(userOrgMap.get(userInfoId), orgIdList, null);
        }
        return orgIdList.toArray(new Long[orgIdList.size()]);
    }

    /**
     * 取得用户所在部门org {id:name}
     * @param userInfoId Long
     * @return Map<Long, String>
     */
    public Map<Long, String> getOrgMapOfUser(Long userInfoId) {
        Map<Long, List<Org>> userOrgMap = this.getOrgOfUsers(new Long[]{userInfoId});
        Map<Long, String> orgIdNameMap = new HashMap<Long,String>();
        if (userOrgMap != null && userOrgMap.containsKey(userInfoId)) {
            for (Org org : userOrgMap.get(userInfoId)) {
                orgIdNameMap.put(org.getOrgId(), org.getName());
            }
        }
        return orgIdNameMap;
    }

    /**
     * 查询用户对应的授权角色
     *
     * @param userInfoIds
     * @return Map<Long, List<Role>> (userInfoId:List<Role>)
     */
    public Map<Long, List<Role>> getRoleListOfUsers(Long[] userInfoIds) {
        SysUserInfoRoleFullQueryInfo info = new SysUserInfoRoleFullQueryInfo();
        info.setUserInfoIds(userInfoIds);
        List<SysUserInfo> userInfoList = this.userOrgService.selectUserInfoListOfRoles(info);
        if (userInfoList == null || userInfoList.size() == 0) {
            return null;
        }
        Map<Long, List<Role>> userRoleMap = new LinkedHashMap<Long, List<Role>>();
        for (SysUserInfo ui : userInfoList) {
            Set<SysRole> roles = ui.getSysUser().getUserRoles();
            if (roles == null || roles.size() == 0) {
                continue;
            }
            Long userInfoId = ui.getUserInfoId();
            List<Role> roleList = userRoleMap.get(userInfoId);
            if (roleList == null) {
                roleList = new ArrayList<Role>();
            }
            for (SysRole sysRole : roles) {
                Role role = new Role(sysRole);
                roleList.add(role);
            }
            userRoleMap.put(userInfoId, roleList);
        }
        return userRoleMap;
    }

    /**
     * 根据角色Id列表获得各个角色包含的用户
     *
     * @param roleIds
     * @return
     */
    public Map<Long, List<User>> getUserListOfRoles(Long[] roleIds) {
        if (roleIds == null || roleIds.length == 0) {
            return null;
        }
        SysUserInfoRoleFullQueryInfo info = new SysUserInfoRoleFullQueryInfo();
        info.setRoleIds(roleIds);
        List<SysUserInfo> userRoleList = this.userOrgService.selectUserInfoListOfRoles(info);
        if (userRoleList == null || userRoleList.size() == 0) {
            return null;
        }
        Map<Long, List<User>> roleUserMap = new LinkedHashMap<Long, List<User>>();
        for (SysUserInfo ui : userRoleList) {
            Set<SysRole> sysRoles = ui.getSysUser().getUserRoles();
            if (sysRoles == null) {
                continue;
            }
            for (SysRole sysRole : sysRoles) {
                Long roleId = sysRole.getRoleId();
                if (roleId == null || !Arrays.asList(roleIds).contains(roleId)) {
                    continue;
                }
                List<User> userList = roleUserMap.get(sysRole.getRoleId());
                if (userList == null) {
                    userList = new ArrayList<User>();
                    roleUserMap.put(roleId, userList);
                }
                userList.add(new User(ui));
            }
        }
        return roleUserMap;
    }

    /**
     * 查询用户对应的授权模块
     *
     * @param userInfoIds
     * @return Map<Long, List<Function>> (userInfoId:List<Function>)
     */
    public Map<Long, List<Function>> getFunctionOfUsers(Map<Long, List<Role>> userInfoIdRoleMap) {
        if (userInfoIdRoleMap == null) {
            return null;
        }
        // 用于查询roleFunction关联的roleId参数
        List<Long> roleIds = new ArrayList<Long>();
        // 记录拥有某一角色的用户id
        Map<Long, Map<Long, Long>> roleIdUserInfoIdsMap = new HashMap<Long, Map<Long, Long>>();
        for (Map.Entry<Long, List<Role>> userRole : userInfoIdRoleMap.entrySet()) {
            Long userInfoId = userRole.getKey();
            for (Role role : userRole.getValue()) {
                Long roleId = role.getRoleId();
                Map<Long, Long> userInfoIdsMap = roleIdUserInfoIdsMap.get(roleId);
                if (userInfoIdsMap == null) {
                    userInfoIdsMap = new HashMap<Long, Long>();
                }
                userInfoIdsMap.put(userInfoId, userInfoId);
                roleIdUserInfoIdsMap.put(roleId, userInfoIdsMap);
                if (!roleIds.contains(roleId)) {
                    roleIds.add(roleId);
                }
            }
        }
        // 查询roleFunction管理数据
        RoleFunctionMappingQueryInfo roleFunctionInfo = new RoleFunctionMappingQueryInfo();
        roleFunctionInfo.setRoleIds(roleIds.toArray(new Long[roleIds.size()]));
        List<SysRoleFunctionMapping> roleMappingList = this.userOrgService.selectRoleFunctionMapping(roleFunctionInfo);
        if (roleMappingList == null || roleMappingList.size() == 0) {
            return null;
        }
        // 填充Map<userInfoId:List<Function>>
        Map<Long, List<Function>> userFunctionMap = new HashMap<Long, List<Function>>();
        for (SysRoleFunctionMapping rf : roleMappingList) {
            Long roleId = rf.getCompId().getRoleId();
            Map<Long, Long> userInfoIdsMap = roleIdUserInfoIdsMap.get(roleId);
            if (userInfoIdsMap == null) {
                continue;
            }
            Function func = new Function(rf.getSysFunction());
            for (Long userInfoId : userInfoIdsMap.keySet()) {
                List<Function> funcList = userFunctionMap.get(userInfoId);
                if (funcList == null) {
                    funcList = new ArrayList<Function>();
                }
                funcList.add(func);
                userFunctionMap.put(userInfoId, funcList);
            }
        }
        return userFunctionMap;
    }

    /**
     * 取得用户所在单位列表(单位Id数组)
     *
     * @param userInfoId
     * @return
     */
    public Long[] getUnitIdsOfUser(Long userInfoId) {
        Map<Long, List<Org>> userOrgMap =  this.getOrgOfUsers(new Long[]{ userInfoId});
        List<Long> unitIdList = new ArrayList<Long>();
        if (userOrgMap != null) {
            for (Org org : userOrgMap.get(userInfoId)) {
                Long orgId = null;
                if (org.isUnit() ) {
                    orgId = org.getOrgId();
                } else if (org.getUnitOrgId() != null) {
                    orgId = org.getUnitOrgId();
                } else {
                    continue;
                }
                if (!unitIdList.contains(org.getOrgId())) {
                    unitIdList.add(orgId);
                }
            }
        }
        return unitIdList.toArray(new Long[unitIdList.size()]);
    }

    /**
     * 根据角色列表获得各个角色的授权模块
     *
     * @param roleIds
     * @return Map<Long, List<Function>>
     */
    @SuppressWarnings("unchecked")
    public Map<Long, List<Function>> getFunctionListOfRoles(Long[] roleIds) {
        if (roleIds == null || roleIds.length == 0) {
            return null;
        }
        RoleFunctionMappingQueryInfo info = new RoleFunctionMappingQueryInfo();
        info.setRoleIds(roleIds);
        List<SysRoleFunctionMapping> roleFuncList = this.userOrgService.selectRoleFunctionMapping(info);
        if (roleFuncList == null || roleFuncList.size() == 0) {
            return null;
        }
        Map<Long, List<Function>> roleFunctionMap = new HashMap<Long, List<Function>>();
        List<Long> roleIdList = Arrays.asList(roleIds);
        for (SysRoleFunctionMapping rfm : roleFuncList) {
            Long roleId = rfm.getSysRole().getRoleId();
            if (!roleIdList.contains(roleId)) {
                continue;
            }
            List<Function> funcs = roleFunctionMap.get(roleId);
            if (funcs == null) {
                funcs = new ArrayList<Function>();
                roleFunctionMap.put(roleId, funcs);
            }
            funcs.add(new Function(rfm.getSysFunction()));
        }
        return roleFunctionMap;
    }

    /**
     * 查询角色的授权单位信息
     *
     * @param roleIds
     * @return
     */
    @SuppressWarnings("unchecked")
    public Map<Long, List<Org>> getAuthOrgListOfRoles(Long[] roleIds) {
        if (roleIds == null || roleIds.length == 0) {
            return null;
        }
        SysRoleOrgMappingQueryInfo info = new SysRoleOrgMappingQueryInfo();
        info.setRoleIds(roleIds);
        List<SysRoleOrgMapping> roleOrgList = this.userOrgService.selectRoleOrgMapping(info);
        if (roleOrgList == null || roleOrgList.size() == 0) {
            return null;
        }
        Map<Long, List<Org>> roleAuthOrgMap = new HashMap<Long, List<Org>>();
        List<Long> roleIdList = Arrays.asList(roleIds);
        for (SysRoleOrgMapping rom : roleOrgList) {
            Long roleId = rom.getCompId().getRoleId();
            if (!roleIdList.contains(roleId)) {
                continue;
            }
            List<Org> authOrgs = roleAuthOrgMap.get(roleId);
            if (authOrgs == null) {
                authOrgs = new ArrayList<Org>();
                roleAuthOrgMap.put(roleId, authOrgs);
            }
            authOrgs.add(new Org(rom.getSysOrg()));
        }
        return roleAuthOrgMap;
    }

    /**
     * 重新加载机构树
     */
    private void reloadOrgTree(LinkedHashMap<Long, Org> orgMap, Org rootOrg) {
        List<SysOrg> orgs = this.userOrgService.selectAllOrgs();
        for (SysOrg org : orgs) {
            orgMap.put(org.getOrgId(), new Org(org));
        }
        for (Org org : orgMap.values()) {
            if (org.isTop()) {
                rootOrg.childOrgs.add(org);
                if (org.isUnit()) {
                    rootOrg.childUnits.add(org);
                } else {
                    rootOrg.childDeps.add(org);
                }
            }
            if (org.parentOrgId != null && !org.parentOrgId.equals(org.orgId)) {
                Org parent = orgMap.get(org.parentOrgId);
                if (parent == null) {
                    continue;
                }
                parent.childOrgs.add(org);
                if (org.isUnit()) {
                    parent.childUnits.add(org);
                } else {
                    parent.childDeps.add(org);
                }
            }
        }
        orgMap.put(0L, rootOrg);
    }

    /**
     * 重新加载单个用户
     */
    private User reloadUser(Long userInfoId) {
        SysUserInfo userInfo = userOrgService.loadUserInfo(userInfoId);
        return new User(userInfo);
    }

    /**
     * 重新加载Function树
     *
     * @param functionMap
     * @param rootFunc
     */
    private void reloadFunctionTree(LinkedHashMap<Long, Function> functionMap, Function rootFunc) {
        List<SysFunction> functions = userOrgService.selectAllFunction();
        for (SysFunction sysFunc : functions) {
            functionMap.put(sysFunc.getFunctionId(), new Function(sysFunc));
        }
        for (Function func : functionMap.values()) {
            if (func.parentId == 1L) {
                func.parent = rootFunc;
                rootFunc.children.add(func);
            } else {
                func.parent = functionMap.get(func.parentId);
                if (func.parent != null && func.parent.children != null) {
                    func.parent.children.add(func);
                }
            }
        }
        functionMap.put(1L, rootFunc);
    }

    /**
     * 缓冲池中的org对象类
     */
    public class Org {
        private Long orgId;
        private String name;
        private String code;
        private String address;
        private String director;
        private String directorTel;
        private String attributeId;
        private Long parentOrgId;
        private Long unitOrgId;
        private String orgRank;
        private String remark;
        private Long sort;
        private List<Org> childOrgs;
        private List<Org> childUnits;
        private List<Org> childDeps;
        private List<User> users;

        private Org() {
            this.orgId = 0L;
            this.childOrgs = new ArrayList<Org>();
            this.childUnits = new ArrayList<Org>();
            this.childDeps = new ArrayList<Org>();
        }

        private Org(SysOrg org) {
            this.orgId = org.getOrgId();
            this.name = org.getName();
            this.code = org.getCode();
            this.address = org.getAddress();
            this.director = org.getDirector();
            this.directorTel = org.getDirectorTel();
            this.attributeId = org.getAttributeId();
            this.parentOrgId = org.getParentOrgId();
            this.unitOrgId = org.getUnitOrgId();
            this.orgRank = org.getOrgRank();
            this.remark = org.getRemark();
            this.sort = org.getSort();
            this.childOrgs = new ArrayList<Org>();
            this.childUnits = new ArrayList<Org>();
            this.childDeps = new ArrayList<Org>();
        }

        public Long getOrgId() {
            return orgId;
        }

        public String getName() {
            return name;
        }

        public Long getUnitOrgId() {
            return unitOrgId;
        }

        public void setUnitOrgId(Long unitOrgId) {
            this.unitOrgId = unitOrgId;
        }

        public String getCode() {
            return code;
        }

        public String getAddress() {
            return address;
        }

        public String getDirector() {
            return director;
        }

        public String getDirectorTel() {
            return directorTel;
        }

        /**
		 * @return the attributeId
		 */
		public String getAttributeId() {
			return attributeId;
		}

		public Long getParentOrgId() {
            return this.parentOrgId;
        }

        public Org getParentOrg() {
            return this.parentOrgId != null ? orgMap.get(this.parentOrgId) : null;
        }

        public Org getUnitOrg() {
            return this.unitOrgId != null ? orgMap.get(this.unitOrgId) : null;
        }

        public String getOrgRank() {
            return orgRank;
        }

        public String getRemark() {
            return remark;
        }

        public Long getSort() {
            return sort;
        }

        public List<Org> getChildOrgs() {
            return Collections.unmodifiableList(childOrgs);
        }

        public List<Org> getChildUnits() {
            return Collections.unmodifiableList(childUnits);
        }

        public List<Org> getChildDeps() {
            return Collections.unmodifiableList(childDeps);
        }

        public boolean isUnit() {
            for (String rank : SysOrg.UNIT_RANKS) {
                if (rank.equals(this.orgRank)) {
                    return true;
                }
            }
            return false;
        }

        public void getAllSubOrgs(Org root, List<Org> resultList) {
            if (root.childOrgs == null) {
                return;
            }
            resultList.addAll(Collections.unmodifiableList((root.childOrgs)));
            for (Org org : root.childOrgs) {
                getAllSubOrgs(org, resultList);
            }
        }

        public boolean isTop() {
            // 当组织结构 为顶层时： org_id=parent_org_id=unit_org_id
            return this.orgId.equals(parentOrgId) && this.orgId.equals(unitOrgId);
        }
    }

    /**
     * 缓冲池中的User对象类
     */
    public class User {
        private Long userInfoId;
        private Long userId;
        private String account;
        private String status;
        private String name;
        private String sex;
        private Integer age;
        private Long dutyId;
        private String duty;
        private String phone;
        private String workPhone;
        private String workAddress;
        private String photograph;
        private String code;// 用户编码
        private String fax;
        private String email;
        private String remark;
        private Long sort;
        private Long orgId;
        private String orgName;
        private String delFlag;
        //private List<Org> orgs = new ArrayList<Org>();
        //private List<Role> roles = new ArrayList<Role>();

        public User(SysUserInfo user) {
            this.userInfoId = user.getUserInfoId();
            this.userId = user.getUserId();
            this.account = user.getSysUser().getAccount();
            this.status = user.getSysUser().getStatus();
            this.name = user.getName();
            this.sex = user.getSex();
            this.age = user.getAge();
            this.dutyId = user.getDutyId();
            this.duty = user.getSysDuty() != null ? user.getSysDuty().getName() : null;
            this.phone = user.getPhone();
            this.workPhone = user.getWorkPhone();
            this.workAddress = user.getWorkAddress();
            this.photograph = user.getPhotograph();
            this.code = user.getCode();// 用户编码
            this.fax = user.getFax();
            this.email = user.getEmail();
            this.remark = user.getRemark();
            this.sort = user.getSort();
            this.orgId = user.getOrgId();
            this.orgName = user.getSysOrg() != null ? user.getSysOrg().getName() : null;
            this.delFlag = user.getSysUser().getDelFlag();
        }

        public Long getUserInfoId() {
            return userInfoId;
        }

        public Long getUserId() {
            return userId;
        }

        public String getAccount() {
            return account;
        }

        public String getStatus() {
            return status;
        }

        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        public Integer getAge() {
            return age;
        }

        public Long getDutyId() {
            return dutyId;
        }

        public String getDuty() {
            return duty;
        }

        public String getPhone() {
            return phone;
        }

        public String getWorkPhone() {
            return workPhone;
        }

        public String getWorkAddress() {
            return workAddress;
        }

        public String getPhotograph() {
            return photograph;
        }

        public String getCode() {
            return code;
        }

        public String getFax() {
            return fax;
        }

        public String getEmail() {
            return email;
        }

        public String getRemark() {
            return remark;
        }

        public Long getSort() {
            return sort;
        }

        public Org getOrg() {
            return orgMap.get(this.orgId);
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public Long getOrgId() {
            return orgId;
        }

        public void setOrgId(Long orgId) {
            this.orgId = orgId;
        }
    }

    /**
     * 缓冲池中的角色对象类
     */
    public static class Role {
        private Long roleId;
        private String code;
        private String note;
        private String name;
        private String sysType;
        private String roleInName;
        //private List<User> users = new ArrayList<User>();
        //private List<Function> functions = new ArrayList<Function>();
        //private List<Org> authOrgs = new ArrayList<Org>();

        public Role(SysRole role) {
            this.roleId = role.getRoleId();
            this.code = role.getRoleCode();
            this.note = role.getRoleNode();
            this.name = role.getRoleName();
            this.sysType = role.getSysType();
            this.roleInName = role.getRoleInName();
        }

        public Long getRoleId() {
            return roleId;
        }

        public String getName() {
            return name;
        }

        public String getSysType() {
            return sysType;
        }

        public String getCode() {
            return code;
        }

        public String getNote() {
            return note;
        }

        public String getRoleInName() {
            return roleInName;
        }
    }

    /**
     * 缓冲池中的模块对象类
     */
    public static class Function {
        private Long functionId;
        private String name;
        private String code;
        private String operate;
        private Long parentId;
        private BigDecimal sort;
        private String sysType;
        private String other;
        private Function parent;
        private ArrayList<Function> children = new ArrayList<Function>();

        public Function(Long functionId) {
            this.functionId = functionId;
        }

        public Function(SysFunction func) {
            this.functionId = func.getFunctionId();
            this.name = func.getName();
            this.code = func.getCode();
            this.operate = func.getFunctionOperate();
            this.parentId = func.getParentId();
            this.sort = func.getSort();
            this.sysType = func.getSysType();
            this.other = func.getOther();
        }

        public Long getFunctionId() {
            return functionId;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        public String getOperate() {
            return operate;
        }

        public Long getParentId() {
            return parentId;
        }

        public BigDecimal getSort() {
            return sort;
        }

        public String getSysType() {
            return sysType;
        }

        public String getOther() {
            return other;
        }

        public ArrayList<Function> getChildren() {
            return children;
        }

        public Function getParent() {
            return parent;
        }

    }

    /** 以下是构建符合json结构的相关数据工具函数，包括用户、角色、模块节点或者列表数据 */
    /**
     * 创建机构节点
     *
     * @param org
     * @param multi
     *            是否添加checkbox按钮
     * @param deep
     *            递归深度 用于判断是否打开该节点
     * @return
     */
    public Map<String, Object> createOrgNode(UserOrgManager.Org org, boolean multi, int deep) {
        Map<String, Object> attrs = new HashMap<String, Object>();
        attrs.put("orgId", org.getOrgId().toString());
        attrs.put("orgRank", org.getOrgRank());
        attrs.put("sort", org.getSort());
        attrs.put("name", org.getName());
        attrs.put("director", org.getDirector());
        attrs.put("directorTel", org.getDirectorTel());
        attrs.put("address", org.getAddress());
        attrs.put("isUnit", org.isUnit());
        attrs.put("parentOrgId", org.getParentOrgId().toString());
        attrs.put("unitOrgId", org.getUnitOrg().getOrgId().toString());
        boolean isLeaf = org.getChildOrgs().isEmpty();
        Map<String, Object> node = JsonNodeUtils.createNode(org.getOrgId().toString(), org.getName(), isLeaf, true, multi, attrs);
        if (!isLeaf) {
            List<Map<String, Object>> childStore = new ArrayList<Map<String, Object>>();
            node.put("children", childStore);
            for (UserOrgManager.Org child : org.getChildOrgs()) {
                childStore.add(createOrgNode(child, multi, deep + 1));
            }
        }
        return node;
    }

    /**
     * 创建单位节点
     *
     * @param org
     * @param multi
     *            是否添加checkbox按钮
     * @param deep
     *            递归深度 用于判断是否打开该节点
     * @return
     */
    public Map<String, Object> createUnitNode(UserOrgManager.Org org, boolean multi, int deep) {
        Map<String, Object> attrs = new HashMap<String, Object>();
        attrs.put("orgId", org.getOrgId().toString());
        attrs.put("orgRank", org.getOrgRank());
        attrs.put("sort", org.getSort());
        attrs.put("name", org.getName());
        attrs.put("director", org.getDirector());
        attrs.put("directorTel", org.getDirectorTel());
        attrs.put("address", org.getAddress());
        boolean isLeaf = org.getChildUnits().isEmpty();
        Map<String, Object> node = JsonNodeUtils.createNode(org.getOrgId().toString(), org.getName(), isLeaf, deep < 2, multi, attrs);
        if (!isLeaf) {
            List<Map<String, Object>> childStore = new ArrayList<Map<String, Object>>();
            node.put("children", childStore);
            for (UserOrgManager.Org child : org.getChildUnits()) {
                childStore.add(createUnitNode(child, multi, deep + 1));
            }
        }
        return node;
    }

    /**
     * 构建某一单位下的所有单位列表 排序:按单位上下级排序: 上级单位1{子单位1...子单位n}...上级单位n
     *
     * @param unit UserOrgManager.Org
     * @param unitList List<UserOrgManager.Org>
     * @return
     */
    public List<UserOrgManager.Org> createUnitList(UserOrgManager.Org unit, List<UserOrgManager.Org> unitList) {
        unitList.add(unit);
        List<UserOrgManager.Org> childUnits = unit.getChildUnits();
        if (childUnits != null && childUnits.size() > 0) {
            for (UserOrgManager.Org childUnit : childUnits) {
                createUnitList(childUnit, unitList);
            }
        }
        return unitList;
    }

    /**
     * 构建某一单位下的所有单位Map 排序:按单位上下级排序: {上级单位1Id: 上级单位1名称,
     * {子单位1...子单位n}...上级单位NId:上的单位N名称}
     *
     * @param unit UserOrgManager.Org
     * @param unitMap  Map<Long, UserOrgManager.Org>
     * @return
     */
    public Map<Long, UserOrgManager.Org> createUnitMap(UserOrgManager.Org unit, Map<Long, UserOrgManager.Org> unitMap) {
        unitMap.put(unit.getOrgId(), unit);
        List<UserOrgManager.Org> childUnits = unit.getChildUnits();
        if (childUnits != null && childUnits.size() > 0) {
            for (UserOrgManager.Org childUnit : childUnits) {
                createUnitMap(childUnit, unitMap);
            }
        }
        return unitMap;
    }

    /**
     * 构建选择器使用的单位Map 按org code长度对齐
     *
     * @param unit
     * @param unitMap
     * @return
     */
    public Map<Long, String> createUnitSelecterMap(UserOrgManager.Org unit, Map<Long, String> unitMap) {
        String code = unit.getCode();
        int times = code.length() / SysOrg.TREELEN;
        String padStr = StringUtils.rightPad(SysOrg.SELECTER_START_CHAR, times, SysOrg.SELECTER_PAD_CHAR);
        unitMap.put(unit.getOrgId(), padStr + unit.getName());
        // List<UserOrgManager.Org> childUnits = unit.getChildUnits();
        List<UserOrgManager.Org> childUnits = unit.getChildOrgs();
        if (childUnits != null && childUnits.size() > 0) {
            for (UserOrgManager.Org childUnit : childUnits) {
                createUnitSelecterMap(childUnit, unitMap);
            }
        }
        return unitMap;
    }

    /**
     * 创建包含用户的机构节点
     *
     * @param org
     * @param multi
     *            是否添加checkbox按钮
     * @param deep
     *            递归深度 用于判断是否打开该节点
     * @return
     */
    public Map<String, Object> createOrgUserNode(UserOrgManager.Org org, boolean multi, int deep) {
        Map<String, Object> attrs = new HashMap<String, Object>();
        attrs.put("orgId", org.getOrgId().toString());
        attrs.put("unitOrgId", org.getUnitOrg().getOrgId().toString());

        attrs.put("orgRank", org.getOrgRank());
        attrs.put("sort", org.getSort());
        attrs.put("name", org.getName());
        attrs.put("director", org.getDirector());
        attrs.put("directorTel", org.getDirectorTel());
        attrs.put("address", org.getAddress());
        attrs.put("isUnit", org.isUnit());
        attrs.put("users", buildOrgUsers(org));

        boolean isLeaf = org.getChildOrgs().isEmpty();
        Map<String, Object> node = JsonNodeUtils.createNode(org.getOrgId().toString(), org.getName(), isLeaf, deep < 2, multi, attrs);
        if (!isLeaf) {
            List<Map<String, Object>> childStore = new ArrayList<Map<String, Object>>();
            node.put("children", childStore);
            for (UserOrgManager.Org child : org.getChildOrgs()) {
                childStore.add(this.createOrgUserNode(child, multi, deep + 1));
            }
        }
        return node;
    }

    /**
     * 创建角色节点
     *
     * @param role
     * @param multi
     * @return
     */
    public Map<String, Object> createRoleNode(UserOrgManager.Role role, boolean multi,List<Map<String, Object>> funcMapList, List<Map<String, Object>> userMapList, Map<String, String> sysTypeDict) {
        Map<String, Object> attrs = new HashMap<String, Object>();
        attrs.put("roleId", role.getRoleId().toString());
        attrs.put("roleName", role.getName());
        attrs.put("roleCode", role.getCode());
        attrs.put("sysType", role.getSysType());
        String sysTypeName = sysTypeDict.get(role.getSysType());
        attrs.put("sysTypeName", sysTypeName);
        attrs.put("roleNote", role.getNote());
        attrs.put("functions", funcMapList);
        attrs.put("users", userMapList);
        Map<String, Object> node = JsonNodeUtils.createNode(role.getRoleId().toString(), role.getName() + "(" + sysTypeName + ")", true, false, multi, attrs);
        return node;
    }

    /**
     * 创建模块树节点
     *
     * @param func
     * @param multi
     * @param deep
     * @return Map<String,Object>
     */
    public Map<String, Object> createFunctionNode(UserOrgManager.Function func, boolean multi, int deep) {
        Map<String, Object> attrs = new HashMap<String, Object>();
        attrs.put("functionId", func.getFunctionId().toString());
        attrs.put("name", func.getName());
        attrs.put("code", func.getCode());
        attrs.put("sort", func.getSort());
        attrs.put("other", func.getOther());
        attrs.put("operate", func.getOperate());
        attrs.put("sysType", func.getSysType());
        boolean isLeaf = func.getChildren().isEmpty();
        Map<String, Object> node = JsonNodeUtils.createNode(func.getFunctionId().toString(), func.getName(), isLeaf, deep < 2, multi, attrs);
        if (!isLeaf) {
            List<Map<String, Object>> childStore = new ArrayList<Map<String, Object>>();
            node.put("children", childStore);
            for (UserOrgManager.Function child : func.getChildren()) {
                childStore.add(this.createFunctionNode(child, multi, deep + 1));
            }
        }
        return node;
    }

    /**
     * 机构包含的用户列表信息
     *
     * @param org
     * @return
     */
    public List<Map<String, Object>> buildOrgUsers(UserOrgManager.Org org) {
        List<Map<String, Object>> users = new ArrayList<Map<String, Object>>();
        List<User> userList = this.getUsersInOrg(org.orgId);
        if (userList == null || userList.size() == 0) {
            return null;
        }
        for (UserOrgManager.User u : this.getUsersInOrg(org.orgId)) {
            Map<String, Object> userMap = new HashMap<String, Object>();
            userMap.put("userId", u.getUserId().toString());
            userMap.put("userInfoId", u.getUserInfoId().toString());
            userMap.put("userName", u.getName());
            userMap.put("account", u.getAccount());
            userMap.put("age", u.getAge());
            userMap.put("orgId", org.getOrgId().toString());
            userMap.put("unitOrgId", org.getUnitOrg().getOrgId().toString());
            userMap.put("orgName", org.getName());
            userMap.put("duty", u.getDuty());
            userMap.put("dutyId", u.getDutyId());
            userMap.put("phone", u.getPhone());
            userMap.put("workPhone", u.getWorkPhone());
            userMap.put("fax", u.getFax());
            userMap.put("email", u.getEmail());
            userMap.put("remark", u.getRemark());
            userMap.put("photogrph", u.getPhotograph());
            userMap.put("status", u.getStatus());
            userMap.put("candidate", false);
            userMap.put("checked", false);
//            userMap.put("roles", this.buildUserRoles(u));
            users.add(userMap);
        }
        return users;
    }

    /**
     * 获得用户所属部门名称,逗号分隔
     *
     * @param user
     *            UserOrgManager.User
     * @return String
     */
    public String buildUserOrgNames(Map<Long, List<Org>> userOrgMap, UserOrgManager.User user) {
        String userOrgNames = "";
        if (userOrgMap == null) {
            return userOrgNames;
        }
        List<Org> orgs = userOrgMap.get(user.getUserInfoId());
        for (UserOrgManager.Org org : orgs) {
            if (userOrgNames.indexOf(org.getName()) >= 0) {
                continue;
            }
            if (!userOrgNames.equals("")) {
                userOrgNames += ", ";
            }
            userOrgNames += org.getName();
        }
        return userOrgNames;
    }

    /**
     * 根据user列表分离userInfoId和userName
     *
     * @param userList
     * @param userInfoIdList
     * @param userNameList
     */
    public void buildUserInfoIdNameToList(List<User> userList, List<Long> userInfoIdList, List<String> userNameList, List<Map<String,Object>> mapList) {
        if (userList != null) {
            for (User user : userList) {
                if (userInfoIdList != null) {
                    userInfoIdList.add(user.getUserInfoId());
                }
                if (userNameList != null) {
                    userNameList.add(user.getName());
                }
                if (mapList != null) {
                    Map<String, Object>  userMap = new HashMap<String, Object>();
                    userMap.put("orgId", user.getUserId().toString());
                    userMap.put("name", user.getName());
                   /* TODO orgName 需要另外取,目前跟User已经没有关联 */
                    userMap.put("orgName", user.getOrg().getName());
                    userMap.put("orgId", user.orgId);
                    mapList.add(userMap);
                }
            }
        }
    }

    /**
     * 根据org列表分离orgId和orgName
     *
     * @param orgList
     * @param orgIdList
     * @param orgNameList
     */
    public void buildOrgIdNameToList(List<Org> orgList, List<Long> orgIdList, List<String> orgNameList) {
        if (orgList != null) {
            for (Org org : orgList) {
                if (orgIdList != null) {
                    orgIdList.add(org.getOrgId());
                }
                if (orgNameList != null) {
                    orgNameList.add(org.getName());
                }
            }
        }
    }

    /**
     * 根据角色列表，分离roleId和roleName信息
     *
     * @param roleList
     * @param roleIdList
     * @param roleNames
     */
    public void buildRoleIdNameToList(List<Role> roleList, List<Long> roleIdList, List<String> roleNameList) {
        if (roleList != null) {
            for (Role role : roleList) {
                if (roleIdList != null) {
                    roleIdList.add(role.getRoleId());
                }
                if (roleNameList != null) {
                    roleNameList.add(role.getName());
                }
            }
        }
    }

    /**
     * 根据授权模块列表，分离functionId和functionName信息
     *
     * @param roleList
     * @param roleIdList
     * @param roleNames
     */
    public void buildFunctionIdNameToList(List<Function> functionList, List<Long> functionIdList, List<String> functionNameList, List<Map<String,Object>> mapList) {
        if (functionList != null) {
            for (Function func : functionList) {
                if (functionIdList != null) {
                    functionIdList.add(func.getFunctionId());
                }
                if (functionNameList != null) {
                    functionNameList.add(func.getName());
                }
                if (mapList != null) {
                    Map<String, Object> funcMap = new HashMap<String, Object>();
                    funcMap.put("functionId", func.getFunctionId().toString());
                    funcMap.put("name", func.getName());
                    funcMap.put("parentId", func.getParentId().toString());
                    mapList.add(funcMap);
                }
            }
        }
    }

    public static interface Filter<T> {
        boolean compare(T obj);
    }

    /**
     * 将跟机构即子机构Id合并到数组
     *
     * @param org
     *            根机构
     * @param includeChild
     *            是否包含子机构
     * @return Long[]
     */
    private Long[] mergeOrgChildToArray(Org org, boolean includeChild) {
        Long[] orgIds = null;
        if (includeChild) {
            List<Org> subOrgList = new ArrayList<Org>();
            org.getAllSubOrgs(org, subOrgList);
            orgIds = new Long[subOrgList.size() + 1];
            orgIds[0] = org.orgId;
            if (subOrgList != null) {
                int i = 1;
                for (Org subOrg : subOrgList) {
                    orgIds[i] = subOrg.orgId;
                    i++;
                }
            }
        } else {
            orgIds = new Long[1];
            orgIds[0] = org.orgId;
        }
        return orgIds;
    }

    /**
     * 用户信息分页查询 查询条件: 用户名 orgIds 帐号等
     *
     * @param info SysUserInfoInOrgQueryInfo
     * @return Page
     */
    @SuppressWarnings("unchecked")
    public Page selectUserPage(SysUserInfoInOrgQueryInfo info) {
        Org org = this.getOrg(info.getRootOrgId());
        if (org == null) {
            org = this.getRootOrg();
        }
        Long[] orgIds = mergeOrgChildToArray(org, info.isIncludeChildOrg());
        info.setOrgIds(orgIds);
        Page page = userOrgService.selectUserInfoPage(info);
        List<User> userList = new ArrayList<User>();
        for (SysUserInfo sui : (List<SysUserInfo>) page.getData()) {
            userList.add(new User(sui));
        }
        return new DataPage(userList, page.getTotalSize(), page.getPageSize(), page.getPageNumber(), info.getToken());
    }

    /**
     * 取得用户信息列表的Id数组
     *
     * @param users
     * @return
     */
    public Long[] getUserInfoIds(List<User> users) {
        if (users == null || users.size() == 0) {
            return null;
        }
        Long[] userInfoIds = new Long[users.size()];
        int i = 0;
        for (User user : users) {
            userInfoIds[i] = user.getUserInfoId();
            i++;
        }
        return userInfoIds;
    }

    /**
     * 查找机构
     *
     * @param result 查找结果
     * @param rootOrgId 在此Org中查找
     * @param includeChildOrg  包括下级机构
     * @param filter 过滤条件
     * @return Set<Org> 查找结果
     */
    public Set<Org> selectOrgs(Set<Org> result, Long rootOrgId, boolean includeChildOrg, Filter<Org> filter) {
        Org org = this.getOrg(rootOrgId);
        if (filter.compare(org)) {
            result.add(org);
        }
        if (includeChildOrg) {
            for (Org child : org.getChildOrgs()) {
                selectOrgs(result, child.getOrgId(), true, filter);
            }
        }
        return result;
    }

    /**
     * 分页查询用户
     *
     * @param rootOrgId
     *            在此Org中查找
     * @param includeChildOrg
     *            包括下级机构
     * @param filter
     *            过滤条件
     * @param sorter
     *            排序方法
     * @param pageSize
     *            每页数据数量
     * @param pageNumber
     *            第几页(从1开始)
     * @param token
     *            查询的token标记
     * @return 查询结果
     */
    public Page findOrgs(Long rootOrgId, boolean includeChildOrg, Filter<Org> filter, Comparator<Org> sorter, int pageSize, int pageNumber, Long token) {
        Set<Org> orgs = new HashSet<Org>();
        this.selectOrgs(orgs, rootOrgId, includeChildOrg, filter);
        List<Org> orgList = new ArrayList<Org>(orgs);
        Collections.sort(orgList, sorter);
        int totalSize = orgList.size();
        int fromIndex = (pageNumber - 1) * pageSize;
        int toIndex = pageNumber * pageSize;
        if (fromIndex > totalSize) {
            orgList.clear();
        } else {
            if (toIndex > totalSize) {
                toIndex = totalSize;
            }
            orgList = orgList.subList(fromIndex, toIndex);
        }
        return new DataPage(orgList, totalSize, pageSize, pageNumber, token);
    }
}
