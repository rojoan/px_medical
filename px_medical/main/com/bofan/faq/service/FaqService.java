/*
 * <p> Title:  LawBaseService.java</p>
 * <p>Copyright:   BoFan (b) 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.bofan.faq.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.faq.command.FaqEditInfo;
import com.bofan.faq.command.FaqQueryInfo;
import com.bofan.faq.command.FaqTypeInfo;
import com.bofan.faq.valueobject.FaqDetail;
import com.bofan.faq.valueobject.FaqType;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;

/**
 * <p> Calss Name:  LawBaseService.java</p>
 * <p> Description: faq服务对象类  </p>
 * @version 1.0
 * @author pch
 * @created  2018-2-13
 */
@Service
public class FaqService extends AbstractAnnoCommonService{
    
    
    /**
     * 查询faq类型列表
     * @param info
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional
    public List<FaqType> findFaqTypeList(FaqTypeInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }
    
    /**
     * faq信息分页查询
     * @param info
     * @return
     */
    @Transactional
    public Page findFaqPage(FaqQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.find(qo.getQueryString(), qo.getParam(),info.getPageNumber(),info.getPageSize());
    }    
    
    /**
     * faq列表查询
     * @param info
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional
    public List<FaqDetail> findFaqList(FaqQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }   
    
    /**
     * 擦和讯单个faqDetail
     * @param info
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional
    public FaqDetail findFaqDetail(FaqQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        FaqDetail faqDetail = null;
        List<FaqDetail> faqList =  super.executeSql(qo.getQueryString(),qo.getParam());
        if(faqList != null && faqList.size() > 0) {
            faqDetail = faqList.get(0);
            super.initialize(faqDetail.getFaqContent());
            super.initialize(faqDetail.getAffix());
        }
        return faqDetail;
    }    
    
    @SuppressWarnings("unchecked")
    @Transactional
    public FaqDetail findFaqDetailOffset(FaqQueryInfo info,int offset) {
        info.setPageSize(Math.abs(offset));
        //info.setPageNumber(1);
        IQueryObject qo = super.getQueryObject(info);
        Page page = super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
        List<FaqDetail> faqList = page.getData();
        if(faqList != null && faqList.size() > 0 ){
            return faqList.get(Math.abs(offset)-1);
        }
        return null;
    }    
    
    
    
    /**
     * 累加点击数
     * @param info
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional
    public FaqDetail clickFaqDetail(FaqQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        FaqDetail faqDetail = null;
        List<FaqDetail> faqList =  super.executeSql(qo.getQueryString(),qo.getParam());
        if(faqList != null && faqList.size() > 0) {
            faqDetail = faqList.get(0);
            faqDetail.setClickTime(new Date());
            faqDetail.setClickCount(faqDetail.getClickCount() + 1);
            super.save(faqDetail);
        }
        return faqDetail;
    }    
    
    /**
     * 查询单个FaqType
     * @param info
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional
    public FaqType findFaqType(FaqTypeInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        FaqType faqType = null;
        List<FaqType> faqTypeList =  super.executeSql(qo.getQueryString(),qo.getParam());
        if(faqTypeList != null && faqTypeList.size() > 0) {
            faqType = faqTypeList.get(0);
        }
        return faqType;
    }  
    
    /**
     * 新增/保存faqdetail信息 
     * @param info
     * @return
     */
    @Transactional
    public FaqDetail faqSave(FaqEditInfo info) {
        FaqDetail faqDetail = null;
        if (info.getFaqDetailId() == null ) {
        	faqDetail = new FaqDetail();
            NullBeanUtils.copyProperties(faqDetail, info);
            faqDetail.setCreateTime(new Date());
        } else {
            faqDetail = super.load(FaqDetail.class, info.getFaqDetailId());
            Date createTime = faqDetail.getCreateTime();
            Long creatorId = faqDetail.getCreatorId();
            NullBeanUtils.copyProperties(faqDetail, info);
            faqDetail.setCreateTime(createTime);
            faqDetail.setCreatorId(creatorId);
        }
        
        /**
        FaqTypeInfo faqTypeInfo = new FaqTypeInfo();
        faqTypeInfo.setFaqTypeCode(info.getFaqTypeCode());
        FaqType faqType = this.findFaqType(faqTypeInfo);
        faqDetail.setFaqTypeId(faqType.getFaqTypeId());
        */
        
        Long clickCount = faqDetail.getClickCount();
        faqDetail.setClickCount(clickCount==null ? 1 : clickCount.longValue() + 1);
        faqDetail.setClickTime(new Date());
        super.save(faqDetail);
        return faqDetail;
    }  
   
    /**
     * 删除faq及其附件
     * @param info
     * @return
     */
    @Transactional
    public FaqDetail faqDelete(FaqQueryInfo info) {
        FaqDetail faqDetail = super.load(FaqDetail.class, info.getFaqDetailId());
        /**
        super.initialize(faqDetail.getAffix());
        if (faqDetail.getAffixId() != null) {
            FaqAffix affix = faqDetail.getAffix();
            super.deleteAll(affix.getItems());
            super.delete(affix);
        }
        */
        super.delete(faqDetail);
        return faqDetail;
    }  
    
    /**
     * 保存faqType信息
     * @param info
     * @return
     */
    @Transactional
    public FaqType saveFaqType(FaqTypeInfo info) {
         FaqType faqType = null;
         if (info.getFaqTypeId() == null) {//新增
        	 faqType = new FaqType();
             faqType.setFaqTypeCode(super.nextTreeId(FaqType.class, "faqTypeCode", info.getParentCode(), Contstants.TYPE_SEGMENT_LENGTH));
         } else {//修改
        	 faqType = super.load(FaqType.class, info.getFaqTypeId());
        	 /**
        	 //如果上级分类有变更，则连子节点也一起跟着变
        	 String parentCode = "";
        	 if(StringUtils.isNotEmpty(info.getParentCode())){
        	     parentCode = info.getParentCode();
        	 }
        	 if(parentCode.length()+ Contstants.TYPE_SEGMENT_LENGTH != faqType.getFaqTypeCode().length() 
        			 || ! faqType.getFaqTypeCode().startsWith(parentCode)){
        		 faqType.setFaqTypeCode(super.nextTreeId(FaqType.class, "faqTypeCode", parentCode, Contstants.TYPE_SEGMENT_LENGTH));
        		 FaqTypeInfo queryInfo = new FaqTypeInfo();
        		 queryInfo.setParentCode(info.getFaqTypeCode());
        		 List<FaqType> subTypeList = this.findFaqTypeList(queryInfo);
        		 
        		 for(FaqType subType : subTypeList){
        			String newCode = faqType.getFaqTypeCode() + subType.getFaqTypeCode().substring(info.getFaqTypeCode().length());
             		subType.setFaqTypeCode(newCode);
        		 }
        		 super.saveAll(subTypeList);
        	 }
        	 */
         }
         faqType.setFaqTypeName(info.getFaqTypeName());
         super.save(faqType);
         return faqType;
    }
    
    /**
     * 删除条目
     * @param info
     * @param errorMsg 错误信息  成功则返回空
     * @return 
     */
    @Transactional
    public FaqType deleteFaqType(Long faqTypeId, StringBuffer errorMsg) {
         FaqType faqType = super.load(FaqType.class, faqTypeId);
         
         if(faqType == null) {
             errorMsg.append("指定的分类不存在！");
             return null;
         }
         FaqTypeInfo faqTypeInfo = new FaqTypeInfo();
         faqTypeInfo.setParentCode(faqType.getFaqTypeCode());
         IQueryObject qo = super.getQueryObject(faqTypeInfo);
         if (super.exists(qo.getQueryString(), qo.getParam())) {
        	 errorMsg.append("要删除的分类包含有下级分类，请先删除下级分类.");
        	 return faqType;
         }
         
         FaqQueryInfo faqQueryInfo = new FaqQueryInfo();
         faqQueryInfo.setFaqTypeId(faqType.getFaqTypeId());
         qo = super.getQueryObject(faqQueryInfo);
         
         if (super.exists(qo.getQueryString(), qo.getParam())) {
        	 errorMsg.append("要删除的分类包含有条目记录，请先删除其包含的相关条目.");
        	 return faqType;
         }
         super.delete(faqType);
         return faqType;
    }
    
}
