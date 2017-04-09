package top.wuhaojie.zhd;

import org.junit.Test;

import java.util.Date;

import top.wuhaojie.zhd.utils.StringUtils;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/02/19 13:38
 * Version: 1.0
 */

public class StringUtilsTest {
    @Test
    public void dateTimeString() throws Exception {
        String s = StringUtils.dateTimeString(1491706621);
        System.out.println(s);
    }

    @Test
    public void str2DateWeek() throws Exception {
        String s = StringUtils.str2DateWeek("20170215");
        System.out.println(s);
    }

    @Test
    public void dateString() throws Exception {
        System.out.println(StringUtils.dateString(0));
        System.out.println(StringUtils.dateString(-1));
        System.out.println(StringUtils.dateString(1));
        System.out.println(StringUtils.dateString(10));
        System.out.println(StringUtils.dateString(100));
        System.out.println(StringUtils.dateString(-100));
    }

    @Test
    public void getDateString() throws Exception {
        Date date = new Date();
        date.setTime(System.currentTimeMillis() - 1 * 24 * 60 * 60 * 1000);
        String s = StringUtils.dateString(date);
        System.out.println(s);
    }

    @Test
    public void bigNumber() {
        System.out.println(StringUtils.bigNumber(0));
        System.out.println(StringUtils.bigNumber(10));
        System.out.println(StringUtils.bigNumber(100));
        System.out.println(StringUtils.bigNumber(999));
        System.out.println(StringUtils.bigNumber(1000));
        System.out.println(StringUtils.bigNumber(675));
        System.out.println(StringUtils.bigNumber(6765));
        System.out.println(StringUtils.bigNumber(1111));
        System.out.println(StringUtils.bigNumber(56787));
        System.out.println(StringUtils.bigNumber(11111));
        System.out.println(StringUtils.bigNumber(896779));
        System.out.println(StringUtils.bigNumber(999999));
        System.out.println(StringUtils.bigNumber(9999999));
        System.out.println(StringUtils.bigNumber(99999999));
    }


}
