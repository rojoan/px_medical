package com.bofan.reconsult.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.reconsult.command.EmrKbDetailQueryInfo;
import com.bofan.reconsult.command.EmrKbTypeQueryInfo;
import com.bofan.reconsult.valueobject.EmrKbDetail;
import com.bofan.reconsult.valueobject.EmrKbType;
import com.bofan.utils.Contstants;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-11-14
 */
@Service
@Transactional
public class EmrKbService extends AbstractAnnoCommonService {

    /**
     * 根据条件知识库类型列表
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<EmrKbType> selectEmrKbType(EmrKbTypeQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new EmrKbTypeQueryInfo();
        }
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }
    
    /**
     * 根据条件知识库信息列表
     * @param emrKbTypeId
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<EmrKbDetail> selectEmrKbDetail(EmrKbDetailQueryInfo queryInfo) {
        if (null == queryInfo) {
            queryInfo = new EmrKbDetailQueryInfo();
        }
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(), qo.getParam());
    }

    /**
     * 保存EmrKbType信息
     * @param emrKbTypeId
     * @param emrKbTypeCode
     * @param emrKbTypeName
     */
    public void saveEmrKbType(Long emrKbTypeId, String emrKbTypeCode, String emrKbTypeName) {
        EmrKbType emrKbType = null;
         if (emrKbTypeId == null) {//新增
             emrKbType = new EmrKbType();
             emrKbType.setEmrKbTypeCode(super.nextTreeId(EmrKbType.class, "emrKbTypeCode", emrKbTypeCode, Contstants.TYPE_SEGMENT_LENGTH));
         } else {//修改
             emrKbType = super.load(EmrKbType.class, emrKbTypeId);
         }
         emrKbType.setEmrKbTypeName(emrKbTypeName);
         
         super.save(emrKbType);
    }
    
}
