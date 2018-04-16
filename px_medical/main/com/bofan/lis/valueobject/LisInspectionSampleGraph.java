package com.bofan.lis.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: lis_inspection_sample_graph（检验样本图片信息表）
 * @author lqw
 * @date 2017-10-09
 */
@Entity
@Table(name = "LIS_INSPECTION_SAMPLE_GRAPH", schema = SchemaConsts.LIS_CLOUD)
@SequenceGenerator(name = "LIS_INSPECTION_SAMPLE_GRAPH_ID", sequenceName = SchemaConsts.LIS_CLOUD + ".LIS_INSPECTION_SAMPLE_GRAPH_ID", allocationSize=1)
public class LisInspectionSampleGraph {

	// Fields
	
    /** 检验样本图片信息ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIS_INSPECTION_SAMPLE_GRAPH_ID")
	@Column(name = "LIS_INSPECTION_SAMPLE_GRAPH_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long lisInspectionSampleGraphId;

    /** 医院（医疗机构）标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;

    /** 检验单ID 原表主键ID */
	@Column(name = "INSPECTION_ID", nullable = false, length = 20)
	private String inspectionId;
	
	/**	检验时间	*/
	@Column(name = "INSPECTION_TIME", nullable = false)
	private Date inspectionTime;

    /** 检验仪器 */
	@Column(name = "INSPECTION_INSTRUMENT", nullable = false, length = 50)
	private String inspectionInstrument;
	
    /** 图片类型 */
	@Column(name = "GRAPH_FORMAT", length = 100)
	private String graphFormat;

    /** 图片路径 */
	@Column(name = "GRAPH_PATH", length = 100)
	private String graphPath;

	   /** 图象标识 */
    @Column(name = "PATIENT_IMAGE_NUM", precision = 18, scale = 0)
    private Long patientImageNum;
    
    /** 图片名称 */
	@Column(name = "GRAPH_NAME", length = 20)
	private String graphName;
	
	/** bdb保存路径 */
	@Column(name = "SAVE_PATH", length = 100)
	private String savePath;

	/** bdb数据库关键字 */
	@Column(name = "BDB_KEY", unique = true, length = 50)
	private String bdbKey;

    /** 备注 */
	@Column(name = "REMARK", length = 100)
	private String remark;


	/** default constructor */
	public LisInspectionSampleGraph() {
	}
	 
	
	public String getHospitalNo() {
		return this.hospitalNo;
	}

	/**
	 * @return lisInspectionSampleGraphId
	 */
	public Long getLisInspectionSampleGraphId() {
		return lisInspectionSampleGraphId;
	}

	/**
	 * @param lisInspectionSampleGraphId 要设置的 lisInspectionSampleGraphId
	 */
	public void setLisInspectionSampleGraphId(Long lisInspectionSampleGraphId) {
		this.lisInspectionSampleGraphId = lisInspectionSampleGraphId;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}
	
	public String getInspectionId() {
		return this.inspectionId;
	}

	public void setInspectionId(String inspectionId) {
		this.inspectionId = inspectionId;
	}
	
	/**
	 * @return inspectionTime
	 */
	public Date getInspectionTime() {
		return inspectionTime;
	}

	/**
	 * @param inspectionTime 要设置的 inspectionTime
	 */
	public void setInspectionTime(Date inspectionTime) {
		this.inspectionTime = inspectionTime;
	}

	public String getInspectionInstrument() {
		return this.inspectionInstrument;
	}

	public void setInspectionInstrument(String inspectionInstrument) {
		this.inspectionInstrument = inspectionInstrument;
	}
	
	public String getGraphFormat() {
		return this.graphFormat;
	}

	public void setGraphFormat(String graphFormat) {
		this.graphFormat = graphFormat;
	}

	public String getGraphPath() {
		return this.graphPath;
	}

	public void setGraphPath(String graphPath) {
		this.graphPath = graphPath;
	}

	/**
     * @return patientImageNum
     */
    public Long getPatientImageNum() {
        return patientImageNum;
    }


    /**
     * @param patientImageNum 要设置的 patientImageNum
     */
    public void setPatientImageNum(Long patientImageNum) {
        this.patientImageNum = patientImageNum;
    }


    public String getGraphName() {
		return this.graphName;
	}

	public void setGraphName(String graphName) {
		this.graphName = graphName;
	}
	
	/**
     * @return the savePath
     */
    public String getSavePath() {
        return savePath;
    }

    /**
     * @param savePath the savePath to set
     */
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getBdbKey() {
		return this.bdbKey;
	}

	public void setBdbKey(String bdbKey) {
		this.bdbKey = bdbKey;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}