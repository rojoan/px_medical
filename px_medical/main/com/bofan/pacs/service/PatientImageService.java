package com.bofan.pacs.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.pacs.command.PatientImageQueryInfo;
import com.bofan.pacs.valueobject.PatientImage;
import com.bofan.utils.DateHelper;
import com.bofan.utils.DicTools;

@Service
@Transactional
public class PatientImageService extends AbstractAnnoCommonService {
	 
    /**
     * 根据条件查询病人图像信息
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PatientImage> selectPatientImages(PatientImageQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 查询病人图像信息
     * @param info
     * @return
     */
    public PatientImage findPatientImage(PatientImageQueryInfo info) {
        List<PatientImage> list = selectPatientImages(info);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 根据条件查询病人图像信息
     * @param hospitalNo
     * @param htFsPacsMark
     * @param patientExamNum
     * @return
     */
    public List<PatientImage> selectPatientImageList(String hospitalNo, String htFsPacsMark, String patientExamNum) {
		//查询病人图片 或者dicom图片  
		PatientImageQueryInfo patientImageQueryInfo = new PatientImageQueryInfo();
		patientImageQueryInfo.setHospitalNo(hospitalNo);
		patientImageQueryInfo.setHtFsPacsMark(htFsPacsMark);
		patientImageQueryInfo.setPatientExamNum(patientExamNum);
		return this.selectPatientImages(patientImageQueryInfo);
		 
	}
    
    /** 创建dbdKey
     * @return dbdKey dbdKey
     */
    public String bulidBdbKey() {
        return DateHelper.getDateFormatStr(new Date(),"yyyyMMddHHmmss")  + DicTools.getRondomNum(4);
    }
    
    /**
     * 创建图像文件名称
     * @param hospitalNo
     * @return
     */
    public String bulidImageFileName() {
    	return DateHelper.getDateFormatStr(new Date(),"yyyyMMddHHmmss")  + DicTools.getRondomNum(4);
    }
 
}
