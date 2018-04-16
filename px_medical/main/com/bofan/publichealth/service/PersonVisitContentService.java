package com.bofan.publichealth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonVisitContentIdQueryInfo;
import com.bofan.publichealth.command.PersonVisitContentQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronicVisit;
import com.bofan.publichealth.valueobject.PersonVisitContent;
import com.bofan.utils.Contstants;

/**
 * @Description 慢性病随访--报导内容业务类
 * @author xlf
 * @version 
 * 2017-11-01
 */
@Service
public class PersonVisitContentService extends AbstractAnnoCommonService {

    /**
     * 获取慢性病随访--报导内容ID
     * @param chronicVisitId
     * @param personDetailId
     * @return
     */
    @Transactional
    public List<String> selectPersonVisitContentId(Long chronicVisitId, Long personDetailId, String chronicType) {
        PersonVisitContentIdQueryInfo queryInfo = new PersonVisitContentIdQueryInfo();
        queryInfo.setChronicVisitId(chronicVisitId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(String.class, qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存慢性病随访--报导内容
     * @param visitSignTypes
     * @param chronicVisit
     * @param chronicType
     */
    public void savePersonVisitContent(String[] visitContentTypes, PersonChronicVisit chronicVisit, String chronicType) {
        List<PersonVisitContent> cureList = this.selectPersonVisitContent(chronicVisit.getPersonChronicId(), chronicVisit.getPersonDetailId(), chronicType);
        if (null == visitContentTypes || visitContentTypes.length <= 0) {
            if (null != cureList && cureList.size() > 0) {
                super.deleteAll(cureList);
            }
            return ;
        }
        
        int index = 0;
        int maxIndex = (null != cureList ? cureList.size() : 0);
        PersonVisitContent visitContent = null;
        for (String type : visitContentTypes) {
            visitContent = ((maxIndex > 0 && maxIndex > index) ? cureList.get(0) : null);
            if (null != visitContent) {
                cureList.remove(0);
            } else {
                visitContent = new PersonVisitContent();
            }
            visitContent.setValidFlag(Contstants.YES_FLAG);
            visitContent.setChronicType(chronicType);
            visitContent.setVisitTime(chronicVisit.getVisitTime());
            visitContent.setVisitDoctorId(chronicVisit.getVisitDoctorId());
            visitContent.setHospitalId(chronicVisit.getHospitalId());
            visitContent.setContentType(type);
            visitContent.setChronicVisitId(chronicVisit.getChronicVisitId());
            visitContent.setPersonDetailId(chronicVisit.getPersonDetailId());
            visitContent.setPersonChronicId(chronicVisit.getPersonChronicId());
            
            index++;
            super.save(visitContent);
        }
        
        if (null != cureList && cureList.size() > 0) {
            for (PersonVisitContent content : cureList) {
                super.delete(content);
            }
        }
    }
    
    /**
     * 获取慢性病随访--报导内容
     * @param chronicVisitId
     * @param personDetailId
     * @return
     */
    private List<PersonVisitContent> selectPersonVisitContent(Long chronicVisitId, Long personDetailId, String chronicType) {
        PersonVisitContentQueryInfo queryInfo = new PersonVisitContentQueryInfo();
        queryInfo.setChronicVisitId(chronicVisitId);
        queryInfo.setPersonDetailId(personDetailId);
        queryInfo.setChronicType(chronicType);
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(PersonVisitContent.class, qo.getQueryString(), qo.getParam());
    }
    
}