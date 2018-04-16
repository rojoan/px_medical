package com.bofan.publichealth.vaccine.command;

import java.util.Date;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 预防接种明细查询对象
 * @author wmg
 */
@QueryInfo(
        from = "com.bofan.publichealth.vaccine.valueobject.VaccinationDetail vaccinationDetail ", 
        orderBy = "vaccinationDetail.vaccinationDetailId desc")
public class VaccinationDetailQueryInfo extends BaseCommandInfo {

    private static final long serialVersionUID = 1L;

    /** 预防接种明细ID */
    @QueryParam(fieldName = "vaccinationDetailId", op =QueryOperator.EQU)
    private Long  vaccinationDetailId ;

    /** 被接种儿童基本信息ID */
    @QueryParam(fieldName = "childDetailId", op =QueryOperator.EQU)
    private Long  childDetailId ;

    /** 有效日期起始 */
    @QueryParam(fieldName = "effectiveDate", op = QueryOperator.GT_EQU)
    private Date effectiveDateBegin ;

    /** 有效日期截止 */
    @QueryParam(fieldName = "effectiveDate", op = QueryOperator.LESS_EQU)
    private Date effectiveDateEnd ;

    /** 医疗机构ID */
    @QueryParam(fieldName = "hospitalId", op =QueryOperator.EQU)
    private Long  hospitalId ;

    /** 医疗机构名称 */
    @QueryParam(fieldName = "hospitalName", op =QueryOperator.LIKE)
    private String  hospitalName ;

    /** 医疗机构代码 */
    @QueryParam(fieldName = "hospitalNo", op =QueryOperator.LIKE)
    private String  hospitalNo ;

    /** 被接种人个人ID */
    @QueryParam(fieldName = "personDetailId", op =QueryOperator.EQU)
    private Long  personDetailId ;

    /** 生产企业 */
    @QueryParam(fieldName = "productionEntp", op =QueryOperator.LIKE)
    private String  productionEntp ;

    /** 被接种人姓名 */
    @QueryParam(fieldName = "vaccinatedName", op =QueryOperator.LIKE)
    private String  vaccinatedName ;

    /** 预防接种卡编号 */
    @QueryParam(fieldName = "vaccinationCardNo", op =QueryOperator.LIKE)
    private String  vaccinationCardNo ;

    /** 接种日期起始 */
    @QueryParam(fieldName = "vaccinationDate", op = QueryOperator.GT_EQU)
    private Date vaccinationDateBegin ;

    /** 接种日期截止 */
    @QueryParam(fieldName = "vaccinationDate", op = QueryOperator.LESS_EQU)
    private Date vaccinationDateEnd ;

    /** 接种医生 */
    @QueryParam(fieldName = "vaccinationDoctor", op =QueryOperator.LIKE)
    private String  vaccinationDoctor ;

    /** 接种医生ID */
    @QueryParam(fieldName = "vaccinationDoctorId", op =QueryOperator.EQU)
    private Long  vaccinationDoctorId ;

    /** 疫苗批号 */
    @QueryParam(fieldName = "vaccineBatch", op =QueryOperator.LIKE)
    private String  vaccineBatch ;

    /** 疫苗名称 */
    @QueryParam(fieldName = "vaccineName", op =QueryOperator.LIKE)
    private String  vaccineName ;

    /** 疫苗编码，冗余字段 */
    @QueryParam(fieldName = "vaccineNo", op =QueryOperator.LIKE)
    private String  vaccineNo ;

    /** 接种部位 */
    @QueryParam(fieldName = "vaccineSite", op =QueryOperator.LIKE)
    private String  vaccineSite ;

    /** 预防接种卡ID */
    @QueryParam(fieldName = "vaccinationCardId", op =QueryOperator.EQU)
    private Long  vaccinationCardId ;

    /** 疫苗ID */
    @QueryParam(fieldName = "vaccineId", op =QueryOperator.EQU)
    private Long  vaccineId ;



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
     * @return effectiveDateBegin(有效日期)
     */
    public Date getEffectiveDateBegin() {
        return effectiveDateBegin;
    }

    /**
     * @param effectiveDateBegin 要设置的 effectiveDateBegin(有效日期)
     */
    public void setEffectiveDateBegin(Date effectiveDateBegin) {
        this.effectiveDateBegin = effectiveDateBegin;
    }


    /**
     * @return effectiveDateEnd(有效日期)
     */
    public Date getEffectiveDateEnd() {
        return effectiveDateEnd;
    }

    /**
     * @param effectiveDateEnd 要设置的 effectiveDateEnd(有效日期)
     */
    public void setEffectiveDateEnd(Date effectiveDateEnd) {
        this.effectiveDateEnd = effectiveDateEnd;
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
     * @return productionEntp(生产企业)
     */
    public String getProductionEntp() {
        return productionEntp;
    }

    /**
     * @param productionEntp 要设置的 productionEntp(生产企业)
     */
    public void setProductionEntp(String productionEntp) {
        this.productionEntp = productionEntp;
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
     * @return vaccinationDateBegin(接种日期)
     */
    public Date getVaccinationDateBegin() {
        return vaccinationDateBegin;
    }

    /**
     * @param vaccinationDateBegin 要设置的 vaccinationDateBegin(接种日期)
     */
    public void setVaccinationDateBegin(Date vaccinationDateBegin) {
        this.vaccinationDateBegin = vaccinationDateBegin;
    }


    /**
     * @return vaccinationDateEnd(接种日期)
     */
    public Date getVaccinationDateEnd() {
        return vaccinationDateEnd;
    }

    /**
     * @param vaccinationDateEnd 要设置的 vaccinationDateEnd(接种日期)
     */
    public void setVaccinationDateEnd(Date vaccinationDateEnd) {
        this.vaccinationDateEnd = vaccinationDateEnd;
    }

    /**
     * @return vaccinationDoctor(接种医生)
     */
    public String getVaccinationDoctor() {
        return vaccinationDoctor;
    }

    /**
     * @param vaccinationDoctor 要设置的 vaccinationDoctor(接种医生)
     */
    public void setVaccinationDoctor(String vaccinationDoctor) {
        this.vaccinationDoctor = vaccinationDoctor;
    }

    /**
     * @return vaccinationDoctorId(接种医生ID)
     */
    public Long getVaccinationDoctorId() {
        return vaccinationDoctorId;
    }

    /**
     * @param vaccinationDoctorId 要设置的 vaccinationDoctorId(接种医生ID)
     */
    public void setVaccinationDoctorId(Long vaccinationDoctorId) {
        this.vaccinationDoctorId = vaccinationDoctorId;
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
     * @return vaccineNo(疫苗编码，冗余字段)
     */
    public String getVaccineNo() {
        return vaccineNo;
    }

    /**
     * @param vaccineNo 要设置的 vaccineNo(疫苗编码，冗余字段)
     */
    public void setVaccineNo(String vaccineNo) {
        this.vaccineNo = vaccineNo;
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

}
