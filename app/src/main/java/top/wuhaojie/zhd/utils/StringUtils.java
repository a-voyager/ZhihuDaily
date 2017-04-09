package top.wuhaojie.zhd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/02/19 13:28
 * Version: 1.0
 */

public class StringUtils {

    private StringUtils() {
    }


    public static String bigNumber(int number) {
        if (number < 0) return "0";
        if (number < 1000) return String.valueOf(number);
        if (number > 999 * 1000) return "999K";
        double v = number / 1000.0;
        String raw = String.valueOf(v);
        if (raw.length() <= 3) return raw + "K";
        String substring = raw.substring(0, 3);
        if (substring.endsWith(".")) {
            substring = substring.substring(0, 2);
        }
        return substring + "K";
    }


    public static String dateString(Date date) {
        if (date == null) throw new NullPointerException("date == null");
        return Singleton.DATE_NUMBER_FORMAT.format(date);
    }


    /**
     * 获取第 n 天前的日期简写字符串
     *
     * @param ago 第 n 天前
     * @return 简写字符串 如: 170219
     */
    public static String dateString(int ago) {
        long offTimeMillis = System.currentTimeMillis() - (long) ago * 24 * 60 * 60 * 1000;
        Singleton.DATE.setTime(offTimeMillis);
        return dateString(Singleton.DATE);
    }


    public static String str2DateWeek(String src) throws ParseException {
        if (src == null || "".equals(src)) throw new NullPointerException("src == null");
        Date date = Singleton.DATE_NUMBER_FORMAT.parse(src);
        return Singleton.DATE_WEEK_FORMAT.format(date);
    }


    public static String dateTimeString(long time) {
        if (time <= 0) throw new IllegalArgumentException();
        Singleton.DATE.setTime(time);
        return Singleton.DATE_TIME_FORMAT.format(Singleton.DATE);
    }

    private static class Singleton {
        static SimpleDateFormat DATE_NUMBER_FORMAT = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        static SimpleDateFormat DATE_WEEK_FORMAT = new SimpleDateFormat("MM月dd日 E", Locale.CHINA);
        static SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA);
        static Date DATE = new Date();
    }

}
