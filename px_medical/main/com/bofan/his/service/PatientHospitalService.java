package com.bofan.his.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.his.command.PatientHospitalQueryInfo;
import com.bofan.his.valueobject.PatientHospital;
import com.bofan.utils.Tools;

/**
 * @author lqw
 * @date 2017-10-2
 * @version V1.0
 */
@Service
@Transactional
public class PatientHospitalService extends AbstractAnnoCommonService {

	/**
	 * 根据条件查询患者信息
	 * @param queryInfo PatientHospitalQueryInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PatientHospital> selectPatientHospitalList(PatientHospitalQueryInfo queryInfo) {
		IQueryObject qo = super.getQueryObject(queryInfo);
		return super.executeSql(qo.getQueryString(),qo.getParam());
	}
	
	/**
	 * 根据条件查询患者索引信息
	 * @param queryInfo PatientHospitalQueryInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PatientHospital findPatientHospital(PatientHospitalQueryInfo queryInfo) {
		IQueryObject qo = super.getQueryObject(queryInfo);
		List<PatientHospital> list = super.executeSql(qo.getQueryString(),qo.getParam());
		if (Tools.isNotEmptyList(list)) {
			return list.get(0);
		}
		return null;
	}
}
