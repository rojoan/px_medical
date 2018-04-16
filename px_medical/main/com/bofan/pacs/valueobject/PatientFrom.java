package com.bofan.pacs.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: patient_from（病人来源类型表）实体
 * @author lqw
 * @date 2017-09-26
 * @version V1.0
 */
@Entity
@Table(name = "PATIENT_FROM", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "PATIENT_FROM_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".PATIENT_FROM_ID", allocationSize=1)
public class PatientFrom {

	// Fields

	/** 病人来源ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT_FROM_ID")
	@Column(name = "PATIENT_FROM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long patientFromId;
	
	/** 病人来源标识 */
	@Column(name = "PATIENT_FROM_NUM", nullable = false, precision = 18, scale = 0)
	private Long patientFromNum;
	
	/** 病人来源 */
	@Column(name = "PATIENT_FROM", nullable = false, length = 12)
	private String patientFrom;
	
	/** 影像科室标识 */
	@Column(name = "IMAGE_DEPT_NUM", precision = 18, scale = 0)
	private Long imageDeptNum;
	
	/** 显示顺序 */
	@Column(name = "SORT", precision = 18, scale = 0)
	private Long sort;
	
	/** 医院标识不同的医院分配不同的标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	@Column(name = "HT_FS_PACS_MARK", nullable = false, length = 1)
	private String htFsPacsMark;

	// Constructors

	/** default constructor */
	public PatientFrom() {
	}

	/**
	 * @return patientFromId
	 */
	public Long getPatientFromId() {
		return patientFromId;
	}

	/**
	 * @param patientFromId 要设置的 patientFromId
	 */
	public void setPatientFromId(Long patientFromId) {
		this.patientFromId = patientFromId;
	}

	/**
	 * @return patientFromNum
	 */
	public Long getPatientFromNum() {
		return patientFromNum;
	}

	/**
	 * @param patientFromNum 要设置的 patientFromNum
	 */
	public void setPatientFromNum(Long patientFromNum) {
		this.patientFromNum = patientFromNum;
	}

	/**
	 * @return patientFrom
	 */
	public String getPatientFrom() {
		return patientFrom;
	}

	/**
	 * @param patientFrom 要设置的 patientFrom
	 */
	public void setPatientFrom(String patientFrom) {
		this.patientFrom = patientFrom;
	}

	/**
	 * @return imageDeptNum
	 */
	public Long getImageDeptNum() {
		return imageDeptNum;
	}

	/**
	 * @param imageDeptNum 要设置的 imageDeptNum
	 */
	public void setImageDeptNum(Long imageDeptNum) {
		this.imageDeptNum = imageDeptNum;
	}

	/**
	 * @return sort
	 */
	public Long getSort() {
		return sort;
	}

	/**
	 * @param sort 要设置的 sort
	 */
	public void setSort(Long sort) {
		this.sort = sort;
	}

	/**
	 * @return hospitalNo
	 */
	public String getHospitalNo() {
		return hospitalNo;
	}

	/**
	 * @param hospitalNo 要设置的 hospitalNo
	 */
	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	/**
	 * @return htFsPacsMark
	 */
	public String getHtFsPacsMark() {
		return htFsPacsMark;
	}

	/**
	 * @param htFsPacsMark 要设置的 htFsPacsMark
	 */
	public void setHtFsPacsMark(String htFsPacsMark) {
		this.htFsPacsMark = htFsPacsMark;
	}
}