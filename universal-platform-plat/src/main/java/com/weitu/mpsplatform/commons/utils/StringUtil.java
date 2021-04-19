package com.weitu.mpsplatform.commons.utils;

import com.weitu.mpsplatform.commons.exception.BaseException;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * StringUtil
 * 
 * @author senhuaF-31049
 * @version $Id: StringUtil.java, v 0.1 2018年4月18日 下午3:46:41 senhuaF-31049 Exp $
 */
public class StringUtil {
    /**
     *  Pattern.compile("^(1)\\d{10}$")
     */
    private static Pattern MOBILE_NO_PATTERN = Pattern.compile("^(1)\\d{10}$");
    /**
     *  Pattern.compile("^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$")
     */
    private static Pattern CAR_NO_PATTERN = Pattern.compile("^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$");
    /**
     *  Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$")
     */
    private static Pattern PHONE_PATTERN_ONE = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
    /**
     *  Pattern.compile("^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$")
     */
    private static Pattern PHONE_PATTERN_TWO = Pattern.compile("^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$");
    /**
     *  Pattern.compile("^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(19[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\\d{8})?$")
     */
    private static Pattern PHONE_PATTERN_THREE = Pattern.compile("^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(19[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\\d{8})?$");
    /**
     *  Pattern.compile("^(0[0-9]{2,3}\\-)?([1-9][0-9]{6,7})$")
     */
    private static Pattern FIXED_LINE_PATTERN = Pattern.compile("^(0[0-9]{2,3}\\-)?([1-9][0-9]{6,7})$");
    /**
     *  Pattern.compile("(^\\d{5,15}$)|(^\\d{3}-\\d{5,8}$)|(^\\d{4}-\\d{5,8}$)|(^\\d{3,4}-\\d{3,4}-\\d{3,4}$)|(^\\d{3,4}-\\d{5,8},\\d{2,6}$)")
     */
    private static Pattern VALIDATE_PHONE_PATTERN = Pattern.compile("(^\\d{5,15}$)|(^\\d{3}-\\d{5,8}$)|(^\\d{4}-\\d{5,8}$)|(^\\d{3,4}-\\d{3,4}-\\d{3,4}$)|(^\\d{3,4}-\\d{5,8},\\d{2,6}$)");
    /**
     *  Pattern.compile("#\\{.*?\\}")
     */
    private static Pattern SQL_CONDITION_PATTERN = Pattern.compile("#\\{.*?\\}");
    
    /**
     *  Pattern.compile("^\\d+(\\.\\d+)?$")
     */
    private static Pattern IS_NUMBER_PATTERN = Pattern.compile("^\\d+(\\.\\d+)?$");
    /**
     *  Pattern.compile("^\\d+$")
     */
    private static Pattern IS_NUM_PATTERN = Pattern.compile("^\\d+$");
    
    /**
     * 随机数组
     */
    public static final String[] RANDOM_COUNT_ARRAY = { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D",
            "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
            "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z" };
    
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 阿拉伯数字转换成中文数字
     * 
     * @param nums
     * @return
     */
    public static String convertNums(int nums) {
        StringBuffer sbBuffer = new StringBuffer();
        String[] numStrs = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
        String inStr = String.valueOf(nums);
        for (int i = 0; i < inStr.length(); i++) {
            String index = String.valueOf(inStr.charAt(i));
            sbBuffer = sbBuffer.append(numStrs[Integer.parseInt(index)]);
        }
        return sbBuffer.toString();
    }

    /**
     * 计算字符串长度
     * 
     * @param s
     * @return
     */
    public static int length(String s) {
        if (s == null) {
            return 0;
        }
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!isLetter(c[i])) {
                len++;
            }
        }
        return len;
    }

    /**
     * 
     * @param str
     * @param size
     * @return
     */
    public static String alignRight(String str, int size) {
        return alignRight(str, size, ' ');
    }

    /**
     * 
     * @param str
     * @param size
     * @param padChar
     * @return
     */
    public static String alignRight(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }

        int pads = size - str.length();

        if (pads <= 0) {
            return str;
        }

        return alignRight(str, size, String.valueOf(padChar));
    }

    /**
     * 
     * @param str
     * @param size
     * @param padStr
     * @return
     */
    public static String alignRight(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }

        if ((padStr == null) || (padStr.length() == 0)) {
            padStr = " ";
        }

        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;

        if (pads <= 0) {
            return str;
        }

        if (pads == padLen) {
            return padStr.concat(str);
        }
        if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        }
        char[] padding = new char[pads];
        char[] padChars = padStr.toCharArray();

        for (int i = 0; i < pads; ++i) {
            padding[i] = padChars[(i % padLen)];
        }

        return new String(padding).concat(str);
    }

    /**
     * 判断是否为英文字符
     * 
     * @param c
     * @return
     */
    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }

    /**
    * 手机号判断
    * 
    * @param mobiles
    * @return
    */
    public static boolean isMobileNO(String mobiles) {
        Matcher m = MOBILE_NO_PATTERN.matcher(mobiles);

        return m.matches();

    }
    
    
    /**
     * 判断字符串是否为URL
     * @param urls 用户头像key
     * @return true:是URL、false:不是URL
     */
    public static boolean isHttpUrl(String urls) {
        boolean isurl = false;
        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
            + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";//设置正则表达式

        //比对
        Pattern pat = Pattern.compile(regex.trim());
        Matcher mat = pat.matcher(urls.trim());
        //判断是否匹配
        isurl = mat.matches();
        if (isurl || urls.toLowerCase().startsWith("https:") || urls.toLowerCase().startsWith("http:")
                || urls.toLowerCase().startsWith("wxfile:")) {
            isurl = true;
        }
        return isurl;
    }
 
    /**
     * 手机号判断
     * 
     * @param carNo
     * @return
     */
    public static boolean isCarNO(String carNo) {
        Matcher m = CAR_NO_PATTERN.matcher(carNo);
        return m.matches();
    }
    
    public static boolean isPhoneNo (String mobileNo){
        Matcher matcher = PHONE_PATTERN_ONE.matcher(mobileNo);
        if(!matcher.matches()){
            matcher = PHONE_PATTERN_TWO.matcher(mobileNo);
        }
        return matcher.matches();
    }
    
    /**
	 * 验证是否是手机号码
	 *
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str) {
		if (SString.isBlank(SString.getTrimString(str))){
			return false;
		}
		Matcher matcher = PHONE_PATTERN_THREE.matcher(str);
		boolean b = matcher.matches();
		return b;
	}

	/**
	 * 是否是座机电话号码
	 *
	 * @param str
	 * @return
	 */
	public static boolean isFixedLine(String str) {
		if (SString.isBlank(SString.getTrimString(str))){
			return false;
		}
		Matcher matcher = FIXED_LINE_PATTERN.matcher(str);
		boolean b = matcher.matches();
		return b;
	}
	
	/**
	 * 校验手机或者电话号码格式是否正确
	 *    
	 * @param checkType 校验类型：0校验手机号码，1校验座机号码，2两者都校验满足其一就可
	 * @param phoneNum
	 */
	public static boolean validPhoneNum(String checkType, String phoneNum) {
		boolean flag = false;
		Matcher m = null;
		if ("0".equals(checkType)) {
			if (phoneNum.length() != 11) {
				return false;
			} else {
				m = PHONE_PATTERN_THREE.matcher(phoneNum);
				flag = m.matches();
			}
		} else if ("1".equals(checkType)) {
			if (phoneNum.length() < 11 || phoneNum.length() >= 16) {
				return false;
			} else {
				m = FIXED_LINE_PATTERN.matcher(phoneNum);
				flag = m.matches();
			}
		} else if ("2".equals(checkType)) {
			if (!((phoneNum.length() == 11 && PHONE_PATTERN_THREE.matcher(phoneNum).matches())
					|| (phoneNum.length() < 16 && FIXED_LINE_PATTERN.matcher(phoneNum).matches()))) {
				return false;
			} else {
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * 校验手机或者电话号码格式是否正确
	 *    
	 * @param phoneNum
	 */
	public static boolean validPhoneNum(String phoneNum) {
		boolean flag = false;
		if (SString.isBlank(SString.getTrimString(phoneNum))){
			return false;
		}
		Matcher matcher = VALIDATE_PHONE_PATTERN.matcher(phoneNum);
		flag = matcher.matches();
		return flag;
	}
    
    /**
     * 时间转换成string
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 1900基础上添加时间天数
     * 
     * @param days
     * @return
     */
    public static String getAddDays(int days) {
        String timeStr = "";
        try {
            Calendar c = new GregorianCalendar(1900, 0, -1);
            Date date = c.getTime();
            Date d = DateUtils.addDays(date, days);
            timeStr = d.toLocaleString();
        } catch (Exception e) {
            throw new BaseException(e);
        }
        return timeStr;
    }

    /**
     * 
     * @param days
     * @return
     */
    public static Date addDays(int days) {
        Date returnDate = null;
        try {
            Calendar c = new GregorianCalendar(1900, 0, -1);
            Date date = c.getTime();
            returnDate = DateUtils.addDays(date, days);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.format(returnDate);
        } catch (Exception e) {
            throw new BaseException(e);
        }
        return returnDate;
    }

    /**
     * 每3个字符插入逗号
     * 例如：
     * 005*(007-006)+101+102+103+11
     * 转成：005,007,006,101,102,103,11
     * 
     * @param inputStr
     * @return
     */
    public static String convertFromDigit(String inputStr) {
        String result = "";
        if (SString.isBlank(inputStr)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < inputStr.length(); i++) {
            char ch = inputStr.charAt(i);
            //过滤小数、百分比，只保留公式变量的code组合
            if (ch >= '0' && ch <= '9') {
                stringBuffer.append(ch);
            }
        }

        ////反转字符串位置
        //strBuff = stringBuffer.reverse().toString();
        String strBuff = stringBuffer.toString();
        for (int a = 0; a < strBuff.length(); a++) {
            if (a * 3 + 3 > strBuff.length()) {
                result += strBuff.substring(a * 3, strBuff.length());
                break;
            }
            result += new StringBuffer().append(strBuff.substring(a * 3, a * 3 + 3)).append(",");
        }
        //去除最后一个位置的逗号
        if (SString.isNotBlank(result) && result.endsWith(",")) {
            result = result.substring(0, result.length() - 1);
        }

        //System.err.println(new StringBuilder(result).reverse().toString()); 
        return result;
    }

    /**
     * 过滤字符串
     * 
     * @param oldStr
     * @return
     */
    public static String replaceSpecialStr(String oldStr) {
        if (SString.isBlank(oldStr)) {
            return "";
        }
        return SString.getTrimString(oldStr).replace(" ", "").replace("#", "").replace("{", "")
            .replace("}", "").replace("=", "").replace("'", "").replace(",", "").replace(":", "");
    }

    /**
     * 
     * 将从sql中获取检索条件的字段
     *     例如：select property_area from room_info where room_id=#{roomId}
     * 
     * @param sqlStr
     * @return
     */
    public static String getSqlConditions(String sqlStr) {
        if (SString.isBlank(sqlStr)) {
            return "";
        }
        String result = "";
        Matcher matcher = SQL_CONDITION_PATTERN.matcher(sqlStr);
        while (matcher.find()) {
            result += new StringBuffer().append(matcher.group()).append(",");
        }
        if (result.endsWith(",")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    /**
     * 追加sql条件的单引号
     * 
     * @param condition
     * @return
     */
    public static String setSqlColums(String condition) {
        if (SString.isBlank(condition)) {
            return "";
        }
        return new StringBuffer().append("'").append(condition).append("'").toString();
    }

    /**
     * 校验是否为正浮点数
     * 
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Matcher isNum = IS_NUMBER_PATTERN.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
    
    /**
     * 校验是否非负整数(正整数加0)
     * 
     * @param str
     * @return
     */
    public static boolean isNum(String str) {
        Matcher isNum = IS_NUM_PATTERN.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
    /**
     * 匹配表情符号
     * 
     * @param codePoint
     * @return
     */
    public static boolean isNotEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
               || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
               || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
               || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

    /** 
    * 过滤emoji 或者 其他非文字类型的字符 
    * @param source 
    * @return 
    */
    public static String filterEmoji(String source) {
        int len = source.length();
        StringBuilder buf = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (isNotEmojiCharacter(codePoint)) {
                buf.append(codePoint);
            } else {
                buf.append("*");
            }
        }
        return buf.toString();
    }
    
    /**
     * 检查指定的字符串列表是否不为空。
     */
    public static boolean areNotEmpty(String... values) {
        boolean result = true;
        if (values == null || values.length == 0) {
            result = false;
        } else {
            for (String value : values) {
                result &= !isEmpty(value);
            }
        }
        return result;
    }
    
    /**
     * 检查指定的字符串是否为空。
     * <ul>
     * <li>SysUtils.isEmpty(null) = true</li>
     * <li>SysUtils.isEmpty("") = true</li>
     * <li>SysUtils.isEmpty("   ") = true</li>
     * <li>SysUtils.isEmpty("abc") = false</li>
     * </ul>
     * 
     * @param value 待检查的字符串
     * @return true/false
     */
    public static boolean isEmpty(String value) {
        int strLen;
        if (value == null || (strLen = value.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(value.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
    /**
     * 生成随机8位不重复数字
     * 
     * @return
     */
    public static String generateNumber() {  
        String no="";  
        //初始化备选数组  
        int[] defaultNums = new int[10];  
        for (int i = 0; i < defaultNums.length; i++) {  
            defaultNums[i] = i;  
        }  
   
        Random random = new Random();  
        int[] nums = new int[LENGTH];  
        //默认数组中可以选择的部分长度  
        int canBeUsed = 10;  
        //填充目标数组  
        for (int i = 0; i < nums.length; i++) {  
            //将随机选取的数字存入目标数组  
            int index = random.nextInt(canBeUsed);  
            nums[i] = defaultNums[index];  
            //将已用过的数字扔到备选数组最后，并减小可选区域  
            swap(index, canBeUsed - 1, defaultNums);  
            canBeUsed--;  
        }  
        if (nums.length>0) {  
            for (int i = 0; i < nums.length; i++) {  
                no+=nums[i];  
            }  
        }  
   
        return no;  
    }
    
    private static final int LENGTH = 6;  
    
    private static void swap(int i, int j, int[] nums) {  
        int temp = nums[i];  
        nums[i] = nums[j];  
        nums[j] = temp;  
    }  
    
    public static String generateNumber2() {  
        String no="";  
        int num[]=new int[8];  
        int c=0;  
        for (int i = 0; i < 8; i++) {  
            num[i] = new Random().nextInt(10);  
            c = num[i];  
            for (int j = 0; j < i; j++) {  
                if (num[j] == c) {  
                    i--;  
                    break;  
                }  
            }  
        }  
        if (num.length>0) {  
            for (int i = 0; i < num.length; i++) {  
                no+=num[i];  
            }  
        }  
        return no;  
    }
    
    /**
     * Method description : 是否存在字符串
     *
     * Author：        zhiyic-35267                
     * Create Date：   2018年3月29日 上午10:18:09
     * History:  2018年3月29日 上午10:18:09   zhiyic-35267   Created.
     *
     * @param longString  
     * @param shortString 
     * @param delim 切分符
     * @return
     *
     */
    public static boolean isWordExist(String longString, String shortString, String delim) {
        StringTokenizer tokenizer = null;
        if (delim != null
        		&& !"".equals(delim)
        		&& !"null".equalsIgnoreCase(delim)) {
        	tokenizer = new StringTokenizer(longString, delim);
        } else {
        	tokenizer = new StringTokenizer(longString);
        }
        while (tokenizer.hasMoreTokens()) {
            String tempString = tokenizer.nextToken();
            if (shortString.equals(tempString)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 获取随机密码字符串
     * @author zhiyic
     * @return
     */
    public static String randomPassString(){
    	StringBuilder passString = null;
    	String retPass ="";
		do{
			passString = new StringBuilder();
			//生成随机密码
    		List passRandom = SRandom.getRandomListFromArray(RANDOM_COUNT_ARRAY, 6);
    		for (int i = 0; i < passRandom.size(); i++) {
    			passString.append(passRandom.get(i));
    		}
    		retPass = passString.toString();
		}while(!BaseCommonTools.validPwd(retPass));
		return retPass;
    }
    
    
    /**
     * （1）一小时内，显示为xx分钟前
     * （2）小于24小时，显示为xx小时前；
     * （3）间隔超过24小时，显示：昨天xx:xx；
     * （4）间隔超过48小时，显示：xx-xx xx:xx；
     * （5）间隔超过一年，显示：xxxx-xx-xx xx:xx
     * 
     * @param date
     * @return
     */
    public static final String formatDateForProd(Date date){
    	
    	return BaseHomeIdxDateTools.timeLogic(date);
//        if(date == null){
//            return "";
//        }
//        Date nowDate =new Date();
//        long timeDistance = nowDate.getTime() - date.getTime();
//        String result = "";
//        if(timeDistance <0 ){
//            result = SDateTime.format(date,null);
//        }else if(timeDistance >= 0 && timeDistance < 60*1000){
//            result ="刚刚";
//        }else if(timeDistance < 60*60*1000 && timeDistance >= 60*1000 ){
//            int min = (int) (timeDistance/1000/60);
//            result = min +"分钟前";
//            if(min == 0){
//                result ="刚刚";
//            }
//        }else if(timeDistance < 24*60*60*1000){
//            int hour = (int) (timeDistance/1000/60/60);
//            result = hour+"小时前";
//        }else if(timeDistance >= 24*60*60*1000 && timeDistance < 2*24*60*60*1000){
//            result = "昨天"+SDateTime.format(date, "HH:mm");
//        }else if(timeDistance >=  2*24*60*60*1000 && timeDistance < 365*24*60*60*1000L){
//            result = SDateTime.format(date, "MM-dd HH:mm");
//        }else{
//            result = SDateTime.format(date,null);
//        }
//        return result;
    }
    /**
     * 获取两个时间距离 天 小时 分
     * @author lingeng
     * @param endDate
     * @param nowDate
     * @return
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = Math.abs(endDate.getTime() - nowDate.getTime());
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        String result = "";
        if(day >0 ){
            result +=day + "天";
        }
        if(hour>0){
            result +=hour+"小时";
        }
        result += min + "分钟";
        return result;
    }
    
}