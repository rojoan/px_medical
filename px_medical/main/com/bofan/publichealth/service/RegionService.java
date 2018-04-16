package com.bofan.publichealth.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.dictionary.support.DictionarysInVelocityToolbox;
import com.bofan.publichealth.command.RegionQueryInfo;
import com.bofan.publichealth.valueobject.Region;
import com.bofan.utils.Contstants;

/**
 * @Description: 城镇街道业务
 * @author lqw
 */
@Service
@Transactional
public class RegionService extends AbstractAnnoCommonService {

	/**
	 * 城市街道的CityPicker 格式数据
	 */
    @SuppressWarnings("unchecked")
	public Map<String,Object> regionCityPicker() {
		Map<String,Object> regionJsonData = new HashMap<String,Object>();
        List<Region> regionFirstLevellist = new ArrayList<Region>(); 
        List<Region> regionSecondLevellist = new ArrayList<Region>();
        List<Region> regionThirdLevellist = new ArrayList<Region>();
		
        //查询Region列表
        IQueryObject qo = super.getQueryObject(new RegionQueryInfo());
        List<Region> list = super.executeSql(qo.getQueryString(), qo.getParam());
        if (list == null || list.size() == 0) {
			return regionJsonData;
		}
        
        //对第一、第二、第三级进行分组
        for (Region region : list) {
			if (region.getRegionId().length() == Contstants.REGION_ID_FIRST_LEVEL_SIZE ) {
				regionFirstLevellist.add(region);
			} else if (region.getRegionId().length() == Contstants.REGION_ID_SECOND_LEVEL_SIZE){
				regionSecondLevellist.add(region);
			} else{
				regionThirdLevellist.add(region);
			}
		}
        
        //将第一级街道封装到Map,并保存到 regionJsonData
        Map<String,Object> topLevelArrayMap = new HashMap<String,Object>();
        List<Map<String,String>> regionFirstLevelMaplist = new ArrayList<Map<String,String>>(); 
        for (Region regionFirstLevel : regionFirstLevellist) {
			Map<String,String> regionFirstLevelMap = new HashMap<String,String>();
			regionFirstLevelMap.put("code", regionFirstLevel.getRegionId());
			regionFirstLevelMap.put("address", regionFirstLevel.getRegionName());
			regionFirstLevelMaplist.add(regionFirstLevelMap);
		}  
        
        //规定的json格式
        topLevelArrayMap.put("", regionFirstLevelMaplist);
        regionJsonData.put("86", topLevelArrayMap);
        
        //将第一级街道对应的第二 级街道封装到Map,并保存到 regionJsonData
        for (Region regionFirstLevel : regionFirstLevellist) {
			Map<String,String> regionSecondLevelMap = new HashMap<String,String>();
			//regionFirstLevelMap
			for (Region region : regionSecondLevellist) {
				if (region.getRegionId().startsWith(regionFirstLevel.getRegionId())) {
					regionSecondLevelMap.put(region.getRegionId(), region.getRegionName());
				}
			}
			if (!regionSecondLevelMap.isEmpty()) {
				regionJsonData.put(regionFirstLevel.getRegionId(), regionSecondLevelMap);
			}
		}  
         
        //将第二级街道对应的第三级街道封装到Map,并保存到 regionJsonData
        for (Region regionSecondLevel : regionSecondLevellist) {
        	Map<String,String> regionthirdLevelMap = new HashMap<String,String>();
        	//regionFirstLevelMap
        	for (Region region : regionThirdLevellist) {
        		
        		if (region.getRegionId().startsWith(regionSecondLevel.getRegionId())) {
        			regionthirdLevelMap.put(region.getRegionId(), region.getRegionName());
				}
        	}
        	if (!regionthirdLevelMap.isEmpty()) {
        		regionJsonData.put(regionSecondLevel.getRegionId(), regionthirdLevelMap);
        	}
        }
        
        return regionJsonData;
    } 
    
    /**
	 * 将街道Id解析出街道的名称
	 * @param regionId 街道Id
	 * @return 街道的名称(市/镇/村)
	 */
	@SuppressWarnings("rawtypes")
	public String parseRegionAdress(String regionId) {
		Map dicRegionMap = (Map) DictionarysInVelocityToolbox.getDictionary("dicRegion");
		String regionAddress = "";
		if (StringUtils.isBlank(regionId)) {
			return regionAddress;
		}
		if (regionId.length() == Contstants.REGION_ID_FIRST_LEVEL_SIZE) {
			//只包含市
			regionAddress = (String)dicRegionMap.get(regionId);
		}else if(regionId.length() == Contstants.REGION_ID_SECOND_LEVEL_SIZE) {
			//包含市/镇
			regionAddress = (String)dicRegionMap.get(regionId.substring(0, Contstants.REGION_ID_FIRST_LEVEL_SIZE)) //市
					+ "/"  + (String)dicRegionMap.get(regionId);//镇
		} else {
			//包含市/镇/村
			regionAddress = (String)dicRegionMap.get(regionId.substring(0, Contstants.REGION_ID_FIRST_LEVEL_SIZE)) //市
					 + "/"  
			         + (String)dicRegionMap.get(regionId.substring(0, Contstants.REGION_ID_SECOND_LEVEL_SIZE)) //镇
			         + "/" 
			         + (String)dicRegionMap.get(regionId); //村
		}
		return regionAddress;
	}
 

}
