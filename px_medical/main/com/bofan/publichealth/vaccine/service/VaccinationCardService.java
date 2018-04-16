package  com.bofan.publichealth.vaccine.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import  com.bofan.publichealth.vaccine.command.VaccinationCardEditInfo;
import  com.bofan.publichealth.vaccine.command.VaccinationCardQueryInfo;
import  com.bofan.publichealth.vaccine.valueobject.VaccinationCard;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description:  预防接种卡基本信息服务类
 * @author wmg
 */
@Service
@Transactional
public class VaccinationCardService extends AbstractAnnoCommonService {
    
    /**
     * 根据条件查询预防接种卡基本信息分页记录
     * @param vaccinationCardEditInfo
     * @return
     */
    public Page selectVaccinationCardPage(VaccinationCardQueryInfo info) { 
        IQueryObject qo = super.getQueryObject(info);
        return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
    }
    /**
     * 根据条件查询预防接种卡基本信息列表
     * @param vaccineEditInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<VaccinationCard> selectVaccinationCardList(VaccinationCardQueryInfo info) { 
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存预防接种卡基本信息
     */
    public VaccinationCard saveVaccinationCard(VaccinationCardEditInfo  vaccinationCardEditInfo) {
        //设置 预防接种卡基本信息
        VaccinationCard vaccinationCard = null;
        if (null != vaccinationCardEditInfo.getVaccinationCardId()) {
            //vaccinationCard = this.selectVaccinationCardById(vaccinationCardEditInfo.getVaccinationCardId());
             vaccinationCard = super.selectAObject(VaccinationCard.class, vaccinationCardEditInfo.getVaccinationCardId());
            NullBeanUtils.copyProperties(vaccinationCard,vaccinationCardEditInfo);
        } else {
            vaccinationCard = new VaccinationCard();
            NullBeanUtils.copyProperties(vaccinationCard, vaccinationCardEditInfo);
            vaccinationCard.setCreatorId(vaccinationCardEditInfo.getCurrentUser().getUserInfoId());
            vaccinationCard.setCreateTime(new Date());
            vaccinationCard.setCreatorName(vaccinationCardEditInfo.getCurrentUser().getName());
        }
        //保存 预防接种卡基本信息
        super.save(vaccinationCard);
        return vaccinationCard;
    }

}
