/*
 * <p> Title:  FaqAffixService.java</p>
 * <p>Copyright:   BoFan (b) 2013</p>
 * <p>Company: 博繁科技</p>
 */
package com.bofan.faq.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.affix.command.AffixItem;
import com.affix.service.IAffixService;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.faq.valueobject.FaqAffix;
import com.bofan.faq.valueobject.FaqAffixItem;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;


/**
 * <p> Calss Name:  FaqAffixService.java</p>
 * <p> Description: Faq附件上传服务接口  </p>
 * @version 1.0
 * @author GAOXH
 * @created  2018-2-16
 */
@Service
public class FaqAffixService extends AbstractAnnoCommonService implements IAffixService {

	/**
	 * @see com.bofan.utils.IPluggableService#getServiceId()
	 */
	public String getServiceId() {
		return "faq";
	}
	
    /**
     * @see com.bofan.affix.service.IAffixService#saveAffixItem(com.bofan.affix.command.AffixItem)
     */
    @Transactional
    public String saveAffixItem(String uniqueCode, AffixItem affixItem) {
        if (affixItem.getAffixId() == null) {
            FaqAffix affix = new FaqAffix();
            affix.setAffixId(uniqueCode);
            super.save(affix);
            affixItem.setAffixId(affix.getAffixId());
        }
        FaqAffixItem faqAffixItem = new FaqAffixItem();
        NullBeanUtils.copyProperties(faqAffixItem, affixItem);
        faqAffixItem.setIsImage(affixItem.getIsImage() ? Contstants.IMAGE_YES : Contstants.IMAGE_NO);
        faqAffixItem.setPdfFlag(affixItem.getIsPdf() ? Contstants.PDF_YES : Contstants.PDF_NO);
        super.save(faqAffixItem);
        return faqAffixItem.getFileId() + "," + faqAffixItem.getAffixId();
    }

    /**
     * @see com.bofan.affix.service.IAffixService#deleteAffixItem(java.lang.String)
     */
    @Transactional
    public String deleteAffixItem(Long fileId) {
    	FaqAffixItem item = super.delete(FaqAffixItem.class, fileId);
    	return item.getSavePath();
    }

    /**
     * @see com.bofan.affix.service.IAffixService#findAffixItem(java.lang.Long)
     */
    @Transactional
	public AffixItem findAffixItem(Long fileId) {
        FaqAffixItem item = (FaqAffixItem) super.getCommonDao().load(FaqAffixItem.class, fileId);
        AffixItem affixItem = new AffixItem();
    	NullBeanUtils.copyProperties(affixItem, item);
    	return affixItem;
	}

}
