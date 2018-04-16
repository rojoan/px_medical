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
 * @Description: 临床信息实体
 * @author lqw
 * @date 2017-09-26
 * @version V1.0
 */
@Entity
@Table(name = "CLINIC_DETAIL", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "CLINIC_DETAIL_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".CLINIC_DETAIL_ID", allocationSize=1)
public class ClinicDetail {

	// Fields

	/**  临床信息主键ID  */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLINIC_DETAIL_ID")
	@Column(name = "CLINIC_DETAIL_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long clinicDetailId;
	
	/**  临床信息标识  */
	@Column(name = "CLINIC_INFO_NUM", nullable = false, precision = 18, scale = 0)
	private Long clinicInfoNum;
	
	/**  临床信息  */
	@Column(name = "CLINIC_CONTENT")
	private String clinicContent;
	
	/**  类型标识  */
	@Column(name = "CLINICF_TYPE", precision = 18, scale = 0)
	private Long clinicfType;
	
	/**  科室标识  */
	@Column(name = "DEPARTMENT_NUM", precision = 18, scale = 0)
	private Long departmentNum;
	
	/**  排序  */
	@Column(name = "SORT", precision = 18, scale = 0)
	private Long sort;
	
	/**  医院标识不同的医院分配不同的标识  对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	 /**  ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS  */
	@Column(name = "HT_FS_PACS_MARK", nullable = false, length = 1)
	private String htFsPacsMark;

	// Constructors

	/** default constructor */
	public ClinicDetail() {
	}

	/** minimal constructor */
	public ClinicDetail(Long clinicDetailId, Long clinicInfoNum,
			String hospitalNo, String htFsPacsMark) {
		this.clinicDetailId = clinicDetailId;
		this.clinicInfoNum = clinicInfoNum;
		this.hospitalNo = hospitalNo;
		this.htFsPacsMark = htFsPacsMark;
	}

	 
	// Property accessors
	/**
	 * @return the clinicDetailId
	 */
	public Long getClinicDetailId() {
		return clinicDetailId;
	}

	/**
	 * @param clinicDetailId the clinicDetailId to set
	 */
	public void setClinicDetailId(Long clinicDetailId) {
		this.clinicDetailId = clinicDetailId;
	}
	
	public Long getClinicInfoNum() {
		return this.clinicInfoNum;
	}
	

	public void setClinicInfoNum(Long clinicInfoNum) {
		this.clinicInfoNum = clinicInfoNum;
	}
	
	public String getClinicContent() {
		return this.clinicContent;
	}

	public void setClinicContent(String clinicContent) {
		this.clinicContent = clinicContent;
	}
	
	public Long getClinicfType() {
		return this.clinicfType;
	}

	public void setClinicfType(Long clinicfType) {
		this.clinicfType = clinicfType;
	}
	
	public Long getDepartmentNum() {
		return this.departmentNum;
	}

	public void setDepartmentNum(Long departmentNum) {
		this.departmentNum = departmentNum;
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