package com.weitu.mpsplatform.commons.utils;


import com.weitu.mpsplatform.commons.exception.SysException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SMD5 {

    public static byte[] encryptToByte(String str) {
        // 加密之后所得字节数组
        byte[] bytes = null;
        try {
            // 获取MD5算法实例 得到一个md5的消息摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //添加要进行计算摘要的信息
            md.update(str.getBytes());
            //得到该摘要
            bytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new SysException(e);
        }
        return null == bytes ? null : bytes;
    }

    public static String encrytpToString(String str) {
        byte[] bytes=encryptToByte(str);
        StringBuffer sb = new StringBuffer();
        for (byte aByte : bytes) {
            String s = Integer.toHexString(0xff & aByte);
            if (s.length() == 1) {
                sb.append("0" + s);
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}