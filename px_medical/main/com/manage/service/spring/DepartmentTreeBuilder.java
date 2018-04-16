/*
 * FileName:    DepartmentTreeBuilder.java
 * Description:
 * Company:     博繁科技
 * Copyright:   bofan 2018
 * History:     2018-10-28 (pch) 1.0 Create
 */
package com.manage.service.spring;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bofan.basesystem.tree.command.ITreeNode;
import com.bofan.basesystem.tree.command.TreeNode;
import com.bofan.basesystem.tree.service.impl.SimpleTreeBuilder;
import com.bofan.dictionary.support.DictionarysInVelocityToolbox;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.utils.NullBeanUtils;
import com.manage.command.SysOrgQueryInfo;
import com.manage.service.IDepartmentTreeBuilder;
import com.manage.service.ManageService;

/**
 * @author  pch
 * @version 1.0, 2018-10-28
 */
public class DepartmentTreeBuilder extends SimpleTreeBuilder implements IDepartmentTreeBuilder {
    @Autowired
    private ManageService manageService;

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#selectUnitDepTree(java.lang.Long)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List selectUnitDepTree(Long unitOrgId) {

        if (unitOrgId != null) {
            ITreeNode rootNode = this.createUnitDepTree(unitOrgId);
            List result = new ArrayList();
            result.add(rootNode.find(unitOrgId.toString()));
            return result;
        } else {
            ITreeNode rootNode = (ITreeNode) DictionarysInVelocityToolbox.getDictionary("dicDepartmentTree");
            return rootNode.getChildren();
        }
    }

    /**
	 * @see com.bofan.manage.service.IDepartmentTreeBuilder#selectUnitDepAllTree(java.lang.Long)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List selectUnitDepAllTree(Long unitOrgId) {
        if (unitOrgId != null) {
			ITreeNode rootNode = this.createUnitDepAllTree(unitOrgId);
			List result = new ArrayList();
			result.add(rootNode.find(unitOrgId.toString()));
			return result;
        }
        return new ArrayList();
    }

	/**
	 * @see com.bofan.manage.service.IDepartmentTreeBuilder#selectUnitWithRanksTree(java.lang.Long, java.lang.String)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List selectUnitWithRanksTree(SysOrgQueryInfo info) {
	    if (null == info.getUnitOrgId()) {
	        return new ArrayList();
	    }
	    ITreeNode rootNode = this.createUnitWithRanksTree(info);
	    List result = new ArrayList();
	    result.add(rootNode.find(info.getUnitOrgId().toString()));
	    return result;
	}

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#selectDepListWithCandidate(java.lang.Long, java.lang.String)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List selectDepListWithCandidate(Long unitOrgId, String candidateDeps) {
        List list = this.manageService.selectDepListWithCandidate(candidateDeps);
        List nodeList = new ArrayList();
        //构造orgMap,用于查找candidateDeps到unitOrgId之间缺失的节点
        Map<Long, SysOrg> orgMap = new LinkedHashMap<Long, SysOrg>();
        for (int i = 0; i < list.size(); i++) {
            SysOrg sysOrg = (SysOrg) list.get(i);
            orgMap.put(sysOrg.getOrgId(), sysOrg);
        }
        //补全普通节点到根节点的缺失的节点
        for (int i = 0; i < list.size(); i++) {
            SysOrg sysOrg = (SysOrg) list.get(i);
            while(null != sysOrg && null != sysOrg.getParentOrgId() && !orgMap.containsKey(sysOrg.getParentOrgId())) {
                sysOrg = this.manageService.loadSysOrg(sysOrg.getParentOrgId());
                orgMap.put(sysOrg.getOrgId(), sysOrg);
            }
        }
        //获取根节点sysOrg
        SysOrg unitOrg = this.manageService.loadSysOrg(unitOrgId);
        //创建根节点
        TreeNode curNode = this.createTreeNode(unitOrg);
        addChildren(curNode, new ArrayList(orgMap.values()));
        nodeList.add(curNode);
        return nodeList;
    }

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#selectDepListWithEquallyCandidate(java.lang.String)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List selectDepListWithEquallyCandidate(String candidateDeps) {
        List list = this.manageService.selectDepListWithCandidate(candidateDeps);
        List nodeList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            SysOrg sysOrg = (SysOrg) list.get(i);
            TreeNode curNode = this.createTreeNode(sysOrg);
            nodeList.add(curNode);
        }
        return nodeList;
    }

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#selectUnitDepTreeWithCandidate(java.lang.Long, java.lang.String)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List selectUnitDepTreeWithCandidate(Long unitOrgId, String candidateDeps) {
        if(null == candidateDeps || "".equals(candidateDeps)){
            return this.selectUnitDepTree(unitOrgId);
        }
        if (unitOrgId != null) {
            ITreeNode rootNode = this.createUnitDepTreeWithCandidate(unitOrgId,candidateDeps);
            List result = new ArrayList();
            result.add(rootNode.find(unitOrgId.toString()));
            return result;
        } else {
            ITreeNode rootNode = (ITreeNode) DictionarysInVelocityToolbox.getDictionary("dicDepartmentTree");
            return rootNode.getChildren();
        }
    }

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#selectParentUnitDepTree(java.lang.Long, java.lang.Long)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List selectParentUnitDepTree(Long rootId, Long unitOrgId, boolean itself) {
        if (unitOrgId != null) {
            SysOrg sysOrg = this.manageService.loadSysOrg(unitOrgId); //获取用户所在单位
            //不包括本单位,则从本单位上级单位开始查找
            if (itself == false) {
                sysOrg = this.manageService.loadSysOrg(sysOrg.getParentOrgId()); //获取用户所在父单位
            }
            List<SysOrg> list = new ArrayList();
            SysOrg sysOrgRoot = null;
            //定义listTemp用于排序
            List<SysOrg> listTemp = new ArrayList();
            while (sysOrg.getCode().length() >= 3) { //如果长度大于3为，就为非区单位 = 3 为区单位
                String orgRank = SysOrg.UNIT_DEP_MAP.get(sysOrg.getOrgRank());
                listTemp = new ArrayList(list);
                list = new ArrayList();
                list.add(sysOrg);
                list.addAll(this.manageService.selectSysOrgByInfo(new SysOrgQueryInfo(sysOrg.getUnitOrgId(), orgRank)));
                list.addAll(listTemp);
                if (sysOrg.getCode().length() == 3) {
                    sysOrgRoot = sysOrg; //一级节点为区
                    break;
                }
                sysOrg = this.manageService.loadSysOrg(sysOrg.getParentOrgId());
            }

            TreeNode rootNode = new TreeNode(null, "", null);
            TreeNode curNode = this.createTreeNode(sysOrgRoot); //一级节点为区
            rootNode.addChild(curNode);
            addChildren(curNode, list);

            List result = new ArrayList();
            result.add(rootNode.find(sysOrgRoot.getOrgId().toString()));
            return result;
        } else {
            ITreeNode rootNode = (ITreeNode) DictionarysInVelocityToolbox.getDictionary("dicDepartmentTree");
            return rootNode.getChildren();
        }
    }

    /**
     *
     * @see com.bofan.basesystem.tree.service.impl.SimpleTreeBuilder#createTree()
     */
    @SuppressWarnings("rawtypes")
    protected TreeNode createTree() {
        List list = this.manageService.selectAllUnitDep(new SysOrgQueryInfo(), true);
        TreeNode rootNode = new TreeNode(null, "", null);
        for (int i = 0; i < list.size(); i++) {
            SysOrg sysOrg = (SysOrg) list.get(i);
            if (sysOrg.getOrgId().equals(sysOrg.getParentOrgId())) { //一级节点
                TreeNode curNode = this.createTreeNode(sysOrg);
                rootNode.addChild(curNode);
                addChildren(curNode, list);
            }
        }
        return rootNode;
    }

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#selectUnitTree()
     */
    @SuppressWarnings("rawtypes")
	public List selectUnitTree() {
        TreeNode rootNode = this.createUnitTree();
        return rootNode.getChildren();
    }

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#selectProviceCityContryArbanUnitTree()
     */
    @SuppressWarnings("rawtypes")
	public List selectProviceCityContryArbanUnitTree() {
        TreeNode rootNode = this.createProviceCityContryArbanUnitTree();
        return rootNode.getChildren();
    }

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#createUnitDepTree(java.lang.Long)
     */
    @SuppressWarnings("rawtypes")
	public TreeNode createUnitDepTree(Long unitOrgId) {
        List list = this.manageService.selectUnitAllDep(unitOrgId);
        TreeNode rootNode = new TreeNode(null, "", null);
        for (int i = 0; i < list.size(); i++) {
            SysOrg sysOrg = (SysOrg) list.get(i);
            if (sysOrg.getOrgId().equals(sysOrg.getUnitOrgId())) { //一级节点
                TreeNode curNode = this.createTreeNode(sysOrg);
                rootNode.addChild(curNode);
                addChildren(curNode, list);
            }
        }
        return rootNode;
    }

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#createUnitDepAllTree(java.lang.Long)
     */
    @SuppressWarnings("rawtypes")
	public TreeNode createUnitDepAllTree(Long unitOrgId) {
    	List list = this.manageService.selectUnitDepAll(unitOrgId);
    	TreeNode rootNode = new TreeNode(null, "", null);
    	for (int i = 0; i < list.size(); i++) {
    		SysOrg sysOrg = (SysOrg) list.get(i);
    		if (sysOrg.getOrgId().equals(sysOrg.getUnitOrgId())) { //一级节点
    			TreeNode curNode = this.createTreeNode(sysOrg);
    			rootNode.addChild(curNode);
    			addChildren(curNode, list);
    		}
    	}
    	return rootNode;
    }

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#createUnitWithRanksTree(java.lang.Long, java.lang.String)
     */
    @SuppressWarnings("rawtypes")
    public TreeNode createUnitWithRanksTree(SysOrgQueryInfo info) {
        SysOrg org = this.manageService.loadSysOrg(info.getUnitOrgId());
        SysOrgQueryInfo queryInfo = new SysOrgQueryInfo();
        NullBeanUtils.copyProperties(queryInfo, info);
        queryInfo.setUnitOrgId(null);
        queryInfo.setCode(org.getCode());
        queryInfo.setDelFlag(SysOrg.NORMAL_STATE);
        List list = this.manageService.selectUnit(queryInfo);
        TreeNode rootNode = new TreeNode(null, "", null);
        for (int i = 0; i < list.size(); i++) {
            SysOrg sysOrg = (SysOrg) list.get(i);
            if (sysOrg.getOrgId().equals(sysOrg.getUnitOrgId())) { //一级节点
                TreeNode curNode = this.createTreeNode(sysOrg);
                rootNode.addChild(curNode);
                addChildren(curNode, list);
            }
        }
        return rootNode;
    }

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#createUnitDepTreeWithCandidate(java.lang.Long, java.lang.String)
     */
    @SuppressWarnings("rawtypes")
	public TreeNode createUnitDepTreeWithCandidate(Long unitOrgId, String candidateDeps) {
        List list = this.manageService.selectUnitDepWithCandidate(unitOrgId, candidateDeps);
        TreeNode rootNode = new TreeNode(null, "", null);
        for (int i = 0; i < list.size(); i++) {
            SysOrg sysOrg = (SysOrg) list.get(i);
            if (sysOrg.getOrgId().equals(sysOrg.getUnitOrgId())) { //一级节点
                TreeNode curNode = this.createTreeNode(sysOrg);
                rootNode.addChild(curNode);
                addChildren(curNode, list);
            }
        }
        return rootNode;
    }

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#createUnitTree()
     */
    @SuppressWarnings("rawtypes")
	public TreeNode createUnitTree() {
        List list = this.manageService.selectSysUnits(null);
        TreeNode rootNode = new TreeNode(null, "", null);
        for (int i = 0; i < list.size(); i++) {
            SysOrg sysOrg = (SysOrg) list.get(i);
            if (sysOrg.getOrgId().equals(sysOrg.getParentOrgId())) { //一级节点
                TreeNode curNode = this.createTreeNode(sysOrg);
                rootNode.addChild(curNode);
                addChildren(curNode, list);
            }
        }
        return rootNode;
    }

    /**
     * @see com.bofan.manage.service.IDepartmentTreeBuilder#createProviceCityContryArbanUnitTree()
     */
    @SuppressWarnings("rawtypes")
	public TreeNode createProviceCityContryArbanUnitTree() {
        List list = this.manageService.selectProviceCityContryArbanUnits(null);
        TreeNode rootNode = new TreeNode(null, "", null);
        for (int i = 0; i < list.size(); i++) {
            SysOrg sysOrg = (SysOrg) list.get(i);
            if (sysOrg.getOrgId().equals(sysOrg.getParentOrgId())) { //一级节点
                TreeNode curNode = this.createTreeNode(sysOrg);
                rootNode.addChild(curNode);
                addChildren(curNode, list);
            }
        }
        return rootNode;
    }

    /** 根据对象创建树节点
     * @param sysOrg 对象
     * @return 树节点
     */
    private TreeNode createTreeNode(SysOrg sysOrg) {
        return new TreeNode(sysOrg.getOrgId().toString(), sysOrg.getName(), sysOrg);
    }

    /** 添加子节点
     * @param node 节点
     * @param list 数据列表
     */
    @SuppressWarnings("rawtypes")
	private void addChildren(TreeNode node, List list) {
        for (int i = 0; i < list.size(); i++) {
            SysOrg sysOrg = (SysOrg) list.get(i);
            if (sysOrg.getParentOrgId() != null && !sysOrg.getParentOrgId().equals(sysOrg.getOrgId())
                    && sysOrg.getParentOrgId().equals(new Long(node.getNodeKey()))) {
                TreeNode curNode = this.createTreeNode(sysOrg);
                node.addChild(curNode);
                addChildren(curNode, list);
            }
        }
    }

}
