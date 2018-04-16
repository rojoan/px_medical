package  com.bofan.publichealth.vaccine.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import  com.bofan.publichealth.vaccine.command.VaccinationDetailEditInfo;
import  com.bofan.publichealth.vaccine.command.VaccinationDetailQueryInfo;
import  com.bofan.publichealth.vaccine.valueobject.VaccinationDetail;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description:  预防接种明细服务类
 * @author wmg
 */
@Service
@Transactional
public class VaccinationDetailService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询预防接种明细分页记录
     * @param vaccinationDetailEditInfo
     * @return
     */
    public Page selectVaccinationDetailPage(VaccinationDetailQueryInfo info) { 
        IQueryObject qo = super.getQueryObject(info);
        return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
    }
    /**
     * 根据条件查询预防接种明细列表
     * @param vaccineEditInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<VaccinationDetail> selectVaccinationDetailList(VaccinationDetailQueryInfo info) { 
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存预防接种明细
     */
    public VaccinationDetail saveVaccinationDetail(VaccinationDetailEditInfo  vaccinationDetailEditInfo) {
        //设置 预防接种明细
        VaccinationDetail vaccinationDetail = null;
        if (null != vaccinationDetailEditInfo.getVaccinationDetailId()) {
            //vaccinationDetail = this.selectVaccinationDetailById(vaccinationDetailEditInfo.getVaccinationDetailId());
             vaccinationDetail = super.selectAObject(VaccinationDetail.class, vaccinationDetailEditInfo.getVaccinationDetailId());
            NullBeanUtils.copyProperties(vaccinationDetail,vaccinationDetailEditInfo);
        } else {
            vaccinationDetail = new VaccinationDetail();
            NullBeanUtils.copyProperties(vaccinationDetail, vaccinationDetailEditInfo);
        }
        //保存 预防接种明细
        super.save(vaccinationDetail);
        return vaccinationDetail;
    }

}
