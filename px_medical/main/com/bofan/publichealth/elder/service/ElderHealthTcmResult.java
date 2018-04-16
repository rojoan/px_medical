package com.bofan.publichealth.elder.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bofan.publichealth.service.Corporeity;
import com.bofan.utils.Contstants;
import com.bofan.utils.NullBeanUtils;


/**
 * 老年人 中医健康评估 体质 结果
 * @Description: 
 * @author lqw
 */
public class ElderHealthTcmResult{
   
    /** 体质List */
    List<Corporeity> corporeityList = new ArrayList<Corporeity>();
    /** 体质Map */
    Map<String,Corporeity> corporeityMap = new HashMap<String,Corporeity>();
    /** 主要体质List */
    List<Corporeity> mainCorporeityList = new ArrayList<Corporeity>();
    /** 偏向体质List */
    List<Corporeity> inclinationCorporeityList = new ArrayList<Corporeity>();
    
    public void addCorporeity(Corporeity corporeity){
        corporeityList.add(corporeity);
        corporeityMap.put(corporeity.getCorporeityType(), corporeity);
        if (Contstants.CORPOREITY_BELONG_YES.equals(corporeity.getBelong())) {
            Corporeity newCorporeity = new Corporeity();
            NullBeanUtils.copyProperties(newCorporeity, corporeity);
            mainCorporeityList.add(corporeity);
        }
        if (Contstants.CORPOREITY_BELONG_YES_PARTIAL.equals(corporeity.getBelong())) {
            Corporeity newCorporeity = new Corporeity();
            NullBeanUtils.copyProperties(newCorporeity, corporeity);
            inclinationCorporeityList.add(corporeity);
        }
    }
    
    /**
     * @return corporeityList
     */
    public List<Corporeity> getCorporeityList() {
        return corporeityList;
    }
    
    /**
     * @param corporeityList 要设置的 corporeityList
     */
    public void setCorporeityList(List<Corporeity> corporeityList) {
        this.corporeityList = corporeityList;
    }
    
    /**
     * @return mainCorporeityList
     */
    public List<Corporeity> getMainCorporeityList() {
       
        return mainCorporeityList;
    }
    
    /**
     * @param mainCorporeityList 要设置的 mainCorporeityList
     */
    public void setMainCorporeityList(List<Corporeity> mainCorporeityList) {
        this.mainCorporeityList = mainCorporeityList;
    }
    
    /**
     * @return inclinationCorporeityList
     */
    public List<Corporeity> getInclinationCorporeityList() {
        return inclinationCorporeityList;
    }
    
    /**
     * @param inclinationCorporeityList 要设置的 inclinationCorporeityList
     */
    public void setInclinationCorporeityList(List<Corporeity> inclinationCorporeityList) {
        this.inclinationCorporeityList = inclinationCorporeityList;
    }

    /**
     * @return corporeityMap
     */
    public Map<String, Corporeity> getCorporeityMap() {
        return corporeityMap;
    }

    /**
     * @param corporeityMap 要设置的 corporeityMap
     */
    public void setCorporeityMap(Map<String, Corporeity> corporeityMap) {
        this.corporeityMap = corporeityMap;
    }
}
