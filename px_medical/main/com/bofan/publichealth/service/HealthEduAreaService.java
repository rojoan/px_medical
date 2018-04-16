package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.HealthEduAreaIdQueryInfo;
import com.bofan.publichealth.command.HealthEduAreaQueryInfo;
import com.bofan.publichealth.valueobject.HealthEduArea;

/**
 * @Description 健康教育--发放印刷/播放位置业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class HealthEduAreaService extends AbstractAnnoCommonService {

    /**
     * 获取健康教育--发放印刷/播放位置
     * @param healthEducationId
     * @param eduAreaFlag
     * @return
     */
    @Transactional
    public List<String> selectHealthEduAreaId(Long healthEducationId, String eduAreaFlag) {
        HealthEduAreaIdQueryInfo queryInfo = new HealthEduAreaIdQueryInfo();
        queryInfo.setHealthEducationId(healthEducationId);
        queryInfo.setEduAreaFlag(eduAreaFlag);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(String.class, qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存健康教育--发放印刷/播放位置
     * @param archiveTypes
     * @param healthEducationId
     * @param eduAreaFlag
     */
    public void saveHealthEduArea(String[] putAreas, Long healthEducationId, String eduAreaFlag) {
        List<HealthEduArea> areaList = this.selectHealthEduArea(healthEducationId, eduAreaFlag);
        if (null == putAreas || putAreas.length <= 0) {
            if (null != areaList && areaList.size() > 0) {
                super.deleteAll(areaList);
            }
            return ;
        }
        
        int index = 0;
        int maxIndex = (null != areaList ? areaList.size() : 0);
        HealthEduArea eduArea = null;
        for (String type : putAreas) {
            eduArea = ((maxIndex > 0 && maxIndex > index) ? areaList.get(0) : null);
            if (null != eduArea) {
                areaList.remove(0);
            } else {
                eduArea = new HealthEduArea();
            }
            eduArea.setPutArea(type);
            eduArea.setEduAreaFlag(eduAreaFlag);
            eduArea.setHealthEducationId(healthEducationId);
            
            index++;
            super.save(eduArea);
        }
        
        if (null != areaList && areaList.size() > 0) {
            for (HealthEduArea area : areaList) {
                super.delete(area);
            }
        }
    }
    
    /**
     * 获取健康教育--发放印刷/播放位置
     * @param healthEducationId
     * @param eduAreaFlag
     * @return
     */
    private List<HealthEduArea> selectHealthEduArea(Long healthEducationId, String eduAreaFlag) {
        HealthEduAreaQueryInfo queryInfo = new HealthEduAreaQueryInfo();
        queryInfo.setEduAreaFlag(eduAreaFlag);
        queryInfo.setHealthEducationId(healthEducationId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(HealthEduArea.class, qo.getQueryString(), qo.getParam());
    }
    
}