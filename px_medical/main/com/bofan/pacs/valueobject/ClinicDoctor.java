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
 * 
 * @Description: 临床医生实体
 * @author lqw
 * @date 2017-09-26 
 * @version V1.0
 */
@Entity
@Table(name = "CLINIC_DOCTOR", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "CLINIC_DOCTOR_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".CLINIC_DOCTOR_ID", allocationSize=1)
public class ClinicDoctor {

	// Fields

	/**  临床医生表主键  */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLINIC_DOCTOR_ID")
	@Column(name = "CLINIC_DOCTOR_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long clinicDoctorId;
	
	/** 临床科室标识  */
	@Column(name = "CLINIC_DEP_NUM", precision = 18, scale = 0)
	private Long clinicDepNum;
	
	/** 临床医生标识  */
	@Column(name = "CLINIC_DOCTOR_NUM", nullable = false, precision = 18, scale = 0)
	private Long clinicDoctorNum;
	
	/** 临床医生姓名  */
	@Column(name = "CLINIC_DOCTOR_NAME", nullable = false, length = 30)
	private String clinicDoctorName;
	
	/** 排序  */
	@Column(name = "SORT", precision = 18, scale = 0)
	private Long sort;
	
	/** 影像科室标识  */
	@Column(name = "IMAGE_DEPT_NUM", precision = 18, scale = 0)
	private Long imageDeptNum;
	
	/** 医院标识不同的医院分配不同的标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	@Column(name = "HT_FS_PACS_MARK", nullable = false, length = 1)
	private String htFsPacsMark;

	// Constructors

	/** default constructor */
	public ClinicDoctor() {
	}

	/** minimal constructor */
	public ClinicDoctor(Long clinicDoctorId, Long clinicDoctorNum,
			String clinicDoctorName, String hospitalNo, String htFsPacsMark) {
		this.clinicDoctorId = clinicDoctorId;
		this.clinicDoctorNum = clinicDoctorNum;
		this.clinicDoctorName = clinicDoctorName;
		this.hospitalNo = hospitalNo;
		this.htFsPacsMark = htFsPacsMark;
	}

	/** full constructor */
	public ClinicDoctor(Long clinicDoctorId, Long clinicDepNum,
			Long clinicDoctorNum, String clinicDoctorName, Long sort,
			Long imageDeptNum, String hospitalNo, String htFsPacsMark) {
		this.clinicDoctorId = clinicDoctorId;
		this.clinicDepNum = clinicDepNum;
		this.clinicDoctorNum = clinicDoctorNum;
		this.clinicDoctorName = clinicDoctorName;
		this.sort = sort;
		this.imageDeptNum = imageDeptNum;
		this.hospitalNo = hospitalNo;
		this.htFsPacsMark = htFsPacsMark;
	}

	// Property accessors
	
	public Long getClinicDoctorId() {
		return this.clinicDoctorId;
	}

	public void setClinicDoctorId(Long clinicDoctorId) {
		this.clinicDoctorId = clinicDoctorId;
	}

	public Long getClinicDepNum() {
		return this.clinicDepNum;
	}

	public void setClinicDepNum(Long clinicDepNum) {
		this.clinicDepNum = clinicDepNum;
	}
	
	public Long getClinicDoctorNum() {
		return this.clinicDoctorNum;
	}

	public void setClinicDoctorNum(Long clinicDoctorNum) {
		this.clinicDoctorNum = clinicDoctorNum;
	}
	
	public String getClinicDoctorName() {
		return this.clinicDoctorName;
	}

	public void setClinicDoctorName(String clinicDoctorName) {
		this.clinicDoctorName = clinicDoctorName;
	}

	public Long getSort() {
		return this.sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}
	
	public Long getImageDeptNum() {
		return this.imageDeptNum;
	}

	public void setImageDeptNum(Long imageDeptNum) {
		this.imageDeptNum = imageDeptNum;
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