package com.bofan.publichealth.gravida.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.basesystem.common.Constants;
import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.controller.AbstractAnnotationController;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysUserInfo;
import com.bofan.publichealth.gravida.command.GravidaAuxExamQueryInfo;
import com.bofan.publichealth.gravida.command.GravidaDetailQueryInfo;
import com.bofan.publichealth.gravida.command.GravidaExamItemQueryInfo;
import com.bofan.publichealth.gravida.command.GravidaHealthGuideQueryInfo;
import com.bofan.publichealth.gravida.command.GravidaParturitionEditInfo;
import com.bofan.publichealth.gravida.command.GravidaParturitionQueryInfo;
import com.bofan.publichealth.gravida.command.GravidaSurgeryEditInfo;
import com.bofan.publichealth.gravida.command.GravidaSurgeryQueryInfo;
import com.bofan.publichealth.gravida.command.PostpartumVisitEditInfo;
import com.bofan.publichealth.gravida.command.PostpartumVisitQueryInfo;
import com.bofan.publichealth.gravida.command.PregnancyExamQueryInfo;
import com.bofan.publichealth.gravida.command.PregnancyFirstExamQueryInfo;
import com.bofan.publichealth.gravida.service.GravidaAuxExamService;
import com.bofan.publichealth.gravida.service.GravidaDetailService;
import com.bofan.publichealth.gravida.service.GravidaExamItemService;
import com.bofan.publichealth.gravida.service.GravidaHealthGuideService;
import com.bofan.publichealth.gravida.service.GravidaParturitionService;
import com.bofan.publichealth.gravida.service.GravidaPregnancyService;
import com.bofan.publichealth.gravida.service.GravidaSurgeryService;
import com.bofan.publichealth.gravida.service.PostpartumVisitService;
import com.bofan.publichealth.gravida.service.PregnancyExamItemService;
import com.bofan.publichealth.gravida.service.PregnancyExamService;
import com.bofan.publichealth.gravida.service.PregnancyFirstExamService;
import com.bofan.publichealth.gravida.valueobject.GravidaDetail;
import com.bofan.publichealth.gravida.valueobject.GravidaParturition;
import com.bofan.publichealth.gravida.valueobject.GravidaSurgery;
import com.bofan.publichealth.gravida.valueobject.PostpartumVisit;
import com.bofan.publichealth.gravida.valueobject.PregnancyExam;
import com.bofan.publichealth.gravida.valueobject.PregnancyFirstExam;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.manage.service.ManageService;

/**
 * @Description: 孕妇保健 -- 孕妇孕前体检Controller
 * @author lqw
 */
@Controller
@RequestMapping("/gravidaHeathCare")
public class GravidaHeathCareController  extends AbstractAnnotationController{
	
    /** logger */
    protected static Logger logger = Logger.getLogger(GravidaHeathCareController.class.getName());
	@Autowired
	private GravidaDetailService gravidaDetailService;
	@Autowired
	private PregnancyFirstExamService pregnancyFirstExamService;
	@Autowired
	private ManageService manageService;
	@Autowired
    private GravidaPregnancyService gravidaPregnancyService;
	@Autowired
	private GravidaExamItemService gravidaExamItemService;
	@Autowired
	private PregnancyExamItemService pregnancyExamItemService;
	@Autowired
	private GravidaAuxExamService gravidaAuxExamService;
	@Autowired
    private PregnancyExamService pregnancyExamService;
	@Autowired
	private GravidaHealthGuideService gravidaHealthGuideService;
	@Autowired
	private GravidaParturitionService gravidaParturitionService;
	@Autowired
	private PostpartumVisitService postpartumVisitService;
    @Autowired
    private GravidaSurgeryService gravidaSurgeryService;
   
    /**
     * 进入孕妇保健管理列表页面
     * @return
     */
    @RequestMapping("/gravidaHeathCareList.do")
    public String gravidaHeathCareList() {
        return "publichealth/gravida/gravidaHeathCareList";
    }
    
    /**
     * 进入 孕妇高危列表页面
     * @return
     */
    @RequestMapping("/gravidahighRiskList.do")
    public String gravidahighRiskList() {
        return "publichealth/gravida/gravidahighRiskList";
    }
    
    /**
     * 进入孕妇保健 操作页面
     * @param gravidaDetailId
     * @param model
     * @return
     */
    @RequestMapping("/gravidaHeathCareDetail.do")
    public String gravidaHeathCareDetail(Long gravidaDetailId, Model model) {
        GravidaDetail  gravidaDetail = this.gravidaDetailService.selectAObject(GravidaDetail.class,gravidaDetailId);
        List<PregnancyFirstExam> pregnancyFirstExamList = this.pregnancyFirstExamService.selectPregnancyFirstExamList(new PregnancyFirstExamQueryInfo(gravidaDetailId));
        List<PregnancyExam> pregnancyExamList = this.pregnancyExamService.selectPregnancyExamList(new PregnancyExamQueryInfo(gravidaDetailId));
        
        PostpartumVisitQueryInfo PostpartumVisitQueryInfo = new PostpartumVisitQueryInfo(gravidaDetailId);
        PostpartumVisitQueryInfo.setFortyTwoExamFlag(Contstants.NO_FLAG);
        List<PostpartumVisit> postpartumVisitList = this.postpartumVisitService.selectPostpartumVisitList(PostpartumVisitQueryInfo);
        PostpartumVisitQueryInfo.setFortyTwoExamFlag(Contstants.YES_FLAG);
        List<PostpartumVisit> fortyTwoVisitList = this.postpartumVisitService.selectPostpartumVisitList(PostpartumVisitQueryInfo);
        
        List<GravidaParturition> gravidaParturitionList = this.gravidaParturitionService.selectGravidaParturitionList(new GravidaParturitionQueryInfo(gravidaDetailId));
        List<GravidaSurgery> gravidaSurgeryList = this.gravidaSurgeryService.selectGravidaSurgeryList(new GravidaSurgeryQueryInfo(gravidaDetailId));
        
        model.addAttribute("gravidaDetailId",gravidaDetailId);
        model.addAttribute("gravidaDetail",gravidaDetail);
        model.addAttribute("pregnancyFirstExamList",pregnancyFirstExamList); //孕妇孕前体检列表
        model.addAttribute("pregnancyExamList",pregnancyExamList); //孕中期期检查记录表 
        model.addAttribute("gravidaParturitionList",gravidaParturitionList); //孕妇分娩记录表
        model.addAttribute("postpartumVisitList",postpartumVisitList);// 产后访视 列表
        model.addAttribute("fortyTwoVisitList",fortyTwoVisitList); //  产后42天检查 列表
        model.addAttribute("gravidaSurgeryList",gravidaSurgeryList); //产前筛查检查/手术记录 列表
        return "publichealth/gravida/gravidaHeathCareDetail";
    }
    
    /**
     * 获取分页列表数据
     * @param request
     * @param info
     * @return
     */
    @RequestMapping("/gravidaHeathCareListData.do")
    @ResponseBody
    public  Map<String, Object> listData(HttpServletRequest request,GravidaDetailQueryInfo info) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	Page page = this.gravidaDetailService.selectGravidaDetailPage(info);
        result.put("rows", page.getData());
        result.put("total", page.getTotalSize());
        return result;
    }
    
    /**
     * 编辑孕妇孕前体检
     * @param request
     * @param gravidaDetailId
     * @param model
     * @return
     */
    @RequestMapping("/editPregnancyFirstExam.do") 
    public String editPregnancyFirstExam(HttpServletRequest request, String mode, Long gravidaDetailId, Long pregnancyFirstExamId, Model model) {
        GravidaDetail  gravidaDetail = this.gravidaDetailService.selectAObject(GravidaDetail.class,gravidaDetailId);
        PregnancyFirstExam pregnancyFirstExam = null;
        
        if (null != pregnancyFirstExamId ) {
            pregnancyFirstExam = this.pregnancyFirstExamService.selectAObject(PregnancyFirstExam.class,pregnancyFirstExamId);
            
            model.addAttribute("gravidaPregnancyIdList",this.gravidaPregnancyService.selectGravidaPregnancyIdsList(pregnancyFirstExamId));//孕妇孕早期情况对照表中 pregnancyCaseId 列表集合
            model.addAttribute("gravidaExamItemList",this.gravidaExamItemService.selectGravidaExamItemList(new GravidaExamItemQueryInfo(pregnancyFirstExamId)));//孕妇早期情况对照表
            model.addAttribute("gravidaHealthGuideList",this.gravidaHealthGuideService.selectGravidaHealthGuideList(
                    new GravidaHealthGuideQueryInfo(pregnancyFirstExamId,null)));//孕妇保健指导 key为HealthGuideType的 列表集合
            model.addAttribute("gravidaAuxExamMap",this.gravidaAuxExamService.selectGravidaAuxExamMap(new GravidaAuxExamQueryInfo(pregnancyFirstExamId)));//妇孕检辅助检查项目   情况对照表 字典的 map集合
            model.addAttribute("gravidaExamItemMap",this.gravidaExamItemService.selectGravidaExamItemMap(new GravidaExamItemQueryInfo(pregnancyFirstExamId)));//孕妇孕检项目情况对照 key=孕检项目类型 的map
        } else {
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY); 
            Long currenUserUnitOrgId = userInfo.getSysOrg().getUnitOrgId();
            SysOrg sysOrg = this.manageService.loadSysOrg(currenUserUnitOrgId);
            pregnancyFirstExam = new PregnancyFirstExam();
            pregnancyFirstExam.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
            pregnancyFirstExam.setHospitalName(sysOrg.getName());
            pregnancyFirstExam.setTransDiagnosisOfficeId(userInfo.getOrgId());
            pregnancyFirstExam.setTransDiagnosisOfficeName(userInfo.getSysOrg().getName());
            pregnancyFirstExam.setDutyDoctorId(userInfo.getUserInfoId());
            pregnancyFirstExam.setDutyDoctorName(userInfo.getName());
        }
        
        model.addAttribute("mode",mode); //查看/编辑
        model.addAttribute("pregnancyFirstExam",pregnancyFirstExam); //孕产妇初次孕检记录
        model.addAttribute("gravidaDetail",gravidaDetail); //孕产妇登记卡
        model.addAttribute("pegnancyExamItemTypeMap",this.pregnancyExamItemService.selectExamItemTypeMap()); // 孕妇辅助检查项目 字典的 map集合 
        return "publichealth/gravida/pregnancyFirstExamEdit";
    }
    
    /**
     * 保存 孕妇孕前体检
     * @param pregnancyFirstExamRetionData
     * @return
     */
    @RequestMapping(value = "/savePregnancyFirstExam.jo")
    @ResponseBody 
    public JsonObj savePregnancyFirstExam(String pregnancyFirstExamRetionData) { 
        JsonObj result = new JsonObj();
        this.pregnancyFirstExamService.savePregnancyFirstExam(pregnancyFirstExamRetionData);
        return result;
    }
    
    /**
     * 删除  孕妇孕前体检
     * @param pregnancyFirstExamId
     * @return
     */
    @RequestMapping(value = "/delPregnancyFirstExam.jo")
    @ResponseBody 
    public JsonObj delPregnancyFirstExam(Long pregnancyFirstExamId) { 
        JsonObj result = new JsonObj();
        this.pregnancyFirstExamService.delPregnancyFirstExam(pregnancyFirstExamId);
        return result;
    }

    /**
     * 进入 孕妇孕期检查 编辑页面
     * @param request
     * @param gravidaDetailId
     * @param pregnancyExamId
     * @param model
     * @return
     */
    @RequestMapping("/editPregnancyExam.do") 
    public String editPregnancyExam(HttpServletRequest request, String mode, Long gravidaDetailId,Long pregnancyExamId, Model model) {
        GravidaDetail  gravidaDetail = this.gravidaDetailService.selectAObject(GravidaDetail.class,gravidaDetailId);
        PregnancyExam pregnancyExam = null;
        if (null != pregnancyExamId) {
            pregnancyExam = this.pregnancyExamService.selectAObject(PregnancyExam.class,pregnancyExamId);
            model.addAttribute("gravidaHealthGuideList",this.gravidaHealthGuideService.selectGravidaHealthGuideList(
                    new GravidaHealthGuideQueryInfo(null,pregnancyExamId)));//孕妇保健指导 key为HealthGuideType的 列表集合
        } else {
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY); 
            Long currenUserUnitOrgId = userInfo.getSysOrg().getUnitOrgId();
            SysOrg sysOrg = this.manageService.loadSysOrg(currenUserUnitOrgId);
            pregnancyExam = new PregnancyExam();
            pregnancyExam.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
            pregnancyExam.setHospitalName(sysOrg.getName());
            pregnancyExam.setTransDiagnosisOfficeId(userInfo.getOrgId());
            pregnancyExam.setTransDiagnosisOfficeName(userInfo.getSysOrg().getName());
            pregnancyExam.setDutyDoctorId(userInfo.getUserInfoId());
            pregnancyExam.setDutyDoctorName(userInfo.getName());
        }
        model.addAttribute("mode",mode); //查看/编辑
        model.addAttribute("gravidaDetail",gravidaDetail); //孕产妇登记卡
        model.addAttribute("pregnancyExam",pregnancyExam); //孕妇孕期检查
        return "publichealth/gravida/pregnancyExamEdit";
    }
    
    /**
     * 保存 孕妇孕期体检
     * @param pregnancyExamRetionData
     * @return
     */
    @RequestMapping(value = "/savePregnancyExam.jo")
    @ResponseBody 
    public JsonObj savePregnancyExam(String pregnancyExamRetionData) { 
        JsonObj result = new JsonObj();
        this.pregnancyExamService.savePregnancyExam(pregnancyExamRetionData);
        return result;
    }
    
    /**
     * 删除  孕妇孕期体检
     * @param pregnancyExamId
     * @return
     */
    @RequestMapping(value = "/delPregnancyExam.jo")
    @ResponseBody 
    public JsonObj delPregnancyExam(Long pregnancyExamId) { 
        JsonObj result = new JsonObj();
        PregnancyExam  pregnancyExam = this.pregnancyExamService.selectAObject(PregnancyExam.class, pregnancyExamId);
        this.pregnancyExamService.deleteAObject(pregnancyExam);
        return result;
    } 
     
    /**
     * 进入 编辑 孕妇分娩记录
     * @param request
     * @param gravidaDetailId
     * @param gravidaParturitionId
     * @param model
     * @return
     */
    @RequestMapping("/editGravidaParturition.do") 
    public String editGravidaParturition(HttpServletRequest request,String mode, Long gravidaDetailId, Long gravidaParturitionId, Model model) {
        GravidaDetail  gravidaDetail = this.gravidaDetailService.selectAObject(GravidaDetail.class,gravidaDetailId);
        GravidaParturition gravidaParturition = null;
        
        if (null != gravidaParturitionId ) {
            gravidaParturition = this.gravidaParturitionService.selectAObject(GravidaParturition.class,gravidaParturitionId);
        } else {
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY); 
            Long currenUserUnitOrgId = userInfo.getSysOrg().getUnitOrgId();
            SysOrg sysOrg = this.manageService.loadSysOrg(currenUserUnitOrgId);
            gravidaParturition = new GravidaParturition();
            gravidaParturition.setGravidaName(gravidaDetail.getGravidaName());
            gravidaParturition.setGravidaAge(gravidaDetail.getGravidaAge());
            gravidaParturition.setRegionId(gravidaDetail.getRegionId());
            gravidaParturition.setGravidaDetailId(gravidaDetailId);
            gravidaParturition.setPersonDetailId(gravidaDetail.getPersonDetailId());
            gravidaParturition.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
            gravidaParturition.setHospitalName(sysOrg.getName());
            gravidaParturition.setDeliverDoctorName(userInfo.getName());
            gravidaParturition.setDeliverDoctorId(userInfo.getUserInfoId());
        }
        model.addAttribute("mode",mode); //查看/编辑
        model.addAttribute("gravidaParturition",gravidaParturition); //孕妇分娩记录
        model.addAttribute("gravidaDetail",gravidaDetail); //孕产妇登记卡
        return "publichealth/gravida/gravidaParturitionEdit";
    }
    
    /**
     * 保存孕妇分娩记录
     * @param pregnancyFirstExamRetionData
     * @return
     */
    @RequestMapping(value = "/saveGravidaParturition.jo")
    @ResponseBody 
    public JsonObj saveGravidaParturition(GravidaParturitionEditInfo gravidaParturitionEditInfo) { 
        JsonObj result = new JsonObj();
        this.gravidaParturitionService.saveGravidaParturition(gravidaParturitionEditInfo);
        return result;
    } 
    
    /**
     *  删除 孕妇分娩记录
     * @param gravidaParturitionId
     * @return
     */
    @RequestMapping(value = "/delGravidaParturition.jo")
    @ResponseBody 
    public JsonObj delGravidaParturition(Long gravidaParturitionId) { 
        JsonObj result = new JsonObj();
        GravidaParturition  gravidaParturition = this.gravidaParturitionService.selectAObject(GravidaParturition.class, gravidaParturitionId);
        this.gravidaParturitionService.deleteAObject(gravidaParturition);
        return result;
    }
    
    /**
     * 编辑 产后访视--42天检查
     * @param request
     * @param gravidaDetailId
     * @param postpartumVisitId
     * @param model
     * @return
     */
    @RequestMapping("/editPostpartumVisit.do") 
    public String editPostpartumVisit(HttpServletRequest request, String mode, Long gravidaDetailId,Long postpartumVisitId, String fortyTwoExamFlag, Model model) {
        GravidaDetail  gravidaDetail = this.gravidaDetailService.selectAObject(GravidaDetail.class,gravidaDetailId);
        PostpartumVisit postpartumVisit = null;
        
        if (null != postpartumVisitId ) {
            postpartumVisit = this.postpartumVisitService.selectAObject(PostpartumVisit.class,postpartumVisitId);
        }else{
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY); 
            Long currenUserUnitOrgId = userInfo.getSysOrg().getUnitOrgId();
            SysOrg sysOrg = this.manageService.loadSysOrg(currenUserUnitOrgId);
            postpartumVisit = new PostpartumVisit();
            postpartumVisit.setGravidaName(gravidaDetail.getGravidaName());
            postpartumVisit.setRegionId(gravidaDetail.getRegionId());
            postpartumVisit.setGravidaDetailId(gravidaDetailId);
            postpartumVisit.setPersonDetailId(gravidaDetail.getPersonDetailId());
            postpartumVisit.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
            postpartumVisit.setHospitalName(sysOrg.getName());
            postpartumVisit.setVisitDoctorName(userInfo.getName());
            postpartumVisit.setVisitDoctorId(userInfo.getUserInfoId());
            postpartumVisit.setFortyTwoExamFlag(fortyTwoExamFlag);
        }
        
        model.addAttribute("mode",mode); //查看/编辑
        model.addAttribute("postpartumVisit",postpartumVisit); //孕妇分娩记录
        model.addAttribute("gravidaDetail",gravidaDetail); //孕产妇登记卡
        return "publichealth/gravida/postpartumVisitEdit";
    }
    
    /**
     * 保存 产后访视--42天检查
     * @param postpartumVisitEditInfo
     * @return
     */
    @RequestMapping(value = "/savePostpartumVisit.jo")
    @ResponseBody 
    public JsonObj savePostpartumVisit(PostpartumVisitEditInfo postpartumVisitEditInfo) { 
        JsonObj result = new JsonObj();
        this.postpartumVisitService.savePostpartumVisit(postpartumVisitEditInfo);
        return result;
    } 
    
    /**
     *  删除  产后访视--42天检查
     * @param postpartumVisitId
     * @return
     */
    @RequestMapping(value = "/delPostpartumVisit.jo")
    @ResponseBody 
    public JsonObj delPostpartumVisit(Long postpartumVisitId) { 
        JsonObj result = new JsonObj();
        PostpartumVisit  postpartumVisit = this.postpartumVisitService.selectAObject(PostpartumVisit.class, postpartumVisitId);
        this.postpartumVisitService.deleteAObject(postpartumVisit);
        return result;
    }
    
    /**
     * 产前筛查检查/手术记录表 
     * @param request
     * @param gravidaDetailId
     * @param gravidaSurgeryId
     * @param model
     * @return
     */
    @RequestMapping("/editGravidaSurgery.do")
    public String editGravidaSurgery(HttpServletRequest request, String mode, Long gravidaDetailId,Long gravidaSurgeryId, Model model) {
        GravidaDetail  gravidaDetail = this.gravidaDetailService.selectAObject(GravidaDetail.class,gravidaDetailId);
        GravidaSurgery gravidaSurgery = null;
        
        if (null != gravidaSurgeryId ) {
            gravidaSurgery = this.gravidaSurgeryService.selectAObject(GravidaSurgery.class, gravidaSurgeryId);
            model.addAttribute("surgeryWayId",this.gravidaSurgeryService.selectGravidaSurgeryWayId(gravidaSurgeryId));//手术检查方式
        }else{
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY); 
            Long currenUserUnitOrgId = userInfo.getSysOrg().getUnitOrgId();
            SysOrg sysOrg = this.manageService.loadSysOrg(currenUserUnitOrgId);
            gravidaSurgery = new GravidaSurgery();
            gravidaSurgery.setGravidaName(gravidaDetail.getGravidaName());
            gravidaSurgery.setRegionId(gravidaDetail.getRegionId());
            gravidaSurgery.setGravidaDetailId(gravidaDetailId);
            gravidaSurgery.setPersonDetailId(gravidaDetail.getPersonDetailId());
            gravidaSurgery.setHospitalId(userInfo.getSysOrg().getUnitOrgId());
            gravidaSurgery.setHospitalName(sysOrg.getName());
            gravidaSurgery.setDutyDoctorName(userInfo.getName());
            gravidaSurgery.setDutyDoctorId(userInfo.getUserInfoId());
        }
        
        model.addAttribute("mode",mode); //查看/编辑
        model.addAttribute("gravidaSurgery",gravidaSurgery); //产前筛查检查/手术记录表 
        model.addAttribute("gravidaDetail",gravidaDetail); //孕产妇登记卡
        return "publichealth/gravida/gravidaSurgeryEdit";
    }
    
    /**
     * 保存 产前筛查检查/手术记录
     * @param gravidaSurgeryEditInfo
     * @return
     */
    @RequestMapping(value = "/saveGravidaSurgery.jo")
    @ResponseBody 
    public JsonObj saveGravidaSurgery(GravidaSurgeryEditInfo gravidaSurgeryEditInfo) { 
        JsonObj result = new JsonObj();
        this.gravidaSurgeryService.saveGravidaSurgery(gravidaSurgeryEditInfo);
        return result;
    } 
    
    /**
     * 删除 产前筛查检查/手术记录
     * @param gravidaSurgeryId
     * @return
     */
    @RequestMapping(value = "/delGravidaSurgery.jo")
    @ResponseBody 
    public JsonObj delGravidaSurgery(Long gravidaSurgeryId) { 
        JsonObj result = new JsonObj();
        GravidaSurgery  gravidaSurgery = this.gravidaSurgeryService.selectAObject(GravidaSurgery.class, gravidaSurgeryId);
        this.gravidaSurgeryService.deleteAObject(gravidaSurgery);
        return result;
    }
    
}
