package com.bofan.publichealth.gravida.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.gravida.command.PostpartumVisitEditInfo;
import com.bofan.publichealth.gravida.command.PostpartumVisitQueryInfo;
import com.bofan.publichealth.gravida.valueobject.PostpartumVisit;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * @Description: 产后访视 Service
 * @author lqw
 */
@Service
@Transactional
public class PostpartumVisitService extends AbstractAnnoCommonService {

    /**
     * 根据条件查询 产后访视 分页记录
     * @param queryInfo
     * @return
     */
    public Page selectGravidaDetailPage(PostpartumVisitQueryInfo queryInfo) { 
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.find(qo.getQueryString(), qo.getParam(), queryInfo.getPageNumber(), queryInfo.getPageSize());

    }
    
    /**
     * 根据条件查询 产后访视 列表
     * @param queryInfo PostpartumVisitQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PostpartumVisit> selectPostpartumVisitList(PostpartumVisitQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询 产后访视
     * @param queryInfo PostpartumVisitQueryInfo
     * @return
     */
    public PostpartumVisit findPostpartumVisit(PostpartumVisitQueryInfo queryInfo) {
        List<PostpartumVisit> list = selectPostpartumVisitList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 保存 产后访视
     * @param postpartumVisitEditInfo
     */
    public void savePostpartumVisit(PostpartumVisitEditInfo postpartumVisitEditInfo) {
        PostpartumVisit postpartumVisit = null;
        if (null != postpartumVisitEditInfo.getPostpartumVisitId()) {
            postpartumVisit = super.selectAObject(PostpartumVisit.class, postpartumVisitEditInfo.getPostpartumVisitId());
            NullBeanUtils.copyProperties(postpartumVisit, postpartumVisitEditInfo);
        } else {
            postpartumVisit = new PostpartumVisit();
            NullBeanUtils.copyProperties(postpartumVisit, postpartumVisitEditInfo);
        }
        // 保存
        super.save(postpartumVisit);
    }
    
 
   
    
}