package com.weitu.mpsplatform.commons.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**  
 * 数字格式化工具类.<br>  
 */  
public abstract class NumberUtils {   
    /**  
     * 按指定的样式格式化数字.<br>  
     * 例如:  
     * <li><code>format(1,"#0.000")</code>,结果1.000  
     * <li><code>format(1.165686,"#0.000")</code>,结果1.166  
     * <li><code>format(0,"#0.00")</code>,结果0.00  
     * <li><code>format(0.2556,"#0.00%")</code>,结果25.56%  
     * <li><code>format(1,"#0%")</code>,结果100%  
     * @param d double  
     * @param pattern 格式化字符串. 如:#0.000(带三位小数点,四舍五入)  
     * @return  
     */  
    public static String format(double d, String pattern) {   
        DecimalFormat nf = new DecimalFormat(pattern);   
        return nf.format(d);   
    }   
  
    /**  
     * {@link #format(double, String)}.  
     * @param doubleStr  
     * @param pattern  
     * @return  
     */  
    public static String format(String doubleStr, String pattern) {   
        double d = 0;   
        try {   
            d = Double.parseDouble(doubleStr);   
        } catch (NumberFormatException e) {   
            System.out.println("字符串转换成数字有异常!  doubleStr=" + doubleStr);   
        }   
        return format(d, pattern);   
    }   
  
    /**  
     * 和 {@link #format(double, String)}相似,区别在于返回值增加了一个html的空格字符(&nbsp;).  
     * @param d  
     * @param pattern  
     * @return 返回值增加了一个html格式的空格符(&nbsp;).  
     */  
    public static String formatWithBlank(double d, String pattern) {   
        return format(d, pattern) + "&nbsp;";   
    }   
  
    /**  
     * {@link #formatWithBlank(double, String)}  
     * @param doubleStr  
     * @param pattern  
     * @return  
     */  
    public static String formatWithBlank(String doubleStr, String pattern) {   
        double d = 0;   
        try {   
            d = Double.parseDouble(doubleStr);   
        } catch (NumberFormatException e) {   
            System.out.println("字符串转换成数字有异常!  doubleStr=" + doubleStr);   
        }   
        return formatWithBlank(d, pattern);   
    }   
  
    /**  
     * 给数字字符后增加一个html格式的空格符(&nbsp;);<br>  
     * 用途:在将html页面导出excel格式时,excel会默认将数字字符串转换成数字,这样会导致字符串前后的00被清掉.  
     * 调用此方法,增加了一个空格字符后,可以避免excel的自动转换. 如:1.200,excel会自动转换成1.2;  
     * 00012,excel会自动转换成12;  
     * @param numStr 数字字符串  
     * @return  
     */  
    public static String addBlank(String numStr) {   
        return numStr + "&nbsp;";   
    }
    
    /***
     * 
     * 方法说明：将一个数字转换亿或万为单位
     *
     * Author：        senhuaF-31049                
     * Create Date：   2017年12月24日 下午10:06:58
     * History:  2017年12月24日 下午10:06:58   senhuaF-31049   Created.
     *
     * @param num
     * @return
     *
     */
    public static String getname(double num) {
    	String rtlString = "";
    	if (num < 10000) {
    		if(num > -100000000){
    			double f = (double) num / 10000;
    			double m = setScale(2,f);
    			rtlString = m + "万";
    			//System.out.println("输入的数字为：" + m + "万");
    		}else {
    			double f = (double) (num / 100000000);
    			double m = setScale(2,f);
    			rtlString = m + "亿";
    			//System.out.println("输入的数字为：" + m + "亿");
			}
		} else if (num < 100000000 ) {
			double f = (double) num / 10000;
			double m = setScale(2,f);
			rtlString = m + "万";
			//System.out.println("输入的数字为：" + m + "万");
		} else if (num >= 100000000) {
			double f = (double) (num / 100000000);
			double m = setScale(2,f);
			rtlString = m + "亿";
			//System.out.println("输入的数字为：" + m + "亿");
		}
		return rtlString;
	}
    
    /***
     * 
     * 方法说明：将一个数字转换亿为单位
     *
     * Author：        senhuaF-31049                
     * Create Date：   2017年12月24日 下午10:06:58
     * History:  2017年12月24日 下午10:06:58   senhuaF-31049   Created.
     *
     * @param num
     * @return
     *
     */
    public static String getNotName(double num) {
    	String rtlString = "";
//    	if (num < 10000) {
//			double f = (double) num / 10000;
//			double m = setScale(2,f);
//			rtlString = m + "";
//			//System.out.println("输入的数字为：" + m + "万");
//		} else {
//			double f = (double) num / 10000;
//			double m = setScale(2,f);
//			rtlString = m + "";
//			//System.out.println("输入的数字为：" + m + "万");
//		}
		double f = (double) (num / 100000000);
		double m = setScale(2,f);
		rtlString = m + "";
		//System.out.println("输入的数字为：" + m + "亿");
		return rtlString;
	}
    
    /**
     * 
     * 方法说明：保留几位小数
     *
     * Author：        senhuaF-31049                
     * Create Date：   2017年12月24日 下午10:05:14
     * History:  2017年12月24日 下午10:05:14   senhuaF-31049   Created.
     *
     * @param s 保存几位小数
     * @param f 要转的数字
     * @return
     *
     */
    public static double setScale(int s,double f){
    	BigDecimal b = new BigDecimal(f);
		double m = b.setScale(s,BigDecimal.ROUND_HALF_UP).doubleValue();
		return m;  
    }
    
    private static final Double MILLION = 10000.0;
    private static final Double MILLIONS = 1000000.0;
    private static final Double BILLION = 100000000.0;
    private static final String MILLION_UNIT = "万";
    private static final String BILLION_UNIT = "亿";
    
    /**
     * 通过反射修改对象字段值
     * 
     * @author senhuaF-31049
     * @param c
     * @return
     */
    public static <T> T updateObjectFieldValue(T c){
        try {
            Field[] fields = c.getClass().getDeclaredFields();
            DecimalFormat df = new DecimalFormat("#.00");
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                //String fieldName = field.getName();
                // 获取具体值
                field.setAccessible(true);
                // 其余情况根据类型赋值
                String fieldClassName = field.getType().getSimpleName();
                //System.out.println(fieldName + " : " + fieldClassName);
                if (fieldClassName.equalsIgnoreCase("double")) {
                    // 获取字段值
                    Object fieldValue=field.get(c);
                    if (fieldValue != null) {
                        field.set(c, new Double(df.format(fieldValue)));
                    }
                } else if (fieldClassName.equalsIgnoreCase("BigDecimal")) {
                    // 获取字段值
                    Object fieldValue=field.get(c);
                    if (fieldValue != null) {
                        field.set(c,  new BigDecimal(df.format(fieldValue)));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    
    /**
     * 将数字转换成以万为单位或者以亿为单位，因为在前端数字太大显示有问题
     *
     * @author
     * @version 1.00.00
     *
     * @date 2018年1月18日
     * @param number 数字
     * @return
     */
    public static String numberConversion(double number){
        //最终返回的结果值
        String result = String.valueOf(number);
        //四舍五入后的值
        double value = 0;
        //转换后的值
        double tempValue = 0;
        //余数
        double remainder = 0;
        
        //金额大于1百万小于1亿
        if(number > MILLIONS && number < BILLION){
            tempValue = number/MILLION;
            remainder = number%MILLION;
            //log.info("tempValue=" + tempValue + ", remainder=" + remainder);
            
            //余数小于5000则不进行四舍五入
            if(remainder < (MILLION/2)){
                value = formatNumber(tempValue,2,false);
            }else{
                value = formatNumber(tempValue,2,true);
            }
            //如果值刚好是10000万，则要变成1亿
            if(value == MILLION){
                result = zeroFill(value/MILLION) + BILLION_UNIT;
            }else{
                result = zeroFill(value);
            }
        }
        //金额大于1亿
        else if(number > BILLION){
            tempValue = number/BILLION;
            remainder = number%BILLION;
            //log.info("tempValue=" + tempValue + ", remainder=" + remainder);
            
            //余数小于50000000则不进行四舍五入
            if(remainder < (BILLION/2)){
                value = formatNumber(tempValue,2,false);
            }else{
                value = formatNumber(tempValue,2,true);
            }
            result = zeroFill(value);
        }else{
            result = zeroFill(number);
        }
        //log.info("result=" + result);
        return result;
    }
    
    /**
     * 将数字转换成以万为单位或者以亿为单位，因为在前端数字太大显示有问题
     *
     * @author
     * @version 1.00.00
     *
     * @date 2018年1月18日
     * @param amount 报销金额
     * @return
     */
    public static String amountConversion(double amount){
        //最终返回的结果值
        String result = String.valueOf(amount);
        //四舍五入后的值
        double value = 0;
        //转换后的值
        double tempValue = 0;
        //余数
        double remainder = 0;
        
        //金额大于1百万小于1亿
        if(amount > MILLIONS && amount < BILLION){
            tempValue = amount/MILLION;
            remainder = amount%MILLION;
            //log.info("tempValue=" + tempValue + ", remainder=" + remainder);
            
            //余数小于5000则不进行四舍五入
            if(remainder < (MILLION/2)){
                value = formatNumber(tempValue,2,false);
            }else{
                value = formatNumber(tempValue,2,true);
            }
            //如果值刚好是10000万，则要变成1亿
            if(value == MILLION){
                result = zeroFill(value/MILLION) + BILLION_UNIT;
            }else{
                result = zeroFill(value) + MILLION_UNIT;
            }
        }
        //金额大于1亿
        else if(amount > BILLION){
            tempValue = amount/BILLION;
            remainder = amount%BILLION;
            //log.info("tempValue=" + tempValue + ", remainder=" + remainder);
            
            //余数小于50000000则不进行四舍五入
            if(remainder < (BILLION/2)){
                value = formatNumber(tempValue,2,false);
            }else{
                value = formatNumber(tempValue,2,true);
            }
            result = zeroFill(value) + BILLION_UNIT;
        }else{
            result = zeroFill(amount);
        }
        //log.info("result=" + result);
        return result;
    }
    
    /**
     * 将数字转换成以万为单位或者以亿为单位，因为在前端数字太大显示有问题(包含处理负数)
     *
     * @author
     * @version 1.00.00
     *
     * @date 2018年1月18日
     * @param number 数字
     * @return
     */
    public static String amountConversionNegative(double number){
        double amount = 0;
        // 处理负数
        if (number < 0) {
            BigDecimal bd = new BigDecimal(number);
            amount = bd.abs().doubleValue();
        }else{
            amount = number;
        }
        //最终返回的结果值
        String result = String.valueOf(amount);
        //四舍五入后的值
        double value = 0;
        //转换后的值
        double tempValue = 0;
        //余数
        double remainder = 0;
        
        //金额大于1百万小于1亿
        if(amount > MILLIONS && amount < BILLION){
            tempValue = amount/MILLION;
            remainder = amount%MILLION;
            //log.info("tempValue=" + tempValue + ", remainder=" + remainder);
            
            //余数小于5000则不进行四舍五入
            if(remainder < (MILLION/2)){
                value = formatNumber(tempValue,2,false);
            }else{
                value = formatNumber(tempValue,2,true);
            }
            //如果值刚好是10000万，则要变成1亿
            if(value == MILLION){
                result = zeroFill(value/MILLION) + BILLION_UNIT;
            }else{
                result = zeroFill(value) + MILLION_UNIT;
            }
        }
        //金额大于1亿
        else if(amount > BILLION){
            tempValue = amount/BILLION;
            remainder = amount%BILLION;
            //log.info("tempValue=" + tempValue + ", remainder=" + remainder);
            
            //余数小于50000000则不进行四舍五入
            if(remainder < (BILLION/2)){
                value = formatNumber(tempValue,2,false);
            }else{
                value = formatNumber(tempValue,2,true);
            }
            result = zeroFill(value) + BILLION_UNIT;
        }else{
            result = zeroFill(amount);
        }
        // 处理负数
        if (number < 0) {
            result = "-"+result;
        }
        //log.info("result=" + result);
        return result;
    }
    
    /**
     * 对数字进行四舍五入，保留2位小数
     *
     * @author
     * @version 1.00.00
     *
     * @date 2018年1月18日
     * @param number 要四舍五入的数字
     * @param decimal 保留的小数点数
     * @param rounding 是否四舍五入
     * @return
     */
    public static Double formatNumber(double number, int decimal, boolean rounding){
        BigDecimal bigDecimal = new BigDecimal(number);
        
        if(rounding){
            return bigDecimal.setScale(decimal,RoundingMode.HALF_UP).doubleValue();
        }else{
            return bigDecimal.setScale(decimal,RoundingMode.DOWN).doubleValue();
        }
    }
    
    /**
     * 对四舍五入的数据进行补0显示，即显示.00
     *
     * @author
     * @version 1.00.00
     *
     * @date 2018年1月23日
     * @return
     */
    public static String zeroFill(double number){
        String value = String.valueOf(number);
        
        if(value.indexOf(".")<0){
            value = value + ".00";
        }else{
            String decimalValue = value.substring(value.indexOf(".")+1);
            
            if(decimalValue.length()<2){
                value = value + "0";
            }
        }
        return value;
    }
    
    /**
     * 测试方法入口
     *
         * @author
     * @version 1.00.00
     *
     * @date 2018年1月18日
     * @param args
     */
    public static void main(String[] args) throws Exception{
//        numberConversion(120);
//        numberConversion(18166.35);
//        numberConversion(1222188.35);
//        numberConversion(129887783.5);
//        amountConversion(-163580353.02);
        BigDecimal aa =new BigDecimal("-163580353.02");
        System.out.println(aa.abs());//把BigDecimal的负数转成正数
        System.out.println(aa.negate());//把BigDecimail的正数转负数
        //BigDecimal aa = mod.getOperatingIncome().abs();
        double d = 1.165686;   
        String result = NumberUtils.format(d, "#0.000");   
        System.out.println("" + result);   
        d = 1;   
        result = NumberUtils.format(d, "#0.00%");   
        System.out.println("" + result);   
        d = 0;   
        result = NumberUtils.format(d, "#0.0%");   
        System.out.println("" + result);   
        d = 0.2556;   
        result = NumberUtils.format(d, "#0.00%");   
        System.out.println("" + result);   
        d = 1;   
        result = NumberUtils.format(d, "#0%");   
        System.out.println("" + result);   
        System.out.println("-----------");   
        System.out.println(NumberUtils.format("3.1415926", "#0.00%"));   
    }
    
}  