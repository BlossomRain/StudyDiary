package com.timeTest;

import org.hamcrest.core.IsNot;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @Auther: lxz
 * @Date: 2020/3/19 0019
 * @Description:测试时间相关的类
 */
public class TimeTest {
    @Test   //Date  DateFormat Calendar
    public void testDate() {

        long l = System.currentTimeMillis();
        Date date = new Date(l);
        System.out.println(date);

        java.sql.Date date_sql = new java.sql.Date(date.getTime());

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        format.format(date);
        try {
            Date parse = format.parse("1234.5.6");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar instance = Calendar.getInstance();
        instance.set(2020,1,1);
        System.out.println(instance.getTime());
    }

    @Test
    public void testTime(){
        LocalDate now = LocalDate.now();
        LocalTime time = LocalTime.of(21, 21);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String format = now.format(formatter);
        System.out.println(format);


    }
}
