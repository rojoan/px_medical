package com.bofan.videomeeting.video;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VideoMeetingUtils {

    public static final String XML_HEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Package";

    @Value("${videoCreateDepCode}")
    private int videoCreateDepCode;

    @Value("${videoCreateUserCode}")
    private int videoCreateUserCode;

    @Value("${videoCreateMeetingCode}")
    private int videoCreateMeetingCode;

    @Value("${videoReqeustMethod}")
    private String videoReqeustMethod;

    @Value("${videoDepRequestUrl}")
    private String videoDepRequestUrl;

    @Value("${videoUserRequestUrl}")
    private String videoUserRequestUrl;

    @Value("${videoMeetingRequestUrl}")
    private String videoMeetingRequestUrl;
    
    @Value("${enterMeetingRequestUrl}")
    private String enterMeetingRequestUrl;
    
    @Value("${mobileEnterMeetingRequestUrl}")
    private String mobileEnterMeetingRequestUrl;
    
    @Value("${MeetingRequestProtocol}")
    private String MeetingRequestProtocol;
    
    /** 会议房间编号，用于替换进入会议的占位符 */
    private static final String ROOM_NO = "{roomNo}";
    /** 会议显示昵称，用于替换进入会议的占位符 */
    private static final String SHOW_NAME = "{shouName}";
    /** 会议房间密码，用于替换进入会议的占位符 */
    private static final String ROOM_PWD = "{roomPwd}";
    /** 进入会议房间账号，用于替换进入会议的占位符 */
    private static final String USER_NAME = "{userName}";
    /** 进入会议房间账号密码，用于替换进入会议的占位符 */
    private static final String USER_PWD = "{userPwd}";
    /** 会议房间编号，用于替换进入会议的占位符 */
    private static final String PC_URL_KEY = "{key}";

    /**
     * 生成进入会议的url地址
     * @param confId
     * @param sysUserName
     * @param meetingPwd
     * @param meetingUser
     * @param meetingUserPwd
     * @return
     * @throws UnsupportedEncodingException
     */
    public String buildMeetingUrl(String confId, String sysUserName, String meetingPwd, String meetingUser,
            String meetingUserPwd, boolean isMobile) {
        String strUrl = this.enterMeetingRequestUrl.replace(ROOM_NO, confId).replace(SHOW_NAME, sysUserName)
                .replace(ROOM_PWD, meetingPwd).replace(USER_NAME, meetingUser).replace(USER_PWD, meetingUserPwd);

        String result = null;
		try {
			result = new String(Base64.encodeBase64(strUrl.getBytes()), "UTF-8");
		} catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
		}
        if (isMobile) {
            return this.mobileEnterMeetingRequestUrl.replace(ROOM_NO, confId).replace(PC_URL_KEY, result);
        }
        return MeetingRequestProtocol + result;

    }
    
    /**
     * 创建用户
     * 
     * @return
     * @throws Exception
     */
    public String createUser(String username, String userpasswd, String realname, String role, String thirduserid,
            String thirddeptid, String usernum, String sex, String email, String telephone, String mobile,
            String levelid, String imconference, String inaddress, String userorder) {
        StringBuffer xml = new StringBuffer(XML_HEAD);
        xml.append(" username=\"").append(null == username ? "" : username).append("\"");
        xml.append(" userpasswd=\"").append(null == userpasswd ? "" : userpasswd).append("\"");
        xml.append(" realname=\"").append(null == realname ? "" : realname).append("\"");
        // 1部门管理员； 2预定用户； 3普通用户
        xml.append(" role=\"").append(null == role ? "" : role).append("\"");
        // 用户ID
        xml.append(" thirduserid=\"").append(null == thirduserid ? "" : thirduserid).append("\"");
        // 用户所属部门ID
        xml.append(" thirddeptid=\"").append(null == thirddeptid ? "" : thirddeptid).append("\"");
        xml.append(" usernum=\"").append(null == usernum ? "" : usernum).append("\"");

        xml.append(" sex=\"").append(null == sex ? "" : sex).append("\"");
        xml.append(" email=\"").append(null == email ? "" : email).append("\"");
        xml.append(" telephone=\"").append(null == telephone ? "" : telephone).append("\"");
        xml.append(" mobile=\"").append(null == mobile ? "" : mobile).append("\"");
        xml.append(" levelid=\"").append(null == levelid ? "" : levelid).append("\"");
        // 发起及时会议权限 1 有权限 0没有权限
        xml.append(" imconference=\"").append(null == imconference ? "" : imconference).append("\"");
        // 是否加入企业通讯簿 1 加入 0不加入
        xml.append(" inaddress=\"").append(null == inaddress ? "" : inaddress).append("\"");
        xml.append(" userorder=\"").append(null == userorder ? "" : userorder).append("\"");
        xml.append(" />");

        return excuteInvoke(this.videoUserRequestUrl, xml.toString(), this.videoCreateUserCode);

    }

    /**
     * 创建部门
     * @param depName 部门名称
     * @param depDesc 部门藐视
     * @param thirdDeptId 第三方部门Id
     * @param thirdParentId 第三方父部门Id
     * @param userNum 允许参加会议的人数
     * @param inAddress 是否接入企业通讯录  1：加入；0：不加入
     * @param depOrder 部门排序
     * @return
     * @throws Exception 
     */
    public String createDep(String depName, String depDesc, String thirdDeptId, String thirdParentId, String userNum,
            String inAddress, String depOrder) {
        StringBuffer xml = new StringBuffer(XML_HEAD);
        xml.append(" deptname=\"").append(null == depName ? "" : depName).append("\"");
        xml.append(" deptdesc=\"").append(null == depDesc ? "" : depDesc).append("\"");
        // 部门ID
        xml.append(" thirddeptid=\"").append(null == thirdDeptId ? "" : thirdDeptId).append("\"");
        xml.append(" thirdparentid=\"").append(null == thirdParentId ? "" : thirdParentId).append("\"");
        // 允许参与会议的人数
        xml.append(" usernum=\"").append(null == userNum ? "" : userNum).append("\"");
        // 是否接入企业通讯录 0 不加入
        xml.append(" inaddress=\"").append(null == inAddress ? "" : inAddress).append("\"");
        xml.append(" deptorder=\"").append(null == depOrder ? "" : depOrder).append("\"");
        xml.append(" />");
        
        return excuteInvoke(this.videoDepRequestUrl, xml.toString(), this.videoCreateDepCode);

    }

    /**
     * 
     * @param topic
     * @param beginTime
     * @param enTime
     * @param userNum
     * @return
     * @throws Exception 
     */
    public String createMeeting(String userLogin, String userPwd, String topic, String beginTime, String enTime, int userNum) {
        StringBuffer xml = new StringBuffer(XML_HEAD);
        xml.append(" username=\"").append(null == userLogin ? "" : userLogin).append("\"");
        xml.append(" userpassword=\"").append(null == userPwd ? "" : userPwd).append("\"");
        // 会议名称
        xml.append(" topic=\"").append(null == topic ? "" : topic).append("\"");
        xml.append(" begintime=\"").append(null == beginTime ? "" : beginTime).append("\"");
        xml.append(" endtime=\"").append(null == enTime ? "" : enTime).append("\"");

        // 是否及时会议（1不是；0是；）,现暂时默认固定会议
        xml.append(" clientconf=\"").append(VideoContstants.YES_FIXED_FLAG).append("\"");
        // 会议人数
        xml.append(" attendnum=\"").append(userNum).append("\"");
        xml.append(" />");

        String result = excuteInvoke(this.videoMeetingRequestUrl, xml.toString(), this.videoCreateMeetingCode);
        Document document;
		try {
			document = DocumentHelper.parseText(result);
		} catch (DocumentException e) {
            throw new RuntimeException(e);
		}
        String confId = document.getRootElement().elementText("confid");
        
        if (StringUtils.isBlank(confId)) {
            throw new RuntimeException("创建会议失败，返回结果:" + result + ", requestParams:" + xml.toString());
        }
        return confId;

    }

    /**
     * 调用执行webservicce方法
     * 
     * @param reqeustUrl
     * @param xml
     * @param code
     * @throws Exception
     */
    private String excuteInvoke(String reqeustUrl, String xml, int code) {

        Service service = new Service();
        Call call;
        String result = null;
		try {
			call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(reqeustUrl));
			call.setOperationName(this.videoReqeustMethod);
			
			Object[] s = new Object[] { code, xml, "" };
			// 调用方法
            result = (String) call.invoke(s);
		} catch (ServiceException ex) {
			throw new RuntimeException(ex);
		} catch (MalformedURLException el) {
			throw new RuntimeException(el);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
        // 返回值
        System.out.println(result);
        return result;

    }

}
