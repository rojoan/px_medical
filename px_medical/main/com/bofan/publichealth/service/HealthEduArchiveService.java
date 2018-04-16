package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.HealthEduArchiveIdQueryInfo;
import com.bofan.publichealth.command.HealthEduArchiveQueryInfo;
import com.bofan.publichealth.valueobject.HealthEduArchive;

/**
 * @Description 健康教育活动存档类型业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class HealthEduArchiveService extends AbstractAnnoCommonService {

    /**
     * 获取健康教育活动存档类型
     * @param healthEducationId
     * @return
     */
    @Transactional
    public List<String> selectHealthEduArchiveId(Long healthEducationId) {
        HealthEduArchiveIdQueryInfo queryInfo = new HealthEduArchiveIdQueryInfo();
        queryInfo.setHealthEducationId(healthEducationId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(String.class, qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存健康教育活动存档类型
     * @param archiveTypes
     * @param healthEducationId
     */
    public void saveHealthEduArchive(String[] archiveTypes, Long healthEducationId) {
        List<HealthEduArchive> archiveList = this.selectHealthEduArchive(healthEducationId);
        if (null == archiveTypes || archiveTypes.length <= 0) {
            if (null != archiveList && archiveList.size() > 0) {
                super.deleteAll(archiveList);
            }
            return ;
        }
        
        int index = 0;
        int maxIndex = (null != archiveList ? archiveList.size() : 0);
        HealthEduArchive archive = null;
        for (String type : archiveTypes) {
            archive = ((maxIndex > 0 && maxIndex > index) ? archiveList.get(0) : null);
            if (null != archive) {
                archiveList.remove(0);
            } else {
                archive = new HealthEduArchive();
            }
            archive.setEduArchiveType(type);
            archive.setHealthEducationId(healthEducationId);
            
            index++;
            super.save(archive);
        }
        
        if (null != archiveList && archiveList.size() > 0) {
            for (HealthEduArchive eduArchive : archiveList) {
                super.delete(eduArchive);
            }
        }
    }
    
    /**
     * 获取健康教育活动存档
     * @param healthEducationId
     * @return
     */
    private List<HealthEduArchive> selectHealthEduArchive(Long healthEducationId) {
        HealthEduArchiveQueryInfo queryInfo = new HealthEduArchiveQueryInfo();
        queryInfo.setHealthEducationId(healthEducationId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(HealthEduArchive.class, qo.getQueryString(), qo.getParam());
    }
    
}