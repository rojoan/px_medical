package com.bofan.pacs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.pacs.command.DicomMatchQueryInfo;
import com.bofan.pacs.valueobject.DicomMatch;

@Service
@Transactional
public class DicomMatchService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询图像匹配信息
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<DicomMatch> selectDicomMatchs(DicomMatchQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 查询图像匹配信息
     * @param info
     * @return
     */
    public DicomMatch findDicomMatch(DicomMatchQueryInfo info) {
        List<DicomMatch> list = selectDicomMatchs(info);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
