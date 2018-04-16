package com.bofan.reconsult.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.reconsult.command.ReProfessorQueryInfo;
import com.bofan.reconsult.valueobject.ReProfessor;

/**
 * @Description
 * @author xlf
 * @version 1.0
 * 2017-10-02
 */
@Service
@Transactional
public class ReProfessorService extends AbstractAnnoCommonService {
    
    /**
     * 根据主键获取专家信息
     * @param videoMeetingId
     * @return
     */
    public ReProfessor selectReProfessorById(Long videoMeetingId) {
        return super.load(ReProfessor.class, videoMeetingId);
    }
    
    /**
     * 获取专家列表信息
     * @param ReProfessorQueryInfo
     * @return
     */
    public List<ReProfessor> selectReProfessorList(ReProfessorQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new ReProfessorQueryInfo();
        }
        IQueryObject qo = super.getQueryObject(queryInfo);
        List<ReProfessor> dataList = super.executeSql(ReProfessor.class, qo.getQueryString(), qo.getParam());
        return dataList;
    }

}
