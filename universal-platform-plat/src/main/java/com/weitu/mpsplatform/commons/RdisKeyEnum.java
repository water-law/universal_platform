package com.weitu.mpsplatform.commons;

/**
 * @Description 缓存枚举
 * @Author: 范森华
 * @Date 2019/7/5 17:55
 * @Param
 * @return
 **/
public enum RdisKeyEnum {

    TOKEN("token","MPS_TOKEN_");

    public final String describe;
    public final String content;


    RdisKeyEnum(String describe, String content){
        this.describe = describe;
        this.content = content;
    }
}
