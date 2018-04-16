package com.bofan.lis.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * @Description: lis_inspection_sample_explain（检验样本结果解释表）
 * @author lqw
 */
@Entity
@Table(name = "LIS_INSPECTION_SAMPLE_EXPLAIN", schema = SchemaConsts.LIS_CLOUD)
@SequenceGenerator(name = "LIS_INSPECT_SAMPLE_EXPLAIN_ID", sequenceName = SchemaConsts.LIS_CLOUD + ".LIS_INSPECT_SAMPLE_EXPLAIN_ID", allocationSize=1)
public class LisInspectionSampleExplain {

    // Fields
    /** 基础数据--一般检验ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIS_INSPECT_SAMPLE_EXPLAIN_ID")
    @Column(name = "LIS_INSPECT_SAMPLE_EXPLAIN_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long lisInspectSampleExplainId;
    
    /** 医院（医疗机构）标识 对应sys_org表中org_no字段 */
    @Column(name = "HOSPITAL_No", nullable = false, length = 40)
    private String hospitalNo;
    
    /**  检验单ID，原主键ID */
    @Column(name = "INSPECTION_ID", nullable = false, length = 30)
    private String inspectionId;
    
    /** 结果解释代码，原主键ID */
    @Column(name = "EXPLAIN_ID", nullable = false, length = 20)
    private String explainId;

    /** 结果解释内容 */
    @Column(name = "EXPLAIN", length = 4000)
    private String explain;

    /**
     * 
     */
    public LisInspectionSampleExplain() {
    }

    /**
     * @return the lisInspectSampleExplainId
     */
    public Long getLisInspectSampleExplainId() {
        return lisInspectSampleExplainId;
    }

    /**
     * @param lisInspectSampleExplainId the lisInspectSampleExplainId to set
     */
    public void setLisInspectSampleExplainId(Long lisInspectSampleExplainId) {
        this.lisInspectSampleExplainId = lisInspectSampleExplainId;
    }

    /**
     * @return the hospitalNo
     */
    public String getHospitalNo() {
        return hospitalNo;
    }

    /**
     * @param hospitalNo the hospitalNo to set
     */
    public void setHospitalNo(String hospitalNo) {
        this.hospitalNo = hospitalNo;
    }


    /**
     * @return the inspectionId
     */
    public String getInspectionId() {
        return inspectionId;
    }

    /**
     * @param inspectionId the inspectionId to set
     */
    public void setInspectionId(String inspectionId) {
        this.inspectionId = inspectionId;
    }

    /**
     * @return the explainId
     */
    public String getExplainId() {
        return explainId;
    }

    /**
     * @param explainId the explainId to set
     */
    public void setExplainId(String explainId) {
        this.explainId = explainId;
    }

    /**
     * @return the explain
     */
    public String getExplain() {
        return explain;
    }

    /**
     * @param explain the explain to set
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }
    
}