package com.bofan.emergencyevent.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.controller.AbstractAnnotationController;
import com.bofan.emergencyevent.command.EmProfessorEditInfo;
import com.bofan.emergencyevent.command.EmProfessorQueryInfo;
import com.bofan.emergencyevent.service.EmProfessorService;
import com.bofan.emergencyevent.valueobject.EmProfessor;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.manage.service.ManageService;

/**
 * @Description: 专家信息Controller
 * @author lqw
 */
@Controller
@RequestMapping("/emProfessor")
public class EmProfessorController  extends AbstractAnnotationController{
	/** logger */
    protected static Logger logger = Logger.getLogger(EmProfessorController.class.getName());
	@Autowired
	private EmProfessorService epidemiologyService;
	@Autowired
	private ManageService manageService;
	
    
    /**
     * 进入专家信息列表页面
     * @return
     */
    @RequestMapping("/list.do")
    public String list() {
        return "emergencyevent/emProfessorList";
    }
    
    /**
     * 获取分页列表数据
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/listData.do")
    @ResponseBody
    public  Map<String, Object> listData(HttpServletRequest request,EmProfessorQueryInfo info) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	Page page = this.epidemiologyService.selectEmProfessorList(info);
    	result.put("rows", page.getData());
    	result.put("total", page.getTotalSize());
        return result;
    }
   
    /**
     * 进入新增| 编辑 页面
     * @param request
     * @param professorId
     * @param model
     * @return
     */
    @RequestMapping("/edit.do")
    public String edit(HttpServletRequest request,Long professorId, Model model) {
    	EmProfessor emProfessor = null;
    	if (null != professorId) {
    		//进入编辑修改 
    		emProfessor = this.epidemiologyService.selectAObject(EmProfessor.class,professorId);
		} else {
			//进入新增
			SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
			SysOrg sysOrg = this.manageService.loadSysOrg(userInfo.getSysOrg().getUnitOrgId());
			emProfessor = new EmProfessor();
			emProfessor.setGender(Contstants.GENDER_MAN);//默认男性
			emProfessor.setValidFlag(Contstants.YES_FLAG);//默认有效
			emProfessor.setOrgId(sysOrg.getUnitOrgId());//当前用户机构Id
			emProfessor.setOrgName(sysOrg.getName());
			emProfessor.setSort(100);//默认排序
		}
    	model.addAttribute("emProfessor",emProfessor);
        return "emergencyevent/emProfessorEdit";
    }
    
    /**
     * 保存专家信息
     * @param info
     * @return
     */
    @RequestMapping(value = "/saveEmProfessor.do")
    @ResponseBody 
    public JsonObj saveEmProfessor(EmProfessorEditInfo info) {
    	JsonObj result = new JsonObj();
    	result.setData(this.epidemiologyService.saveEmProfessor(info));
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        return result;
    }
    
   /**
    * 删除专家信息
    * @param professorId
    * @return
    */
    @RequestMapping(value = "/delEmProfessor.do")
    @ResponseBody 
    public JsonObj delEmProfessor(Long professorId) {
    	JsonObj result = new JsonObj();
    	EmProfessor emHealthReport = this.epidemiologyService.selectAObject(EmProfessor.class,professorId);
    	this.epidemiologyService.deleteAObject(emHealthReport);
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
    	return result;
    }
    
}
