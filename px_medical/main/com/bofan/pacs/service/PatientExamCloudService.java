package com.bofan.pacs.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.pacs.command.PatientExamCloudQueryInfo;

/**
 * @author xlf
 *
 */
@Service
@Transactional
public class PatientExamCloudService extends AbstractAnnoCommonService {

	/**
	 * 
	 * @param info
	 * @return
	 */
	public Page selectPatientExamCloudList(PatientExamCloudQueryInfo info) {
		IQueryObject qo = super.getQueryObject(info);
		return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
	}

}
