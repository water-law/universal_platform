package com.weitu.mpsplatform.commons.utils;

import com.weitu.mpsplatform.commons.exception.SysException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description : 时间工具类
 *
 * @author fsh
 */
public class DateTimeTools {

    private static final Log   LOG                      = LogFactory.getLog(DateTimeTools.class);

    public static final String PATTERN_STANDARD04W      = "yyyy";
    public static final String PATTERN_STANDARD06W      = "yyyyMM";
    public static final String PATTERN_STANDARD08W      = "yyyyMMdd";
    public static final String PATTERN_STANDARD12W      = "yyyyMMddHHmm";
    public static final String PATTERN_STANDARD14W      = "yyyyMMddHHmmss";
    public static final String PATTERN_STANDARD17W      = "yyyyMMddHHmmssSSS";

    public static final String PATTERN_STANDARD10H      = "yyyy-MM-dd";
    public static final String PATTERN_STANDARD16H      = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_STANDARD19H      = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_STANDARDTIMEZONE = "yyyy-MM-dd'T'HH:mm:ss";

    public static final String PATTERN_STANDARD10X      = "yyyy/MM/dd";
    public static final String PATTERN_STANDARD16X      = "yyyy/MM/dd HH:mm";
    public static final String PATTERN_STANDARD19X      = "yyyy/MM/dd HH:mm:ss";

    /**
     * 24小时格式化--时间
     */
    public static final String PATTERN_24_STANDARD05H   = "HH:mm";
    /**
     * 12小时格式化--时间
     */
    public final static String PATTERN_12_STANDARD05H     = "hh:mm";

    /**
     * 月份
     */
    public final static String PATTERN_MOUTHS_STANDARD05H      = "MM-dd";
    /**
     * 获取  当前年、半年、季度、月、日、小时 开始结束时间
     */
    private static final SimpleDateFormat shortSdf  = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
    private static final SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 单位秒
     */
    public static final long ONE_MINUTE = 60;
    /**
     * 单位秒
     */
    public static final long ONE_HOUR = 60 * 60;
    /**
     * 单位秒
     */
    public static final long ONE_DAY = 24 * 60 * 60;
    /**
     * 单位秒
     */
    public static final long ONE_YEAR = 365 * 24 * 60 * 60;

    /**
     * 刚刚
     */
    public final static String TIME_INFO            = "刚刚";

    /**
     * N分钟前
     */
    public final static String TIME_MINUTES_BEFORE  = "分钟前";

    /**
     * N小时前
     */
    public final static String TIME_HOURS_BEFORE    = "小时前";

    /**
     * N天前
     */
    public final static String TIME_DAYS_BEFORE     = "天前";

    /**
     * N月前
     */
    public final static String TIME_METHOD_BEFORE   = "个月前";

    /**
     * N年
     */
    public final static String TIME_YEARS_BEFORE    = "年前";

    /**
     * 昨天
     */
    public final static String YESTERDAY            = "昨天";

    /**
     * 上午
     */
    public final static String TIME_AM              = "上午";

    /**
     * 下午
     */
    public final static String TIME_PM              = "下午";

    /**
     * 1分钟前
     */
    public final static String FIRST_MINUTES_BEFORE = "1分钟前";

    /**
     * 应收日期类型
     */
    public static class RcvDateType {
        public static final String CYCLE_FIRST_FORWARD = "01";
        public static final String CYCLE_FIRST_BACKWARD      = "02";
        public static final String CYCLE_LAST_FORWARD = "03";
        public static final String CYCLE_LAST_BACKWARD      = "04";
    }

    /**
     * 应收计费周期
     */
    public static class PeriodType {
        /**
         * 每月
         */
        public static final String MONTH          = "01";
        /**
         * 双月
         */
        public static final String DOUBLE_MONTH      = "02";
        /**
         * 季度
         */
        public static final String QUARTER = "03";
        /**
         * 半年
         */
        public static final String HALF_YEAR = "04";
        /**
         * 一年
         */
        public static final String YEAR = "05";
    }

    /**
     * 计划周期
     */
    public static class PlanType {
        /**
         * 按日
         */
        public static final String DAY = "day";
        /**
         * 按周
         */
        public static final String WEEK = "week";
        /**
         * 按月
         */
        public static final String MONTH = "month";
        /**
         * 按年
         */
        public static final String YEAR = "year";
    }

    /**
     * 星期几
     */
    public static class WeekType {
        /**
         * 周日
         */
        public static final int SUNDAY = 7;
        /**
         * 周一
         */
        public static final int MONDAY = 1;
        /**
         * 周二
         */
        public static final int TUESDAY = 2;
        /**
         * 周三
         */
        public static final int WEDNESDAY = 3;
        /**
         * 周四
         */
        public static final int THURSDAY = 4;
        /**
         * 周五
         */
        public static final int FRIDAY = 5;
        /**
         * 周六
         */
        public static final int SATURDAY = 6;
    }

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
     * Method description : 时间转换
     *<br>
     *（1）一小时内，显示为xx分钟前;<br>
     *（2）大于1小时 && 小于24小时，显示为xx小时前;<br>
     *（3）大于24小时 && 小于48小时，显示：昨天xx:xx;<br>
     *（4）大于48小时 && 小于1年，显示：xx-xx xx:xx;<br>
     *（5）大于1年，显示：xxxx-xx-xx xx:xx;<br>
     *<br>
     *
     * @param date
     * @return
     *
     */
    public static String getTimeFromToday(Date date) {
    	if (date != null) {
    		Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            long time = date.getTime() / 1000;
            long now = System.currentTimeMillis() / 1000;
            long ago = now - time;
            if (ago < ONE_MINUTE) {
            	return "刚刚";
            }
            else if (ago > ONE_MINUTE && ago <= ONE_HOUR)  {
            	return ago / ONE_MINUTE + "分钟前";
            }
            else if (ago <= ONE_DAY)  {
            	return ago / ONE_HOUR + "小时前";
            }
            else if (ago > ONE_DAY && ago <= ONE_DAY * 2) {
            	return "昨天 " + format(date, PATTERN_24_STANDARD05H);
            }
            else if (ago > ONE_DAY * 2 && ago <= ONE_YEAR)  {
            	return format(date, PATTERN_MOUTHS_STANDARD05H) + " "
            			+ format(date, PATTERN_24_STANDARD05H);
            }
            else {
                return format(date, PATTERN_STANDARD16H);
            }
    	}
        return "";
    }

    /**
     * 取得当前日期和时间
     *
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
        if ((thedate1 == 1) || (thedate1 == 2) || (thedate1 == 3) || (thedate1 == 4)
            || (thedate1 == 5) || (thedate1 == 6) || (thedate1 == 7) || (thedate1 == 8)
            || (thedate1 == 9)) {
            thedate = "0" + thedate1;
        } else {
            thedate = String.valueOf(thedate1);
        }
        themonth1 = calendar.get(Calendar.MONTH) + 1;
        if ((themonth1 == 1) || (themonth1 == 2) || (themonth1 == 3) || (themonth1 == 4)
            || (themonth1 == 5) || (themonth1 == 6) || (themonth1 == 7) || (themonth1 == 8)
            || (themonth1 == 9)) {
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

        if (nowhourstring.length() < 2) {
            nowhourstring = "0" + nowhourstring;
        }
        if (nowminutestring.length() < 2) {
            nowminutestring = "0" + nowminutestring;
        }
        if (nowsecondstring.length() < 2) {
            nowsecondstring = "0" + nowsecondstring;
        }
        nowtime = nowhourstring + ":" + nowminutestring + ":" + nowsecondstring;
        return nowtime;
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
        if (weekday == 7) {
            nowweekday = "星期日";
        } else if (weekday == 1) {
            nowweekday = "星期一";
        } else if (weekday == 2) {
            nowweekday = "星期二";
        } else if (weekday == 3) {
            nowweekday = "星期三";
        } else if (weekday == 4) {
            nowweekday = "星期四";
        } else if (weekday == 5) {
            nowweekday = "星期五";
        } else if (weekday == 6) {
            nowweekday = "星期六";
        }
        return (nowweekday);
    }

    /**
     * 获取一个时间是星期几
     *
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
        if (weekday == 7) {
            theweekday = "星期日";
        } else if (weekday == 1) {
            theweekday = "星期一";
        } else if (weekday == 2) {
            theweekday = "星期二";
        } else if (weekday == 3) {
            theweekday = "星期三";
        } else if (weekday == 4) {
            theweekday = "星期四";
        } else if (weekday == 5) {
            theweekday = "星期五";
        } else if (weekday == 6) {
            theweekday = "星期六";
        }
        return (theweekday);
    }

    /**
     * 获取一个时间是星期几
     *
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
            LOG.error(Thread.currentThread().getId(), e);
        }
        int days = (int) timeCalculate(thedate, date) - 1;
        String theweekday = "";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        if (weekday == 7) {
            theweekday = "星期日";
        } else if (weekday == 1) {
            theweekday = "星期一";
        } else if (weekday == 2) {
            theweekday = "星期二";
        } else if (weekday == 3) {
            theweekday = "星期三";
        } else if (weekday == 4) {
            theweekday = "星期四";
        } else if (weekday == 5) {
            theweekday = "星期五";
        } else if (weekday == 6) {
            theweekday = "星期六";
        }
        return (theweekday);
    }

    /**
     * 日期加减
     *
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
        if ((thedate1 == 1) || (thedate1 == 2) || (thedate1 == 3) || (thedate1 == 4)
            || (thedate1 == 5) || (thedate1 == 6) || (thedate1 == 7) || (thedate1 == 8)
            || (thedate1 == 9)) {
            thedate = "0" + thedate1;
        } else {
            thedate = String.valueOf(thedate1);
        }

        themonth1 = calendar.get(Calendar.MONTH) + 1;
        if ((themonth1 == 1) || (themonth1 == 2) || (themonth1 == 3) || (themonth1 == 4)
            || (themonth1 == 5) || (themonth1 == 6) || (themonth1 == 7) || (themonth1 == 8)
            || (themonth1 == 9)) {
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
     *
     * @param date
     * @param hour
     * @return String
     */
    public static String getDateAddHour(String date, int hour) {
        String nowdate = getNowDateTime();
        date = getTime(StringUtils.trimToEmpty(date));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date thedateNowdate = null;
        Date insideDateDate = null;
        try {
            thedateNowdate = format.parse(nowdate);
            insideDateDate = format.parse(date);
        } catch (Exception e) {
            LOG.error(Thread.currentThread().getId(), e);
        }
        int hours = (int) timeCalculateHour(thedateNowdate, insideDateDate);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, hours + hour);
        return getDate(calendar);
    }

    /**
     * 小时加减
     *
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
            LOG.error(Thread.currentThread().getId(), e);
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
     * @return String
     */
    public static String getDateAddMinutes(Date date, int minute) {
        String nowdate = getNowDateTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date thedateNowdate = null;
        try {
            thedateNowdate = format.parse(nowdate);
        } catch (Exception e) {
            LOG.error(Thread.currentThread().getId(), e);
        }
        int minutes = (int) timeCalculateMinutes(thedateNowdate, date);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minutes + minute);
        return getDate(calendar);
    }

    /**
     * 秒加减
     *
     * @param date
     * @param seconds
     * @return String
     */
    public static String getDateAddSeconds(Date date, int seconds) {
        String nowdate = getNowDateTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date thedateNowdate = null;
        try {
            thedateNowdate = format.parse(nowdate);
        } catch (Exception e) {
            LOG.error(Thread.currentThread().getId(), e);
        }
        int second = (int) timeCalculateSeconds(thedateNowdate, date);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, second + seconds);

        return getDate(calendar);
    }

    /**
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
            LOG.error(Thread.currentThread().getId(), e);
        }
        return (flag);
    }

    /**
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
            LOG.error(Thread.currentThread().getId(), e);
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
            LOG.error(Thread.currentThread().getId(), e);
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
            LOG.error(Thread.currentThread().getId(), e);
        }
        return (day);
    }

    /**
     * 计算小时差
     *
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
            LOG.error(Thread.currentThread().getId(), e);
        }
        return hour;
    }

    /**
     * 计算时差
     *
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
     * 计算分钟差
     *
     * @param date1
     * @param date2
     * @return double
     */
    public static double timeCalculateMinutes(Date date1, Date date2) {
        double minutes = 0;
        double millisecond = date2.getTime() - date1.getTime();
        minutes = millisecond / (60 * 1000);
        return minutes;
    }

    /**
     * 计算秒差
     *
     * @param date1
     * @param date2
     * @return double
     */
    public static double timeCalculateSeconds(Date date1, Date date2) {
        return (date2.getTime() - date1.getTime()) / 1000;
    }

    /**
     *
     * 计算两个期间相差几个月
     *  date2 - date1
     *  format格式：yyyy-MM-dd
     *
     *  先比较年，再比较月份，年之差*12+月份之差
     *
     * @author fsh
     * @param date1
     * @param date2
     * @return
     */
    public static int timeCalculateMonth(String date1, String date2, String format) {
        return SDateTime.timeCalculateMonth(date1, date2, format);
    }

    /**
     * 取得当前时间
     *
     * @param time
     * @return long
     */
    public static long getLongTime(String time) {
        time = getTime(StringUtils.trimToEmpty(time));
        long longtime = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = format.parse(time);
            longtime = date.getTime();
        } catch (Exception e) {
            LOG.error(Thread.currentThread().getId(), e);
        }
        return longtime;
    }

    /**
     * 字符串转换时间
     *
     * @param datestring
     * @param theformat
     * @return Date
     */
    public static Date parseDate(String datestring, String theformat) {
        if (StringUtils.isBlank(datestring) && !"null".equals(datestring)) {
            return null;
        }
        datestring = datestring.trim();
        if (StringUtils.isBlank(theformat)) {
            datestring = getTime(datestring);
            theformat = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(theformat);
        Date date = null;
        try {
            date = format.parse(datestring);
        } catch (Exception e) {
            LOG.error(Thread.currentThread().getId(), e);
        }
        return date;
    }

    /**
     *
     * 方法说明：将java.util.Date 格式转换为字符串格式如：
     * 'yyyy-MM-dd HH:mm:ss'(24小时制)或者：'yyyy-MM-dd'日期
     *
     * Author：        fsh
     *
     * @param time Date 日期<br>
     * @param formatStr 格式化字符串类型
     * @return String   字符串<br>
     *
     */
    public static String dateToString(Date time,String formatStr) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat(formatStr);
        String ctime = formatter.format(time);
        return ctime;
    }

    /**
     *
     * 方法说明：字符串转日期
     *
     * Author：        fsh
     *
     * @param dateStr 日期字符串
     * @param formatStr 格式化字符串类型
     * @return
     *
     */
    public static Date stringToDate(String dateStr,String formatStr) {
        Date date = new Date();
        try {
            DateFormat sdf = new SimpleDateFormat(formatStr);
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     *取系统当前时间:返回只值为如下形式
     *2002-10-30
     *@return String
     */
    public static String getYYYY_MM_DD() {
        return dateToString(new Date()).substring(0, 10);

    }

    /**
     *取系统当前时间:返回只值为如下形式
     *20021030
     *@return String
     */
    public static String getYYYYMMDD(String dateStr) {
        String L_curDate = null;
        if(dateStr != null && !"".equals(dateStr)){
            L_curDate = dateStr;
        }else{
            L_curDate = getYYYY_MM_DD();
        }
        String L_curDate2 = L_curDate.substring(0, 4) +
                L_curDate.substring(5, 7) +
                L_curDate.substring(8, 10);
        return L_curDate2;
    }

    /**
     *取系统当前时间:返回只值为如下形式
     *2002
     *@return String
     */
    public static String getYYYY(String dateStr) {
        String L_curDate = null;
        if(dateStr != null && !"".equals(dateStr)){
            L_curDate = dateStr;
        }else{
            L_curDate = getYYYY_MM_DD();
        }
        String L_curDate2 = L_curDate.substring(0, 4) ;
        return L_curDate2;
    }

    /**
     *取系统当前时间:返回只值为如下形式
     *021030
     *@return String
     */
    public static String getYYMMDD(String dateStr) {
        String L_curDate = null;
        if(dateStr != null && !"".equals(dateStr)){
            L_curDate = dateStr;
        }else{
            L_curDate = getYYYY_MM_DD();
        }
        String L_curDate2 = L_curDate.substring(2, 4) +
                L_curDate.substring(5, 7) +
                L_curDate.substring(8, 10);
        return L_curDate2;
    }

    /**
     * 对小时进行相加操作
     * @param addNumber 要增加的小时数
     * @return String 格式yyyy-mm-dd
     */
    public static String getHourAdd(int addNumber) {
        String returnStr = "";
        SimpleDateFormat forma=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dd=new Date();
        Calendar g=Calendar.getInstance();
        g.setTime(dd);
        g.add(Calendar.HOUR,addNumber);
        returnStr=forma.format(g.getTime());
        return returnStr;
    }

    /**
     * 对日期进行相加操作
     * @param date 日期字符串格式为yyyy-mm-dd
     * @param addNumber 要增加的天数
     * @return String 格式yyyy-mm-dd
     */
    public static String getDateAdd(String date, int addNumber) {
        String returnStr = "";
        StringTokenizer token = new StringTokenizer(date, "-");
        int num = token.countTokens();
        if (num == 3) {
            int year;
            int month;
            int day;
            year = Integer.parseInt(token.nextToken());
            month = Integer.parseInt(token.nextToken());
            day = Integer.parseInt(token.nextToken());
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calen = Calendar.getInstance();
            calen.set(year, month - 1, day);
            calen.add(5, addNumber); //5代表日期，1代表年，2代表月
            returnStr = formatter.format(calen.getTime());
        } else {
            returnStr = date;
        }
        return returnStr;
    }

    /**
     * 对日期进行相加操作
     * @param date 日期字符串格式为yyyy-mm-dd
     * @param addNumber 要增加的天数
     * @param formatStr 格式化字符串类型如：yyyyMMdd
     * @return String 格式由上面格式化字符串定义
     */
    public static String getDateAdd(String date, int addNumber, String formatStr) {
        String returnStr = "";
        StringTokenizer token = new StringTokenizer(date, "-");
        int num = token.countTokens();
        if (num == 3) {
            int year;
            int month;
            int day;
            year = Integer.parseInt(token.nextToken());
            month = Integer.parseInt(token.nextToken());
            day = Integer.parseInt(token.nextToken());
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat(formatStr);
            Calendar calen = Calendar.getInstance();
            calen.set(year, month - 1, day);
            calen.add(5, addNumber); //5代表日期，1代表年，2代表月
            returnStr = formatter.format(calen.getTime());
        } else {
            returnStr = date;
        }
        return returnStr;
    }

    /**
     * 对日期进行相加操作(对月操作)
     * @param date 日期字符串格式为yyyy-mm-dd
     * @param addNumber 要月
     * @return String 格式yyyy-mm-dd
     */
    public static String getDateMonthAdd(String date, int addNumber) {
        String returnStr = "";
        StringTokenizer token = new StringTokenizer(date, "-");
        int num = token.countTokens();
        if (num == 3) {
            int year;
            int month;
            int day;
            year = Integer.parseInt(token.nextToken());
            month = Integer.parseInt(token.nextToken());
            day = Integer.parseInt(token.nextToken());
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calen = Calendar.getInstance();
            calen.set(year, month - 1, day);
            calen.add(2, addNumber); //5代表日期，1代表年，2代表月
            returnStr = formatter.format(calen.getTime());
        } else {
            returnStr = date;
        }
        return returnStr;
    }

    /**
     * 对日期进行相加操作(对月操作)
     * @param date 日期字符串格式为yyyy-mm-dd
     * @param addNumber 要月
     * @param formatStr 格式化字符串类型如：yyyyMM或：yyyyMMdd
     * @return String 格式由上面格式化字符串定义
     */
    public static String getDateMonthAdd(String date, int addNumber, String formatStr) {
        String returnStr = "";
        StringTokenizer token = new StringTokenizer(date, "-");
        int num = token.countTokens();
        if (num == 3) {
            int year;
            int month;
            int day;
            year = Integer.parseInt(token.nextToken());
            month = Integer.parseInt(token.nextToken());
            day = Integer.parseInt(token.nextToken());
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat(formatStr);
            Calendar calen = Calendar.getInstance();
            calen.set(year, month - 1, day);
            calen.add(2, addNumber); //5代表日期，1代表年，2代表月
            returnStr = formatter.format(calen.getTime());
        } else {
            returnStr = date;
        }
        return returnStr;
    }


    /**
     * 对日期进行相加操作(对年操作)
     * @param date 日期字符串格式为yyyy-mm-dd
     * @param addNumber 要年
     * @return String 格式yyyy-mm-dd
     */
    public static String getDateYearAdd(String date, int addNumber) {
        String returnStr = "";
        StringTokenizer token = new StringTokenizer(date, "-");
        int num = token.countTokens();
        if (num == 3) {
            int year;
            int month;
            int day;
            year = Integer.parseInt(token.nextToken());
            month = Integer.parseInt(token.nextToken());
            day = Integer.parseInt(token.nextToken());
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calen = Calendar.getInstance();
            calen.set(year, month - 1, day);
            calen.add(1, addNumber); //5代表日期，1代表年，2代表月
            returnStr = formatter.format(calen.getTime());
        } else {
            returnStr = date;
        }
        return returnStr;
    }

    /**
     * 对日期进行相加操作(对年操作)
     * @param date 日期字符串格式为yyyy-mm-dd
     * @param addNumber 要年
     * @param formatStr 格式化字符串类型如：yyyy或：yyyyMM
     * @return String 格式由上面格式化字符串定义
     */
    public static String getDateYearAdd(String date, int addNumber, String formatStr) {
        String returnStr = "";
        StringTokenizer token = new StringTokenizer(date, "-");
        int num = token.countTokens();
        if (num == 3) {
            int year;
            int month;
            int day;
            year = Integer.parseInt(token.nextToken());
            month = Integer.parseInt(token.nextToken());
            day = Integer.parseInt(token.nextToken());
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat(formatStr);
            Calendar calen = Calendar.getInstance();
            calen.set(year, month - 1, day);
            calen.add(1, addNumber); //5代表日期，1代表年，2代表月
            returnStr = formatter.format(calen.getTime());
        } else {
            returnStr = date;
        }
        return returnStr;
    }

    /**
     * 字符串转换到时间格式
     * @param dateString 需要转换的字符串
     * @param formatStr 需要格式的目标字符串  举例 yyyy-MM-dd
     * @return Date 返回转换后的时间
     * @throws NullPointerException - 如果 text 或 pos 为 null。
     */
    public static Date stringtoDate(String dateString, String formatStr) throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat(formatStr);
        Date date = null;

        try
        {
            date = ft.parse(dateString);
        }
        catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 计算给定时间至今的天数
     *
     * @since 1.1
     * @param date
     *            给定的时间
     * @return 给定时间至今的天数
     */
    public static long date2day(String date) {
        long day = 0;
        DateFormat df = DateFormat.getDateInstance();
        try {
            long old = df.parse(date).getTime();
            long now = new Date().getTime();
            long secs = now - old;
            day = secs / (1000 * 24 * 60 * 60);
        } catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * 获得与某日期相隔几天的日期
     *
     * @param date     指定的日期
     * @param addCount 相隔的天数,可以是负数，表示日期前几天
     * @return 返回的日期
     * @throws com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException 解析异常
     */
    public static Date addDay(Date date, int addCount) throws com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, addCount);

        return calendar.getTime();
    }

    /**
     * 获得与某日期相隔几月的日期
     *
     * @param date     指定的日期
     * @param addCount 相隔的月数,可以是负数，表示日期前几月
     * @return 返回的日期
     * @throws com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException 解析异常
     */
    public static Date addMonth(Date date, int addCount) throws com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, addCount);
        return calendar.getTime();
    }






    /**
     * 字符串转换时间    超出日期，不自动转换  （eg: 2011-12-33  =>    2012-01-02）
     *
     * @param datestring
     * @param theformat
     * @return Date
     */
    public static Date parseDateWithNotLenient(String datestring, String theformat) {
        if (StringUtils.isBlank(datestring) && !"null".equals(datestring)) {
            return null;
        }
        datestring = datestring.trim();
        if (StringUtils.isBlank(theformat)) {
            datestring = getTime(datestring);
            theformat = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(theformat);
        format.setLenient(false);
        Date date = null;
        try {
            date = format.parse(datestring);
        } catch (Exception e) {
            System.out.println("-=");
            LOG.error(Thread.currentThread().getId(), e);
        }
        return date;
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
     * 取得月份的天数
     *
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
     *
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
     *
     * @return int
     */
    public static int getNowYearOnly() {
        int year;
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        return year;
    }

    /**
     * 取得当前月份
     *
     * @return int
     */
    public static int getNowMonthOnly() {
        int month;
        Calendar calendar = Calendar.getInstance();
        month = calendar.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 取得当前日期
     *
     * @return int
     */
    public static int getNowDateOnly() {
        int date;
        Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DATE);
        return date;
    }

    /**
     * 取得单前小时
     *
     * @return int
     */
    public static int getNowHourOnly() {
        int hour;
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    /**
     * 取得单前分钟
     *
     * @return int
     */
    public static int getNowMinuteOnly() {
        int hour;
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.MINUTE);
        return hour;
    }

    /**
     * 取得单前秒钟
     *
     * @return int
     */
    public static int getNowSecondOnly() {
        int hour;
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.SECOND);
        return hour;
    }

    /**
     * 取得日期
     *
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
        if ((thedate1 == 1) || (thedate1 == 2) || (thedate1 == 3) || (thedate1 == 4)
            || (thedate1 == 5) || (thedate1 == 6) || (thedate1 == 7) || (thedate1 == 8)
            || (thedate1 == 9)) {
            thedate = "0" + thedate1;
        } else {
            thedate = String.valueOf(thedate1);
        }
        themonth1 = calendar.get(Calendar.MONTH) + 1;
        if ((themonth1 == 1) || (themonth1 == 2) || (themonth1 == 3) || (themonth1 == 4)
            || (themonth1 == 5) || (themonth1 == 6) || (themonth1 == 7) || (themonth1 == 8)
            || (themonth1 == 9)) {
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

        if (nowhourstring.length() < 2) {
            nowhourstring = "0" + nowhourstring;
        }
        if (nowminutestring.length() < 2) {
            nowminutestring = "0" + nowminutestring;
        }
        if (nowsecondstring.length() < 2) {
            nowsecondstring = "0" + nowsecondstring;
        }
        nowtime = nowhourstring + ":" + nowminutestring + ":" + nowsecondstring;

        return nowday + " " + nowtime;
    }

    /**
     *
     * @param time
     * @return
     */
    private static String getTime(String time) {
        if (String.valueOf(time).split(" ").length < 2) {
            time = time + " 00:00:00";
        }
        return time;
    }

    /**
     * 天加减
     *
     * @param date
     * @param day
     * @return
     */
    public static String getDateAddDay(String date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(date, null));
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return getDate(calendar);
    }

    public static Date getDateAddDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //把日期往后增加一天.整数往后推,负数往前移动
        calendar.add(Calendar.DATE, 1);
        //这个时间就是日期往后推一天的结果
        date = calendar.getTime();
        return date;
    }

    /**
     * 月份加减
     *
     * @param date
     * @param day
     * @return
     */
    public static String getDateAddMonth(String date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(date, null));
        calendar.add(Calendar.MONTH, day);
        return getDate(calendar);
    }

    /**
     * 获取一个时间是星期几 数字
     *
     * @param thedate
     * @return
     */
    public static int getWeekDayNum(String thedate) {
        String nowdate = getNowDate() + " 00:00:00";
        int days = (int) timeCalculate(nowdate, thedate) - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        return (weekday);
    }

    /**
     *  获取两个日期相差的月数
     * @param d1    较大的日期
     * @param d2    较小的日期
     */
    public static int getMonthDiff(String d1, String d2, String theformat) {
        Date date1 = parseDate(d1, theformat);
        Date date2 = parseDate(d2, theformat);
        if (date1.compareTo(date2) < 0) {
            return getMonthDiff(date2, date1);
        } else {
            return getMonthDiff(date1, date2);
        }
    }

    /**
    *  获取两个日期相差的月数
    * @param d1    较大的日期
    * @param d2    较小的日期
    * @return  如果d1>d2返回 月数差 否则返回0
    */
   public static int getMonthDiff(Date d1, Date d2) {
       Calendar c1 = Calendar.getInstance();
       Calendar c2 = Calendar.getInstance();
       c1.setTime(d1);
       c2.setTime(d2);
       if(c1.getTimeInMillis() < c2.getTimeInMillis()) return 0;
       int year1 = c1.get(Calendar.YEAR);
       int year2 = c2.get(Calendar.YEAR);
       int month1 = c1.get(Calendar.MONTH);
       int month2 = c2.get(Calendar.MONTH);
       int day1 = c1.get(Calendar.DAY_OF_MONTH);
       int day2 = c2.get(Calendar.DAY_OF_MONTH);
       // 获取年的差值 假设 d1 = 2015-8-16  d2 = 2011-9-30
       int yearInterval = year1 - year2;
       // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
       if(month1 < month2 || month1 == month2 && day1 < day2) yearInterval --;
       // 获取月数差值
       int monthInterval =  (month1 + 12) - month2  ;
       if(day1 < day2) monthInterval --;
       monthInterval %= 12;
       return yearInterval * 12 + monthInterval;

   }
    /**
     * 当前月前五个月显示
     *
     * @param dateFormat
     * @return
     */
    @SuppressWarnings({ "rawtypes" })
    public static List getYearAndMonth(String dateFormat) {// dateFormat 显示格式
        // format the date
        SimpleDateFormat objSdft = new SimpleDateFormat(dateFormat);
        // get the Calendar object
        Calendar objCal = Calendar.getInstance();
        // get the current date
        Date dateNow = objCal.getTime();
        // get the latest 6th month
        objCal.add(Calendar.MONTH, -5);
        // 画面的下拉框
        List<String> lstQueryDate = new ArrayList<String>();
        // 当前月之前的第6个月的日期
        Date dateBefore = objCal.getTime();
        // 取得前5个月的日期
        while (dateBefore.before(dateNow)) {
            // 日期格式化
            lstQueryDate.add(objSdft.format(dateBefore));
            objCal.add(Calendar.MONTH, 1);
            dateBefore = objCal.getTime();
        }
        // 当前月日期
        lstQueryDate.add(objSdft.format(dateNow));
        // list倒序显示
        Collections.reverse(lstQueryDate);
        return lstQueryDate;
    }

    /**
     * 取某月的上一月份
     * @param theYearMonth
     * @return
     */
    public static String getTheLastYearMonth(String theYearMonth) {
        String theYear = theYearMonth.substring(0, 4);
        String theMonth = theYearMonth.substring(4);
        int theIntMonth = Integer.parseInt(theMonth);
        int theIntYear = Integer.parseInt(theYear);
        if (--theIntMonth == 0) {
            theIntMonth = 12;
            theIntYear--;
        }
        String theLastMonth = Integer.toString(theIntMonth);
        if (theLastMonth.length() == 1) {
            theLastMonth = "0" + theLastMonth;
        }
        return Integer.toString(theIntYear) + theLastMonth;
    }

    /**
     * 获取时间date1与date2相差的秒数
     *
     * @param date1
     *            起始时间
     * @param date2
     *            结束时间
     * @return 返回相差的秒数
     */
    public static int getOffsetSeconds(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / 1000);
    }

    /**
     * Method description : timezone转成需要的时间格式时间
     *
     * Author：        fsh
     *
     * @param timeZoneStr
     * @param dateFormat
     * @return
     *
     */
    public static String getTimeZoneToDateStr(String timeZoneStr, String dateFormat) {
        String formattedTime = "";
        if (SString.isNotBlank(timeZoneStr)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_STANDARDTIMEZONE);
                SimpleDateFormat output = new SimpleDateFormat(dateFormat);
                Date d = sdf.parse(timeZoneStr);
                formattedTime = output.format(d);
            } catch (ParseException e) {
                LOG.error(e);
            }
        }
        return formattedTime;

    }

    /**
     * Method description : 获取两个时间间隔(返回几天几时几分几秒几毫秒)
     *
     * Author：        fsh
     *
     * @param beginDate
     * @param endDate
     * @return
     *
     */
    public static String timeInterval(String beginDate, String endDate) {
        if (SString.isBlank(beginDate) || SString.isBlank(endDate)) {
            return "";
        }
        long between = 0;
        try {
            Date beginTime = parseDate(beginDate, null);
            Date endTime = parseDate(endDate, null);
            // 得到两者的毫秒数
            between = (endTime.getTime() - beginTime.getTime());
        } catch (Exception ex) {
           throw new SysException(ex);
        }
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String result = day + "天" + hour + "小时" + min + "分" + s + "秒";
        return result;
    }


    /**
     * Method description : 获取两个时间间隔(返回几天几时几分几秒几毫秒)
     *
     * Author：        fsh
     *
     * @param timelong
     * @return
     *
     */
    public static String timeInterval(long timelong) {
        if (timelong == 0) {
            return "";
        }
        long between = timelong;
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String result = "";
        if (day > 0) {
        	result += day + "天";
        }
        if (hour > 0) {
        	result += hour + "小时";
        }
        if (min > 0) {
        	result += min + "分";
        }
        if (s > 0) {
        	result += s + "秒";
        }
        return result;
    }
    /**
     * 获取两个时间的时间差，精确到毫秒
     * @param start
     * @param end
     * @return
     */
    public static String timeInterval(long start, long end) {
        long between = end - start;
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
                - min * 60 * 1000 - s * 1000);
        String timeInterval = day + "天" + hour + "小时" + min + "分" + s + "秒" + ms
                + "毫秒";
        return timeInterval;
    }

    /**
     *
     * 获取两个日期   相差天数
     *
     *
     * @param startDate
     * @param endDate
     * @return
     *
     */
    public static int getBetweenDays(String startDate, String endDate) {
        Date start = parseDate(startDate, "yyyyMMdd");
        Date end = parseDate(endDate, null);
        long startlong = start.getTime();
        long endlong = end.getTime();

        int oneday = 1000 * 60 * 60 * 24;

        return (int) Math.ceil(Math.abs(endlong - startlong) / oneday);
    }

    public static int getBetweenDays(String startDate, Date endDate) {
        return getBetweenDays(startDate, format(endDate, null));
    }

    public static Date convert2FirstDayForMonth(Date date) {
        String dateStr = format(date, "yyyy-MM-dd");
        String firstDateStr = getFirstDayForMonth(dateStr, "yyyy-MM-dd");
        return parseDate(firstDateStr, null);
    }

    public static Date convert2LastForMonth(Date date) {
        String dateStr = format(date, "yyyy-MM-dd");
        String firstDateStr = getLastDayForMonth(dateStr, "yyyy-MM-dd");
        return parseDate(firstDateStr, null);
    }

    /**
     * 当月第一天
     *
     * @param dateStr 指定年月/年月日
     * @param format 日期格式化
     * @return
     */
    public static String getFirstDayForMonth(String dateStr, String format) {
        SimpleDateFormat simpleDateFormat = setFirstFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
    }

    public static SimpleDateFormat setFirstFormat(String format) {
        if (SString.isBlank(format)) {
            format = "yyyy-MM-dd";
        }
        if ("yyyy-MM-dd HH:mm:ss".equals(format) || "yyyy-MM-dd hh:mm:ss".equals(format)) {
            format = "yyyy-MM-dd 00:00:00";
        }
        return new SimpleDateFormat(format);
    }

    /**
     * 当月最后一天
     *
     * @param dateStr 指定年月/年月日
     * @param format 日期格式化
     * @return
     */
    public static String getLastDayForMonth(String dateStr, String format) {
        SimpleDateFormat simpleDateFormat = setLastFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(setCalendarTime(dateStr, format));
        int value = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, value);
        Date thisDate = calendar.getTime();
        return simpleDateFormat.format(thisDate);
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

    public static SimpleDateFormat setLastFormat(String format) {
        if (SString.isBlank(format)) {
            format = "yyyy-MM-dd";
        }
        if ("yyyy-MM-dd HH:mm:ss".equals(format)) {
            format = "yyyy-MM-dd 23:59:59";
        }
        if ("yyyy-MM-dd hh:mm:ss".equals(format)) {
            format = "yyyy-MM-dd 11:59:59";
        }
        return new SimpleDateFormat(format);
    }

    /**
     * 生成  startDate 日期前的 offset 个月的  月份（yyyy-mm）/（yyyymm）列表
     * @param startDate
     * @param format
     * @param offset    小于0
     * @return
     *
     */
    public static List<String> getBetweenMonth(Date startDate, String format, int offset) {
        List<String> months = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        int count = Math.abs(offset);
        int index = 0;
        if (offset < 0) {
            index = -1;
        } else {
            index = 1;
        }
        months.add(format(calendar.getTime(), format));
        for (int i = 0; i < count; i++) {
            calendar.add(Calendar.MONTH, index);
            months.add(format(calendar.getTime(), format));
        }
        return months;
    }

    /**
     * Method description : 判断时间格式是否正确
     *
     * Author：        fsh
     *
     * @param str
     * @param dateFormat
     * @return
     *
     */
    public static boolean isValidDate(String str, String dateFormat) {
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        try {
            Date date = (Date) formatter.parse(str);
            return str.equals(formatter.format(date));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     *
     * @param rcvDateType
     * @param bgnDate
     * @param endDate
     * @return
     */
    public static final String getPeroidDate(String rcvDateType, String bgnDate, String endDate) {
        if (SString.isBlank(SString.getTrimString(rcvDateType))) {
            return null;
        }
        //周期初向前、向后
        if (RcvDateType.CYCLE_FIRST_FORWARD.equals(rcvDateType)
            || RcvDateType.CYCLE_FIRST_BACKWARD.equals(rcvDateType)) {
            return bgnDate;
        }
        //周期末向前、向后
        else if (RcvDateType.CYCLE_LAST_FORWARD.equals(rcvDateType)
                 || RcvDateType.CYCLE_LAST_BACKWARD.equals(rcvDateType)) {
            return endDate;
        }
        return null;
    }

    /**
     * 获取应收日期
     *
     * @param periodType
     * @param rcvDateType
     * @param inputDate
     * @param dayNums
     * @return
     *
     */
    public static String getRcvDate(String periodType, String rcvDateType, String inputDate,
                                    int dayNums) {
        if ("".equals(SString.getTrimString(periodType))
            || "".equals(SString.getTrimString(rcvDateType))) {
            return null;
        }
        String handleDate = "";

        //周期初向前
        if (RcvDateType.CYCLE_FIRST_FORWARD.equals(rcvDateType)) {
            if (PeriodType.MONTH.equals(periodType)) {
                handleDate = SDateTime.getFirstDayForMonth(inputDate,
                    SDateTime.PATTERN_STANDARD10H);
                handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
            }
            //双月(周期初向前)
            else if (PeriodType.DOUBLE_MONTH.equals(periodType)) {
                int month = SDateTime.getMonthOnly(inputDate);
                int year = SDateTime.getYearOnly(inputDate);
                //有余数
                if (month % 2 != 0) {
                    handleDate = SDateTime.getFirstDayForMonth(inputDate,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
                //无余数(calendar.set(year, month, 1)为+1月)
                } else {
                    handleDate = SDateTime.getFirstDayOfMonth(year, month - 2,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
                }
            } else if (PeriodType.QUARTER.equals(periodType)) {
                handleDate = SDateTime.getFirstDayStartQuarter(inputDate,
                    SDateTime.PATTERN_STANDARD10H);
                handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
            }
            //半年
            else if (PeriodType.HALF_YEAR.equals(periodType)) {
                int month = SDateTime.getMonthOnly(inputDate);
                int year = SDateTime.getYearOnly(inputDate);
                if (month > 6) {
                    handleDate = SDateTime.getFirstDayOfMonth(year, 7 - 1,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
                } else {
                    handleDate = SDateTime.getFirstDayOfMonth(year, 1 - 1,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
                }
            } else if (PeriodType.YEAR.equals(periodType)) {
                handleDate = SDateTime.getFirstDayForCurrentYear(inputDate,
                    SDateTime.PATTERN_STANDARD10H);
                handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
            }
        }
        //周期初向后
        else if (RcvDateType.CYCLE_FIRST_BACKWARD.equals(rcvDateType)) {
            if (PeriodType.MONTH.equals(periodType)) {
                handleDate = SDateTime.getFirstDayForMonth(inputDate,
                    SDateTime.PATTERN_STANDARD10H);
                handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
            }
            //双月(周期初向后)
            else if (PeriodType.DOUBLE_MONTH.equals(periodType)) {
                int month = SDateTime.getMonthOnly(inputDate);
                int year = SDateTime.getYearOnly(inputDate);
                //有余数
                if (month % 2 != 0) {
                    handleDate = SDateTime.getFirstDayForMonth(inputDate,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
                //无余数(calendar.set(year, month, 1)为+1月)
                } else {
                    handleDate = SDateTime.getFirstDayOfMonth(year, month - 2,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
                }
            } else if (PeriodType.QUARTER.equals(periodType)) {
                handleDate = SDateTime.getFirstDayStartQuarter(inputDate,
                    SDateTime.PATTERN_STANDARD10H);
                handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
            }
            //半年
            else if (PeriodType.HALF_YEAR.equals(periodType)) {
                int month = SDateTime.getMonthOnly(inputDate);
                int year = SDateTime.getYearOnly(inputDate);
                if (month > 6) {
                    handleDate = SDateTime.getFirstDayOfMonth(year, 7 - 1,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
                } else {
                    handleDate = SDateTime.getFirstDayOfMonth(year, 1 - 1,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
                }
            } else if (PeriodType.YEAR.equals(periodType)) {
                handleDate = SDateTime.getFirstDayForCurrentYear(inputDate,
                    SDateTime.PATTERN_STANDARD10H);
                handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
            }
        }
        //周期末向前
        else if (RcvDateType.CYCLE_LAST_FORWARD.equals(rcvDateType)) {
            if (PeriodType.MONTH.equals(periodType)) {
                handleDate = SDateTime.getLastDayForMonth(inputDate, SDateTime.PATTERN_STANDARD10H);
                handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
            }
            //双月(周期末向前)
            else if (PeriodType.DOUBLE_MONTH.equals(periodType)) {
                int month = SDateTime.getMonthOnly(inputDate);
                int year = SDateTime.getYearOnly(inputDate);
                //有余数
                if (month % 2 == 0) {
                    handleDate = SDateTime.getLastDayForMonth(inputDate,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
                //无余数(calendar.set(year, month, 1)为+1月)
                } else {
                    handleDate = SDateTime.getLastDayOfMonth(year, month,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
                }
            } else if (PeriodType.QUARTER.equals(periodType)) {
                handleDate = SDateTime.getLastDayStartQuarter(inputDate,
                    SDateTime.PATTERN_STANDARD10H);
                handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
            }
            //半年
            else if (PeriodType.HALF_YEAR.equals(periodType)) {
                int month = SDateTime.getMonthOnly(inputDate);
                int year = SDateTime.getYearOnly(inputDate);
                if (month > 6) {
                    handleDate = SDateTime.getLastDayOfMonth(year, 11,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
                } else {
                    handleDate = SDateTime.getLastDayOfMonth(year, 5,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
                }
            } else if (PeriodType.YEAR.equals(periodType)) {
                handleDate = SDateTime.getLastDayForCurrentYear(inputDate,
                    SDateTime.PATTERN_STANDARD10H);
                handleDate = SDateTime.getDateAddDay(handleDate, -dayNums);
            }
        }
        //周期末向后
        else if (RcvDateType.CYCLE_LAST_BACKWARD.equals(rcvDateType)) {
            if (PeriodType.MONTH.equals(periodType)) {
                handleDate = SDateTime.getLastDayForMonth(inputDate, SDateTime.PATTERN_STANDARD10H);
                handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
            }
            //双月(周期末向后)
            else if (PeriodType.DOUBLE_MONTH.equals(periodType)) {
                int month = SDateTime.getMonthOnly(inputDate);
                int year = SDateTime.getYearOnly(inputDate);
                //有余数
                if (month % 2 == 0) {
                    handleDate = SDateTime.getLastDayForMonth(inputDate,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
                //无余数(calendar.set(year, month, 1)为+1月)
                } else {
                    handleDate = SDateTime.getLastDayOfMonth(year, month,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
                }
            } else if (PeriodType.QUARTER.equals(periodType)) {
                handleDate = SDateTime.getLastDayStartQuarter(inputDate,
                    SDateTime.PATTERN_STANDARD10H);
                handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
            }
            //半年
            else if (PeriodType.HALF_YEAR.equals(periodType)) {
                int month = SDateTime.getMonthOnly(inputDate);
                int year = SDateTime.getYearOnly(inputDate);
                if (month > 6) {
                    handleDate = SDateTime.getLastDayOfMonth(year, 11,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
                } else {
                    handleDate = SDateTime.getLastDayOfMonth(year, 5,
                        SDateTime.PATTERN_STANDARD10H);
                    handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
                }
            } else if (PeriodType.YEAR.equals(periodType)) {
                handleDate = SDateTime.getLastDayForCurrentYear(inputDate,
                    SDateTime.PATTERN_STANDARD10H);
                handleDate = SDateTime.getDateAddDay(handleDate, dayNums);
            }
        }
        if (!"".equals(handleDate)) {
            handleDate = SDateTime.format(SDateTime.parseDate(handleDate),
                SDateTime.PATTERN_STANDARD10H);
        }
        return handleDate;
    }

    /**
     * 首页时间段计算
     * 1、当传入时间与当前时间对比小于1时，显示1分钟。
     * 2、当传入时间与当前时间对比小于60分钟时，显示N分钟。
     * 3、当传入时间与当前时间对比大于N个小时小于1天时，则显示具体时间。例如：下午1:00 或者 13:00
     * 4、当传入时间与当前时间对比等于1天时，则显示具体时间。例如：昨天 下午1:00 或者 昨天 13:00
     * 5、当传入时间与当前时间对比大于1<365天时，则显示具体时间。例如：04-28 下午1:00 或者 04-28 13:00
     * 6、当传入时间与当前时间对比大于等于1年时，则显示具体时间。例如：2014-12-30 下午1:00 或者 2014-12-30 13:00
     *
     * @param busiDate 传入时间
     * @return
     */
    public static String timeLogic(Date busiDate) {
        if (busiDate == null) {
            LOG.error("入参为空！");
            return "";
        }
        return timeLogics(busiDate);
    }

    /**
     *
     * @param busiDate
     * @return
     */
    private static String timeLogics(Date busiDate) {
        StringBuilder commonTimeCale = new StringBuilder();
        //按分钟计算
        //为了保证计算方便，将时间进行统一。
        Date sysDate = new Date();
        String sysTime = DateTimeTools.format(sysDate, PATTERN_STANDARD19H);
        sysDate = DateTimeTools.parseDate(sysTime, PATTERN_STANDARD19H);
        String inputTime = DateTimeTools.format(busiDate, PATTERN_STANDARD19H);
        busiDate = DateTimeTools.parseDate(inputTime, PATTERN_STANDARD19H);

        //分钟差
        double minutesCalu = DateTimeTools.timeCalculateMinutes(busiDate, sysDate);
        //小时差
        double hoursCalu = DateTimeTools.timeCalculateHour(busiDate, sysDate);
        //天差
        //float yearCalu = DateTimeTools.timeCalculateFloat(busiDate, sysDate);
        int daysCal = sysDate.getDate() - busiDate.getDate();
        int years = sysDate.getYear() - busiDate.getYear();
        int months = sysDate.getMonth() - busiDate.getMonth();
        //int dateLength = new Date().getHours();//当前系统时间制式：12/24小时制
        //传入时间的上下午标志。
        String apFlag = DateTimeTools.format(busiDate, "a");

        //不到1分钟
        if (minutesCalu < 1) {
            commonTimeCale.append(FIRST_MINUTES_BEFORE);
        //不到1小时
        } else if (minutesCalu < 60 && hoursCalu < 1) {
            commonTimeCale
                .append((int) minutesCalu + TIME_MINUTES_BEFORE);
        //按照12、24小时制区分
        } else {
            //上午
            if (apFlag.equals(TIME_AM)) {
                commonTimeCale = setTwelfthTime(busiDate, years, months, daysCal, hoursCalu,
                    apFlag);
            } else {
                commonTimeCale = setTwoFourTime(busiDate, years, months, daysCal, hoursCalu,
                    apFlag);
            }
        }
        return commonTimeCale.toString();
    }

    /**
     * 24小时制转换
     *
     * @param busiDate
     * @param hoursCalu
     * @param daysCalu
     * @param apFlag
     * @return
     */
    public static StringBuilder setTwoFourTime(Date busiDate, int years, int months, int daysCalu,
                                               double hoursCalu, String apFlag) {
        //24小时制
        StringBuilder commonTimeCale = new StringBuilder();
        String nowTime = "";
        nowTime = DateTimeTools.format(busiDate, PATTERN_24_STANDARD05H);
        //大于一小时,并且小于1天
        if (hoursCalu >= 1 && daysCalu < 1 && months < 1 && years < 1) {
            //上午
            if (apFlag.indexOf(TIME_AM) != -1) {
                commonTimeCale.append(TIME_AM + nowTime);
            //下午
            } else if (apFlag.indexOf(TIME_PM) != -1) {
                commonTimeCale.append(nowTime);
            }
        //相差1天，昨天时间
        } else if (daysCalu == 1 && months < 1 && years < 1) {
            //上午
            if (apFlag.indexOf(TIME_AM) != -1) {
                commonTimeCale.append(YESTERDAY + " "
                                      + TIME_AM + nowTime);
            //下午
            } else if (apFlag.indexOf(TIME_PM) != -1) {
                commonTimeCale.append(YESTERDAY + " " + nowTime);
            }
        //月份，大于1天时间，并且小于一年内的时间，则显示增早时间。。
        } else if ((daysCalu >= 1 || months >= 1) && years < 1) {
            String nowMounth = DateTimeTools.format(busiDate,
                PATTERN_MOUTHS_STANDARD05H);
            //上午
            if (apFlag.indexOf(TIME_AM) != -1) {
                commonTimeCale
                    .append(nowMounth + " " + TIME_AM + nowTime);
            //下午
            } else if (apFlag.indexOf(TIME_PM) != -1) {
                commonTimeCale.append(nowMounth + " " + nowTime);
            }
        //跨年
        } else if (years >= 1) {
            String yearsCom = DateTimeTools.format(busiDate,
                PATTERN_STANDARD10H);
            //上午
            if (apFlag.indexOf(TIME_AM) != -1) {
                commonTimeCale
                    .append(yearsCom + " " + TIME_AM + nowTime);
            //下午
            } else if (apFlag.indexOf(TIME_PM) != -1) {
                commonTimeCale.append(yearsCom + " " + nowTime);
            }
        }
        return commonTimeCale;
    }

    /**
     * 12小时转换
     *
     * @param busiDate
     * @param hoursCalu
     * @param apFlag
     * @param daysCalu
     * @return
     */
    public static StringBuilder setTwelfthTime(Date busiDate, int years, int months, int daysCalu,
                                               double hoursCalu, String apFlag) {
        StringBuilder commonTimeCale = new StringBuilder();
        String nowTime = "";
        //12小时制 格式化：hh:mm
        nowTime = DateTimeTools.format(busiDate, PATTERN_12_STANDARD05H);
        //时间转换
        String convertDate = DateTimeTools.format(busiDate, "HH");
        if (convertDate.contains("00")) {
            //格式化：HH:mm
            nowTime = DateTimeTools.format(busiDate, PATTERN_24_STANDARD05H);
        }
        //大于一小时,并且小于1天
        if (hoursCalu >= 1 && daysCalu < 1 && months < 1 && years < 1) {
            //上午
            if (apFlag.indexOf(TIME_AM) != -1) {
                commonTimeCale.append(TIME_AM + nowTime);
            //下午
            } else if (apFlag.indexOf(TIME_PM) != -1) {
                commonTimeCale.append(TIME_PM + nowTime);
            }
        //相差1天，昨天时间
        } else if (daysCalu == 1 && months < 1 && years < 1) {
            //上午
            if (apFlag.indexOf(TIME_AM) != -1) {
                commonTimeCale.append(YESTERDAY + " "
                                      + TIME_AM + nowTime);
            //下午
            } else if (apFlag.indexOf(TIME_PM) != -1) {
                commonTimeCale.append(YESTERDAY + " "
                                      + TIME_PM + nowTime);
            }
        //月份，大于1天时间，并且小于一年内的时间，则显示增早时间。。
        } else if ((daysCalu >= 1 || months >= 1) && years < 1) {
            String nowMounth = DateTimeTools.format(busiDate,
                PATTERN_MOUTHS_STANDARD05H);
            //上午
            if (apFlag.indexOf(TIME_AM) != -1) {
                commonTimeCale
                    .append(nowMounth + " " + TIME_AM + nowTime);
            //下午
            } else if (apFlag.indexOf(TIME_PM) != -1) {
                commonTimeCale
                    .append(nowMounth + " " + TIME_PM + nowTime);
            }
        //跨年
        } else if (years >= 1) {
            String yearsCom = DateTimeTools.format(busiDate,
                PATTERN_STANDARD10H);
            //上午
            if (apFlag.indexOf(TIME_AM) != -1) {
                commonTimeCale
                    .append(yearsCom + " " + TIME_AM + nowTime);
            //下午
            } else if (apFlag.indexOf(TIME_PM) != -1) {
                commonTimeCale
                    .append(yearsCom + " " + TIME_PM + nowTime);
            }
        }
        return commonTimeCale;
    }

    /**
     * 获取计划日期
     *
     * @param planType 计划类型 day 按天 week 按周 month 按月 year 按年
     * @param startDate 开始日期
     * @param endDate  结束日期
     * @param interval 间隔 按天(每天为1 间隔天数 具体数字) 按周(7周日 1 周一 2 周二 3 周三 4 周四 5 周五 6周六)  按月(1-31的日期) 按年(年-月-日格式日期数据)
     * @return
     *
     */
    public static List<String> getPlatDate(String planType, String startDate, String endDate, String interval) {
    	if ( SString.isBlank(planType) ) {
    		return null;
    	}

    	if ( SString.isBlank(interval) ) {
    		return null;
    	}

    	if ( SString.isBlank(startDate) || SString.isBlank(endDate) ) {
    		return null;
    	}

    	List<String> planDates = new ArrayList<String>();

    	//按日
    	if ( PlanType.DAY.equals(planType) ) {
    		planDates = SDateTime.getBetweenDates(startDate, endDate,Integer.parseInt(interval),true,SDateTime.PATTERN_STANDARD10H);
    	}

    	//按周
    	if ( PlanType.WEEK.equals(planType) ) {
    		Calendar cal = Calendar.getInstance();
            cal.setTime(SDateTime.parseDate(startDate));
            int weekIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if(weekIndex < 0){
            	weekIndex = 0;
            }
            int weekInterval = Integer.parseInt(interval);
            if ( weekInterval == WeekType.SUNDAY) {
            	weekInterval = 0;
            }

            String initDate = "";
            if( weekIndex == weekInterval ) {
            	initDate = startDate;
            	if ( ((int)SDateTime.timeCalculate(initDate, endDate)) >=0 ) {
            		planDates.add(initDate);
            	}
            	while( ((int)SDateTime.timeCalculate(initDate, endDate)) >= 0 ) {
            		initDate = SDateTime.getDateAddDay(initDate, 7);
            		initDate = SDateTime.format(SDateTime.parseDate(initDate),SDateTime.PATTERN_STANDARD10H);
            		if ( ((int)SDateTime.timeCalculate(initDate, endDate)) >=0 ) {
            			planDates.add(initDate);
            		}
            	}
            } else if ( weekIndex < weekInterval ) {
            	initDate = SDateTime.getDateAddDay(startDate, (weekInterval-weekIndex));
            	initDate = SDateTime.format(SDateTime.parseDate(initDate),SDateTime.PATTERN_STANDARD10H);
            	if ( ((int)SDateTime.timeCalculate(initDate, endDate)) >=0 ) {
            		planDates.add(initDate);
            	}
            	while( ((int)SDateTime.timeCalculate(initDate, endDate)) >= 0 ) {
            		initDate = SDateTime.getDateAddDay(initDate, 7);
            		initDate = SDateTime.format(SDateTime.parseDate(initDate),SDateTime.PATTERN_STANDARD10H);
            		if ( ((int)SDateTime.timeCalculate(initDate, endDate)) >=0 ) {
            			planDates.add(initDate);
            		}
            	}
            } else {
            	initDate = SDateTime.getDateAddDay(startDate, (weekInterval-weekIndex));
            	initDate = SDateTime.format(SDateTime.parseDate(initDate),SDateTime.PATTERN_STANDARD10H);
            	if ( ((int)SDateTime.timeCalculate(startDate, initDate)) >=0 ) {
            		planDates.add(initDate);
            	}
            	while( ((int)SDateTime.timeCalculate(initDate, endDate)) >= 0 ) {
            		initDate = SDateTime.getDateAddDay(initDate, 7);
            		initDate = SDateTime.format(SDateTime.parseDate(initDate),SDateTime.PATTERN_STANDARD10H);
            		if ( ((int)SDateTime.timeCalculate(initDate, endDate)) >=0 ) {
            			planDates.add(initDate);
            		}
            	}
            }
    	}

    	//按月
    	if ( PlanType.MONTH.equals(planType) ) {
    		String initDate = "";
    		int year = SDateTime.getYearOnly(startDate);
    		int month = SDateTime.getMonthOnly(startDate);
    		int day = Integer.parseInt(interval);
    		initDate = SString.getString(year) + "-" + (month>9?SString.getString(month):"0"+SString.getString(month)) + "-" + (day>9?SString.getString(day):"0"+SString.getString(day));
    		if ( ((int)SDateTime.timeCalculate(initDate, endDate)) >=0 ) {
        		planDates.add(initDate);
        	}
    		while( ((int)SDateTime.timeCalculate(initDate, endDate)) >= 0 ) {
    			if ( month == 12 ) {
    				year = year + 1;
    				month = 1;
    			} else {
    				month = month + 1;
    			}
    			initDate = SString.getString(year) + "-" + (month>9?SString.getString(month):"0"+SString.getString(month)) + "-" + (day>9?SString.getString(day):"0"+SString.getString(day));
        		if ( ((int)SDateTime.timeCalculate(initDate, endDate)) >=0 ) {
        			planDates.add(initDate);
        		}
        	}
    	}

    	//按年
		if ( PlanType.YEAR.equals(planType) ) {
			String initDate = "";
    		initDate = interval;
    		if ( ((int)SDateTime.timeCalculate(initDate, endDate)) >=0 ) {
        		planDates.add(initDate);
        	}
    		while( ((int)SDateTime.timeCalculate(initDate, endDate)) >= 0 ) {
    			int year = SDateTime.getYearOnly(initDate) + 1;
        		int month = SDateTime.getMonthOnly(initDate);
        		int day = SDateTime.getDayOnly(initDate);
    			initDate = SString.getString(year) + "-" + (month>9?SString.getString(month):"0"+SString.getString(month)) + "-" + (day>9?SString.getString(day):"0"+SString.getString(day));
        		if ( ((int)SDateTime.timeCalculate(initDate, endDate)) >=0 ) {
        			planDates.add(initDate);
        		}
        	}
		}

        return planDates;
    }

    /**
     * 获取下一个月时间起始时间
     *  格式化时间：yyyy-MM-dd
     *
     * @author fsh
     * @param expPeroidDate
     * @param busiBgnDate
     * @return
     */
    private static String getPreMonthStartDateHandle(String expPeroidDate, String busiBgnDate) {
        String month = "";
        String dayStr = "";
        if (isValidDate(expPeroidDate, SDateTime.PATTERN_STANDARD08W)) {
            expPeroidDate = SDateTime.format(SDateTime.parseDate(expPeroidDate, SDateTime.PATTERN_STANDARD08W), SDateTime.PATTERN_STANDARD10H);
        }
        if (isValidDate(busiBgnDate, SDateTime.PATTERN_STANDARD08W)) {
            busiBgnDate = SDateTime.format(SDateTime.parseDate(busiBgnDate, SDateTime.PATTERN_STANDARD08W), SDateTime.PATTERN_STANDARD10H);
        }

        if (!isValidDate(expPeroidDate, SDateTime.PATTERN_STANDARD10H)) {
            return null;
        }
        if (!isValidDate(busiBgnDate, SDateTime.PATTERN_STANDARD10H)) {
            return null;
        }

        // 业务参数当前天数
        int busiDay = SDateTime.getDayOnly(busiBgnDate);
        // 计费账期月份
        int monthInt = SDateTime.getMonthOnly(expPeroidDate);
        // 计费账期当期月最后一天
        String expPeroidDateLast = SDateTime.getLastDayForMonth(expPeroidDate, SDateTime.PATTERN_STANDARD10H);
        int expPeroidDateDay = SDateTime.getDayOnly(expPeroidDateLast);

        month = SDateTime.format(SDateTime.parseDate(expPeroidDate, SDateTime.PATTERN_STANDARD07H), SDateTime.PATTERN_STANDARD07H);

        // 2,4,6,9,11 月份
        if ((monthInt == SDateTime.NUMBER_TWO || monthInt == SDateTime.NUMBER_FOUR || monthInt == SDateTime.NUMBER_SIX || monthInt == SDateTime.NUMBER_NINE ||
                monthInt == SDateTime.NUMBER_ELEVEN) && busiDay > expPeroidDateDay) {
            dayStr = String.valueOf(expPeroidDateDay);
        }

        if (SString.isBlank(dayStr)) {
            dayStr = SDateTime.format(SDateTime.parseDate(busiBgnDate, SDateTime.PATTERN_STANDARD10H), "dd");
        }
        String allDate = new StringBuffer().append(month).append("-").append(dayStr).toString();
        if (!isValidDate(allDate, SDateTime.PATTERN_STANDARD10H)) {
            return null;
        }

        return allDate;
    }

    /**
     * 获取下一个月时间起始时间
     *  格式化时间：yyyyMMdd
     *
     * @author fsh
     * @param expPeroidDate
     * @param busiBgnDate
     * @return
     */
    public static String getPreMonthStartDate(String expPeroidDate, String busiBgnDate) {
        String allDate = getPreMonthStartDateHandle(expPeroidDate, busiBgnDate);
        if (SString.isNotBlank(allDate)) {
            allDate = SDateTime.format(SDateTime.parseDate(allDate, SDateTime.PATTERN_STANDARD10H), SDateTime.PATTERN_STANDARD08W);
        }

        return allDate;
    }

    /**
     * 获取下一个月时间结束时间
     *  格式：yyyy-MM-dd
     *
     * @author fsh
     * @param allBgnDate
     * @param busiBgnDate
     * @return
     */
    private static String getPreMonthEndDateHandle(String allBgnDate, String busiBgnDate) {
        String dateResult = null;

        if (isValidDate(allBgnDate, SDateTime.PATTERN_STANDARD08W)) {
            allBgnDate = SDateTime.format(SDateTime.parseDate(allBgnDate, SDateTime.PATTERN_STANDARD08W), SDateTime.PATTERN_STANDARD10H);
        } else {
            if (!isValidDate(allBgnDate, SDateTime.PATTERN_STANDARD10H)) {
                return null;
            }
        }

        if (isValidDate(busiBgnDate, SDateTime.PATTERN_STANDARD08W)) {
            busiBgnDate = SDateTime.format(SDateTime.parseDate(busiBgnDate, SDateTime.PATTERN_STANDARD08W), SDateTime.PATTERN_STANDARD10H);
        }

        if (!isValidDate(busiBgnDate, SDateTime.PATTERN_STANDARD10H)) {
            return null;
        }

        // 业务参数当前天数
        int busiDay = SDateTime.getDayOnly(busiBgnDate);
        // 当前计费账期天数
        int allDay = SDateTime.getDayOnly(allBgnDate);
        // 当前计费账期月
        int monthInt = SDateTime.getMonthOnly(allBgnDate);

        // 月初
        if (SDateTime.isMonthStart(SDateTime.parseDate(allBgnDate, SDateTime.PATTERN_STANDARD10H)) || busiDay == SDateTime.NUMBER_ONE) {
            return SDateTime.getLastDayForMonth(allBgnDate, SDateTime.PATTERN_STANDARD10H);
        }

        if (SDateTime.isMonthEnd(SDateTime.parseDate(allBgnDate, SDateTime.PATTERN_STANDARD10H))) {
            // 28、29、30
            if (allDay == SDateTime.NUMBER_TWENTY_EIGHT || allDay == SDateTime.NUMBER_TWENTY_NINE || allDay == SDateTime.NUMBER_THIRTY) {
                return SDateTime.getDateAddDay(SDateTime.getLastDayForMonth(SDateTime.getDateAddMonth(allBgnDate, SDateTime.NUMBER_ONE), SDateTime.PATTERN_STANDARD10H), -1);
            }
            // 31
            if (allDay == SDateTime.NUMBER_THIRTY_ONE) {
                if (monthInt + 1 == SDateTime.NUMBER_TWO || monthInt == SDateTime.NUMBER_SEVEN || monthInt == SDateTime.NUMBER_TWELVE) {
                    dateResult = SDateTime.getDateAddDay(SDateTime.getDateAddMonth(allBgnDate, SDateTime.NUMBER_ONE), -1);
                } else {
                    dateResult = SDateTime.getDateAddMonth(allBgnDate, SDateTime.NUMBER_ONE);
                }
            }
        } else {
            String allBgnDateLast = SDateTime.getLastDayForMonth(allBgnDate, SDateTime.PATTERN_STANDARD10H);
            int allBgnDateLastDay = SDateTime.getDayOnly(allBgnDateLast);
            int subDay = new BigDecimal(String.valueOf(allBgnDateLastDay)).subtract(new BigDecimal(String.valueOf(allDay)))
                        .add(new BigDecimal(1)).intValue();

            dateResult = SDateTime.getDateAddMonth(allBgnDate, SDateTime.NUMBER_ONE);
            if (monthInt + 1 == SDateTime.NUMBER_TWO && SDateTime.isMonthEnd(SDateTime.parseDate(dateResult, SDateTime.PATTERN_STANDARD10H))) {
                dateResult = SDateTime.getDateAddDay(dateResult, -subDay);
            } else {
                dateResult = SDateTime.getDateAddDay(dateResult, -1);
            }
        }

        if (SString.isNotBlank(dateResult)) {
            dateResult = SDateTime.format(SDateTime.parseDate(dateResult, SDateTime.PATTERN_STANDARD19H), SDateTime.PATTERN_STANDARD10H);
        }
        return dateResult;
    }

    /**
     *
     * 获取下一个月时间结束时间
     *  格式：yyyyMMdd
     *
     * @author fsh
     * @param allBgnDate
     * @param busiBgnDate
     * @return
     */
    public static String getPreMonthEndDate(String allBgnDate, String busiBgnDate) {
        String dateResult = getPreMonthEndDateHandle(allBgnDate, busiBgnDate);
        if (SString.isNotBlank(dateResult)) {
            dateResult = SDateTime.format(SDateTime.parseDate(dateResult, SDateTime.PATTERN_STANDARD10H), SDateTime.PATTERN_STANDARD08W);
        }

        return dateResult;
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
     * 获得本周的第一天，周一
     *
     * @return
     */
    public static Date getCurrentWeekDayStartTime() {
        Calendar c = Calendar.getInstance();
        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;
            c.add(Calendar.DATE, -weekday);
            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c.getTime();
    }

    /**
     * 获得本周的最后一天，周日
     *
     * @return
     */
    public static Date getCurrentWeekDayEndTime() {
        Calendar c = Calendar.getInstance();
        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK);
            c.add(Calendar.DATE, 8 - weekday);
            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c.getTime();
    }

    /**
     *
     * 方法说明：获取本周一（第一天）
     * 解决周日会出现 并到下一周的情况
     * 因为按中国礼拜一作为第一天
     *
     * Author： fsh
     *
     * @param date
     * @return
     *
     */
    public static Date getNowWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1); // 解决周日会出现 并到下一周的情况
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     *
     * 方法说明：获取上周一（第一天）
     * 解决周日会出现 并到下一周的情况
     * 因为按中国礼拜一作为第一天
     *
     * Author： fsh
     *
     * @param date
     * @return
     *
     */
    public static Date getLastWeekMonday(Date date) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.add(Calendar.WEEK_OF_YEAR, -1);// 一周
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     *
     * 方法说明：获取上周日（最后一天）
     * 解决周日会出现 并到下一周的情况
     * 因为按中国礼拜一作为第一天
     *
     * Author： fsh
     *
     * @param date
     * @return
     *
     */
    public static Date getLastWeekSunday(Date date) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.set(Calendar.DAY_OF_WEEK, 1);
        return cal.getTime();
    }

    /**
     * 获得本天的开始时间，即2012-01-01 00:00:00
     *
     * @return
     */
    public static Date getCurrentDayStartTime() {
        Date now = new Date();
        try {
            now = shortSdf.parse(shortSdf.format(now));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获得本天的结束时间，即2012-01-01 23:59:59
     *
     * @return
     */
    public static Date getCurrentDayEndTime() {
        Date now = new Date();
        try {
            now = longSdf.parse(shortSdf.format(now) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获得本小时的开始时间，即2012-01-01 23:59:59
     *
     * @return
     */
    public static Date getCurrentHourStartTime() {
        Date now = new Date();
        try {
            now = longHourSdf.parse(longHourSdf.format(now));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获得本小时的结束时间，即2012-01-01 23:59:59
     *
     * @return
     */
    public static Date getCurrentHourEndTime() {
        Date now = new Date();
        try {
            now = longSdf.parse(longHourSdf.format(now) + ":59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获得本月的开始时间，即2012-01-01 00:00:00
     *
     * @return
     */
    public static Date getCurrentMonthStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前月的结束时间，即2012-01-31 23:59:59
     *
     * @return
     */
    public static Date getCurrentMonthEndTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            c.add(Calendar.MONTH, 1);
            c.add(Calendar.DATE, -1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前年的开始时间，即2012-01-01 00:00:00
     *
     * @return
     */
    public static Date getCurrentYearStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.MONTH, 0);
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前年的结束时间，即2012-12-31 23:59:59
     *
     * @return
     */
    public static Date getCurrentYearEndTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.MONTH, 11);
            c.set(Calendar.DATE, 31);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }
    /**
     * 获取当前年月（日期）为第几季度，即：2015-10-10为第四季度 2016-01-23为第一季度
     * @return
     */
    public static String getCurrentMonthHowMuchSeasons() {
        SimpleDateFormat longF = new SimpleDateFormat("yyyy");
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        String now = "";
        int season = 1;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                season = 1;
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                season = 2;
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                season = 3;
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                season = 4;
            }
            now = longF.format(c.getTime())+'-'+season;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     *
     * 方法说明：获取当前输入季度的,向后几个季度
     *
     * Author：        fsh
     *
     * @param reportingPeriod
     * @param continuousMonths 向后几个季度
     * @return
     *
     */
    public static String getReportingPeriodNextData(String reportingPeriod,int continuousMonths) {
        String reportingPeriodNextData = "";
        if (!"".equals(reportingPeriod) && reportingPeriod != null ) {
            //to_char(substr('2015-4', 1, 4) +
            //trunc((substr('2015-4', -1) + 10 - 1) / 4)) || '-' ||
            //  to_char(1 + mod((substr('2015-4', -1) + 10 - 1), 4))
            //上面的10代表向后10个季度
            //上面这段是oracle中的计算方法，下面这段是Java的方式计算的。
            //--上面这段是相加得到前台传进来的如：2015-4季度那么年就是2016
            //该方法是计算机当前季度向前几个季度
            //.substring(abilityToGrow.getReportingPeriod().length()-1))+20-1)这里加20代表向后20个季度
            int n1 = Integer.parseInt(reportingPeriod.substring(0,4))+
                    ((Integer.parseInt(reportingPeriod.substring(reportingPeriod.length()-1))+continuousMonths-1)/4);
            // --下面这一段是求余是前台传进来的如：2015-4季度那么季度就是1
            int s1 = 1+((Integer.parseInt(reportingPeriod.substring(reportingPeriod.length()-1)) + continuousMonths - 1)%4);
            reportingPeriodNextData =  n1+"-"+s1;
        }
        return reportingPeriodNextData;
    }
    /**
     *
     * 方法说明：获取当前输入季度的,向前几个季度
     *
     * Author：        fsh
     *
     * @param reportingPeriod
     * @param continuousMonths 向前几个季度
     * @return
     *
     */
    public static String getReportingPeriodData(String reportingPeriod,int continuousMonths) {
        String reportingPeriodData = "";
        if (!"".equals(reportingPeriod) && continuousMonths > 0 && reportingPeriod != null ) {
            //to_char(substr(a.reportingperiod, 1, 4) -
            //trunc((3 + 4 - substr(a.reportingperiod, -1)) / 4)) || '-' ||
            //to_char(4 -mod(3 + 4 - substr(a.reportingperiod, -1), 4))
            //上面这段是oracle中的计算方法，下面这段是Java的方式计算的。
            //--上面这段是相减得到前台传进来的如：2015-4季度那么年就是2016
            //该方法是计算机当前季度向后几个季度
            int n = Integer.parseInt(reportingPeriod.substring(0,4))-
                    ((continuousMonths+4-Integer.parseInt(reportingPeriod.substring(reportingPeriod.length()-1)))/4);
            // --下面这一段是求余
            int s = 4-((continuousMonths +4 - Integer.parseInt(reportingPeriod.substring(reportingPeriod.length()-1)))%4);
            reportingPeriodData =  n+"-"+s;
        }
        return reportingPeriodData;
    }

    /**
     * 当前季度的开始时间，即2012-01-1 00:00:00
     *
     * @return
     */
    public static Date getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的结束时间，即2012-03-31 23:59:59
     *
     * @return
     */
    public static Date getCurrentQuarterEndTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }
    /**
     * 获取前/后半年的开始时间
     * @return
     */
    public static Date getHalfYearStartTime(){
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6){
                c.set(Calendar.MONTH, 0);
            }else if (currentMonth >= 7 && currentMonth <= 12){
                c.set(Calendar.MONTH, 6);
            }
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;

    }
    /**
     *
     * 方法说明：获取前/后半年的结束时间
     *
     * Author：        fsh
     *
     * @return
     *
     */
    public static Date getHalfYearEndTime(){
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6){
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            }else if (currentMonth >= 7 && currentMonth <= 12){
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     *
     * 方法说明：获取前一天日期 及星期
     *
     * Author：        fsh
     *
     *
     */
    private static void initDate(){
        String[] weekDays = {"周日","周一","周二","周三","周四","周五","周六"};
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        int i = cal.get(Calendar.DAY_OF_WEEK)-1;
        if(i<0){
            i=0;
        }
        String yesterday = new SimpleDateFormat("yyyy年MM月dd日").format(cal.getTime());
        String w = weekDays[i];
    }

    /**
     *
     * 方法说明：将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)
     *
     * Author：        fsh
     *
     * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)<br>
     * 如Sat May 11 17:24:21 CST 2002 to '2002-05-11 17:24:21'<br>
     * @param time Date 日期<br>
     * @return String   字符串<br>
     *
     */
    public static String dateToString(Date time) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ctime = formatter.format(time);
        return ctime;
    }


    /**
     * 日期减几年
     */
    public static String dateMinusYear(String str) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date dt = sdf.parse(str);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.YEAR, -1);// 日期减1年
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    /**
     * 日期加几年
     */
    public static String dateAddYear(String str) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date dt = sdf.parse(str);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.YEAR, 1);// 日期加1年
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    /**
     * 日期减几月
     */
    public static String dateMinusMonth(String str) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date dt = sdf.parse(str);//将字符串生成Date
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);//使用给定的 Date 设置此 Calendar 的时间。
        rightNow.add(Calendar.MONTH, -1);// 日期减1个月
        Date dt1 = rightNow.getTime();//返回一个表示此 Calendar 时间值的 Date 对象。
        String reStr = sdf.format(dt1);//将给定的 Date 格式化为日期/时间字符串，并将结果添加到给定的 StringBuffer。
        return reStr;
    }

    /**
     * 日期加几月
     */
    public static String dateAddMonth(String str) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date dt = sdf.parse(str);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, 1);// 日期加3个月
        // rightNow.add(Calendar.DAY_OF_YEAR,10);//日期加10天
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    /**
     * 获取当前年月的第一个月的str
     * @param str
     *   201505
     * @return 201501
     * @throws Exception
     */
    public static String dateOneMonth(String str) {

        str = str.substring(0, str.length() - 2);
        str = str + "01";
        return str;
    }

    /**
     * 判断dateStr是否在start和end中间，start和end都可以为null long形格式
     *
     * @author fsh
     * @param dateStr
     * @param start
     * @param end
     * @return
     */
    public static boolean checkDateV(String dateStr, String start, String end) {
        boolean isDateRight = false;
        long date = -1;
        long fromDate = -1;
        long toDate = -1;

        date = java.lang.Long.parseLong(dateStr);

        if ((start == null) && (end == null)) {
            isDateRight = true;
        } else if ((start == null) && (end != null)) {
            try {
                toDate = java.lang.Long.parseLong(end);
            } catch (NumberFormatException nfe) {
                LOG.error(nfe, nfe);
            }
            if (date <= toDate) {
                isDateRight = true;
            }
        } else if ((start != null) && (end == null)) {
            try {
                fromDate = java.lang.Long.parseLong(start);
            } catch (NumberFormatException nfe) {
                LOG.error(nfe, nfe);
            }

            if (date >= fromDate) {
                isDateRight = true;
            }
        } else if ((start != null) && (end != null)) {
            try {
                toDate = java.lang.Long.parseLong(end);
                fromDate = java.lang.Long.parseLong(start);
            } catch (NumberFormatException nfe) {
                LOG.error(nfe, nfe);
            }

            if ((date <= toDate) && (date >= fromDate)) {
                isDateRight = true;
            }
        }
        return isDateRight;
    }

    /**
     * 判断时间是否是本年、本月、本日
     * @param date
     * @param pattern
     * @return
     */
    public static boolean isThisYear(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String param = sdf.format(date);//参数时间
        String now = sdf.format(new Date());//当前时间
        if (param.equals(now)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // System.out.println(isThisYear(new Date(2019,8,21),"yyyy"));
        //System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));


//        System.out.println(getMonthDiff("201804", "201804", PATTERN_STANDARD06W));
        //每月
        //System.out.println(getRcvDate("01", "01", "2017-02-03", 4));
        //System.out.println(getRcvDate("01", "02", "2017-02-03", 4));
        //System.out.println(getRcvDate("01", "03", "2017-02-03", 4));
        //System.out.println(getRcvDate("01", "04", "2017-02-03", 4));

        //System.out.println(getRcvDate("01", "01", getPeroidDate("01", "2017-04-10", "2017-04-30"), 4));
        //System.out.println(getRcvDate("01", "02", getPeroidDate("02", "2017-04-10", "2017-04-30"), 4));
        //System.out.println(getRcvDate("01", "03", getPeroidDate("03", "2017-04-10", "2017-04-30"), 4));
        //System.out.println(getRcvDate("01", "04", getPeroidDate("04", "2017-04-10", "2017-04-30"), 4));

        //双月
        //System.out.println(getRcvDate("02", "01", "2017-04-10", 4));
        //System.out.println(getRcvDate("02", "02", "2017-04-10", 4));
        //System.out.println(getRcvDate("02", "03", "2017-04-10", 4));
        //System.out.println(getRcvDate("02", "04", "2017-04-10", 4));

        //System.out.println(getRcvDate("02", "01", getPeroidDate("01", "2017-03-10", "2017-03-31"), 4));
        //System.out.println(getRcvDate("02", "02", getPeroidDate("02", "2017-03-10", "2017-03-31"), 4));
        //System.out.println(getRcvDate("02", "03", getPeroidDate("03", "2017-03-10", "2017-03-31"), 4));
        //System.out.println(getRcvDate("02", "04", getPeroidDate("04", "2017-03-10", "2017-03-31"), 4));

        //季度
        //System.out.println(getRcvDate("03", "01", "2017-07-03", 4));
        //System.out.println(getRcvDate("03", "02", "2017-07-03", 4));
        //System.out.println(getRcvDate("03", "03", "2017-07-03", 4));
        //System.out.println(getRcvDate("03", "04", "2017-07-03", 4));

        //System.out.println(getRcvDate("03", "01", getPeroidDate("01", "2017-04-10", "2017-04-30"), 4));
        //System.out.println(getRcvDate("03", "02", getPeroidDate("02", "2017-04-10", "2017-04-30"), 4));
        //System.out.println(getRcvDate("03", "03", getPeroidDate("03", "2017-04-10", "2017-04-30"), 4));
        //System.out.println(getRcvDate("03", "04", getPeroidDate("04", "2017-04-10", "2017-04-30"), 4));

        //半年
        //System.out.println(getRcvDate("04", "01", "2017-06-03", 4));
        //System.out.println(getRcvDate("04", "02", "2017-06-03", 4));
        //System.out.println(getRcvDate("04", "03", "2017-06-03", 4));
        //System.out.println(getRcvDate("04", "04", "2017-06-03", 4));

        //System.out.println(getRcvDate("04", "01", getPeroidDate("01", "2017-07-10", "2017-07-31"), 4));
        //System.out.println(getRcvDate("04", "02", getPeroidDate("02", "2017-07-10", "2017-07-31"), 4));
        //System.out.println(getRcvDate("04", "03", getPeroidDate("03", "2017-07-10", "2017-07-31"), 4));
        //System.out.println(getRcvDate("04", "04", getPeroidDate("04", "2017-07-10", "2017-07-31"), 4));

        //一年
        //System.out.println(getRcvDate("05", "01", "2017-02-03", 4));
        //System.out.println(getRcvDate("05", "02", "2017-02-03", 4));
        //System.out.println(getRcvDate("05", "03", "2017-02-03", 4));
        //System.out.println(getRcvDate("05", "04", "2017-02-03", 4));

        //System.out.println(getRcvDate("05", "01", getPeroidDate("01", "2017-04-10", "2017-04-30"), 4));
        //System.out.println(getRcvDate("05", "02", getPeroidDate("02", "2017-04-10", "2017-04-30"), 4));
        //System.out.println(getRcvDate("05", "03", getPeroidDate("03", "2017-04-10", "2017-04-30"), 4));
        //System.out.println(getRcvDate("05", "04", getPeroidDate("04", "2017-04-10", "2017-04-30"), 4));

        //System.err.println(SDateTime.getFirstDayOfMonth(2017, 1, SDateTime.PATTERN_STANDARD10H));

        //获取昨天的日期
//        Date date = DateUtils.addDays(new Date(),-1);
//        //获取当前日期的前三年
//        Date dateyears = DateUtils.addYears(new Date(), -3);
//        //获取输入日期的前三年
//        Date dateyears1 = DateUtils.addYears(stringToDate("2015", "yyyy"), -3);

        //年
        //System.out.println(DateUtil.dateToString(DateUtil.getCurrentYearStartTime(),CommonConstant.DATA_FORMAT_YM_J));
        //System.out.println(DateUtil.getDateMonthAdd(DateUtil.dateToString(DateUtil.getCurrentMonthStartTime(),PATTERN_STANDARD10H),-1,CommonConstant.DATA_FORMAT_YM_J));
        //获取本年第一个月
        //System.out.println(dateToString(DateUtil.getCurrentYearStartTime(),"yyyyMM"));
        //获取本年最后一个月
        //System.out.println(dateToString(DateUtil.getCurrentYearEndTime(),"yyyyMM"));

        //月
        //获取当前月的第一天
        //System.out.println(dateToString(DateUtil.getCurrentMonthStartTime(),"yyyyMMdd"));
        //System.out.println(DateUtil.dateToString(DateUtil.getCurrentMonthStartTime(),PATTERN_STANDARD08W));
        //第一种
        //System.out.println(DateUtil.getDateAdd(DateUtil.dateToString(new Date(),PATTERN_STANDARD10H), -1, PATTERN_STANDARD08W));
        //第二种
        //System.out.println(DateUtil.dateToString(date,PATTERN_STANDARD08W));
        //获取当前月前一个月
        //System.out.println(getDateMonthAdd(dateToString(DateUtil.getCurrentMonthStartTime(),"yyyy-MM-dd"),-1,"yyyyMM"));
        //获取当前月前一个月第一天
        //System.out.println(getDateMonthAdd(dateToString(DateUtil.getCurrentMonthStartTime(),"yyyy-MM-dd"),-1,"yyyyMMdd"));

        //日
        //获取当前日期的前一天
        //第一种
        //System.out.println(getDateAdd(dateToString(DateUtil.getCurrentDayStartTime(),"yyyy-MM-dd"), -1, "yyyyMMdd"));
        //第二种
        //System.out.println(dateToString(date,"yyyyMMdd"));

        //周
        //通过当前日期前一天获取本周一（第一天）
        //System.out.println(dateToString(DateUtil.getNowWeekMonday(date),PATTERN_STANDARD08W));
        //通过当前日期前一天获取上周一（第一天）
        //System.out.println(dateToString(DateUtil.getLastWeekMonday(date),"yyyyMMdd"));
        //通过当前日期前一天获取上周日（最后一天）
        //System.out.println(dateToString(DateUtil.getLastWeekSunday(date),"yyyyMMdd"));
        //System.out.println(DateUtil.dateToString(date,PATTERN_STANDARD06W));

        //System.out.println(DateUtil.dateToString(new Date(),PATTERN_STANDARD06W));

        //当前时间
        //System.out.println(dateToString(DateUtil.getCurrentDayStartTime(),"yyyy-MM-dd"));
        //System.out.println(dateToString(new Date(),"yyyy-MM-dd"));
//
//        System.out.println(dateToString(getCurrentYearStartTime(),PATTERN_STANDARD06W));
//        System.out.println(dateToString(getCurrentMonthStartTime(),PATTERN_STANDARD06W));

    }

}
