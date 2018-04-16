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
 * @Description: image_dept（影像科室表）实体
 * @author lqw
 * @date 2017-09-26
 * @version V1.0
 */
@Entity
@Table(name = "IMAGE_DEPT", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "IMAGE_DEPT_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".IMAGE_DEPT_ID", allocationSize=1)
public class ImageDept {

	// Fields

	/** 影像科室主键ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IMAGE_DEPT_ID")
	@Column(name = "IMAGE_DEPT_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long imageDeptId;
	
	/** 影像科室标识 */
	@Column(name = "IMAGE_DEPT_NUM", nullable = false, precision = 18, scale = 0)
	private Long imageDeptNum;
	
	/** 影像科室名称 */
	@Column(name = "IMAGE_DEP_NAME", nullable = false, length = 64)
	private String imageDepName;
	
	/** 影像科室标志 */
	@Column(name = "IMAGE_DEP_MARK", length = 50)
	private String imageDepMark;
	
	/** 当日流水号 */
	@Column(name = "SERIES_NUM", precision = 18, scale = 0)
	private Long seriesNum;
	
	/** 医院标识不同的医院分配不同的标识 对应sys_org表中org_no字段*/
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	@Column(name = "HT_FS_PACS_MARK", nullable = false, length = 1)
	private String htFsPacsMark;

	// Constructors

	/** default constructor */
	public ImageDept() {
	}

	/** minimal constructor */
	public ImageDept(Long imageDeptId, Long imageDeptNum, String imageDepName,
			String hospitalNo, String htFsPacsMark) {
		this.imageDeptId = imageDeptId;
		this.imageDeptNum = imageDeptNum;
		this.imageDepName = imageDepName;
		this.hospitalNo = hospitalNo;
		this.htFsPacsMark = htFsPacsMark;
	}

	/** full constructor */
	public ImageDept(Long imageDeptId, Long imageDeptNum, String imageDepName,
			String imageDepMark, Long seriesNum, String hospitalNo,
			String htFsPacsMark) {
		this.imageDeptId = imageDeptId;
		this.imageDeptNum = imageDeptNum;
		this.imageDepName = imageDepName;
		this.imageDepMark = imageDepMark;
		this.seriesNum = seriesNum;
		this.hospitalNo = hospitalNo;
		this.htFsPacsMark = htFsPacsMark;
	}

	// Property accessors

	public Long getImageDeptId() {
		return this.imageDeptId;
	}

	public void setImageDeptId(Long imageDeptId) {
		this.imageDeptId = imageDeptId;
	}

	public Long getImageDeptNum() {
		return this.imageDeptNum;
	}

	public void setImageDeptNum(Long imageDeptNum) {
		this.imageDeptNum = imageDeptNum;
	}

	public String getImageDepName() {
		return this.imageDepName;
	}

	public void setImageDepName(String imageDepName) {
		this.imageDepName = imageDepName;
	}

	public String getImageDepMark() {
		return this.imageDepMark;
	}

	public void setImageDepMark(String imageDepMark) {
		this.imageDepMark = imageDepMark;
	}

	public Long getSeriesNum() {
		return this.seriesNum;
	}

	public void setSeriesNum(Long seriesNum) {
		this.seriesNum = seriesNum;
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