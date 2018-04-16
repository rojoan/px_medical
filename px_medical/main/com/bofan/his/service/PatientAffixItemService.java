package com.bofan.his.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.his.command.PatientAffixItemQueryInfo;
import com.bofan.his.valueobject.PatientAffixItem;

/**
 * @Description: 患者附件
 * @author lqw
 */
@Service
@Transactional
public class PatientAffixItemService extends AbstractAnnoCommonService {

	/**
	 * 根据附件标识查询附件列表
	 * @param affixId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PatientAffixItem> selectPatientAffixItem(String affixId) {
		if (StringUtils.isBlank(affixId)) {
			return new ArrayList<PatientAffixItem>();
		}
		PatientAffixItemQueryInfo queryInfo = new PatientAffixItemQueryInfo();
		queryInfo.setAffixId(affixId);
		IQueryObject qo = super.getQueryObject(queryInfo);
		return super.executeSql(qo.getQueryString(),qo.getParam());
	}

}
