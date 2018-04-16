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
 * @Description: lis_inspection_group（检验分组信息表）
 * @author lqw
 * @date 2017-10-09
 */
@Entity
@Table(name = "LIS_INSPECTION_GROUP", schema = SchemaConsts.LIS_CLOUD)
@SequenceGenerator(name = "LIS_INSPECTION_GROUP_ID", sequenceName = SchemaConsts.LIS_CLOUD + ".LIS_INSPECTION_GROUP_ID", allocationSize=1)
public class LisInspectionGroup {

	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIS_INSPECTION_GROUP_ID")
	@Column(name = "LIS_INSPECTION_GROUP_ID", unique = true, nullable = false, length = 10)
	private Long lisInspectionGroupId;
	
	/** 医院（医疗机构）标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_No", nullable = false, length = 40)
	private String hospitalNo;
	
	/** 分组ID */
	@Column(name = "GROUP_ID", nullable = false, length = 10)
	private String groupId;
	
	/** 分组代码 */
	@Column(name = "GROUP_CODE", length = 20)
	private String groupCode;
	
	/** 分组序号 */
	@Column(name = "GROUP_SORT", length = 20)
	private String groupSort;
	
	/** 分组名称 */
	@Column(name = "GROUP_NAME", length = 50)
	private String groupName;
	
	/** 所属科室 */
	@Column(name = "INSPECTION_DEPT", length = 20)
	private String inspectionDept;
	
	/** 分组类型 */
	@Column(name = "GROUP_CLASS", length = 20)
	private String groupClass;
	
	/** 老系统代码 */
	@Column(name = "LIS_ID", length = 20)
	private String lisId;
	
	/** 附加项目 */
	@Column(name = "TEST_ITEM_APPEND", length = 20)
	private String testItemAppend;
	
	/** 显示格式 */
	@Column(name = "ITEM_DISPLAY", length = 20)
	private String itemDisplay;
	
	/** 起始样本号 */
	@Column(name = "START_NO", length = 2)
	private String startNo;
	
	/** 开始焦点 */
	@Column(name = "START_FOCUS", length = 20)
	private String startFocus;
	
	/** 结果回顾 */
	@Column(name = "RESULT_REVIEW", length = 20)
	private String resultReview;
	
	/** 同类分组 */
	@Column(name = "SAME_GROUP", length = 100)
	private String sameGroup;
	
	/** 图形格式 */
	@Column(name = "GRAPH_FORMAT", length = 50)
	private String graphFormat;
	
	/** graph_switch_file */
	@Column(name = "GRAPH_SWITCH_FILE", length = 50)
	private String graphSwitchFile;
	
	/** 状态 */
	@Column(name = "STATE_FLAG", length = 2)
	private String stateFlag;

	// Constructors

	/** default constructor */
	public LisInspectionGroup() {
	}

	// Property accessors
	
	/**
	 * @return groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @return lisInspectionGroupId
	 */
	public Long getLisInspectionGroupId() {
		return lisInspectionGroupId;
	}

	/**
	 * @param lisInspectionGroupId 要设置的 lisInspectionGroupId
	 */
	public void setLisInspectionGroupId(Long lisInspectionGroupId) {
		this.lisInspectionGroupId = lisInspectionGroupId;
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
	 * @param groupId 要设置的 groupId
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return groupCode
	 */
	public String getGroupCode() {
		return groupCode;
	}

	/**
	 * @param groupCode 要设置的 groupCode
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	/**
	 * @return groupSort
	 */
	public String getGroupSort() {
		return groupSort;
	}

	/**
	 * @param groupSort 要设置的 groupSort
	 */
	public void setGroupSort(String groupSort) {
		this.groupSort = groupSort;
	}

	/**
	 * @return groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName 要设置的 groupName
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return inspectionDept
	 */
	public String getInspectionDept() {
		return inspectionDept;
	}

	/**
	 * @param inspectionDept 要设置的 inspectionDept
	 */
	public void setInspectionDept(String inspectionDept) {
		this.inspectionDept = inspectionDept;
	}

	/**
	 * @return groupClass
	 */
	public String getGroupClass() {
		return groupClass;
	}

	/**
	 * @param groupClass 要设置的 groupClass
	 */
	public void setGroupClass(String groupClass) {
		this.groupClass = groupClass;
	}

	/**
	 * @return lisId
	 */
	public String getLisId() {
		return lisId;
	}

	/**
	 * @param lisId 要设置的 lisId
	 */
	public void setLisId(String lisId) {
		this.lisId = lisId;
	}

	/**
	 * @return testItemAppend
	 */
	public String getTestItemAppend() {
		return testItemAppend;
	}

	/**
	 * @param testItemAppend 要设置的 testItemAppend
	 */
	public void setTestItemAppend(String testItemAppend) {
		this.testItemAppend = testItemAppend;
	}

	/**
	 * @return itemDisplay
	 */
	public String getItemDisplay() {
		return itemDisplay;
	}

	/**
	 * @param itemDisplay 要设置的 itemDisplay
	 */
	public void setItemDisplay(String itemDisplay) {
		this.itemDisplay = itemDisplay;
	}

	/**
	 * @return startNo
	 */
	public String getStartNo() {
		return startNo;
	}

	/**
	 * @param startNo 要设置的 startNo
	 */
	public void setStartNo(String startNo) {
		this.startNo = startNo;
	}

	/**
	 * @return startFocus
	 */
	public String getStartFocus() {
		return startFocus;
	}

	/**
	 * @param startFocus 要设置的 startFocus
	 */
	public void setStartFocus(String startFocus) {
		this.startFocus = startFocus;
	}

	/**
	 * @return resultReview
	 */
	public String getResultReview() {
		return resultReview;
	}

	/**
	 * @param resultReview 要设置的 resultReview
	 */
	public void setResultReview(String resultReview) {
		this.resultReview = resultReview;
	}

	/**
	 * @return sameGroup
	 */
	public String getSameGroup() {
		return sameGroup;
	}

	/**
	 * @param sameGroup 要设置的 sameGroup
	 */
	public void setSameGroup(String sameGroup) {
		this.sameGroup = sameGroup;
	}

	/**
	 * @return graphFormat
	 */
	public String getGraphFormat() {
		return graphFormat;
	}

	/**
	 * @param graphFormat 要设置的 graphFormat
	 */
	public void setGraphFormat(String graphFormat) {
		this.graphFormat = graphFormat;
	}

	/**
	 * @return graphSwitchFile
	 */
	public String getGraphSwitchFile() {
		return graphSwitchFile;
	}

	/**
	 * @param graphSwitchFile 要设置的 graphSwitchFile
	 */
	public void setGraphSwitchFile(String graphSwitchFile) {
		this.graphSwitchFile = graphSwitchFile;
	}

	/**
	 * @return stateFlag
	 */
	public String getStateFlag() {
		return stateFlag;
	}

	/**
	 * @param stateFlag 要设置的 stateFlag
	 */
	public void setStateFlag(String stateFlag) {
		this.stateFlag = stateFlag;
	}

}