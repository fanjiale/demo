package com.cares.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static String DATE_FORMAT_YEAR = "yyyy";

    public static String DATE_FORMAT_MONTH = "MM";

    public static String DATE_FORMAT_DAY = "dd";

    public static String DATE_FORMAT_YMD = "yyyyMMdd";

    public static String DATE_FORMAT_SHORT = "yyyy-MM-dd";

    public static String DATE_FORMAT_MONTH_OF_YEAR = "yyyy-MM";

    public static String DATE_FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    public static String DATE_FORMAT_HM = "HH:mm";

    public static String DATE_FORMAT_YMDHMS = "yyyyMMddHHmmss";

    public static String DATE_FORMAT_YYMDHM = "yyyyMMddHHmm";

    public static String DATE_FORMAT_YMDHM = "yyyy-MM-dd HH:mm";

    public static String DATE_FORMAT_MMDD = "MM/dd";

    public static String DATE_FORMAT_SHORT_ = "yyyy/MM/dd";

    public static String DATE_FORMAT_MINIT = "mm";

    public static String DATE_FORMAT_YMDH = "yyyy-MM-dd HH";

    /**
     * 取得日期字符串
     *
     * @param date
     * @param format
     * @return Date: 2012-5-17上午09:58:10
     */
    public static String getDateStr(Date date, String format) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
        return "";
    }

    /**
     * 取得字符串日期
     *
     * @param str
     * @param format Date:2012-5-18 上午09:21:34
     */
    public static Date getStrDate(String str, String format) throws ParseException {
        if (str != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(str);
        }
        return null;
    }


    /**
     * 取得日期的字符串
     *
     * @param dt Date:2012-5-18 上午09:21:34
     */
    public static String getStrShort(Date dt) {
        if (dt != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_SHORT);
            return sdf.format(dt);
        }
        return "";
    }

    /**
     * 取得日期的字符串
     *
     * @param dt Date:2012-5-18 上午09:21:34
     */
    public static String getStrLong(Date dt) {
        if (dt != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_LONG);
            return sdf.format(dt);
        }
        return "";
    }

    /**
     * 取得年
     *
     * @param date
     * @return Date: 2012-5-16下午05:02:18
     */
    public static String getYear(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YEAR);
            return sdf.format(date);
        }
        return "";
    }

    /**
     * 取得月
     *
     * @param date
     * @return Date: 2012-5-16下午05:02:18
     */
    public static String getMonth(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_MONTH);
            return sdf.format(date);
        }
        return "";
    }

    /**
     * 取得日
     *
     * @param date
     * @return Date: 2012-5-16下午05:02:18
     */
    public static String getDay(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DAY);
            return sdf.format(date);
        }
        return "";
    }

    /**
     * 取得当前月第一天
     *
     * @param date
     * @return Date: 2012-5-14下午03:53:37
     */
    public static Date getMonthFirst(Date date) {
        try {
            SimpleDateFormat sdfShort = new SimpleDateFormat(DATE_FORMAT_SHORT);
            SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
            return sdfShort.parse(sdfYear.format(date) + "-" + sdfMonth.format(date) + "-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 取得当前月最后一天
     *
     * @param date
     * @return Date: 2012-5-14下午03:53:57
     */
    public static Date getMonthLast(Date date) {
        try {
            SimpleDateFormat sdfShort = new SimpleDateFormat(DATE_FORMAT_SHORT);
            SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
            int year = Integer.valueOf(sdfYear.format(date));
            int month = Integer.valueOf(sdfMonth.format(date));
            int day = getMonthDays(year, month);
            return sdfShort.parse(year + "-" + month + "-" + day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 取得某月天数
     *
     * @param year
     * @param month
     * @return Date: 2012-5-14下午04:13:41
     */
    public static int getMonthDays(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 格式化日期，将时分秒转化为00:00:00
     *
     * @param date
     * @return Date: 2012-4-17下午02:41:17
     */
    public static Date getDayBegin(Date date) {
        try {
            if (date != null) {
                SimpleDateFormat sdfShort = new SimpleDateFormat(DATE_FORMAT_SHORT);
                SimpleDateFormat sdfLong = new SimpleDateFormat(DATE_FORMAT_LONG);
                return sdfLong.parse(sdfShort.format(date) + " 00:00:00");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 格式化日期，将时分秒转化为23:59:59
     *
     * @param date
     * @return Date: 2012-4-17下午02:41:17
     */
    public static Date getDayEnd(Date date) {
        try {
            if (date != null) {
                SimpleDateFormat sdfShort = new SimpleDateFormat(DATE_FORMAT_SHORT);
                SimpleDateFormat sdfLong = new SimpleDateFormat(DATE_FORMAT_LONG);
                return sdfLong.parse(sdfShort.format(date) + " 23:59:59");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算两个日期相隔的天数，时分秒不在计算范围内
     *
     * @param dt1,dt2
     * @return Date: 2012-6-29上午10:38:32
     * @throws ParseException
     */
    public static int calcTwoDatesDays(Date dt1, Date dt2) {
        Long days = 0l;
        try {
            //只取年月日
            if (dt1 != null && dt2 != null) {
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_SHORT);
                String strDt1 = sdf.format(dt1);
                Date temp1 = sdf.parse(strDt1);
                String strDt2 = sdf.format(dt2);
                Date temp2 = sdf.parse(strDt2);
                days = (temp2.getTime() - temp1.getTime()) / (24 * 60 * 60 * 1000);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days.intValue();
    }

    /**
     * 修改日期
     *
     * @param dt     修改的日期
     * @param field  Calendar类的field，例如：Calendar.DAY_OF_MONTH,Calendar.MONTH
     * @param amount 年月日数
     * @return 修改后的日期
     * Date: 2012-7-2上午10:48:13
     */
    public static Date changeDate(Date dt, int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 获取当前时间的年月日时分秒。
     *
     * @return
     */
    public static String currentTimeStr() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentTime = (format.format(new Date()));
        return currentTime;
    }

    /**
     * TODO 获取当前时间所在周的星期一
     *
     * @param date当前时间
     * @return 所在周的星期一
     * @see Date:2012-8-4 下午12:44:20
     */
    public static Date getMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return getDayBegin(cal.getTime());
    }

    /**
     * TODO 获取当前时间所在周的星期日
     *
     * @param date当前时间
     * @return 所在周的星期日
     * @see Date:2012-8-4 下午12:44:20
     */
    public static Date getSunday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return changeDate(getDayBegin(cal.getTime()), Calendar.DAY_OF_MONTH, 1);
    }

    /**
     * 截取时间格式转换的小时与分钟部分
     *
     * @param date 时间
     * @return 小时与分钟
     */
    public static String getHourAndMinute(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_HM);
        String time = sdf.format(date);
        return time;
    }

    /**
     * 时间格式转换为时间戳
     * patten 格式类型如: yyyy-MM-dd HH:mm:ss 或 mm:ss 等
     */
    public static int getIntTime(String time, String patten) {
        if ("".equals(time) || null == time) {
            return 0;
        } else {
            SimpleDateFormat format = new SimpleDateFormat(patten);
            Date dateS = null;
            try {
                dateS = format.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int intTime = new Long(dateS.getTime() / 1000).intValue();
            return intTime;
        }
    }

    /**
     * @param intTime 将时间戳转换为时间格式[10位]
     */
    public static String getDateTime(int intTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = sdf.format(new Date(intTime * 1000L));
        return dateTime;
    }

    /**
     * @param intTime 将时间戳转换为时间格式[13位]
     */
    public static String getDateTime13(long intTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = sdf.format(new Date(intTime));
        return dateTime;
    }

    /**
     * 返回当前的时间
     * yyyy-MM-dd HH:mm:ss
     */
    public static String nowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 返回当前的日期
     * yyyy-MM-dd
     */
    public static String nowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    public static String getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String today = getDateStr(calendar.getTime(), DATE_FORMAT_SHORT);
        return today;
    }

    /**
     * 返回当前的时间戳
     */
    public static int getNowTimestamp() {
        return DateUtil.getIntTime(DateUtil.nowTime(), "yyyy-MM-dd HH:mm:ss");
    }

    public static void main(String arg[]) {
        System.out.println((new Date()).before(changeDate(getDayBegin(new Date()), Calendar.DAY_OF_MONTH, 1)));
    }
}
