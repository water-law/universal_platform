package com.weitu.mpsplatform.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @Description: yml文件工具类
 * @Author: senhuaF
 * @CreateDate: 2019/10/28 10:24
 * @Version 1.0
 **/
public class YamlConfigurerUtil {

    private static final Logger log = LoggerFactory.getLogger(YamlConfigurerUtil.class);

    private static Properties ymlProperties = new Properties();

    public YamlConfigurerUtil(Properties properties) {
        ymlProperties = properties;
    }

    /**
     * 功能描述: 根据Key获取yml文件的值-返回字符串值
     * @Author: senhuaF
     * @CreateDate: 2019/10/28 10:29
     * @Return:
     * @Version 1.0
     **/
    public static String getStrYmlVal(String key) {
        if (SString.isBlank(key)) {
            log.error("传入要获取Yml文件的Key值为空，请重新传入Key值,传入的key为:"+key);
            //throw new JudicialException("传入要获取Yml文件的Key值为空，请重新传入Key值!");
            return null;
        }
        return ymlProperties.getProperty(key);
    }
    /**
     * 功能描述: 根据Key获取yml文件的值-返回整数值
     * @Author: senhuaF
     * @CreateDate: 2019/10/28 10:29
     * @Return:
     * @Version 1.0
     **/
    public static Integer getIntegerYmlVal(String key) {
        if (SString.isBlank(key)) {
            log.error("传入要获取Yml文件的Key值为空，请重新传入Key值,传入的key为:"+key);
            //throw new JudicialException("传入要获取Yml文件的Key值为空，请重新传入Key值!");
            return null;
        }
        return Integer.valueOf(ymlProperties.getProperty(key));
    }
}
