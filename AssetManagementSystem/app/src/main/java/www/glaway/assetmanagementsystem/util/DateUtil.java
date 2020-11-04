package www.glaway.assetmanagementsystem.util;

import com.blankj.utilcode.util.TimeUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String DateFormat = "yyyy-MM-dd";
    public static final String DateFormatTime = "yyyy-MM-dd HH:mm:ss";


    public static String dateToString1(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }

    public static String dateToString2(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    /**
     * 格式化时间为String
     *
     * @param date
     * @param patter
     * @return
     */
    public static String dataToString(Date date, String patter) {
        if (date == null) return "";
        return TimeUtils.date2String(date, patter);
    }
    /**
     * 获取当年的第一天
     */
    public static Date getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }
        /**
          * 获取当年的最后一天
          */
     public static Date getCurrYearLast(){
        Calendar currCal=Calendar.getInstance();  
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }
    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }
    /**
      * 获取某年最后一天日期
      * @param year 年份
      * @return Date
      */
      public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }
    /**
     * 获取年
     *
     * @return
     */
    public static int getYear() {
        Calendar cd = Calendar.getInstance();
        return cd.get(Calendar.YEAR);
    }

    /**
     * 获取月
     *
     * @return
     */
    public static int getMonth() {
        Calendar cd = Calendar.getInstance();
        return cd.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日
     *
     * @return
     */
    public static int getDay() {
        Calendar cd = Calendar.getInstance();
        return cd.get(Calendar.DATE);
    }

    /**
     * 获取时
     *
     * @return
     */
    public static int getHour() {
        Calendar cd = Calendar.getInstance();
        return cd.get(Calendar.HOUR);
    }

    /**
     * 获取分
     *
     * @return
     */
    public static int getMinute() {
        Calendar cd = Calendar.getInstance();
        return cd.get(Calendar.MINUTE);
    }
}
