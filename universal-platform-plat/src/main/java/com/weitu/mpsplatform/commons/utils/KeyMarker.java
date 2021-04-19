package com.weitu.mpsplatform.commons.utils;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author fsh
 */
public class KeyMarker {
    private KeyMarker() {

    }
    
    public static String getKey() {
        return SUUID.getUUID();
    }

    public static String getHash(String srcString) {
        return SMD5.encrytpToString(srcString);
    }

    public static String getHash(List<String> srcStrings) {
        StringBuilder srcStringBuilder = new StringBuilder();
        for (String src : srcStrings) {
            src = SString.getTrimString(src);
            if(src.equals("")){
                src="-";
            }
            srcStringBuilder.append(src + "|");
        }
        return getHash(srcStringBuilder.toString());
    }
    
    public static String getEncryptPassword(String password,String salt) throws NoSuchAlgorithmException,GeneralSecurityException{
        String encryptPassword = getEncryptPassword(password);
        return getEncryptPassword(encryptPassword+salt);
    }
    
    private static String getEncryptPassword(String text) throws NoSuchAlgorithmException,GeneralSecurityException{
        MessageDigest md = MessageDigest.getInstance("MD5");  
        md.update(text.trim().getBytes());
        byte b[] = md.digest();
        int i;
        StringBuffer buf = new StringBuffer("");
        for (int offset = 0; offset < b.length; offset++) {
          i = b[offset];
          if (i < 0)
            i += 256;
          if (i < 16)
            buf.append("0");
          buf.append(Integer.toHexString(i));
        }
        return buf.toString();
    }
    
    /**
     * 生成appId
     * 20位数字（时间随机数）：14位时间戳+6位数字随机数
     * 
     * @return
     */
    public static String genAppId(){
        return SRandom.getSeed(20);
    }

    public static void main(String[] args) {
        String l = "6b28e14df30d46baa11ac2e6e3589ce7";
        String d = "0423bff1026e11e8b87307962a1f241e";
        String s = "";
        String f = "10";

        List<String> list = new ArrayList<String>(Arrays.asList(l, d, s, f));
        System.out.println(getHash(list));
        System.err.println(genAppId().length());
    }
    
}
