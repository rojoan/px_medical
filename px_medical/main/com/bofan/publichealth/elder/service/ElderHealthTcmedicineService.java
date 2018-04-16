package com.bofan.publichealth.elder.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.publichealth.command.HealthTcmedicineQueryInfo;
import com.bofan.publichealth.elder.command.ElderHealthTcmItemEditInfo;
import com.bofan.publichealth.elder.command.ElderHealthTcmItemQueryInfo;
import com.bofan.publichealth.elder.command.ElderHealthTcmedicineEditInfo;
import com.bofan.publichealth.elder.command.ElderHealthTcmedicineQueryInfo;
import com.bofan.publichealth.elder.valueobject.ElderHealthTcmItem;
import com.bofan.publichealth.elder.valueobject.ElderHealthTcmedicine;
import com.bofan.publichealth.elder.valueobject.HealthTcmedicine;
import com.bofan.publichealth.service.Corporeity;
import com.bofan.utils.Contstants;
import com.bofan.utils.JsonObj;
import com.bofan.utils.NullBeanUtils;
import com.bofan.utils.Tools;

/**
 * @Description: 老年人中医药评估主表 Service
 * @author lqw
 */
@Service
@Transactional
public class ElderHealthTcmedicineService extends AbstractAnnoCommonService {


    
    
    @Autowired
    private ElderHealthTcmItemService elderHealthTcmItemService;
    
    /**
     * 根据条件查询 老年人中医药评估主表 列表
     * @param queryInfo ElderHealthTcmedicineQueryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<ElderHealthTcmedicine> selectElderHealthTcmedicineList(ElderHealthTcmedicineQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
    
    /**
     * 根据条件查询 老年人中医药评估主表
     * @param queryInfo ElderHealthTcmedicineQueryInfo
     * @return
     */
    public ElderHealthTcmedicine findElderHealthTcmedicine(ElderHealthTcmedicineQueryInfo queryInfo) {
        List<ElderHealthTcmedicine> list = selectElderHealthTcmedicineList(queryInfo);
        if (Tools.isNotEmptyList(list)) {
            return list.get(0);
        }
        return null;
    }
 

    @SuppressWarnings("unchecked")
    public JsonObj saveElderHealthTcmedicine(String elderHealthTcmedicineRetionData) {
        JsonObj result = new JsonObj();
        JSONObject data = JSONObject.parseObject(elderHealthTcmedicineRetionData);
        String elderHealthTcmedicineEditInfoJson =  data.getString("elderHealthTcmedicineEditInfo");
        String elderHealthTcmItemEditInfoListJson =  data.getString("elderHealthTcmItemEditInfoList");
        ElderHealthTcmedicineEditInfo elderHealthTcmedicineEditInfo =  JSON.parseObject(elderHealthTcmedicineEditInfoJson, ElderHealthTcmedicineEditInfo.class);
        List<JSONObject> elderHealthTcmItemEditInfoList = JSON.parseObject(elderHealthTcmItemEditInfoListJson, List.class);
        
        
        ElderHealthTcmedicine elderHealthTcmedicine = null;
        if (null != elderHealthTcmedicineEditInfo.getElderHealthTcmedicineId()) {
            elderHealthTcmedicine = super.selectAObject(ElderHealthTcmedicine.class, elderHealthTcmedicineEditInfo.getElderHealthTcmedicineId());
            NullBeanUtils.copyProperties(elderHealthTcmedicine, elderHealthTcmedicineEditInfo);
        } else {
            elderHealthTcmedicine = new ElderHealthTcmedicine();
            NullBeanUtils.copyProperties(elderHealthTcmedicine, elderHealthTcmedicineEditInfo);
        }
        // 保存
        super.save(elderHealthTcmedicine);
        this.saveOrUpdateElderHealthTcmItem(elderHealthTcmItemEditInfoList,elderHealthTcmedicine);
        ElderHealthTcmResult elderHealthTcmResult = scoreResult(elderHealthTcmedicine.getElderHealthTcmedicineId());
        result.setData(elderHealthTcmResult);
        return result;
    }

    /**
     * 新增或者 修改 老年人自理能力评估明细
     * @param elderHealthTcmItemEditInfoList
     * @param elderHealthTcmedicine
     */
    @SuppressWarnings("rawtypes")
    private void saveOrUpdateElderHealthTcmItem(List<JSONObject> elderHealthTcmItemEditInfoList, ElderHealthTcmedicine elderHealthTcmedicine) {
        Iterator<ElderHealthTcmItem> personExposeDisIt = this.elderHealthTcmItemService.selectElderHealthTcmItemList(
                new ElderHealthTcmItemQueryInfo(elderHealthTcmedicine.getElderHealthTcmedicineId())) .iterator(); 
        if (!Tools.isNotEmptyList(elderHealthTcmItemEditInfoList)) { 
            // 如果页面传参不存在既往史，则删除已有的数据
            while ( personExposeDisIt.hasNext()) {
                ElderHealthTcmItem ElderHealthTcmItemDisease = (ElderHealthTcmItem) personExposeDisIt.next();
                super.delete(ElderHealthTcmItemDisease); 
            }
        } else {
            // 如果页面传参存在关联关系，则更新关联关系 
            Map<Long,ElderHealthTcmItem> elderHealthTcmItemMap = new HashMap<Long,ElderHealthTcmItem>();
            
            while (personExposeDisIt.hasNext()) {  
                ElderHealthTcmItem personExposeDisItem = (ElderHealthTcmItem) personExposeDisIt.next();
                elderHealthTcmItemMap.put(personExposeDisItem.getElderHealthTcmItemId(), personExposeDisItem);
            }
            for (JSONObject exposeDiseaseEditInfoJson : elderHealthTcmItemEditInfoList) {
                ElderHealthTcmItemEditInfo editInfo = JSON.parseObject(exposeDiseaseEditInfoJson.toJSONString(), ElderHealthTcmItemEditInfo.class);
                if (elderHealthTcmItemMap.containsKey(editInfo.getElderHealthTcmItemId())) {
                    elderHealthTcmItemMap.remove(editInfo.getElderHealthTcmItemId());
                } else {
                    //不包含则需要新增
                    ElderHealthTcmItem newElderHealthTcmItem = new ElderHealthTcmItem();
                    NullBeanUtils.copyProperties(newElderHealthTcmItem, editInfo);
                    newElderHealthTcmItem.setAssessTime(elderHealthTcmedicine.getAssessTime());
                    newElderHealthTcmItem.setElderHealthTcmedicineId(elderHealthTcmedicine.getElderHealthTcmedicineId());
                    newElderHealthTcmItem.setHospitalId(elderHealthTcmedicine.getHospitalId());
                    newElderHealthTcmItem.setPersonDetailId(elderHealthTcmedicine.getPersonDetailId());
                    newElderHealthTcmItem.setRegionId(elderHealthTcmedicine.getRegionId());
                    super.save(newElderHealthTcmItem);
                }
            }
            
            //删除页面已删除的既往史
            if (Tools.isNotEmptyMap(elderHealthTcmItemMap)) {
                Iterator it = elderHealthTcmItemMap.entrySet().iterator();
                while (it.hasNext()) {
                    super.delete((ElderHealthTcmItem) ((Map.Entry) it.next()).getValue());
                }
            }
        }
    }
    
    //中医药健康评估 分数 反向计分
    private Map<Integer,Integer> reverseScoreMap = new HashMap<Integer,Integer>();
    {
        reverseScoreMap.put(1, 5);
        reverseScoreMap.put(2, 4);
        reverseScoreMap.put(3, 3);
        reverseScoreMap.put(4, 2);
        reverseScoreMap.put(5, 1);
    }
 
    
    /**
     * 计算 体质 得分
     * @param elderHealthTcmedicineId
     *  气虚质（2）（3）（4）（14）
                    阳虚质（11）（12）（13）（29）
                    阴虚质（10）（21）（26）（31）
                    痰湿质（9）（16）（28）（32）
                    湿热质（23）（25）（27）（30）
                    血瘀质（19）（22）（24）（33）
                    气郁质（5）（6）（7）（8）
                    特禀质（15）（17）（18）（20） 
                        各条目得分相加之和≥11分   是
                        各条目得分相加之和为9～10分 倾向是
                        各条目得分相加之和≤8分    否
                        
                 平和质（1）（2）（4）（5）（13）
               （其中，（2）（4）（5）（13）反向计分，即1→5，2→4，3→3，4→2，5→1） 
                各条目得分相加之和≥17分，同时其他8种体质得分均≤8分    是
                各条目得分相加之和≥17分，同时其他8种体质得分均≤10分   基本是
                不满足上述条件者    否
     * @return
     */
    public ElderHealthTcmResult scoreResult(Long elderHealthTcmedicineId){
        Map<String,String> tcmDescMap = new HashMap<String,String>();
        ElderHealthTcmResult elderHealthTcmResult = new ElderHealthTcmResult();
        Map<Long,ElderHealthTcmItem> elderSelfCareItemMap =  selectElderHealthTcmItemMap(elderHealthTcmedicineId);

        ElderHealthTcmItem elderHealthTcmItem2 = elderSelfCareItemMap.get(2L);
        ElderHealthTcmItem elderHealthTcmItem3 = elderSelfCareItemMap.get(3L);
        ElderHealthTcmItem elderHealthTcmItem4 = elderSelfCareItemMap.get(4L);
        ElderHealthTcmItem elderHealthTcmItem14 = elderSelfCareItemMap.get(14L);
        int qizhixuScore = this.countTotalScore(elderHealthTcmItem2,elderHealthTcmItem3,elderHealthTcmItem4,elderHealthTcmItem14);
        tcmDescMap.put(Contstants.TCM_QIXU, socreResultDesc(qizhixuScore));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_QIXU, qizhixuScore, socreResultDesc(qizhixuScore)));

        ElderHealthTcmItem elderHealthTcmItem11 = elderSelfCareItemMap.get(11L);
        ElderHealthTcmItem elderHealthTcmItem12 = elderSelfCareItemMap.get(12L);
        ElderHealthTcmItem elderHealthTcmItem13 = elderSelfCareItemMap.get(13L);
        ElderHealthTcmItem elderHealthTcmItem29 = elderSelfCareItemMap.get(29L);
        int yangxuScore = this.countTotalScore(elderHealthTcmItem11,elderHealthTcmItem12,elderHealthTcmItem13,elderHealthTcmItem29);
        tcmDescMap.put(Contstants.TCM_YANGXU, socreResultDesc(yangxuScore));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_YANGXU, yangxuScore, socreResultDesc(yangxuScore)));
        
        ElderHealthTcmItem elderHealthTcmItem10 = elderSelfCareItemMap.get(10L);
        ElderHealthTcmItem elderHealthTcmItem21 = elderSelfCareItemMap.get(21L);
        ElderHealthTcmItem elderHealthTcmItem26 = elderSelfCareItemMap.get(26L);
        ElderHealthTcmItem elderHealthTcmItem31 = elderSelfCareItemMap.get(31L);
        int yinxuScore = this.countTotalScore(elderHealthTcmItem10,elderHealthTcmItem21,elderHealthTcmItem26,elderHealthTcmItem31);
        tcmDescMap.put(Contstants.TCM_YINXU, socreResultDesc(yinxuScore));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_YINXU, yinxuScore, socreResultDesc(yinxuScore)));
        
        ElderHealthTcmItem elderHealthTcmItem9 = elderSelfCareItemMap.get(9L);
        ElderHealthTcmItem elderHealthTcmItem16 = elderSelfCareItemMap.get(16L);
        ElderHealthTcmItem elderHealthTcmItem28 = elderSelfCareItemMap.get(28L);
        ElderHealthTcmItem elderHealthTcmItem32 = elderSelfCareItemMap.get(32L);
        int tanshiScore = this.countTotalScore(elderHealthTcmItem9,elderHealthTcmItem16,elderHealthTcmItem28,elderHealthTcmItem32);
        tcmDescMap.put(Contstants.TCM_TANSHI, socreResultDesc(tanshiScore));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_TANSHI, tanshiScore, socreResultDesc(tanshiScore)));
        
        ElderHealthTcmItem elderHealthTcmItem23 = elderSelfCareItemMap.get(23L);
        ElderHealthTcmItem elderHealthTcmItem25 = elderSelfCareItemMap.get(25L);
        ElderHealthTcmItem elderHealthTcmItem27 = elderSelfCareItemMap.get(27L);
        ElderHealthTcmItem elderHealthTcmItem30 = elderSelfCareItemMap.get(30L);
        int shireScore = this.countTotalScore(elderHealthTcmItem23,elderHealthTcmItem25,elderHealthTcmItem27,elderHealthTcmItem30);
        tcmDescMap.put(Contstants.TCM_SHIRE, socreResultDesc(shireScore));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_SHIRE, shireScore, socreResultDesc(shireScore)));
        
        ElderHealthTcmItem elderHealthTcmItem19 = elderSelfCareItemMap.get(19L);
        ElderHealthTcmItem elderHealthTcmItem22 = elderSelfCareItemMap.get(22L);
        ElderHealthTcmItem elderHealthTcmItem24 = elderSelfCareItemMap.get(24L);
        ElderHealthTcmItem elderHealthTcmItem33 = elderSelfCareItemMap.get(33L);
        int xueyuScore = this.countTotalScore(elderHealthTcmItem19,elderHealthTcmItem22,elderHealthTcmItem24,elderHealthTcmItem33);
        tcmDescMap.put(Contstants.TCM_XUEYU, socreResultDesc(xueyuScore));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_XUEYU, xueyuScore, socreResultDesc(xueyuScore)));
        
        ElderHealthTcmItem elderHealthTcmItem5 = elderSelfCareItemMap.get(5L);
        ElderHealthTcmItem elderHealthTcmItem6 = elderSelfCareItemMap.get(6L);
        ElderHealthTcmItem elderHealthTcmItem7 = elderSelfCareItemMap.get(7L);
        ElderHealthTcmItem elderHealthTcmItem8 = elderSelfCareItemMap.get(8L);
        int qiyuScore = this.countTotalScore(elderHealthTcmItem5,elderHealthTcmItem6,elderHealthTcmItem7,elderHealthTcmItem8);
        tcmDescMap.put(Contstants.TCM_QIYU, socreResultDesc(qiyuScore));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_QIYU, qiyuScore, socreResultDesc(qiyuScore)));
        
        ElderHealthTcmItem elderHealthTcmItem15 = elderSelfCareItemMap.get(15L);
        ElderHealthTcmItem elderHealthTcmItem17 = elderSelfCareItemMap.get(17L);
        ElderHealthTcmItem elderHealthTcmItem18 = elderSelfCareItemMap.get(18L);
        ElderHealthTcmItem elderHealthTcmItem20 = elderSelfCareItemMap.get(20L);
        int tebingScore = this.countTotalScore(elderHealthTcmItem15,elderHealthTcmItem17,elderHealthTcmItem18,elderHealthTcmItem20);
        tcmDescMap.put(Contstants.TCM_TEBIN, socreResultDesc(tebingScore));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_TEBIN, tebingScore, socreResultDesc(tebingScore)));
        
        ElderHealthTcmItem elderHealthTcmItem1 = elderSelfCareItemMap.get(1L);
        Integer pingheScore = elderHealthTcmItem1.getTcmScore() + countReverseTotalScore(elderHealthTcmItem2,elderHealthTcmItem4,elderHealthTcmItem5,elderHealthTcmItem13);
      
        String pingheSoreResutlDesc = "";
        if (pingheScore >= 17 && (qizhixuScore <= 8)) {
            pingheSoreResutlDesc = Contstants.CORPOREITY_BELONG_YES;
        } else if (pingheScore >= 17 && (qizhixuScore <= 10)){
            pingheSoreResutlDesc = Contstants.CORPOREITY_BELONG_YES_PARTIAL;
        } else {
            pingheSoreResutlDesc = Contstants.CORPOREITY_BELONG_NO;
        }
       
        tcmDescMap.put(Contstants.TCM_PINGHE, pingheSoreResutlDesc);
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_PINGHE, pingheScore, pingheSoreResutlDesc));
        System.out.println("elderHealthTcmResult1 = " + JSON.toJSONString(elderHealthTcmResult.getInclinationCorporeityList()));
        System.out.println("elderHealthTcmResult2 = " + JSON.toJSONString(elderHealthTcmResult.getMainCorporeityList()));
        System.out.println("elderHealthTcmResult3 = " + JSON.toJSONString(elderHealthTcmResult));
        return elderHealthTcmResult;
    }
    
    /**
     * 计算各项的得分 总和
     * @param objects
     * @return
     */
    private Integer countTotalScore(ElderHealthTcmItem ...objects){
        int totalItemScore = 0;
        for (ElderHealthTcmItem tcmItem : objects) {
            if (null == tcmItem || null == tcmItem.getTcmScore()) {
                continue;
            }
            totalItemScore += tcmItem.getTcmScore();
        }
        return totalItemScore;
    }

    
    /**
     * 计算 评估项 的 反向计分 总和
     * @param objects
     * @return
     */
    public Integer countReverseTotalScore(ElderHealthTcmItem ...objects){
        int totalItemScore = 0;
        for (ElderHealthTcmItem tcmItem : objects) {
            if (null == tcmItem.getTcmScore()) {
                continue;
            }
            totalItemScore +=  reverseScoreMap.get(tcmItem.getTcmScore());
        }
        return totalItemScore;
    }
    
    public ElderHealthTcmResult initElderHealthTcmResult(){
        ElderHealthTcmResult elderHealthTcmResult = new ElderHealthTcmResult();
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_QIXU, null, null));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_YANGXU, null, null));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_YINXU, null, null));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_TANSHI, null, null));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_SHIRE, null, null));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_XUEYU, null, null));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_TEBIN, null, null));
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_QIYU, null, null)); 
        elderHealthTcmResult.addCorporeity(new Corporeity(Contstants.TCM_PINGHE, null, null));
        return elderHealthTcmResult;
    }
    
    
    /**
     * 通过分数 获取 体质归属
     * @param score
     * @return
     */
    public String socreResultDesc(int score){
//      各条目得分相加之和≥11分   是
//      各条目得分相加之和为9～10分 倾向是
//      各条目得分相加之和≤8分    否
        String resultDesc = "";
        if (score <= 8) {
            resultDesc = Contstants.CORPOREITY_BELONG_NO;
        } else if (score >= 9 && score <= 10){
            resultDesc = Contstants.CORPOREITY_BELONG_YES_PARTIAL;
        } else if (score >= 11){
            resultDesc = Contstants.CORPOREITY_BELONG_YES;
        } 
        return resultDesc;
    }

    /**
     * 查询 自中医药健康字典表--老年人
     * @param queryInfo
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<HealthTcmedicine> selectHealthTcmedicineList(HealthTcmedicineQueryInfo queryInfo) {
        IQueryObject qo = super.getQueryObject(queryInfo);
        return super.executeSql(qo.getQueryString(),qo.getParam());
    }
 
    /**
     * 老年人中医药评估明细 的 map 集合
     * @param elderHealthTcmedicineId
     * @return
     */
    public Map<Long,ElderHealthTcmItem> selectElderHealthTcmItemMap(Long elderHealthTcmedicineId) {
        Map<Long,ElderHealthTcmItem> elderSelfCareItemMap = new HashMap<Long,ElderHealthTcmItem>();
        List<ElderHealthTcmItem>  elderSelfCareItemList  = this.elderHealthTcmItemService.selectElderHealthTcmItemList(new ElderHealthTcmItemQueryInfo(elderHealthTcmedicineId));
        if (!Tools.isNotEmptyList(elderSelfCareItemList)) {
            return elderSelfCareItemMap;
        }
        for (ElderHealthTcmItem elderSelfCareItem : elderSelfCareItemList) {
            elderSelfCareItemMap.put(elderSelfCareItem.getHealthTcmedicineId(), elderSelfCareItem);
        }
        return elderSelfCareItemMap;
    }

    /**
     * 删除  老年人中医药评估 
     * @param elderHealthTcmedicineId
     */
    public void delElderHealthTcmedicine(Long elderHealthTcmedicineId) {
        //删除 老年人中医药评估明细表
        List<ElderHealthTcmItem>  elderSelfCareItemList  = this.elderHealthTcmItemService.selectElderHealthTcmItemList(new ElderHealthTcmItemQueryInfo(elderHealthTcmedicineId));
        if (Tools.isNotEmptyList(elderSelfCareItemList)) {
            super.deleteAll(elderSelfCareItemList);
        }
        // 删除 老年人中医药评估主表
        ElderHealthTcmedicine  elderHealthTcmedicine = super.selectAObject(ElderHealthTcmedicine.class,elderHealthTcmedicineId);
        super.delete(elderHealthTcmedicine);
    
    }
    
}