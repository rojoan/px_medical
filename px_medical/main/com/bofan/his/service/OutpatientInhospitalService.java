package com.bofan.his.service;


import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.his.command.OutpatientInhospitalEditInfo;
import com.bofan.his.command.OutpatientInhospitalQueryInfo;
import com.bofan.his.valueobject.OutpatientInhospital;
import com.bofan.his.valueobject.PatientAffix;
import com.bofan.his.valueobject.PatientAffixItem;
import com.bofan.pacs.command.PacsDetailEditInfo;
import com.bofan.pacs.command.PacsDetailQueryInfo;
import com.bofan.pacs.command.PatientExamEditInfo;
import com.bofan.pacs.command.PatientImageEditInfo;
import com.bofan.pacs.service.PacsDetailService;
import com.bofan.pacs.service.PatientExamService;
import com.bofan.pacs.service.PatientImageService;
import com.bofan.pacs.valueobject.PacsDetail;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.pacs.valueobject.PatientImage;
import com.bofan.utils.Contstants;
import com.bofan.utils.DateHelper;
import com.bofan.utils.JsonObj;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;
import com.bofan.utils.UniqueCodeUtil;

/**
 * @author lqw
 * @date 2017-10-2
 * @version V1.0
 */
@Service
@Transactional
public class OutpatientInhospitalService extends AbstractAnnoCommonService {
	@Autowired
	private PatientExamService patientExamService;
	@Autowired
	private PatientImageService patientImageService; 
	@Autowired
	private PatientAffixService patientAffixService; 
	@Autowired
	private PatientAffixItemService patientAffixItemService; 
    @Autowired
    private PacsDetailService pacsDetailService; 
 
	
	/**
	 * 根据条件查询门诊-住院表
	 * 
	 * @param queryInfo
	 * @return
	 */
	public Page selectOutpatientInhospitalList(OutpatientInhospitalQueryInfo info) {
		IQueryObject qo = super.getQueryObject(info);
		return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
	}
	
	/**
     * 根据条件查询门诊-住院表
     * 
     * @param queryInfo
     * @return
     */
    public List<OutpatientInhospital> selectOutpatientInhospital(OutpatientInhospitalQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(OutpatientInhospital.class, qo.getQueryString(), qo.getParam());
    }

    /**
     * 根据单位ID、患者ID、患者类型、住院或门诊号查询住院门诊对象信息
     * @param orgId 单位ID
     * @param patientId 患者ID
     * @param patientType 患者类型
     * @param inpatientId 住院或门诊号
     * @return
     */
    public OutpatientInhospital selectOutpatientInhospital(Long orgId, Long patientId, String patientType, Long inpatientId) {
        OutpatientInhospitalQueryInfo info = new OutpatientInhospitalQueryInfo();
        info.setOrgId(orgId);
        info.setPatientId(patientId);
        // 住院
        if (Contstants.PATIENT_TYPE_INHOSPITAL.equals(patientType) || Contstants.PATIENT_TYPE_INHOSPITAL_URGENT.equals(patientType)) {
            info.setInhospitalId(inpatientId);
        }
        // 门诊
        if (Contstants.PATIENT_TYPE_OUTPATIENT.equals(patientType) || Contstants.PATIENT_TYPE_OUTPATIENT_URGENT.equals(patientType)) {
            info.setOutpatientId(inpatientId);
        }
        
        IQueryObject qo = super.getQueryObject(info);
        List<OutpatientInhospital> dataList = super.executeSql(OutpatientInhospital.class, qo.getQueryString(), qo.getParam());
        return (null != dataList && dataList.size() > 0) ? dataList.get(0) : null;
        
    }

	/**
	 * 保存 门诊-住院登记
	 * @param editInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public JsonObj saveOutpatientInhospital(String regPatientExamData) {
		//获取参数
		JSONObject dataJson = JSONObject.parseObject(regPatientExamData);
		String outpatientInhospitalEditInoJson = dataJson.getString("outpatientInhospitalEditInfo");
		String patientExamEditInfoJson = dataJson.getString("patientExamEditInfo");
		String patientImageEditInfoListJson = dataJson.getString("patientImageEditInfoList");
		String patientAffixEditInfoListJson = dataJson.getString("patientAffixEditInfoList");
		String pacsDetailEditInfoListJson = dataJson.getString("pacsDetailEditInfoList");
		
		OutpatientInhospitalEditInfo outInhospitalEditInfo = JSON.parseObject(outpatientInhospitalEditInoJson, OutpatientInhospitalEditInfo.class);
		PatientExamEditInfo patientExamEditInfo = JSON.parseObject(patientExamEditInfoJson, PatientExamEditInfo.class);
		List<JSONObject> patientImageEditInfoList = JSON.parseObject(patientImageEditInfoListJson, List.class);
		List<JSONObject> patientAffixEditInfoList = JSON.parseObject(patientAffixEditInfoListJson, List.class);
		List<JSONObject> pacsDetailEditInfoList = JSON.parseObject(pacsDetailEditInfoListJson, List.class);
		 
		JsonObj result = new JsonObj();
		Map<String,Object> data = new HashMap<String,Object>();
		OutpatientInhospital outpatientInhospital = null;
		OutpatientInhospitalQueryInfo info = new OutpatientInhospitalQueryInfo();
		
		//验证、设置数据 
		if (null != outInhospitalEditInfo.getOutpatientInhospitalId()) {
			outpatientInhospital = super.load(OutpatientInhospital.class, outInhospitalEditInfo.getOutpatientInhospitalId());
		} else {
			//判断门诊号/住院号是否已经存在
			if (null != outInhospitalEditInfo.getOutpatientId()) {
				info.setOrgId(outInhospitalEditInfo.getOrgId());
				info.setOutpatientId(outInhospitalEditInfo.getOutpatientId());
				if (Tools.isNotEmptyList(this.selectOutpatientInhospital(info))) {
					result.setResult(ResponseContstants.RESULT_FAIL_CODE, "门诊号已经存在");
					return result;
				}
			} else {
				info = new OutpatientInhospitalQueryInfo();
				info.setOrgId(outInhospitalEditInfo.getOrgId());
				info.setInhospitalId(outInhospitalEditInfo.getInhospitalId());
				if (Tools.isNotEmptyList(this.selectOutpatientInhospital(info))) {
					result.setResult(ResponseContstants.RESULT_FAIL_CODE, "住院号已经存在");
					return result;
				}
			}
			outpatientInhospital = new OutpatientInhospital();
			outpatientInhospital.setDiagnosisFlag(Contstants.DIAGNOSIS_FLAG_NONE);
			outpatientInhospital.setValidFlag(Contstants.YES_FLAG);
			outpatientInhospital.setAffixId(UniqueCodeUtil.generate(UniqueCodeUtil.DatePattern.SECOND, "", 6));
		}
		
		//保存门诊|住院登记信息
		NullBeanUtils.copyProperties(outpatientInhospital , outInhospitalEditInfo); 
		super.save(outpatientInhospital);
		
		//保存检查信息
		JsonObj saveExamResult =  this.saveOrUpdatePatientExam(patientExamEditInfo);
		//如果检查信息保存失败返回
		if (ResponseContstants.RESULT_FAIL_CODE.equals(saveExamResult.getCode()) ) {
			return saveExamResult;
		}
		//保存检查图像
		this.saveOrUpdataPatientImage(patientImageEditInfoList, patientExamEditInfo);
		//保存检查图像
		this.saveOrUpdataPacsDetail(pacsDetailEditInfoList, patientExamEditInfo);
		
		//保存附件信息
		this.saveOrUpdataPatientAffix(patientAffixEditInfoList, outpatientInhospital.getAffixId());
		data.put("outInhospital", outpatientInhospital);
		data.put("patientExam", saveExamResult.getData());
		result.setData(data);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
    private void saveOrUpdataPacsDetail(List<JSONObject> pacsDetailEditInfoList, PatientExamEditInfo patientExamEditInfo) {
	    if (null == patientExamEditInfo ) {
            return;
        }
	    Iterator<PacsDetail>  pacsDetailIt =  this.pacsDetailService.selectPacsDetailList(
	            new PacsDetailQueryInfo(patientExamEditInfo.getPatientExamId()+"")).iterator();
	    
        //没有上传的dicom文件，删除数据库记录
        if (!Tools.isNotEmptyList(pacsDetailEditInfoList)) {
            while (pacsDetailIt.hasNext()) {  
                PacsDetail pacsDetailItem = (PacsDetail) pacsDetailIt.next();
                super.delete(pacsDetailItem);
            }
            return;
        }
        
        //新增图片，并删除移除的dicom文件
        Map<String,PacsDetail> pacsDetailMap = new HashMap<String,PacsDetail>();
        while (pacsDetailIt.hasNext()) {  
            PacsDetail pacsDetailItem = (PacsDetail) pacsDetailIt.next();
            pacsDetailMap.put(pacsDetailItem.getInstanceUid(), pacsDetailItem);
        }
        
        //从map中移除已存在的dicom文件， 保存新增的dicom文件
        for (JSONObject pacsDetailJson : pacsDetailEditInfoList){
            PacsDetailEditInfo pacsDetailEditInfo = JSON.parseObject(pacsDetailJson.toJSONString(), PacsDetailEditInfo.class);
            if (pacsDetailMap.containsKey(pacsDetailEditInfo.getInstanceUid())) {
                PacsDetail oldPacsDetail = pacsDetailMap.get(pacsDetailEditInfo.getInstanceUid());
                oldPacsDetail.setSeriesUid(oldPacsDetail.getInstanceUid());// 重新设置序列号，才能使dicomService对所有记录解析出dicom文件里面的序列号
                super.save(oldPacsDetail);
                pacsDetailMap.remove(pacsDetailEditInfo.getInstanceUid());
            } else {
                PacsDetail pacsDetail = new PacsDetail();
                NullBeanUtils.copyProperties(pacsDetail, pacsDetailEditInfo);
                pacsDetail.setPatientId(String.valueOf(patientExamEditInfo.getPatientExamId()));
                pacsDetail.setSeriesUid(pacsDetailEditInfo.getInstanceUid());//默认设置为seriesUid 
                pacsDetail.setStudyUid(Contstants.NULLABLE_DEFAULT_STRING);
                pacsDetail.setAccessNumber(Contstants.NULLABLE_DEFAULT_STRING);
                pacsDetail.setHtFsPacsMark(Contstants.PACS_TYPE_FS);
                pacsDetail.setHospitalNo(patientExamEditInfo.getHospitalNo());
                pacsDetail.setDateTime(DateHelper.getDateStr(new Date()));
                super.save(pacsDetail);
            }
            
        }
        //删除已经移除的dicom文件
        if (!pacsDetailMap.isEmpty()) {
            Iterator it = pacsDetailMap.entrySet().iterator();
            while (it.hasNext()) {
                super.delete((PacsDetail) ((Map.Entry) it.next()).getValue());
            }
        }
        
    }

    /**
	 * 保存或更新附件信息
	 * @param patientAffixEditInfoList
	 * @param affixId
	 */
	@SuppressWarnings("rawtypes")
	private void saveOrUpdataPatientAffix(List<JSONObject> patientAffixEditInfoList, String affixId) {
		Iterator<PatientAffixItem>  patientAffixItemIt = this.patientAffixItemService.selectPatientAffixItem(affixId).iterator();
		//没有上传的附件，删除数据库记录
 		if (!Tools.isNotEmptyList(patientAffixEditInfoList)) {
 			while (patientAffixItemIt.hasNext()) {   
 				PatientAffixItem affixItem = (PatientAffixItem) patientAffixItemIt.next();
 	        	super.delete(affixItem);
 	        }
 			return; 
 		}
 		
 		//如果附件标识记录不存在，则保存
 		PatientAffix patientAffix = this.patientAffixService.selectAObject(PatientAffix.class,affixId);
 		if (null == patientAffix) {
 			patientAffix = new PatientAffix(affixId);
 			super.save(patientAffix);
		}
 		
 		//附件 map
 		Map<Long,PatientAffixItem> patientAffixItemMap = new HashMap<Long,PatientAffixItem>();
        while (patientAffixItemIt.hasNext()) {  
        	PatientAffixItem patientImageItem = (PatientAffixItem) patientAffixItemIt.next();
        	patientAffixItemMap.put(patientImageItem.getAffixItemId(), patientImageItem);
        }
	
        //从map移除包含的附件 ， 保存新增的附件
        for (JSONObject patientImageJson : patientAffixEditInfoList){
        	PatientAffixItem patientAffixItemEditInfo = JSON.parseObject(patientImageJson.toJSONString(), PatientAffixItem.class);
			if (patientAffixItemMap.containsKey(patientAffixItemEditInfo.getAffixItemId())) {
				patientAffixItemMap.remove(patientAffixItemEditInfo.getAffixItemId());
			} else {
				PatientAffixItem patientAffixItem = new PatientAffixItem();
				NullBeanUtils.copyProperties(patientAffixItem, patientAffixItemEditInfo); 
				patientAffixItem.setAffixId(affixId);
				super.save(patientAffixItem); 
			}
		}
        //删除已移除的附件
		if (!patientAffixItemMap.isEmpty()) {
			Iterator it = patientAffixItemMap.entrySet().iterator();
            while (it.hasNext()) {
                super.delete((PatientAffixItem) ((Map.Entry) it.next()).getValue());
            }
        }
	}

	//保存或更新检查图像
	@SuppressWarnings("rawtypes")
	private void saveOrUpdataPatientImage(List<JSONObject> patientImageEditInfoList,PatientExamEditInfo patientExamEditInfo ) {
	    if (null == patientExamEditInfo ) {
            return;
        }
		Iterator<PatientImage>  patientImageIt = this.patientImageService.selectPatientImageList(
				patientExamEditInfo.getHospitalNo(), patientExamEditInfo.getHtFsPacsMark(), patientExamEditInfo.getPatientExamNum()).iterator();
		//没有上传的图片，删除数据库记录
		if (!Tools.isNotEmptyList(patientImageEditInfoList)) {
			while (patientImageIt.hasNext()) {  
	        	PatientImage patientImageItem = (PatientImage) patientImageIt.next();
	        	super.delete(patientImageItem);
	        }
			return;
		}
		
		//新增图片，并删除移除的图片
		Map<Long,PatientImage> patientImageMap = new HashMap<Long,PatientImage>();
        while (patientImageIt.hasNext()) {  
        	PatientImage patientImageItem = (PatientImage) patientImageIt.next();
        	patientImageMap.put(patientImageItem.getPatientImageId(), patientImageItem);
        }
		
        //从map中移除已存在的图片， 保存新增的图片
        long imageSort = 0;
		for (JSONObject patientImageJson : patientImageEditInfoList){
			imageSort++;
			PatientImageEditInfo patientImageEditInfo = JSON.parseObject(patientImageJson.toJSONString(), PatientImageEditInfo.class);
			if (patientImageMap.containsKey(patientImageEditInfo.getPatientImageId())) {
				PatientImage patientImage  = patientImageMap.get(patientImageEditInfo.getPatientImageId());
				patientImage.setImageSort(imageSort);
				super.save(patientImage);
				patientImageMap.remove(patientImageEditInfo.getPatientImageId());
			} else {
				PatientImage patientImage = new PatientImage();
				NullBeanUtils.copyProperties(patientImage, patientImageEditInfo);
				patientImage.setPatientImageNum(new Long(new Random().nextInt(1000000000)));
				patientImage.setPatientExamNum(patientExamEditInfo.getPatientExamNum());
				super.save(patientImage);
			}
			
		}
		//删除已经移除的图片
		if (!patientImageMap.isEmpty()) {
            Iterator it = patientImageMap.entrySet().iterator();
            while (it.hasNext()) {
                super.delete((PatientImage) ((Map.Entry) it.next()).getValue());
            }
        }
	}

	/**
	 * 保存病人检查信息
	 * @param editInfo
	 */
	private JsonObj saveOrUpdatePatientExam(PatientExamEditInfo editInfo) {
		JsonObj result = new JsonObj();
		if (null == editInfo) {
            return result;
        }
		//判断如果是新增
		if (null == editInfo.getPatientExamId()) {
			//封装对象
			PatientExam patientExam = new PatientExam();
			NullBeanUtils.copyProperties(patientExam, editInfo); 
			if (StringUtils.isBlank(editInfo.getPatientExamNum())) {
				String patientExamNum = this.patientExamService.bulidPatientExamNum();
				patientExam.setPatientExamNum(patientExamNum);
				editInfo.setPatientExamNum(patientExamNum);
			}
			patientExam.setExamDate(editInfo.getExamDate());
			patientExam.setDiagnosisFlag(Contstants.DIAGNOSIS_FLAG_NONE);
			patientExam.setHospitalNo(editInfo.getHospitalNo());
			patientExam.setSourceIp(Contstants.NULLABLE_DEFAULT_STRING);
			super.save(patientExam);
			editInfo.setPatientExamId(patientExam.getPatientExamId());
			result.setData(patientExam);
			return result;
		}
		
		PatientExam oldPatientExam = super.load(PatientExam.class, editInfo.getPatientExamId());
		NullBeanUtils.copyProperties(oldPatientExam, editInfo); 
		
		super.save(oldPatientExam);
		editInfo.setPatientExamId(oldPatientExam.getPatientExamId());
		result.setData(oldPatientExam);
		return result;
	}

	/**
	 * 标记为无效状态
	 * @param outpatientInhospitalId
	 * @return
	 */
	public JsonObj markInvalid(Long outpatientInhospitalId) {
		JsonObj result = new JsonObj();
		OutpatientInhospital outpatientInhospital = super.load(OutpatientInhospital.class, outpatientInhospitalId);
		outpatientInhospital.setValidFlag(Contstants.NO_FLAG);
		String inpatientId = "";
		if (null != outpatientInhospital.getInhospitalId()) {
			inpatientId = outpatientInhospital.getInhospitalId() + "";
		} else {
			inpatientId =  outpatientInhospital.getOutpatientId() + "";
		}
		
		PatientExam patientExam = this.patientExamService.findPatientExamByOrgInpatientId(outpatientInhospital.getOrgId(),inpatientId);
		if (null != patientExam) {
			super.delete(patientExam);
		}
		return result;
	}

	

}
