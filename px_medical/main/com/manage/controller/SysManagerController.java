package com.manage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.controller.AbstractAnnotationController;
import com.bofan.common.util.Md5Encode;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUser;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.manage.command.PasswordInfo;
import com.manage.command.SysRoleOrgUserQueryInfo;
import com.manage.command.UserOrgInfo;
import com.manage.service.UserOrgService;

@Controller
@RequestMapping("manager")
public class SysManagerController extends AbstractAnnotationController{
	/**请求失败代码 **/
	public static final String RESULT_FAIL_CODE = "-1";
    @Autowired
    private UserOrgService userOrgService;

    /**
     * 获得下级子单位
     * @param request
     * @param info
     * @return
     * 只返回数据,没有view处理
     */
    @RequestMapping(value = "getOrgStore.jo")
    public @ResponseBody List<Map<String, Object>>  getOrgStore(HttpServletRequest request, UserOrgInfo info) {
        SysUserInfo curUser = (SysUserInfo)Constants.getCurrentLoginUser(request);
        //当前用户有权获取rootOrgId单位时，topOrg为rootOrgId对应单位，否则topOrg为当前用户所在单位
        SysOrg topOrg = this.userOrgService.checkUserTopUnit(curUser.getSysOrg().getUnitOrgId(), info.getRootOrgId());
        Map<String,Object> node = this.userOrgService.createOrgNode(topOrg, info.isMulti(), 0);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        result.add(node);
        return result;
    }

    /**
     * 保存系统角色，单位关系表
     * @param request
     * @param response
     * @param info SysRoleOrgUserQueryInfo
     */
    @RequestMapping(value = "saveRoleOrgMapping.do")
    public @ResponseBody Map<String, Object>  saveRoleOrgMapping(HttpServletRequest request, HttpServletResponse response, SysRoleOrgUserQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        StringBuffer strBuffer = new StringBuffer();
        if (null == info.getRoleId()) {
            strBuffer.append("请指定角色");
            result.put("error", strBuffer.toString());
            return result;
        }
        this.userOrgService.saveRoleOrgMapping(info, strBuffer);
        result.put("success", strBuffer.toString());
        return result;
    }

    /**
     * 保存系统角色，人员关系表
     * @param request
     * @param response
     * @param info SysRoleOrgUserQueryInfo
     */
    @RequestMapping(value = "saveRoleUserMapping.do")
    public @ResponseBody Map<String, Object>  saveRoleUserMapping(HttpServletRequest request, HttpServletResponse response, SysRoleOrgUserQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        StringBuffer strBuffer = new StringBuffer();
        if (null == info.getRoleId()) {
            strBuffer.append("请指定角色");
            result.put("error", strBuffer.toString());
            return result;
        }
        this.userOrgService.saveRoleUserMapping(info, strBuffer);
        result.put("success", strBuffer.toString());
        return result;
    }

    /**
     * 修改密码页面显示
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("passwordEdit.do")
    public ModelAndView passwordEdit(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        SysUserInfo curUserInfo = (SysUserInfo)Constants.getCurrentLoginUser(request);
        model.put("unitOrg", this.userOrgService.selectAObject(SysOrg.class, curUserInfo.getSysOrg().getUnitOrgId()));
        return new ModelAndView("manager/passwordEdit" , model);
    }

    /**
     * 个人密码修改保存
     * @param request
     * @param oldPassword
     * @param newPassword
     * @param confirmPassword
     * @return
     */
     @RequestMapping("passwordChange.jo")
     @ResponseBody
     public JsonObj passwordChange(HttpServletRequest request, String oldPassword, String newPassword, String confirmPassword) {
         JsonObj result = new JsonObj();
         SysUserInfo curUserInfo = (SysUserInfo)Constants.getCurrentLoginUser(request);
         
         if (!StringUtils.hasText(oldPassword)) {
             result.setCode(ResponseContstants.RESULT_FAIL_CODE);
             result.setMsg("请输入原密码。");
             return result;
         }
         if(!StringUtils.hasText(newPassword)) {
             result.setCode(ResponseContstants.RESULT_FAIL_CODE);
             result.setMsg("请输入新密码。");
             return result;
         }
         if(!newPassword.equals(confirmPassword)) {
             result.setCode(ResponseContstants.RESULT_FAIL_CODE);
             result.setMsg("新密码和确认密码不一致。");
             return result;
         }
         SysUser user = this.userOrgService.selectAObject(SysUser.class, curUserInfo.getUserId());
         
         if (null == user) {
             result.setCode(ResponseContstants.RESULT_FAIL_CODE);
             result.setMsg("会话信息不存在。");
             return result;
         }
         if (!user.getPassword().equals(Md5Encode.md5Encoding(oldPassword))) {
             result.setCode(ResponseContstants.RESULT_FAIL_CODE);
             result.setMsg("原密码不正确,请重新输入。");
             return result;
         }
         
         user.setPassword(Md5Encode.md5Encoding(newPassword));
         this.userOrgService.saveAObject(user);
         
         result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
         result.setMsg("修改成功，三秒后系统自动跳到登录页。");
         return result;

     }

     /**
      * 个人手机号修改保存
      * @param request HttpServletRequest
      * @param response HttpServletResponse
      * @param info PasswordInfo
      * @return ModelAndView
      */
     @RequestMapping("phoneChange.do")
     public ModelAndView phoneChange(HttpServletRequest request, HttpServletResponse response, PasswordInfo info) {
    	 SysUserInfo curUserInfo = (SysUserInfo)Constants.getCurrentLoginUser(request);
    	 if(curUserInfo.getUserInfoId() == null  ) {
    		 return this.alertRedirectPage.redirect("../manager/passwordEdit.do", "您还没有登录系统，不能修改个人手机号.");
    	 }
    	 if(info.getNewPhone() == null || info.getNewPhone().trim() == "" ) {
    		 return this.alertRedirectPage.redirect("../manager/passwordEdit.do", "新手机号不能为空");
    	 }

    	 String msg = this.userOrgService.phoneChange(curUserInfo.getUserInfoId(), info);

    	 return this.alertRedirectPage.redirect("../manager/passwordEdit.do", msg);

     }
}
