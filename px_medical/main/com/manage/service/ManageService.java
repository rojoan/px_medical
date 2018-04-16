/*
 * FileName:    ManageService.java
 * Description:
 * Company:     博繁科技
 * Copyright:   bofan 2013
 * History:     2018-10-28 (PCH) 1.0 Create
 */
package com.manage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.basesystem.common.utils.IQueryStringUtil;
import com.bofan.common.util.Md5Encode;
import com.bofan.dictionary.support.DictionarysInVelocityToolbox;
import com.bofan.manage.valueobject.SysFunction;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysRole;
import com.bofan.manage.valueobject.SysRoleOrgMapping;
import com.bofan.manage.valueobject.SysUser;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.manage.valueobject.SysUserOrgMapping;
import com.bofan.manage.valueobject.SysUserRoleMapping;
import com.bofan.utils.QueryUtils;
import com.bofan.utils.Tools;
import com.manage.command.OrgQueryInfo;
import com.manage.command.SysFunctionQueryInfo;
import com.manage.command.SysOrgQueryInfo;
import com.manage.command.SysRoleQueryInfo;
import com.manage.command.SysUserInfoQueryInfo;
import com.manage.command.SysUserOrgRoleQueryInfo;
import com.manage.command.SysUserQueryInfo;
import com.manage.command.SysUserRoleMappingQueryInfo;
import com.manage.command.UserInfoQueryMapInfo;
import com.manage.command.UserOrgMappingQueryInfo;

/**
 * The <code>ManageService</code>
 *
 * @author pch
 * @version 1.0, 2018-10-28
 */
@Service
@Transactional
public class ManageService extends AbstractAnnoCommonService {
    @Autowired
    @Qualifier("depUserQueryUtil")
    private IQueryStringUtil depUserQueryUtil;
    @Autowired
    @Qualifier("adminMenuTreeQueryUtil")
    private IQueryStringUtil adminMenuTreeQueryUtil;
    @Autowired
    @Qualifier("userMenuTreeQueryUtil")
    private IQueryStringUtil userMenuTreeQueryUtil;
    @Autowired
    @Qualifier("functionMenuTreeQueryUtil")
    private IQueryStringUtil functionMenuTreeQueryUtil;

    /**
     * 获取员工SysUserInfo信息
     * @param loginName 登录工号
     * @return  Staff实例
     */
    @SuppressWarnings({ "rawtypes" })
    public boolean validateLoginPassword(SysUserQueryInfo info, StringBuffer msg) {
        if (Tools.isEmptyString(info.getAccount())) {
            return false;
        }
        info.setNotDelFlag(SysUser.INVALID_USER);
        String password = info.getPassword();
        info.setPassword(null);
        IQueryObject qo = super.getQueryObject(info);
        List userlist = super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
        if (!Tools.isNotEmptyList(userlist)) {
            msg.append("输入的账号错误！");
            return false;
        }
        SysUser sysUser =  (SysUser) userlist.get(0);
        String md5Password = sysUser.getPassword();
        if (!md5Password.equals(Md5Encode.md5Encoding(password))) {
            msg.append("输入的密码错误！");
            return false;
        }
        return true;
    }

    /**
     * 获取员工SysUserInfo信息
     * @param loginName 登录工号
     * @return  Staff实例
     */
    @SuppressWarnings({ "rawtypes" })
    public SysUserInfo loadValidate(String loginName) {
        IQueryObject qo = super.getQueryObject(new SysUserInfoQueryInfo(loginName, SysUser.INVALID_USER));
        List userInfolist = super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
        if (Tools.isNotEmptyList(userInfolist)) {
            SysUserInfo sysUserInfo =  (SysUserInfo) userInfolist.get(0);
            //super.getCommonDao().initialize(sysUserInfo.getOrgRoles());
//            sysUserInfo.setOrgRoles(this.selectOrgRoleSet(sysUserInfo));
            super.getCommonDao().initialize(sysUserInfo.getSysUser());
            super.getCommonDao().initialize(sysUserInfo.getSysOrg());
            super.getCommonDao().initialize(sysUserInfo.getSysDuty());
            return sysUserInfo;
        }
        return null;
    }

    /**
     * 根据用户userId获取部门角色映射集
     * @param queryInfo SysUserOrgRoleQueryInfo
     * @return List
     */
    @SuppressWarnings({ "unchecked" })
    public List<SysRoleOrgMapping> selectUserOrgRoleList(SysUserOrgRoleQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 根据用户unitOrgId获取部门角色映射集
     * @param queryInfo SysUserRoleMappingQueryInfo
     * @return Map <userId, SysUserRoleMapping>
     */
    public Map<Long, SysUserRoleMapping> selectUserRoleMap(SysUserRoleMappingQueryInfo queryInfo) {
        List<SysUserRoleMapping> userRoleList = this.selectUserRoleList(queryInfo);
        Map<Long, SysUserRoleMapping> userRoleMap = new HashMap<Long, SysUserRoleMapping>();
        if (!Tools.isNotEmptyList(userRoleList)) {
            return userRoleMap;
        }
        for (SysUserRoleMapping userRole : userRoleList) {
            userRoleMap.put(userRole.getSysUser().getUserId(), userRole);
        }
        return userRoleMap;
    }

    /**
     * 根据用户unitOrgId获取部门角色映射集
     * @param queryInfo SysUserRoleMappingQueryInfo
     * @return List
     */
    @SuppressWarnings({ "unchecked" })
    public List<SysUserRoleMapping> selectUserRoleList(SysUserRoleMappingQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 查询用户部门角色
     * @param sysUserInfo SysUserInfo
     * @return Set
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Set selectOrgRoleSet(SysUserInfo sysUserInfo) {
        List userOrgMappingList = this.selectUserOrgRoleList(new SysUserOrgRoleQueryInfo(sysUserInfo.getUserId()));
        Set orgRoles = new HashSet();
        for (int i = 0; i < userOrgMappingList.size(); i++) {
            SysRole sysRole = ((SysRoleOrgMapping) userOrgMappingList.get(i)).getSysRole();
            orgRoles.add(sysRole);
        }
        return orgRoles;
    }

    /**
     * 获取员工SysUserInfo信息
     * @param userInfoId
     * @return  SysUserInfo实例
     */
    public SysUserInfo loadSysUserInfo(Long userInfoId) {
        return super.load(SysUserInfo.class, userInfoId);
    }
    /**
     * 获取员工SysUserInfo 对应的所在的所有部门信息
     * @param userInfoId
     * @return Map<Long, String>
     */
    @SuppressWarnings({ "unchecked", "rawtypes"})
    public Map<Long, String> selectSysUserOrgName(SysUserInfo curUser) {
    	Map<Long, String> orgMap = new HashMap();
    	if (null == curUser) {
    		return orgMap;
    	}
    	List<SysUserOrgMapping> userOrgMappingList = this.selectSysUserOrgMapping(curUser);
    	for (SysUserOrgMapping userOrgMapping : userOrgMappingList) {
    		orgMap.put(userOrgMapping.getSysOrg().getOrgId(), userOrgMapping.getSysOrg().getName());
    	}
    	return orgMap;
    }
    /**
     * 获取员工SysUserInfo 对应的所在的所有部门信息
     * @param userInfoId
     * @return  List<SysUserOrgMapping>
     */
    @SuppressWarnings({ "unchecked"})
    public List<SysUserOrgMapping> selectSysUserOrgMapping(SysUserInfo curUser) {
    	if (null == curUser) {
    		return new ArrayList<SysUserOrgMapping>();
    	}
    	IQueryObject qo = super.getQueryObject(new UserOrgMappingQueryInfo(curUser.getUserId()));
    	return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }
    /**
     * 获取员工SysUserInfo 对应的所在的所有部门和单位信息
     * @param userInfoId
     * @return  Map<String, Object>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Map<String, Long[]> selectSysUserOrgMappingMap(SysUserInfo curUser) {
        List<SysUserOrgMapping> userOrgMappingList = this.selectSysUserOrgMapping(curUser);
        Long[] rangeDepId = new Long[userOrgMappingList.size()];
        Long[] rangeUnitId = new Long[userOrgMappingList.size()];
        for (int i = 0; i < userOrgMappingList.size(); i++) {
        	SysUserOrgMapping mapping = userOrgMappingList.get(i);
        	rangeDepId[i] = mapping.getSysOrg().getOrgId();
        	rangeUnitId[i] = mapping.getSysOrg().getUnitOrgId();
        }
        Map<String, Long[]> orgMap = new HashMap();
        orgMap.put("rangeDepId", rangeDepId);
        orgMap.put("rangeUnitId", rangeUnitId);
        return orgMap;
    }

    /**
     * 取得用户所在部门org {id:name}
     * @param userInfoId Long
     * @return Map<Long, String>
     */
    public Map<Long, String> getOrgMapOfUser(SysUserInfo curUser) {
        Iterator<SysUserOrgMapping> userOrgMappingIt = this.selectSysUserOrgMapping(curUser).iterator();
        Map<Long, String> orgIdNameMap = new HashMap<Long,String>();
        while (userOrgMappingIt.hasNext()) {
        	SysUserOrgMapping mapping = userOrgMappingIt.next();
        	orgIdNameMap.put(mapping.getSysOrg().getOrgId(), mapping.getSysOrg().getName());
        }
        return orgIdNameMap;
    }

    /**
     * 获取单位或部门信息（SysRole）
     * @param SysRoleQueryInfo
     * @return  SysRole实例
     */
    @SuppressWarnings("unchecked")
    public SysRole findSysRole(SysRoleQueryInfo info) {
        if (null != info.getRoleId()) {
            return super.getCommonDao().load(SysRole.class, info.getRoleId());
        }
        IQueryObject qo = super.getQueryObject(info);
        List<SysRole> list = this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
        return Tools.isNotEmptyList(list) ? list.get(0) : null;
    }

    /**
     * 获取单位或部门信息（SysOrg）
     * @param userInfoId
     * @return  SysUserInfo实例
     */
    @SuppressWarnings("unchecked")
    public SysOrg findSysOrgInfo(SysOrgQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        List<SysOrg> list = this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
        return Tools.isNotEmptyList(list) ? list.get(0) : null;
    }

    /**
     * 取得用户菜单列表.
     * @return  <code>SysFunction</code>实例组成的<code>List</code>
     */
    @SuppressWarnings({ "unchecked"})
    public List<SysFunction> selectUserFunction(String[] sysTypes, boolean adminFlag, SysUserInfo userInfo) {
        IQueryObject qo = null;
        List<SysFunction> menuList = new ArrayList<SysFunction>();
        if (adminFlag) {
            SysFunctionQueryInfo info = new SysFunctionQueryInfo();
            info.setSysType(sysTypes);
            qo = this.adminMenuTreeQueryUtil.getQueryObject(info);
            menuList = this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
        } else {
            //获取公用模块
            qo = this.adminMenuTreeQueryUtil.getQueryObject(new SysFunctionQueryInfo(SysFunction.SHARE_FUNCTION));
            menuList = this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
            //获取授权模块
            StringBuffer roleIds = new StringBuffer("");
            for (Iterator<SysRole> iterator = userInfo.getSysUser().getUserRoles().iterator(); iterator.hasNext();) {
                SysRole role = (SysRole) iterator.next();
                roleIds.append(" '").append(role.getRoleId()).append("',");
            }
            if (roleIds.length() > 0) {
                roleIds.delete(roleIds.length() - 1, roleIds.length()); //删除最后一个","
            }
            SysFunctionQueryInfo info = new SysFunctionQueryInfo(userInfo.getUserId(), roleIds.toString());
            info.setSysType(sysTypes);
            qo = this.userMenuTreeQueryUtil.getQueryObject(info);
            List listRole = this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
            menuList.addAll(listRole);

        }
        return menuList;
    }

    /**
     * 取得菜单列表（通过sys_type）.
     * @return  <code>SysFunction</code>实例组成的<code>List</code>
     */
    @SuppressWarnings("unchecked")
    public List<SysFunction> selectFunctionBySysType(String[] sysTypes, String code) {
        SysFunctionQueryInfo info = new SysFunctionQueryInfo();
        info.setCode(code);
        info.setSysType(sysTypes);
        IQueryObject qo = this.functionMenuTreeQueryUtil.getQueryObject(info);
        return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 取得系统内所有单位和部门的列表.
     * @param info OrgQueryInfo
     * @param delFlag 是否选择有效单位和部门（true : 单位和有效部门， false ： 所有部门包括无效单位和部门）
     * @return  <code>Department</code>实例组成的<code>List</code>
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectAllUnitDep(SysOrgQueryInfo info, boolean delFlag) {
    	if (delFlag) {
    		info.setDelFlag(SysOrg.NORMAL_STATE);
    	}
        IQueryObject qo = super.getQueryObject(info);
        return this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
    * 取指定部门的员工列表.
    * @param depId 部门编号
    * @param delFlag 是否为有效员工 （true : 有效员工， false ： 所有员工包括无效员工）
    * @return  Staff实例组成的List
    */
    @SuppressWarnings("unchecked")
    public List<SysUserInfo> selectDepartmentStaff(SysUserInfoQueryInfo info, boolean delFlag) {
    	if (delFlag) {
    		info.setNotDelFlag(SysUser.INVALID_USER);
    	}
        IQueryObject qo = super.getQueryObject(info);
        if (info.getOrgIds() != null) {
            info.setOrgId(null);
        }
        return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 取指定单位下的员工列表.
     * @param unitOrgId 单位ID
     * @param delFlag 是否为有效员工 （true : 有效员工， false ： 所有员工包括无效员工）
     * @return  SysUserInfo实例组成的List
     */
     public List<SysUserInfo> selectDepartmentStaffByUnitId(Long unitOrgId, boolean delFlag) {
         SysUserInfoQueryInfo info = new SysUserInfoQueryInfo();
         if (delFlag) {
             info.setNotDelFlag(SysUser.INVALID_USER);
         }
         info.setUnitOrgId(unitOrgId);
         return this.selectDepartmentStaff(info, delFlag);
     }
     
     /**
      * 取指定部门下的员工列表.
      * @param orgId 部门ID
      * @param delFlag 是否为有效员工 （true : 有效员工， false ： 所有员工包括无效员工）
      * @return  SysUserInfo实例组成的List
      */
      public List<SysUserInfo> selectDepartmentStaffByOrgId(Long orgId, boolean delFlag) {
          SysUserInfoQueryInfo info = new SysUserInfoQueryInfo();
          if (delFlag) {
              info.setNotDelFlag(SysUser.INVALID_USER);
          }
          info.setOrgId(orgId);
          return this.selectDepartmentStaff(info, delFlag);
      }
    
    /**
     * 查询单位部门
     * @param info 查询command
     * @param delFlag 是否选择有效单位和部门（true : 单位和有效部门， false ： 所有部门包括无效单位和部门）
     * @return 部门列表
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectDapartment(SysOrgQueryInfo info, boolean delFlag) {
    	if (delFlag) {
    		info.setDelFlag(SysOrg.NORMAL_STATE);
    	}
        String whereSql = " orgId != unitOrgId ";
        IQueryObject qo = super.getQueryObject(info, whereSql, new Object[]{});
        return this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 查询单位部门
     * @param unitOrgId 单位Id
     * @param delFlag 是否选择有效单位和部门（true : 单位和有效部门， false ： 所有部门包括无效单位和部门）
     * @return 部门列表
     */
    public List<SysOrg> selectDapartment(Long unitOrgId, boolean delFlag) {
        SysOrgQueryInfo info = new SysOrgQueryInfo();
        info.setUnitOrgId(unitOrgId);
        return this.selectDapartment(info, delFlag);
    }

    /**
     * 查询本单位下面的部门
     * @param info 查询command
     * @param delFlag 是否选择有效单位和部门（true : 单位和有效部门， false ： 所有部门包括无效单位和部门）
     * @return 部门列表
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectUnitOfHisDeps(SysOrgQueryInfo info, boolean delFlag) {
        if (delFlag) {
            info.setDelFlag(SysOrg.NORMAL_STATE);
        }
        if (null == info.getUnitOrgId() || Tools.isEmptyString(info.getName())) {
            return new ArrayList<SysOrg>();
        }
        IQueryObject qo = super.getQueryObject(info);
        return this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 查询本单位和本单位下面的部门
     * @param info 查询command
     * @param delFlag 是否选择有效单位和部门（true : 单位和有效部门， false ： 所有部门包括无效单位和部门）
     * @return 部门列表
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectUnitAndHisDeps(SysOrgQueryInfo info, boolean delFlag) {
        if (delFlag) {
            info.setDelFlag(SysOrg.NORMAL_STATE);
        }
        if (SysOrg.PROVINCE_UNIT.equals(info.getOrgRank()) || SysOrg.PROVINCE_DEP.equals(info.getOrgRank())) {
            IQueryObject qo = super.getQueryObject(new SysOrgQueryInfo(info.getUnitOrgId(), new String[]{SysOrg.PROVINCE_UNIT, SysOrg.PROVINCE_DEP}));
            return this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
        } else {
            IQueryObject qo = super.getQueryObject(new SysOrgQueryInfo(info.getUnitOrgId()));
            return this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
        }
    }

    /**
     * 查询单位部门(orgId、orgRank等)
     * @param info 查询command
     * @return 部门列表
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectSysOrgByInfo(SysOrgQueryInfo info) {
        info.setDelFlag(SysOrg.NORMAL_STATE);
        IQueryObject qo = super.getQueryObject(info);
        return this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 根据跳就查询单位
     * @param info 查询command
     * @return 单位列表
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectUnit(SysOrgQueryInfo info) {
        StringBuffer whereSql = new StringBuffer("orgId = unitOrgId ");
        IQueryObject qo = super.getQueryObject(info, whereSql.toString(), new Object[]{});
        return this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 根据ID查询单位
     * @param unitOrgId 单位ID
     * @return 单位列表
     */
    public List<SysOrg> selectUnit(Long unitOrgId, boolean delFlag) {
        SysOrgQueryInfo info = new SysOrgQueryInfo();
        if (delFlag) {
            info.setDelFlag(SysOrg.NORMAL_STATE);
        }
        info.setUnitOrgId(unitOrgId);
        return this.selectUnit(info);
    }
    
    /**
     * 查询所有单位，过滤掉orgId等于unitOrgId的值
     * @param unitOrgId 要过滤的单位ID
     * @return 单位列表
     */
    public List<SysOrg> selectUnitFilter(Long filterOrgId, boolean delFlag) {
        SysOrgQueryInfo info = new SysOrgQueryInfo();
        if (delFlag) {
            info.setDelFlag(SysOrg.NORMAL_STATE);
        }
        info.setNotUnitOrgId(filterOrgId);
        return this.selectUnit(info);
    }

    /**
     * 取得所有单位的列表. 单位标识 ：祖宗Id ＝ 自身Id（不包括食安办单位org_rank=14,16）
     * @param filterStr 按名字进行过滤时的过滤条件
     * @return  <code>Department</code>实例组成的<code>List</code>
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectAllUnits(String filterStr) {
        SysOrgQueryInfo info = new SysOrgQueryInfo();
        if (filterStr != null && filterStr.trim().length() > 0) {
            info.setName(QueryUtils.convertObjectToMultiKeyWord(QueryUtils.convertSqlLikePattern(filterStr)));
        }
        info.setDelFlag(SysOrg.NORMAL_STATE);
        String whereSql = " orgId = unitOrgId ";
        IQueryObject qo = super.getQueryObject(info, whereSql, new Object[]{});
        return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 取得所有单位的列表. 单位标识 ：祖宗Id ＝ 自身Id（包括食安办单位org_rank=14,16）
     * @param filterStr 按名字进行过滤时的过滤条件
     * @return  <code>Department</code>实例组成的<code>List</code>
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectSysUnits(String filterStr) {
        SysOrgQueryInfo info = new SysOrgQueryInfo();
        if (filterStr != null && filterStr.trim().length() > 0) {
            info.setName(QueryUtils.convertObjectToMultiKeyWord(QueryUtils.convertSqlLikePattern(filterStr)));
        }
        info.setDelFlag(SysOrg.NORMAL_STATE);
        StringBuffer whereSql = new StringBuffer(250);
        whereSql.append("orgId = unitOrgId) ");
        IQueryObject qo = super.getQueryObject(info, whereSql.toString(), new Object[]{});
        return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 取得区市县单位的列表. 单位标识 ：祖宗Id ＝ 自身Id
     * @param filterStr 按名字进行过滤时的过滤条件
     * @return  <code>Department</code>实例组成的<code>List</code>
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectProviceCityContryUnits(String filterStr) {
        SysOrgQueryInfo info = new SysOrgQueryInfo();
        if (filterStr != null && filterStr.trim().length() > 0) {
            info.setName(QueryUtils.convertObjectToMultiKeyWord(QueryUtils.convertSqlLikePattern(filterStr)));
        }
        info.setDelFlag(SysOrg.NORMAL_STATE);
        info.setOrgRanks(new String[]{SysOrg.PROVINCE_UNIT, SysOrg.CITY_UNIT, SysOrg.SMALL_UNIT});
        String whereSql = "orgId = unitOrgId ";
        IQueryObject qo = super.getQueryObject(info, whereSql, new Object[]{});
        return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }


    /**
     * 取得区/市/县/城区局单位的列表. 单位标识 ：祖宗Id ＝ 自身Id
     * @param filterStr 按名字进行过滤时的过滤条件
     * @return  <code>Department</code>实例组成的<code>List</code>
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectProviceCityContryArbanUnits(String filterStr) {
        SysOrgQueryInfo info = new SysOrgQueryInfo();
        if (filterStr != null && filterStr.trim().length() > 0) {
            info.setName(QueryUtils.convertObjectToMultiKeyWord(QueryUtils.convertSqlLikePattern(filterStr)));
        }
        info.setDelFlag(SysOrg.NORMAL_STATE);
        info.setOrgRanks(new String[]{SysOrg.PROVINCE_UNIT, SysOrg.CITY_UNIT, SysOrg.SMALL_UNIT, SysOrg.SMALL_AREA_UNIT});
        String whereSql = " orgId = unitOrgId ";
        IQueryObject qo = super.getQueryObject(info, whereSql.toString(), new Object[]{});
        return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 根据单位级别选择单位
     * @param parentOrgId 父级单位
     * @param ranks 单位级别
     * @return
     * 如果单位级别为空，则返回所有的省、市、县级单位
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectRegionUnitInRank(Long parentOrgId, String ranks) {
        SysOrgQueryInfo info = new SysOrgQueryInfo();
        info.setDelFlag(SysOrg.NORMAL_STATE);
        StringBuffer whereSql = new StringBuffer(250);
        whereSql.append(" orgId =  unitOrgId ");
        if (parentOrgId != null ) {
            whereSql.append(" and (parentOrgId =").append(parentOrgId).append(" or orgId =").append(parentOrgId).append(")");
        }
        if (StringUtils.isEmpty(ranks) ) {
            info.setOrgRanks(new String[]{SysOrg.PROVINCE_UNIT, SysOrg.CITY_UNIT, SysOrg.SMALL_UNIT});
        } else {
            whereSql.append(" and orgRank in (").append(ranks).append(")");
        }
        IQueryObject qo = super.getQueryObject(info, whereSql.toString(), new Object[]{});
        return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 组合orgList的单位Id为字符串，逗号分隔
     * @param orgList 单位列表
     * @return
     *
     */
    public String buildUnitOrgIds(List<SysOrg> orgList) {
        StringBuffer orgIds = new StringBuffer(50);
        orgIds.append("");
        for(SysOrg org : orgList) {
            orgIds.append(org.getUnitOrgId() + ",");
        }
        if(orgIds.length() > 1) {
            orgIds.setLength(orgIds.length() -1);
        }
        return orgIds.toString();
    }

    /**
     * 根据SysOrg List，构建orgId字符串，逗号分隔
     * @param unitList
     * @return
     */
    public String buildOrgIds( List<SysOrg> sysOrgList){
        String unitIds = "";
        for(int i =0; i < sysOrgList.size(); i++){
            if( i>0 ) unitIds += ",";
            unitIds += sysOrgList.get(i).getOrgId();
        }
        return unitIds;
    }

    /**
     * 根据SysOrg List，构建orgId字符串，逗号分隔
     * @param unitList
     * @return
     */
    public Long[] buildOrgIdLongs( List<SysOrg> sysOrgList){
        if (Tools.isNotEmptyList(sysOrgList)) {
            Long[] unitOrgIds = new Long[sysOrgList.size()];
            int i = 0;
            for(SysOrg sysOrg : sysOrgList) {
                unitOrgIds[i] = sysOrg.getOrgId();
                i++;
            }
            return unitOrgIds;
        }
        return null;
    }

    /**
     * 取指定的部门(或者单位)
     * <b>注：本方法不过滤无效部门</b>
     * @param orgId 部门编号
     * @return  SysOrg
     */
    public SysOrg loadSysOrg(Long orgId) {
    	if (null == orgId) {
    		return null;
    	}
        return (SysOrg) this.getCommonDao().load(SysOrg.class, orgId);
    }

    /**
     * 获取人员信息
     * @param info UserQueryInfo
     * @return SysUserInfo
     */
    @SuppressWarnings("rawtypes")
    public SysUserInfo selectSysUserInfo(SysUserInfoQueryInfo info) {
        if (info.getUserId() == null && info.getUserInfoId() == null) {
            return null;
        }
        IQueryObject qo = super.getQueryObject(info);
        List result = super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());

        return (Tools.isNotEmptyList(result)) ? (SysUserInfo) result.get(0) : null;
    }

    /**
    * 取指定的人员信息
    * @param userInfoId Long
    * @return  SysUserInfo
    */
    public SysUserInfo selectUserInfo(Long userInfoId) {
        if (null == userInfoId || userInfoId.longValue() < 0) {
            return null;
        }
        return super.load(SysUserInfo.class, userInfoId);
    }

    /**
     * 取单位下属所有部门
     * @param unitOrgId 单位
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectUnitAllDepts(Long unitOrgId) {
        if(null == unitOrgId || unitOrgId.longValue()<0){
            return null;
        }
        SysOrgQueryInfo info = new SysOrgQueryInfo();
        info.setUnitOrgId(unitOrgId);
        info.setDelFlag(SysOrg.NORMAL_STATE);
        String whereSql = "orgId <> unitOrgId ";
        IQueryObject qo = super.getQueryObject(info, whereSql, new Object[]{});
        return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 取单位下属所有单位和部门（不包括子单位和子单位的相关部门）
     * @param unitOrgId 单位
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectUnitAllDep(Long unitOrgId) {
        if (null == unitOrgId || unitOrgId.longValue() < 0) {
            return null;
        }
        SysOrgQueryInfo info = new SysOrgQueryInfo();
        info.setUnitOrgId(unitOrgId);
        info.setDelFlag(SysOrg.NORMAL_STATE);
        IQueryObject qo = super.getQueryObject(info);
        return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 取单位下属所有单位和部门(包括子单位和子单位的相关子部门)
     * @param unitOrgId 单位
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectUnitDepAll(Long unitOrgId) {
        if (null == unitOrgId || unitOrgId.longValue() < 0) {
            return null;
        }
        SysOrgQueryInfo info = new SysOrgQueryInfo();
        SysOrg sysOrg = super.load(SysOrg.class, unitOrgId);
        info.setCode(sysOrg.getCode());
        info.setDelFlag(SysOrg.NORMAL_STATE);
        IQueryObject qo = super.getQueryObject(info);
        return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 取单位下属所有单位和部门,带候选部门作为过滤条件
     * @param unitOrgId 单位
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectUnitDepWithCandidate(Long unitOrgId, String candidateDeps) {
        if (null == unitOrgId || unitOrgId.longValue() < 0) {
            return null;
        }
        SysOrgQueryInfo info = new SysOrgQueryInfo();
        info.setUnitOrgId(unitOrgId);
        info.setDelFlag(SysOrg.NORMAL_STATE);
        StringBuffer whereSql = new StringBuffer(" orgId in (").append(candidateDeps).append(")");
        IQueryObject qo = super.getQueryObject(info, whereSql.toString(), new Object[]{});
        return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 取所有候选部门
     * @param candidateDeps
     * @return
     */
    @SuppressWarnings("unchecked")
   public List<SysOrg> selectDepListWithCandidate(String candidateDeps) {
        SysOrgQueryInfo info = new SysOrgQueryInfo();
       info.setDelFlag(SysOrg.NORMAL_STATE);
       StringBuffer whereSql = new StringBuffer(" orgId in (").append(candidateDeps).append(")");
       IQueryObject qo = super.getQueryObject(info, whereSql.toString(), new Object[]{});
       return super.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
   }

   /**
    * 根据rootId取市及该市下的县级单位,城区局单位，如果root是1，则仅取区单位,即root本身
    * @param rootId
    * @return
    */
    @SuppressWarnings("rawtypes")
    public List<SysOrg> selectSubordinateUnit(Long rootId) {
        SysOrgQueryInfo orgQueryInfo = new SysOrgQueryInfo();
        if(rootId.longValue() == SysOrg.ROOT_ID.longValue()){
            //如果当前单位是区局，则不查询下级单位
            orgQueryInfo.setOrgId(rootId);
        } else {
            //通过code查询前指定单位及下属单位
            Map orgIdCodeMap = (Map)DictionarysInVelocityToolbox.getDictionary("dicSysOrgIdCode");
            String orgCode = (String) orgIdCodeMap.get(rootId.toString());
            orgQueryInfo.setCode(orgCode);
            orgQueryInfo.setDelFlag(SysOrg.NORMAL_STATE);
        }
        List<SysOrg> unitList = this.selectUnit(orgQueryInfo);
        return unitList;
    }

    /**
     * 根据code就查询上级单位
     * @param info 查询command
     * @return 部门列表
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectUnitByHigherOrgCode(SysOrgQueryInfo info) {
        StringBuffer whereSql = new StringBuffer("orgId = unitOrgId ");
        if (Tools.isNotEmptyString(info.getCode())) {
            whereSql.append(" and code in (");
            for (int i = 1; i <= info.getCode().length()/3; i++) {
                if (i > 1) {
                    whereSql.append(",");
                }
                whereSql.append("'").append(info.getCode().substring(0, i * 3)).append("'");
            }
            whereSql.append(")");
        }
        info.setCode(null);
        IQueryObject qo = super.getQueryObject(info, whereSql.toString(), new Object[]{});
        return this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 根据rootId取上级单位，如果root是1，则仅取区单位,即root本身
     * @param rootId
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List<SysOrg> selectHigherUnit(Long rootId) {
        SysOrgQueryInfo orgQueryInfo = new SysOrgQueryInfo();
        if(rootId.longValue() == SysOrg.ROOT_ID.longValue()){
            //如果当前单位是区局，则不查询下级单位
            orgQueryInfo.setOrgId(rootId);
        } else {
            //通过code查询前指定单位及上级单位
            Map orgIdCodeMap = (Map)DictionarysInVelocityToolbox.getDictionary("dicSysOrgIdCode");
            String unitCode = (String)orgIdCodeMap.get(rootId.toString());
            orgQueryInfo.setCode(unitCode);
            orgQueryInfo.setDelFlag(SysOrg.NORMAL_STATE);
        }
        List<SysOrg> unitList = this.selectUnitByHigherOrgCode(orgQueryInfo);
        return unitList;
    }

    /**
     * 根据code就查询上级单位
     * @param info 查询command
     * @return 部门列表
     */
    @SuppressWarnings("unchecked")
    public List<SysOrg> selectUnitAndDepsByHigherOrgCode(SysOrgQueryInfo info) {
        StringBuffer whereSql = new StringBuffer("");
        if (Tools.isNotEmptyString(info.getCode())) {
            whereSql.append(" code in (");
            for (int i = 1; i <= info.getCode().length()/3; i++) {
                if (i > 1) {
                    whereSql.append(",");
                }
                whereSql.append("'").append(info.getCode().substring(0, i * 3)).append("'");
            }
            whereSql.append(")");
        }
        info.setCode(null);
        IQueryObject qo = super.getQueryObject(info, whereSql.toString(), new Object[]{});
        return this.getCommonDao().executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 根据rootId取上级单位，如果root是1，则仅取区单位和部门,即root本身
     * @param rootId
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List<SysOrg> selectHigherUnitAndDeps(Long rootId) {
        SysOrgQueryInfo orgQueryInfo = new SysOrgQueryInfo();
        if(rootId.longValue() == SysOrg.ROOT_ID.longValue()){
            //如果当前单位是区局，则不查询下级单位
            orgQueryInfo.setOrgId(rootId);
        } else {
            //通过code查询前指定单位及上级单位
            Map orgIdCodeMap = (Map)DictionarysInVelocityToolbox.getDictionary("dicSysOrgIdCode");
            String unitCode = (String)orgIdCodeMap.get(rootId.toString());
            orgQueryInfo.setCode(unitCode);
            orgQueryInfo.setDelFlag(SysOrg.NORMAL_STATE);
        }
        List<SysOrg> unitList = this.selectUnitAndDepsByHigherOrgCode(orgQueryInfo);
        return unitList;
    }

    /**
     * @param info OrgQueryInfo 部门用户查询info
     * @return
     */
    public Page selectStaffPage(OrgQueryInfo info) {
        IQueryObject qo = this.depUserQueryUtil.getQueryObject(info);
        return super.getCommonDao().find(qo.getQueryString(), qo.getParam(), info.getPageNumber());
    }
    
    /**
     * @param info UserInfoQueryMapInfo 部门用户查询info
     * @return
     */
    public Page selectStaffPage(UserInfoQueryMapInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.getCommonDao().findMap(qo.getCountQuery(), qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
    }

    /**
     * 部门用户查询
     * 不分页
     * @param info
     * @param delFlag 是否为有效员工 （true : 有效员工， false ： 所有员工包括无效员工）
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List selectStaffList(OrgQueryInfo info, boolean delFlag) {
    	if (delFlag) {
    		info.setDelFlag(SysUser.VALID_USER);
    		info.setUserDelFlag(SysUser.INVALID_USER);
    	}
        IQueryObject qo = this.depUserQueryUtil.getQueryObject(info);
        List staffList = super.getCommonDao().executeSql(qo.getQueryString(),qo.getParam());

        Map staffMap = new HashMap();
        List staffListNew = new ArrayList();
        Object[] tempObject = new Object[3];
        int len = null != staffList && staffList.size() > 0 ? staffList.size() : 0;
        for (int i = 0; i < len; i++) {
            tempObject = (Object[]) staffList.get(i);
            SysUserInfo userInfo = (SysUserInfo) tempObject[0];
            if (null == staffMap.get(userInfo.getUserInfoId())) {
                staffListNew.add(tempObject);
                staffMap.put(userInfo.getUserInfoId(), userInfo.getUserInfoId());
            } else {
                continue;
            }
        }
        return staffListNew;
    }

}
