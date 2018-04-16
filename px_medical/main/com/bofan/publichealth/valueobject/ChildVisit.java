package com.bofan.publichealth.valueobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ChildVisit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CHILD_VISIT", schema = SchemaConsts.PUBLIC_HEALTH)
@SequenceGenerator(name = "CHILD_VISIT_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".CHILD_VISIT_ID", allocationSize = 1)
public class ChildVisit implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 535535293570828888L;
    // Fields

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHILD_VISIT_ID")
    @Column(name = "CHILD_VISIT_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long childVisitId;
    
    @Column(name = "CHILD_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long childDetailId;
    
    @Column(name = "CHILD_NAME", nullable = false, length = 20)
	private String childName;
    
    @Column(name = "GENDER", length = 1)
	private String gender;
    
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "BIRTH_DATE")
	private Date birthDate;
    
    @Column(name = "FETATION_AGE", length = 20)
	private String fetationAge;
    
    @Column(name = "HOSPITAL_ID", nullable = false, precision = 18, scale = 0)
	private Long hospitalId;
    
    @Column(name = "HOSPITAL_NO", nullable = false, length = 40)
	private String hospitalNo;
    
    @Column(name = "HOSPITAL_NAME", length = 80)
	private String hospitalName;
    
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "VISIT_DATE", nullable = false)
	private Date visitDate;
    
    @Column(name = "VISIT_DOCTOR_ID", precision = 18, scale = 0)
	private Long visitDoctorId;
    
    @Column(name = "VISIT_DOCTOR", nullable = false, length = 20)
	private String visitDoctor;
    
    @Column(name = "VISIT_DOCTOR_PHONE", length = 50)
	private String visitDoctorPhone;
    
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @Column(name = "NEXT_VISIT_TIME", nullable = false)
	private Date nextVisitTime;
    
    @Column(name = "NEXT_VISIT_ADDR", nullable = false, length = 100)
	private String nextVisitAddr;
    
    @Column(name = "CHILD_BIRTH_HEIGHT", precision = 18)
	private Double childBirthHeight;
    
    @Column(name = "CHILD_CUR_WEIGHT", precision = 18)
	private Double childCurWeight;
    
    @Column(name = "CHILD_CUR_HEIGHT", precision = 18)
	private Double childCurHeight;
    
    @Column(name = "CHILD_BIRTH_WEIGHT", precision = 18)
	private Double childBirthWeight;
    
    @Column(name = "FEED_FLAG", length = 1)
	private String feedFlag;
    
    @Column(name = "SUCK_ML", precision = 18, scale = 0)
	private Long suckMl;
    
    @Column(name = "SUCK_PER", precision = 18, scale = 0)
	private Long suckPer;
    
    @Column(name = "EMESIS_EXAM", length = 1)
	private String emesisExam;
    
    @Column(name = "SHIT_EXAM", length = 1)
	private String shitExam;
    
    @Column(name = "SHIT_DESCRIBE", length = 100)
	private String shitDescribe;
    
    @Column(name = "SHIT_DAY_PER", precision = 18, scale = 0)
	private Long shitDayPer;
    
    @Column(name = "ANIMAL_HEAT", precision = 18)
	private Double animalHeat;
    
    @Column(name = "COMPLEXION", length = 1)
	private String complexion;
    
    @Column(name = "COMPLEXION_ORTHER", length = 100)
	private String complexionOrther;
    
    @Column(name = "HEART_RATE", precision = 18, scale = 0)
	private Long heartRate;
    
    @Column(name = "BREATHE_RATE", precision = 18, scale = 0)
	private Long breatheRate;
    
    @Column(name = "JAUNDICE_PARTS", length = 40)
	private String jaundiceParts;
    
    @Column(name = "FONTANELLE", length = 1)
	private String fontanelle;
    
    @Column(name = "FONTANELLE_ACROSS", precision = 18)
	private Double fontanelleAcross;
    
    @Column(name = "FONTANELLE_VERTICAL", precision = 18)
	private Double fontanelleVertical;
    
    @Column(name = "FONTANELLE_ORTHER", length = 100)
	private String fontanelleOrther;
    
    @Column(name = "EYE_EXAM", length = 1)
	private String eyeExam;
    
    @Column(name = "EYE_DESCRIBE", length = 100)
	private String eyeDescribe;
    
    @Column(name = "ARM_LEG", length = 1)
	private String armLeg;
    
    @Column(name = "ARM_LEG_DESCRIBE", length = 100)
	private String armLegDescribe;
    
    @Column(name = "EAR_EXAM", length = 1)
	private String earExam;
    
    @Column(name = "EAR_DESCRIBE", length = 100)
	private String earDescribe;
    
    @Column(name = "NECK_EXAM", length = 1)
	private String neckExam;
    
    @Column(name = "NECK_DESCRIBE", length = 100)
	private String neckDescribe;
    
    @Column(name = "NOSE_EXAM", length = 1)
	private String noseExam;
    
    @Column(name = "NOSE_DESCRIBE", length = 100)
	private String noseDescribe;
    
    @Column(name = "SKIN_EXAM", length = 1)
	private String skinExam;
    
    @Column(name = "SKIN_DESCRIBE", length = 100)
	private String skinDescribe;
    
    @Column(name = "MOUTH_EXAM", length = 1)
	private String mouthExam;
    
    @Column(name = "MOUTH_DESCRIBE", length = 100)
	private String mouthDescribe;
    
    @Column(name = "ANUS_EXAM", length = 1)
	private String anusExam;
    
    @Column(name = "ANUS_DESCRIBE", length = 100)
	private String anusDescribe;
    
    @Column(name = "HEART_LUNG_EXAM", length = 1)
	private String heartLungExam;
    
    @Column(name = "HEART_LUNG_DESCRIBE", length = 100)
	private String heartLungDescribe;
    
    @Column(name = "CHEST_EXAM", length = 1)
	private String chestExam;
    
    @Column(name = "CHEST_DESCRIBE", length = 100)
	private String chestDescribe;
    
    @Column(name = "ABDOMINAL_EXAM", length = 1)
	private String abdominalExam;
    
    @Column(name = "ABDOMINAL_DESCRIBE", length = 100)
	private String abdominalDescribe;
    
    @Column(name = "SPINE_EXAM", length = 1)
	private String spineExam;
    
    @Column(name = "SPINE_DESCRIBE", length = 100)
	private String spineDescribe;
    
    @Column(name = "NAVEL_EXAM", length = 1)
	private String navelExam;
    
    @Column(name = "NAVEL_DESCRIBE", length = 100)
	private String navelDescribe;
    
    @Column(name = "TRANS_TREAT_FLAG", length = 1)
	private String transTreatFlag;
    
    @Column(name = "TRANS_TREAT_REASON", length = 100)
	private String transTreatReason;
    
    @Column(name = "TRANS_TREAT_ORG", length = 100)
	private String transTreatOrg;
    
    @Column(name = "RICKETS_SYMPTOM", length = 100)
	private String ricketsSymptom;
    
    @Column(name = "RICKETS_BODY", length = 100)
	private String ricketsBody;
    
    @Column(name = "COXYPHORASE", precision = 18, scale = 0)
	private Long coxyphorase;
    
    @Column(name = "OUTDOOR_HOUR", precision = 20, scale = 0)
	private BigDecimal outdoorHour;
    
    @Column(name = "VD_DAY", precision = 20, scale = 0)
	private BigDecimal vdDay;
    
    @Column(name = "BODY_ASSESS", length = 100)
	private String bodyAssess;
    
    /** 发育评估 0=未通过;1=通过 */
    @Column(name = "BODY_ASSESS_FLAG", length = 1)
    private String bodyAssessFlag;
    
    @Column(name = "OTHER_ADVISE", length = 100)
	private String otherAdvise;
    
    /** 两次随访之间的患病情况 */
    @Column(name = "OTHER_SICKEN", length = 100)
    private String otherSicken;
    
    /** 头围 */
    @Column(name = "HEAD_SIZE", precision = 18, scale = 2)
    private Double headSize;
    
    /** 左眼视力 */
    @Column(name = "LEFT_EYESIGHT", length = 20)
    private String leftEyesight;
    
    /** 右眼视力 */
    @Column(name = "RIGHT_EYESIGHT", length = 20)
    private String rightEyesight;
    
    /** 出牙颗数 */
    @Column(name = "TOOTH_NUM", length = 18)
    private Long toothNum;
    
    /** 龋齿数（颗） */
    @Column(name = "DECAYED_TOOTH_NUM", length = 18)
    private Long decayedToothNum;
    
    /** 听力：1=通过；0=未通过 */
    @Column(name = "HEARING_EXAM", length = 1)
    private String hearingExam;
    
    /** 体格发育评价：1=正常;2=低体重;3=消瘦;4=发育迟缓;5=超重 */
    @Column(name = "GROWTH_ASSESS", length = 1)
    private String growthAssess;
    
    /** 随访-检查年龄阶段1=新生儿随访；2=1岁内检查；3=1~2岁检查；4=3~6岁检查 */
    @Column(name = "AGE_STAGE_FLAG", length = 1)
    private String ageStageFlag;
    
    @Column(name = "VALID_FLAG", length = 1)
    private String validFlag;

	// Constructors

	/** default constructor */
	public ChildVisit() {
	    
	}
	
	// Property accessors

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
     * @return the visitDoctorId
     */
    public Long getVisitDoctorId() {
        return visitDoctorId;
    }

    /**
     * @param visitDoctorId the visitDoctorId to set
     */
    public void setVisitDoctorId(Long visitDoctorId) {
        this.visitDoctorId = visitDoctorId;
    }

    /**
     * @return the visitDoctor
     */
    public String getVisitDoctor() {
        return visitDoctor;
    }

    /**
     * @param visitDoctor the visitDoctor to set
     */
    public void setVisitDoctor(String visitDoctor) {
        this.visitDoctor = visitDoctor;
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

    /**
     * @return the validFlag
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag the validFlag to set
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

}