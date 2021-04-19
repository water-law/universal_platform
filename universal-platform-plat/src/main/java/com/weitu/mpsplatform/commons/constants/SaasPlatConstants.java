package com.weitu.mpsplatform.commons.constants;

/**
 * 公共支撑常量类
 * 
 * @author fansenhua
 * @version $Id: SaasConstants.java, v 0.1 2016年9月19日 上午10:18:34 fansenhua Exp $
 */
public class SaasPlatConstants {
    private SaasPlatConstants() {

    }

    public static final String PROJECT_NAME="bigdata";

    /**
     * Description : 标识符号
     *
     * Author： zhiyiChen-35267 Create Date： 2017年1月12日 下午3:56:23
     *
     *
     */
    public static class Symbol {
        /**
         * 竖线拼接标识("|")
         */
        public static final String SYMBOL_VERTICAL_LINE_JOIN         = "|";

        /**
         * 竖线切分标识("\\|")
         */
        public static final String SYMBOL_VERTICAL_LINE_SPLIT        = "\\|";
        /**
         * 逗号标识(",")
         */
        public static final String SYMBOL_COMMA                      = ",";
        /**
         * 井号标识("#")
         */
        public static final String SYMBOL_POUND                      = "#";
        /**
         * 下划线标识("_")
         */
        public static final String SYMBOL_UNDER_LINE                 = "_";
        /**
         * 并列标识("&")
         */
        public static final String SYMBOL_COORDINATE                 = "&";
        /**
         * 百分号
         */
        public static final String SYMBOL_PERCENT                    = "%";

        /**
         * 短线标识("-")
         */
        public static final String SYMBOL_SHORT_LINE                 = "-";

        /**
         * 冒号标识(":")
         */
        public static final String SYMBOL_COLON                      = ":";

        /**
         * 波浪号标识("~")
         */
        public static final String SYMBOL_TILDE                      = "~";

        /**
         * 英文分号标识(";")
         */
        public static final String SYMBOL_SEMICOLON                  = ";";

        /**
         * 美元符号
         */
        public static final String SYMBOL_DOUBLE_DOLLAR              = "$$";

        public static final String DEFAULT_EQUAL                     = "=";
        public static final String DEFAULT_NULL                      = "null";
        public static final String DEFAULT_ZERO                      = "0";
        public static final String DEFAULT_ONE                       = "1.000000";
        public static final String DEFAULT_DOUBLE_DIGIT_ZERO         = "0.00";

        public static final double ZERO_VALUE                        = 0.0;

        public static final double DEFUALT_DOUBLE_ONE_VALUE          = 1.0;

        public static final int    DEFUALT_INT_ZERO_VALUE            = 0;
        public static final int    DEFUALT_INT_ONE_VALUE             = 1;
        public static final int    DEFUALT_INT_TWO_VALUE             = 2;

        public static final String BILLING_ORDER_NO_DEFAULT_SEQUENCE = "Z";
        public static final int    BILLING_ORDER_NO_DEFAULT_LENGTH   = 9;
        public static final String DEFAULT_NUMONE                    = "1";
        public static final String DEFAULT_FUNUMONE                  = "-1";

        public static final String SYMBOL_ADD                        = "+";
        public static final String SYMBOL_SUB                        = "-";
        public static final String SYMBOL_MUL                        = "*";
        public static final String SYMBOL_DIV                        = "/";
        public static final String SYMBOL_LEFT_BRACKETS              = "(";
        public static final String SYMBOL_RIGHT_BRACKETS             = ")";

        /**
         * 加号(+)转义
         */
        public static final String SYMBOL_ADD_TRANSFERRED            = "%2b";
        /**
         * Y英文标识（"/"）
         */
        public static final String SYMBOL_SLASH = "/";
        /**
         * 英文标识（"*"）
         */
        public static final String SYMBOL_ASTERISK = "*";
        /**
         * 英文标识（"="）
         */
        public static final String SYMBOL_EQUAL = "=";
    }

    /**
     * Description : 时间有效期
     *
     * Author： zhiyic-35267 Create Date： 2017年7月26日 上午10:54:40
     *
     *
     */
    public static class TimeExpirationInfo {
        /**
         * 有效时间 20年 ，单位：秒
         */
        public static final long EXPIRATION_TIME_TWENTY_YEARS = 20 * 365 * 24 * 60 * 60;
    }

    public static class Cache {
        /**
         * 缓存重载延迟时间，单位：毫秒
         */
        public static final long CACHE_RELOAD_DELAY_TIME         = 120000;

        /**
         * 缓存重载间隔时间，单位：毫秒
         */
        public static final long CACHE_RELOAD_TIME               = 300000;

        /**
         * 验证码存入缓冲有效时间，单位：秒
         */
        public static final int  VERIFICATION_KEY_CODE_TIME      = 1800;

        /**
         * REDIS缓存对象默认有效时间
         */
        public static final int  REDIS_CACHE_DEFAULT_RELOAD_TIME = 3600;

        /**
         * 设置小区缓存时间
         */
        public static final int  REDIS_CACHE_COMMUNITY_TIME      = 3600 * 10;
    }

    public static class MessageConstants {
        private MessageConstants() {

        }

        public static final String SYSTEM_ERROR_MESSAGE        = "系统繁忙，请重试！";
        
        public static final String ISNOT_PERMISSION = "无访问权限，请联系管理员授权！";

        public static final String SAVE_SUCCESS                = "保存成功";

        public static final String PARAM_IS_NULL               = "参数不能为空";

        public static final String DELETE_SUCCESS              = "删除成功";

        public static final String OPERATE_SUCCESS             = "操作成功";

        public static final String OPERATE_FAIL                = "操作失败";
    }

    /**
     * 自定义属性常量类
     */
    public static class CustomAttributeConstants {
        private CustomAttributeConstants() {

        }

        /**
         *  自定义属性-数据权限级别
         */
        public static final String REQUEST_ATTRIBUTE_MENU_DATA_LEVEL = "custom_menu_data_level";

    }

}
