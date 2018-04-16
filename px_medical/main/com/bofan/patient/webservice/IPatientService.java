package com.bofan.patient.webservice;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "patientService") // name属性标注在接口类上，可以指定wsdl中接口名称，也就是生成的客户端代码中接口类的名字。
@SOAPBinding(style = SOAPBinding.Style.RPC)  // 指定SOAP消息样式
public interface IPatientService {

	/**
	 * 建立患者档案
	 * @param jsonParams
	 * @return
	 */
	public String createPatientDetail(String jsonParams);
	
	/**
	 * 根据就诊卡号获取患者信息
	 * @param jsonParams
	 * @return
	 */
	public String getPatientDetail(String jsonParams);
	
	/**
	 * 创建门诊就诊信息
	 * @param jsonParams
	 * @return
	 */
	public String createPatientOutpatient(String jsonParams);
	
	/**
	 * 创建门诊处方（医嘱）信息
	 * @param jsonParams
	 * @return
	 */
	public String createOutpatientRecipe(String jsonParams);
	
	/**
	 * 创建患者住院就诊信息
	 * @param jsonParams
	 * @return
	 */
	public String createPatientInhospital(String jsonParams);
	
	/**
	 * 创建住院医嘱信息
	 * @param jsonParams
	 * @return
	 */
	public String createInhospitalDoctorAdvice(String jsonParams);
	
	/**
	 * 创建患者出院小结报告
	 * @param jsonParams
	 * @return
	 */
	public String createInhospitalDoctorReport(String jsonParams);

	/**
	 * @param fileUuid
	 * @param byteData
	 * @return bdb database path
	 */
	public String  putByteFile(String fileUuid,byte[] byteData);
	
	/**
     * 通过fileUuid获取文件字节数组
     * @param fileUuid
     * @return
     */
	byte[] getFileByte(String bdbSavePath, String fileUuid);

}
