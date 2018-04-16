package com.bofan.publichealth.service;



/**
 * 老年人 中医健康评估 体质  
 * @Description: 
 * @author lqw
 */
public class Corporeity{
    
    /** 体质类型 */
    private String corporeityType ;
    /** 体质得分 */
    private Integer score ;
    /** 体质归属 ： 是 、 偏向是、 否 */
    private String belong ; 
    
    
    /** default construction*/
    public Corporeity() {
    }
    
    /**
     * @param corporeityType
     * @param score
     * @param belong
     */
    public Corporeity(String corporeityType, Integer score, String belong) {
        this.corporeityType = corporeityType;
        this.score = score;
        this.belong = belong;
    }

    /**
     * @return corporeityType
     */
    public String getCorporeityType() {
        return corporeityType;
    }
    /**
     * @param corporeityType 要设置的 corporeityType
     */
    public void setCorporeityType(String corporeityType) {
        this.corporeityType = corporeityType;
    }
    /**
     * @return score
     */
    public Integer getScore() {
        return score;
    }
    /**
     * @param score 要设置的 score
     */
    public void setScore(Integer score) {
        this.score = score;
    }
    /**
     * @return belong
     */
    public String getBelong() {
        return belong;
    }
    /**
     * @param belong 要设置的 belong
     */
    public void setBelong(String belong) {
        this.belong = belong;
    }
}
