package  com.bofan.publichealth.vaccine.command;
import java.lang.Long;
import java.util.Date;
import java.lang.String;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * @Description:  包含家庭居住条件和卫生设施编辑
 * @author wmg
 */
public class  VaccinationAbnormalEditInfo extends BaseCommandInfo {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

     /** 预防接种明细ID  对应预防接种明细表主键ID  vaccination_detail_id */
    private Long vaccinationDetailId;

    /** 反应时间 */
    private Date abnormalTime;

    /** 被接种人--儿童基本信息ID（与个人基本信息ID不能同时为空）  对应  child_detail（儿童基本信息表） 主键ID */
    private Long childDetailId;

    /** 临床诊断 */
    private String clinicDiagnose;

    /** 就诊机构 */
    private String clinicHospital;

    /** 就诊时间 */
    private Date clinicTime;

    /** 医疗机构ID  对应sys_org表的 主键ID */
    private Long hospitalId;

    /** 医疗机构名称 */
    private String hospitalName;

    /** 医院编码（医疗机构代码）  对应sys_org 表中的 org_no  */
    private String hospitalNo;

    /** 是否住院  1=是 0=否 */
    private String inHospitalFlag;

    /** 被接种人个人基本信息ID  对应  person_detail（个人基本信息表） 主键ID */
    private Long personDetailId;

    /** 接种医生 */
    private String reportDoctor;

    /** 接种医生ID */
    private Long reportDoctorId;

    /** 报告日期 */
    private Date reportTime;

    /** 被接种人--姓名（冗余字段） */
    private String vaccinatedName;

    /** 预防接种卡ID */
    private Long vaccinationCardId;

    /** 预防接种卡编号 */
    private String vaccinationCardNo;

    /** 疫苗批号 */
    private String vaccineBatch;

    /** 接种日期 */
    private Date vaccineDate;

    /** 疫苗ID */
    private Long vaccineId;

    /** 疫苗名称 */
    private String vaccineName;

    /** 接种部位 */
    private String vaccineSite;


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
     * @return abnormalTime(反应时间)
     */
    public Date getAbnormalTime() {
        return abnormalTime;
    }

    /**
     * @param abnormalTime 要设置的 abnormalTime(反应时间)
     */
    public void setAbnormalTime(Date abnormalTime) {
        this.abnormalTime = abnormalTime;
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
     * @return clinicTime(就诊时间)
     */
    public Date getClinicTime() {
        return clinicTime;
    }

    /**
     * @param clinicTime 要设置的 clinicTime(就诊时间)
     */
    public void setClinicTime(Date clinicTime) {
        this.clinicTime = clinicTime;
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
     * @return reportTime(报告日期)
     */
    public Date getReportTime() {
        return reportTime;
    }

    /**
     * @param reportTime 要设置的 reportTime(报告日期)
     */
    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
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
     * @return vaccineDate(接种日期)
     */
    public Date getVaccineDate() {
        return vaccineDate;
    }

    /**
     * @param vaccineDate 要设置的 vaccineDate(接种日期)
     */
    public void setVaccineDate(Date vaccineDate) {
        this.vaccineDate = vaccineDate;
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
