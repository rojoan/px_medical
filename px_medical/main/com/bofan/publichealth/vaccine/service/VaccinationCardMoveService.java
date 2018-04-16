package  com.bofan.publichealth.vaccine.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import  com.bofan.publichealth.vaccine.command.VaccinationCardMoveEditInfo;
import  com.bofan.publichealth.vaccine.command.VaccinationCardMoveQueryInfo;
import  com.bofan.publichealth.vaccine.valueobject.VaccinationCardMove;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description:  疫苗接种证调动记录表服务类
 * @author wmg
 */
@Service
@Transactional
public class VaccinationCardMoveService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询疫苗接种证调动记录表分页记录
     * @param vaccinationCardMoveEditInfo
     * @return
     */
    public Page selectVaccinationCardMovePage(VaccinationCardMoveQueryInfo info) { 
        IQueryObject qo = super.getQueryObject(info);
        return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
    }
    /**
     * 根据条件查询疫苗接种证调动记录表列表
     * @param vaccineEditInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<VaccinationCardMove> selectVaccinationCardMoveList(VaccinationCardMoveQueryInfo info) { 
        IQueryObject qo = super.getQueryObject(info);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存疫苗接种证调动记录表
     */
    public VaccinationCardMove saveVaccinationCardMove(VaccinationCardMoveEditInfo  vaccinationCardMoveEditInfo) {
        //设置 疫苗接种证调动记录表
        VaccinationCardMove vaccinationCardMove = null;
        if (null != vaccinationCardMoveEditInfo.getCardMoveId()) {
            //vaccinationCardMove = this.selectVaccinationCardMoveById(vaccinationCardMoveEditInfo.getCardMoveId());
             vaccinationCardMove = super.selectAObject(VaccinationCardMove.class, vaccinationCardMoveEditInfo.getCardMoveId());
            NullBeanUtils.copyProperties(vaccinationCardMove,vaccinationCardMoveEditInfo);
        } else {
            vaccinationCardMove = new VaccinationCardMove();
            NullBeanUtils.copyProperties(vaccinationCardMove, vaccinationCardMoveEditInfo);
            vaccinationCardMove.setCreatorId(vaccinationCardMoveEditInfo.getCurrentUser().getUserInfoId());
            vaccinationCardMove.setCreateTime(new Date());
        }
        //保存 疫苗接种证调动记录表
        super.save(vaccinationCardMove);
        return vaccinationCardMove;
    }

}
