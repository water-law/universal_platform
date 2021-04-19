package com.weitu.mpsplatform.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


/**
 * 常见时间段格式计算(支付宝生活号、微信朋友圈等发布时间格式)
 * 
 *  例如：
 *  在同一年的显示规则：
 *      不到1分钟，显示：1分钟前，英文：1 minute ago
 *      不到1小时，显示：N分钟前，英文：1 minute ago N minute ago
 *      今天(12h)，显示：下午1:00，英文：1:00 PM
 *      今天(24h)，显示：13:00，13:00
 *      昨天(12h)，显示：昨天 下午1:00，英文：Yesterday 1:00 PM
 *      昨天(24h)，显示：昨天 13:00，英文：Yesterday 13:00
 *      更早(12h)，显示：04-28 下午1:00，英文：04-28 1:00 PM
 *      更早(24h)，显示：04-28 13:00，英文：04-28 13:00
 *  不在同一年的显示规则：
 *      跨年(12h)，显示：2014-12-30 下午1:00， 英文：2014-12-30 1:00 PM
 *      跨年(24h)，显示：2014-12-30 13:00， 英文：2014-12-30 13:00
 *      未来时间，显示：1分钟前，英文：1 minute ago
 * 
 * @author fansenhua
 */
public class BaseHomeIdxDateTools {
    
    private static final Logger LOG = LoggerFactory.getLogger(BaseHomeIdxDateTools.class);
    
    /**
     * 首页时间段计算
     * 1、当传入时间与当前时间对比小于1时，显示1分钟。
     * 2、当传入时间与当前时间对比小于60分钟时，显示N分钟。
     * 3、当传入时间与当前时间对比大于N个小时小于1天时，则显示具体时间。例如：下午1:00 或者 13:00
     * 4、当传入时间与当前时间对比等于1天时，则显示具体时间。例如：昨天 下午1:00 或者 昨天 13:00
     * 5、当传入时间与当前时间对比大于1<365天时，则显示具体时间。例如：04-28 下午1:00 或者 04-28 13:00
     * 6、当传入时间与当前时间对比大于等于1年时，则显示具体时间。例如：2014-12-30 下午1:00 或者 2014-12-30 13:00
     * 
     * @param convertDate 传入时间
     * @return
     */
    public static String timeLogic(Date convertDate) {
        if (convertDate == null) {
            LOG.error("入参为空！");
            return null;
        }
        return timeLogics(convertDate);
    }
    
    @SuppressWarnings("deprecation")
    private static String timeLogics(Date convertDate) {
        StringBuilder commonTimeCale = new StringBuilder();
        // 按分钟计算，为了保证计算方便，将时间进行统一。
        Date sysDate = new Date();
        String sysTime = DateTimeTools.format(sysDate, SDateTime.PATTERN_STANDARD19H);
        sysDate = DateTimeTools.parseDate(sysTime, SDateTime.PATTERN_STANDARD19H);
        String inputTime = DateTimeTools.format(convertDate, SDateTime.PATTERN_STANDARD19H);
        convertDate = DateTimeTools.parseDate(inputTime, SDateTime.PATTERN_STANDARD19H);

        // 分钟差
        double minutesCalu = DateTimeTools.timeCalculateMinutes(convertDate, sysDate);
        // 小时差
        double hoursCalu = DateTimeTools.timeCalculateHour(convertDate, sysDate);
        int daysCal = sysDate.getDate() - convertDate.getDate();
        int years = sysDate.getYear() - convertDate.getYear();
        int months = sysDate.getMonth() - convertDate.getMonth();
        // 传入时间的上下午标志。
        String apFlag = DateTimeTools.format(convertDate, "a");
        // 不到1分钟
        if (minutesCalu < 1) {
            commonTimeCale.append(SDateTime.FIRST_MINUTES_BEFORE);
        } 
        // 不到1小时
        else if (minutesCalu < 60 && hoursCalu < 1) {
            commonTimeCale.append((int) minutesCalu + SDateTime.TIME_MINUTES_BEFORE);
        } else {
            // 按照12、24小时制区分
            // 上午
            if (apFlag.equals(SDateTime.TIME_AM)) {
                commonTimeCale = setTwelfthTime(convertDate, years, months, daysCal, hoursCalu, apFlag);
            } else {
                commonTimeCale = setTwoFourTime(convertDate, years, months, daysCal, hoursCalu, apFlag);
            }
        }
        String result = commonTimeCale.toString();
        return result;
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
    public static StringBuilder setTwelfthTime(Date busiDate, int years, int months, int daysCalu, double hoursCalu, String apFlag) {
        StringBuilder commonTimeCale = new StringBuilder();
        String nowTime = "";
        // 12小时制,格式化：hh:mm
        nowTime = DateTimeTools.format(busiDate, SDateTime.PATTERN_12_STANDARD05H);
        String convertDate = DateTimeTools.format(busiDate,"HH");
        if(convertDate.contains("00")){
            // 格式化：HH:mm
            nowTime = DateTimeTools.format(busiDate, SDateTime.PATTERN_24_STANDARD05H);
        }
        // 大于1小时,并且小于1天
        if (hoursCalu >= 1 && daysCalu < 1 && months < 1 && years < 1) {
            // 上午
            if (apFlag.indexOf(SDateTime.TIME_AM) != -1) {
                commonTimeCale.append(SDateTime.TIME_AM + nowTime);
            } 
            // 下午
            else {
                commonTimeCale.append(SDateTime.TIME_PM + nowTime);
            }
        } 
        // 相差1天，昨天时间
        else if (daysCalu == 1 && months < 1 && years < 1) {
            // 上午
            if (apFlag.indexOf(SDateTime.TIME_AM) != -1) {
                commonTimeCale.append(SDateTime.YESTERDAY + " " + SDateTime.TIME_AM + nowTime);
            } 
            // 下午
            else {
                commonTimeCale.append(SDateTime.YESTERDAY + " " + SDateTime.TIME_PM + nowTime);
            }
        } 
        // 月份，大于1天时间，并且小于1年内的时间，则显示更早时间
        else if ((daysCalu >= 1 || months >= 1) && years < 1) {
            String nowMounth = DateTimeTools.format(busiDate, SDateTime.MOUTHS_PATTERN);
            // 上午
            if (apFlag.indexOf(SDateTime.TIME_AM) != -1) {
                commonTimeCale.append(nowMounth + " " + SDateTime.TIME_AM + nowTime);
            } 
            // 下午
            else {
                commonTimeCale.append(nowMounth + " " + SDateTime.TIME_PM + nowTime);
            }
        } 
        // 跨年
        else if (years >= 1) {
            String yearsCom = DateTimeTools.format(busiDate, SDateTime.PATTERN_STANDARD10H);
            // 上午
            if (apFlag.indexOf(SDateTime.TIME_AM) != -1) {
                commonTimeCale.append(yearsCom + " " + SDateTime.TIME_AM + nowTime);
            } 
            // 下午
            else {
                commonTimeCale.append(yearsCom + " " + SDateTime.TIME_PM + nowTime);
            }
        }
        return commonTimeCale;
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
    public static StringBuilder setTwoFourTime(Date busiDate, int years, int months, int daysCalu, double hoursCalu, String apFlag) {
        //24小时制
        StringBuilder commonTimeCale = new StringBuilder();
        String nowTime = "";
        nowTime = DateTimeTools.format(busiDate, SDateTime.PATTERN_24_STANDARD05H);
        // 大于1小时,并且小于1天
        if (hoursCalu >= 1 && daysCalu < 1 && months < 1 && years < 1) {
            // 上午
            if (apFlag.indexOf(SDateTime.TIME_AM) != -1) {
                commonTimeCale.append(SDateTime.TIME_AM + nowTime);
            } 
            // 下午
            else {
                commonTimeCale.append(nowTime);
            }
        } 
        // 相差1天，昨天时间
        else if (daysCalu == 1 && months < 1 && years < 1) {
            // 上午
            if (apFlag.indexOf(SDateTime.TIME_AM) != -1) {
                commonTimeCale.append(SDateTime.YESTERDAY + " " + SDateTime.TIME_AM + nowTime);
            } 
            // 下午
            else {
                commonTimeCale.append(SDateTime.YESTERDAY + " " + nowTime);
            }
        } 
        // 月份，大于1天时间，并且小于1年内的时间，则显示更早时间
        else if ((daysCalu >= 1 || months >= 1) && years < 1) {
            String nowMounth = DateTimeTools.format(busiDate, SDateTime.MOUTHS_PATTERN);
            // 上午
            if (apFlag.indexOf(SDateTime.TIME_AM) != -1) {
                commonTimeCale.append(nowMounth + " " + SDateTime.TIME_AM + nowTime);
            } 
            // 下午
            else {
                commonTimeCale.append(nowMounth + " " + nowTime);
            }
        } 
        // 跨年
        else if (years >= 1) {
            String yearsCom = DateTimeTools.format(busiDate, SDateTime.PATTERN_STANDARD10H);
            // 上午
            if (apFlag.indexOf(SDateTime.TIME_AM) != -1) {
                commonTimeCale.append(yearsCom + " " + SDateTime.TIME_AM + nowTime);
            } 
            // 下午
            else {
                commonTimeCale.append(yearsCom + " " + nowTime);
            }
        }
        return commonTimeCale;
    }
    
    
    /**
     *  将毫秒时间转换成具体时间格式
     * 
     * @param currentTimeMillis
     * @return
     */
    public static String getDiscountDate(String currentTimeMillis) {
        String time = "";
        if (SString.isBlank(currentTimeMillis)) {
            return time;
        }
        String converTime = SDateTime.getTimeFromMills(currentTimeMillis);
        if (SString.isNotBlank(converTime)) {
            Date convertDate = DateTimeTools.parseDate(converTime, SDateTime.PATTERN_STANDARD19H);
            if (convertDate != null) {
                time = timeLogics(convertDate);
            }
        }
        return time;
    }
    
    
}