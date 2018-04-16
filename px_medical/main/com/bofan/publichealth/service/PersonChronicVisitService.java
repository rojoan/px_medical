package com.bofan.publichealth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.PersonChronicVisitEditInfo;
import com.bofan.publichealth.command.PersonChronicVisitQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronicVisit;
import com.bofan.publichealth.valueobject.PersonVisitItem;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 慢性病患者随访记录业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class PersonChronicVisitService extends AbstractAnnoCommonService {

    @Autowired
    private PersonVisitCureService personVisitCureService;
    @Autowired
    private PersonVisitSignService personVisitSignService;
    @Autowired
    private PersonVisitDrugService personVisitDrugService;
    @Autowired
    private PersonVisitContentService personVisitContentService;
    @Autowired
    private PersonVisitChronicSymService personVisitChronicSymService;
    
    /**
     * 慢性病患者随访分页列表
     * @param queryInfo
     * @return
     */
    public Page selectPersonChronicVisitList(PersonChronicVisitQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new PersonChronicVisitQueryInfo();
        }
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 保存慢性病患者随访（包括高血压、糖尿病等）
     * @param info
     */
    public void savePersonChronicVisit(PersonChronicVisitEditInfo info) {
        // 保存主表信息 
        PersonChronicVisit chronicVisit = null;
        if(null != info.getChronicVisitId()) {
            // 修改
            chronicVisit = super.selectAObject(PersonChronicVisit.class, info.getChronicVisitId());
        } else {
            // 新增
            chronicVisit = new PersonChronicVisit();
            chronicVisit.setValidFlag(Contstants.YES_FLAG);
        }
        NullBeanUtils.copyProperties(chronicVisit, info);
        super.saveAndRefresh(chronicVisit);
        info.setChronicVisitId(chronicVisit.getChronicVisitId());
        
        // 随访--体征/检查/生活指导/治疗情况
        this.savePersonVisitItem(info, chronicVisit);

        // 慢性病随访症状
        this.personVisitChronicSymService.savePersonVisitChronicSym(info.getVisitChronicSymIds(), chronicVisit);
        
        // 慢性病随访药物情况
        this.personVisitDrugService.savePersonVisitDrugByJson(info.getPersonVisitDrugJson(), chronicVisit);
        
        // 慢性病随访--体征
        this.personVisitSignService.savePersonVisitSign(info.getVisitSignTypes(), chronicVisit, info.getChronicType());
        
        // 慢性病随访-治疗情况
        this.personVisitCureService.savePersonVisitCure(info.getVisitCureTypes(), chronicVisit, info.getChronicType());
        
        // 报导内容
        this.personVisitContentService.savePersonVisitContent(info.getVisitContentTypes(), chronicVisit, info.getChronicType());

    }
    
    /**
     * 删除慢性病患者随访
     * @param examPersonId
     * @return
     */
    public void deletePersonChronicVisit(Long[] ids) {
        PersonChronicVisit chronicVisit = null;
        for (Long id : ids) {
            if (null == id || id.intValue() < 0) {
                continue ;
            }
            
            chronicVisit = super.selectAObject(PersonChronicVisit.class, id);
            if (null != chronicVisit) {
                chronicVisit.setValidFlag(Contstants.NO_FLAG);
                super.save(chronicVisit);
            }
        }
    }

    /**
     * 随访--体征/检查/生活指导/治疗情况
     * @param info
     * @param chronicVisit
     */
    private void savePersonVisitItem(PersonChronicVisitEditInfo info, PersonChronicVisit chronicVisit) {
        PersonVisitItem personVisitItem = super.selectAObject(PersonVisitItem.class, info.getChronicVisitId());
        if (null == personVisitItem) {
            personVisitItem = new PersonVisitItem();
            personVisitItem.setValidFlag(Contstants.YES_FLAG);
        }
        if (null == info.getPersonVisitItem()) {
            info.setPersonVisitItem(new PersonVisitItem());
        }
        info.getPersonVisitItem().setValidFlag(personVisitItem.getValidFlag());
        info.getPersonVisitItem().setVisitTime(chronicVisit.getVisitTime());
        info.getPersonVisitItem().setHospitalId(chronicVisit.getHospitalId());
        info.getPersonVisitItem().setVisitDoctorId(chronicVisit.getVisitDoctorId());
        info.getPersonVisitItem().setChronicVisitId(chronicVisit.getChronicVisitId());
        info.getPersonVisitItem().setPersonChronicId(chronicVisit.getPersonChronicId());
        info.getPersonVisitItem().setPersonDetailId(chronicVisit.getPersonDetailId());
        NullBeanUtils.copyProperties(personVisitItem, info.getPersonVisitItem());
        super.save(personVisitItem);
    }
}
