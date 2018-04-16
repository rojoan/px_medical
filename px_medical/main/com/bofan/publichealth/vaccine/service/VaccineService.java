package  com.bofan.publichealth.vaccine.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import  com.bofan.publichealth.vaccine.command.VaccineEditInfo;
import  com.bofan.publichealth.vaccine.command.VaccineQueryInfo;
import  com.bofan.publichealth.vaccine.valueobject.Vaccine;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description:  疫苗程序表服务类
 * @author wmg
 */
@Service
@Transactional
public class VaccineService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询疫苗程序表分页记录
     * @param vaccineEditInfo
     * @return
     */
    public Page selectVaccinePage(VaccineQueryInfo info) { 
        IQueryObject qo = super.getQueryObject(info);
        return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
    }
    /**
     * 根据条件查询疫苗程序表列表
     * @param vaccineEditInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Vaccine> selectVaccineList(VaccineQueryInfo info) { 
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存疫苗程序表
     */
    public Vaccine saveVaccine(VaccineEditInfo  vaccineEditInfo) {
        //设置 疫苗程序表
        Vaccine vaccine = null;
        if (null != vaccineEditInfo.getVaccineId()) {
            //vaccine = this.selectVaccineById(vaccineEditInfo.getVaccineId());
             vaccine = super.selectAObject(Vaccine.class, vaccineEditInfo.getVaccineId());
            NullBeanUtils.copyProperties(vaccine,vaccineEditInfo);
        } else {
            vaccine = new Vaccine();
            NullBeanUtils.copyProperties(vaccine, vaccineEditInfo);
            vaccine.setCreatorId(vaccineEditInfo.getCurrentUser().getUserInfoId());
            vaccine.setCreateTime(new Date());
        }
        //保存 疫苗程序表
        super.save(vaccine);
        return vaccine;
    }

}
