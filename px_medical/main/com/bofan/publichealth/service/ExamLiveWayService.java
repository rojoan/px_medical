package com.bofan.publichealth.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.command.ExamPersonEditInfo;
import com.bofan.publichealth.command.LiveWayDietaryIdQueryInfo;
import com.bofan.publichealth.command.LiveWayDietaryQueryInfo;
import com.bofan.publichealth.command.LiveWayDrinkIdQueryInfo;
import com.bofan.publichealth.command.LiveWayDrinkQueryInfo;
import com.bofan.publichealth.valueobject.ExamElder;
import com.bofan.publichealth.valueobject.ExamLiveWay;
import com.bofan.publichealth.valueobject.LiveWayDietary;
import com.bofan.publichealth.valueobject.LiveWayDrink;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * @Description 居民健康体检--生活方式业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class ExamLiveWayService extends AbstractAnnoCommonService {
    
    /**
     * 获取居民健康体检--生活方式信息
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public ExamLiveWay selectExamLiveWay(Long examPersonId) {
        return super.selectAObject(ExamLiveWay.class, examPersonId);
    }
    
    /**
     * 居民健康体检--生活方式
     * @param info
     */
    public void saveExamLiveWay(ExamPersonEditInfo info) {
        if (null != info.getExamElder()) {
            this.saveExamElder(info.getExamElder(), info.getCurrentUser(), info.getPersonDetailId(), info.getExamPersonId(), info.getExamTime());
        }
        
        if (null != info.getExamLiveWay()) {
            ExamLiveWay examLiveWay = super.selectAObject(ExamLiveWay.class, info.getExamPersonId());
            if (null == examLiveWay) {
                examLiveWay = new ExamLiveWay();
            }
            NullBeanUtils.copyProperties(examLiveWay, info.getExamLiveWay());
            examLiveWay.setExamTime(info.getExamTime());
            examLiveWay.setExamPersonId(info.getExamPersonId());
            examLiveWay.setPersonDetailId(info.getPersonDetailId());
            super.save(examLiveWay);
        }
        
        this.saveLiveWayDietary(info.getDietaryHabitIds(), info.getPersonDetailId(), info.getExamPersonId(), info.getExamTime());
        this.saveLiveWayDrink(info.getDrinkTypeIds(), info.getPersonDetailId(), info.getExamPersonId(), info.getExamTime());
    }
    
    /**
     * 居民健康体检--生活方式
     * @param examPersonId
     * @param personDetailId
     */
    public void deleteExamLiveWay(Long examPersonId, Long personDetailId) {
        // 删除生活方式信息
        ExamLiveWay examLiveWay = super.selectAObject(ExamLiveWay.class, examPersonId);
        if (null != examLiveWay) {
            super.delete(examLiveWay);
        }
        
        //删除老年人信息
        ExamElder examElder = this.selectAObject(ExamElder.class, examPersonId);
        if (null != examElder) {
            super.delete(examElder);
        }
        
        //删除饮食习惯信息
        List<LiveWayDietary> dietaryList = this.selectLiveWayDietary(examPersonId, personDetailId);
        if (Tools.isNotEmptyList(dietaryList)) {
            super.deleteAll(dietaryList);
        }
        
        //删除饮酒信息
        List<LiveWayDrink> drinkList = this.selectLiveWayDrink(examPersonId, personDetailId);
        if (Tools.isNotEmptyList(drinkList)) {
            super.deleteAll(drinkList);
        }
    }
    
    /**
     * 居民生活方式--饮食习惯ID
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<Long> selectLiveWayDietaryIds(Long examPersonId, Long personDetailId) {
        LiveWayDietaryIdQueryInfo queryInfo = new LiveWayDietaryIdQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(Long.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 居民生活方式--饮食习惯
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<LiveWayDietary> selectLiveWayDietary(Long examPersonId, Long personDetailId) {
        LiveWayDietaryQueryInfo queryInfo = new LiveWayDietaryQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(LiveWayDietary.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 居民生活方式--饮酒习惯ID
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<Long> selectLiveWayDrinkIds(Long examPersonId, Long personDetailId) {
        LiveWayDrinkIdQueryInfo queryInfo = new LiveWayDrinkIdQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(Long.class, qo.getQueryString(), qo.getParam());

    }
    
    /**
     * 居民生活方式--饮酒习惯
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<LiveWayDrink> selectLiveWayDrink(Long examPersonId, Long personDetailId) {
        LiveWayDrinkQueryInfo queryInfo = new LiveWayDrinkQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(LiveWayDrink.class, qo.getQueryString(), qo.getParam());

    }
    
    /**
     * 居民生活方式--饮酒种类
     * @param drinkTypeIds
     * @param personDetailId
     * @param examPersonId
     * @param examTime
     */
    private void saveLiveWayDrink(Long[] drinkTypeIds, Long personDetailId, Long examPersonId, Date examTime) {
        List<LiveWayDrink> drinkList = this.selectLiveWayDrink(examPersonId, personDetailId);
        if (null == drinkTypeIds || drinkTypeIds.length <= 0) {
            // 当页面传回的饮酒种类ids（symptomIds）为空， 表示页面没有勾选，因此要删除之前保存过得 数据据
            super.deleteAll(drinkList);
            return ;
        }
        
        List<Long> drinkIdList = new ArrayList<Long>(java.util.Arrays.asList(drinkTypeIds));
        for (LiveWayDrink drink : drinkList) {
            if (drinkIdList.contains(drink.getDrinkTypeId())) {
                drinkIdList.remove(drink.getDrinkTypeId());
            } else {
                super.delete(drink);
            }
        }
        
        LiveWayDrink liveWayDrink = null;
        for (Long itemId : drinkIdList) {
            if (null == itemId || itemId.intValue() <= 0) {
                continue ;
            }
            liveWayDrink = new LiveWayDrink();
            liveWayDrink.setDrinkTypeId(itemId);
            liveWayDrink.setExamPersonId(examPersonId);
            liveWayDrink.setPersonDetailId(personDetailId);
            super.save(liveWayDrink);
        }
    }
    
    /**
     * 居民生活方式--饮食习惯
     * @param json
     */
    private void saveLiveWayDietary(Long[] dietaryHabitIds, Long personDetailId, Long examPersonId, Date examTime) {
        List<LiveWayDietary> dietaryList = this.selectLiveWayDietary(examPersonId, personDetailId);
        if (null == dietaryHabitIds || dietaryHabitIds.length <= 0) {
            // 当页面传回的饮食习惯ids（symptomIds）为空， 表示页面没有勾选，因此要删除之前保存过得 数据据
            super.deleteAll(dietaryList);
            return ;
        }
        
        List<Long> dietaryIdList = new ArrayList<Long>(java.util.Arrays.asList(dietaryHabitIds));
        for (LiveWayDietary dietary : dietaryList) {
            if (dietaryIdList.contains(dietary.getDietaryHabitId())) {
                dietaryIdList.remove(dietary.getDietaryHabitId());
            } else {
                super.delete(dietary);
            }
        }
        
        LiveWayDietary dietary = null;
        for (Long itemId : dietaryIdList) {
            if (null == itemId || itemId.intValue() <= 0) {
                continue ;
            }
            dietary = new LiveWayDietary();
            dietary.setDietaryHabitId(itemId);
            dietary.setExamPersonId(examPersonId);
            dietary.setPersonDetailId(personDetailId);
            super.save(dietary);
        }
    }
    
    /**
     * 老年人健康体检信息
     * @param json
     */
    private void saveExamElder(ExamElder examElderInfo, SysUserInfo user, Long personDetailId, Long examPersonId, Date examTime) {
        // 检验是否有要保存的信息，没有直接返回
        StringBuffer check = new StringBuffer(examElderInfo.getHealthAssess());
        check.append(examElderInfo.getIntelligenceCheck());
        check.append(examElderInfo.getCognitiveFunction());
        check.append(examElderInfo.getLiveSelfAssess());
        check.append(examElderInfo.getEmotionCondition());
        check.append(examElderInfo.getDepressionCheck());
        if (check.length() <= 0) {
            return ;
        }
        
        ExamElder examElder = super.selectAObject(ExamElder.class, examPersonId);
        if (null == examElder) {
            examElder = new ExamElder();
            examElderInfo.setCreateTime(new Date());
            examElderInfo.setCreatorId(user.getUserInfoId());
            examElderInfo.setCreatorName(user.getName());
        } else {
            
            examElderInfo.setCreateTime(examElder.getCreateTime());
            examElderInfo.setCreatorId(examElder.getCreatorId());
            examElderInfo.setCreatorName(examElder.getCreatorName());
        }
        NullBeanUtils.copyProperties(examElder, examElderInfo);
        examElder.setExamTime(examTime);
        examElder.setExamPersonId(examPersonId);
        examElder.setPersonDetailId(personDetailId);
        super.save(examElder);
    }
}
