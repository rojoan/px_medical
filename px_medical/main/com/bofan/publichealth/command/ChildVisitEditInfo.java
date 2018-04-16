package com.bofan.publichealth.command;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.publichealth.valueobject.ChildVisitSicken;

/**
 * 0-6岁儿童基本情况登记表，接收来自页面编辑参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
public class ChildVisitEditInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 2167347603346334073L;

    private Long childVisitId;
    
    private Long childDetailId;
    
    private String childName;
    
    private String gender;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date birthDate;
    
    private String fetationAge;
    
    private Long hospitalId;
    
    private String hospitalNo;
    
    private String hospitalName;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date visitDate;
    
    private String visitDoctorPhone;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date nextVisitTime;
    
    private String nextVisitAddr;
    
    private Double childBirthHeight;
    
    private Double childCurWeight;
    
    private Double childCurHeight;
    
    private Double childBirthWeight;
    
    private String feedFlag;
    
    private Long suckMl;
    
    private Long suckPer;
    
    private String emesisExam;
    
    private String shitExam;
    
    private String shitDescribe;
    
    private Long shitDayPer;
    
    private Double animalHeat;
    
    private String complexion;
    
    private String complexionOrther;
    
    private Long heartRate;
    
    private Long breatheRate;
    
    private String jaundiceParts;
    
    private String fontanelle;
    
    private Double fontanelleAcross;
    
    private Double fontanelleVertical;
    
    private String fontanelleOrther;
    
    private String eyeExam;
    
    private String eyeDescribe;
    
    private String armLeg;
    
    private String armLegDescribe;
    
    private String earExam;
    
    private String earDescribe;
    
    private String neckExam;
    
    private String neckDescribe;
    
    private String noseExam;
    
    private String noseDescribe;
    
    private String skinExam;
    
    private String skinDescribe;
    
    private String mouthExam;
    
    private String mouthDescribe;
    
    private String anusExam;
    
    private String anusDescribe;
    
    private String heartLungExam;
    
    private String heartLungDescribe;
    
    private String chestExam;
    
    private String chestDescribe;
    
    private String abdominalExam;
    
    private String abdominalDescribe;
    
    private String spineExam;
    
    private String spineDescribe;
    
    private String navelExam;
    
    private String navelDescribe;
    
    private String transTreatFlag;
    
    private String transTreatReason;
    
    private String transTreatOrg;
    
    private String ricketsSymptom;
    
    private String ricketsBody;
    
    private Long coxyphorase;
    
    private BigDecimal outdoorHour;
    
    private BigDecimal vdDay;
    
    private String bodyAssess;
    
    private String otherAdvise;
    
    private String ageStageFlag;
    
    private String bodyAssessFlag;
    
    private String otherSicken;
    
    /** 头围 */
    private Double headSize;
    
    /** 左眼视力 */
    private String leftEyesight;
    
    /** 右眼视力 */
    private String rightEyesight;
    
    /** 出牙颗数 */
    private Long toothNum;
    
    /** 龋齿数（颗） */
    private Long decayedToothNum;
    
    /** 听力：1=通过；0=未通过 */
    private String hearingExam;
    
    /** 体格发育评价：1=正常;2=低体重;3=消瘦;4=发育迟缓;5=超重 */
    private String growthAssess;
    
    /** 患病情况内容 */
    private Map<Long, ChildVisitSicken> visitSickenMap;
    
    /** 其他患病描述 */
    private String sickenContent;
    
    /** 随访指导ID */
    private Long[] visitAdivseIds;

    /**
     * @return the childVisitId
     */
    public Long getChildVisitId() {
        return childVisitId;
    }

    /**
     * @param childVisitId the childVisitId to set
     */
    public void setChildVisitId(Long childVisitId) {
        this.childVisitId = childVisitId;
    }

    /**
     * @return the childDetailId
     */
    public Long getChildDetailId() {
        return childDetailId;
    }

    /**
     * @param childDetailId the childDetailId to set
     */
    public void setChildDetailId(Long childDetailId) {
        this.childDetailId = childDetailId;
    }

    /**
     * @return the childName
     */
    public String getChildName() {
        return childName;
    }

    /**
     * @param childName the childName to set
     */
    public void setChildName(String childName) {
        this.childName = childName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the fetationAge
     */
    public String getFetationAge() {
        return fetationAge;
    }

    /**
     * @param fetationAge the fetationAge to set
     */
    public void setFetationAge(String fetationAge) {
        this.fetationAge = fetationAge;
    }

    /**
     * @return the hospitalId
     */
    public Long getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId the hospitalId to set
     */
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    /**
     * @return the hospitalNo
     */
    public String getHospitalNo() {
        return hospitalNo;
    }

    /**
     * @param hospitalNo the hospitalNo to set
     */
    public void setHospitalNo(String hospitalNo) {
        this.hospitalNo = hospitalNo;
    }

    /**
     * @return the hospitalName
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * @param hospitalName the hospitalName to set
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * @return the visitDate
     */
    public Date getVisitDate() {
        return visitDate;
    }

    /**
     * @param visitDate the visitDate to set
     */
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    /**
     * @return the visitDoctorPhone
     */
    public String getVisitDoctorPhone() {
        return visitDoctorPhone;
    }

    /**
     * @param visitDoctorPhone the visitDoctorPhone to set
     */
    public void setVisitDoctorPhone(String visitDoctorPhone) {
        this.visitDoctorPhone = visitDoctorPhone;
    }

    /**
     * @return the nextVisitTime
     */
    public Date getNextVisitTime() {
        return nextVisitTime;
    }

    /**
     * @param nextVisitTime the nextVisitTime to set
     */
    public void setNextVisitTime(Date nextVisitTime) {
        this.nextVisitTime = nextVisitTime;
    }

    /**
     * @return the nextVisitAddr
     */
    public String getNextVisitAddr() {
        return nextVisitAddr;
    }

    /**
     * @param nextVisitAddr the nextVisitAddr to set
     */
    public void setNextVisitAddr(String nextVisitAddr) {
        this.nextVisitAddr = nextVisitAddr;
    }

    /**
     * @return the childBirthHeight
     */
    public Double getChildBirthHeight() {
        return childBirthHeight;
    }

    /**
     * @param childBirthHeight the childBirthHeight to set
     */
    public void setChildBirthHeight(Double childBirthHeight) {
        this.childBirthHeight = childBirthHeight;
    }

    /**
     * @return the childCurWeight
     */
    public Double getChildCurWeight() {
        return childCurWeight;
    }

    /**
     * @param childCurWeight the childCurWeight to set
     */
    public void setChildCurWeight(Double childCurWeight) {
        this.childCurWeight = childCurWeight;
    }

    /**
     * @return the childCurHeight
     */
    public Double getChildCurHeight() {
        return childCurHeight;
    }

    /**
     * @param childCurHeight the childCurHeight to set
     */
    public void setChildCurHeight(Double childCurHeight) {
        this.childCurHeight = childCurHeight;
    }

    /**
     * @return the childBirthWeight
     */
    public Double getChildBirthWeight() {
        return childBirthWeight;
    }

    /**
     * @param childBirthWeight the childBirthWeight to set
     */
    public void setChildBirthWeight(Double childBirthWeight) {
        this.childBirthWeight = childBirthWeight;
    }

    /**
     * @return the feedFlag
     */
    public String getFeedFlag() {
        return feedFlag;
    }

    /**
     * @param feedFlag the feedFlag to set
     */
    public void setFeedFlag(String feedFlag) {
        this.feedFlag = feedFlag;
    }

    /**
     * @return the suckMl
     */
    public Long getSuckMl() {
        return suckMl;
    }

    /**
     * @param suckMl the suckMl to set
     */
    public void setSuckMl(Long suckMl) {
        this.suckMl = suckMl;
    }

    /**
     * @return the suckPer
     */
    public Long getSuckPer() {
        return suckPer;
    }

    /**
     * @param suckPer the suckPer to set
     */
    public void setSuckPer(Long suckPer) {
        this.suckPer = suckPer;
    }

    /**
     * @return the emesisExam
     */
    public String getEmesisExam() {
        return emesisExam;
    }

    /**
     * @param emesisExam the emesisExam to set
     */
    public void setEmesisExam(String emesisExam) {
        this.emesisExam = emesisExam;
    }

    /**
     * @return the shitExam
     */
    public String getShitExam() {
        return shitExam;
    }

    /**
     * @param shitExam the shitExam to set
     */
    public void setShitExam(String shitExam) {
        this.shitExam = shitExam;
    }

    /**
     * @return the shitDescribe
     */
    public String getShitDescribe() {
        return shitDescribe;
    }

    /**
     * @param shitDescribe the shitDescribe to set
     */
    public void setShitDescribe(String shitDescribe) {
        this.shitDescribe = shitDescribe;
    }

    /**
     * @return the shitDayPer
     */
    public Long getShitDayPer() {
        return shitDayPer;
    }

    /**
     * @param shitDayPer the shitDayPer to set
     */
    public void setShitDayPer(Long shitDayPer) {
        this.shitDayPer = shitDayPer;
    }

    /**
     * @return the animalHeat
     */
    public Double getAnimalHeat() {
        return animalHeat;
    }

    /**
     * @param animalHeat the animalHeat to set
     */
    public void setAnimalHeat(Double animalHeat) {
        this.animalHeat = animalHeat;
    }

    /**
     * @return the complexion
     */
    public String getComplexion() {
        return complexion;
    }

    /**
     * @param complexion the complexion to set
     */
    public void setComplexion(String complexion) {
        this.complexion = complexion;
    }

    /**
     * @return the complexionOrther
     */
    public String getComplexionOrther() {
        return complexionOrther;
    }

    /**
     * @param complexionOrther the complexionOrther to set
     */
    public void setComplexionOrther(String complexionOrther) {
        this.complexionOrther = complexionOrther;
    }

    /**
     * @return the heartRate
     */
    public Long getHeartRate() {
        return heartRate;
    }

    /**
     * @param heartRate the heartRate to set
     */
    public void setHeartRate(Long heartRate) {
        this.heartRate = heartRate;
    }

    /**
     * @return the breatheRate
     */
    public Long getBreatheRate() {
        return breatheRate;
    }

    /**
     * @param breatheRate the breatheRate to set
     */
    public void setBreatheRate(Long breatheRate) {
        this.breatheRate = breatheRate;
    }

    /**
     * @return the jaundiceParts
     */
    public String getJaundiceParts() {
        return jaundiceParts;
    }

    /**
     * @param jaundiceParts the jaundiceParts to set
     */
    public void setJaundiceParts(String jaundiceParts) {
        this.jaundiceParts = jaundiceParts;
    }

    /**
     * @return the fontanelle
     */
    public String getFontanelle() {
        return fontanelle;
    }

    /**
     * @param fontanelle the fontanelle to set
     */
    public void setFontanelle(String fontanelle) {
        this.fontanelle = fontanelle;
    }

    /**
     * @return the fontanelleAcross
     */
    public Double getFontanelleAcross() {
        return fontanelleAcross;
    }

    /**
     * @param fontanelleAcross the fontanelleAcross to set
     */
    public void setFontanelleAcross(Double fontanelleAcross) {
        this.fontanelleAcross = fontanelleAcross;
    }

    /**
     * @return the fontanelleVertical
     */
    public Double getFontanelleVertical() {
        return fontanelleVertical;
    }

    /**
     * @param fontanelleVertical the fontanelleVertical to set
     */
    public void setFontanelleVertical(Double fontanelleVertical) {
        this.fontanelleVertical = fontanelleVertical;
    }

    /**
     * @return the fontanelleOrther
     */
    public String getFontanelleOrther() {
        return fontanelleOrther;
    }

    /**
     * @param fontanelleOrther the fontanelleOrther to set
     */
    public void setFontanelleOrther(String fontanelleOrther) {
        this.fontanelleOrther = fontanelleOrther;
    }

    /**
     * @return the eyeExam
     */
    public String getEyeExam() {
        return eyeExam;
    }

    /**
     * @param eyeExam the eyeExam to set
     */
    public void setEyeExam(String eyeExam) {
        this.eyeExam = eyeExam;
    }

    /**
     * @return the eyeDescribe
     */
    public String getEyeDescribe() {
        return eyeDescribe;
    }

    /**
     * @param eyeDescribe the eyeDescribe to set
     */
    public void setEyeDescribe(String eyeDescribe) {
        this.eyeDescribe = eyeDescribe;
    }

    /**
     * @return the armLeg
     */
    public String getArmLeg() {
        return armLeg;
    }

    /**
     * @param armLeg the armLeg to set
     */
    public void setArmLeg(String armLeg) {
        this.armLeg = armLeg;
    }

    /**
     * @return the armLegDescribe
     */
    public String getArmLegDescribe() {
        return armLegDescribe;
    }

    /**
     * @param armLegDescribe the armLegDescribe to set
     */
    public void setArmLegDescribe(String armLegDescribe) {
        this.armLegDescribe = armLegDescribe;
    }

    /**
     * @return the earExam
     */
    public String getEarExam() {
        return earExam;
    }

    /**
     * @param earExam the earExam to set
     */
    public void setEarExam(String earExam) {
        this.earExam = earExam;
    }

    /**
     * @return the earDescribe
     */
    public String getEarDescribe() {
        return earDescribe;
    }

    /**
     * @param earDescribe the earDescribe to set
     */
    public void setEarDescribe(String earDescribe) {
        this.earDescribe = earDescribe;
    }

    /**
     * @return the neckExam
     */
    public String getNeckExam() {
        return neckExam;
    }

    /**
     * @param neckExam the neckExam to set
     */
    public void setNeckExam(String neckExam) {
        this.neckExam = neckExam;
    }

    /**
     * @return the neckDescribe
     */
    public String getNeckDescribe() {
        return neckDescribe;
    }

    /**
     * @param neckDescribe the neckDescribe to set
     */
    public void setNeckDescribe(String neckDescribe) {
        this.neckDescribe = neckDescribe;
    }

    /**
     * @return the noseExam
     */
    public String getNoseExam() {
        return noseExam;
    }

    /**
     * @param noseExam the noseExam to set
     */
    public void setNoseExam(String noseExam) {
        this.noseExam = noseExam;
    }

    /**
     * @return the noseDescribe
     */
    public String getNoseDescribe() {
        return noseDescribe;
    }

    /**
     * @param noseDescribe the noseDescribe to set
     */
    public void setNoseDescribe(String noseDescribe) {
        this.noseDescribe = noseDescribe;
    }

    /**
     * @return the skinExam
     */
    public String getSkinExam() {
        return skinExam;
    }

    /**
     * @param skinExam the skinExam to set
     */
    public void setSkinExam(String skinExam) {
        this.skinExam = skinExam;
    }

    /**
     * @return the skinDescribe
     */
    public String getSkinDescribe() {
        return skinDescribe;
    }

    /**
     * @param skinDescribe the skinDescribe to set
     */
    public void setSkinDescribe(String skinDescribe) {
        this.skinDescribe = skinDescribe;
    }

    /**
     * @return the mouthExam
     */
    public String getMouthExam() {
        return mouthExam;
    }

    /**
     * @param mouthExam the mouthExam to set
     */
    public void setMouthExam(String mouthExam) {
        this.mouthExam = mouthExam;
    }

    /**
     * @return the mouthDescribe
     */
    public String getMouthDescribe() {
        return mouthDescribe;
    }

    /**
     * @param mouthDescribe the mouthDescribe to set
     */
    public void setMouthDescribe(String mouthDescribe) {
        this.mouthDescribe = mouthDescribe;
    }

    /**
     * @return the anusExam
     */
    public String getAnusExam() {
        return anusExam;
    }

    /**
     * @param anusExam the anusExam to set
     */
    public void setAnusExam(String anusExam) {
        this.anusExam = anusExam;
    }

    /**
     * @return the anusDescribe
     */
    public String getAnusDescribe() {
        return anusDescribe;
    }

    /**
     * @param anusDescribe the anusDescribe to set
     */
    public void setAnusDescribe(String anusDescribe) {
        this.anusDescribe = anusDescribe;
    }

    /**
     * @return the heartLungExam
     */
    public String getHeartLungExam() {
        return heartLungExam;
    }

    /**
     * @param heartLungExam the heartLungExam to set
     */
    public void setHeartLungExam(String heartLungExam) {
        this.heartLungExam = heartLungExam;
    }

    /**
     * @return the heartLungDescribe
     */
    public String getHeartLungDescribe() {
        return heartLungDescribe;
    }

    /**
     * @param heartLungDescribe the heartLungDescribe to set
     */
    public void setHeartLungDescribe(String heartLungDescribe) {
        this.heartLungDescribe = heartLungDescribe;
    }

    /**
     * @return the chestExam
     */
    public String getChestExam() {
        return chestExam;
    }

    /**
     * @param chestExam the chestExam to set
     */
    public void setChestExam(String chestExam) {
        this.chestExam = chestExam;
    }

    /**
     * @return the chestDescribe
     */
    public String getChestDescribe() {
        return chestDescribe;
    }

    /**
     * @param chestDescribe the chestDescribe to set
     */
    public void setChestDescribe(String chestDescribe) {
        this.chestDescribe = chestDescribe;
    }

    /**
     * @return the abdominalExam
     */
    public String getAbdominalExam() {
        return abdominalExam;
    }

    /**
     * @param abdominalExam the abdominalExam to set
     */
    public void setAbdominalExam(String abdominalExam) {
        this.abdominalExam = abdominalExam;
    }

    /**
     * @return the abdominalDescribe
     */
    public String getAbdominalDescribe() {
        return abdominalDescribe;
    }

    /**
     * @param abdominalDescribe the abdominalDescribe to set
     */
    public void setAbdominalDescribe(String abdominalDescribe) {
        this.abdominalDescribe = abdominalDescribe;
    }

    /**
     * @return the spineExam
     */
    public String getSpineExam() {
        return spineExam;
    }

    /**
     * @param spineExam the spineExam to set
     */
    public void setSpineExam(String spineExam) {
        this.spineExam = spineExam;
    }

    /**
     * @return the spineDescribe
     */
    public String getSpineDescribe() {
        return spineDescribe;
    }

    /**
     * @param spineDescribe the spineDescribe to set
     */
    public void setSpineDescribe(String spineDescribe) {
        this.spineDescribe = spineDescribe;
    }

    /**
     * @return the navelExam
     */
    public String getNavelExam() {
        return navelExam;
    }

    /**
     * @param navelExam the navelExam to set
     */
    public void setNavelExam(String navelExam) {
        this.navelExam = navelExam;
    }

    /**
     * @return the navelDescribe
     */
    public String getNavelDescribe() {
        return navelDescribe;
    }

    /**
     * @param navelDescribe the navelDescribe to set
     */
    public void setNavelDescribe(String navelDescribe) {
        this.navelDescribe = navelDescribe;
    }

    /**
     * @return the transTreatFlag
     */
    public String getTransTreatFlag() {
        return transTreatFlag;
    }

    /**
     * @param transTreatFlag the transTreatFlag to set
     */
    public void setTransTreatFlag(String transTreatFlag) {
        this.transTreatFlag = transTreatFlag;
    }

    /**
     * @return the transTreatReason
     */
    public String getTransTreatReason() {
        return transTreatReason;
    }

    /**
     * @param transTreatReason the transTreatReason to set
     */
    public void setTransTreatReason(String transTreatReason) {
        this.transTreatReason = transTreatReason;
    }

    /**
     * @return the transTreatOrg
     */
    public String getTransTreatOrg() {
        return transTreatOrg;
    }

    /**
     * @param transTreatOrg the transTreatOrg to set
     */
    public void setTransTreatOrg(String transTreatOrg) {
        this.transTreatOrg = transTreatOrg;
    }

    /**
     * @return the ricketsSymptom
     */
    public String getRicketsSymptom() {
        return ricketsSymptom;
    }

    /**
     * @param ricketsSymptom the ricketsSymptom to set
     */
    public void setRicketsSymptom(String ricketsSymptom) {
        this.ricketsSymptom = ricketsSymptom;
    }

    /**
     * @return the ricketsBody
     */
    public String getRicketsBody() {
        return ricketsBody;
    }

    /**
     * @param ricketsBody the ricketsBody to set
     */
    public void setRicketsBody(String ricketsBody) {
        this.ricketsBody = ricketsBody;
    }

    /**
     * @return the coxyphorase
     */
    public Long getCoxyphorase() {
        return coxyphorase;
    }

    /**
     * @param coxyphorase the coxyphorase to set
     */
    public void setCoxyphorase(Long coxyphorase) {
        this.coxyphorase = coxyphorase;
    }

    /**
     * @return the outdoorHour
     */
    public BigDecimal getOutdoorHour() {
        return outdoorHour;
    }

    /**
     * @param outdoorHour the outdoorHour to set
     */
    public void setOutdoorHour(BigDecimal outdoorHour) {
        this.outdoorHour = outdoorHour;
    }

    /**
     * @return the vdDay
     */
    public BigDecimal getVdDay() {
        return vdDay;
    }

    /**
     * @param vdDay the vdDay to set
     */
    public void setVdDay(BigDecimal vdDay) {
        this.vdDay = vdDay;
    }

    /**
     * @return the bodyAssess
     */
    public String getBodyAssess() {
        return bodyAssess;
    }

    /**
     * @param bodyAssess the bodyAssess to set
     */
    public void setBodyAssess(String bodyAssess) {
        this.bodyAssess = bodyAssess;
    }

    /**
     * @return the otherAdvise
     */
    public String getOtherAdvise() {
        return otherAdvise;
    }

    /**
     * @param otherAdvise the otherAdvise to set
     */
    public void setOtherAdvise(String otherAdvise) {
        this.otherAdvise = otherAdvise;
    }

    /**
     * @return the visitSickenMap
     */
    public Map<Long, ChildVisitSicken> getVisitSickenMap() {
        return visitSickenMap;
    }

    /**
     * @param visitSickenMap the visitSickenMap to set
     */
    public void setVisitSickenMap(Map<Long, ChildVisitSicken> visitSickenMap) {
        this.visitSickenMap = visitSickenMap;
    }

    /**
     * @return the sickenContent
     */
    public String getSickenContent() {
        return sickenContent;
    }

    /**
     * @param sickenContent the sickenContent to set
     */
    public void setSickenContent(String sickenContent) {
        this.sickenContent = sickenContent;
    }

    /**
     * @return the visitAdivseIds
     */
    public Long[] getVisitAdivseIds() {
        return visitAdivseIds;
    }

    /**
     * @param visitAdivseIds the visitAdivseIds to set
     */
    public void setVisitAdivseIds(Long[] visitAdivseIds) {
        this.visitAdivseIds = visitAdivseIds;
    }

    /**
     * @return the ageStageFlag
     */
    public String getAgeStageFlag() {
        return ageStageFlag;
    }

    /**
     * @param ageStageFlag the ageStageFlag to set
     */
    public void setAgeStageFlag(String ageStageFlag) {
        this.ageStageFlag = ageStageFlag;
    }

    /**
     * @return the bodyAssessFlag
     */
    public String getBodyAssessFlag() {
        return bodyAssessFlag;
    }

    /**
     * @param bodyAssessFlag the bodyAssessFlag to set
     */
    public void setBodyAssessFlag(String bodyAssessFlag) {
        this.bodyAssessFlag = bodyAssessFlag;
    }

    /**
     * @return the otherSicken
     */
    public String getOtherSicken() {
        return otherSicken;
    }

    /**
     * @param otherSicken the otherSicken to set
     */
    public void setOtherSicken(String otherSicken) {
        this.otherSicken = otherSicken;
    }

    /**
     * @return the headSize
     */
    public Double getHeadSize() {
        return headSize;
    }

    /**
     * @param headSize the headSize to set
     */
    public void setHeadSize(Double headSize) {
        this.headSize = headSize;
    }

    /**
     * @return the leftEyesight
     */
    public String getLeftEyesight() {
        return leftEyesight;
    }

    /**
     * @param leftEyesight the leftEyesight to set
     */
    public void setLeftEyesight(String leftEyesight) {
        this.leftEyesight = leftEyesight;
    }

    /**
     * @return the rightEyesight
     */
    public String getRightEyesight() {
        return rightEyesight;
    }

    /**
     * @param rightEyesight the rightEyesight to set
     */
    public void setRightEyesight(String rightEyesight) {
        this.rightEyesight = rightEyesight;
    }

    /**
     * @return the toothNum
     */
    public Long getToothNum() {
        return toothNum;
    }

    /**
     * @param toothNum the toothNum to set
     */
    public void setToothNum(Long toothNum) {
        this.toothNum = toothNum;
    }

    /**
     * @return the decayedToothNum
     */
    public Long getDecayedToothNum() {
        return decayedToothNum;
    }

    /**
     * @param decayedToothNum the decayedToothNum to set
     */
    public void setDecayedToothNum(Long decayedToothNum) {
        this.decayedToothNum = decayedToothNum;
    }

    /**
     * @return the hearingExam
     */
    public String getHearingExam() {
        return hearingExam;
    }

    /**
     * @param hearingExam the hearingExam to set
     */
    public void setHearingExam(String hearingExam) {
        this.hearingExam = hearingExam;
    }

    /**
     * @return the growthAssess
     */
    public String getGrowthAssess() {
        return growthAssess;
    }

    /**
     * @param growthAssess the growthAssess to set
     */
    public void setGrowthAssess(String growthAssess) {
        this.growthAssess = growthAssess;
    }

}
