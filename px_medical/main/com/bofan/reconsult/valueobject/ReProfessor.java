package com.bofan.reconsult.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;


/**
 * re_professor（专家表）专家分系统内、系统外
 */
@Entity
@Table(name = "RE_PROFESSOR" ,schema = SchemaConsts.REMOTE_CONSULT)
public class ReProfessor  implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7470167249770239479L;
    // Fields    

    /** 主键ID对应云sys系统 的 sys_user_info 表  */
    @Id
    @Column(name = "PROFESSOR_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long professorId;
    
    /** 医生姓名 */
    @Column(name="DOCTOR_NAME", nullable=false, length=20)
    private String doctorName;
    
    /** 医生性别  */
    @Column(name="DOCTOR_SEX", nullable=false, length=1)
    private String doctorSex;
    
    /** 医生手机号 */
    @Column(name="DOCTOR_MOBILE_PHONE", length=20)
    private String doctorMobilePhone;
    
    /** 擅长（职业范围） */
    @Column(name="DOCTOR_GOODAT", length=100)
    private String doctorGoodat;
    
    /** 职务 */
    @Column(name="DOCTOR_POST", length=100)
    private String doctorPost;
    
    /** 级别 */
    @Column(name="DOCTOR_RANK", length=100)
    private String doctorRank;
    
    /** 医疗机构ID */
    @Column(name="HOSPITAL_ID", length=50)
    private String hospitalId;
    
    @Column(name="VALID_FLAG", nullable=false, length=1)
    private String validFlag;

    /**
     * 
     */
    public ReProfessor() {
        super();
    }

    /**
     * @return the professorId
     */
    public Long getProfessorId() {
        return professorId;
    }

    /**
     * @param professorId the professorId to set
     */
    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    /**
     * @return the doctorName
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * @param doctorName the doctorName to set
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * @return the doctorSex
     */
    public String getDoctorSex() {
        return doctorSex;
    }

    /**
     * @param doctorSex the doctorSex to set
     */
    public void setDoctorSex(String doctorSex) {
        this.doctorSex = doctorSex;
    }

    /**
     * @return the doctorMobilePhone
     */
    public String getDoctorMobilePhone() {
        return doctorMobilePhone;
    }

    /**
     * @param doctorMobilePhone the doctorMobilePhone to set
     */
    public void setDoctorMobilePhone(String doctorMobilePhone) {
        this.doctorMobilePhone = doctorMobilePhone;
    }

    /**
     * @return the doctorGoodat
     */
    public String getDoctorGoodat() {
        return doctorGoodat;
    }

    /**
     * @param doctorGoodat the doctorGoodat to set
     */
    public void setDoctorGoodat(String doctorGoodat) {
        this.doctorGoodat = doctorGoodat;
    }

    /**
     * @return the doctorPost
     */
    public String getDoctorPost() {
        return doctorPost;
    }

    /**
     * @param doctorPost the doctorPost to set
     */
    public void setDoctorPost(String doctorPost) {
        this.doctorPost = doctorPost;
    }

    /**
     * @return the doctorRank
     */
    public String getDoctorRank() {
        return doctorRank;
    }

    /**
     * @param doctorRank the doctorRank to set
     */
    public void setDoctorRank(String doctorRank) {
        this.doctorRank = doctorRank;
    }

    /**
     * @return the hospitalId
     */
    public String getHospitalId() {
        return hospitalId;
    }

    /**
     * @param hospitalId the hospitalId to set
     */
    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
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