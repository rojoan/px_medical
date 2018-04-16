package com.bofan.reconsult.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.reconsult.command.ConsultingProfessorQueryInfo;
import com.bofan.reconsult.command.ConsultingUserIdsQueryInfo;
import com.bofan.reconsult.valueobject.ReConsultingProfessor;

/**
 * @Description
 * @author xlf
 * @version 1.0
 * 2017-10-02
 */
@Service
@Transactional
public class ReConsultingProfessorService extends AbstractAnnoCommonService {
    
    /**
     * 根据专家表查询会诊信息分页列表
     * @param queryInfo
     * @return
     */
    public Page selectConsultingProfessorList(ConsultingProfessorQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
    }
    
    /**
     * 根据主键获取参会人信息
     * @param videoMeetingId
     * @return
     */
    public ReConsultingProfessor selectReConsultingProfessorById(Long videoMeetingId) {
        return super.load(ReConsultingProfessor.class, videoMeetingId);
    }
    
    /**
     * 根据远程会诊ID获取会议对应的专家列表信息
     * @param reConsultingId
     * @return
     */
    public List<ReConsultingProfessor> selectReConsultingProfessorList(Long reConsultingId) {
        ConsultingProfessorQueryInfo queryInfo = new ConsultingProfessorQueryInfo();
        queryInfo.setReConsultingId(reConsultingId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<ReConsultingProfessor> dataList = super.executeSql(ReConsultingProfessor.class, qo.getQueryString(), qo.getParam());
        return dataList;
    }
    
    /**
     * 获取会议对应的专家列表信息
     * @param 
     * @return
     */
    public List<ReConsultingProfessor> selectReConsultingProfessorList(ConsultingProfessorQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<ReConsultingProfessor> dataList = super.executeSql(ReConsultingProfessor.class, qo.getQueryString(), qo.getParam());
        return dataList;
    }
    
    /**
     * 根据会诊ID获取参与会诊的会诊专家Id(也是用户ID)
     * @param reConsultingId
     * @return
     */
    public List<Long> selectConsultingUserIds(Long reConsultingId) {
        ConsultingUserIdsQueryInfo queryInfo = new ConsultingUserIdsQueryInfo();
        queryInfo.setReConsultingId(reConsultingId);
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<Long> dataList = super.executeSql(Long.class, qo.getQueryString(), qo.getParam());
        return dataList;
    }

    /**
     * 保存更新专家诊断意见
     * @param reConsultingId
     * @param reProfessorId
     * @param opinion
     */
    public void updateConsultingProfessorOpinion(Long reConsultingId, Long professorId, String opinion) {
        ConsultingProfessorQueryInfo queryInfo = new ConsultingProfessorQueryInfo();
        queryInfo.setReProfessorId(professorId);
        queryInfo.setReConsultingId(reConsultingId);
        List<ReConsultingProfessor> dataList = this.selectReConsultingProfessorList(queryInfo);
        ReConsultingProfessor consultingProfessor = dataList.isEmpty() ? null : dataList.get(0);
        if (null != consultingProfessor) {
            consultingProfessor.setPersonOpinion(opinion);
            super.save(consultingProfessor);
        }
    }
    
    /**
     * 保存多个参会人员
     * @param professors
     */
    public void saveReConsultingProfessor(Long reConsultingId, String[] professors, String joinFlag) {
        if (null != reConsultingId && null != professors && professors.length > 0) {
            List<Long> newDataList =  new ArrayList<Long>();
            Map<Long, String> professorMap = new HashMap<Long, String>();
            for (String pro : professors) {
                if (StringUtils.isBlank(pro)) {
                    continue ;
                }
                String[] item = pro.split("\\|");
                if (StringUtils.isBlank(item[0])) {
                    continue ;
                }
                Long professorId = Long.valueOf(item[0]);
                newDataList.add(Long.valueOf(professorId));
                professorMap.put(professorId, item[1]);
            }
            
            // 获取旧的参会人员，并遍历对比新参会人员，如果新的参会人员中（tempList），不包含旧的参会人员，则删除掉
            List<ReConsultingProfessor> oldDataList = this.selectReConsultingProfessorList(reConsultingId);
            if (!oldDataList.isEmpty()) {
                List<ReConsultingProfessor> deleteList = new ArrayList<ReConsultingProfessor>();
                for (ReConsultingProfessor rcp : oldDataList) {
                    if (!newDataList.contains(rcp.getProfessorId())) {
                        deleteList.add(rcp);
                    } else {
                        newDataList.remove(rcp.getProfessorId());
                    }
                }
                super.deleteAll(deleteList);
            }
            
            ReConsultingProfessor professor = null;
            List<ReConsultingProfessor> entities = new ArrayList<ReConsultingProfessor>();
            Long reProfessorId = null;
            for (int i = 0; i < newDataList.size(); i++) {
                reProfessorId = newDataList.get(i);
                if (null == reProfessorId) {
                    continue ;
                }
                professor = new ReConsultingProfessor();
                professor.setProfessorId(reProfessorId);
                professor.setDoctorName(professorMap.get(reProfessorId));
                professor.setReConsultingId(reConsultingId);
                professor.setJoinFlag(joinFlag);
                entities.add(professor);
            }
            super.saveAll(entities);
        }
    }
}
