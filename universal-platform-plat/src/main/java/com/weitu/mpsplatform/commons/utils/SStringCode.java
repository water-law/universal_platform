package com.weitu.mpsplatform.commons.utils;

import com.weitu.mpsplatform.commons.exception.SysException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * 
 * @author 范森华
 * @version $Id: SStringCode.java, v 0.1 2016年10月24日 上午7:05:11 fansenhua Exp $
 */
public class SStringCode {
    private SStringCode(){
        
    }
    
    public static String encodeBase64String(byte[] data){
        return Base64.encodeBase64String(data);
    }
    
    public static byte[] decodeBase64(String base64String){
        return Base64.decodeBase64(base64String);
    }

    public static String safeUrlBase64Encode(byte[] data) {
        if(data==null) {
            return null;
        }
        String encodeBase64 = encodeBase64String(data);
        String safeBase64Str = encodeBase64.replace('+', '-');
        safeBase64Str = safeBase64Str.replace('/', '_');
        safeBase64Str = safeBase64Str.replaceAll("=", "");
        return safeBase64Str;
    }

    public static byte[] safeUrlBase64Decode(String safeBase64Str) {
        safeBase64Str=SString.getString(safeBase64Str);
        if(safeBase64Str.equals("")) {
            return safeBase64Str.getBytes();
        }
        String base64Str = safeBase64Str.replace('-', '+');
        base64Str = base64Str.replace('_', '/');
        int mod4 = base64Str.length() % 4;
        if (mod4 > 0) {
            base64Str = base64Str + "====".substring(mod4);
        }
        return decodeBase64(base64Str);
    }
    
    public static String hexEncode(byte[] data){
        return Hex.encodeHexString(data);
    }
    
    public static byte[] hexDecode(String hexString){
        try {
            return Hex.decodeHex(hexString.toCharArray());
        } catch (DecoderException e) {
            throw new SysException(e);
        }
    }
    
}
