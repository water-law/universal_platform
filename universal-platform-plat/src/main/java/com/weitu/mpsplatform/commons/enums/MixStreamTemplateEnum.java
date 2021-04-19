package com.weitu.mpsplatform.commons.enums;


import java.math.BigInteger;

/**
 * 混流枚举模板
 */
public enum MixStreamTemplateEnum {
    /**
     * 双人模板
     */
    TWO(2, new BigInteger("10")),
    /**
     * 三人模板
     */
    THREE(3, new BigInteger("310")),
    /**
     * 四人模板
     */
    FOUR(4, new BigInteger("410")),
    /**
     * 五人模板
     */
    FIVE(5, new BigInteger("510")),
    /**
     * 六人模板
     */
    SIX(6, new BigInteger("610"));
    /**
     * 人数
     */
    private Integer count;
    /**
     * 模板ID
     */
    private BigInteger templateId;

    MixStreamTemplateEnum(Integer count, BigInteger templateId) {
        this.count = count;
        this.templateId = templateId;
    }

    /**
     * 通过人数获取模板
     * @param count
     * @return
     */
    public static BigInteger getTemplateIdByCount(Integer count) {
        if (count == null) {
            return new BigInteger("0");
        }
        for(MixStreamTemplateEnum enums : MixStreamTemplateEnum.values()) {
            if (enums.count.equals(count)) {
                return enums.templateId;
            }
        }
        return new BigInteger("0");
    }

}
