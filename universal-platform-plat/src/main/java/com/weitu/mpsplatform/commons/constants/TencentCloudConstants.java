package com.weitu.mpsplatform.commons.constants;

import java.math.BigInteger;

/**
 * 腾讯云相关常量类
 */
public class TencentCloudConstants {
    private TencentCloudConstants() {}

    /**
     * 实时音视频常量类
     */
    public static class TRTCStreamConstants {

        /**
         * 流类型-旁路直播默认值
         */
        public static final String STREAM_TYPE_MAIN = "main";
        /**
         * 流类型-自定义混流
         */
        public static final String STREAM_TYPE_SELF_MIX = "self_mix";
        /**
         * 输出流类型,当输出流为输入流 list 中的一条时，填写0。
         */
        public static final BigInteger OUTPUT_STREAM_TYPE_EXIST = new BigInteger("0");
        /**
         * 输出流类型,当期望生成的混流结果成为一条新流时，该值填为1。
         */
        public static final BigInteger OUTPUT_STREAM_TYPE_NEW = new BigInteger("1");
        /**
         * 图层标识号，背景流（即大主播画面或画布）的 image_layer 填1。
         */
        public static final BigInteger IMAGE_LAYER_BACKGROUND = new BigInteger("1");
    }
}
