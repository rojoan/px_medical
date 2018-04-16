package com.bofan.publichealth.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.publichealth.command.PersonChronicEditInfo;
import com.bofan.publichealth.command.PersonChronicTypeQueryInfo;
import com.bofan.publichealth.valueobject.PersonChronic;
import com.bofan.publichealth.valueobject.PersonChronicDisease;
import com.bofan.publichealth.valueobject.PersonChronicItem;
import com.bofan.publichealth.valueobject.PersonChronicType;
import com.bofan.publichealth.valueobject.PersonDiabetesCure;
import com.bofan.publichealth.valueobject.PersonHypCure;
import com.bofan.publichealth.valueobject.PersonPhthisisCure;
import com.bofan.publichealth.valueobject.PersonTumourCure;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description 慢性病患者业务
 * @author xlf
 * 2017-10-26
 */
@Service
@Transactional
public class PersonChronicService extends AbstractAnnoCommonService {

    @Autowired
    private PersonChronicDrugService personChronicDrugService;
    @Autowired
    private PersonChronicDrinkService personChronicDrinkService;
    @Autowired
    private PersonChronicDangerService PersonChronicDangerService;
    @Autowired
    private PersonChronicNonDrugService personChronicNonDrugService;
    @Autowired
    private PersonChronicDiagnoseService personChronicDiagnoseService;
    @Autowired
    private PersonChronicDiagBasisService personChronicDiagBasisService;
    
    /**
     * 慢性病患者--高血压分页列表
     * @param queryInfo
     * @return
     */
    public Page selectPersonChronicTypeList(PersonChronicTypeQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new PersonChronicTypeQueryInfo();
        }
        
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 保存慢性病患者登记（包括高血压、糖尿病等）
     * @param info
     */
    public void savePersonChronic(PersonChronicEditInfo info) {
        // 保存主表信息 
        PersonChronic personChronic = null;
        if(null != info.getPersonChronicId()) {
            // 修改
            personChronic = super.selectAObject(PersonChronic.class, info.getPersonChronicId());
        } else {
            // 新增
            personChronic = new PersonChronic();
            personChronic.setValidFlag(Contstants.YES_FLAG);
            personChronic.setCreateTime(new Date());
            personChronic.setCreatorId(info.getCurrentUser().getUserInfoId());
            personChronic.setCreatorName(info.getCurrentUser().getName());
            
            // 当前用户单位
            SysOrg unitOrg = super.selectAObject(SysOrg.class, info.getCurrentUser().getSysOrg().getUnitOrgId());
            personChronic.setHospitalId(unitOrg.getOrgId());
            personChronic.setHospitalName(unitOrg.getName());
            personChronic.setHospitalNo(unitOrg.getOrgNo());
            personChronic.setHospitalPhone(unitOrg.getDirectorTel());

        }
        NullBeanUtils.copyProperties(personChronic, info);
        super.saveAndRefresh(personChronic);
        info.setPersonChronicId(personChronic.getPersonChronicId());
        
        // 保存慢性病类型
        PersonChronicType chronicType = null;
        if (null != info.getPersonChronicType() && null != info.getPersonChronicType().getChronicTypeId()) {
            chronicType = super.selectAObject(PersonChronicType.class, info.getPersonChronicType().getChronicTypeId());
        } else {
            chronicType = new PersonChronicType();
        }
        info.getPersonChronicType().setValidFlag(Contstants.YES_FLAG);
        info.getPersonChronicType().setChronicType(info.getChronicType());
        info.getPersonChronicType().setPersonChronicId(info.getPersonChronicId());
        info.getPersonChronicType().setPersonDetailId(info.getPersonDetailId());
        NullBeanUtils.copyProperties(chronicType, info.getPersonChronicType());
        super.save(chronicType);
        
        // 高血压
        if (Contstants.CHRONNIC_TYPE_HYP.equals(info.getChronicType())) {
            // 保存慢性病患者相关病史和家族史
            this.saveChronicDisease(info, personChronic);
            // 保存慢性病患者体格检查/生活行为
            this.saveChronicItem(info, personChronic);
            // 保存慢性病对应的目前治疗情况信息
            this.saveChronicCure(info, personChronic);
            // 保存慢性病非药物治疗
            this.personChronicNonDrugService.savePersonChronicNonDrug(info.getNonDrugType(), personChronic, chronicType.getChronicType());
            // 保存慢性病本次药物治疗
            this.personChronicDrugService.savePersonalDrugByJson(info.getChronicDrugJson(), personChronic, chronicType.getChronicType());
            // 保存慢性病患者--饮酒种类对照
            this.personChronicDrinkService.savePersonChronicDrinkByJson(info.getChronicDrinkJson(), personChronic);
        }
        
        // 糖尿病
        if (Contstants.CHRONNIC_TYPE_DM.equals(info.getChronicType())) {
            // 保存慢性病患者相关病史和家族史
            this.saveChronicDisease(info, personChronic);
            // 保存慢性病患者体格检查/生活行为
            this.saveChronicItem(info, personChronic);
            // 保存慢性病对应的目前治疗情况信息
            this.saveChronicCure(info, personChronic);
            // 保存慢性病非药物治疗
            this.personChronicNonDrugService.savePersonChronicNonDrug(info.getNonDrugType(), personChronic, chronicType.getChronicType());
            // 保存慢性病本次药物治疗
            this.personChronicDrugService.savePersonalDrugByJson(info.getChronicDrugJson(), personChronic, chronicType.getChronicType());
            // 保存慢性病患者--饮酒种类对照
            this.personChronicDrinkService.savePersonChronicDrinkByJson(info.getChronicDrinkJson(), personChronic);
        }
        
        // 慢阻肺疾病
        if (Contstants.CHRONNIC_TYPE_COPD.equals(info.getChronicType())) {
            // 保存慢性病非药物治疗
            this.personChronicNonDrugService.savePersonChronicNonDrug(info.getNonDrugType(), personChronic, chronicType.getChronicType());
            // 保存慢性病--危险因素
            this.PersonChronicDangerService.savePersonChronicDanger(info.getDangerType(), personChronic, info.getChronicType());
        }
        
        // 肿瘤疾病
        if (Contstants.CHRONNIC_TYPE_TUM.equals(info.getChronicType())) {
            // 保存肿瘤患者治疗和进展情况  
            this.savePersonTumourCure(info, personChronic);
            // 保存慢性病非药物治疗
            this.personChronicNonDrugService.savePersonChronicNonDrug(info.getNonDrugType(), personChronic, chronicType.getChronicType());
            // 保存慢性病--诊断依据
            this.personChronicDiagBasisService.savePersonChronicDiagBasis(info.getDiagnoseBasis(), personChronic, info.getChronicType());
        }
        
        // 冠心病
        if (Contstants.CHRONNIC_TYPE_CHD.equals(info.getChronicType())) {
            // 保存具体诊断
            this.personChronicDiagnoseService.savePersonChronicDiagnose(info.getChronicDiagnoses(), personChronic, info.getChronicType());
            // 保存慢性病--诊断依据
            this.personChronicDiagBasisService.savePersonChronicDiagBasis(info.getDiagnoseBasis(), personChronic, info.getChronicType());
        }
        
        // 脑卒中
        if (Contstants.CHRONNIC_TYPE_CS.equals(info.getChronicType())) {
            // 保存具体诊断
            this.personChronicDiagnoseService.savePersonChronicDiagnose(info.getChronicDiagnoses(), personChronic, info.getChronicType());
            // 保存慢性病--诊断依据
            this.personChronicDiagBasisService.savePersonChronicDiagBasis(info.getDiagnoseBasis(), personChronic, info.getChronicType());
        }
        
        // 肺结核
        if (Contstants.CHRONNIC_TYPE_PTB.equals(info.getChronicType())) {
            // 保存慢性病患者体格检查/生活行为
            this.saveChronicItem(info, personChronic);
            // 保存肺结核诊断和治疗情况
            this.savePersonPhthisisCure(info, personChronic);
            // 保存慢性病非药物治疗
            this.personChronicNonDrugService.savePersonChronicNonDrug(info.getNonDrugType(), personChronic, chronicType.getChronicType());
        }

    }
    
    /**
     * 删除慢性病患者类型
     * @param examPersonId
     * @return
     */
    public void deletePersonHypRecord(Long[] ids) {
        PersonChronicType personChronicType = null;
        for (Long id : ids) {
            if (null == id || id.intValue() < 0) {
                continue ;
            }
            personChronicType = super.selectAObject(PersonChronicType.class, id);
            if (null != personChronicType) {
                personChronicType.setValidFlag(Contstants.NO_FLAG);
                super.save(personChronicType);
            }
        }
    }

    /**
     * 保存慢性病对应的目前治疗情况信息
     * @param info
     * @param personChronic
     */
    private void saveChronicCure(PersonChronicEditInfo info, PersonChronic personChronic) {
        if (Contstants.CHRONNIC_TYPE_HYP.equals(info.getChronicType())) {
            // 高血压患者用药和治疗情况
            PersonHypCure personHypCure = super.selectAObject(PersonHypCure.class, info.getPersonChronicId());
            if (null == personHypCure) {
                personHypCure = new PersonHypCure();
                personHypCure.setValidFlag(Contstants.YES_FLAG);
            }
            if (null == info.getPersonHypCure()) {
                info.setPersonHypCure(new PersonHypCure());
            }
            info.getPersonHypCure().setValidFlag(personHypCure.getValidFlag());
            info.getPersonHypCure().setCreateTime(personChronic.getCreateTime());
            info.getPersonHypCure().setCreatorId(personChronic.getCreatorId());
            info.getPersonHypCure().setHospitalId(personChronic.getHospitalId());
            info.getPersonHypCure().setPersonChronicId(personChronic.getPersonChronicId());
            info.getPersonHypCure().setPersonDetailId(personChronic.getPersonDetailId());
            NullBeanUtils.copyProperties(personHypCure, info.getPersonHypCure());
            super.save(personHypCure);
            
        } else if (Contstants.CHRONNIC_TYPE_DM.equals(info.getChronicType())) {
            // 糖尿病患者干预和治疗情况
            PersonDiabetesCure diabetesCure = super.selectAObject(PersonDiabetesCure.class, info.getPersonChronicId());
            if (null == diabetesCure) {
                diabetesCure = new PersonDiabetesCure();
                diabetesCure.setValidFlag(Contstants.YES_FLAG);
            }
            if (null == info.getPersonDiabetesCure()) {
                info.setPersonDiabetesCure(new PersonDiabetesCure());
            }
            info.getPersonDiabetesCure().setValidFlag(diabetesCure.getValidFlag());
            info.getPersonDiabetesCure().setCreateTime(personChronic.getCreateTime());
            info.getPersonDiabetesCure().setCreatorId(personChronic.getCreatorId());
            info.getPersonDiabetesCure().setHospitalId(personChronic.getHospitalId());
            info.getPersonDiabetesCure().setPersonChronicId(personChronic.getPersonChronicId());
            info.getPersonDiabetesCure().setPersonDetailId(personChronic.getPersonDetailId());
            NullBeanUtils.copyProperties(diabetesCure, info.getPersonDiabetesCure());
            super.save(diabetesCure);
        }
    }
    
    /**
     * 保存慢性病患者相关病史和家族史
     * @param info
     * @param personChronic
     */
    private void saveChronicDisease(PersonChronicEditInfo info, PersonChronic personChronic) {
     
        PersonChronicDisease chronicDisease = super.selectAObject(PersonChronicDisease.class, info.getPersonChronicId());
        if (null == chronicDisease) {
            chronicDisease = new PersonChronicDisease();
            chronicDisease.setValidFlag(Contstants.YES_FLAG);
        }
        if (null == info.getPersonChronicDisease()) {
            info.setPersonChronicDisease(new PersonChronicDisease());
        }
        info.getPersonChronicDisease().setValidFlag(chronicDisease.getValidFlag());
        info.getPersonChronicDisease().setCreateTime(personChronic.getCreateTime());
        info.getPersonChronicDisease().setCreatorId(personChronic.getCreatorId());
        info.getPersonChronicDisease().setHospitalId(personChronic.getHospitalId());
        info.getPersonChronicDisease().setPersonChronicId(personChronic.getPersonChronicId());
        info.getPersonChronicDisease().setPersonDetailId(personChronic.getPersonDetailId());
        NullBeanUtils.copyProperties(chronicDisease, info.getPersonChronicDisease());
        super.save(chronicDisease);
    }
    
    /**
     * 保存慢性病患者体格检查/生活行为
     * @param info
     * @param personChronic
     */
    private void saveChronicItem(PersonChronicEditInfo info, PersonChronic personChronic) {
        PersonChronicItem chronicItem = super.selectAObject(PersonChronicItem.class, info.getPersonChronicId());
        if (null == chronicItem) {
            chronicItem = new PersonChronicItem();
            chronicItem.setValidFlag(Contstants.YES_FLAG);
        }
        if (null == info.getPersonChronicItem()) {
            info.setPersonChronicItem(new PersonChronicItem());
        }
        info.getPersonChronicItem().setValidFlag(chronicItem.getValidFlag());
        info.getPersonChronicItem().setCreateTime(personChronic.getCreateTime());
        info.getPersonChronicItem().setCreatorId(personChronic.getCreatorId());
        info.getPersonChronicItem().setHospitalId(personChronic.getHospitalId());
        info.getPersonChronicItem().setPersonChronicId(personChronic.getPersonChronicId());
        info.getPersonChronicItem().setPersonDetailId(personChronic.getPersonDetailId());
        NullBeanUtils.copyProperties(chronicItem, info.getPersonChronicItem());
        super.save(chronicItem);
    }
    
    /**
     * 保存肿瘤患者治疗和进展情况
     * @param info
     * @param personChronic
     */
    private void savePersonTumourCure(PersonChronicEditInfo info, PersonChronic personChronic) {
        PersonTumourCure tumourCure = super.selectAObject(PersonTumourCure.class, info.getPersonChronicId());
        if (null == tumourCure) {
            tumourCure = new PersonTumourCure();
            tumourCure.setValidFlag(Contstants.YES_FLAG);
        }
        if (null == info.getPersonTumourCure()) {
            info.setPersonTumourCure(new PersonTumourCure());
        }
        info.getPersonTumourCure().setValidFlag(tumourCure.getValidFlag());
        info.getPersonTumourCure().setCreateTime(personChronic.getCreateTime());
        info.getPersonTumourCure().setCreatorId(personChronic.getCreatorId());
        info.getPersonTumourCure().setHospitalId(personChronic.getHospitalId());
        info.getPersonTumourCure().setPersonChronicId(personChronic.getPersonChronicId());
        info.getPersonTumourCure().setPersonDetailId(personChronic.getPersonDetailId());
        NullBeanUtils.copyProperties(tumourCure, info.getPersonTumourCure());
        super.save(tumourCure);
    }
    
    /**
     * 保存肺结核诊断和治疗情况
     * @param info
     * @param personChronic
     */
    private void savePersonPhthisisCure(PersonChronicEditInfo info, PersonChronic personChronic) {
        PersonPhthisisCure phthisisCure = super.selectAObject(PersonPhthisisCure.class, info.getPersonChronicId());
        if (null == phthisisCure) {
            phthisisCure = new PersonPhthisisCure();
            phthisisCure.setValidFlag(Contstants.YES_FLAG);
        }
        if (null == info.getPersonPhthisisCure()) {
            info.setPersonPhthisisCure(new PersonPhthisisCure());
        }
        info.getPersonPhthisisCure().setValidFlag(phthisisCure.getValidFlag());
        info.getPersonPhthisisCure().setCreateTime(personChronic.getCreateTime());
        info.getPersonPhthisisCure().setCreatorId(personChronic.getCreatorId());
        info.getPersonPhthisisCure().setHospitalId(personChronic.getHospitalId());
        info.getPersonPhthisisCure().setPersonChronicId(personChronic.getPersonChronicId());
        info.getPersonPhthisisCure().setPersonDetailId(personChronic.getPersonDetailId());
        NullBeanUtils.copyProperties(phthisisCure, info.getPersonPhthisisCure());
        super.save(phthisisCure);
    }
    
}
