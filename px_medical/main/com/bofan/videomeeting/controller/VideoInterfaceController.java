package com.bofan.videomeeting.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bofan.videomeeting.video.VideoMeetingUtils;

/**
 * @Description
 * @author xlf
 * @version 
 * 2017-10-13
 */
@Controller
@RequestMapping("/video")
public class VideoInterfaceController {
    /** logger */
    protected static Logger logger = Logger.getLogger(VideoInterfaceController.class.getName());
    
    @Autowired
    private VideoMeetingUtils videoMeetingUtils;
    
    /**
     * 
     * @param view
     * @return
     */
    @RequestMapping("/editPage")
    public String eidtPage(String view) {
        return "video/" + view;
    }
    
    /**
     * 
     * @param request
     * @return
     */
    @RequestMapping("/addMeetting")
    public @ResponseBody String addMeetting(String userLogin, String userPwd, String topic, String beginTime, String enTime, String userNum) {
    	String result = this.videoMeetingUtils.createMeeting(userLogin, userPwd, topic, beginTime, enTime, Integer.valueOf(userNum));
    	return result;
    }
    
    /**
     * 
     * @param request
     * @return
     */
    @RequestMapping("/addDep")
    public @ResponseBody String addDep(String depName, String depDesc, String thirdDeptId, String thirdParentId, String userNum,
            String inAddress, String depOrder) {
    	this.videoMeetingUtils.createDep(depName, depDesc, thirdDeptId, thirdParentId, userNum, inAddress, depOrder);
    	return "0";
    }
    
    /**
     * 
     * @param request
     * @return
     */
    @RequestMapping("/addUser")
    public @ResponseBody String addUser(String username, String userpasswd, String realname, String role,
            String thirduserid, String thirddeptid, String usernum, String sex, String email, String telephone,
            String mobile, String levelid, String imconference, String inaddress, String userorder) {
    	
    	this.videoMeetingUtils.createUser(username, userpasswd, realname, role, thirduserid, thirddeptid, usernum,
    			sex, email, telephone, mobile, levelid, imconference, inaddress, userorder);
    	return "0";
    }
    
    

}
