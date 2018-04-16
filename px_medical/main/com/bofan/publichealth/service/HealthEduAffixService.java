/*
 * <p> Title:  FaqAffixService.java</p>
 * <p>Copyright:   ChaoChuang (c) 2013</p>
 * <p>Company: 南宁超创信息工程有限公司</p>
 */
package com.bofan.publichealth.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.affix.command.AffixItem;
import com.affix.service.IAffixService;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.publichealth.valueobject.HealthEduAffix;
import com.bofan.publichealth.valueobject.HealthEduAffixItem;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;


/**
 * <p> Calss Name:  HealthEduAffixService.java</p>
 * <p> Description: 健康教育附件上传服务接口  </p>
 * @version 1.0
 * @author GAOXH
 * @created  2018-2-16
 */
@Service
public class HealthEduAffixService extends AbstractAnnoCommonService implements IAffixService {

	/**
	 * @see com.bofan.utils.IPluggableService#getServiceId()
	 */
	public String getServiceId() {
		return "healthEduAffix";
	}
	
    /**
     * @see com.bofan.affix.service.IAffixService#saveAffixItem(com.bofan.affix.command.AffixItem)
     */
    @Transactional
    public String saveAffixItem(String uniqueCode, AffixItem affixItem) {
        if (affixItem.getAffixId() == null) {
            HealthEduAffix affix = new HealthEduAffix();
            affix.setAffixId(uniqueCode);
            super.save(affix);
            affixItem.setAffixId(affix.getAffixId());
        }
        HealthEduAffixItem eduAffixItem = new HealthEduAffixItem();
        NullBeanUtils.copyProperties(eduAffixItem, affixItem);
        eduAffixItem.setIsImage(affixItem.getIsImage() ? Contstants.IMAGE_YES : Contstants.IMAGE_NO);
        eduAffixItem.setPdfFlag(affixItem.getIsPdf() ? Contstants.PDF_YES : Contstants.PDF_NO);
        super.save(eduAffixItem);
        return eduAffixItem.getAffixItemId() + "," + eduAffixItem.getAffixId();
    }

    /**
     * @see com.bofan.affix.service.IAffixService#deleteAffixItem(java.lang.String)
     */
    @Transactional
    public String deleteAffixItem(Long fileId) {
        HealthEduAffixItem item = super.delete(HealthEduAffixItem.class, fileId);
    	return item.getSavePath();
    }

    /**
     * @see com.bofan.affix.service.IAffixService#findAffixItem(java.lang.Long)
     */
    @Transactional
	public AffixItem findAffixItem(Long fileId) {
        HealthEduAffixItem item = (HealthEduAffixItem) super.getCommonDao().load(HealthEduAffixItem.class, fileId);
        AffixItem affixItem = new AffixItem();
    	NullBeanUtils.copyProperties(affixItem, item);
    	return affixItem;
	}
}
