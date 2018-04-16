package com.bofan.publichealth.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.ExamHealthAssessQueryInfo;
import com.bofan.publichealth.command.ExamHealthAssessStrQueryInfo;
import com.bofan.publichealth.command.ExamHealthDangerIdQueryInfo;
import com.bofan.publichealth.command.ExamHealthDangerQueryInfo;
import com.bofan.publichealth.command.ExamHealthGuideIdQueryInfo;
import com.bofan.publichealth.command.ExamHealthGuideQueryInfo;
import com.bofan.publichealth.command.ExamPersonDiseaseIdQueryInfo;
import com.bofan.publichealth.command.ExamPersonDiseaseQueryInfo;
import com.bofan.publichealth.command.ExamPersonEditInfo;
import com.bofan.publichealth.valueobject.ExamHealthAssess;
import com.bofan.publichealth.valueobject.ExamHealthDanger;
import com.bofan.publichealth.valueobject.ExamHealthGuide;
import com.bofan.publichealth.valueobject.ExamHealthProblem;
import com.bofan.publichealth.valueobject.ExamPersonDisease;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * 保存居民健康体检--健康问题相关信息业务类
 * @Description 
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class ExamHealthProblemService extends AbstractAnnoCommonService {
    
    
    /**
     * 保存居民健康体检--健康问题相关信息表
     * @param info
     */
    public void saveExamHealthProblemInfo(ExamPersonEditInfo info) {
        ExamHealthProblem healthProblemInfo = info.getHealthProblem();
        if (null != healthProblemInfo) {
            ExamHealthProblem healthProblem = null;
            if (null != info.getExamPersonId()) {
                healthProblem = this.selectAObject(ExamHealthProblem.class, info.getExamPersonId());
            } 
            if (null == healthProblem) {
                healthProblem = new ExamHealthProblem();
            }
            NullBeanUtils.copyProperties(healthProblem, healthProblemInfo); 
            healthProblem.setExamPersonId(info.getExamPersonId());
            healthProblem.setPersonDetailId(info.getPersonDetailId());
            healthProblem.setExamTime(info.getExamTime());
            
            // 脑血管疾病IDS
            healthProblem.setCvDiseaseFlag(
                    (null != info.getCerebrovascularDiseaseIds() && info.getCerebrovascularDiseaseIds().length > 0)
                            ? Contstants.YES_FLAG : Contstants.NO_FLAG);
            // 肾脏疾病IDS
            healthProblem.setKlDiseaseFlag(
                    (null != info.getKidneyAndLiveDiseaseIds() && info.getKidneyAndLiveDiseaseIds().length > 0)
                            ? Contstants.YES_FLAG : Contstants.NO_FLAG);
            // 心脏疾病IDS
            healthProblem.setHeartFlag((null != info.getHeartDiseaseIds() && info.getHeartDiseaseIds().length > 0)
                    ? Contstants.YES_FLAG : Contstants.NO_FLAG);
            // 血管疾病IDS
            healthProblem.setVascularFlag((null != info.getBloodDiseaseIds() && info.getBloodDiseaseIds().length > 0)
                    ? Contstants.YES_FLAG : Contstants.NO_FLAG);
            // 眼部疾病IDS
            healthProblem.setEyeDiseaseFlag(
                    (null != info.getOcularRegionDiseaseIds() && info.getOcularRegionDiseaseIds().length > 0)
                            ? Contstants.YES_FLAG : Contstants.NO_FLAG);

            super.saveAndRefresh(healthProblem);
        }
        
        List<ExamPersonDisease> diseaseList = this.selectPersonDisease(info.getExamPersonId(), info.getPersonDetailId());
        // 体检健康问题--疾病对照
        this.savePersonDisease(diseaseList, info.getCerebrovascularDiseaseIds(), Contstants.DISEASE_CV_TYPE,
                info.getExamPersonId(), info.getPersonDetailId());
        this.savePersonDisease(diseaseList, info.getKidneyAndLiveDiseaseIds(), Contstants.DISEASE_KL_TYPE,
                info.getExamPersonId(), info.getPersonDetailId());
        this.savePersonDisease(diseaseList, info.getHeartDiseaseIds(), Contstants.DISEASE_HEART_TYPE,
                info.getExamPersonId(), info.getPersonDetailId());
        this.savePersonDisease(diseaseList, info.getBloodDiseaseIds(), Contstants.DISEASE_VASCULAR_TYPE,
                info.getExamPersonId(), info.getPersonDetailId());
        this.savePersonDisease(diseaseList, info.getOcularRegionDiseaseIds(), Contstants.DISEASE_EYE_TYPE,
                info.getExamPersonId(), info.getPersonDetailId());
        
        // 保存有无体检异常
        if (null != healthProblemInfo && Contstants.HAVE_FLAG.equals(healthProblemInfo.getHealthAssessFlag())) {
            this.saveHealthAssess(info.getHealthAbnormalContent(), info.getExamTime(), info.getExamPersonId(), info.getPersonDetailId());
        }
        
        // 保存健康指导类型信息
        this.saveHealthGuide(info.getHealthGuideTypeIds(), info.getExamPersonId(), info.getPersonDetailId());
        
        // 健康危险因素控制对信息
        this.saveHealthDanger(info.getHealthDangerTypeIds(), info.getExamPersonId(), info.getPersonDetailId());
        
    }
    
    
    /**
     * 删除居民健康体检--健康问题相关信息
     * @param info
     */
    public void deleteExamHealthProblemInfo(Long examPersonId, Long personDetailId) {
        // 删除健康问题评价指信息
        ExamHealthProblem healthProblem = this.selectAObject(ExamHealthProblem.class, examPersonId);
        if (null != healthProblem) {
            super.delete(healthProblem);
        }
        
        // 删除疾病信息
        List<ExamPersonDisease> personDiseaseList = this.selectPersonDisease(examPersonId, personDetailId);
        if (Tools.isNotEmptyList(personDiseaseList)) {
            super.deleteAll(personDiseaseList);
        }
        
        // 删除健康异常信息
        List<ExamHealthAssess> healthAssessList = this.selectHealthAssess(examPersonId, personDetailId);
        if (Tools.isNotEmptyList(healthAssessList)) {
            super.deleteAll(healthAssessList);
        }
        
        // 删除健康指导类型信息
        List<ExamHealthGuide> healthGuideList = this.selectHealthGuide(examPersonId, personDetailId);
        if (Tools.isNotEmptyList(healthGuideList)) {
            super.deleteAll(healthGuideList);
        }
        
        // 删除健康危险因素信息
        List<ExamHealthDanger> healthDangerList = this.selectHealthDanger(examPersonId, personDetailId);
        if (Tools.isNotEmptyList(healthDangerList)) {
            super.deleteAll(healthDangerList);
        }
        
    }
    
    /**
     * 获取居民体检健康问题--疾病Ids
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<Long> selectPersonDiseaseIds(Long examPersonId, Long personDetailId) {
        ExamPersonDiseaseIdQueryInfo queryInfo = new ExamPersonDiseaseIdQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(Long.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 获取居民体检健康问题--疾病
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<ExamPersonDisease> selectPersonDisease(Long examPersonId, Long personDetailId) {
        ExamPersonDiseaseQueryInfo queryInfo = new ExamPersonDiseaseQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(ExamPersonDisease.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 获取居民体检健康问题--异常信息内容字符串
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<String> selectHealthAssessContent(Long examPersonId, Long personDetailId) {
        ExamHealthAssessStrQueryInfo queryInfo = new ExamHealthAssessStrQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(String.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 获取居民体检健康问题--异常信息对象列表
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<ExamHealthAssess> selectHealthAssess(Long examPersonId, Long personDetailId) {
        ExamHealthAssessQueryInfo queryInfo = new ExamHealthAssessQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(ExamHealthAssess.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 获取居民体检健康问题--指导类型信息IDS
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<Long> selectHealthGuideIds(Long examPersonId, Long personDetailId) {
        ExamHealthGuideIdQueryInfo queryInfo = new ExamHealthGuideIdQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(Long.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 获取居民体检健康问题--指导类型信息
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<ExamHealthGuide> selectHealthGuide(Long examPersonId, Long personDetailId) {
        ExamHealthGuideQueryInfo queryInfo = new ExamHealthGuideQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(ExamHealthGuide.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 获取居民体检健康问题--危险控制因素信息ids
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<Long> selectHealthDangerIds(Long examPersonId, Long personDetailId) {
        ExamHealthDangerIdQueryInfo queryInfo = new ExamHealthDangerIdQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(Long.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 获取居民体检健康问题--危险控制因素信息
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<ExamHealthDanger> selectHealthDanger(Long examPersonId, Long personDetailId) {
        ExamHealthDangerQueryInfo queryInfo = new ExamHealthDangerQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(ExamHealthDanger.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存的疾病对照信息
     * @param diseaseList
     * @param diseaseIds
     * @param diseaseType
     * @param examPersonId
     * @param personDetailId
     */
    private void savePersonDisease(List<ExamPersonDisease> diseaseList, Long[] diseaseIds, String diseaseType,
            Long examPersonId, Long personDetailId) {
        if (null == diseaseIds) {
            diseaseIds =  new Long[0];
        }
        List<Long> diseaseIdList = new ArrayList<Long>(java.util.Arrays.asList(diseaseIds));
        for (ExamPersonDisease disease : diseaseList) {
            if (!diseaseType.equals(disease.getDiseaseType())) {
                continue;
            }
            if (null == diseaseIds || diseaseIds.length <= 0) {
                super.delete(disease);
                continue;
            }
            if (diseaseIdList.contains(disease.getDiseaseId())) {
                diseaseIdList.remove(disease.getDiseaseId());
            } else {
                super.delete(disease);
            }
        }
        
        ExamPersonDisease personDisease = null;
        for (Long itemId : diseaseIdList) {
            if (null == itemId || itemId.intValue() <= 0) {
                continue;
            }
            personDisease = new ExamPersonDisease();
            personDisease.setDiseaseId(itemId);
            personDisease.setDiseaseType(diseaseType);
            personDisease.setExamPersonId(examPersonId);
            personDisease.setPersonDetailId(personDetailId);
            super.save(personDisease);
        }
    }
    
    /**
     * 保存体检异常对照信息
     * @param diseaseIds
     * @param diseaseType
     * @param examPersonId
     * @param personDetailId
     * @param personDiseaseList
     */
    private void saveHealthAssess(String[] healthAbnormal, Date examTime, Long examPersonId, Long personDetailId) {
        List<ExamHealthAssess> assessList = this.selectHealthAssess(examPersonId, personDetailId);
        if (null == healthAbnormal) {
            super.deleteAll(assessList);
            return ;
        }
        
        int len = (null == assessList ? 0 : assessList.size());
        ExamHealthAssess healthAssess = null;
        for (int i = 0; i < healthAbnormal.length; i++) {
            if (null == healthAbnormal[i] || healthAbnormal[i].length() <= 0) {
                continue ;
            }
            
            if (len > i) {
                healthAssess = assessList.get(i);
                assessList.remove(i);
            }
            if (null == healthAssess) {
                healthAssess = new ExamHealthAssess();
                healthAssess.setExamTime(examTime);
                healthAssess.setExamPersonId(examPersonId);
                healthAssess.setPersonDetailId(personDetailId);
            }
            healthAssess.setHealthAbnormalContent(healthAbnormal[i]);
            super.save(healthAssess);
        }
        super.deleteAll(assessList);
    }
    
    /**
     * 保存健康指导类型对照信息
     * @param diseaseIds
     * @param diseaseType
     * @param examPersonId
     * @param personDetailId
     * @param personDiseaseList
     */
    private void saveHealthGuide(Long[] healthGuideTypeIds, Long examPersonId, Long personDetailId) {
        List<ExamHealthGuide> guideList = this.selectHealthGuide(examPersonId, personDetailId);
        if (null == healthGuideTypeIds || healthGuideTypeIds.length <= 0) {
            // 当页面传回的健康指导类型ids为空， 表示页面没有勾选，因此要删除之前保存过得 数据据
            super.deleteAll(guideList);
            return ;
        }
        
        List<Long> guideIdList = new ArrayList<Long>(java.util.Arrays.asList(healthGuideTypeIds));
        for (ExamHealthGuide guide : guideList) {
            if (guideIdList.contains(guide.getHealthGuideTypeId())) {
                guideIdList.remove(guide.getHealthGuideTypeId());
            } else {
                super.delete(guide);
            }
        }
        
        ExamHealthGuide healthGuide = null;
        for (Long itemId : guideIdList) {
            if (null == itemId || itemId.intValue() <= 0) {
                continue ;
            }
            healthGuide = new ExamHealthGuide();
            healthGuide.setHealthGuideTypeId(itemId);
            healthGuide.setExamPersonId(examPersonId);
            healthGuide.setPersonDetailId(personDetailId);
            super.save(healthGuide);
        }
    }

    
    /**
     * 健康危险因素控制对照信息
     * @param diseaseIds
     * @param diseaseType
     * @param examPersonId
     * @param personDetailId
     * @param personDiseaseList
     */
    private void saveHealthDanger(Long[] healthDangerTypeIds, Long examPersonId, Long personDetailId) {
        List<ExamHealthDanger> dangerList = this.selectHealthDanger(examPersonId, personDetailId);
        if (null == healthDangerTypeIds || healthDangerTypeIds.length <= 0) {
            // 当页面传回的健康指导类型ids为空， 表示页面没有勾选，因此要删除之前保存过得 数据据
            super.deleteAll(dangerList);
            return ;
        }
        
        List<Long> dangerTypeIdList = new ArrayList<Long>(java.util.Arrays.asList(healthDangerTypeIds));
        for (ExamHealthDanger danger : dangerList) {
            if (dangerTypeIdList.contains(danger.getHealthDangerTypeId())) {
                dangerTypeIdList.remove(danger.getHealthDangerTypeId());
            } else {
                super.delete(danger);
            }
        }
        
        ExamHealthDanger healthDanger = null;
        for (Long itemId : dangerTypeIdList) {
            if (null == itemId || itemId.intValue() <= 0) {
                continue ;
            }
            healthDanger = new ExamHealthDanger();
            healthDanger.setHealthDangerTypeId(itemId);
            healthDanger.setExamPersonId(examPersonId);
            healthDanger.setPersonDetailId(personDetailId);
            super.save(healthDanger);
        }
    }
}
