package com.bofan.pacs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.dictionary.support.DictionarysInVelocityToolbox;
import com.bofan.his.service.PatientService;
import com.bofan.his.valueobject.Patient;
import com.bofan.pacs.command.PatientImageQueryInfo;
import com.bofan.pacs.service.ExamResultService;
import com.bofan.pacs.service.PacsDetailService;
import com.bofan.pacs.service.PatientExamService;
import com.bofan.pacs.service.PatientImageService;
import com.bofan.pacs.valueobject.ExamResult;
import com.bofan.pacs.valueobject.PatientExam;
import com.bofan.pacs.valueobject.PatientImage;
import com.bofan.pacs.webservice.IPacsService;
import com.bofan.reconsult.command.EmrKbDetailQueryInfo;
import com.bofan.reconsult.command.ReConsultingEditInfo;
import com.bofan.reconsult.service.EmrKbService;
import com.bofan.reconsult.service.ReConsultingService;
import com.bofan.reconsult.valueobject.EmrKbDetail;
import com.bofan.reconsult.valueobject.EmrKbType;
import com.bofan.reconsult.valueobject.ReConsulting;
import com.bofan.utils.Contstants;
import com.bofan.utils.DateHelper;
import com.bofan.utils.JsonObj;
import com.bofan.utils.ResponseContstants;

import sun.misc.BASE64Encoder;

/**
 * @Description: 病人检查报告控制层
 * @author lqw
 * @date 2017-9-30
 * @version V1.0
 */
@Controller
@RequestMapping("/report")
public class PatientExamReportController {
    /** logger */
    protected static Logger logger = Logger.getLogger(PatientExamReportController.class.getName());
	@Autowired
	private PatientExamService patientExamService;
	//@Autowired
	//private PatientArchiveService patientArchiveService;   
	@Autowired
	private ExamResultService examResultService;
	@Autowired
	private PatientImageService patientImageService; 
	@Autowired
    private IPacsService pacsService; 
    @Autowired
    private EmrKbService emrKbService;
    @Autowired
	private PatientService patientService;
    @Autowired
    private PacsDetailService pacsDetailService;
    
    @Autowired
    private ReConsultingService reConsultingService;
	 
	/** 病人图像显示的张数 **/
	private int patientImageCount = 3; 
    /** pacs第一张图像Index  */
    private int pacsImgFirstIndex = 0;
    /** pacs第一张图像Index  */
    private int pacsImgSecondIndex = 1;
    /** pacs第三张图像Index  */
    private int pacsImgThirdIndex = 2;
    
    /**
     * 跳转到报告打印页面
     * @param patientExamId
     * @param model
     * @return
     */
    @RequestMapping("/show.do")
    public String printReport(Long reConsultingId, Model model) {
    	model.addAttribute("reConsultingId", reConsultingId);
    	return "pacs/printReport";
    }
    
    @RequestMapping("/examResultEdit.do")
    public String examResultEdit(HttpServletRequest request,Long patientExamId, Long reConsultingId, Model model) {
 
    	// 查询病人检查信息
    	PatientExam patientExam = this.patientExamService.selectAObject(PatientExam.class, patientExamId);

    	// 会诊信息
    	ReConsulting consulting = this.reConsultingService.selectReConsultingById(reConsultingId);
    	
    	//根据影像科室标识判断患者检查类型 
		List<String> patientExamJpgList = new ArrayList<String>();
    	if (null != patientExam && Contstants.IMAGETYPE_DICOM != patientExam.getImageType()) { 
    		// 读取 病理、或者内镜、或者超声JPG图片
    		//查询病人图片 或者dicom图片  
        	PatientImageQueryInfo patientImageQueryInfo = new PatientImageQueryInfo();
        	
        	patientImageQueryInfo.setHospitalNo(patientExam.getHospitalNo());
        	patientImageQueryInfo.setHtFsPacsMark(patientExam.getHtFsPacsMark());
        	patientImageQueryInfo.setPatientExamNum(patientExam.getPatientExamNum());
        	List<PatientImage> patientImageList = this.patientImageService.selectPatientImages(patientImageQueryInfo);
        	if (null != patientImageList && patientImageList.size() > 0) {
    			for (PatientImage patientImage : patientImageList) {
    				//通过bdbkey获取二进制文件 
    				byte[] dicomByteArray = null;
    				try {
    					dicomByteArray = this.pacsService.getFileByte(patientImage.getSavePath(),patientImage.getBdbKey());
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
    				 // 对字节数组Base64编码  
    		        BASE64Encoder encoder = new BASE64Encoder();  
    		        // 添加Base64编码过的字节数组字符串  
    				patientExamJpgList.add(encoder.encode(dicomByteArray));
    			}
    		}
		}
    	//SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);
         
    	model.addAttribute("patientExamJpgList", patientExamJpgList);
    	model.addAttribute("patientExam", patientExam);
    	model.addAttribute("consulting", consulting);
    	//model.addAttribute("doctorList",  this.manageService.selectDepartmentStaffByUnitId(userInfo.getSysOrg().getUnitOrgId(), true));
    	
    	return "pacs/examResultEdit";
    }
    
    /**
     * 保存检查结果信息
     * @param info
     * @param model
     * @return
     */
    @RequestMapping(value = "/saveExamResult.jo", method = RequestMethod.POST)
    @ResponseBody
    public JsonObj saveExamResult(ReConsultingEditInfo info) {
        JsonObj result = new JsonObj();
        if (null == info.getReConsultingId()) {
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            result.setMsg("保存失败");
            return result;
        }
        ReConsulting consulting = this.reConsultingService.selectReConsultingById(info.getReConsultingId());
        if (null == consulting) {
            result.setCode(ResponseContstants.RESULT_FAIL_CODE);
            result.setMsg("保存失败");
            return result;
        }
        
        consulting.setExamFinding(info.getExamFinding());
        consulting.setExamHint(info.getExamHint());
        consulting.setDiagnosticOpinion(info.getDiagnosticOpinion());
        this.reConsultingService.saveAObject(consulting);
        
        result.setCode(ResponseContstants.RESULT_SUCCESS_CODE);
        result.setMsg("保存成功");
        return result;
    }
    
    /**
     * 获取打印报告信息
     * @param patientExamId
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("/fsExamData.do")
    @ResponseBody
    public  Map<String, Object> reportData(Long reConsultingId){
        Map<String,Object> reportData = new HashMap<String,Object>();
        if (null == reConsultingId) {
            return reportData;
        }
        
        // 远程会诊信息
        ReConsulting consulting = this.reConsultingService.selectReConsultingById(reConsultingId);
        
        if (null == consulting) {
            return reportData;
        }
        
    	// 查询病人检查信息
        PatientExam patientExam = null;
    	if (null != consulting.getPatientExamId()) {
    	    patientExam = this.patientExamService.selectAObject(PatientExam.class, consulting.getPatientExamId());
    	}
    	
    	// 查询病人信息
    	Patient patient = null;
        if (null != consulting.getPatientId()) {
            patient = this.patientService.selectAObject(Patient.class, consulting.getPatientId());
        }

    	// 封装报告的json数据
    	Map<String,Object> data = new HashMap<String,Object>();
    	data.put("hospitalName", consulting.getMedicalInstitutionName());//需要建立 医院字典表
    	data.put("patientName", consulting.getPatientName());
    	data.put("outpatientNumber", consulting.getInpatientId());
    	data.put("examFindings",consulting.getExamFinding());
        data.put("examHint", consulting.getExamHint()); 
        data.put("diagnosticOpinion", consulting.getDiagnosticOpinion()); 
    	
    	if (null != patientExam) {
    	    data.put("examChildType", patientExam.getExamChildType());
    	    data.put("patientExamNum", patientExam.getPatientExamNum());
    	    data.put("admissionNum", patientExam.getAdmissionNum());
    	    data.put("applyDept", patientExam.getApplyDept());
            data.put("applyDoctor", patientExam.getApplyDoctor());
            data.put("examPart", patientExam.getExamPart());
            data.put("bedNum", patientExam.getBedNum());
            data.put("diagnosisDoctor", patientExam.getDiagnosisDoctor());
            data.put("auditDoctor", patientExam.getAuditDoctor());
            if (null != patientExam.getExamDate()) {
                data.put("examDate", DateHelper.getDateStr(patientExam.getExamDate()));
            }
    	}
    	
    	if (null != patient) {
    	    Map dicSexMap = (Map) DictionarysInVelocityToolbox.getDictionary("dicSex");
            data.put("patientSex", dicSexMap.get(patient.getPatientSex()));
            data.put("patientAge",patient.getCurrentAge());
        }

    	//检查图像
    	if (null != patientExam && Contstants.IMAGETYPE_DICOM != patientExam.getImageType()) { 
    		// 读取 病理、或者内镜、或者超声JPG图片
        	PatientImageQueryInfo PatientImageQueryInfo = new PatientImageQueryInfo();
        	PatientImageQueryInfo.setHospitalNo(patientExam.getHospitalNo());
        	PatientImageQueryInfo.setHtFsPacsMark(patientExam.getHtFsPacsMark());
        	PatientImageQueryInfo.setPatientExamNum(patientExam.getPatientExamNum());
        	List<PatientImage> patientImageList = this.patientImageService.selectPatientImages(PatientImageQueryInfo);
        	if (null != patientImageList && patientImageList.size() > 0) { 
        		for (int pacsImgIndex = 0; pacsImgIndex < patientImageList.size(); pacsImgIndex++) {
    				if (pacsImgIndex == patientImageCount) {//取指定数量的图片
    					break;
    				}  
    				PatientImage patientImage = patientImageList.get(pacsImgIndex);
    				//通过bdbkey获取二进制文件
    				byte[]  dicomByteArray = this.pacsService.getFileByte(patientImage.getSavePath(),patientImage.getBdbKey());
    				 // 对字节数组Base64编码  
    		        BASE64Encoder encoder = new BASE64Encoder();  
    		        // 添加Base64编码过的字节数组字符串  
    				if (pacsImgIndex == this.pacsImgFirstIndex) {
    					data.put("dicomImgFirst", encoder.encode(dicomByteArray));
					}else if (pacsImgIndex == this.pacsImgSecondIndex) {
						data.put("dicomImgSencond", encoder.encode(dicomByteArray));
					}else if (pacsImgIndex == this.pacsImgThirdIndex) {
						data.put("dicomImgThird", encoder.encode(dicomByteArray));
					}
    			}
    		}
		} else {
			//放射图片
			String savePath = this.pacsDetailService.selectSavePath(consulting.getPatientExamId());
			byte[] dicomByteArray = this.pacsService.getFileByte(savePath,Contstants.DICM_BASE64_KEY + consulting.getPatientExamId());
				String dicomImageStr = new String(dicomByteArray) ;
				String[] dimImages = dicomImageStr.split(Contstants.STRING_SEPARATOR);
				if (dimImages.length > 0) {
					for (int pacsImgIndex = 0; pacsImgIndex < dimImages.length; pacsImgIndex++) {
						if (pacsImgIndex == patientImageCount) {
	    					break;
	    				}
						if (pacsImgIndex == this.pacsImgFirstIndex) {
	    					data.put("dicomImgFirst", dimImages[pacsImgIndex]);
						}else if (pacsImgIndex == this.pacsImgSecondIndex) {
							data.put("dicomImgSencond", dimImages[pacsImgIndex]);
						}else if (pacsImgIndex == this.pacsImgThirdIndex) {
							data.put("dicomImgThird", dimImages[pacsImgIndex]);
						}
					}
				}
		}
 
    	List<Object> list = new ArrayList<Object>();
    	list.add(data);
    	reportData.put("reportData", list);
    	return reportData;
    }
    
    /**
     * 检查信息查看
     * @param info
     * @return
     */
    @RequestMapping("/examInfoShow.do")
    public String examInfoShow(HttpServletRequest request,Long patientExamId,String mode, Model model) {
        if (null == patientExamId) {
            throw new RuntimeException("patientExamId is null");
        }
        
    	// 查询病人检查信息
    	PatientExam patientExam = this.patientService.selectAObject(PatientExam.class, patientExamId);
    	if (null == patientExam) {
    	    return "pacs/examInfoShow";
    	}
    	
    	if (StringUtils.isNotEmpty(patientExam.getHospitalNo()) 
    	        && StringUtils.isNotEmpty(patientExam.getHtFsPacsMark()) 
    	        && StringUtils.isNotEmpty(patientExam.getPatientExamNum())) {
        	//查询病人检查结果表
        	ExamResult  examResult  = this.examResultService.findExamResult(patientExam.getHospitalNo(), patientExam.getHtFsPacsMark(), patientExam.getPatientExamNum());
        	model.addAttribute("examResult", examResult);
    	}
    	
    	if (StringUtils.isNotEmpty(patientExam.getImageType())) {
            // 读取检查 JPG图片
            List<String> patientExamJpgList = new ArrayList<String>();
            if (Contstants.IMAGETYPE_DICOM != patientExam.getImageType()) { 
                patientExamJpgList = selectExamBase64Image(patientExam.getHospitalNo(),patientExam.getHtFsPacsMark(), patientExam.getPatientExamNum());
            } 
            model.addAttribute("patientExamJpgList", patientExamJpgList);
        }
    	
        model.addAttribute("patient", this.patientService.selectAObject(Patient.class, patientExam.getPatientId()));
    	model.addAttribute("patientExam", patientExam);
    	if ("pacsImage".equals(mode)) {
    		return "gradingclinics/pacsImage";
		}
    	
        return "pacs/examInfoShow";
    }

	/**
	 * 查询病人图像转出base64图像数据
	 * @param hospitalNo
	 * @param htFsPacsMark
	 * @param patientExamNum
	 * @return
	 */
	private List<String> selectExamBase64Image(String hospitalNo, String htFsPacsMark, String patientExamNum) {
		List<String> examBase64ImgList = new ArrayList<String>();
		List<PatientImage> patientImageList = this.patientImageService.selectPatientImageList(hospitalNo,htFsPacsMark,patientExamNum);
		if (null != patientImageList && patientImageList.size() > 0) {
			for (int i = 0; i < patientImageList.size(); i++) {
				//通过bdbkey获取二进制文件
				byte[]  dicomByteArray = this.pacsService.getFileByte(patientImageList.get(i).getSavePath(), patientImageList.get(i).getBdbKey());
				if (null == dicomByteArray) {
				    dicomByteArray = new byte[0];
				}
				// 对字节数组Base64编码  
		        BASE64Encoder encoder = new BASE64Encoder();  
		        // 添加Base64编码过的字节数组字符串  
				examBase64ImgList.add(encoder.encode(dicomByteArray));
			}
		}
		return examBase64ImgList;
	}
    
    /**
     * 查询知识库树的json数据
     */
    @RequestMapping("/emrKbTypeTree.do")
    @ResponseBody
    public  List<Map<String,Object>> emrKbTypeTree(String topEmrKbTypeCode){
    	List<Map<String,Object>> emrKbTypeListTree = new ArrayList<Map<String,Object>>();
    	//查询知识库类型列表
    	List<EmrKbType> emrKbTypeList = emrKbService.selectEmrKbType(null);
    	 
    	if (emrKbTypeList == null || emrKbTypeList.size() == 0){
    		return emrKbTypeListTree;
    	}

		// 将emrKbTypeCode 与 emrKbTypeId 映射到Map
		Map<String,Long> emrKbyTypeMap = new HashMap<String,Long>();
		for (EmrKbType emrKbType : emrKbTypeList) {
			emrKbyTypeMap.put(emrKbType.getEmrKbTypeCode(), emrKbType.getEmrKbTypeId());
		}
		// 组装jsTree的树形结构json数组
		for (EmrKbType emrKbType : emrKbTypeList) {
			//根据某个顶级节点的code获取数据列表
			if (StringUtils.isNotBlank(topEmrKbTypeCode)) {
				if (emrKbType.getEmrKbTypeCode().startsWith(topEmrKbTypeCode)) {
					buildTreeData(emrKbTypeListTree,emrKbyTypeMap, emrKbType);
				}
			//所有顶级节点的code获取数据列表
			} else {
				buildTreeData(emrKbTypeListTree,emrKbyTypeMap, emrKbType);
			}
		}
		 
    	return emrKbTypeListTree;
    }

	/**
	 * 创建知识库树的数据结构对象
	 * @return List<Map<String,Object>> 知识库树的数据结构对象
	 * @param emrKbyTypeMap 知识库类型映射集合 Map<emrKbTypeCode,emrKbTypeId>
	 * @param emrKbType 知识库类型对象
	 */
	private void buildTreeData(List<Map<String,Object>> emrKbTypeListTree,Map<String, Long> emrKbyTypeMap, EmrKbType emrKbType) {
		Map<String,Object> emrKbyTypeMapTree = new HashMap<String,Object>();//树的单个节点
		//设置节点的属性:id
		emrKbyTypeMapTree.put("id", emrKbyTypeMap.get(emrKbType.getEmrKbTypeCode()));
		//设置节点的属性:parent
		int len = emrKbType.getEmrKbTypeCode().length();
		String parentTypeCode = emrKbType.getEmrKbTypeCode().substring(0, len-3);
		emrKbyTypeMapTree.put("parent",emrKbyTypeMap.get(parentTypeCode) != null?emrKbyTypeMap.get(parentTypeCode):"#"); 
		
		//设置节点的属性:text
		emrKbyTypeMapTree.put("text",emrKbType.getEmrKbTypeName());
		
		//设置节点的其他属性
		Map<String,Object> li_attr = new HashMap<String,Object>();
		li_attr.put("nodeType", "emrKbType");
		emrKbyTypeMapTree.put("li_attr",li_attr);
		emrKbTypeListTree.add(emrKbyTypeMapTree);
	}
    
    /**
     * 查询知识库类型查询知识库信息
     */
    @RequestMapping("/findEmrKbDetail.do")
    @ResponseBody
    public  List<EmrKbDetail> findEmrKbDetail(Long emrKbTypeId){
    	EmrKbDetailQueryInfo queryInfo = new EmrKbDetailQueryInfo();
    	queryInfo.setEmrKbTypeId(emrKbTypeId);
    	return emrKbService.selectEmrKbDetail(queryInfo);
    }
    
    /**
     * 查询pacs检查结果
     * @param patientExamId
     * @param model
     * @return
     */
    @RequestMapping("/showPacs.do")
    public String showPacs(Long patientExamId, Model model) {
        if (null == patientExamId) {
            return "pacs/showPacs";
        }
        PatientExam patientExam = this.patientExamService.selectAObject(PatientExam.class, patientExamId);
        if (null == patientExam) {
        	return "pacs/showPacs";
        }
        
        // 读取 病理、或者内镜、或者超声JPG图片
        List<String> patientExamJpgList = new ArrayList<String>();
        //查询病人图片 或者dicom图片 
        PatientImageQueryInfo PatientImageQueryInfo = new PatientImageQueryInfo();
        
        if (Contstants.IMAGETYPE_DICOM != patientExam.getImageType()) { 
            PatientImageQueryInfo.setHospitalNo(patientExam.getHospitalNo());
            PatientImageQueryInfo.setHtFsPacsMark(patientExam.getHtFsPacsMark());
            PatientImageQueryInfo.setPatientExamNum(patientExam.getPatientExamNum());
            List<PatientImage> patientImageList = this.patientImageService.selectPatientImages(PatientImageQueryInfo);
            if (null != patientImageList && patientImageList.size() > 0) {
            	 
                for (PatientImage dicom : patientImageList) {
                     //通过bdbkey获取二进制文件
                    byte[] dicomByteArray = null;
                    try {
                        dicomByteArray = this.pacsService.getFileByte(dicom.getSavePath(),dicom.getBdbKey());
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                     // 对字节数组Base64编码  
                    BASE64Encoder encoder = new BASE64Encoder();  
                    // 添加Base64编码过的字节数组字符串  
                    patientExamJpgList.add(encoder.encode(dicomByteArray));
                }
            }
        }
        model.addAttribute("patient", this.patientService.selectAObject(Patient.class, patientExam.getPatientId()));
        model.addAttribute("patientExam", patientExam);
        model.addAttribute("patientExamJpgList", patientExamJpgList);
        return "pacs/showPacs";
    }

}
