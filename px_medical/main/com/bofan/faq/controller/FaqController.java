/*
 * <p> Title:  LawBaseController.java</p>
 * <p>Copyright:   BoFan (b) 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.bofan.faq.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.controller.AbstractAnnotationController;
import com.bofan.faq.command.FaqEditInfo;
import com.bofan.faq.command.FaqQueryInfo;
import com.bofan.faq.command.FaqTypeInfo;
import com.bofan.faq.service.FaqService;
import com.bofan.faq.valueobject.FaqDetail;
import com.bofan.faq.valueobject.FaqType;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonNodeUtils;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.TreeBuilderByIdLen;
import com.manage.utils.UserOrgManager;

/**
 * <p> Calss Name:  LawBaseController.java</p>
 * <p> Description:  法律法规基础库 </p>
 * @version 1.0
 * @author pch
 * @created  2017-10-16
 */
@Controller
@RequestMapping("faq")
public class FaqController extends AbstractAnnotationController{

    @Autowired
    private FaqService faqService;

    @Autowired
    private UserOrgManager userOrgManager;

    /**
     * 法律法规主界面显示
     * @param request
     * @param response
     * @param info
     * @return
     */
    @RequestMapping(value = "faqAdmin.do")
    public ModelAndView faqAdmin(HttpServletRequest request, HttpServletResponse response, FaqQueryInfo info) {
        Map<String, Object> model = new HashMap<String, Object>();
        Page page = this.faqService.findFaqPage(info);
        model.put("faqEditInfo", new FaqEditInfo());
        model.put("faqDetailList", page.getData());
        return new ModelAndView("/faq/faqAdmin", model);
    }


    /**
     * 查询faq内容列表
     * @param request
     * @param response
     * @param info
     * @return
     */
    @RequestMapping(value="faqList.jo")
    public ModelAndView faqList(HttpServletRequest request, HttpServletResponse response, FaqQueryInfo info) {
        Map<String, Object> model = new HashMap<String, Object>();
        Page page = this.faqService.findFaqPage(info);
        model.put("faqDetailList", page.getData());
        return new ModelAndView("/faq/faqList", model);
    }

    /**
     * faq编辑/新增
     * @param request
     * @param response
     * @param info
     * @return
     */
    @RequestMapping("faqEdit.do")
    public ModelAndView faqEdit(HttpServletRequest request, HttpServletResponse response, FaqEditInfo info, String mode){
        Map<String, Object> model = new HashMap<String, Object>();
        if(info.getFaqDetailId() != null) {
            FaqQueryInfo faqQueryInfo = new  FaqQueryInfo();
            faqQueryInfo.setFaqDetailId(info.getFaqDetailId());
            FaqDetail faqDetail = this.faqService.findFaqDetail(faqQueryInfo);
//            info.setFaqTypeId(faqDetail.getFaqTypeId());
//            info.setFaqTypeName(faqDetail.getFaqType().getFaqTypeName());
            model.put("faqDetail", faqDetail);
            model.put("faqTypeId", faqDetail.getFaqTypeId());
            model.put("faqTypeCode", faqDetail.getFaqType().getFaqTypeCode());
        }else {
            model.put("faqTypeId", info.getFaqTypeId());
        }
//        else if(info.getFaqTypeId() != null) {
//            FaqTypeInfo faqTypeInfo = new FaqTypeInfo();
//            faqTypeInfo.setFaqTypeId(info.getFaqTypeId());
//            FaqType faqType = this.faqService.findFaqType(faqTypeInfo);
//            info.setFaqTypeName(faqType.getFaqTypeName());
//        }

        List<FaqType> faqTypeList = this.faqService.findFaqTypeList(new FaqTypeInfo());
        model.put("faqTypeMap", this.buildFaqTypeMap(faqTypeList));
        model.put("mode", mode);
        return new ModelAndView("faq/faqEdit", model);
    }

    /**
     * 保存faq记录
     * @param request
     * @param response
     * @param info
     * @return
     */
    @RequestMapping("faqSave.do")
    public ModelAndView faqSave(HttpServletRequest request, HttpServletResponse response, FaqEditInfo info){
        Map<String, Object> params = new HashMap<String, Object>();
        if (null == info.getFaqTypeId()) {
            params.put("faqInfoId", info.getFaqDetailId());
            return this.alertRedirectPage.redirect("../faq/faqEdit.do", params, "没有提供条目分类，保存失败!");
        }
        if (info.getFaqDetailId() == null) {
            SysUserInfo curUser = (SysUserInfo) Constants.getCurrentLoginUser(request);
            info.setCreatorId(curUser.getUserInfoId());
        }
        FaqDetail faqDetail = this.faqService.faqSave(info);
        //params.put("faqInfoId", faqDetail.getFaqInfoId());
        return new ModelAndView("redirect:../faq/faqEdit.do?faqDetailId="+faqDetail.getFaqDetailId());
    }

   /**
    * 删除faq及其附件
    * @param request
    * @param response
    * @param info
    * @return
    */
    @RequestMapping("faqDelete.do")
    public @ResponseBody Map<String, String> faqDelete(HttpServletRequest request, HttpServletResponse response, FaqQueryInfo info){
        Map<String, String> result = new HashMap<String, String>();
        if (info.getFaqDetailId() == null ) {
            result.put("isSuccess", ResponseContstants.RESULT_FAIL_CODE);
            result.put("msg", "没有指定要删除的记录，不能删除!");
            return result;
        }

        this.faqService.faqDelete(info);
        result.put("isSuccess", ResponseContstants.RESULT_SUCCESS_CODE);
        result.put("msg", "删除成功");
        return result;
    }

    /**
     * 显示faq详细信息
     * @param request
     * @param response
     * @param info
     * @return
     */
    @RequestMapping("faqShow.do")
    public ModelAndView faqShow(HttpServletRequest request, HttpServletResponse response, FaqQueryInfo info){
        Map<String, Object> model = new HashMap<String, Object>();
        this.faqService.clickFaqDetail(info);
        FaqDetail faqDetail = this.faqService.findFaqDetail(info);
        FaqEditInfo editInfo = new FaqEditInfo();
        NullBeanUtils.copyProperties(editInfo, faqDetail);
        editInfo.setCreator(this.userOrgManager.getUser(faqDetail.getCreatorId()).getName());
        editInfo.setCreateTime(Constants.DATE_FORMAT.format(faqDetail.getCreateTime()));
        editInfo.setFaqTypeName(faqDetail.getFaqType().getFaqTypeName());
        editInfo.setFaqTypeId(faqDetail.getFaqType().getFaqTypeId());
        model.put("faqDetail", faqDetail);
        model.put("faqEditInfo", editInfo);

        Long faqClick =  faqDetail.getClickCount();
        if (faqClick == null) {
            faqClick = 0L;
        }
        FaqQueryInfo offsetInfo = new FaqQueryInfo();
        offsetInfo.setNotFaqDetailId(info.getFaqDetailId());
        //前一篇
        offsetInfo.setGtClickCount(faqClick); 
        offsetInfo.setOrderBy(FaqQueryInfo.ORDER_CLICK_ASC);
        FaqDetail faqBefore = this.faqService.findFaqDetailOffset(offsetInfo,-1);
        offsetInfo.setGtClickCount(null);
        //后一篇
        offsetInfo.setOrderBy(FaqQueryInfo.ORDER_CLICK_DESC);
        offsetInfo.setLeClickCount(faqClick);
        FaqDetail faqNext = this.faqService.findFaqDetailOffset(offsetInfo,1);
        model.put("faqBefore", faqBefore);
        model.put("faqNext", faqNext);
        
        if (request.getParameter("sysPortal") != null){
        	return new ModelAndView("faq/faqShowForSysPortal", model);
        } else{
        	return new ModelAndView("faq/faqShow", model);
        }
    }
    
    /**
     * faq分类编辑页面
     * @param request
     * @param response
     * @param info
     * @return
     */
    @RequestMapping(value = "faqTypeEdit.do")
    public ModelAndView faqTypeEdit(HttpServletRequest request, HttpServletResponse response, FaqTypeInfo info) {
        Map<String, Object> model = new HashMap<String, Object>();
        List<FaqType> faqTypeList = this.faqService.findFaqTypeList(new FaqTypeInfo());
        model.put("faqTypeMap", this.buildFaqTypeMap(faqTypeList));
        model.put("info", info);
        return new ModelAndView("/faq/faqTypeEdit", model);
    }
    
    /**
     * 保存faq分类
     * @param request
     * @param response
     * @param info
     * @return
     */
    @RequestMapping("faqTypeSave.do")
    public @ResponseBody Map<String, String> faqTypeSave(FaqTypeInfo info){
        Map<String, String> result = new HashMap<String, String>();
        this.faqService.saveFaqType(info);
        result.put("isSuccess", ResponseContstants.RESULT_SUCCESS_CODE);
        result.put("msg", "保存成功");
        return result;
    }
    
    /**
     * 删除faq类别
     * @param request
     * @param response
     * @param faqTypeId
     * @return
     */
    @RequestMapping("faqTypeDelete.do")
    public @ResponseBody Map<String, String>  faqTypeDelete(HttpServletRequest request, HttpServletResponse response, Long faqTypeId){
    	StringBuffer msg = new StringBuffer();
    	 Map<String, String> result = new HashMap<String, String>();
         if (null == faqTypeId) {
             result.put("isSuccess", ResponseContstants.RESULT_FAIL_CODE);
             result.put("msg", "删除失败");
             return result;
         }
         
         this.faqService.deleteFaqType(faqTypeId, msg);
         if (msg.length() > 0) {
        	 result.put("isSuccess", ResponseContstants.RESULT_FAIL_CODE);
        	 result.put("msg", msg.toString());
         } else {
        	 result.put("isSuccess", ResponseContstants.RESULT_SUCCESS_CODE);
        	 result.put("msg", "删除成功");
         }
         return result;
    }
    
    
    /**
     * 构造FaqType分类树数据
     * @param request
     * @return
     */
    @RequestMapping(value = "getAllFaqTypeStore.jo")
    public @ResponseBody List<Map<String, Object>>  getAllFaqTypeStore(HttpServletRequest request, boolean withCheckBox){

        List<FaqType> faqTypeList = this.faqService.findFaqTypeList(new FaqTypeInfo());

        List<Map<String, Object>> result =  new TreeBuilderByIdLen<FaqType>(withCheckBox, 0) {
            @Override
            protected void copyProperties(Map<String, Object> attrs, FaqType obj) {
                attrs.put("typeId", obj.getFaqTypeId());
                attrs.put("faqTypeCode", obj.getFaqTypeCode());
                attrs.put("faqTypeName", obj.getFaqTypeName());
            }
            @Override
            protected String getObjectId(FaqType object) {
                return object.getFaqTypeCode();
            }
            @Override
            protected String getObjectTitle(FaqType object) {
                return object.getFaqTypeName();
            }
			
        }.build(faqTypeList);
        return result;
    }
    

    /**
     * 将FaqType转为Map
     * @param faqTypeList
     * @return
     */
    private Map<String, String> buildFaqTypeMap(List<FaqType> faqTypeList) {
        Map<String, String> faqTypeMap = new LinkedHashMap<String, String>();
        if(faqTypeList != null) {
            for(FaqType faqType : faqTypeList) {
                faqTypeMap.put(faqType.getFaqTypeCode(), faqType.getFaqTypeName());
            }
        }
        return faqTypeMap;
    }

    /**
     * ajax方式保存faq分类
     * @param request
     * @param response
     * @param info
     * @return
     */
    @RequestMapping("faqTypeSave.jo")
    public @ResponseBody String faqTypeSaveJo(HttpServletRequest request, HttpServletResponse response, FaqTypeInfo info){
        
    	this.faqService.saveFaqType(info);
    	return ResponseContstants.RESULT_SUCCESS_CODE;
    }

    /**
     * 删除faq类别
     * @param request
     * @param response
     * @param faqTypeId
     * @return
     */
    @RequestMapping("faqTypeDelete.jo")
    public @ResponseBody Map<String,Object> faqTypeDeleteJo(HttpServletRequest request, HttpServletResponse response, Long faqTypeId){
        StringBuffer errorMsg = new StringBuffer(50);
        FaqType faqType = this.faqService.deleteFaqType(faqTypeId, errorMsg);
        Map<String, Object> node = new HashMap<String,Object>();
        if(faqType != null) {
            node.put(JsonNodeUtils.NODE_ID, faqType.getFaqTypeId());
            node.put(JsonNodeUtils.NODE_TEXT, faqType.getFaqTypeName());
            node.put("faqTypeId", faqType.getFaqTypeId());
            node.put("faqTypeName", faqType.getFaqTypeName());
        } else {
        	try {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, errorMsg.toString());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
        }
        return node;
    }
    
    /**
     * 根据分类父节点获取直属子树节点
     * @param request
     * @param info
     * @return
     */
    @RequestMapping(value = "getFaqTypeStore.do")
    public @ResponseBody List<Map<String, Object>>  getFaqTypeStore(HttpServletRequest request, FaqTypeInfo info){
        List<Map<String,Object>> treeStore = new ArrayList<Map<String,Object>>();
        if(info.getParentCode() == null) {
            return treeStore;
        }
        if (!Contstants.ROOT_TREE_ID.equals(info.getParentCode())) {
            info.setChildIdLenLimit(info.getParentCode().length() + Contstants.TYPE_SEGMENT_LENGTH);
        }
        List<FaqType> faqTypeList = this.faqService.findFaqTypeList(info);
        for (FaqType faqType : faqTypeList) {
            String typeCode = faqType.getFaqTypeCode();
            boolean expanded = false;
            if(faqType.getFaqTypeCode().length() == Contstants.TYPE_SEGMENT_LENGTH) {
                expanded = true;
            }
            Map<String, Object> attrs = new HashMap<String, Object>();
            attrs.put("faqTypeName", faqType.getFaqTypeName());
            Map<String, Object> node =   JsonNodeUtils.createNode(typeCode  , faqType.getFaqTypeName(), false, expanded, false, attrs);
            treeStore.add(node);
        }
        return treeStore;
    }

    /**
     * 获得faq类型编辑数据
     * @param scope
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("faqTypeEditor.jo")
    public ModelAndView faqTypeEditor(String scope, HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> model = new HashMap<String,Object>();
        return new ModelAndView("/faq/faqTypeEditor", model);
    }

}
