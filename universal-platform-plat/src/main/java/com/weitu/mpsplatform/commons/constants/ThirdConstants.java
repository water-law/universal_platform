package com.weitu.mpsplatform.commons.constants;

/**
 * 第三方对接常量
 */
public class ThirdConstants {
    private ThirdConstants() {}

    public static class MeiyapicoConstants {
        /**
         * 响应参数-success
         */
        public static final String RESPONSE_PARAM_SUCCESS = "success";
        /**
         * 响应参数-data
         */
        public static final String RESPONSE_PARAM_DATA = "data";
        /**
         * 响应参数-data:success
         */
        public static final String RESPONSE_PARAM_DATA_SUCCESS = "success";
        /**
         * 响应参数-data:code
         */
        public static final String RESPONSE_PARAM_DATA_CODE = "code";
        /**
         * 响应参数-data:msg
         */
        public static final String RESPONSE_PARAM_DATA_MSG = "msg";
        /**
         * 响应值-成功
         */
        public static final Boolean RESPONSE_VALUE_SUCCESS = true;

    }

    /**
     * 远程调用请求参数
     */
    public static class RemoteRequestParamKey {
        /**
         * 请求数据
         */
        public static final String DATA = "data";
    }

}
