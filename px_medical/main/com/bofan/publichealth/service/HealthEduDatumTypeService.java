package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.HealthEduDatumTypeIdQueryInfo;
import com.bofan.publichealth.command.HealthEduDatumTypeQueryInfo;
import com.bofan.publichealth.valueobject.HealthEduDatumType;

/**
 * @Description 健康教育--资料种类业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class HealthEduDatumTypeService extends AbstractAnnoCommonService {

    /**
     * 获取健康教育--资料种类
     * @param healthEducationId
     * @return
     */
    @Transactional
    public List<String> selectHealthEduDatumTypeId(Long healthEducationId) {
        HealthEduDatumTypeIdQueryInfo queryInfo = new HealthEduDatumTypeIdQueryInfo();
        queryInfo.setHealthEducationId(healthEducationId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(String.class, qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存健康教育--资料种类
     * @param archiveTypes
     * @param healthEducationId
     */
    public void saveHealthEduDatumType(String[] datumTypes, Long healthEducationId) {
        List<HealthEduDatumType> datumTypeList = this.selectHealthEduDatumType(healthEducationId);
        if (null == datumTypes || datumTypes.length <= 0) {
            if (null != datumTypeList && datumTypeList.size() > 0) {
                super.deleteAll(datumTypeList);
            }
            return ;
        }
        
        int index = 0;
        int maxIndex = (null != datumTypeList ? datumTypeList.size() : 0);
        HealthEduDatumType datumType = null;
        for (String type : datumTypes) {
            datumType = ((maxIndex > 0 && maxIndex > index) ? datumTypeList.get(0) : null);
            if (null != datumType) {
                datumTypeList.remove(0);
            } else {
                datumType = new HealthEduDatumType();
            }
            
            datumType.setDatumType(type);
            datumType.setHealthEducationId(healthEducationId);
            
            index++;
            super.save(datumType);
        }
        
        if (null != datumTypeList && datumTypeList.size() > 0) {
            for (HealthEduDatumType datum : datumTypeList) {
                super.delete(datum);
            }
        }
    }
    
    /**
     * 获取健康教育--资料种类
     * @param healthEducationId
     * @return
     */
    private List<HealthEduDatumType> selectHealthEduDatumType(Long healthEducationId) {
        HealthEduDatumTypeQueryInfo queryInfo = new HealthEduDatumTypeQueryInfo();
        queryInfo.setHealthEducationId(healthEducationId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(HealthEduDatumType.class, qo.getQueryString(), qo.getParam());
    }
    
}