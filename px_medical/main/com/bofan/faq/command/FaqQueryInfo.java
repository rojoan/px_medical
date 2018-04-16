/*
 * <p> Title:  FaqDetailInfo.java</p>
 * <p>Copyright:   BoFan (b) 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.bofan.faq.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryOrder;
import com.bofan.infoql.QueryOrders;
import com.bofan.infoql.QueryParam;
import com.bofan.infoql.QueryParams;
import com.bofan.utils.Contstants;

/**
 * <p> Calss Name:  FaqQueryInfo.java</p>
 * <p> Description: Faq列表查询构造  </p>
 * @version 1.0
 * @author GAOXH
 * @created  2018-2-16
 */
@QueryInfo(from="com.bofan.faq.valueobject.FaqDetail fd", orderBy = "fd.faqTypeId asc, fd.faqDetailId desc")
public class FaqQueryInfo extends BaseCommandInfo{     
    private static final long serialVersionUID = 1L; 
    
    public static final String HOT = "hot";
    public static final int HOT_PAGE_SIZE = 20;
    public static final String ORDER_CLICK_DESC = "clickDesc";
    public static final String ORDER_CLICK_ASC = "clickasc";
    
    @QueryParam(fieldName = "fd.faqDetailId", op = QueryOperator.EQU)
    private Long faqDetailId; 
    
    @QueryParam(fieldName = "fd.faqTypeId", op = QueryOperator.EQU)
    private Long faqTypeId; 

    @QueryParam(fieldName="fd.faqTitle", op=QueryOperator.LIKE)
    private String faqTitle; 
  
    //全文检索 调用oracle全文检索函数contains
    @QueryParams({
        @QueryParam(
            stmt="contains(fd.faqContent,?,1)>0")
    })
    private String faqContent;
    
    //近期热点查询:  一个月以内点击超过50次 ,可以修改常量更改改条件设置
    @QueryParams({
        @QueryParam(
            on=HOT, 
            stmt="fd.clickCount >="+ Contstants.CLICK_HOT_COUNT +" and floor(sysdate - fd.createTime) <= " +Contstants.CLICK_HOT_DAYS)
    })
    private String hot;
    
    @QueryParam(fieldName="fd.faqDetailId", op=QueryOperator.NOT_EQU)
    private Long notFaqDetailId; 
    
    @QueryOrders({
        @QueryOrder(on=ORDER_CLICK_DESC, stmt="fd.clickCount desc, fd.faqDetailId asc"),
        @QueryOrder(on=ORDER_CLICK_ASC, stmt="fd.clickCount asc, fd.faqDetailId desc")
    })
    private String orderBy;
    
    //大于等于
    @QueryParam(fieldName="fd.clickCount", op=QueryOperator.GT)
    private Long gtClickCount;
    
    @QueryParam(fieldName="fd.clickCount", op=QueryOperator.LESS_EQU)
    private Long leClickCount;
    
    public String getFaqTitle() {
        return faqTitle;
    }

    public void setFaqTitle(String faqTitle) {
        this.faqTitle = faqTitle;
    }

    public String getFaqContent() {
        return faqContent;
    }

    public void setFaqContent(String faqContent) {
        this.faqContent = faqContent;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    /**
	 * @return the faqDetailId
	 */
	public Long getFaqDetailId() {
		return faqDetailId;
	}

	/**
	 * @param faqDetailId the faqDetailId to set
	 */
	public void setFaqDetailId(Long faqDetailId) {
		this.faqDetailId = faqDetailId;
	}

    /**
     * @return the notFaqDetailId
     */
    public Long getNotFaqDetailId() {
        return notFaqDetailId;
    }

    /**
     * @param notFaqDetailId the notFaqDetailId to set
     */
    public void setNotFaqDetailId(Long notFaqDetailId) {
        this.notFaqDetailId = notFaqDetailId;
    }

    /**
     * @return the gtClickCount
     */
    public Long getGtClickCount() {
        return gtClickCount;
    }

    /**
     * @param gtClickCount the gtClickCount to set
     */
    public void setGtClickCount(Long gtClickCount) {
        this.gtClickCount = gtClickCount;
    }

    /**
     * @return the leClickCount
     */
    public Long getLeClickCount() {
        return leClickCount;
    }

    /**
     * @param leClickCount the leClickCount to set
     */
    public void setLeClickCount(Long leClickCount) {
        this.leClickCount = leClickCount;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

	public void setFaqTypeId(Long faqTypeId) {
		this.faqTypeId = faqTypeId;
	}

	public Long getFaqTypeId() {
		return faqTypeId;
	} 
    

    
}
