package com.bofan.pacs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.pacs.command.PatientArchiveQueryInfo;
import com.bofan.pacs.valueobject.PatientArchive;

@Service
@Transactional
public class PatientArchiveService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询患者档案信息
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PatientArchive> selectPatientArchives(PatientArchiveQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 查询患者档案信息
     * @param info
     * @return
     */
    public PatientArchive findPatientArchive(PatientArchiveQueryInfo info) {
        List<PatientArchive> list = selectPatientArchives(info);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 根据患者ID查询患者档案信息
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public PatientArchive selectPatientArchives(Long patientId) {
        if (null == patientId) {
            return null;
        }
        PatientArchiveQueryInfo queryInfo = new PatientArchiveQueryInfo();
        queryInfo.setPatientId(patientId.toString());
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<PatientArchive> dataList = super.executeSql(qo.getQueryString(), qo.getParam());
        return dataList.isEmpty() ? null : dataList.get(0);
    }

}
