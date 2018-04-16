package com.bofan.pacs.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.pacs.command.PatientExamQueryInfo;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.utils.DateHelper;
import com.bofan.utils.DicTools;
 

@Service
@Transactional
public class PatientExamService extends AbstractAnnoCommonService {

    /**
     * 查询病人检查信息列表
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PatientExam> selectPatientExamList(PatientExamQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 查询病人检查信息
     * @param info
     * @return
     */
    public PatientExam findPatientExam(PatientExamQueryInfo info) {
        List<PatientExam> list = selectPatientExamList(info);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 根据 单位id和门诊|住院号查询检查信息
     * @param orgId
     * @param inpatientId
     * @return
     */
    public PatientExam findPatientExamByOrgInpatientId(Long orgId,String inpatientId) {
    	PatientExamQueryInfo queryInfo = new PatientExamQueryInfo();
    	queryInfo.setOrgId(orgId);
    	queryInfo.setInpatientId(new Long(inpatientId));
        return findPatientExam(queryInfo);
    }
    
    /**
     * 根据条件查询病人检查信息
     * @param hospitalNo
     * @param htFsPacsMark
     * @param patientExamNum
     * @return
     */
    public PatientExam findPatientExam(String hospitalNo, String htFsPacsMark,String patientExamNum) {
    	PatientExamQueryInfo patientExamQueryInfo = new PatientExamQueryInfo();
    	patientExamQueryInfo.setHospitalNo(hospitalNo);
    	patientExamQueryInfo.setHtFsPacsMark(htFsPacsMark);
    	patientExamQueryInfo.setPatientExamNum(patientExamNum);
        return findPatientExam(patientExamQueryInfo);
    }

    /**
     * 根据条件查询病人检查信息
     * @param patientId
     * @param patientType
     * @param inpatientId
     * @return
     */
    public PatientExam findPatientExam(Long patientId, Long patientType, Long inpatientId) {
        if (null == patientId || null == patientType || null == inpatientId) {
            return null;
        }
        PatientExamQueryInfo patientExamQueryInfo = new PatientExamQueryInfo();
        patientExamQueryInfo.setPatientId(patientId);
        patientExamQueryInfo.setPatientType(patientType);
        patientExamQueryInfo.setInpatientId(inpatientId);
        return findPatientExam(patientExamQueryInfo);
    }

    public  String bulidPatientExamNum() {
        return DateHelper.getDateFormatStr(new Date(),"yyyyMMddHHmmss")  + DicTools.getRondomNum(4);
    }
 
}
