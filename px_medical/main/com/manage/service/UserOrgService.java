/*
 * <p> Title:  UserOrgService.java</p>
 * <p>Copyright:   bofan 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.manage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.common.util.Md5Encode;
import com.bofan.manage.valueobject.SysFunction;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysRole;
import com.bofan.manage.valueobject.SysRoleFunctionMapping;
import com.bofan.manage.valueobject.SysRoleOrgMapping;
import com.bofan.manage.valueobject.SysRoleOrgMappingPK;
import com.bofan.manage.valueobject.SysUser;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.manage.valueobject.SysUserOrgMapping;
import com.bofan.manage.valueobject.SysUserRoleMapping;
import com.bofan.manage.valueobject.SysUserRoleMappingPK;
import com.bofan.utils.JsonNodeUtils;
import com.bofan.utils.Tools;
import com.manage.command.AllFunctionInfo;
import com.manage.command.AllOrgInfo;
import com.manage.command.PasswordInfo;
import com.manage.command.RoleFunctionMappingQueryInfo;
import com.manage.command.SysOrgQueryInfo;
import com.manage.command.SysRoleOrgMappingQueryInfo;
import com.manage.command.SysRoleOrgUserQueryInfo;
import com.manage.command.SysRoleQueryInfo;
import com.manage.command.SysRoleUserMappingQueryInfo;
import com.manage.command.SysUserInfoInOrgQueryInfo;
import com.manage.command.SysUserInfoOrgFullQueryInfo;
import com.manage.command.SysUserInfoQueryInfo;
import com.manage.command.SysUserInfoRoleFullQueryInfo;
import com.manage.command.UserOrgMappingQueryInfo;

/**
 * <p> Calss Name:  UserOrgService.java</p>
 * <p> Description:   机构、用户查询对象类, 仅在共享池数据加载的时候使用,事务也在加载方法中启动</p>
 * @version 1.0
 * @author gaoxh
 * @created  2018-2-18
 */

@SuppressWarnings("unchecked")
@Service
public class UserOrgService extends AbstractAnnoCommonService {
    @Autowired
    private ManageService manageService;

    /**
     * 查询所有机构信息
     * @return List<SysOrg>
     */
	@Transactional
	public List<SysOrg> selectAllOrgs() {
	    IQueryObject qo = super.getQueryObject(new AllOrgInfo(SysOrg.NORMAL_STATE));
		return super.executeSql(qo.getQueryString(), qo.getParam());
	}

	/**
     * 查询用户信息
     * @return List<SysUserInfo>
     */
    @Transactional
    public List<SysUserInfo> selectUserInfo(SysUserInfoQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 查询指定机构的用户信息
     * @return List<SysUserInfo>
     */
    @Transactional
    public List<SysUserInfo> selectUserInfoInOrg(SysUserInfoInOrgQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 根据orgId分页查询用户信息
     * @param info
     * @return Page<SysUserInfo>
     */
    @Transactional
    public Page selectUserInfoPage(SysUserInfoInOrgQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
    }

    /**
     * 根据userInfoId查询用户列表，包含用户所在部门信息
     * @return List<SysUserInfo>
     */
    @Transactional
    public List<SysUserInfo> selectUserInfoWithOrg(SysUserInfoOrgFullQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 根据userInfoId查询用户列表，包含用户角色信息
     * @return List<SysUserInfo>
     */
    @Transactional
    public List<SysUserInfo> selectUserInfoListOfRoles(SysUserInfoRoleFullQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 根据userInfoId查询授权模块信息
     * @return List<SysUserInfo>
     */
    @Transactional
    public List<SysUserInfo> selectUserInfoFunction(SysUserInfoRoleFullQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 查询所有用户信息
     * @return List<SysUserInfo>
     */
    public List<SysUserInfo> selectAllUserInfos() {
        SysUserInfoQueryInfo allUserInfo = new SysUserInfoQueryInfo();
        allUserInfo.setNotDelFlag(SysUser.INVALID_USER);
        IQueryObject qo = super.getQueryObject(allUserInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

	/**
	 * 查询所有功能模块信息
	 * @return List<SysFunction>
	 */
	@Transactional
	public List<SysFunction> selectAllFunction() {
		IQueryObject qo = super.getQueryObject(new AllFunctionInfo());
		return super.executeSql(qo.getQueryString(), qo.getParam());
	}

	/**
     * 查询所有用户机构关系信息
     * @return List<SysUserOrgMapping>
     */
    public List<SysUserOrgMapping> selectUserOrgMapping(UserOrgMappingQueryInfo info) {
        if (info == null) {
            info = new UserOrgMappingQueryInfo();
        }
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 分页查询角色信息
     * @return Page<SysFunction>
     */
    @Transactional
    public Page selectRolePage(SysRoleQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.find(qo.getQueryString(),qo.getParam(), info.getPageNumber(), info.getPageSize());
    }
    /**
     * 根据条件查询角色信息
     * @return List<SysFunction>
     */
    @Transactional
    public List<SysRole> selectRoleList(SysRoleQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }

    /**
     * 查询角色与授权单位关系信息
     * @param info SysRolesOrgMappingQueryInfo
     * @return List<SysRoleOrgMapping>
     */
    @Transactional
    public List<SysRoleOrgMapping> selectRoleOrgMapping(SysRoleOrgMappingQueryInfo info) {
        if (info == null) {
            info = new SysRoleOrgMappingQueryInfo();
        }
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    @Transactional
    public SysUserInfo loadUserInfo(Long userInfoId) {
        return super.load(SysUserInfo.class, userInfoId);
    }

	/**
	 * 查询角色与授权模块关系信息
	 * @param info RoleFunctionMappingQueryInfo
	 * @return List<SysRoleFunctionMapping>
	 */
	@Transactional
	public List<SysRoleFunctionMapping> selectRoleFunctionMapping(RoleFunctionMappingQueryInfo info) {
	    if (info == null) {
	        info = new RoleFunctionMappingQueryInfo();
	    }
		IQueryObject qo = super.getQueryObject(info);
		return super.executeSql(qo.getQueryString(), qo.getParam());
	}

	/**
     * 查询SysRole表
     * @param info SysRoleQueryInfo
     */
    @Transactional
    public Page selectSysRoleOrgMappingPage(SysRoleOrgUserQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        Page page = super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber());
        List<SysRole> sysRoleList = page.getData();
        for (SysRole role : sysRoleList) {
            if (null != role) {
                super.initialize(role.getSysUserInfos());
                super.initialize(role.getAuthSysOrgs());
            }
        }
        return page;
    }

    /**
     * 保存SysRoleOrgMapping信息
     * @param info SysRoleOrgUserQueryInfo
     */
    @SuppressWarnings("rawtypes")
    @Transactional
    public void saveRoleOrgMapping(SysRoleOrgUserQueryInfo info, StringBuffer strBuffer) {
        List mappingList = new ArrayList();
        SysRoleOrgMappingQueryInfo mappingQueryInfo = new SysRoleOrgMappingQueryInfo();
        mappingQueryInfo.setRoleIds(new Long[]{info.getRoleId()});
        IQueryObject qo = super.getQueryObject(mappingQueryInfo);
        super.deleteAll(super.executeSql(qo.getQueryString(), qo.getParam()));
        for (int i = 0; i < info.getOrgIds().length; i ++) {
            SysRoleOrgMappingPK sysRoleOrgMappingPK = new SysRoleOrgMappingPK();
            SysRoleOrgMapping sysRoleOrgMapping = new SysRoleOrgMapping();
            sysRoleOrgMappingPK.setRoleId(info.getRoleId());
            sysRoleOrgMappingPK.setOrgId(info.getOrgIds()[i]);
            sysRoleOrgMapping.setCompId(sysRoleOrgMappingPK);
            mappingList.add(sysRoleOrgMapping);
        }
        if (Tools.isNotEmptyList(mappingList)) {
            super.saveAll(mappingList);
        }
        strBuffer.append("保存成功");
    }

    /**
     * 保存SysRoleOrgMapping信息
     * @param info SysRoleOrgUserQueryInfo
     */
    @Transactional
    public void saveRoleUserMapping(SysRoleOrgUserQueryInfo info, StringBuffer strBuffer) {
        List mappingList = new ArrayList();
        SysRoleUserMappingQueryInfo mappingQueryInfo = new SysRoleUserMappingQueryInfo();
        mappingQueryInfo.setRoleId(info.getRoleId());
        IQueryObject qo = super.getQueryObject(mappingQueryInfo);
        super.deleteAll(super.executeSql(qo.getQueryString(), qo.getParam()));
        for (int i = 0; i < info.getUserInfoIds().length; i ++) {
            SysUserRoleMappingPK sysUserRoleMappingPK = new SysUserRoleMappingPK();
            SysUserRoleMapping sysUserRoleMapping = new SysUserRoleMapping();
            sysUserRoleMappingPK.setRoleId(info.getRoleId());
            SysUserInfo sysUserInfo = super.load(SysUserInfo.class, info.getUserInfoIds()[i]);
            if (null == sysUserInfo) {
                break;
            }
            sysUserRoleMappingPK.setUserId(sysUserInfo.getUserId());
            sysUserRoleMapping.setCompId(sysUserRoleMappingPK);
            mappingList.add(sysUserRoleMapping);
        }
        if (Tools.isNotEmptyList(mappingList)) {
            super.saveAll(mappingList);
        }
        strBuffer.append("保存成功");
    }

    /**
     * 获取当前用户一级根单位
     * @param curUser SysUserInfo
     * @return SysOrg rootTree 一级单位
     */
    @Transactional
    public SysOrg loadRootOrg(SysUserInfo curUser) {
        //用户不允许跨不同根单位
    	List<SysUserOrgMapping> sysUserOrgList = this.manageService.selectSysUserOrgMapping(curUser);
    	if (!Tools.isNotEmptyList(sysUserOrgList)) {
    		return null;
    	}
    	SysOrg sysUserOrg = ((SysUserOrgMapping) sysUserOrgList.get(0)).getSysOrg();
    	SysOrg sysUserOrgTemp;
    	while (!sysUserOrg.isUnitOrg() && sysUserOrg.getCode().length() != 3) {
    		sysUserOrgTemp = super.load(SysOrg.class, sysUserOrg.getParentOrgId());
            sysUserOrg = sysUserOrgTemp;
            // NullBeanUtils.copyProperties(sysUserOrg, sysUserOrgTemp);
    	}
        return sysUserOrg;
    }

    /**
     * 个人密码修改
     * @param userId Long
     * @param info PasswordInfo
     * @return String
     */
    @Transactional
    public String passwordChange(Long userId, PasswordInfo info) {
        SysUser user = super.load(SysUser.class, userId);
        String oldPasswdMd5 = Md5Encode.md5Encoding(info.getOldPassword());
        if(!oldPasswdMd5.equals(user.getPassword())) {
            return "原密码不正确,请重新输入";
        }
        user.setPassword(Md5Encode.md5Encoding(info.getNewPassword()));
        super.save(user);
        return "密码修改成功!";
    }

    /**
     * 个人手机号修改
     * @param userInfoId Long
     * @param PasswordInfo PasswordInfo
     * @return String
     */
    @Transactional
    public String phoneChange(Long userInfoId, PasswordInfo info) {
    	SysUserInfo userInfo = super.load(SysUserInfo.class, userInfoId);
    	SysUser sysUser = super.load(SysUser.class, userInfo.getUserId());

        String oldPasswdMd5 = Md5Encode.md5Encoding(info.getOldPassword());
        if(!oldPasswdMd5.equals(sysUser.getPassword())) {
            return "原密码不正确,请重新输入";
        }
    	userInfo.setPhone(info.getNewPhone());
    	super.save(userInfo);
    	return "手机号修改成功!";
    }
    
    /**
     * 获取部门
     * @param info
     * @return
     */
    @Transactional
    public List<SysOrg> selectSysOrgs(SysOrgQueryInfo info){
    	IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 判断当前用户是否可以访问某个Org
     * @param userOrgId
     * @param accessOrgId
     * @return
     */
    @Transactional
    public SysOrg checkUserTopUnit(Long userOrgId, Long accessOrgId) {
        if (userOrgId == null) {
            return null;
        }
        SysOrg userOrg = super.load(SysOrg.class, userOrgId);
        if (accessOrgId == null || accessOrgId == 0L) {
            return userOrg;
        }
        SysOrg accessOrg = super.load(SysOrg.class, accessOrgId);
        if (accessOrg.getCode().startsWith(userOrg.getCode())) {
            return accessOrg;
        }
        return userOrg;
    }

    /** 以下是构建符合json结构的相关数据工具函数，包括用户、角色、模块节点或者列表数据 */
    /**
     * 创建机构节点
     * @param org
     * @param multi 是否添加checkbox按钮
     * @param deep 递归深度 用于判断是否打开该节点
     * @return
     */
    @SuppressWarnings("rawtypes")
	@Transactional
    public Map<String, Object> createOrgNode(SysOrg org, boolean multi, int deep) {
        Map<String, Object> attrs = new HashMap<String, Object>();
        attrs.put("orgId", org.getOrgId().toString());
        attrs.put("orgRank", org.getOrgRank());
        attrs.put("sort", org.getSort());
        attrs.put("name", org.getName());
        attrs.put("director", org.getDirector());
        attrs.put("directorTel", org.getDirectorTel());
        attrs.put("address", org.getAddress());
        attrs.put("isUnit", org.isUnitOrg());
        attrs.put("parentOrgId", org.getParentOrgId().toString());
        attrs.put("unitOrgId", org.getUnitOrgId().toString());
        List<SysOrg> orgList = this.manageService.selectUnitDepAll(org.getOrgId());
        orgList.remove(org);
        boolean isLeaf = Tools.isNotEmptyList(orgList) ?  false : true;
        Map<String, Object> node = JsonNodeUtils.createNode(org.getOrgId().toString(), org.getName(), isLeaf, true, multi, attrs);
        if (!isLeaf) {
            List<Map<String, Object>> childStore = new ArrayList<Map<String, Object>>();
            node.put("children", childStore);
            for (Iterator iterator = orgList.iterator(); iterator.hasNext();) {
                childStore.add(createOrgNode((SysOrg) iterator.next(), multi, deep + 1));
            }
        }
        return node;
    }
}
