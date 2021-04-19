package com.weitu.mpsplatform.common;

/**
 * 网关常量
 */
public class GateWayConstants {
    private GateWayConstants() {}

    /**
     * 响应消息枚举
     */
    public enum RespnseMsgEnum {
        /**
         * 登录成功
         */
        SUCCESS(200, "成功"),
        /**
         * 未登录
         */
        NOT_LOGIN(401, "登录超时或未登录，请重新登录"),
        /**
         * 帐号已登录
         */
        LOGIN_REPEAT(402, "此账号在其他地方登录，为了账号安全，建议您修改密码"),
        /**
         * 无访问权限
         */
        NOT_ACCESS(403, "无访问权限");
        /**
         * 状态码
         */
        private Integer stateCode;
        /**
         * 响应消息
         */
        private String responseMsg;

        RespnseMsgEnum(Integer stateCode, String responseMsg) {
            this.stateCode = stateCode;
            this.responseMsg = responseMsg;
        }

        public Integer getStateCode() {
            return stateCode;
        }

        public void setStateCode(Integer stateCode) {
            this.stateCode = stateCode;
        }

        public String getResponseMsg() {
            return responseMsg;
        }

        public void setResponseMsg(String responseMsg) {
            this.responseMsg = responseMsg;
        }

        /**
         * 通过状态码返回消息值
         * @param stateCode
         * @return
         */
        public static String getMsgByCode(Integer stateCode) {
            if (stateCode != null) {
                for (RespnseMsgEnum respnseMsgEnum : RespnseMsgEnum.values()) {
                    if (respnseMsgEnum.getStateCode() == stateCode) {
                        return respnseMsgEnum.getResponseMsg();
                    }
                }
            }
            return "";
        }
    }
}
