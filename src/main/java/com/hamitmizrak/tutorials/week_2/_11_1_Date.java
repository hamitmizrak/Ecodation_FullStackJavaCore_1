package com.hamitmizrak.tutorials.week_2;

import java.util.Date;

public class _11_1_Date {
    public static void main(String[] args) {
        // Date/Calendar
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getDate());
        System.out.println(date.getDay());
        System.out.println(date.getHours());
        System.out.println(date.getMinutes());
        System.out.println(date.getSeconds());

        Date date1 = new Date(System.currentTimeMillis());
        System.out.println(date1);

        System.out.println("\n"+date.getHours());
        date.setHours(15);
        System.out.println(date.getHours());


        System.out.println("///////////");
        // date: yıl: +1900  -1900
        int specialYear= date.getYear()+1900;
        System.out.println(specialYear);
    }
}