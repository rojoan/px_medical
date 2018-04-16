package  com.bofan.publichealth.vaccine.command;
import java.math.BigDecimal;
import java.lang.Long;
import java.util.Date;
import java.lang.String;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description:  包含家庭居住条件和卫生设施编辑
 * @author wmg
 */
public class  VaccinationDetailEditInfo extends BaseCommandInfo {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

     /** 预防接种明细ID */
    private Long vaccinationDetailId;

    /** 被接种人--儿童基本信息ID（与个人基本信息ID不能同时为空）  对应  child_detail（儿童基本信息表） 主键ID */
    private Long childDetailId;

    /** 有效日期 */
    private Date effectiveDate;

    /** 医疗机构ID  对应sys_org表的 主键ID */
    private Long hospitalId;

    /** 医疗机构名称 */
    private String hospitalName;

    /** 医院编码（医疗机构代码）  对应sys_org 表中的 org_no  */
    private String hospitalNo;

    /** 被接种人个人基本信息ID  对应  person_detail（个人基本信息表） 主键ID */
    private Long personDetailId;

    /** 生产企业 */
    private String productionEntp;

    /** 生产企业编码 */
    private BigDecimal productionEntpNo;

    /** 被接种人--姓名（冗余字段） */
    private String vaccinatedName;

    /** 预防接种卡编号 */
    private String vaccinationCardNo;

    /** 接种日期 */
    private Date vaccinationDate;

    /** 接种医生 */
    private String vaccinationDoctor;

    /** 接种医生ID */
    private Long vaccinationDoctorId;

    /** 疫苗批号 */
    private String vaccineBatch;

    /** 疫苗名称 */
    private String vaccineName;

    /** 疫苗编码，冗余字段 */
    private String vaccineNo;

    /** 接种部位 */
    private String vaccineSite;

    /** 预防接种卡ID */
    private Long vaccinationCardId;

    /** 疫苗ID */
    private Long vaccineId;


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
     * @return effectiveDate(有效日期)
     */
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * @param effectiveDate 要设置的 effectiveDate(有效日期)
     */
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
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
     * @return productionEntpNo(生产企业编码)
     */
    public BigDecimal getProductionEntpNo() {
        return productionEntpNo;
    }

    /**
     * @param productionEntpNo 要设置的 productionEntpNo(生产企业编码)
     */
    public void setProductionEntpNo(BigDecimal productionEntpNo) {
        this.productionEntpNo = productionEntpNo;
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
     * @return vaccinationDate(接种日期)
     */
    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    /**
     * @param vaccinationDate 要设置的 vaccinationDate(接种日期)
     */
    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
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
