package com.bofan.publichealth.valueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;

/**
 * ExamOrganBody entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EXAM_ORGAN_BODY", schema = SchemaConsts.PUBLIC_HEALTH)
public class ExamOrganBody implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1977877574518675279L;
    // Fields

    @Id
    @Column(name = "EXAM_PERSON_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long examPersonId;
    
    @Column(name = "EXAM_TIME", nullable = false)
	private Date examTime;
    
    @Column(name = "PERSON_DETAIL_ID", nullable = false, precision = 18, scale = 0)
	private Long personDetailId;
    
    @Column(name = "LIPS", length = 1)
	private String lips;
    
    @Column(name = "PHARYNGEAL", length = 1)
	private String pharyngeal;
    
    @Column(name = "DENTITION_FLAG", length = 1)
	private String dentitionFlag;
    
    @Column(name = "LACK_TOOTH_TL", length = 20)
	private String lackToothTl;
    
    @Column(name = "LACK_TOOTH_TR", length = 20)
	private String lackToothTr;
    
    @Column(name = "LACK_TOOTH_BL", length = 20)
	private String lackToothBl;
    
    @Column(name = "LACK_TOOTH_BR", length = 20)
	private String lackToothBr;
    
    @Column(name = "DECAYED_TOOTH_TL", length = 20)
	private String decayedToothTl;
    
    @Column(name = "DECAYED_TOOTH_TR", length = 20)
	private String decayedToothTr;
    
    @Column(name = "DECAYED_TOOTH_BL", length = 20)
	private String decayedToothBl;
    
    @Column(name = "DECAYED_TOOTH_BR", length = 20)
	private String decayedToothBr;
    
    @Column(name = "FALSE_TOOTH_TL", length = 20)
	private String falseToothTl;
    
    @Column(name = "FALSE_TOOTH_TR", length = 20)
	private String falseToothTr;
    
    @Column(name = "FALSE_TOOTH_BL", length = 20)
	private String falseToothBl;
    
    @Column(name = "FALSE_TOOTH_BR", length = 20)
	private String falseToothBr;
    
    @Column(name = "LEFT_EYE", precision = 3, scale = 1)
	private Double leftEye;
    
    @Column(name = "RIGHT_EYE", precision = 3, scale = 1)
	private Double rightEye;
    
    @Column(name = "LEFT_CORRECT_EYE", precision = 3, scale = 1)
	private Double leftCorrectEye;
    
    @Column(name = "RIGHT_CORRECT_EYE", precision = 3, scale = 1)
	private Double rightCorrectEye;
    
    @Column(name = "HEARING", length = 1)
	private String hearing;
    
    @Column(name = "SPORTS_ABILITY", length = 1)
	private String sportsAbility;
    
    @Column(name = "FUNDUS", length = 1)
	private String fundus;
    
    @Column(name = "FUNDUS_OTHER_CONTENT", length = 100)
	private String fundusOtherContent;
    
    @Column(name = "SKIN", length = 1)
	private String skin;
    
    @Column(name = "SKIN_OTHER_CONTENT", length = 100)
	private String skinOtherContent;
    
    @Column(name = "LYMPH", length = 1)
	private String lymph;
    
    @Column(name = "LYMPH_OTHER_CONTENT", length = 100)
	private String lymphOtherContent;
    
    @Column(name = "SCLERA", length = 1)
	private String sclera;
    
    @Column(name = "SCLERA_OTHER_CONTENT", length = 100)
	private String scleraOtherContent;
    
    @Column(name = "BARREL", length = 1)
	private String barrel;
    
    @Column(name = "BREATH", length = 1)
	private String breath;
    
    @Column(name = "BREATH_OTHER_CONTENT", length = 100)
	private String breathOtherContent;
    
    @Column(name = "RALE", length = 1)
	private String rale;
    
    @Column(name = "RALE_OTHER_CONTENT", length = 100)
	private String raleOtherContent;
    
    @Column(name = "HEART_RATE", precision = 3, scale = 0)
	private Short heartRate;
    
    @Column(name = "RHYTHM_HEART", length = 1)
	private String rhythmHeart;
    
    @Column(name = "HEART_NOISE", length = 1)
	private String heartNoise;
    
    @Column(name = "HEART_NOISE_CONTENT", length = 100)
	private String heartNoiseContent;
    
    @Column(name = "TENDER", length = 1)
	private String tender;
    
    @Column(name = "TENDER_OTHER_CONTENT", length = 100)
	private String tenderOtherContent;
    
    @Column(name = "ENCLOSED", length = 1)
	private String enclosed;
    
    @Column(name = "ENCLOSED_OTHER_CONTENT", length = 100)
	private String enclosedOtherContent;
    
    @Column(name = "HEPAT", length = 1)
	private String hepat;
    
    @Column(name = "HEPAT_OTHER_CONTENT", length = 100)
	private String hepatOtherContent;
    
    @Column(name = "SPLENAUXE", length = 1)
	private String splenauxe;
    
    @Column(name = "SPLENAUXE_OTHER_CONTENT", length = 100)
	private String splenauxeOtherContent;
    
    @Column(name = "SHIFT_DULL", length = 1)
	private String shiftDull;
    
    @Column(name = "SHIFT_DULL_CONTENT", length = 100)
	private String shiftDullContent;
    
    @Column(name = "LOWER_BODY_EDEMA", length = 1)
	private String lowerBodyEdema;
    
    @Column(name = "ANUS_DRE", length = 1)
	private String anusDre;
    
    @Column(name = "ANUS_DRE_CONTENT", length = 100)
	private String anusDreContent;
    
    @Column(name = "DORSAL_ARTERY_BEATS", length = 40)
	private String dorsalArteryBeats;
    
    @Column(name = "BREAST", length = 40)
	private String breast;
    
    @Column(name = "BREAST_OTHER_CONTENT", length = 100)
	private String breastOtherContent;
    
    @Column(name = "VULVA", length = 1)
	private String vulva;
    
    @Column(name = "VULVA_OTHER_CONTENT", length = 100)
	private String vulvaOtherContent;
    
    @Column(name = "VAGINA", length = 1)
	private String vagina;
    
    @Column(name = "VAGINA_OTHER_CONTENT", length = 100)
	private String vaginaOtherContent;
    
    @Column(name = "CERVIX", length = 1)
	private String cervix;
    
    @Column(name = "CERVIX_OTHER_CONTENT", length = 100)
	private String cervixOtherContent;
    
    @Column(name = "CORPUS", length = 1)
	private String corpus;
    
    @Column(name = "CORPUS_OTHER_CONTENT", length = 100)
	private String corpusOtherContent;
    
    @Column(name = "ADNEXA_UTERI", length = 1)
	private String adnexaUteri;
    
    @Column(name = "ADNEXA_UTERI_CONTENT", length = 100)
	private String adnexaUteriContent;
    
    @Column(name = "SCREENELSE", length = 50)
	private String screenelse;
    
    @Column(name = "HEMOGLOBIN_NUM", length = 100)
	private String hemoglobinNum;
    
    @Column(name = "HEMAMEBA_NUM", length = 100)
	private String hemamebaNum;
    
    @Column(name = "PLATELET_NUM", length = 100)
	private String plateletNum;
    
    @Column(name = "BLOOD_ROUTINE", length = 50)
	private String bloodRoutine;
    
    @Column(name = "UNINE_PROTEIN", length = 100)
	private String unineProtein;
    
    @Column(name = "URINE_SUGAR", length = 100)
	private String urineSugar;
    
    @Column(name = "URINE_ACETONE", length = 100)
	private String urineAcetone;
    
    @Column(name = "URINE_OCCULT_BLOOD", length = 100)
	private String urineOccultBlood;
    
    @Column(name = "UNINE_OTHER_CONTENT", length = 30)
	private String unineOtherContent;
    
    @Column(name = "FBG_MMOL", precision = 4, scale = 1)
	private Double fbgMmol;
    
    @Column(name = "FBG_MG", precision = 4, scale = 1)
	private Double fbgMg;
    
    @Column(name = "ECG", length = 1)
	private String ecg;
    
    @Column(name = "ECG_OTHER_CONTENT", length = 100)
	private String ecgOtherContent;
    
    @Column(name = "MICROALBUMINURIA", precision = 5, scale = 1)
	private Double microalbuminuria;
    
    @Column(name = "FOBT", length = 1)
	private String fobt;
    
    /**
    @Column(name = "BSURFACE_ANTIGEN", length = 1)
    private String bsurfaceAntigen;
    */
    
    @Column(name = "GLY_HEMOGLOBIN", precision = 4, scale = 1)
	private Double glyHemoglobin;
    
    @Column(name = "SGPT", precision = 3, scale = 0)
	private Short sgpt;
    
    @Column(name = "SGOT", precision = 3, scale = 0)
	private Short sgot;
    
    @Column(name = "ALBUMIN", precision = 2, scale = 0)
	private Byte albumin;
    
    @Column(name = "TBIL", precision = 4, scale = 1)
	private Double tbil;
    
    @Column(name = "DBIL", precision = 5, scale = 1)
	private Double dbil;
    
    @Column(name = "CREA", precision = 18, scale = 0)
	private Long crea;
    
    @Column(name = "BUN", precision = 4, scale = 1)
	private Double bun;
    
    @Column(name = "PCONCENTRAT", precision = 4, scale = 1)
	private Double pconcentrat;
    
    @Column(name = "BSCONCENTRAT", precision = 4, scale = 0)
	private Short bsconcentrat;
    
    @Column(name = "TC", precision = 5)
	private Double tc;
    
    @Column(name = "TG", precision = 18, scale = 0)
	private Long tg;
    
    @Column(name = "LDL_CHOLESTEROL", precision = 5)
	private Double ldlCholesterol;
    
    @Column(name = "HDL_CHOLESTEROL", precision = 5)
	private Double hdlCholesterol;
    
    @Column(name = "CHESTX", length = 1)
	private String chestx;
    
    @Column(name = "CHESTX_OTHER_CONTENT", length = 100)
	private String chestxOtherContent;
    
    @Column(name = "ABDOMINAL_BTYPE", length = 1)
	private String abdominalBtype;
    
    @Column(name = "ABDOMINAL_BTYPE_CONTENT", length = 100)
	private String abdominalBtypeContent;
    
    @Column(name = "PAP_SMEAR", length = 1)
	private String papSmear;
    
    @Column(name = "PAP_SMEAR_CONTENT", length = 100)
	private String papSmearContent;
    
    @Column(name = "BTYPE", length = 1)
	private String btype;
    
    @Column(name = "BTYPE_OTHER_CONTENT", length = 100)
	private String btypeOtherContent;
    
    @Column(name = "AEXAM_OTHER", length = 100)
	private String aexamOther;

	// Constructors

	/** default constructor */
	public ExamOrganBody() {
	}

    /**
     * @return the examPersonId
     */
    public Long getExamPersonId() {
        return examPersonId;
    }

    /**
     * @param examPersonId the examPersonId to set
     */
    public void setExamPersonId(Long examPersonId) {
        this.examPersonId = examPersonId;
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
     * @return the personDetailId
     */
    public Long getPersonDetailId() {
        return personDetailId;
    }

    /**
     * @param personDetailId the personDetailId to set
     */
    public void setPersonDetailId(Long personDetailId) {
        this.personDetailId = personDetailId;
    }

    /**
     * @return the lips
     */
    public String getLips() {
        return lips;
    }

    /**
     * @param lips the lips to set
     */
    public void setLips(String lips) {
        this.lips = lips;
    }

    /**
     * @return the pharyngeal
     */
    public String getPharyngeal() {
        return pharyngeal;
    }

    /**
     * @param pharyngeal the pharyngeal to set
     */
    public void setPharyngeal(String pharyngeal) {
        this.pharyngeal = pharyngeal;
    }

    /**
     * @return the dentitionFlag
     */
    public String getDentitionFlag() {
        return dentitionFlag;
    }

    /**
     * @param dentitionFlag the dentitionFlag to set
     */
    public void setDentitionFlag(String dentitionFlag) {
        this.dentitionFlag = dentitionFlag;
    }

    /**
     * @return the lackToothTl
     */
    public String getLackToothTl() {
        return lackToothTl;
    }

    /**
     * @param lackToothTl the lackToothTl to set
     */
    public void setLackToothTl(String lackToothTl) {
        this.lackToothTl = lackToothTl;
    }

    /**
     * @return the lackToothTr
     */
    public String getLackToothTr() {
        return lackToothTr;
    }

    /**
     * @param lackToothTr the lackToothTr to set
     */
    public void setLackToothTr(String lackToothTr) {
        this.lackToothTr = lackToothTr;
    }

    /**
     * @return the lackToothBl
     */
    public String getLackToothBl() {
        return lackToothBl;
    }

    /**
     * @param lackToothBl the lackToothBl to set
     */
    public void setLackToothBl(String lackToothBl) {
        this.lackToothBl = lackToothBl;
    }

    /**
     * @return the lackToothBr
     */
    public String getLackToothBr() {
        return lackToothBr;
    }

    /**
     * @param lackToothBr the lackToothBr to set
     */
    public void setLackToothBr(String lackToothBr) {
        this.lackToothBr = lackToothBr;
    }

    /**
     * @return the decayedToothTl
     */
    public String getDecayedToothTl() {
        return decayedToothTl;
    }

    /**
     * @param decayedToothTl the decayedToothTl to set
     */
    public void setDecayedToothTl(String decayedToothTl) {
        this.decayedToothTl = decayedToothTl;
    }

    /**
     * @return the decayedToothTr
     */
    public String getDecayedToothTr() {
        return decayedToothTr;
    }

    /**
     * @param decayedToothTr the decayedToothTr to set
     */
    public void setDecayedToothTr(String decayedToothTr) {
        this.decayedToothTr = decayedToothTr;
    }

    /**
     * @return the decayedToothBl
     */
    public String getDecayedToothBl() {
        return decayedToothBl;
    }

    /**
     * @param decayedToothBl the decayedToothBl to set
     */
    public void setDecayedToothBl(String decayedToothBl) {
        this.decayedToothBl = decayedToothBl;
    }

    /**
     * @return the decayedToothBr
     */
    public String getDecayedToothBr() {
        return decayedToothBr;
    }

    /**
     * @param decayedToothBr the decayedToothBr to set
     */
    public void setDecayedToothBr(String decayedToothBr) {
        this.decayedToothBr = decayedToothBr;
    }

    /**
     * @return the falseToothTl
     */
    public String getFalseToothTl() {
        return falseToothTl;
    }

    /**
     * @param falseToothTl the falseToothTl to set
     */
    public void setFalseToothTl(String falseToothTl) {
        this.falseToothTl = falseToothTl;
    }

    /**
     * @return the falseToothTr
     */
    public String getFalseToothTr() {
        return falseToothTr;
    }

    /**
     * @param falseToothTr the falseToothTr to set
     */
    public void setFalseToothTr(String falseToothTr) {
        this.falseToothTr = falseToothTr;
    }

    /**
     * @return the falseToothBl
     */
    public String getFalseToothBl() {
        return falseToothBl;
    }

    /**
     * @param falseToothBl the falseToothBl to set
     */
    public void setFalseToothBl(String falseToothBl) {
        this.falseToothBl = falseToothBl;
    }

    /**
     * @return the falseToothBr
     */
    public String getFalseToothBr() {
        return falseToothBr;
    }

    /**
     * @param falseToothBr the falseToothBr to set
     */
    public void setFalseToothBr(String falseToothBr) {
        this.falseToothBr = falseToothBr;
    }

    /**
     * @return the leftEye
     */
    public Double getLeftEye() {
        return leftEye;
    }

    /**
     * @param leftEye the leftEye to set
     */
    public void setLeftEye(Double leftEye) {
        this.leftEye = leftEye;
    }

    /**
     * @return the rightEye
     */
    public Double getRightEye() {
        return rightEye;
    }

    /**
     * @param rightEye the rightEye to set
     */
    public void setRightEye(Double rightEye) {
        this.rightEye = rightEye;
    }

    /**
     * @return the leftCorrectEye
     */
    public Double getLeftCorrectEye() {
        return leftCorrectEye;
    }

    /**
     * @param leftCorrectEye the leftCorrectEye to set
     */
    public void setLeftCorrectEye(Double leftCorrectEye) {
        this.leftCorrectEye = leftCorrectEye;
    }

    /**
     * @return the rightCorrectEye
     */
    public Double getRightCorrectEye() {
        return rightCorrectEye;
    }

    /**
     * @param rightCorrectEye the rightCorrectEye to set
     */
    public void setRightCorrectEye(Double rightCorrectEye) {
        this.rightCorrectEye = rightCorrectEye;
    }

    /**
     * @return the hearing
     */
    public String getHearing() {
        return hearing;
    }

    /**
     * @param hearing the hearing to set
     */
    public void setHearing(String hearing) {
        this.hearing = hearing;
    }

    /**
     * @return the sportsAbility
     */
    public String getSportsAbility() {
        return sportsAbility;
    }

    /**
     * @param sportsAbility the sportsAbility to set
     */
    public void setSportsAbility(String sportsAbility) {
        this.sportsAbility = sportsAbility;
    }

    /**
     * @return the fundus
     */
    public String getFundus() {
        return fundus;
    }

    /**
     * @param fundus the fundus to set
     */
    public void setFundus(String fundus) {
        this.fundus = fundus;
    }

    /**
     * @return the fundusOtherContent
     */
    public String getFundusOtherContent() {
        return fundusOtherContent;
    }

    /**
     * @param fundusOtherContent the fundusOtherContent to set
     */
    public void setFundusOtherContent(String fundusOtherContent) {
        this.fundusOtherContent = fundusOtherContent;
    }

    /**
     * @return the skin
     */
    public String getSkin() {
        return skin;
    }

    /**
     * @param skin the skin to set
     */
    public void setSkin(String skin) {
        this.skin = skin;
    }

    /**
     * @return the skinOtherContent
     */
    public String getSkinOtherContent() {
        return skinOtherContent;
    }

    /**
     * @param skinOtherContent the skinOtherContent to set
     */
    public void setSkinOtherContent(String skinOtherContent) {
        this.skinOtherContent = skinOtherContent;
    }

    /**
     * @return the lymph
     */
    public String getLymph() {
        return lymph;
    }

    /**
     * @param lymph the lymph to set
     */
    public void setLymph(String lymph) {
        this.lymph = lymph;
    }

    /**
     * @return the lymphOtherContent
     */
    public String getLymphOtherContent() {
        return lymphOtherContent;
    }

    /**
     * @param lymphOtherContent the lymphOtherContent to set
     */
    public void setLymphOtherContent(String lymphOtherContent) {
        this.lymphOtherContent = lymphOtherContent;
    }

    /**
     * @return the sclera
     */
    public String getSclera() {
        return sclera;
    }

    /**
     * @param sclera the sclera to set
     */
    public void setSclera(String sclera) {
        this.sclera = sclera;
    }

    /**
     * @return the scleraOtherContent
     */
    public String getScleraOtherContent() {
        return scleraOtherContent;
    }

    /**
     * @param scleraOtherContent the scleraOtherContent to set
     */
    public void setScleraOtherContent(String scleraOtherContent) {
        this.scleraOtherContent = scleraOtherContent;
    }

    /**
     * @return the barrel
     */
    public String getBarrel() {
        return barrel;
    }

    /**
     * @param barrel the barrel to set
     */
    public void setBarrel(String barrel) {
        this.barrel = barrel;
    }

    /**
     * @return the breath
     */
    public String getBreath() {
        return breath;
    }

    /**
     * @param breath the breath to set
     */
    public void setBreath(String breath) {
        this.breath = breath;
    }

    /**
     * @return the breathOtherContent
     */
    public String getBreathOtherContent() {
        return breathOtherContent;
    }

    /**
     * @param breathOtherContent the breathOtherContent to set
     */
    public void setBreathOtherContent(String breathOtherContent) {
        this.breathOtherContent = breathOtherContent;
    }

    /**
     * @return the rale
     */
    public String getRale() {
        return rale;
    }

    /**
     * @param rale the rale to set
     */
    public void setRale(String rale) {
        this.rale = rale;
    }

    /**
     * @return the raleOtherContent
     */
    public String getRaleOtherContent() {
        return raleOtherContent;
    }

    /**
     * @param raleOtherContent the raleOtherContent to set
     */
    public void setRaleOtherContent(String raleOtherContent) {
        this.raleOtherContent = raleOtherContent;
    }

    /**
     * @return the heartRate
     */
    public Short getHeartRate() {
        return heartRate;
    }

    /**
     * @param heartRate the heartRate to set
     */
    public void setHeartRate(Short heartRate) {
        this.heartRate = heartRate;
    }

    /**
     * @return the rhythmHeart
     */
    public String getRhythmHeart() {
        return rhythmHeart;
    }

    /**
     * @param rhythmHeart the rhythmHeart to set
     */
    public void setRhythmHeart(String rhythmHeart) {
        this.rhythmHeart = rhythmHeart;
    }

    /**
     * @return the heartNoise
     */
    public String getHeartNoise() {
        return heartNoise;
    }

    /**
     * @param heartNoise the heartNoise to set
     */
    public void setHeartNoise(String heartNoise) {
        this.heartNoise = heartNoise;
    }

    /**
     * @return the heartNoiseContent
     */
    public String getHeartNoiseContent() {
        return heartNoiseContent;
    }

    /**
     * @param heartNoiseContent the heartNoiseContent to set
     */
    public void setHeartNoiseContent(String heartNoiseContent) {
        this.heartNoiseContent = heartNoiseContent;
    }

    /**
     * @return the tender
     */
    public String getTender() {
        return tender;
    }

    /**
     * @param tender the tender to set
     */
    public void setTender(String tender) {
        this.tender = tender;
    }

    /**
     * @return the tenderOtherContent
     */
    public String getTenderOtherContent() {
        return tenderOtherContent;
    }

    /**
     * @param tenderOtherContent the tenderOtherContent to set
     */
    public void setTenderOtherContent(String tenderOtherContent) {
        this.tenderOtherContent = tenderOtherContent;
    }

    /**
     * @return the enclosed
     */
    public String getEnclosed() {
        return enclosed;
    }

    /**
     * @param enclosed the enclosed to set
     */
    public void setEnclosed(String enclosed) {
        this.enclosed = enclosed;
    }

    /**
     * @return the enclosedOtherContent
     */
    public String getEnclosedOtherContent() {
        return enclosedOtherContent;
    }

    /**
     * @param enclosedOtherContent the enclosedOtherContent to set
     */
    public void setEnclosedOtherContent(String enclosedOtherContent) {
        this.enclosedOtherContent = enclosedOtherContent;
    }

    /**
     * @return the hepat
     */
    public String getHepat() {
        return hepat;
    }

    /**
     * @param hepat the hepat to set
     */
    public void setHepat(String hepat) {
        this.hepat = hepat;
    }

    /**
     * @return the hepatOtherContent
     */
    public String getHepatOtherContent() {
        return hepatOtherContent;
    }

    /**
     * @param hepatOtherContent the hepatOtherContent to set
     */
    public void setHepatOtherContent(String hepatOtherContent) {
        this.hepatOtherContent = hepatOtherContent;
    }

    /**
     * @return the splenauxe
     */
    public String getSplenauxe() {
        return splenauxe;
    }

    /**
     * @param splenauxe the splenauxe to set
     */
    public void setSplenauxe(String splenauxe) {
        this.splenauxe = splenauxe;
    }

    /**
     * @return the splenauxeOtherContent
     */
    public String getSplenauxeOtherContent() {
        return splenauxeOtherContent;
    }

    /**
     * @param splenauxeOtherContent the splenauxeOtherContent to set
     */
    public void setSplenauxeOtherContent(String splenauxeOtherContent) {
        this.splenauxeOtherContent = splenauxeOtherContent;
    }

    /**
     * @return the shiftDull
     */
    public String getShiftDull() {
        return shiftDull;
    }

    /**
     * @param shiftDull the shiftDull to set
     */
    public void setShiftDull(String shiftDull) {
        this.shiftDull = shiftDull;
    }

    /**
     * @return the shiftDullContent
     */
    public String getShiftDullContent() {
        return shiftDullContent;
    }

    /**
     * @param shiftDullContent the shiftDullContent to set
     */
    public void setShiftDullContent(String shiftDullContent) {
        this.shiftDullContent = shiftDullContent;
    }

    /**
     * @return the lowerBodyEdema
     */
    public String getLowerBodyEdema() {
        return lowerBodyEdema;
    }

    /**
     * @param lowerBodyEdema the lowerBodyEdema to set
     */
    public void setLowerBodyEdema(String lowerBodyEdema) {
        this.lowerBodyEdema = lowerBodyEdema;
    }

    /**
     * @return the anusDre
     */
    public String getAnusDre() {
        return anusDre;
    }

    /**
     * @param anusDre the anusDre to set
     */
    public void setAnusDre(String anusDre) {
        this.anusDre = anusDre;
    }

    /**
     * @return the anusDreContent
     */
    public String getAnusDreContent() {
        return anusDreContent;
    }

    /**
     * @param anusDreContent the anusDreContent to set
     */
    public void setAnusDreContent(String anusDreContent) {
        this.anusDreContent = anusDreContent;
    }

    /**
     * @return the dorsalArteryBeats
     */
    public String getDorsalArteryBeats() {
        return dorsalArteryBeats;
    }

    /**
     * @param dorsalArteryBeats the dorsalArteryBeats to set
     */
    public void setDorsalArteryBeats(String dorsalArteryBeats) {
        this.dorsalArteryBeats = dorsalArteryBeats;
    }

    /**
     * @return the breast
     */
    public String getBreast() {
        return breast;
    }

    /**
     * @param breast the breast to set
     */
    public void setBreast(String breast) {
        this.breast = breast;
    }

    /**
     * @return the breastOtherContent
     */
    public String getBreastOtherContent() {
        return breastOtherContent;
    }

    /**
     * @param breastOtherContent the breastOtherContent to set
     */
    public void setBreastOtherContent(String breastOtherContent) {
        this.breastOtherContent = breastOtherContent;
    }

    /**
     * @return the vulva
     */
    public String getVulva() {
        return vulva;
    }

    /**
     * @param vulva the vulva to set
     */
    public void setVulva(String vulva) {
        this.vulva = vulva;
    }

    /**
     * @return the vulvaOtherContent
     */
    public String getVulvaOtherContent() {
        return vulvaOtherContent;
    }

    /**
     * @param vulvaOtherContent the vulvaOtherContent to set
     */
    public void setVulvaOtherContent(String vulvaOtherContent) {
        this.vulvaOtherContent = vulvaOtherContent;
    }

    /**
     * @return the vagina
     */
    public String getVagina() {
        return vagina;
    }

    /**
     * @param vagina the vagina to set
     */
    public void setVagina(String vagina) {
        this.vagina = vagina;
    }

    /**
     * @return the vaginaOtherContent
     */
    public String getVaginaOtherContent() {
        return vaginaOtherContent;
    }

    /**
     * @param vaginaOtherContent the vaginaOtherContent to set
     */
    public void setVaginaOtherContent(String vaginaOtherContent) {
        this.vaginaOtherContent = vaginaOtherContent;
    }

    /**
     * @return the cervix
     */
    public String getCervix() {
        return cervix;
    }

    /**
     * @param cervix the cervix to set
     */
    public void setCervix(String cervix) {
        this.cervix = cervix;
    }

    /**
     * @return the cervixOtherContent
     */
    public String getCervixOtherContent() {
        return cervixOtherContent;
    }

    /**
     * @param cervixOtherContent the cervixOtherContent to set
     */
    public void setCervixOtherContent(String cervixOtherContent) {
        this.cervixOtherContent = cervixOtherContent;
    }

    /**
     * @return the corpus
     */
    public String getCorpus() {
        return corpus;
    }

    /**
     * @param corpus the corpus to set
     */
    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    /**
     * @return the corpusOtherContent
     */
    public String getCorpusOtherContent() {
        return corpusOtherContent;
    }

    /**
     * @param corpusOtherContent the corpusOtherContent to set
     */
    public void setCorpusOtherContent(String corpusOtherContent) {
        this.corpusOtherContent = corpusOtherContent;
    }

    /**
     * @return the adnexaUteri
     */
    public String getAdnexaUteri() {
        return adnexaUteri;
    }

    /**
     * @param adnexaUteri the adnexaUteri to set
     */
    public void setAdnexaUteri(String adnexaUteri) {
        this.adnexaUteri = adnexaUteri;
    }

    /**
     * @return the adnexaUteriContent
     */
    public String getAdnexaUteriContent() {
        return adnexaUteriContent;
    }

    /**
     * @param adnexaUteriContent the adnexaUteriContent to set
     */
    public void setAdnexaUteriContent(String adnexaUteriContent) {
        this.adnexaUteriContent = adnexaUteriContent;
    }

    /**
     * @return the screenelse
     */
    public String getScreenelse() {
        return screenelse;
    }

    /**
     * @param screenelse the screenelse to set
     */
    public void setScreenelse(String screenelse) {
        this.screenelse = screenelse;
    }

    /**
     * @return the hemoglobinNum
     */
    public String getHemoglobinNum() {
        return hemoglobinNum;
    }

    /**
     * @param hemoglobinNum the hemoglobinNum to set
     */
    public void setHemoglobinNum(String hemoglobinNum) {
        this.hemoglobinNum = hemoglobinNum;
    }

    /**
     * @return the hemamebaNum
     */
    public String getHemamebaNum() {
        return hemamebaNum;
    }

    /**
     * @param hemamebaNum the hemamebaNum to set
     */
    public void setHemamebaNum(String hemamebaNum) {
        this.hemamebaNum = hemamebaNum;
    }

    /**
     * @return the plateletNum
     */
    public String getPlateletNum() {
        return plateletNum;
    }

    /**
     * @param plateletNum the plateletNum to set
     */
    public void setPlateletNum(String plateletNum) {
        this.plateletNum = plateletNum;
    }

    /**
     * @return the bloodRoutine
     */
    public String getBloodRoutine() {
        return bloodRoutine;
    }

    /**
     * @param bloodRoutine the bloodRoutine to set
     */
    public void setBloodRoutine(String bloodRoutine) {
        this.bloodRoutine = bloodRoutine;
    }

    /**
     * @return the unineProtein
     */
    public String getUnineProtein() {
        return unineProtein;
    }

    /**
     * @param unineProtein the unineProtein to set
     */
    public void setUnineProtein(String unineProtein) {
        this.unineProtein = unineProtein;
    }

    /**
     * @return the urineSugar
     */
    public String getUrineSugar() {
        return urineSugar;
    }

    /**
     * @param urineSugar the urineSugar to set
     */
    public void setUrineSugar(String urineSugar) {
        this.urineSugar = urineSugar;
    }

    /**
     * @return the urineAcetone
     */
    public String getUrineAcetone() {
        return urineAcetone;
    }

    /**
     * @param urineAcetone the urineAcetone to set
     */
    public void setUrineAcetone(String urineAcetone) {
        this.urineAcetone = urineAcetone;
    }

    /**
     * @return the urineOccultBlood
     */
    public String getUrineOccultBlood() {
        return urineOccultBlood;
    }

    /**
     * @param urineOccultBlood the urineOccultBlood to set
     */
    public void setUrineOccultBlood(String urineOccultBlood) {
        this.urineOccultBlood = urineOccultBlood;
    }

    /**
     * @return the unineOtherContent
     */
    public String getUnineOtherContent() {
        return unineOtherContent;
    }

    /**
     * @param unineOtherContent the unineOtherContent to set
     */
    public void setUnineOtherContent(String unineOtherContent) {
        this.unineOtherContent = unineOtherContent;
    }

    /**
     * @return the fbgMmol
     */
    public Double getFbgMmol() {
        return fbgMmol;
    }

    /**
     * @param fbgMmol the fbgMmol to set
     */
    public void setFbgMmol(Double fbgMmol) {
        this.fbgMmol = fbgMmol;
    }

    /**
     * @return the fbgMg
     */
    public Double getFbgMg() {
        return fbgMg;
    }

    /**
     * @param fbgMg the fbgMg to set
     */
    public void setFbgMg(Double fbgMg) {
        this.fbgMg = fbgMg;
    }

    /**
     * @return the ecg
     */
    public String getEcg() {
        return ecg;
    }

    /**
     * @param ecg the ecg to set
     */
    public void setEcg(String ecg) {
        this.ecg = ecg;
    }

    /**
     * @return the ecgOtherContent
     */
    public String getEcgOtherContent() {
        return ecgOtherContent;
    }

    /**
     * @param ecgOtherContent the ecgOtherContent to set
     */
    public void setEcgOtherContent(String ecgOtherContent) {
        this.ecgOtherContent = ecgOtherContent;
    }

    /**
     * @return the microalbuminuria
     */
    public Double getMicroalbuminuria() {
        return microalbuminuria;
    }

    /**
     * @param microalbuminuria the microalbuminuria to set
     */
    public void setMicroalbuminuria(Double microalbuminuria) {
        this.microalbuminuria = microalbuminuria;
    }

    /**
     * @return the fobt
     */
    public String getFobt() {
        return fobt;
    }

    /**
     * @param fobt the fobt to set
     */
    public void setFobt(String fobt) {
        this.fobt = fobt;
    }

    /**
    public String getBsurfaceAntigen() {
        return bsurfaceAntigen;
    }

 
    public void setBsurfaceAntigen(String bsurfaceAntigen) {
        this.bsurfaceAntigen = bsurfaceAntigen;
    }
     */
    /**
     * @return the glyHemoglobin
     */
    public Double getGlyHemoglobin() {
        return glyHemoglobin;
    }

    /**
     * @param glyHemoglobin the glyHemoglobin to set
     */
    public void setGlyHemoglobin(Double glyHemoglobin) {
        this.glyHemoglobin = glyHemoglobin;
    }

    /**
     * @return the sgpt
     */
    public Short getSgpt() {
        return sgpt;
    }

    /**
     * @param sgpt the sgpt to set
     */
    public void setSgpt(Short sgpt) {
        this.sgpt = sgpt;
    }

    /**
     * @return the sgot
     */
    public Short getSgot() {
        return sgot;
    }

    /**
     * @param sgot the sgot to set
     */
    public void setSgot(Short sgot) {
        this.sgot = sgot;
    }

    /**
     * @return the albumin
     */
    public Byte getAlbumin() {
        return albumin;
    }

    /**
     * @param albumin the albumin to set
     */
    public void setAlbumin(Byte albumin) {
        this.albumin = albumin;
    }

    /**
     * @return the tbil
     */
    public Double getTbil() {
        return tbil;
    }

    /**
     * @param tbil the tbil to set
     */
    public void setTbil(Double tbil) {
        this.tbil = tbil;
    }

    /**
     * @return the dbil
     */
    public Double getDbil() {
        return dbil;
    }

    /**
     * @param dbil the dbil to set
     */
    public void setDbil(Double dbil) {
        this.dbil = dbil;
    }

    /**
     * @return the crea
     */
    public Long getCrea() {
        return crea;
    }

    /**
     * @param crea the crea to set
     */
    public void setCrea(Long crea) {
        this.crea = crea;
    }

    /**
     * @return the bun
     */
    public Double getBun() {
        return bun;
    }

    /**
     * @param bun the bun to set
     */
    public void setBun(Double bun) {
        this.bun = bun;
    }

    /**
     * @return the pconcentrat
     */
    public Double getPconcentrat() {
        return pconcentrat;
    }

    /**
     * @param pconcentrat the pconcentrat to set
     */
    public void setPconcentrat(Double pconcentrat) {
        this.pconcentrat = pconcentrat;
    }

    /**
     * @return the bsconcentrat
     */
    public Short getBsconcentrat() {
        return bsconcentrat;
    }

    /**
     * @param bsconcentrat the bsconcentrat to set
     */
    public void setBsconcentrat(Short bsconcentrat) {
        this.bsconcentrat = bsconcentrat;
    }

    /**
     * @return the tc
     */
    public Double getTc() {
        return tc;
    }

    /**
     * @param tc the tc to set
     */
    public void setTc(Double tc) {
        this.tc = tc;
    }

    /**
     * @return the tg
     */
    public Long getTg() {
        return tg;
    }

    /**
     * @param tg the tg to set
     */
    public void setTg(Long tg) {
        this.tg = tg;
    }

    /**
     * @return the ldlCholesterol
     */
    public Double getLdlCholesterol() {
        return ldlCholesterol;
    }

    /**
     * @param ldlCholesterol the ldlCholesterol to set
     */
    public void setLdlCholesterol(Double ldlCholesterol) {
        this.ldlCholesterol = ldlCholesterol;
    }

    /**
     * @return the hdlCholesterol
     */
    public Double getHdlCholesterol() {
        return hdlCholesterol;
    }

    /**
     * @param hdlCholesterol the hdlCholesterol to set
     */
    public void setHdlCholesterol(Double hdlCholesterol) {
        this.hdlCholesterol = hdlCholesterol;
    }

    /**
     * @return the chestx
     */
    public String getChestx() {
        return chestx;
    }

    /**
     * @param chestx the chestx to set
     */
    public void setChestx(String chestx) {
        this.chestx = chestx;
    }

    /**
     * @return the chestxOtherContent
     */
    public String getChestxOtherContent() {
        return chestxOtherContent;
    }

    /**
     * @param chestxOtherContent the chestxOtherContent to set
     */
    public void setChestxOtherContent(String chestxOtherContent) {
        this.chestxOtherContent = chestxOtherContent;
    }

    /**
     * @return the abdominalBtype
     */
    public String getAbdominalBtype() {
        return abdominalBtype;
    }

    /**
     * @param abdominalBtype the abdominalBtype to set
     */
    public void setAbdominalBtype(String abdominalBtype) {
        this.abdominalBtype = abdominalBtype;
    }

    /**
     * @return the abdominalBtypeContent
     */
    public String getAbdominalBtypeContent() {
        return abdominalBtypeContent;
    }

    /**
     * @param abdominalBtypeContent the abdominalBtypeContent to set
     */
    public void setAbdominalBtypeContent(String abdominalBtypeContent) {
        this.abdominalBtypeContent = abdominalBtypeContent;
    }

    /**
     * @return the papSmear
     */
    public String getPapSmear() {
        return papSmear;
    }

    /**
     * @param papSmear the papSmear to set
     */
    public void setPapSmear(String papSmear) {
        this.papSmear = papSmear;
    }

    /**
     * @return the papSmearContent
     */
    public String getPapSmearContent() {
        return papSmearContent;
    }

    /**
     * @param papSmearContent the papSmearContent to set
     */
    public void setPapSmearContent(String papSmearContent) {
        this.papSmearContent = papSmearContent;
    }

    /**
     * @return the btype
     */
    public String getBtype() {
        return btype;
    }

    /**
     * @param btype the btype to set
     */
    public void setBtype(String btype) {
        this.btype = btype;
    }

    /**
     * @return the btypeOtherContent
     */
    public String getBtypeOtherContent() {
        return btypeOtherContent;
    }

    /**
     * @param btypeOtherContent the btypeOtherContent to set
     */
    public void setBtypeOtherContent(String btypeOtherContent) {
        this.btypeOtherContent = btypeOtherContent;
    }

    /**
     * @return the aexamOther
     */
    public String getAexamOther() {
        return aexamOther;
    }

    /**
     * @param aexamOther the aexamOther to set
     */
    public void setAexamOther(String aexamOther) {
        this.aexamOther = aexamOther;
    }

	// Property accessors
	

}