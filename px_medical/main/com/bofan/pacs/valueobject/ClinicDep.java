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
 * @Description: 临床科室
 * @author lqw
 * @date 2017-09-26
 * @version V1.0
 */
@Entity
@Table(name = "CLINIC_DEP", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "CLINIC_DEP_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".CLINIC_DEP_ID", allocationSize=1)
public class ClinicDep {

	// Fields
	
	/** 临床科室主键ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLINIC_DEP_ID")
	@Column(name = "CLINIC_DEP_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long clinicDepId;
	
	/** 临床科室标识 */
	@Column(name = "CLINIC_DEP_NUM", nullable = false, precision = 18, scale = 0)
	private Long clinicDepNum;
	
	/** 科室名称 */
	@Column(name = "DEPT_NAME", nullable = false, length = 64)
	private String deptName;
	
	/** 病人来源标识 */
	@Column(name = "PATIENT_FROM_NUM", precision = 18, scale = 0)
	private Long patientFromNum;
	
	/** 影像科室标识 */
	@Column(name = "IMAGE_DEPT_NUM", precision = 18, scale = 0)
	private Long imageDeptNum;
	
	/** 排序 */
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
	public ClinicDep() {
	}

	// Property accessors
	
	public Long getClinicDepId() {
		return this.clinicDepId;
	}

	public void setClinicDepId(Long clinicDepId) {
		this.clinicDepId = clinicDepId;
	}

	public Long getClinicDepNum() {
		return this.clinicDepNum;
	}

	public void setClinicDepNum(Long clinicDepNum) {
		this.clinicDepNum = clinicDepNum;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Long getPatientFromNum() {
		return this.patientFromNum;
	}

	public void setPatientFromNum(Long patientFromNum) {
		this.patientFromNum = patientFromNum;
	}

	public Long getImageDeptNum() {
		return this.imageDeptNum;
	}

	public void setImageDeptNum(Long imageDeptNum) {
		this.imageDeptNum = imageDeptNum;
	}
	
	public Long getSort() {
		return this.sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}
	
	public String getHospitalNo() {
		return this.hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	
	public String getHtFsPacsMark() {
		return this.htFsPacsMark;
	}

	public void setHtFsPacsMark(String htFsPacsMark) {
		this.htFsPacsMark = htFsPacsMark;
	}

}