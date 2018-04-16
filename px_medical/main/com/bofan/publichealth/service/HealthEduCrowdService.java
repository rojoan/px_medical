package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.HealthEduCrowdIdQueryInfo;
import com.bofan.publichealth.command.HealthEduCrowdQueryInfo;
import com.bofan.publichealth.valueobject.HealthEduCrowd;

/**
 * @Description 健康教育--资料发放/接受教育对象业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class HealthEduCrowdService extends AbstractAnnoCommonService {

    /**
     * 获取健康教育--资料发放/接受教育对象
     * @param healthEducationId
     * @return
     */
    @Transactional
    public List<String> selectHealthEduCrowdId(Long healthEducationId) {
        HealthEduCrowdIdQueryInfo queryInfo = new HealthEduCrowdIdQueryInfo();
        queryInfo.setHealthEducationId(healthEducationId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(String.class, qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存健康教育--接受教育对象
     * @param archiveTypes
     * @param healthEducationId
     */
    public void saveHealthEduCrowd(String[] crowdTypes, Long healthEducationId) {
        List<HealthEduCrowd> crowdList = this.selectHealthEduCrowd(healthEducationId);
        if (null == crowdTypes || crowdTypes.length <= 0) {
            if (null != crowdList && crowdList.size() > 0) {
                super.deleteAll(crowdList);
            }
            return ;
        }
        
        int index = 0;
        int maxIndex = (null != crowdList ? crowdList.size() : 0);
        HealthEduCrowd eduCrowd = null;
        for (String type : crowdTypes) {
            eduCrowd = ((maxIndex > 0 && maxIndex > index) ? crowdList.get(0) : null);
            if (null != eduCrowd) {
                crowdList.remove(0);
            } else {
                eduCrowd = new HealthEduCrowd();
            }
            
            eduCrowd.setCrowdType(type);
            eduCrowd.setHealthEducationId(healthEducationId);
            
            index++;
            super.save(eduCrowd);
        }
        
        if (null != crowdList && crowdList.size() > 0) {
            for (HealthEduCrowd crowd : crowdList) {
                super.delete(crowd);
            }
        }
    }
    
    /**
     * 获取健康教育--资料发放/接受教育对象
     * @param healthEducationId
     * @return
     */
    private List<HealthEduCrowd> selectHealthEduCrowd(Long healthEducationId) {
        HealthEduCrowdQueryInfo queryInfo = new HealthEduCrowdQueryInfo();
        queryInfo.setHealthEducationId(healthEducationId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(HealthEduCrowd.class, qo.getQueryString(), qo.getParam());
    }
    
}