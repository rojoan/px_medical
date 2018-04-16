package com.bofan.publichealth.gravida.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.gravida.command.GravidaPregnancyQueryInfo;
import com.bofan.publichealth.gravida.valueobject.GravidaPregnancy;
import com.bofan.utils.Tools;

/**
 * @Description: 孕妇早期情况 Service
 * @author lqw
 */
@Service
@Transactional
public class GravidaPregnancyService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询孕妇孕早期情况对照表 列表
     * @param queryInfo GravidaPregnancyQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<GravidaPregnancy> selectGravidaPregnancyList(GravidaPregnancyQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询孕妇孕早期情况对照表
     * @param queryInfo GravidaPregnancyQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public GravidaPregnancy findGravidaPregnancy(GravidaPregnancyQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<GravidaPregnancy> list = super.executeSql(qo.getQueryString(),qo.getParam());
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 根据条件查询 孕妇孕早期情况对照表中  pregnancyCaseId 列表集合
     * @param pregnancyFirstExamId
     * @return
     */
    public List<Long> selectGravidaPregnancyIdsList(Long pregnancyFirstExamId) {
        GravidaPregnancyQueryInfo queryInfo = new GravidaPregnancyQueryInfo();
        queryInfo.setPregnancyFirstExamId(pregnancyFirstExamId);
        List<GravidaPregnancy> GravidaPregnancyList = this.selectGravidaPregnancyList(queryInfo);
        List<Long> gravidaPregnancyIdList = new ArrayList<Long>();
        if (null != GravidaPregnancyList && GravidaPregnancyList.size() > 0) {
            for (GravidaPregnancy GravidaPregnancy : GravidaPregnancyList) {
                gravidaPregnancyIdList.add(GravidaPregnancy.getPregnancyCaseId());
            }
        }
        return gravidaPregnancyIdList;
    }
}