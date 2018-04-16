package com.bofan.lis.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.lis.command.GroupResultMicroQueryInfo;
import com.bofan.lis.command.LisInspectionResultMicroQueryInfo;
import com.bofan.lis.command.LisInspectionResultQueryInfo;
import com.bofan.lis.command.LisInspectionSampleExplainQueryInfo;
import com.bofan.lis.valueobject.LisInspectionSampleExplain;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-10-8
 */
@Service
@Transactional
public class LisInspectionResultServcie extends AbstractAnnoCommonService {
    
    /**
     * 根据检验ID获取一般结果列表
     * @param inspectionId
     * @return
     */
    public Page selectLisInspectionResultByInspectionId(LisInspectionResultQueryInfo queryInfo) {
        if (null != queryInfo.getInspectionId()) {
            IQueryObject qo = super.getQueryObject(queryInfo);
            return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
        }
        return null;
    }
    
    /**
     * 查询判断是否存在一般检验结果数据
     * @param inpatientId
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean selectExistGeneralResultByInspectionId(String inspectionId) {
        if (null != inspectionId) {
            LisInspectionResultQueryInfo queryInfo = new LisInspectionResultQueryInfo();
            queryInfo.setInspectionId(inspectionId);

            IQueryObject qo = super.getQueryObject(queryInfo);
            List<Long> dataList = (List<Long>) super.executeSql(qo.getCountQuery(), qo.getParam());
            if (dataList.isEmpty()) {
                return false;
            }
            
            Long coutn = dataList.get(0);
            return coutn > 0 ? true : false;
        }
        return false;
    }
    
    /**
     * 根据检验ID获取微生物结果列表
     * @param inspectionId
     * @return
     */
    public Page selectLisInspectionResultMicroByInspectionId(LisInspectionResultMicroQueryInfo queryInfo) {
        if (null != queryInfo.getInspectionId()) {
            IQueryObject qo = super.getQueryObject(queryInfo);
            return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());
        }
        return null;
    }
    
    /**
     * 根据检验ID分组查询微生物结果列表
     * @param inspectionId
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectGroupResultMicroByInspectionId(GroupResultMicroQueryInfo queryInfo) {
        if (null != queryInfo.getInspectionId()) {
            IQueryObject qo = super.getQueryObject(queryInfo);
            return super.executeSql(qo.getQueryString(), qo.getParam());
        }
        return null;
    }
    
    /**
     * 查询判断是否存在微生物检验结果数据
     * @param inpatientId
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean selectExistMicroResultByInspectionId(String inspectionId) {
        if (null != inspectionId) {
            LisInspectionResultMicroQueryInfo queryInfo = new LisInspectionResultMicroQueryInfo();
            queryInfo.setInspectionId(inspectionId);

            IQueryObject qo = super.getQueryObject(queryInfo);
            List<Long> dataList = (List<Long>) super.executeSql(qo.getCountQuery(), qo.getParam());
            if (dataList.isEmpty()) {
                return false;
            }
            
            Long coutn = dataList.get(0);
            return coutn > 0 ? true : false;
        }
        return false;
    }
    
    /**
     * 获取结果评价内容
     * @param inpatientId
     * @return
     */
    @SuppressWarnings("unchecked")
    public LisInspectionSampleExplain selectInspectionSampleExplainByInspectionId(String inspectionId) {
        if (null != inspectionId) {
            LisInspectionSampleExplainQueryInfo queryInfo = new LisInspectionSampleExplainQueryInfo();
            queryInfo.setInspectionId(inspectionId);

            IQueryObject qo = super.getQueryObject(queryInfo);
            List<LisInspectionSampleExplain> dataList = super.executeSql(qo.getQueryString(), qo.getParam());
            return dataList.isEmpty() ? null : (LisInspectionSampleExplain) dataList.get(0);
        }
        return null;
    }
    
}
