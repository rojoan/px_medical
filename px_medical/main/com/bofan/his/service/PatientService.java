package com.bofan.his.service;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.his.command.PatientEditInfo;
import com.bofan.his.command.PatientHospitalQueryInfo;
import com.bofan.his.command.PatientQueryInfo;
import com.bofan.his.valueobject.Patient;
import com.bofan.his.valueobject.PatientHospital;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * @author lqw
 * @date 2017-10-2
 * @version V1.0
 */
@Service
@Transactional
public class PatientService extends AbstractAnnoCommonService {
	
    /**
	 * 根据条件查询病人信息
	 * 
	 * @param queryInfo
	 * @return
	 */
	public Page selectPatientPage(PatientHospitalQueryInfo info) {
		IQueryObject qo = super.getQueryObject(info);
		return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
	}

	/**
	 * 根据条件查询单个患者信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Patient findPatient(PatientQueryInfo queryInfo) {
		IQueryObject qo = super.getQueryObject(queryInfo);
		List<Patient> list = super.executeSql(qo.getQueryString(),qo.getParam());
		if (Tools.isNotEmptyList(list)) {
			return list.get(0);
		}
		return null;
    }
	
	/**
	 * 根据条件查询患者信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Patient> selectPatientList(PatientQueryInfo queryInfo) {
		IQueryObject qo = super.getQueryObject(queryInfo);
		return super.executeSql(qo.getQueryString(),qo.getParam());
	}

	/**
	 * 保存患者信息
	 * @param editInfo
	 * @return
	 */
	public void savePatient(PatientEditInfo editInfo) {
		Patient patient = null;
		if (null != editInfo.getPatientId()) {
			patient = super.load(Patient.class, editInfo.getPatientId());
		}else{
		    //根据 患者身份标识信息 查询患者信息
		    patient = this.findPatientByPatientIdentity(editInfo);
		    if (null == patient) {
		        patient = new Patient();
		        patient.setCreateDate(new Date());
		        patient.setValidFlag(Contstants.YES_FLAG);
            }
		}
		NullBeanUtils.copyProperties(patient, editInfo);
        super.save(patient);
        
		PatientHospital patientHospital = new PatientHospital();
		if (null !=  editInfo.getPatientHospitalId()) {
		    patientHospital = super.load(PatientHospital.class, editInfo.getPatientHospitalId());
		    patientHospital.setModifyTime(new Date());
		} else{
		    patientHospital.setValidFlag(Contstants.YES_FLAG);
		    editInfo.setPatientId(patient.getPatientId());
		    patientHospital.setCreateTime(new Date());
		}
		
		NullBeanUtils.copyProperties(patientHospital, editInfo);
		super.save(patientHospital);
	}

	/**
     * 根据 患者身份标识信息 查询患者信息
     * @param editInfo
     * @return
     */
    private Patient findPatientByPatientIdentity(PatientEditInfo editInfo) {
        Patient patient = null;
        PatientQueryInfo patientQueryInfo = new PatientQueryInfo();
        if (!Tools.isEmptyString(editInfo.getPatientIdCard())) {
            patientQueryInfo.setOrgId(editInfo.getOrgId());
            patientQueryInfo.setHospitalNo(editInfo.getHospitalNo());
            patientQueryInfo.setPatientIdCardEqu(editInfo.getPatientIdCard());
            patientQueryInfo.setPatientNameEqu(editInfo.getPatientName());
            patient  = this.findPatient(patientQueryInfo);
            if (null != patient) {
                return patient;
            }
        }
        if (!Tools.isEmptyString(editInfo.getInsuranceNo())) {
            patientQueryInfo.setOrgId(editInfo.getOrgId());
            patientQueryInfo.setHospitalNo(editInfo.getHospitalNo());
            patientQueryInfo.setInsuranceNoEqu(editInfo.getInsuranceNo());
            patientQueryInfo.setPatientNameEqu(editInfo.getPatientName());
            patient  = this.findPatient(patientQueryInfo);
            if (null != patient) {
                return patient;
            }
        }
        
        return null;
    }
    
	/**
	 * 删除患者信息
	 * @param patientId
	 * @return
	 */
	public void markInvalid(Long patientHospitalId) {
		if (null == patientHospitalId) {
			return;
		}
		PatientHospital patientHospital = super.load(PatientHospital.class, patientHospitalId);
		if (null != patientHospital) {
			patientHospital.setValidFlag(Contstants.NO_FLAG);
			super.save(patientHospital);
		}
	}
}
