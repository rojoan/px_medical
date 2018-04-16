package com.bofan.emergencyevent.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.emergencyevent.command.EmHealthCheckEditInfo;
import com.bofan.emergencyevent.command.EmHealthCheckQueryInfo;
import com.bofan.emergencyevent.command.EmHealthReportOtherInfo;
import com.bofan.emergencyevent.command.EmHealthReportQueryInfo;
import com.bofan.emergencyevent.command.EmReportEventAreaQueryInfo;
import com.bofan.emergencyevent.command.EmReportEventSourceQueryInfo;
import com.bofan.emergencyevent.command.EmReportSymptomQueryInfo;
import com.bofan.emergencyevent.valueobject.EmHealthCheck;
import com.bofan.emergencyevent.valueobject.EmHealthReport;
import com.bofan.emergencyevent.valueobject.EmReportEventArea;
import com.bofan.emergencyevent.valueobject.EmReportEventSource;
import com.bofan.emergencyevent.valueobject.EmReportSymptom;
import com.bofan.utils.JsonObj;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.ResponseContstants;

/**
 * @Description: 突发公卫报告登记业务
 * @author lqw
 */
@Service
@Transactional
public class EmHealthReportService extends AbstractAnnoCommonService {

	/**
	 * 根据条件查询转诊申请信息
	 * 
	 * @param info
	 * @return
	 */
	public Page selectEmHealthReportList(EmHealthReportQueryInfo info) {
		IQueryObject qo = super.getQueryObject(info);
		return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
	}

	public EmHealthReport selectEmHealthReportById(Long healthReportId) {
		return super.load(EmHealthReport.class, healthReportId);
	}

	/**
	 * 保存突发公卫报告登记
	 */
	public EmHealthReport saveEmHealthReport(EmHealthReportOtherInfo info) {
		EmHealthReport emHealthReport = null;
		if (null == info.getHealthReportId()) {
			//新增
			emHealthReport = new EmHealthReport(); 
			NullBeanUtils.copyProperties(emHealthReport, info);
			super.save(emHealthReport);
			//保存与 突发症状的关联
			if (null != info.getCheifSymptomId() && info.getCheifSymptomId().length > 0 ) {
				for (int i = 0; i < info.getCheifSymptomId().length; i++) {
					EmReportSymptom emRreportSymptom = new EmReportSymptom();
					emRreportSymptom.setCheifSymptomId(info.getCheifSymptomId()[i]);
					emRreportSymptom.setHealthReportId(emHealthReport.getHealthReportId());;
					super.getCommonDao().save(emRreportSymptom);
				}
			}
			//保存与 突发事件场所的关联
			if (null != info.getEventAreaId() && info.getEventAreaId().length > 0 ) {
				for (int i = 0; i < info.getEventAreaId().length; i++) { 
					EmReportEventArea emReportEventArea = new EmReportEventArea();
					emReportEventArea.setEventAreaId(info.getEventAreaId()[i]);
					emReportEventArea.setHealthReportId(emHealthReport.getHealthReportId());;
					super.getCommonDao().save(emReportEventArea);
				}
			}
			//保存与 事件信息来源的关联
			if (null != info.getEventSourceId() && info.getEventSourceId().length > 0 ) {
				for (int i = 0; i < info.getEventSourceId().length; i++) {
					EmReportEventSource emReportEventSource = new EmReportEventSource();
					emReportEventSource.setEventSourceId(info.getEventSourceId()[i]);
					emReportEventSource.setHealthReportId(emHealthReport.getHealthReportId());;
					super.getCommonDao().save(emReportEventSource);
				}
			}
			
			return emHealthReport;
		}  
 
		//进行修改
		emHealthReport = this.selectEmHealthReportById(info.getHealthReportId());
		NullBeanUtils.copyProperties(emHealthReport, info);
		super.save(emHealthReport);
		 
		//更新与 突发症状的关联
		saveEmReportSymptom(info);
		//更新与 突发事件场所的关联
		saveEmReportEventArea(info);
		//更新与 事件信息来源的关联
		saveEmReportEventSource(info);
		return emHealthReport;
	}

	
	@SuppressWarnings("unchecked")
	public List<EmReportEventArea> selectEmReportEventArea(EmReportEventAreaQueryInfo queryInfo){
		IQueryObject qo = super.getQueryObject(queryInfo);
		return super.executeSql(qo.getQueryString(), qo.getParam());
	}
	
	@SuppressWarnings("unchecked")
	public List<EmReportEventSource> selectEmReportEventSource(EmReportEventSourceQueryInfo queryInfo){
		IQueryObject qo = super.getQueryObject(queryInfo);
		return super.executeSql(qo.getQueryString(), qo.getParam());
	}
	
	@SuppressWarnings("unchecked")
	public List<EmReportSymptom> selectEmReportSymptom(EmReportSymptomQueryInfo queryInfo){
		IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
	}
	
	/**
	 * @param info
	 */
	@SuppressWarnings("rawtypes")
	private void saveEmReportSymptom(EmHealthReportOtherInfo info) {
		Iterator<EmReportSymptom> itemReportSymptomIt = this.selectEmReportSymptom(new EmReportSymptomQueryInfo(info.getHealthReportId())).iterator();
		if (null == info.getCheifSymptomId() ) {
			 // 如果页面传参不存在关联关系，则删除关联 
	        while (itemReportSymptomIt.hasNext()) {
	        	EmReportSymptom itemReportSymptom = (EmReportSymptom) itemReportSymptomIt.next();
	        	super.getCommonDao().delete(itemReportSymptom); 
	        }
		} else {
			 // 如果页面传参存在关联关系，则更新关联关系
			Map<Long,EmReportSymptom> itemReportSymptomMap = new HashMap<Long,EmReportSymptom>();
	        while (itemReportSymptomIt.hasNext()) {
	        	EmReportSymptom reportSymptomItem = (EmReportSymptom) itemReportSymptomIt.next();
	            itemReportSymptomMap.put(reportSymptomItem.getCheifSymptomId(), reportSymptomItem);
	        }
		    for (int i = 0; i < info.getCheifSymptomId().length; i++) {
		    	if (itemReportSymptomMap.containsKey(info.getCheifSymptomId()[i])) {
		    		itemReportSymptomMap.remove(info.getCheifSymptomId()[i]);
				} else {
					//不包含则需要新增
					EmReportSymptom emRreportSymptom = new EmReportSymptom();
					emRreportSymptom.setCheifSymptomId(info.getCheifSymptomId()[i]);
					emRreportSymptom.setHealthReportId(info.getHealthReportId());;
					super.getCommonDao().save(emRreportSymptom);
				}
		    }
		    if (!itemReportSymptomMap.isEmpty()) {
	            Iterator it = itemReportSymptomMap.entrySet().iterator();
	            while (it.hasNext()) {
	                super.getCommonDao().delete((EmReportSymptom) ((Map.Entry) it.next()).getValue());
	            }
	        }
        }
	}
	
	/**
	 * @param info
	 */
	@SuppressWarnings("rawtypes")
	private void saveEmReportEventArea(EmHealthReportOtherInfo info) {
		Iterator<EmReportEventArea> itemReportEvenAreaIt = this.selectEmReportEventArea(
				new EmReportEventAreaQueryInfo(info.getHealthReportId())).iterator();
		if (null == info.getEventAreaId()) {
			// 如果页面传参不存在关联关系，则删除关联 
			while (itemReportEvenAreaIt.hasNext()) {
				EmReportEventArea itemReportEventArea = (EmReportEventArea) itemReportEvenAreaIt.next();
				super.getCommonDao().delete(itemReportEventArea); 
			} 
		} else {
			// 如果页面传参存在关联关系，则更新关联关系
			Map<String,EmReportEventArea> itemReportEventAreaMap = new HashMap<String,EmReportEventArea>();
			while (itemReportEvenAreaIt.hasNext()) {
				EmReportEventArea itemReportEventArea = (EmReportEventArea) itemReportEvenAreaIt.next();
				itemReportEventAreaMap.put(itemReportEventArea.getEventAreaId(), itemReportEventArea);
			}
			for (int i = 0; i < info.getEventAreaId().length; i++) {
				if (itemReportEventAreaMap.containsKey(info.getEventAreaId()[i])) {
					itemReportEventAreaMap.remove(info.getEventAreaId()[i]);
				} else {
					//不包含则需要新增
					EmReportEventArea emRreportEventArea = new EmReportEventArea();
					emRreportEventArea.setEventAreaId(info.getEventAreaId()[i]);
					emRreportEventArea.setHealthReportId(info.getHealthReportId());;
					super.getCommonDao().save(emRreportEventArea); 
				}
			}
			if (!itemReportEventAreaMap.isEmpty()) {
				Iterator it = itemReportEventAreaMap.entrySet().iterator();
				while (it.hasNext()) {
					super.getCommonDao().delete((EmReportEventArea) ((Map.Entry) it.next()).getValue());
				}
			}
		}
	}
	
	/**
	 * @param info
	 */
	@SuppressWarnings("rawtypes")
	private void saveEmReportEventSource(EmHealthReportOtherInfo info) {
		Iterator<EmReportEventSource> itemReportEventSourceIt = this.selectEmReportEventSource(
				new EmReportEventSourceQueryInfo(info.getHealthReportId())).iterator();
		if (null == info.getEventSourceId()) {
			 // 如果页面传参不存在关联关系，则删除关联 
	        while (itemReportEventSourceIt.hasNext()) {
	        	EmReportEventSource itemReportEventSource = (EmReportEventSource) itemReportEventSourceIt.next();
	        	super.getCommonDao().delete(itemReportEventSource); 
	        }
		} else {
			 // 如果页面传参存在关联关系，则更新关联关系
			Map<Long,EmReportEventSource> itemReportEventSourceMap = new HashMap<Long,EmReportEventSource>();
	        while (itemReportEventSourceIt.hasNext()) {
	        	EmReportEventSource itemReportEventSource = (EmReportEventSource) itemReportEventSourceIt.next();
	            itemReportEventSourceMap.put(itemReportEventSource.getEventSourceId(), itemReportEventSource);
	        }
		    for (int i = 0; i < info.getEventSourceId().length; i++) {
		    	if (itemReportEventSourceMap.containsKey(info.getEventSourceId()[i])) {
		    		itemReportEventSourceMap.remove(info.getEventSourceId()[i]);
				} else {
					//不包含则需要新增
					EmReportEventSource emRreportSymptom = new EmReportEventSource();
					emRreportSymptom.setEventSourceId(info.getEventSourceId()[i]);
					emRreportSymptom.setHealthReportId(info.getHealthReportId());;
					super.getCommonDao().save(emRreportSymptom);
				}
		    }
		    if (!itemReportEventSourceMap.isEmpty()) {
	            Iterator it = itemReportEventSourceMap.entrySet().iterator();
	            while (it.hasNext()) {
	                super.getCommonDao().delete((EmReportEventSource) ((Map.Entry) it.next()).getValue());
	            }
	        }
        }
	}

	/**
	 * 保存突发公卫报告的审核内容
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

	/**
	 * 根据审核ID查询审核信息
	 * @param healthCheckId
	 */
	@SuppressWarnings("unchecked")
	public EmHealthCheck selectHealthCheckByReportId(Long healthReportId) {
		EmHealthCheckQueryInfo queryInfo = new EmHealthCheckQueryInfo();
		queryInfo.setHealthReportId(healthReportId);
		IQueryObject qo = super.getQueryObject(queryInfo);
		List<EmHealthCheck> list = super.executeSql(qo.getQueryString(), qo.getParam());
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public JsonObj delemHealthReport(Long healthReportId) {
		JsonObj result = new JsonObj();
		EmHealthCheck emHealthCheck = this.selectHealthCheckByReportId(healthReportId);
		if (null != emHealthCheck) {
			result.setCode(ResponseContstants.RESULT_FAIL_CODE);
			result.setMsg("已审核的报告不能删除！");
			return result;
		}
		
		EmHealthReport emHealthReport = this.selectEmHealthReportById(healthReportId);
		
	 
		 // 删除与与事件信息来源 关联 
		Iterator<EmReportSymptom> itemReportSymptomIt = this.selectEmReportSymptom(
				new EmReportSymptomQueryInfo(healthReportId)).iterator();
	    while (itemReportSymptomIt.hasNext()) {
        	EmReportSymptom itemReportSymptom = (EmReportSymptom) itemReportSymptomIt.next();
        	super.delete(itemReportSymptom); 
        }
		
	    // 删除与事件发生场所 关联 
	    Iterator<EmReportEventArea> itemReportEvenAreaIt = this.selectEmReportEventArea(
				new EmReportEventAreaQueryInfo(healthReportId)).iterator();
		while (itemReportEvenAreaIt.hasNext()) {
			EmReportEventArea itemReportEventArea = (EmReportEventArea) itemReportEvenAreaIt.next();
			super.delete(itemReportEventArea); 
		} 
	 
		//删除 与事件信息来源 关联
		Iterator<EmReportEventSource> itemReportEventSourceIt = this.selectEmReportEventSource( 
				new EmReportEventSourceQueryInfo(healthReportId)).iterator();
        while (itemReportEventSourceIt.hasNext()) {
        	EmReportEventSource itemReportEventSource = (EmReportEventSource) itemReportEventSourceIt.next();
        	super.delete(itemReportEventSource); 
        }
        
        super.delete(emHealthReport);
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
		
		return result;
	}
	
}
