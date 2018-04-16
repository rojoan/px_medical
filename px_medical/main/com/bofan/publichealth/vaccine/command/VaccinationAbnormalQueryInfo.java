package com.bofan.publichealth.vaccine.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;
import java.lang.Long;
import java.util.Date;
import java.lang.String;

/**
 * @Description: 预防接种异常表查询对象
 * @author wmg
 */
@QueryInfo(
        from = "com.bofan.publichealth.vaccine.valueobject.VaccinationAbnormal vaccinationAbnormal ", 
        orderBy = "vaccinationAbnormal.vaccinationDetailId desc")
public class VaccinationAbnormalQueryInfo extends BaseCommandInfo {

    private static final long serialVersionUID = 1L;

    /** 预防接种明细ID */
    @QueryParam(fieldName = "vaccinationDetailId", op =QueryOperator.EQU)
    private Long  vaccinationDetailId ;

    /** 反应时间起始 */
    @QueryParam(fieldName = "abnormalTime", op = QueryOperator.GT_EQU)
    private Date abnormalTimeBegin ;

    /** 反应时间截止 */
    @QueryParam(fieldName = "abnormalTime", op = QueryOperator.LESS_EQU)
    private Date abnormalTimeEnd ;

    /** 被接种儿童基本信息ID */
    @QueryParam(fieldName = "childDetailId", op =QueryOperator.EQU)
    private Long  childDetailId ;

    /** 临床诊断 */
    @QueryParam(fieldName = "clinicDiagnose", op =QueryOperator.LIKE)
    private String  clinicDiagnose ;

    /** 就诊机构 */
    @QueryParam(fieldName = "clinicHospital", op =QueryOperator.LIKE)
    private String  clinicHospital ;

    /** 就诊时间起始 */
    @QueryParam(fieldName = "clinicTime", op = QueryOperator.GT_EQU)
    private Date clinicTimeBegin ;

    /** 就诊时间截止 */
    @QueryParam(fieldName = "clinicTime", op = QueryOperator.LESS_EQU)
    private Date clinicTimeEnd ;

    /** 医疗机构ID */
    @QueryParam(fieldName = "hospitalId", op =QueryOperator.EQU)
    private Long  hospitalId ;

    /** 医疗机构名称 */
    @QueryParam(fieldName = "hospitalName", op =QueryOperator.LIKE)
    private String  hospitalName ;

    /** 医疗机构代码 */
    @QueryParam(fieldName = "hospitalNo", op =QueryOperator.LIKE)
    private String  hospitalNo ;

    /** 是否住院 */
    @QueryParam(fieldName = "inHospitalFlag", op =QueryOperator.EQU)
    private String  inHospitalFlag ;

    /** 被接种人个人ID */
    @QueryParam(fieldName = "personDetailId", op =QueryOperator.EQU)
    private Long  personDetailId ;

    /** 接种医生 */
    @QueryParam(fieldName = "reportDoctor", op =QueryOperator.LIKE)
    private String  reportDoctor ;

    /** 接种医生ID */
    @QueryParam(fieldName = "reportDoctorId", op =QueryOperator.EQU)
    private Long  reportDoctorId ;

    /** 报告日期起始 */
    @QueryParam(fieldName = "reportTime", op = QueryOperator.GT_EQU)
    private Date reportTimeBegin ;

    /** 报告日期截止 */
    @QueryParam(fieldName = "reportTime", op = QueryOperator.LESS_EQU)
    private Date reportTimeEnd ;

    /** 被接种人姓名 */
    @QueryParam(fieldName = "vaccinatedName", op =QueryOperator.LIKE)
    private String  vaccinatedName ;

    /** 预防接种卡ID */
    @QueryParam(fieldName = "vaccinationCardId", op =QueryOperator.EQU)
    private Long  vaccinationCardId ;

    /** 预防接种卡编号 */
    @QueryParam(fieldName = "vaccinationCardNo", op =QueryOperator.LIKE)
    private String  vaccinationCardNo ;

    /** 疫苗批号 */
    @QueryParam(fieldName = "vaccineBatch", op =QueryOperator.LIKE)
    private String  vaccineBatch ;

    /** 接种日期起始 */
    @QueryParam(fieldName = "vaccineDate", op = QueryOperator.GT_EQU)
    private Date vaccineDateBegin ;

    /** 接种日期截止 */
    @QueryParam(fieldName = "vaccineDate", op = QueryOperator.LESS_EQU)
    private Date vaccineDateEnd ;

    /** 疫苗ID */
    @QueryParam(fieldName = "vaccineId", op =QueryOperator.EQU)
    private Long  vaccineId ;

    /** 疫苗名称 */
    @QueryParam(fieldName = "vaccineName", op =QueryOperator.LIKE)
    private String  vaccineName ;

    /** 接种部位 */
    @QueryParam(fieldName = "vaccineSite", op =QueryOperator.LIKE)
    private String  vaccineSite ;



    /**
     * @return vaccinationDetailId(预防接种明细ID)
     */
    public Long getVaccinationDetailId() {
        return vaccinationDetailId;
    }

    /**
     * @param vaccinationDetailId 要设置的 vaccinationDetailId(预防接种明细ID)
     */
    public void setVaccinationDetailId(Long vaccinationDetailId) {
        this.vaccinationDetailId = vaccinationDetailId;
    }

    /**
     * @return abnormalTimeBegin(反应时间)
     */
    public Date getAbnormalTimeBegin() {
        return abnormalTimeBegin;
    }

    /**
     * @param abnormalTimeBegin 要设置的 abnormalTimeBegin(反应时间)
     */
    public void setAbnormalTimeBegin(Date abnormalTimeBegin) {
        this.abnormalTimeBegin = abnormalTimeBegin;
    }


    /**
     * @return abnormalTimeEnd(反应时间)
     */
    public Date getAbnormalTimeEnd() {
        return abnormalTimeEnd;
    }

    /**
     * @param abnormalTimeEnd 要设置的 abnormalTimeEnd(反应时间)
     */
    public void setAbnormalTimeEnd(Date abnormalTimeEnd) {
        this.abnormalTimeEnd = abnormalTimeEnd;
    }

    /**
     * @return childDetailId(被接种儿童基本信息ID)
     */
    public Long getChildDetailId() {
        return childDetailId;
    }

    /**
     * @param childDetailId 要设置的 childDetailId(被接种儿童基本信息ID)
     */
    public void setChildDetailId(Long childDetailId) {
        this.childDetailId = childDetailId;
    }

    /**
     * @return clinicDiagnose(临床诊断)
     */
    public String getClinicDiagnose() {
        return clinicDiagnose;
    }

    /**
     * @param clinicDiagnose 要设置的 clinicDiagnose(临床诊断)
     */
    public void setClinicDiagnose(String clinicDiagnose) {
        this.clinicDiagnose = clinicDiagnose;
    }

    /**
     * @return clinicHospital(就诊机构)
     */
    public String getClinicHospital() {
        return clinicHospital;
    }

    /**
     * @param clinicHospital 要设置的 clinicHospital(就诊机构)
     */
    public void setClinicHospital(String clinicHospital) {
        this.clinicHospital = clinicHospital;
    }

    /**
     * @return clinicTimeBegin(就诊时间)
     */
    public Date getClinicTimeBegin() {
        return clinicTimeBegin;
    }

    /**
     * @param clinicTimeBegin 要设置的 clinicTimeBegin(就诊时间)
     */
    public void setClinicTimeBegin(Date clinicTimeBegin) {
        this.clinicTimeBegin = clinicTimeBegin;
    }


    /**
     * @return clinicTimeEnd(就诊时间)
     */
    public Date getClinicTimeEnd() {
        return clinicTimeEnd;
    }

    /**
     * @param clinicTimeEnd 要设置的 clinicTimeEnd(就诊时间)
     */
    public void setClinicTimeEnd(Date clinicTimeEnd) {
        this.clinicTimeEnd = clinicTimeEnd;
    }

    /**
     * @return hospitalId(医疗机构ID)
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId 要设置的 hospitalId(医疗机构ID)
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * @return hospitalName(医疗机构名称)
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * @param hospitalName 要设置的 hospitalName(医疗机构名称)
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * @return hospitalNo(医疗机构代码)
     */
    public String getHospitalNo() {
        return hospitalNo;
    }

    /**
     * @param hospitalNo 要设置的 hospitalNo(医疗机构代码)
     */
    public void setHospitalNo(String hospitalNo) {
        this.hospitalNo = hospitalNo;
    }

    /**
     * @return inHospitalFlag(是否住院)
     */
    public String getInHospitalFlag() {
        return inHospitalFlag;
    }

    /**
     * @param inHospitalFlag 要设置的 inHospitalFlag(是否住院)
     */
    public void setInHospitalFlag(String inHospitalFlag) {
        this.inHospitalFlag = inHospitalFlag;
    }

    /**
     * @return personDetailId(被接种人个人ID)
     */
    public Long getPersonDetailId() {
        return personDetailId;
    }

    /**
     * @param personDetailId 要设置的 personDetailId(被接种人个人ID)
     */
    public void setPersonDetailId(Long personDetailId) {
        this.personDetailId = personDetailId;
    }

    /**
     * @return reportDoctor(接种医生)
     */
    public String getReportDoctor() {
        return reportDoctor;
    }

    /**
     * @param reportDoctor 要设置的 reportDoctor(接种医生)
     */
    public void setReportDoctor(String reportDoctor) {
        this.reportDoctor = reportDoctor;
    }

    /**
     * @return reportDoctorId(接种医生ID)
     */
    public Long getReportDoctorId() {
        return reportDoctorId;
    }

    /**
     * @param reportDoctorId 要设置的 reportDoctorId(接种医生ID)
     */
    public void setReportDoctorId(Long reportDoctorId) {
        this.reportDoctorId = reportDoctorId;
    }

    /**
     * @return reportTimeBegin(报告日期)
     */
    public Date getReportTimeBegin() {
        return reportTimeBegin;
    }

    /**
     * @param reportTimeBegin 要设置的 reportTimeBegin(报告日期)
     */
    public void setReportTimeBegin(Date reportTimeBegin) {
        this.reportTimeBegin = reportTimeBegin;
    }


    /**
     * @return reportTimeEnd(报告日期)
     */
    public Date getReportTimeEnd() {
        return reportTimeEnd;
    }

    /**
     * @param reportTimeEnd 要设置的 reportTimeEnd(报告日期)
     */
    public void setReportTimeEnd(Date reportTimeEnd) {
        this.reportTimeEnd = reportTimeEnd;
    }

    /**
     * @return vaccinatedName(被接种人姓名)
     */
    public String getVaccinatedName() {
        return vaccinatedName;
    }

    /**
     * @param vaccinatedName 要设置的 vaccinatedName(被接种人姓名)
     */
    public void setVaccinatedName(String vaccinatedName) {
        this.vaccinatedName = vaccinatedName;
    }

    /**
     * @return vaccinationCardId(预防接种卡ID)
     */
    public Long getVaccinationCardId() {
        return vaccinationCardId;
    }

    /**
     * @param vaccinationCardId 要设置的 vaccinationCardId(预防接种卡ID)
     */
    public void setVaccinationCardId(Long vaccinationCardId) {
        this.vaccinationCardId = vaccinationCardId;
    }

    /**
     * @return vaccinationCardNo(预防接种卡编号)
     */
    public String getVaccinationCardNo() {
        return vaccinationCardNo;
    }

    /**
     * @param vaccinationCardNo 要设置的 vaccinationCardNo(预防接种卡编号)
     */
    public void setVaccinationCardNo(String vaccinationCardNo) {
        this.vaccinationCardNo = vaccinationCardNo;
    }

    /**
     * @return vaccineBatch(疫苗批号)
     */
    public String getVaccineBatch() {
        return vaccineBatch;
    }

    /**
     * @param vaccineBatch 要设置的 vaccineBatch(疫苗批号)
     */
    public void setVaccineBatch(String vaccineBatch) {
        this.vaccineBatch = vaccineBatch;
    }

    /**
     * @return vaccineDateBegin(接种日期)
     */
    public Date getVaccineDateBegin() {
        return vaccineDateBegin;
    }

    /**
     * @param vaccineDateBegin 要设置的 vaccineDateBegin(接种日期)
     */
    public void setVaccineDateBegin(Date vaccineDateBegin) {
        this.vaccineDateBegin = vaccineDateBegin;
    }


    /**
     * @return vaccineDateEnd(接种日期)
     */
    public Date getVaccineDateEnd() {
        return vaccineDateEnd;
    }

    /**
     * @param vaccineDateEnd 要设置的 vaccineDateEnd(接种日期)
     */
    public void setVaccineDateEnd(Date vaccineDateEnd) {
        this.vaccineDateEnd = vaccineDateEnd;
    }

    /**
     * @return vaccineId(疫苗ID)
     */
    public Long getVaccineId() {
        return vaccineId;
    }

    /**
     * @param vaccineId 要设置的 vaccineId(疫苗ID)
     */
    public void setVaccineId(Long vaccineId) {
        this.vaccineId = vaccineId;
    }

    /**
     * @return vaccineName(疫苗名称)
     */
    public String getVaccineName() {
        return vaccineName;
    }

    /**
     * @param vaccineName 要设置的 vaccineName(疫苗名称)
     */
    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    /**
     * @return vaccineSite(接种部位)
     */
    public String getVaccineSite() {
        return vaccineSite;
    }

    /**
     * @param vaccineSite 要设置的 vaccineSite(接种部位)
     */
    public void setVaccineSite(String vaccineSite) {
        this.vaccineSite = vaccineSite;
    }

}
