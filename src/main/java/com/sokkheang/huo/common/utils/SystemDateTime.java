package com.sokkheang.huo.common.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Sokkheang Huo
 */
public class SystemDateTime {

    /**
     * @Method getCurrentTimeMillis()
     */
    public Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * @Method getDateTime_YYYY_MM_DD_at_Time_With_Local_Zone()
     */
    public String getDateTime_YYYY_MM_DD_at_Time_With_Local_Zone() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    /**
     * @Method getDateTime_DD_MM_YYYY_at_Time_With_Local_Zone()
     */
    public String getDateTime_DD_MM_YYYY_at_Time_With_Local_Zone() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    /**
     * @Method getCurrentDateTime_DD_MM_YYYY()
     */
    public String getCurrentDateTime_DD_MM_YYYY() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);
    }

    /**
     * @Method getCurrentDateTime_YYYY_MM_DD()
     */
    public String getCurrentDateTime_YYYY_MM_DD() {

        /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43*/

        /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal)); //2016/11/16 12:08:43*/

        /*Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(calendar.getTime());*/

        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now)); //2016/11/16 12:08:43*/

        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        System.out.println(dtf.format(localDate)); //2016/11/16*/

        /*Date date = new Date();
        System.out.println(sdf.format(date));

        Calendar cal = Calendar.getInstance();
        System.out.println(sdf.format(cal.getTime()));

        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        LocalDate localDate = LocalDate.now();
        System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));*/

        /*System.out.println(java.time.LocalDate.now());*/

        /*System.out.println(java.time.LocalTime.now());*/

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }

    /**
     * @Method getCurrentDate()
     */
    public String getCurrentDate() {
        LocalDate date = LocalDate.now(); // gets the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }

    /**
     * @Method getCurrentTime()
     */
    public String getCurrentTime() {
        LocalTime time = LocalTime.now(); // gets the current time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }
}
