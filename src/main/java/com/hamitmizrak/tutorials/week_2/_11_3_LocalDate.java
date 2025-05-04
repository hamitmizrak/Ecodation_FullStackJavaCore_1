package com.hamitmizrak.tutorials.week_2;

import java.time.LocalDate;
import java.util.Calendar;

public class _11_3_LocalDate {
    public static void main(String[] args) {
        // LocalDate Java 8 sürümüyle
        // LocalDate : java.time
        // Sadece Tarih: yıl,ay,gün
        // Tercihi: Basit ve güvenli bir kullanım
        LocalDate today = LocalDate.now(); // bugünü tarihi
        System.out.println("Bugün: "+today);

        LocalDate specialDay = LocalDate.of(2025,1,27);
        System.out.println("Belirli tarihi:"+specialDay);

    }
}