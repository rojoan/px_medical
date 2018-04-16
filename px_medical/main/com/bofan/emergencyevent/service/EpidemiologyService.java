package com.bofan.emergencyevent.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.emergencyevent.command.EmHealthCheckEditInfo;
import com.bofan.emergencyevent.command.EmHealthCheckQueryInfo;
import com.bofan.emergencyevent.command.EpidemiologyEditInfo;
import com.bofan.emergencyevent.command.EpidemiologyQueryInfo;
import com.bofan.emergencyevent.valueobject.EmHealthCheck;
import com.bofan.emergencyevent.valueobject.Epidemiology;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description: 流行病学记录业务
 * @author lqw
 */
@Service
@Transactional
public class EpidemiologyService extends AbstractAnnoCommonService {

	/**
	 * 根据条件查询流行病学记录分页记录
	 * 
	 * @param info
	 * @return
	 */
	public Page selectEpidemiologyList(EpidemiologyQueryInfo info) {
		IQueryObject qo = super.getQueryObject(info);
		return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
	}

	/**
	 * 根据id查询流行病学记录
	 * @param epidemiologyId
	 * @return
	 */
	public Epidemiology selectEpidemiologyById(Long epidemiologyId) {
		return super.load(Epidemiology.class, epidemiologyId);
	}

	/**
	 * 保存流行病学记录
	 */
	public Epidemiology saveEpidemiology(EpidemiologyEditInfo editInfo) {
		Epidemiology epidemiology = null;
		if (null != editInfo.getEpidemiologyId()) {
			epidemiology = this.selectEpidemiologyById(editInfo.getEpidemiologyId());
		} else {
			epidemiology = new Epidemiology();
		}

		NullBeanUtils.copyProperties(epidemiology, editInfo);
		super.save(epidemiology);
		return epidemiology;
	}

	/**
	 * 根据流行病学记录ID 查询审核信息
	 * @param epidemiologyId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EmHealthCheck selectHealthCheckByEpidemiologyId(Long epidemiologyId) {
		EmHealthCheckQueryInfo queryInfo = new EmHealthCheckQueryInfo();
		queryInfo.setEpidemiologyId(epidemiologyId);
		IQueryObject qo = super.getQueryObject(queryInfo);
		List<EmHealthCheck> list = super.executeSql(qo.getQueryString(), qo.getParam());
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 保存流行病学记录的审核内容
	 * @param editInfo
	 * @return
	 */
	public EmHealthCheck saveEmHealthCheck(EmHealthCheckEditInfo editInfo) {
		EmHealthCheck emHealthCheck = null;
		if (null != editInfo.getHealthCheckId()) {
			emHealthCheck = super.load(EmHealthCheck.class, editInfo.getHealthCheckId());
		} else {
			emHealthCheck = new EmHealthCheck();
		} 
		 
		NullBeanUtils.copyProperties(emHealthCheck, editInfo);
		emHealthCheck.setCheckTime(new Date()); 
	    super.save(emHealthCheck);
	    return emHealthCheck;
	}

}
