/*
 * <p> Title:  FaqTypeInfo.java</p>
 * <p>Copyright:   BoFan (b) 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.bofan.faq.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryParam;
import com.bofan.infoql.QueryParams;
import com.bofan.utils.Contstants;

/**
 * <p> Calss Name:  FaqTypeInfo.java</p>
 * <p> Description:  faq类别查询 </p>
 * @version 1.0
 * @author wangsx
 * @created  2018-3-25
 */

@QueryInfo(from="com.bofan.faq.valueobject.FaqType", orderBy="faqTypeCode")
public class FaqTypeInfo extends BaseCommandInfo{

    private static final long serialVersionUID = 1L;
    
    @QueryParam
    private Long faqTypeId; 
    
    @QueryParam
    private String faqTypeCode;
    
    @QueryParams({
        @QueryParam(
	        on = Contstants.ROOT_TREE_ID, 
	        stmt="length(faqTypeCode)=" + Contstants.TYPE_SEGMENT_LENGTH
        ),
        @QueryParam(
        	stmt="faqTypeCode <> ? and faqTypeCode like ?%"
        )
    })
    private String parentCode; 
   
    @QueryParam(stmt="length(faqTypeId)=?")
    private Integer childIdLenLimit;
    
    private String faqTypeName;

    public Integer getChildIdLenLimit() {
        return childIdLenLimit;
    }
    public void setChildIdLenLimit(Integer childIdLenLimit) {
        this.childIdLenLimit = childIdLenLimit;
    }
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setFaqTypeName(String faqTypeName) {
		this.faqTypeName = faqTypeName;
	}
	public String getFaqTypeName() {
		return faqTypeName;
	}
	public void setFaqTypeCode(String faqTypeCode) {
		this.faqTypeCode = faqTypeCode;
	}
	public String getFaqTypeCode() {
		return faqTypeCode;
	}
	public void setFaqTypeId(Long faqTypeId) {
		this.faqTypeId = faqTypeId;
	}
	public Long getFaqTypeId() {
		return faqTypeId;
	}
}
