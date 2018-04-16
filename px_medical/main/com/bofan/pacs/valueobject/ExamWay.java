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
 * @Description: exam_way (检查方式)实体
 * @author lqw
 * @date 2017-09-26
 * @version V1.0
 */
@Entity
@Table(name = "EXAM_WAY", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "EXAM_WAY_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".EXAM_WAY_ID", allocationSize=1)
public class ExamWay {

	// Fields

	/** 检查方式ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAM_WAY_ID")
	@Column(name = "EXAM_WAY_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long examWayId;
	
	/** 检查方式标识 */
	@Column(name = "EXAM_WAY_NUM", nullable = false, precision = 18, scale = 0)
	private Long examWayNum;
	
	/** 检查方式 */
	@Column(name = "EXAM_WAY", nullable = false, length = 50)
	private String examWay;
	
	/** 排序 */
	@Column(name = "SORT", nullable = false, precision = 18, scale = 0)
	private Long sort;
	
	/** 科室标识 */
	@Column(name = "DEPARTMENT_NUM", precision = 18, scale = 0)
	private Long departmentNum;
	
	/** 医院标识不同的医院分配不同的标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	@Column(name = "HT_FS_PACS_MARK", nullable = false, length = 1)
	private String htFsPacsMark;

	// Constructors

	/** default constructor */
	public ExamWay() {
	}

	/** minimal constructor */
	public ExamWay(Long examWayId, Long examWayNum, String examWay, Long sort,
			String hospitalNo, String htFsPacsMark) {
		this.examWayId = examWayId;
		this.examWayNum = examWayNum;
		this.examWay = examWay;
		this.sort = sort;
		this.hospitalNo = hospitalNo;
		this.htFsPacsMark = htFsPacsMark;
	}

	/** full constructor */
	public ExamWay(Long examWayId, Long examWayNum, String examWay, Long sort,
			Long departmentNum, String hospitalNo, String htFsPacsMark) {
		this.examWayId = examWayId;
		this.examWayNum = examWayNum;
		this.examWay = examWay;
		this.sort = sort;
		this.departmentNum = departmentNum;
		this.hospitalNo = hospitalNo;
		this.htFsPacsMark = htFsPacsMark;
	}

	// Property accessors

	public Long getExamWayId() {
		return this.examWayId;
	}

	public void setExamWayId(Long examWayId) {
		this.examWayId = examWayId;
	}

	public Long getExamWayNum() {
		return this.examWayNum;
	}

	public void setExamWayNum(Long examWayNum) {
		this.examWayNum = examWayNum;
	}

	public String getExamWay() {
		return this.examWay;
	}

	public void setExamWay(String examWay) {
		this.examWay = examWay;
	}

	public Long getSort() {
		return this.sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public Long getDepartmentNum() {
		return this.departmentNum;
	}

	public void setDepartmentNum(Long departmentNum) {
		this.departmentNum = departmentNum;
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