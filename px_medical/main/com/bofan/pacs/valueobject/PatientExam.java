package com.bofan.pacs.valueobject;

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
 * @Description: patient_exam（病人检查表）实体
 * @author lqw
 * @date 2017-09-26
 * @version V1.0
 */
@Entity
@Table(name = "PATIENT_EXAM", schema = SchemaConsts.PACS_SCHEMA)
@SequenceGenerator(name = "PATIENT_EXAM_ID", sequenceName = SchemaConsts.PACS_SCHEMA + ".PATIENT_EXAM_ID", allocationSize=1)
public class PatientExam {

	// Fields

	/** 病人检查主键ID */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT_EXAM_ID")
	@Column(name = "PATIENT_EXAM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long patientExamId;
	
	/** 根据医院编码获取 SysOrg 的org_id */
	@Column(name = "ORG_ID", nullable = false, precision = 18, scale = 0)
	private Long orgId;
	
	/** 病人检查号 */
	@Column(name = "PATIENT_EXAM_NUM", length = 20, nullable = false)
	private String patientExamNum;
	
	/** 病人档案号 */
	@Column(name = "PATIENT_ARCHIVE_NUM", length = 20)
	private String patientArchiveNum;

    /** 患者姓名 */
    @Column(name = "PATIENT_NAME", length = 30, nullable = false)
    private String patientName;

    /** 是否双向转诊-远程会诊 0= 1=已申请转诊 2=已申请远程诊断 */
	@Column(name = "DIAGNOSIS_FLAG", length = 1, nullable = false)
	private String diagnosisFlag;
	
	/** 当日流水号 */
	@Column(name = "EXAM_SERIES_NUM", precision = 18, scale = 0)
	private Long examSeriesNum;
	
	/** 影像科室标识 1=超声 ，2=放射 ，3=内镜 ，4=病理*/
	@Column(name = "IMAGE_DEPT_NUM", precision = 18, scale = 0)
	private Long imageDeptNum;
	
	/** 诊断设备标识 */
	@Column(name = "DIAGNOSIS_DEVICE_NUM", precision = 18, scale = 0)
	private Long diagnosisDeviceNum;
	
	/** 病人来源标识 */
	@Column(name = "PATIENT_FROM_NUM", precision = 18, scale = 0)
	private Long patientFromNum;
	
	/** 病人来源 [住院 /住院 /体检] */
	@Column(name = "PATIENT_FROM", length = 12)
	private String patientFrom;
	
	/** 检查部位ID */
	@Column(name = "EXAM_PART_ID", precision = 18, scale = 0)
	private Long examPartId;
	
	/** 检查部位 */
	@Column(name = "EXAM_PART", length = 256)
	private String examPart;
	
	/** 检查分类： 1=超声 ，2=放射 ，3=内镜 ，4=病理*/
	@Column(name = "EXAM_CATEGORY", length = 64, nullable = false)
	private String examCategory;
	
	/** 检查费用 */
	@Column(name = "EXAM_COST", precision = 18)
	private Double examCost;
	
	/** 住院号 */
	@Column(name = "ADMISSION_NUM", length = 16)
	private String admissionNum;
	
	/** 床号 */
	@Column(name = "BED_NUM", length = 16)
	private String bedNum;
	
	/** 检查状态 */
	@Column(name = "EXAM_STATUS", length = 20)
	private String examStatus;
	
	/** 诊断医生 */
	@Column(name = "DIAGNOSIS_DOCTOR", length = 30)
	private String diagnosisDoctor;
	
	/** 登记医生 */
	@Column(name = "REGISTER_DOCTOR", length = 30)
	private String registerDoctor;
	
	/** 临床科室标识 */
	@Column(name = "CLINIC_DEPT_NUM", precision = 18, scale = 0)
	private Long clinicDeptNum;
	
	/** 临床医生标识 */
	@Column(name = "CLINIC_DOCTOR_NUM", precision = 18, scale = 0)
	private Long clinicDoctorNum;
	
	/** 登记时间 */
	@Column(name = "REGISTER_DATE")
	private Date registerDate;
	
	/** 检查时间 */
	@Column(name = "EXAM_DATE")
	private Date examDate;
	
	/** 更改时间 */
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	/** 打印时间 */
	@Column(name = "PRINT_DATE")
	private Date printDate;
	
	/** 图像目录 */
	@Column(name = "IMAGE_PATH", length = 64)
	private String imagePath;
	
	/** 图片类型 1=dicom 图片 2=img 图片 */
	@Column(name = "IMAGE_TYPE", length = 1)
	private String imageType;
	
	/** 病历追踪标志 */
	@Column(name = "MEDICAL_RECORD", length = 1)
	private String medicalRecord;
	
	/** 病历评审标志 */
	@Column(name = "MEDICAL_AUDIT", length = 1)
	private String medicalAudit;
	
	/** 备份标记 */
	@Column(name = "REMARK_FLAG", length = 1)
	private String remarkFlag;
	
	/** 病人标记 */
	@Column(name = "PATIENT_FLAG", length = 64)
	private String patientFlag;
	
	/** 阳性标记 */
	@Column(name = "POSITIVE_FLAG", precision = 18, scale = 0)
	private Long positiveFlag;
	
	/** 记录医生 */
	@Column(name = "RECORD_DOCTOR", length = 30)
	private String recordDoctor;
	
	/** 审核医生 */
	@Column(name = "AUDIT_DOCTOR", length = 30)
	private String auditDoctor;
	
	/** 年龄 */
	@Column(name = "PATIENT_AGE", length = 10)
	private String patientAge;
	
	/** 孕期 */
	@Column(name = "PREGNANCY_CYCLE", precision = 18, scale = 0)
	private Long pregnancyCycle;
	
	/** 会诊医生 */
	@Column(name = "CONSULTATION_DOCTOR", length = 50)
	private String consultationDoctor;
	
	/** 病人超声号 */
	@Column(name = "PATEINT_PACS_NUM", length = 20)
	private String pateintPacsNum;
	
	/** 是否追踪 */
	@Column(name = "TRACE_FLAG", precision = 18, scale = 0)
	private Long traceFlag;
	
	/** 病人类别（对应病人来源字段中文的解析） 1=住院 2=门诊 3=住院急诊 4=门诊急诊 5=体检 */
	@Column(name = "PATIENT_TYPE", precision = 18, scale = 0)
	private Long patientType;
	
	/** 检查HIS号 对应HIS的patient表的patientid */
	@Column(name = "PATIENT_ID", precision = 18, scale = 0)
	private Long patientId;
	
	/*** HIS辅助号（ 病人门诊住院唯一号） 根据病人类别对应  
	 * 门诊--对应云HIS系统   REGISTATION（门诊挂号）的主键ID 住院--对应云HIS系统    HOSPITALREGISTER（住院登记）的主键ID*/
	@Column(name = "INPATIENT_ID", precision = 18, scale = 0)
	private Long inpatientId;
	
	/** 患者院内档案ID（HIS系统） */
	@Column(name = "PATIENT_NO", precision = 18, scale = 0)
	private Long patientNo;
	
	/** 计划追踪时间 */
	@Column(name = "PLAN_TRACE_DATE")
	private Date planTraceDate;
	
	/** 上传标识 */
	@Column(name = "UPLOAD_FLAG", precision = 18, scale = 0)
	private Long uploadFlag;
	
	/** 辅助检查诊断 */
	@Column(name = "SUBEXAM_DIAGNOSIS", length = 50)
	private String subexamDiagnosis;
	
	/** 删除标识 */
	@Column(name = "DELETE_FLAG", precision = 18, scale = 0)
	private Long deleteFlag;
 
	/** 到达时间 */
	@Column(name = "ARRIVE_DATE", length = 50)
	private String arriveDate;
	
	/** 数据类型 */
	@Column(name = "DATA_TYPE", precision = 18, scale = 0)
	private Long dataType;
	
	/** 检查设备 */
	@Column(name = "EXAM_DEVICE", length = 50)
	private String examDevice;
	
	/** 申请科室 */
	@Column(name = "APPLY_DEPT", length = 50)
	private String applyDept;
	
	/** 申请医生 */
	@Column(name = "APPLY_DOCTOR", length = 50)
	private String applyDoctor;
	
	/** 检查方式ID */
	@Column(name = "EXAM_WAY_ID", precision = 18, scale = 0)
	private Long examWayId;
	
	/** 检查方式 */
	@Column(name = "EXAM_WAY", length = 50)
	private String examWay;
	
	/** 主诉 */
	@Column(name = "MAIN_DESC", length = 256)
	private String mainDesc;
	
	/** 检查编号 */
	@Column(name = "STUDY_UID", length = 128)
	private String studyUid;
	
	/** 序列编号 */
	@Column(name = "SERIES_UID", length = 128)
	private String seriesUid;
	
	/** 归属检查编号 */
	@Column(name = "BELONGS_CHECK_NUM", length = 128)
	private String belongsCheckNum;
	
	/** 查询HIS号 */
	@Column(name = "QUERY_HIS_NUM", length = 128)
	private String queryHisNum;
	
	/** 区域标识 */
	@Column(name = "AREA_ID", precision = 18, scale = 0)
	private Long areaId;
	
	/** 危急值 */
	@Column(name = "PANIC_VALUES", length = 256)
	private String panicValues;
	
	/** 申请日期 */
	@Column(name = "APPLY_DATE")
	private Date applyDate;
	
	/** 辅助日期 */
	@Column(name = "ASSISTANT_DATE")
	private Date assistantDate;
	
	/** 联系电话 */
	@Column(name = "TELEPHONE", length = 50)
	private String telephone;
	
	/** 预产期 */
	@Column(name = "EXPECT_CHILDBIRTH_DATE", length = 50)
	private String expectChildbirthDate;
	
	/** 就诊卡号 */
	@Column(name = "VISIT_CARD_NUM", length = 50)
	private String visitCardNum;
	
	/** 存取编号 */
	@Column(name = "ACCESS_NUMBER", length = 50)
	private String accessNumber;
	
	/** 检查ID */
	@Column(name = "EXAM_ID", length = 50)
	private String examId;
	
	/** 科室号 */
	@Column(name = "DEPT_NUM", length = 20)
	private String deptNum;
	
	/** 初诊医生 */
	@Column(name = "FIRST_VISIT_DOCTOR", length = 30)
	private String firstVisitDoctor;
	
	/** 初诊时间 */
	@Column(name = "FIRST_VIST_DATE")
	private Date firstVistDate;
	
	/** 当前医生 */
	@Column(name = "CURRENT_DOCTOR", length = 30)
	private String currentDoctor;
	
	/** 胶片状态 */
	@Column(name = "FILM_STATUS", length = 10)
	private String filmStatus;
	
	/** 打印次数 */
	@Column(name = "PRINT_TIMES", precision = 18, scale = 0)
	private Long printTimes;
	
	/** ht辅助号htPACS（超声、内镜、病理）使用 */
	@Column(name = "ASSISTANT_NUMBER", length = 18)
	private String assistantNumber;
	
	/** ht申请单明细htPACS（超声、内镜、病理）使用 */
	@Column(name = "APPLY_NOTES_DETAIL", length = 1024)
	private String applyNotesDetail;
	
	/** ht获取次数 htPACS（超声、内镜、病理）使用 */
	@Column(name = "OBTAIN_TIMES", precision = 18, scale = 0)
	private Long obtainTimes;
	
	/** HIS文本信息 */
	@Column(name = "HIS_TEXT_MESSAGE")
	private String hisTextMessage;
	
	/** fs甲等片fsPACS（放射）使用 */
	@Column(name = "FIRST_CLASS_FILM", length = 12)
	private String firstClassFilm;
	
	/** fs符合临床fsPACS（放射）使用 */
	@Column(name = "ACCORD_CLINIC", length = 12)
	private String accordClinic;
	
	/** fs医院名称fsPACS（放射）使用 */
	@Column(name = "HOSPITAL_NAME", length = 50)
	private String hospitalName;
	
	/** fs检查子类fsPACS（放射）使用 */
	@Column(name = "EXAM_CHILD_TYPE", length = 50)
	private String examChildType;
	
	/** ht住院次数htPACS（超声、内镜、病理）使用 */
	@Column(name = "HOSPITALIZED_TIMES", length = 12)
	private String hospitalizedTimes;
	
	/** 审核时间 */
	@Column(name = "AUDIT_DATE")
	private Date auditDate;
	
	/** ht辅助医生htPACS（超声、内镜、病理）使用 */
	@Column(name = "ASSIST_DOCTORS", length = 50)
	private String assistDoctors;
	
	/** ht检查类型htPACS（超声、内镜、病理）使用 */
	@Column(name = "EXAM_TYPE", length = 32)
	private String examType;
	
	/** ht检查部位编号htPACS（超声、内镜、病理）使用 */
	@Column(name = "EXAM_PART_NUM", length = 100)
	private String examPartNum;
	
	/** fs报告单合格fsPACS（放射）使用 */
	@Column(name = "REPORT_CARD_QUALIFIED", length = 12)
	private String reportCardQualified;
	
	/** fs危急检查fsPACS（放射）使用 */
	@Column(name = "CRITICAL_CHECK", length = 12)
	private String criticalCheck;
	
	/** fs传染病检查fsPACS（放射）使用 */
	@Column(name = "INFECTIOUS_CHECK", length = 50)
	private String infectiousCheck;
	
	/** fs诊断时间fsPACS（放射）使用 */
	@Column(name = "DIAGNOSIS_DATE")
	private Date diagnosisDate;
	
	/** fs排诊医生fsPACS（放射）使用 */
	@Column(name = "SCHEDULING_DOCTOR", length = 32)
	private String schedulingDoctor;
	
	/** fs曝光次数fsPACS（放射）使用 */
	@Column(name = "EXPOSURE_TIMES", precision = 18, scale = 0)
	private Long exposureTimes;
	
	/** 医院标识不同的医院分配不同的标识 对应sys_org表中org_no字段 */
	@Column(name = "HOSPITAL_NO", nullable = false, length = 40)
	private String hospitalNo;
	
	/** 来源ip */
	@Column(name = "SOURCE_IP", nullable = false, length = 20)
	private String sourceIp;
	
	/** ht-fs数据库标识同一医院PACS系统数据的标识1：fsPACS2：htPACS */
	@Column(name = "HT_FS_PACS_MARK", nullable = false, length = 1)
	private String htFsPacsMark;

	// Constructors

	/** default constructor */
	public PatientExam() {
	}

	/**
	 * @return patientExamId
	 */
	public Long getPatientExamId() {
		return patientExamId;
	}

	/**
	 * @param patientExamId 要设置的 patientExamId
	 */
	public void setPatientExamId(Long patientExamId) {
		this.patientExamId = patientExamId;
	}

	/**
	 * @return orgId
	 */
	public Long getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId 要设置的 orgId
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return patientExamNum
	 */
	public String getPatientExamNum() {
		return patientExamNum;
	}

	/**
	 * @param patientExamNum 要设置的 patientExamNum
	 */
	public void setPatientExamNum(String patientExamNum) {
		this.patientExamNum = patientExamNum;
	}

	/**
	 * @return patientArchiveNum
	 */
	public String getPatientArchiveNum() {
		return patientArchiveNum;
	}

	/**
	 * @param patientArchiveNum 要设置的 patientArchiveNum
	 */
	public void setPatientArchiveNum(String patientArchiveNum) {
		this.patientArchiveNum = patientArchiveNum;
	}

	/**
     * @return the diagnosisFlag
     */
    public String getDiagnosisFlag() {
        return diagnosisFlag;
    }

    /**
     * @param diagnosisFlag the diagnosisFlag to set
     */
    public void setDiagnosisFlag(String diagnosisFlag) {
        this.diagnosisFlag = diagnosisFlag;
    }

    /**
	 * @return examSeriesNum
	 */
	public Long getExamSeriesNum() {
		return examSeriesNum;
	}

	/**
	 * @param examSeriesNum 要设置的 examSeriesNum
	 */
	public void setExamSeriesNum(Long examSeriesNum) {
		this.examSeriesNum = examSeriesNum;
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
	 * @return diagnosisDeviceNum
	 */
	public Long getDiagnosisDeviceNum() {
		return diagnosisDeviceNum;
	}

	/**
	 * @param diagnosisDeviceNum 要设置的 diagnosisDeviceNum
	 */
	public void setDiagnosisDeviceNum(Long diagnosisDeviceNum) {
		this.diagnosisDeviceNum = diagnosisDeviceNum;
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
	 * @return examPartId
	 */
	public Long getExamPartId() {
		return examPartId;
	}

	/**
	 * @param examPartId 要设置的 examPartId
	 */
	public void setExamPartId(Long examPartId) {
		this.examPartId = examPartId;
	}

	/**
	 * @return examPart
	 */
	public String getExamPart() {
		return examPart;
	}

	/**
	 * @param examPart 要设置的 examPart
	 */
	public void setExamPart(String examPart) {
		this.examPart = examPart;
	}

	/**
	 * @return examCategory
	 */
	public String getExamCategory() {
		return examCategory;
	}

	/**
	 * @param examCategory 要设置的 examCategory
	 */
	public void setExamCategory(String examCategory) {
		this.examCategory = examCategory;
	}

	/**
	 * @return examCost
	 */
	public Double getExamCost() {
		return examCost;
	}

	/**
	 * @param examCost 要设置的 examCost
	 */
	public void setExamCost(Double examCost) {
		this.examCost = examCost;
	}

	/**
	 * @return admissionNum
	 */
	public String getAdmissionNum() {
		return admissionNum;
	}

	/**
	 * @param admissionNum 要设置的 admissionNum
	 */
	public void setAdmissionNum(String admissionNum) {
		this.admissionNum = admissionNum;
	}

	/**
	 * @return bedNum
	 */
	public String getBedNum() {
		return bedNum;
	}

	/**
	 * @param bedNum 要设置的 bedNum
	 */
	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}

	/**
	 * @return examStatus
	 */
	public String getExamStatus() {
		return examStatus;
	}

	/**
	 * @param examStatus 要设置的 examStatus
	 */
	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	/**
	 * @return diagnosisDoctor
	 */
	public String getDiagnosisDoctor() {
		return diagnosisDoctor;
	}

	/**
	 * @param diagnosisDoctor 要设置的 diagnosisDoctor
	 */
	public void setDiagnosisDoctor(String diagnosisDoctor) {
		this.diagnosisDoctor = diagnosisDoctor;
	}

	/**
	 * @return registerDoctor
	 */
	public String getRegisterDoctor() {
		return registerDoctor;
	}

	/**
	 * @param registerDoctor 要设置的 registerDoctor
	 */
	public void setRegisterDoctor(String registerDoctor) {
		this.registerDoctor = registerDoctor;
	}

	/**
	 * @return clinicDeptNum
	 */
	public Long getClinicDeptNum() {
		return clinicDeptNum;
	}

	/**
	 * @param clinicDeptNum 要设置的 clinicDeptNum
	 */
	public void setClinicDeptNum(Long clinicDeptNum) {
		this.clinicDeptNum = clinicDeptNum;
	}

	/**
	 * @return clinicDoctorNum
	 */
	public Long getClinicDoctorNum() {
		return clinicDoctorNum;
	}

	/**
	 * @param clinicDoctorNum 要设置的 clinicDoctorNum
	 */
	public void setClinicDoctorNum(Long clinicDoctorNum) {
		this.clinicDoctorNum = clinicDoctorNum;
	}

	/**
	 * @return registerDate
	 */
	public Date getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate 要设置的 registerDate
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return examDate
	 */
	public Date getExamDate() {
		return examDate;
	}

	/**
	 * @param examDate 要设置的 examDate
	 */
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	/**
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate 要设置的 updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return printDate
	 */
	public Date getPrintDate() {
		return printDate;
	}

	/**
	 * @param printDate 要设置的 printDate
	 */
	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	/**
	 * @return imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath 要设置的 imagePath
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return imageType
	 */
	public String getImageType() {
		return imageType;
	}

	/**
	 * @param imageType 要设置的 imageType
	 */
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	/**
	 * @return medicalRecord
	 */
	public String getMedicalRecord() {
		return medicalRecord;
	}

	/**
	 * @param medicalRecord 要设置的 medicalRecord
	 */
	public void setMedicalRecord(String medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	/**
	 * @return medicalAudit
	 */
	public String getMedicalAudit() {
		return medicalAudit;
	}

	/**
	 * @param medicalAudit 要设置的 medicalAudit
	 */
	public void setMedicalAudit(String medicalAudit) {
		this.medicalAudit = medicalAudit;
	}

	/**
	 * @return remarkFlag
	 */
	public String getRemarkFlag() {
		return remarkFlag;
	}

	/**
	 * @param remarkFlag 要设置的 remarkFlag
	 */
	public void setRemarkFlag(String remarkFlag) {
		this.remarkFlag = remarkFlag;
	}

	/**
	 * @return patientFlag
	 */
	public String getPatientFlag() {
		return patientFlag;
	}

	/**
	 * @param patientFlag 要设置的 patientFlag
	 */
	public void setPatientFlag(String patientFlag) {
		this.patientFlag = patientFlag;
	}

	/**
	 * @return positiveFlag
	 */
	public Long getPositiveFlag() {
		return positiveFlag;
	}

	/**
	 * @param positiveFlag 要设置的 positiveFlag
	 */
	public void setPositiveFlag(Long positiveFlag) {
		this.positiveFlag = positiveFlag;
	}

	/**
	 * @return recordDoctor
	 */
	public String getRecordDoctor() {
		return recordDoctor;
	}

	/**
	 * @param recordDoctor 要设置的 recordDoctor
	 */
	public void setRecordDoctor(String recordDoctor) {
		this.recordDoctor = recordDoctor;
	}

	/**
	 * @return auditDoctor
	 */
	public String getAuditDoctor() {
		return auditDoctor;
	}

	/**
	 * @param auditDoctor 要设置的 auditDoctor
	 */
	public void setAuditDoctor(String auditDoctor) {
		this.auditDoctor = auditDoctor;
	}

	/**
	 * @return patientAge
	 */
	public String getPatientAge() {
		return patientAge;
	}

	/**
	 * @param patientAge 要设置的 patientAge
	 */
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	/**
	 * @return pregnancyCycle
	 */
	public Long getPregnancyCycle() {
		return pregnancyCycle;
	}

	/**
	 * @param pregnancyCycle 要设置的 pregnancyCycle
	 */
	public void setPregnancyCycle(Long pregnancyCycle) {
		this.pregnancyCycle = pregnancyCycle;
	}

	/**
	 * @return consultationDoctor
	 */
	public String getConsultationDoctor() {
		return consultationDoctor;
	}

	/**
	 * @param consultationDoctor 要设置的 consultationDoctor
	 */
	public void setConsultationDoctor(String consultationDoctor) {
		this.consultationDoctor = consultationDoctor;
	}

	/**
	 * @return pateintPacsNum
	 */
	public String getPateintPacsNum() {
		return pateintPacsNum;
	}

	/**
	 * @param pateintPacsNum 要设置的 pateintPacsNum
	 */
	public void setPateintPacsNum(String pateintPacsNum) {
		this.pateintPacsNum = pateintPacsNum;
	}

	/**
	 * @return traceFlag
	 */
	public Long getTraceFlag() {
		return traceFlag;
	}

	/**
	 * @param traceFlag 要设置的 traceFlag
	 */
	public void setTraceFlag(Long traceFlag) {
		this.traceFlag = traceFlag;
	}

	/**
     * @return the patientId
     */
    public Long getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    /**
	 * @return patientType
	 */
	public Long getPatientType() {
		return patientType;
	}

	/**
	 * @param patientType 要设置的 patientType
	 */
	public void setPatientType(Long patientType) {
		this.patientType = patientType;
	}

	/**
	 * @return inpatientId
	 */
	public Long getInpatientId() {
		return inpatientId;
	}

	/**
	 * @param inpatientId 要设置的 inpatientId
	 */
	public void setInpatientId(Long inpatientId) {
		this.inpatientId = inpatientId;
	}

	/**
	 * @return patientNo
	 */
	public Long getPatientNo() {
		return patientNo;
	}

	/**
	 * @param patientNo 要设置的 patientNo
	 */
	public void setPatientNo(Long patientNo) {
		this.patientNo = patientNo;
	}

	/**
	 * @return planTraceDate
	 */
	public Date getPlanTraceDate() {
		return planTraceDate;
	}

	/**
	 * @param planTraceDate 要设置的 planTraceDate
	 */
	public void setPlanTraceDate(Date planTraceDate) {
		this.planTraceDate = planTraceDate;
	}

	/**
	 * @return uploadFlag
	 */
	public Long getUploadFlag() {
		return uploadFlag;
	}

	/**
	 * @param uploadFlag 要设置的 uploadFlag
	 */
	public void setUploadFlag(Long uploadFlag) {
		this.uploadFlag = uploadFlag;
	}

	/**
	 * @return subexamDiagnosis
	 */
	public String getSubexamDiagnosis() {
		return subexamDiagnosis;
	}

	/**
	 * @param subexamDiagnosis 要设置的 subexamDiagnosis
	 */
	public void setSubexamDiagnosis(String subexamDiagnosis) {
		this.subexamDiagnosis = subexamDiagnosis;
	}


	/**
	 * @return deleteFlag
	 */
	public Long getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag 要设置的 deleteFlag
	 */
	public void setDeleteFlag(Long deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * @return arriveDate
	 */
	public String getArriveDate() {
		return arriveDate;
	}

	/**
	 * @param arriveDate 要设置的 arriveDate
	 */
	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}

	/**
	 * @return dataType
	 */
	public Long getDataType() {
		return dataType;
	}

	/**
	 * @param dataType 要设置的 dataType
	 */
	public void setDataType(Long dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return examDevice
	 */
	public String getExamDevice() {
		return examDevice;
	}

	/**
	 * @param examDevice 要设置的 examDevice
	 */
	public void setExamDevice(String examDevice) {
		this.examDevice = examDevice;
	}

	/**
	 * @return applyDept
	 */
	public String getApplyDept() {
		return applyDept;
	}

	/**
	 * @param applyDept 要设置的 applyDept
	 */
	public void setApplyDept(String applyDept) {
		this.applyDept = applyDept;
	}

	/**
	 * @return applyDoctor
	 */
	public String getApplyDoctor() {
		return applyDoctor;
	}

	/**
	 * @param applyDoctor 要设置的 applyDoctor
	 */
	public void setApplyDoctor(String applyDoctor) {
		this.applyDoctor = applyDoctor;
	}

	/**
	 * @return examWayId
	 */
	public Long getExamWayId() {
		return examWayId;
	}

	/**
	 * @param examWayId 要设置的 examWayId
	 */
	public void setExamWayId(Long examWayId) {
		this.examWayId = examWayId;
	}

	/**
	 * @return examWay
	 */
	public String getExamWay() {
		return examWay;
	}

	/**
	 * @param examWay 要设置的 examWay
	 */
	public void setExamWay(String examWay) {
		this.examWay = examWay;
	}

	/**
	 * @return mainDesc
	 */
	public String getMainDesc() {
		return mainDesc;
	}

	/**
	 * @param mainDesc 要设置的 mainDesc
	 */
	public void setMainDesc(String mainDesc) {
		this.mainDesc = mainDesc;
	}

	/**
	 * @return studyUid
	 */
	public String getStudyUid() {
		return studyUid;
	}

	/**
	 * @param studyUid 要设置的 studyUid
	 */
	public void setStudyUid(String studyUid) {
		this.studyUid = studyUid;
	}

	/**
	 * @return seriesUid
	 */
	public String getSeriesUid() {
		return seriesUid;
	}

	/**
	 * @param seriesUid 要设置的 seriesUid
	 */
	public void setSeriesUid(String seriesUid) {
		this.seriesUid = seriesUid;
	}

	/**
	 * @return belongsCheckNum
	 */
	public String getBelongsCheckNum() {
		return belongsCheckNum;
	}

	/**
	 * @param belongsCheckNum 要设置的 belongsCheckNum
	 */
	public void setBelongsCheckNum(String belongsCheckNum) {
		this.belongsCheckNum = belongsCheckNum;
	}

	/**
	 * @return queryHisNum
	 */
	public String getQueryHisNum() {
		return queryHisNum;
	}

	/**
	 * @param queryHisNum 要设置的 queryHisNum
	 */
	public void setQueryHisNum(String queryHisNum) {
		this.queryHisNum = queryHisNum;
	}

	/**
	 * @return areaId
	 */
	public Long getAreaId() {
		return areaId;
	}

	/**
	 * @param areaId 要设置的 areaId
	 */
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	/**
	 * @return panicValues
	 */
	public String getPanicValues() {
		return panicValues;
	}

	/**
	 * @param panicValues 要设置的 panicValues
	 */
	public void setPanicValues(String panicValues) {
		this.panicValues = panicValues;
	}

	/**
	 * @return applyDate
	 */
	public Date getApplyDate() {
		return applyDate;
	}

	/**
	 * @param applyDate 要设置的 applyDate
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	/**
	 * @return assistantDate
	 */
	public Date getAssistantDate() {
		return assistantDate;
	}

	/**
	 * @param assistantDate 要设置的 assistantDate
	 */
	public void setAssistantDate(Date assistantDate) {
		this.assistantDate = assistantDate;
	}

	/**
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone 要设置的 telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return expectChildbirthDate
	 */
	public String getExpectChildbirthDate() {
		return expectChildbirthDate;
	}

	/**
	 * @param expectChildbirthDate 要设置的 expectChildbirthDate
	 */
	public void setExpectChildbirthDate(String expectChildbirthDate) {
		this.expectChildbirthDate = expectChildbirthDate;
	}

	/**
	 * @return visitCardNum
	 */
	public String getVisitCardNum() {
		return visitCardNum;
	}

	/**
	 * @param visitCardNum 要设置的 visitCardNum
	 */
	public void setVisitCardNum(String visitCardNum) {
		this.visitCardNum = visitCardNum;
	}

	/**
	 * @return accessNumber
	 */
	public String getAccessNumber() {
		return accessNumber;
	}

	/**
	 * @param accessNumber 要设置的 accessNumber
	 */
	public void setAccessNumber(String accessNumber) {
		this.accessNumber = accessNumber;
	}

	/**
	 * @return examId
	 */
	public String getExamId() {
		return examId;
	}

	/**
	 * @param examId 要设置的 examId
	 */
	public void setExamId(String examId) {
		this.examId = examId;
	}

	/**
	 * @return deptNum
	 */
	public String getDeptNum() {
		return deptNum;
	}

	/**
	 * @param deptNum 要设置的 deptNum
	 */
	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}

	/**
	 * @return firstVisitDoctor
	 */
	public String getFirstVisitDoctor() {
		return firstVisitDoctor;
	}

	/**
	 * @param firstVisitDoctor 要设置的 firstVisitDoctor
	 */
	public void setFirstVisitDoctor(String firstVisitDoctor) {
		this.firstVisitDoctor = firstVisitDoctor;
	}

	/**
	 * @return firstVistDate
	 */
	public Date getFirstVistDate() {
		return firstVistDate;
	}

	/**
	 * @param firstVistDate 要设置的 firstVistDate
	 */
	public void setFirstVistDate(Date firstVistDate) {
		this.firstVistDate = firstVistDate;
	}

	/**
	 * @return currentDoctor
	 */
	public String getCurrentDoctor() {
		return currentDoctor;
	}

	/**
	 * @param currentDoctor 要设置的 currentDoctor
	 */
	public void setCurrentDoctor(String currentDoctor) {
		this.currentDoctor = currentDoctor;
	}

	/**
	 * @return filmStatus
	 */
	public String getFilmStatus() {
		return filmStatus;
	}

	/**
	 * @param filmStatus 要设置的 filmStatus
	 */
	public void setFilmStatus(String filmStatus) {
		this.filmStatus = filmStatus;
	}

	/**
	 * @return printTimes
	 */
	public Long getPrintTimes() {
		return printTimes;
	}

	/**
	 * @param printTimes 要设置的 printTimes
	 */
	public void setPrintTimes(Long printTimes) {
		this.printTimes = printTimes;
	}

	/**
	 * @return assistantNumber
	 */
	public String getAssistantNumber() {
		return assistantNumber;
	}

	/**
	 * @param assistantNumber 要设置的 assistantNumber
	 */
	public void setAssistantNumber(String assistantNumber) {
		this.assistantNumber = assistantNumber;
	}

	/**
	 * @return applyNotesDetail
	 */
	public String getApplyNotesDetail() {
		return applyNotesDetail;
	}

	/**
	 * @param applyNotesDetail 要设置的 applyNotesDetail
	 */
	public void setApplyNotesDetail(String applyNotesDetail) {
		this.applyNotesDetail = applyNotesDetail;
	}

	/**
	 * @return obtainTimes
	 */
	public Long getObtainTimes() {
		return obtainTimes;
	}

	/**
	 * @param obtainTimes 要设置的 obtainTimes
	 */
	public void setObtainTimes(Long obtainTimes) {
		this.obtainTimes = obtainTimes;
	}

	/**
	 * @return hisTextMessage
	 */
	public String getHisTextMessage() {
		return hisTextMessage;
	}

	/**
	 * @param hisTextMessage 要设置的 hisTextMessage
	 */
	public void setHisTextMessage(String hisTextMessage) {
		this.hisTextMessage = hisTextMessage;
	}

	/**
	 * @return firstClassFilm
	 */
	public String getFirstClassFilm() {
		return firstClassFilm;
	}

	/**
	 * @param firstClassFilm 要设置的 firstClassFilm
	 */
	public void setFirstClassFilm(String firstClassFilm) {
		this.firstClassFilm = firstClassFilm;
	}

	/**
	 * @return accordClinic
	 */
	public String getAccordClinic() {
		return accordClinic;
	}

	/**
	 * @param accordClinic 要设置的 accordClinic
	 */
	public void setAccordClinic(String accordClinic) {
		this.accordClinic = accordClinic;
	}

	/**
	 * @return hospitalName
	 */
	public String getHospitalName() {
		return hospitalName;
	}

	/**
	 * @param hospitalName 要设置的 hospitalName
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	/**
	 * @return examChildType
	 */
	public String getExamChildType() {
		return examChildType;
	}

	/**
	 * @param examChildType 要设置的 examChildType
	 */
	public void setExamChildType(String examChildType) {
		this.examChildType = examChildType;
	}

	/**
	 * @return hospitalizedTimes
	 */
	public String getHospitalizedTimes() {
		return hospitalizedTimes;
	}

	/**
	 * @param hospitalizedTimes 要设置的 hospitalizedTimes
	 */
	public void setHospitalizedTimes(String hospitalizedTimes) {
		this.hospitalizedTimes = hospitalizedTimes;
	}

	/**
	 * @return auditDate
	 */
	public Date getAuditDate() {
		return auditDate;
	}

	/**
	 * @param auditDate 要设置的 auditDate
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * @return assistDoctors
	 */
	public String getAssistDoctors() {
		return assistDoctors;
	}

	/**
	 * @param assistDoctors 要设置的 assistDoctors
	 */
	public void setAssistDoctors(String assistDoctors) {
		this.assistDoctors = assistDoctors;
	}

	/**
	 * @return examType
	 */
	public String getExamType() {
		return examType;
	}

	/**
	 * @param examType 要设置的 examType
	 */
	public void setExamType(String examType) {
		this.examType = examType;
	}

	/**
	 * @return examPartNum
	 */
	public String getExamPartNum() {
		return examPartNum;
	}

	/**
	 * @param examPartNum 要设置的 examPartNum
	 */
	public void setExamPartNum(String examPartNum) {
		this.examPartNum = examPartNum;
	}

	/**
	 * @return reportCardQualified
	 */
	public String getReportCardQualified() {
		return reportCardQualified;
	}

	/**
	 * @param reportCardQualified 要设置的 reportCardQualified
	 */
	public void setReportCardQualified(String reportCardQualified) {
		this.reportCardQualified = reportCardQualified;
	}

	/**
	 * @return criticalCheck
	 */
	public String getCriticalCheck() {
		return criticalCheck;
	}

	/**
	 * @param criticalCheck 要设置的 criticalCheck
	 */
	public void setCriticalCheck(String criticalCheck) {
		this.criticalCheck = criticalCheck;
	}

	/**
	 * @return infectiousCheck
	 */
	public String getInfectiousCheck() {
		return infectiousCheck;
	}

	/**
	 * @param infectiousCheck 要设置的 infectiousCheck
	 */
	public void setInfectiousCheck(String infectiousCheck) {
		this.infectiousCheck = infectiousCheck;
	}

	/**
	 * @return diagnosisDate
	 */
	public Date getDiagnosisDate() {
		return diagnosisDate;
	}

	/**
	 * @param diagnosisDate 要设置的 diagnosisDate
	 */
	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	/**
	 * @return schedulingDoctor
	 */
	public String getSchedulingDoctor() {
		return schedulingDoctor;
	}

	/**
	 * @param schedulingDoctor 要设置的 schedulingDoctor
	 */
	public void setSchedulingDoctor(String schedulingDoctor) {
		this.schedulingDoctor = schedulingDoctor;
	}

	/**
	 * @return exposureTimes
	 */
	public Long getExposureTimes() {
		return exposureTimes;
	}

	/**
	 * @param exposureTimes 要设置的 exposureTimes
	 */
	public void setExposureTimes(Long exposureTimes) {
		this.exposureTimes = exposureTimes;
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
	 * @return sourceIp
	 */
	public String getSourceIp() {
		return sourceIp;
	}

	/**
	 * @param sourceIp 要设置的 sourceIp
	 */
	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
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

	/**
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
}