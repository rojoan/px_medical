package com.bofan.publichealth.service;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.FamilyDetailOtherEditInfo;
import com.bofan.publichealth.command.FamilyDetailQueryInfo;
import com.bofan.publichealth.valueobject.FamilyDetail;
import com.bofan.publichealth.valueobject.HouseCondition;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * @Description: 家庭基本档案业务
 * @author lqw
 */
@Service
@Transactional
public class FamilyDetailService extends AbstractAnnoCommonService {
 
	
	/**
	 * 根据条件查询家庭基本档案分页记录
	 * @param info
	 * @return
	 */
	public Page selectFamilyDetailList(FamilyDetailQueryInfo info) { 
		IQueryObject qo = super.getQueryObject(info);
		return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
	}
	
	/**
	 * 保存家庭基本档案
	 */
	public FamilyDetail saveFamilyDetail(String familyDetailRetionData) {
		//获取参数
		JSONObject data = JSONObject.parseObject(familyDetailRetionData);
		String familyDetailOtherEditInfoStr = data.getString("familyDetailOtherEditInfo"); 
		FamilyDetailOtherEditInfo info =  JSON.parseObject(familyDetailOtherEditInfoStr, FamilyDetailOtherEditInfo.class);
		
		//设置 家庭基本信息档案
		FamilyDetail familyDetail = null;
		if (null != info.getFamilyDetailId()) {
			familyDetail = super.selectAObject(FamilyDetail.class, info.getFamilyDetailId());
			NullBeanUtils.copyProperties(familyDetail, info);
		} else {
			familyDetail = new FamilyDetail();
			NullBeanUtils.copyProperties(familyDetail, info);
			familyDetail.setCreateTime(new Date());
			familyDetail.setValidFlag(Contstants.YES_FLAG);
			familyDetail.setFamilyNumber(Tools.getLenNextId(new Random().nextInt(10000)+"", 18, "0"));
		}
		
		//保存或更新家庭居住条件
		saveOrUpdateHouseCondition(info, familyDetail);
		//保存 家庭基本信息档案
		super.save(familyDetail);
		return familyDetail;
	}

	/**
	 * 保存或更新家庭居住条件
	 * @param editInfo
	 * @param familyDetail
	 */
	private void saveOrUpdateHouseCondition(FamilyDetailOtherEditInfo editInfo, FamilyDetail familyDetail) {
		//保存或更新家庭居住条件
		HouseCondition houseCondition = null;
		if (null != editInfo.getHouseConditionId()) {
		    houseCondition = super.selectAObject(HouseCondition.class,editInfo.getHouseConditionId());
        }
		if (null != houseCondition) {
			//更新
			NullBeanUtils.copyProperties(houseCondition, editInfo);
			super.save(houseCondition);
		} else {
			//新增
			if (!this.isHouseConditionEmpty(editInfo)) {
				houseCondition = new HouseCondition();
				NullBeanUtils.copyProperties(houseCondition, editInfo);
				super.save(houseCondition);
				familyDetail.setHouseConditionId(houseCondition.getHouseConditionId());//保存家庭条件实体后 才设置这个值
			}
		}
	}

	/**
	 * 判断家庭居住条件和卫生设施的传值是否都为空
	 * @param info
	 * @return
	 */
	public boolean isHouseConditionEmpty(FamilyDetailOtherEditInfo info){
		if (StringUtils.isNotBlank(info.getHouseArea())
				|| StringUtils.isNotBlank(info.getHouseType())
				|| StringUtils.isNotBlank(info.getKitchenAir())
				|| StringUtils.isNotBlank(info.getKitchenClean())
				|| StringUtils.isNotBlank(info.getKitchenFuel())
				|| StringUtils.isNotBlank(info.getKitchenHumidity())
				|| StringUtils.isNotBlank(info.getKitchenRay())
				|| StringUtils.isNotBlank(info.getKitchenUse())
				|| StringUtils.isNotBlank(info.getKitchenWater())
				|| StringUtils.isNotBlank(info.getLivestockBar())
				|| StringUtils.isNotBlank(info.getToiletClean())
				|| StringUtils.isNotBlank(info.getWarmCondition())
				) {
			return false;
		}
		
		return true;
	}
	
}
