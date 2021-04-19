package com.weitu.mpsplatform.commons.utils;

import com.weitu.mpsplatform.commons.constants.SaasPlatConstants;
import com.weitu.mpsplatform.commons.exception.JudicialException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.net.URLEncoder;

/**
 * 腾讯云工具类
 */
public class TencentCloudUtils {
    private static final Logger log = LoggerFactory.getLogger(TencentCloudUtils.class);

    private TencentCloudUtils() {

    }

    /**
     * 实时音视频streamId计算
     * 参考文档地址：https://cloud.tencent.com/document/product/647/16826
     * @param SDKAppid  实时音视频应用ID
     * @param roomNo    房间号
     * @param userId    用户ID
     * @param streamType    流类型
     * @return
     */
    public static String TRTCStreamIdCalculate(BigInteger SDKAppid, String roomNo, String userId, String streamType) {
        String inputStreamId = null;
        try {
            if (SString.isNotBlank(SString.getTrimString(SDKAppid))
                    && SString.isNotBlank(SString.getTrimString(roomNo))
                    && SString.isNotBlank(SString.getTrimString(userId))
                    && SString.isNotBlank(SString.getTrimString(streamType))) {
                StringBuffer stringBuffer = new StringBuffer(SDKAppid.toString())
                        .append(SaasPlatConstants.Symbol.SYMBOL_UNDER_LINE).append(roomNo)
                        .append(SaasPlatConstants.Symbol.SYMBOL_UNDER_LINE).append(userId)
                        .append(SaasPlatConstants.Symbol.SYMBOL_UNDER_LINE).append(streamType);
                inputStreamId = URLEncoder.encode(stringBuffer.toString());
            }
        } catch (Exception e) {
            log.error("输入流ID计算失败， userId = {}, 失败原因：{}", userId, e);
            throw new JudicialException("输入流ID计算失败");
        }
        return inputStreamId;
    }
}
