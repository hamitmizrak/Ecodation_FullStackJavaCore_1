package com.hamitmizrak.week_2;

import java.util.Calendar;
import java.util.Date;

public class _11_2_Calendar {
    public static void main(String[] args) {
        // Calendar Java 1.1 sürümüyle
        // GregorianCalendar
        // Aylar: 0 saymaya başlar
        Calendar cal = Calendar.getInstance(); // bugünün tarihi
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        System.out.println("Bugün: "+year +"/"+month+"/"+ day+" "+hour+":"+minute+":"+second);

    }
}