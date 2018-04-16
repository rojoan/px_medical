package com.bofan.publichealth.gravida.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.gravida.command.GravidaSurgeryEditInfo;
import com.bofan.publichealth.gravida.command.GravidaSurgeryQueryInfo;
import com.bofan.publichealth.gravida.command.GravidaSurgeryWayQueryInfo;
import com.bofan.publichealth.gravida.valueobject.GravidaSurgery;
import com.bofan.publichealth.gravida.valueobject.GravidaSurgeryWay;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * @Description:产前筛查检查/手术记录 Service
 * @author lqw
 */
@Service
@Transactional
public class GravidaSurgeryService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询产前筛查检查/手术记录 列表
     * @param queryInfo 
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<GravidaSurgery> selectGravidaSurgeryList(GravidaSurgeryQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询产前筛查检查/手术记录
     * @param queryInfo 
     * @return
     */
    public GravidaSurgery findGravidaSurgery(GravidaSurgeryQueryInfo queryInfo) {
        List<GravidaSurgery> list = selectGravidaSurgeryList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 保存 产前筛查检查/手术记录
     * @param gravidaSurgeryEditInfo
     */
    public void saveGravidaSurgery(GravidaSurgeryEditInfo gravidaSurgeryEditInfo) {
        GravidaSurgery gravidaSurgery = null;
        if (null != gravidaSurgeryEditInfo.getGravidaSurgeryId()) {
            gravidaSurgery = super.selectAObject(GravidaSurgery.class, gravidaSurgeryEditInfo.getGravidaSurgeryId());
            NullBeanUtils.copyProperties(gravidaSurgery, gravidaSurgeryEditInfo);
        } else {
            gravidaSurgery = new GravidaSurgery();
            NullBeanUtils.copyProperties(gravidaSurgery, gravidaSurgeryEditInfo);
        }
        // 保存
        super.save(gravidaSurgery);
        //新增或者修改手术方式表
        this.saveOrUpdateGravidaSurgeryWay(gravidaSurgery.getGravidaSurgeryId(),gravidaSurgeryEditInfo);
    }

    /**
     * 新增或者修改手术方式表
     * @param gravidaSurgeryId
     * @param gravidaSurgeryEditInfo
     */
    private void saveOrUpdateGravidaSurgeryWay(Long gravidaSurgeryId, GravidaSurgeryEditInfo gravidaSurgeryEditInfo) {
        GravidaSurgeryWay gravidaSurgeryWay = this.findGravidaSurgeryWay(new GravidaSurgeryWayQueryInfo(gravidaSurgeryId));
        if (null == gravidaSurgeryEditInfo.getSurgeryWayId()) {
            //删除手术方式
            if (null != gravidaSurgeryWay) {
                super.delete(gravidaSurgeryWay);
            }
        }else{
            if (null == gravidaSurgeryWay) { 
                //新增手术方式
                gravidaSurgeryWay = new GravidaSurgeryWay();
                gravidaSurgeryWay.setPregnancySurgeryId(gravidaSurgeryId);
                gravidaSurgeryWay.setSurgeryWayId(gravidaSurgeryEditInfo.getSurgeryWayId());
                super.save(gravidaSurgeryWay);
            } else {
                //修改手术方式
                gravidaSurgeryWay.setSurgeryWayId(gravidaSurgeryEditInfo.getSurgeryWayId());
                super.save(gravidaSurgeryWay);
            }
        }
    }
    
    /**
     * 获取手术方式ID
     * @param gravidaSurgeryId
     * @return
     */
    public Long selectGravidaSurgeryWayId(Long gravidaSurgeryId){
        GravidaSurgeryWay gravidaSurgeryWay = this.findGravidaSurgeryWay(new GravidaSurgeryWayQueryInfo(gravidaSurgeryId));
        if (null == gravidaSurgeryWay) {
            return null;
        }
        return gravidaSurgeryWay.getSurgeryWayId();
    }
    
    
    
    /**
     * 查询 孕妇孕期检查/手术方式 列表
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<GravidaSurgeryWay> selectGravidaSurgeryWayList(GravidaSurgeryWayQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 查询 孕妇孕期检查/手术方式
     * @param queryInfo
     * @return
     */
    public GravidaSurgeryWay findGravidaSurgeryWay(GravidaSurgeryWayQueryInfo queryInfo) {
        List<GravidaSurgeryWay> list = selectGravidaSurgeryWayList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
   
}