package com.bofan.lis.webservice;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Description: webservice传输数据，包括json字符串和附件数据
 * @author lqw
 * @date 2017年9月29日 下午5:36:17 
 * @version V1.0
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TransferBody {
	
	/** json 传输参数 **/
	private String jsonParam;
	
	/** 注：这是一个附件类型的数据 **/
	@XmlMimeType("application/octet-stream")
	private DataHandler dataHandler;

	public String getJsonParam() {
		return jsonParam;
	}

	public void setJsonParam(String jsonParam) {
		this.jsonParam = jsonParam;
	}

	public DataHandler getDataHandler() {
		return dataHandler;
	}

	public void setDataHandler(DataHandler dataHandler) {
		this.dataHandler = dataHandler;
	}

}
