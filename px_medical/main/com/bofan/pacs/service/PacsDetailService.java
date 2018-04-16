package com.bofan.pacs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.pacs.command.PacsDetailQueryInfo;
import com.bofan.pacs.valueobject.PacsDetail;

@Service
@Transactional
public class PacsDetailService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询临床科室信息
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PacsDetail> selectPacsDetailList(PacsDetailQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 查询预约信息
     * @param info
     * @return
     */
    public PacsDetail findPacsDetail(PacsDetailQueryInfo info) {
        List<PacsDetail> list = selectPacsDetailList(info);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 根据检查表id主键 获取dicom的保存路径
     * @param patientExamId
     * @return
     */
    public String selectSavePath(Long patientExamId) {
    	if (null == patientExamId) {
    		return null;
		}
    	PacsDetailQueryInfo info = new PacsDetailQueryInfo();
    	info.setPatientId(patientExamId + "");//病人id -- 对应 patientExam 主键id
        List<PacsDetail> list = selectPacsDetailList(info);
        if (list != null && list.size() > 0) {
            return list.get(0).getSavePath();
        }
        return null;
    }
 
}
