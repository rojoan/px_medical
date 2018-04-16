package com.bofan.publichealth.gravida.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bofan.utils.SchemaConsts;
/**
 * @Description: 孕妇辅助检查项目表
 * @author lqw
 */
@Entity
@Table(name = "PREGNANCY_EXAM_ITEM", schema = SchemaConsts.PUBLIC_HEALTH )
@SequenceGenerator(name = "PREGNANCY_EXAM_ITEM_ID", sequenceName = SchemaConsts.PUBLIC_HEALTH + ".PREGNANCY_EXAM_ITEM_ID", allocationSize = 1)
public class PregnancyExamItem {
    
    /** 孕检辅助检查项目ID，自动增长ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREGNANCY_EXAM_ITEM_ID")
    @Column(name = "PREGNANCY_EXAM_ITEM_ID", unique = true, nullable = false, precision = 18, scale = 0)
	private Long pregnancyExamItemId;
	
    /** 孕检项目类型 辅助检查使用01=血常规02=尿常规03=血型04=血糖05=肝功能06=肾功能07=阴道分泌物08=乙型肝炎五项09=梅毒血清学实验10=HIV抗体检测11=B超12=其他 */
    @Column(name = "EXAM_ITEM_TYPE", nullable = false, length = 2)
	private String examItemType;
	
    /** 孕检项目名称 */
    @Column(name = "EXAM_ITEM_NAME", nullable = false, length = 80)
	private String examItemName;
	
    /** 检测单位 */
    @Column(name = "EXAM_ITEM_UNIT", length = 20)
	private String examItemUnit;
    
    /** 是否有效 1=有效 0=无效 */
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
    private String validFlag;

	/** default constructor */
	public PregnancyExamItem() {
	}

    /**
     * @return pregnancyExamItemId
     */
    public Long getPregnancyExamItemId() {
        return pregnancyExamItemId;
    }

    /**
     * @param pregnancyExamItemId 要设置的 pregnancyExamItemId
     */
    public void setPregnancyExamItemId(Long pregnancyExamItemId) {
        this.pregnancyExamItemId = pregnancyExamItemId;
    }

    /**
     * @return examItemType
     */
    public String getExamItemType() {
        return examItemType;
    }

    /**
     * @param examItemType 要设置的 examItemType
     */
    public void setExamItemType(String examItemType) {
        this.examItemType = examItemType;
    }

    /**
     * @return examItemName
     */
    public String getExamItemName() {
        return examItemName;
    }

    /**
     * @param examItemName 要设置的 examItemName
     */
    public void setExamItemName(String examItemName) {
        this.examItemName = examItemName;
    }

    /**
     * @return examItemUnit
     */
    public String getExamItemUnit() {
        return examItemUnit;
    }

    /**
     * @param examItemUnit 要设置的 examItemUnit
     */
    public void setExamItemUnit(String examItemUnit) {
        this.examItemUnit = examItemUnit;
    }

    /**
     * @return validFlag
     */
    public String getValidFlag() {
        return validFlag;
    }

    /**
     * @param validFlag 要设置的 validFlag
     */
    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

}