package com.login.controller.support;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.manage.valueobject.SysOrg;
import com.bofan.utils.Contstants;
import com.bofan.utils.TreeBuilderByIdLen;
import com.manage.command.SysOrgQueryInfo;
import com.manage.service.ManageService; 

/**
 * @desc 机构控制器
 * @author xlf
 */
@Controller
@RequestMapping("/org")
public class OrgController {  
	
	@Autowired
    private ManageService manageService; 

	/**
	 * 打开展示树形结构的页面
	 * @return
	 */
	@RequestMapping(value = "/getTreeView.do")
	public String getTreeView(String view){
	    return view;
	}
	
	/**
     * 获取单位树形结构数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/getUnitTreeData.do")
    public @ResponseBody List<Map<String, Object>> getUnitTreeData(SysOrgQueryInfo queryInfo, boolean withCheckBox){
        queryInfo.setDelFlag(Contstants.YES_FLAG);
        List<SysOrg> orgList = this.manageService.selectUnit(queryInfo);
        
        List<Map<String, Object>> result =  new TreeBuilderByIdLen<SysOrg>(withCheckBox, 0) {
            @Override
            protected void copyProperties(Map<String, Object> attrs, SysOrg obj) {
                attrs.put("orgId", obj.getOrgId());
                attrs.put("code", obj.getCode());
                attrs.put("name", obj.getName());
                attrs.put("orgNo", obj.getOrgNo());
            }
            @Override
            protected String getObjectId(SysOrg object) {
                return object.getCode();
            }
            @Override
            protected String getObjectTitle(SysOrg object) {
                return object.getName();
            }
            
        }.build(orgList);
        
        return result;
    }
	
}
