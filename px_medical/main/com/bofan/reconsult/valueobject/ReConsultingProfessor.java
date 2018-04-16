package com.bofan.reconsult.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;


/**
 * re_consulting_professor（会诊专家对照表）
 */
@Entity
@Table(name = "RE_CONSULTING_PROFESSOR" ,schema = SchemaConsts.REMOTE_CONSULT)
@SequenceGenerator(name = "RE_CONSULTING_PROFESSOR_ID", sequenceName = SchemaConsts.REMOTE_CONSULT + ".RE_CONSULTING_PROFESSOR_ID", allocationSize = 1)
public class ReConsultingProfessor  implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7470167249770239479L;
    // Fields    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RE_CONSULTING_PROFESSOR_ID")
    @Column(name = "CONSULTING_PROFESSOR_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long consultingProfessorId;
    
    /** 专家ID  */
    @Column(name="PROFESSOR_ID", unique = true, nullable = false, precision = 18, scale = 0)
    private Long professorId ;
    
    /** 专家名字  */
    @Column(name="DOCTOR_NAME", unique = true, length = 20)
    private String doctorName;
    
    /** 远程会诊ID */
    @Column(name="RE_CONSULTING_ID", nullable=false, length=20)
    private Long reConsultingId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RE_CONSULTING_ID", insertable = false, updatable = false)
    private ReConsulting consulting;
    
    /** 是否与会1：是;0：否  */
    @Column(name="JOIN_FLAG", nullable=false, length=1)
    private String joinFlag;
    
    /** 诊断意见 */
    @Column(name="PERSON_OPINION", length=20)
    private String personOpinion;

    /**
     * 
     */
    public ReConsultingProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the consultingProfessorId
     */
    public Long getConsultingProfessorId() {
        return consultingProfessorId;
    }

    /**
     * @param consultingProfessorId the consultingProfessorId to set
     */
    public void setConsultingProfessorId(Long consultingProfessorId) {
        this.consultingProfessorId = consultingProfessorId;
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
	 * @return the reConsultingId
	 */
	public Long getReConsultingId() {
		return reConsultingId;
	}

	/**
	 * @param reConsultingId the reConsultingId to set
	 */
	public void setReConsultingId(Long reConsultingId) {
		this.reConsultingId = reConsultingId;
	}

	/**
     * @return the consulting
     */
    public ReConsulting getConsulting() {
        return consulting;
    }

    /**
     * @param consulting the consulting to set
     */
    public void setConsulting(ReConsulting consulting) {
        this.consulting = consulting;
    }

    /**
     * @return the joinFlag
     */
    public String getJoinFlag() {
        return joinFlag;
    }

    /**
     * @param joinFlag the joinFlag to set
     */
    public void setJoinFlag(String joinFlag) {
        this.joinFlag = joinFlag;
    }

    /**
     * @return the personOpinion
     */
    public String getPersonOpinion() {
        return personOpinion;
    }

    /**
     * @param personOpinion the personOpinion to set
     */
    public void setPersonOpinion(String personOpinion) {
        this.personOpinion = personOpinion;
    }

    
}