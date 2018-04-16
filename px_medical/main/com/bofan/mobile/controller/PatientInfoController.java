package com.bofan.mobile.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.his.command.OutpatientInhospitalQueryInfo;
import com.bofan.his.controller.PatientController;
import com.bofan.his.service.OutpatientInhospitalService;
import com.bofan.his.valueobject.OutpatientInhospital;
import com.bofan.his.valueobject.Patient;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.Tools;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-11-24
 */
@Controller
@RequestMapping("/mobile.patient")
public class PatientInfoController extends PatientController {

    @Autowired
    private OutpatientInhospitalService outInhospitalService;
    
    /**
     * 
     * @param patientId
     * @param model
     * @return
     */
    @RequestMapping("/showPatientInfo.do")
    @ResponseBody
    public Map<String, Object> showPatientInfo(Long patientId, Model model) {
        Map<String, Object> result = new HashMap<String, Object>();
        super.showPatient(patientId, model);
        Map<String, Object> dataMap = model.asMap();
        result.putAll(dataMap);
        return result;
    }
    
    /**
     * 
     * @param patientId
     * @param model
     * @return
     */
    @RequestMapping("/showOutPatientInfo.do")
    @ResponseBody
    public Map<String, Object> showOutPatientInfo(Long outpatientInhospitalId) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (!Tools.isNotEmptyLong(outpatientInhospitalId)) {
            return result;
        }
        OutpatientInhospital outpatientInhospital = this.outInhospitalService.selectAObject(OutpatientInhospital.class,outpatientInhospitalId);
        if (null != outpatientInhospital && null != outpatientInhospital.getPatientId()) {
            result.put("patient", this.outInhospitalService.selectAObject(Patient.class, outpatientInhospital.getPatientId()));
        }
        result.put("outpatient", outpatientInhospital);
        return result;
    }

    /**
     * @see com.bofan.his.controller.PatientController#listData(javax.servlet.http.HttpServletRequest, com.bofan.his.command.PatientQueryInfo)
     */
    @RequestMapping("/patientList.do")
    @ResponseBody
    public Map<String, Object> listData(HttpServletRequest request, OutpatientInhospitalQueryInfo info) {
        Map<String, Object> result = new HashMap<String, Object>();
        SysUserInfo sysUserInfo = (SysUserInfo)request.getSession().getAttribute( Constants.USER_KEY);
        info.setOrgId(sysUserInfo.getSysOrg().getUnitOrgId());//查询本院的患者
        info.setDiagnosisFlag(Contstants.DIAGNOSIS_FLAG_NONE);//未进行远程诊断的
        Page page = this.outInhospitalService.selectOutpatientInhospitalList(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }


    /**
     * @see com.bofan.his.controller.PatientController#selectPatient(java.lang.Long, java.lang.Long)
     */
    @RequestMapping("/getPatient.do")
    @ResponseBody
    public JsonObj getPatient(Long patientId) {
        return super.selectPatient(patientId);
       
    }

}
