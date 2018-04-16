package com.bofan.pacs.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.pacs.command.ExamResultEditInfo;
import com.bofan.pacs.command.ExamResultQueryInfo;
import com.bofan.pacs.valueobject.ExamResult;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.utils.NullBeanUtils;
/**
 * 病人检查结果信息业务层
 * @Description: 
 * @author lqw
 * @date 2017-9-30
 * @version V1.0
 */
@Service
@Transactional
public class ExamResultService extends AbstractAnnoCommonService {

	@Autowired
	private PatientExamService patientExamService;
	
    /**
     * 根据条件查询检查结果信息列表
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<ExamResult> selectExamResults(ExamResultQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 根据条件查询检查结果信息
     * @param info
     * @return
     */
    public ExamResult findExamResult(ExamResultQueryInfo info) {
        List<ExamResult> list = selectExamResults(info);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 根据条件查询
     * @param hospitalNo
     * @param htFsPacsMark
     * @param patientExamNum
     * @return
     */
    public ExamResult findExamResult(String hospitalNo, String htFsPacsMark, String patientExamNum) {
    	ExamResultQueryInfo queryInfo = new ExamResultQueryInfo();
    	queryInfo.setHospitalNo(hospitalNo);
    	queryInfo.setHtFsPacsMark(htFsPacsMark);
    	queryInfo.setPatientExamNum(patientExamNum);
    	return findExamResult(queryInfo);
    }

    /**
     * 保存检查结果报告
     * @param info
     */
	public void saveExamResult(ExamResultEditInfo info) {
		ExamResult examResult =  findExamResult(info.getHospitalNo(), info.getHtFsPacsMark(), info.getPatientExamNum());
	    if (null == examResult) {
	    	examResult = new ExamResult();
	    } 
	    NullBeanUtils.copyProperties(examResult, info);
	    super.save(examResult);
	    // 检查医生 、 报告日期
	    PatientExam patientExam = patientExamService.findPatientExam(info.getHospitalNo(), info.getHtFsPacsMark(), info.getPatientExamNum());
	    patientExam.setExamDate(new Date());
	    patientExam.setAuditDoctor(info.getAuditDoctor());
	    //TODO 待其他业务功能完成，需要 设置 检查医生：patientExam.setDiagnosisDoctor(""); 
	    super.save(patientExam);
	}

}
