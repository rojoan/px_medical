package com.bofan.gradingclinics.service;

import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.dictionary.support.DictionarysInVelocityToolbox;
import com.bofan.gradingclinics.command.HdDiagnosisApplyEditInfo;
import com.bofan.gradingclinics.command.HdDiagnosisApplyMonthDownCalcInfo;
import com.bofan.gradingclinics.command.HdDiagnosisApplyQueryInfo;
import com.bofan.gradingclinics.valueobject.HdDiagnosisApply;
import com.bofan.his.command.OutpatientInhospitalQueryInfo;
import com.bofan.his.service.OutpatientInhospitalService;
import com.bofan.his.valueobject.OutpatientInhospital;
import com.bofan.lis.service.LisInspectionSampleServcie;
import com.bofan.lis.valueobject.LisInspectionSample;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.pacs.service.PatientExamService;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.utils.Contstants;
import com.bofan.utils.DateHelper;
import com.bofan.utils.DicTools;
import com.bofan.utils.JsonObj;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.ResponseContstants;
import com.bofan.utils.Tools;
import com.mongo.command.HiDataBaseQueryInfo;
import com.mongo.hchart.DataCycleType;
import com.mongo.hchart.HiDataCommon;
import com.mongo.service.BaseMongoService;

/**
 * @Description: 双向转诊业务
 * @author lqw
 * @date 2017-10-2
 * @version V1.0
 */
@Service
@Transactional
public class HdDiagnosisApplyService extends AbstractAnnoCommonService {
    // dataName命名规则:值对象名(HdDiagnosisApply)+统计指标简称(Cout:记录数,XXSum:汇总数)
    static private String HD_DIAGNOSIS_APPLY_CHART_DATA = "HdDiagnosisApplyDownCout";
	@Autowired
	private PatientExamService patientExamService;
	@Autowired
	private LisInspectionSampleServcie lisInspectionSampleServcie;
    @Autowired
	private OutpatientInhospitalService outpatientInhospitalService;
    @Autowired
    private BaseMongoService mongoService;
	/**
	 * 保存双向转诊申请单
	 * @param editInfo 
	 */
	@SuppressWarnings({ "rawtypes" })
	public HdDiagnosisApply saveHdDiagnosisApply(HdDiagnosisApplyEditInfo editInfo) { 
		Map dicSysOrgCode = (Map) DictionarysInVelocityToolbox.getDictionary("dicSysOrgCode");
		HdDiagnosisApply hdDiagnosisApply = null;
		if (null != editInfo.getHdDiagnosisApplyId()) {
			hdDiagnosisApply = super.selectAObject(HdDiagnosisApply.class,editInfo.getHdDiagnosisApplyId());
			//如果是由暂存的转成已申请，修改申请时间
			if (Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_APPLYED.equals(editInfo.getTransStatus())
					|| Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_STORE.equals(hdDiagnosisApply.getTransStatus())) {
			    hdDiagnosisApply.setApplyTime(new Date());
			}
			NullBeanUtils.copyProperties(hdDiagnosisApply, editInfo);
		} else {
			hdDiagnosisApply = new HdDiagnosisApply();
			NullBeanUtils.copyProperties(hdDiagnosisApply, editInfo);
			if (Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_APPLYED.equals(editInfo.getTransStatus())) {
			    hdDiagnosisApply.setApplyTime(new Date());
			}
			hdDiagnosisApply.setApplyTime(new Date());//申请时间
			String numTime = DateHelper.getDateFormatStr(new Date(),"yyyyMMdd");
			String numCode = (String)dicSysOrgCode.get(hdDiagnosisApply.getInstitutionUpId()+"");
			String numInt =  DicTools.getRondomNum(3); 
			hdDiagnosisApply.setHdDiagnosisNum(numTime+numCode+numInt);//转诊单号 
		}
		
	    super.save(hdDiagnosisApply);
	    this.updateDiagnosisFlag(editInfo,hdDiagnosisApply);
	    return hdDiagnosisApply;
	}

	/**
	 * 更新远程会诊/双向转诊标志
	 * @param editInfo
	 * @param hdDiagnosisApply
	 */
	private void updateDiagnosisFlag(HdDiagnosisApplyEditInfo editInfo, HdDiagnosisApply hdDiagnosisApply) {
		if (null != editInfo.getHdDiagnosisApplyId()) {
			//如果是由暂存的转成已申请，修改申请时间
			if (Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_WAIT_RECEIVE.equals(editInfo.getTransStatus())
					&& Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_STORE.equals(hdDiagnosisApply.getTransStatus())) {
				updateRelTableDiagnosisFlag(hdDiagnosisApply.getOrgId(),hdDiagnosisApply.getPatientType(),hdDiagnosisApply.getInpatientId(),Contstants.DIAGNOSIS_FLAG_DIAG);
			}
			return ;
		}
		
		//直接申请双向转诊
		if (Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_WAIT_RECEIVE.equals(editInfo.getTransStatus())) {
			updateRelTableDiagnosisFlag(hdDiagnosisApply.getOrgId(),hdDiagnosisApply.getPatientType(),hdDiagnosisApply.getInpatientId(),Contstants.DIAGNOSIS_FLAG_DIAG);
		}
	}

	/**
	 * 更新关联表的远程诊断标识
	 * @param inpatientId
	 * @param diagnosisFlag
	 */ 
	private void updateRelTableDiagnosisFlag(Long orgId,String patientType,String inpatientId,String diagnosisFlag) {
		//更新PACS检查表的远程诊断标识
		PatientExam patientExam = this.patientExamService.findPatientExamByOrgInpatientId(orgId,inpatientId);
		if (null != patientExam) {
			patientExam.setDiagnosisFlag(diagnosisFlag);
			super.save(patientExam);
		}
		//更新LIS检查表的远程诊断标识
		LisInspectionSample inspectionSample = this.lisInspectionSampleServcie.selectInspectionSampleByOrgInpatientId(orgId,inpatientId);
		if (null != inspectionSample) {
			inspectionSample.setDiagnosisFlag(diagnosisFlag);
			super.save(inspectionSample);
		}
		//更新门诊住院表的远程诊断标识
		
		OutpatientInhospital outpatientInhospital = this.selectOutpatientInhospital(patientType, inpatientId);
		if (null != outpatientInhospital) {
			  outpatientInhospital.setDiagnosisFlag(diagnosisFlag);
	          super.save(outpatientInhospital);
		}
	}
	
	/**
	 * 根据患者类型 和门诊住院号 查询  门诊住院登记
	 * @param patientType
	 * @param inpatientId
	 * @return
	 */
	public OutpatientInhospital selectOutpatientInhospital(String patientType,String inpatientId){
		OutpatientInhospitalQueryInfo queryInfo = new OutpatientInhospitalQueryInfo();
		if (Contstants.PATIENT_TYPE_INHOSPITAL.equals(patientType)) {
			 queryInfo.setInhospitalId(new Long(inpatientId));
		} else {
			 queryInfo.setOutpatientId(new Long(inpatientId));
		}
		List<OutpatientInhospital> dataList = this.outpatientInhospitalService.selectOutpatientInhospital(queryInfo);
		if (Tools.isNotEmptyList(dataList)) {
			return dataList.get(0);
		}
		return null;
	}
	
	

	/**
	 * 根据条件查询转诊申请信息
	 * @param info
	 * @return
	 */
	public Page selectHdDiagnosisApply(HdDiagnosisApplyQueryInfo info) {
		IQueryObject qo = super.getQueryObject(info);
		return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
	}

	public JsonObj updateAudit(Long hdDiagnosisApplyId, String auditStatus, Long checkDoctorId, String checkDoctorName, String checkOpinion) {
		JsonObj result = new JsonObj();
		HdDiagnosisApply  hdDiagnosisApply = super.selectAObject(HdDiagnosisApply.class,hdDiagnosisApplyId);
    	hdDiagnosisApply.setCheckDoctorId(checkDoctorId); //审核医生Id
    	hdDiagnosisApply.setCheckDoctorName(checkDoctorName); //审核医生
    	hdDiagnosisApply.setCheckOpinion(checkOpinion); //审核意见
    	hdDiagnosisApply.setCheckTime(new Date());//审核日期
    	//设置审核状态
    	if (Contstants.HDDIAGNOSISAPPLY_AUDITSTATUS_PASS.equals(auditStatus)) {
    		hdDiagnosisApply.setTransStatus(Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_WAIT_RECEIVE);//审核通过待接诊
    		
		}else if (Contstants.HDDIAGNOSISAPPLY_AUDITSTATUS_REFUSE.equals(auditStatus)) {
    		hdDiagnosisApply.setTransStatus(Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_REFUSE);//已拒绝
    		this.updateRelTableDiagnosisFlag(hdDiagnosisApply.getOrgId(),hdDiagnosisApply.getPatientType(),hdDiagnosisApply.getInpatientId(), Contstants.DIAGNOSIS_FLAG_NONE);//是否申请远程诊断或双向转诊：0=未申请;
		}
    	
    	this.save(hdDiagnosisApply);
    	result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
    	return result;
		
	}

	/**
	 * 对申请单 进行接诊
	 * @param hdDiagnosisApplyId
	 * @param clinicalOfficeId
	 * @param clinicalOfficeName
	 * @param clinicalDoctorId
	 * @param clinicalDoctorName
	 * @return
	 */
	public JsonObj receiveTreatment(Long hdDiagnosisApplyId, Long clinicalOfficeId, String clinicalOfficeName, Long clinicalDoctorId, String clinicalDoctorName) {
		JsonObj result = new JsonObj();
		HdDiagnosisApply  hdDiagnosisApply = super.selectAObject(HdDiagnosisApply.class,hdDiagnosisApplyId);
    	hdDiagnosisApply.setClinicalDoctorId(clinicalDoctorId);
    	hdDiagnosisApply.setClinicalDoctorName(clinicalDoctorName);
    	hdDiagnosisApply.setClinicalOfficeId(clinicalOfficeId);
    	hdDiagnosisApply.setClinicalOfficeName(clinicalOfficeName);
    	hdDiagnosisApply.setClinicalTime(new Date());
    	hdDiagnosisApply.setTransStatus(Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_WAIT_TREAT);
    	this.save(hdDiagnosisApply);
    	return result;
	}
	
	/**
	 * 保存接诊或拒绝
	 * @param ids
	 * @param currentUser
	 * @param transStatus
	 */
	public void saveReceivePatient(String[] ids, SysUserInfo currentUser, String transStatus) {
	    if (null != ids && ids.length > 0) {
	        Date currentDate = new Date();
	        HdDiagnosisApply hdDiagnosisApply = null;
	        for (String id : ids) {
	            if (Tools.isEmptyString(id)) {
	                continue ;
	            }
	            hdDiagnosisApply = super.selectAObject(HdDiagnosisApply.class,Long.valueOf(id));
	            if (null == hdDiagnosisApply) {
	                continue ;
	            }
	            
	            hdDiagnosisApply.setClinicalTime(currentDate);
	            hdDiagnosisApply.setClinicalDoctorId(currentUser.getUserInfoId());
	            hdDiagnosisApply.setClinicalDoctorName(currentUser.getName());
	            hdDiagnosisApply.setClinicalOfficeId(currentUser.getOrgId());
	            hdDiagnosisApply.setClinicalOfficeName(currentUser.getSysOrg().getName());
	            hdDiagnosisApply.setTransStatus(transStatus);
	            super.save(hdDiagnosisApply);
	        }
	    }
	    
	}

    /**
     * 统计转诊的从上下医院上转的数量 不定给周期的话，默认将周期设为月 不指定起止时间的话，默认统计当月
     * 
     * @param calcInfo
     */
    public void calcHdDiagnosisApplyMonthDownCount(HdDiagnosisApplyMonthDownCalcInfo calcInfo) {
        // 如不指定周期，默认是月周期
        if (calcInfo.getCycleType() == null) {
            calcInfo.setCycleType(DataCycleType.MONTH.getCycleType());
        }
        // 根据统计起始日期设置周期(期次)
        calcInfo.setDataCycle(DataCycleType.getDateCycleFromStr(calcInfo.getCycleType(), calcInfo.getBeginApplyTime()));

        // 查询Mongo，看有无旧记录
        Criteria criatira = new Criteria();
        criatira.andOperator(Criteria.where("dataName").is(HD_DIAGNOSIS_APPLY_CHART_DATA),
                Criteria.where("dataCycle").is(calcInfo.getDataCycle()),
                Criteria.where("dataCycle").is(calcInfo.getDataCycle()));
        HiDataCommon hiData = this.mongoService.selectOne(HiDataCommon.class, query(criatira));
        if (hiData == null) {
            hiData = new HiDataCommon();

            hiData.setDataName(HD_DIAGNOSIS_APPLY_CHART_DATA);
            hiData.setCycleType(calcInfo.getCycleType());
            hiData.setDataCycle(calcInfo.getDataCycle());
        } else {
            hiData.clearSeriesData();
        }
        // 转诊申请数量统计结果当成一个列
        calcInfo.setTransStatusNotIn(new String[] { Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_STORE });

        IQueryObject downApplyCountQo = super.getQueryObject(calcInfo);
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> monthDownApplyCountList = (List<Map<String, Object>>) super.executeSql(
                downApplyCountQo.getQueryString(), downApplyCountQo.getParam());
        //hiData.addSeriesData("转入申请数", "#FF0000", monthDownApplyCountList);
        hiData.addSeriesData("转入申请数", monthDownApplyCountList);

        // 转诊接诊数量统计结果当成一个列
        calcInfo.setTransStatusIn(new String[] { Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_WAIT_TREAT,
                Contstants.HDDIAGNOSISAPPLY_TRANSSTATUS_HAD_TREAT });
        IQueryObject downClinicalCountQo = super.getQueryObject(calcInfo);
        downClinicalCountQo = super.getQueryObject(calcInfo);
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> monthDownClinicalCountList = (List<Map<String, Object>>) super.executeSql(
                downClinicalCountQo.getQueryString(), downClinicalCountQo.getParam());
        //hiData.addSeriesData("转入就诊数", "#FF00FF", monthDownClinicalCountList);
        hiData.addSeriesData("转入就诊数", monthDownClinicalCountList);

        // 保存到mongo
        this.mongoService.save(hiData);
    }

    public HiDataCommon selectHdDiagnosisMonthDownCount(HiDataBaseQueryInfo hiDataQueryInfo) {
        Criteria criatira = new Criteria();
        criatira.andOperator(Criteria.where("dataName").is(hiDataQueryInfo.getDataName()),
                Criteria.where("dataCycle").is(hiDataQueryInfo.getDataCycle()));

        HiDataCommon hiData = this.mongoService.selectOne(HiDataCommon.class, query(criatira));
        return hiData;
    }

}
