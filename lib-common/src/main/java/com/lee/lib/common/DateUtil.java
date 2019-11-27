package com.lee.lib.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author lihaiqiang
 * @since 2019/11/27
 */
public class DateUtil {

    private static final String DATE = "yyyy-MM-dd";
    private static final String TIME = "HH:mm:ss";
    private static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static String format(String pattern, Date date) {
        return new SimpleDateFormat(pattern, Locale.CHINA).format(date);
    }

    public static String format(String pattern, long millis) {
        Date date = new Date();
        date.setTime(millis);
        return new SimpleDateFormat(pattern, Locale.CHINA).format(date);
    }

    public static String formatDate() {
        return format(DATE, new Date());
    }

    public static String formatDate(Date date) {
        return format(DATE, date);
    }

    public static String formatDate(long millis) {
        return format(DATE, millis);
    }

    public static String formatTime() {
        return format(TIME, new Date());
    }

    public static String formatTime(Date date) {
        return format(TIME, date);
    }

    public static String formatTime(long millis) {
        return format(TIME, millis);
    }

    public static String formatDateTime() {
        return format(DATE_TIME, new Date());
    }

    public static String formatDateTime(Date date) {
        return format(DATE_TIME, date);
    }

    public static String formatDateTime(long millis) {
        return format(DATE_TIME, millis);
    }

    public static Date parse(String pattern, String source) throws ParseException {
        return new SimpleDateFormat(pattern, Locale.CHINA).parse(source);
    }

    public static Date parseDate(String dateStr) throws ParseException {
        return parse(DATE, dateStr);
    }

    public static Date parseTime(String timeStr) throws ParseException {
        return parse(TIME, timeStr);
    }

    public static Date parseDateTime(String dateTimeStr) throws ParseException {
        return parse(DATE_TIME, dateTimeStr);
    }

    public static void main(String[] args) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.HOUR, 1);

        System.out.println("formatDate: " + formatDate());
        System.out.println("formatDate: " + formatDate(calendar.getTime()));
        System.out.println("formatDate: " + formatDate(calendar.getTime().getTime()));

        System.out.println("formatTime: " + formatTime());
        System.out.println("formatTime: " + formatTime(calendar.getTime()));
        System.out.println("formatTime: " + formatTime(calendar.getTime().getTime()));

        System.out.println("formatDateTime: " + formatDateTime());
        System.out.println("formatDateTime: " + formatDateTime(calendar.getTime()));
        System.out.println("formatDateTime: " + formatDateTime(calendar.getTime().getTime()));

        System.out.println("parseDate: " + parseDate("2019-11-27"));
        System.out.println("parseTime: " + parseTime("10:18:32"));
        System.out.println("parseDateTime: " + parseDateTime("2019-11-27 10:18:32"));
    }
}
