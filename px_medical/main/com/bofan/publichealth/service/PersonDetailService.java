package com.bofan.publichealth.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.command.PersonDetailEditInfo;
import com.bofan.publichealth.command.PersonDetailQueryInfo;
import com.bofan.publichealth.command.PersonDisabilityQueryInfo;
import com.bofan.publichealth.command.PersonDrugAllergyEditInfo;
import com.bofan.publichealth.command.PersonDrugAllergyQueryInfo;
import com.bofan.publichealth.command.PersonExposeEditInfo;
import com.bofan.publichealth.command.PersonExposeQueryInfo;
import com.bofan.publichealth.command.PersonFamilyDiseaseEditInfo;
import com.bofan.publichealth.command.PersonFamilyDiseaseQueryInfo;
import com.bofan.publichealth.command.PersonPastDiseaseEditInfo;
import com.bofan.publichealth.command.PersonPastDiseaseQueryInfo;
import com.bofan.publichealth.command.PersonSurgeryEditInfo;
import com.bofan.publichealth.command.PersonSurgeryQueryInfo;
import com.bofan.publichealth.valueobject.PersonDetail;
import com.bofan.publichealth.valueobject.PersonDisability;
import com.bofan.publichealth.valueobject.PersonDrugAllergy;
import com.bofan.publichealth.valueobject.PersonExpose;
import com.bofan.publichealth.valueobject.PersonFamilyDisease;
import com.bofan.publichealth.valueobject.PersonPastDisease;
import com.bofan.publichealth.valueobject.PersonSurgery;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;

/**
 * @Description: 个人基本档案业务
 * @author lqw
 */
@Service
@Transactional
public class PersonDetailService extends AbstractAnnoCommonService {
 
	/**
	 * 根据条件查询个人基本档案分页记录
	 * 
	 * @param info
	 * @return
	 */
	public Page selectPersonDetailList(PersonDetailQueryInfo info) { 
		IQueryObject qo = super.getQueryObject(info);
		return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
	}
	
	/**
	 * 根据家庭基本档案ID 查询 家庭基本档案 列表
	 * @param personDetailId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PersonDetail> selectPersonDetailList(Long familyDetailId) {
		if (null == familyDetailId) {
			return null;
		}
		PersonDetailQueryInfo queryInfo = new PersonDetailQueryInfo();
		queryInfo.setFamilyDetailId(familyDetailId);
		queryInfo.setValidFlag(Contstants.YES_FLAG);
		IQueryObject qo = super.getQueryObject(queryInfo);
		return super.executeSql(qo.getQueryString(), qo.getParam());
	}
	
	/**
	 * 根据条件查询单个个人信息
	 * @param info
	 * @return
	 */
    @SuppressWarnings("unchecked")
    public PersonDetail findPersonDetail(PersonDetailQueryInfo info) {
        IQueryObject qo = super.getQueryObject(info);
        List<PersonDetail> list = super.executeSql(qo.getQueryString(), qo.getParam());
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
	
	/** 
	 * 保存个人基本档案,包括关联的附属信息
	 * [个人基本档案、个人家庭关系信息、既往史信息]
	 */
	@SuppressWarnings("unchecked")
	public PersonDetail savePersonDetail(String personDetailRetionData,SysUserInfo userInfo) {
		JSONObject data = JSONObject.parseObject(personDetailRetionData);
		String personDetailEditInfoStr = data.getString("personDetailEditInfo");
		String pastDiseaseEditInfoListStr = data.getString("pastDiseaseEditInfoList");
		String exposeDiseaseEditInfoListStr = data.getString("exposeDiseaseEditInfoList");
		String drugAllergyEditInfoListStr = data.getString("drugAllergyEditInfoList");
		String personDisabilityListStr = data.getString("personDisabilityList");
		String personSurgeryListStr = data.getString("personSurgeryList");
		String familyDiseaseListStr = data.getString("familyDiseaseList");
		 
		PersonDetailEditInfo personDetailEditInfo = JSON.parseObject(personDetailEditInfoStr, PersonDetailEditInfo.class);
		List<JSONObject> pastDiseaseEditInfoList = JSON.parseObject(pastDiseaseEditInfoListStr, List.class);
		List<JSONObject> exposeDiseaseEditInfoList = JSON.parseObject(exposeDiseaseEditInfoListStr, List.class);
		List<JSONObject> drugAllergyEditInfoList = JSON.parseObject(drugAllergyEditInfoListStr, List.class);
		List<JSONObject> personSurgeryEditInfoList = JSON.parseObject(personSurgeryListStr, List.class);
		List<JSONObject> familyDiseaseEditInfoList = JSON.parseObject(familyDiseaseListStr, List.class);
		List<Integer> personDisabilityEditInfoList = JSON.parseObject(personDisabilityListStr, List.class);
		
		PersonDetail personDetail = null;
		if (null != personDetailEditInfo.getPersonDetailId()) {
			personDetail = super.selectAObject(PersonDetail.class,personDetailEditInfo.getPersonDetailId());
			NullBeanUtils.copyProperties(personDetail, personDetailEditInfo);
		} else {
			personDetail = new PersonDetail();
			NullBeanUtils.copyProperties(personDetail, personDetailEditInfo);
			personDetail.setCreateTime(new Date());
			personDetail.setValidFlag(Contstants.YES_FLAG);
			//临时使用
			personDetail.setArchivePersonalNum(Tools.getLenNextId(new Random().nextInt(10000)+"", 18, "0"));
		}
		super.save(personDetail);
		//保存既往史列表
		saveOrUpdatePersonPastDiseaseList(pastDiseaseEditInfoList,personDetail.getPersonDetailId(),userInfo);
		//保存暴露史列表
		saveOrUpdatePersonExposeDiseaseList(exposeDiseaseEditInfoList,personDetail.getPersonDetailId(),userInfo);
		//保存过敏史列表
		saveOrUpdatePersonDrugAllergyList(drugAllergyEditInfoList,personDetail.getPersonDetailId(),userInfo);
		//保存或更新残疾
		saveOrUpdatePersonDisability(personDisabilityEditInfoList,personDetail.getPersonDetailId(),userInfo);
		//保存或更新既往手术、外伤、输血史
		saveOrUpdatePersonSurgery(personSurgeryEditInfoList,personDetail.getPersonDetailId(),userInfo);
		//保存或更新家族史
		saveOrUpdatePersonFamilyDiseaseList(familyDiseaseEditInfoList,personDetail.getPersonDetailId(),userInfo);
		return personDetail;
	}

	/**
	 * 查询个人既往史列表
	 * @param personDetailId
	 * @return
	 */
	public List<PersonPastDisease> selectPersonPastDiseaseList(Long personDetailId) {
		if (null == personDetailId) {
			return null;
		}
		PersonPastDiseaseQueryInfo info = new PersonPastDiseaseQueryInfo();
		info.setPersonDetailId(personDetailId);
		return this.selectPersonPastDiseaseList(info);
	}
 
	/**
	 * 查询个人既往史列表
	 * @param info
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PersonPastDisease> selectPersonPastDiseaseList(PersonPastDiseaseQueryInfo info) {
		if (null == info) {
			info = new PersonPastDiseaseQueryInfo();
		}
		IQueryObject qo = super.getQueryObject(info);
		return super.executeSql(qo.getQueryString(), qo.getParam());
	}
 
	/**
	 * 保存个人既往史列表
	 * @param pastDiseaseEditInfoList
	 */
	@SuppressWarnings("rawtypes")
	private void saveOrUpdatePersonPastDiseaseList( List<JSONObject> pastDiseaseEditInfoList,Long personDetailId,SysUserInfo userInfo) {
		Iterator<PersonPastDisease> personPastDisIt = this.selectPersonPastDiseaseList(personDetailId).iterator();
		if (!Tools.isNotEmptyList(pastDiseaseEditInfoList)) {
			 // 如果页面传参不存在既往史，则删除已有的数据
	        while ( personPastDisIt.hasNext()) {
	        	PersonPastDisease personPastDisease = (PersonPastDisease) personPastDisIt.next();
	        	super.getCommonDao().delete(personPastDisease); 
	        }
		} else {
			 // 如果页面传参存在关联关系，则更新关联关系 
			Map<Long,PersonPastDisease> personPastDiseaseMap = new HashMap<Long,PersonPastDisease>();
			List<PersonPastDisease> newPastDeseaseList = new ArrayList<PersonPastDisease>();
	        while (personPastDisIt.hasNext()) { 
	        	PersonPastDisease personPastDisItem = (PersonPastDisease) personPastDisIt.next();
	            personPastDiseaseMap.put(personPastDisItem.getPastDiseaseId(), personPastDisItem);
	        }
	        for (JSONObject pastDiseaseEditInfoJson : pastDiseaseEditInfoList) {
	        	PersonPastDiseaseEditInfo editInfo = JSON.parseObject(pastDiseaseEditInfoJson.toJSONString(), PersonPastDiseaseEditInfo.class);
	        	if (personPastDiseaseMap.containsKey(editInfo.getPastDiseaseId())) {
	        		//包含则更新内容
	        		PersonPastDisease oldPersonPastDisease = personPastDiseaseMap.get(editInfo.getPastDiseaseId());
	        		
	        		oldPersonPastDisease.setDiseaseContent(editInfo.getDiseaseContent());
	        		oldPersonPastDisease.setDiseaseId(editInfo.getDiseaseId());
	        		oldPersonPastDisease.setDiseaseName(editInfo.getDiseaseName());
	        		oldPersonPastDisease.setDiseaseTime(editInfo.getDiseaseTime());
	        		oldPersonPastDisease.setFamilyDiseaseFlag(editInfo.getFamilyDiseaseFlag());
		    		personPastDiseaseMap.remove(editInfo.getPastDiseaseId());
				} else {
					//不包含则需要新增
					PersonPastDisease newPersonPastDisease = new PersonPastDisease();
					NullBeanUtils.copyProperties(newPersonPastDisease, editInfo);
					newPersonPastDisease.setPersonDetailId(personDetailId);
					newPersonPastDisease.setCreatorId(userInfo.getUserInfoId());
					newPersonPastDisease.setCreateTime(new Date());
					newPastDeseaseList.add(newPersonPastDisease);
				}
			}
	 
	        //删除页面已删除的既往史
		    if (Tools.isNotEmptyMap(personPastDiseaseMap)) {
	            Iterator it = personPastDiseaseMap.entrySet().iterator();
	            while (it.hasNext()) {
	                super.delete((PersonPastDisease) ((Map.Entry) it.next()).getValue());
	            }
	        }
		    //避免删除前新增，导致唯一索引约束报错，所以在删除后新增
		    for (PersonPastDisease personPastDisease : newPastDeseaseList) {
		    	super.save(personPastDisease);
			}
		}
		
	}
	
	/**
	 * 保存或更新个人暴露史
	 * @param exposeDiseaseEditInfoList
	 */
	@SuppressWarnings("rawtypes") 
	private void saveOrUpdatePersonExposeDiseaseList( List<JSONObject> exposeDiseaseEditInfoList,Long personDetailId,SysUserInfo userInfo) {
		Iterator<PersonExpose> personExposeDisIt = this.selectPersonExposeDiseaseList(personDetailId).iterator();
		if (!Tools.isNotEmptyList(exposeDiseaseEditInfoList)) { 
			// 如果页面传参不存在既往史，则删除已有的数据
			while ( personExposeDisIt.hasNext()) {
				PersonExpose PersonExposeDisease = (PersonExpose) personExposeDisIt.next();
				super.delete(PersonExposeDisease); 
			}
		} else {
			// 如果页面传参存在关联关系，则更新关联关系 
			Map<Long,PersonExpose> personExposeDiseaseMap = new HashMap<Long,PersonExpose>();
			
			while (personExposeDisIt.hasNext()) {  
				PersonExpose personExposeDisItem = (PersonExpose) personExposeDisIt.next();
				personExposeDiseaseMap.put(personExposeDisItem.getExposeId(), personExposeDisItem);
			}
			for (JSONObject exposeDiseaseEditInfoJson : exposeDiseaseEditInfoList) {
				PersonExposeEditInfo editInfo = JSON.parseObject(exposeDiseaseEditInfoJson.toJSONString(), PersonExposeEditInfo.class);
				if (personExposeDiseaseMap.containsKey(editInfo.getExposeId())) {
					personExposeDiseaseMap.remove(editInfo.getExposeId());
				} else {
					//不包含则需要新增
					PersonExpose newPersonExposeDisease = new PersonExpose();
					NullBeanUtils.copyProperties(newPersonExposeDisease, editInfo);
					newPersonExposeDisease.setPersonDetailId(personDetailId);
					newPersonExposeDisease.setCreatorId(userInfo.getUserInfoId());
					newPersonExposeDisease.setCreateTime(new Date());
					super.save(newPersonExposeDisease);
				}
			}
			
			//删除页面已删除的既往史
			if (Tools.isNotEmptyMap(personExposeDiseaseMap)) {
				Iterator it = personExposeDiseaseMap.entrySet().iterator();
				while (it.hasNext()) {
					super.delete((PersonExpose) ((Map.Entry) it.next()).getValue());
				}
			}
		}
	}

	/**
	 * 根据个人信息id查询 暴露史列表
	 * @param personDetailId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PersonExpose> selectPersonExposeDiseaseList(Long personDetailId) {
		if (null == personDetailId) {
			return null;
		}
		IQueryObject qo = super.getQueryObject(new PersonExposeQueryInfo(personDetailId));
		return super.executeSql(qo.getQueryString(), qo.getParam());
	}
	
	public List<Long> selectPersonExposeIdsList(Long personDetailId) {
		List<PersonExpose> personExposeList = selectPersonExposeDiseaseList(personDetailId);
		List<Long> personExposeIdList = new ArrayList<Long>();
		if (null != personExposeList && personExposeList.size() > 0) {
			for (PersonExpose personExpose : personExposeList) {
				personExposeIdList.add(personExpose.getExposeId());
			}
		}
		return personExposeIdList;
	}
	
	/**
	 * 添加或者保存个人药物过敏史
	 * @param drugAllergyEditInfoList
	 * @param personDetailId
	 * @param userInfo
	 */
	@SuppressWarnings("rawtypes")
	private void saveOrUpdatePersonDrugAllergyList(List<JSONObject> drugAllergyEditInfoList, Long personDetailId, SysUserInfo userInfo) {
		Iterator<PersonDrugAllergy> personDrugAllergyIt = this.selectPersonDrugAllergyList(personDetailId).iterator();
		if (!Tools.isNotEmptyList(drugAllergyEditInfoList)) { 
			// 如果页面传参不存在既往史，则删除已有的数据
			while ( personDrugAllergyIt.hasNext()) {
				PersonDrugAllergy personDrugAllergy = (PersonDrugAllergy) personDrugAllergyIt.next();
				super.delete(personDrugAllergy); 
			}
		} else {
			// 如果页面传参存在关联关系，则更新关联关系 
			Map<Long,PersonDrugAllergy> personDrugAllergyMap = new HashMap<Long,PersonDrugAllergy>();
			
			while (personDrugAllergyIt.hasNext()) {  
				PersonDrugAllergy personDrugAllergyItem = (PersonDrugAllergy) personDrugAllergyIt.next();
				personDrugAllergyMap.put(personDrugAllergyItem.getDrugAllergyId(), personDrugAllergyItem);
			}
			for (JSONObject exposeDiseaseEditInfoJson : drugAllergyEditInfoList) {
				PersonDrugAllergyEditInfo editInfo = JSON.parseObject(exposeDiseaseEditInfoJson.toJSONString(), PersonDrugAllergyEditInfo.class);
				if (personDrugAllergyMap.containsKey(editInfo.getDrugAllergyId())) {
					//包含则更新内容
					PersonDrugAllergy oldPersonDrugAllergy = personDrugAllergyMap.get(editInfo.getDrugAllergyId());
					oldPersonDrugAllergy.setDrugAllergyOther(editInfo.getDrugAllergyOther());
					super.save(oldPersonDrugAllergy);
					personDrugAllergyMap.remove(editInfo.getDrugAllergyId());
				} else {
					//不包含则需要新增
					PersonDrugAllergy newPersonDrugAllergy = new PersonDrugAllergy();
					NullBeanUtils.copyProperties(newPersonDrugAllergy, editInfo);
					newPersonDrugAllergy.setPersonDetailId(personDetailId);
					newPersonDrugAllergy.setCreatorId(userInfo.getUserInfoId());
					newPersonDrugAllergy.setCreateTime(new Date());
					super.save(newPersonDrugAllergy);
				}
			}
			
			//删除页面已删除的既往史
			if (Tools.isNotEmptyMap(personDrugAllergyMap)) {
				Iterator it = personDrugAllergyMap.entrySet().iterator();
				while (it.hasNext()) {
					super.delete((PersonDrugAllergy) ((Map.Entry) it.next()).getValue());
				}
			}
			 
		}
		
	}

	/**
	 * 根据个人信息id查询 药物过敏史列表
	 * @param personDetailId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PersonDrugAllergy> selectPersonDrugAllergyList(Long personDetailId) {
		if (null == personDetailId) {
			return null;
		}
		IQueryObject qo = super.getQueryObject(new PersonDrugAllergyQueryInfo(personDetailId));
		return super.executeSql(qo.getQueryString(), qo.getParam());
	}
	
	/**
	 * 保存或更新残疾情况
	 * @param diseaseEditInfoList
	 * @param personDetailId
	 * @param userInfo
	 */
	@SuppressWarnings("rawtypes")
	private void saveOrUpdatePersonDisability(List<Integer> diseaseEditInfoList, Long personDetailId, SysUserInfo userInfo) { 
		Iterator<PersonDisability> personDisabilityIt = this.selectPersonDisabilityList(personDetailId).iterator();
		if (!Tools.isNotEmptyList(diseaseEditInfoList)) {
			 // 如果页面传参不存在关联关系，则删除关联 
	        while (personDisabilityIt.hasNext()) {
	        	PersonDisability ersonDisabilityItem = (PersonDisability) personDisabilityIt.next();
	        	super.delete(ersonDisabilityItem);  
	        }
	        return ;
		} 
		
		 // 如果页面传参存在关联关系，则更新关联关系 
		Map<Long,PersonDisability> personDisabilityMap = new HashMap<Long,PersonDisability>();
        while (personDisabilityIt.hasNext()) { 
        	PersonDisability personDisabilityItem = (PersonDisability) personDisabilityIt.next();
            personDisabilityMap.put(personDisabilityItem.getDisabilityId(), personDisabilityItem);
        }
        for (Integer disabilityId : diseaseEditInfoList) {
        	if (personDisabilityMap.containsKey(disabilityId.longValue())) {
	    		personDisabilityMap.remove(disabilityId.longValue());
			} else {
				//不包含则需要新增
				PersonDisability personDisability = new PersonDisability();
				personDisability.setDisabilityId(disabilityId.longValue());
				personDisability.setPersonDetailId(personDetailId);
				personDisability.setCreatorId(userInfo.getUserInfoId());
				personDisability.setCreatorName(userInfo.getName());
				personDisability.setCreateTime(new Date());
				super.save(personDisability);
			}
		}
	    if (!personDisabilityMap.isEmpty()) {
            Iterator it = personDisabilityMap.entrySet().iterator();
            while (it.hasNext()) {
                super.delete((PersonDisability) ((Map.Entry) it.next()).getValue());
            }
        }
         
	}
	
	/**
	 * 保存或更新既往手术、外伤、输血史
	 * @param personSurgeryList
	 * @param personDetailId
	 * @param userInfo
	 */
	@SuppressWarnings("rawtypes")
	private void saveOrUpdatePersonSurgery(List<JSONObject> personSurgeryList, Long personDetailId, SysUserInfo userInfo) {
		Iterator<PersonSurgery> personSurgeryIt = this.selectPersonSurgeryList(personDetailId).iterator();
		if (!Tools.isNotEmptyList(personSurgeryList)) { 
			// 如果页面传参不存在既往史，则删除已有的数据 
			while ( personSurgeryIt.hasNext()) {
				PersonSurgery personSurgery = (PersonSurgery) personSurgeryIt.next();
				super.delete(personSurgery); 
			}
		} else {
			// 如果页面传参存在关联关系，则更新关联关系 
			Map<Long,PersonSurgery> personSurgeryMap = new HashMap<Long,PersonSurgery>();
			
			while (personSurgeryIt.hasNext()) {   
				PersonSurgery personSurgeryItem = (PersonSurgery) personSurgeryIt.next();
				personSurgeryMap.put(personSurgeryItem.getSurgeryId(), personSurgeryItem);
			}
			for (JSONObject exposeDiseaseEditInfoJson : personSurgeryList) {
				PersonSurgeryEditInfo editInfo = JSON.parseObject(exposeDiseaseEditInfoJson.toJSONString(), PersonSurgeryEditInfo.class);
				if (personSurgeryMap.containsKey(editInfo.getSurgeryId())) {
					//包含则更新内容
					PersonSurgery oldPersonDrugAllergy = personSurgeryMap.get(editInfo.getSurgeryId());
					
					if (!Tools.isEmptyString(editInfo.getSurgeryName())) {
						oldPersonDrugAllergy.setSurgeryName(editInfo.getSurgeryName());
						oldPersonDrugAllergy.setSurgeryTime(editInfo.getSurgeryTime());
					}else if (!Tools.isEmptyString(editInfo.getTraumaName())){
						oldPersonDrugAllergy.setTraumaName(editInfo.getTraumaName());
						oldPersonDrugAllergy.setTraumaTime(editInfo.getTraumaTime());
					} else {
						oldPersonDrugAllergy.setBloodTransReason(editInfo.getBloodTransReason());
						oldPersonDrugAllergy.setBloodTransTime(editInfo.getBloodTransTime());
					}
					personSurgeryMap.remove(editInfo.getSurgeryId());
				} else {
					//不包含则需要新增
					PersonSurgery newPersonDrugAllergy = new PersonSurgery();
					NullBeanUtils.copyProperties(newPersonDrugAllergy, editInfo);
					newPersonDrugAllergy.setPersonDetailId(personDetailId);
					newPersonDrugAllergy.setCreatorId(userInfo.getUserInfoId());
					//newPersonDrugAllergy.setCreatorName(userInfo.getName());
					newPersonDrugAllergy.setCreateTime(new Date());
					super.save(newPersonDrugAllergy);
				}
			}
			
			//删除页面已删除的既往史
			if (Tools.isNotEmptyMap(personSurgeryMap)) {
				Iterator it = personSurgeryMap.entrySet().iterator();
				while (it.hasNext()) {
					super.delete((PersonSurgery) ((Map.Entry) it.next()).getValue());
				}
			}
			 
		}
		
	}

	/**
	 * 根据个人信息id查询 残疾列表
	 * @param personDetailId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PersonDisability> selectPersonDisabilityList(Long personDetailId) {
		if (null == personDetailId) {
			return null;
		}
		IQueryObject qo = super.getQueryObject(new PersonDisabilityQueryInfo(personDetailId));
		return super.executeSql(qo.getQueryString(), qo.getParam());
	}
	
	/***
	 * 根据个人信息id查询 残疾记录的 id 列表
	 * @param personDetailId
	 * @return
	 */
	public List<Long> selectPersonDisabilityIdsList(Long personDetailId) {
		List<PersonDisability> personDisabilityList = selectPersonDisabilityList(personDetailId);
		List<Long> personDisabilityIdList = new ArrayList<Long>();
		if (null != personDisabilityList && personDisabilityList.size() > 0) {
			for (PersonDisability personDisability : personDisabilityList) {
				personDisabilityIdList.add(personDisability.getDisabilityId());
			}
		}
		return personDisabilityIdList;
	}

	/**
	 * 根据个人信息id查询  个人既往手术、外伤、输血史列表
	 * @param personDetailId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PersonSurgery> selectPersonSurgeryList(Long personDetailId) {
		if (null == personDetailId) {
			return null;
		}
		IQueryObject qo = super.getQueryObject(new PersonSurgeryQueryInfo(personDetailId));
		return super.executeSql(qo.getQueryString(), qo.getParam());
	}
	
	/**
	 * 保存或更新家族史
	 * @param familyDiseaseEditInfoList
	 * @param personDetailId
	 * @param userInfo
	 */
	@SuppressWarnings("rawtypes")
	private void saveOrUpdatePersonFamilyDiseaseList(List<JSONObject> familyDiseaseEditInfoList, Long personDetailId, SysUserInfo userInfo) {
		Iterator<PersonFamilyDisease> familyDiseaseDisIt = this.selectPersonFamilyDiseaseList(personDetailId).iterator();
		if (!Tools.isNotEmptyList(familyDiseaseEditInfoList)) { 
			// 如果页面传参不存在既往史，则删除已有的数据
			while ( familyDiseaseDisIt.hasNext()) {
				PersonFamilyDisease personFamilyDiseaseItem = (PersonFamilyDisease) familyDiseaseDisIt.next();
				super.delete(personFamilyDiseaseItem); 
			}
		} else { 
			// 如果页面传参存在关联关系，则更新关联关系  
			Map<Long,PersonFamilyDisease> personFamilyDiseaseMap = new HashMap<Long,PersonFamilyDisease>();
			
			while (familyDiseaseDisIt.hasNext()) {  
				PersonFamilyDisease personFamilyDiseaseItem = (PersonFamilyDisease) familyDiseaseDisIt.next();
				personFamilyDiseaseMap.put(personFamilyDiseaseItem.getFamilyDiseaseId(), personFamilyDiseaseItem);
			} 
			for (JSONObject familyDiseaseEditInfoJson : familyDiseaseEditInfoList) {
				PersonFamilyDiseaseEditInfo editInfo = JSON.parseObject(familyDiseaseEditInfoJson.toJSONString(), PersonFamilyDiseaseEditInfo.class);
				if (personFamilyDiseaseMap.containsKey(editInfo.getFamilyDiseaseId())) {
					//包含则更新内容
					PersonFamilyDisease oldPersonFamilyDisease = personFamilyDiseaseMap.get(editInfo.getFamilyDiseaseId());
					oldPersonFamilyDisease.setDiseaseId(editInfo.getDiseaseId());
					oldPersonFamilyDisease.setDiseaseName(editInfo.getDiseaseName());
					oldPersonFamilyDisease.setFamilyMemberFlag(editInfo.getFamilyMemberFlag());
					oldPersonFamilyDisease.setFamilyMember(editInfo.getFamilyMember());
					personFamilyDiseaseMap.remove(editInfo.getFamilyDiseaseId());
				} else {
					//不包含则需要新增
					PersonFamilyDisease newPersonFamilyDisease = new PersonFamilyDisease();
					NullBeanUtils.copyProperties(newPersonFamilyDisease, editInfo);
					newPersonFamilyDisease.setPersonDetailId(personDetailId);
					newPersonFamilyDisease.setCreatorId(userInfo.getUserInfoId());
					newPersonFamilyDisease.setCreateTime(new Date());
					super.save(newPersonFamilyDisease);
				}
			}
			
			//删除页面已删除的既往史
			if (Tools.isNotEmptyMap(personFamilyDiseaseMap)) {
				Iterator it = personFamilyDiseaseMap.entrySet().iterator();
				while (it.hasNext()) {
					super.delete((PersonFamilyDisease) ((Map.Entry) it.next()).getValue());
				}
			}
			 
		}
		
	}
	
	/**
	 * 根据个人信息id查询 个人家族疾病史列表
	 * @param personDetailId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PersonFamilyDisease> selectPersonFamilyDiseaseList(Long personDetailId) {
		if (null == personDetailId) {
			return null;
		}
		IQueryObject qo = super.getQueryObject(new PersonFamilyDiseaseQueryInfo(personDetailId));
		return super.executeSql(qo.getQueryString(), qo.getParam());
	}

	/**
	 * 居民家庭 变动更新
	 * @param editInfo
	 * @return
	 */
	public JsonObj changPersonFamily(PersonDetailEditInfo editInfo) {
		JsonObj result = new JsonObj(); 
		if (null == editInfo.getPersonDetailId() ) {
			result.setResult(ResponseContstants.RESULT_FAIL_CODE, "数据不存在");
		}
		PersonDetail personDetail = super.selectAObject(PersonDetail.class,editInfo.getPersonDetailId());
		personDetail.setFamilyDetailId(editInfo.getFamilyDetailId());
		personDetail.setFamilyRelId(editInfo.getFamilyRelId());
		super.save(personDetail);
		return result;
	}

}
