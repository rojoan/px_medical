package com.bofan.reconsult.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.his.command.OutpatientInhospitalQueryInfo;
import com.bofan.his.service.OutpatientInhospitalService;
import com.bofan.his.valueobject.OutpatientInhospital;
import com.bofan.lis.valueobject.LisInspectionSample;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.reconsult.command.ReConsultingEditInfo;
import com.bofan.reconsult.command.ReConsultingQueryInfo;
import com.bofan.reconsult.valueobject.ReConsulting;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;
import com.bofan.videomeeting.service.VideoMeetingService;
import com.bofan.videomeeting.valueobject.VideoMeeting;
import com.bofan.videomeeting.valueobject.VideoMeetingQueue;

/**
 * @author xlf
 *
 */
@Service
@Transactional
public class ReConsultingService extends AbstractAnnoCommonService {
    
    @Autowired
    private VideoMeetingService videoMeetingService;
    
    @Autowired
    private OutpatientInhospitalService outpatientInhospitalService;

    /**
     * 查询会诊信息分页列表
     * @param queryInfo
     * @return
     */
    public Page selectReConsultingList(ReConsultingQueryInfo queryInfo) {
        IQueryObject qo = null;
        // 初始化查询时间
        queryInfo.handleQueryDate();
        if (StringUtils.isNotBlank(queryInfo.getQueryField()) && StringUtils.isNotBlank(queryInfo.getKeyword())) {
            qo = super.getQueryObject(queryInfo, queryInfo.getQueryField(), new Object[]{queryInfo.getKeyword()});
        } else {
            qo = super.getQueryObject(queryInfo);
        }
         
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 根据pasc检查Id及状态获取远程会诊信息
     * @param patientExamId
     * @param consultingStatus
     * @return
     */
    @SuppressWarnings("rawtypes")
    public ReConsulting selectReConsultingByPatientExamId(Long patientExamId, String consultingStatus) {
        if (null == patientExamId) {
            return null;
        }
        ReConsultingQueryInfo queryInfo = new ReConsultingQueryInfo();
        queryInfo.setPatientExamId(patientExamId);
        queryInfo.setNotEquStatus(consultingStatus);
        
        IQueryObject qo = super.getQueryObject(queryInfo, queryInfo.getQueryField(), new Object[]{queryInfo.getKeyword()});
        List dataList = super.executeSql(qo.getQueryString(), qo.getParam());
        return dataList.isEmpty() ? null : (ReConsulting) dataList.get(0);
    }
    
    /**
     * 根据Lis检查Id及状态获取远程会诊信息
     * @param patientExamId
     * @param consultingStatus
     * @return
     */
    @SuppressWarnings("rawtypes")
    public ReConsulting selectReConsultingByInspectionSampleId(Long lisInspectionSampleId, String consultingStatus) {
        if (null == lisInspectionSampleId) {
            return null;
        }
        ReConsultingQueryInfo queryInfo = new ReConsultingQueryInfo();
        queryInfo.setLisInspectionSampleId(lisInspectionSampleId);
        queryInfo.setNotEquStatus(consultingStatus);
        
        IQueryObject qo = super.getQueryObject(queryInfo, queryInfo.getQueryField(), new Object[]{queryInfo.getKeyword()});
        List dataList = super.executeSql(qo.getQueryString(), qo.getParam());
        return dataList.isEmpty() ? null : (ReConsulting) dataList.get(0);
    }
    
    /**
     * 根据ris检查Id及状态获取远程会诊信息
     * @param patientExamId
     * @param consultingStatus
     * @return
     */
    @SuppressWarnings("rawtypes")
    public ReConsulting selectReConsultingByRisInspectionId(Long risInspectionId, String consultingStatus) {
        if (null == risInspectionId) {
            return null;
        }
        ReConsultingQueryInfo queryInfo = new ReConsultingQueryInfo();
        queryInfo.setRisInspectionId(risInspectionId);
        queryInfo.setNotEquStatus(consultingStatus);
        
        IQueryObject qo = super.getQueryObject(queryInfo, queryInfo.getQueryField(), new Object[]{queryInfo.getKeyword()});
        List dataList = super.executeSql(qo.getQueryString(), qo.getParam());
        return dataList.isEmpty() ? null : (ReConsulting) dataList.get(0);
    }
    
    /**
     * 根据主键获取远程会诊信息
     * @param reConsultingId
     * @return
     */
    public ReConsulting selectReConsultingById(Long reConsultingId) {
        return super.load(ReConsulting.class, reConsultingId);
    }
    
	/**
	 * 保存远程会诊申请信息
	 * @param info
	 * @return
	 */
	public void saveReConsulting(ReConsultingEditInfo info) {
	    ReConsulting reConsulting = null;
	    if (null != info.getReConsultingId()) {
	        reConsulting = this.selectReConsultingById(info.getReConsultingId());
	        info.setPatientType(reConsulting.getPatientType());
	        info.setInpatientId(reConsulting.getInpatientId());
	    } else {
	        Date currentData = new Date();
	        reConsulting = new ReConsulting();
	        info.setReApplyTime(currentData);
	        reConsulting.setReCreateTime(currentData);
	    }
	    
	    NullBeanUtils.copyProperties(reConsulting, info);
	    super.saveAndRefresh(reConsulting);
	    info.setReConsultingId(reConsulting.getReConsultingId());
	    
	    OutpatientInhospitalQueryInfo queryInfo = new OutpatientInhospitalQueryInfo();
	    // 标识检查表的数据为远程会诊
	    if (null != reConsulting.getPatientExamId()) {
	        PatientExam patientExam = super.selectAObject(PatientExam.class, reConsulting.getPatientExamId());
	        if (null != patientExam) {
	            patientExam.setDiagnosisFlag(Contstants.DIAGNOSIS_FLAG_REMOTE);
	            super.save(patientExam);
	            
	            queryInfo.setPatientId(patientExam.getPatientId());
	            if (Contstants.PATIENT_TYPE_INHOSPITAL.equals(patientExam.getPatientType() + "") 
	                    || Contstants.PATIENT_TYPE_INHOSPITAL_URGENT.equals(patientExam.getPatientType() + "")) {
	                queryInfo.setInhospitalId(patientExam.getInpatientId());
	            }
	            if (Contstants.PATIENT_TYPE_OUTPATIENT.equals(patientExam.getPatientType() + "") 
	                    || Contstants.PATIENT_TYPE_OUTPATIENT_URGENT.equals(patientExam.getPatientType() + "")) {
	                queryInfo.setOutpatientId(patientExam.getInpatientId());
	            }
	        }
	    }
	    
	    // 标识检验样例表的数据为远程会诊
        if (null != reConsulting.getLisInspectionSampleId()) {
            LisInspectionSample inspectionSample = super.selectAObject(LisInspectionSample.class, reConsulting.getLisInspectionSampleId());
            if (null != inspectionSample) {
                inspectionSample.setDiagnosisFlag(Contstants.DIAGNOSIS_FLAG_REMOTE);
                super.save(inspectionSample);
                
                if (null != inspectionSample.getPatientId()) {
                    queryInfo.setPatientId(new Long(inspectionSample.getPatientId()));
                }
                if (null != inspectionSample.getInpatientId() 
                        && (Contstants.PATIENT_TYPE_INHOSPITAL.equals(inspectionSample.getPatientType()) 
                        || Contstants.PATIENT_TYPE_INHOSPITAL_URGENT.equals(inspectionSample.getPatientType()))) {
                    queryInfo.setInhospitalId(new Long(inspectionSample.getInpatientId()));
                }
                if (null != inspectionSample.getInpatientId() 
                        && (Contstants.PATIENT_TYPE_OUTPATIENT.equals(inspectionSample.getPatientType()) 
                        || Contstants.PATIENT_TYPE_OUTPATIENT_URGENT.equals(inspectionSample.getPatientType()))) {
                    queryInfo.setOutpatientId(new Long(inspectionSample.getInpatientId()));
                }
            }
        }
        
        // 更新门诊住院表
        if (null != queryInfo.getPatientId() && (null != queryInfo.getInhospitalId() || null != queryInfo.getOutpatientId())) {
            List<OutpatientInhospital> dataList = this.outpatientInhospitalService.selectOutpatientInhospital(queryInfo);
            if (null != dataList && dataList.size() == 1) {
                OutpatientInhospital outpatientInhospital = dataList.get(0);
                outpatientInhospital.setDiagnosisFlag(Contstants.DIAGNOSIS_FLAG_REMOTE);
                super.save(outpatientInhospital);
            }
        }
	}
	
	/**
	 * 更新完成
	 * @param reConsultingId
	 */
	public void saveReConsultFinish(Long reConsultingId) {
	    ReConsulting consult = this.selectReConsultingById(reConsultingId);
	    if (null != consult) {
	        if (Contstants.RE_CONSULT_STATUS_FINISH.equals(consult.getConsultingStatus())) {
	            throw new RuntimeException("会诊已结束！");
	        }
	        consult.setConsultingStatus(Contstants.RE_CONSULT_STATUS_FINISH);
	        super.save(consult);
	        VideoMeeting meeting = this.videoMeetingService.selectVideoMeetingByReConsultingId(reConsultingId, false);
	        if (null != meeting) {
                List<VideoMeetingQueue> dataList = this.videoMeetingService.selectVideoMeetingQueue(reConsultingId,
                        meeting.getVideoMeetingId());
                super.deleteAll(dataList);
	        }
	    }
	    
	}

}
