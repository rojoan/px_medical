package  com.bofan.publichealth.vaccine.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import  com.bofan.publichealth.vaccine.command.VaccinationAbnormalEditInfo;
import  com.bofan.publichealth.vaccine.command.VaccinationAbnormalQueryInfo;
import  com.bofan.publichealth.vaccine.valueobject.VaccinationAbnormal;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description:  预防接种异常表服务类
 * @author wmg
 */
@Service
@Transactional
public class VaccinationAbnormalService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询预防接种异常表分页记录
     * @param vaccinationAbnormalEditInfo
     * @return
     */
    public Page selectVaccinationAbnormalPage(VaccinationAbnormalQueryInfo info) { 
        IQueryObject qo = super.getQueryObject(info);
        return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
    }
    /**
     * 根据条件查询预防接种异常表列表
     * @param vaccineEditInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<VaccinationAbnormal> selectVaccinationAbnormalList(VaccinationAbnormalQueryInfo info) { 
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存预防接种异常表
     */
    public VaccinationAbnormal saveVaccinationAbnormal(VaccinationAbnormalEditInfo  vaccinationAbnormalEditInfo) {
        //设置 预防接种异常表
        VaccinationAbnormal vaccinationAbnormal = super.selectAObject(VaccinationAbnormal.class,
                vaccinationAbnormalEditInfo.getVaccinationDetailId());
        if (null != vaccinationAbnormal) {
            //vaccinationAbnormal = this.selectVaccinationAbnormalById(vaccinationAbnormalEditInfo.getVaccinationDetailId());
             vaccinationAbnormal = super.selectAObject(VaccinationAbnormal.class, vaccinationAbnormalEditInfo.getVaccinationDetailId());
            NullBeanUtils.copyProperties(vaccinationAbnormal,vaccinationAbnormalEditInfo);
        } else {
            vaccinationAbnormal = new VaccinationAbnormal();
            NullBeanUtils.copyProperties(vaccinationAbnormal, vaccinationAbnormalEditInfo);
            vaccinationAbnormal.setReportDoctorId(vaccinationAbnormalEditInfo.getCurrentUser().getUserInfoId());
            vaccinationAbnormal.setReportDoctor(vaccinationAbnormalEditInfo.getCurrentUser().getName());
        }
        //保存 预防接种异常表
        super.save(vaccinationAbnormal);
        return vaccinationAbnormal;
    }

}
