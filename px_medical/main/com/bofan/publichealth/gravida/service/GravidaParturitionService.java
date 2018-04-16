package com.bofan.publichealth.gravida.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.gravida.command.GravidaParturitionEditInfo;
import com.bofan.publichealth.gravida.command.GravidaParturitionQueryInfo;
import com.bofan.publichealth.gravida.valueobject.GravidaParturition;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * @Description:孕妇分娩记录表 Service
 * @author lqw
 */
@Service
@Transactional
public class GravidaParturitionService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询孕妇分娩记录表 列表
     * @param queryInfo GravidaParturitionQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<GravidaParturition> selectGravidaParturitionList(GravidaParturitionQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询孕妇分娩记录表
     * @param queryInfo GravidaParturitionQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public GravidaParturition findGravidaParturition(GravidaParturitionQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<GravidaParturition> list = super.executeSql(qo.getQueryString(),qo.getParam());
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 保存孕妇分娩
     * @param gravidaParturitionEditInfo
     */
    public void saveGravidaParturition(GravidaParturitionEditInfo gravidaParturitionEditInfo) {
        GravidaParturition gravidaParturition = null;
        if (null != gravidaParturitionEditInfo.getGravidaParturitionId()) {
            gravidaParturition = super.selectAObject(GravidaParturition.class, gravidaParturitionEditInfo.getGravidaParturitionId());
            NullBeanUtils.copyProperties(gravidaParturition, gravidaParturitionEditInfo);
        } else {
            gravidaParturition = new GravidaParturition();
            NullBeanUtils.copyProperties(gravidaParturition, gravidaParturitionEditInfo);
            gravidaParturition.setCurCreateTime(new Date());
        }
        // 保存
        super.save(gravidaParturition);
    }
    
   
    
}