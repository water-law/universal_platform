package com.weitu.mpsplatform.commons.utils;


import com.weitu.mpsplatform.commons.exception.SysException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 
 * 
 * @author senhuaF-31049
 * @version $Id: SDateTime.java, v 0.1 2016年9月19日 上午10:07:08 senhuaF-31049 Exp $
 */
public class SDateTime {
    private static final Log LOG                      = LogFactory.getLog(DateTimeTools.class);
    public static final String PATTERN_STANDARD04W      = "yyyy";
    public static final String PATTERN_STANDARD06W      = "yyyyMM";
    public static final String PATTERN_STANDARD08W      = "yyyyMMdd";
    public static final String PATTERN_STANDARD12W      = "yyyyMMddHHmm";
    public static final String PATTERN_STANDARD14W      = "yyyyMMddHHmmss";
    public static final String PATTERN_STANDARD17W      = "yyyyMMddHHmmssSSS";

    public static final String PATTERN_STANDARD07H      = "yyyy-MM";
    public static final String PATTERN_STANDARD10H      = "yyyy-MM-dd";
    public static final String PATTERN_STANDARD16H      = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_STANDARD19H      = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_STANDARDTIMEZONE = "yyyy-MM-dd'T'HH:mm:ss";
    
    public static final String PATTERN_STANDARD06W_NYR      = "yyyy年MM月";
    public static final String PATTERN_STANDARD16H_NYR      = "yyyy年MM月dd日 HH:mm";
    public static final String PATTERN_STANDARD16HM_NYR     = "yyyy年MM月dd日HH时mm分";
    public static final String PATTERN_STANDARD19H_NYR      = "yyyy年MM月dd日 HH:mm:ss";

    public static final String PATTERN_STANDARD07X      = "yyyy/MM";
    public static final String PATTERN_STANDARD10X      = "yyyy/MM/dd";
    public static final String PATTERN_STANDARD16X      = "yyyy/MM/dd HH:mm";
    public static final String PATTERN_STANDARD19X      = "yyyy/MM/dd HH:mm:ss";

    public static final String PATTERN_UTC_MILLI_24TZ   = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String PATTERN_UTC_MILLI_28TZ   = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String PATTERN_UTC_20TZ         = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String PATTERN_UTC_24TZ_0800    = "yyyy-MM-dd'T'HH:mm:ssZ";

    public static final String PATTERN_GMT              = "EEE MMM ddHH:mm:ss 'GMT' yyyy";
    public static final String DATE_TIMEZONE            = "GMT+8";
    public static final String PATTERN_STANDARD08H      = "HH:mm:ss";

    /**
     * 12小时格式化
     */
    public final static String PATTERN_12_STANDARD19H   = "yyyy-MM-dd hh:mm:ss";
    /**
     * 24小时格式化--时间
     */
    public static final String PATTERN_24_STANDARD05H   = "HH:mm";
    /**
     * 12小时格式化--时间
     */
    public final static String PATTERN_12_STANDARD05H   = "hh:mm";
    /**
     * 月份
     */
    public final static String MOUTHS_PATTERN           = "MM-dd";

    public static final String DATE_WEE_HOURS           = "00:00:00";
    public static final String DATE_WEE_NIGHT           = "23:59:59";

    /**
     * 时间格式长度，12:12
     */
    public static final int    DATE_HOUER_INT           = 5;
    
    /**
     *  数字-1
     */
    public static final int NUMBER_MINUS_ONE = -1;
    
    /**
     *  数字0
     */
    public static final int NUMBER_ZERO = 0;
    
    /**
     *  数字1
     */
    public static final int NUMBER_ONE = 1;
    
    /**
     *  数字2
     */
    public static final int NUMBER_TWO = 2;
    
    /**
     *  数字3
     */
    public static final int NUMBER_THREE = 3;
    
    /**
     *  数字4
     */
    public static final int NUMBER_FOUR = 4;
    
    /**
     *  数字5
     */
    public static final int NUMBER_FIVE = 5;
    
    /**
     *  数字6
     */
    public static final int NUMBER_SIX = 6;
    
    /**
     *  数字7
     */
    public static final int NUMBER_SEVEN = 7;
    
    /**
     *  数字8
     */
    public static final int NUMBER_EIGHT = 8;
    
    /**
     *  数字9
     */
    public static final int NUMBER_NINE = 9;
    
    /**
     *  数字10
     */
    public static final int NUMBER_TEN = 10;
    
    /**
     *  数字11
     */
    public static final int NUMBER_ELEVEN = 11;
    
    /**
     *  数字12
     */
    public static final int NUMBER_TWELVE = 12;
    
    public static final int NUMBER_TWENTY_EIGHT = 28;
    public static final int NUMBER_TWENTY_NINE = 29;
    public static final int NUMBER_THIRTY = 30;
    public static final int NUMBER_THIRTY_ONE = 31;
    
    /**
     * 文件协议类型
     */
    public final static String JAR_FILE_FIX="jar:file:";
    
    /**
     * 文件协议类型
     */
    public final static String FILE_FIX="file:/";
    
    /**
     * 默认字符集
     */
    public final static String DEFAULT_ENCODING="utf-8";
    
    public final static String TRUE_VALUE="true";
    
    public final static String OK_VALUE="OK";
    
//  public final static String SERVICE_NAME_SUFFIX="_AirExportService";
    
    /**
     *  双斜扛
     */
    public static final String SYMBOL_DOUBLE_VIRGULE  = "//";
    
    /**
     *  双斜扛
     */
    public static final String SYMBOL_VIRGULE  = "/";
    
    /**
     *  句号
     */
    public static final String SYMBOL_PERIOD = ".";
    
    /**
     *  句号
     */
    public static final String SYMBOL_FILE_PREFIX = "file:/";
    
    /**
     *  负号或减号
     */
    public static final String SYMBOL_MINUS = "-";
    
    /**
     *  冒号
     */
    public static final String SYMBOL_COLON = ":";
    
    /**
     *  空格
     */
    public static final String SYMBOL_BLANK = " ";
    
    /**
     *  连字符
     */
    public static final String SYMBOL_HYPHEN = "_";

    /**
     * 刚刚
     */
    public final static String TIME_INFO                = "刚刚";
    /**
     * 上午
     */
    public final static String TIME_AM                  = "上午";
    /**
     * 下午
     */
    public final static String TIME_PM                  = "下午";
    /**
     * 1分钟前
     */
    public final static String FIRST_MINUTES_BEFORE     = "1分钟前";
    /**
     * N分钟前
     */
    public final static String TIME_MINUTES_BEFORE      = "分钟前";
    /**
     * N小时前
     */
    public final static String TIME_HOURS_BEFORE        = "小时前";
    /**
     * 昨天
     */
    public final static String YESTERDAY                = "昨天";
    /**
     * N天前
     */
    public final static String TIME_DAYS_BEFORE         = "天前";
    /**
     * 周前
     */
    public final static String TIME_WEEK_BEFORE        = "周前";
    /**
     * N月前
     */
    public final static String TIME_METHOD_BEFORE       = "个月前";
    /**
     * N年
     */
    public final static String TIME_YEARS_BEFORE        = "年前";

    public SDateTime() {

    }

    /**
     * 取得当前日期和时间
     * @return String
     */
    public static String getNowDateTime() {
        String nowdatetime = "";
        nowdatetime = getNowDate() + " " + getNowTime();
        return nowdatetime;
    }

    /**
     * 取得当前的系统日期
     * 
     * @return String
     */
    public static String getNowDate() {
        String thedate = "";
        String themonth = "";
        int thedate1 = 0;
        int themonth1 = 0;
        String nowday = "";
        Calendar calendar = Calendar.getInstance();

        thedate1 = calendar.get(Calendar.DATE);
        if (thedate1 <= NUMBER_NINE) {
            thedate = "0" + thedate1;
        } else {
            thedate = String.valueOf(thedate1);
        }
        themonth1 = calendar.get(Calendar.MONTH) + 1;
        if (themonth1 <= NUMBER_NINE) {
            themonth = "0" + themonth1;
        } else {
            themonth = String.valueOf(themonth1);
        }
        // 当前日期
        nowday = calendar.get(Calendar.YEAR) + "-" + (themonth) + "-" + (thedate);
        return nowday;
    }

    /**
     * 取得当前系统时间
     * 
     * @return String
     */
    public static String getNowTime() {
        String nowtime = "";
        int nowhour = 0;
        int nowminute = 0;
        int nowsecond = 0;
        Calendar calendar = Calendar.getInstance();
        nowhour = calendar.get(Calendar.HOUR_OF_DAY);
        nowminute = calendar.get(Calendar.MINUTE);
        nowsecond = calendar.get(Calendar.SECOND);

        String nowhourstring = String.valueOf(nowhour);
        String nowminutestring = String.valueOf(nowminute);
        String nowsecondstring = String.valueOf(nowsecond);

        if (nowhourstring.length() < NUMBER_TWO) {
            nowhourstring = "0" + nowhourstring;
        }
        if (nowminutestring.length() < NUMBER_TWO) {
            nowminutestring = "0" + nowminutestring;
        }
        if (nowsecondstring.length() < NUMBER_TWO) {
            nowsecondstring = "0" + nowsecondstring;
        }
        nowtime = nowhourstring + ":" + nowminutestring + ":" + nowsecondstring;
        return nowtime;
    }

    /**
     * 月份加减
     * 
     * @param date
     * @param month
     * @return
     */
    public static String getDateAddMonth(String date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(date, null));
        calendar.add(Calendar.MONTH, month);
        return getDate(calendar);
    }

    /**
     * 取得当前是一周中的第几天
     * 
     * @return String
     */
    public static String getNowWeekDay() {
        String nowweekday = "";
        Calendar calendar = Calendar.getInstance();
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        if (weekday == NUMBER_SEVEN) {
            nowweekday = "星期日";
        } else if (weekday == NUMBER_ONE) {
            nowweekday = "星期一";
        } else if (weekday == NUMBER_TWO) {
            nowweekday = "星期二";
        } else if (weekday == NUMBER_THREE) {
            nowweekday = "星期三";
        } else if (weekday == NUMBER_FOUR) {
            nowweekday = "星期四";
        } else if (weekday == NUMBER_FIVE) {
            nowweekday = "星期五";
        } else if (weekday == NUMBER_SIX) {
            nowweekday = "星期六";
        }
        return (nowweekday);
    }

    /**
     * 获取一个时间是星期几
     * @param thedate
     * @return String
     */
    public static String getWeekDay(String thedate) {
        String nowdate = getNowDate() + " 00:00:00";
        int days = (int) timeCalculate(nowdate, thedate) - 1;
        String theweekday = "";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        if (weekday == NUMBER_SEVEN) {
            theweekday = "星期日";
        } else if (weekday == NUMBER_ONE) {
            theweekday = "星期一";
        } else if (weekday == NUMBER_TWO) {
            theweekday = "星期二";
        } else if (weekday == NUMBER_THREE) {
            theweekday = "星期三";
        } else if (weekday == NUMBER_FOUR) {
            theweekday = "星期四";
        } else if (weekday == NUMBER_FIVE) {
            theweekday = "星期五";
        } else if (weekday == NUMBER_SIX) {
            theweekday = "星期六";
        }
        return (theweekday);
    }

    /**
     * 获取一个时间是星期几
     * @param thedate
     * @return String
     */
    public static String getWeekDay(Date thedate) {
        String nowdate = getNowDate() + " 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(nowdate);
        } catch (Exception e) {
            throw new SysException(e);
        }
        int days = (int) timeCalculate(thedate, date) - 1;
        String theweekday = "";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        if (weekday == NUMBER_SEVEN) {
            theweekday = "星期日";
        } else if (weekday == NUMBER_ONE) {
            theweekday = "星期一";
        } else if (weekday == NUMBER_TWO) {
            theweekday = "星期二";
        } else if (weekday == NUMBER_THREE) {
            theweekday = "星期三";
        } else if (weekday == NUMBER_FOUR) {
            theweekday = "星期四";
        } else if (weekday == NUMBER_FIVE) {
            theweekday = "星期五";
        } else if (weekday == NUMBER_SIX) {
            theweekday = "星期六";
        }
        return (theweekday);
    }

    /**
     * 日期加减
     * @param days
     * @return String
     */
    public static String getDateAddDate(int days) {
        String thedate = "";
        String themonth = "";
        int thedate1 = 0;
        int themonth1 = 0;
        String nowday = "";

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);

        thedate1 = calendar.get(Calendar.DATE);
        if ((thedate1 == NUMBER_ONE) || (thedate1 == NUMBER_TWO) || (thedate1 == NUMBER_THREE) || (thedate1 == NUMBER_FOUR)
            || (thedate1 == NUMBER_FIVE) || (thedate1 == NUMBER_SIX) || (thedate1 == NUMBER_SEVEN) || (thedate1 == NUMBER_EIGHT)
            || (thedate1 == NUMBER_NINE)) {
            thedate = "0" + thedate1;
        } else {
            thedate = String.valueOf(thedate1);
        }

        themonth1 = calendar.get(Calendar.MONTH) + 1;
        if ((themonth1 == NUMBER_ONE) || (themonth1 == NUMBER_TWO) || (themonth1 == NUMBER_THREE) || (themonth1 == NUMBER_FOUR)
            || (themonth1 == NUMBER_FIVE) || (themonth1 == NUMBER_SIX) || (themonth1 == NUMBER_SEVEN) || (themonth1 == NUMBER_EIGHT)
            || (themonth1 == NUMBER_NINE)) {
            themonth = "0" + themonth1;
        } else {
            themonth = String.valueOf(themonth1);
        }
        // 当前日期
        nowday = calendar.get(Calendar.YEAR) + "-" + (themonth) + "-" + (thedate);

        return nowday;
    }

    /**
     * 小时加减
     * @param date
     * @param hour
     * @return String
     */
    public static String getDateAddHour(String date, int hour) {
        String nowdate = getNowDateTime();
        date = getTime(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date thedateNowdate = null;
        Date insideDateDate = null;
        try {
            thedateNowdate = format.parse(nowdate);
            insideDateDate = format.parse(date);
        } catch (Exception e) {
            throw new SysException(e);
        }
        int hours = (int) timeCalculateHour(thedateNowdate, insideDateDate);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, hours + hour);

        return getDate(calendar);
    }

    /**
     * 小时加减
     * @param date
     * @param hour
     * @return String
     */
    public static String getDateAddHour(Date date, int hour) {
        String nowdate = getNowDateTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date thedateNowdate = null;
        try {
            thedateNowdate = format.parse(nowdate);
        } catch (Exception e) {
            throw new SysException(e);
        }
        int hours = (int) timeCalculateHour(thedateNowdate, date);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, hours + hour);

        return getDate(calendar);
    }

    /**
     * 分钟加减
     * 
     * @param date
     * @param minute
     * @return
     */
    public static String getDateAddMinutes(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return getDate(calendar);
    }

    /**
     * 比较日期的大小，判断time1和time2的大小time1>time2时返回1,time1 <time2是返回-1,time1=time2返回0；
     * 
     * @param time1
     *            String格式日期
     * @param time2
     *            String格式日期
     * @return int
     */
    public static int compareTime(String time1, String time2) {
        time1 = getTime(time1);
        time2 = getTime(time2);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int flag = 0;
        try {
            Date date1, date2;
            date1 = format.parse(time1);
            date2 = format.parse(time2);
            long millisecond = date1.getTime() - date2.getTime();
            if (millisecond > 0) {
                flag = 1;
            } else if (millisecond < 0) {
                flag = -1;
            } else if (millisecond == 0) {
                flag = 0;
            }
        } catch (ParseException e) {
            throw new SysException(e);
        }
        return (flag);
    }

    /**
     * 比较日期的大小，判断time1和time2的大小time1>time2时返回1,time1 <time2是返回-1,time1=time2返回0；
     * 
     * @param time1
     *            Date格式日期
     * @param time2
     *            Date格式日期
     * @return int
     */
    public static int compareTime(Date time1, Date time2) {
        int flag = 0;
        try {
            long millisecond = time1.getTime() - time2.getTime();
            if (millisecond > 0) {
                flag = 1;
            } else if (millisecond < 0) {
                flag = -1;
            } else if (millisecond == 0) {
                flag = 0;
            }
        } catch (Exception e) {
            throw new SysException(e);
        }
        return (flag);
    }

    /**
     * 计算time2-time1得到的天数差
     * 
     * @param time1
     *            String格式日期
     * @param time2
     *            String格式日期
     * @return int
     */
    public static float timeCalculate(String time1, String time2) {
        time1 = getTime(time1);
        time2 = getTime(time2);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        float day = 0;
        Date date1 = null;
        Date date2 = null;

        try {
            date1 = format.parse(time1);
            date2 = format.parse(time2);
            long millisecond = date2.getTime() - date1.getTime();
            day = millisecond / (24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            throw new SysException(e);
        }
        return (day);
    }

    /**
     * 计算time2-time1的天数差
     * 
     * @param time1
     *            Date格式日期
     * @param time2
     *            Date格式日期
     * @return double
     */
    public static float timeCalculate(Date time1, Date time2) {
        float day = 0;
        try {
            Date date1, date2;
            date1 = time1;
            date2 = time2;
            long millisecond = date2.getTime() - date1.getTime();
            day = millisecond / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            throw new SysException(e);
        }
        return (day);
    }

    /**
     * 计算小时差
     * @param time1
     * @param time2
     * @return double
     */
    public static double timeCalculateHour(String time1, String time2) {
        time1 = getTime(time1);
        time2 = getTime(time2);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        double hour = 0;
        try {
            Date date1, date2;
            date1 = format.parse(time1);
            date2 = format.parse(time2);
            double millisecond = date2.getTime() - date1.getTime();
            hour = millisecond / (60 * 60 * 1000);
        } catch (ParseException e) {
            throw new SysException(e);
        }
        return hour;
    }

    /**
     * 计算时差
     * @param date1
     * @param date2
     * @return double
     */
    public static double timeCalculateHour(Date date1, Date date2) {
        double hour = 0;
        double millisecond = date2.getTime() - date1.getTime();
        hour = millisecond / (60 * 60 * 1000);
        return hour;
    }

    /**
     * 
     * 计算两个期间相差几个月
     *  date2 - date1
     *  format格式：yyyy-MM-dd
     *  
     *  先比较年，再比较月份，年之差*12+月份之差
     *  
     * @author yuexin.song
     * @param date1
     * @param date2
     * @param format
     * @return
     */
    public static int timeCalculateMonth(String date1, String date2, String format) {
        if (SString.isBlank(date1) && SString.isBlank(date2)) {
            return 0;
        }
        if (SString.isBlank(format)) {
            format = PATTERN_STANDARD10H;
        }
        Date startDate = parseDate(date1, format);
        Date endDate = parseDate(date2, format);
        if (startDate.after(endDate)) {
            Date date = startDate;
            startDate = endDate;
            endDate = date;
        }
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.setTime(startDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        
        Calendar temp = Calendar.getInstance();  
        temp.setTime(endDate);  
        temp.add(Calendar.DATE, 1);
        
        int year = (endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR));  
        int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) {  
            return Math.abs(year * 12 + month + 1);  
        } else if ((startCalendar.get(Calendar.DATE) != 1) && (temp.get(Calendar.DATE) == 1)) {  
            return Math.abs(year * 12 + month);  
        } else if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) != 1)) {  
            return Math.abs(year * 12 + month);  
        } else {  
            return (year * 12 + month - 1) < 0 ? 0 : Math.abs(year * 12 + month);  
        }
    }
    
    /**
     * 取得当前时间
     * @param time
     * @return long
     */
    public static long getLongTime(String time) {
        time = getTime(time);
        long longtime = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = format.parse(time);
            longtime = date.getTime();
        } catch (Exception e) {
            throw new SysException(e);
        }
        return longtime;
    }

    /**
     * 字符串转换时间
     * @param datestring
     * @param theformat
     * @return Date
     */
    public static Date parseDate(String datestring, String theformat) {
        if (theformat == null) {
            datestring = getTime(datestring);
            theformat = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(theformat);
        Date date = null;
        try {
            date = format.parse(datestring);
        } catch (Exception e) {
            throw new SysException(e);
        }
        return date;
    }

    /**
     * 字符串转换时间
     * @param datestring
     * @return Date
     */
    public static Date parseDate(String datestring) {
        if (getDataFormat(datestring).equals(PATTERN_STANDARD06W)) {
            datestring = datestring + "01";
        } else if (getDataFormat(datestring).equals(PATTERN_STANDARD07H)) {
            datestring = datestring + "-01";
        }
        String theformat = "yyyy-MM-dd HH:mm:ss";
        theformat = getDataFormat(datestring);
        SimpleDateFormat format = new SimpleDateFormat(theformat);
        Date date = null;
        try {
            date = format.parse(datestring);
        } catch (Exception e) {
            throw new SysException(e);
        }
        return date;
    }

    /**
     * 字符串转换时间 
     *
     * @param datestring
     * @param isFirst 为true,获取当前时间起点时间,比如2017-01-01 00:00:00
     * @param isLast 为true,获取当前时间终点时间,比如2017-01-01 23:59:59
     * @return
     *
     */
    public static Date parseDate(String datestring, boolean isFirst, boolean isLast) {
        if (getDataFormat(datestring).equals(PATTERN_STANDARD06W)) {
            datestring = datestring + "01";
        } else if (getDataFormat(datestring).equals(PATTERN_STANDARD07H)) {
            datestring = datestring + "-01";
        }
        String theformat = "yyyy-MM-dd HH:mm:ss";
        theformat = getDataFormat(datestring);
        SimpleDateFormat format = new SimpleDateFormat(theformat);
        Date date = null;
        try {
            date = format.parse(datestring);
            if (isFirst) {
                date = getStartTimeOfDay(date);
            } else if (isLast) {
                date = getEndTimeOfDay(date);
            }
        } catch (Exception e) {
            throw new SysException(e);
        }
        return date;
    }

    /**
     * 获取当前时间的时间格式
     *
     * @param datastring
     * @return
     *
     */
    public static String getDataFormat(String datastring) {
        datastring = SString.getTrimString(datastring);
        int length = datastring.length();
        if (length == PATTERN_STANDARD06W.length()) {
            return PATTERN_STANDARD06W;
        } else if (length == PATTERN_STANDARD07H.length() && datastring.indexOf(SYMBOL_MINUS) > 0) {
            return PATTERN_STANDARD07H;
        } else if (length == PATTERN_STANDARD07X.length() && datastring.indexOf(SYMBOL_DOUBLE_VIRGULE) > 0) {
            return PATTERN_STANDARD07X;
        } else if (length == PATTERN_STANDARD08W.length()) {
            return PATTERN_STANDARD08W;
        } else if (length == PATTERN_STANDARD10H.length() && datastring.indexOf(SYMBOL_MINUS) > 0) {
            return PATTERN_STANDARD10H;
        } else if (length == PATTERN_STANDARD10X.length() && datastring.indexOf(SYMBOL_DOUBLE_VIRGULE) > 0) {
            return PATTERN_STANDARD10X;
        } else if (length == PATTERN_STANDARD12W.length()) {
            return PATTERN_STANDARD12W;
        } else if (length == PATTERN_STANDARD14W.length()) {
            return PATTERN_STANDARD14W;
        } else if (length == PATTERN_STANDARD16H.length() && datastring.indexOf(SYMBOL_MINUS) > 0) {
            return PATTERN_STANDARD16H;
        } else if (length == PATTERN_STANDARD16X.length() && datastring.indexOf(SYMBOL_DOUBLE_VIRGULE) > 0) {
            return PATTERN_STANDARD16X;
        } else if (length == PATTERN_STANDARD17W.length()) {
            return PATTERN_STANDARD17W;
        } else if (length == PATTERN_STANDARD19H.length() && datastring.indexOf(SYMBOL_MINUS) > 0) {
            return PATTERN_STANDARD19H;
        } else if (length == PATTERN_STANDARD19X.length() && datastring.indexOf(SYMBOL_DOUBLE_VIRGULE) > 0) {
            return PATTERN_STANDARD19X;
        } else {
            return PATTERN_STANDARD19H;
        }
    }

    /**
     * 获取当前时间起点时间 
     *
     * @param date
     * @return
     *
     */
    private static Date getStartTimeOfDay(Date date) {
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        return day.getTime();
    }

    /**
     * 获取当前时间起点时间 
     *
     * @param dateStr
     * @param pattern
     * @return
     *
     */
    public static String getStartTimeOfDay(String dateStr, String pattern) {
        Date date = getStartTimeOfDay(parseDate(dateStr));
        return format(date, pattern);
    }

    /**
     * 获取当前时间终点时间 
     *
     * @param date
     * @return
     *
     */
    private static Date getEndTimeOfDay(Date date) {
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 23);
        day.set(Calendar.MINUTE, 59);
        day.set(Calendar.SECOND, 59);
        day.set(Calendar.MILLISECOND, 999);
        return day.getTime();
    }

    /**
     * 获取当前时间终点时间 
     *
     * @param dateStr
     * @param pattern
     * @return
     *
     */
    public static String getEndTimeOfDay(String dateStr, String pattern) {
        Date date = getEndTimeOfDay(parseDate(dateStr));
        return format(date, pattern);
    }

    /**
     * 根据指定格式将指定日期格式化成字符串
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        if (pattern == null) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 判断是不是正确的日期
     * @param datestring
     * @param theformat
     * @return boolean
     */
    public static boolean isDateTime(String datestring, String theformat) {
        boolean flag = false;
        if (theformat == null) {
            datestring = getTime(datestring);
            theformat = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(theformat);
        try {
            format.parse(datestring);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 判断是不是正确的日期
     * @param datestring
     * @param theformat
     * @return boolean
     */
    public static boolean isDate(String datestring, String theformat) {
        boolean flag = false;
        if (theformat == null) {
            datestring = getTime(datestring);
            theformat = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(theformat);
        try {
            format.parse(datestring + " " + getNowTime());
            flag = true;
            return flag;
        } catch (Exception e) {
            flag = false;
            return flag;
        }
    }

    /**
     * 判断是不是正确的时间
     * @param timestring
     * @param theformat
     * @return boolean
     */
    public static boolean isTime(String timestring, String theformat) {
        boolean flag = false;
        if (theformat == null) {
            timestring = getTime(timestring);
            theformat = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(theformat);
        try {
            format.parse(getNowDate() + " " + timestring);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 取得月份的天数
     * @param year
     * @param month
     * @return int
     */
    public static int getDaysOfMonth(int year, int month) {
        int days = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days;
    }

    /**
     * 取得当前月份天数
     * @return int
     */
    public static int getDaysOfMonth() {
        int days = 0;
        int year = getNowYearOnly();
        int month = getNowMonthOnly();
        days = getDaysOfMonth(year, month);
        return days;
    }

    /**
     * 取得当前年份
     * @return int
     */
    public static int getNowYearOnly() {
        int year;
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        return year;
    }

    /**
     * 取得当前年份
     * @return int
     */
    public static int getYearOnly(String dateStr) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        int year;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(dateStr));
        year = calendar.get(Calendar.YEAR);
        return year;
    }

    /**
     * 取得当前月份
     * @return int
     */
    public static int getNowMonthOnly() {
        int month;
        Calendar calendar = Calendar.getInstance();
        month = calendar.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 取得当前月份
     * @return int
     */
    public static int getMonthOnly(String dateStr) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        int month;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(dateStr));
        month = calendar.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 取得当前月所在第几天数
     * @return int
     */
    public static int getDayOnly(String dateStr) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        int day;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(dateStr));
        day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    /**
     * 取得当前日期
     * @return int
     */
    public static int getNowDateOnly() {
        int date;
        Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DATE);
        return date;
    }

    /**
     * 取得当前小时
     * @return int
     */
    public static int getNowHourOnly() {
        int hour;
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    /**
     * 取得当前分钟
     * @return int
     */
    public static int getNowMinuteOnly() {
        int hour;
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.MINUTE);
        return hour;
    }

    /**
     * 取得当前秒钟
     * @return int
     */
    public static int getNowSecondOnly() {
        int hour;
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.SECOND);
        return hour;
    }

    /**
     * 取得当前日期
     * @param calendar
     * @return String
     */
    public static String getDate(Calendar calendar) {
        String thedate = "";
        String themonth = "";
        int thedate1 = 0;
        int themonth1 = 0;

        String nowtime = "";
        int nowhour = 0;
        int nowminute = 0;
        int nowsecond = 0;

        String nowday = "";

        thedate1 = calendar.get(Calendar.DATE);
        if (thedate1 <= NUMBER_NINE) {
            thedate = "0" + thedate1;
        } else {
            thedate = String.valueOf(thedate1);
        }
        themonth1 = calendar.get(Calendar.MONTH) + 1;
        if (themonth1 <= NUMBER_NINE) {
            themonth = "0" + themonth1;
        } else {
            themonth = String.valueOf(themonth1);
        }
        // 当前日期
        nowday = calendar.get(Calendar.YEAR) + "-" + (themonth) + "-" + (thedate);

        nowhour = calendar.get(Calendar.HOUR_OF_DAY);
        nowminute = calendar.get(Calendar.MINUTE);
        nowsecond = calendar.get(Calendar.SECOND);

        String nowhourstring = String.valueOf(nowhour);
        String nowminutestring = String.valueOf(nowminute);
        String nowsecondstring = String.valueOf(nowsecond);

        if (nowhourstring.length() < NUMBER_TWO) {
            nowhourstring = "0" + nowhourstring;
        }
        if (nowminutestring.length() < NUMBER_TWO) {
            nowminutestring = "0" + nowminutestring;
        }
        if (nowsecondstring.length() < NUMBER_TWO) {
            nowsecondstring = "0" + nowsecondstring;
        }
        nowtime = nowhourstring + ":" + nowminutestring + ":" + nowsecondstring;

        return nowday + " " + nowtime;
    }

    /**
     * 时间格式校验
     * 
     * @param dateStr
     * @return
     */
    public static boolean isDateMemo(String dateStr, String theformat) {
        if (SString.isBlank(theformat)) {
            theformat = "yyyyMMdd";
        }
        if (SString.isNotBlank(dateStr)) {
            try {
                SimpleDateFormat format = new SimpleDateFormat(theformat);
                Date date = (Date) format.parse(dateStr);
                return dateStr.equals(format.format(date));
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String getTime(String time) {
        if (SString.getInterString(SYMBOL_BLANK, time).size() < NUMBER_TWO) {
            time = time + " 00:00:00";
        }
        return time;
    }

    public static String getTimeEnd(String time) {
        if (SString.getInterString(SYMBOL_BLANK, time).size() < NUMBER_TWO) {
            time = time + " 23:59:59";
        }
        return time;
    }

    /**
     * 根据传入字符串日期，返回date时间
     * 
     * @param dateStr
     * @return
     */
    private static Date setCalendarTime(String dateStr, String formatStr) {
        if (SString.isNotBlank(dateStr)) {
            return parseDate(dateStr, formatStr);
        } else {
            return new Date();
        }
    }

    /**
     * 
     * 根据当前日期获取上一天时间
     * 
     * @param dateStr
     * @param format
     * @return
     */
    public static String getYesterday(String dateStr, String format) {
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取当月第一天
     * 
     * @param dateStr 指定年月/年月日
     * @param format 日期格式化
     * @return
     */
    public static String getFirstDayOfTMonth(String dateStr, String format) {
        if (!isDateTime(dateStr, format)) {
            if (format.contains(SYMBOL_MINUS)) {
                dateStr = dateStr + "-01";
            } else {
                dateStr = dateStr + "01";
            }
        }
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(dateStr, format));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取当月最后一天
     * 
     * @param dateStr 指定年月/年月日
     * @param format 日期格式化
     * @return
     */
    public static String getLastDayOfTMonth(String dateStr, String format) {
        if (!isDateTime(dateStr, format)) {
            if (format.contains(SYMBOL_MINUS)) {
                dateStr = dateStr + "-01";
            } else {
                dateStr = dateStr + "01";
            }
        }
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(dateStr, format));
        int value = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, value);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 当月第一天
     * 
     * @param dateStr 指定年月/年月日
     * @param format 日期格式化
     * @return
     */
    public static String getFirstDayForMonth(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 当月第一天
     * 
     * @param date 指定年月/年月日
     * @param format 日期格式化
     * @return
     */
    public static String getFirstDayForMonth(Date date, String format) {
        String dateStr = format(date, format);
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 当月最后一天
     * 
     * @param dateStr 指定年月/年月日
     * @param format 日期格式化
     * @return
     */
    public static String getLastDayForMonth(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        int value = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, value);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 当月最后一天
     * 
     * @param date 指定年月/年月日
     * @param format 日期格式化
     * @return
     */
    public static String getLastDayForMonth(Date date, String format) {
        String dateStr = format(date, format);
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        int value = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, value);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 
     * 获取上一个月的第一天
     * 
     * @param dateStr 指定日期
     * @param format 日期格式化
     * @return
     */
    public static String getFirstDayForLastMonth(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 
     * 获取上一个月的第一天
     * 
     * @param date 指定日期
     * @param format 日期格式化
     * @return
     */
    public static String getFirstDayForLastMonth(Date date, String format) {
        String dateStr = format(date, format);
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取上一个月最后一天
     * 
     * @param dateStr 指定日期
     * @param format 日期格式化
     * @return
     */
    public static String getLastDayForLastMonth(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取上一个月最后一天
     *
     * @param date 指定日期
     * @param format 日期格式化
     * @return
     */
    public static String getLastDayForLastMonth(Date date, String format) {
        String dateStr = format(date, format);
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取本周一天
     * 
     * @param dateStr 指定日期
     * @param format 日期格式化
     * @return
     */
    public static String getFirstDayForWeek(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        // 设置周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(setCalendarTime(dateStr, format));
        int value = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        // 如果第一天的日期为上一月，则把这周的第一天设置成本月一号
        if (calendar.get(Calendar.MONTH) < value) {
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
        }
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取本周一天
     * 
     * @param date 指定日期
     * @param format 日期格式化
     * @return
     */
    public static String getFirstDayForWeek(Date date, String format) {
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        String dateStr = format(date, format);
        Calendar calendar = Calendar.getInstance();
        // 设置周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(setCalendarTime(dateStr, format));
        int value = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        // 如果第一天的日期为上一月，则把这周的第一天设置成本月一号
        if (calendar.get(Calendar.MONTH) < value) {
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
        }
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取本周最后一天
     * 
     * @param dateStr 指定日期
     * @param format 日期格式化
     * @return
     */
    public static String getLastDayForWeek(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        Calendar calendar = Calendar.getInstance();
        // 设置周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int value = calendar.get(Calendar.MONTH);
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6);
        // 如果最后一天的日期为下个月，则把本周的最后一天设置为本月最后一天
        while (calendar.get(Calendar.MONTH) > value) {
            // 日期逐渐减少一天，直到月份为本月为止
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取本周最后一天
     * 
     * @param date 指定日期
     * @param format 日期格式化
     * @return
     */
    public static String getLastDayForWeek(Date date, String format) {
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        String dateStr = format(date, format);
        Calendar calendar = Calendar.getInstance();
        // 设置周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int value = calendar.get(Calendar.MONTH);
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6);
        // 如果最后一天的日期为下个月，则把本周的最后一天设置为本月最后一天
        while (calendar.get(Calendar.MONTH) > value) {
            // 日期逐渐减少一天，直到月份为本月为止
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取上周第一天
     * 
     * @param dateStr
     * @param format
     * @return
     */
    public static String getFirstDayForLastWeek(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.add(Calendar.DATE, -1 * 7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取上周第一天
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getFirstDayForLastWeek(Date date, String format) {
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        String dateStr = format(date, format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.add(Calendar.DATE, -1 * 7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取上周最后一天
     * 
     * @param dateStr
     * @param format
     * @return
     */
    public static String getLastDayForLastWeek(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.add(Calendar.DATE, -1 * 7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取上周最后一天
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getLastDayForLastWeek(Date date, String format) {
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        String dateStr = format(date, format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.add(Calendar.DATE, -1 * 7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取当季第一天
     * 
     * @param dateStr
     * @param format
     * @return
     */
    public static String getFirstDayStartQuarter(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        getQuarterForMonth(calendar, calendar.get(Calendar.MONTH), true);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取当季第一天
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getFirstDayStartQuarter(Date date, String format) {
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        String dateStr = format(date, format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        getQuarterForMonth(calendar, calendar.get(Calendar.MONTH), true);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取当季最后一天
     * 
     * @param dateStr
     * @param format
     * @return
     */
    public static String getLastDayStartQuarter(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        getQuarterForMonth(calendar, calendar.get(Calendar.MONTH), false);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取当季最后一天
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getLastDayStartQuarter(Date date, String format) {
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        String dateStr = format(date, format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        getQuarterForMonth(calendar, calendar.get(Calendar.MONTH), false);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 
     * 计算当前季度
     * 
     * @param calendar
     * @param month
     * @param isQuarterStart
     * @return
     */
    public static Calendar getQuarterForMonth(Calendar calendar, int month,
                                              boolean isQuarterStart) {

        if (month >= Calendar.JANUARY && month <= Calendar.MARCH) {
            if (isQuarterStart) {
                calendar.set(Calendar.MONTH, Calendar.JANUARY);
            } else {
                calendar.set(Calendar.MONTH, Calendar.MARCH);
            }
        }
        if (month >= Calendar.APRIL && month <= Calendar.JUNE) {
            if (isQuarterStart) {
                calendar.set(Calendar.MONTH, Calendar.APRIL);
            } else {
                calendar.set(Calendar.MONTH, Calendar.JUNE);
            }
        }
        if (month >= Calendar.JULY && month <= Calendar.AUGUST) {
            if (isQuarterStart) {
                calendar.set(Calendar.MONTH, Calendar.JULY);
            } else {
                calendar.set(Calendar.MONTH, Calendar.AUGUST);
            }
        }
        if (month >= Calendar.OCTOBER && month <= Calendar.DECEMBER) {
            if (isQuarterStart) {
                calendar.set(Calendar.MONTH, Calendar.OCTOBER);
            } else {
                calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            }
        }
        //当前季度第一天
        if (isQuarterStart) {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        }
        return calendar;
    }

    /**
     * 返回指定年季的季的第一天
     * 
     * @param year
     * @param quarter
     * @param format
     * @return
     */
    public static String getFirstDayOfQuarter(Integer year, Integer quarter, String format) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == NUMBER_ONE) {
            month = 1 - 1;
        } else if (quarter == NUMBER_TWO) {
            month = 4 - 1;
        } else if (quarter == NUMBER_THREE) {
            month = 7 - 1;
        } else if (quarter == NUMBER_FOUR) {
            month = 10 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month, format);
    }

    /**
     * 返回指定年季的季的最后一天
     * 
     * @param year
     * @param quarter
     * @param format
     * @return
     */
    public static String getLastDayOfQuarter(Integer year, Integer quarter, String format) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == NUMBER_ONE) {
            month = 3 - 1;
        } else if (quarter == NUMBER_TWO) {
            month = 6 - 1;
        } else if (quarter == NUMBER_THREE) {
            month = 9 - 1;
        } else if (quarter == NUMBER_FOUR) {
            month = 12 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month, format);
    }

    /**
     * 返回指定年季的上一季的最后一天
     * 
     * @param year
     * @param quarter
     * @param format
     * @return
     */
    public static String getLastDayOfLastQuarter(Integer year, Integer quarter, String format) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == NUMBER_ONE) {
            month = 12 - 1;
        } else if (quarter == NUMBER_TWO) {
            month = 3 - 1;
        } else if (quarter == NUMBER_THREE) {
            month = 6 - 1;
        } else if (quarter == NUMBER_FOUR) {
            month = 9 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month, format);
    }

    /**
     * 返回指定年月的月份的第一天
     * 
     * @param year
     * @param month
     * @param format
     * @return
     */
    public static String getFirstDayOfMonth(Integer year, Integer month, String format) {
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 返回指定年月的月份的最后一天
     * 
     * @param year
     * @param month
     * @param format
     * @return
     */
    public static String getLastDayOfMonth(Integer year, Integer month, String format) {
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        calendar.roll(Calendar.DATE, -1);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 当期日期为第几季度
     * 
     * @param date
     * @return
     */
    public static int getSeason(Date date) {
        int season = 0;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;
            default:
                break;
        }
        return season;
    }

    /**
     * 获取本年的第一天
     * 
     * @param dateStr
     * @param format
     * @return
     */
    public static String getFirstDayForCurrentYear(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        int currentYear = calendar.get(Calendar.YEAR);
        Date thisDate = getYearFirstDay(currentYear);
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取本年的第一天
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getFirstDayForCurrentYear(Date date, String format) {
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        String dateStr = format(date, format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        int currentYear = calendar.get(Calendar.YEAR);
        Date thisDate = getYearFirstDay(currentYear);
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取本年的最后一天
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getLastDayForCurrentYear(Date date, String format) {
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        String dateStr = format(date, format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        int lastYear = calendar.get(Calendar.YEAR);
        Date thisDate = getYearLastDay(lastYear);
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取本年的最后一天
     * 
     * @param dateStr
     * @param format
     * @return
     */
    public static String getLastDayForCurrentYear(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        int lastYear = calendar.get(Calendar.YEAR);
        Date thisDate = getYearLastDay(lastYear);
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取去年的第一天
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getFirstDayForLastYear(Date date, String format) {
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        String dateStr = format(date, format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        int currentYear = calendar.get(Calendar.YEAR) - 1;
        Date thisDate = getYearFirstDay(currentYear);
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取去年的第一天
     * 
     * @param dateStr
     * @param format
     * @return
     */
    public static String getFirstDayForLastYear(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        int currentYear = calendar.get(Calendar.YEAR) - 1;
        Date thisDate = getYearFirstDay(currentYear);
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取去年的最后一天
     * 
     * @param format
     * @return
     */
    public static String getLastDayForLastYear(Date date, String format) {
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        String dateStr = format(date, format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        int lastYear = calendar.get(Calendar.YEAR) - 1;
        Date thisDate = getYearLastDay(lastYear);
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取去年的最后一天
     * 
     * @param format
     * @return
     */
    public static String getLastDayForLastYear(String dateStr, String format) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        int lastYear = calendar.get(Calendar.YEAR) - 1;
        Date thisDate = getYearLastDay(lastYear);
        return simpleDateFormat.format(thisDate);
    }

    /**
     * 获取某年第一天
     * 
     * @param year
     * @return
     */
    public static Date getYearFirstDay(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * 
     * 获取某年最后一天
     * 
     * @param year
     * @return
     */
    public static Date getYearLastDay(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }

    public static SimpleDateFormat setFirstFormat(String format) {
        if (SString.isBlank(format)) {
            format = "yyyy-MM-dd";
        }
        if (format.equals(PATTERN_STANDARD19H) || format.equals(PATTERN_12_STANDARD19H)) {
            format = "yyyy-MM-dd 00:00:00";
        }
        return new SimpleDateFormat(format);
    }

    public static SimpleDateFormat setLastFormat(String format) {
        if (SString.isBlank(format)) {
            format = "yyyy-MM-dd";
        }
        if (format.equals(PATTERN_STANDARD19H)) {
            format = "yyyy-MM-dd 23:59:59";
        }
        if (format.equals(PATTERN_12_STANDARD19H)) {
            format = "yyyy-MM-dd 11:59:59";
        }
        return new SimpleDateFormat(format);
    }

    /**
     * 返回日期格式
     * 
     * @param format
     * @param isFirstLast
     * @return
     */
    public static String getFormatDate(String format, Boolean isFirstLast) {
        if (SString.isBlank(format)) {
            format = "yyyyMMdd";
        }
        if (format.equals(PATTERN_STANDARD19H) || format.equals(PATTERN_12_STANDARD19H)) {
            if (isFirstLast) {
                format = "yyyy-MM-dd 00:00:00";
            } else {
                format = "yyyy-MM-dd 23:59:59";
            }
        }
        return format;
    }

    /**
     * 根据年份获取每个月第一天或是最后一天列表
     * 
     * @param year 年
     * @param nums 返回接个月的日期
     * @param format 日期格式
     * @param isFirstLast 是否第一天（最后一天）
     * @return
     */
    public static List<String> getFirstOrLastDayOfYear(int year, int nums, String format,
                                                       Boolean isFirstLast) {
        format = getFormatDate(format, isFirstLast);
        List<String> monthList = new ArrayList<String>();
        for (int i = 0; i < nums; i++) {
            //每个月的第一天
            if (isFirstLast) {
                monthList.add(getFirstDayOfMonth(year, i, format));
            }
            //每个月最后一天
            else {
                monthList.add(getLastDayOfMonth(year, i, format));
            }
        }
        return monthList;
    }

    /**
     * 根据月份个数，获取从当期月份往前推几个月的日期列表
     *  [20160701-20160731, 20160801-20160831, 20160901-20160930, 20161001-20161031, 20161101-20161130, 20161201-20161231]
     * 
     * @param month
     * @param format
     * @return
     */
    public static List<String> getBetweenDates(int month, String format) {
        if (SString.isBlank(format)) {
            format = "yyyyMMdd";
        }
        if (format.equals(PATTERN_STANDARD19H) || format.equals(PATTERN_12_STANDARD19H)) {
            format = "yyyyMMdd";
        }
        List<String> result = new ArrayList<String>();
        for (int i = 1; i <= month; i++) {
            String nowBngdateStr = getFirstDayOfMonth(getNowYearOnly(), getNowMonthOnly() - i,
                format);
            String nowEndDateStr = getLastDayOfMonth(getNowYearOnly(), getNowMonthOnly() - i,
                format);
            String betweenDate = new StringBuffer().append(nowBngdateStr).append("-")
                .append(nowEndDateStr).toString();
            result.add(betweenDate);
        }
        Collections.sort(result);
        return result;
    }

    /**
     * 获取两个日期之间的日期
     * @param start 开始日期
     * @param end 结束日期
     * @return 日期集合
     */
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    /**
     * 获取两个日期之间的日期
     * @param start 开始日期
     * @param end 结束日期
     * @param isContainCurrent 是否包含当前
     * @return 日期集合
     */
    public static List<String> getBetweenDates(String start, String end, int interval,
                                               boolean isContainCurrent, String pattern) {
        if (interval <= 0) {
            interval = 1;
        }
        List<String> result = new ArrayList<String>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(parseDate(start));
        if (isContainCurrent) {
            tempStart.add(Calendar.DAY_OF_YEAR, 0);
        } else {
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(parseDate(end));
        if (isContainCurrent) {
            tempEnd.add(Calendar.DAY_OF_YEAR, 1);
        }
        while (tempStart.before(tempEnd)) {
            result.add(format(tempStart.getTime(), pattern));
            tempStart.add(Calendar.DAY_OF_YEAR, interval);
        }
        return result;
    }

    /**
     * 根据时间段之间的年-月集合
     *
     * @param minDate
     * @param maxDate
     * @return
     * @throws Exception
     *
     */
    public static List<String> getMonthBetween(String minDate, String maxDate,
                                               String format) throws Exception {
        if (SString.isBlank(SString.getTrimString(format))) {
            format = "yyyy-MM";
        }

        List<String> result = new ArrayList<String>();
        // 格式化为年月
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    /**
     * 根据时间段之间的年集合
     *
     * @param minDate
     * @param maxDate
     * @return
     * @throws Exception
     *
     */
    public static List<String> getYearBetween(String minDate, String maxDate,
                                               String format) throws Exception {
        if (SString.isBlank(SString.getTrimString(format))) {
            format = "yyyy-MM";
        }

        List<String> result = new ArrayList<String>();
        // 格式化为年月
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.YEAR, 1);
        }
        return result;
    }

    /**
     * 根据时间段之间的年-月集合
     *
     * @param minDate
     * @param maxDate
     * @return
     * @throws Exception
     *
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) throws Exception {
        String format = "yyyy-MM";

        return getMonthBetween(minDate, maxDate, format);
    }

    /**
     * Method description : 获取两个时间间隔(返回几天几时几分几秒几毫秒)
     *
     * Author：        guoqit-31263                
     * Create Date：   2017年3月2日 下午8:05:56
     * History:  2017年3月2日 下午8:05:56   guoqit-31263   Created.
     *
     * @param beginDate
     * @param endDate
     * @return
     *
     */
    public static String timeInterval(Date beginDate, Date endDate) {
        long between = 0;
        try {
            // 得到两者的毫秒数
            between = (endDate.getTime() - beginDate.getTime());
        } catch (Exception ex) {
            throw new SysException(ex);
        }
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000
                   - s * 1000);
        String result = day + "天" + hour + "小时" + min + "分" + s + "秒" + ms + "毫秒";
        return result;
    }

    /**
     * Method description : 将时间戳转为字符串
     *
     * @param timestamp
     * @return
     *
     */
    public static String timestampToDateTime(String timestamp) {
        String strTime = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(timestamp);
        Date date = new Date(lt);
        strTime = simpleDateFormat.format(date);
        return strTime;
    }
    
    public static String timestampToDateTime(String timestamp, String format) {
        String strTime = "";
        if (SString.isBlank(format)) {
            format = SDateTime.PATTERN_STANDARD19H;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date(Long.valueOf(timestamp));
        strTime = simpleDateFormat.format(date);
        return strTime;
    }

    /**
     * Method description : 将时间戳转为字符串
     *
     * @param timestamp
     * @return
     *
     */
    public static String timestampToDateTime(long timestamp) {
        String strTime = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timestamp);
        strTime = simpleDateFormat.format(date);
        return strTime;
    }

    /**
     * 获取往前(负数)推几天或往后几天的日期
     * 
     * @param dateStr
     * @param day
     * @return
     */
    public static String getDateAddDay(String dateStr, int day) {
        if (getDataFormat(dateStr).equals(PATTERN_STANDARD06W)) {
            dateStr = dateStr + "01";
        } else if (getDataFormat(dateStr).equals(PATTERN_STANDARD07H)) {
            dateStr = dateStr + "-01";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(dateStr, null));
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return getDate(calendar);
    }

    /**
     * 获取往前(负数)推几天或往后几天的日期
     * 
     * @param date
     * @param day
     * @return
     */
    public static Date getDateAddDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取往前(负数)推几年或往后几年的日期
     * 
     * @param date
     * @param year
     * @return
     */
    public static Date getDateAddYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);
        date = calendar.getTime();
        return date;
    }
    
    /**
     * 判断是否月末时间
     * 
     * @author yuexin.song
     * @param date
     * @return
     */
    public static Boolean isMonthEnd(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DATE) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 判断是否月初时间
     * 
     * @author yuexin.song
     * @param date
     * @return
     */
    public static Boolean isMonthStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DATE) == calendar.getActualMinimum(Calendar.DAY_OF_MONTH)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 判断闰年
     * 
     * @author yuexin.song
     * @param year
     * @return
     */
    public static Boolean isLeapYear(int year) {
        if ((year % 4 ==0 && year % 100 !=0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取往前(负数)推几个月或往后几个月的日期
     * 
     * @param date
     * @param month
     * @return
     */
    public static Date getDateAddMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        date = calendar.getTime();
        return date;
    }

    public enum DateType {
                          /**
                           * 年
                           */
                          YEAR,
                          /**
                           * 季度
                           */
                          QUARTER,
                          /**
                           * 月
                           */
                          MONTH,
                          /**
                           * 周
                           */
                          WEEK
    }

    public static List<String> getEveryDayByDateType(String dateStr, DateType dateType,
                                                     String pattern) {
        String startDate = "";
        String endDate = "";

        List<String> dateList = new ArrayList<String>();
        if (DateType.YEAR.equals(dateType)) {
            startDate = getFirstDayForCurrentYear(dateStr, pattern);
            endDate = getLastDayForCurrentYear(dateStr, pattern);
        } else if (DateType.QUARTER.equals(dateType)) {
            startDate = getFirstDayStartQuarter(dateStr, pattern);
            endDate = getLastDayStartQuarter(dateStr, pattern);
        } else if (DateType.MONTH.equals(dateType)) {
            startDate = getFirstDayForMonth(dateStr, pattern);
            endDate = getLastDayForMonth(dateStr, pattern);
        } else if (DateType.WEEK.equals(dateType)) {
            startDate = getFirstDayForWeek(dateStr, pattern);
            endDate = getLastDayForWeek(dateStr, pattern);
        }

        return getBetweenDates(startDate, endDate, 1, true, pattern);
    }

    /**
     * UTC时间转换Date格式
     * 
     * //T代表后面跟着时间，Z代表UTC统一时间
     * 
     * @param dateString
     * @return
     */
    public static Date datestrForUTC(String dateString, String formate) {
        if (SString.isBlank(dateString)) {
            return null;
        }
        if (SString.isBlank(formate)) {
            formate = PATTERN_UTC_MILLI_24TZ;
        }
        // 格式化时间 "2017-05-27T15:10:24.467Z";
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        String time = dateString;
        // 解析时间 2017-05-27T15:10:24.467Z
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            throw new SysException("时间转换失败", e);
        }
        return date;
    }

    /**
     * 将GMT字符串时间转Date格式
     * 
     * @param dateString
     * @return
     */
    public static Date datestrForGMT(String dateString) {
        //字符串转Date
        //String dateString = "Thu Oct 16 07:13:48 GMT 2015";
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_GMT, Locale.US);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            throw new SysException("时间转换失败", e);
        }
        return date;
    }
    
    /**
     * 仿朋友圈微信的几分钟前、几小时前、几天前、几周前、几月前、几年前的Java实现！
     * 
     * @author senhuaF-31049
     * @param d
     * @return
     */
    public static String getFriendlytime(Date d){  
        long delta = (new Date().getTime()-d.getTime())/1000;  
        if(delta<=0)return d.toLocaleString();  
        if(delta/(60*60*24*365) > 0) return delta/(60*60*24*365) + TIME_YEARS_BEFORE;  
        if(delta/(60*60*24*30) > 0) return delta/(60*60*24*30) + TIME_METHOD_BEFORE;  
        if(delta/(60*60*24*7) > 0)return delta/(60*60*24*7) + TIME_WEEK_BEFORE;  
        if(delta/(60*60*24) > 0) return delta/(60*60*24) + TIME_DAYS_BEFORE;  
        if(delta/(60*60) > 0)return delta/(60*60) + TIME_HOURS_BEFORE;  
        if(delta/(60) > 0)return delta/(60) + TIME_MINUTES_BEFORE;  
        return TIME_INFO;  
    }  

    /**
     * 将毫秒转换成时间
     * 
     * @param currentTimeMillis
     * @return
     */
    public static String getTimeFromMills(String currentTimeMillis) {
        if (SString.isBlank(currentTimeMillis)) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(currentTimeMillis));
        return format(calendar.getTime(), null);
    }

    /**
     * 判断dateStr是否在start和end中间，start和end都可以为null yyyyMMddHHmmss或者yyyyMMdd格式
     *
     * @author fsh
     * @param dateStr
     * @param start
     * @param end
     * @return
     */
    public static boolean checkDateVal(String dateStr, String start, String end) {
        boolean isDateRight = false;
        Date date = null;
        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat sdf = null;
        // 判断日期格式
        if (14 == dateStr.length()) {
            sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        } else if (8 == dateStr.length()) {
            sdf = new SimpleDateFormat("yyyyMMdd");
        } else
            return false;

        try {
            // 更改判断日期格式
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            LOG.error(e, e);
        }

        if ((start == null) && (end != null)) {
            try {
                endDate = sdf.parse(end);
            } catch (ParseException ex1) {
                LOG.error(ex1, ex1);
            }
            if ((date != null) && (endDate != null))// Check parameters for
            {
                if (date.compareTo(endDate) <= 0)
                    isDateRight = true;
            }
        } else if ((start != null) && (end == null)) {
            try {
                startDate = sdf.parse(start);
            } catch (ParseException ex1) {
                LOG.error(ex1, ex1);
            }
            if ((date != null) && (startDate != null)) {
                if (date.compareTo(startDate) >= 0)
                    isDateRight = true;
            }
        } else if ((start != null) && (end != null)) {
            try {
                startDate = sdf.parse(start);
                endDate = sdf.parse(end);
            } catch (ParseException ex2) {
                System.out.println(ex2.toString());
            }
            if ((startDate != null) && (date != null) && (endDate != null)) {
                if ((date.compareTo(startDate) >= 0)
                        && (date.compareTo(endDate) <= 0))
                    isDateRight = true;
            }
        }
        return isDateRight;
    }

    public static void main(String[] args) throws Exception {
        String formatStart = SDateTime.getNowDate();
        // 最后一年的最后一天
//        String endStr = SDateTime.format(endDate, SDateTime.PATTERN_STANDARD10H);
//        String formatEnd = SDateTime.getLastDayForCurrentYear(endStr, SDateTime.PATTERN_STANDARD10H);
        System.out.println(SDateTime.getNowDate());
        String formatEnd = SDateTime.getDateAddMonth(formatStart, -12);
        System.out.println(formatEnd);
        System.out.println(SDateTime.format(SDateTime.getDateAddYear(new Date(), -1), SDateTime.PATTERN_STANDARD10H));
        /**
        float days = timeCalculate("2004-05-11", "2005-12-05");
        System.out.println("days=" + days);
        System.err.println("=昨天=" + getDateAddDate(-1));
        System.out.println("=上个月第一天=" + getFirstDayForLastMonth(null));
        System.err.println("==本年第几季度==" + getSeason(new Date()));
        System.out.println("==上一季度第一天==" + getFirstDayOfQuarter(getNowYearOnly(),
            getSeason(new Date()) - 1, "yyyy-MM-dd"));
        System.out.println("==上一季度最后一天==" + getLastDayOfQuarter(getNowYearOnly(),
            getSeason(new Date()) - 1, "yyyy-MM-dd"));
        System.out.println("==上一季度最后一天==" + getLastDayOfLastQuarter(getNowYearOnly(),
            getSeason(new Date()), "yyyy-MM-dd"));
         **/

        //        System.out.println(getYesterday("2017-03-02", "yyyy-MM-dd"));
        //        System.err.println(getFirstDayForMonth("20170302", "yyyyMMdd"));
        //System.out.println(getLastDayForLastYear("2017-01-01", "yyyyMMdd"));
        //System.out.println(getFirstDayForLastYear(parseDate("2017-01"), "yyyy-MM-dd"));
        //System.out.println(getLastDayForCurrentYear(parseDate("2017-01"), "yyyy-MM-dd"));
        //System.out.println(getFirstDayForCurrentYear(parseDate("2017-01"), "yyyy-MM-dd"));
        //System.out.println(getLastDayStartQuarter(parseDate("2017-01"), "yyyy-MM-dd"));
        //System.out.println(getFirstDayStartQuarter(parseDate("2017-01"), "yyyy-MM-dd"));
        //System.out.println(getLastDayForLastWeek(parseDate("2017-01"), "yyyy-MM-dd"));
        //System.out.println(getFirstDayForLastWeek(parseDate("2017-01"), "yyyy-MM-dd"));
        //System.out.println(getLastDayForWeek(parseDate("2017-01"), "yyyy-MM-dd"));
        //System.out.println(getFirstDayForWeek(parseDate("2017-01"), "yyyy-MM-dd"));
        //System.out.println(getLastDayForLastMonth(parseDate("2017-01"), "yyyy-MM-dd"));
        //System.out.println(getFirstDayForLastMonth(parseDate("2017-01"), "yyyy-MM-dd"));
        //System.out.println(getLastDayForMonth(parseDate("2017-01"), "yyyy-MM-dd"));
        //System.out.println(getFirstDayForMonth(parseDate("2017-01"), "yyyy-MM-dd"));

        //System.out.println(parseDate("2017-01-01","yyyy-MM-dd HH:mm:ss"));
       /* System.out.println(parseDate("2017-01-01 23:00:00", false, true));
        System.out.println(timestampToDateTime(getLongTime("2017-01-01 00:00:00")));
        System.out.println(getDateAddDay("2017-02-01", -4));
        System.out.println(getYearOnly("2017-02-01"));

        System.out.println(
            getBetweenDates("2017-04-02 11:00:00", "2017-05-31 00:00:00", 2, true, "yyyy-MM-dd"));

        System.out.println(
            getEveryDayByDateType("2017-01-01", DateType.YEAR, SDateTime.PATTERN_STANDARD10H));
        System.out.println(timestampToDateTime(Long.parseLong("1496364900000")));
        System.out.println(timestampToDateTime(Long.parseLong("1496364840000")));
        System.out.println(timestampToDateTime(Long.parseLong("1491979151000")));*/
        // System.out.println(format(new Date(),"yyyy-MM-dd"));
        //System.out.println(getMonthBetween("2017-01","2017-07"));
        // System.out.println(timeCalculate("2017-03-13 00:00:00","2017-03-14 00:00:00"));

        //获取本周第一天
        //System.out.println(getFirstDayForWeek(new Date(), "yyyy-MM-dd HH:mm:ss"));
        //获取本周最后一天
        //System.out.println(getLastDayForWeek(new Date(), "yyyy-MM-dd HH:mm:ss"));

        //获取本周第一天
        //System.out.println(parseDate(getFirstDayForWeek(new Date(), "yyyy-MM-dd HH:mm:ss"),null));
        //获取本周最后一天
        //System.out.println(parseDate(getLastDayForWeek(new Date(), "yyyy-MM-dd HH:mm:ss"),null));
    }

    /**
     * 根据出生日期获取年龄
     * @param birthDay 出生日期
     * @return
     */
    public static Integer getAgeByBirthday(Date birthDay ){
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            }else{
                age--;
            }
        }
        return age;
    }
}