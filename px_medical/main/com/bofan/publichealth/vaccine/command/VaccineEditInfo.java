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
public class  VaccineEditInfo extends BaseCommandInfo {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

     /** 疫苗ID */
    private Long vaccineId;

    /** 禁忌症 */
    private String contraindication;

    /** 建立时间 */
    private Date createTime;

    /** 操作人ID */
    private Long creatorId;

    /** 是否计划内  1=是 0=否 */
    private String planFlag;

    /** 可预防疾病 */
    private String preventDisease;

    /** 生产企业 */
    private String productEntp;

    /** 是否加强  1=是 0=否 */
    private String reinforceFlag;

    /** 可能出现的副反应 */
    private String sideEffect;

    /** 排序号 */
    private Long sort;

    /** 是否使用  1=使用 0=未使用 */
    private String useFlag;

    /** 疫苗简称 */
    private String vaccineCode;

    /** 疫苗简介 */
    private String vaccineContent;

    /** 接种剂次 */
    private String vaccineDose;

    /** 接种剂量/剂次 */
    private String vaccineDoseNum;

    /** 疫苗名称 */
    private String vaccineName;

    /** 疫苗编号 */
    private String vaccineNo;

    /** 接种对象 */
    private String vaccineObject;

    /** 接种部位 */
    private String vaccinePart;

    /** 疫苗价格 */
    private BigDecimal vaccinePrice;

    /** 疫苗产地 */
    private String vaccineProductArea;

    /** 备注 */
    private String vaccineRemark;

    /** 接种时间 */
    private String vaccineTime;

    /** 疫苗单位（支/粒）  1=支 2=粒 */
    private String vaccineUnit;

    /** 接种途径 */
    private String vaccineUse;


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
     * @return contraindication( 禁忌症)
     */
    public String getContraindication() {
        return contraindication;
    }

    /**
     * @param contraindication 要设置的 contraindication( 禁忌症)
     */
    public void setContraindication(String contraindication) {
        this.contraindication = contraindication;
    }

    /**
     * @return createTime(建立时间)
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 要设置的 createTime(建立时间)
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return creatorId(操作人ID)
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId 要设置的 creatorId(操作人ID)
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return planFlag(是否计划内)
     */
    public String getPlanFlag() {
        return planFlag;
    }

    /**
     * @param planFlag 要设置的 planFlag(是否计划内)
     */
    public void setPlanFlag(String planFlag) {
        this.planFlag = planFlag;
    }

    /**
     * @return preventDisease(可预防疾病)
     */
    public String getPreventDisease() {
        return preventDisease;
    }

    /**
     * @param preventDisease 要设置的 preventDisease(可预防疾病)
     */
    public void setPreventDisease(String preventDisease) {
        this.preventDisease = preventDisease;
    }

    /**
     * @return productEntp(生产企业)
     */
    public String getProductEntp() {
        return productEntp;
    }

    /**
     * @param productEntp 要设置的 productEntp(生产企业)
     */
    public void setProductEntp(String productEntp) {
        this.productEntp = productEntp;
    }

    /**
     * @return reinforceFlag(是否加强)
     */
    public String getReinforceFlag() {
        return reinforceFlag;
    }

    /**
     * @param reinforceFlag 要设置的 reinforceFlag(是否加强)
     */
    public void setReinforceFlag(String reinforceFlag) {
        this.reinforceFlag = reinforceFlag;
    }

    /**
     * @return sideEffect(可能出现的副反应)
     */
    public String getSideEffect() {
        return sideEffect;
    }

    /**
     * @param sideEffect 要设置的 sideEffect(可能出现的副反应)
     */
    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    /**
     * @return sort(排序号)
     */
    public Long getSort() {
        return sort;
    }

    /**
     * @param sort 要设置的 sort(排序号)
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * @return useFlag(是否使用)
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     * @param useFlag 要设置的 useFlag(是否使用)
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * @return vaccineCode(疫苗简称)
     */
    public String getVaccineCode() {
        return vaccineCode;
    }

    /**
     * @param vaccineCode 要设置的 vaccineCode(疫苗简称)
     */
    public void setVaccineCode(String vaccineCode) {
        this.vaccineCode = vaccineCode;
    }

    /**
     * @return vaccineContent(疫苗简介)
     */
    public String getVaccineContent() {
        return vaccineContent;
    }

    /**
     * @param vaccineContent 要设置的 vaccineContent(疫苗简介)
     */
    public void setVaccineContent(String vaccineContent) {
        this.vaccineContent = vaccineContent;
    }

    /**
     * @return vaccineDose(接种剂次)
     */
    public String getVaccineDose() {
        return vaccineDose;
    }

    /**
     * @param vaccineDose 要设置的 vaccineDose(接种剂次)
     */
    public void setVaccineDose(String vaccineDose) {
        this.vaccineDose = vaccineDose;
    }

    /**
     * @return vaccineDoseNum(接种剂量/剂次)
     */
    public String getVaccineDoseNum() {
        return vaccineDoseNum;
    }

    /**
     * @param vaccineDoseNum 要设置的 vaccineDoseNum(接种剂量/剂次)
     */
    public void setVaccineDoseNum(String vaccineDoseNum) {
        this.vaccineDoseNum = vaccineDoseNum;
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
     * @return vaccineNo(疫苗编号)
     */
    public String getVaccineNo() {
        return vaccineNo;
    }

    /**
     * @param vaccineNo 要设置的 vaccineNo(疫苗编号)
     */
    public void setVaccineNo(String vaccineNo) {
        this.vaccineNo = vaccineNo;
    }

    /**
     * @return vaccineObject(接种对象)
     */
    public String getVaccineObject() {
        return vaccineObject;
    }

    /**
     * @param vaccineObject 要设置的 vaccineObject(接种对象)
     */
    public void setVaccineObject(String vaccineObject) {
        this.vaccineObject = vaccineObject;
    }

    /**
     * @return vaccinePart(接种部位)
     */
    public String getVaccinePart() {
        return vaccinePart;
    }

    /**
     * @param vaccinePart 要设置的 vaccinePart(接种部位)
     */
    public void setVaccinePart(String vaccinePart) {
        this.vaccinePart = vaccinePart;
    }

    /**
     * @return vaccinePrice(疫苗价格)
     */
    public BigDecimal getVaccinePrice() {
        return vaccinePrice;
    }

    /**
     * @param vaccinePrice 要设置的 vaccinePrice(疫苗价格)
     */
    public void setVaccinePrice(BigDecimal vaccinePrice) {
        this.vaccinePrice = vaccinePrice;
    }

    /**
     * @return vaccineProductArea(疫苗产地)
     */
    public String getVaccineProductArea() {
        return vaccineProductArea;
    }

    /**
     * @param vaccineProductArea 要设置的 vaccineProductArea(疫苗产地)
     */
    public void setVaccineProductArea(String vaccineProductArea) {
        this.vaccineProductArea = vaccineProductArea;
    }

    /**
     * @return vaccineRemark(备注)
     */
    public String getVaccineRemark() {
        return vaccineRemark;
    }

    /**
     * @param vaccineRemark 要设置的 vaccineRemark(备注)
     */
    public void setVaccineRemark(String vaccineRemark) {
        this.vaccineRemark = vaccineRemark;
    }

    /**
     * @return vaccineTime(接种时间)
     */
    public String getVaccineTime() {
        return vaccineTime;
    }

    /**
     * @param vaccineTime 要设置的 vaccineTime(接种时间)
     */
    public void setVaccineTime(String vaccineTime) {
        this.vaccineTime = vaccineTime;
    }

    /**
     * @return vaccineUnit(疫苗单位（支/粒）)
     */
    public String getVaccineUnit() {
        return vaccineUnit;
    }

    /**
     * @param vaccineUnit 要设置的 vaccineUnit(疫苗单位（支/粒）)
     */
    public void setVaccineUnit(String vaccineUnit) {
        this.vaccineUnit = vaccineUnit;
    }

    /**
     * @return vaccineUse(接种途径)
     */
    public String getVaccineUse() {
        return vaccineUse;
    }

    /**
     * @param vaccineUse 要设置的 vaccineUse(接种途径)
     */
    public void setVaccineUse(String vaccineUse) {
        this.vaccineUse = vaccineUse;
    }

}
