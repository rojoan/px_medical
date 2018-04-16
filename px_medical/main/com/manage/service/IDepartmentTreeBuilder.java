/*
 * FileName:    IDepartmentTreeBuilder.java
 * Description:
 * Company:     博繁科技
 * Copyright:   bofan 2018
 * History:     2018-10-28 (pch) 1.0 Create
 */
package com.manage.service;

import java.util.List;

import com.bofan.basesystem.tree.command.TreeNode;
import com.bofan.basesystem.tree.service.ITreeBuilder;
import com.manage.command.SysOrgQueryInfo;

/**
 * @author  pch
 * @version 1.0, 2018-10-28
 */
public interface IDepartmentTreeBuilder extends ITreeBuilder{

    /**
     * 取得属于本单位的部门树，使用 <code>DepartmentTree</code> 实例.
     * @param unitOrgId
     * @return  部门树根结点列表.
     */
    List selectUnitDepTree(Long unitOrgId);

    /**
     * 取得属于本单位（包括本单位的部门）以及下属的所有单位和部门树，使用 <code>DepartmentTree</code> 实例.
     * @param unitOrgId
     * @return  部门树根结点列表.
     */
    List selectUnitDepAllTree(Long unitOrgId);

    /**
     * 取得属于本单位（包括本单位）以及下属的所有单位树，使用 <code>DepartmentTree</code> 实例.
     * @param unitOrgId 根节点单位id
     * @param ranks 单位类型
     * @return  部门树根结点列表.
     */
    List selectUnitWithRanksTree(SysOrgQueryInfo info);

    /**
     * 取得部门树（包括候选部门），使用 <code>DepartmentTree</code> 实例.
     * 带候选部门过滤
     * @param unitOrgId
     * @return  部门树根结点列表.
     */
    List selectUnitDepTreeWithCandidate(Long unitOrgId, String candiateDeps);

    /**
     * 取得部门列表，使用 <code>DepartmentTree</code> 实例.
     * 带候选部门过滤
     * @param unitOrgId Long 根节点
     * @param candiateDeps String 要选择的部门,必须是根节点unitOrgId的子节点、子孙节点
     * @return  部门树根结点列表.
     */
    List selectDepListWithCandidate(Long unitOrgId, String candiateDeps);

    /**
     * 取得部门列表，使用 <code>DepartmentTree</code> 实例.
     * 带候选部门过滤,不按单位和部门构建树形而是直接并列首列显示
     * @param candiateDeps
     * @return  并排的单位和部门列表.
     */
    List selectDepListWithEquallyCandidate(String candiateDeps);

    /**
     * 构建单位部门树(以unitOrgId为根节点的单位部门树)
     * @param unitOrgId
     * @return TreeNode
     */
    TreeNode createUnitDepTree(Long unitOrgId);

    /**
     * 构建单位部门(包括下属单位和部门)树(以unitOrgId为根节点的单位部门树)
     * @param unitOrgId
     * @return TreeNode
     */
    TreeNode createUnitDepAllTree(Long unitOrgId);

    /**
     * 构建单位(包括下属单位)树(以unitOrgId为根节点的单位树,不包括部门)
     * @param unitOrgId 根节点单位id
     * @param ranks 要查找的单位类型
     * @return TreeNode
     */
    TreeNode createUnitWithRanksTree(SysOrgQueryInfo info);

    /**
     * 构建上级单位部门树
     * @param rootId 根节点
     * @param unitOrgId 当前用户所在单位
     * @param itself 是否包括本单位 true:包括;false:不包括
     * @return TreeNode
     */
    List selectParentUnitDepTree(Long rootId, Long unitOrgId, boolean itself);

    /**
     * 构建单位部门树(通过候选部门)
     * @param unitOrgId 单位ID
     * @return TreeNode
     */
    TreeNode createUnitDepTreeWithCandidate(Long unitOrgId, String candidateDeps);

    /**
     * 构建单位树
     * @param dwId
     * @return TreeNode
     */
    TreeNode createUnitTree();
    /**
     * 构建单位树并构建子节点
     * @return TreeNode
     */
    List selectUnitTree();
    /**
     * 构建地市县单位树并构建子节点
     * @return TreeNode
     */
    List selectProviceCityContryArbanUnitTree();
}
