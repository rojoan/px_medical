/*
 * <p> Title:  LawInfo.java</p>
 * <p>Copyright:   BoFan (b) 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.bofan.faq.command;

import com.bofan.autoform.FormField;
import com.bofan.autoform.FormInfo;
import com.bofan.autoform.FormMethod;
import com.bofan.autoform.Validator;
import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * <p> Calss Name:  FaqEditInfo.java</p>
 * <p> Description: Faq表单数据准备  </p>
 * @version 1.0
 * @author pch
 * @created  2018-2-16
 */
@FormInfo(action="../faq/faqSave.jo", layout="rowLayout", method=FormMethod.POST)
public class FaqEditInfo extends BaseCommandInfo{     
    private static final long serialVersionUID = 1L; 
    
    @FormField(type="hidden")
    private String parentCode;
    
    @FormField(type="hidden")
    private Long faqDetailId;
    
  //$faqTypeName在info中找，如果绑定model数据，则需要指定model中的名称
    @FormField(type="treePicker", label="分类", validator=@Validator(required=true),
            options={"text=$faqTypeName", "action=/faq/faqTypeEditor.jo"}
    )
    private Long faqTypeId;
    
    private String faqTypeCode;
    
   
    private String faqTypeName;
    
    private String createTime;
    
    private String creator;
    
    @FormField(type="text", label="标题", validator=@Validator(required=true, value="maxLength:1000"))
    private String faqTitle;

    @FormField(type="rich", label="内容", options="rows=16", validator=@Validator(required=true))
    private String faqContent;
    
    @FormField(type="affix", label="附件", options={"area=faq", "items=$affix.items"})
    private String affixId;
    
    @FormField(type="hidden")
    private Long creatorId;

    public String getFaqTypeName() {
        return faqTypeName;
    }

    public void setFaqTypeName(String faqTypeName) {
        this.faqTypeName = faqTypeName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

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

    public String getAffixId() {
        return affixId;
    }

    public void setAffixId(String affixId) {
        this.affixId = affixId;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
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

	public void setFaqTypeId(Long faqTypeId) {
		this.faqTypeId = faqTypeId;
	}

	public Long getFaqTypeId() {
		return faqTypeId;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setFaqTypeCode(String faqTypeCode) {
		this.faqTypeCode = faqTypeCode;
	}

	public String getFaqTypeCode() {
		return faqTypeCode;
	}
}
