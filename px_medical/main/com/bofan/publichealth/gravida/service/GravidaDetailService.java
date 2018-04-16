package com.bofan.publichealth.gravida.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.gravida.command.GravidaDetailEditInfo;
import com.bofan.publichealth.gravida.command.GravidaDetailQueryInfo;
import com.bofan.publichealth.gravida.valueobject.GravidaDetail;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * @Description: 孕产妇登记卡业务
 * @author lqw
 */
@Service
@Transactional
public class GravidaDetailService extends AbstractAnnoCommonService {
	
	/**
	 * 根据条件查询孕产妇登记卡分页记录
	 * @param queryInfo
	 * @return
	 */
	public Page selectGravidaDetailPage(GravidaDetailQueryInfo info) { 
		IQueryObject qo = super.getQueryObject(info);
		return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
	}
	
	/**
	 * 根据条件查询 孕产妇登记 列表
	 * @param queryInfo
	 * @return
	 */
    @SuppressWarnings("unchecked")
    public List<GravidaDetail> selectGravidaDetailList(GravidaDetailQueryInfo queryInfo) { 
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    } 
    
    /**
     * 根据条件查询 孕产妇登记
     * @param queryInfo
     * @return
     */
    public GravidaDetail findGravidaDetailList(GravidaDetailQueryInfo queryInfo) { 
        List<GravidaDetail> list = this.selectGravidaDetailList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }

	/**
	 * 保存孕产妇登记卡 
	 */
	public GravidaDetail saveGravidaDetail(GravidaDetailEditInfo editInfo) {
		GravidaDetail gravidaDetail = null;
		if (null != editInfo.getGravidaDetailId()) {
			gravidaDetail = super.selectAObject(GravidaDetail.class,editInfo.getGravidaDetailId());
			NullBeanUtils.copyProperties(gravidaDetail, editInfo);
		} else {
			gravidaDetail = new GravidaDetail();
			NullBeanUtils.copyProperties(gravidaDetail, editInfo);
			gravidaDetail.setValidFlag(Contstants.YES_FLAG);
		}
		//保存 孕产妇登记卡档案
		super.save(gravidaDetail);
		return gravidaDetail;
	}

	/**
	 * 将孕妇信息置为无效
	 * @param gravidaDetailId
	 */
	public void delGravidaDetail(Long gravidaDetailId) {
		GravidaDetail gravidaDetail = super.selectAObject(GravidaDetail.class,gravidaDetailId);
		gravidaDetail.setValidFlag(Contstants.NO_FLAG);
		super.save(gravidaDetail);
	}
 
	 
	
}
