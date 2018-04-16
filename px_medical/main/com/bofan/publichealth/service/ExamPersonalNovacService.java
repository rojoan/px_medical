package com.bofan.publichealth.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.ExamPersonalNovacQueryInfo;
import com.bofan.publichealth.valueobject.ExamPersonalNovac;
import com.bofan.utils.Tools;

/**
 * @Description 保存居民体检--非免疫规划预防接种史业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class ExamPersonalNovacService extends AbstractAnnoCommonService {
    
    /**
     * 获取居民体检健康问题--非免疫规划预防接种史信息
     * @param examPersonId
     * @param personDetailId
     * @return
     */
    public List<ExamPersonalNovac> selectPersonalNovac(Long examPersonId, Long personDetailId) {
        ExamPersonalNovacQueryInfo queryInfo = new ExamPersonalNovacQueryInfo();
        queryInfo.setExamPersonId(examPersonId);
        queryInfo.setPersonDetailId(personDetailId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(ExamPersonalNovac.class, qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 保存居民体检--非免疫规划预防接种史
     * @param json
     */
    public void savePersonalNovacByJson(String json, Long personDetailId, Long examPersonId, Date examTime) {
        List<ExamPersonalNovac> dataList = JSONArray.parseArray(json, ExamPersonalNovac.class);
        for (ExamPersonalNovac personalNovac : dataList) {
            if (Tools.isEmptyString(personalNovac.getVacName())) {
                continue ;
            }
            personalNovac.setPersonDetailId(personDetailId);
            personalNovac.setExamPersonId(examPersonId);
            personalNovac.setExamTime(examTime);
            super.save(personalNovac);
        }
    }
    
    /**
     * 删除居民体检--非免疫规划预防接种史(多个)
     * @param json
     */
    public void deletePersonNovac(Long personDetailId, Long examPersonId) {
        List<ExamPersonalNovac> personNovacList = this.selectPersonalNovac(examPersonId, personDetailId);
        if (null != personNovacList) {
            super.deleteAll(personNovacList);
        }
    }
    
    /**
     * 根据主键删除居民体检--非免疫规划预防接种史
     * @param personDrugId
     */
    public void deletePersonNovac(Long personNovacId) {
        ExamPersonalNovac personalNovac = super.selectAObject(ExamPersonalNovac.class, personNovacId);
        if (null != personalNovac) {
            super.delete(personalNovac);
        }
    }

}
