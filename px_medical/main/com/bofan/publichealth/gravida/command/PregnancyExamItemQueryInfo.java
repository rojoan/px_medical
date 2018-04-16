package com.bofan.publichealth.gravida.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;
import com.bofan.infoql.QueryOperator;
import com.bofan.infoql.QueryParam;

/**
 * @Description: 孕妇辅助检查项目表
 * @author lqw
 */
@QueryInfo( from = "com.bofan.publichealth.gravida.valueobject.PregnancyExamItem p ",  orderBy = "p.pregnancyExamItemId asc")
public class PregnancyExamItemQueryInfo extends BaseCommandInfo {

    private static final long serialVersionUID = 5325328913404493199L;
    
    /** 孕检项目类型 辅助检查使用01=血常规02=尿常规03=血型04=血糖05=肝功能06=肾功能07=阴道分泌物08=乙型肝炎五项09=梅毒血清学实验10=HIV抗体检测11=B超12=其他 */
    @QueryParam(fieldName = "examItemType", op = QueryOperator.EQU)
    private String examItemType;

    /** default constructor */
    public PregnancyExamItemQueryInfo() {
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
}