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
 * @Description: 检查部位实体
 * @author lqw
 * @date 2017-09-26 
 * @version V1.0
 */
@Entity
@Table(name = "EXAM_PART", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "EXAM_PART_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".EXAM_PART_ID", allocationSize=1)
public class ExamPart {

	// Fields

	/** 检查部位ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAM_PART_ID")
	@Column(name = "EXAM_PART_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long examPartId;
	
	/** 检查部位标识 */
	@Column(name = "EXAM_PART_NUM", nullable = false, precision = 18, scale = 0)
	private Long examPartNum;
	
	/** 科室标识 */
	@Column(name = "EXAM_DEP_NUM", nullable = false, precision = 18, scale = 0)
	private Long examDepNum;
	
	/** 部位名称 */
	@Column(name = "EXAM_PART_NAME", nullable = false, length = 100)
	private String examPartName;
	
	/** 系统 */
	@Column(name = "EXAM_SYSTEM", nullable = false, precision = 18, scale = 0)
	private Long examSystem;
	
	/** 检查费用 */
	@Column(name = "EXAM_COST", length = 20)
	private String examCost;
	
	/** 检查分类 */
	@Column(name = "EXAM_CLASSIFY", length = 32)
	private String examClassify;
	
	/** 分类名称 */
	@Column(name = "EXAM_CLASSIFY_NAME", length = 50)
	private String examClassifyName;
	
	/** 部位代码 */
	@Column(name = "PART_CODE", length = 50)
	private String partCode;
	
	/** 部位描述 */
	@Column(name = "PART_DESCRIPTION", length = 50)
	private String partDescription;
	
	/** 术语节点 */
	@Column(name = "TERM_NODE", length = 32)
	private String termNode;
	
	/** 二级分类 */
	@Column(name = "SECOND_CLASSIFY", length = 32)
	private String secondClassify;
	
	/** 曝光次数 */
	@Column(name = "EXPOSURE_TIMES", precision = 18, scale = 0)
	private Long exposureTimes;
	
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
	public ExamPart() {
	}

	// Property accessors
	public Long getExamPartId() {
		return this.examPartId;
	}

	public void setExamPartId(Long examPartId) {
		this.examPartId = examPartId;
	}

	public Long getExamPartNum() {
		return this.examPartNum;
	}

	public void setExamPartNum(Long examPartNum) {
		this.examPartNum = examPartNum;
	}

	public Long getExamDepNum() {
		return this.examDepNum;
	}

	public void setExamDepNum(Long examDepNum) {
		this.examDepNum = examDepNum;
	}

	public String getExamPartName() {
		return this.examPartName;
	}

	public void setExamPartName(String examPartName) {
		this.examPartName = examPartName;
	}

	public Long getExamSystem() {
		return this.examSystem;
	}

	public void setExamSystem(Long examSystem) {
		this.examSystem = examSystem;
	}

	public String getExamCost() {
		return this.examCost;
	}

	public void setExamCost(String examCost) {
		this.examCost = examCost;
	}

	public String getExamClassify() {
		return this.examClassify;
	}

	public void setExamClassify(String examClassify) {
		this.examClassify = examClassify;
	}

	public String getExamClassifyName() {
		return this.examClassifyName;
	}

	public void setExamClassifyName(String examClassifyName) {
		this.examClassifyName = examClassifyName;
	}

	public String getPartCode() {
		return this.partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getPartDescription() {
		return this.partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public String getTermNode() {
		return this.termNode;
	}

	public void setTermNode(String termNode) {
		this.termNode = termNode;
	}

	public String getSecondClassify() {
		return this.secondClassify;
	}

	public void setSecondClassify(String secondClassify) {
		this.secondClassify = secondClassify;
	}

	public Long getExposureTimes() {
		return this.exposureTimes;
	}

	public void setExposureTimes(Long exposureTimes) {
		this.exposureTimes = exposureTimes;
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