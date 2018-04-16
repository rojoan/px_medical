package com.bofan.pacs.webservice;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.soap.MTOM;


@WebService(name = "pacsService") // name属性标注在接口类上，可以指定wsdl中接口名称，也就是生成的客户端代码中接口类的名字。
@SOAPBinding(style = SOAPBinding.Style.RPC)  // 指定SOAP消息样式
@MTOM  // 开启MTOM功能
public interface IPacsService {
	
	/**
	 * 创建患者检查信息
	 * @param jsonParam
	 * @return
	 */
	public String createPatientExam(String jsonParams);
	
	/**
	 * 查询患者检信息
	 * @param jsonParam
	 * @return
	 */
	public String getPatientExam(String jsonParams);
	
	/**
	 * 创建患者检查图像
	 * @param jsonParams
	 */
	public String createPatientImage(String jsonParams, @XmlMimeType("*/*") @WebParam(name="fileData")DataHandler dataHandler); 
	
	
	/**
	 * 获取患者检查图像信息列表（不包含图像base64图像数据）
	 * @param jsonParams
	 * @return
	 */
	public String getPatientImageList(String jsonParams);
	
	/**
	 * 获取患者检查图像数据
	 * @param jsonParams
	 * @return
	 */
	@XmlMimeType("*/*")
	public DataHandler getPatientImageData(String jsonParams);
	
	
	/**
	 * 创建患者影像检查结果
	 * @param jsonParams
	 * @return
	 */
	public String createExamResult(String jsonParams);
	
	
    
	/**
	 * @param fileUuid
	 * @param byteData
	 * @return bdb database path
	 */
	public String  putByteFile(String fileUuid,byte[] byteData);
	
	/**
	 * dicomService解析dicom文件 返回base64数组的图片数据
	 * @param patientId = patientExamId (由于表结果，固定此字段为patientId)
	 * @param base64Data base64数组的图片数据 
	 * @return
	 */
	public String putImgBase64(String patientId, String[] base64Data);
	
	/**
	 * dicomService解析dicom文件 返回base64数组的图片数据、和pacsDetail的相关信息
	 * @param patientId = patientExamId (由于表结果，固定此字段为patientId)
	 * @param base64Data base64数组的图片数据 
	 * @param dicomDataArr pacsDetail的相关信息
	 */
	public void putDicomData(String patientId, String[] base64Data, String dicomDataMap);
	
	/**
     * 通过fileUuid获取文件字节数组
     * @param fileUuid
     * @return
     */
	byte[] getFileByte(String bdbSavePath, String fileUuid);

	/**
	 * 解析检查记录对应的dicom文件到bdb库
	 * @param jsonParam
	 */
	public void parseExamDicom(String jsonParam);
	
	/**
	 * 请求dicomService服务解析dicom文件成二进制和PacsDetail相关信息返回
	 * @param patientExamId
	 */
	public void parseDicomToPacsDetail(String patientExamId);
	
    /**
     * 保存DicomService 的PaceInfo数据
     * @param jsonParam
     */
    public void syncPacsDetail(TransferBody transferBody) throws Exception ;
    
    /**
     * 同步临床科室信息
     * 各个医院的PACS系统临床科室信息
     * @param jsonParam 
     * @return
     */
	public void syncClinicDep(String jsonParam);
    
    /**
     * 同步临床医生信息
     * 各个医院的PACS系统临床医生表
     * @param jsonParam 
     * @return
     */
    public void syncClinicDoctor(String jsonParam);
    
    /**
     * 同步临床信息
     * 各个医院的PACS系统临床信息
     * @param jsonParam 
     * @return
     */
    public void syncClinicInfo(String jsonParam);
    
    /**
     * 同步图像匹配表
     * 各个医院的PACS系统图像匹配表
     * @param jsonParam 
     * @return
     */
    public void syncDicomMatch(String jsonParam);
    
    /**
     * 同步图像信息记录表
     * 各个医院的PACS系统图像信息记录表
     * @param jsonParam 
     * @return
     */
    public void syncDicomRecord(String jsonParam);
    
    /**
     * 同步检查部位
     * 各个医院的PACS系统检查部位
     * @param jsonParam 
     * @return
     */
    public void syncExamPart(String jsonParam);
    
    /**
     * 同步检查结果表
     * 各个医院的PACS系统检查结果表
     * @param jsonParam 
     * @return
     */
    public void syncExamResult(String jsonParam);
    
    /**
     * 同步检查方式表
     * 各个医院的PACS系统检查方式表
     * @param jsonParam 
     * @return
     */
    public void syncExamWay(String jsonParam);
    
    /**
     * 同步影像科室表
     * 各个医院的PACS系统影像科室表
     * @param jsonParam 
     * @return
     */
    public void syncImageDept(String jsonParam);
    
    /**
     * 同步病人档案表
     * 各个医院的PACS系统病人档案表
     * @param jsonParam 
     * @return
     */
    public void syncPatientArchive(String jsonParam);
    
    /**
     * 同步病人图象表
     * 各个医院的PACS系统病人图象表
     * @param jsonParam 
     * @return
     */
    public void syncPatientDicom(TransferBody transferBody) throws Exception;
    
    /**
     * 同步病人检查表
     * 各个医院的PACS系统病人检查表
     * @param jsonParam 
     * @return
     */
    public void syncPatientExam(String jsonParam);
    
    /**
     * 同步病人来源类型
     * 各个医院的PACS系统病人来源类型
     * @param jsonParam 
     * @return
     */
    public void syncPatientFrom(String jsonParam);
     
}