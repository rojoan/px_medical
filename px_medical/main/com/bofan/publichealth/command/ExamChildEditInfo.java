package com.bofan.publichealth.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bofan.basesystem.common.command.BaseCommandInfo;

/**
 * 儿童体检(检查)编辑参数
 * @Description 
 * @author xlf
 * 2017-10-26
 */
public class ExamChildEditInfo extends BaseCommandInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 4756934410201828280L;
    
    private Long examChildId;
    
    private Long childDetailId;
    
    private String childName;
    
    private String gender;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date examTime;
    
    private String examBillNo;
    
    private String feedFlag;
    
    private String assistedFoodFlag;
    
    private String vdCalcium;
    
    private Double childHeight;
    
    private String childHeightAssess;
    
    private Double childWeight;
    
    private String childWeightAssess;
    
    private Double bustLine;
    
    private Double headSize;
    
    private String fontanelleClosed;
    
    private Double fontanelleAcross;
    
    private Double fontanelleVertical;
    
    private String heartAus;
    
    private String suplExam;
    
    private String lungAus;
    
    private String limbsExam;
    
    private String liverAus;
    
    private String spineExam;
    
    private String spleenAus;
    
    private String abdominalExam;
    
    private String skinExam;
    
    private String repOrganExam;
    
    private String symptom;
    
    private String sign;
    
    private String ricket;
    
    private String trachomaFlag;
    
    private String leftEyesight;
    
    private String rightEyesight;
    
    private String leftHearExam;
    
    private String leftHearingDetection;
    
    private String rightHearExam;
    
    private String rightHearingDetection;
    
    private String noseExam;
    
    private String pharyngealExam;
    
    private String tonsilExam;
    
    private Long teethingMonth;
    
    private Long toothNum;
    
    private Long decayedToothNum;
    
    private String growthAssess;
    
    private String sickenCondition;
    
    private String sickenOrtherCondition;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date nextExamTime;

    /**
     * @return the examChildId
     */
    public Long getExamChildId() {
        return examChildId;
    }

    /**
     * @param examChildId the examChildId to set
     */
    public void setExamChildId(Long examChildId) {
        this.examChildId = examChildId;
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
     * @return the examTime
     */
    public Date getExamTime() {
        return examTime;
    }

    /**
     * @param examTime the examTime to set
     */
    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    /**
     * @return the examBillNo
     */
    public String getExamBillNo() {
        return examBillNo;
    }

    /**
     * @param examBillNo the examBillNo to set
     */
    public void setExamBillNo(String examBillNo) {
        this.examBillNo = examBillNo;
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
     * @return the assistedFoodFlag
     */
    public String getAssistedFoodFlag() {
        return assistedFoodFlag;
    }

    /**
     * @param assistedFoodFlag the assistedFoodFlag to set
     */
    public void setAssistedFoodFlag(String assistedFoodFlag) {
        this.assistedFoodFlag = assistedFoodFlag;
    }

    /**
     * @return the vdCalcium
     */
    public String getVdCalcium() {
        return vdCalcium;
    }

    /**
     * @param vdCalcium the vdCalcium to set
     */
    public void setVdCalcium(String vdCalcium) {
        this.vdCalcium = vdCalcium;
    }

    /**
     * @return the childHeight
     */
    public Double getChildHeight() {
        return childHeight;
    }

    /**
     * @param childHeight the childHeight to set
     */
    public void setChildHeight(Double childHeight) {
        this.childHeight = childHeight;
    }

    /**
     * @return the childHeightAssess
     */
    public String getChildHeightAssess() {
        return childHeightAssess;
    }

    /**
     * @param childHeightAssess the childHeightAssess to set
     */
    public void setChildHeightAssess(String childHeightAssess) {
        this.childHeightAssess = childHeightAssess;
    }

    /**
     * @return the childWeight
     */
    public Double getChildWeight() {
        return childWeight;
    }

    /**
     * @param childWeight the childWeight to set
     */
    public void setChildWeight(Double childWeight) {
        this.childWeight = childWeight;
    }

    /**
     * @return the childWeightAssess
     */
    public String getChildWeightAssess() {
        return childWeightAssess;
    }

    /**
     * @param childWeightAssess the childWeightAssess to set
     */
    public void setChildWeightAssess(String childWeightAssess) {
        this.childWeightAssess = childWeightAssess;
    }

    /**
     * @return the bustLine
     */
    public Double getBustLine() {
        return bustLine;
    }

    /**
     * @param bustLine the bustLine to set
     */
    public void setBustLine(Double bustLine) {
        this.bustLine = bustLine;
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
     * @return the fontanelleClosed
     */
    public String getFontanelleClosed() {
        return fontanelleClosed;
    }

    /**
     * @param fontanelleClosed the fontanelleClosed to set
     */
    public void setFontanelleClosed(String fontanelleClosed) {
        this.fontanelleClosed = fontanelleClosed;
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
     * @return the heartAus
     */
    public String getHeartAus() {
        return heartAus;
    }

    /**
     * @param heartAus the heartAus to set
     */
    public void setHeartAus(String heartAus) {
        this.heartAus = heartAus;
    }

    /**
     * @return the suplExam
     */
    public String getSuplExam() {
        return suplExam;
    }

    /**
     * @param suplExam the suplExam to set
     */
    public void setSuplExam(String suplExam) {
        this.suplExam = suplExam;
    }

    /**
     * @return the lungAus
     */
    public String getLungAus() {
        return lungAus;
    }

    /**
     * @param lungAus the lungAus to set
     */
    public void setLungAus(String lungAus) {
        this.lungAus = lungAus;
    }

    /**
     * @return the limbsExam
     */
    public String getLimbsExam() {
        return limbsExam;
    }

    /**
     * @param limbsExam the limbsExam to set
     */
    public void setLimbsExam(String limbsExam) {
        this.limbsExam = limbsExam;
    }

    /**
     * @return the liverAus
     */
    public String getLiverAus() {
        return liverAus;
    }

    /**
     * @param liverAus the liverAus to set
     */
    public void setLiverAus(String liverAus) {
        this.liverAus = liverAus;
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
     * @return the spleenAus
     */
    public String getSpleenAus() {
        return spleenAus;
    }

    /**
     * @param spleenAus the spleenAus to set
     */
    public void setSpleenAus(String spleenAus) {
        this.spleenAus = spleenAus;
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
     * @return the repOrganExam
     */
    public String getRepOrganExam() {
        return repOrganExam;
    }

    /**
     * @param repOrganExam the repOrganExam to set
     */
    public void setRepOrganExam(String repOrganExam) {
        this.repOrganExam = repOrganExam;
    }

    /**
     * @return the symptom
     */
    public String getSymptom() {
        return symptom;
    }

    /**
     * @param symptom the symptom to set
     */
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    /**
     * @return the sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * @param sign the sign to set
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * @return the ricket
     */
    public String getRicket() {
        return ricket;
    }

    /**
     * @param ricket the ricket to set
     */
    public void setRicket(String ricket) {
        this.ricket = ricket;
    }

    /**
     * @return the trachomaFlag
     */
    public String getTrachomaFlag() {
        return trachomaFlag;
    }

    /**
     * @param trachomaFlag the trachomaFlag to set
     */
    public void setTrachomaFlag(String trachomaFlag) {
        this.trachomaFlag = trachomaFlag;
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
     * @return the leftHearExam
     */
    public String getLeftHearExam() {
        return leftHearExam;
    }

    /**
     * @param leftHearExam the leftHearExam to set
     */
    public void setLeftHearExam(String leftHearExam) {
        this.leftHearExam = leftHearExam;
    }

    /**
     * @return the leftHearingDetection
     */
    public String getLeftHearingDetection() {
        return leftHearingDetection;
    }

    /**
     * @param leftHearingDetection the leftHearingDetection to set
     */
    public void setLeftHearingDetection(String leftHearingDetection) {
        this.leftHearingDetection = leftHearingDetection;
    }

    /**
     * @return the rightHearExam
     */
    public String getRightHearExam() {
        return rightHearExam;
    }

    /**
     * @param rightHearExam the rightHearExam to set
     */
    public void setRightHearExam(String rightHearExam) {
        this.rightHearExam = rightHearExam;
    }

    /**
     * @return the rightHearingDetection
     */
    public String getRightHearingDetection() {
        return rightHearingDetection;
    }

    /**
     * @param rightHearingDetection the rightHearingDetection to set
     */
    public void setRightHearingDetection(String rightHearingDetection) {
        this.rightHearingDetection = rightHearingDetection;
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
     * @return the pharyngealExam
     */
    public String getPharyngealExam() {
        return pharyngealExam;
    }

    /**
     * @param pharyngealExam the pharyngealExam to set
     */
    public void setPharyngealExam(String pharyngealExam) {
        this.pharyngealExam = pharyngealExam;
    }

    /**
     * @return the tonsilExam
     */
    public String getTonsilExam() {
        return tonsilExam;
    }

    /**
     * @param tonsilExam the tonsilExam to set
     */
    public void setTonsilExam(String tonsilExam) {
        this.tonsilExam = tonsilExam;
    }

    /**
     * @return the teethingMonth
     */
    public Long getTeethingMonth() {
        return teethingMonth;
    }

    /**
     * @param teethingMonth the teethingMonth to set
     */
    public void setTeethingMonth(Long teethingMonth) {
        this.teethingMonth = teethingMonth;
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

    /**
     * @return the sickenCondition
     */
    public String getSickenCondition() {
        return sickenCondition;
    }

    /**
     * @param sickenCondition the sickenCondition to set
     */
    public void setSickenCondition(String sickenCondition) {
        this.sickenCondition = sickenCondition;
    }

    /**
     * @return the sickenOrtherCondition
     */
    public String getSickenOrtherCondition() {
        return sickenOrtherCondition;
    }

    /**
     * @param sickenOrtherCondition the sickenOrtherCondition to set
     */
    public void setSickenOrtherCondition(String sickenOrtherCondition) {
        this.sickenOrtherCondition = sickenOrtherCondition;
    }

    /**
     * @return the nextExamTime
     */
    public Date getNextExamTime() {
        return nextExamTime;
    }

    /**
     * @param nextExamTime the nextExamTime to set
     */
    public void setNextExamTime(Date nextExamTime) {
        this.nextExamTime = nextExamTime;
    }

}
