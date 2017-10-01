package com.date;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;


import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/26
 * Time: 19:43  .
 */
public class DateTest {
    public static int compareToday(Date oneday) {
        DateTime today = new DateTime().withMillisOfDay(0);
        DateTime thatDay = new DateTime(oneday).withMillisOfDay(0);
        Period p = new Period(today, thatDay, PeriodType.days());
        int days = p.getDays();
        if (days > 0) return 1;
        else if (days == 0) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        int result = DateTest.compareToday(new Date());
        System.out.println(result);
    }
}
