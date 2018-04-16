package com.bofan.utils;

/**
 * @Description:  常量定义
 * @author   lqw 
 * @version  v1.0   
 * @Date     2017-8-22 下午10:49:22
 */
public class Contstants {
    
    /** pacs系统中，由dicm文件解析出来的图片后名称分隔符 */
    public static final String PACS_IMG_SEPARATOR = "_";
    /** pacs系统中，由dicm文件解析出来的图片后缀名 */
    public static final String PACS_IMG_SUFFIX = ".jpg";
    /** 多个字符串的分隔符  */
    public static final String STRING_SEPARATOR = ",";
    /** 在bdb中，存在dicm图片base64数据的key */
    public static final String DICM_BASE64_KEY = "PATIENTEXAMID";
    /** pacs系统中，由dicm文件解析出来图片后压缩图片压缩文件名称后缀 */
    public static final String PACS_IMG_COMPRESS_SUFFIX = ".zip";
    /** 000 三位 一个级别 faq_type */
    public static final int TYPE_SEGMENT_LENGTH = 3;
    /** 000 根节点*/
    public static final String ROOT_TREE_ID = "0";
//知识库	/ faq_detail
    /** 50次以上为热点点击计数 */
    public static final int CLICK_HOT_COUNT = 0;
    /** 30天以内为热点点击计数 */
    public static final int CLICK_HOT_DAYS = 90;
//是否为图片 faq_affix_item
    public static final String IMAGE_YES = "1";
	public static final String IMAGE_NO = "0";
//是否为PDF文档	 faq_affix_item
	public static final String PDF_YES = "1";
	public static final String PDF_NO = "0";
	
	/** 进入查看页面参数  **/
	public static final String SHOW_PAGE = "show";
	/** 进入快速编辑页面参数  **/
	public static final String SIMPLE_EDIT_PAGE = "simple";
	
	/****  数据库非空字段默认字符   ****/
	public static final String NULLABLE_DEFAULT_STRING = "-";
	/****  数据库非空字段默认字符   ****/
	public static final Long NULLABLE_DEFAULT_LONG = 0L;
	
	/** 1：是 **/
	public static final String YES_FLAG = "1";
	/** 0：否 **/
	public static final String NO_FLAG = "0";
	
	
	/** 1：有 **/
    public static final String HAVE_FLAG = "1";
    /** 0：无 **/
    public static final String NONE_FLAG = "0";
	
	/** 性别：男 **/
	public static final String GENDER_MAN = "1";
	/** 性别：女 **/
	public static final String GENDER_MALE = "2";

	public static final String OPTION_SAVE = "1";
	
	
	/** 远程会诊状态： 暂存 */
    public static final String RE_CONSULT_STATUS_SVAE = "0";
    /** 远程会诊状态： 提交申请 */
    public static final String RE_CONSULT_STATUS_APPLY = "1";
    /** 远程会诊状态： 正在会诊 */
    public static final String RE_CONSULT_STATUS_ING = "2";
    /** 远程会诊状态： 会诊完成 */
    public static final String RE_CONSULT_STATUS_FINISH = "3";
    
    /** 会诊类型： 非交互式 */
    public static final String RE_CONSULT_TYPE_NOT_MUTUAL = "1";
    /** 会诊类型： 交互式 */
    public static final String RE_CONSULT_TYPE_MUTUAL = "2";
    
    /** PACS数据库类型: FSPACS*/
    public static final String PACS_TYPE_FS = "1";
    /** PACS数据库类型: HTPACS*/
    public static final String PACS_TYPE_HT = "2";
    
    /** 病人检查图像类型: 超声检查*/
    public static final String PATIENT_EXAM_TYPE_ULTRASOUND = "1";
    /** 病人检查图像类型: 放射检查*/
    public static final String PATIENT_EXAM_TYPE_RADIOLOGY = "2";
    /** 病人检查图像类型: 内镜检查*/
    public static final String PATIENT_EXAM_TYPE_ENDOSCOPE = "3";
     /** 病人检查图像类型: 病理检查*/
    public static final String PATIENT_EXAM_TYPE_PATHOLOGY = "4";
    
     /** 病人检查图像类型: dicom文件*/
    public static final String IMAGETYPE_DICOM = "1";
     /** 病人检查图像类型: img文件*/
    public static final String IMAGETYPE_IMG = "2";
     /** 图像可用标识： 可用*/
    public static final String IMAGE_AVAILABLE = "Y";
    
    /** 双向转诊转诊类型 ：上转  **/
    public static final String DIAGNOSISAPPLY_HDTYPE_UP = "1";
    /** 双向转诊转诊类型 ：下转 **/
    public static final String DIAGNOSISAPPLY_HDTYPE_DOWN = "2";
    
    /** 双向转诊转诊审核 ：通过  **/
    public static final String HDDIAGNOSISAPPLY_AUDITSTATUS_PASS = "1";
    /** 双向转诊转诊审核 ：拒绝 **/
    public static final String HDDIAGNOSISAPPLY_AUDITSTATUS_REFUSE = "2";
    
    /** 双向转诊转诊状态 ：暂存 **/
    public static final String  HDDIAGNOSISAPPLY_TRANSSTATUS_STORE = "0";
    /** 双向转诊转诊状态 ：已申请 **/
    public static final String  HDDIAGNOSISAPPLY_TRANSSTATUS_APPLYED = "1";
    /** 双向转诊转诊状态 ：待接诊 **/
    public static final String  HDDIAGNOSISAPPLY_TRANSSTATUS_WAIT_RECEIVE = "2";
    /** 双向转诊转诊状态 ：待就诊 **/
    public static final String  HDDIAGNOSISAPPLY_TRANSSTATUS_WAIT_TREAT = "3";
    /** 双向转诊转诊状态 ：已就诊 **/
    public static final String  HDDIAGNOSISAPPLY_TRANSSTATUS_HAD_TREAT = "4";
    /** 双向转诊转诊状态 ：已拒绝转诊 **/
    public static final String  HDDIAGNOSISAPPLY_TRANSSTATUS_REFUSE = "5";

    /** sys_function.sys_type 系统管理业务类型 */
    /** 01:云HIS */
    public static final String SYS_TYPE_HIS = "01";
    /** 02:双向转诊 */
    public static final String SYS_TYPE_GRADE = "02";
    /** 03:远程会诊 */
    public static final String SYS_TYPE_RECONSULT = "03";
    /** 04:云PACS */
    public static final String SYS_TYPE_PACS = "04";
    /** 05:云LIS */
    public static final String SYS_TYPE_LIS = "05";
    /** 06:云RIS */
    public static final String SYS_TYPE_RIS = "06";
    /** 07:公共卫生 */
    public static final String SYS_TYPE_HEALTH = "07";
    /** 08:疫情上报 */
    public static final String SYS_TYPE_REPORT = "08";
    
    /** 视频会议用管理员用户标识 */
    public static final String VIDEO_MEETING_ADMIN_USER = "1";
    
    /** 病人类别 */
    /** 1:住院  */
    public static final String PATIENT_TYPE_INHOSPITAL = "1";
    /** 2:门诊  */
    public static final String PATIENT_TYPE_OUTPATIENT = "2";
    /** 3:住院急诊  */
    public static final String PATIENT_TYPE_INHOSPITAL_URGENT = "3";
    /** 4:门诊急诊  */
    public static final String PATIENT_TYPE_OUTPATIENT_URGENT = "4";
    /** 5:体检  */
    public static final String PATIENT_TYPE_INHOSPITAL_EXAM = "5";
    
    /** 行政街道 市ID的长度 : 6 */
	public static final Integer REGION_ID_FIRST_LEVEL_SIZE = 6;
	/** 行政街道 镇ID的长度 : 9 */
	public static final Integer REGION_ID_SECOND_LEVEL_SIZE = 9;
	/** 行政街道 村ID的长度 : 12 */
	public static final Integer REGION_ID_THIRD_LEVEL_SIZE = 12;
	
	/**疾病类型：1=脑血管疾病名称;*/
	public static final String DISEASE_CV_TYPE = "1";
	/**疾病类型：2=肾肝疾病名称; */
    public static final String DISEASE_KL_TYPE = "2";
    /**疾病类型：3=心脏疾病名称; */
    public static final String DISEASE_HEART_TYPE = "3";
    /**疾病类型：4=血管疾病名称; */
    public static final String DISEASE_VASCULAR_TYPE = "4";
    /**疾病类型：5=肺部疾病名称; */
    public static final String DISEASE_PD_TYPE = "5";
    /**疾病类型：6=眼部疾病名称; */
    public static final String DISEASE_EYE_TYPE = "6";
    
    /**是否申请远程诊断或双向转诊：0=未申请;*/
    public static final String DIAGNOSIS_FLAG_NONE = "0";
    /**是否申请远程诊断或双向转诊：1=已申请双向转诊;*/
    public static final String DIAGNOSIS_FLAG_DIAG = "1";
    /**是否申请远程诊断或双向转诊：2=已申请远程诊断;*/
    public static final String DIAGNOSIS_FLAG_REMOTE = "2";
    
    /** 随访-检查年龄阶段1=新生儿随访 */
    public static final String CHILD_NEW_FALG = "1";
    /** 随访-检查年龄阶段2=1岁内检查 */
    public static final String CHILD_ONEUNDER_FALG = "2";
    /** 随访-检查年龄阶段3=1~2岁检查  */
    public static final String CHILD_TWOUNDER_FALG = "3";
    /** 随访-检查年龄阶段3=4=3~6岁检查   */
    public static final String CHILD_SIXUNDER_FALG = "4";
    
    /** 死亡是否孕妇 -居民   */
    public static final String DEATH_FLAG_PERSON = "0";
    /** 死亡是否孕妇 -孕妇   */
    public static final String DEATH_FLAG_GRAVIDADETAIL = "1";
    /** 死亡是否孕妇 -儿童   */
    public static final String DEATH_FLAG_CHILD = "2";
    
    /** bdb存储数据库 - pacs_bdb */
    public static final String PACS_BDB = "1";
    /** bdb存储数据库 - lis_bdb */
    public static final String LIS_BDB = "2";
    /** bdb存储数据库 - patient_bdb */
    public static final String PATIENT_BDB = "3";
    /** bdb存储数据库 - emr_bdb */
    public static final String EMR_BDB = "4";

    /** 慢性病类型：1=高血压 */
    public static final String CHRONNIC_TYPE_HYP = "1";
    /** 慢性病类型：2=糖尿病 */
    public static final String CHRONNIC_TYPE_DM = "2";
    /** 慢性病类型：3=慢阻肺疾病 */
    public static final String CHRONNIC_TYPE_COPD = "3";
    /** 慢性病类型：4=冠心病 */
    public static final String CHRONNIC_TYPE_CHD = "4";
    /** 慢性病类型：5=脑卒中 */
    public static final String CHRONNIC_TYPE_CS = "5";
    /** 慢性病类型：6=肺结核  */
    public static final String CHRONNIC_TYPE_PTB = "6";
    /** 慢性病类型：7=肿瘤  */
    public static final String CHRONNIC_TYPE_TUM = "7";
    
    /** 重性精神病记录类型：1=登记  */
    public static final String INSANITY_REG_RECODE_TYPE = "1";
    /** 重性精神病记录类型：2=随访  */
    public static final String INSANITY_VISIT_RECODE_TYPE = "2";

    /** 居民档案 个人类别 : 6=老人 */
    public static final String PERSONALTYPE_ELDER = "7";
    
    /** 中医体质类别 ：1=气虚质  */
    public static final String TCM_QIXU = "1";
    /** 中医体质类别 ：2=阳虚质  */
    public static final String TCM_YANGXU = "2";
    /** 中医体质类别 ：3=阴虚质  */
    public static final String TCM_YINXU = "3";
    /** 中医体质类别 ：4=痰湿质  */
    public static final String TCM_TANSHI = "4";
    /** 中医体质类别 ：5=湿热质  */
    public static final String TCM_SHIRE = "5";
    /** 中医体质类别 ：6=血瘀质  */
    public static final String TCM_XUEYU = "6";
    /** 中医体质类别 ： 7=气郁质 */
    public static final String TCM_QIYU = "7";
    /** 中医体质类别 ： 8=特禀质  */
    public static final String TCM_TEBIN = "8";
    /** 中医体质类别 ： 9=平和质 */
    public static final String TCM_PINGHE = "9";
    
    /** 中医体质类别 ： 体质归属 ： 是 、 偏向是、 否 */
    public static final String CORPOREITY_BELONG_YES = "是";
    /** 中医体质类别 ： 体质归属 ： 是 、 偏向是、 否 */
    public static final String CORPOREITY_BELONG_NO = "否";
    /** 中医体质类别 ： 体质归属 ： 是 、 偏向是、 否 */
    public static final String CORPOREITY_BELONG_YES_PARTIAL = "偏向是";
    
    /** 健康教育活动形式 1=提供健康教育资料  */
    public static final String EDU_ACTIVITY_MATERIAL = "1";
    /** 健康教育活动形式 2=设置健康教育宣传栏  */
    public static final String EDU_ACTIVITY_PROPAGATE = "2";
    /** 健康教育活动形式 3=开展公众健康咨询活动  */
    public static final String EDU_ACTIVITY_INQUIRY = "3";
    /** 健康教育活动形式 4=举办健康知识讲座  */
    public static final String EDU_ACTIVITY_LECTURE = "4";
    
    /** 发放/播放标志 1=发放资料位置  */
    public static final String EDU_AREA_PUT = "1";
    /** 发放/播放标志 2=播放音像位置  */
    public static final String EDU_AREA_PALY = "2";
    
    
            

}
