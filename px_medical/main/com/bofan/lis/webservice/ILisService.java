package com.bofan.lis.webservice;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.soap.MTOM;


@WebService(name = "lisService") // name属性标注在接口类上，可以指定wsdl中接口名称，也就是生成的客户端代码中接口类的名字。
@SOAPBinding(style = SOAPBinding.Style.RPC)  // 指定SOAP消息样式
@MTOM  // 开启MTOM功能
public interface ILisService {
	
	
	/**
	 * 创建检验申请单信息
	 * @param jsonParams
	 * @return
	 */
	public String createRequisitionInfo(String jsonParams);
	
	/**
	 * 获取检验申请单信息
	 * @param jsonParams
	 * @return
	 */
	public String getRequisitionInfo(String jsonParams);
	
	/**
	 * 创建检验样本信息
	 * @param jsonParams
	 * @return
	 */
	public String createInspectionSample(String jsonParams);
	
	/**
	 * 获取检验样本信息
	 * @param jsonParams
	 * @return
	 */
	public String getInspectionSample (String jsonParams);

	/**
	 * 创建患者检验图像
	 * @param jsonParams
	 * @return
	 */
	public String createInspectionSampleGraph(String jsonParams);
	
	/**
	 * 获取患者检验图像列表（不包含base64图像数据）
	 * @param jsonParams
	 * @return
	 */
	public String getInspectionSampleGraphList(String jsonParams);
	
	/**
	 * 获取患者检验图像base64图像数据
	 * @param jsonParams
	 * @return
	 */
	public String getInspectionSampleGraphData(String jsonParams);
	
	/**
	 * 创建检验样本结果解释信息
	 * @param jsonParams
	 * @return
	 */
	public String createInspectionSampleExplain(String jsonParams);
	
	/**
	 * 创建检验样本结果-一般检验
	 * @param jsonParams
	 * @return
	 */
	public String createInspectionResult(String jsonParams);
	
	/**
	 * 创建检验样本结果-微生物
	 * @param jsonParams
	 * @return
	 */
	public String createInspectionResultMicro(String jsonParams);
	
	/**
	 * 将文件的字节数组存入bdb数据库
	 * @param fileUuid
	 * @param byteData
	 */
	String  putByteFile(String fileUuid, byte[] byteData);
	
    /**
     * 通过fileUuid获取文件字节数组
     * @param fileUuid
     * @return
     */
	byte[] getFileByte(String bdbSavePath, String fileUuid);
	
    /**
     *  同步 检验分组信息表
     * @param jsonParam
     */
	public void syncLisInspectionGroup(String jsonParam);
	
	/**
     *  同步 检验样本结果表_一般检验
     * @param jsonParam
     */
	public void syncLisInspectionResult(String jsonParam);
	
	/**
     *  同步 检验样本结果表_微生物
     * @param jsonParam
     */
	public void syncLisInspectionResultMicro(String jsonParam);
	
	/**
     *  同步 检验样本信息表
     * @param jsonParam
     */
	public void syncLisInspectionSample(String jsonParam);
	
	/**
     *  同步 检验样本图片信息表
     * @param jsonParam
     */
	public void syncLisInspectionSampleGraph(TransferBody transferBody);
	
	/**
     *  同步 申请单病人信息表
     * @param jsonParam
     */
	public void syncLisRequisitionInfo(String jsonParam);
	
	/**
     *  同步 基础信息表_一般检验
     * @param jsonParam
     */
	public void syncLisBaseData(String jsonParam);
    
	/**
     *  同步 基础数据表_微生物查询
     * @param jsonParam
     */
	public void syncLisMicroData(String jsonParam);
	
	/**
     *  同步 检验样本结果解释表
     * @param jsonParam
     */
	public void syncLisInspectionSampleExplain(String jsonParam);
	 
     
}