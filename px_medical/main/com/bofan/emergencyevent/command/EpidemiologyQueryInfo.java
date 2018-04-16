package com.bofan.emergencyevent.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 流行病学记录查询
 * @author lqw
 */
@QueryInfo(from = "com.bofan.emergencyevent.valueobject.Epidemiology ", orderBy = "epidemiologyId desc")
public class EpidemiologyQueryInfo extends BaseCommandInfo {
	
    private static final long serialVersionUID = -5540536874297793573L;
    
    /** 患者姓名 */
    @QueryParam(fieldName = "epi.patient.name", op = QueryOperator.LIKE)
  	private String patientName;
    
    /** 病人属于 1：本县区 2：本市其他县区 3：本省其他地市 4：外省 5：港澳台 6：外籍 */
    @QueryParam(fieldName = "epi.patientBelong", op = QueryOperator.EQU)
	private String patientBelong;
	
	/** 病历分类 01=疑似病例 02=临床诊断病例 03=实验室确诊病例 04=病原携带者 05=阳性检测病例 06=急性乙型肝炎 07=慢性乙型肝炎 08=急性丙肝 09=慢性丙肝 10=急性吸血虫病 11=慢性吸血虫病 */
    @QueryParam(fieldName = "epi.medicalClassify", op = QueryOperator.EQU)
	private String medicalClassify;

    /** 填写日期开始时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "epi.fillTime", op = QueryOperator.GT_EQU)
    private Date fillTimeStart;
    
    /** 填写日期结束时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    @QueryParam(fieldName = "epi.fillTime", op = QueryOperator.LESS_EQU)
    private Date fillTimeEnd;
    
	/**
	 * @return patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName 要设置的 patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * @return patientBelong
	 */
	public String getPatientBelong() {
		return patientBelong;
	}

	/**
	 * @param patientBelong 要设置的 patientBelong
	 */
	public void setPatientBelong(String patientBelong) {
		this.patientBelong = patientBelong;
	}

	/**
	 * @return medicalClassify
	 */
	public String getMedicalClassify() {
		return medicalClassify;
	}

	/**
	 * @param medicalClassify 要设置的 medicalClassify
	 */
	public void setMedicalClassify(String medicalClassify) {
		this.medicalClassify = medicalClassify;
	}

	/**
	 * @return fillTimeStart
	 */
	public Date getFillTimeStart() {
		return fillTimeStart;
	}

	/**
	 * @param fillTimeStart 要设置的 fillTimeStart
	 */
	public void setFillTimeStart(Date fillTimeStart) {
		this.fillTimeStart = fillTimeStart;
	}

	/**
	 * @return fillTimeEnd
	 */
	public Date getFillTimeEnd() {
		return fillTimeEnd;
	}

	/**
	 * @param fillTimeEnd 要设置的 fillTimeEnd
	 */
	public void setFillTimeEnd(Date fillTimeEnd) {
		this.fillTimeEnd = fillTimeEnd;
	}
}
