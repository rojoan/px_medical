package com.bofan.publichealth.gravida.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.gravida.command.GravidaAuxExamQueryInfo;
import com.bofan.publichealth.gravida.valueobject.GravidaAuxExam;
import com.bofan.utils.Tools;

/**
 * @Description:孕妇孕检辅助检查项目情况对照表 Service
 * @author lqw
 */
@Service
@Transactional
public class GravidaAuxExamService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询孕妇孕检辅助检查项目情况对照表表 列表
     * @param queryInfo GravidaAuxExamQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<GravidaAuxExam> selectGravidaAuxExamList(GravidaAuxExamQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询孕妇孕检辅助检查项目情况对照表表
     * @param queryInfo GravidaAuxExamQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public GravidaAuxExam findGravidaAuxExam(GravidaAuxExamQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<GravidaAuxExam> list = super.executeSql(qo.getQueryString(),qo.getParam());
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 查询所有 孕妇孕检辅助检查项目情况对照表 的 map集合
     * @return
     */
    public Map<Long,GravidaAuxExam> selectGravidaAuxExamMap(GravidaAuxExamQueryInfo queryInfo){
        Map<Long,GravidaAuxExam> gravidaAuxExamMap = new HashMap<Long,GravidaAuxExam>();
        List<GravidaAuxExam> list  = this.selectGravidaAuxExamList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            for (GravidaAuxExam gravidaAuxExam : list) {
                gravidaAuxExamMap.put(gravidaAuxExam.getPregnancyExamItemId(), gravidaAuxExam);
            }
        }
        return gravidaAuxExamMap;
    }
    
}