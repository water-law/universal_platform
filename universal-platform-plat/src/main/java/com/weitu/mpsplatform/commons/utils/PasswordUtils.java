package com.weitu.mpsplatform.commons.utils;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


/**
 *     登录密码处理
 * @author
 */
public class PasswordUtils {

    /**
     * 数字、小写字母、大写字母正则表达式
     */
    public static final String NUMBER_LOWERCASE_UPPERCASE_REGULAR = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9]{3,18}";

    /**
     * 数字、大小写字母 字符数组(增加数字所占比例，提高产生密码速度)
     */
    private static final char[] ALLSTR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9','0', '1', '2', '3', '4', '5', '6', '7', '8', '9','0', '1', '2', '3', '4', '5', '6', '7', '8', '9','0', '1', '2', '3', '4', '5', '6', '7', '8', '9','0', '1', '2', '3', '4', '5', '6', '7', '8', '9','0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private PasswordUtils() {

    }

    /**
             *     对密码做加密操作
     * @param password  密码明文
     * @param salt  加盐
     * @return
     * @throws NoSuchAlgorithmException
     * @throws GeneralSecurityException
     */
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
          if (i < 0) {
            i += 256;
          }
          if (i < 16) {
            buf.append("0");
          }
          buf.append(Integer.toHexString(i));
        }
        return buf.toString();
    }

    /**
     * 产生length位的随机密码，满足：
     * 1.密码包含大写字母、小写字母和数字组合
     * 2.数字部分不能包含连续3位及以上相同或串联，如包含abc、DCB、321、aaa、222、123
     * 3.密码长度在3~18之间
     *
     * @param length
     * @return
     */
    public static String getRondomPwd(int length) {
        if (length < 3) {
            return null;
        }
        Random random = new Random();
        String result = "";
        while (!isContainNumberLowUpWord(result, 6)) {
            result = "";
            for (int i = 0; i < length - 2; i++) {
                result += ALLSTR[random.nextInt(ALLSTR.length)];
                if (result.length() >= 3) {
                    i = result.length() - 3;
                    if (isDifferOneFromThreeChar(result.substring(i, (i + 3)))) {
                        result = result.substring(0, result.length() - 3);
                    }
                } else {
                    i--;
                }
            }
        }
        return result;
    }

    /**
     * 校验3个字符之间均相差1或0
     *
     * @param str
     * @return
     */
    private static boolean isDifferOneFromThreeChar(String str) {
        if (str.length() != 3) {
            return false;
        }
        return (Integer.valueOf(Integer.toOctalString(str.charAt(1))) - Integer.valueOf(Integer.toOctalString(str.charAt(0))) == 1
                && Integer.valueOf(Integer.toOctalString(str.charAt(2))) - Integer.valueOf(Integer.toOctalString(str.charAt(1))) == 1)
                || (Integer.valueOf(Integer.toOctalString(str.charAt(1))) - Integer.valueOf(Integer.toOctalString(str.charAt(0))) == -1
                && Integer.valueOf(Integer.toOctalString(str.charAt(2))) - Integer.valueOf(Integer.toOctalString(str.charAt(1))) == -1)
                || (Integer.valueOf(Integer.toOctalString(str.charAt(1))) - Integer.valueOf(Integer.toOctalString(str.charAt(0))) == 0
                && Integer.valueOf(Integer.toOctalString(str.charAt(2))) - Integer.valueOf(Integer.toOctalString(str.charAt(1))) == 0);
    }

    /**
     * 判断str是否包含numberCount个数字、大小写字母
     * @param str
     * @param numberCount 应包含数字个数
     * @return
     */
    private static boolean isContainNumberLowUpWord(String str, int numberCount) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return str.matches(NUMBER_LOWERCASE_UPPERCASE_REGULAR) && getNumberCount(str) >= numberCount;
    }

    /**
     * 获取str包含数字的个数
     * @param str
     * @return
     */
    private static int getNumberCount(String str){
        int result = 0;
        for (int i = 0;i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println(getRondomPwd(8));
        }
        long end1 = System.currentTimeMillis();
        System.out.println("花费时间" + (end1 - start1) + "ms");
    }

}
