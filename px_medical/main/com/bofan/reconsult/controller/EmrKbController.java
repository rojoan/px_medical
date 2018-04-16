package com.bofan.reconsult.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.reconsult.command.EmrKbDetailQueryInfo;
import com.bofan.reconsult.command.EmrKbTypeQueryInfo;
import com.bofan.reconsult.service.EmrKbService;
import com.bofan.reconsult.valueobject.EmrKbDetail;
import com.bofan.reconsult.valueobject.EmrKbType;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.TreeBuilderByIdLen;

@Controller
@RequestMapping("/emrKb")
public class EmrKbController {
    
    /** logger */
    protected static Logger logger = Logger.getLogger(EmrKbController.class.getName());
    
    @Autowired
    private EmrKbService emrKbService;
    
    /**
     * 
     * @return
     */
    @RequestMapping("/main.do")
    public String main() {
        
        return "reconsulting/emrkbAdmin";
        
    }
    
    /**
     * 构造EmrKbType分类树数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/getEmrKbTree.do")
    public @ResponseBody List<Map<String, Object>> getEmrKbTree(HttpServletRequest request, boolean withCheckBox){

        List<EmrKbType> dataList = this.emrKbService.selectEmrKbType(null);

        List<Map<String, Object>> result =  new TreeBuilderByIdLen<EmrKbType>(withCheckBox, 0) {
            @Override
            protected void copyProperties(Map<String, Object> attrs, EmrKbType obj) {
                attrs.put("kbId", obj.getEmrKbTypeId());
                attrs.put("code", obj.getEmrKbTypeCode());
                attrs.put("name", obj.getEmrKbTypeName());
            }
            @Override
            protected String getObjectId(EmrKbType object) {
                return object.getEmrKbTypeCode();
            }
            @Override
            protected String getObjectTitle(EmrKbType object) {
                return object.getEmrKbTypeName();
            }
            
        }.build(dataList);
        
        return result;
    }
    
    /**
     * 根据知识类型ID获取知识内容
     * @param queryInfo
     * @return
     */
    @RequestMapping(value = "/emrKbDetailListByTypeId.do")
    public String emrKbDetailListByTypeId(EmrKbDetailQueryInfo queryInfo, Model model){
        String view = "reconsulting/emrkbDetailList";
        if (null == queryInfo.getEmrKbTypeId()) {
            return view;
        }
        
        model.addAttribute("dataList", this.emrKbService.selectEmrKbDetail(queryInfo));
        return view;
    }
    
    /**
     * 保存知识内容
     * @param request
     * @param emrKbDetailId
     * @param emrKbTypeId
     * @param emrKbTitle
     * @param emrKbContent
     * @return
     */
    @RequestMapping(value = "/saveEmrKbDetail.jo")
    public @ResponseBody JsonObj saveEmrKbDetail(HttpServletRequest request, Long emrKbDetailId,
            Long emrKbTypeId, String emrKbTitle, String emrKbContent) {
        JsonObj result = new JsonObj();
        if (null == emrKbDetailId) {
        	SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
        	EmrKbDetail emrKbDetail = new EmrKbDetail();
        	emrKbDetail.setEmrKbTitle(emrKbTitle);
        	emrKbDetail.setEmrKbContent(emrKbContent);
        	emrKbDetail.setEmrKbTypeId(emrKbTypeId);
        	emrKbDetail.setCreateTime(new Date());
        	emrKbDetail.setClickCount(0L);
        	emrKbDetail.setCreatorId(userInfo.getUserInfoId());
        	this.emrKbService.saveAObject(emrKbDetail);
        	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        	result.setMsg("保存成功");
        	return result;
        }
        
        EmrKbDetail emrKbDetail = this.emrKbService.selectAObject(EmrKbDetail.class, emrKbDetailId);
        if (null == emrKbDetail) {
        	result.setCode(ResponseContstants.RESULT_FAIL_CODE);
        	result.setMsg("保存失败");
        	return result;
        }
        
        emrKbDetail.setEmrKbContent(emrKbContent);
        this.emrKbService.saveAObject(emrKbDetail);
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        result.setMsg("保存成功");
        return result;
    }
    
    /**
     * 删除知识内容
     * @param emrKbDetailId
     * @return
     */
    @RequestMapping(value = "/deleteEmrKbDetail.jo")
    public @ResponseBody JsonObj deleteEmrKbDetail(Long emrKbDetailId) {
        JsonObj result = new JsonObj();
        if (null == emrKbDetailId) {
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            result.setMsg("删除失败");
            return result;
        }
        
        EmrKbDetail emrKbDetail = this.emrKbService.selectAObject(EmrKbDetail.class, emrKbDetailId);
        if (null == emrKbDetail) {
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            result.setMsg("删除失败");
            return result;
        }
        
        this.emrKbService.deleteAObject(emrKbDetail);
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        result.setMsg("删除成功");
        return result;
    }
    
    /**
     * 保存知识内容
     * @param emrKbTypeId
     * @param emrKbTypeCode
     * @param emrKbTypeName
     * @return
     */
    @RequestMapping(value = "/saveEmrKbType.jo")
    public @ResponseBody JsonObj saveEmrKbType(Long emrKbTypeId, String emrKbTypeCode, String emrKbTypeName) {
        JsonObj result = new JsonObj();
        this.emrKbService.saveEmrKbType(emrKbTypeId, emrKbTypeCode, emrKbTypeName);
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        result.setMsg("保存成功");
        return result;
    }
    
    /**
     * 删除知识分类
     * @param emrKbTypeId
     * @return
     */
    @RequestMapping(value = "/deleteEmrKbType.jo")
    public @ResponseBody JsonObj deleteEmrKbType(Long emrKbTypeId) {
        JsonObj result = new JsonObj();
        if (null == emrKbTypeId) {
        	result.setCode(ResponseContstants.RESULT_FAIL_CODE);
        	result.setMsg("删除失败");
        	return result;
        }
        
        EmrKbType emrKbType = this.emrKbService.selectAObject(EmrKbType.class, emrKbTypeId);
        if (null == emrKbType) {
        	result.setCode(ResponseContstants.RESULT_FAIL_CODE);
        	result.setMsg("删除失败");
        	return result;
        }
        
        EmrKbTypeQueryInfo queryInfo = new EmrKbTypeQueryInfo();
        queryInfo.setNotCode(emrKbType.getEmrKbTypeCode());
        queryInfo.setLikeCode(emrKbType.getEmrKbTypeCode());
        List<EmrKbType> dataList = this.emrKbService.selectEmrKbType(queryInfo);
        if (null != dataList && dataList.size() > 0) {
        	result.setCode(ResponseContstants.RESULT_FAIL_CODE);
        	result.setMsg("要删除的分类包含有下级分类，请先删除下级分类");
        	return result;
        }
        
        this.emrKbService.deleteAObject(emrKbType);
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        result.setMsg("删除成功");
        return result;
    }

}
